package com.getui.gtc.extension.distribution.gbd.g;

/* loaded from: classes22.dex */
public abstract class d {
    public static final java.lang.String a = "HttpPlugin";
    public static final java.lang.String b = "utf-8";
    public static final int c = 30000;
    public static final int d = 60000;
    public java.lang.String e;
    public byte[] f;
    public java.io.InputStream g;
    public long h;
    public boolean l;
    public com.getui.gtc.extension.distribution.gbd.g.c m;
    public boolean n;
    public boolean o;
    public java.lang.String w;
    public java.lang.String x;
    public android.net.Network i = null;
    public android.util.Pair<android.net.Network, android.net.ConnectivityManager.NetworkCallback> j = null;
    public android.net.ConnectivityManager k = null;
    public int p = 30000;
    public int q = 60000;
    public boolean r = true;

    /* renamed from: s, reason: collision with root package name */
    public boolean f332s = true;
    public boolean t = false;
    public boolean u = true;
    public java.util.HashMap<java.lang.String, java.lang.String> v = new java.util.HashMap<>();

    public d() {
    }

    public d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a("HttpPlugin", "http url:".concat(java.lang.String.valueOf(str)));
        this.e = str;
        this.v.put("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
    }

    private void a(com.getui.gtc.extension.distribution.gbd.g.c cVar) {
        this.m = cVar;
    }

    private void a(java.io.InputStream inputStream, long j) {
        this.g = inputStream;
        this.h = j;
    }

    private void a(java.lang.String str) {
        this.e = str;
    }

    private void a(java.lang.String str, java.lang.String str2) {
        this.v.put(str, str2);
    }

    private void a(boolean z) {
        this.n = z;
    }

    private void a(byte[] bArr) {
        this.f = bArr;
    }

    private boolean a() {
        return this.n;
    }

    private void b(int i) {
        this.p = i;
    }

    private void b(java.lang.String str) {
        this.w = str;
    }

    private void b(boolean z) {
        this.o = z;
    }

    private boolean b() {
        return this.o;
    }

    private void c(int i) {
        this.q = i;
    }

    private void c(java.lang.String str) {
        this.x = str;
    }

    private void c(boolean z) {
        this.u = z;
    }

    private boolean c() {
        return this.u;
    }

    private void d(boolean z) {
        this.r = z;
    }

    private boolean d() {
        return this.t;
    }

    private void e() {
        this.t = true;
    }

    private void e(boolean z) {
        this.f332s = z;
    }

    private int f() {
        return this.p;
    }

    private int g() {
        return this.q;
    }

    private boolean h() {
        return this.r;
    }

    private boolean i() {
        return this.f332s;
    }

    private java.util.HashMap<java.lang.String, java.lang.String> j() {
        return this.v;
    }

    private boolean k() {
        return this.l;
    }

    private void l() {
        this.l = true;
    }

    private java.lang.String m() {
        return this.e;
    }

    private byte[] n() {
        return this.f;
    }

    private java.io.InputStream o() {
        return this.g;
    }

    private long p() {
        return this.h;
    }

    private java.lang.String q() {
        return this.w;
    }

    private java.lang.String r() {
        return this.x;
    }

    private com.getui.gtc.extension.distribution.gbd.g.c s() {
        return this.m;
    }

    private static void t() {
    }

    private static void u() {
    }

    public void a(int i) {
    }

    public void a(java.lang.Throwable th) {
    }

    public void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
    }
}
