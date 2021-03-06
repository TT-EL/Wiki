package xyz.dgel.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyz.dgel.Common.HttpGetUtil;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.UserEntity;
import xyz.dgel.Model.ViewModel.UserGetCourseListView;
import xyz.dgel.Model.ViewModel.UserGetTieListView;
import xyz.dgel.Model.ViewModel.UserRemarkListView;
import xyz.dgel.Model.WxTestWebInfo;
import xyz.dgel.Model.WxUserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/User",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController extends BaseController{


    private String code = null;
    private String openid = null;
    private String access_token = null;

    public void BasicJsonResponse(HttpServletResponse resp,String json) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        writer.write(json);
    }

    //region 登录，注册，身份验证



    //获取Code
    @RequestMapping(value = "/entry")
    public void getWxCode(HttpServletResponse resp, HttpServletRequest req) throws ServletException,IOException{
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String redirect_url = URLEncoder.encode("http://dgel.natapp1.cc/User/getOpenId","UTF-8");

        StringBuffer url = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WxTestWebInfo.appid+"&redirect_uri="+redirect_url+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        resp.sendRedirect(url.toString());
    }

    @RequestMapping(value = "/getOpenId")
    public void getOpenId(HttpServletResponse resp, HttpServletRequest req) throws ServletException,IOException{
        resp.setContentType("text/html");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        code = req.getParameter("code");//获取code

        Map params = new HashMap();
        params.put("secret", WxTestWebInfo.appsecret);
        params.put("appid", WxTestWebInfo.appid);
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        String result = HttpGetUtil.httpRequestToString(
                "https://api.weixin.qq.com/sns/oauth2/access_token", params);
        JSONObject jsonObject = JSONObject.parseObject(result);

        openid = jsonObject.get("openid").toString();
        access_token = jsonObject.get("access_token").toString();
        System.out.println("得到的openid为:"+openid);
        System.out.println("access_tokn:"+access_token);

        StringBuffer url = new StringBuffer("http://dgel.natapp1.cc/User/home");
        resp.sendRedirect(url.toString());

    }

    @RequestMapping("/home")
    public ModelAndView homePage(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException, Exception{
        WxUserInfo userInfo = new WxUserInfo();

        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if(code == null||openid == null||access_token == null)
            return new ModelAndView("redirect:/User/entry");


        Map params = new HashMap();
        params.put("access_token",access_token);
        params.put("openid",openid);
        params.put("lang","zh_CN");

        String result = HttpGetUtil.httpRequestToString("https://api.weixin.qq.com/sns/userinfo",params);

        JSONObject jsonObject1 = JSONObject.parseObject(result);
        System.out.println(jsonObject1.toJSONString());
        userInfo.setOpenId(jsonObject1.getString("openid"));
        userInfo.setNickName(jsonObject1.getString("nickname"));
        userInfo.setHeadImage(jsonObject1.getString("headimgurl"));
        userInfo.setUnionId(jsonObject1.getString("unionid"));
        //获取登录授权之后根据OpenId查询数据库

        boolean exist = userService.getregisterwxinfo(userInfo.getOpenId());

        ModelAndView modelAndView = new ModelAndView();

        //已注册，跳转到课程列表
        if(exist){
            UserEntity userEntity = userService.getOneUserByWXId(userInfo.getOpenId());
            if (userEntity.getPower() == (byte)0){
                modelAndView.setViewName("userhomepage");
                modelAndView.addObject("student_id",userEntity.getUserId());
            }
            else{

                modelAndView.setViewName("questionregion");
            }
            return modelAndView;
        }

        //未注册，跳转到绑定学籍信息
        modelAndView.setViewName("register");
        modelAndView.addObject("wx_id",userInfo.getOpenId());
        modelAndView.addObject("wx_name",userInfo.getNickName());
        modelAndView.addObject("wx_image",userInfo.getHeadImage());

        System.out.println("未注册，跳转到注册页面");
        //return "register";
        return modelAndView;
    }


    @RequestMapping("/getRegisView")
    public ModelAndView getRegisView(){
        ModelAndView m = new ModelAndView();
        m.setViewName("register");
        return m;
    }

    @Transactional
    @RequestMapping("/register")
    public void userRegister(HttpServletResponse response,@ModelAttribute StudentEntity studentEntity) throws Exception{
        System.out.println("用户注册");
        System.out.println(JSON.toJSONString(studentEntity));
        JSONObject jsonObject = new JSONObject();

        //写入数据库
        try{
            boolean result = userService.addStudent(studentEntity);
            if (result){
                System.out.println("注册成功");
                //model.addAttribute("message","注册成功");
                jsonObject.put("code",1);
                jsonObject.put("student_id",studentEntity.getStudentId());


            }
            else{
                //model.addAttribute("message","注册失败,数据库错误");
                jsonObject.put("code",0);
            }
        }catch (Exception e){

            //model.addAttribute("message","注册失败");
            jsonObject.put("code",0);
        }
        BasicJsonResponse(response,jsonObject.toJSONString());
        //return "message";
    }

    //endregion

    @RequestMapping(value = "/getTiePage",method =RequestMethod.GET)
    public ModelAndView getTiePage(ModelAndView modelAndView,@Param(value = "cotocl_num")String cotocl_num){

        modelAndView.addObject("cotocl_num",cotocl_num);
        modelAndView.setViewName("questionregion");
        return modelAndView;

    }

    @RequestMapping(value = "/getRemarkPage",method =RequestMethod.GET)
    public ModelAndView getRemarkPage(ModelAndView modelAndView,@Param(value = "tie_id")String tie_id){

        modelAndView.addObject("tie_id",tie_id);
        modelAndView.setViewName("remarkpage");
        return modelAndView;
    }


    //region 获取列表类控制器

    @RequestMapping(value = "/getCourseList",method = RequestMethod.GET)
    public void getCourseList(HttpServletResponse response,@Param(value = "student_id")String student_id) throws Exception{
        List<UserGetCourseListView> list = userService.getcourselist(student_id);
        BasicJsonResponse(response,JSON.toJSONString(list));
    }

    @RequestMapping(value = "getTieList",method = RequestMethod.GET)
    public void getTieList(HttpServletResponse response,@Param(value = "cotocl_num")Integer cotocl_num) throws Exception{
        List<UserGetTieListView> list = userService.gettielist(cotocl_num);
        BasicJsonResponse(response,JSON.toJSONString(list));
    }

    @RequestMapping(value = "getTie",method = RequestMethod.GET)
    public void getTie(HttpServletResponse response,@Param(value = "tie_id")String tie_id) throws Exception{
        UserGetTieListView userGetTieListView = userService.gettie(tie_id);
        BasicJsonResponse(response,JSON.toJSONString(userGetTieListView));
    }

    @RequestMapping(value = "getRemarkList",method = RequestMethod.GET)
    public void getRemarkList(HttpServletResponse response,@Param(value = "tie_id")String tie_id) throws Exception{
        List<UserRemarkListView> list = userService.getremarklist(tie_id);
        BasicJsonResponse(response,JSON.toJSONString(list));
    }

    //endregion




    @RequestMapping("/getalluser")
    public void getAllUser() throws Exception{

        String s = userService.getAllUserByClassId().toString();
        System.out.println(s);
    }
}
