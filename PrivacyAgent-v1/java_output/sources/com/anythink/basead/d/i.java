package com.anythink.basead.d;

/* loaded from: classes12.dex */
public class i {
    public static final java.lang.String a = "i";
    private java.util.Map<java.lang.String, com.anythink.core.api.BaseAd> b;

    public static class a {
        private static final com.anythink.basead.d.i a = new com.anythink.basead.d.i((byte) 0);

        private a() {
        }
    }

    private i() {
        this.b = new java.util.HashMap(2);
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static com.anythink.basead.d.i a() {
        return com.anythink.basead.d.i.a.a;
    }

    public final com.anythink.core.api.BaseAd a(java.lang.String str) {
        return this.b.remove(str);
    }

    public final void a(java.lang.String str, com.anythink.core.api.BaseAd baseAd) {
        this.b.put(str, baseAd);
    }
}
