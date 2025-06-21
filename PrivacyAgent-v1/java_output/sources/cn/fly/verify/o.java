package cn.fly.verify;

/* loaded from: classes.dex */
public class o {
    private static cn.fly.verify.o a;

    /* renamed from: cn.fly.verify.o$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.common.callback.b<cn.fly.verify.pure.entity.PreVerifyResult> {
        final /* synthetic */ cn.fly.verify.common.callback.a a;
        final /* synthetic */ boolean b;
        final /* synthetic */ cn.fly.verify.e c;
        final /* synthetic */ cn.fly.verify.s d;

        public AnonymousClass1(cn.fly.verify.common.callback.a aVar, boolean z, cn.fly.verify.e eVar, cn.fly.verify.s sVar) {
            this.a = aVar;
            this.b = z;
            this.c = eVar;
            this.d = sVar;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            if (verifyException != null && this.d.a(verifyException.getCode()) && cn.fly.verify.ai.a().t() == 0) {
                verifyException.setCode(cn.fly.verify.common.exception.VerifyErr.INNER_OTHER_EXCEPTION_ERR.getCode());
            }
            this.a.a(this.d.b(), verifyException, this.b, this.c);
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.pure.entity.PreVerifyResult preVerifyResult) {
            if (this.a.a(preVerifyResult.getOperator(), preVerifyResult, this.b, this.c) && cn.fly.verify.ai.a().l() == 1) {
                cn.fly.verify.q.a().a(this.d.a);
                cn.fly.verify.q a = cn.fly.verify.q.a();
                cn.fly.verify.s sVar = this.d;
                a.a(sVar.a, sVar.b, sVar.c, sVar.d(), this.d.e(), this.d.f(), preVerifyResult.getExpireAt());
            }
        }
    }

    public static cn.fly.verify.o a() {
        if (a == null) {
            a = new cn.fly.verify.o();
        }
        return a;
    }

    public void a(cn.fly.verify.common.callback.OperationCallback<cn.fly.verify.pure.entity.PreVerifyResult> operationCallback, boolean z, cn.fly.verify.s... sVarArr) {
        cn.fly.verify.common.callback.a aVar = new cn.fly.verify.common.callback.a(operationCallback, sVarArr);
        for (int length = sVarArr.length; length >= 1; length--) {
            cn.fly.verify.s sVar = sVarArr[length - 1];
            if (sVar != null) {
                if (cn.fly.verify.ai.a().l() == 1) {
                    cn.fly.verify.q.a().a(sVar.a);
                }
                sVar.a(new cn.fly.verify.o.AnonymousClass1(aVar, z, sVar.c(), sVar));
            }
        }
    }
}
