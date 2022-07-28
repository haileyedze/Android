package com.example.practice_gorilla.listview;

public class GorillaDTO {
    private int img_btn, button, bg_img;
    private String fm, title;

    public GorillaDTO(int img_btn, int button, int bg_img, String fm, String title) {
        this.img_btn = img_btn;
        this.button = button;
        this.bg_img = bg_img;
        this.fm = fm;
        this.title = title;
    }

    public int getImg_btn() {
        return img_btn;
    }

    public void setImg_btn(int img_btn) {
        this.img_btn = img_btn;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public int getBg_img() {
        return bg_img;
    }

    public void setBg_img(int bg_img) {
        this.bg_img = bg_img;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
