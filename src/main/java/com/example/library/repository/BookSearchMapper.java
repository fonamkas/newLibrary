package com.example.library.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.library.dto.BookSearchForm;
import com.example.library.dto.BookSearchRow;
@Mapper
public interface BookSearchMapper {
	int countByCriteria(@Param("f") BookSearchForm form);
	
	List<BookSearchRow> searchByCriteria(@Param("f") BookSearchForm form,
										@Param("limit") int limit, 
										@Param("offset") int offset);
}

