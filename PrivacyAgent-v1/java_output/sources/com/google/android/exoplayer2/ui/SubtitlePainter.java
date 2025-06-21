package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
final class SubtitlePainter {
    public int A;
    public int B;
    public int C;
    public int D;
    public android.text.StaticLayout E;
    public android.text.StaticLayout F;
    public int G;
    public int H;
    public int I;
    public android.graphics.Rect J;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final android.text.TextPaint f;
    public final android.graphics.Paint g;
    public final android.graphics.Paint h;

    @androidx.annotation.Nullable
    public java.lang.CharSequence i;

    @androidx.annotation.Nullable
    public android.text.Layout.Alignment j;

    @androidx.annotation.Nullable
    public android.graphics.Bitmap k;
    public float l;
    public int m;
    public int n;
    public float o;
    public int p;
    public float q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public int f367s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public SubtitlePainter(android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{android.R.attr.lineSpacingExtra, android.R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = java.lang.Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.a = round;
        this.b = round;
        this.c = round;
        android.text.TextPaint textPaint = new android.text.TextPaint();
        this.f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable java.lang.CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(com.google.android.exoplayer2.text.Cue cue, com.google.android.exoplayer2.text.CaptionStyleCompat captionStyleCompat, float f, float f2, float f3, android.graphics.Canvas canvas, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = cue.bitmap == null;
        if (!z) {
            i5 = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
        } else if (android.text.TextUtils.isEmpty(cue.text)) {
            return;
        } else {
            i5 = cue.windowColorSet ? cue.windowColor : captionStyleCompat.windowColor;
        }
        if (a(this.i, cue.text) && com.google.android.exoplayer2.util.Util.areEqual(this.j, cue.textAlignment) && this.k == cue.bitmap && this.l == cue.line && this.m == cue.lineType && com.google.android.exoplayer2.util.Util.areEqual(java.lang.Integer.valueOf(this.n), java.lang.Integer.valueOf(cue.lineAnchor)) && this.o == cue.position && com.google.android.exoplayer2.util.Util.areEqual(java.lang.Integer.valueOf(this.p), java.lang.Integer.valueOf(cue.positionAnchor)) && this.q == cue.size && this.r == cue.bitmapHeight && this.f367s == captionStyleCompat.foregroundColor && this.t == captionStyleCompat.backgroundColor && this.u == i5 && this.w == captionStyleCompat.edgeType && this.v == captionStyleCompat.edgeColor && com.google.android.exoplayer2.util.Util.areEqual(this.f.getTypeface(), captionStyleCompat.typeface) && this.x == f && this.y == f2 && this.z == f3 && this.A == i && this.B == i2 && this.C == i3 && this.D == i4) {
            d(canvas, z);
            return;
        }
        this.i = cue.text;
        this.j = cue.textAlignment;
        this.k = cue.bitmap;
        this.l = cue.line;
        this.m = cue.lineType;
        this.n = cue.lineAnchor;
        this.o = cue.position;
        this.p = cue.positionAnchor;
        this.q = cue.size;
        this.r = cue.bitmapHeight;
        this.f367s = captionStyleCompat.foregroundColor;
        this.t = captionStyleCompat.backgroundColor;
        this.u = i5;
        this.w = captionStyleCompat.edgeType;
        this.v = captionStyleCompat.edgeColor;
        this.f.setTypeface(captionStyleCompat.typeface);
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.A = i;
        this.B = i2;
        this.C = i3;
        this.D = i4;
        if (z) {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.i);
            g();
        } else {
            com.google.android.exoplayer2.util.Assertions.checkNotNull(this.k);
            f();
        }
        d(canvas, z);
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap", "bitmapRect"})
    public final void c(android.graphics.Canvas canvas) {
        canvas.drawBitmap(this.k, (android.graphics.Rect) null, this.J, this.h);
    }

    public final void d(android.graphics.Canvas canvas, boolean z) {
        if (z) {
            e(canvas);
            return;
        }
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.J);
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.k);
        c(canvas);
    }

