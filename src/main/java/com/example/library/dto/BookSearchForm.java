package com.example.library.dto;

import lombok.Data;

@Data
public class BookSearchForm {
    private String bookName;
    private String authorName;
    private String libraryName;
    private Integer page = 1;      // 1始まり
    private Integer size = 10;     // 1ページ件数


}