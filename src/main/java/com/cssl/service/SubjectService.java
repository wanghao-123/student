package com.cssl.service;

import com.cssl.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    public int insertSubject(Subject subject);
    public List<Map<String,Object>> selectSubject(Subject subject);
    public int selectTitle(Subject subject);
    public int deleteAll(Subject subject);
}
