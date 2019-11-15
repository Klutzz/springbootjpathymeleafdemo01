package com.offcn.controller;

import com.offcn.dao.UserDao;
import com.offcn.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String findAll(Model model){
        List<User> userList = userDao.findAll();
        model.addAttribute("list", userList);
        return "user/list";
    }

    // 跳转到新增页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd.html";
    }

    // 保存数据
    @PostMapping("/add")
    public String save(User user){
        userDao.save(user);
        // 重定向到列表页面
        return "redirect:/";
    }

    // 跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        User user = userDao.findById(id).get();
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    // 保存修改数据
    @RequestMapping("/update")
    public String update(User user){
        userDao.saveAndFlush(user);
        return "redirect:/";
    }

    // 删除用户数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userDao.deleteById(id);
        return "redirect:/";
    }


}
