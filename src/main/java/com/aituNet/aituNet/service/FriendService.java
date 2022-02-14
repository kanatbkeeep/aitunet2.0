package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Friends;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendService {
    Friends addFriend(Friends friends);
    List<Friends> showFriends(Integer id);
    void deleteFriend(Integer Id);
    void deleteByOwnerIdAndFriendId(Integer owner, Integer friend);
}
