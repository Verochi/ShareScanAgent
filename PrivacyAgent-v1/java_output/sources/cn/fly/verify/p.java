package cn.fly.verify;

/* loaded from: classes.dex */
public class p {
    private static volatile cn.fly.verify.p b;
    private long c;
    private cn.fly.verify.pure.entity.PreVerifyResult e;
    private int f;
    private java.lang.String g;
    private cn.fly.verify.at h;
    private cn.fly.verify.at i;
    public final java.util.concurrent.atomic.AtomicReference<cn.fly.verify.a> a = new java.util.concurrent.atomic.AtomicReference<>();
    private long d = 5000;

    /* renamed from: cn.fly.verify.p$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;

        public AnonymousClass1(cn.fly.verify.common.callback.OperationCallback operationCallback, boolean z, boolean z2) {
            this.a = operationCallback;
            this.b = z;
            this.c = z2;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.e eVar = new cn.fly.verify.e(cn.fly.verify.g.PREVERIFY);
            try {
                if (cn.fly.verify.ax.h()) {
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.a, (cn.fly.verify.pure.entity.PreVerifyResult) null, new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR));
                    return;
                }
                eVar.a(java.lang.Integer.valueOf(this.b ? 1 : 0));
                eVar.a((java.lang.String) null, (java.lang.String) null, com.anythink.expressad.foundation.d.c.bT);
                if (cn.fly.verify.fh.d.b()) {
                    if (cn.fly.verify.p.this.b(eVar, this.a, true)) {
                        return;
                    }
                    cn.fly.verify.p.this.a(eVar, this.a, this.c);
                } else {
                    cn.fly.verify.f.a().a("not main process");
                    cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "not main process");
                    cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH);
                    eVar.a(verifyException2, verifyException);
                    verifyException2.setSerialId(eVar.b());
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.a, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException2);
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().a(th);
                cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH;
                cn.fly.verify.common.exception.VerifyException verifyException3 = new cn.fly.verify.common.exception.VerifyException(verifyErr.getCode(), cn.fly.verify.as.a(th));
                cn.fly.verify.common.exception.VerifyException verifyException4 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
                eVar.a(verifyException4, verifyException3);
                verifyException4.setSerialId(eVar.b());
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.a, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException4);
            }
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            cn.fly.verify.p.this.a(true).a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH.getCode(), cn.fly.verify.as.a(th)));
        }
    }

    /* renamed from: cn.fly.verify.p$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.ar {
        final /* synthetic */ long a;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ cn.fly.verify.e f;

        /* renamed from: cn.fly.verify.p$2$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Handler.Callback {
            final /* synthetic */ cn.fly.verify.common.exception.VerifyException a;

