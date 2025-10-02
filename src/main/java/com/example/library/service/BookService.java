package com.example.library.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.dto.BookDetailDto;
import com.example.library.dto.BookSearchForm;
import com.example.library.dto.BookSearchRow;
import com.example.library.dto.CollectionDto;
import com.example.library.entity.Book;
import com.example.library.repository.BookDetailMapper;
import com.example.library.repository.BookMapper;
import com.example.library.repository.BookSearchMapper;

@Service
public class BookService {

	private final BookMapper bookMapper;
	private final BookSearchMapper bookSearchMapper;
	private final BookDetailMapper bookDetailMapper;

	public BookService(BookMapper bookMapper,
			BookSearchMapper bookSearchMapper,
			BookDetailMapper bookDetailMapper) {
		this.bookMapper = bookMapper;
		this.bookSearchMapper = bookSearchMapper;
		this.bookDetailMapper = bookDetailMapper;
	}

	@Transactional(readOnly = true)
	public List<Book> findAllBooks() {
		return bookMapper.findAll();
	}

	@Transactional(readOnly = true)
	public int countBooks(BookSearchForm form) {
		return bookSearchMapper.countByCriteria(form);
	}

	@Transactional(readOnly = true)
	public List<BookSearchRow> searchBooks(BookSearchForm form, int limit, int offset) {

		return bookSearchMapper.searchByCriteria(form, limit, offset);
	}

	public BookDetailDto findBookDetailData(Long bookId) {
		return bookDetailMapper.selectBookById(bookId);
	}

	/**
	 * 【追加】書籍IDに対応する所蔵情報DTOのリストを取得する
	 */
	public List<CollectionDto> findCollectionsForBook(Long bookId) {
		return bookDetailMapper.selectCollectionsByBookId(bookId);
	}

}
