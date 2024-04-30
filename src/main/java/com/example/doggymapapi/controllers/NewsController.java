package com.example.doggymapapi.controllers;

import com.example.doggymapapi.models.News;
import com.example.doggymapapi.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }



    @GetMapping("news-list")
    public String findAll(Model model) {
        List<News> news = newsService.findAll();
        model.addAttribute("news", news);
        return "news-list";
    }


    @GetMapping("NewsPage")
    public String findAllForPage(Model model) {
        List<News> news = newsService.findAll();
        model.addAttribute("news", news);
        return "site/NewsPage";
    }



    @GetMapping("/create")
    public String createNewsForm(News news) {
        return "news-create";
    }

    @PostMapping("/create")
    public String createNews(News news) {
        newsService.saveNews(news);
        return "redirect:/news";
    }

    @GetMapping("/update/{id}")
    public String updateNewsForm(@PathVariable Long id, Model model) {
        News news = newsService.findById(id);
        model.addAttribute("news", news);
        return "news-update";
    }

    @PostMapping("/update")
    public String updateNews(News news) {
        newsService.saveNews(news);
        return "redirect:/news";
    }

    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
        return "redirect:/news";
    }
}
