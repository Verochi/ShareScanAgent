package com.getui.gtc.extension.distribution.gbd.k.a;

/* loaded from: classes22.dex */
public final class e extends com.getui.gtc.extension.distribution.gbd.k.b {
    private static final java.lang.String c = "GBD_CT";
    private static com.getui.gtc.extension.distribution.gbd.k.a.e d;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.k.a.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.a.b.c.f();
            java.lang.String[] split = "* * * * *".split(" ");
            java.lang.String[] split2 = new java.text.SimpleDateFormat("mm HH dd MM yy", java.util.Locale.getDefault()).format(new java.util.Date()).split(" ");
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= split2.length) {
                    z = true;
                    break;
                }
                if (!split[i].equals("*")) {
                    if (split[i].startsWith("*/")) {
                        int intValue = java.lang.Integer.valueOf(split[i].substring(2)).intValue();
                        if (intValue > 0 && java.lang.Integer.valueOf(split2[i]).intValue() % intValue != 0) {
                            break;
                        }
                    } else if (!split2[i].equals(split[i])) {
                        break;
                    }
                }
                i++;
            }
            if (z) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 1;
                obtain.arg1 = 12;
                com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
                if (aVar != null) {
                    aVar.sendMessage(obtain);
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.k.a.e.c, "w static doSample...");
            }
        }
    }

    private e() {
        this.a = com.getui.gtc.extension.distribution.gbd.d.h.aa;
        this.b = f();
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|lastRefreshTime = " + this.a);
    }

    private static void a(int i, int i2) {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar != null) {
            aVar.sendMessage(obtain);
        }
    }

    private static boolean a(java.lang.String str) {
        java.lang.String[] split = str.split(" ");
        java.lang.String[] split2 = new java.text.SimpleDateFormat("mm HH dd MM yy", java.util.Locale.getDefault()).format(new java.util.Date()).split(" ");
        for (int i = 0; i < split2.length; i++) {
            if (!split[i].equals("*")) {
                if (split[i].startsWith("*/")) {
                    int intValue = java.lang.Integer.valueOf(split[i].substring(2)).intValue();
                    if (intValue > 0 && java.lang.Integer.valueOf(split2[i]).intValue() % intValue != 0) {
                        return false;
                    }
                } else if (!split2[i].equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static /* synthetic */ boolean b(java.lang.String str) {
        java.lang.String[] split = str.split(" ");
        java.lang.String[] split2 = new java.text.SimpleDateFormat("mm HH dd MM yy", java.util.Locale.getDefault()).format(new java.util.Date()).split(" ");
        for (int i = 0; i < split2.length; i++) {
            if (!split[i].equals("*")) {
                if (split[i].startsWith("*/")) {
                    int intValue = java.lang.Integer.valueOf(split[i].substring(2)).intValue();
                    if (intValue > 0 && java.lang.Integer.valueOf(split2[i]).intValue() % intValue != 0) {
                        return false;
                    }
                } else if (!split2[i].equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static com.getui.gtc.extension.distribution.gbd.k.a.e e() {
        if (d == null) {
            d = new com.getui.gtc.extension.distribution.gbd.k.a.e();
        }
        return d;
    }

    private static long f() {
        java.util.Date date = new java.util.Date(new java.util.Date().getTime() - com.getui.gtc.extension.distribution.gbd.d.h.B);
        int intValue = java.lang.Integer.valueOf(new java.text.SimpleDateFormat("mm", java.util.Locale.getDefault()).format(date)).intValue();
        int intValue2 = java.lang.Integer.valueOf(new java.text.SimpleDateFormat("ss", java.util.Locale.getDefault()).format(date)).intValue();
        int i = (3600 - (((intValue * 60) + intValue2) % com.anythink.expressad.d.a.b.ck)) * 1000;
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "calcDelay nowMinute:" + intValue + "|nowSecond:" + intValue2 + "|delaySeconds:" + i);
        return i;
    }

    private static /* synthetic */ void g() {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.arg1 = 12;
        com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar != null) {
            aVar.sendMessage(obtain);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "doTask...");
        com.getui.gtc.extension.distribution.gbd.e.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.b;
        if (aVar != null) {
            aVar.post(new com.getui.gtc.extension.distribution.gbd.k.a.e.AnonymousClass1());
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final void a(long j) {
        this.a = j;
        this.b = f();
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.aa = j;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, java.lang.String.valueOf(j));
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "step = " + this.b + "|updateRefreshTime = " + j);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final boolean c() {
        return true;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.k.b
    public final int d() {
        return 111;
    }
}
