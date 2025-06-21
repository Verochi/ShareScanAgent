package com.bytedance.android.live.base.api.outer.data;

/* loaded from: classes.dex */
public class RoomInfo {
    com.bytedance.android.live.base.api.outer.data.City city;
    java.lang.String count;
    java.lang.String cover;
    java.util.HashMap<java.lang.Integer, java.lang.String> extraCover;
    java.lang.String openRoomId;
    long orientation;
    com.bytedance.android.live.base.api.outer.data.AnchorInfo owner;
    java.lang.String requestId;
    long status;
    java.lang.String title;
    java.lang.String trackExtra;

    public RoomInfo() {
    }

    public RoomInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, com.bytedance.android.live.base.api.outer.data.City city, long j2, com.bytedance.android.live.base.api.outer.data.AnchorInfo anchorInfo, java.lang.String str5, java.lang.String str6, java.util.HashMap<java.lang.Integer, java.lang.String> hashMap) {
        this.openRoomId = str;
        this.title = str2;
        this.cover = str3;
        this.count = str4;
        this.orientation = j;
        this.city = city;
        this.status = j2;
        this.owner = anchorInfo;
        this.requestId = str5;
        this.trackExtra = str6;
        this.extraCover = hashMap;
    }

    public com.bytedance.android.live.base.api.outer.data.City getCity() {
        return this.city;
    }

    public java.lang.String getCount() {
        return this.count;
    }

    public java.lang.String getCover() {
        return this.cover;
    }

    public java.util.HashMap<java.lang.Integer, java.lang.String> getExtraCover() {
        return this.extraCover;
    }

    public java.lang.String getOpenRoomId() {
        return this.openRoomId;
    }

    public long getOrientation() {
        return this.orientation;
    }

    public com.bytedance.android.live.base.api.outer.data.AnchorInfo getOwner() {
        return this.owner;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public long getStatus() {
        return this.status;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getTrackExtra() {
        return this.trackExtra;
    }

    public void setCity(com.bytedance.android.live.base.api.outer.data.City city) {
        this.city = city;
    }

    public void setCount(java.lang.String str) {
        this.count = str;
    }

    public void setCover(java.lang.String str) {
        this.cover = str;
    }

    public void setOpenRoomId(java.lang.String str) {
        this.openRoomId = str;
    }

    public void setOrientation(long j) {
        this.orientation = j;
    }

    public void setOwner(com.bytedance.android.live.base.api.outer.data.AnchorInfo anchorInfo) {
        this.owner = anchorInfo;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setStatus(long j) {
        this.status = j;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setTrackExtra(java.lang.String str) {
        this.trackExtra = str;
    }
}
