package cn.fly.verify;

/* loaded from: classes31.dex */
public abstract class s {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public android.content.Context d;
    public boolean e = false;
    protected int f = 1;
    protected cn.fly.verify.e g;
    protected boolean h;
    private int i;
    private boolean j;
    private int k;
    private java.lang.Integer l;
    private java.lang.String m;

    /* renamed from: cn.fly.verify.s$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.common.callback.b a;

        /* renamed from: cn.fly.verify.s$1$1, reason: invalid class name and collision with other inner class name */
        public class C00181 implements cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.PreVerifyResult> {
            public C00181() {
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
                cn.fly.verify.s.AnonymousClass1 anonymousClass1 = cn.fly.verify.s.AnonymousClass1.this;
                if (anonymousClass1.a != null) {
                    cn.fly.verify.s sVar = cn.fly.verify.s.this;
                    if (sVar.f <= 0 || sVar.h() || cn.fly.verify.s.this.j) {
                        cn.fly.verify.s sVar2 = cn.fly.verify.s.this;
                        cn.fly.verify.e eVar = sVar2.g;
                        if (eVar != null) {
                            eVar.a(sVar2.a, sVar2.b, "failure_retry_count", java.lang.String.valueOf(sVar2.i));
                            cn.fly.verify.s sVar3 = cn.fly.verify.s.this;
                            sVar3.g.a(sVar3.a, sVar3.b, "cell_wifi", java.lang.String.valueOf(sVar3.g()));
                        }
                        cn.fly.verify.s.AnonymousClass1.this.a.a(verifyException);
                        return;
                    }
                    r7.f--;
                    cn.fly.verify.s.e(cn.fly.verify.s.this);
                    cn.fly.verify.f.a().a("retry count = " + cn.fly.verify.s.this.i);
                    cn.fly.verify.s sVar4 = cn.fly.verify.s.this;
                    cn.fly.verify.e eVar2 = sVar4.g;
                    if (eVar2 != null) {
                        eVar2.a(sVar4.a, sVar4.b, "retry", java.lang.String.valueOf(sVar4.i));
                        cn.fly.verify.s sVar5 = cn.fly.verify.s.this;
                        sVar5.g.a(sVar5.a, sVar5.b, "cell_wifi", java.lang.String.valueOf(sVar5.g()));
                    }
                    cn.fly.verify.s.AnonymousClass1 anonymousClass12 = cn.fly.verify.s.AnonymousClass1.this;
                    cn.fly.verify.s.this.a(anonymousClass12.a);
                }
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
                cn.fly.verify.s.AnonymousClass1 anonymousClass1 = cn.fly.verify.s.AnonymousClass1.this;
                if (anonymousClass1.a != null) {
                    cn.fly.verify.s sVar = cn.fly.verify.s.this;
                    cn.fly.verify.e eVar = sVar.g;
                    if (eVar != null) {
                        eVar.a(sVar.a, sVar.b, "success_retry_count", java.lang.String.valueOf(sVar.i));
                        cn.fly.verify.s sVar2 = cn.fly.verify.s.this;
                        sVar2.g.a(sVar2.a, sVar2.b, "cell_wifi", java.lang.String.valueOf(sVar2.g()));
                    }
                    cn.fly.verify.s.AnonymousClass1.this.a.a((cn.fly.verify.common.callback.b) preVerifyResult);
                }
            }
        }

