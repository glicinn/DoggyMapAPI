package com.example.doggymapapi.services;

import com.example.doggymapapi.models.News;
import com.example.doggymapapi.repos.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News findById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }
}
