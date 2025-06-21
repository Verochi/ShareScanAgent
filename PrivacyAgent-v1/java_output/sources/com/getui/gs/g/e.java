package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class e {
    public long a;
    public long b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public java.lang.String j;
    public org.json.JSONObject k;

    public final void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        this.k = jSONObject;
    }

    public final java.lang.String toString() {
        return "TypeData{id=" + this.a + ", time=" + this.b + ", type=" + this.c + ", data='" + this.d + "', sessionId='" + this.e + "', versionName='" + this.f + "', foreground='" + this.g + "', channelId='" + this.h + "', systemVersion='" + this.i + "', sdkVersion='" + this.j + "', inner='" + this.k.toString() + "'}";
    }
}
