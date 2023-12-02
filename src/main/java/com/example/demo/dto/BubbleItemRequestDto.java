package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class BubbleItemRequestDto {


    @NotBlank(message = "Input should not be blank")
    public String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }


}
