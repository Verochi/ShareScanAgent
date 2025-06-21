package com.alimm.tanx.core.ad.listener.bean;

/* loaded from: classes.dex */
public interface ITrackItem {
    public static final int TYPE_VIDEO_END = 3;
    public static final int TYPE_VIDEO_ING = 2;
    public static final int TYPE_VIDEO_START = 1;

    int getTime();

    int getType();

    java.util.List<java.lang.String> getUrl();
}
