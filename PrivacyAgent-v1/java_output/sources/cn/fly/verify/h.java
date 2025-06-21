package cn.fly.verify;

/* loaded from: classes.dex */
public class h {

    public static class a {
        private static final cn.fly.verify.h a = new cn.fly.verify.h(null);
    }

    private h() {
    }

    public /* synthetic */ h(cn.fly.verify.h.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static cn.fly.verify.h a() {
        return cn.fly.verify.h.a.a;
    }

    private java.lang.String a(int i, java.lang.Object... objArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            java.lang.Object obj = objArr[i2];
            if (sb.length() > 0) {
                sb.append("\u0001");
            }
            java.lang.String valueOf = obj == null ? "" : java.lang.String.valueOf(obj);
            sb.append(valueOf);
            if (i == 1 || (i > 1 && i2 > 0)) {
                sb2.append("[");
                sb2.append(i2 + i);
                sb2.append("]");
                sb2.append(valueOf);
            }
        }
        java.lang.String sb3 = sb.toString();
        cn.fly.verify.f.a().a("token " + ((java.lang.Object) sb2));
        return sb3;
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> a(cn.fly.verify.c cVar) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        try {
            java.lang.String b = cVar.b();
            java.lang.String c = cVar.c().equals("preVerify") ? cn.fly.verify.ai.a().c() : cVar.c().equals("verify") ? cn.fly.verify.ai.a().b() : null;
            if (c != null && !c.equals(b)) {
                b = b + "," + c;
            }
            hashMap.put("serialId", b);
            hashMap.put("isFirstPre", java.lang.Boolean.valueOf(cVar.a()));
            hashMap.put("type", cVar.c());
            hashMap.put("method", cVar.d());
            hashMap.put("appkey", cn.fly.verify.ax.d());
            hashMap.put("plat", "1");
            hashMap.put("model", cn.fly.verify.fh.d.j());
            hashMap.put("deviceName", cn.fly.verify.fh.d.l());
            hashMap.put(androidx.core.app.NotificationCompat.CATEGORY_SYSTEM, java.lang.String.valueOf(cn.fly.verify.fh.d.g()));
            hashMap.put("duid", cn.fly.verify.am.a());
            if (android.text.TextUtils.isEmpty(cVar.q())) {
                cVar.f(cn.fly.verify.as.b());
            }
            hashMap.put("operator", cVar.q());
            hashMap.put("mnc", cn.fly.verify.as.a());
            java.lang.String s2 = cVar.s();
            if (android.text.TextUtils.isEmpty(s2)) {
                s2 = "-1";
            }
            hashMap.put("pmask", s2);
            hashMap.put("sdkver", cn.fly.verify.FlyVerify.getVersion());
            hashMap.put("pkg", cn.fly.verify.fh.d.c());
            hashMap.put("md5", cn.fly.verify.al.a());
            hashMap.put("time", java.lang.Long.valueOf(cVar.i()));
            hashMap.put("sdkMode", cn.fly.verify.ak.a);
            hashMap.put("romVersion", cn.fly.verify.al.g());
            hashMap.put(com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData.UNION_COSTTIME, java.lang.Long.valueOf(cVar.j()));
            hashMap.put("stepTime", java.lang.Long.valueOf(cVar.k()));
            hashMap.put("removeTelcom", java.lang.Boolean.valueOf(cVar.m()));
            hashMap.put("isCache", java.lang.Boolean.valueOf(cVar.l()));
            hashMap.put(com.anythink.expressad.videocommon.e.b.u, cVar.n());
            hashMap.put("isCdn", java.lang.Boolean.valueOf(cVar.p()));
            hashMap.put("isError", java.lang.Boolean.valueOf(cVar.o()));
            hashMap.put("resCode", java.lang.Integer.valueOf(cVar.e()));
            hashMap.put("innerCode", java.lang.Integer.valueOf(cVar.g()));
            if (cVar.h() != null) {
                hashMap.put("innerDesc", cVar.h());
            }
            if (cVar.f() != null) {
                hashMap.put("resDesc", cVar.f());
            }
            if (!cn.fly.verify.ai.a().g().contains("deviceId")) {
                hashMap.put("deviceId", cn.fly.verify.al.f());
            }
            hashMap.put("oaid", cn.fly.verify.al.k());
            hashMap.put("slots", java.lang.Integer.valueOf(cn.fly.verify.as.b(false)));
            hashMap.put("slots2", java.lang.Integer.valueOf(cn.fly.verify.as.c(false)));
            hashMap.put("subids", cn.fly.verify.as.d(false));
            hashMap.put("factory", cn.fly.verify.fh.d.k());
            hashMap.put("brand", cn.fly.verify.fh.d.l());
            if (cVar.r() != null) {
                hashMap.put("auto", cVar.r());
            }
            hashMap.put("ui", 0);
            if (cVar.d().equals("preVerify")) {
                hashMap.put("netStatus", java.lang.Integer.valueOf(cn.fly.verify.as.o()));
                hashMap.put(com.alipay.sdk.m.k.b.k, cn.fly.verify.al.j());
            }
            if (cVar.t() != null) {
                hashMap.put("multiFlag", cVar.t());
            }
            cn.fly.verify.f.a().a("append: method = " + cVar.d() + ", isError = " + cVar.o() + cn.fly.verify.fm.a((java.util.HashMap) hashMap));
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "buildLogParams" + th.getMessage());
        }
        return hashMap;
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        try {
            hashMap.put("appkey", cn.fly.verify.ax.d());
            hashMap.put(com.heytap.mcssdk.constant.b.A, cn.fly.verify.ax.e());
            hashMap.put("appVersion", cn.fly.verify.fh.d.f());
            hashMap.put("duid", cn.fly.verify.am.a());
            hashMap.put("plat", "1");
            hashMap.put(com.heytap.mcssdk.constant.b.C, 130604);
            hashMap.put(com.heytap.mcssdk.constant.b.e, cn.fly.verify.fh.d.c());
            hashMap.put("operator", str);
            hashMap.put(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE, str2);
            if (!cn.fly.verify.ai.a().g().contains("simserial")) {
                hashMap.put("simserial", cn.fly.verify.al.h());
            }
            if (!cn.fly.verify.ai.a().g().contains("imsi")) {
                hashMap.put("imsi", cn.fly.verify.al.e());
            }
            if (!cn.fly.verify.ai.a().g().contains("mnc")) {
                hashMap.put("mnc", cn.fly.verify.as.a());
            }
            hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID, java.lang.Integer.valueOf(cn.fly.verify.as.d()));
            hashMap.put("oaid", cn.fly.verify.al.k());
            hashMap.put("udd", cn.fly.verify.as.f());
            hashMap.put("drd", cn.fly.verify.as.g());
            hashMap.put("fbt", java.lang.String.valueOf(cn.fly.verify.as.h()));
            hashMap.put("fwt", java.lang.String.valueOf(cn.fly.verify.as.i()));
            hashMap.put("fls", java.lang.String.valueOf(cn.fly.verify.as.j()));
            hashMap.put("fda", java.lang.String.valueOf(cn.fly.verify.as.k()));
            hashMap.put("fsm", java.lang.String.valueOf(cn.fly.verify.as.l()));
            hashMap.put("fus", java.lang.String.valueOf(cn.fly.verify.as.m()));
            hashMap.put("fsf", java.lang.String.valueOf(cn.fly.verify.as.n()));
            hashMap.put("finp", android.os.Build.FINGERPRINT);
            hashMap.put("model", cn.fly.verify.fh.d.j());
            hashMap.put("factory", cn.fly.verify.fh.d.k());
            hashMap.put("sysverint", java.lang.String.valueOf(cn.fly.verify.fh.d.g()));
            if (!android.text.TextUtils.isEmpty(str3)) {
                hashMap.put("serialId", str3);
            }
            cn.fly.verify.f.a().a(hashMap.toString());
            return hashMap;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "buildCacheParams", th.getMessage());
            return hashMap;
        }
    }

    public java.lang.String[] a(cn.fly.verify.s sVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Throwable th;
        java.lang.Object a2;
        java.lang.Object c;
        java.lang.Object d;
        java.lang.Object a3;
        java.lang.String f;
        java.lang.String e;
        java.lang.Object k;
        java.lang.String f2;
        try {
            a2 = cn.fly.verify.am.a();
            c = cn.fly.verify.fh.d.c();
            d = cn.fly.verify.ax.d();
            a3 = cn.fly.verify.al.a();
            f = cn.fly.verify.fh.d.f();
            if (f.contains("#")) {
                try {
                    f = f.replace("#", "_");
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cn.fly.verify.f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "getOriginToken", th.getMessage());
                    return null;
                }
            }
            e = !cn.fly.verify.ai.a().g().contains("imsi") ? cn.fly.verify.al.e() : "";
            if (android.text.TextUtils.isEmpty(e)) {
                e = "";
            }
            k = cn.fly.verify.al.k();
            f2 = !cn.fly.verify.ai.a().g().contains("deviceId") ? cn.fly.verify.al.f() : "";
            if (android.text.TextUtils.isEmpty(f2)) {
                f2 = "";
            }
            try {
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        try {
            java.lang.String a4 = a(1, d, a2, "1", c, f, 130604, "", a3, f2, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()), e, k, "", "", cn.fly.verify.as.a(), java.lang.String.valueOf(sVar.e), sVar.b, java.lang.String.valueOf(cn.fly.verify.ai.a().e()), java.lang.String.valueOf(cn.fly.verify.ai.a().f()), java.lang.String.valueOf(cn.fly.verify.ai.a().d()), java.lang.String.valueOf(cn.fly.verify.as.d()), sVar.c() != null ? sVar.c().b() : "", android.text.TextUtils.isEmpty(str) ? "" : str);
            java.lang.Object a5 = cn.fly.verify.ao.a(str2 + a4 + str3);
            int d2 = sVar.d();
            java.lang.Object e2 = sVar.e();
            java.lang.Object f3 = sVar.f();
            int b = cn.fly.verify.as.b(false);
            java.util.List<java.lang.Integer> d3 = cn.fly.verify.as.d(false);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (d3 != null && !d3.isEmpty()) {
                for (java.lang.Integer num : d3) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    sb.append(num);
                }
            }
            java.lang.Object h = cn.fly.verify.fh.d.h();
            java.lang.Object k2 = cn.fly.verify.fh.d.k();
            java.lang.Object l = cn.fly.verify.fh.d.l();
            java.lang.Object j = cn.fly.verify.fh.d.j();
            int g = cn.fly.verify.fh.d.g();
            java.lang.Object f4 = cn.fly.verify.as.f();
            java.lang.Object g2 = cn.fly.verify.as.g();
            long h2 = cn.fly.verify.as.h();
            long i = cn.fly.verify.as.i();
            long j2 = cn.fly.verify.as.j();
            long k3 = cn.fly.verify.as.k();
            long l2 = cn.fly.verify.as.l();
            long m = cn.fly.verify.as.m();
            long n = cn.fly.verify.as.n();
            return new java.lang.String[]{a(23, a4, a5, "", java.lang.Integer.valueOf(d2), e2, f3, java.lang.Integer.valueOf(b), sb.toString(), h, k2, l, j, java.lang.Integer.valueOf(g), f4, g2, java.lang.Long.valueOf(h2), java.lang.Long.valueOf(i), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(k3), java.lang.Long.valueOf(l2), java.lang.Long.valueOf(m), java.lang.Long.valueOf(n), android.os.Build.FINGERPRINT) + "\u0001", a5};
        } catch (java.lang.Throwable th5) {
            th = th5;
            th = th;
            cn.fly.verify.f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "getOriginToken", th.getMessage());
            return null;
        }
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> b() {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        try {
            java.lang.String c = cn.fly.verify.fh.d.c();
            hashMap.put("appkey", cn.fly.verify.ax.d());
            hashMap.put("appVersion", cn.fly.verify.fh.d.f());
            hashMap.put("plat", "1");
            hashMap.put(com.heytap.mcssdk.constant.b.C, 130604);
            hashMap.put(com.heytap.mcssdk.constant.b.e, c);
            hashMap.put("old", java.lang.Boolean.FALSE);
            hashMap.put("duid", 0);
            hashMap.put("md5", cn.fly.verify.al.a());
            return hashMap;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().b(th, "[FlyVerify][%s][%s] ==>%s", "ParamBuilder", "buildInitParams", th.getMessage());
            return hashMap;
        }
    }
}
