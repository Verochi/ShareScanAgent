package cn.fly.verify;

/* loaded from: classes.dex */
public class cr implements cn.fly.verify.cw<cn.fly.verify.cr> {
    private cn.fly.verify.cq a;

    /* renamed from: cn.fly.verify.cr$1, reason: invalid class name */
    public class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
        public AnonymousClass1() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
            arrayList.add(network);
            cn.fly.verify.cr.this.a.a(cn.fly.verify.ba.a("011;gfVg-gnffUfAfk;if4hgXih"), arrayList);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            super.onLost(network);
            java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
            arrayList.add(network);
            cn.fly.verify.cr.this.a.a(cn.fly.verify.ba.a("006OgfSg,hegfhjZk"), arrayList);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
        }
    }

    private android.net.ConnectivityManager.NetworkCallback a() {
        return new cn.fly.verify.cr.AnonymousClass1();
    }

    public void a(cn.fly.verify.cq cqVar) {
        this.a = cqVar;
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.cr crVar, java.lang.Class<cn.fly.verify.cr> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        java.lang.Object obj;
        if ("setHandler".equals(str) && objArr.length == 1 && (obj = objArr[0]) != null && (obj instanceof cn.fly.verify.cq)) {
            crVar.a((cn.fly.verify.cq) obj);
        } else {
            if (!cn.fly.verify.ba.a("019WfkGg8fk!k,gj5hk:hhgfflfnim fiiVhg7fe)fn").equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = crVar.a();
        }
        return true;
    }
}
