package ru.gnupunk.client.core;

import ru.gnupunk.client.entity.UserEntity;

public interface PlayerPool {
    public boolean addToQueue(UserEntity userEntity);
    public boolean removeFromQueue(UserEntity userEntity);
    public boolean isExistInQueue(UserEntity userEntity);
}
