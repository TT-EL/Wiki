package xyz.dgel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.dgel.BLL.UserService;
import xyz.dgel.Model.EF.UserEntity;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("/register")
    public String userRegister(Model model, UserEntity userEntity) throws Exception{
        System.out.println("用户注册");
        //写入数据库
        userService.addUser(userEntity);
        System.out.println("注册成功");
        model.addAttribute("message","注册成功");
        return "/WEB-INF/jsp/message.jsp";
    }
}
