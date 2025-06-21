package cn.fly.verify;

/* loaded from: classes.dex */
public class ae extends cn.fly.verify.s {

    /* renamed from: cn.fly.verify.ae$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.common.callback.b {
        final /* synthetic */ cn.fly.verify.common.callback.b a;

        public AnonymousClass1(cn.fly.verify.common.callback.b bVar) {
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
            cn.fly.verify.common.callback.b bVar = this.a;
            if (bVar != null) {
                bVar.a((cn.fly.verify.common.callback.b) obj);
            }
        }
    }

    @Override // cn.fly.verify.s
    public java.lang.Object a(boolean z) {
        try {
            return cn.fly.verify.ag.d(this.b, this.c);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, android.net.Network network, java.lang.Object obj, cn.fly.verify.common.callback.b bVar, cn.fly.verify.e eVar) {
        if (obj != null && (obj instanceof java.util.HashMap)) {
            java.util.HashMap hashMap = (java.util.HashMap) obj;
            new cn.fly.verify.af((java.util.HashMap) hashMap.get("params"), (java.util.HashMap) hashMap.get("sign")).a(network, "https://auth.wosms.cn/dro/netm/v1.0/qc", new cn.fly.verify.ae.AnonymousClass1(bVar), this.c);
        } else if (bVar != null) {
            bVar.a(new cn.fly.verify.common.exception.VerifyException(302002, "params error"));
        }
    }
}
