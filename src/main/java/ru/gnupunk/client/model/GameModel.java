package ru.gnupunk.client.model;

import ru.gnupunk.client.entity.UserEntity;

import java.util.HashSet;

public class GameModel {
    private UserEntity player1;
    private UserEntity player2;
    private UserEntity player3;
    private GameType type;
    private HashSet score;


    public UserEntity getPlayer1() {
        return player1;
    }

    public void setPlayer1(UserEntity player1) {
        this.player1 = player1;
    }

    public UserEntity getPlayer2() {
        return player2;
    }

    public void setPlayer2(UserEntity player2) {
        this.player2 = player2;
    }

    public UserEntity getPlayer3() {
        return player3;
    }

    public void setPlayer3(UserEntity player3) {
        this.player3 = player3;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public HashSet getScore() {
        return score;
    }

    public void setScore(HashSet score) {
        this.score = score;
    }
}
