package com.igexin.push.core.d;

import com.igexin.push.config.a.AnonymousClass9;

/* loaded from: classes23.dex */
public final class a implements com.igexin.push.core.d.e {
    private static final java.lang.String a = "DycSdkConfig";
    private java.util.Map<java.lang.String, java.lang.String> b = new java.util.HashMap();

    /* renamed from: com.igexin.push.core.d.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.core.d.g {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.core.d.g
        public final void a(java.lang.String str) {
            com.igexin.c.a.c.a.a(com.igexin.push.core.d.a.a, str);
            com.igexin.c.a.c.a.a("DycSdkConfig| get gtc config error ,message is : ".concat(java.lang.String.valueOf(str)), new java.lang.Object[0]);
        }

        @Override // com.igexin.push.core.d.g
        public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
            com.igexin.push.core.d.a.this.a(map);
            java.lang.String str = com.igexin.push.core.e.a;
            com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
        }
    }

    private int a(java.lang.String str, int i) {
        if (!b(str)) {
            return i;
        }
        try {
            return java.lang.Integer.valueOf(a(str)).intValue();
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    private java.lang.Boolean a(java.lang.String str, java.lang.Boolean bool) {
        if (!b(str)) {
            return bool;
        }
        try {
            return java.lang.Boolean.valueOf(a(str));
        } catch (java.lang.Exception unused) {
            return bool;
        }
    }

    private java.lang.Long a(java.lang.String str, java.lang.Long l) {
        if (!b(str)) {
            return l;
        }
        try {
            return java.lang.Long.valueOf(a(str));
        } catch (java.lang.Exception unused) {
            return l;
        }
    }

    private java.lang.String a(java.lang.String str) {
        return this.b.get(str);
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (!b(str)) {
            return str2;
        }
        try {
            java.lang.String a2 = a(str);
            return android.text.TextUtils.isEmpty(a2) ? str2 : a2;
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }

    private static java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, com.igexin.push.core.d.f fVar) {
        return com.getui.gtc.dyc.b.a.a(context, fVar.a);
    }

    private java.util.Map<java.lang.String, java.lang.String> a(boolean z) {
        com.igexin.push.config.SDKUrlConfig.getConfigServiceUrl();
        java.lang.String str = com.igexin.push.core.e.a;
        java.util.Map<java.lang.String, java.lang.String> a2 = a(com.igexin.push.core.e.l, new com.igexin.push.core.d.f.a().b(com.igexin.push.core.b.j).a(com.igexin.push.config.SDKUrlConfig.getConfigServiceUrl()).f("3.3.7.2").c(com.igexin.push.core.e.a).d(com.igexin.push.core.e.A).e("sdkconfig").a(z ? 1L : 86400000L).a(new com.igexin.push.core.d.a.AnonymousClass1()).a());
        a(a2);
        return a2;
    }

    private boolean b(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.String> map = this.b;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    private static void d() {
        java.lang.String str = com.igexin.push.core.e.a;
        com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
    }

    private static /* synthetic */ void e() {
        java.lang.String str = com.igexin.push.core.e.a;
        com.getui.gtc.api.GtcManager.getInstance().loadSdk(new com.getui.gtc.api.SdkInfo.Builder().appid(com.igexin.push.core.e.a).cid(com.igexin.push.core.e.A).moduleName(com.igexin.push.core.b.j).version("3.3.7.2").build());
    }

