package com.example.demo.repository;


import com.example.demo.model.BubbleSortResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BubbleSortResultRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BubbleSortResultRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAll(List<BubbleSortResult> resultList) {

        String sql = "INSERT INTO bubble_sort_result (request_id, data_char, data_index) VALUES (?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                BubbleSortResult result = resultList.get(i);
                ps.setLong(1, result.getRequestId());
                ps.setString(2, String.valueOf(result.getDataChar()));
                ps.setInt(3, result.getDataIndex());
            }

            @Override
            public int getBatchSize() {
                return resultList.size();
            }
        });

    }

    public List<BubbleSortResult> findByRequestId(Long requestId) {
        String sql = "SELECT * FROM bubble_sort_result WHERE request_id = ? ORDER BY data_index";
        return jdbcTemplate.query(sql, new Object[]{requestId}, new BeanPropertyRowMapper<>(BubbleSortResult.class));
    }
}