            public AnonymousClass1(cn.fly.verify.common.exception.VerifyException verifyException) {
                this.a = verifyException;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                cn.fly.verify.p.AnonymousClass2.this.b.onFailure(this.a);
                return false;
            }
        }

        /* renamed from: cn.fly.verify.p$2$2, reason: invalid class name and collision with other inner class name */
        public class C00132 implements android.os.Handler.Callback {
            final /* synthetic */ cn.fly.verify.common.exception.VerifyException a;

            public C00132(cn.fly.verify.common.exception.VerifyException verifyException) {
                this.a = verifyException;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                cn.fly.verify.p.AnonymousClass2.this.b.onFailure(this.a);
                return false;
            }
        }

        public AnonymousClass2(long j, cn.fly.verify.common.callback.OperationCallback operationCallback, boolean z, int i, int i2, cn.fly.verify.e eVar) {
            this.a = j;
            this.b = operationCallback;
            this.c = z;
            this.d = i;
            this.e = i2;
            this.f = eVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.common.exception.VerifyException verifyException;
            try {
                java.lang.Thread.sleep(this.a);
            } catch (java.lang.InterruptedException unused) {
            }
            cn.fly.verify.common.callback.OperationCallback operationCallback = this.b;
            if (operationCallback == null || operationCallback.isCanceled()) {
                return;
            }
            try {
                this.b.setCanceled(true);
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "handleTimeout");
                cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.INNER_TIMEOUT_ERR;
                int code = verifyErr.getCode();
                if (this.c && this.d == 1) {
                    int i = this.e;
                    if (i == 1) {
                        code = 200023;
                    } else {
                        if (i != 2 && i != 3) {
                            if (i == 4) {
                                code = 80000;
                            }
                        }
                        code = 101005;
                    }
                }
                cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(code, verifyErr.getMessage());
                cn.fly.verify.e eVar = this.f;
                if (eVar != null) {
                    cn.fly.verify.common.exception.VerifyErr a = eVar.a(cn.fly.verify.as.a(this.e), (java.lang.String) null, verifyException2);
                    this.f.a(true);
                    verifyException = new cn.fly.verify.common.exception.VerifyException(a);
                    verifyException.setSerialId(this.f.b());
                } else {
                    verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_TIMEOUT);
                }
                if (this.c && this.d == 1 && code != verifyErr.getCode()) {
                    verifyException.setOperatorCode(code + "");
                }
                cn.fly.verify.ft.a(0, new cn.fly.verify.p.AnonymousClass2.AnonymousClass1(verifyException));
            } catch (java.lang.Throwable unused2) {
                verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH);
                cn.fly.verify.ft.a(0, new cn.fly.verify.p.AnonymousClass2.C00132(verifyException));
            }
            cn.fly.verify.p.this.a(this.c).a(this.f);
            cn.fly.verify.p.this.a(this.c).a(verifyException);
        }
    }

    /* renamed from: cn.fly.verify.p$3, reason: invalid class name */
    public class AnonymousClass3 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.e a;
        final /* synthetic */ boolean b;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback c;

        /* renamed from: cn.fly.verify.p$3$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> {
            final /* synthetic */ boolean a;
            final /* synthetic */ android.util.SparseArray b;
            final /* synthetic */ int c;
            final /* synthetic */ java.lang.String d;

            public AnonymousClass1(boolean z, android.util.SparseArray sparseArray, int i, java.lang.String str) {
                this.a = z;
                this.b = sparseArray;
                this.c = i;
                this.d = str;
            }

            @Override // cn.fly.verify.common.callback.OperationCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onComplete(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
                cn.fly.verify.p.this.e = preVerifyResult;
                cn.fly.verify.p.this.a(true).a(cn.fly.verify.p.AnonymousClass3.this.a);
                cn.fly.verify.p.AnonymousClass3 anonymousClass3 = cn.fly.verify.p.AnonymousClass3.this;
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) anonymousClass3.c, preVerifyResult, (cn.fly.verify.common.exception.VerifyException) null);
                if (cn.fly.verify.p.AnonymousClass3.this.a.d()) {
                    cn.fly.verify.p.AnonymousClass3.this.a.a(preVerifyResult.getChannel(), cn.fly.verify.p.this.g, "timeout_success");
                } else if (!this.a) {
                    cn.fly.verify.p.AnonymousClass3.this.a.a(preVerifyResult.getChannel(), cn.fly.verify.p.this.g);
                    cn.fly.verify.p.AnonymousClass3 anonymousClass32 = cn.fly.verify.p.AnonymousClass3.this;
                    cn.fly.verify.p.this.a(this.c, preVerifyResult, anonymousClass32.a);
                } else {
                    cn.fly.verify.l lVar = (cn.fly.verify.l) this.b.get(cn.fly.verify.p.c(preVerifyResult.getChannel()));
                    cn.fly.verify.c b = cn.fly.verify.p.AnonymousClass3.this.a.b(preVerifyResult.getChannel(), lVar != null ? lVar.b : null);
                    b.b(201);
                    cn.fly.verify.p.AnonymousClass3.this.a.a(b);
                }
                cn.fly.verify.p.AnonymousClass3.this.a.c();
                cn.fly.verify.p.AnonymousClass3 anonymousClass322 = cn.fly.verify.p.AnonymousClass3.this;
                cn.fly.verify.p.this.a(this.c, preVerifyResult, anonymousClass322.a);
            }

            @Override // cn.fly.verify.common.callback.OperationCallback
            public void onFailure(cn.fly.verify.common.exception.VerifyException verifyException) {
                cn.fly.verify.common.exception.VerifyException verifyException2;
                cn.fly.verify.p.this.e = null;
                if (cn.fly.verify.p.AnonymousClass3.this.a.d()) {
                    cn.fly.verify.c a = cn.fly.verify.p.AnonymousClass3.this.a.a(cn.fly.verify.as.a(this.c), cn.fly.verify.p.this.g, verifyException.getCode(), verifyException.getMessage());
                    a.b(false);
                    a.b("timeout_error");
                    cn.fly.verify.p.AnonymousClass3.this.a.a(a);
                    cn.fly.verify.p.AnonymousClass3.this.a.c();
                    return;
                }
                if (this.a) {
                    verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_UNSUPPORTED_OPERATOR);
                    cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.INNER_UNKNOWN_OPERATOR_TRIED;
                    verifyException2.setExtraDesc(verifyErr.getMessage());
                    cn.fly.verify.common.exception.VerifyException verifyException3 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
                    verifyException3.setExtraDesc(this.d);
                    cn.fly.verify.p.AnonymousClass3.this.a.a(verifyException2, verifyException3);
                } else {
                    cn.fly.verify.common.exception.VerifyException verifyException4 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.p.AnonymousClass3.this.a.a(cn.fly.verify.as.a(this.c), cn.fly.verify.p.this.g, verifyException));
                    cn.fly.verify.p.AnonymousClass3 anonymousClass3 = cn.fly.verify.p.AnonymousClass3.this;
                    cn.fly.verify.p.this.a(this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, anonymousClass3.a);
                    verifyException2 = verifyException4;
                }
                if (cn.fly.verify.ai.a().t() == 1) {
                    verifyException2.setOperatorCode(verifyException.getCode() + "");
                }
                cn.fly.verify.p.this.a(true).a(cn.fly.verify.p.AnonymousClass3.this.a);
                verifyException2.setSerialId(cn.fly.verify.p.AnonymousClass3.this.a.b());
                cn.fly.verify.p.AnonymousClass3 anonymousClass32 = cn.fly.verify.p.AnonymousClass3.this;
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) anonymousClass32.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException2);
            }
        }

        public AnonymousClass3(cn.fly.verify.e eVar, boolean z, cn.fly.verify.common.callback.OperationCallback operationCallback) {
            this.a = eVar;
            this.b = z;
            this.c = operationCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.fly.verify.ar
        public void a() {
            android.util.SparseArray<cn.fly.verify.l> sparseArray;
            boolean z;
            cn.fly.verify.s[] sVarArr;
            cn.fly.verify.p.this.e = null;
            java.lang.String a = cn.fly.verify.as.a(true);
            if ((cn.fly.verify.as.a(a) == 1 && cn.fly.verify.ai.a().n() == 1) || (cn.fly.verify.as.a(a) == 2 && cn.fly.verify.ai.a().o() == 1)) {
                new cn.fly.verify.aj().a();
            }
            android.util.SparseArray<cn.fly.verify.l> a2 = cn.fly.verify.l.a();
            int i = 0;
            if (a2 == null) {
                a2 = cn.fly.verify.m.a();
                if (a2 != null) {
                    cn.fly.verify.ai.a().a(0);
                    this.a.a((java.lang.String) null, (java.lang.String) null, "use_ca");
                    cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use cache config");
                }
            } else {
                cn.fly.verify.ai.a().a(2);
                this.a.a((java.lang.String) null, (java.lang.String) null, "use_cdn");
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use server config");
            }
            if (a2 == null && this.b) {
                android.util.SparseArray<cn.fly.verify.l> a3 = cn.fly.verify.n.a(2000L, moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME, this.a);
                if (a3 != null) {
                    cn.fly.verify.ai.a().a(2);
                    cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use server config");
                }
                sparseArray = a3;
                z = true;
            } else {
                sparseArray = a2;
                z = false;
            }
            if (sparseArray == null) {
                cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_CONFIG_ERROR);
                verifyException.setExtraDesc(z ? "has retry" : "no retry");
                this.a.a(verifyException, new cn.fly.verify.common.exception.VerifyException(z ? cn.fly.verify.common.exception.VerifyErr.INNER_NO_INIT_RETRY : cn.fly.verify.common.exception.VerifyErr.INNER_NO_INIT_NO_RETRY));
                verifyException.setSerialId(this.a.b());
                cn.fly.verify.p.this.a(true).a(this.a);
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException);
                return;
            }
            int a4 = cn.fly.verify.p.a(a);
            java.lang.String d = cn.fly.verify.al.d();
            if (a4 != 5 && (android.text.TextUtils.isEmpty(d) || "-1".equalsIgnoreCase(d))) {
                this.a.a(cn.fly.verify.as.a(a4), (java.lang.String) null, "dh_carrier_error");
            }
            cn.fly.verify.l.a(sparseArray);
            cn.fly.verify.p.this.a(this.a, this.c, a4, true);
            this.a.a(cn.fly.verify.as.a(a4), (java.lang.String) null, "get_cc", java.lang.String.valueOf(cn.fly.verify.p.this.b()));
            if (!cn.fly.verify.ai.a().k().booleanValue() && a4 == 5) {
                cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "carrier unknown");
                cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_UNSUPPORTED_OPERATOR);
                cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.INNER_UNKNOWN_OPERATOR;
                verifyException2.setExtraDesc(verifyErr.getMessage());
                cn.fly.verify.common.exception.VerifyException verifyException3 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
                verifyException3.setExtraDesc(a);
                this.a.a(verifyException2, verifyException3);
                cn.fly.verify.p.this.a(true).a(this.a);
                verifyException2.setSerialId(this.a.b());
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException2);
                return;
            }
            if (a4 == 5) {
                int[] iArr = {1, 4, 2, 3};
                sVarArr = new cn.fly.verify.s[4];
                while (i < 4) {
                    cn.fly.verify.l lVar = sparseArray.get(iArr[i]);
                    if (lVar != null) {
                        sVarArr[i] = cn.fly.verify.as.a(null, iArr[i], lVar.b, lVar.c, lVar.d(), lVar.e(), lVar.f(), this.a).b(true);
                    }
                    i++;
                }
                this.a.a((java.lang.String) null, (java.lang.String) null, "unknown_try");
                i = 1;
            } else {
                cn.fly.verify.l lVar2 = sparseArray.get(a4);
                if (lVar2 == null) {
                    cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "no operator config");
                    cn.fly.verify.common.exception.VerifyException verifyException4 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_UNSUPPORTED_OPERATOR);
                    cn.fly.verify.common.exception.VerifyErr verifyErr2 = cn.fly.verify.common.exception.VerifyErr.INNER_NO_OPERATOR_CONFIG;
                    verifyException4.setExtraDesc(verifyErr2.getMessage());
                    this.a.a(verifyException4, new cn.fly.verify.common.exception.VerifyException(verifyErr2), cn.fly.verify.as.a(a4));
                    cn.fly.verify.p.this.a(true).a(this.a);
                    verifyException4.setSerialId(this.a.b());
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException4);
                    return;
                }
                if (android.text.TextUtils.isEmpty(lVar2.b) || android.text.TextUtils.isEmpty(lVar2.c)) {
                    cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "no appid");
                    cn.fly.verify.common.exception.VerifyException verifyException5 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_APPID_NULL);
                    this.a.a(verifyException5, verifyException5, cn.fly.verify.as.a(a4));
                    cn.fly.verify.p.this.a(true).a(this.a);
                    verifyException5.setSerialId(this.a.b());
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException5);
                    return;
                }
                this.a.b(java.lang.Integer.valueOf(lVar2.d()));
                sVarArr = new cn.fly.verify.s[]{cn.fly.verify.as.a(null, a4, lVar2.b, lVar2.c, lVar2.d(), lVar2.e(), lVar2.f(), this.a)};
                cn.fly.verify.p.this.g = lVar2.b;
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "aid:" + lVar2.b + ", us: " + (java.lang.System.currentTimeMillis() - cn.fly.verify.p.this.c));
                this.a.a(cn.fly.verify.as.a(a4), lVar2.b, "get_ci");
            }
            cn.fly.verify.o.a().a(new cn.fly.verify.p.AnonymousClass3.AnonymousClass1(i, sparseArray, a4, a), true, sVarArr);
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH;
            cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(verifyErr.getCode(), cn.fly.verify.as.a(th));
            cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
            this.a.a(verifyException2, verifyException);
            cn.fly.verify.p.this.a(true).a(this.a);
            verifyException2.setSerialId(this.a.b());
            cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) this.c, (cn.fly.verify.pure.entity.PreVerifyResult) null, verifyException2);
        }
    }

    /* renamed from: cn.fly.verify.p$4, reason: invalid class name */
    public class AnonymousClass4 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback a;

        public AnonymousClass4(cn.fly.verify.common.callback.OperationCallback operationCallback) {
            this.a = operationCallback;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.e eVar = new cn.fly.verify.e(cn.fly.verify.g.VERIFY);
            try {
                if (cn.fly.verify.ax.h()) {
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.a, (cn.fly.verify.pure.entity.VerifyResult) null, new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_PRIVACY_NOT_ACCEPTED_ERROR));
                    return;
                }
                eVar.a((java.lang.String) null, (java.lang.String) null, com.anythink.expressad.foundation.d.c.bT);
                if (cn.fly.verify.fh.d.b()) {
                    cn.fly.verify.p.this.a(true).b();
                    cn.fly.verify.p.this.a(false).a();
                    cn.fly.verify.p.this.a(eVar, this.a);
                } else {
                    cn.fly.verify.f.a().a("not main process");
                    cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), "not main process");
                    cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_VERIFY_CATCH);
                    eVar.a(verifyException2, verifyException);
                    verifyException2.setSerialId(eVar.b());
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.a, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException2);
                }
            } catch (java.lang.Throwable th) {
                java.lang.String a = cn.fly.verify.as.a(th);
                cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.C_VERIFY_CATCH;
                cn.fly.verify.common.exception.VerifyException verifyException3 = new cn.fly.verify.common.exception.VerifyException(verifyErr.getCode(), a);
                cn.fly.verify.common.exception.VerifyException verifyException4 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
                eVar.a(verifyException4, verifyException3);
                verifyException4.setSerialId(eVar.b());
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.a, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException4);
            }
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            cn.fly.verify.p.this.a(false).a(new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_VERIFY_CATCH.getCode(), cn.fly.verify.as.a(th)));
        }
    }

    /* renamed from: cn.fly.verify.p$5, reason: invalid class name */
    public class AnonymousClass5 extends cn.fly.verify.ar {
        final /* synthetic */ cn.fly.verify.e a;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback b;

        /* renamed from: cn.fly.verify.p$5$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> {
            final /* synthetic */ cn.fly.verify.s a;
            final /* synthetic */ cn.fly.verify.l b;

            public AnonymousClass1(cn.fly.verify.s sVar, cn.fly.verify.l lVar) {
                this.a = sVar;
                this.b = lVar;
            }

            @Override // cn.fly.verify.common.callback.OperationCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onComplete(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
                cn.fly.verify.p.this.e = preVerifyResult;
                cn.fly.verify.p.AnonymousClass5 anonymousClass5 = cn.fly.verify.p.AnonymousClass5.this;
                cn.fly.verify.p.this.a(this.a, (cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass5.b, anonymousClass5.a, this.b.b);
            }

            @Override // cn.fly.verify.common.callback.OperationCallback
            public void onFailure(cn.fly.verify.common.exception.VerifyException verifyException) {
                cn.fly.verify.p.AnonymousClass5.this.a.a(this.a.a, this.b.b, verifyException);
                verifyException.setSerialId(cn.fly.verify.p.AnonymousClass5.this.a.b());
                cn.fly.verify.p.AnonymousClass5 anonymousClass5 = cn.fly.verify.p.AnonymousClass5.this;
                cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass5.b, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException);
            }
        }

        public AnonymousClass5(cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback operationCallback) {
            this.a = eVar;
            this.b = operationCallback;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
        @Override // cn.fly.verify.ar
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            cn.fly.verify.l lVar;
            cn.fly.verify.l lVar2;
            cn.fly.verify.l lVar3;
            android.util.SparseArray<cn.fly.verify.l> a;
            cn.fly.verify.l lVar4;
            cn.fly.verify.common.exception.VerifyException verifyException;
            cn.fly.verify.e eVar;
            cn.fly.verify.common.exception.VerifyException verifyException2;
            cn.fly.verify.p.this.a(this.a);
            int a2 = cn.fly.verify.p.a(cn.fly.verify.as.a(true));
            if (a2 == 5 && cn.fly.verify.ai.a().k().booleanValue() && cn.fly.verify.p.this.e != null) {
                a2 = cn.fly.verify.p.c(cn.fly.verify.p.this.e.getChannel());
            }
            if (a2 == 5) {
                verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_UNSUPPORTED_OPERATOR);
                verifyException.setExtraDesc("unknown operator");
                eVar = this.a;
                verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_UNKNOWN_OPERATOR);
            } else {
                if (a2 == 2 && cn.fly.verify.p.this.e != null && "CUXW".equals(cn.fly.verify.p.this.e.getChannel())) {
                    a2 = 3;
                }
                cn.fly.verify.p.this.a(this.a, this.b, a2, false);
                this.a.a(cn.fly.verify.as.a(a2), (java.lang.String) null, "get_cc");
                android.util.SparseArray<cn.fly.verify.l> a3 = cn.fly.verify.l.a();
                android.util.SparseArray<cn.fly.verify.l> c = cn.fly.verify.l.c();
                boolean z = (a3 == null || c == null || a3.get(a2) == null || c.get(a2) == null || a3.get(a2).b == null || a3.get(a2).b.equals(c.get(a2).b)) ? false : true;
                if (z) {
                    lVar4 = a3.get(a2);
                } else {
                    if (c != null) {
                        lVar2 = c.get(a2);
                    } else if (a3 != null) {
                        lVar2 = a3.get(a2);
                    } else {
                        lVar = null;
                        if (lVar == null) {
                            android.util.SparseArray<cn.fly.verify.l> a4 = cn.fly.verify.m.a();
                            if (a4 != null) {
                                cn.fly.verify.ai.a().a(0);
                                this.a.a((java.lang.String) null, (java.lang.String) null, "use_ca");
                                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use cache config");
                                lVar = a4.get(a2);
                            }
                            if (lVar == null && (a = cn.fly.verify.n.a(2000L, moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME, this.a)) != null) {
                                cn.fly.verify.ai.a().a(2);
                                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use server config");
                                lVar4 = a.get(a2);
                            }
                        }
                        lVar3 = lVar;
                        if (lVar3 != null) {
                            this.a.b(java.lang.Integer.valueOf(lVar3.d()));
                            cn.fly.verify.s a5 = cn.fly.verify.as.a(null, a2, lVar3.b, lVar3.c, lVar3.d(), lVar3.e(), lVar3.f(), this.a);
                            this.a.a(cn.fly.verify.as.a(a2), lVar3.b, "get_ci");
                            if (!z || cn.fly.verify.p.this.a.get() != null) {
                                cn.fly.verify.p.this.a(a5, (cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.b, this.a, lVar3.b);
                                return;
                            }
                            cn.fly.verify.f.a().a("[FlyVerify] ==>%s", "pre3：" + lVar3.b);
                            cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) new cn.fly.verify.p.AnonymousClass5.AnonymousClass1(a5, lVar3), true, a5);
                            return;
                        }
                        verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.C_UNSUPPORTED_OPERATOR);
                        verifyException.setExtraDesc("no operator config");
                        eVar = this.a;
                        verifyException2 = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_NO_OPERATOR_CONFIG);
                    }
                    lVar = lVar2;
                    if (lVar == null) {
                    }
                    lVar3 = lVar;
                    if (lVar3 != null) {
                    }
                }
                lVar3 = lVar4;
                if (lVar3 != null) {
                }
            }
            eVar.a(verifyException, verifyException2);
            verifyException.setSerialId(this.a.b());
            cn.fly.verify.p.this.a(false).a(this.a);
            cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.b, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException);
        }

        @Override // cn.fly.verify.ar
        public void a(java.lang.Throwable th) {
            java.lang.String a = cn.fly.verify.as.a(th);
            cn.fly.verify.common.exception.VerifyErr verifyErr = cn.fly.verify.common.exception.VerifyErr.C_VERIFY_CATCH;
            cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(verifyErr.getCode(), a);
            cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(verifyErr);
            this.a.a(verifyException2, verifyException);
            cn.fly.verify.p.this.a(false).a(this.a);
            verifyException2.setExtraDesc(this.a.b());
            verifyException2.setSerialId(this.a.b());
            cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) this.b, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException2);
        }
    }

    /* renamed from: cn.fly.verify.p$6, reason: invalid class name */
    public class AnonymousClass6 implements android.os.Handler.Callback {
        final /* synthetic */ cn.fly.verify.pure.entity.VerifyResult a;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback b;
        final /* synthetic */ cn.fly.verify.common.exception.VerifyException c;

        public AnonymousClass6(cn.fly.verify.pure.entity.VerifyResult verifyResult, cn.fly.verify.common.callback.OperationCallback operationCallback, cn.fly.verify.common.exception.VerifyException verifyException) {
            this.a = verifyResult;
            this.b = operationCallback;
            this.c = verifyException;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            cn.fly.verify.pure.entity.VerifyResult verifyResult = this.a;
            if (verifyResult != null) {
                this.b.onComplete(verifyResult);
                return false;
            }
            this.b.onFailure(this.c);
            return false;
        }
    }

    /* renamed from: cn.fly.verify.p$7, reason: invalid class name */
    public class AnonymousClass7 implements android.os.Handler.Callback {
        final /* synthetic */ cn.fly.verify.pure.entity.PreVerifyResult a;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback b;
        final /* synthetic */ cn.fly.verify.common.exception.VerifyException c;

        public AnonymousClass7(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.common.callback.OperationCallback operationCallback, cn.fly.verify.common.exception.VerifyException verifyException) {
            this.a = preVerifyResult;
            this.b = operationCallback;
            this.c = verifyException;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult = this.a;
            if (preVerifyResult != null) {
                this.b.onComplete(preVerifyResult);
                return false;
            }
            this.b.onFailure(this.c);
            return false;
        }
    }

    /* renamed from: cn.fly.verify.p$8, reason: invalid class name */
    public class AnonymousClass8 extends cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> {
        final /* synthetic */ cn.fly.verify.e a;
        final /* synthetic */ android.util.SparseArray b;
        final /* synthetic */ cn.fly.verify.s c;

        public AnonymousClass8(cn.fly.verify.e eVar, android.util.SparseArray sparseArray, cn.fly.verify.s sVar) {
            this.a = eVar;
            this.b = sparseArray;
            this.c = sVar;
        }

        @Override // cn.fly.verify.common.callback.OperationCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onComplete(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
            cn.fly.verify.p.this.e = preVerifyResult;
            cn.fly.verify.c b = this.a.b("pre_2_s");
            b.e(((cn.fly.verify.l) this.b.get(cn.fly.verify.p.this.f)).b);
            b.f(preVerifyResult.getChannel());
            this.a.a(b);
            this.a.c();
            cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        }

        @Override // cn.fly.verify.common.callback.OperationCallback
        public void onFailure(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.c b = this.a.b("pre_2_f");
            b.e(((cn.fly.verify.l) this.b.get(cn.fly.verify.p.this.f)).b);
            b.f(this.c.a);
            this.a.a(b);
            this.a.c();
            cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        }
    }

    /* renamed from: cn.fly.verify.p$9, reason: invalid class name */
    public class AnonymousClass9 implements cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.VerifyResult> {
        final /* synthetic */ cn.fly.verify.s a;
        final /* synthetic */ cn.fly.verify.e b;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback c;
        final /* synthetic */ java.lang.String d;

        /* renamed from: cn.fly.verify.p$9$1, reason: invalid class name */
        public class AnonymousClass1 extends cn.fly.verify.ar {
            final /* synthetic */ cn.fly.verify.pure.entity.VerifyResult a;

            public AnonymousClass1(cn.fly.verify.pure.entity.VerifyResult verifyResult) {
                this.a = verifyResult;
            }

            @Override // cn.fly.verify.ar
            public void a() {
                cn.fly.verify.common.exception.VerifyErr a;
                try {
                    cn.fly.verify.p.AnonymousClass9 anonymousClass9 = cn.fly.verify.p.AnonymousClass9.this;
                    if (cn.fly.verify.p.this.b(anonymousClass9.a, anonymousClass9.b, anonymousClass9.c, this.a.getOpToken())) {
                        return;
                    }
                    java.lang.String[] a2 = cn.fly.verify.C0545r.a().a(this.a.getOpToken(), this.a.getOperator(), cn.fly.verify.p.AnonymousClass9.this.a, this.a.getOpToken());
                    cn.fly.verify.p.AnonymousClass9 anonymousClass92 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.c b = anonymousClass92.b.b(anonymousClass92.a.a, anonymousClass92.d);
                    b.d(a2[1]);
                    cn.fly.verify.p.AnonymousClass9.this.b.b(b);
                    this.a.setToken(a2[0]);
                    cn.fly.verify.p.this.a(false).a(cn.fly.verify.p.AnonymousClass9.this.b);
                    cn.fly.verify.p.AnonymousClass9 anonymousClass93 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass93.c, this.a, (cn.fly.verify.common.exception.VerifyException) null);
                } catch (java.lang.Throwable th) {
                    if (th instanceof cn.fly.verify.common.exception.VerifyException) {
                        cn.fly.verify.p.AnonymousClass9 anonymousClass94 = cn.fly.verify.p.AnonymousClass9.this;
                        a = anonymousClass94.b.a(anonymousClass94.a.a, anonymousClass94.d, th);
                    } else {
                        cn.fly.verify.p.AnonymousClass9 anonymousClass95 = cn.fly.verify.p.AnonymousClass9.this;
                        a = anonymousClass95.b.a(anonymousClass95.a.a, anonymousClass95.d, new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode(), cn.fly.verify.as.a(th)));
                    }
                    cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(a);
                    cn.fly.verify.p.this.a(false).a(cn.fly.verify.p.AnonymousClass9.this.b);
                    verifyException.setSerialId(cn.fly.verify.p.AnonymousClass9.this.b.b());
                    cn.fly.verify.p.AnonymousClass9 anonymousClass96 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass96.c, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException);
                }
            }
        }

        /* renamed from: cn.fly.verify.p$9$2, reason: invalid class name */
        public class AnonymousClass2 extends cn.fly.verify.ar {
            final /* synthetic */ cn.fly.verify.common.exception.VerifyException a;

            public AnonymousClass2(cn.fly.verify.common.exception.VerifyException verifyException) {
                this.a = verifyException;
            }

            @Override // cn.fly.verify.ar
            public void a() {
                try {
                    java.lang.String str = "";
                    cn.fly.verify.s sVar = cn.fly.verify.p.AnonymousClass9.this.a;
                    if (sVar != null && sVar.a() != null && cn.fly.verify.p.AnonymousClass9.this.a.a().containsKey("optoken")) {
                        str = (java.lang.String) cn.fly.verify.p.AnonymousClass9.this.a.a().get("optoken");
                    }
                    cn.fly.verify.p.AnonymousClass9 anonymousClass9 = cn.fly.verify.p.AnonymousClass9.this;
                    if (cn.fly.verify.p.this.b(anonymousClass9.a, anonymousClass9.b, anonymousClass9.c, str)) {
                        return;
                    }
                    cn.fly.verify.p.AnonymousClass9 anonymousClass92 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(anonymousClass92.b.a(anonymousClass92.a.a, anonymousClass92.d, this.a));
                    cn.fly.verify.p.this.a(false).a(cn.fly.verify.p.AnonymousClass9.this.b);
                    verifyException.setSerialId(cn.fly.verify.p.AnonymousClass9.this.b.b());
                    cn.fly.verify.p.AnonymousClass9 anonymousClass93 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass93.c, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException);
                } catch (cn.fly.verify.common.exception.VerifyException unused) {
                    cn.fly.verify.p.AnonymousClass9 anonymousClass94 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.common.exception.VerifyException verifyException2 = new cn.fly.verify.common.exception.VerifyException(anonymousClass94.b.a(anonymousClass94.a.a, anonymousClass94.d, this.a));
                    cn.fly.verify.p.this.a(false).a(cn.fly.verify.p.AnonymousClass9.this.b);
                    verifyException2.setSerialId(cn.fly.verify.p.AnonymousClass9.this.b.b());
                    cn.fly.verify.p.AnonymousClass9 anonymousClass95 = cn.fly.verify.p.AnonymousClass9.this;
                    cn.fly.verify.p.this.a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) anonymousClass95.c, (cn.fly.verify.pure.entity.VerifyResult) null, verifyException2);
                }
            }
        }

        public AnonymousClass9(cn.fly.verify.s sVar, cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback operationCallback, java.lang.String str) {
            this.a = sVar;
            this.b = eVar;
            this.c = operationCallback;
            this.d = str;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.as.a(new cn.fly.verify.p.AnonymousClass9.AnonymousClass2(verifyException));
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.pure.entity.VerifyResult verifyResult) {
            cn.fly.verify.as.a(new cn.fly.verify.p.AnonymousClass9.AnonymousClass1(verifyResult));
        }
    }

    private p() {
        new cn.fly.verify.be().c();
    }

    public static int a(java.lang.String str) {
        int a = cn.fly.verify.as.a(str);
        if (a == 1) {
            return 1;
        }
        return a == 2 ? cn.fly.verify.m.b() ? 3 : 2 : a == 3 ? 4 : 5;
    }

    public static cn.fly.verify.p a() {
        if (b == null) {
            synchronized (cn.fly.verify.p.class) {
                if (b == null) {
                    b = new cn.fly.verify.p();
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.e eVar) {
        cn.fly.verify.l lVar;
        cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        if (eVar.d()) {
            return;
        }
        android.util.SparseArray<cn.fly.verify.l> a = cn.fly.verify.l.a();
        android.util.SparseArray<cn.fly.verify.l> c = cn.fly.verify.l.c();
        this.f = i;
        if (preVerifyResult != null) {
            try {
                if ("CUXW".equals(preVerifyResult.getChannel())) {
                    this.f = 3;
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.as.a(th);
                cn.fly.verify.c b2 = eVar.b("pre_2_f");
                b2.e(c.get(this.f).b);
                b2.f(cn.fly.verify.as.a(this.f));
                eVar.a(b2);
                eVar.c();
                return;
            }
        }
        if (a != null && (lVar = a.get(this.f)) != null) {
            java.lang.String str = lVar.b;
            java.lang.String str2 = lVar.c;
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2) && !c.get(this.f).b.equals(str)) {
                cn.fly.verify.s a2 = cn.fly.verify.as.a(null, this.f, str, str2, lVar.d(), lVar.e(), lVar.f(), eVar);
                cn.fly.verify.l.a(a);
                a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) new cn.fly.verify.p.AnonymousClass8(eVar, a, a2), false, a2);
                return;
            }
        }
        cn.fly.verify.c b3 = eVar.b("pre_2_no");
        b3.e(c.get(this.f).b);
        b3.f(cn.fly.verify.as.a(this.f));
        eVar.a(b3);
        eVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.common.exception.VerifyException verifyException) {
        cn.fly.verify.f a;
        java.lang.String str;
        cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        if (operationCallback == null) {
            cn.fly.verify.at a2 = a(true);
            if (preVerifyResult == null) {
                preVerifyResult = verifyException;
            }
            a2.a(preVerifyResult);
            return;
        }
        if (operationCallback.isCanceled()) {
            a = cn.fly.verify.f.a();
            str = "get result , but already timeout";
        } else {
            operationCallback.setCanceled(true);
            cn.fly.verify.ft.a(0, new cn.fly.verify.p.AnonymousClass7(preVerifyResult, operationCallback, verifyException));
            cn.fly.verify.at a3 = a(true);
            if (preVerifyResult == null) {
                preVerifyResult = verifyException;
            }
            a3.a(preVerifyResult);
            a = cn.fly.verify.f.a();
            str = "get result , cancel timeout";
        }
        a.b("[FlyVerify] ==>%s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback, cn.fly.verify.pure.entity.VerifyResult verifyResult, cn.fly.verify.common.exception.VerifyException verifyException) {
        cn.fly.verify.f a;
        java.lang.String str;
        cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        if (operationCallback == null) {
            cn.fly.verify.at a2 = a(false);
            if (verifyResult == null) {
                verifyResult = verifyException;
            }
            a2.a(verifyResult);
            return;
        }
        if (operationCallback.isCanceled()) {
            a = cn.fly.verify.f.a();
            str = "get result , but already timeout";
        } else {
            operationCallback.setCanceled(true);
            this.a.set(null);
            cn.fly.verify.ft.a(0, new cn.fly.verify.p.AnonymousClass6(verifyResult, operationCallback, verifyException));
            cn.fly.verify.at a3 = a(false);
            if (verifyResult == null) {
                verifyResult = verifyException;
            }
            a3.a(verifyResult);
            a = cn.fly.verify.f.a();
            str = "get result , cancel timeout";
        }
        a.b("[FlyVerify] ==>%s", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z, cn.fly.verify.s... sVarArr) {
        cn.fly.verify.o.a().a(operationCallback, z, sVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.fly.verify.e eVar) {
        java.lang.String str;
        java.lang.String str2;
        try {
            if (8 == cn.fly.verify.aq.k()) {
                cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult = this.e;
                if (preVerifyResult != null) {
                    str = preVerifyResult.getSecurityPhone();
                    str2 = this.e.getOperator();
                } else {
                    str = null;
                    str2 = null;
                }
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "request cache before verify");
                cn.fly.verify.k.a().a(str2, str, eVar, null);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback operationCallback, int i, boolean z) {
        long j = this.d;
        java.lang.Long l = cn.fly.verify.ak.b;
        if (l != null && z) {
            j = l.longValue();
            if (j < 2000) {
                j = this.d;
            }
            if (eVar != null) {
                eVar.a(cn.fly.verify.as.a(i), (java.lang.String) null, "timeout", java.lang.String.valueOf(l));
            }
        } else if (i == 4) {
            j *= 2;
        }
        long j2 = j;
        int t = cn.fly.verify.ai.a().t();
        cn.fly.verify.f.a().a("isOperatorCode:" + t);
        new cn.fly.verify.p.AnonymousClass2(j2, operationCallback, z, t, i, eVar).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cn.fly.verify.s sVar, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback, cn.fly.verify.e eVar, java.lang.String str) {
        a(sVar, eVar, operationCallback, str);
    }

    private void a(cn.fly.verify.s sVar, cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback, java.lang.String str) {
        sVar.b(new cn.fly.verify.p.AnonymousClass9(sVar, eVar, operationCallback, str));
    }

    private boolean a(cn.fly.verify.a aVar, cn.fly.verify.s sVar) {
        java.lang.String str;
        boolean z = false;
        if (aVar != null && (str = aVar.e) != null && sVar != null && str.equals(sVar.b()) && aVar.f == cn.fly.verify.as.d()) {
            z = true;
        }
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "cache and current ope is same " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        boolean a = cn.fly.verify.as.a(cn.fly.verify.ax.g());
        return (a ? 10 : 0) + (cn.fly.verify.as.d() > -1 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback operationCallback, boolean z) {
        cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult;
        cn.fly.verify.common.exception.VerifyException verifyException;
        java.lang.Object a = a(z).a();
        if (a == null) {
            return false;
        }
        cn.fly.verify.e c = a(z).c();
        if (c != null) {
            eVar.c(c.e());
            eVar.a(c.d());
            eVar.b(c.f());
        }
        cn.fly.verify.pure.entity.VerifyResult verifyResult = null;
        if (a instanceof cn.fly.verify.common.exception.VerifyException) {
            verifyException = new cn.fly.verify.common.exception.VerifyException(eVar.a(cn.fly.verify.as.b(), this.g, (cn.fly.verify.common.exception.VerifyException) a));
            preVerifyResult = null;
        } else if (a instanceof cn.fly.verify.pure.entity.PreVerifyResult) {
            preVerifyResult = (cn.fly.verify.pure.entity.PreVerifyResult) a;
            eVar.a(preVerifyResult.getOperator(), this.g);
            verifyException = null;
        } else if (a instanceof cn.fly.verify.pure.entity.VerifyResult) {
            cn.fly.verify.pure.entity.VerifyResult verifyResult2 = (cn.fly.verify.pure.entity.VerifyResult) a;
            eVar.a(verifyResult2.getOperator(), this.g);
            verifyException = null;
            verifyResult = verifyResult2;
            preVerifyResult = null;
        } else {
            preVerifyResult = null;
            verifyException = null;
        }
        if (z) {
            a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult>) operationCallback, preVerifyResult, verifyException);
            return true;
        }
        a((cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult>) operationCallback, verifyResult, verifyException);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(cn.fly.verify.s sVar, cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback, java.lang.String str) throws cn.fly.verify.common.exception.VerifyException {
        cn.fly.verify.a aVar = a().a.get();
        if (aVar == null || !a(aVar, sVar)) {
            return false;
        }
        if (eVar != null) {
            eVar.a(sVar.a, sVar.b, "usc", java.lang.String.valueOf(aVar.d));
        }
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "use server cache");
        cn.fly.verify.ai.a().b(1);
        cn.fly.verify.ai.a().a(aVar.d);
        cn.fly.verify.pure.entity.VerifyResult verifyResult = new cn.fly.verify.pure.entity.VerifyResult(aVar.b, aVar.a, sVar.b());
        java.lang.String[] a = cn.fly.verify.C0545r.a().a(verifyResult.getOpToken(), verifyResult.getOperator(), sVar, str);
        cn.fly.verify.c b2 = eVar.b(sVar.a, this.g);
        b2.d(a[1]);
        eVar.b(b2);
        verifyResult.setToken(a[0]);
        a(operationCallback, verifyResult, (cn.fly.verify.common.exception.VerifyException) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(java.lang.String str) {
        if ("CMCC".equals(str)) {
            return 1;
        }
        if ("CUXW".equals(str)) {
            return 3;
        }
        if ("CUCC".equals(str)) {
            return 2;
        }
        return "CTCC".equals(str) ? 4 : 5;
    }

    public cn.fly.verify.at a(boolean z) {
        if (z) {
            if (this.h == null) {
                this.h = new cn.fly.verify.at("preVerify");
            }
            return this.h;
        }
        if (this.i == null) {
            this.i = new cn.fly.verify.at("verify");
        }
        return this.i;
    }

    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback) {
        a(operationCallback, true);
    }

    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z) {
        a(operationCallback, z, false);
    }

    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z, boolean z2) {
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "start preVerify");
        this.c = java.lang.System.currentTimeMillis();
        new cn.fly.verify.p.AnonymousClass1(operationCallback, z2, z).b();
    }

    public void a(cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback) {
        cn.fly.verify.al.a(new cn.fly.verify.p.AnonymousClass5(eVar, operationCallback), true, eVar);
    }

    public void a(cn.fly.verify.e eVar, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z) {
        cn.fly.verify.al.a(new cn.fly.verify.p.AnonymousClass3(eVar, z, operationCallback), true, eVar);
    }

    public void b(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.VerifyResult> operationCallback) {
        cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "start verify");
        new cn.fly.verify.p.AnonymousClass4(operationCallback).b();
    }
}
