package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.domain.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer>{

}
