package com.java.rest.logol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.rest.logol.dao.NewsDao;
import com.java.rest.logol.entity.News;
import com.java.rest.logol.response.ViewResponse;

@Service
public class NewsService {
	
	@Autowired
	private NewsDao newsDao;
	
	public List<News> findAll(){
		List<News> datas = newsDao.findAll();
		return datas ;
	}
	
	public ViewResponse findOneData(String id) {
		ViewResponse response = new ViewResponse();
		News newsFindOne = newsDao.findOne(id);
	    
		if (newsFindOne == null || id.equals("")) {
			response.setResponseCode("XX");
			response.setResponseDesc("Pilih Data yang tersedia/data tidak ada");
			return response;
	    }
	    response.setResponseCode("00");
		response.setResponseDesc("Data Ditemukan");
		response.setNews(newsFindOne);
	    return response;
	}
	
	public ViewResponse save(News news) {
		ViewResponse response = new ViewResponse();
		News newsFindOne = newsDao.findOne(news.getId());
	    
		if (newsFindOne != null) {
			response.setResponseCode("XX");
			response.setResponseDesc("Id Sudah ada");
			return response;
	    }
		newsDao.save(news);
	    response.setResponseCode("00");
		response.setResponseDesc("Data Berhasil Disimpan");
		response.setNews(news);
	    return response;
	}
	
	public ViewResponse update(String id,News news) {
		ViewResponse response = new ViewResponse();
		News newsUpdate = newsDao.findOne(id);
	    
		if (newsUpdate == null) {
			response.setResponseCode("XX");
			response.setResponseDesc("Pilih data terlebih dahulu");
			return response;
	    }
		
		newsUpdate.setTitle(news.getTitle());
		newsUpdate.setDescription(news.getDescription());
		newsUpdate.setTargetDate(news.getTargetDate());
		newsDao.save(newsUpdate);
		
	    response.setResponseCode("00");
		response.setResponseDesc("Data Berhasil Disimpan");
		response.setNews(newsUpdate);
	    return response;
	}

	public ViewResponse delete(String id) {
		ViewResponse response = new ViewResponse();
		News newsDel = newsDao.findOne(id);
	    
		if (newsDel == null || id.equals("")) {
			response.setResponseCode("XX");
			response.setResponseDesc("Pilih Data Hapus/data tidak ada");
			return response;
	    }
	    newsDao.deleteById(id);
	    response.setResponseCode("00");
		response.setResponseDesc("Data Telah dihapus");
		response.setNews(newsDel);
	    return response;
	}
}
