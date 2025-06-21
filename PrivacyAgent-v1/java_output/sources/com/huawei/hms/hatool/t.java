package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class t {
    public java.util.List<com.huawei.hms.hatool.q> a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;

    public t(java.util.List<com.huawei.hms.hatool.q> list, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.c)) {
            a(this.a, this.c, this.b);
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (com.huawei.hms.hatool.q qVar : this.a) {
            java.lang.String c = qVar.c();
            if (android.text.TextUtils.isEmpty(c) || "oper".equals(c)) {
                arrayList4.add(qVar);
            } else if ("maint".equals(c)) {
                arrayList.add(qVar);
            } else if ("preins".equals(c)) {
                arrayList2.add(qVar);
            } else if ("diffprivacy".equals(c)) {
                arrayList3.add(qVar);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    public final void a(java.util.List<com.huawei.hms.hatool.q> list, java.lang.String str, java.lang.String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i = 0; i < size; i++) {
            int i2 = i * 500;
            java.util.List<com.huawei.hms.hatool.q> subList = list.subList(i2, java.lang.Math.min(list.size(), i2 + 500));
            java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long b = com.huawei.hms.hatool.c.b(str2, str) * 86400000;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.huawei.hms.hatool.q qVar : subList) {
                if (!com.huawei.hms.hatool.q0.a(qVar.b(), currentTimeMillis, b)) {
                    arrayList.add(qVar);
                }
            }
            if (arrayList.size() > 0) {
                new com.huawei.hms.hatool.u(str2, str, this.d, arrayList, replace).a();
            } else {
                com.huawei.hms.hatool.y.e("hmsSdk", "No data to report handler");
            }
        }
    }
}
