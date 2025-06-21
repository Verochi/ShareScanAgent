package cn.fly.verify;

/* loaded from: classes.dex */
public class ff extends cn.fly.verify.ew {
    private java.lang.StringBuilder a = new java.lang.StringBuilder();

    public cn.fly.verify.ff a(java.lang.String str) {
        this.a.append(str);
        return this;
    }

    @Override // cn.fly.verify.ew
    public java.io.InputStream a() throws java.lang.Throwable {
        return new java.io.ByteArrayInputStream(this.a.toString().getBytes("utf-8"));
    }

    @Override // cn.fly.verify.ew
    public long b() throws java.lang.Throwable {
        return this.a.toString().getBytes("utf-8").length;
    }

    public java.lang.String toString() {
        return this.a.toString();
    }
}
