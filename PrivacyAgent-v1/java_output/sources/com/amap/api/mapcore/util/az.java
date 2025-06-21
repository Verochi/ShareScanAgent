package com.amap.api.mapcore.util;

@com.amap.api.mapcore.util.gi(a = "update_item")
/* loaded from: classes12.dex */
public class az {

    @com.amap.api.mapcore.util.gj(a = "localPath", b = 6)
    protected java.lang.String h;

    @com.amap.api.mapcore.util.gj(a = "mCompleteCode", b = 2)
    protected int j;

    @com.amap.api.mapcore.util.gj(a = "mState", b = 2)
    public int l;

    @com.amap.api.mapcore.util.gj(a = "title", b = 6)
    protected java.lang.String a = null;

    @com.amap.api.mapcore.util.gj(a = "url", b = 6)
    protected java.lang.String b = null;

    @com.amap.api.mapcore.util.gj(a = "mAdcode", b = 6)
    protected java.lang.String c = null;

    @com.amap.api.mapcore.util.gj(a = com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_FILE_NAME, b = 6)
    protected java.lang.String d = null;

    @com.amap.api.mapcore.util.gj(a = "version", b = 6)
    protected java.lang.String e = "";

    @com.amap.api.mapcore.util.gj(a = "lLocalLength", b = 5)
    protected long f = 0;

    @com.amap.api.mapcore.util.gj(a = "lRemoteLength", b = 5)
    protected long g = 0;

    @com.amap.api.mapcore.util.gj(a = "isProvince", b = 2)
    protected int i = 0;

    @com.amap.api.mapcore.util.gj(a = "mCityCode", b = 6)
    protected java.lang.String k = "";

    @com.amap.api.mapcore.util.gj(a = "mPinyin", b = 6)
    public java.lang.String m = "";

    public static java.lang.String e(java.lang.String str) {
        return "mAdcode='" + str + "'";
    }

    public static java.lang.String f(java.lang.String str) {
        return "mPinyin='" + str + "'";
    }

    public final java.lang.String c() {
        return this.a;
    }

    public final void c(java.lang.String str) {
        this.c = str;
    }

    public final java.lang.String d() {
        return this.e;
    }

    public final void d(java.lang.String str) {
        this.k = str;
    }

    public final java.lang.String e() {
        return this.c;
    }

    public final java.lang.String f() {
        return this.b;
    }

    public final int g() {
        return this.j;
    }

    public final java.lang.String h() {
        return this.m;
    }
}
