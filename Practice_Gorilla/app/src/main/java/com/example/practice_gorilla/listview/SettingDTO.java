package com.example.practice_gorilla.listview;

public class SettingDTO {
    private int icon;
    private String menu;

    public SettingDTO(int icon, String menu) {
        this.icon = icon;
        this.menu = menu;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
