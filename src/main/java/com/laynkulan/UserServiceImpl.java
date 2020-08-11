package com.laynkulan;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final FakeRepo fakeRepo;

    public UserServiceImpl(@Qualifier("fakeRepo") FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }


    @Override
    public boolean addUser(User user) {
        fakeRepo.insertUser(user);
        System.out.println(user.getName() +" Entered");
        return true;
    }

    @Override
    public boolean addUser(long id,User user){
        fakeRepo.insertUser(id,user);
        System.out.println(user.getName() +" Entered");
        return true;
    }


    @Override
    public boolean removeUser(long id) {
        if (fakeRepo.findUserById(id).isPresent()){
            String name =  fakeRepo.findUserById(id).get().getName();
            System.out.println(name+" Removed");
            fakeRepo.deleteUserById(id);
            return true;
        }else{
            System.out.println("User with id: "+id+" does not exist");
            return false;
        }

    }

    @Override
    public User getUser(long id) {
        try {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(2_000);
            if (fakeRepo.findUserById(id).isPresent()){
                String name =  fakeRepo.findUserById(id).get().getName();
                System.out.println("Hello "+name);
                return fakeRepo.findUserById(id).get();
            }else{
                System.out.println("User with id: "+id+" does not exist");
                return null;
            }

        }catch ( InterruptedException e){
            e.printStackTrace();
            return null;
        }

    }
}