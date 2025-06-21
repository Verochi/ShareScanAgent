package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class hb {
    public static int a = 0;
    public static java.lang.String b = "";
    public static java.util.HashMap<java.lang.String, java.lang.String> c;
    public static java.util.HashMap<java.lang.String, java.lang.String> d;
    public static java.util.HashMap<java.lang.String, java.lang.String> e;
    private static com.amap.api.mapcore.util.hb f;

    public interface a {
        java.net.URLConnection a();
    }

    public hb() {
        com.amap.api.mapcore.util.ew.d();
    }

    public static int a(com.amap.api.mapcore.util.hi hiVar, long j) {
        try {
            e(hiVar);
            long j2 = 0;
            if (j != 0) {
                j2 = android.os.SystemClock.elapsedRealtime() - j;
            }
            int conntectionTimeout = hiVar.getConntectionTimeout();
            if (hiVar.getDegradeAbility() != com.amap.api.mapcore.util.hi.a.FIX && hiVar.getDegradeAbility() != com.amap.api.mapcore.util.hi.a.SINGLE) {
                long j3 = conntectionTimeout;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return java.lang.Math.min(1000, hiVar.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    public static com.amap.api.mapcore.util.hb a() {
        if (f == null) {
            f = new com.amap.api.mapcore.util.hb();
        }
        return f;
    }

    private static com.amap.api.mapcore.util.hj a(com.amap.api.mapcore.util.hi hiVar, com.amap.api.mapcore.util.hi.b bVar, int i) throws com.amap.api.mapcore.util.eu {
        try {
            e(hiVar);
            hiVar.setDegradeType(bVar);
            hiVar.setReal_max_timeout(i);
            return new com.amap.api.mapcore.util.hf().c(hiVar);
        } catch (com.amap.api.mapcore.util.eu e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    @java.lang.Deprecated
    public static com.amap.api.mapcore.util.hj a(com.amap.api.mapcore.util.hi hiVar, boolean z) throws com.amap.api.mapcore.util.eu {
        byte[] bArr;
        e(hiVar);
        hiVar.setHttpProtocol(z ? com.amap.api.mapcore.util.hi.c.HTTPS : com.amap.api.mapcore.util.hi.c.HTTP);
        com.amap.api.mapcore.util.hj hjVar = null;
        long j = 0;
        boolean z2 = false;
        if (c(hiVar)) {
            boolean d2 = d(hiVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                hjVar = a(hiVar, b(hiVar, d2), d(hiVar, d2));
            } catch (com.amap.api.mapcore.util.eu e2) {
                if (e2.f() == 21 && hiVar.getDegradeAbility() == com.amap.api.mapcore.util.hi.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!d2) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (hjVar != null && (bArr = hjVar.a) != null && bArr.length > 0) {
            return hjVar;
        }
        try {
            return a(hiVar, c(hiVar, z2), a(hiVar, j));
        } catch (com.amap.api.mapcore.util.eu e3) {
            throw e3;
        }
    }

    public static com.amap.api.mapcore.util.hi.b b(com.amap.api.mapcore.util.hi hiVar, boolean z) {
        if (hiVar.getDegradeAbility() == com.amap.api.mapcore.util.hi.a.FIX) {
            return com.amap.api.mapcore.util.hi.b.FIX_NONDEGRADE;
        }
        if (hiVar.getDegradeAbility() != com.amap.api.mapcore.util.hi.a.SINGLE && z) {
            return com.amap.api.mapcore.util.hi.b.FIRST_NONDEGRADE;
        }
        return com.amap.api.mapcore.util.hi.b.NEVER_GRADE;
    }

    public static com.amap.api.mapcore.util.hj b(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        return a(hiVar, hiVar.isHttps());
    }

    public static com.amap.api.mapcore.util.hi.b c(com.amap.api.mapcore.util.hi hiVar, boolean z) {
        return hiVar.getDegradeAbility() == com.amap.api.mapcore.util.hi.a.FIX ? z ? com.amap.api.mapcore.util.hi.b.FIX_DEGRADE_BYERROR : com.amap.api.mapcore.util.hi.b.FIX_DEGRADE_ONLY : z ? com.amap.api.mapcore.util.hi.b.DEGRADE_BYERROR : com.amap.api.mapcore.util.hi.b.DEGRADE_ONLY;
    }

    public static boolean c(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        e(hiVar);
        try {
            java.lang.String ipv6url = hiVar.getIPV6URL();
            if (android.text.TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            java.lang.String host = new java.net.URL(ipv6url).getHost();
            if (!android.text.TextUtils.isEmpty(hiVar.getIPDNSName())) {
                host = hiVar.getIPDNSName();
            }
            return com.amap.api.mapcore.util.ew.d(host);
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static int d(com.amap.api.mapcore.util.hi hiVar, boolean z) {
        try {
            e(hiVar);
            int conntectionTimeout = hiVar.getConntectionTimeout();
            int i = com.amap.api.mapcore.util.ew.e;
            if (hiVar.getDegradeAbility() != com.amap.api.mapcore.util.hi.a.FIX) {
                if (hiVar.getDegradeAbility() != com.amap.api.mapcore.util.hi.a.SINGLE && conntectionTimeout >= i && z) {
                    return i;
                }
            }
            return conntectionTimeout;
        } catch (java.lang.Throwable unused) {
            return 5000;
        }
    }

    public static boolean d(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        e(hiVar);
        if (!c(hiVar)) {
            return true;
        }
        if (hiVar.getURL().equals(hiVar.getIPV6URL()) || hiVar.getDegradeAbility() == com.amap.api.mapcore.util.hi.a.SINGLE) {
            return false;
        }
        return com.amap.api.mapcore.util.ew.h;
    }

    public static void e(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        if (hiVar == null) {
            throw new com.amap.api.mapcore.util.eu("requeust is null");
        }
        if (hiVar.getURL() == null || "".equals(hiVar.getURL())) {
            throw new com.amap.api.mapcore.util.eu("request url is empty");
        }
    }

    @java.lang.Deprecated
    public byte[] a(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        try {
            com.amap.api.mapcore.util.hj a2 = a(hiVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (com.amap.api.mapcore.util.eu e2) {
            throw e2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "bm", com.alipay.sdk.m.o.a.a);
            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }
}
