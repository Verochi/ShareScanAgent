package com.amap.api.maps;

/* loaded from: classes12.dex */
public class InfoWindowParams {
    public static final int INFOWINDOW_TYPE_IMAGE = 1;
    public static final int INFOWINDOW_TYPE_VIEW = 2;
    private android.view.View infoContent;
    private android.view.View infoWindow;
    private int infoWindowType = 2;
    private int mInfoWindowUpdateTime;

    public android.view.View getInfoContents() {
        return this.infoContent;
    }

    public android.view.View getInfoWindow() {
        return this.infoWindow;
    }

    public int getInfoWindowType() {
        return this.infoWindowType;
    }

    public long getInfoWindowUpdateTime() {
        return this.mInfoWindowUpdateTime;
    }

    public void setInfoContent(android.view.View view) {
        this.infoContent = view;
    }

    public void setInfoWindow(android.view.View view) {
        this.infoWindow = view;
    }

    public void setInfoWindowType(int i) {
        this.infoWindowType = i;
    }

    public void setInfoWindowUpdateTime(int i) {
        this.mInfoWindowUpdateTime = i;
    }
}
