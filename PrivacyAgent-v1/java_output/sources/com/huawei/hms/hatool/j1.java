package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class j1 {
    public java.lang.String a;
    public com.huawei.hms.hatool.m b;

    public j1(java.lang.String str) {
        this.a = str;
        this.b = new com.huawei.hms.hatool.m(str);
        com.huawei.hms.hatool.i.c().a(this.a, this.b);
    }

    public void a(int i) {
        com.huawei.hms.hatool.y.d("hmsSdk", "onReport. TAG: " + this.a + ", TYPE: " + i);
        com.huawei.hms.hatool.i1.a().a(this.a, i);
    }

    public void a(int i, java.lang.String str, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        com.huawei.hms.hatool.y.d("hmsSdk", "onEvent. TAG: " + this.a + ", TYPE: " + i + ", eventId : " + str);
        if (com.huawei.hms.hatool.s0.a(str) || !c(i)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i);
            return;
        }
        if (!com.huawei.hms.hatool.s0.a(linkedHashMap)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        com.huawei.hms.hatool.i1.a().a(this.a, i, str, linkedHashMap);
    }

    public void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.y.d("hmsSdk", "onEvent(context). TAG: " + this.a + ", eventId : " + str);
        if (context == null) {
            com.huawei.hms.hatool.y.e("hmsSdk", "context is null in onevent ");
            return;
        }
        if (com.huawei.hms.hatool.s0.a(str) || !c(0)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a);
            return;
        }
        if (!com.huawei.hms.hatool.s0.a("value", str2, 65536)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.a);
            str2 = "";
        }
        com.huawei.hms.hatool.i1.a().a(this.a, context, str, str2);
    }

    public void a(com.huawei.hms.hatool.k kVar) {
        com.huawei.hms.hatool.y.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.a);
        if (kVar != null) {
            this.b.a(kVar);
        } else {
            com.huawei.hms.hatool.y.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.b.a((com.huawei.hms.hatool.k) null);
        }
    }

    public final com.huawei.hms.hatool.k b(int i) {
        if (i == 0) {
            return this.b.c();
        }
        if (i == 1) {
            return this.b.b();
        }
        if (i == 2) {
            return this.b.d();
        }
        if (i != 3) {
            return null;
        }
        return this.b.a();
    }

    public void b(com.huawei.hms.hatool.k kVar) {
        com.huawei.hms.hatool.y.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.a);
        if (kVar != null) {
            this.b.b(kVar);
        } else {
            this.b.b(null);
            com.huawei.hms.hatool.y.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
        }
    }

    public final boolean c(int i) {
        java.lang.String str;
        if (i != 2) {
            com.huawei.hms.hatool.k b = b(i);
            if (b != null && !android.text.TextUtils.isEmpty(b.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else {
            if ("_default_config_tag".equals(this.a)) {
                return true;
            }
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        com.huawei.hms.hatool.y.e("hmsSdk", str);
        return false;
    }
}
