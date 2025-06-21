package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public class j implements com.anythink.expressad.e.b, com.anythink.expressad.foundation.g.d.c, java.io.Serializable {
    private static final long a = 1;
    public static final int cR = 1;
    public static final int cS = 2;
    public static final int cT = 3;
    public java.lang.String cU;
    private double j;
    private java.lang.Object l;
    private java.lang.String n;
    private android.graphics.drawable.Drawable o;
    private android.graphics.drawable.Drawable p;
    private com.anythink.expressad.out.q q;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";
    private long i = 0;
    private int k = com.badlogic.gdx.graphics.GL30.GL_R32I;
    private int m = 1;
    private int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f251s = 0;
    private int t = 0;

    private android.graphics.drawable.Drawable a() {
        return this.o;
    }

    private static android.graphics.drawable.Drawable a(android.graphics.Bitmap bitmap) {
        return new android.graphics.drawable.BitmapDrawable(bitmap);
    }

    private void a(int i) {
        this.r = i;
    }

    private void a(android.graphics.drawable.Drawable drawable) {
        this.o = drawable;
    }

    private void a(com.anythink.expressad.out.q qVar) {
        this.q = qVar;
        if (android.text.TextUtils.isEmpty(this.g)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.g, this);
    }

    private void a(java.lang.Object obj) {
        this.l = obj;
    }

    private void a(java.lang.String str) {
        this.n = str;
    }

    private android.graphics.drawable.Drawable b() {
        return this.p;
    }

    private void b(int i) {
        this.f251s = i;
    }

    private void b(android.graphics.drawable.Drawable drawable) {
        this.p = drawable;
    }

    private void b(com.anythink.expressad.out.q qVar) {
        this.q = qVar;
        if (android.text.TextUtils.isEmpty(this.h)) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.h, this);
    }

    private java.lang.Object c() {
        return this.l;
    }

    private void c(com.anythink.expressad.out.q qVar) {
        this.q = qVar;
    }

    private java.lang.String d() {
        return this.cU;
    }

    private int e() {
        return this.r;
    }

    private int f() {
        return this.f251s;
    }

    private java.lang.String g() {
        return this.n;
    }

    public final void A(java.lang.String str) {
        this.h = str;
    }

    public final void B(java.lang.String str) {
        this.f = str;
    }

    public final void a(double d) {
        this.j = d;
    }

    public final void a(long j) {
        this.i = j;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        java.lang.String str2;
        if (!android.text.TextUtils.isEmpty(this.h) && this.h.equals(str) && bitmap != null) {
            this.p = a(bitmap);
            if (this.q != null) {
                a(bitmap);
            }
        }
        if (android.text.TextUtils.isEmpty(this.g) || (str2 = this.g) == null || !str2.equals(str) || bitmap == null) {
            return;
        }
        this.o = a(bitmap);
        if (this.q != null) {
            a(bitmap);
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public final void a(java.lang.String str, java.lang.String str2) {
    }

    public final double aX() {
        return this.j;
    }

    public final int aY() {
        return this.k;
    }

    public final java.lang.String aZ() {
        return this.b;
    }

    public final java.lang.String ba() {
        return this.c;
    }

    public final java.lang.String bb() {
        return this.d;
    }

    public final java.lang.String bc() {
        return this.e;
    }

    public final java.lang.String bd() {
        return this.g;
    }

    public final java.lang.String be() {
        return this.h;
    }

    public final int bf() {
        return this.m;
    }

    public final long bg() {
        return this.i;
    }

    public final java.lang.String bh() {
        return this.f;
    }

    public final int bi() {
        return this.t;
    }

    public final void o(int i) {
        this.k = i;
    }

    public void o(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.cU = str;
    }

    public final void p(int i) {
        this.m = i;
    }

    public final void q(int i) {
        this.t = i;
    }

    public final void v(java.lang.String str) {
        this.b = str;
    }

    public final void w(java.lang.String str) {
        this.c = str;
    }

    public final void x(java.lang.String str) {
        this.d = str;
    }

    public final void y(java.lang.String str) {
        this.e = str;
    }

    public final void z(java.lang.String str) {
        this.g = str;
    }
}
