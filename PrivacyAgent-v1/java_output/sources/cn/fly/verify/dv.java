package cn.fly.verify;

/* loaded from: classes.dex */
public class dv {

    /* renamed from: cn.fly.verify.dv$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.HashMap[] a;

        public AnonymousClass1(java.util.HashMap[] hashMapArr) {
            this.a = hashMapArr;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            this.a[0] = cn.fly.verify.dv.a(bVar.g());
            this.a[0].put(cn.fly.verify.dn.a("006+dfbabjbbLdJbh"), java.lang.Integer.valueOf(cn.fly.verify.ax.a));
            this.a[0].put(cn.fly.verify.dn.a("004Pbabebgba"), cn.fly.verify.df.a((cn.fly.verify.bd) null));
            this.a[0].put(cn.fly.verify.dn.a("006bhh^bb3dHbh"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.m()));
            this.a[0].put(cn.fly.verify.dn.a("007ab*bhbhbg]dWbh"), bVar.d());
            this.a[0].put(cn.fly.verify.dn.a("005Fbdcbba_de"), cn.fly.verify.fh.d.j());
            this.a[0].put(cn.fly.verify.dn.a("007CcdWbagVcbbhbi"), cn.fly.verify.fh.d.k());
            this.a[0].put(cn.fly.verify.dn.a("006*dfbidfbb[d8bh"), cn.fly.verify.fh.d.h());
            this.a[0].put(cn.fly.verify.dn.a("005?bebgbbEdObh"), bVar.p());
            this.a[0].put(cn.fly.verify.dn.a("009>dfbidfbb<d8bhbg@cg"), java.lang.Integer.valueOf(cn.fly.verify.fh.d.g()));
            this.a[0].put(cn.fly.verify.dn.a("010aeXbg.dcgIcibgbdNd"), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            this.a[0].put(cn.fly.verify.dn.a("006bhh<bdbafg"), bVar.f());
            this.a[0].put(cn.fly.verify.dn.a("005Wdcbh$bcFba"), cn.fly.verify.fh.d.l());
            this.a[0].put("usridt", cn.fly.verify.bk.c());
            this.a[0].put(cn.fly.verify.dn.a("004-bdcbbgba"), bVar.A());
        }
    }

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(cn.fly.verify.ds.a) && cn.fly.verify.ax.g() != null) {
            cn.fly.verify.ds.a(cn.fly.verify.ax.g());
        }
        return android.text.TextUtils.isEmpty(cn.fly.verify.ds.a) ? cn.fly.verify.ds.c : cn.fly.verify.ds.a;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        if (!c()) {
            return cn.fly.verify.dj.a().a(str, str2, str3, z);
        }
        cn.fly.verify.ed.a().a("isForb: true", new java.lang.Object[0]);
        return null;
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> a(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put(cn.fly.verify.dn.a("006bhhBbjRd^bi"), a());
        hashMap.put(cn.fly.verify.dn.a("006bhhhKbjcc"), cn.fly.verify.fh.d.c());
        hashMap.put(cn.fly.verify.dn.a("006bhhKbb_d^bh"), cn.fly.verify.fh.d.f());
        hashMap.put(cn.fly.verify.dn.a("004hebg"), java.lang.String.valueOf(cn.fly.verify.fh.d.e()));
        hashMap.put(cn.fly.verify.dn.a("011cdgKddcbbhbjYgNbi1hd"), str);
        java.lang.String b = cn.fly.verify.df.b();
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put(cn.fly.verify.dn.a("0042babebgba"), b);
        }
        return hashMap;
    }

    public static void a(boolean z) {
        try {
            cn.fly.verify.dy.a(z);
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
    }

    public static int b() {
        int d = cn.fly.verify.dy.d();
        if (d == 1) {
            return 1;
        }
        return d == 0 ? -1 : 0;
    }

    public static boolean c() {
        int b = b();
        if (b != 2 && b != 1) {
            return true;
        }
        cn.fly.verify.dy.g();
        return true ^ cn.fly.verify.bo.a();
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> d() {
        java.util.HashMap<java.lang.String, java.lang.Object>[] hashMapArr = {new java.util.HashMap<>()};
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).d().g().p().f().B().a(new cn.fly.verify.dv.AnonymousClass1(hashMapArr));
        return hashMapArr[0];
    }
}
