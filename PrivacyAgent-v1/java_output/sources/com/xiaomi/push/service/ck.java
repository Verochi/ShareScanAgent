package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public class ck {

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    private static volatile com.xiaomi.push.service.ck m;
    public final android.content.SharedPreferences a;
    public long h;
    public final boolean i;
    public final android.content.Context k;
    private final boolean l;
    public final java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(0);
    public java.lang.String c = null;
    public volatile boolean d = false;
    public java.lang.String e = null;
    public final java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger(0);
    public final java.util.concurrent.atomic.AtomicInteger g = new java.util.concurrent.atomic.AtomicInteger(0);
    public int j = -1;

    public static class a {
        public static java.lang.String a(java.lang.String str) {
            return java.lang.String.format("HB_%s", str);
        }

        public static java.lang.String b(java.lang.String str) {
            return java.lang.String.format("HB_dead_time_%s", str);
        }
    }

    private ck(android.content.Context context) {
        this.k = context;
        this.i = com.xiaomi.push.iu.a(context);
        this.l = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.IntelligentHeartbeatSwitchBoolean.bw, true);
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.a = sharedPreferences;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (sharedPreferences.getLong("record_hb_count_start", -1L) == -1) {
            sharedPreferences.edit().putLong("record_hb_count_start", currentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong("record_ptc_start", -1L);
        this.h = j;
        if (j == -1) {
            this.h = currentTimeMillis;
            sharedPreferences.edit().putLong("record_ptc_start", currentTimeMillis).apply();
        }
    }

    public static com.xiaomi.push.service.ck a(android.content.Context context) {
        if (m == null) {
            synchronized (com.xiaomi.push.service.ck.class) {
                if (m == null) {
                    m = new com.xiaomi.push.service.ck(context);
                }
            }
        }
        return m;
    }

    public static boolean b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(java.lang.String str) {
        int i;
        android.content.SharedPreferences.Editor remove;
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            java.lang.String str2 = this.c;
            if (str2 == null || !str2.startsWith("W-")) {
                str = null;
            }
            i = this.a.getInt(com.xiaomi.push.service.ck.a.a(this.c), -1);
            long j = this.a.getLong(com.xiaomi.push.service.ck.a.b(this.c), -1L);
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (i != -1) {
                if (j == -1) {
                    remove = this.a.edit().putLong(com.xiaomi.push.service.ck.a.b(this.c), currentTimeMillis + c());
                } else if (currentTimeMillis > j) {
                    remove = this.a.edit().remove(com.xiaomi.push.service.ck.a.a(this.c)).remove(com.xiaomi.push.service.ck.a.b(this.c));
                }
                remove.apply();
            }
            this.b.getAndSet(0);
            if (android.text.TextUtils.isEmpty(this.c) && b() == -1) {
                this.d = true;
            } else {
                this.d = false;
            }
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[HB] network changed, netid:%s, %s", this.c, java.lang.Boolean.valueOf(this.d)));
        }
        this.c = str;
        i = this.a.getInt(com.xiaomi.push.service.ck.a.a(this.c), -1);
        long j2 = this.a.getLong(com.xiaomi.push.service.ck.a.b(this.c), -1L);
        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
        if (i != -1) {
        }
        this.b.getAndSet(0);
        if (android.text.TextUtils.isEmpty(this.c)) {
        }
        this.d = false;
        com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[HB] network changed, netid:%s, %s", this.c, java.lang.Boolean.valueOf(this.d)));
    }

    public final long a() {
        return this.a.getLong("keep_short_hb_effective_time", -1L);
    }

    public final synchronized void a(android.net.NetworkInfo networkInfo) {
        if (e()) {
            java.lang.String str = null;
            if (networkInfo != null) {
                if (networkInfo.getType() == 0) {
                    java.lang.String subtypeName = networkInfo.getSubtypeName();
                    if (!android.text.TextUtils.isEmpty(subtypeName) && !com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(subtypeName)) {
                        str = "M-".concat(java.lang.String.valueOf(subtypeName));
                    }
                    c(str);
                    this.j = 0;
                    return;
                }
                if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                    c(null);
                    this.j = -1;
                    return;
                }
                c("WIFI-ID-UNKNOWN");
                this.j = 1;
                return;
            }
            c(null);
            this.j = -1;
        }
    }

    public final synchronized void a(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && !this.a.getBoolean("support_wifi_digest", false)) {
            this.a.edit().putBoolean("support_wifi_digest", true).apply();
        }
        if (e() && !android.text.TextUtils.isEmpty(str)) {
            c("W-".concat(java.lang.String.valueOf(str)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str3;
        com.xiaomi.push.gh a2;
        com.xiaomi.push.go goVar = new com.xiaomi.push.go();
        goVar.g = str;
        goVar.c = "hb_name";
        goVar.a = "hb_channel";
        goVar.a(1L);
        goVar.b = str2;
        goVar.a(false);
        goVar.b(java.lang.System.currentTimeMillis());
        goVar.k = this.k.getPackageName();
        goVar.h = "com.xiaomi.xmsf";
        com.xiaomi.push.service.co a3 = com.xiaomi.push.service.cp.a(this.k);
        if (a3 != null && !android.text.TextUtils.isEmpty(a3.a)) {
            java.lang.String[] split = a3.a.split("@");
            if (split.length > 0) {
                str3 = split[0];
                map.put("uuid", str3);
                map.put("model", android.os.Build.MODEL);
                android.content.Context context = this.k;
                map.put("avc", java.lang.String.valueOf(com.xiaomi.push.ga.b(context, context.getPackageName())));
                map.put("pvc", "40090");
                map.put("cvc", "48");
                goVar.j = map;
                a2 = com.xiaomi.push.gh.a(this.k);
                if (a2 == null) {
                    a2.a(goVar, this.k.getPackageName());
                    return;
                }
                return;
            }
        }
        str3 = null;
        map.put("uuid", str3);
        map.put("model", android.os.Build.MODEL);
        android.content.Context context2 = this.k;
        map.put("avc", java.lang.String.valueOf(com.xiaomi.push.ga.b(context2, context2.getPackageName())));
        map.put("pvc", "40090");
        map.put("cvc", "48");
        goVar.j = map;
        a2 = com.xiaomi.push.gh.a(this.k);
        if (a2 == null) {
        }
    }

    public final int b() {
        if (android.text.TextUtils.isEmpty(this.c)) {
            return -1;
        }
        try {
            return this.a.getInt(com.xiaomi.push.service.ck.a.a(this.c), -1);
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public final long c() {
        return com.xiaomi.push.service.ad.a(this.k).a(com.xiaomi.push.gp.ShortHeartbeatEffectivePeriodMsLong.bw);
    }

    public final boolean d() {
        return e() && com.xiaomi.push.service.ad.a(this.k).a(com.xiaomi.push.gp.IntelligentHeartbeatDataCollectSwitchBoolean.bw, true) && com.xiaomi.push.iy.China.name().equals(com.xiaomi.push.service.d.a(this.k).a());
    }

    public final boolean e() {
        return this.i && (this.l || ((a() > java.lang.System.currentTimeMillis() ? 1 : (a() == java.lang.System.currentTimeMillis() ? 0 : -1)) >= 0));
    }
}
