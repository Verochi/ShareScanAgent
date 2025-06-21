package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class bl implements java.lang.Runnable {
    final /* synthetic */ com.baidu.mobads.sdk.api.IOAdEvent a;
    final /* synthetic */ com.baidu.mobads.sdk.internal.bi.a b;

    public bl(com.baidu.mobads.sdk.internal.bi.a aVar, com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.util.HashMap hashMap;
        java.lang.String str;
        java.lang.String str2;
        com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent = this.a;
        if (iOAdEvent == null || android.text.TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        java.lang.String type = this.a.getType();
        if (com.baidu.mobads.sdk.internal.z.I.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.a(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.L.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.p = this.a.getMessage();
            com.baidu.mobads.sdk.internal.bi.this.q();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.M.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.e(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.N.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.f(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.V.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.g(this.a);
            return;
        }
        java.lang.String str3 = "";
        int i = 0;
        int i2 = 0;
        r6 = false;
        boolean z = false;
        if (com.baidu.mobads.sdk.internal.z.q.equals(type)) {
            java.util.HashMap hashMap2 = (java.util.HashMap) this.a.getData();
            if (hashMap2 != null) {
                str3 = (java.lang.String) hashMap2.get("error_message");
                java.lang.Object obj = hashMap2.get("error_code");
                java.lang.Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                i = ((java.lang.Integer) obj2).intValue();
                com.baidu.mobads.sdk.internal.bi.this.j = (java.lang.String) hashMap2.get(com.baidu.mobads.sdk.internal.bi.e);
                str2 = com.baidu.mobads.sdk.internal.bi.this.j;
            } else {
                str2 = "";
            }
            com.baidu.mobads.sdk.internal.bi.this.a(str3, i, str2);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.K.equals(type)) {
            java.util.HashMap hashMap3 = (java.util.HashMap) this.a.getData();
            if (hashMap3 != null) {
                str3 = (java.lang.String) hashMap3.get("error_message");
                java.lang.Object obj3 = hashMap3.get("error_code");
                java.lang.Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                i2 = ((java.lang.Integer) obj4).intValue();
                com.baidu.mobads.sdk.internal.bi.this.j = (java.lang.String) hashMap3.get(com.baidu.mobads.sdk.internal.bi.e);
                str = com.baidu.mobads.sdk.internal.bi.this.j;
            } else {
                str = "";
            }
            com.baidu.mobads.sdk.internal.bi.this.a(i2, str3, str);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.G.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.h(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.W.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.d();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.X.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.d(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.Z.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.s();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.aa.equals(type)) {
            com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent2 = this.a;
            if (iOAdEvent2 != null && (hashMap = (java.util.HashMap) iOAdEvent2.getData()) != null) {
                z = "1".equals((java.lang.String) hashMap.get("serverVerify"));
            }
            com.baidu.mobads.sdk.internal.bi.this.b(z);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ab.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.b();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ac.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.c();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ad.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.c();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.J.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.b(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ae.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.a(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.af.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.e(this.a.getMessage());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ag.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.f(this.a.getMessage());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ah.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.d(this.a.getMessage());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.C.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.g(this.a.getMessage());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.Y.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.t();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ai.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.b(this.a.getMessage(), 1 == this.a.getCode());
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.al.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.c(this.a);
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.aj.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.u();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.ak.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.v();
            return;
        }
        if (com.baidu.mobads.sdk.internal.z.an.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.i(this.a);
        } else if (com.baidu.mobads.sdk.internal.z.ao.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.j(this.a);
        } else if (com.baidu.mobads.sdk.internal.z.am.equals(type)) {
            com.baidu.mobads.sdk.internal.bi.this.k(this.a);
        }
    }
}
