package com.igexin.push.config;

/* loaded from: classes23.dex */
public final class b {
    private static com.igexin.push.config.b a;

    private b() {
    }

    public static synchronized com.igexin.push.config.b a() {
        com.igexin.push.config.b bVar;
        synchronized (com.igexin.push.config.b.class) {
            if (a == null) {
                a = new com.igexin.push.config.b();
            }
            bVar = a;
        }
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.a, "PUSH_DOMAIN:" + r5.getString(r7));
        r5 = r5.getString(r7);
        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(new java.lang.String[]{"socket://xfr." + r5 + ":5224"});
        r6 = new java.lang.StringBuilder("XFR_ADDRESS_IPS:");
        r6.append(com.igexin.push.config.SDKUrlConfig.getXfrAddress()[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.a, r6.toString());
        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = new java.lang.String[]{"socket://xfr_bak." + r5 + ":5224"};
        r1 = new java.lang.StringBuilder("XFR_ADDRESS_IPS_BAK:");
        r1.append(com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        com.igexin.c.a.c.a.a(r1.toString(), new java.lang.Object[0]);
        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = new java.lang.String[]{"https://bi." + r5 + "/api.php"};
        r1 = new java.lang.StringBuilder("BI_ADDRESS_IPS:");
        r1.append(com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.a, r1.toString());
        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = new java.lang.String[]{"https://config." + r5 + "/api.php"};
        r0 = new java.lang.StringBuilder("CONFIG_ADDRESS_IPS:");
        r0.append(com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(com.igexin.push.config.h.a, r0.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b() {
        try {
            android.os.Bundle bundle = com.igexin.push.h.n.b(com.igexin.push.core.e.l).metaData;
            if (bundle != null) {
                java.util.Iterator<java.lang.String> it = bundle.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    java.lang.String next = it.next();
                    if ("PUSH_DOMAIN".equals(next)) {
                        break;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new java.lang.Object[0]);
        }
        return true;
    }

    private static java.lang.String c() {
        return null;
    }

    private static int d() {
        return 0;
    }
}
