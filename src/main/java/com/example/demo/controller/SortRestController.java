package com.example.demo.controller;

import com.example.demo.service.BubbleSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/sort")
public class SortRestController {

    private final BubbleSortService bubbleSortService;

    @Autowired
    public SortRestController(BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<List<Character>> getSortedDataById(@PathVariable Long requestId) {
        List<Character> sortedData = bubbleSortService.getSortedDataByRequestId(requestId);
        return ResponseEntity.ok(sortedData);
    }


}

