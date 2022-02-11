package com.aituNet.aituNet.service;

import com.aituNet.aituNet.repo.FriendsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class FriendServiceImpl {
    private final FriendsRepo friendsRepo;

    public FriendServiceImpl(FriendsRepo friendsRepo) {
        this.friendsRepo = friendsRepo;
    }
}
