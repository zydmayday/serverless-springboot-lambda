package main.java.com.example.demo.csv.strategy;

import main.java.com.example.demo.db.entity.UserEntity;
import main.java.com.example.demo.db.repository.UserRepository;
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
