package com.java.rest.logol.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.rest.logol.entity.News;

@Repository
public interface NewsDao extends JpaRepository<News, String> {
	
	@Query("select a from News a where a.id=?1")
    public News findOne(String id);

}
