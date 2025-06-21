package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class z {
    public boolean a = false;
    public int b = 4;

    public static java.lang.String a() {
        return "FormalHASDK_2.2.0.313" + com.huawei.hms.hatool.k1.a();
    }

    public void a(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.System.lineSeparator());
        sb.append("======================================= ");
        sb.append(java.lang.System.lineSeparator());
        sb.append(a());
        sb.append("");
        sb.append(java.lang.System.lineSeparator());
        sb.append("=======================================");
        this.b = i;
        this.a = true;
    }

    public void a(int i, java.lang.String str, java.lang.String str2) {
    }

    public void b(int i, java.lang.String str, java.lang.String str2) {
        a(i, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i) {
        return this.a && i >= this.b;
    }
}
