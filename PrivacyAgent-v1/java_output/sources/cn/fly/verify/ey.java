package cn.fly.verify;

/* loaded from: classes.dex */
public class ey implements cn.fly.verify.ex {
    private java.net.HttpURLConnection a;

    public ey(java.net.HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    @Override // cn.fly.verify.ex
    public int a() throws java.io.IOException {
        return this.a.getResponseCode();
    }

    @Override // cn.fly.verify.ex
    public java.io.InputStream b() throws java.io.IOException {
        return this.a.getInputStream();
    }

    @Override // cn.fly.verify.ex
    public java.io.InputStream c() throws java.io.IOException {
        return this.a.getErrorStream();
    }

    @Override // cn.fly.verify.ex
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> d() throws java.io.IOException {
        return this.a.getHeaderFields();
    }
}
