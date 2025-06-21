package cn.fly.verify.common.callback;

/* loaded from: classes.dex */
public class a {
    private boolean a;
    private int b;
    private final cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> c;

    /* renamed from: cn.fly.verify.common.callback.a$1, reason: invalid class name */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ cn.fly.verify.pure.entity.PreVerifyResult b;
        final /* synthetic */ cn.fly.verify.e c;

        public AnonymousClass1(java.lang.String str, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.e eVar) {
            this.a = str;
            this.b = preVerifyResult;
            this.c = eVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.common.callback.a.this.a(this.a, null, this.b.getSecurityPhone(), this.b, null, this.c);
        }
    }

    /* renamed from: cn.fly.verify.common.callback.a$2, reason: invalid class name */
    public class AnonymousClass2 extends cn.fly.verify.ar {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ cn.fly.verify.common.exception.VerifyException b;
        final /* synthetic */ cn.fly.verify.e c;

        public AnonymousClass2(java.lang.String str, cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.e eVar) {
            this.a = str;
            this.b = verifyException;
            this.c = eVar;
        }

        @Override // cn.fly.verify.ar
        public void a() {
            cn.fly.verify.common.callback.a.this.a(this.a, null, null, null, this.b, this.c);
        }
    }

    /* renamed from: cn.fly.verify.common.callback.a$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.common.callback.b<cn.fly.verify.a> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ cn.fly.verify.common.callback.OperationCallback b;
        final /* synthetic */ cn.fly.verify.pure.entity.PreVerifyResult c;
        final /* synthetic */ cn.fly.verify.common.exception.VerifyException d;

        public AnonymousClass3(java.lang.String str, cn.fly.verify.common.callback.OperationCallback operationCallback, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.common.exception.VerifyException verifyException) {
            this.a = str;
            this.b = operationCallback;
            this.c = preVerifyResult;
            this.d = verifyException;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.a aVar) {
            long currentTimeMillis = java.lang.System.currentTimeMillis() + 3600000;
            java.lang.String str = aVar.b;
            java.lang.String str2 = this.a;
            cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult = new cn.fly.verify.pure.entity.PreVerifyResult(str, str2, currentTimeMillis, str2);
            cn.fly.verify.common.callback.OperationCallback operationCallback = this.b;
            if (operationCallback != null) {
                operationCallback.onComplete(preVerifyResult);
            }
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult = this.c;
            if (preVerifyResult != null) {
                cn.fly.verify.common.callback.OperationCallback operationCallback = this.b;
                if (operationCallback != null) {
                    operationCallback.onComplete(preVerifyResult);
                    return;
                }
                return;
            }
            cn.fly.verify.common.exception.VerifyException verifyException2 = this.d;
            if (verifyException2 != null) {
                verifyException = verifyException2;
            }
            cn.fly.verify.common.callback.OperationCallback operationCallback2 = this.b;
            if (operationCallback2 != null) {
                operationCallback2.onFailure(verifyException);
            }
        }
    }

    public a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, cn.fly.verify.s... sVarArr) {
        int i = 0;
        for (cn.fly.verify.s sVar : sVarArr) {
            if (sVar != null) {
                i++;
            }
        }
        this.b = i;
        this.c = operationCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, java.lang.String str2, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.e eVar) {
        cn.fly.verify.k.a().a(str, str2, eVar, new cn.fly.verify.common.callback.a.AnonymousClass3(str, operationCallback, preVerifyResult, verifyException));
    }

    public void a(java.lang.String str, cn.fly.verify.common.exception.VerifyException verifyException, boolean z, cn.fly.verify.e eVar) {
        if (this.a) {
            cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
            return;
        }
        if (this.b == 1) {
            this.c.onFailure(verifyException);
            cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
            int k = cn.fly.verify.aq.k();
            if (z && (k == 3 || k == 6 || k == 4 || k == 7)) {
                java.util.concurrent.Executors.newSingleThreadExecutor().execute(new cn.fly.verify.common.callback.a.AnonymousClass2(str, verifyException, eVar));
            }
        }
        this.b--;
    }

    public boolean a(java.lang.String str, cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult, boolean z, cn.fly.verify.e eVar) {
        if (this.a) {
            cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
            return false;
        }
        this.a = true;
        this.c.onComplete(preVerifyResult);
        cn.fly.verify.au.a(cn.fly.verify.ax.g()).a();
        int k = cn.fly.verify.aq.k();
        if (z && (k == 2 || k == 4 || k == 7)) {
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new cn.fly.verify.common.callback.a.AnonymousClass1(str, preVerifyResult, eVar));
        }
        return true;
    }
}
