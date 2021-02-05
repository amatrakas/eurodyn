package com.services;

import com.dataTransferObjects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.jcache.JCacheCache;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class Util {

    @Autowired
    CacheManager cacheManager;



    // # sto key gia na parei to pedio
    @Cacheable(cacheNames = "usercache",key = "#user.email")
    public User uniqueId(User user){
        System.out.println("In to the cache- generates the UUID");
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        return user;
    }

    public User findUser(String email) {

        for (User i : getUserFromCache()) {
            System.out.println(i);
            if (i.getEmail().equals(email)) {
                return i;
            }
        }
        return null;

    }


    public List<User> getUserFromCache() {

        javax.cache.Cache<Object, Object> ehcache = ((JCacheCache) Objects.requireNonNull(cacheManager.getCache("usercache"))).getNativeCache();
        List<User> coverageMapperList = (List<User>) (Object) StreamSupport.stream(ehcache.spliterator(), false)
                .collect(Collectors.toList()).stream().map(javax.cache.Cache.Entry::getValue).collect(Collectors.toList());

        return coverageMapperList;
    }


}