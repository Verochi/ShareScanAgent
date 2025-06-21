package com.xiaomi.push;

/* loaded from: classes19.dex */
final class fe extends com.xiaomi.push.service.c.j {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ com.xiaomi.push.fd c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe(com.xiaomi.push.fd fdVar, long j, long j2) {
        super(13);
        this.c = fdVar;
        this.a = j;
        this.b = j2;
    }

    @Override // com.xiaomi.push.service.c.j
    public final void a() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.Thread.yield();
        if (!this.c.j() || this.c.a(this.a)) {
            return;
        }
        com.xiaomi.push.service.ck a = com.xiaomi.push.service.ck.a(this.c.u);
        if (a.e()) {
            int i = a.j;
            java.lang.String str3 = i != 0 ? i != 1 ? null : "record_wifi_ptc" : "record_mobile_ptc";
            if (!android.text.TextUtils.isEmpty(str3)) {
                if (a.a.getLong("record_ptc_start", -1L) == -1) {
                    a.h = java.lang.System.currentTimeMillis();
                    a.a.edit().putLong("record_ptc_start", a.h).apply();
                }
                a.a.edit().putInt(str3, a.a.getInt(str3, 0) + 1).apply();
            }
            if (a.d && !android.text.TextUtils.isEmpty(a.c) && a.c.equals(a.e)) {
                a.b.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.a("[HB] ping timeout count:" + a.b);
                if (a.b.get() >= java.lang.Math.max(com.xiaomi.push.service.ad.a(a.k).a(com.xiaomi.push.gp.IntelligentHeartbeatNATCountInt.bw, 5), 3)) {
                    com.xiaomi.channel.commonutils.logger.b.a("[HB] change hb interval for net:" + a.c);
                    java.lang.String str4 = a.c;
                    if (com.xiaomi.push.service.ck.b(str4)) {
                        a.a.edit().putInt(com.xiaomi.push.service.ck.a.a(str4), 235000).apply();
                        a.a.edit().putLong(com.xiaomi.push.service.ck.a.b(a.c), java.lang.System.currentTimeMillis() + a.c()).apply();
                    }
                    a.d = false;
                    a.b.getAndSet(0);
                    java.lang.String str5 = a.c;
                    if (a.d() && !android.text.TextUtils.isEmpty(str5)) {
                        if (str5.startsWith("W-")) {
                            str = androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST;
                        } else if (str5.startsWith("M-")) {
                            str = "M";
                        }
                        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(str5);
                        sb.append(":::");
                        sb.append(str);
                        sb.append(":::");
                        sb.append("235000");
                        sb.append(":::");
                        sb.append(valueOf);
                        java.lang.String string = a.a.getString("record_hb_change", null);
                        if (android.text.TextUtils.isEmpty(string)) {
                            str2 = sb.toString();
                        } else {
                            str2 = string + "###" + sb.toString();
                        }
                        a.a.edit().putString("record_hb_change", str2).apply();
                    }
                }
            }
        }
        this.c.u.a(22, (java.lang.Exception) null);
    }

    @Override // com.xiaomi.push.service.c.j
    public final java.lang.String b() {
        return "check the ping-pong." + this.b;
    }
}
