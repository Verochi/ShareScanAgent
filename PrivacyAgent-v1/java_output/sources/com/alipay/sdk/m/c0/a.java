package com.alipay.sdk.m.c0;

/* loaded from: classes.dex */
public final class a {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;

    public a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.StringBuilder sb2;
        java.lang.String str2;
        java.lang.StringBuilder sb3;
        java.lang.String str3;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(java.util.Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.a);
        stringBuffer.append("," + this.b);
        stringBuffer.append("," + this.c);
        stringBuffer.append("," + this.d);
        if (com.alipay.sdk.m.z.a.a(this.e) || this.e.length() < 20) {
            sb = new java.lang.StringBuilder(",");
            str = this.e;
        } else {
            sb = new java.lang.StringBuilder(",");
            str = this.e.substring(0, 20);
        }
        sb.append(str);
        stringBuffer.append(sb.toString());
        if (com.alipay.sdk.m.z.a.a(this.f) || this.f.length() < 20) {
            sb2 = new java.lang.StringBuilder(",");
            str2 = this.f;
        } else {
            sb2 = new java.lang.StringBuilder(",");
            str2 = this.f.substring(0, 20);
        }
        sb2.append(str2);
        stringBuffer.append(sb2.toString());
        if (com.alipay.sdk.m.z.a.a(this.g) || this.g.length() < 20) {
            sb3 = new java.lang.StringBuilder(",");
            str3 = this.g;
        } else {
            sb3 = new java.lang.StringBuilder(",");
            str3 = this.g.substring(0, 20);
        }
        sb3.append(str3);
        stringBuffer.append(sb3.toString());
        return stringBuffer.toString();
    }
}
