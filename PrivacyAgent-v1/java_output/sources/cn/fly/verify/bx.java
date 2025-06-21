package cn.fly.verify;

/* loaded from: classes.dex */
public class bx extends cn.fly.verify.bu {
    public bx(android.content.Context context) {
        super(context);
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        android.os.Bundle b = b(str, str2);
        if (a(b)) {
            str3 = "002Obgba";
        } else {
            if (b == null) {
                return null;
            }
            str3 = "007=bd8dTdfdfIb)ccJd";
        }
        return b.getString(cn.fly.verify.dn.a(str3));
    }

    private boolean a(android.os.Bundle bundle) {
        return bundle != null && bundle.getInt(cn.fly.verify.dn.a("004a;cbbaEd"), -1) == 0;
    }

    private android.os.Bundle b(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = null;
        try {
            android.net.Uri parse = android.net.Uri.parse(cn.fly.verify.dn.a("036a)cb5cgdcgijjacCdb^c^bedcbgZb]dbbgba_dcg?bgEg'biPjYbgba(dcg$bgLgCbi"));
            int i = android.os.Build.VERSION.SDK_INT;
            android.content.ContentProviderClient acquireUnstableContentProviderClient = this.a.getContentResolver().acquireUnstableContentProviderClient(parse);
            bundle = acquireUnstableContentProviderClient.call(str, str2, null);
            if (i >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
        return bundle;
    }

    private boolean f() {
        android.os.Bundle b = b(cn.fly.verify.dn.a("009HbgdfchbeXhhKcbbh%g"), null);
        if (a(b)) {
            return b.getBoolean(cn.fly.verify.dn.a("009UbgdfdfbeFhh cbbh'g"), true);
        }
        return false;
    }

    @Override // cn.fly.verify.bu
    public cn.fly.verify.bu.b b() {
        cn.fly.verify.bu.b bVar = new cn.fly.verify.bu.b();
        bVar.a = f();
        bVar.b = a(cn.fly.verify.dn.a("007.cc'dgOeecjcgdi"), (java.lang.String) null);
        return bVar;
    }
}
