package com.cssl.service;

import com.cssl.pojo.Votes;

import java.util.List;

public interface VotesService {
    public int insertVotes(Votes votes);
    public int selectVotes(Votes votes);
}
