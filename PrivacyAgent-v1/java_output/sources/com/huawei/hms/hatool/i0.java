package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class i0 implements com.huawei.hms.hatool.n0 {
    public byte[] a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.util.List<com.huawei.hms.hatool.q> f;

    public i0(byte[] bArr, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.List<com.huawei.hms.hatool.q> list) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    public final com.huawei.hms.hatool.b0 a(java.util.Map<java.lang.String, java.lang.String> map) {
        return com.huawei.hms.hatool.a0.a(this.b, this.a, map);
    }

    public final java.util.Map<java.lang.String, java.lang.String> a() {
        return com.huawei.hms.hatool.d1.b(this.c, this.e, this.d);
    }

    public final void b() {
        com.huawei.hms.hatool.o0.c().a(new com.huawei.hms.hatool.l0(this.f, this.c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hms.hatool.y.c("hmsSdk", "send data running");
        int b = a(a()).b();
        if (b != 200) {
            b();
            return;
        }
        com.huawei.hms.hatool.y.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.c, java.lang.Integer.valueOf(b));
    }
}
