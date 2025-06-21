package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface AdData {

    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(com.qq.e.comm.pi.AdData adData);

    int getAdPatternType();

    java.lang.String getDesc();

    int getECPM();

    java.lang.String getECPMLevel();

    java.util.Map<java.lang.String, java.lang.Object> getExtraInfo();

    <T> T getProperty(java.lang.Class<T> cls);

    java.lang.String getProperty(java.lang.String str);

    java.lang.String getTitle();

    int getVideoDuration();

    void setECPMLevel(java.lang.String str);
}
