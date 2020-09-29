package com.example.countdownlacthtestdemo;

/**
 * @author HaiMing Xu
 * @date 2020/9/21
 */
public class test {

    public static void main(String[] args) {
        Room room = new Room(20);
        new Thread(room).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Member member = new Member(room, "Member·" + (i + 1));
                new Thread(member).start();
            }
        }).start();
        new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                Member member = new Member(room, "Member·" + (i + 1));
                new Thread(member).start();
            }
        }).start();
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Math.random());
//        }
//    }

}
