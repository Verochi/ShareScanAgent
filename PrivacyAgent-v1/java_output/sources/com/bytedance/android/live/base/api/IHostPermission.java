package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface IHostPermission {
    boolean alist();

    java.lang.String getAndroidID();

    java.lang.String getDevImei();

    java.lang.String getDevOaid();

    java.lang.String getMacAddress();

    com.bytedance.android.live.base.api.LocationProvider getTTLocation();

    boolean isCanGetAndUseAndroidID();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();
}
