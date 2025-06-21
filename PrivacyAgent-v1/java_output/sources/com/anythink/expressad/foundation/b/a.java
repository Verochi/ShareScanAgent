package com.anythink.expressad.foundation.b;

/* loaded from: classes12.dex */
public class a {
    public static final java.lang.String a = "a";
    private static volatile com.anythink.expressad.foundation.b.a b;
    private android.content.Context c;
    private java.lang.String d;
    private java.lang.String e;
    private org.json.JSONObject g;
    private boolean i;
    private java.lang.ref.WeakReference<android.content.Context> j;
    private java.lang.ref.WeakReference<android.app.Activity> k;
    private int f = 0;
    private boolean h = false;

    private a() {
    }

    private void a(int i) {
        this.f = i;
    }

    private void a(org.json.JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public static com.anythink.expressad.foundation.b.a b() {
        if (b == null) {
            synchronized (com.anythink.expressad.foundation.b.a.class) {
                if (b == null) {
                    b = new com.anythink.expressad.foundation.b.a();
                }
            }
        }
        return b;
    }

    public final java.lang.String a() {
        try {
            android.content.Context context = this.c;
            if (context != null) {
                return context.getPackageName();
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void a(android.content.Context context) {
        this.c = context;
    }

    public final void a(java.lang.String str) {
        this.d = str;
    }

    public final void b(android.content.Context context) {
        this.j = new java.lang.ref.WeakReference<>(context);
    }

    public final void b(java.lang.String str) {
        this.e = str;
    }

    public final void c() {
        if (this.h) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            this.g = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public final android.content.Context d() {
        return this.c;
    }

    public final java.lang.String e() {
        return !android.text.TextUtils.isEmpty(this.d) ? this.d : "";
    }

    public final java.lang.String f() {
        return !android.text.TextUtils.isEmpty(this.e) ? this.e : "";
    }

    public final android.content.Context g() {
        java.lang.ref.WeakReference<android.content.Context> weakReference = this.j;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final int h() {
        return this.f;
    }

    public final org.json.JSONObject i() {
        return this.g;
    }
}
