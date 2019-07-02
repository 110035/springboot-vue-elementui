package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
public class userController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/add")
    @ResponseBody
    public void testAdd(@RequestBody Map map) {
        String add_username = map.get("add_username").toString();
        String add_password = map.get("add_password").toString();
        userService.addNewUser(add_username, add_password);
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<user> testFindUserList(@RequestBody Map map) {
        Integer id;
        try{
            id = Integer.valueOf(map.get("search_id").toString());

        } catch (NumberFormatException e){
            id = 0;
        }

        //int search_id = (int)searchId;
        String search_username = map.get("search_username").toString();

        if (search_username == "") {
            search_username = null;
        }
        List<user> userList = userService.findUsersByCondition(id, search_username);
        return userList;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public user testFindUser(@RequestBody Map map) {
        int currentId = (int) map.get("currentId");
        user user = userService.findUserById(currentId);
        return user;
    }

    @RequestMapping("/update")
    @ResponseBody
    public void testUpdate(@RequestBody Map map) {
        int id = (int) map.get("upd_id");
        String username = map.get("upd_username").toString();
        String password = map.get("upd_password").toString();
        userService.update(id, username, password);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void testDelete(@RequestBody Map map) {
        int id = (int) map.get("deleteId");
        userService.delete(id);
    }
}
