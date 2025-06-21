package cn.fly.verify;

/* loaded from: classes.dex */
public class k {
    private static cn.fly.verify.k a;
    private int b = -1;

    /* renamed from: cn.fly.verify.k$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.common.callback.b<cn.fly.verify.a> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ cn.fly.verify.common.callback.b b;

        public AnonymousClass1(java.lang.String str, cn.fly.verify.common.callback.b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.a aVar) {
            if (aVar != null) {
                cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "response cache =" + aVar.b);
                if (aVar.c) {
                    aVar.e = this.a;
                    cn.fly.verify.p.a().a.set(aVar);
                    cn.fly.verify.common.callback.b bVar = this.b;
                    if (bVar != null) {
                        bVar.a((cn.fly.verify.common.callback.b) aVar);
                        return;
                    }
                }
            }
            cn.fly.verify.common.callback.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.a((cn.fly.verify.common.exception.VerifyException) null);
            }
        }

        @Override // cn.fly.verify.common.callback.b
        public void a(cn.fly.verify.common.exception.VerifyException verifyException) {
            cn.fly.verify.common.callback.b bVar = this.b;
            if (bVar != null) {
                bVar.a(verifyException);
            }
        }
    }

    private k() {
    }

    public static cn.fly.verify.k a() {
        if (a == null) {
            synchronized (cn.fly.verify.k.class) {
                if (a == null) {
                    a = new cn.fly.verify.k();
                }
            }
        }
        return a;
    }

    public void a(java.lang.String str, java.lang.String str2, cn.fly.verify.e eVar, cn.fly.verify.common.callback.b<cn.fly.verify.a> bVar) {
        cn.fly.verify.C0545r.a().a(str, str2, eVar, new cn.fly.verify.k.AnonymousClass1(str, bVar));
    }
}
