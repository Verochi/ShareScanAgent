package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ch {
    public static final java.lang.String a = "/a/";
    public static final java.lang.String b = "b";
    public static final java.lang.String c = "c";
    public static final java.lang.String d = "d";
    public static java.lang.String e = "s";
    public static final java.lang.String f = "g";
    public static final java.lang.String g = "h";
    public static final java.lang.String h = "e";
    public static final java.lang.String i = "f";
    public static final java.lang.String j = "j";
    public static final java.lang.String k = "k";
    public static long l;
    public static java.util.Vector<com.amap.api.col.s.bt> m = new java.util.Vector<>();

    /* renamed from: com.amap.api.col.s.ch$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ android.content.Context t;

        public AnonymousClass1(android.content.Context context) {
            this.t = context;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            try {
                com.amap.api.col.s.ck.j(this.t);
                com.amap.api.col.s.ck.l(this.t);
                com.amap.api.col.s.ck.k(this.t);
                com.amap.api.col.s.dk.a(this.t);
                com.amap.api.col.s.di.a(this.t);
            } catch (java.util.concurrent.RejectedExecutionException unused) {
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cj.c(th, "Lg", "proL");
            }
        }
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    public static void a(android.content.Context context) {
        try {
            if (java.lang.System.currentTimeMillis() - l < 60000) {
                return;
            }
            l = java.lang.System.currentTimeMillis();
            com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.ch.AnonymousClass1(context));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "Lg", "proL");
        }
    }

    @android.annotation.TargetApi(9)
    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(com.amap.api.col.s.bt btVar) {
        try {
            synchronized (android.os.Looper.getMainLooper()) {
                if (btVar == null) {
                    return;
                }
                if (m.contains(btVar)) {
                    return;
                }
                m.add(btVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static java.util.List<com.amap.api.col.s.bt> b() {
        java.util.Vector<com.amap.api.col.s.bt> vector;
        try {
            synchronized (android.os.Looper.getMainLooper()) {
                vector = m;
            }
            return vector;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return m;
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        r1 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        if (r2 >= r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        if (d(r6, r7[r2].trim()) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(java.lang.String[] strArr, java.lang.String str) {
        if (strArr != null && str != null) {
            try {
                java.lang.String[] split = str.split("\n");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= length) {
                        break;
                    }
                    java.lang.String trim = split[i2].trim();
                    if (android.text.TextUtils.isEmpty(trim) || !trim.startsWith("at ") || !trim.contains("uncaughtException")) {
                        z = false;
                    }
                    if (z) {
                        return false;
                    }
                    i2++;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean d(java.lang.String[] strArr, java.lang.String str) {
        if (strArr != null && str != null) {
            try {
                for (java.lang.String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
