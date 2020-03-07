package com.example;

public class Player<M extends MoveSet> implements Comparable<Player<M>> {

    private String name;
    private Strategy<M> strategy;

    public Player(String name, Strategy<M> strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public Strategy<M> getStrategy() {
        return strategy;
    }

    @Override
    public int compareTo(Player<M> that) {
        return this.getName().compareTo(that.getName());
    }
}
