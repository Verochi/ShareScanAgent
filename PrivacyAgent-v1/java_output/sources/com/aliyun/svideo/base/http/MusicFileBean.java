package com.aliyun.svideo.base.http;

/* loaded from: classes.dex */
public class MusicFileBean {
    public java.lang.String artist;
    public java.lang.String displayName;
    public int duration;
    public int id;
    public java.lang.String image;
    public java.lang.String musicId;
    public java.lang.String path;
    public long size;
    public java.lang.String title;
    public java.lang.String uri;

    public MusicFileBean() {
    }

    public MusicFileBean(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.title = str;
        this.artist = str2;
        this.musicId = str3;
        this.image = str4;
    }

    public java.lang.String getArtist() {
        return this.artist;
    }

    public java.lang.String getDisplayName() {
        return this.displayName;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getImage() {
        return this.image;
    }

    public java.lang.String getMusicId() {
        return this.musicId;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setArtist(java.lang.String str) {
        this.artist = str;
    }

    public void setDisplayName(java.lang.String str) {
        this.displayName = str;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImage(java.lang.String str) {
        this.image = str;
    }

    public void setMusicId(java.lang.String str) {
        this.musicId = str;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setUri(java.lang.String str) {
        this.uri = str;
    }
}
