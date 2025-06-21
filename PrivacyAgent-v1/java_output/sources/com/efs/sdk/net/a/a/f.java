package com.efs.sdk.net.a.a;

/* loaded from: classes22.dex */
public interface f {

    public interface a {
        java.lang.String a(int i);

        java.lang.String b(int i);

        int e();
    }

    public interface b extends com.efs.sdk.net.a.a.f.c {
        java.lang.String b();

        java.lang.String c();

        @org.jetbrains.annotations.Nullable
        byte[] d();
    }

    public interface c extends com.efs.sdk.net.a.a.f.a {
        java.lang.String a();
    }

    public interface d extends com.efs.sdk.net.a.a.f.e {
    }

    public interface e extends com.efs.sdk.net.a.a.f.a {
        java.lang.String a();

        int b();
    }

    @org.jetbrains.annotations.Nullable
    java.io.InputStream a(java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2, @org.jetbrains.annotations.Nullable java.lang.String str3, @org.jetbrains.annotations.Nullable java.io.InputStream inputStream);

    void a();

    void a(com.efs.sdk.net.a.a.f.b bVar);

    void a(com.efs.sdk.net.a.a.f.d dVar);

    java.lang.String b();
}
