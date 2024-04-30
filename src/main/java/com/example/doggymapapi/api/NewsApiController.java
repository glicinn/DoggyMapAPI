package com.example.doggymapapi.api;

import com.example.doggymapapi.models.News;
import com.example.doggymapapi.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsApiController {

    private final NewsService newsService;

    @Autowired
    public NewsApiController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsService.saveNews(news);
    }


    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News updatedNews) {
        // Проверка существования новости с заданным id
        News existingNews = newsService.findById(id);
        if (existingNews == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей новости
        existingNews.setNewsName(updatedNews.getNewsName());
        existingNews.setNewsDescription(updatedNews.getNewsDescription());
        existingNews.setNewsBannerTitle(updatedNews.getNewsBannerTitle());
        existingNews.setNewsArtwork(updatedNews.getNewsArtwork());
        existingNews.setNewsText(updatedNews.getNewsText());
        existingNews.setNewsLink(updatedNews.getNewsLink());

        // Сохранение обновленной новости
        News updatedNewsData = newsService.saveNews(existingNews);
        return ResponseEntity.ok(updatedNewsData);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService .deleteById(id);
    }
}