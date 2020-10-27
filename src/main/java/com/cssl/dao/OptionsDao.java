package com.cssl.dao;

import com.cssl.pojo.Options;
import com.cssl.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface OptionsDao {
    public int insertOptions(Options options);
    public List<Map<String,Object>> selectOptions(Subject subject);
    public int deleteOptions(Subject subject);
}
