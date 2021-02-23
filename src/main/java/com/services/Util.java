package com.services;

import com.dataTransferObjects.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

@Service
public class Util {
    private final Logger logger = Logger.getLogger(Util.class);

    @Autowired
    CacheManager cacheManager;



    @Cacheable(cacheNames = "usercache",key = "#user.email")
    public User uniqueId(User user)throws Exception{
        logger.info("Util.uniqueId starts ..");
        try {
            logger.info("In to the cache- generates the UUID");
            String uuid = UUID.randomUUID().toString();
            user.setId(uuid);
        }catch (Exception e){
            throw new Exception();
        }
        logger.info("Util.uniqueId ends..");
        return user;
    }

    public User findUser(String email) throws Exception {
        logger.info("Util.uniqueId starts..");
        User user;
        try {
            user = (User) getUserFromCache().get(email);
        } catch (Exception e){
            throw new Exception();
        }
        logger.info("Util.uniqueId ends..");
        return user;
    }

    public ConcurrentMap<Object,Object> getUserFromCache() {
        logger.info("Util.getUserFromCache starts..");
        ConcurrentMap<Object, Object> ehcache = ((ConcurrentMapCache) Objects.requireNonNull(cacheManager.getCache("usercache"))).getNativeCache();
        logger.info("Util.getUserFromCache ends..");
        return ehcache;
    }
}