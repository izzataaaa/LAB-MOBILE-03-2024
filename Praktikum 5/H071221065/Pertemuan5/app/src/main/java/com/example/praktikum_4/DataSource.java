package com.example.praktikum_4;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("taylorSweet","Taylor","swifties tonight",R.drawable.taylor,R.drawable.sg_taylor));
        instagrams1.add(new Instagram("tiaraandini", "TiaraAndini"," if u like this,then u like me",R.drawable.tiaraa,R.drawable.sg_tiara));
        instagrams1.add(new Instagram("anggaYunnda", "Angga","easy to Love",R.drawable.angga, R.drawable.sg_angga));
        instagrams1.add(new Instagram("iqbal.e", "igbalRamadhan","music is my life",R.drawable.iqbal,R.drawable.sg_iqbal));
        instagrams1.add(new Instagram("gazali.Al","AlGazali","yuhuuuu",R.drawable.nail1, R.drawable.nail2));
        return instagrams1;
    }

    public static ArrayList<Instagram> getInstagrams() {
        return instagrams;
    }
}
