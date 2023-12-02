package com.example.demo.service;

import com.example.demo.converter.BubbleSortConverter;
import com.example.demo.model.BubbleSortRequest;
import com.example.demo.model.BubbleSortResult;
import com.example.demo.repository.BubbleSortRequestRepository;
import com.example.demo.repository.BubbleSortResultRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.BubbleItemRequestDto;
import com.example.demo.dto.BubbleItemResponseDto;
import org.springframework.validation.annotation.Validated;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class BubbleSortService {

    private final BubbleSortRequestRepository requestRepository;
    private final BubbleSortResultRepository resultRepository;
    private final BubbleSortConverter converter;

    @Autowired
    public BubbleSortService(BubbleSortRequestRepository requestRepository, BubbleSortResultRepository resultRepository,
                             BubbleSortConverter converter) {
        this.requestRepository = requestRepository;
        this.resultRepository = resultRepository;
        this.converter = converter;

    }

    public BubbleItemResponseDto sortData(@Valid BubbleItemRequestDto requestDto) {

        BubbleSortRequest bubbleSortRequest = converter.convertToRequest(requestDto);
        Long requestId = requestRepository.save(bubbleSortRequest);
        char[] sortResult = bubbleSort(requestDto.getInput());
        List<BubbleSortResult> resultList = converter.convertToResult(requestId, sortResult);
        resultRepository.saveAll(resultList);
        return new BubbleItemResponseDto(requestId, new String(sortResult));
    }

    public List<Character> getSortedDataByRequestId(Long requestId) {
        List<BubbleSortResult> sortedData = resultRepository.findByRequestId(requestId);
        if (sortedData == null) {
            // Обработка ситуации, когда результаты не найдены
            return Collections.emptyList();
        }
        return sortedData.stream()
                .map(BubbleSortResult::getDataChar)
                .collect(Collectors.toList());
    }

    private char[] bubbleSort(String output) {
        char[] arr = output.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    char temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


}
