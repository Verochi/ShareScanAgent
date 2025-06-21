package cn.fly.verify;

/* loaded from: classes.dex */
public class cm extends android.content.BroadcastReceiver implements cn.fly.verify.cw<cn.fly.verify.cm> {
    private cn.fly.verify.cq a;

    public void a(cn.fly.verify.cq cqVar) {
        this.a = cqVar;
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cm cmVar, java.lang.Class<cn.fly.verify.cm> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        java.lang.Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof cn.fly.verify.cq)) {
            return false;
        }
        cmVar.a((cn.fly.verify.cq) obj);
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (this.a != null) {
            try {
                java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>(1);
                arrayList.add(intent);
                this.a.a("onReceive", arrayList);
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
