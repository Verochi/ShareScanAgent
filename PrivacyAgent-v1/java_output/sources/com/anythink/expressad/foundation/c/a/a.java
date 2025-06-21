package com.anythink.expressad.foundation.c.a;

/* loaded from: classes12.dex */
public final class a {
    private com.anythink.expressad.foundation.g.a.d a;

    /* renamed from: com.anythink.expressad.foundation.c.a.a$a, reason: collision with other inner class name */
    public static class C0207a {
        private static com.anythink.expressad.foundation.c.a.a a = new com.anythink.expressad.foundation.c.a.a((byte) 0);

        private C0207a() {
        }
    }

    private a() {
        this.a = new com.anythink.expressad.foundation.g.a.d();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static com.anythink.expressad.foundation.c.a.a a() {
        return com.anythink.expressad.foundation.c.a.a.C0207a.a;
    }

    private org.json.JSONArray b() {
        return new org.json.JSONArray((java.util.Collection) this.a.a());
    }

    public final org.json.JSONObject a(java.lang.String str) {
        org.json.JSONObject b = this.a.b(str);
        if (b != null) {
            return b;
        }
        return null;
    }

    public final void a(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                this.a.a(next, jSONObject.optJSONObject(next));
            }
        }
    }
}
