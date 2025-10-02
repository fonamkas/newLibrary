package com.example.library.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.library.dto.BookSearchForm;
import com.example.library.dto.BookSearchRow;
import com.example.library.service.BookService;
import com.example.library.viewmodel.Screen110BookSearchVm;

@Controller
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService=bookService;
	}
	
//	//110:検索フォーム(GE
//	@GetMapping("/search")
//	public String showSearchForm(BookSearchForm form, Model model) {
//		
//		model.addAttribute("screenNo","110");
//		
//		return "books/110_book_search";
//		
//	}
//	
//	@GetMapping("/search/result")
//	public String search(BookSearchForm form, Model model) {
//		int page=form.getPage();
//		int size=form.getSize();
//		int offset=(page-1)*size;
//		
//		int total= service.countBooks(form);
//		List<BookSearchOut> list= service.searchBooks(form,size,offset);
//		
//		int totalPages=(int)Math.ceil(total/(double)size);	
//		
//		model.addAttribute(list)
//	}
	
	@GetMapping("/search")
	public String search(BookSearchForm form ,Model model) {
		int page=form.getPage();
		int size=form.getSize();
		int offset=(page-1)*size;
		
		int total= bookService.countBooks(form);
		List<BookSearchRow> list= bookService.searchBooks(form,size,offset);
		
		int totalPages=(int)Math.ceil(total/(double)size);	
		
		Screen110BookSearchVm vm=Screen110BookSearchVm.builder()
				.screenNo("110")
				.form(form)
				.list(list)
				.total(total)
				.page(page)
				.size(size)
				.totalPages(totalPages)
				.build();
		
		System.out.println(vm);
		
		model.addAttribute("vm",vm);
		return "books";
	}
}
