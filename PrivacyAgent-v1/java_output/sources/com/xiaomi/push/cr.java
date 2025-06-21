package com.xiaomi.push;

/* loaded from: classes19.dex */
public class cr {
    private static volatile com.xiaomi.push.cr b;
    public android.content.Context a;

    private cr(android.content.Context context) {
        this.a = context;
    }

    public static com.xiaomi.push.cr a(android.content.Context context) {
        if (b == null) {
            synchronized (com.xiaomi.push.cr.class) {
                if (b == null) {
                    b = new com.xiaomi.push.cr(context);
                }
            }
        }
        return b;
    }

    public static /* synthetic */ void a(com.xiaomi.push.cr crVar) {
        com.xiaomi.push.m a = com.xiaomi.push.m.a(crVar.a);
        com.xiaomi.push.service.ad a2 = com.xiaomi.push.service.ad.a(crVar.a);
        android.content.SharedPreferences sharedPreferences = crVar.a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (java.lang.Math.abs(currentTimeMillis - j) >= com.baidu.mobads.sdk.internal.bm.e) {
            crVar.a(a2, a, false);
            if (a2.a(com.xiaomi.push.gp.StorageCollectionSwitch.bw, true)) {
                int max = java.lang.Math.max(60, a2.a(com.xiaomi.push.gp.StorageCollectionFrequency.bw, 86400));
                a.a(new com.xiaomi.push.cu(crVar.a, max), max, 0);
            }
            com.xiaomi.push.iu.a(crVar.a);
            if (a2.a(com.xiaomi.push.gp.ActivityTSSwitch.bw, false)) {
                crVar.a();
            }
            crVar.a(a2, a, true);
        }
    }

    private void a(com.xiaomi.push.service.ad adVar, com.xiaomi.push.m mVar, boolean z) {
        if (adVar.a(com.xiaomi.push.gp.UploadSwitch.bw, true)) {
            com.xiaomi.push.cv cvVar = new com.xiaomi.push.cv(this.a);
            if (z) {
                mVar.a(cvVar, java.lang.Math.max(60, adVar.a(com.xiaomi.push.gp.UploadFrequency.bw, 86400)), 0);
            } else {
                mVar.a((com.xiaomi.push.m.a) cvVar, 0);
            }
        }
    }

    private boolean a() {
        try {
            android.content.Context context = this.a;
            if (!(context instanceof android.app.Application)) {
                context = context.getApplicationContext();
            }
            ((android.app.Application) context).registerActivityLifecycleCallbacks(new com.xiaomi.push.cm(this.a, java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000)));
            return true;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }
}
