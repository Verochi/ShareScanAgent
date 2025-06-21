package com.amap.api.mapcore.util;

@com.amap.api.mapcore.util.gi(a = "update_item_file")
/* loaded from: classes12.dex */
class ay {

    @com.amap.api.mapcore.util.gj(a = "mAdcode", b = 6)
    private java.lang.String a;

    @com.amap.api.mapcore.util.gj(a = "file", b = 6)
    private java.lang.String b;

    public ay() {
        this.a = "";
        this.b = "";
    }

    public ay(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public static java.lang.String a(java.lang.String str) {
        return "mAdcode='" + str + "'";
    }

    public final java.lang.String a() {
        return this.b;
    }
}
