package com.wiredbrain.friends.controller;

import com.wiredbrain.friends.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wiredbrain.friends.service.FriendService;

import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend) {

        return friendService.save(friend);

    }

    @GetMapping("/friend")
    Iterable<Friend> read() {

        return friendService.findAll();
    }

    @PutMapping("/friend")
    ResponseEntity<Friend> update(@RequestBody Friend friend) {

        if ( friendService.findById( friend.getId()).isPresent()) {

            return new ResponseEntity<Friend>(friendService.save(friend), HttpStatus.OK);

        } else {

            return new ResponseEntity<Friend>(friend, HttpStatus.BAD_REQUEST);

        }



    }

    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable Integer id) {

        friendService.deleteById(id);

    }

    @GetMapping("/friend/{id}")
    Optional<Friend> findById(@PathVariable Integer id) {

        return friendService.findById(id);

    }

    @GetMapping("/friend/search")
    Iterable<Friend> findByQuery(@RequestParam(value="first", required = false) String firstName,
                                 @RequestParam(value ="last", required = false) String lastName) {

        if (firstName != null && lastName != null) {

            return friendService.findByFirstNameAndLastName(firstName, lastName);

        } else if (firstName != null) {

            return friendService.findByFirstName(firstName);

        } else if (lastName != null) {

            return friendService.findByLastName(lastName);

        } else {

            return friendService.findAll();
        }



    }
}
