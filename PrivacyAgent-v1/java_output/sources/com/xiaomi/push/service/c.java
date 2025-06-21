package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public class c extends android.app.Service implements com.xiaomi.push.ey {
    private static boolean p;
    public com.xiaomi.push.ev c;
    com.xiaomi.push.service.cf d;
    private com.xiaomi.push.ew i;
    private com.xiaomi.push.service.at j;
    private java.lang.String k;
    private com.xiaomi.push.service.c.f l;
    private com.xiaomi.push.service.c.t m;
    private com.xiaomi.push.service.c.k n;
    private com.xiaomi.push.service.c.a o;
    private com.xiaomi.push.service.c.r q;
    private com.xiaomi.push.er t;
    private android.database.ContentObserver x;
    private boolean h = false;
    private int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f489s = 0;
    long a = 0;
    protected java.lang.Class b = com.xiaomi.push.service.b.class;
    private com.xiaomi.push.service.ah u = null;
    com.xiaomi.push.service.cl e = null;
    android.os.Messenger f = null;
    private java.util.Collection<com.xiaomi.push.service.v> v = java.util.Collections.synchronizedCollection(new java.util.ArrayList());
    java.util.ArrayList<com.xiaomi.push.service.c.n> g = new java.util.ArrayList<>();
    private com.xiaomi.push.fb w = new com.xiaomi.push.service.bm(this);

    public class a extends android.content.BroadcastReceiver {
        private final java.lang.Object b;

        private a() {
            this.b = new java.lang.Object();
        }

        public /* synthetic */ a(com.xiaomi.push.service.c cVar, byte b) {
            this();
        }

        private void a() {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.b) {
                try {
                    this.b.wait(3000L);
                } catch (java.lang.InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] interrupt from waiting state. ".concat(java.lang.String.valueOf(e)));
                }
            }
        }

        public static /* synthetic */ void a(com.xiaomi.push.service.c.a aVar) {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (aVar.b) {
                try {
                    aVar.b.notifyAll();
                } catch (java.lang.Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] notify lock. ".concat(java.lang.String.valueOf(e)));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!com.xiaomi.push.service.an.p.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.a("[Alarm] cancel the old ping timer");
                com.xiaomi.push.du.a();
                return;
            }
            if (android.text.TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.xiaomi.push.service.c.class);
                    intent2.putExtra("time_stamp", java.lang.System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    com.xiaomi.push.service.a.a(context).a(intent2);
                    a();
                    com.xiaomi.channel.commonutils.logger.b.a("[Alarm] heartbeat alarm finish in " + (java.lang.System.currentTimeMillis() - currentTimeMillis));
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public class b extends com.xiaomi.push.service.c.j {
        com.xiaomi.push.service.aj.b a;

        public b(com.xiaomi.push.service.aj.b bVar) {
            super(9);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            try {
                if (!com.xiaomi.push.service.c.this.b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                com.xiaomi.push.service.aj a = com.xiaomi.push.service.aj.a();
                com.xiaomi.push.service.aj.b bVar = this.a;
                com.xiaomi.push.service.aj.b b = a.b(bVar.h, bVar.b);
                if (b == null) {
                    com.xiaomi.channel.commonutils.logger.b.a("ignore bind because the channel " + this.a.h + " is removed ");
                    return;
                }
                if (b.m == com.xiaomi.push.service.aj.c.unbind) {
                    b.a(com.xiaomi.push.service.aj.c.binding, 0, 0, null, null);
                    com.xiaomi.push.service.c.this.c.a(b);
                    com.xiaomi.push.ej.a(com.xiaomi.push.service.c.this, b);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("trying duplicate bind, ingore! " + b.m);
                }
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. ".concat(java.lang.String.valueOf(e)));
                com.xiaomi.push.service.c.this.a(10, e);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "bind the client. " + this.a.h;
        }
    }

    /* renamed from: com.xiaomi.push.service.c$c, reason: collision with other inner class name */
    public static class C0535c extends com.xiaomi.push.service.c.j {
        private final com.xiaomi.push.service.aj.b a;

        public C0535c(com.xiaomi.push.service.aj.b bVar) {
            super(12);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            this.a.a(com.xiaomi.push.service.aj.c.unbind, 1, 21, null, null);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "bind time out. chid=" + this.a.h;
        }

        public final boolean equals(java.lang.Object obj) {
            if (obj instanceof com.xiaomi.push.service.c.C0535c) {
                return android.text.TextUtils.equals(((com.xiaomi.push.service.c.C0535c) obj).a.h, this.a.h);
            }
            return false;
        }

        public final int hashCode() {
            return this.a.h.hashCode();
        }
    }

    public class d extends com.xiaomi.push.service.c.j {
        com.xiaomi.push.ek a;

        public d(com.xiaomi.push.ek ekVar) {
            super(8);
            this.a = ekVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:158:0x04c0 A[Catch: Exception -> 0x07a1, TRY_ENTER, TryCatch #6 {Exception -> 0x07a1, blocks: (B:126:0x03ac, B:128:0x03af, B:130:0x03b7, B:132:0x03c3, B:134:0x03c9, B:136:0x0421, B:144:0x042f, B:145:0x044f, B:147:0x045a, B:149:0x0462, B:150:0x049a, B:152:0x04a9, B:158:0x04c0, B:161:0x052b, B:162:0x04d3, B:167:0x0545, B:169:0x054d, B:173:0x0565, B:186:0x05ab, B:187:0x05b6, B:175:0x05c6, B:180:0x05fe, B:181:0x0609, B:177:0x0619, B:183:0x060d, B:189:0x05ba, B:190:0x0635, B:192:0x0639, B:193:0x0644, B:194:0x0651, B:196:0x0657, B:199:0x0559, B:211:0x0662, B:185:0x057e, B:179:0x05d1), top: B:97:0x0316, inners: #2, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:169:0x054d A[Catch: Exception -> 0x07a1, TryCatch #6 {Exception -> 0x07a1, blocks: (B:126:0x03ac, B:128:0x03af, B:130:0x03b7, B:132:0x03c3, B:134:0x03c9, B:136:0x0421, B:144:0x042f, B:145:0x044f, B:147:0x045a, B:149:0x0462, B:150:0x049a, B:152:0x04a9, B:158:0x04c0, B:161:0x052b, B:162:0x04d3, B:167:0x0545, B:169:0x054d, B:173:0x0565, B:186:0x05ab, B:187:0x05b6, B:175:0x05c6, B:180:0x05fe, B:181:0x0609, B:177:0x0619, B:183:0x060d, B:189:0x05ba, B:190:0x0635, B:192:0x0639, B:193:0x0644, B:194:0x0651, B:196:0x0657, B:199:0x0559, B:211:0x0662, B:185:0x057e, B:179:0x05d1), top: B:97:0x0316, inners: #2, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0565 A[Catch: Exception -> 0x07a1, TRY_LEAVE, TryCatch #6 {Exception -> 0x07a1, blocks: (B:126:0x03ac, B:128:0x03af, B:130:0x03b7, B:132:0x03c3, B:134:0x03c9, B:136:0x0421, B:144:0x042f, B:145:0x044f, B:147:0x045a, B:149:0x0462, B:150:0x049a, B:152:0x04a9, B:158:0x04c0, B:161:0x052b, B:162:0x04d3, B:167:0x0545, B:169:0x054d, B:173:0x0565, B:186:0x05ab, B:187:0x05b6, B:175:0x05c6, B:180:0x05fe, B:181:0x0609, B:177:0x0619, B:183:0x060d, B:189:0x05ba, B:190:0x0635, B:192:0x0639, B:193:0x0644, B:194:0x0651, B:196:0x0657, B:199:0x0559, B:211:0x0662, B:185:0x057e, B:179:0x05d1), top: B:97:0x0316, inners: #2, #5 }] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.xiaomi.push.service.c$d] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.xiaomi.push.ek] */
        /* JADX WARN: Type inference failed for: r1v6 */
        @Override // com.xiaomi.push.service.c.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            java.lang.String str;
            int i;
            com.xiaomi.push.service.c cVar;
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            com.xiaomi.push.ek ekVar;
            boolean z;
            boolean z2;
            android.content.SharedPreferences.Editor putInt;
            android.content.SharedPreferences.Editor putInt2;
            java.lang.String[] split;
            java.lang.String str5;
            java.lang.String str6;
            java.lang.String str7;
            com.xiaomi.push.service.c cVar2;
            java.lang.String[] strArr;
            com.xiaomi.push.service.aj a;
            com.xiaomi.push.service.s sVar;
            com.xiaomi.push.service.aj.b b;
            ?? r1 = this;
            java.lang.String str8 = "record_long_hb_count";
            java.lang.String str9 = "record_wifi_ptc";
            java.lang.String str10 = "record_mobile_ptc";
            com.xiaomi.push.service.s sVar2 = r1.a.e;
            if (sVar2 != null) {
                sVar2.g = java.lang.System.currentTimeMillis();
            }
            com.xiaomi.push.service.ah ahVar = com.xiaomi.push.service.c.this.u;
            com.xiaomi.push.ek ekVar2 = r1.a;
            if (5 != ekVar2.a.a) {
                java.lang.String b2 = ekVar2.b();
                java.lang.String num = java.lang.Integer.toString(ekVar2.a.a);
                if (!android.text.TextUtils.isEmpty(b2) && !android.text.TextUtils.isEmpty(num) && (b = com.xiaomi.push.service.aj.a().b(num, b2)) != null) {
                    com.xiaomi.push.gc.a(ahVar.a, b.a, ekVar2.d(), true, true, java.lang.System.currentTimeMillis());
                }
            }
            try {
                com.xiaomi.push.cx.a aVar = ekVar2.a;
                str = aVar.f;
                i = aVar.a;
            } catch (java.lang.Exception e) {
                e = e;
                r1 = ekVar2;
            }
            if (i != 0) {
                java.lang.String num2 = java.lang.Integer.toString(i);
                if ("SECMSG".equals(ekVar2.a.f)) {
                    if (ekVar2.a.l) {
                        com.xiaomi.channel.commonutils.logger.b.a("Recv SECMSG errCode = " + ekVar2.a.m + " errStr = " + ekVar2.a.n);
                        return;
                    }
                    com.xiaomi.push.service.c cVar3 = ahVar.a;
                    com.xiaomi.push.service.aj.b a2 = com.xiaomi.push.service.cf.a(ekVar2);
                    if (a2 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + num2 + " not registered");
                        return;
                    }
                    if ("5".equalsIgnoreCase(num2)) {
                        try {
                            com.xiaomi.push.service.ct.a(cVar3, ekVar2.c(a2.i), ekVar2.d());
                            return;
                        } catch (java.lang.IllegalArgumentException e2) {
                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                            return;
                        }
                    }
                    java.lang.String str11 = a2.a;
                    android.content.Intent intent = new android.content.Intent();
                    intent.setAction("com.xiaomi.push.new_msg");
                    intent.setPackage(str11);
                    intent.putExtra("ext_rcv_timestamp", android.os.SystemClock.elapsedRealtime());
                    intent.putExtra("ext_chid", num2);
                    intent.putExtra("ext_raw_packet", ekVar2.c(a2.i));
                    intent.putExtra(com.xiaomi.push.service.an.F, a2.j);
                    intent.putExtra(com.xiaomi.push.service.an.x, a2.i);
                    if (a2.r != null) {
                        try {
                            a2.r.send(android.os.Message.obtain(null, 17, intent));
                            com.xiaomi.channel.commonutils.logger.b.a("message was sent by messenger for chid=".concat(java.lang.String.valueOf(num2)));
                            return;
                        } catch (android.os.RemoteException unused) {
                            a2.r = null;
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("peer may died: ");
                            java.lang.String str12 = a2.b;
                            sb.append(str12.substring(str12.lastIndexOf(64)));
                            com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                        }
                    }
                    if ("com.xiaomi.xmsf".equals(str11)) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a2.h, a2.a, ekVar2.a()));
                    com.xiaomi.push.service.cf.a(cVar3, intent, a2);
                    if (!com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(num2) || (sVar = ekVar2.e) == null) {
                        return;
                    }
                    sVar.h = java.lang.System.currentTimeMillis();
                    if (com.xiaomi.push.gj.a(cVar3)) {
                        com.xiaomi.push.service.bc.a("category_coord_down", "coord_down", "com.xiaomi.xmsf", ekVar2.e);
                        return;
                    }
                    return;
                    e = e;
                    r1 = ekVar2;
                    com.xiaomi.channel.commonutils.logger.b.a("handle Blob chid = " + r1.a.a + " cmd = " + r1.a.f + " packetid = " + r1.a() + " failure ", e);
                    return;
                }
                if (!"BIND".equals(str)) {
                    if ("KICK".equals(str)) {
                        com.xiaomi.push.cx.g gVar = (com.xiaomi.push.cx.g) new com.xiaomi.push.cx.g().b(ekVar2.c());
                        java.lang.String b3 = ekVar2.b();
                        java.lang.String str13 = gVar.a;
                        java.lang.String str14 = gVar.b;
                        com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + num2 + " res= " + com.xiaomi.push.service.aj.b.a(b3) + " type=" + str13 + " reason=" + str14);
                        if (!"wait".equals(str13)) {
                            ahVar.a.a(num2, b3, 3, str14, str13);
                            com.xiaomi.push.service.aj.a().a(num2, b3);
                            return;
                        }
                        com.xiaomi.push.service.aj.b b4 = com.xiaomi.push.service.aj.a().b(num2, b3);
                        if (b4 != null) {
                            ahVar.a.a(b4);
                            b4.a(com.xiaomi.push.service.aj.c.unbind, 3, 0, str14, str13);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.xiaomi.push.cx.d dVar = (com.xiaomi.push.cx.d) new com.xiaomi.push.cx.d().b(ekVar2.c());
                java.lang.String b5 = ekVar2.b();
                com.xiaomi.push.service.aj.b b6 = com.xiaomi.push.service.aj.a().b(num2, b5);
                if (b6 != null) {
                    if (dVar.a) {
                        com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind succeeded, chid=" + ekVar2.a.a);
                        b6.a(com.xiaomi.push.service.aj.c.binded, 1, 0, null, null);
                        return;
                    }
                    java.lang.String str15 = dVar.b;
                    if (com.alipay.sdk.m.k.b.n.equals(str15)) {
                        if ("invalid-sig".equals(dVar.c)) {
                            com.xiaomi.channel.commonutils.logger.b.a("SMACK: bind error invalid-sig token = " + b6.c + " sec = " + b6.i);
                            com.xiaomi.push.ej.a(com.xiaomi.push.dy.BIND_INVALID_SIG.af, 1, null, 0);
                        }
                        b6.a(com.xiaomi.push.service.aj.c.unbind, 1, 5, dVar.c, str15);
                        a = com.xiaomi.push.service.aj.a();
                    } else {
                        if (!com.anythink.expressad.d.a.b.dO.equals(str15)) {
                            if ("wait".equals(str15)) {
                                ahVar.a.a(b6);
                                b6.a(com.xiaomi.push.service.aj.c.unbind, 1, 7, dVar.c, str15);
                            }
                            com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, chid=" + num2 + " reason=" + dVar.c);
                            return;
                        }
                        b6.a(com.xiaomi.push.service.aj.c.unbind, 1, 7, dVar.c, str15);
                        a = com.xiaomi.push.service.aj.a();
                    }
                    a.a(num2, b5);
                    com.xiaomi.channel.commonutils.logger.b.a("SMACK: channel bind failed, chid=" + num2 + " reason=" + dVar.c);
                    return;
                }
                return;
            }
            try {
                if ("PING".equals(str)) {
                    byte[] c = ekVar2.c();
                    if (c != null && c.length > 0) {
                        com.xiaomi.push.cx.j jVar = (com.xiaomi.push.cx.j) new com.xiaomi.push.cx.j().b(c);
                        if (jVar.a) {
                            com.xiaomi.push.service.ay.a().a(jVar.b);
                        }
                    }
                    if (!"com.xiaomi.xmsf".equals(ahVar.a.getPackageName())) {
                        com.xiaomi.push.service.c cVar4 = ahVar.a;
                        if (android.os.SystemClock.elapsedRealtime() - cVar4.a >= com.xiaomi.push.fc.b() && com.xiaomi.push.ai.c(cVar4)) {
                            cVar4.a(true);
                        }
                    }
                    if ("1".equals(ekVar2.a())) {
                        com.xiaomi.channel.commonutils.logger.b.a("received a server ping");
                    } else {
                        com.xiaomi.push.ej.b();
                    }
                    com.xiaomi.push.service.c cVar5 = ahVar.a;
                    com.xiaomi.push.service.ck a3 = com.xiaomi.push.service.ck.a(cVar5.getApplicationContext());
                    if (a3.e()) {
                        if (a3.d()) {
                            java.lang.String string = a3.a.getString("record_hb_change", null);
                            if (android.text.TextUtils.isEmpty(string) || (split = string.split("###")) == null) {
                                str2 = "record_long_hb_count";
                                str3 = "record_wifi_ptc";
                                str4 = "record_mobile_ptc";
                                cVar = cVar5;
                                ekVar = ekVar2;
                            } else {
                                ekVar = ekVar2;
                                int i2 = 0;
                                while (i2 < split.length) {
                                    if (android.text.TextUtils.isEmpty(split[i2])) {
                                        str5 = str8;
                                        str6 = str9;
                                        str7 = str10;
                                        cVar2 = cVar5;
                                        strArr = split;
                                    } else {
                                        strArr = split;
                                        java.lang.String[] split2 = split[i2].split(":::");
                                        if (split2 != null) {
                                            cVar2 = cVar5;
                                            if (split2.length >= 4) {
                                                java.lang.String str16 = split2[0];
                                                str6 = str9;
                                                java.lang.String str17 = split2[1];
                                                java.lang.String str18 = split2[2];
                                                java.lang.String str19 = split2[3];
                                                str7 = str10;
                                                java.util.HashMap hashMap = new java.util.HashMap();
                                                str5 = str8;
                                                hashMap.put("event", "change");
                                                hashMap.put("model", android.os.Build.MODEL);
                                                hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_NET_TYPE, str17);
                                                hashMap.put("net_name", str16);
                                                hashMap.put(com.umeng.analytics.pro.bo.ba, str18);
                                                hashMap.put("timestamp", str19);
                                                a3.a("category_hb_change", null, hashMap);
                                                com.xiaomi.channel.commonutils.logger.b.a("[HB] report hb changed events.");
                                            } else {
                                                str5 = str8;
                                                str6 = str9;
                                                str7 = str10;
                                            }
                                        } else {
                                            str5 = str8;
                                            str6 = str9;
                                            str7 = str10;
                                            cVar2 = cVar5;
                                        }
                                    }
                                    i2++;
                                    split = strArr;
                                    cVar5 = cVar2;
                                    str9 = str6;
                                    str10 = str7;
                                    str8 = str5;
                                }
                                str2 = str8;
                                str3 = str9;
                                str4 = str10;
                                cVar = cVar5;
                                a3.a.edit().remove("record_hb_change").apply();
                            }
                            if (a3.a.getBoolean("support_wifi_digest", false) && !a3.a.getBoolean("record_support_wifi_digest_reported", false)) {
                                java.util.HashMap hashMap2 = new java.util.HashMap();
                                hashMap2.put("event", "support");
                                hashMap2.put("model", android.os.Build.MODEL);
                                hashMap2.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
                                a3.a("category_hb_change", null, hashMap2);
                                com.xiaomi.channel.commonutils.logger.b.a("[HB] report support wifi digest events.");
                                a3.a.edit().putBoolean("record_support_wifi_digest_reported", true).apply();
                            }
                            long j = a3.a.getLong("record_hb_count_start", -1L);
                            if (j != -1) {
                                long currentTimeMillis = java.lang.System.currentTimeMillis();
                                if (j > currentTimeMillis || currentTimeMillis - j >= 259200000) {
                                    z = true;
                                    if (z) {
                                        int i3 = a3.a.getInt("record_short_hb_count", 0);
                                        java.lang.String str20 = str2;
                                        int i4 = a3.a.getInt(str20, 0);
                                        if (i3 > 0 || i4 > 0) {
                                            java.lang.String valueOf = java.lang.String.valueOf(a3.a.getLong("record_hb_count_start", -1L));
                                            java.lang.String valueOf2 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                                            try {
                                                org.json.JSONObject jSONObject = new org.json.JSONObject();
                                                jSONObject.put(com.umeng.analytics.pro.bo.ba, "235000");
                                                jSONObject.put("c_short", java.lang.String.valueOf(i3));
                                                jSONObject.put("c_long", java.lang.String.valueOf(i4));
                                                jSONObject.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, java.lang.String.valueOf(i3 + i4));
                                                jSONObject.put("start_time", valueOf);
                                                jSONObject.put("end_time", valueOf2);
                                                java.lang.String jSONObject2 = jSONObject.toString();
                                                java.util.HashMap hashMap3 = new java.util.HashMap();
                                                hashMap3.put("event", "long_and_short_hb_count");
                                                a3.a("category_hb_count", jSONObject2, hashMap3);
                                                com.xiaomi.channel.commonutils.logger.b.a("[HB] report short/long hb count events.");
                                            } catch (java.lang.Throwable unused2) {
                                            }
                                        }
                                        a3.a.edit().putInt("record_short_hb_count", 0).putInt(str20, 0).putLong("record_hb_count_start", java.lang.System.currentTimeMillis()).apply();
                                    }
                                    if (a3.h != -1) {
                                        long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                                        long j2 = a3.h;
                                        if (j2 <= currentTimeMillis2) {
                                            if (currentTimeMillis2 - j2 >= 259200000) {
                                            }
                                        }
                                        z2 = true;
                                        if (z2) {
                                            java.lang.String valueOf3 = java.lang.String.valueOf(a3.h);
                                            java.lang.String valueOf4 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                                            java.lang.String str21 = str4;
                                            int i5 = a3.a.getInt(str21, 0);
                                            if (i5 > 0) {
                                                try {
                                                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                                                    jSONObject3.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                                                    jSONObject3.put("ptc", i5);
                                                    jSONObject3.put("start_time", valueOf3);
                                                    jSONObject3.put("end_time", valueOf4);
                                                    java.lang.String jSONObject4 = jSONObject3.toString();
                                                    java.util.HashMap hashMap4 = new java.util.HashMap();
                                                    hashMap4.put("event", "ptc_event");
                                                    a3.a("category_lc_ptc", jSONObject4, hashMap4);
                                                    com.xiaomi.channel.commonutils.logger.b.a("[HB] report ping timeout count events of mobile network.");
                                                    putInt = a3.a.edit().putInt(str21, 0);
                                                } catch (java.lang.Throwable unused3) {
                                                    putInt = a3.a.edit().putInt(str21, 0);
                                                }
                                                putInt.apply();
                                            }
                                            java.lang.String str22 = str3;
                                            int i6 = a3.a.getInt(str22, 0);
                                            if (i6 > 0) {
                                                try {
                                                    org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                                                    jSONObject5.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_NET_TYPE, androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST);
                                                    jSONObject5.put("ptc", i6);
                                                    jSONObject5.put("start_time", valueOf3);
                                                    jSONObject5.put("end_time", valueOf4);
                                                    java.lang.String jSONObject6 = jSONObject5.toString();
                                                    java.util.HashMap hashMap5 = new java.util.HashMap();
                                                    hashMap5.put("event", "ptc_event");
                                                    a3.a("category_lc_ptc", jSONObject6, hashMap5);
                                                    com.xiaomi.channel.commonutils.logger.b.a("[HB] report ping timeout count events of wifi network.");
                                                    putInt2 = a3.a.edit().putInt(str22, 0);
                                                } catch (java.lang.Throwable unused4) {
                                                    putInt2 = a3.a.edit().putInt(str22, 0);
                                                }
                                                putInt2.apply();
                                            }
                                            a3.h = java.lang.System.currentTimeMillis();
                                            a3.a.edit().putLong("record_ptc_start", a3.h).apply();
                                        }
                                    }
                                    z2 = false;
                                    if (z2) {
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                            if (a3.h != -1) {
                            }
                            z2 = false;
                            if (z2) {
                            }
                        } else {
                            cVar = cVar5;
                        }
                        if (a3.d) {
                            a3.b.getAndSet(0);
                        }
                    } else {
                        cVar = cVar5;
                    }
                    java.util.Iterator it = new java.util.ArrayList(cVar.g).iterator();
                    while (it.hasNext()) {
                        ((com.xiaomi.push.service.c.n) it.next()).a();
                    }
                    return;
                }
                try {
                    if (!"SYNC".equals(str)) {
                        if ("NOTIFY".equals(ekVar2.a.f)) {
                            com.xiaomi.push.cx.h hVar = (com.xiaomi.push.cx.h) new com.xiaomi.push.cx.h().b(ekVar2.c());
                            com.xiaomi.channel.commonutils.logger.b.a("notify by server err = " + hVar.a + " desc = " + hVar.b);
                            return;
                        }
                        return;
                    }
                    if ("CONF".equals(ekVar2.a.h)) {
                        com.xiaomi.push.service.ay.a().a(com.xiaomi.push.cx.b.a(ekVar2.c()));
                        return;
                    }
                    if (android.text.TextUtils.equals("U", ekVar2.a.h)) {
                        com.xiaomi.push.cx.k kVar = (com.xiaomi.push.cx.k) new com.xiaomi.push.cx.k().b(ekVar2.c());
                        com.xiaomi.push.cg a4 = com.xiaomi.push.cg.a(ahVar.a);
                        a4.a.add(new com.xiaomi.push.ch(a4, kVar.f * 1024, new java.util.Date(kVar.c), new java.util.Date(kVar.d), kVar.a, kVar.b, kVar.e));
                        a4.a(0L);
                        com.xiaomi.push.ek ekVar3 = new com.xiaomi.push.ek();
                        ekVar3.a(0);
                        ekVar3.a(ekVar2.a.f, "UCA");
                        ekVar3.a(ekVar2.a());
                        com.xiaomi.push.service.c cVar6 = ahVar.a;
                        cVar6.a(new com.xiaomi.push.service.aw(cVar6, ekVar3), 0L);
                        return;
                    }
                    if (android.text.TextUtils.equals("P", ekVar2.a.h)) {
                        com.xiaomi.push.cx.i iVar = (com.xiaomi.push.cx.i) new com.xiaomi.push.cx.i().b(ekVar2.c());
                        com.xiaomi.push.ek ekVar4 = new com.xiaomi.push.ek();
                        ekVar4.a(0);
                        ekVar4.a(ekVar2.a.f, "PCA");
                        ekVar4.a(ekVar2.a());
                        com.xiaomi.push.cx.i iVar2 = new com.xiaomi.push.cx.i();
                        if (iVar.a) {
                            iVar2.a(iVar.b);
                        }
                        ekVar4.a(iVar2.c(), (java.lang.String) null);
                        com.xiaomi.push.service.c cVar7 = ahVar.a;
                        cVar7.a(new com.xiaomi.push.service.aw(cVar7, ekVar4), 0L);
                        com.xiaomi.channel.commonutils.logger.b.a("ACK msgP: id = " + ekVar2.a());
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                r1 = ekVar;
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "receive a message.";
        }
    }

    public class e extends com.xiaomi.push.service.c.j {
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            if (com.xiaomi.push.service.c.this.a() && com.xiaomi.push.service.c.b(com.xiaomi.push.service.c.this.getApplicationContext())) {
                com.xiaomi.push.service.c.j(com.xiaomi.push.service.c.this);
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "do reconnect..";
        }
    }

    public class f extends android.content.BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.a("network changed, " + com.xiaomi.push.iu.a(intent));
            com.xiaomi.push.service.c.this.onStart(intent, 1);
        }
    }

    public class g extends com.xiaomi.push.service.c.j {
        public int a;
        public java.lang.Exception b;

        public g(int i) {
            super(2);
            this.a = i;
            this.b = null;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            com.xiaomi.push.service.c.this.a(this.a, this.b);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "disconnect the connection.";
        }
    }

    public class h extends com.xiaomi.push.service.c.j {
        public h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            com.xiaomi.push.service.c.g(com.xiaomi.push.service.c.this);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "Init Job";
        }
    }

    public class i extends com.xiaomi.push.service.c.j {
        android.content.Intent a;

        public i(android.content.Intent intent) {
            super(15);
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            com.xiaomi.push.service.c.a(com.xiaomi.push.service.c.this, this.a);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "Handle intent action = " + this.a.getAction();
        }
    }

    public static abstract class j extends com.xiaomi.push.service.cl.b {
        public j(int i) {
            super(i);
        }

        public abstract void a();

        public abstract java.lang.String b();

        @Override // java.lang.Runnable
        public void run() {
            int i = this.f;
            if (i != 4 && i != 8) {
                com.xiaomi.channel.commonutils.logger.b.a(com.xiaomi.channel.commonutils.logger.a.a, b());
            }
            a();
        }
    }

    public class k extends android.content.BroadcastReceiver {
        public k() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.a("[HB] hold short heartbeat, " + com.xiaomi.push.iu.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            com.xiaomi.push.service.c.this.onStart(intent, 1);
        }
    }

    public class l extends com.xiaomi.push.service.c.j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            com.xiaomi.push.service.cl clVar = com.xiaomi.push.service.c.this.e;
            com.xiaomi.channel.commonutils.logger.b.a("quit. finalizer:" + clVar.b);
            clVar.a.a();
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "ask the job queue to quit";
        }
    }

    public class m extends com.xiaomi.push.service.c.j {
        private com.xiaomi.push.fn b;

        public m(com.xiaomi.push.fn fnVar) {
            super(8);
            this.b = fnVar;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            java.lang.String str;
            com.xiaomi.push.service.aj.b b;
            com.xiaomi.push.service.ah ahVar = com.xiaomi.push.service.c.this.u;
            com.xiaomi.push.fn fnVar = this.b;
            if (!"5".equals(fnVar.t)) {
                java.lang.String str2 = fnVar.r;
                java.lang.String str3 = fnVar.t;
                if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str3) && (b = com.xiaomi.push.service.aj.a().b(str3, str2)) != null) {
                    com.xiaomi.push.gc.a(ahVar.a, b.a, com.xiaomi.push.gc.a(fnVar.b()), true, true, java.lang.System.currentTimeMillis());
                }
            }
            java.lang.String str4 = fnVar.t;
            if (android.text.TextUtils.isEmpty(str4)) {
                str4 = "1";
                fnVar.t = "1";
            }
            if (str4.equals("0")) {
                com.xiaomi.channel.commonutils.logger.b.a("Received wrong packet with chid = 0 : " + fnVar.b());
            }
            boolean z = fnVar instanceof com.xiaomi.push.fl;
            if (z) {
                com.xiaomi.push.fk a = fnVar.a("kick");
                if (a != null) {
                    java.lang.String str5 = fnVar.r;
                    java.lang.String a2 = a.a("type");
                    java.lang.String a3 = a.a("reason");
                    com.xiaomi.channel.commonutils.logger.b.a("kicked by server, chid=" + str4 + " res=" + com.xiaomi.push.service.aj.b.a(str5) + " type=" + a2 + " reason=" + a3);
                    if (!"wait".equals(a2)) {
                        ahVar.a.a(str4, str5, 3, a3, a2);
                        com.xiaomi.push.service.aj.a().a(str4, str5);
                        return;
                    }
                    com.xiaomi.push.service.aj.b b2 = com.xiaomi.push.service.aj.a().b(str4, str5);
                    if (b2 != null) {
                        ahVar.a.a(b2);
                        b2.a(com.xiaomi.push.service.aj.c.unbind, 3, 0, a3, a2);
                        return;
                    }
                    return;
                }
            } else if (fnVar instanceof com.xiaomi.push.fm) {
                com.xiaomi.push.fm fmVar = (com.xiaomi.push.fm) fnVar;
                if ("redir".equals(fmVar.a)) {
                    com.xiaomi.push.fk a4 = fmVar.a("hosts");
                    if (a4 != null) {
                        java.lang.String a5 = a4.a();
                        if (android.text.TextUtils.isEmpty(a5)) {
                            return;
                        }
                        java.lang.String[] split = a5.split(com.alipay.sdk.m.u.i.b);
                        com.xiaomi.push.br a6 = com.xiaomi.push.bv.a().a(com.xiaomi.push.ew.a(), false);
                        if (a6 == null || split.length <= 0) {
                            return;
                        }
                        a6.a(split);
                        ahVar.a.a(20, (java.lang.Exception) null);
                        ahVar.a.b(true);
                        return;
                    }
                    return;
                }
            }
            com.xiaomi.push.service.c cVar = ahVar.a;
            com.xiaomi.push.service.aj.b a7 = com.xiaomi.push.service.cf.a(fnVar);
            if (a7 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str4 + " not registered");
                return;
            }
            if ("5".equalsIgnoreCase(str4)) {
                if (!(fnVar instanceof com.xiaomi.push.fm)) {
                    com.xiaomi.channel.commonutils.logger.b.a("not a mipush message");
                    return;
                }
                com.xiaomi.push.fm fmVar2 = (com.xiaomi.push.fm) fnVar;
                com.xiaomi.push.fk a8 = fmVar2.a("s");
                if (a8 != null) {
                    try {
                        com.xiaomi.push.service.ct.a(cVar, com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(a7.i, fmVar2.d()), a8.a()), com.xiaomi.push.gc.a(fnVar.b()));
                        return;
                    } catch (java.lang.IllegalArgumentException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return;
                    }
                }
                return;
            }
            java.lang.String str6 = a7.a;
            if (fnVar instanceof com.xiaomi.push.fm) {
                str = "com.xiaomi.push.new_msg";
            } else if (z) {
                str = "com.xiaomi.push.new_iq";
            } else {
                if (!(fnVar instanceof com.xiaomi.push.fp)) {
                    com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                    return;
                }
                str = "com.xiaomi.push.new_pres";
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setAction(str);
            intent.setPackage(str6);
            intent.putExtra("ext_chid", str4);
            intent.putExtra("ext_packet", fnVar.a());
            intent.putExtra(com.xiaomi.push.service.an.F, a7.j);
            intent.putExtra(com.xiaomi.push.service.an.x, a7.i);
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("[Bcst] notify packet arrival. %s,%s,%s", a7.h, a7.a, fnVar.d()));
            com.xiaomi.push.service.cf.a(cVar, intent, a7);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "receive a message.";
        }
    }

    public interface n {
        void a();
    }

    public class o extends com.xiaomi.push.service.c.j {
        boolean a;

        public o(boolean z) {
            super(4);
            this.a = z;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            if (com.xiaomi.push.service.c.this.b()) {
                try {
                    if (!this.a) {
                        com.xiaomi.push.ej.a();
                    }
                    com.xiaomi.push.service.c.this.c.b(this.a);
                } catch (com.xiaomi.push.fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.service.c.this.a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "send ping..";
        }
    }

    public class p extends com.xiaomi.push.service.c.j {
        com.xiaomi.push.service.aj.b a;

        public p(com.xiaomi.push.service.aj.b bVar) {
            super(4);
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            try {
                this.a.a(com.xiaomi.push.service.aj.c.unbind, 1, 16, null, null);
                com.xiaomi.push.ev evVar = com.xiaomi.push.service.c.this.c;
                com.xiaomi.push.service.aj.b bVar = this.a;
                evVar.a(bVar.h, bVar.b);
                com.xiaomi.push.service.c cVar = com.xiaomi.push.service.c.this;
                cVar.a(cVar.new b(this.a), 300L);
            } catch (com.xiaomi.push.fh e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                com.xiaomi.push.service.c.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "rebind the client. " + this.a.h;
        }
    }

    public class q extends com.xiaomi.push.service.c.j {
        public q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            com.xiaomi.push.service.c.this.a(11, (java.lang.Exception) null);
            if (com.xiaomi.push.service.c.this.a() && com.xiaomi.push.service.c.b(com.xiaomi.push.service.c.this.getApplicationContext())) {
                com.xiaomi.push.service.c.j(com.xiaomi.push.service.c.this);
            }
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "reset the connection.";
        }
    }

    public class r extends android.content.BroadcastReceiver {
        public r() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.xiaomi.push.service.c.this.onStart(intent, 1);
        }
    }

    public class s extends com.xiaomi.push.service.c.j {
        com.xiaomi.push.service.aj.b a;
        int b;
        java.lang.String c;
        java.lang.String d;

        public s(com.xiaomi.push.service.aj.b bVar, int i, java.lang.String str, java.lang.String str2) {
            super(9);
            this.a = bVar;
            this.b = i;
            this.c = str;
            this.d = str2;
        }

        @Override // com.xiaomi.push.service.c.j
        public final void a() {
            if (this.a.m != com.xiaomi.push.service.aj.c.unbind && com.xiaomi.push.service.c.this.c != null) {
                try {
                    com.xiaomi.push.ev evVar = com.xiaomi.push.service.c.this.c;
                    com.xiaomi.push.service.aj.b bVar = this.a;
                    evVar.a(bVar.h, bVar.b);
                } catch (com.xiaomi.push.fh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    com.xiaomi.push.service.c.this.a(10, e);
                }
            }
            this.a.a(com.xiaomi.push.service.aj.c.unbind, this.b, 0, this.d, this.c);
        }

        @Override // com.xiaomi.push.service.c.j
        public final java.lang.String b() {
            return "unbind the channel. " + this.a.h;
        }
    }

    public class t extends android.content.BroadcastReceiver {
        public t() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            if (!com.xiaomi.push.service.c.this.h) {
                com.xiaomi.push.service.c.k(com.xiaomi.push.service.c.this);
            }
            com.xiaomi.channel.commonutils.logger.b.a("[HB] wifi changed, " + com.xiaomi.push.iu.a(intent));
            com.xiaomi.push.service.c.this.onStart(intent, 1);
        }
    }

    private com.xiaomi.push.fn a(com.xiaomi.push.fn fnVar, java.lang.String str, java.lang.String str2) {
        java.lang.String valueOf;
        java.lang.String str3;
        com.xiaomi.push.service.aj a2 = com.xiaomi.push.service.aj.a();
        java.util.List<java.lang.String> b2 = a2.b(str);
        if (b2.isEmpty()) {
            valueOf = java.lang.String.valueOf(str);
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            fnVar.u = str;
            java.lang.String str4 = fnVar.t;
            if (android.text.TextUtils.isEmpty(str4)) {
                str4 = b2.get(0);
                fnVar.t = str4;
            }
            com.xiaomi.push.service.aj.b b3 = a2.b(str4, fnVar.f466s);
            if (!b()) {
                valueOf = java.lang.String.valueOf(str4);
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (b3 == null || b3.m != com.xiaomi.push.service.aj.c.binded) {
                valueOf = java.lang.String.valueOf(str4);
                str3 = "drop a packet as the channel is not opened, chid=";
            } else {
                if (android.text.TextUtils.equals(str2, b3.j)) {
                    return fnVar;
                }
                valueOf = java.lang.String.valueOf(str2);
                str3 = "invalid session. ";
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(str3.concat(valueOf));
        return null;
    }

    private void a(android.content.BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (java.lang.IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.xiaomi.push.service.an.B);
        java.lang.String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.an.F);
        android.os.Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        com.xiaomi.push.fm[] fmVarArr = new com.xiaomi.push.fm[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            com.xiaomi.push.fm fmVar = new com.xiaomi.push.fm((android.os.Bundle) parcelableArrayExtra[i2]);
            fmVarArr[i2] = fmVar;
            com.xiaomi.push.fm fmVar2 = (com.xiaomi.push.fm) a(fmVar, stringExtra, stringExtra2);
            fmVarArr[i2] = fmVar2;
            if (fmVar2 == null) {
                return;
            }
        }
        com.xiaomi.push.service.aj a2 = com.xiaomi.push.service.aj.a();
        com.xiaomi.push.ek[] ekVarArr = new com.xiaomi.push.ek[length];
        for (int i3 = 0; i3 < length; i3++) {
            com.xiaomi.push.fm fmVar3 = fmVarArr[i3];
            ekVarArr[i3] = com.xiaomi.push.ek.a(fmVar3, a2.b(fmVar3.t, fmVar3.f466s).i);
        }
        b(new com.xiaomi.push.service.bd(this, ekVarArr));
    }

    private void a(com.xiaomi.push.service.c.n nVar) {
        synchronized (this.g) {
            this.g.add(nVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:218:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.xiaomi.push.service.c cVar, android.content.Intent intent) {
        boolean z;
        int i2;
        int i3;
        java.lang.String b2;
        android.content.SharedPreferences sharedPreferences;
        com.xiaomi.push.service.aj a2 = com.xiaomi.push.service.aj.a();
        java.lang.String str = null;
        android.net.NetworkInfo networkInfo = null;
        r4 = null;
        com.xiaomi.push.ek ekVar = null;
        r4 = null;
        com.xiaomi.push.service.aj.b b3 = null;
        str = null;
        boolean z2 = true;
        int i4 = 0;
        if (com.xiaomi.push.service.an.d.equalsIgnoreCase(intent.getAction()) || com.xiaomi.push.service.an.j.equalsIgnoreCase(intent.getAction())) {
            java.lang.String stringExtra = intent.getStringExtra(com.xiaomi.push.service.an.t);
            if (android.text.TextUtils.isEmpty(intent.getStringExtra(com.xiaomi.push.service.an.x))) {
                com.xiaomi.channel.commonutils.logger.b.a("security is empty. ignore.");
                return;
            }
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                com.xiaomi.channel.commonutils.logger.b.d("channel id is empty, do nothing!");
                return;
            }
            com.xiaomi.push.service.aj.b b4 = com.xiaomi.push.service.aj.a().b(stringExtra, intent.getStringExtra(com.xiaomi.push.service.an.q));
            if (b4 == null || stringExtra == null) {
                z = false;
            } else {
                java.lang.String stringExtra2 = intent.getStringExtra(com.xiaomi.push.service.an.F);
                java.lang.String stringExtra3 = intent.getStringExtra(com.xiaomi.push.service.an.x);
                if (android.text.TextUtils.isEmpty(b4.j) || android.text.TextUtils.equals(stringExtra2, b4.j)) {
                    z = false;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("session changed. old session=" + b4.j + ", new session=" + stringExtra2 + " chid = " + stringExtra);
                    z = true;
                }
                if (!stringExtra3.equals(b4.i)) {
                    com.xiaomi.channel.commonutils.logger.b.a("security changed. chid = " + stringExtra + " sechash = " + com.xiaomi.push.an.a(stringExtra3));
                    z = true;
                }
            }
            com.xiaomi.push.service.aj.b b5 = com.xiaomi.push.service.aj.a().b(stringExtra, intent.getStringExtra(com.xiaomi.push.service.an.q));
            if (b5 == null) {
                b5 = new com.xiaomi.push.service.aj.b(cVar);
            }
            b5.h = intent.getStringExtra(com.xiaomi.push.service.an.t);
            b5.b = intent.getStringExtra(com.xiaomi.push.service.an.q);
            b5.c = intent.getStringExtra(com.xiaomi.push.service.an.v);
            b5.a = intent.getStringExtra(com.xiaomi.push.service.an.B);
            b5.f = intent.getStringExtra(com.xiaomi.push.service.an.z);
            b5.g = intent.getStringExtra(com.xiaomi.push.service.an.A);
            b5.e = intent.getBooleanExtra(com.xiaomi.push.service.an.y, false);
            b5.i = intent.getStringExtra(com.xiaomi.push.service.an.x);
            b5.j = intent.getStringExtra(com.xiaomi.push.service.an.F);
            b5.d = intent.getStringExtra(com.xiaomi.push.service.an.w);
            b5.k = cVar.d;
            b5.a((android.os.Messenger) intent.getParcelableExtra(com.xiaomi.push.service.an.J));
            b5.l = cVar.getApplicationContext();
            com.xiaomi.push.service.aj.a().a(b5);
            if (!com.xiaomi.push.ai.b(cVar)) {
                com.xiaomi.push.service.cf.a(cVar, b5, false, 2, null);
                return;
            }
            if (!cVar.b()) {
                cVar.b(true);
                return;
            }
            com.xiaomi.push.service.aj.c cVar2 = b5.m;
            if (cVar2 == com.xiaomi.push.service.aj.c.unbind) {
                cVar.b(cVar.new b(b5));
                return;
            }
            if (z) {
                cVar.b(cVar.new p(b5));
                return;
            } else if (cVar2 == com.xiaomi.push.service.aj.c.binding) {
                com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("the client is binding. %1$s %2$s.", b5.h, com.xiaomi.push.service.aj.b.a(b5.b)));
                return;
            } else {
                if (cVar2 == com.xiaomi.push.service.aj.c.binded) {
                    com.xiaomi.push.service.cf.a(cVar, b5, true, 0, null);
                    return;
                }
                return;
            }
        }
        if (com.xiaomi.push.service.an.i.equalsIgnoreCase(intent.getAction())) {
            java.lang.String stringExtra4 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            java.lang.String stringExtra5 = intent.getStringExtra(com.xiaomi.push.service.an.t);
            java.lang.String stringExtra6 = intent.getStringExtra(com.xiaomi.push.service.an.q);
            com.xiaomi.channel.commonutils.logger.b.a("Service called close channel chid = " + stringExtra5 + " res = " + com.xiaomi.push.service.aj.b.a(stringExtra6));
            if (android.text.TextUtils.isEmpty(stringExtra5)) {
                java.util.Iterator<java.lang.String> it = a2.b(stringExtra4).iterator();
                while (it.hasNext()) {
                    cVar.a(it.next(), 2);
                }
                return;
            } else if (android.text.TextUtils.isEmpty(stringExtra6)) {
                cVar.a(stringExtra5, 2);
                return;
            } else {
                cVar.a(stringExtra5, stringExtra6, 2, null, null);
                return;
            }
        }
        long j2 = 0;
        if (com.xiaomi.push.service.an.e.equalsIgnoreCase(intent.getAction())) {
            if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(intent.getStringExtra("ext_chid"))) {
                intent.putExtra("run", java.lang.System.currentTimeMillis());
            }
            java.lang.String stringExtra7 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            java.lang.String stringExtra8 = intent.getStringExtra(com.xiaomi.push.service.an.F);
            android.os.Bundle bundleExtra = intent.getBundleExtra("ext_packet");
            com.xiaomi.push.service.aj a3 = com.xiaomi.push.service.aj.a();
            if (bundleExtra != null) {
                com.xiaomi.push.fm fmVar = (com.xiaomi.push.fm) cVar.a(new com.xiaomi.push.fm(bundleExtra), stringExtra7, stringExtra8);
                if (fmVar == null) {
                    return;
                } else {
                    ekVar = com.xiaomi.push.ek.a(fmVar, a3.b(fmVar.t, fmVar.f466s).i);
                }
            } else {
                byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
                if (byteArrayExtra != null) {
                    try {
                        j2 = java.lang.Long.parseLong(intent.getStringExtra(com.xiaomi.push.service.an.q));
                    } catch (java.lang.NumberFormatException unused) {
                    }
                    java.lang.String stringExtra9 = intent.getStringExtra(com.xiaomi.push.service.an.r);
                    java.lang.String stringExtra10 = intent.getStringExtra(com.xiaomi.push.service.an.f488s);
                    java.lang.String stringExtra11 = intent.getStringExtra("ext_chid");
                    com.xiaomi.push.service.aj.b b6 = a3.b(stringExtra11, java.lang.String.valueOf(j2));
                    if (b6 != null) {
                        com.xiaomi.push.ek ekVar2 = new com.xiaomi.push.ek();
                        if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(stringExtra11)) {
                            ekVar2.b(java.lang.Integer.parseInt(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ));
                            ekVar2.e.c = intent.getBooleanExtra(com.umeng.ccg.a.f, true);
                            ekVar2.e.d = intent.getBooleanExtra(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI, true);
                            ekVar2.e.e = intent.getLongExtra("rx_msg", -1L);
                            ekVar2.e.f = intent.getLongExtra("enqueue", -1L);
                            ekVar2.e.b = intent.getIntExtra("num", -1);
                            ekVar2.e.g = intent.getLongExtra("run", -1L);
                        }
                        try {
                            ekVar2.a(java.lang.Integer.parseInt(stringExtra11));
                        } catch (java.lang.NumberFormatException unused2) {
                        }
                        ekVar2.a("SECMSG", (java.lang.String) null);
                        if (android.text.TextUtils.isEmpty(stringExtra9)) {
                            stringExtra9 = "xiaomi.com";
                        }
                        ekVar2.a(j2, stringExtra9, stringExtra10);
                        ekVar2.a(intent.getStringExtra("ext_pkt_id"));
                        ekVar2.a(byteArrayExtra, b6.i);
                        com.xiaomi.channel.commonutils.logger.b.a("send a message: chid=" + stringExtra11 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                        ekVar = ekVar2;
                    }
                }
            }
            if (ekVar != null) {
                cVar.b(new com.xiaomi.push.service.aw(cVar, ekVar));
                return;
            }
            return;
        }
        if (com.xiaomi.push.service.an.g.equalsIgnoreCase(intent.getAction())) {
            cVar.a(intent);
            return;
        }
        if (com.xiaomi.push.service.an.f.equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.push.fn a4 = cVar.a(new com.xiaomi.push.fl(intent.getBundleExtra("ext_packet")), intent.getStringExtra(com.xiaomi.push.service.an.B), intent.getStringExtra(com.xiaomi.push.service.an.F));
            if (a4 != null) {
                cVar.b(new com.xiaomi.push.service.aw(cVar, com.xiaomi.push.ek.a(a4, a2.b(a4.t, a4.f466s).i)));
                return;
            }
            return;
        }
        if (com.xiaomi.push.service.an.h.equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.push.fn a5 = cVar.a(new com.xiaomi.push.fp(intent.getBundleExtra("ext_packet")), intent.getStringExtra(com.xiaomi.push.service.an.B), intent.getStringExtra(com.xiaomi.push.service.an.F));
            if (a5 != null) {
                cVar.b(new com.xiaomi.push.service.aw(cVar, com.xiaomi.push.ek.a(a5, a2.b(a5.t, a5.f466s).i)));
                return;
            }
            return;
        }
        if (com.xiaomi.push.service.an.k.equals(intent.getAction())) {
            java.lang.String stringExtra12 = intent.getStringExtra(com.xiaomi.push.service.an.t);
            java.lang.String stringExtra13 = intent.getStringExtra(com.xiaomi.push.service.an.q);
            if (stringExtra12 != null) {
                com.xiaomi.channel.commonutils.logger.b.a("request reset connection from chid = ".concat(stringExtra12));
                com.xiaomi.push.service.aj.b b7 = com.xiaomi.push.service.aj.a().b(stringExtra12, stringExtra13);
                if (b7 != null && b7.i.equals(intent.getStringExtra(com.xiaomi.push.service.an.x)) && b7.m == com.xiaomi.push.service.aj.c.binded) {
                    com.xiaomi.push.ev evVar = cVar.c;
                    if (evVar == null || !evVar.a(android.os.SystemClock.elapsedRealtime() - 15000)) {
                        cVar.b(cVar.new q());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (com.xiaomi.push.service.an.l.equals(intent.getAction())) {
            java.lang.String stringExtra14 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            java.util.List<java.lang.String> b8 = a2.b(stringExtra14);
            if (b8.isEmpty()) {
                com.xiaomi.channel.commonutils.logger.b.a("open channel should be called first before update info, pkg=".concat(java.lang.String.valueOf(stringExtra14)));
                return;
            }
            java.lang.String stringExtra15 = intent.getStringExtra(com.xiaomi.push.service.an.t);
            java.lang.String stringExtra16 = intent.getStringExtra(com.xiaomi.push.service.an.q);
            if (android.text.TextUtils.isEmpty(stringExtra15)) {
                stringExtra15 = b8.get(0);
            }
            if (android.text.TextUtils.isEmpty(stringExtra16)) {
                java.util.Collection<com.xiaomi.push.service.aj.b> c = a2.c(stringExtra15);
                if (c != null && !c.isEmpty()) {
                    b3 = c.iterator().next();
                }
            } else {
                b3 = a2.b(stringExtra15, stringExtra16);
            }
            if (b3 != null) {
                if (intent.hasExtra(com.xiaomi.push.service.an.z)) {
                    b3.f = intent.getStringExtra(com.xiaomi.push.service.an.z);
                }
                if (intent.hasExtra(com.xiaomi.push.service.an.A)) {
                    b3.g = intent.getStringExtra(com.xiaomi.push.service.an.A);
                    return;
                }
                return;
            }
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && cVar.m() && com.xiaomi.push.du.b()) {
                    com.xiaomi.channel.commonutils.logger.b.a("enter falldown mode, stop alarm.");
                    com.xiaomi.push.du.a();
                    return;
                }
                return;
            }
            if (cVar.m()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("exit falldown mode, activate alarm.");
            cVar.k();
            if (cVar.b() || cVar.l()) {
                return;
            }
            cVar.b(true);
            return;
        }
        if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            com.xiaomi.push.service.aq.a(cVar.getApplicationContext());
            java.lang.String str2 = com.xiaomi.push.f.a;
            if ((str2.contains("xmsf") || str2.contains(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || str2.contains("miui")) && com.xiaomi.push.service.aq.a(cVar.getApplicationContext()).a() == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            java.lang.String stringExtra17 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            int intExtra = intent.getIntExtra("mipush_env_type", 1);
            com.xiaomi.push.service.cq a6 = com.xiaomi.push.service.cq.a(cVar);
            synchronized (a6.b) {
                if (a6.b.contains(stringExtra17)) {
                    a6.b.remove(stringExtra17);
                    a6.a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ao.a(a6.b, ",")).commit();
                }
            }
            if (!booleanExtra || "com.xiaomi.xmsf".equals(cVar.getPackageName())) {
                cVar.a(byteArrayExtra2, stringExtra17);
                return;
            } else {
                cVar.b(new com.xiaomi.push.service.by(cVar, intExtra, stringExtra17, byteArrayExtra2));
                return;
            }
        }
        if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            java.lang.String stringExtra18 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if (com.xiaomi.push.service.ci.a(byteArrayExtra3, stringExtra18)) {
                com.xiaomi.channel.commonutils.logger.b.a("duplicate msg from: " + java.lang.String.valueOf(stringExtra18));
                return;
            }
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                com.xiaomi.push.service.cq a7 = com.xiaomi.push.service.cq.a(cVar);
                synchronized (a7.b) {
                    if (!a7.b.contains(stringExtra18)) {
                        a7.b.add(stringExtra18);
                        a7.a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ao.a(a7.b, ",")).commit();
                    }
                }
                if (com.xiaomi.push.iu.a(cVar.getApplicationContext())) {
                    com.xiaomi.push.service.k.a(stringExtra18);
                }
            }
            cVar.a(stringExtra18, byteArrayExtra3, booleanExtra2);
            return;
        }
        if (com.xiaomi.push.service.ar.a.equals(intent.getAction())) {
            java.lang.String stringExtra19 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra19 == null || android.text.TextUtils.isEmpty(stringExtra19.trim())) {
                return;
            }
            try {
                android.content.pm.PackageInfo packageInfo = cVar.getPackageManager().getPackageInfo(stringExtra19, 0);
                if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.ib.a(cVar, packageInfo.packageName)) {
                    z2 = false;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.a("dual space's app uninstalled ".concat(stringExtra19));
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused3) {
            }
            if ("com.xiaomi.channel".equals(stringExtra19) && !com.xiaomi.push.service.aj.a().c("1").isEmpty() && z2) {
                cVar.a("1", 0);
                com.xiaomi.channel.commonutils.logger.b.a("close the miliao channel as the app is uninstalled.");
                return;
            }
            android.content.SharedPreferences sharedPreferences2 = cVar.getSharedPreferences("pref_registered_pkg_names", 0);
            java.lang.String string = sharedPreferences2.getString(stringExtra19, null);
            if (android.text.TextUtils.isEmpty(string) || !z2) {
                return;
            }
            android.content.SharedPreferences.Editor edit = sharedPreferences2.edit();
            edit.remove(stringExtra19);
            edit.commit();
            if (com.xiaomi.push.service.p.e(cVar, stringExtra19)) {
                com.xiaomi.push.service.p.d(cVar, stringExtra19);
            }
            com.xiaomi.push.service.p.b(cVar, stringExtra19);
            com.xiaomi.push.service.x.a(cVar.getApplicationContext(), stringExtra19);
            if (!cVar.b() || string == null) {
                return;
            }
            try {
                com.xiaomi.push.service.l.a(cVar, com.xiaomi.push.service.l.a(stringExtra19, string));
                com.xiaomi.channel.commonutils.logger.b.a("uninstall " + stringExtra19 + " msg sent");
                return;
            } catch (com.xiaomi.push.fh e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e2.getMessage());
                cVar.a(10, e2);
                return;
            }
        }
        if (com.xiaomi.push.service.ar.b.equals(intent.getAction())) {
            java.lang.String stringExtra20 = intent.getStringExtra("data_cleared_pkg_name");
            if (android.text.TextUtils.isEmpty(stringExtra20)) {
                return;
            }
            try {
                sharedPreferences = cVar.getSharedPreferences("pref_registered_pkg_names", 0);
                if (sharedPreferences != null) {
                    try {
                        str = sharedPreferences.getString(stringExtra20, null);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        com.xiaomi.channel.commonutils.logger.b.a("Fail to get sp or appId : ".concat(java.lang.String.valueOf(th)));
                        if (!android.text.TextUtils.isEmpty(str)) {
                        }
                        com.xiaomi.push.service.x.a(cVar, stringExtra20);
                        if (com.xiaomi.push.iu.a(cVar.getApplicationContext())) {
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                sharedPreferences = null;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                android.content.SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.remove(stringExtra20);
                edit2.commit();
                if (com.xiaomi.push.service.p.e(cVar, stringExtra20)) {
                    com.xiaomi.push.service.p.d(cVar, stringExtra20);
                }
                com.xiaomi.push.service.p.b(cVar, stringExtra20);
                com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
                hkVar.d = str;
                hkVar.e = com.xiaomi.push.gu.AppDataCleared.ah;
                hkVar.c = com.xiaomi.push.service.ag.a();
                hkVar.a(false);
                cVar.a(stringExtra20, com.xiaomi.push.hv.a(com.xiaomi.push.service.l.a(stringExtra20, str, hkVar, com.xiaomi.push.gk.Notification)), true);
            }
            com.xiaomi.push.service.x.a(cVar, stringExtra20);
            if (com.xiaomi.push.iu.a(cVar.getApplicationContext())) {
                return;
            }
            com.xiaomi.push.service.k.a(stringExtra20);
            return;
        }
        if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            java.lang.String stringExtra21 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            int intExtra2 = intent.getIntExtra(com.xiaomi.push.service.an.C, -2);
            if (android.text.TextUtils.isEmpty(stringExtra21)) {
                return;
            }
            if (intExtra2 >= -1) {
                com.xiaomi.push.service.p.a(cVar, stringExtra21, intExtra2, intent.getIntExtra(com.xiaomi.push.service.an.D, -1));
                return;
            } else {
                com.xiaomi.push.service.p.a(cVar, stringExtra21, intent.getStringExtra(com.xiaomi.push.service.an.H), intent.getStringExtra(com.xiaomi.push.service.an.I));
                return;
            }
        }
        if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
            java.lang.String stringExtra22 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            if (android.text.TextUtils.isEmpty(stringExtra22)) {
                return;
            }
            com.xiaomi.push.service.p.c(cVar, stringExtra22);
            return;
        }
        if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            java.lang.String stringExtra23 = intent.getStringExtra(com.xiaomi.push.service.an.B);
            java.lang.String stringExtra24 = intent.getStringExtra(com.xiaomi.push.service.an.G);
            if (intent.hasExtra(com.xiaomi.push.service.an.E)) {
                int intExtra3 = intent.getIntExtra(com.xiaomi.push.service.an.E, 0);
                b2 = com.xiaomi.push.an.b(stringExtra23 + intExtra3);
                i4 = intExtra3;
                z2 = false;
            } else {
                b2 = com.xiaomi.push.an.b(stringExtra23);
            }
            if (android.text.TextUtils.isEmpty(stringExtra23) || !android.text.TextUtils.equals(stringExtra24, b2)) {
                com.xiaomi.channel.commonutils.logger.b.d("invalid notification for ".concat(java.lang.String.valueOf(stringExtra23)));
                return;
            } else if (z2) {
                com.xiaomi.push.service.p.d(cVar, stringExtra23);
                return;
            } else {
                com.xiaomi.push.service.p.b(cVar, stringExtra23, i4);
                return;
            }
        }
        if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            java.lang.String stringExtra25 = intent.getStringExtra("mipush_app_package");
            if (!android.text.TextUtils.isEmpty(stringExtra25)) {
                com.xiaomi.push.service.cq a8 = com.xiaomi.push.service.cq.a(cVar);
                synchronized (a8.c) {
                    if (!a8.c.contains(stringExtra25)) {
                        a8.c.add(stringExtra25);
                        a8.a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ao.a(a8.c, ",")).commit();
                    }
                }
            }
            if ("com.xiaomi.xmsf".equals(cVar.getPackageName())) {
                return;
            }
            cVar.a(19, (java.lang.Exception) null);
            cVar.k();
            cVar.stopSelf();
            return;
        }
        if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            java.lang.String stringExtra26 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
            java.lang.String stringExtra27 = intent.getStringExtra("mipush_app_id");
            java.lang.String stringExtra28 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.cq a9 = com.xiaomi.push.service.cq.a(cVar);
                synchronized (a9.d) {
                    if (!a9.d.contains(stringExtra26)) {
                        a9.d.add(stringExtra26);
                        a9.a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ao.a(a9.d, ",")).commit();
                    }
                }
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                com.xiaomi.push.service.cq.a(cVar).d(stringExtra26);
                com.xiaomi.push.service.cq.a(cVar).e(stringExtra26);
            }
            if (byteArrayExtra4 == null) {
                com.xiaomi.push.service.cs.a(cVar, stringExtra26, byteArrayExtra4, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            com.xiaomi.push.service.cs.b(stringExtra26, byteArrayExtra4);
            cVar.a(new com.xiaomi.push.service.cr(cVar, stringExtra26, stringExtra27, stringExtra28, byteArrayExtra4), 0L);
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && cVar.l == null) {
                cVar.l = cVar.new f();
                cVar.registerReceiver(cVar.l, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
                return;
            }
            return;
        }
        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
            java.lang.String stringExtra29 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra5 = intent.getByteArrayExtra("mipush_payload");
            com.xiaomi.push.go goVar = new com.xiaomi.push.go();
            try {
                com.xiaomi.push.hv.a(goVar, byteArrayExtra5);
                com.xiaomi.push.gh.a(cVar).a(goVar, stringExtra29);
                return;
            } catch (com.xiaomi.push.ia e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                return;
            }
        }
        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("[Alarm] Service called on timer");
            if (!cVar.m()) {
                com.xiaomi.push.du.a(false);
                if (cVar.g()) {
                    cVar.a(false);
                }
            } else if (com.xiaomi.push.du.b()) {
                com.xiaomi.channel.commonutils.logger.b.a("enter falldown mode, stop alarm");
                com.xiaomi.push.du.a();
            }
            com.xiaomi.push.service.c.a aVar = cVar.o;
            if (aVar != null) {
                com.xiaomi.push.service.c.a.a(aVar);
                return;
            }
            return;
        }
        if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("Service called on check alive.");
            if (cVar.g()) {
                cVar.a(false);
                return;
            }
            return;
        }
        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
            com.xiaomi.channel.commonutils.logger.b.a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
            com.xiaomi.push.du.a(cVar, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
            return;
        }
        if (com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
            try {
                networkInfo = ((android.net.ConnectivityManager) cVar.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (java.lang.Exception e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            }
            com.xiaomi.push.service.ck.a(cVar.getApplicationContext()).a(networkInfo);
            if (networkInfo != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("network changed,");
                sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + networkInfo.getDetailedState());
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                android.net.NetworkInfo.State state = networkInfo.getState();
                if (state == android.net.NetworkInfo.State.SUSPENDED || state == android.net.NetworkInfo.State.UNKNOWN) {
                    return;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
            }
            if (com.xiaomi.push.eh.a() != null) {
                com.xiaomi.push.eh.a().a();
            }
            com.xiaomi.push.gc.a(cVar);
            com.xiaomi.push.er erVar = cVar.t;
            synchronized (erVar.f) {
                erVar.f.clear();
            }
            if (com.xiaomi.push.ai.a(cVar)) {
                if (cVar.b() && cVar.g()) {
                    cVar.a(false);
                }
                if (!cVar.b() && !cVar.l()) {
                    cVar.e.a(1);
                    cVar.a(cVar.new e(), 0L);
                }
                com.xiaomi.push.cg.a(cVar).a();
            } else {
                cVar.a(cVar.new g(2), 0L);
            }
            cVar.k();
            return;
        }
        if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
            android.os.Bundle extras = intent.getExtras();
            if (extras != null) {
                com.xiaomi.push.service.ck.a(cVar.getApplicationContext()).a(extras.getString("digest"));
                return;
            }
            return;
        }
        if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
            if (intent.getExtras() == null || (i3 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i3 > 604800) {
                return;
            }
            com.xiaomi.push.service.ck.a(cVar.getApplicationContext()).a.edit().putLong("keep_short_hb_effective_time", java.lang.System.currentTimeMillis() + (i3 * 1000)).apply();
            return;
        }
        if ("action_cr_config".equals(intent.getAction())) {
            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
            long longExtra = intent.getLongExtra("action_cr_event_frequency", com.anythink.expressad.d.a.b.aT);
            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", com.anythink.expressad.d.a.b.aT);
            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
            com.xiaomi.a.a.a.C0531a b9 = new com.xiaomi.a.a.a.C0531a().b(booleanExtra3);
            b9.f = longExtra;
            com.xiaomi.a.a.a.C0531a c2 = b9.c(booleanExtra4);
            c2.g = longExtra2;
            c2.d = com.xiaomi.push.as.a(cVar.getApplicationContext());
            com.xiaomi.a.a.a.C0531a a10 = c2.a(booleanExtra5);
            a10.e = longExtra3;
            com.xiaomi.a.a.a a11 = a10.a(cVar.getApplicationContext());
            if ("com.xiaomi.xmsf".equals(cVar.getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                return;
            }
            com.xiaomi.push.Cdo.a(cVar.getApplicationContext(), a11);
            return;
        }
        if ("action_help_ping".equals(intent.getAction())) {
            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
            int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
            if (intExtra4 >= 0 && intExtra4 < 30) {
                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                intExtra4 = 30;
            }
            if (intExtra4 < 0) {
                booleanExtra6 = false;
            }
            com.xiaomi.channel.commonutils.logger.b.a("aw_ping: receive a aw_ping message. switch: " + booleanExtra6 + " frequency: " + intExtra4);
            if (!booleanExtra6 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(cVar.getPackageName())) {
                return;
            }
            byte[] byteArrayExtra6 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra7 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            com.xiaomi.push.hk hkVar2 = new com.xiaomi.push.hk();
            try {
                com.xiaomi.push.hv.a(hkVar2, byteArrayExtra6);
                com.xiaomi.push.m.a(cVar.getApplicationContext()).a(new com.xiaomi.push.service.ac(hkVar2, new java.lang.ref.WeakReference(cVar), booleanExtra7), intExtra4, 0);
                return;
            } catch (com.xiaomi.push.ia unused4) {
                com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
                return;
            }
        }
        if (!"action_aw_app_logic".equals(intent.getAction())) {
            if (com.xiaomi.push.service.an.n.equals(intent.getAction())) {
                android.content.Context applicationContext = cVar.getApplicationContext();
                java.lang.String stringExtra30 = intent.getStringExtra("ext_fcm_container_buffer");
                java.lang.String stringExtra31 = intent.getStringExtra("mipush_app_package");
                if (android.text.TextUtils.isEmpty(stringExtra30) || android.text.TextUtils.isEmpty(stringExtra31)) {
                    return;
                }
                try {
                    byte[] b10 = com.xiaomi.push.service.cj.b(android.util.Base64.decode(stringExtra30, 2), applicationContext.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra31, null));
                    if (b10 != null) {
                        com.xiaomi.push.service.p.a(applicationContext, com.xiaomi.push.service.ct.a(b10), b10);
                        return;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ：dencrypt failed");
                        return;
                    }
                } catch (java.lang.Throwable th3) {
                    com.xiaomi.channel.commonutils.logger.b.a("notify fcm notification error ", th3);
                    return;
                }
            }
            return;
        }
        try {
            com.xiaomi.push.de.a(cVar.getApplicationContext()).e = new com.xiaomi.push.service.ap();
            java.lang.String stringExtra32 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra7 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra7 == null) {
                return;
            }
            com.xiaomi.push.hk hkVar3 = new com.xiaomi.push.hk();
            com.xiaomi.push.hv.a(hkVar3, byteArrayExtra7);
            java.lang.String str3 = hkVar3.d;
            java.util.Map<java.lang.String, java.lang.String> map = hkVar3.h;
            if (map != null) {
                java.lang.String str4 = map.get("extra_help_aw_info");
                java.lang.String str5 = map.get("extra_aw_app_online_cmd");
                if (android.text.TextUtils.isEmpty(str5)) {
                    return;
                }
                try {
                    i2 = java.lang.Integer.parseInt(str5);
                } catch (java.lang.NumberFormatException unused5) {
                    i2 = 0;
                }
                if (android.text.TextUtils.isEmpty(stringExtra32) || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str4)) {
                    return;
                }
                com.xiaomi.push.de a12 = com.xiaomi.push.de.a(cVar.getApplicationContext());
                if (!android.text.TextUtils.isEmpty(str4) && !android.text.TextUtils.isEmpty(stringExtra32) && !android.text.TextUtils.isEmpty(str3)) {
                    a12.d = i2;
                    com.xiaomi.push.m.a(a12.a).a(new com.xiaomi.push.df(a12, str4, cVar, stringExtra32, str3), 0);
                    return;
                }
                com.xiaomi.push.cz.a(cVar, java.lang.String.valueOf(str4), 1008, "A receive a incorrect message");
            }
        } catch (com.xiaomi.push.ia e5) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e5.getMessage());
        }
    }

    private void a(java.lang.String str, int i2) {
        java.util.Collection<com.xiaomi.push.service.aj.b> c = com.xiaomi.push.service.aj.a().c(str);
        if (c != null) {
            for (com.xiaomi.push.service.aj.b bVar : c) {
                if (bVar != null) {
                    a(new com.xiaomi.push.service.c.s(bVar, i2, null, null), 0L);
                }
            }
        }
        com.xiaomi.push.service.aj.a().a(str);
    }

    private void b(com.xiaomi.push.service.c.j jVar) {
        this.e.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(android.content.Context context) {
        try {
            com.xiaomi.push.s.a();
            for (int i2 = 100; i2 > 0; i2--) {
                if (com.xiaomi.push.ai.b(context)) {
                    com.xiaomi.channel.commonutils.logger.b.a("network connectivity ok.");
                    return true;
                }
                try {
                    java.lang.Thread.sleep(100L);
                } catch (java.lang.Exception unused) {
                }
            }
            return false;
        } catch (java.lang.Exception unused2) {
            return true;
        }
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.jc.c()) {
                if (!z) {
                    sendBroadcast(new android.content.Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new android.content.Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (com.xiaomi.push.service.v vVar : (com.xiaomi.push.service.v[]) this.v.toArray(new com.xiaomi.push.service.v[0])) {
                    vVar.a();
                }
            }
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public static boolean c() {
        return p;
    }

    private int[] d() {
        java.lang.String[] split;
        java.lang.String a2 = com.xiaomi.push.service.ad.a(getApplicationContext()).a(com.xiaomi.push.gp.FallDownTimeRange.bw, "");
        if (!android.text.TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
            int[] iArr = new int[2];
            try {
                iArr[0] = java.lang.Integer.valueOf(split[0]).intValue();
                int intValue = java.lang.Integer.valueOf(split[1]).intValue();
                iArr[1] = intValue;
                int i2 = iArr[0];
                if (i2 >= 0 && i2 <= 23 && intValue >= 0 && intValue <= 23 && i2 != intValue) {
                    return iArr;
                }
            } catch (java.lang.NumberFormatException e2) {
                com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: ".concat(java.lang.String.valueOf(e2)));
            }
        }
        return null;
    }

    private static java.lang.String e() {
        java.lang.String a2 = com.xiaomi.push.iu.a("ro.miui.region");
        return android.text.TextUtils.isEmpty(a2) ? com.xiaomi.push.iu.a("ro.product.locale.region") : a2;
    }

    public static /* synthetic */ com.xiaomi.push.ev f(com.xiaomi.push.service.c cVar) {
        cVar.c = null;
        return null;
    }

    private java.lang.String f() {
        java.lang.String e2;
        com.xiaomi.push.s.a();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.lang.Object obj = new java.lang.Object();
        java.lang.String str = null;
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.push.service.aq a2 = com.xiaomi.push.service.aq.a(this);
            java.lang.String str2 = null;
            while (true) {
                if (!android.text.TextUtils.isEmpty(str2) && a2.a() != 0) {
                    e2 = e();
                    break;
                }
                if (android.text.TextUtils.isEmpty(str2)) {
                    str2 = e();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (java.lang.InterruptedException unused) {
                }
                i2++;
            }
        } else {
            e2 = com.xiaomi.push.iu.e();
        }
        if (!android.text.TextUtils.isEmpty(e2)) {
            com.xiaomi.push.service.d.a(getApplicationContext()).a(e2);
            str = com.xiaomi.push.iu.b(e2).name();
        }
        com.xiaomi.channel.commonutils.logger.b.a("wait region :" + str + " cost = " + (android.os.SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    public static /* synthetic */ void g(com.xiaomi.push.service.c cVar) {
        java.lang.String str;
        java.lang.String concat;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        com.xiaomi.push.service.d a2 = com.xiaomi.push.service.d.a(cVar.getApplicationContext());
        java.lang.String a3 = a2.a();
        com.xiaomi.channel.commonutils.logger.b.a("region of cache is ".concat(java.lang.String.valueOf(a3)));
        if (android.text.TextUtils.isEmpty(a3)) {
            a3 = cVar.f();
        } else {
            if (!android.text.TextUtils.isEmpty(a2.b()) || android.text.TextUtils.isEmpty(a2.a())) {
                str = "no need to check country code";
            } else {
                java.lang.String e2 = "com.xiaomi.xmsf".equals(cVar.getPackageName()) ? e() : com.xiaomi.push.iu.e();
                if (android.text.TextUtils.isEmpty(e2)) {
                    str = "check no country code";
                } else {
                    java.lang.String name = com.xiaomi.push.iu.b(e2).name();
                    if (android.text.TextUtils.equals(name, a2.a())) {
                        a2.a(e2);
                        concat = "update country code";
                    } else {
                        concat = "not update country code, because not equals ".concat(java.lang.String.valueOf(name));
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(concat);
                }
            }
            com.xiaomi.channel.commonutils.logger.b.b(str);
        }
        if (android.text.TextUtils.isEmpty(a3)) {
            cVar.k = com.xiaomi.push.iy.China.name();
        } else {
            cVar.k = a3;
            if (!android.text.TextUtils.equals(a3, a2.b)) {
                a2.b = a3;
                com.xiaomi.push.service.d.a(a2.c, a2.b, "mipush_region", "mipush_region.lock", a2.a);
            }
            if (com.xiaomi.push.iy.Global.name().equals(cVar.k)) {
                com.xiaomi.push.ew.a("app.chat.global.xiaomi.net");
            } else {
                if (com.xiaomi.push.iy.Europe.name().equals(cVar.k)) {
                    str4 = "fr.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.iy.Russia.name().equals(cVar.k)) {
                    str4 = "ru.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.iy.India.name().equals(cVar.k)) {
                    str4 = "idmb.app.chat.global.xiaomi.net";
                }
                com.xiaomi.push.ew.a(str4);
            }
        }
        com.xiaomi.push.iy iyVar = com.xiaomi.push.iy.China;
        if (iyVar.name().equals(cVar.k)) {
            com.xiaomi.push.ew.a("cn.app.chat.xiaomi.net");
        }
        if (iyVar.name().equals(cVar.k)) {
            com.xiaomi.push.bv.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            com.xiaomi.push.bv.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            com.xiaomi.push.bv.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            com.xiaomi.push.bv.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            com.xiaomi.push.bv.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            str2 = "resolver.msg.xiaomi.net";
            com.xiaomi.push.bv.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            str3 = "111.202.1.252:443";
        } else {
            com.xiaomi.push.bv.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            str2 = "resolver.msg.global.xiaomi.net";
            com.xiaomi.push.bv.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
            str3 = "161.117.180.178:443";
        }
        com.xiaomi.push.bv.a(str2, str3);
        if (cVar.i()) {
            com.xiaomi.push.service.bw bwVar = new com.xiaomi.push.service.bw(cVar);
            cVar.a(bwVar, 0L);
            com.xiaomi.push.service.cp.b = new com.xiaomi.push.service.bx(cVar, bwVar);
        }
        try {
            if (com.xiaomi.push.jc.c()) {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("com.xiaomi.push.service_started");
                if (com.xiaomi.push.iu.d()) {
                    intent.addFlags(16777216);
                }
                com.xiaomi.channel.commonutils.logger.b.a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
                cVar.sendBroadcast(intent);
            }
        } catch (java.lang.Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.a(e3);
        }
    }

    private boolean g() {
        if (android.os.SystemClock.elapsedRealtime() - this.a < 30000) {
            return false;
        }
        return com.xiaomi.push.ai.c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && android.provider.Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private boolean i() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.cq.a(this).b(getPackageName());
    }

    public static /* synthetic */ void j(com.xiaomi.push.service.c cVar) {
        java.lang.String str;
        com.xiaomi.push.ev evVar = cVar.c;
        if (evVar == null || !evVar.i()) {
            com.xiaomi.push.ev evVar2 = cVar.c;
            if (evVar2 == null || !evVar2.j()) {
                cVar.i.g = com.xiaomi.push.ai.i(cVar);
                try {
                    cVar.t.a(cVar.w, new com.xiaomi.push.service.bp(cVar));
                    cVar.t.n();
                    cVar.c = cVar.t;
                } catch (com.xiaomi.push.fh e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
                    cVar.t.b(3, e2);
                }
                if (cVar.c == null) {
                    com.xiaomi.push.service.aj.a().e();
                    cVar.c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    private boolean j() {
        try {
            java.lang.Class<?> a2 = com.xiaomi.push.jc.a(this, "miui.os.Build");
            java.lang.reflect.Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            java.lang.reflect.Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            java.lang.reflect.Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!a()) {
            com.xiaomi.push.du.a();
        } else {
            if (com.xiaomi.push.du.b()) {
                return;
            }
            com.xiaomi.push.du.a(true);
        }
    }

    public static /* synthetic */ boolean k(com.xiaomi.push.service.c cVar) {
        cVar.h = true;
        return true;
    }

    private boolean l() {
        com.xiaomi.push.ev evVar = this.c;
        return evVar != null && evVar.i();
    }

    private boolean m() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && n() && !com.xiaomi.push.ib.k(this) && !com.xiaomi.push.ib.j(getApplicationContext());
    }

    private boolean n() {
        int intValue = java.lang.Integer.valueOf(java.lang.String.format("%tH", new java.util.Date())).intValue();
        int i2 = this.r;
        int i3 = this.f489s;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    public final void a(int i2) {
        this.e.a(i2);
    }

    public final void a(int i2, java.lang.Exception exc) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        com.xiaomi.push.ev evVar = this.c;
        sb.append(evVar == null ? null : java.lang.Integer.valueOf(evVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
        com.xiaomi.push.ev evVar2 = this.c;
        if (evVar2 != null) {
            evVar2.b(i2, exc);
            this.c = null;
        }
        a(7);
        a(4);
        com.xiaomi.push.service.aj.a().a(i2);
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        com.xiaomi.push.eh.a().a(evVar);
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, int i2, java.lang.Exception exc) {
        com.xiaomi.push.eh.a().a(evVar, i2, exc);
        if (m()) {
            return;
        }
        b(false);
    }

    @Override // com.xiaomi.push.ey
    public final void a(com.xiaomi.push.ev evVar, java.lang.Exception exc) {
        com.xiaomi.push.eh.a().a(evVar, exc);
        c(false);
        if (m()) {
            return;
        }
        b(false);
    }

    public final void a(com.xiaomi.push.service.aj.b bVar) {
        if (bVar != null) {
            long random = (((long) ((java.lang.Math.random() * 20.0d) - 10.0d)) + ((bVar.n + 1) * 15)) * 1000;
            com.xiaomi.channel.commonutils.logger.b.a("schedule rebind job in " + (random / 1000));
            a(new com.xiaomi.push.service.c.b(bVar), random);
        }
    }

    public final void a(com.xiaomi.push.service.c.j jVar) {
        com.xiaomi.push.service.cl clVar = this.e;
        synchronized (clVar.a) {
            com.xiaomi.push.service.cl.c.a aVar = clVar.a.f;
            for (int i2 = 0; i2 < aVar.b; i2++) {
                com.xiaomi.push.service.cl.d dVar = aVar.a[i2];
                if (dVar.d == jVar) {
                    dVar.a();
                }
            }
            aVar.b();
        }
    }

    public final void a(com.xiaomi.push.service.c.j jVar, long j2) {
        try {
            this.e.a(jVar, j2);
        } catch (java.lang.IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.a("can't execute job err = " + e2.getMessage());
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, java.lang.String str4) {
        com.xiaomi.push.service.aj.b b2 = com.xiaomi.push.service.aj.a().b(str, str2);
        if (b2 != null) {
            a(new com.xiaomi.push.service.c.s(b2, i2, str4, str3), 0L);
        }
        com.xiaomi.push.service.aj.a().a(str, str2);
    }

    public final void a(java.lang.String str, byte[] bArr, boolean z) {
        java.util.Collection<com.xiaomi.push.service.aj.b> c = com.xiaomi.push.service.aj.a().c("5");
        if (c.isEmpty()) {
            if (z) {
                com.xiaomi.push.service.cs.b(str, bArr);
            }
        } else if (c.iterator().next().m == com.xiaomi.push.service.aj.c.binded) {
            a(new com.xiaomi.push.service.bn(this, str, bArr), 0L);
        } else if (z) {
            com.xiaomi.push.service.cs.b(str, bArr);
        }
    }

    public final void a(boolean z) {
        this.a = android.os.SystemClock.elapsedRealtime();
        if (!b()) {
            b(true);
        } else if (com.xiaomi.push.ai.a(this)) {
            b(new com.xiaomi.push.service.c.o(z));
        } else {
            b(new com.xiaomi.push.service.c.g(17));
            b(true);
        }
    }

    public final void a(byte[] bArr, java.lang.String str) {
        if (bArr == null) {
            com.xiaomi.push.service.cs.a(this, str, bArr, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        com.xiaomi.push.hh hhVar = new com.xiaomi.push.hh();
        try {
            com.xiaomi.push.hv.a(hhVar, bArr);
            if (hhVar.a != com.xiaomi.push.gk.Registration) {
                com.xiaomi.push.service.cs.a(this, str, bArr, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
                return;
            }
            com.xiaomi.push.hl hlVar = new com.xiaomi.push.hl();
            try {
                com.xiaomi.push.hv.a(hlVar, hhVar.a());
                a(new com.xiaomi.push.service.cr(this, hhVar.f, hlVar.d, hlVar.g, bArr), 0L);
                com.xiaomi.push.dp.a(getApplicationContext()).a(hhVar.f, "E100003", hlVar.c, com.huawei.hms.support.api.entity.auth.AuthCode.StatusCode.AUTH_INFO_NOT_EXIST, null);
            } catch (com.xiaomi.push.ia e2) {
                com.xiaomi.channel.commonutils.logger.b.d("app register error. ".concat(java.lang.String.valueOf(e2)));
                com.xiaomi.push.service.cs.a(this, str, bArr, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
            }
        } catch (com.xiaomi.push.ia e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. ".concat(java.lang.String.valueOf(e3)));
            com.xiaomi.push.service.cs.a(this, str, bArr, com.xiaomi.mipush.sdk.ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public final boolean a() {
        boolean a2 = com.xiaomi.push.ai.a(this);
        boolean z = com.xiaomi.push.service.aj.a().c() > 0;
        boolean z2 = !j();
        boolean i2 = i();
        boolean z3 = !h();
        boolean z4 = a2 && z && z2 && i2 && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.f(java.lang.String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", java.lang.Boolean.valueOf(a2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(i2), java.lang.Boolean.valueOf(z3)));
        }
        return z4;
    }

    @Override // com.xiaomi.push.ey
    public final void b(com.xiaomi.push.ev evVar) {
        com.xiaomi.push.eh.a().b(evVar);
        c(true);
        com.xiaomi.push.service.at atVar = this.j;
        atVar.b = java.lang.System.currentTimeMillis();
        atVar.a.a(1);
        atVar.c = 0;
        if (!com.xiaomi.push.du.b() && !m()) {
            com.xiaomi.channel.commonutils.logger.b.a("reconnection successful, reactivate alarm.");
            com.xiaomi.push.du.a(true);
        }
        java.util.Iterator<com.xiaomi.push.service.aj.b> it = com.xiaomi.push.service.aj.a().b().iterator();
        while (it.hasNext()) {
            a(new com.xiaomi.push.service.c.b(it.next()), 0L);
        }
        if (this.h || !com.xiaomi.push.iu.a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.m.a(getApplicationContext()).a(new com.xiaomi.push.service.bq(this), 0);
    }

    public final void b(boolean z) {
        this.j.a(z);
    }

    public final boolean b() {
        com.xiaomi.push.ev evVar = this.c;
        return evVar != null && evVar.j();
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.f.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        java.lang.String[] split;
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.jc.a(this);
        com.xiaomi.push.service.co a2 = com.xiaomi.push.service.cp.a(this);
        if (a2 != null) {
            com.xiaomi.push.f.a(a2.g);
        }
        if (com.xiaomi.push.iu.a(getApplicationContext())) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("hb-alarm");
            handlerThread.start();
            android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
            this.o = new com.xiaomi.push.service.c.a(this, (byte) 0);
            registerReceiver(this.o, new android.content.IntentFilter(com.xiaomi.push.service.an.p), null, handler);
            p = true;
            handler.post(new com.xiaomi.push.service.br(this));
        }
        this.f = new android.os.Messenger(new com.xiaomi.push.service.bs(this));
        com.xiaomi.push.service.ao aoVar = new com.xiaomi.push.service.ao(this);
        com.xiaomi.push.service.ay.a().a(aoVar);
        synchronized (com.xiaomi.push.bv.class) {
            com.xiaomi.push.bv.a(aoVar);
            com.xiaomi.push.bv.a(this, new com.xiaomi.push.service.ao.a(), "0", "push", "2.2");
        }
        com.xiaomi.push.service.bt btVar = new com.xiaomi.push.service.bt(this, "xiaomi.com");
        this.i = btVar;
        btVar.f = true;
        this.t = new com.xiaomi.push.er(this, this.i);
        this.d = new com.xiaomi.push.service.cf();
        com.xiaomi.push.du.a(this);
        com.xiaomi.push.er erVar = this.t;
        if (!erVar.g.contains(this)) {
            erVar.g.add(this);
        }
        this.u = new com.xiaomi.push.service.ah(this);
        this.j = new com.xiaomi.push.service.at(this);
        com.xiaomi.push.fu.a().a.put(com.xiaomi.push.fu.b("all", "xm:chat"), new com.xiaomi.push.service.cg());
        com.xiaomi.push.eh.a.a.a(this);
        this.e = new com.xiaomi.push.service.cl("Connection Controller Thread", (byte) 0);
        com.xiaomi.push.service.aj a3 = com.xiaomi.push.service.aj.a();
        a3.f();
        a3.a(new com.xiaomi.push.service.bu(this));
        if (!android.text.TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            com.xiaomi.push.service.ad.a(this).a(com.xiaomi.push.gp.ForegroundServiceSwitch.bw, false);
        }
        com.xiaomi.push.gh a4 = com.xiaomi.push.gh.a(this);
        com.xiaomi.push.service.cm cmVar = new com.xiaomi.push.service.cm(this);
        if (android.text.TextUtils.isEmpty("UPLOADER_PUSH_CHANNEL")) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            a4.b.put("UPLOADER_PUSH_CHANNEL", cmVar);
        }
        a(new com.xiaomi.push.ge(this));
        a(new com.xiaomi.push.service.bk(this));
        if (com.xiaomi.push.iu.a(this)) {
            a(new com.xiaomi.push.service.ai());
        }
        a(new com.xiaomi.push.service.c.h(), 0L);
        this.v.add(com.xiaomi.push.service.ba.a(this));
        if (i()) {
            this.l = new com.xiaomi.push.service.c.f();
            registerReceiver(this.l, new android.content.IntentFilter(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        }
        if (com.xiaomi.push.iu.a(getApplicationContext())) {
            this.m = new com.xiaomi.push.service.c.t();
            registerReceiver(this.m, new android.content.IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
            com.xiaomi.push.service.c.k kVar = new com.xiaomi.push.service.c.k();
            this.n = kVar;
            registerReceiver(kVar, new android.content.IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
        }
        com.xiaomi.push.service.ck.a(getApplicationContext());
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            android.net.Uri uriFor = android.provider.Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.x = new com.xiaomi.push.service.bv(this, new android.os.Handler(android.os.Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.x);
                } catch (java.lang.Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] d2 = d();
            if (d2 != null) {
                this.q = new com.xiaomi.push.service.c.r();
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                registerReceiver(this.q, intentFilter);
                this.r = d2[0];
                this.f489s = d2[1];
                com.xiaomi.channel.commonutils.logger.b.a("falldown initialized: " + this.r + "," + this.f489s);
            }
        }
        java.lang.String str = "";
        if (a2 != null) {
            try {
                if (!android.text.TextUtils.isEmpty(a2.a) && (split = a2.a.split("@")) != null && split.length > 0) {
                    str = split[0];
                }
            } catch (java.lang.Exception unused) {
            }
        }
        com.xiaomi.push.ce.a();
        com.xiaomi.channel.commonutils.logger.b.f("XMPushService created. pid=" + android.os.Process.myPid() + ", uid=" + android.os.Process.myUid() + ", vc=" + com.xiaomi.push.ga.b(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.xiaomi.push.service.c.f fVar = this.l;
        if (fVar != null) {
            a(fVar);
            this.l = null;
        }
        com.xiaomi.push.service.c.t tVar = this.m;
        if (tVar != null) {
            a(tVar);
            this.m = null;
        }
        com.xiaomi.push.service.c.k kVar = this.n;
        if (kVar != null) {
            a(kVar);
            this.n = null;
        }
        com.xiaomi.push.service.c.r rVar = this.q;
        if (rVar != null) {
            a(rVar);
            this.q = null;
        }
        com.xiaomi.push.service.c.a aVar = this.o;
        if (aVar != null) {
            a(aVar);
            this.o = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.x != null) {
            try {
                getContentResolver().unregisterContentObserver(this.x);
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.v.clear();
        com.xiaomi.push.service.cl clVar = this.e;
        synchronized (clVar.a) {
            clVar.a.f.a();
        }
        a(new com.xiaomi.push.service.bo(this), 0L);
        a(new com.xiaomi.push.service.c.l(), 0L);
        com.xiaomi.push.service.aj.a().f();
        com.xiaomi.push.service.aj.a().a(15);
        com.xiaomi.push.service.aj.a().d();
        this.t.g.remove(this);
        com.xiaomi.push.service.ay.a().b();
        com.xiaomi.push.du.a();
        synchronized (this.g) {
            this.g.clear();
        }
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(android.content.Intent intent, int i2) {
        com.xiaomi.push.service.c.i iVar;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(com.xiaomi.push.service.an.t), intent.getStringExtra(com.xiaomi.push.service.an.B), intent.getStringExtra("mipush_app_package")));
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                com.xiaomi.push.service.cl.c cVar = this.e.a;
                if (cVar.b && android.os.SystemClock.uptimeMillis() - cVar.a > 600000) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    com.xiaomi.push.service.aj.a().a(14);
                    stopSelf();
                } else {
                    iVar = new com.xiaomi.push.service.c.i(intent);
                    a(iVar, 0L);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if (com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", java.lang.System.currentTimeMillis());
                    intent.putExtra(com.umeng.ccg.a.f, com.xiaomi.push.jd.a(getApplicationContext()));
                    intent.putExtra(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI, com.xiaomi.push.ai.d(getApplicationContext()));
                }
                iVar = new com.xiaomi.push.service.c.i(intent);
                a(iVar, 0L);
            }
        }
        long currentTimeMillis2 = java.lang.System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}
