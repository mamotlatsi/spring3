package com.laynkulan;

public interface UserService {
    boolean addUser(User user);

    default boolean addUser(long id, User user){
        return addUser(id,user);
    }

    boolean removeUser(long id);

    User getUser(long id);

}
