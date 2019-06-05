package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer>{

}
