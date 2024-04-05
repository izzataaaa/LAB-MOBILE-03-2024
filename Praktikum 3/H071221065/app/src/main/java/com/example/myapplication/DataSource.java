package com.example.myapplication;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagramuser();

    private static ArrayList<Instagram> generateDummyInstagramuser() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("izztaclrssa", "Don't take it personal", R.drawable.izzata, R.drawable.izzata, R.drawable.story,"1.5 JT", "5"));
        instagrams1.add(new Instagram("tiaraandini", "if u like this,then u like me", R.drawable.tiaraa, R.drawable.tiaraa, R.drawable.sg_tiara, "13.5 JT", "6452"));
        instagrams1.add(new Instagram("anggaYunnda", "easy to Love", R.drawable.angga, R.drawable.angga, R.drawable.sg_angga, "1.3 JT", "172"));
        instagrams1.add(new Instagram("iqbal.e", "mirror photos", R.drawable.iqbal, R.drawable.iqbal, R.drawable.sg_iqbal, "6.9 JT", "1"));
        instagrams1.add(new Instagram("taylorSweet", "swifties tonight", R.drawable.taylor, R.drawable.taylor, R.drawable.sg_taylor, "9.9 JT", "5"));
        instagrams1.add(new Instagram("gazali.Al", "music is my life", R.drawable.algazali, R.drawable.algazali, R.drawable.sg_al, "17.6 JT", "0"));
        instagrams1.add(new Instagram("keyshaLvrnk", "nunggu buka puasaaa", R.drawable.keysha, R.drawable.keysha, R.drawable.sg_keysha, "8.6 JT", "4"));
        instagrams1.add(new Instagram("syifa_hadju", "semangat puasanya guyss", R.drawable.syifa, R.drawable.syifa, R.drawable.sg_syifa, "3.4 JT", "0"));
        instagrams1.add(new Instagram("ziva.mgnlya", "pengen ngepost aja", R.drawable.ziva, R.drawable.ziva, R.drawable.sg_ziva, "5.4 JT", "3"));
        instagrams1.add(new Instagram("jefri.nicole", "photoshoot by gammaca.galeri", R.drawable.jefrincl, R.drawable.jefrincl, R.drawable.sg_jef, "2.4 JT", "1"));
        return instagrams1;
    }
}
