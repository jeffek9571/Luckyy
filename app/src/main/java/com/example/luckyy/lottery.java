package com.example.luckyy;

import java.util.HashSet;

public class lottery {

    protected static int[] createlottery(){
        HashSet<Integer> set2 = new HashSet<>();//丟進去的東西不會有重複
        while (set2.size() < 6) {
            set2.add((int) (Math.random() * 49 + 1));
        }
        int k=0;
        int[] lottery2 = new int[6];
        for(Integer ret:set2){
            lottery2[k]=ret;
            k++;
        }
        return lottery2;
    }
    public static int[] createlottery2(){

        HashSet<Integer> set3 = new HashSet<>();//丟進去的東西不會有重複
        while (set3.size() < 7) {
            set3.add((int) (Math.random() * 38 + 1));
        }
        int k=0;
        int[] lottery3 = new int[7];
        for(Integer ret:set3){
            lottery3[k]=ret;
            k++;
        }
        lottery3[6] = (int) (Math.random() * 8 + 1);

        return lottery3;
    }
}
