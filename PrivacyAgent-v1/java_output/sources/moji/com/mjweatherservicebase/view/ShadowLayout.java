package moji.com.mjweatherservicebase.view;

/* loaded from: classes20.dex */
public class ShadowLayout extends android.widget.LinearLayout {
    public int A;
    public int B;
    public int C;
    public moji.com.mjweatherservicebase.view.Shadow D;
    public float E;
    public float F;
    public android.graphics.Paint G;
    public android.graphics.Paint H;
    public int n;
    public float t;
    public float u;
    public float v;
    public float w;
    public int x;
    public boolean y;
    public int z;
    public static final float SHADOW_DEFAULT_RADIUS = com.moji.tool.DeviceTool.dp2px(5.0f);
    public static final float SHADOW_MAX_OFFSET = com.moji.tool.DeviceTool.dp2px(20.0f);
    public static final float SHADOW_MAX_BLUR = com.moji.tool.DeviceTool.dp2px(20.0f);
    public static final float SHADOW_DEFAULT_BLUR_RADIUS = com.moji.tool.DeviceTool.dp2px(5.0f);

    public class ShadowConfig implements moji.com.mjweatherservicebase.view.Shadow {
        public moji.com.mjweatherservicebase.view.ShadowLayout a;

        public ShadowConfig(moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout) {
            this.a = shadowLayout;
        }

