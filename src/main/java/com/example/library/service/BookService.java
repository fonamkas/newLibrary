package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.dto.BookSearchForm;
import com.example.library.dto.BookSearchRow;
import com.example.library.entity.Book;
import com.example.library.repository.BookMapper;
import com.example.library.repository.BookSearchMapper;

@Service
public class BookService {
	
	private final BookMapper bookMapper;
	private final BookSearchMapper bookSearchMapper;
	
	public BookService(BookMapper bookMapper,
						BookSearchMapper bookSearchMapper) {
		this.bookMapper=bookMapper;
		this.bookSearchMapper=bookSearchMapper;
	}
	
	@Transactional(readOnly=true)
	public List<Book> findAllBooks(){
		return bookMapper.findAll();
	}
	
	@Transactional(readOnly=true)
	public int countBooks(BookSearchForm form) {
		return bookSearchMapper.countByCriteria(form);
	}
	
	@Transactional(readOnly=true)
	public List<BookSearchRow> searchBooks(BookSearchForm form, int limit, int offset){
		
		return bookSearchMapper.searchByCriteria(form,limit, offset);	
	}
	
	
	
}
