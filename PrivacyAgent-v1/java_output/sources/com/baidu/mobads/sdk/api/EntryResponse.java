package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface EntryResponse {

    public interface EntryAdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i);

        void onAdClick();

        void onAdUnionClick();
    }

    java.lang.String getAdLogoUrl();

    java.lang.String getBaiduLogoUrl();

    java.lang.String getTitle();

    boolean isAdAvailable();

    void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener);

    void unionLogoClick();
}
