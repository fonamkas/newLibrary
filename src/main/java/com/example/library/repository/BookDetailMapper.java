package com.example.library.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.library.dto.BookDetailDto;
import com.example.library.dto.CollectionDto;
@Mapper
public interface BookDetailMapper {
	
	BookDetailDto selectBookById(@Param("bookId") Long bookId);
	List<CollectionDto> selectCollectionsByBookId(@Param("bookId") Long bookId);  

}
