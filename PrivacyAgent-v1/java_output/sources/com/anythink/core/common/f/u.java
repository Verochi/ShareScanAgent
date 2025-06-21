package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class u {
    public static final java.lang.String h = "business_type";
    public static final int i = 1000;
    public static final int j = 1001;
    public java.lang.String a;
    public int b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public long f;
    public java.lang.String g;

    public static java.lang.String a(int i2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(h, i2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final java.lang.String a() {
        return this.d + "--extra: " + this.g + "--requestType: " + this.b + "--content:" + this.e;
    }
}
