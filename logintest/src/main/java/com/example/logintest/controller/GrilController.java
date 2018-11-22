package com.example.logintest.controller;


import com.example.logintest.domain.Gril;
import com.example.logintest.service.GrilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GrilController {

    private static Logger logger = LoggerFactory.getLogger(GrilController.class);

    @Resource
    private GrilService grilService;

 /*   @RequestMapping("/")
    public String index(){
        return "redirect:/list";
    }*/
    @RequestMapping("/login")
    public String login(/*@RequestParam("loginName") String loginName, @RequestParam("password") String password,*/ HttpServletRequest request, HttpSession session){
       // System.out.println("loginName:"+loginName);
        /*mv.setViewName();*/
        request.setAttribute("book","springboot");
        logger.info("login success");
        return "redirect:/list";
    }
    @RequestMapping("/list")
    public String list(Model model) {
        List<Gril> users=grilService.findAll();
        model.addAttribute("grils", users);
        System.out.println("!!!"+users.toString());
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(Gril user) {
        grilService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Gril user=grilService.findById(id);
        model.addAttribute("gril", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(Gril user) {
        grilService.update(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        grilService.deleteById(id);
        return "redirect:/list";
    }
    @RequestMapping("/find")
    public String find(Model model,Long id,String name) {
       // Gril gril = grilService.findById(id);
        System.out.println("id:"+id+"--"+"name:"+name);
        if (("".equals(id)||id==null)&&("".equals(name))){
            return "redirect:/list";}
        else {
        List<Gril> gril = grilService.findByIdOrName(id,name);
        model.addAttribute("grils", gril);
        System.out.println(
                gril.toString());
        return "user/list";}
    }
    @RequestMapping("/find1")
    public String findByNameLike(Model model,String name) {
        // Gril gril = grilService.findById(id);
        List<Gril> gril = grilService.findByNameLike(name);
        System.out.println("name:"+name);
        model.addAttribute("grils", gril);
        System.out.println(
                gril.toString()
        );
        return "user/list";
    }
}
