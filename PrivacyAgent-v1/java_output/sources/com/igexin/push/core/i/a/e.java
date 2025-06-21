package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public class e extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable, com.igexin.push.core.i.a.h.b {
    public static final int a = -1;
    public static final int b = 0;
    private static final int f = 119;
    public final com.igexin.push.core.i.a.e.a c;
    public boolean d;
    boolean e;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private android.graphics.Paint l;
    private android.graphics.Rect m;

    public static final class a extends android.graphics.drawable.Drawable.ConstantState {
        public final com.igexin.push.core.i.a.h a;

        public a(com.igexin.push.core.i.a.h hVar) {
            this.a = hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final android.graphics.drawable.Drawable newDrawable() {
            return new com.igexin.push.core.i.a.e(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final android.graphics.drawable.Drawable newDrawable(android.content.res.Resources resources) {
            return newDrawable();
        }
    }

    public e(com.igexin.push.core.i.a.d dVar, android.graphics.Bitmap bitmap) {
        this(new com.igexin.push.core.i.a.e.a(new com.igexin.push.core.i.a.h(dVar, bitmap)));
    }

    public e(com.igexin.push.core.i.a.e.a aVar) {
        this.h = true;
        this.j = -1;
        this.c = (com.igexin.push.core.i.a.e.a) com.igexin.push.core.i.a.k.a(aVar);
    }

    private void a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new java.lang.IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i != 0) {
            this.j = i;
        } else {
            int l = this.c.a.a.l();
            this.j = l != 0 ? l : -1;
        }
    }

    private void a(boolean z) {
        this.d = z;
    }

    private int c() {
        com.igexin.push.core.i.a.h hVar = this.c.a;
        return hVar.a.m() + hVar.j;
    }

    private java.nio.ByteBuffer d() {
        return this.c.a.a.c().asReadOnlyBuffer();
    }

    private int e() {
        return this.c.a.a();
    }

    private int f() {
        com.igexin.push.core.i.a.h.a aVar = this.c.a.e;
        if (aVar != null) {
            return aVar.a;
        }
        return -1;
    }

    private void g() {
        this.i = 0;
    }

    private void h() {
        com.igexin.push.core.i.a.k.a(!this.d, "You cannot restart a currently running animation.");
        com.igexin.push.core.i.a.h hVar = this.c.a;
        com.igexin.push.core.i.a.k.a(!hVar.c, "Can't restart a running animation");
        hVar.d = true;
        if (hVar.i != null) {
            hVar.i = null;
        }
        start();
    }

    private void i() {
        com.igexin.push.core.i.a.k.a(!this.e, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.c.a.a() == 1) {
            invalidateSelf();
        } else {
            if (this.d) {
                return;
            }
            this.d = true;
            this.c.a.a(this);
            invalidateSelf();
        }
    }

    private void j() {
        this.d = false;
        this.c.a.b(this);
    }

    private android.graphics.Rect k() {
        if (this.m == null) {
            this.m = new android.graphics.Rect();
        }
        return this.m;
    }

    private android.graphics.Paint l() {
        if (this.l == null) {
            this.l = new android.graphics.Paint(2);
        }
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private android.graphics.drawable.Drawable.Callback m() {
        android.graphics.drawable.Drawable.Callback callback = getCallback();
        while (callback instanceof android.graphics.drawable.Drawable) {
            callback = ((android.graphics.drawable.Drawable) callback).getCallback();
        }
        return callback;
    }

    private void n() {
        this.e = true;
        com.igexin.push.core.i.a.h hVar = this.c.a;
        hVar.b.clear();
        hVar.b();
        hVar.c = false;
        if (hVar.e != null) {
            hVar.e = null;
        }
        if (hVar.g != null) {
            hVar.g = null;
        }
        if (hVar.i != null) {
            hVar.i = null;
        }
        hVar.a.o();
        hVar.f = true;
    }

    private boolean o() {
        return this.e;
    }

    public final android.graphics.Bitmap a() {
        return this.c.a.h;
    }

    @Override // com.igexin.push.core.i.a.h.b
    public final void b() {
        java.lang.Object callback = getCallback();
        while (callback instanceof android.graphics.drawable.Drawable) {
            callback = ((android.graphics.drawable.Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        com.igexin.push.core.i.a.h.a aVar = this.c.a.e;
        if ((aVar != null ? aVar.a : -1) == r0.a() - 1) {
            this.i++;
        }
        int i = this.j;
        if (i == -1 || this.i < i) {
            return;
        }
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.e) {
            return;
        }
        if (this.k) {
            android.view.Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
            this.k = false;
        }
        com.igexin.push.core.i.a.h hVar = this.c.a;
        com.igexin.push.core.i.a.h.a aVar = hVar.e;
        canvas.drawBitmap(aVar != null ? aVar.b : hVar.h, (android.graphics.Rect) null, k(), l());
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.a.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.a.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        this.k = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        l().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.e) {
            com.igexin.c.a.c.a.b("GifBitmapProvider", "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
            return super.setVisible(z, z2);
        }
        this.h = z;
        if (!z) {
            com.igexin.c.a.c.a.b("GifBitmapProvider", "invisible  stopRunning");
            j();
        } else if (this.g) {
            i();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g = true;
        this.i = 0;
        if (this.h) {
            i();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g = false;
        j();
    }
}
