package com.amap.api.mapcore.util;

@com.amap.api.mapcore.util.gi(a = "update_item_download_info")
/* loaded from: classes12.dex */
class ax {

    @com.amap.api.mapcore.util.gj(a = "mAdcode", b = 6)
    private java.lang.String a;

    @com.amap.api.mapcore.util.gj(a = "fileLength", b = 5)
    private long b;

    @com.amap.api.mapcore.util.gj(a = "splitter", b = 2)
    private int c;

    @com.amap.api.mapcore.util.gj(a = "startPos", b = 5)
    private long d;

    @com.amap.api.mapcore.util.gj(a = "endPos", b = 5)
    private long e;

    public ax() {
        this.a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public ax(java.lang.String str, long j, int i, long j2, long j3) {
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }

    public static java.lang.String a(java.lang.String str) {
        return "mAdcode='" + str + "'";
    }
}
