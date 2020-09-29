package com.example.countdownlacthtestdemo;

/**
 * @author HaiMing Xu
 * @date 2020/9/21
 */
public class Member implements Runnable{
    private String name;
    private Room room;

    public Member(Room room, String name) {
        this.room = room;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random()*10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        room.active(name);
    }
}
