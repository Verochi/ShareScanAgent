package cn.fly.verify;

/* loaded from: classes.dex */
public class cs implements android.content.ServiceConnection, cn.fly.verify.cw<cn.fly.verify.cs> {
    private cn.fly.verify.cq a;

    public void a(cn.fly.verify.cq cqVar) {
        this.a = cqVar;
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cs csVar, java.lang.Class<cn.fly.verify.cs> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if (!"setHandler".equals(str) || objArr.length != 1) {
            return false;
        }
        csVar.a((cn.fly.verify.cq) objArr[0]);
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        if (this.a != null) {
            try {
                java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
                arrayList.add(componentName);
                arrayList.add(iBinder);
                this.a.a("onServiceConnected", arrayList);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        if (this.a != null) {
            java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
            arrayList.add(componentName);
            this.a.a("onServiceDisconnected", arrayList);
        }
    }
}
