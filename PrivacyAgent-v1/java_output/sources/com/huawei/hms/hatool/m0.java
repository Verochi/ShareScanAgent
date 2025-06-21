package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class m0 implements com.huawei.hms.hatool.n0 {
    public java.lang.String a;
    public java.lang.String b;

    public m0(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.huawei.hms.hatool.r0.a(this.a, this.b);
    }
}
