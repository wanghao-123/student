package com.cssl.service.Impl;

import com.cssl.dao.OptionsDao;
import com.cssl.pojo.Options;
import com.cssl.pojo.Subject;
import com.cssl.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OptionsServiceImpl implements OptionsService {
    @Autowired
    private OptionsDao optionsDao;
    @Override
    public int insertOptions(Options options) {
        return optionsDao.insertOptions(options);
    }

    @Override
    public List<Map<String,Object>> selectOptions(Subject subject) {
        return optionsDao.selectOptions(subject);
    }
}
