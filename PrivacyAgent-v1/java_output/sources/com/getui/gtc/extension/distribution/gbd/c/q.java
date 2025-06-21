package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class q {
    int a;
    java.lang.String b;
    java.lang.String c;
    int d;

    private q(int i) {
        this.b = "";
        this.c = "";
        this.d = -100;
        this.a = i;
    }

    private q(int i, java.lang.String str, java.lang.String str2) {
        this.d = -100;
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    private q(int i, java.lang.String str, java.lang.String str2, int i2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
    }

    private q(com.getui.gtc.extension.distribution.gbd.c.q qVar, int i) {
        this.a = -1;
        this.b = "";
        this.c = "";
        this.d = -100;
        this.a = qVar.a;
        this.b = qVar.b;
        this.c = qVar.c;
        this.d = i;
    }

    private int a() {
        return this.a;
    }

    private void a(java.lang.String str) {
        this.c = str;
    }

    private java.lang.String b() {
        return this.b;
    }

    private java.lang.String c() {
        return this.c;
    }

    private int d() {
        return this.d;
    }
}