        public /* synthetic */ ShadowConfig(moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout, moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout2, defpackage.of2 of2Var) {
            this(shadowLayout2);
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public void commit() {
            this.a.h();
            this.a.requestLayout();
            this.a.postInvalidate();
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setBlurRadius(float f) {
            return setBlurRadius(1, f);
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setBlurRadius(int i, float f) {
            android.content.Context context = moji.com.mjweatherservicebase.view.ShadowLayout.this.getContext();
            this.a.u = java.lang.Math.min(moji.com.mjweatherservicebase.view.ShadowLayout.SHADOW_MAX_BLUR, java.lang.Math.abs(android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics())));
            return this;
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setShadowColor(int i) {
            this.a.n = i;
            return this;
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setShadowColorRes(int i) {
            moji.com.mjweatherservicebase.view.ShadowLayout shadowLayout = this.a;
            shadowLayout.n = shadowLayout.getResources().getColor(i);
            return this;
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setShadowRadius(float f) {
            return setShadowRadius(1, f);
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setShadowRadius(int i, float f) {
            android.content.Context context = moji.com.mjweatherservicebase.view.ShadowLayout.this.getContext();
            this.a.t = java.lang.Math.abs(android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics()));
            return this;
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setXOffset(float f) {
            return setXOffset(1, f);
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setXOffset(int i, float f) {
            android.content.Context context = moji.com.mjweatherservicebase.view.ShadowLayout.this.getContext();
            float applyDimension = android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics());
            float abs = java.lang.Math.abs(applyDimension);
            float f2 = moji.com.mjweatherservicebase.view.ShadowLayout.SHADOW_MAX_OFFSET;
            if (abs > f2) {
                applyDimension = (applyDimension / java.lang.Math.abs(applyDimension)) * f2;
            }
            this.a.v = applyDimension;
            return this;
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setYOffset(float f) {
            return setYOffset(1, f);
        }

        @Override // moji.com.mjweatherservicebase.view.Shadow
        public moji.com.mjweatherservicebase.view.Shadow setYOffset(int i, float f) {
            android.content.Context context = moji.com.mjweatherservicebase.view.ShadowLayout.this.getContext();
            float applyDimension = android.util.TypedValue.applyDimension(i, f, (context == null ? android.content.res.Resources.getSystem() : context.getResources()).getDisplayMetrics());
            float abs = java.lang.Math.abs(applyDimension);
            float f2 = moji.com.mjweatherservicebase.view.ShadowLayout.SHADOW_MAX_OFFSET;
            if (abs > f2) {
                applyDimension = (applyDimension / java.lang.Math.abs(applyDimension)) * f2;
            }
            this.a.w = applyDimension;
            return this;
        }
    }

    public ShadowLayout(android.content.Context context) {
        super(context, null);
        this.n = android.graphics.Color.parseColor("#333333");
        this.t = 0.0f;
        this.u = SHADOW_DEFAULT_BLUR_RADIUS;
        this.v = com.moji.tool.DeviceTool.dp2px(10.0f);
        this.w = com.moji.tool.DeviceTool.dp2px(10.0f);
        this.x = -1;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new moji.com.mjweatherservicebase.view.ShadowLayout.ShadowConfig(this, this, null);
        this.G = new android.graphics.Paint();
        this.H = new android.graphics.Paint();
    }

    public ShadowLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = android.graphics.Color.parseColor("#333333");
        this.t = 0.0f;
        float f = SHADOW_DEFAULT_BLUR_RADIUS;
        this.u = f;
        this.v = com.moji.tool.DeviceTool.dp2px(10.0f);
        this.w = com.moji.tool.DeviceTool.dp2px(10.0f);
        this.x = -1;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = new moji.com.mjweatherservicebase.view.ShadowLayout.ShadowConfig(this, this, null);
        this.G = new android.graphics.Paint();
        this.H = new android.graphics.Paint();
        setLayerType(1, null);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, moji.com.mjweatherservicebase.R.styleable.ShadowLayout);
        this.n = obtainStyledAttributes.getColor(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_shadowColor, -16776961);
        this.u = obtainStyledAttributes.getDimension(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_blurRadius, f);
        this.t = obtainStyledAttributes.getDimension(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_shadowRadius, 0.0f);
        this.y = obtainStyledAttributes.getBoolean(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_hasEffect, false);
        this.v = obtainStyledAttributes.getDimension(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_xOffset, com.moji.tool.DeviceTool.dp2px(10.0f));
        this.w = obtainStyledAttributes.getDimension(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_yOffset, com.moji.tool.DeviceTool.dp2px(10.0f));
        this.x = obtainStyledAttributes.getColor(moji.com.mjweatherservicebase.R.styleable.ShadowLayout_bgColor, -1);
        obtainStyledAttributes.recycle();
        float f2 = this.t;
        if (f2 < 0.0f) {
            this.t = -f2;
        }
        float f3 = this.u;
        if (f3 < 0.0f) {
            this.u = -f3;
        }
        this.u = java.lang.Math.min(SHADOW_MAX_BLUR, this.u);
        float abs = java.lang.Math.abs(this.v);
        float f4 = SHADOW_MAX_OFFSET;
        if (abs > f4) {
            float f5 = this.v;
            this.v = (f5 / java.lang.Math.abs(f5)) * f4;
        }
        if (java.lang.Math.abs(this.w) > f4) {
            float f6 = this.w;
            this.w = (f6 / java.lang.Math.abs(f6)) * f4;
        }
        setBackgroundColor(android.graphics.Color.parseColor("#00ffffff"));
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final void g(android.graphics.Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        this.E = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.F = measuredHeight;
        if (this.v == 0.0f) {
            f = this.A;
            f2 = this.E - this.u;
        } else {
            float f5 = this.A;
            float f6 = this.u;
            f = f5 + f6;
            f2 = (this.E - this.z) - f6;
        }
        if (this.w == 0.0f) {
            f4 = this.C;
            f3 = this.u;
        } else {
            float f7 = this.C;
            f3 = this.u;
            f4 = f7 + f3;
            measuredHeight -= this.B;
        }
        float f8 = measuredHeight - f3;
        if (this.u > 0.0f) {
            this.G.setMaskFilter(new android.graphics.BlurMaskFilter(this.u, android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
        this.G.setColor(this.n);
        this.G.setAntiAlias(true);
        android.graphics.RectF rectF = new android.graphics.RectF(f, f4, f2, f8);
        android.graphics.RectF rectF2 = new android.graphics.RectF(this.z, this.B, this.E - this.A, this.F - this.C);
        float f9 = this.t;
        if (f9 == 0.0f) {
            canvas.drawRect(rectF, this.G);
        } else {
            canvas.drawRoundRect(rectF, f9, f9, this.G);
        }
        this.H.setColor(this.x);
        this.H.setAntiAlias(true);
        float f10 = this.t;
        if (f10 == 0.0f) {
            canvas.drawRect(rectF2, this.H);
        } else {
            canvas.drawRoundRect(rectF2, f10, f10, this.H);
        }
    }

    public moji.com.mjweatherservicebase.view.Shadow getShadowConfig() {
        return this.D;
    }

    public final void h() {
        float f = this.v;
        if (f > 0.0f) {
            this.A = (int) (this.u + java.lang.Math.abs(f));
        } else if (f == 0.0f) {
            float f2 = this.u;
            this.z = (int) f2;
            this.A = (int) f2;
        } else {
            this.z = (int) (this.u + java.lang.Math.abs(f));
        }
        float f3 = this.w;
        if (f3 > 0.0f) {
            this.C = (int) (this.u + java.lang.Math.abs(f3));
        } else if (f3 == 0.0f) {
            float f4 = this.u;
            this.B = (int) f4;
            this.C = (int) f4;
        } else {
            this.B = (int) (this.u + java.lang.Math.abs(f3));
        }
        setPadding(this.z, this.B, this.A, this.C);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        g(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
