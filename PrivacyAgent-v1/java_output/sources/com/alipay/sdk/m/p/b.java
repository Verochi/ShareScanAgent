package com.alipay.sdk.m.p;

/* loaded from: classes.dex */
public final class b {
    public final java.lang.String a;
    public final java.lang.String b;

    public b(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public java.lang.String a() {
        return this.b;
    }

    public java.lang.String b() {
        return this.a;
    }

    public org.json.JSONObject c() {
        if (android.text.TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new org.json.JSONObject(this.b);
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
            return null;
        }
    }

    public java.lang.String toString() {
        return java.lang.String.format("<Letter envelop=%s body=%s>", this.a, this.b);
    }
}
