package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class l0 implements com.huawei.hms.hatool.n0 {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.util.List<com.huawei.hms.hatool.q> d;

    public l0(java.util.List<com.huawei.hms.hatool.q> list, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    public final void a() {
        com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "backup_event", com.huawei.hms.hatool.u0.a(this.a, this.c, this.b));
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.List<com.huawei.hms.hatool.q> list = this.d;
        if (list == null || list.size() == 0) {
            com.huawei.hms.hatool.y.d("hmsSdk", "failed events is empty");
            return;
        }
        if (com.huawei.hms.hatool.q0.a(com.huawei.hms.hatool.b.i(), "cached_v2_1", com.huawei.hms.hatool.b.k() * 1048576)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "The cacheFile is full,Can not writing data! reqID:" + this.b);
            return;
        }
        java.lang.String a = com.huawei.hms.hatool.u0.a(this.a, this.c);
        java.util.List<com.huawei.hms.hatool.q> list2 = com.huawei.hms.hatool.w.b(com.huawei.hms.hatool.b.i(), "cached_v2_1", a).get(a);
        if (list2 != null && list2.size() != 0) {
            this.d.addAll(list2);
        }
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.huawei.hms.hatool.q> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().d());
            } catch (org.json.JSONException unused) {
                com.huawei.hms.hatool.y.e("hmsSdk", "event to json error");
            }
        }
        java.lang.String jSONArray2 = jSONArray.toString();
        if (jSONArray2.length() > com.huawei.hms.hatool.b.h() * 1048576) {
            com.huawei.hms.hatool.y.e("hmsSdk", "this failed data is too long,can not writing it");
            this.d = null;
            return;
        }
        com.huawei.hms.hatool.y.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.b);
        com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "cached_v2_1", a, jSONArray2);
        a();
    }
}
