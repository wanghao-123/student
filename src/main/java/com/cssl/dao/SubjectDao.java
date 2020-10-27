package com.cssl.dao;

import com.cssl.pojo.Subject;

import java.util.List;
import java.util.Map;

public interface SubjectDao {

    public int insertSubject(Subject subject);
    public List<Map<String,Object>> selectSubject(Subject subject);
    public int selectTitle(Subject subject);
    public int deleteSubject(Subject subject);

}
