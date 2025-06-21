package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class du {
    private static com.xiaomi.push.du.a a;
    private static final java.lang.String b = com.xiaomi.push.service.b.class.getCanonicalName();
    private static int c = 0;

    public interface a {
        void a();

        void a(boolean z);

        boolean b();
    }

    public static synchronized void a() {
        synchronized (com.xiaomi.push.du.class) {
            if (a == null) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("[Alarm] stop alarm.");
            a.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if (r6.equals(com.xiaomi.push.jc.a(r9, r5.name).getSuperclass().getCanonicalName()) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(android.content.Context context) {
        int i;
        com.xiaomi.push.dv dvVar;
        android.content.Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            dvVar = new com.xiaomi.push.dv(applicationContext);
        } else {
            int i2 = 0;
            try {
                android.content.pm.ServiceInfo[] serviceInfoArr = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4).services;
                if (serviceInfoArr != null) {
                    int length = serviceInfoArr.length;
                    int i3 = 0;
                    while (i2 < length) {
                        try {
                            android.content.pm.ServiceInfo serviceInfo = serviceInfoArr[i2];
                            i = 1;
                            if ("android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                java.lang.String str = b;
                                if (!str.equals(serviceInfo.name)) {
                                }
                                i3 = 1;
                                if (i3 == 1) {
                                    break;
                                }
                            }
                            if (b.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                break;
                            } else {
                                i2++;
                            }
                        } catch (java.lang.Exception e) {
                            e = e;
                            i2 = i3;
                            com.xiaomi.channel.commonutils.logger.b.a("check service err : " + e.getMessage());
                            i = i2;
                            if (i != 0) {
                            }
                            dvVar = new com.xiaomi.push.dv(applicationContext);
                            a = dvVar;
                        }
                    }
                    i2 = i3;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            i = i2;
            if (i != 0 && com.xiaomi.push.jc.b(applicationContext)) {
                throw new java.lang.RuntimeException("Should export service: " + b + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
            }
            dvVar = new com.xiaomi.push.dv(applicationContext);
        }
        a = dvVar;
    }

    public static synchronized void a(android.content.Context context, int i) {
        synchronized (com.xiaomi.push.du.class) {
            int i2 = c;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i == 2) {
                    c = 2;
                } else {
                    c = 0;
                }
            }
            int i3 = c;
            if (i2 != i3 && i3 == 2) {
                a();
                a = new com.xiaomi.push.dw(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (com.xiaomi.push.du.class) {
            if (a == null) {
                com.xiaomi.channel.commonutils.logger.b.a("timer is not initialized");
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("[Alarm] register alarm. (" + z + ")");
            a.a(z);
        }
    }

    public static synchronized boolean b() {
        synchronized (com.xiaomi.push.du.class) {
            com.xiaomi.push.du.a aVar = a;
            if (aVar == null) {
                return false;
            }
            return aVar.b();
        }
    }
}
