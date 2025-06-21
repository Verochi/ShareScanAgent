package com.xiaomi.push;

/* loaded from: classes19.dex */
class dv implements com.xiaomi.push.du.a {
    protected android.content.Context a;
    private android.app.PendingIntent b = null;
    private volatile long c = 0;

    public dv(android.content.Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // com.xiaomi.push.du.a
    public final void a() {
        if (this.b != null) {
            try {
                ((android.app.AlarmManager) this.a.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM)).cancel(this.b);
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                this.b = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.c = 0L;
                throw th;
            }
            this.b = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.c = 0L;
        }
        this.c = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0122, code lost:
    
        if (r13.c < r9) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0156  */
    @Override // com.xiaomi.push.du.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean z) {
        int i;
        int b;
        com.xiaomi.push.service.ck a = com.xiaomi.push.service.ck.a(this.a);
        long c = com.xiaomi.push.fc.c();
        if (a.i) {
            if (!((android.text.TextUtils.isEmpty(a.c) || !a.c.startsWith("M-") || com.xiaomi.push.service.ad.a(a.k).a(com.xiaomi.push.gp.IntelligentHeartbeatUseInMobileNetworkBoolean.bw, false)) ? false : true) && ((com.xiaomi.push.service.ad.a(a.k).a(com.xiaomi.push.gp.IntelligentHeartbeatSwitchBoolean.bw, true) || a.a() >= java.lang.System.currentTimeMillis()) && (b = a.b()) != -1)) {
                c = b;
            }
        }
        if (!android.text.TextUtils.isEmpty(a.c) && !"WIFI-ID-UNKNOWN".equals(a.c) && a.j == 1) {
            boolean z2 = c < 300000;
            if (a.d()) {
                int incrementAndGet = (z2 ? a.f : a.g).incrementAndGet();
                java.lang.Object[] objArr = new java.lang.Object[2];
                objArr[0] = z2 ? "short" : "long";
                objArr[1] = java.lang.Integer.valueOf(incrementAndGet);
                com.xiaomi.channel.commonutils.logger.b.b(java.lang.String.format("[HB] %s ping interval count: %s", objArr));
                if (incrementAndGet >= 5) {
                    java.lang.String str = z2 ? "record_short_hb_count" : "record_long_hb_count";
                    int i2 = a.a.getInt(str, 0) + incrementAndGet;
                    a.a.edit().putInt(str, i2).apply();
                    java.lang.Object[] objArr2 = new java.lang.Object[2];
                    objArr2[0] = z2 ? "short" : "long";
                    objArr2[1] = java.lang.Integer.valueOf(i2);
                    com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                    (z2 ? a.f : a.g).set(0);
                }
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a("[HB] ping interval:".concat(java.lang.String.valueOf(c)));
        if (z || this.c != 0) {
            if (z) {
                a();
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (!z && this.c != 0) {
                if (this.c <= elapsedRealtime) {
                    this.c += c;
                }
                android.content.Intent intent = new android.content.Intent(com.xiaomi.push.service.an.p);
                intent.setPackage(this.a.getPackageName());
                long j = this.c;
                android.app.AlarmManager alarmManager = (android.app.AlarmManager) this.a.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
                i = android.os.Build.VERSION.SDK_INT;
                this.b = i < 31 ? android.app.PendingIntent.getBroadcast(this.a, 0, intent, com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA) : android.app.PendingIntent.getBroadcast(this.a, 0, intent, 0);
                if (i < 23) {
                    com.xiaomi.push.aj.a((java.lang.Object) alarmManager, "setExactAndAllowWhileIdle", 2, java.lang.Long.valueOf(j), this.b);
                } else {
                    try {
                        android.app.AlarmManager.class.getMethod("setExact", java.lang.Integer.TYPE, java.lang.Long.TYPE, android.app.PendingIntent.class).invoke(alarmManager, 2, java.lang.Long.valueOf(j), this.b);
                    } catch (java.lang.Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. ".concat(java.lang.String.valueOf(e)));
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer ".concat(java.lang.String.valueOf(j)));
            }
            c -= elapsedRealtime % c;
            this.c = elapsedRealtime + c;
            android.content.Intent intent2 = new android.content.Intent(com.xiaomi.push.service.an.p);
            intent2.setPackage(this.a.getPackageName());
            long j2 = this.c;
            android.app.AlarmManager alarmManager2 = (android.app.AlarmManager) this.a.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            i = android.os.Build.VERSION.SDK_INT;
            this.b = i < 31 ? android.app.PendingIntent.getBroadcast(this.a, 0, intent2, com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA) : android.app.PendingIntent.getBroadcast(this.a, 0, intent2, 0);
            if (i < 23) {
            }
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer ".concat(java.lang.String.valueOf(j2)));
        }
    }

    @Override // com.xiaomi.push.du.a
    public final boolean b() {
        return this.c != 0;
    }
}
