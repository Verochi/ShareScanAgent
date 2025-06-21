package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class aq {
    private static com.xiaomi.push.service.aq a;
    private android.content.Context b;
    private int c = 0;

    private aq(android.content.Context context) {
        this.b = context.getApplicationContext();
    }

    public static com.xiaomi.push.service.aq a(android.content.Context context) {
        if (a == null) {
            a = new com.xiaomi.push.service.aq(context);
        }
        return a;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final int a() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        try {
            this.c = android.provider.Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        } catch (java.lang.Exception unused) {
        }
        return this.c;
    }
}
