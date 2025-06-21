package cn.fly.verify;

/* loaded from: classes.dex */
public class cf implements cn.fly.verify.cw<cn.fly.verify.Cdo> {
    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.Cdo cdo, java.lang.Class<cn.fly.verify.Cdo> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if (cn.fly.verify.ba.a("004!gg,hkWhm").equals(str)) {
            objArr2[0] = cdo.a();
        } else if (cn.fly.verify.ba.a("008Hhj$hkGheCfkej").equals(str) && objArr != null && objArr.length == 1) {
            objArr2[0] = cdo.a((java.util.concurrent.CountDownLatch) objArr[0]);
        } else {
            if (!cn.fly.verify.ba.a("005<fkhjgl!lk").equals(str)) {
                return false;
            }
            objArr2[0] = java.lang.Boolean.valueOf(cdo.b());
        }
        return true;
    }
}
