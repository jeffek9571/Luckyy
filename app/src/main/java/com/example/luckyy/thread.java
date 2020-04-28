package com.example.luckyy;
import static com.example.luckyy.lottery.createlottery;
import static com.example.luckyy.lottery.createlottery2;

public class thread extends MainActivity implements Runnable {

    static int[] lottery = new int[6];
    static int[] lottery2 = new int[6];
    static int[] lottery3 = new int[7];
    static int[] lottery4 = new int[7];

    @Override
    public void run() {
        for(int t=0;t<5000;t++){
            lottery = createlottery();
            lottery2 = createlottery();
            lottery3 = createlottery2();
            lottery4 = createlottery2();
        }
    }
}
