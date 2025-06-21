package com.alipay.sdk.m.c0;

/* loaded from: classes.dex */
public final class b {
    public java.io.File a;
    public com.alipay.sdk.m.g0.a b;

    public b(java.lang.String str, com.alipay.sdk.m.g0.a aVar) {
        this.a = null;
        this.b = null;
        this.a = new java.io.File(str);
        this.b = aVar;
    }

    public static java.lang.String a(java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        java.io.File file = this.a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.a.isDirectory() && this.a.list().length != 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.String str : this.a.list()) {
                arrayList.add(str);
            }
            java.util.Collections.sort(arrayList);
            java.lang.String str2 = (java.lang.String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new java.text.SimpleDateFormat("yyyyMMdd").format(java.util.Calendar.getInstance().getTime()) + com.anythink.china.common.a.a.f)) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (java.lang.String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.b.logCollect(a(com.alipay.sdk.m.z.b.a(this.a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                new java.io.File(this.a, (java.lang.String) arrayList.get(i)).delete();
            }
        }
    }

    public final void a() {
        new java.lang.Thread(new com.alipay.sdk.m.c0.c(this)).start();
    }
}
