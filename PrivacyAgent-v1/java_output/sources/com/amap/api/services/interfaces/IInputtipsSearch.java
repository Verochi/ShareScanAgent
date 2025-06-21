package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IInputtipsSearch {
    com.amap.api.services.help.InputtipsQuery getQuery();

    java.util.ArrayList<com.amap.api.services.help.Tip> requestInputtips() throws com.amap.api.services.core.AMapException;

    void requestInputtips(java.lang.String str, java.lang.String str2) throws com.amap.api.services.core.AMapException;

    void requestInputtips(java.lang.String str, java.lang.String str2, java.lang.String str3) throws com.amap.api.services.core.AMapException;

    void requestInputtipsAsyn();

    void setInputtipsListener(com.amap.api.services.help.Inputtips.InputtipsListener inputtipsListener);

    void setQuery(com.amap.api.services.help.InputtipsQuery inputtipsQuery);
}