    public final void e(android.graphics.Canvas canvas) {
        android.text.StaticLayout staticLayout = this.E;
        android.text.StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (android.graphics.Color.alpha(this.u) > 0) {
            this.g.setColor(this.u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.g);
        }
        int i = this.w;
        if (i == 1) {
            this.f.setStrokeJoin(android.graphics.Paint.Join.ROUND);
            this.f.setStrokeWidth(this.a);
            this.f.setColor(this.v);
            this.f.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i == 2) {
            android.text.TextPaint textPaint = this.f;
            float f = this.b;
            float f2 = this.c;
            textPaint.setShadowLayer(f, f2, f2, this.v);
        } else if (i == 3 || i == 4) {
            boolean z = i == 3;
            int i2 = z ? -1 : this.v;
            int i3 = z ? this.v : -1;
            float f3 = this.b / 2.0f;
            this.f.setColor(this.f367s);
            this.f.setStyle(android.graphics.Paint.Style.FILL);
            float f4 = -f3;
            this.f.setShadowLayer(this.b, f4, f4, i2);
            staticLayout2.draw(canvas);
            this.f.setShadowLayer(this.b, f3, f3, i3);
        }
        this.f.setColor(this.f367s);
        this.f.setStyle(android.graphics.Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        float f;
        int i;
        float f2;
        android.graphics.Bitmap bitmap = this.k;
        int i2 = this.C;
        int i3 = this.A;
        int i4 = this.D;
        int i5 = this.B;
        float f3 = i2 - i3;
        float f4 = i3 + (this.o * f3);
        float f5 = i4 - i5;
        float f6 = i5 + (this.l * f5);
        int round = java.lang.Math.round(f3 * this.q);
        float f7 = this.r;
        int round2 = f7 != -3.4028235E38f ? java.lang.Math.round(f5 * f7) : java.lang.Math.round(round * (bitmap.getHeight() / bitmap.getWidth()));
        int i6 = this.p;
        if (i6 != 2) {
            if (i6 == 1) {
                f = round / 2;
            }
            int round3 = java.lang.Math.round(f4);
            i = this.n;
            if (i == 2) {
                if (i == 1) {
                    f2 = round2 / 2;
                }
                int round4 = java.lang.Math.round(f6);
                this.J = new android.graphics.Rect(round3, round4, round + round3, round2 + round4);
            }
            f2 = round2;
            f6 -= f2;
            int round42 = java.lang.Math.round(f6);
            this.J = new android.graphics.Rect(round3, round42, round + round3, round2 + round42);
        }
        f = round;
        f4 -= f;
        int round32 = java.lang.Math.round(f4);
        i = this.n;
        if (i == 2) {
        }
        f6 -= f2;
        int round422 = java.lang.Math.round(f6);
        this.J = new android.graphics.Rect(round32, round422, round + round32, round2 + round422);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a8  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        java.lang.CharSequence charSequence = this.i;
        android.text.SpannableStringBuilder spannableStringBuilder = charSequence instanceof android.text.SpannableStringBuilder ? (android.text.SpannableStringBuilder) charSequence : new android.text.SpannableStringBuilder(this.i);
        int i9 = this.C - this.A;
        int i10 = this.D - this.B;
        this.f.setTextSize(this.x);
        int i11 = (int) ((this.x * 0.125f) + 0.5f);
        int i12 = i11 * 2;
        int i13 = i9 - i12;
        float f = this.q;
        if (f != -3.4028235E38f) {
            i13 = (int) (i13 * f);
        }
        int i14 = i13;
        if (i14 <= 0) {
            com.google.android.exoplayer2.util.Log.w("SubtitlePainter", "Skipped drawing subtitle cue (insufficient space)");
            return;
        }
        if (this.y > 0.0f) {
            spannableStringBuilder.setSpan(new android.text.style.AbsoluteSizeSpan((int) this.y), 0, spannableStringBuilder.length(), 16711680);
        }
        android.text.SpannableStringBuilder spannableStringBuilder2 = new android.text.SpannableStringBuilder(spannableStringBuilder);
        if (this.w == 1) {
            for (android.text.style.ForegroundColorSpan foregroundColorSpan : (android.text.style.ForegroundColorSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), android.text.style.ForegroundColorSpan.class)) {
                spannableStringBuilder2.removeSpan(foregroundColorSpan);
            }
        }
        if (android.graphics.Color.alpha(this.t) > 0) {
            int i15 = this.w;
            if (i15 == 0 || i15 == 2) {
                spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(this.t), 0, spannableStringBuilder.length(), 16711680);
            } else {
                spannableStringBuilder2.setSpan(new android.text.style.BackgroundColorSpan(this.t), 0, spannableStringBuilder2.length(), 16711680);
            }
        }
        android.text.Layout.Alignment alignment = this.j;
        if (alignment == null) {
            alignment = android.text.Layout.Alignment.ALIGN_CENTER;
        }
        android.text.Layout.Alignment alignment2 = alignment;
        android.text.StaticLayout staticLayout = new android.text.StaticLayout(spannableStringBuilder, this.f, i14, alignment2, this.d, this.e, true);
        this.E = staticLayout;
        int height = staticLayout.getHeight();
        int lineCount = this.E.getLineCount();
        int i16 = 0;
        for (int i17 = 0; i17 < lineCount; i17++) {
            i16 = java.lang.Math.max((int) java.lang.Math.ceil(this.E.getLineWidth(i17)), i16);
        }
        if (this.q == -3.4028235E38f || i16 >= i14) {
            i14 = i16;
        }
        int i18 = i14 + i12;
        float f2 = this.o;
        if (f2 != -3.4028235E38f) {
            int round = java.lang.Math.round(i9 * f2);
            int i19 = this.A;
            int i20 = round + i19;
            int i21 = this.p;
            i = 1;
            if (i21 != 1) {
                i2 = 2;
                if (i21 == 2) {
                    i20 -= i18;
                }
            } else {
                i2 = 2;
                i20 = ((i20 * 2) - i18) / 2;
            }
            i3 = java.lang.Math.max(i20, i19);
            i4 = java.lang.Math.min(i18 + i3, this.C);
        } else {
            i = 1;
            i2 = 2;
            i3 = ((i9 - i18) / 2) + this.A;
            i4 = i3 + i18;
        }
        int i22 = i4 - i3;
        if (i22 <= 0) {
            com.google.android.exoplayer2.util.Log.w("SubtitlePainter", "Skipped drawing subtitle cue (invalid horizontal positioning)");
            return;
        }
        float f3 = this.l;
        if (f3 == -3.4028235E38f) {
            i5 = (this.D - height) - ((int) (i10 * this.z));
        } else if (this.m == 0) {
            i5 = java.lang.Math.round(i10 * f3) + this.B;
            int i23 = this.n;
            if (i23 != i2) {
                if (i23 == i) {
                    i5 = ((i5 * 2) - height) / i2;
                }
                i7 = i5 + height;
                i8 = this.D;
                if (i7 <= i8) {
                    i5 = i8 - height;
                } else {
                    int i24 = this.B;
                    if (i5 < i24) {
                        i6 = i24;
                        this.E = new android.text.StaticLayout(spannableStringBuilder, this.f, i22, alignment2, this.d, this.e, true);
                        this.F = new android.text.StaticLayout(spannableStringBuilder2, this.f, i22, alignment2, this.d, this.e, true);
                        this.G = i3;
                        this.H = i6;
                        this.I = i11;
                    }
                }
            }
            i5 -= height;
            i7 = i5 + height;
            i8 = this.D;
            if (i7 <= i8) {
            }
        } else {
            int lineBottom = this.E.getLineBottom(0) - this.E.getLineTop(0);
            float f4 = this.l;
            if (f4 >= 0.0f) {
                i5 = java.lang.Math.round(f4 * lineBottom) + this.B;
                i7 = i5 + height;
                i8 = this.D;
                if (i7 <= i8) {
                }
            } else {
                i5 = java.lang.Math.round((f4 + 1.0f) * lineBottom) + this.D;
                i5 -= height;
                i7 = i5 + height;
                i8 = this.D;
                if (i7 <= i8) {
                }
            }
        }
        i6 = i5;
        this.E = new android.text.StaticLayout(spannableStringBuilder, this.f, i22, alignment2, this.d, this.e, true);
        this.F = new android.text.StaticLayout(spannableStringBuilder2, this.f, i22, alignment2, this.d, this.e, true);
        this.G = i3;
        this.H = i6;
        this.I = i11;
    }
}
