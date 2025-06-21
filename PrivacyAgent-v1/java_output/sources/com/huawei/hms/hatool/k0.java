package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class k0 implements com.huawei.hms.hatool.n0 {
    public android.content.Context a = com.huawei.hms.hatool.b.i();
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;

    public k0(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void a(java.lang.String str, java.util.List<com.huawei.hms.hatool.q> list) {
        android.util.Pair<java.lang.String, java.lang.String> a = com.huawei.hms.hatool.u0.a(str);
        new com.huawei.hms.hatool.t(list, (java.lang.String) a.first, (java.lang.String) a.second, this.d).a();
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.Map<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> a;
        com.huawei.hms.hatool.y.c("hmsSdk", "eventReportTask is running");
        boolean a2 = com.huawei.hms.hatool.q0.a(this.a);
        if (a2) {
            com.huawei.hms.hatool.y.c("hmsSdk", "workKey is refresh,begin report all data");
            this.c = "alltype";
        }
        try {
            try {
                a = com.huawei.hms.hatool.w.a(this.a, this.b, this.c);
            } catch (java.lang.IllegalArgumentException e) {
                com.huawei.hms.hatool.y.e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
                if ("alltype".equals(this.c)) {
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", new java.lang.String[0]);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", new java.lang.String[0]);
                } else {
                    java.lang.String a3 = com.huawei.hms.hatool.u0.a(this.b, this.c);
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a3);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", a3);
                }
            } catch (java.lang.Exception e2) {
                com.huawei.hms.hatool.y.e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
                if ("alltype".equals(this.c)) {
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", new java.lang.String[0]);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", new java.lang.String[0]);
                } else {
                    java.lang.String a4 = com.huawei.hms.hatool.u0.a(this.b, this.c);
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a4);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", a4);
                }
            }
            if (a.size() == 0) {
                com.huawei.hms.hatool.y.b("hmsSdk", "no have events to report: tag:%s : type:%s", this.b, this.c);
                if ("alltype".equals(this.c)) {
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", new java.lang.String[0]);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", new java.lang.String[0]);
                    return;
                } else {
                    java.lang.String a5 = com.huawei.hms.hatool.u0.a(this.b, this.c);
                    com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a5);
                    com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", a5);
                    return;
                }
            }
            for (java.util.Map.Entry<java.lang.String, java.util.List<com.huawei.hms.hatool.q>> entry : a.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.c)) {
                com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", new java.lang.String[0]);
                com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", new java.lang.String[0]);
            } else {
                java.lang.String a6 = com.huawei.hms.hatool.u0.a(this.b, this.c);
                com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a6);
                com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", a6);
            }
            if (a2) {
                com.huawei.hms.hatool.y.c("hmsSdk", "refresh local key");
                com.huawei.hms.hatool.d0.f().b();
            }
        } catch (java.lang.Throwable th) {
            if ("alltype".equals(this.c)) {
                com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", new java.lang.String[0]);
                com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", new java.lang.String[0]);
            } else {
                java.lang.String a7 = com.huawei.hms.hatool.u0.a(this.b, this.c);
                com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a7);
                com.huawei.hms.hatool.g0.a(this.a, "cached_v2_1", a7);
            }
            throw th;
        }
    }
}
