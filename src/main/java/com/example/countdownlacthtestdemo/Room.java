package com.example.countdownlacthtestdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author HaiMing Xu
 * @date 2020/9/21
 */
public class Room implements Runnable{

    private CountDownLatch countDownLatch;

    public Room(int memberNum) {
        this.countDownLatch = new CountDownLatch(memberNum);
    }
    public void active(String name) {
        System.out.println("成员:"+name+"已到达");
        countDownLatch.countDown();
        System.out.println("还需等待"+countDownLatch.getCount()+"到场");
    }

    @Override
    public void run() {
        try {
            System.out.println("会议等待阶段，总共成员数为："+countDownLatch.getCount());
            System.out.println("还需等待"+countDownLatch.getCount()+"到场");
            countDownLatch.await();
            System.out.println("会议正式开始");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
