package modules.basic.controller;

import modules.basic.entity.Admin;
import modules.basic.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yang on 2017/2/19.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //验证账号密码  根据角色跳转到对应页面
    @RequestMapping(value="index")
    public ModelAndView validate(Admin admin, HttpSession httpSession){
        String view;
        ModelAndView mv =new ModelAndView();
        mv.addObject("admin",admin);//用于回显
        Admin a = adminService.validate(admin.getAccount());
        if(a==null){
             mv.addObject("message","用户名不存在！");
             view = "basic/adminLogin";
        }else{
            if(a.getPassword().equals(admin.getPassword())){
                httpSession.setAttribute("admin",a);
                view = "basic/index";
            }else{
                mv.addObject("message","密码错误，请重试！");
                view = "basic/adminLogin";
            }
        }
        mv.setViewName(view);
        return mv;
    }



    /*//删除
    @RequestMapping(value="delete" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult delete(String id){
        JsonResult jr ;
        boolean flag = false;
        flag = adminService.delete(id) > 0 ? true : false  ;
        jr = new JsonResult(flag,"");
        return jr;
    }*/


    //跳转到登录页面
    @RequestMapping(value = "login")
    public String toAdminLogin(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "basic/adminLogin";
    }

    //跳转到控制台页面
    @RequestMapping(value = "index1")
    public String toIndex(){
        return "index";
    }
}
