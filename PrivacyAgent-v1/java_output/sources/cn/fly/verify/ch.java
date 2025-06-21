package cn.fly.verify;

/* loaded from: classes.dex */
public class ch implements cn.fly.verify.cw<cn.fly.verify.ch> {
    private static final cn.fly.verify.fc a = new cn.fly.verify.fc();

    public static <T> T a(cn.fly.verify.fb fbVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.lang.String str, boolean z) throws java.lang.Throwable {
        return (T) fbVar.a(false, hashMap, hashMap2, str, z);
    }

    public static java.lang.String a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2) throws java.lang.Throwable {
        return a.a(str, hashMap, hashMap2);
    }

    public static java.lang.String a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        return a.b(str, hashMap, hashMap2, aVar);
    }

    public static void a(java.lang.String str, java.io.OutputStream outputStream, cn.fly.verify.fc.a aVar) throws java.lang.Throwable {
        a.a(str, outputStream, aVar);
    }

    @Override // cn.fly.verify.cw
    public boolean a(cn.fly.verify.ch chVar, java.lang.Class<cn.fly.verify.ch> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if ("hGet".equals(str)) {
            try {
                objArr2[0] = a((java.lang.String) objArr[0], (java.util.HashMap<java.lang.String, java.lang.Object>) objArr[1], (java.util.HashMap<java.lang.String, java.lang.String>) objArr[2]);
            } catch (java.lang.Throwable th) {
                thArr[0] = th;
                objArr2[0] = null;
            }
            return true;
        }
        if ("pst".equals(str)) {
            try {
                objArr2[0] = a((java.lang.String) objArr[0], (java.util.HashMap) objArr[1], (java.util.HashMap) objArr[2], (cn.fly.verify.fc.a) objArr[3]);
            } catch (java.lang.Throwable th2) {
                thArr[0] = th2;
                objArr2[0] = null;
            }
            return true;
        }
        if (cn.fly.verify.ds.b("008Rcbdcee^df(dcTc9cb").equals(str)) {
            try {
                a((java.lang.String) objArr[0], (java.io.OutputStream) objArr[1], (cn.fly.verify.fc.a) objArr[2]);
            } catch (java.lang.Throwable th3) {
                thArr[0] = th3;
                objArr2[0] = null;
            }
            return true;
        }
        if (!cn.fly.verify.ds.b("007BciUe+cddicjCdb").equals(str)) {
            return false;
        }
        try {
            objArr2[0] = a((cn.fly.verify.fb) objArr[0], (java.util.HashMap) objArr[1], (java.util.HashMap) objArr[2], (java.lang.String) objArr[3], ((java.lang.Boolean) objArr[4]).booleanValue());
        } catch (java.lang.Throwable th4) {
            thArr[0] = th4;
            objArr2[0] = null;
        }
        return true;
    }
}
