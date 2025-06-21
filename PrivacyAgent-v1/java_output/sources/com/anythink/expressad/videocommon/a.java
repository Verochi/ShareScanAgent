package com.anythink.expressad.videocommon;

/* loaded from: classes12.dex */
public final class a {
    private static final java.lang.String a = "TemplateWebviewCache";
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> b = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> c = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> d = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> e = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> f = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> g = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> h = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> i = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> j = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> k = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.expressad.videocommon.a$a, reason: collision with other inner class name */
    public static class C0231a {
        private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a;
        private boolean b;

        public final com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a() {
            return this.a;
        }

        public final void a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
            this.a = windVaneWebView;
        }

        public final void a(java.lang.String str) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final java.lang.String b() {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.a;
            return windVaneWebView != null ? (java.lang.String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.b;
        }
    }

    public static com.anythink.expressad.videocommon.a.C0231a a(int i2, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            java.lang.String aa = cVar.aa();
            if (i2 != 94) {
                if (i2 != 287) {
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap = b;
                    if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                        return b.get(aa);
                    }
                } else if (cVar.A()) {
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap2 = d;
                    if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                        return d.get(aa);
                    }
                } else {
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap3 = g;
                    if (concurrentHashMap3 != null && concurrentHashMap3.size() > 0) {
                        return g.get(aa);
                    }
                }
            } else if (cVar.A()) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap4 = c;
                if (concurrentHashMap4 != null && concurrentHashMap4.size() > 0) {
                    return c.get(aa);
                }
            } else {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap5 = f;
                if (concurrentHashMap5 != null && concurrentHashMap5.size() > 0) {
                    return f.get(aa);
                }
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static com.anythink.expressad.videocommon.a.C0231a a(java.lang.String str) {
        if (h.containsKey(str)) {
            return h.get(str);
        }
        if (i.containsKey(str)) {
            return i.get(str);
        }
        if (j.containsKey(str)) {
            return j.get(str);
        }
        if (k.containsKey(str)) {
            return k.get(str);
        }
        return null;
    }

    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> a(int i2, boolean z) {
        return i2 != 94 ? i2 != 287 ? b : z ? d : g : z ? c : f;
    }

    public static void a() {
        h.clear();
        i.clear();
    }

    public static void a(int i2) {
        try {
            if (i2 == 94) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap = c;
                if (concurrentHashMap != null) {
                    concurrentHashMap.clear();
                }
            } else {
                if (i2 != 287) {
                    return;
                }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap2 = d;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.clear();
                }
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i2, java.lang.String str, com.anythink.expressad.videocommon.a.C0231a c0231a) {
        try {
            if (i2 == 94) {
                if (c == null) {
                    c = new java.util.concurrent.ConcurrentHashMap<>();
                }
                c.put(str, c0231a);
            } else {
                if (i2 != 287) {
                    return;
                }
                if (d == null) {
                    d = new java.util.concurrent.ConcurrentHashMap<>();
                }
                d.put(str, c0231a);
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(java.lang.String str, com.anythink.expressad.videocommon.a.C0231a c0231a, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                i.put(str, c0231a);
                return;
            } else {
                h.put(str, c0231a);
                return;
            }
        }
        if (z2) {
            k.put(str, c0231a);
        } else {
            j.put(str, c0231a);
        }
    }

    private static void a(java.lang.String str, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry : i.entrySet()) {
                    if (entry.getKey().startsWith(str)) {
                        i.remove(entry.getKey());
                    }
                }
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry2 : h.entrySet()) {
                if (entry2.getKey().startsWith(str)) {
                    h.remove(entry2.getKey());
                }
            }
            return;
        }
        if (z2) {
            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry3 : k.entrySet()) {
                if (entry3.getKey().startsWith(str)) {
                    k.remove(entry3.getKey());
                }
            }
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry4 : j.entrySet()) {
            if (entry4.getKey().startsWith(str)) {
                j.remove(entry4.getKey());
            }
        }
    }

    public static void b() {
        j.clear();
        k.clear();
    }

    public static void b(int i2) {
        try {
            if (i2 == 94) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap = f;
                if (concurrentHashMap != null) {
                    concurrentHashMap.clear();
                    return;
                }
                return;
            }
            if (i2 != 287) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap2 = b;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.clear();
                    return;
                }
                return;
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap3 = g;
            if (concurrentHashMap3 != null) {
                concurrentHashMap3.clear();
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(int i2, com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            java.lang.String aa = cVar.aa();
            if (i2 == 94) {
                if (cVar.A()) {
                    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap = c;
                    if (concurrentHashMap != null) {
                        concurrentHashMap.remove(aa);
                        return;
                    }
                    return;
                }
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap2 = f;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(aa);
                    return;
                }
                return;
            }
            if (i2 != 287) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap3 = b;
                if (concurrentHashMap3 != null) {
                    concurrentHashMap3.remove(aa);
                    return;
                }
                return;
            }
            if (cVar.A()) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap4 = d;
                if (concurrentHashMap4 != null) {
                    concurrentHashMap4.remove(aa);
                    return;
                }
                return;
            }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> concurrentHashMap5 = g;
            if (concurrentHashMap5 != null) {
                concurrentHashMap5.remove(aa);
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(int i2, java.lang.String str, com.anythink.expressad.videocommon.a.C0231a c0231a) {
        try {
            if (i2 == 94) {
                if (f == null) {
                    f = new java.util.concurrent.ConcurrentHashMap<>();
                }
                f.put(str, c0231a);
            } else if (i2 != 287) {
                if (b == null) {
                    b = new java.util.concurrent.ConcurrentHashMap<>();
                }
                b.put(str, c0231a);
            } else {
                if (g == null) {
                    g = new java.util.concurrent.ConcurrentHashMap<>();
                }
                g.put(str, c0231a);
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(java.lang.String str) {
        if (h.containsKey(str)) {
            h.remove(str);
        }
        if (j.containsKey(str)) {
            j.remove(str);
        }
        if (i.containsKey(str)) {
            i.remove(str);
        }
        if (k.containsKey(str)) {
            k.remove(str);
        }
    }

    private static void c() {
        h.clear();
    }

    public static void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            h.clear();
        } else {
            for (java.lang.String str2 : h.keySet()) {
                if (!android.text.TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    h.remove(str2);
                }
            }
        }
        i.clear();
    }

    public static void d(java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry : h.entrySet()) {
            if (entry.getKey().contains(str)) {
                h.remove(entry.getKey());
            }
        }
    }

    public static void e(java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry : i.entrySet()) {
            if (entry.getKey().contains(str)) {
                i.remove(entry.getKey());
            }
        }
    }

    private static void f(java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry : j.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                j.remove(entry.getKey());
            }
        }
    }

    private static void g(java.lang.String str) {
        for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.a.C0231a> entry : k.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                k.remove(entry.getKey());
            }
        }
    }
}
