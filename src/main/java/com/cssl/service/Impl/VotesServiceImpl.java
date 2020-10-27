package com.cssl.service.Impl;

import com.cssl.dao.VotesDao;
import com.cssl.pojo.Votes;
import com.cssl.service.VotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VotesServiceImpl implements VotesService {
    @Autowired
    private VotesDao votesDao;
    @Override
    public int insertVotes(Votes votes) {
        return votesDao.insertVotes(votes);
    }
    @Override
    public int selectVotes(Votes votes) {
        return votesDao.selectVotes(votes);
    }
}
