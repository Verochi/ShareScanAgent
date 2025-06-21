package com.umeng.commonsdk.statistics;

/* loaded from: classes19.dex */
public class c {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final java.lang.String o = "thtstart";
    private static final java.lang.String p = "gkvc";
    private static final java.lang.String q = "ekvc";
    java.lang.String a;
    private com.umeng.commonsdk.statistics.internal.c f;
    private com.umeng.commonsdk.statistics.idtracking.ImprintHandler g;
    private com.umeng.commonsdk.statistics.idtracking.f h;
    private com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a i;
    private com.umeng.commonsdk.statistics.noise.Defcon k;
    private long l;
    private int m;
    private int n;
    private android.content.Context r;
    private final int e = 1;
    private com.umeng.commonsdk.statistics.noise.ABTest j = null;

    /* renamed from: com.umeng.commonsdk.statistics.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.d {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.d
        public void onImprintChanged(com.umeng.commonsdk.statistics.idtracking.ImprintHandler.a aVar) {
            com.umeng.commonsdk.statistics.c.this.k.onImprintChanged(aVar);
            com.umeng.commonsdk.statistics.c cVar = com.umeng.commonsdk.statistics.c.this;
            cVar.a = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
        }
    }

    public c(android.content.Context context) {
        this.h = null;
        this.i = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.a = null;
        this.r = context;
        this.i = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).c();
        this.k = com.umeng.commonsdk.statistics.noise.Defcon.getService(this.r);
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.a = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler imprintService = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(this.r);
        this.g = imprintService;
        imprintService.a(new com.umeng.commonsdk.statistics.c.AnonymousClass1());
        if (!com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(this.r)) {
            this.h = com.umeng.commonsdk.statistics.idtracking.f.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f = cVar;
        cVar.a(com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(this.r));
    }

    private int a(byte[] bArr) {
        com.umeng.commonsdk.statistics.proto.Response response = new com.umeng.commonsdk.statistics.proto.Response();
        try {
            new com.umeng.analytics.pro.cf(new com.umeng.analytics.pro.cu.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.g.b(response.getImprint());
                this.g.d();
            }
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }

    public boolean a(java.io.File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = com.umeng.commonsdk.framework.UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            java.lang.String name = file.getName();
            if (android.text.TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            a.e(name);
            boolean a2 = a.a(name);
            boolean b2 = a.b(name);
            boolean c2 = a.c(name);
            boolean d2 = a.d(name);
            java.lang.String d3 = com.umeng.commonsdk.stateless.d.d(name);
            byte[] a3 = this.f.a(byteArray, a2, c2, !android.text.TextUtils.isEmpty(d3) ? com.umeng.commonsdk.stateless.d.c(d3) : d2 ? com.umeng.commonsdk.statistics.UMServerURL.SILENT_HEART_BEAT : c2 ? com.umeng.commonsdk.statistics.UMServerURL.ZCFG_PATH : com.umeng.commonsdk.statistics.UMServerURL.PATH_ANALYTICS);
            int a4 = a3 == null ? 1 : a(a3);
            if (com.umeng.commonsdk.UMConfigure.isDebugLog()) {
                if (d2 && a4 == 2) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c2 && a4 == 2) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b2 && a4 == 2) {
                    com.umeng.commonsdk.statistics.common.MLog.d("本次启动数据: 发送成功!");
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a2 && a4 == 2) {
                    com.umeng.commonsdk.statistics.common.MLog.d("普通统计数据: 发送成功!");
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a4 == 2) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a4 == 2) {
                com.umeng.commonsdk.statistics.idtracking.f fVar = this.h;
                if (fVar != null) {
                    fVar.e();
                }
                com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(this.r).saveSate();
                if (d2) {
                    java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                    if (!android.text.TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.r, java.lang.System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.r);
                        }
                    }
                }
            } else if (a4 == 3) {
                com.umeng.commonsdk.statistics.internal.StatTracer.getInstance(this.r).saveSate();
                if (c2) {
                    com.umeng.commonsdk.config.FieldManager.a().a(this.r);
                    com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    android.content.Context context = this.r;
                    com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f457s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a4 == 2;
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }
}
