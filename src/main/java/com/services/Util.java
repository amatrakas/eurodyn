package com.services;

import com.dataTransferObjects.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class Util {
    // # sto key gia na parei to pedio
    @Cacheable(cacheNames = "usercache",key = "#user.email")
    public User uniqueId(User user){

        System.out.println("In to the cache- generates the UUID");
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        return user;
    }
}
