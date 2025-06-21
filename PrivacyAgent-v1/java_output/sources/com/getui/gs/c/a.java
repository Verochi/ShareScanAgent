package com.getui.gs.c;

/* loaded from: classes22.dex */
public final class a {
    private static final java.util.Map<java.lang.String, java.lang.String> a = new java.util.HashMap();

    /* renamed from: com.getui.gs.c.a$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gs.c.a.b {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gs.c.a.b
        public final void a(java.lang.Exception exc) {
            if ((exc.getCause() instanceof java.io.IOException) && com.getui.gtc.server.ServerManager.switchServer("ido.cs", this.a)) {
                com.getui.gs.c.a.a(com.getui.gs.a.d.a());
            }
        }

        @Override // com.getui.gs.c.a.b
        public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
            if (map != null) {
                com.getui.gs.c.a.a.clear();
                com.getui.gs.c.a.a.putAll(map);
            }
        }
    }

    public static int a(java.lang.String str, int i) {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = a;
            if (map.containsKey(str)) {
                return java.lang.Integer.parseInt(map.get(str)) * 1;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
        return i;
    }

    public static long a(java.lang.String str, long j) {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = a;
            if (map.containsKey(str)) {
                return java.lang.Long.parseLong(map.get(str)) * 1000;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(java.lang.String str, T t) {
        T t2;
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                if (t instanceof java.lang.Integer) {
                    t2 = (T) java.lang.Integer.valueOf(java.lang.Integer.parseInt(str));
                } else if (t instanceof java.lang.Long) {
                    t2 = (T) java.lang.Long.valueOf(java.lang.Long.parseLong(str));
                } else if (t instanceof java.lang.Float) {
                    t2 = (T) java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
                } else if (t instanceof java.lang.Double) {
                    t2 = (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(str));
                }
                return t2 != null ? t : t2;
            }
            t2 = null;
            if (t2 != null) {
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return t;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
        return str2;
    }

    public static void a(android.content.Context context) {
        java.lang.String server = com.getui.gtc.server.ServerManager.getServer("ido.cs");
        com.getui.gs.c.a.a.C0288a c0288a = new com.getui.gs.c.a.a.C0288a();
        c0288a.a.b("GS-IDO");
        c0288a.a.a(java.lang.String.format("%s/api.php?format=json&t=1", server));
        c0288a.a.c(com.getui.gs.a.d.d());
        c0288a.a.f("GSIDO-1.4.6.2");
        c0288a.a.d(com.getui.gs.a.d.e());
        com.getui.gs.c.a.a aVar = new com.getui.gs.c.a.a(c0288a, (byte) 0);
        aVar.a.i(new com.getui.gs.c.a.AnonymousClass1(server).b);
        java.util.Map<java.lang.String, java.lang.String> a2 = com.getui.gtc.dyc.b.a.a(context, aVar.a);
        if (a2 != null) {
            java.util.Map<java.lang.String, java.lang.String> map = a;
            map.clear();
            map.putAll(a2);
        }
    }

    public static boolean a(java.lang.String str, boolean z) {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = a;
            if (map.containsKey(str)) {
                return java.lang.Boolean.parseBoolean(map.get(str));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gs.h.b.a.a.a.e(th);
        }
        return z;
    }
}
