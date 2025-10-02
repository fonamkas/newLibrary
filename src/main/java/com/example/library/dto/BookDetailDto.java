package com.example.library.dto;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookDetailDto {
	
	private Long bookId;
	private String bookName;
	private String authorName;
	private String publishCompany;
	private Date publishDate;
	private String imageUrl;
	private String bookDescription;
	private List<CollectionDto> collections;

}
