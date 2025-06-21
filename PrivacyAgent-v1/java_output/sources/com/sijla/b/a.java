package com.sijla.b;

@android.annotation.SuppressLint({"HandlerLeak"})
/* loaded from: classes19.dex */
public final class a {
    private static java.lang.String a;
    private static java.lang.String b;
    private static long c;
    private static long d;
    private static boolean e;
    private static java.util.HashMap<java.lang.String, java.lang.Integer> f = new java.util.HashMap<>();

    private static java.lang.StringBuilder a(android.content.Context context, long j, double d2) {
        java.lang.String str;
        int i;
        if (context instanceof android.app.Activity) {
            java.lang.String localClassName = ((android.app.Activity) context).getLocalClassName();
            i = localClassName.hashCode();
            if (f.containsKey(localClassName)) {
                str = "";
            } else {
                f.put(localClassName, java.lang.Integer.valueOf(i));
                str = i + "@" + localClassName;
            }
        } else {
            str = "init";
            i = 0;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.content.Context applicationContext = context.getApplicationContext();
        sb.append(com.sijla.h.i.b(applicationContext));
        sb.append("\t");
        sb.append(com.sijla.h.a.a.m(applicationContext));
        sb.append("\t");
        sb.append(com.sijla.b.g.d);
        sb.append("\t");
        sb.append(a);
        sb.append("\t");
        sb.append(b);
        sb.append("\t");
        sb.append(com.sijla.b.g.c);
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(c);
        sb.append("\t");
        sb.append(j);
        sb.append("\t");
        sb.append(d2);
        sb.append("\t");
        sb.append(i);
        return sb;
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.sijla.b.a.class) {
            e = true;
            c(context);
        }
    }

    private static void a(java.lang.String str, java.lang.StringBuilder sb, long j, boolean z) {
        com.sijla.a.a.a(new com.sijla.b.b(z, sb, j, str));
    }

    public static /* synthetic */ void a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.sijla.h.c.a.a();
            com.sijla.h.c.a.a(str, jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ long b() {
        d = 0L;
        return 0L;
    }

    public static synchronized void b(android.content.Context context) {
        synchronized (com.sijla.b.a.class) {
            e = false;
            c(context);
        }
    }

    private static synchronized void c(android.content.Context context) {
        synchronized (com.sijla.b.a.class) {
            java.lang.String optString = com.sijla.c.d.a.optString("rdactivityurl", "");
            if (android.text.TextUtils.isEmpty(optString)) {
                return;
            }
            if (a == null || b == null) {
                a = context.getPackageName();
                b = com.sijla.h.a.a.j(context);
            }
            if (e) {
                c = java.lang.System.currentTimeMillis() / 1000;
                if (0 == d) {
                    d = java.lang.System.currentTimeMillis();
                    a(optString, a(context, java.lang.System.currentTimeMillis() / 1000, 0.0d), d, true);
                }
            } else {
                long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
                long j = c;
                double d2 = currentTimeMillis - j;
                if (0 == j) {
                    d2 = 0.1d;
                }
                a(optString, a(context, currentTimeMillis, d2), d, false);
            }
        }
    }
}
