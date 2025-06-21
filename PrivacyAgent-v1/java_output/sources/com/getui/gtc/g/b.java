package com.getui.gtc.g;

/* loaded from: classes22.dex */
public final class b {
    public static void a(com.getui.gtc.entity.a.C0306a c0306a, java.lang.String str) throws java.lang.Exception {
        if (a(c0306a)) {
            throw new java.lang.RuntimeException("The download request is unusual, too many times in a short time");
        }
        com.getui.gtc.base.http.Response execute = com.getui.gtc.g.d.a.newCall(new com.getui.gtc.base.http.Request.Builder().url(c0306a.h).method("GET").logFlags(1).build()).execute();
        if (execute.body() == null) {
            throw new java.lang.RuntimeException("can not save file, body is null");
        }
        execute.body().file(new java.io.File(str));
    }

    private static boolean a(com.getui.gtc.entity.a.C0306a c0306a) {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        cVar = com.getui.gtc.e.c.a.a;
        int c = cVar.b.c(c0306a.a);
        cVar2 = com.getui.gtc.e.c.a.a;
        long b = cVar2.b.b(c0306a.a);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = true;
        if (c >= 10) {
            c = -1;
            b = currentTimeMillis;
        } else {
            long j = currentTimeMillis - b;
            if (c >= 0) {
                if (j > 3600000) {
                    b = currentTimeMillis;
                    c = 0;
                } else {
                    c++;
                }
                z = false;
            } else if (j > 3600000) {
                b = currentTimeMillis;
                c = 0;
            }
        }
        cVar3 = com.getui.gtc.e.c.a.a;
        cVar3.b.a(c0306a.a, b, c);
        return z;
    }
}
