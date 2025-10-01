package com.example.library.dto;

import lombok.Data;

@Data
public class BookSearchRow {
    private Long bookId;
    private String bookName;
    private String authorNames;     // 複数著者をカンマ連結で表示
    private Integer totalAvailable; // 全館の合計空き冊数
    private Integer libCount;       // 在庫がある館数（目安）
    
}