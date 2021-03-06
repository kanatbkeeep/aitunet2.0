package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Friends;
import com.aituNet.aituNet.repo.FriendsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class FriendServiceImpl implements FriendService{
    private final FriendsRepo friendsRepo;

    public FriendServiceImpl(FriendsRepo friendsRepo) {
        this.friendsRepo = friendsRepo;
    }


    @Override
    public Friends addFriend(Friends friends) {

        log.info("Friend {} added to {}",friends.getFriendId(),friends.getOwnerId());
        return friendsRepo.save(friends);
    }

    @Override
    public List<Friends> showFriends(Integer id) {
        log.info("{}'s friends",id);
        return friendsRepo.findAllByOwnerId(id);
    }

    @Override
    public void deleteFriend(Integer Id) {

      Friends friend = friendsRepo.findById(Id.longValue()).orElse(null);
      if(friend == null){

      }else{
          log.info("{} was deleted from friends",friend.getFriendId());
          friendsRepo.delete(friend);
      }
    }

    @Override
    public void deleteByOwnerIdAndFriendId(Integer owner, Integer friend) {
        log.info("{} was deleted from friends",friend);
        friendsRepo.deleteByOwnerIdAndFriendId(owner,friend);
    }

    @Override
    public Friends showBoth(Integer owner, Integer friend) {
        return friendsRepo.findByOwnerIdAndFriendId(owner,friend);
    }
}
