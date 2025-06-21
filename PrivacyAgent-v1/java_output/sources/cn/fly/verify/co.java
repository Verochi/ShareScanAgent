package cn.fly.verify;

/* loaded from: classes.dex */
public class co extends android.database.ContentObserver implements cn.fly.verify.cw<cn.fly.verify.co> {
    private cn.fly.verify.cq a;

    public co() {
        super(null);
    }

    public void a(cn.fly.verify.cq cqVar) {
        this.a = cqVar;
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.co coVar, java.lang.Class<cn.fly.verify.co> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        java.lang.Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof cn.fly.verify.cq)) {
            return false;
        }
        coVar.a((cn.fly.verify.cq) obj);
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.a != null) {
            java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>(1);
            arrayList.add(java.lang.Boolean.valueOf(z));
            this.a.a("onChange", arrayList);
        }
    }
}
