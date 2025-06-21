package com.amap.api.col.s;

/* loaded from: classes12.dex */
public enum ce {
    MIUI(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI),
    Flyme(com.igexin.assist.util.AssistUtils.BRAND_MZ),
    EMUI(com.igexin.assist.util.AssistUtils.BRAND_HW),
    ColorOS(com.igexin.assist.util.AssistUtils.BRAND_OPPO),
    FuntouchOS(com.igexin.assist.util.AssistUtils.BRAND_VIVO),
    SmartisanOS("smartisan"),
    AmigoOS("amigo"),
    EUI("letv"),
    Sense("htc"),
    LG("lge"),
    Google("google"),
    NubiaUI("nubia"),
    Other("");

    private java.lang.String n;
    private int o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r = android.os.Build.MANUFACTURER;

    ce(java.lang.String str) {
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
