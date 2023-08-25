package com.junior.ec04.model;

public class Temporada extends Shows{
    private int season;

    public Temporada(String name, String imgurl, int season) {
        super(name, imgurl);
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}


