package com.example.demo.model;

public class BubbleSortResult {
    private Long id;
    private Long requestId;
    private char dataChar;
    private int dataIndex;


    public BubbleSortResult(Long requestId, char dataChar, int dataIndex) {

        this.requestId = requestId;
        this.dataChar = dataChar;
        this.dataIndex = dataIndex;
    }

    public BubbleSortResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public char getDataChar() {
        return dataChar;
    }

    public void setDataChar(char dataChar) {
        this.dataChar = dataChar;
    }

    public int getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(int dataIndex) {
        this.dataIndex = dataIndex;
    }
}

