package com.cssl.service.Impl;

import com.cssl.dao.OptionsDao;
import com.cssl.dao.SubjectDao;
import com.cssl.dao.VotesDao;
import com.cssl.pojo.Subject;
import com.cssl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private OptionsDao optionsDao;
    @Autowired
    private VotesDao votesDao;
    @Override
    public int insertSubject(Subject subject) {
        return subjectDao.insertSubject(subject);
    }

    @Override
    public List<Map<String, Object>> selectSubject(Subject subject) {
        return subjectDao.selectSubject(subject);
    }

    @Override
    public int deleteAll(Subject subject) {
        int result;
        try {
            votesDao.deleteVotes(subject);
            optionsDao.deleteOptions(subject);
            subjectDao.deleteSubject(subject);
            result=1;
        }catch (Exception e){
            result=0;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int selectTitle(Subject subject) {
        return subjectDao.selectTitle(subject);
    }
}
