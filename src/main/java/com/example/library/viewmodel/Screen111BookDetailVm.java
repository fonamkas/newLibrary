// ファイルパス: src/main/java/com/example/library/viewmodel/Screen111BookDetailVm.java
package com.example.library.viewmodel;

import java.util.Date;
import java.util.List;

import com.example.library.dto.CollectionDto;

import lombok.Builder;
import lombok.Value;
@Builder
@Value
public class Screen111BookDetailVm {
	private String screenNo;
    private Long bookId;
    private String bookName;
    private String authorName;
    private String publishCompany;
    private Date publishDate;
    private String imageUrl;
    private String bookDescription;
    private List<CollectionDto> collections;
}