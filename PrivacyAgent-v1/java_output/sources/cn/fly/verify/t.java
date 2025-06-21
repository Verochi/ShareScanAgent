package cn.fly.verify;

/* loaded from: classes.dex */
public class t extends cn.fly.verify.s {
    private android.util.SparseArray<java.lang.String> i;
    private java.lang.String j;
    private boolean k;

    /* renamed from: cn.fly.verify.t$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.x a;

        public AnonymousClass1(cn.fly.verify.x xVar) {
            this.a = xVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.t.this.c(this.a.a());
        }
    }

    /* renamed from: cn.fly.verify.t$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.x a;

        public AnonymousClass2(cn.fly.verify.x xVar) {
            this.a = xVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.t.this.b(this.a.a());
        }
    }

    /* renamed from: cn.fly.verify.t$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.common.callback.b {
        final /* synthetic */ cn.fly.verify.common.callback.b a;

        public AnonymousClass3(cn.fly.verify.common.callback.b bVar) {
            this.a = bVar;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.common.callback.b bVar = this.a;
            if (bVar != null) {
                bVar.a(verifyException);
            }
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(java.lang.Object obj) {
            if (obj != null) {
                cn.fly.verify.t.this.k = true;
                cn.fly.verify.t.this.b(this.a);
            } else {
                cn.fly.verify.common.callback.b bVar = this.a;
                if (bVar != null) {
                    bVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "result null"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        cn.fly.verify.x xVar = new cn.fly.verify.x(this.b, this.c);
        xVar.b("POST");
        xVar.c("https://log2.cmpassport.com:9443/log/logReport");
        xVar.a(str);
        new cn.fly.verify.z().a(xVar, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(java.lang.String str) {
        cn.fly.verify.x xVar = new cn.fly.verify.x(this.b, this.c);
        xVar.c("https://config2.cmpassport.com/client/uniConfig");
        xVar.b("POST");
        xVar.a(str);
        new cn.fly.verify.z().a(xVar, 4);
    }

    private int g() {
        java.lang.String j = cn.fly.verify.al.j();
        if (!android.text.TextUtils.isEmpty(j) && !"none".equalsIgnoreCase(j)) {
            boolean b = cn.fly.verify.as.b(cn.fly.verify.ax.g());
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j) && b) {
                return 3;
            }
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j) && !b) {
                return 2;
            }
            if (b) {
                return 1;
            }
        }
        return 0;
    }

    @Override // cn.fly.verify.s
    public java.lang.Object a(boolean z) {
        int g = g();
        if (!cn.fly.verify.as.a(cn.fly.verify.ax.g())) {
            return new cn.fly.verify.common.exception.VerifyException(200010, this.i.get(200010));
        }
        if (g == 0) {
            return new cn.fly.verify.common.exception.VerifyException(102101, this.i.get(102101));
        }
        if (g == 2) {
            return new cn.fly.verify.common.exception.VerifyException(102103, this.i.get(102103));
        }
        return null;
    }

    @Override // cn.fly.verify.s
    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.fly.verify.e eVar) {
        super.a(str, str2, str3, eVar);
        android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>();
        this.i = sparseArray;
        sparseArray.put(200010, "no sim");
        this.i.put(102101, "no network");
        this.i.put(102103, "no mobile data");
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, android.net.Network network, java.lang.Object obj, cn.fly.verify.common.callback.b bVar, cn.fly.verify.e eVar) {
        if (obj != null && (obj instanceof cn.fly.verify.common.exception.VerifyException)) {
            if (bVar != null) {
                bVar.a((cn.fly.verify.common.exception.VerifyException) obj);
                return;
            }
            return;
        }
        try {
            cn.fly.verify.x xVar = new cn.fly.verify.x(this.b, this.c);
            cn.fly.verify.z zVar = new cn.fly.verify.z();
            xVar.b("POST");
            xVar.f("quick_login_android_5.9.6");
            xVar.a(network);
            xVar.c("https://rcs.cmpassport.com/unisdk/rs/scripAndTokenForHttps");
            if (!z) {
                xVar.d(this.j);
                if (eVar != null) {
                    eVar.a(eVar.b("cm_tokenRequest_start"));
                }
            }
            java.util.HashMap<java.lang.String, java.lang.Object> a = zVar.a(xVar, z ? 0 : 1);
            if (!z && eVar != null) {
                eVar.a(eVar.b("cm_tokenRequest"));
            }
            if (a == null) {
                if (bVar != null) {
                    bVar.a(new cn.fly.verify.common.exception.VerifyException(200025, "result null"));
                }
            } else if (a.containsKey("error")) {
                if (bVar != null) {
                    bVar.a(new cn.fly.verify.common.exception.VerifyException(a.containsKey("code") ? ((java.lang.Integer) a.get("code")).intValue() : 200025, (java.lang.String) a.get("error")));
                }
            } else {
                if (bVar != null) {
                    bVar.a((cn.fly.verify.common.callback.b) a);
                }
                (z ? new cn.fly.verify.t.AnonymousClass1(xVar) : new cn.fly.verify.t.AnonymousClass2(xVar)).b();
            }
        } catch (java.lang.Throwable th) {
            if (bVar != null) {
                bVar.a(new cn.fly.verify.common.exception.VerifyException(200025, cn.fly.verify.as.a(th)));
            }
        }
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, cn.fly.verify.common.callback.b bVar) {
        if (z) {
            super.a(true, bVar);
            return;
        }
        this.h = cn.fly.verify.as.b(this.d);
        java.util.HashMap<java.lang.String, java.lang.Object> a = a();
        if (a == null) {
            if (this.k) {
                if (bVar != null) {
                    bVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR));
                    return;
                }
                return;
            } else {
                cn.fly.verify.e eVar = this.g;
                if (eVar != null) {
                    eVar.a(eVar.b("no_upc"));
                }
                b(true, (cn.fly.verify.common.callback.b) new cn.fly.verify.t.AnonymousClass3(bVar));
                return;
            }
        }
        java.lang.String str = a.containsKey(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) ? (java.lang.String) a.get(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) : null;
        long longValue = a.containsKey("expired") ? ((java.lang.Long) a.get("expired")).longValue() : 0L;
        cn.fly.verify.e eVar2 = this.g;
        if (eVar2 != null) {
            eVar2.c(str);
            cn.fly.verify.e eVar3 = this.g;
            eVar3.a(eVar3.b("upc"));
        }
        cn.fly.verify.ai.a().b(2);
        cn.fly.verify.ai.a().a(longValue);
        this.j = a.containsKey("optoken") ? (java.lang.String) a.get("optoken") : null;
        b(false, bVar);
    }
}
