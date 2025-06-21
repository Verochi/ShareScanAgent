package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class e {

    public static class a implements java.lang.Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ java.util.ArrayList b;
        final /* synthetic */ org.json.JSONArray c;

        public a(long j, java.util.ArrayList arrayList, org.json.JSONArray jSONArray) {
            this.a = j;
            this.b = arrayList;
            this.c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.huawei.hms.framework.network.grs.g.k.a aVar = new com.huawei.hms.framework.network.grs.g.k.a();
            aVar.put("total_time", this.a);
            java.util.Iterator it = this.b.iterator();
            while (it.hasNext()) {
                com.huawei.hms.framework.network.grs.g.d dVar = (com.huawei.hms.framework.network.grs.g.d) it.next();
                if (dVar.o() || dVar.m()) {
                    aVar.put(com.huawei.hms.framework.network.grs.g.e.b(dVar));
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z && this.b.size() > 0) {
                java.util.ArrayList arrayList = this.b;
                com.huawei.hms.framework.network.grs.g.d dVar2 = (com.huawei.hms.framework.network.grs.g.d) arrayList.get(arrayList.size() - 1);
                aVar.put(com.huawei.hms.framework.network.grs.g.e.b(dVar2));
                this.b.remove(dVar2);
            }
            if (this.b.size() > 0) {
                java.util.Iterator it2 = this.b.iterator();
                while (it2.hasNext()) {
                    this.c.put(new org.json.JSONObject(com.huawei.hms.framework.network.grs.g.e.b((com.huawei.hms.framework.network.grs.g.d) it2.next())));
                }
            }
            if (this.c.length() > 0) {
                aVar.put("failed_info", this.c.toString());
            }
            com.huawei.hms.framework.common.Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new org.json.JSONObject(aVar.get()));
            com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void a(java.util.ArrayList<com.huawei.hms.framework.network.grs.g.d> arrayList, long j, org.json.JSONArray jSONArray, android.content.Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            return;
        }
        com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.getInstance().getReportExecutor().submit(new com.huawei.hms.framework.network.grs.g.e.a(j, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.LinkedHashMap<java.lang.String, java.lang.String> b(com.huawei.hms.framework.network.grs.g.d dVar) {
        com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack linkedHashMapPack = new com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack();
        java.lang.Exception d = dVar.d();
        if (d != null) {
            linkedHashMapPack.put("error_code", com.huawei.hms.framework.common.ExceptionCode.getErrorCodeFromException(d));
            linkedHashMapPack.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EXCEPTION_NAME, d.getClass().getSimpleName());
            linkedHashMapPack.put("message", com.huawei.hms.framework.common.StringUtils.anonymizeMessage(d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", dVar.b());
            linkedHashMapPack.put(com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
        }
        try {
            linkedHashMapPack.put("domain", new java.net.URL(dVar.l()).getHost());
        } catch (java.net.MalformedURLException e) {
            com.huawei.hms.framework.common.Logger.w("HaReportHelper", "report host MalformedURLException", e);
        }
        linkedHashMapPack.put("req_start_time", dVar.h());
        linkedHashMapPack.put("req_end_time", dVar.g());
        linkedHashMapPack.put("req_total_time", dVar.i());
        return linkedHashMapPack.getAll();
    }
}
