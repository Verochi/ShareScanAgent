package com.loc;

/* loaded from: classes23.dex */
public final class fi {
    private android.net.wifi.WifiInfo a;
    private java.lang.String b;
    private java.lang.String c;
    private int d = -1;

    public fi(android.net.wifi.WifiInfo wifiInfo) {
        this.a = wifiInfo;
    }

    public final java.lang.String a() {
        if (this.c == null) {
            this.c = com.loc.fg.a(this.a);
        }
        return this.c;
    }

    public final java.lang.String b() {
        if (this.b == null) {
            this.b = com.loc.fg.b(this.a);
        }
        return this.b;
    }

    public final int c() {
        if (this.d == -1) {
            this.d = com.loc.fg.c(this.a);
        }
        return this.d;
    }

    public final boolean d() {
        return (this.a == null || android.text.TextUtils.isEmpty(b()) || !com.loc.gd.a(a())) ? false : true;
    }
}
