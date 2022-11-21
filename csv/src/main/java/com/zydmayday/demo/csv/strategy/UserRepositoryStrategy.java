package com.zydmayday.demo.csv.strategy;

import com.zydmayday.demo.db.entity.UserEntity;
import com.zydmayday.demo.db.repository.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class UserRepositoryStrategy implements RepositoryStrategy<UserEntity> {

    private UserRepository userRepository;

    @Override
    public Iterable<UserEntity> getEntities() {
        return userRepository.findAllUsers();
    }

    @Override
    public Iterable<?> mapToValue(UserEntity entity) {
        return Arrays.asList(entity.getName(), entity.getAge());
    }
}
