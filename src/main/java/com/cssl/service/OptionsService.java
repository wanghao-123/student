package com.cssl.service;

import com.cssl.pojo.Options;
import com.cssl.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface OptionsService {
    public int insertOptions(Options options);
    public List<Map<String,Object>> selectOptions(Subject subject);
}
