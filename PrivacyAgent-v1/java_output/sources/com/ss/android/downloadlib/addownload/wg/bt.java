package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class bt {
    private java.lang.String t;
    private int vw;
    private int wg;

    public bt(int i) {
        this(i, 0, null);
    }

    public bt(int i, int i2) {
        this(i, i2, null);
    }

    public bt(int i, int i2, java.lang.String str) {
        this.vw = i;
        this.wg = i2;
        this.t = str;
    }

    public bt(int i, java.lang.String str) {
        this(i, 0, str);
    }

    public int getType() {
        return this.vw;
    }

    public int vw() {
        return this.wg;
    }

    public java.lang.String wg() {
        return this.t;
    }
}
