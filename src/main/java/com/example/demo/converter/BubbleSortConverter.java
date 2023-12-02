package com.example.demo.converter;

import com.example.demo.dto.BubbleItemRequestDto;
import com.example.demo.model.BubbleSortRequest;
import com.example.demo.model.BubbleSortResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BubbleSortConverter {

    public BubbleSortRequest convertToRequest(BubbleItemRequestDto requestDto) {
        BubbleSortRequest bubbleSortRequest = new BubbleSortRequest();
        bubbleSortRequest.setData(requestDto.getInput());
        return bubbleSortRequest;
    }

    public List<BubbleSortResult> convertToResult(Long requestId, char[] sortResult) {
        List<BubbleSortResult> resultList = new ArrayList<>();
        for (int i = 0; i < sortResult.length; i++) {
            BubbleSortResult result = new BubbleSortResult(requestId, sortResult[i], i);
            resultList.add(result);
        }
        return resultList;
    }

}
