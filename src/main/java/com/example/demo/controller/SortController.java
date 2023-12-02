package com.example.demo.controller;

import com.example.demo.dto.BubbleItemRequestDto;
import com.example.demo.dto.BubbleItemResponseDto;
import com.example.demo.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SortController {

    private final BubbleSortService bubbleSortService;

    @Autowired
    public SortController(BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

        @PostMapping("/sort")
    public String submit(@ModelAttribute BubbleItemRequestDto bubbleItemRequestDto, Model model) {
        BubbleItemResponseDto responseDto = bubbleSortService.sortData(bubbleItemRequestDto);
        model.addAttribute("bubbleitemResponse", responseDto);
        return "index";
    }

}