    @Override // com.igexin.push.core.d.e
    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return a(false);
    }

    @Override // com.igexin.push.core.d.e
    public final boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            try {
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.a(a, th.toString());
            }
            if (map.size() != 0) {
                this.b = map;
                com.igexin.c.a.c.a.a("DycSdkConfig|parse sdk config from server resp = " + this.b.toString(), new java.lang.Object[0]);
                com.igexin.push.config.d.j = a("sdk.feature.sendmessage.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.j)).booleanValue();
                com.igexin.push.config.d.h = a("sdk.readlocalcell.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.h)).booleanValue();
                com.igexin.push.config.d.g = a("sdk.domainbackup.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.g)).booleanValue();
                boolean booleanValue = a("sdk.feature.setsilenttime.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.l)).booleanValue();
                com.igexin.push.config.d.l = booleanValue;
                if (!booleanValue && com.igexin.push.config.d.c != 0) {
                    com.igexin.push.core.m.a();
                    com.igexin.push.core.m.a(12, 0);
                }
                com.igexin.push.config.d.k = a("sdk.feature.settag.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.k)).booleanValue();
                com.igexin.push.config.d.m = a("sdk.feature.setheartbeatinterval.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.m)).booleanValue();
                com.igexin.push.config.d.n = a("sdk.feature.setsockettimeout.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.n)).booleanValue();
                com.igexin.push.config.d.q = a("sdk.report.initialize.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.q)).booleanValue();
                com.igexin.push.config.d.o = a("sdk.feature.feedback.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.o)).booleanValue();
                com.igexin.push.config.d.p = a("sdk.daemon.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.p)).booleanValue();
                com.igexin.push.config.d.x = a("sdk.polling.dis.cnt", com.igexin.push.config.d.x);
                com.igexin.push.config.d.y = a("sdk.polling.login.interval", java.lang.Long.valueOf(com.igexin.push.config.d.y)).longValue();
                com.igexin.push.config.d.z = a("sdk.polling.exit.heartbeat.cnt", com.igexin.push.config.d.z);
                com.igexin.push.config.d.N = a("sdk.ral.send.maxcnt", com.igexin.push.config.d.N);
                com.igexin.push.config.d.A = a("sdk.httpdata.maxsize", com.igexin.push.config.d.A);
                com.igexin.push.config.d.B = a("sdk.hide.righticon.blacklist", com.igexin.push.config.d.B);
                java.lang.String a2 = a("sdk.taskid.blacklist", com.igexin.push.config.d.C);
                com.igexin.push.config.d.C = a2;
                if (android.text.TextUtils.isEmpty(a2)) {
                    com.igexin.push.config.d.C = "none";
                } else {
                    com.igexin.push.core.n.a();
                    com.igexin.push.core.n.b();
                }
                com.igexin.push.config.d.E = a("sdk.applink.feedback.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.E)).booleanValue();
                java.lang.String a3 = a("sdk.applink.domains", com.igexin.push.config.d.F);
                com.igexin.push.config.d.F = a3;
                if (android.text.TextUtils.isEmpty(a3)) {
                    com.igexin.push.config.d.F = "none";
                }
                java.lang.String a4 = a("sdk.del.alarm.brand", com.igexin.push.config.d.G);
                com.igexin.push.config.d.G = a4;
                if (android.text.TextUtils.isEmpty(a4)) {
                    com.igexin.push.config.d.G = "none";
                }
                com.igexin.push.config.d.L = a("sdk.vivopush.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.L)).booleanValue();
                com.igexin.push.config.d.O = a("sdk.upload.gzip.limit", java.lang.Long.valueOf(com.igexin.push.config.d.O)).longValue();
                com.igexin.push.config.d.M = a("sdk.multiPuh.stoplist", com.igexin.push.config.d.M);
                com.igexin.push.config.d.P = a("sdk.startservice.limit", com.igexin.push.config.d.P);
                com.igexin.push.config.d.D = a("sdk.miui.wakeup.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.D)).booleanValue();
                com.igexin.push.config.d.a = a("sdk.querytag.interval", java.lang.Long.valueOf(com.igexin.push.config.d.a)).longValue();
                com.igexin.push.config.d.Q = a("sdk.zxsdk.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.Q)).booleanValue();
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass9(com.igexin.push.config.d.Q), true, false);
                com.igexin.push.config.d.R = a("sdk.type253.enable", com.igexin.push.config.d.R);
                com.igexin.push.config.d.S = a("sdk.type253.interval", java.lang.Long.valueOf(com.igexin.push.config.d.S)).longValue();
                com.igexin.push.config.d.T = a("sdk.dud.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.T)).booleanValue();
                com.igexin.push.config.d.U = a("sdk.honorpush.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.U)).booleanValue();
                com.igexin.push.config.d.V = a("sdk.type144.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.V)).booleanValue();
                com.igexin.push.config.d.W = a("sdk.type144.interval", java.lang.Long.valueOf(com.igexin.push.config.d.W)).longValue();
                com.igexin.push.config.d.X = a("sdk.use.gtwf.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.X)).booleanValue();
                com.igexin.push.config.d.Y = a("sdk.type145.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.Y)).booleanValue();
                com.igexin.push.config.d.Z = a("sdk.type145.interval.ms", java.lang.Long.valueOf(com.igexin.push.config.d.Z)).longValue();
                com.igexin.push.config.d.aa = a("sdk.type145.times", com.igexin.push.config.d.aa);
                com.igexin.push.config.d.ab = a("sdk.type145.picc.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ab)).booleanValue();
                com.igexin.push.config.d.ac = a("sdk.type145.ipp.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ac)).booleanValue();
                com.igexin.push.config.d.ad = a("sdk.type145.gploc.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ad)).booleanValue();
                com.igexin.push.config.d.ae = a("sdk.type145.netloc.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ae)).booleanValue();
                com.igexin.push.config.d.af = a("sdk.type145.ceinfo.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.af)).booleanValue();
                com.igexin.push.config.d.ag = a("sdk.type10.cidnull.delay", com.igexin.push.config.d.ag);
                com.igexin.push.config.d.ah = a("sdk.newhostad.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ah)).booleanValue();
                com.igexin.push.config.d.ai = a("sdk.al.notify.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ai)).booleanValue();
                com.igexin.push.config.d.aj = a("sdk.sd.rf.enable", com.igexin.push.config.d.aj);
                com.igexin.push.config.d.ak = a("sdk.log.al.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.ak)).booleanValue();
                com.igexin.push.config.d.al = a("sdk.notification.failed.feedback.brand", com.igexin.push.config.d.al);
                com.igexin.push.config.d.am = a("sdk.radiotype.enable", java.lang.Boolean.valueOf(com.igexin.push.config.d.am)).booleanValue();
                return true;
            }
        }
        return false;
    }

    @Override // com.igexin.push.core.d.e
    public final java.util.Map<java.lang.String, java.lang.String> b() {
        return a(true);
    }

    @Override // com.igexin.push.core.d.e
    public final boolean c() {
        com.igexin.c.a.c.a.a("DycSdkConfig| parse config success", new java.lang.Object[0]);
        return true;
    }
}