        public AnonymousClass1(cn.fly.verify.common.callback.b bVar) {
            this.a = bVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.s.this.a(true, (cn.fly.verify.common.callback.b) new cn.fly.verify.s.AnonymousClass1.C00181());
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            cn.fly.verify.common.callback.b bVar = this.a;
            if (bVar != null) {
                bVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), cn.fly.verify.as.a(th)));
            }
        }
    }

    /* renamed from: cn.fly.verify.s$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.common.callback.b a;

        /* renamed from: cn.fly.verify.s$2$1, reason: invalid class name */
        public class AnonymousClass1 implements cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.VerifyResult> {
            public AnonymousClass1() {
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
                cn.fly.verify.ah.b(cn.fly.verify.s.this.a + "_cache", null);
                cn.fly.verify.s sVar = cn.fly.verify.s.this;
                cn.fly.verify.e eVar = sVar.g;
                if (eVar != null) {
                    eVar.a(sVar.a, sVar.b, "cell_wifi", java.lang.String.valueOf(sVar.g()));
                }
                cn.fly.verify.common.callback.b bVar = cn.fly.verify.s.AnonymousClass2.this.a;
                if (bVar != null) {
                    bVar.a(verifyException);
                }
            }

            @Override // cn.fly.verify.common.callback.b
            public void a(cn.fly.verify.pure.entity.VerifyResult verifyResult) {
                cn.fly.verify.ah.b(cn.fly.verify.s.this.a + "_cache", null);
                cn.fly.verify.s sVar = cn.fly.verify.s.this;
                cn.fly.verify.e eVar = sVar.g;
                if (eVar != null) {
                    eVar.a(sVar.a, sVar.b, "cell_wifi", java.lang.String.valueOf(sVar.g()));
                }
                cn.fly.verify.common.callback.b bVar = cn.fly.verify.s.AnonymousClass2.this.a;
                if (bVar != null) {
                    bVar.a((cn.fly.verify.common.callback.b) verifyResult);
                }
            }
        }

        public AnonymousClass2(cn.fly.verify.common.callback.b bVar) {
            this.a = bVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.s.this.a(false, (cn.fly.verify.common.callback.b) new cn.fly.verify.s.AnonymousClass2.AnonymousClass1());
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            cn.fly.verify.ah.b(cn.fly.verify.s.this.a + "_cache", null);
            cn.fly.verify.common.callback.b bVar = this.a;
            if (bVar != null) {
                bVar.a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), cn.fly.verify.as.a(th)));
            }
        }
    }

    /* renamed from: cn.fly.verify.s$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements cn.fly.verify.common.callback.b {
        final /* synthetic */ boolean a;
        final /* synthetic */ cn.fly.verify.common.callback.b b;

        public AnonymousClass3(boolean z, cn.fly.verify.common.callback.b bVar) {
            this.a = z;
            this.b = bVar;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.common.callback.b bVar = this.b;
            if (bVar != null) {
                bVar.a(verifyException);
            }
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(java.lang.Object obj) {
            cn.fly.verify.e eVar = cn.fly.verify.s.this.g;
            if (eVar != null) {
                eVar.a(eVar.b("request_end"));
            }
            if (obj == null || !(obj instanceof java.util.HashMap)) {
                return;
            }
            java.util.HashMap hashMap = (java.util.HashMap) obj;
            java.lang.String str = hashMap.containsKey(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) ? (java.lang.String) hashMap.get(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) : "";
            long longValue = hashMap.containsKey("expired") ? ((java.lang.Long) hashMap.get("expired")).longValue() : 0L;
            cn.fly.verify.e eVar2 = cn.fly.verify.s.this.g;
            if (eVar2 != null) {
                eVar2.c(str);
            }
            if (this.a) {
                hashMap.put("subId", java.lang.Integer.valueOf(cn.fly.verify.as.d()));
                hashMap.put("clientId", cn.fly.verify.s.this.b);
                cn.fly.verify.ah.b(cn.fly.verify.s.this.a + "_cache", cn.fly.verify.fm.a(hashMap));
            } else {
                cn.fly.verify.ai.a().b(0);
                cn.fly.verify.ai.a().a(longValue);
            }
            cn.fly.verify.common.callback.b bVar = this.b;
            if (bVar != null) {
                if (!this.a) {
                    this.b.a((cn.fly.verify.common.callback.b) new cn.fly.verify.pure.entity.VerifyResult(str, hashMap.containsKey("optoken") ? (java.lang.String) hashMap.get("optoken") : "", cn.fly.verify.s.this.a));
                } else {
                    java.lang.String str2 = cn.fly.verify.s.this.a;
                    bVar.a((cn.fly.verify.common.callback.b) new cn.fly.verify.pure.entity.PreVerifyResult(str, str2, longValue, str2));
                }
            }
        }
    }

    public static /* synthetic */ int e(cn.fly.verify.s sVar) {
        int i = sVar.i;
        sVar.i = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        java.lang.String j = cn.fly.verify.al.j();
        if (this.h && com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j)) {
            return 0;
        }
        if (this.h) {
            return 1;
        }
        if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j)) {
            return 2;
        }
        return "none".equalsIgnoreCase(j) ? 4 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        cn.fly.verify.e eVar = this.g;
        return eVar != null && eVar.d();
    }

    public abstract java.lang.Object a(boolean z);

    public java.util.HashMap<java.lang.String, java.lang.Object> a() {
        cn.fly.verify.f a;
        java.lang.String str;
        java.lang.String a2 = cn.fly.verify.ah.a(this.a + "_cache");
        if (a2 != null) {
            java.util.HashMap<java.lang.String, java.lang.Object> a3 = cn.fly.verify.fm.a(a2);
            long longValue = a3.containsKey("expired") ? ((java.lang.Long) a3.get("expired")).longValue() : 0L;
            int intValue = a3.containsKey("subId") ? ((java.lang.Integer) a3.get("subId")).intValue() : -1;
            java.lang.String str2 = a3.containsKey("clientId") ? (java.lang.String) a3.get("clientId") : "";
            if (intValue == cn.fly.verify.as.d()) {
                boolean z = str2 == null || str2.equals(this.b);
                boolean z2 = longValue < java.lang.System.currentTimeMillis();
                if (z && !z2) {
                    return a3;
                }
                a = cn.fly.verify.f.a();
                str = "cache invalid, expired = " + z2;
            } else {
                a = cn.fly.verify.f.a();
                str = "subid changed, cache invalid";
            }
            a.a(str);
            cn.fly.verify.ah.b(this.a + "_cache", null);
        }
        return null;
    }

    public void a(cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.PreVerifyResult> bVar) {
        cn.fly.verify.as.a(new cn.fly.verify.s.AnonymousClass1(bVar));
    }

    public void a(java.lang.Integer num) {
        this.l = num;
    }

    public void a(java.lang.String str) {
        this.m = str;
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.fly.verify.e eVar) {
        this.a = str3;
        this.d = cn.fly.verify.ax.g();
        this.b = str.trim();
        this.c = str2.trim();
        this.g = eVar;
        if ("CTCC".equals(str3)) {
            this.f = 2;
        }
    }

    public abstract void a(boolean z, android.net.Network network, java.lang.Object obj, cn.fly.verify.common.callback.b bVar, cn.fly.verify.e eVar);

    public void a(boolean z, cn.fly.verify.common.callback.b bVar) {
        cn.fly.verify.pure.entity.a verifyResult;
        this.h = cn.fly.verify.as.b(this.d);
        java.util.HashMap<java.lang.String, java.lang.Object> a = a();
        if (a == null) {
            cn.fly.verify.e eVar = this.g;
            if (eVar != null) {
                eVar.a(eVar.b("no_upc"));
            }
            b(z, bVar);
            return;
        }
        java.lang.String str = a.containsKey(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) ? (java.lang.String) a.get(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) : null;
        long longValue = a.containsKey("expired") ? ((java.lang.Long) a.get("expired")).longValue() : 0L;
        cn.fly.verify.e eVar2 = this.g;
        if (eVar2 != null) {
            eVar2.c(str);
            cn.fly.verify.e eVar3 = this.g;
            eVar3.a(eVar3.b("upc"));
        }
        if (!z) {
            cn.fly.verify.ah.b(this.a + "_cache", null);
            cn.fly.verify.ai.a().b(2);
            cn.fly.verify.ai.a().a(longValue);
        }
        if (bVar != null) {
            if (z) {
                java.lang.String str2 = this.a;
                verifyResult = new cn.fly.verify.pure.entity.PreVerifyResult(str, str2, longValue, str2);
            } else {
                verifyResult = new cn.fly.verify.pure.entity.VerifyResult(str, a.containsKey("optoken") ? (java.lang.String) a.get("optoken") : null, this.a);
            }
            bVar.a((cn.fly.verify.common.callback.b) verifyResult);
        }
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.common.callback.b bVar) {
        return false;
    }

    public cn.fly.verify.s b(boolean z) {
        this.j = z;
        return this;
    }

    public java.lang.String b() {
        return this.e ? "CUCC" : this.a;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.VerifyResult> bVar) {
        cn.fly.verify.as.a(new cn.fly.verify.s.AnonymousClass2(bVar));
    }

    public void b(boolean z, cn.fly.verify.common.callback.b bVar) {
        android.net.Network network = null;
        try {
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(cn.fly.verify.al.j())) {
                cn.fly.verify.e eVar = this.g;
                if (eVar != null) {
                    eVar.a(this.a, this.b, "switch_s");
                }
                network = new cn.fly.verify.aj().c();
                cn.fly.verify.e eVar2 = this.g;
                if (eVar2 != null) {
                    eVar2.a(this.a, this.b, "switch_e");
                }
            }
        } catch (cn.fly.verify.common.exception.VerifyException e) {
            if (a(e, bVar)) {
                return;
            }
            if (cn.fly.verify.ai.a().u() == 0) {
                if (bVar != null) {
                    bVar.a(e);
                    return;
                }
                return;
            }
            cn.fly.verify.e eVar3 = this.g;
            if (eVar3 != null) {
                cn.fly.verify.c b = eVar3.b("switch_e");
                b.f(this.a);
                b.e(this.b);
                b.b(e.getCode());
                b.d(e.getMessage());
                this.g.a(b);
            }
        }
        android.net.Network network2 = network;
        java.lang.Object a = a(z);
        cn.fly.verify.e eVar4 = this.g;
        if (eVar4 != null) {
            eVar4.a(eVar4.b("request_start"));
        }
        a(z, network2, a, new cn.fly.verify.s.AnonymousClass3(z, bVar), this.g);
    }

    public cn.fly.verify.e c() {
        return this.g;
    }

    public int d() {
        return this.k;
    }

    public java.lang.Integer e() {
        return this.l;
    }

    public java.lang.String f() {
        return this.m;
    }
}
