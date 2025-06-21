package com.anythink.basead.ui.animplayerview.redpacket;

/* loaded from: classes12.dex */
public final class a {
    public float a;
    public float b;
    private android.graphics.Bitmap c;
    private int d;
    private int e;
    private float f;
    private float g;

    public a(android.content.Context context, android.graphics.Bitmap bitmap, int i) {
        i = i == 0 ? java.lang.Math.min(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels) : i;
        double nextInt = (new java.util.Random().nextInt(6) + 15.0d) / 100.0d;
        nextInt = (nextInt < 0.15d || nextInt > 0.2d) ? 0.2d : nextInt;
        "widthScale: ".concat(java.lang.String.valueOf(nextInt));
        int i2 = (int) (i * nextInt);
        this.d = i2;
        int height = (i2 * bitmap.getHeight()) / bitmap.getWidth();
        this.e = height;
        try {
            this.c = android.graphics.Bitmap.createScaledBitmap(bitmap, this.d, height, true);
        } catch (java.lang.Exception e) {
            new java.lang.StringBuilder("createScaledBitmap failed: ").append(e.getMessage());
        }
        this.f = 400.0f;
        this.g = (new java.util.Random().nextFloat() * 30.0f) - 15.0f;
    }

    private float f() {
        return this.f;
    }

    public final int a() {
        return this.e;
    }

    public final int b() {
        return this.d;
    }

    public final android.graphics.Bitmap c() {
        return this.c;
    }

    public final void d() {
        android.graphics.Bitmap bitmap = this.c;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.c.recycle();
        this.c = null;
    }

    public final float e() {
        return this.g;
    }
}
