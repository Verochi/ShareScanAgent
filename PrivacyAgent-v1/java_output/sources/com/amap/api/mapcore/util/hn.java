package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class hn {
    static java.lang.ref.WeakReference<com.amap.api.mapcore.util.hl> a;

    /* renamed from: com.amap.api.mapcore.util.hn$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass1(java.lang.String str, android.content.Context context) {
            this.a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.amap.api.mapcore.util.hn.class) {
                try {
                    java.lang.String a = com.amap.api.mapcore.util.fd.a(com.amap.api.mapcore.util.fi.a(this.a));
                    com.amap.api.mapcore.util.hl a2 = com.amap.api.mapcore.util.hs.a(com.amap.api.mapcore.util.hn.a);
                    com.amap.api.mapcore.util.hs.a(this.b, a2, com.amap.api.mapcore.util.gb.j, 50, 102400, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (a2.e == null) {
                        a2.e = new com.amap.api.mapcore.util.gt(new com.amap.api.mapcore.util.gw(new com.amap.api.mapcore.util.gv()));
                    }
                    com.amap.api.mapcore.util.hm.a(a, com.amap.api.mapcore.util.fi.a(" \"timestamp\":\"" + com.amap.api.mapcore.util.fi.a(java.lang.System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + this.a), a2);
                } finally {
                }
            }
        }
    }

    public static void a(java.lang.String str, android.content.Context context) {
        com.amap.api.mapcore.util.gd.d().submit(new com.amap.api.mapcore.util.hn.AnonymousClass1(str, context));
    }
}
