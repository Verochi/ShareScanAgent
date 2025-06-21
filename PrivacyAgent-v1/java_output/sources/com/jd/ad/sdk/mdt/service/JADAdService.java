package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADAdService {
    boolean enablePreloadAd(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot);

    com.jd.ad.sdk.dl.model.IJADExtra getJADExtra(@androidx.annotation.NonNull java.lang.String str);

    java.util.List<com.jd.ad.sdk.dl.addata.JADMaterialData> getJADMaterialDataList(@androidx.annotation.NonNull java.lang.String str);

    void loadAd(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, @androidx.annotation.NonNull com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener);

    void loadAdFromCache(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, @androidx.annotation.NonNull com.jd.ad.sdk.bl.adload.JADAdLoadListener jADAdLoadListener);

    void printRequestData(@androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot);

    void registerAd(java.lang.String str);

    void registerAdPreloader(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot);

    void removeData(@androidx.annotation.NonNull java.lang.String str);

    void unregisterAd(@androidx.annotation.NonNull java.lang.String str);

    void unregisterAdPreloader(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot);
}
