package cn.fly.verify;

/* loaded from: classes.dex */
public class ce {
    private static final cn.fly.verify.cu a = new cn.fly.verify.cu();
    private static final cn.fly.verify.cn b = new cn.fly.verify.cn();
    private static volatile cn.fly.verify.cq c;
    private static volatile cn.fly.verify.cq d;

    /* renamed from: cn.fly.verify.ce$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.cq.a {
        @Override // cn.fly.verify.cq.a
        public java.lang.Object a(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList) {
            try {
                if (cn.fly.verify.ce.d != null) {
                    return cn.fly.verify.ce.d.a(str, arrayList);
                }
                return null;
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
    }

    /* renamed from: cn.fly.verify.ce$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.cq.a {
        @Override // cn.fly.verify.cq.a
        public java.lang.Object a(java.lang.String str, java.util.ArrayList<java.lang.Object> arrayList) {
            return str + "" + arrayList;
        }
    }

    static {
        try {
            c = new cn.fly.verify.cq(new cn.fly.verify.ce.AnonymousClass1());
            d = new cn.fly.verify.cq(new cn.fly.verify.ce.AnonymousClass2());
            c.a("tt", null);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static int a() {
        return cn.fly.verify.da.a();
    }

    public static java.util.LinkedList<java.lang.Object> a(java.lang.Object obj, java.lang.Object... objArr) throws java.lang.Throwable {
        return ((cn.fly.verify.dc) obj).b(objArr);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.reflect.Method method) throws java.lang.Throwable {
        a(cn.fly.verify.da.a(str), context, str2, method);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2) throws java.lang.Throwable {
        cn.fly.verify.da.c a2 = cn.fly.verify.da.a(str);
        a2.a("ss_dhMap", hashMap).a("ss_dataMaps", hashMap2);
        a(a2, context, str2, (java.lang.reflect.Method) null);
    }

    public static void a(android.content.Context context, byte[] bArr, java.lang.String str, java.lang.reflect.Method method) throws java.lang.Throwable {
        a(cn.fly.verify.da.a(bArr), context, str, method);
    }

    private static void a(cn.fly.verify.da.c cVar, android.content.Context context, java.lang.String str, java.lang.reflect.Method method) throws java.lang.Throwable {
        cVar.a(cn.fly.verify.bj.a("012Zhh]kg$ekPej$ejfe3f^fkWgj"), cn.fly.verify.cn.class).a(cn.fly.verify.bj.a("003Xidfifl"), cn.fly.verify.ch.class).a(cn.fly.verify.bj.a("004Kidfkhmgk"), cn.fly.verify.ck.class).a(cn.fly.verify.bj.a("015Kfkgjgk1efUedGhgVekfl6iYek<ge3ed"), cn.fly.verify.ec.class).a(cn.fly.verify.bj.a("019IfkgjgjekfeHe edLdeJgi2j9hjKgdgWejee%g<ek"), cn.fly.verify.cm.class).a(cn.fly.verify.bj.a("017Efkgjhlfe)fjgfjNhj4g!gifeDhDee%g0ek"), cn.fly.verify.cp.class).a(cn.fly.verify.bj.a("019-fkgjfk1g,ekeeejCdg%hlfe2ffgdjYejfeTf"), cn.fly.verify.cs.class).a(cn.fly.verify.bj.a("017PfkgjhlfeBfjgfjWhhgfgi!gFekeeOgYek"), cn.fly.verify.co.class).a(cn.fly.verify.bj.a("017Ifkgjfi>gjRggfeekemhlIehh+gf[edIem"), cn.fly.verify.cr.class).a(cn.fly.verify.bj.a("009Yfkgjgk8ef!edZhgBek"), cn.fly.verify.cq.class).a(cn.fly.verify.bj.a("003]idfihl"), cn.fly.verify.fb.class).a(cn.fly.verify.bj.a("004!idfiflhh"), cn.fly.verify.fc.a.class).a(cn.fly.verify.bj.a("003;gkfefj"), cn.fly.verify.Cdo.class).a(cn.fly.verify.cm.class, cn.fly.verify.cm.class).a(cn.fly.verify.co.class, cn.fly.verify.co.class).a(cn.fly.verify.cs.class, cn.fly.verify.ct.class).a(cn.fly.verify.cr.class, cn.fly.verify.cr.class).a(cn.fly.verify.cu.class, cn.fly.verify.cu.class).a(cn.fly.verify.cn.class, cn.fly.verify.cn.class).a(cn.fly.verify.ch.class, cn.fly.verify.ch.class).a(cn.fly.verify.ck.class, cn.fly.verify.cl.class).a(android.content.Context.class, cn.fly.verify.cg.class).a(android.content.pm.PackageManager.class, cn.fly.verify.cj.class).a(android.app.NotificationManager.class, cn.fly.verify.ci.class).a(cn.fly.verify.Cdo.class, cn.fly.verify.cf.class).a("ss_opSet", b).a("ss_suls", a).a(cn.fly.verify.bj.a("0159gigiei,d(feGfjgPfd(j?hmYeTekAe2eg"), context).a(cn.fly.verify.bj.a("014FgigieigiGje!ekTjDhm4e9ek-e6eggi"), str).a(cn.fly.verify.bj.a("0122gigieigi9je<ekMjSflejeg5g"), java.lang.Long.valueOf(java.lang.System.currentTimeMillis())).a(cn.fly.verify.bj.a("0060gigieieged)k"), method).a(cn.fly.verify.bj.a("016dNfeegegfe+fekKgegiedemge dQedUd"));
        cVar.a();
    }
}
