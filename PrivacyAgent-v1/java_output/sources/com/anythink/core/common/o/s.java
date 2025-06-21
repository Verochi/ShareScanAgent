package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public class s {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static volatile com.anythink.core.common.o.s e;
    private final android.util.SparseBooleanArray d = new android.util.SparseBooleanArray(3);

    public static com.anythink.core.common.o.s a() {
        if (e == null) {
            synchronized (com.anythink.core.common.o.s.class) {
                if (e == null) {
                    e = new com.anythink.core.common.o.s();
                }
            }
        }
        return e;
    }

    public final synchronized boolean a(android.content.Context context) {
        if (this.d.indexOfKey(1) >= 0) {
            return this.d.get(1);
        }
        boolean z = false;
        try {
            com.anythink.core.common.o.p pVar = new com.anythink.core.common.o.p(context);
            com.anythink.core.common.o.p.a a2 = pVar.a("com.huawei.hwid");
            java.lang.String b2 = pVar.b("com.huawei.hwid");
            if (a2 == com.anythink.core.common.o.p.a.ENABLED) {
                if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(b2)) {
                    z = true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        this.d.put(1, z);
        return z;
    }

    public final synchronized boolean b() {
        if (this.d.indexOfKey(3) >= 0) {
            return this.d.get(3);
        }
        this.d.put(3, true);
        return true;
    }

    public final synchronized boolean b(android.content.Context context) {
        if (this.d.indexOfKey(2) >= 0) {
            return this.d.get(2);
        }
        boolean z = false;
        try {
            android.content.Intent intent = new android.content.Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null) {
                if (queryIntentServices.size() > 0) {
                    z = true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        this.d.put(2, z);
        return z;
    }
}
