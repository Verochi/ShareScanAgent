package com.vivo.push.e;

/* loaded from: classes19.dex */
public final class a {
    private static java.lang.String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test", "com.vivo.hybrid"};
    private java.util.ArrayList<java.lang.String> b;

    /* renamed from: com.vivo.push.e.a$a, reason: collision with other inner class name */
    public static class C0530a {
        private static com.vivo.push.e.a a = new com.vivo.push.e.a((byte) 0);
    }

    private a() {
        this.b = null;
        this.b = new java.util.ArrayList<>();
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static com.vivo.push.e.a a() {
        return com.vivo.push.e.a.C0530a.a;
    }

    public final java.util.ArrayList<java.lang.String> b() {
        return new java.util.ArrayList<>(this.b);
    }

    public final boolean c() {
        java.util.ArrayList<java.lang.String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }
}
