package ru.gnupunk.client.core.implementation;

import ru.gnupunk.client.core.PlayerPool;
import ru.gnupunk.client.entity.UserEntity;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PlayerPoolImpl implements PlayerPool {

    private Set<UserEntity> playersPool;

    @PostConstruct
    public void init() {
        this.playersPool = Collections.synchronizedSet(new HashSet<>());
    }

    @Override
    public boolean addToQueue(UserEntity userEntity) {
        return this.playersPool.add(userEntity);
    }

    @Override
    public boolean removeFromQueue(UserEntity userEntity) {
        return this.playersPool.remove(userEntity);
    }

    @Override
    public boolean isExistInQueue(UserEntity userEntity) {
        return this.playersPool.contains(userEntity);
    }
}
