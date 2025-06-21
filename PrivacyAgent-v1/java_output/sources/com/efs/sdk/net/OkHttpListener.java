package com.efs.sdk.net;

/* loaded from: classes22.dex */
public class OkHttpListener extends okhttp3.EventListener {
    private static java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.lang.String b;
    private boolean c;
    private java.util.List d = new java.util.ArrayList();

    /* renamed from: com.efs.sdk.net.OkHttpListener$1, reason: invalid class name */
    public static class AnonymousClass1 implements okhttp3.EventListener.Factory {
        @Override // okhttp3.EventListener.Factory
        @org.jetbrains.annotations.NotNull
        public final okhttp3.EventListener create(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
            return new com.efs.sdk.net.OkHttpListener();
        }
    }

    /* renamed from: com.efs.sdk.net.OkHttpListener$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.efs.sdk.net.a.d a;
        final /* synthetic */ com.efs.sdk.net.a.c b;
        final /* synthetic */ com.efs.sdk.base.protocol.record.EfsJSONLog c;

        public AnonymousClass2(com.efs.sdk.net.a.d dVar, com.efs.sdk.net.a.c cVar, com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog) {
            this.a = dVar;
            this.b = cVar;
            this.c = efsJSONLog;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.util.Map<java.lang.String, java.lang.String> map;
            java.util.Map<java.lang.String, java.lang.String> map2;
            try {
                try {
                    java.lang.String a = com.efs.sdk.net.b.a.a((this.a.E.containsKey(com.efs.sdk.net.a.d.a) ? java.lang.String.valueOf(this.a.E.get(com.efs.sdk.net.a.d.a)) : "") + com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getAppid() + com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getSecret());
                    if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetRequestBodyCollectState() && !android.text.TextUtils.isEmpty(this.b.h)) {
                        this.c.put("wk_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(this.b.h.getBytes(), a.getBytes())));
                    }
                    if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetResponseBodyCollectState() && !android.text.TextUtils.isEmpty(this.b.k)) {
                        this.c.put("wk_res_bd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(this.b.k.getBytes(), a.getBytes())));
                    }
                    if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetRequestHeaderCollectState() && (map2 = this.b.f) != null && !map2.isEmpty()) {
                        this.c.put("wk_req_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new org.json.JSONObject(this.b.f).toString().getBytes(), a.getBytes())));
                    }
                    if (com.efs.sdk.net.NetManager.getNetConfigManager().getNetResponseHeaderCollectState() && (map = this.b.l) != null && !map.isEmpty()) {
                        this.c.put("wk_res_hd", com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(new org.json.JSONObject(this.b.l).toString().getBytes(), a.getBytes())));
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                com.efs.sdk.net.OkHttpListener.a(this.a, this.b, this.c);
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, boolean z, boolean z2) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("|");
            sb.append(com.efs.sdk.net.NetManager.getNetConfigManager().getExtraRateFlag());
            if (map.size() == 0) {
                sb.append("|0");
            } else if (z) {
                sb.append("|0");
            } else if (z2) {
                sb.append("|1");
            } else {
                sb.append("|0");
            }
            sb.append("|");
            sb.append(new org.json.JSONObject(map).toString());
            return com.efs.sdk.net.b.a.a(com.efs.sdk.net.b.a.a(sb.toString().getBytes(), com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private void a() {
        try {
            com.efs.sdk.net.a.d c = com.efs.sdk.net.a.a.a().c(this.b);
            if (c != null) {
                java.util.Map<java.lang.String, java.lang.Long> map = c.E;
                java.util.Map<java.lang.String, java.lang.Long> map2 = c.F;
                map2.put(com.efs.sdk.net.a.d.f306s, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.a, com.efs.sdk.net.a.d.b)));
                map2.put(com.efs.sdk.net.a.d.t, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.d, com.efs.sdk.net.a.d.e)));
                map2.put(com.efs.sdk.net.a.d.u, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.g, com.efs.sdk.net.a.d.h)));
                map2.put(com.efs.sdk.net.a.d.v, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.f, com.efs.sdk.net.a.d.i)));
                map2.put(com.efs.sdk.net.a.d.w, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.k, com.efs.sdk.net.a.d.l)));
                map2.put(com.efs.sdk.net.a.d.x, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.m, com.efs.sdk.net.a.d.n)));
                map2.put(com.efs.sdk.net.a.d.y, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.o, com.efs.sdk.net.a.d.p)));
                map2.put(com.efs.sdk.net.a.d.z, java.lang.Long.valueOf(com.efs.sdk.net.b.a.a(map, com.efs.sdk.net.a.d.q, com.efs.sdk.net.a.d.r)));
                b();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog) {
        try {
            com.efs.sdk.base.EfsReporter reporter = com.efs.sdk.net.NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                    return;
                }
                android.content.SharedPreferences sharedPreferences = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName(), 0);
                java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA).format(new java.util.Date(java.lang.System.currentTimeMillis()));
                if (sharedPreferences != null) {
                    int i = sharedPreferences.getInt(format, 0);
                    android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (edit != null) {
                        edit.putInt(format, i + 1);
                        edit.apply();
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x012c, code lost:
    
        if (java.util.regex.Pattern.matches(r12, r16.B) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0161 A[Catch: all -> 0x0194, TryCatch #1 {all -> 0x0194, blocks: (B:23:0x008f, B:66:0x0096, B:68:0x00a5, B:71:0x00ac, B:73:0x00b2, B:75:0x00be, B:77:0x00ca, B:79:0x00d3, B:83:0x00e4, B:84:0x011b, B:87:0x012e, B:91:0x0139, B:96:0x0161, B:98:0x0176, B:101:0x0147, B:103:0x0151, B:107:0x0104, B:108:0x0126, B:112:0x017b), top: B:22:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0176 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.efs.sdk.net.a.d dVar, com.efs.sdk.net.a.c cVar, com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        try {
            android.content.SharedPreferences sharedPreferences = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().mAppContext.getSharedPreferences("net_launch" + com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName(), 0);
            java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA).format(new java.util.Date(java.lang.System.currentTimeMillis()));
            if (sharedPreferences != null) {
                int i = sharedPreferences.getInt(format, 0);
                if (!com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL() && com.efs.sdk.net.NetManager.getNetConfigManager().getDayLimit() != -1) {
                    if (i >= com.efs.sdk.net.NetManager.getNetConfigManager().getDayLimit()) {
                        return;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        java.util.Map<java.lang.String, java.lang.Object> strategyMap = com.efs.sdk.net.NetManager.getReporter().getStrategyMap();
        boolean a2 = com.efs.sdk.net.b.a.a(com.efs.sdk.net.NetManager.getNetConfigManager().getDataRate());
        java.lang.String str = "";
        if (strategyMap == null || strategyMap.size() != 2) {
            z = false;
            z2 = false;
        } else {
            try {
                z2 = com.efs.sdk.net.b.a.a(((java.lang.Integer) strategyMap.get("rate")).intValue());
                if (!a2 && !z2) {
                    try {
                        if (!com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        z = false;
                        th.printStackTrace();
                        if (android.text.TextUtils.isEmpty(str)) {
                        }
                        efsJSONLog.put("dx", str);
                        if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                        }
                    }
                }
                org.json.JSONArray jSONArray = (org.json.JSONArray) strategyMap.get("stra");
                java.util.HashMap hashMap = new java.util.HashMap();
                if (jSONArray != null && jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (!android.text.TextUtils.isEmpty(dVar.B)) {
                            java.lang.String optString = optJSONObject.optString(com.umeng.analytics.pro.bo.aN);
                            if (!android.text.TextUtils.isEmpty(optString)) {
                                if (!optString.startsWith("^")) {
                                    android.net.Uri parse = android.net.Uri.parse(dVar.B);
                                    int port = parse.getPort();
                                    if (com.efs.sdk.net.b.a.a((port < 0 || port > 65535) ? parse.getHost() + parse.getPath() : parse.getHost() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port + parse.getPath()).equalsIgnoreCase(optString)) {
                                        int optInt = optJSONObject.optInt("v", -1);
                                        if (optInt != -1 && optInt <= 3) {
                                            int optInt2 = optJSONObject.optInt("s", -1);
                                            if (optInt2 != 0) {
                                                if (optInt2 == 2 && com.efs.sdk.net.NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                                                    if (!android.text.TextUtils.isEmpty(cVar.h)) {
                                                    }
                                                    z4 = false;
                                                }
                                            }
                                            z4 = true;
                                        }
                                    }
                                }
                                if (!z4) {
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    sb.append(optJSONObject.optInt("i"));
                                    hashMap.put(sb.toString(), "");
                                }
                            }
                        }
                        z4 = false;
                        if (!z4) {
                        }
                    }
                }
                z = hashMap.size() != 0;
                if (z) {
                    try {
                        com.efs.sdk.net.NetManager.getNetConfigManager().setStrategyHitCurrentProcess(true);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        if (android.text.TextUtils.isEmpty(str)) {
                        }
                        efsJSONLog.put("dx", str);
                        if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
                        }
                    }
                }
                str = a(hashMap, a2, z2);
            } catch (java.lang.Throwable th3) {
                th = th3;
                z = false;
                z2 = false;
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            z3 = false;
            str = a((java.util.Map<java.lang.String, java.lang.String>) new java.util.HashMap(), a2, false);
        } else {
            z3 = false;
        }
        efsJSONLog.put("dx", str);
        if (com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL()) {
            a(efsJSONLog);
            return;
        }
        if (z) {
            if (a2 || z2) {
                a(efsJSONLog);
                return;
            }
            return;
        }
        if (!(com.efs.sdk.net.NetManager.getNetConfigManager().getExtraRateFlag() == 1)) {
            if (a2) {
                a(efsJSONLog);
            }
        } else if (com.efs.sdk.net.NetManager.getNetConfigManager().isStrategyHitCurrentProcess()) {
            int extraDataRate = com.efs.sdk.net.NetManager.getNetConfigManager().getExtraDataRate();
            if (extraDataRate != 0 && (extraDataRate == 100000 || new java.util.Random().nextInt(100000) <= extraDataRate)) {
                z3 = true;
            }
            if (z3) {
                a(efsJSONLog);
            }
        }
    }

    private void a(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Long> map;
        try {
            com.efs.sdk.net.a.d c = com.efs.sdk.net.a.a.a().c(this.b);
            if (c == null || (map = c.E) == null) {
                return;
            }
            map.put(str, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            com.efs.sdk.net.a.d c = com.efs.sdk.net.a.a.a().c(this.b);
            com.efs.sdk.net.a.c a2 = com.efs.sdk.net.a.a.a().a(this.b);
            if (c == null || a2 == null) {
                return;
            }
            java.util.Map<java.lang.String, java.lang.Long> map = c.E;
            java.util.Map<java.lang.String, java.lang.Long> map2 = c.F;
            com.efs.sdk.base.core.util.Log.i("NetTrace-Listener", a2.toString());
            if (android.text.TextUtils.isEmpty(c.B)) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("netperf");
            if (map.containsKey(com.efs.sdk.net.a.d.d)) {
                efsJSONLog.put("wd_dns", map.get(com.efs.sdk.net.a.d.d));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.e)) {
                efsJSONLog.put("wd_dnstm", map.get(com.efs.sdk.net.a.d.e));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.t)) {
                efsJSONLog.put("wl_dns", map2.get(com.efs.sdk.net.a.d.t));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.f)) {
                efsJSONLog.put("wd_tcp", map.get(com.efs.sdk.net.a.d.f));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.i)) {
                efsJSONLog.put("wd_tcptm", map.get(com.efs.sdk.net.a.d.i));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.v)) {
                efsJSONLog.put("wl_tcp", map2.get(com.efs.sdk.net.a.d.v));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.g)) {
                efsJSONLog.put("wd_ssl", map.get(com.efs.sdk.net.a.d.g));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.h)) {
                efsJSONLog.put("wd_ssltm", map.get(com.efs.sdk.net.a.d.h));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.u)) {
                efsJSONLog.put("wl_ssl", map2.get(com.efs.sdk.net.a.d.u));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.k)) {
                efsJSONLog.put("wd_ds", map.get(com.efs.sdk.net.a.d.k));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.n)) {
                efsJSONLog.put("wd_dstm", map.get(com.efs.sdk.net.a.d.n));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.w) && map2.containsKey(com.efs.sdk.net.a.d.x)) {
                efsJSONLog.put("wl_ds", java.lang.Long.valueOf(map2.get(com.efs.sdk.net.a.d.w).longValue() + map2.get(com.efs.sdk.net.a.d.x).longValue()));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.o)) {
                efsJSONLog.put("wd_srt", map.get(com.efs.sdk.net.a.d.o));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.r)) {
                efsJSONLog.put("wd_srttm", map.get(com.efs.sdk.net.a.d.r));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.y) && map2.containsKey(com.efs.sdk.net.a.d.z)) {
                efsJSONLog.put("wl_srt", java.lang.Long.valueOf(map2.get(com.efs.sdk.net.a.d.y).longValue() + map2.get(com.efs.sdk.net.a.d.z).longValue()));
            }
            java.lang.String[] split = c.B.split("\\?");
            java.lang.String str = split != null ? split[0] : null;
            java.util.List list = this.d;
            if (list == null || str == null || list.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.d.add(str);
                if (map.containsKey(com.efs.sdk.net.a.d.n)) {
                    efsJSONLog.put("wd_ttfb", map.get(com.efs.sdk.net.a.d.n));
                } else if (map.containsKey(com.efs.sdk.net.a.d.l)) {
                    efsJSONLog.put("wd_ttfb", map.get(com.efs.sdk.net.a.d.l));
                }
                if (map.containsKey(com.efs.sdk.net.a.d.o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(com.efs.sdk.net.a.d.o));
                }
                if (map.containsKey(com.efs.sdk.net.a.d.o)) {
                    if (map.containsKey(com.efs.sdk.net.a.d.n)) {
                        efsJSONLog.put("wl_ttfb", java.lang.Long.valueOf(map.get(com.efs.sdk.net.a.d.o).longValue() - map.get(com.efs.sdk.net.a.d.n).longValue()));
                    } else if (map.containsKey(com.efs.sdk.net.a.d.l)) {
                        efsJSONLog.put("wl_ttfb", java.lang.Long.valueOf(map.get(com.efs.sdk.net.a.d.o).longValue() - map.get(com.efs.sdk.net.a.d.l).longValue()));
                    }
                }
            }
            if (map.containsKey(com.efs.sdk.net.a.d.a)) {
                efsJSONLog.put("wd_rt", map.get(com.efs.sdk.net.a.d.a));
            }
            if (map.containsKey(com.efs.sdk.net.a.d.b)) {
                efsJSONLog.put("wd_rttm", map.get(com.efs.sdk.net.a.d.b));
            }
            if (map2.containsKey(com.efs.sdk.net.a.d.f306s)) {
                efsJSONLog.put("wl_rt", map2.get(com.efs.sdk.net.a.d.f306s));
            }
            efsJSONLog.put("wk_res", a2.c);
            efsJSONLog.put("wk_res_ori", c.B);
            efsJSONLog.put("wk_ip", c.C);
            efsJSONLog.put("wk_method", a2.e);
            efsJSONLog.put("wk_rc", java.lang.Integer.valueOf(a2.i));
            efsJSONLog.put("wl_up", java.lang.Long.valueOf(a2.g));
            efsJSONLog.put("wl_down", java.lang.Long.valueOf(a2.m));
            efsJSONLog.put("wl_total", java.lang.Long.valueOf(a2.g + a2.m));
            com.efs.sdk.net.a.b.a(new com.efs.sdk.net.OkHttpListener.AnonymousClass2(c, a2, efsJSONLog));
            com.efs.sdk.net.a.a.a().d(this.b);
            com.efs.sdk.net.a.a.a().b(this.b);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static okhttp3.EventListener.Factory get() {
        return new com.efs.sdk.net.OkHttpListener.AnonymousClass1();
    }

    @Override // okhttp3.EventListener
    public void callEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.callEnd(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.b);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.io.IOException iOException) {
        super.callFailed(call, iOException);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callFailed");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.c);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.callStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callStart");
            if (com.efs.sdk.net.NetManager.getNetConfigManager() != null && com.efs.sdk.net.NetManager.getNetConfigManager().enableTracer()) {
                this.c = true;
            }
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.b = java.lang.String.valueOf(a.getAndIncrement());
            com.efs.sdk.base.core.util.Log.i("NetTrace-Listener", "requestId is" + this.b);
            a(com.efs.sdk.net.a.d.a);
            java.lang.String httpUrl = call.request().url().toString();
            try {
                com.efs.sdk.net.a.d c = com.efs.sdk.net.a.a.a().c(this.b);
                if (c != null) {
                    c.B = httpUrl;
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.net.InetSocketAddress inetSocketAddress, @org.jetbrains.annotations.NotNull java.net.Proxy proxy, @org.jetbrains.annotations.Nullable okhttp3.Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.net.InetSocketAddress inetSocketAddress, @org.jetbrains.annotations.NotNull java.net.Proxy proxy, @org.jetbrains.annotations.Nullable okhttp3.Protocol protocol, @org.jetbrains.annotations.NotNull java.io.IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectFailed");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.j);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.net.InetSocketAddress inetSocketAddress, @org.jetbrains.annotations.NotNull java.net.Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull okhttp3.Connection connection) {
        super.connectionAcquired(call, connection);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "connectionAcquired");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            java.net.InetAddress inetAddress = connection.socket().getInetAddress();
            if (inetAddress != null) {
                java.lang.String hostAddress = inetAddress.getHostAddress();
                try {
                    com.efs.sdk.net.a.d c = com.efs.sdk.net.a.a.a().c(this.b);
                    if (c != null) {
                        c.C = hostAddress;
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.util.List<java.net.InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.e);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull java.lang.String str) {
        super.dnsStart(call, str);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "dnsStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.d);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestBodyEnd");
            call.request().body();
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.n);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.requestBodyStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.m);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull okhttp3.Request request) {
        super.requestHeadersEnd(call, request);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.l);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.requestHeadersStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.k);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.r);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.responseBodyStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.q);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.NotNull okhttp3.Response response) {
        super.responseHeadersEnd(call, response);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.p);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.responseHeadersStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.o);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(@org.jetbrains.annotations.NotNull okhttp3.Call call, @org.jetbrains.annotations.Nullable okhttp3.Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.h);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(@org.jetbrains.annotations.NotNull okhttp3.Call call) {
        super.secureConnectStart(call);
        try {
            com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.c && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                com.efs.sdk.base.core.util.Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(com.efs.sdk.net.a.d.g);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
