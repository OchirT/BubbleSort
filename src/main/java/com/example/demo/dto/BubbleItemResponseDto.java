package com.example.demo.dto;

public class BubbleItemResponseDto {
    private Long id;
    private String sortResult;

    public BubbleItemResponseDto(Long id, String sortResult) {
        this.id = id;
        this.sortResult = sortResult;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortResult() {
        return sortResult;
    }

    public void setSortResult(String sortResult) {
        this.sortResult = sortResult;
    }
}

