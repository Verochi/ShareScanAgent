package com.jd.ad.sdk.bl.initsdk;

/* loaded from: classes23.dex */
public abstract class JADPrivateController {
    public java.lang.String getIP() {
        return "";
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.dl.baseinfo.JADLocation getLocation() {
        return new com.jd.ad.sdk.dl.baseinfo.JADLocation(-1.0d, -1.0d, -1.0d);
    }

    public abstract java.lang.String getOaid();

    public boolean isCanUseIP() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }
}
