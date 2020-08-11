package com.laynkulan;
import java.util.Optional;
import java.util.Random;
public interface FakeRepoInterface {


    int insertUser(long id, User user);


    default int insertUser(User user){
        Random random = new Random();
        long id = random.nextLong();
        return insertUser(id,user);
    }


    Optional<User> findUserById(long id);

    boolean deleteUserById(long id);
}