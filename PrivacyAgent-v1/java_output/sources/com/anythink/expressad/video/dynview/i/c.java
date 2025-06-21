package com.anythink.expressad.video.dynview.i;

/* loaded from: classes12.dex */
public final class c {
    public static int a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null && cVar.M() != null) {
            int b = cVar.M().b();
            if (b == 302 || b == 802) {
                return -3;
            }
            if (b == 904) {
                return !a(cVar.M().e()) ? -1 : -3;
            }
        }
        return 100;
    }

    private static java.lang.String a(long j, android.content.Context context) {
        java.lang.String f = com.anythink.core.common.o.e.f(context);
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Q) || f.startsWith(com.anythink.expressad.video.dynview.a.a.R)) {
            return j + " " + context.getString(com.anythink.expressad.foundation.h.i.a(context, "anythink_cm_video_auto_play_after", com.anythink.expressad.foundation.h.i.g));
        }
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.S)) {
            return com.anythink.expressad.video.dynview.a.a.G + j + " Sekunden";
        }
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.T)) {
            return j + com.anythink.expressad.video.dynview.a.a.H;
        }
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.U)) {
            return com.anythink.expressad.video.dynview.a.a.I + j + " secondes";
        }
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
            return " ثوان" + j + com.anythink.expressad.video.dynview.a.a.J;
        }
        if (f.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
            return com.anythink.expressad.video.dynview.a.a.K + j + " секунд";
        }
        return com.anythink.expressad.video.dynview.a.a.F + j + " s";
    }

    private static void a(android.app.Activity activity) {
        if (a((android.content.Context) activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar, android.app.Activity activity) {
        if (cVar == null || cVar.M() == null) {
            return;
        }
        int c = cVar.M().c();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (c == 1) {
            activity.setRequestedOrientation(7);
            return;
        }
        if (c == 2) {
            activity.setRequestedOrientation(6);
        } else if (a((android.content.Context) activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    public static boolean a(android.content.Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse == null) {
                return false;
            }
            java.lang.String queryParameter = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.L);
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static boolean a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        com.anythink.expressad.foundation.d.c cVar;
        if (list == null || list.size() <= 0 || (cVar = list.get(0)) == null) {
            return false;
        }
        return cVar.j();
    }

    private static int b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || cVar.M() == null) {
            return 1;
        }
        return cVar.M().c();
    }
}
