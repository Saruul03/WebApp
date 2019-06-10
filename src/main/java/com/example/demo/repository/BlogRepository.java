package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer>{

	
	@Query("select b from Blog b where b.name like %?1%")
	Page<Blog> findByName(String q, Pageable pageable);
	
	
}
