package com.umeng.pagesdk;

/* loaded from: classes19.dex */
public final class c {
    float a;
    long b;
    int c;
    int d;
    int e;
    boolean g;
    long h;
    long i;
    java.lang.String j;
    private android.content.Context k;
    java.util.Map<java.lang.String, java.lang.Double> f = new java.util.HashMap();
    private android.view.Choreographer.FrameCallback l = new com.umeng.pagesdk.c.AnonymousClass1();

    /* renamed from: com.umeng.pagesdk.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.Choreographer.FrameCallback {
        public AnonymousClass1() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j) {
            java.lang.String str = com.umeng.pagesdk.PageManger.TAG;
            com.umeng.pagesdk.c cVar = com.umeng.pagesdk.c.this;
            if (cVar.g) {
                if (cVar.h == 0) {
                    cVar.h = java.lang.System.currentTimeMillis();
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.umeng.pagesdk.c cVar2 = com.umeng.pagesdk.c.this;
                if (currentTimeMillis - cVar2.h > cVar2.i) {
                    cVar2.b();
                    return;
                }
                if (cVar2.b == 0) {
                    cVar2.b = j;
                }
                float f = (j - cVar2.b) / 1000000.0f;
                if (f > cVar2.a) {
                    double d = (cVar2.c * 1000) / f;
                    cVar2.c = 0;
                    cVar2.b = 0L;
                    if (com.umeng.pagesdk.PageManger.isDebug) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("doFrame: ");
                        sb.append(d);
                        sb.append(", map size is ");
                        sb.append(com.umeng.pagesdk.c.this.f.size());
                        sb.append(", page is ");
                        sb.append(com.umeng.pagesdk.c.this.j);
                    }
                    java.util.Map<java.lang.String, java.lang.Double> map = com.umeng.pagesdk.c.this.f;
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(java.lang.System.currentTimeMillis());
                    map.put(sb2.toString(), java.lang.Double.valueOf(d));
                    com.umeng.pagesdk.c cVar3 = com.umeng.pagesdk.c.this;
                    int i = cVar3.d + 1;
                    cVar3.d = i;
                    if (i >= cVar3.e) {
                        cVar3.c();
                        com.umeng.pagesdk.c cVar4 = com.umeng.pagesdk.c.this;
                        cVar4.d = 0;
                        java.util.Map<java.lang.String, java.lang.Double> map2 = cVar4.f;
                        if (map2 != null) {
                            map2.clear();
                        }
                    }
                } else {
                    cVar2.c++;
                }
                android.view.Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    public c(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        this.a = 1000.0f;
        this.e = 6;
        this.i = 300000L;
        this.k = context;
        if (context == null || (sharedPreferences = context.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.a = sharedPreferences.getFloat(com.umeng.pagesdk.PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.e = sharedPreferences.getInt(com.umeng.pagesdk.PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.i = sharedPreferences.getLong(com.umeng.pagesdk.PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000L);
        if (com.umeng.pagesdk.PageManger.isDebug) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("init fps. diff is ");
            sb.append(this.a);
            sb.append(", count diff is ");
            sb.append(this.e);
            sb.append(", dlealt time is ");
            sb.append(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.umeng.pagesdk.a a;
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Double>> it = this.f.entrySet().iterator();
        if (it != null) {
            org.json.JSONArray jSONArray = null;
            boolean z = false;
            while (it.hasNext()) {
                java.util.Map.Entry<java.lang.String, java.lang.Double> next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new org.json.JSONArray();
                    }
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        if (com.umeng.pagesdk.PageManger.getRefreshRate() > 0.0f && next.getValue().doubleValue() < com.umeng.pagesdk.PageManger.getRefreshRate() * 1.1d) {
                            jSONObject.put(next.getKey(), next.getValue());
                            if (next.getValue().doubleValue() < 40.0d) {
                                z = true;
                            }
                        }
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                try {
                    jSONObject2.put("pN", this.j);
                    jSONObject2.put("pF", jSONArray);
                    if (z && (a = com.umeng.pagesdk.b.a(this.k).a()) != null) {
                        jSONObject2.put("te", a.c);
                        jSONObject2.put("le", a.a);
                    }
                    com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("fpsperf");
                    efsJSONLog.put("fps", jSONObject2);
                    com.efs.sdk.base.EfsReporter reporter = com.umeng.pagesdk.PageManger.getReporter();
                    if (reporter != null) {
                        reporter.send(efsJSONLog);
                    }
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.g) {
            java.lang.String str = com.umeng.pagesdk.PageManger.TAG;
            return;
        }
        this.g = true;
        if (com.umeng.pagesdk.PageManger.isDebug) {
            new java.lang.StringBuilder("start, page is ").append(this.j);
        }
        android.view.Choreographer.getInstance().removeFrameCallback(this.l);
        android.view.Choreographer.getInstance().postFrameCallback(this.l);
    }

    public final void b() {
        if (com.umeng.pagesdk.PageManger.isDebug) {
            new java.lang.StringBuilder("stop, page is ").append(this.j);
        }
        c();
        this.g = false;
        this.h = 0L;
        this.b = 0L;
        this.c = 0;
        java.util.Map<java.lang.String, java.lang.Double> map = this.f;
        if (map != null) {
            map.clear();
        }
        this.d = 0;
    }
}
