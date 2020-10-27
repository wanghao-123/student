package com.cssl.dao;

import com.cssl.pojo.Subject;
import com.cssl.pojo.Votes;

public interface VotesDao {
    public int insertVotes(Votes votes);
    public int selectVotes(Votes votes);
    public int deleteVotes(Subject subject);
}
