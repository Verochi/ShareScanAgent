package cn.fly.verify;

/* loaded from: classes.dex */
public class n {
    private static boolean a;

    /* renamed from: cn.fly.verify.n$1, reason: invalid class name */
    public static class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ boolean a;

        /* renamed from: cn.fly.verify.n$1$1, reason: invalid class name and collision with other inner class name */
        public class C00111 extends cn.fly.verify.ar {
            final /* synthetic */ cn.fly.verify.e a;

            /* renamed from: cn.fly.verify.n$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C00121 extends cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> {
                public C00121() {
                }

                @Override // cn.fly.verify.common.callback.OperationCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onComplete(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
                }

                @Override // cn.fly.verify.common.callback.OperationCallback
                public void onFailure(cn.fly.verify.common.exception.VerifyException verifyException) {
                }
            }

            public C00111(cn.fly.verify.e eVar) {
                this.a = eVar;
            }

            @Override // cn.fly.verify.ar
            public void a() {
                java.util.HashMap hashMap;
                long uptimeMillis;
                boolean z;
                try {
                    hashMap = null;
                    this.a.a((java.lang.String) null, (java.lang.String) null, com.anythink.expressad.foundation.d.c.bT);
                    uptimeMillis = android.os.SystemClock.uptimeMillis();
                    try {
                        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "cdn start");
                        java.lang.String j = cn.fly.verify.al.j();
                        if ((android.text.TextUtils.isEmpty(j) || "none".equalsIgnoreCase(j)) && !android.text.TextUtils.isEmpty(cn.fly.verify.al.m())) {
                            this.a.a((java.lang.String) null, (java.lang.String) null, "dh_network_error");
                        }
                    } catch (cn.fly.verify.common.exception.VerifyException e) {
                        cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "cdn failure " + e);
                        cn.fly.verify.c b = this.a.b("cdn_failure");
                        b.c(java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis));
                        b.b(e.getCode());
                        b.d(e.getMessage());
                        this.a.a(b);
                        long uptimeMillis2 = android.os.SystemClock.uptimeMillis();
                        try {
                            hashMap = cn.fly.verify.C0545r.a().b();
                            this.a.a(java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis2));
                        } catch (cn.fly.verify.common.exception.VerifyException e2) {
                            cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "init failure " + e);
                            this.a.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_INIT_UNEXPECTED_ERROR.getCode(), java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis2)), e2);
                        }
                        z = false;
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
                if (!cn.fly.verify.as.c()) {
                    cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_Init_No_Net);
                    cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "init failure " + verifyException);
                    this.a.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_INIT_UNEXPECTED_ERROR), verifyException);
                    return;
                }
                hashMap = cn.fly.verify.C0545r.a().a(this.a);
                cn.fly.verify.c b2 = this.a.b("init");
                b2.c(true);
                b2.c(java.lang.String.valueOf(android.os.SystemClock.uptimeMillis() - uptimeMillis));
                b2.a(200);
                this.a.a(b2);
                z = true;
                if (hashMap != null) {
                    cn.fly.verify.n.b(hashMap, cn.fly.verify.n.AnonymousClass1.this.a);
                    cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "cdn or init complete");
                    if (cn.fly.verify.n.AnonymousClass1.this.a) {
                        cn.fly.verify.ap.a();
                        if (cn.fly.verify.ai.a().j()) {
                            cn.fly.verify.p.a().a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) new cn.fly.verify.n.AnonymousClass1.C00111.C00121(), true, true);
                        }
                    }
                }
                if (z) {
                    this.a.c();
                }
            }
        }

        public AnonymousClass1(boolean z) {
            this.a = z;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            if (cn.fly.verify.ax.h()) {
                boolean unused = cn.fly.verify.n.a = false;
            } else if (!cn.fly.verify.fh.d.b()) {
                boolean unused2 = cn.fly.verify.n.a = false;
            } else {
                cn.fly.verify.e eVar = new cn.fly.verify.e(cn.fly.verify.g.INIT);
                cn.fly.verify.al.a(new cn.fly.verify.n.AnonymousClass1.C00111(eVar), true, eVar);
            }
        }
    }

    public static android.util.SparseArray<cn.fly.verify.l> a(long j, long j2, cn.fly.verify.e eVar) {
        android.util.SparseArray<cn.fly.verify.l> a2 = a(j, true);
        if (a2 != null) {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "get first config");
            if (eVar != null) {
                eVar.a((java.lang.String) null, (java.lang.String) null, "use_sync_cdn", "1");
            }
            return a2;
        }
        a(false);
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "retry config");
        android.util.SparseArray<cn.fly.verify.l> a3 = a(j2, false);
        if (a3 != null && eVar != null) {
            eVar.a((java.lang.String) null, (java.lang.String) null, "use_sync_cdn", cn.fly.verify.l.b() ? "2" : "3");
        }
        return a3;
    }

    private static android.util.SparseArray<cn.fly.verify.l> a(long j, boolean z) {
        int i = (int) (j / 50);
        int i2 = 0;
        while (cn.fly.verify.l.a() == null && (!z || a)) {
            try {
                java.lang.Thread.sleep(50L);
            } catch (java.lang.InterruptedException unused) {
            }
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return cn.fly.verify.l.a();
    }

    private static java.lang.Integer a(java.util.HashMap hashMap, java.lang.String str) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        try {
            return (java.lang.Integer) hashMap.get(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x02bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(java.util.HashMap hashMap) {
        android.util.SparseArray sparseArray;
        android.util.SparseArray sparseArray2;
        java.util.HashMap hashMap2;
        java.lang.Object obj = hashMap.get("cacheType");
        int intValue = obj != null ? ((java.lang.Integer) obj).intValue() : -1;
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "cacheType = " + obj);
        cn.fly.verify.aq.c(intValue);
        java.lang.Object obj2 = hashMap.get("cdnKey");
        java.lang.String i = obj2 != null ? (java.lang.String) obj2 : cn.fly.verify.ai.a().i();
        cn.fly.verify.ai.a().c(i);
        cn.fly.verify.aq.c(i);
        java.lang.Object obj3 = hashMap.get("useWocucc");
        boolean booleanValue = obj3 != null ? ((java.lang.Boolean) obj3).booleanValue() : false;
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "usewo = " + booleanValue);
        cn.fly.verify.aq.b(booleanValue);
        java.util.HashMap hashMap3 = (java.util.HashMap) hashMap.get("clientConfig");
        if (hashMap3 == null || hashMap3.isEmpty()) {
            return;
        }
        java.lang.Object obj4 = hashMap3.get("oppoNet");
        int intValue2 = obj4 != null ? ((java.lang.Integer) obj4).intValue() : 0;
        cn.fly.verify.ai.a().c(intValue2);
        cn.fly.verify.aq.b(intValue2);
        java.lang.Object obj5 = hashMap3.get("autoPre");
        boolean booleanValue2 = obj5 != null ? ((java.lang.Boolean) obj5).booleanValue() : false;
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "autoPre = " + booleanValue2);
        cn.fly.verify.ai.a().a(booleanValue2);
        cn.fly.verify.aq.c(booleanValue2);
        java.util.ArrayList arrayList = (java.util.ArrayList) hashMap3.get("notUpload");
        if (arrayList != null && !arrayList.isEmpty()) {
            cn.fly.verify.ai.a().a(arrayList);
            cn.fly.verify.aq.a((java.util.ArrayList<java.lang.String>) arrayList);
        }
        if (hashMap3.containsKey("unknownTry")) {
            try {
                int intValue3 = ((java.lang.Integer) hashMap3.get("unknownTry")).intValue();
                cn.fly.verify.ai.a().a(java.lang.Boolean.valueOf(intValue3 == 1));
                cn.fly.verify.aq.a(intValue3 == 1);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (hashMap3.containsKey("autoRefresh")) {
            try {
                int intValue4 = ((java.lang.Integer) hashMap3.get("autoRefresh")).intValue();
                cn.fly.verify.ai.a().d(intValue4);
                cn.fly.verify.aq.d(intValue4);
            } catch (java.lang.Throwable unused2) {
            }
        }
        int intValue5 = hashMap3.containsKey("logSwitch") ? ((java.lang.Integer) hashMap3.get("logSwitch")).intValue() : 1;
        cn.fly.verify.ai.a().e(intValue5);
        cn.fly.verify.aq.a(intValue5);
        if (hashMap3.containsKey("cmSwitchData")) {
            int intValue6 = ((java.lang.Integer) hashMap3.get("cmSwitchData")).intValue();
            cn.fly.verify.ai.a().f(intValue6);
            cn.fly.verify.aq.e(intValue6);
        }
        if (hashMap3.containsKey("cuSwitchData")) {
            int intValue7 = ((java.lang.Integer) hashMap3.get("cuSwitchData")).intValue();
            cn.fly.verify.ai.a().g(intValue7);
            cn.fly.verify.aq.f(intValue7);
        }
        if (hashMap3.containsKey("subIdEnable")) {
            int intValue8 = ((java.lang.Integer) hashMap3.get("subIdEnable")).intValue();
            cn.fly.verify.ai.a().h(intValue8);
            cn.fly.verify.aq.g(intValue8);
        }
        if (hashMap3.containsKey("subIdsEnable")) {
            int intValue9 = ((java.lang.Integer) hashMap3.get("subIdsEnable")).intValue();
            cn.fly.verify.ai.a().i(intValue9);
            cn.fly.verify.aq.h(intValue9);
        }
        if (hashMap3.containsKey("slotsEnable")) {
            int intValue10 = ((java.lang.Integer) hashMap3.get("slotsEnable")).intValue();
            cn.fly.verify.ai.a().j(intValue10);
            cn.fly.verify.aq.i(intValue10);
        }
        if (hashMap3.containsKey("factoryBlst")) {
            java.lang.String str = (java.lang.String) hashMap3.get("factoryBlst");
            cn.fly.verify.ai.a().d(str);
            cn.fly.verify.aq.d(str);
        }
        if (hashMap3.containsKey("isOperatorCode")) {
            int intValue11 = ((java.lang.Integer) hashMap3.get("isOperatorCode")).intValue();
            cn.fly.verify.ai.a().k(intValue11);
            cn.fly.verify.aq.j(intValue11);
        }
        if (hashMap3.containsKey("switchTimeout")) {
            int intValue12 = ((java.lang.Integer) hashMap3.get("switchTimeout")).intValue();
            cn.fly.verify.ai.a().l(intValue12);
            cn.fly.verify.aq.k(intValue12);
        }
        if (hashMap3.containsKey("ignoreSwitchError")) {
            int intValue13 = ((java.lang.Integer) hashMap3.get("ignoreSwitchError")).intValue();
            cn.fly.verify.ai.a().m(intValue13);
            cn.fly.verify.aq.l(intValue13);
        }
        if (hashMap3.containsKey("defaultCmccLogin")) {
            try {
                hashMap2 = (java.util.HashMap) hashMap3.get("defaultCmccLogin");
            } catch (java.lang.Throwable th) {
                th = th;
                sparseArray = null;
            }
            if (hashMap2 != null) {
                cn.fly.verify.l lVar = new cn.fly.verify.l(1, hashMap2.containsKey("clientId") ? java.lang.String.valueOf(hashMap2.get("clientId")) : null, hashMap2.containsKey("clientSecret") ? java.lang.String.valueOf(hashMap2.get("clientSecret")) : null, false);
                lVar.a(a(hashMap2, "channel"));
                lVar.a(b(hashMap2, "channelAccount"));
                sparseArray2 = new android.util.SparseArray();
                try {
                    sparseArray2.append(1, lVar);
                } catch (java.lang.Throwable th2) {
                    sparseArray = sparseArray2;
                    th = th2;
                    cn.fly.verify.f.a().a(th);
                    sparseArray2 = sparseArray;
                    if (hashMap3.containsKey("defaultCuccLogin")) {
                    }
                }
                if (hashMap3.containsKey("defaultCuccLogin")) {
                    try {
                        java.util.HashMap hashMap4 = (java.util.HashMap) hashMap3.get("defaultCuccLogin");
                        cn.fly.verify.l lVar2 = new cn.fly.verify.l(2, hashMap4.containsKey("clientId") ? java.lang.String.valueOf(hashMap4.get("clientId")) : null, hashMap4.containsKey("clientSecret") ? java.lang.String.valueOf(hashMap4.get("clientSecret")) : null, false);
                        lVar2.a(a(hashMap4, "channel"));
                        lVar2.a(b(hashMap4, "channelAccount"));
                        if (sparseArray2 == null) {
                            sparseArray2 = new android.util.SparseArray();
                        }
                        sparseArray2.append(2, lVar2);
                        return;
                    } catch (java.lang.Throwable th3) {
                        cn.fly.verify.f.a().a(th3);
                        return;
                    }
                }
                return;
            }
        }
        sparseArray2 = null;
        if (hashMap3.containsKey("defaultCuccLogin")) {
        }
    }

    public static void a(boolean z) {
        if (z) {
            a = true;
        }
        new cn.fly.verify.n.AnonymousClass1(z).b();
    }

    private static java.lang.String b(java.util.HashMap hashMap, java.lang.String str) {
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        try {
            return (java.lang.String) hashMap.get(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.util.HashMap hashMap, boolean z) {
        if (hashMap == null) {
            return;
        }
        a(hashMap);
        c(hashMap, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(java.util.HashMap hashMap, boolean z) {
        int i;
        int i2;
        java.util.HashMap hashMap2;
        java.util.HashMap hashMap3;
        java.util.HashMap hashMap4;
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        int i3 = 0;
        try {
            java.util.HashMap hashMap5 = (java.util.HashMap) hashMap.get("loginSwitch");
            i = a(hashMap5, "cucc").intValue();
            try {
                i2 = a(hashMap5, "ctcc").intValue();
                try {
                    i3 = a(hashMap5, "cmcc").intValue();
                } catch (java.lang.Throwable unused) {
                }
            } catch (java.lang.Throwable unused2) {
                i2 = 0;
                hashMap2 = (java.util.HashMap) hashMap.get("multiLogin");
                if (hashMap2 != null) {
                    java.lang.String b = b(hashMap2, "clientId");
                    java.lang.String b2 = b(hashMap2, "clientSecret");
                    java.lang.Integer a2 = a(hashMap2, "channel");
                    java.lang.String b3 = b(hashMap2, "channelAccount");
                    if (i == 1) {
                    }
                    if (i3 == 1) {
                    }
                    if (i2 == 1) {
                    }
                }
                if (i == 0) {
                }
                if (i2 == 0) {
                    sparseArray.append(4, new cn.fly.verify.l(4, b(hashMap4, "clientId"), b(hashMap4, "clientSecret"), false, 0, a(hashMap4, "channel"), b(hashMap4, "channelAccount")));
                }
                if (i3 == 0) {
                    sparseArray.append(1, new cn.fly.verify.l(1, b(hashMap3, "clientId"), b(hashMap3, "clientSecret"), false, 0, a(hashMap3, "channel"), b(hashMap3, "channelAccount")));
                }
                cn.fly.verify.l.a(sparseArray, z);
                cn.fly.verify.m.a((android.util.SparseArray<cn.fly.verify.l>) sparseArray);
            }
        } catch (java.lang.Throwable unused3) {
            i = 0;
        }
        hashMap2 = (java.util.HashMap) hashMap.get("multiLogin");
        if (hashMap2 != null && hashMap2.containsKey("clientId") && hashMap2.containsKey("clientSecret")) {
            java.lang.String b4 = b(hashMap2, "clientId");
            java.lang.String b22 = b(hashMap2, "clientSecret");
            java.lang.Integer a22 = a(hashMap2, "channel");
            java.lang.String b32 = b(hashMap2, "channelAccount");
            if (i == 1) {
                sparseArray.append(2, new cn.fly.verify.l(2, b4, b22, false, 1, a22, b32));
                sparseArray.append(3, new cn.fly.verify.l(3, b4, b22, false, 1, a22, b32));
            }
            if (i3 == 1) {
                sparseArray.append(1, new cn.fly.verify.l(1, b4, b22, false, 1, a22, b32));
            }
            if (i2 == 1) {
                sparseArray.append(4, new cn.fly.verify.l(4, b4, b22, false, 1, a22, b32));
            }
        }
        if (i == 0) {
            java.util.HashMap hashMap6 = (java.util.HashMap) hashMap.get("cuccLogin");
            if (hashMap6 != null && hashMap6.containsKey("clientId") && hashMap6.containsKey("clientSecret")) {
                sparseArray.append(2, new cn.fly.verify.l(2, b(hashMap6, "clientId"), b(hashMap6, "clientSecret"), false, 0, a(hashMap6, "channel"), b(hashMap6, "channelAccount")));
            }
            java.util.HashMap hashMap7 = (java.util.HashMap) hashMap.get("woCuccLogin");
            if (hashMap7 != null && hashMap7.containsKey("clientId") && hashMap7.containsKey("clientSecret")) {
                sparseArray.append(3, new cn.fly.verify.l(3, b(hashMap7, "clientId"), b(hashMap7, "clientSecret"), true, 0, a(hashMap7, "channel"), b(hashMap7, "channelAccount")));
            }
        }
        if (i2 == 0 && (hashMap4 = (java.util.HashMap) hashMap.get("ctccLogin")) != null && hashMap4.containsKey("clientId") && hashMap4.containsKey("clientSecret")) {
            sparseArray.append(4, new cn.fly.verify.l(4, b(hashMap4, "clientId"), b(hashMap4, "clientSecret"), false, 0, a(hashMap4, "channel"), b(hashMap4, "channelAccount")));
        }
        if (i3 == 0 && (hashMap3 = (java.util.HashMap) hashMap.get("cmccLogin")) != null && hashMap3.containsKey("clientId") && hashMap3.containsKey("clientSecret")) {
            sparseArray.append(1, new cn.fly.verify.l(1, b(hashMap3, "clientId"), b(hashMap3, "clientSecret"), false, 0, a(hashMap3, "channel"), b(hashMap3, "channelAccount")));
        }
        cn.fly.verify.l.a(sparseArray, z);
        cn.fly.verify.m.a((android.util.SparseArray<cn.fly.verify.l>) sparseArray);
    }
}
