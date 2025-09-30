package com.example.library.viewmodel.books;

import java.util.List;

import com.example.library.dto.book.BookSearchForm;
import com.example.library.dto.book.BookSearchRow;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Screen110BookSearchVm {
    String screenNo;           // "110"
    BookSearchForm form;       // 入力フォーム
    List<BookSearchRow> list;  // 検索結果
    int total;                 // 総件数
    int page;                  // 現在ページ
    int size;                  // ページサイズ
    int totalPages;            // 総ページ数
}
