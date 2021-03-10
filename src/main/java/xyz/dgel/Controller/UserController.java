package xyz.dgel.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyz.dgel.BLL.UserService;
import xyz.dgel.Common.HttpGetUtil;
import xyz.dgel.Model.EF.StudentEntity;
import xyz.dgel.Model.EF.UserEntity;
import xyz.dgel.Model.WxTestWebInfo;
import xyz.dgel.Model.WxUserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/User",method = {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    public UserService userService;

    private String code = null;
    private String openid = null;
    private String access_token = null;

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

        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if(code == null||openid == null||access_token == null)
            return new ModelAndView("redirect:/User/entry");
        WxUserInfo userInfo = new WxUserInfo();

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
            modelAndView.setViewName("userhomepage");
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

    @RequestMapping("/register")
    public String userRegister(Model model,@ModelAttribute StudentEntity studentEntity) throws Exception{
        System.out.println("用户注册");
        System.out.println(JSON.toJSONString(studentEntity));

        //写入数据库
        try{
            boolean result = userService.addStudent(studentEntity);
            if (result){
                System.out.println("注册成功");
                model.addAttribute("message","注册成功");
            }
            else{
                model.addAttribute("message","注册失败,数据库错误");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            model.addAttribute("message","注册失败");
        }

        return "message";
    }

    @RequestMapping(value = "/getCourseList")
    public ModelAndView getCourseList() throws Exception{

        return null;
    }


    @RequestMapping("/getalluser")
    public void getAllUser() throws Exception{


        String s = userService.getAllUserByClassId().toString();
        System.out.println(s);
    }
}
