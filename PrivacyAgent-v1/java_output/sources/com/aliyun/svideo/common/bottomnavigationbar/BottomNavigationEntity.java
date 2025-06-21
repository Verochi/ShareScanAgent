package com.aliyun.svideo.common.bottomnavigationbar;

/* loaded from: classes.dex */
public class BottomNavigationEntity {
    private int badgeNum;
    private int selectedIcon;
    private java.lang.String text;
    private int unSelectIcon;

    public BottomNavigationEntity(int i, int i2) {
        this.unSelectIcon = i;
        this.selectedIcon = i2;
    }

    public BottomNavigationEntity(int i, int i2, int i3) {
        this.unSelectIcon = i;
        this.selectedIcon = i2;
        this.badgeNum = i3;
    }

    public BottomNavigationEntity(java.lang.String str, int i, int i2) {
        this.text = str;
        this.unSelectIcon = i;
        this.selectedIcon = i2;
    }

    public BottomNavigationEntity(java.lang.String str, int i, int i2, int i3) {
        this.text = str;
        this.unSelectIcon = i;
        this.selectedIcon = i2;
        this.badgeNum = i3;
    }

    public int getBadgeNum() {
        return this.badgeNum;
    }

    public int getSelectedIcon() {
        return this.selectedIcon;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public int getUnSelectIcon() {
        return this.unSelectIcon;
    }

    public void setBadgeNum(int i) {
        this.badgeNum = i;
    }

    public void setSelectedIcon(int i) {
        this.selectedIcon = i;
    }

    public void setText(java.lang.String str) {
        this.text = str;
    }

    public void setUnSelectIcon(int i) {
        this.unSelectIcon = i;
    }
}
