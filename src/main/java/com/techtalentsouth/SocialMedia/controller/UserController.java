package com.techtalentsouth.SocialMedia.controller;

import java.util.HashMap;
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
    	    
    	    User loggedInUser = userService.getLoggedInUser();
    	    List<User> following = loggedInUser.getFollowing();
    	    boolean isFollowing = false;
    	    for (User followedUser : following) {
    	        if (followedUser.getUsername().equals(username)) {
    	            isFollowing = true;
    	        }
    	    }
    	    model.addAttribute("following", isFollowing);
    	    
    	    boolean isSelfPage = loggedInUser.getUsername().equals(username);
    	    model.addAttribute("isSelfPage", isSelfPage);
    	    
    	    return "user";
    }
    
    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        SetTweetCounts(users, model);
        return "users";
    }
    
    private void SetTweetCounts(List<User> users, Model model) {
        HashMap<String,Integer> tweetCounts = new HashMap<>();
        for (User user : users) {
            List<Tweet> tweets = tweetService.findAllByUser(user);
            tweetCounts.put(user.getUsername(), tweets.size());
        }
        model.addAttribute("tweetCounts", tweetCounts);
    }

}
