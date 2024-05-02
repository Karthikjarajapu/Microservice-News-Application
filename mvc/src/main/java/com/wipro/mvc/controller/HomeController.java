package com.wipro.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.mvc.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<NewsArticle> newsList = new ArrayList<>();

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/home/login";
    }

    @GetMapping("/home/login")
    public String loginRedirect() {
        return "redirect:/home/addnews"; // Assuming you have a "login.jsp" or similar file for login page
    }

    @GetMapping("/home/addnews")
    public String showAddNewsForm() {
        return "addnews"; // Assuming you have an "addnews.jsp" or similar file for adding news
    }

    @GetMapping("/home/list")
    public String listNews(Model model) {
        model.addAttribute("newsList", newsList);
        return "listnews"; // Assuming you have a "listnews.jsp" or similar file for listing news
    }

    @PostMapping("/addNews")
    public String addNewsAndRedirect(@RequestParam String title, @RequestParam String content, @RequestParam String imageUrl) {
        NewsArticle news = new NewsArticle();
        news.setTitle(title);
        news.setContent(content);
        news.setImageUrl(imageUrl);
        newsList.add(news);
        // Redirect to the listnews view after adding news
        return "redirect:/home/list";
    }
}
