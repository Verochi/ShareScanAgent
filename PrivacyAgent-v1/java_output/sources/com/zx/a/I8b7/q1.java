package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class q1 {
    public java.net.URL a;
    public java.lang.String b;
    public java.util.Map<java.lang.String, java.lang.String> c;
    public com.zx.a.I8b7.s1 d;
    public java.lang.String e;

    public static class a {
        public java.net.URL a;
        public java.lang.String b;
        public java.util.Map<java.lang.String, java.lang.String> c;
        public com.zx.a.I8b7.s1 d;
        public java.lang.String e;

        public a() {
            this.b = "GET";
            this.c = new java.util.HashMap();
            this.e = "";
        }

        public a(com.zx.a.I8b7.q1 q1Var) {
            this.a = q1Var.a;
            this.b = q1Var.b;
            this.d = q1Var.d;
            this.c = q1Var.c;
            this.e = q1Var.e;
        }

        public com.zx.a.I8b7.q1.a a(java.lang.String str) {
            if (str == null) {
                throw new java.lang.NullPointerException("url == null");
            }
            try {
                this.a = new java.net.URL(str);
                return this;
            } catch (java.net.MalformedURLException e) {
                throw new java.lang.IllegalArgumentException(e);
            }
        }
    }

    public q1(com.zx.a.I8b7.q1.a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        java.util.HashMap hashMap = new java.util.HashMap();
        this.c = hashMap;
        hashMap.putAll(aVar.c);
        this.d = aVar.d;
        this.e = aVar.e;
    }
}
