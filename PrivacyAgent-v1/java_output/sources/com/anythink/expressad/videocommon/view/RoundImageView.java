package com.anythink.expressad.videocommon.view;

/* loaded from: classes12.dex */
public class RoundImageView extends com.anythink.expressad.widget.ATImageView {
    private static final java.lang.String a = "RoundImageView";
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 5;
    private static final java.lang.String m = "state_instance";
    private static final java.lang.String n = "state_type";
    private static final java.lang.String o = "state_border_radius";
    private int b;
    private int f;
    private android.graphics.Paint g;
    private int h;
    private android.graphics.Matrix i;
    private android.graphics.BitmapShader j;
    private int k;
    private android.graphics.RectF l;

    public RoundImageView(android.content.Context context) {
        super(context);
        this.i = new android.graphics.Matrix();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) android.util.TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new android.graphics.Matrix();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) android.util.TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    public RoundImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new android.graphics.Matrix();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) android.util.TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    private static android.graphics.Bitmap a(android.graphics.drawable.Drawable drawable) {
        try {
            if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
                return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, android.graphics.Bitmap.Config.ARGB_4444);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private void a() {
        android.graphics.Bitmap a2;
        try {
            android.graphics.drawable.Drawable drawable = getDrawable();
            if (drawable == null || (a2 = a(drawable)) == null || a2.isRecycled()) {
                return;
            }
            android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
            this.j = new android.graphics.BitmapShader(a2, tileMode, tileMode);
            int i = this.b;
            float f = 1.0f;
            if (i == 0) {
                f = (this.k * 1.0f) / java.lang.Math.min(a2.getWidth(), a2.getHeight());
            } else if (i == 1) {
                f = java.lang.Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
            }
            this.i.setScale(f, f);
            this.j.setLocalMatrix(this.i);
            this.g.setShader(this.j);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.widget.ATImageView, android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap a2;
        try {
            if (getDrawable() == null) {
                return;
            }
            try {
                android.graphics.drawable.Drawable drawable = getDrawable();
                if (drawable != null && (a2 = a(drawable)) != null && !a2.isRecycled()) {
                    android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
                    this.j = new android.graphics.BitmapShader(a2, tileMode, tileMode);
                    int i = this.b;
                    float f = 1.0f;
                    if (i == 0) {
                        f = (this.k * 1.0f) / java.lang.Math.min(a2.getWidth(), a2.getHeight());
                    } else if (i == 1) {
                        f = java.lang.Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
                    }
                    this.i.setScale(f, f);
                    this.j.setLocalMatrix(this.i);
                    this.g.setShader(this.j);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            if (this.b != 1) {
                int i2 = this.h;
                canvas.drawCircle(i2, i2, i2, this.g);
            } else {
                android.graphics.RectF rectF = this.l;
                int i3 = this.f;
                canvas.drawRoundRect(rectF, i3, i3, this.g);
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 0) {
            int min = java.lang.Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.k = min;
            this.h = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof android.os.Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        android.os.Bundle bundle = (android.os.Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(m));
        this.b = bundle.getInt(n);
        this.f = bundle.getInt(o);
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(m, super.onSaveInstanceState());
        bundle.putInt(n, this.b);
        bundle.putInt(o, this.f);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b == 1) {
            this.l = new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i) {
        int b = com.anythink.expressad.foundation.h.t.b(getContext(), i);
        if (this.f != b) {
            this.f = b;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.b != i) {
            this.b = i;
            if (i != 1 && i != 0) {
                this.b = 0;
            }
            requestLayout();
        }
    }
}
