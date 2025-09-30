package com.example.library.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.library.entity.Book;

@Mapper
public interface BookMapper{
	List<Book> findAll();
}