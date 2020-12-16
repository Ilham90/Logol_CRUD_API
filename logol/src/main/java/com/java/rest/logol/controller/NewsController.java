package com.java.rest.logol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.rest.logol.entity.News;
import com.java.rest.logol.response.ViewResponse;
import com.java.rest.logol.service.NewsService;

@RestController
@RequestMapping("/logol")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@PostMapping("/getData")
	public List<News> getAllBooks() {
		return newsService.findAll();
	}

	@PostMapping("/getData/{id}")
	private ViewResponse getOneData(@PathVariable("id") String id) {
		return newsService.findOneData(id);
	}

	@PostMapping("/input-data")
	public ViewResponse insert(@RequestBody News news) {
		return newsService.save(news);
	}

	@PutMapping("/update-data/{id}")
	public ViewResponse update(@PathVariable(value = "id") String id, @RequestBody News news) {
		return newsService.update(id, news);
	}

	@DeleteMapping("/getData/Delete/{id}")
	public ViewResponse delete(@PathVariable(value = "id") String id) {
		return newsService.delete(id);
	}

}
