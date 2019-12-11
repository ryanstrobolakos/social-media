package com.techtalentsouth.SocialMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techtalentsouth.SocialMedia.model.Tweet;
import com.techtalentsouth.SocialMedia.model.User;
import com.techtalentsouth.SocialMedia.service.TweetService;
import com.techtalentsouth.SocialMedia.service.UserService;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private TweetService tweetService;
    
    @GetMapping(value = "/users/{username}")
    public String getUser(@PathVariable(value="username") String username, Model model) {	
    	    User user = userService.findByUsername(username);
    	    List<Tweet> tweets = tweetService.findAllByUser(user);
    	    model.addAttribute("tweetList", tweets);
    	    model.addAttribute("user", user);
    	    return "user";
    }

}
