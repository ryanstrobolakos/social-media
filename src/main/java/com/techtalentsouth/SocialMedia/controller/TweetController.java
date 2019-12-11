package com.techtalentsouth.SocialMedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techtalentsouth.SocialMedia.service.TweetService;
import com.techtalentsouth.SocialMedia.service.UserService;

@Controller
public class TweetController {
	@Autowired
    private UserService userService;
	
    @Autowired
    private TweetService tweetService;

}
