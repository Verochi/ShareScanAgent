package com.igexin.push.core.b;

/* loaded from: classes31.dex */
public final class k implements java.lang.Comparable<com.igexin.push.core.b.k> {
    public long a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public byte[] e;
    public byte[] f;
    public java.lang.String g;
    public int h;
    public long i;
    private java.lang.String j;
    private long k;
    private int l;
    private long m;
    private int n;
    private int o;

    public k(long j, java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2, java.lang.String str4, int i, long j2) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = bArr;
        this.f = bArr2;
        this.g = str4;
        this.h = i;
        this.i = j2;
    }

    private k(byte[] bArr, java.lang.String str, long j) {
        this.f = bArr;
        this.j = str;
        this.k = j;
    }

    private int a(com.igexin.push.core.b.k kVar) {
        return (int) (this.k - kVar.k);
    }

    private long a() {
        return this.a;
    }

    private void a(int i) {
        this.h = i;
    }

    private void a(long j) {
        this.a = j;
    }

    private void a(java.lang.String str) {
        this.b = str;
    }

    private void a(byte[] bArr) {
        this.f = bArr;
    }

    private java.lang.String b() {
        return this.b;
    }

    private void b(int i) {
        this.l = i;
    }

    private void b(long j) {
        this.i = j;
    }

    private void b(java.lang.String str) {
        this.c = str;
    }

    private void b(byte[] bArr) {
        this.e = bArr;
    }

    private java.lang.String c() {
        return this.c;
    }

    private void c(int i) {
        this.n = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(java.lang.String str) {
        this.d = str;
    }

    private java.lang.String d() {
        return this.d;
    }

    private void d(int i) {
        this.o = i;
    }

    private void d(long j) {
        this.m = j;
    }

    private void d(java.lang.String str) {
        this.g = str;
    }

    private java.lang.String e() {
        return this.g;
    }

    private void e(java.lang.String str) {
        this.j = str;
    }

    private int f() {
        return this.h;
    }

    private long g() {
        return this.i;
    }

    private int h() {
        return this.l;
    }

    private long i() {
        return this.m;
    }

    private int j() {
        return this.n;
    }

    private int k() {
        return this.o;
    }

    private byte[] l() {
        return this.f;
    }

    private org.json.JSONObject m() {
        try {
            return new org.json.JSONObject(this.j);
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    private long n() {
        return this.k;
    }

    private java.lang.String o() {
        return this.j;
    }

    private byte[] p() {
        return this.e;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(com.igexin.push.core.b.k kVar) {
        return (int) (this.k - kVar.k);
    }
}
