package com.anythink.expressad.videocommon.c;

/* loaded from: classes12.dex */
public final class a {
    private java.lang.String a;
    private java.lang.String b;

    private a(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public static com.anythink.expressad.videocommon.c.a a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new com.anythink.expressad.videocommon.c.a(jSONObject.optString(com.anythink.expressad.videocommon.e.b.u), jSONObject.optString(com.anythink.expressad.videocommon.e.b.v));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private java.lang.String a() {
        return this.a;
    }

    private void a(java.lang.String str) {
        this.a = str;
    }

    private java.lang.String b() {
        return this.b;
    }

    private void b(java.lang.String str) {
        this.b = str;
    }
}
