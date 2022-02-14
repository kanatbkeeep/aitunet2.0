package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entities.Friends;
import com.aituNet.aituNet.request.DeleteByOwnerAndFriendRequest;
import com.aituNet.aituNet.request.DeleteFriendRequest;
import com.aituNet.aituNet.request.MyIdForFriendsRequest;
import com.aituNet.aituNet.service.FriendServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendsController {

    private final FriendServiceImpl friendService;

    @PostMapping("/add")
    public ResponseEntity AddFrined(@RequestBody Friends friends){
        friendService.addFriend(friends);
        return new ResponseEntity("friend created", HttpStatus.CREATED);
    }
    @PostMapping("/delete")
    public ResponseEntity DeleteFriend(@RequestBody DeleteFriendRequest deleteFriendRequest){
        friendService.deleteFriend(deleteFriendRequest.getFriendId());
        return new ResponseEntity("friend is deleted", HttpStatus.CREATED);
    }
    @GetMapping("/show")
    public ResponseEntity ShowFriends(@RequestParam Integer id){
        return ResponseEntity.ok().body(friendService.showFriends(id));
    }
    @GetMapping("/showBoth")
    public ResponseEntity ShowFriendsBoth(@RequestParam Integer ownerId,Integer friendId){
        return ResponseEntity.ok().body(friendService.showBoth(ownerId,friendId));
    }
    @PostMapping("/deleteBoth")
    public ResponseEntity DeleteFriendBoth(@RequestBody DeleteByOwnerAndFriendRequest deleteByOwnerAndFriendRequest){
        friendService.deleteByOwnerIdAndFriendId(deleteByOwnerAndFriendRequest.getOwnerId(),deleteByOwnerAndFriendRequest.getFriendId());
        return new ResponseEntity("friends are deleted", HttpStatus.CREATED);
    }
}
