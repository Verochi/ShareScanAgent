package com.ss.android.download.api.download;

/* loaded from: classes19.dex */
public interface DownloadEventConfig {
    java.lang.String getClickButtonTag();

    java.lang.String getClickContinueLabel();

    java.lang.String getClickInstallLabel();

    java.lang.String getClickItemTag();

    java.lang.String getClickLabel();

    java.lang.String getClickPauseLabel();

    java.lang.String getClickStartLabel();

    int getDownloadScene();

    java.lang.Object getExtraEventObject();

    org.json.JSONObject getExtraJson();

    org.json.JSONObject getParamsJson();

    java.lang.String getRefer();

    java.lang.String getStorageDenyLabel();

    boolean isEnableClickEvent();

    boolean isEnableV3Event();

    void setDownloadScene(int i);

    void setRefer(java.lang.String str);
}
