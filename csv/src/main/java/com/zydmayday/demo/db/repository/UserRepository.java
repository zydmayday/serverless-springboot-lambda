package com.zydmayday.demo.db.repository;

import com.zydmayday.demo.db.entity.UserEntity;

import java.util.Arrays;
import java.util.List;

public class UserRepository {
    public List<UserEntity> findAllUsers() {
        var user1 = new UserEntity("user1", 20);
        var user2 = new UserEntity("user2", 30);
        return Arrays.asList(user1, user2);
    }
}
