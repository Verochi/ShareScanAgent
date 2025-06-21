package cn.fly.verify;

/* loaded from: classes.dex */
public class ct implements cn.fly.verify.cw<cn.fly.verify.cs> {
    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cs csVar, java.lang.Class<cn.fly.verify.cs> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        java.lang.Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof cn.fly.verify.cq)) {
            return false;
        }
        csVar.a((cn.fly.verify.cq) obj);
        return true;
    }
}
