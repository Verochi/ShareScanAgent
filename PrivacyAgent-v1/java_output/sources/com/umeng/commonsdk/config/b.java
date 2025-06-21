package com.umeng.commonsdk.config;

/* loaded from: classes19.dex */
public class b implements com.umeng.commonsdk.config.f {
    private static java.util.Map<java.lang.String, java.lang.Boolean> a = new java.util.HashMap();
    private static java.lang.Object b = new java.lang.Object();

    public static class a {
        private static final com.umeng.commonsdk.config.b a = new com.umeng.commonsdk.config.b(null);

        private a() {
        }
    }

    private b() {
    }

    public /* synthetic */ b(com.umeng.commonsdk.config.b.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static boolean a(java.lang.String str) {
        if (!com.umeng.commonsdk.config.d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!a.containsKey(str)) {
                return true;
            }
            return a.get(str).booleanValue();
        }
    }

    public static com.umeng.commonsdk.config.b b() {
        return com.umeng.commonsdk.config.b.a.a;
    }

    public void a() {
        synchronized (b) {
            a.clear();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(java.lang.String str, java.lang.Boolean bool) {
        if (com.umeng.commonsdk.config.d.a(str)) {
            synchronized (b) {
                java.util.Map<java.lang.String, java.lang.Boolean> map = a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
