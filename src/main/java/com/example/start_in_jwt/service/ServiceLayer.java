package com.example.start_in_jwt.service;

import java.util.List;

public interface ServiceLayer<RQST, RSPNS> {

    RSPNS save(RQST rqst);

    RSPNS update(Long id, RQST rqst);

    RSPNS findById(Long id);

    List<RSPNS> findAll();

    RSPNS delete(Long id);
}
