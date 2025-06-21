package com.loc;

/* loaded from: classes23.dex */
public enum ar {
    MIUI(com.loc.y.c("IeGlhb21p")),
    Flyme(com.loc.y.c("IbWVpenU")),
    RH(com.loc.y.c("IaHVhd2Vp")),
    ColorOS(com.loc.y.c("Ib3Bwbw")),
    FuntouchOS(com.loc.y.c("Idml2bw")),
    SmartisanOS(com.loc.y.c("Mc21hcnRpc2Fu")),
    AmigoOS(com.loc.y.c("IYW1pZ28")),
    EUI(com.loc.y.c("IbGV0dg")),
    Sense(com.loc.y.c("EaHRj")),
    LG(com.loc.y.c("EbGdl")),
    Google(com.loc.y.c("IZ29vZ2xl")),
    NubiaUI(com.loc.y.c("IbnViaWE")),
    Other("");

    private java.lang.String n;
    private int o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r = android.os.Build.MANUFACTURER;

    ar(java.lang.String str) {
        this.n = str;
    }

    public final java.lang.String a() {
        return this.n;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(java.lang.String str) {
        this.p = str;
    }

    public final java.lang.String b() {
        return this.p;
    }

    public final void b(java.lang.String str) {
        this.q = str;
    }

    @Override // java.lang.Enum
    public final java.lang.String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.o + ", versionName='" + this.q + "',ma=" + this.n + "',manufacturer=" + this.r + "'}";
    }
}
