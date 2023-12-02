package com.example.demo.repository;

import com.example.demo.model.BubbleSortRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BubbleSortRequestRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public BubbleSortRequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long save(BubbleSortRequest bubbleSortRequest) {
        String sql = "INSERT INTO bubble_sort_request (data) VALUES (?) RETURNING id";
        return jdbcTemplate.queryForObject(sql, Long.class, bubbleSortRequest.getData());
    }


}

