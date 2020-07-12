package com.locker.logistics.service.impl;

import com.locker.logistics.dao.LogisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsServiceImpl {


    @Autowired
    private LogisticsDao logisticsDao;


}
