package cn.fly.verify;

/* loaded from: classes.dex */
public class e {
    private cn.fly.verify.g b;
    private boolean d;
    private java.lang.Integer e;
    private java.lang.String f;
    private java.lang.Integer g;
    private long a = 0;
    private java.lang.String c = java.util.UUID.randomUUID().toString();

    /* renamed from: cn.fly.verify.e$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[cn.fly.verify.g.values().length];
            a = iArr;
            try {
                iArr[cn.fly.verify.g.PREVERIFY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[cn.fly.verify.g.VERIFY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[cn.fly.verify.g.INIT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[cn.fly.verify.g.AUTHPAGE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public e(cn.fly.verify.g gVar) {
        this.b = gVar;
        if (gVar == cn.fly.verify.g.INIT) {
            cn.fly.verify.ai.a().b(this.c);
        } else if (gVar == cn.fly.verify.g.PREVERIFY) {
            cn.fly.verify.ai.a().a(this.c);
        }
    }

    private void c(cn.fly.verify.c cVar) {
        cn.fly.verify.d.b(cVar);
    }

    private cn.fly.verify.common.exception.VerifyErr d(java.lang.String str) {
        return "CMCC".equals(str) ? "preVerify".equals(g()) ? cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CM_OPERATOR_ACCESS_CODE_ERR : cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CM_OPERATOR_ACCESS_TOKEN_ERR : "CTCC".equals(str) ? "preVerify".equals(g()) ? cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CT_OPERATOR_ACCESS_CODE_ERR : cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CT_OPERATOR_ACCESS_TOKEN_ERR : "CUCC".equals(str) ? "preVerify".equals(g()) ? cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CU_OPERATOR_ACCESS_CODE_ERR : cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_CU_OPERATOR_ACCESS_TOKEN_ERR : "CUXW".equals(str) ? "preVerify".equals(g()) ? cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_XW_OPERATOR_ACCESS_CODE_ERR : cn.fly.verify.common.exception.VerifyErr.C_ONE_KEY_OBTAIN_XW_OPERATOR_ACCESS_TOKEN_ERR : cn.fly.verify.common.exception.VerifyErr.C_PREVERIFY_CATCH;
    }

    private java.lang.String g() {
        int i = cn.fly.verify.e.AnonymousClass1.a[this.b.ordinal()];
        if (i == 1) {
            return "preVerify";
        }
        if (i == 2) {
            return "verify";
        }
        if (i == 3) {
            return "init";
        }
        if (i != 4) {
            return null;
        }
        return "authPageOpend";
    }

    public cn.fly.verify.c a(java.lang.String str, int i, java.lang.String str2, int i2, java.lang.String str3) {
        cn.fly.verify.c b = b(str);
        b.b(true);
        b.a(i);
        b.c(str2);
        b.b(i2);
        b.d(str3);
        return b;
    }

    public cn.fly.verify.c a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        cn.fly.verify.c b = b(g());
        b.e(str2);
        b.f(str);
        b.b(true);
        cn.fly.verify.common.exception.VerifyErr d = d(str);
        if (d != null) {
            b.a(d.getCode());
            b.c(d.getMessage());
        }
        b.b(i);
        b.d(str3);
        return b;
    }

    public cn.fly.verify.common.exception.VerifyErr a(java.lang.String str, java.lang.String str2, cn.fly.verify.common.exception.VerifyException verifyException) {
        a(a(str, str2, verifyException.getCode(), verifyException.getMessage()));
        c();
        return d(str);
    }

    public java.lang.String a() {
        return this.c;
    }

    public void a(cn.fly.verify.c cVar) {
        if (cVar != null) {
            c(cVar);
        }
    }

    public void a(cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.common.exception.VerifyException verifyException2) {
        a(a(g(), verifyException.getCode(), verifyException.getMessage(), verifyException2.getCode(), verifyException2.getMessage()));
        c();
    }

    @java.lang.Deprecated
    public void a(cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.common.exception.VerifyException verifyException2, java.lang.String str) {
        cn.fly.verify.c a = a(g(), verifyException.getCode(), verifyException.getMessage(), verifyException2.getCode(), verifyException2.getMessage());
        a.f(str);
        a(a);
        c();
    }

    public void a(java.lang.Integer num) {
        this.e = num;
    }

    public void a(java.lang.String str) {
        cn.fly.verify.c b = b(g());
        b.a(200);
        b.c(str);
        a(b);
        c();
    }

    public void a(java.lang.String str, java.lang.String str2) {
        a(b(str, str2));
        c();
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        cn.fly.verify.c b = b(str3);
        b.a(200);
        b.c("success");
        b.f(str);
        b.e(str2);
        b.b(this.d ? 300 : 200);
        a(b);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        cn.fly.verify.c b = b(str3);
        b.a(200);
        b.c("success");
        b.f(str);
        b.e(str2);
        b.c(str4);
        b.b(this.d ? 300 : 200);
        a(b);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public cn.fly.verify.c b(java.lang.String str) {
        long j = this.a;
        long j2 = 0;
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        if (j == 0) {
            this.a = uptimeMillis;
        } else {
            j2 = uptimeMillis - this.a;
        }
        cn.fly.verify.c cVar = new cn.fly.verify.c(this.b, str);
        cVar.a(this.c);
        cVar.c(j2);
        cVar.b(j2);
        cVar.a(java.lang.System.currentTimeMillis());
        java.lang.Integer num = this.e;
        if (num != null) {
            cVar.a(num);
        }
        java.lang.String str2 = this.f;
        if (str2 != null) {
            cVar.g(str2);
        }
        java.lang.Integer num2 = this.g;
        if (num2 != null) {
            cVar.b(num2);
        }
        return cVar;
    }

    public cn.fly.verify.c b(java.lang.String str, java.lang.String str2) {
        cn.fly.verify.c b = b(g());
        b.e(str2);
        b.f(str);
        b.a(200);
        b.c("success");
        return b;
    }

    public java.lang.String b() {
        int i = cn.fly.verify.e.AnonymousClass1.a[this.b.ordinal()];
        java.lang.String str = null;
        java.lang.String str2 = i != 1 ? i != 2 ? null : "verify" : "preVerify";
        if ("preVerify".equals(str2)) {
            str = cn.fly.verify.ai.a().c();
        } else if ("verify".equals(str2)) {
            str = cn.fly.verify.ai.a().b();
        }
        if (str == null || str.equals(this.c)) {
            return this.c;
        }
        return this.c + "," + str;
    }

    public void b(cn.fly.verify.c cVar) {
        cn.fly.verify.d.b(cVar);
        cn.fly.verify.d.b();
    }

    public void b(java.lang.Integer num) {
        this.g = num;
    }

    public void c() {
        cn.fly.verify.d.b();
    }

    public void c(java.lang.String str) {
        this.f = str;
    }

    public boolean d() {
        return this.d;
    }

    public java.lang.String e() {
        return this.f;
    }

    public java.lang.Integer f() {
        return this.g;
    }
}
