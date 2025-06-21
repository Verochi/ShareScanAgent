package com.efs.sdk.base.core.model;

/* loaded from: classes22.dex */
public final class a {
    java.lang.String a;
    byte b;
    int c = 0;
    java.lang.String d = "none";
    int e = 1;
    long f = 0;
    int g = 1;
    java.lang.String h = "";
    java.lang.String i = "";
    long j = 0;
    long k = 0;

    public a(java.lang.String str, byte b) {
        this.b = (byte) 2;
        this.a = str;
        if (b <= 0 || 3 < b) {
            throw new java.lang.IllegalArgumentException("log protocol flag invalid : ".concat(java.lang.String.valueOf((int) b)));
        }
        this.b = b;
    }
}
