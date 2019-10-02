package com.roguethree.gymchampionexerciseap.appBootstraper;

import org.springframework.boot.CommandLineRunner;

public class DbBootstraper implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData(){

    }
}
