package com.anythink.expressad.foundation.g.f;

/* loaded from: classes12.dex */
public final class a {
    private static long a;
    private static long b;
    private static long c;

    /* renamed from: com.anythink.expressad.foundation.g.f.a$a, reason: collision with other inner class name */
    public static class C0212a {
        private static com.anythink.expressad.foundation.g.f.a a = new com.anythink.expressad.foundation.g.f.a((byte) 0);

        private C0212a() {
        }
    }

    private a() {
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static com.anythink.expressad.foundation.g.f.a a() {
        return com.anythink.expressad.foundation.g.f.a.C0212a.a;
    }

    public static long b() {
        return b;
    }

    private synchronized void c() {
        if (a == 0) {
            a = android.os.SystemClock.elapsedRealtime();
            c = android.net.TrafficStats.getTotalRxBytes();
        }
    }

    private synchronized void d() {
        if (a != 0 && c != 0) {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - a;
            if (elapsedRealtime != 0) {
                try {
                    if (android.net.TrafficStats.getTotalRxBytes() != -1) {
                        long totalRxBytes = ((android.net.TrafficStats.getTotalRxBytes() - c) * 1000) / elapsedRealtime;
                        if (totalRxBytes == 0) {
                            b = 1L;
                        } else {
                            b = totalRxBytes;
                        }
                    } else {
                        b = 0L;
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            e();
        }
    }

    private synchronized void e() {
        c = 0L;
        a = 0L;
    }
}
