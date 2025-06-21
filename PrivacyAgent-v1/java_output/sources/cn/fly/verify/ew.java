package cn.fly.verify;

/* loaded from: classes.dex */
public abstract class ew {
    public abstract java.io.InputStream a() throws java.lang.Throwable;

    public abstract long b() throws java.lang.Throwable;

    public java.io.InputStream c() throws java.lang.Throwable {
        return new cn.fly.verify.ev(a());
    }
}
