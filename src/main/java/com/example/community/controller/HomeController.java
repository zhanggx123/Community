package com.example.community.controller;

import com.example.community.entity.DiscussPost;
import com.example.community.entity.Page;
import com.example.community.entity.User;
import com.example.community.service.DiscussPostService;
import com.example.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZhangGuoxiang
 * @date {2023/11/10} {15:25}
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if (Objects.nonNull(list)){
             discussPosts = list.stream().map(post -> {
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                return map;
            }).collect(Collectors.toList());
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }

}
