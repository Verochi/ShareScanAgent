package cn.fly.verify;

/* loaded from: classes.dex */
public class ck {
    private final cn.fly.verify.fs a;

    public ck(java.lang.String str, int i) {
        cn.fly.verify.fs fsVar = new cn.fly.verify.fs(cn.fly.verify.ax.g());
        this.a = fsVar;
        fsVar.a(str, i);
    }

    public java.lang.Object a(java.lang.String str) {
        return this.a.d(str);
    }

    public void a(java.lang.String str, int i) {
        this.a.a(str, java.lang.Integer.valueOf(i));
    }

    public void a(java.lang.String str, long j) {
        this.a.a(str, java.lang.Long.valueOf(j));
    }

    public void a(java.lang.String str, java.lang.Object obj) {
        this.a.a(str, obj);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            this.a.e(str);
        } else {
            this.a.a(str, str2);
        }
    }

    public void a(java.lang.String str, boolean z) {
        this.a.a(str, java.lang.Boolean.valueOf(z));
    }

    public int b(java.lang.String str, int i) {
        return this.a.b(str, i);
    }

    public long b(java.lang.String str, long j) {
        return this.a.a(str, j);
    }

    public java.lang.String b(java.lang.String str, java.lang.String str2) {
        return this.a.b(str, str2);
    }

    public boolean b(java.lang.String str, boolean z) {
        return this.a.a(str, z);
    }
}
