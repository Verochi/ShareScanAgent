package cn.fly.verify;

/* loaded from: classes.dex */
public class u {
    private int a;
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> b;
    private java.lang.String c;

    public u(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str) {
        this.a = i;
        this.b = map;
        this.c = str;
    }

    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> a() {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = this.b;
        return map == null ? new java.util.HashMap() : map;
    }

    public java.lang.String b() {
        java.lang.String str = this.c;
        return str == null ? "" : str;
    }

    public java.lang.String toString() {
        return "HttpSuccessResponse{responseCode=" + this.a + ", header=" + this.b + ", f208c='" + this.c + "'}";
    }
}
