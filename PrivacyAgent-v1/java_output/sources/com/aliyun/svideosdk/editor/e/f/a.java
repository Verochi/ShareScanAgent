package com.aliyun.svideosdk.editor.e.f;

/* loaded from: classes12.dex */
public class a {
    private android.widget.TextView a;
    private android.text.TextPaint b;
    private float c;
    private int d;
    private float e;
    private float f;
    private float g;
    private boolean h;
    private boolean i;
    private java.util.ArrayList<com.aliyun.svideosdk.editor.e.f.a.d> j;
    private android.text.TextWatcher k = new com.aliyun.svideosdk.editor.e.f.a.c(this, null);
    private android.view.View.OnLayoutChangeListener l = new com.aliyun.svideosdk.editor.e.f.a.b(this, null);

    public class b implements android.view.View.OnLayoutChangeListener {
        private b() {
        }

        public /* synthetic */ b(com.aliyun.svideosdk.editor.e.f.a aVar, com.aliyun.svideosdk.editor.e.f.a.C0094a c0094a) {
            this();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.aliyun.svideosdk.editor.e.f.a.this.a();
        }
    }

    public class c implements android.text.TextWatcher {
        private c() {
        }

        public /* synthetic */ c(com.aliyun.svideosdk.editor.e.f.a aVar, com.aliyun.svideosdk.editor.e.f.a.C0094a c0094a) {
            this();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            com.aliyun.svideosdk.editor.e.f.a.this.a();
        }
    }

    public interface d {
        void a(float f, float f2);
    }

    private a(android.widget.TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.a = textView;
        this.b = new android.text.TextPaint();
        e(textView.getTextSize());
        this.d = a(textView);
        this.e = f * 8.0f;
        this.f = this.c;
        this.g = 0.5f;
    }

    private static float a(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, float f, int i, float f2, float f3, float f4, android.util.DisplayMetrics displayMetrics) {
        android.text.StaticLayout staticLayout;
        int i2;
        float f5;
        java.lang.CharSequence charSequence2;
        android.text.TextPaint textPaint2;
        float f6;
        int i3;
        float f7;
        float f8;
        float f9 = (f2 + f3) / 2.0f;
        textPaint.setTextSize(android.util.TypedValue.applyDimension(0, f9, displayMetrics));
        if (i != 1) {
            staticLayout = new android.text.StaticLayout(charSequence, textPaint, (int) f, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i2 = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            i2 = 1;
        }
        if (i2 <= i) {
            if (i2 < i) {
                charSequence2 = charSequence;
            } else {
                if (i == 1) {
                    f5 = textPaint.measureText(charSequence, 0, charSequence.length());
                } else {
                    float f10 = 0.0f;
                    for (int i4 = 0; i4 < i2; i4++) {
                        if (staticLayout.getLineWidth(i4) > f10) {
                            f10 = staticLayout.getLineWidth(i4);
                        }
                    }
                    f5 = f10;
                }
                if (f3 - f2 < f4) {
                    return f2;
                }
                if (f5 > f) {
                    charSequence2 = charSequence;
                } else {
                    if (f5 >= f) {
                        return f9;
                    }
                    charSequence2 = charSequence;
                }
            }
            textPaint2 = textPaint;
            f6 = f;
            i3 = i;
            f7 = f9;
            f8 = f3;
            return a(charSequence2, textPaint2, f6, i3, f7, f8, f4, displayMetrics);
        }
        if (f3 - f2 < f4) {
            return f2;
        }
        charSequence2 = charSequence;
        textPaint2 = textPaint;
        f6 = f;
        i3 = i;
        f7 = f2;
        f8 = f9;
        return a(charSequence2, textPaint2, f6, i3, f7, f8, f4, displayMetrics);
    }

    private static int a(android.widget.TextView textView) {
        android.text.method.TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || !(transformationMethod instanceof android.text.method.SingleLineTransformationMethod)) {
            return textView.getMaxLines();
        }
        return 1;
    }

    private static int a(java.lang.CharSequence charSequence, android.text.TextPaint textPaint, float f, float f2, android.util.DisplayMetrics displayMetrics) {
        textPaint.setTextSize(android.util.TypedValue.applyDimension(0, f, displayMetrics));
        return new android.text.StaticLayout(charSequence, textPaint, (int) f2, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    public static com.aliyun.svideosdk.editor.e.f.a a(android.widget.TextView textView, android.util.AttributeSet attributeSet, int i) {
        com.aliyun.svideosdk.editor.e.f.a aVar = new com.aliyun.svideosdk.editor.e.f.a(textView);
        boolean z = true;
        if (attributeSet != null) {
            android.content.Context context = textView.getContext();
            int c2 = (int) aVar.c();
            float d2 = aVar.d();
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.video.android.R.styleable.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(com.aliyun.video.android.R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.aliyun.video.android.R.styleable.AutofitTextView_minTextSize, c2);
            float f = obtainStyledAttributes.getFloat(com.aliyun.video.android.R.styleable.AutofitTextView_precision, d2);
            obtainStyledAttributes.recycle();
            aVar.b(0, dimensionPixelSize).b(f);
        }
        aVar.a(z);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        float textSize = this.a.getTextSize();
        this.i = true;
        a(this.a, this.b, this.e, this.f, this.d, this.g);
        this.i = false;
        float textSize2 = this.a.getTextSize();
        if (textSize2 != textSize) {
            a(textSize2, textSize);
        }
    }

    private void a(float f, float f2) {
        java.util.ArrayList<com.aliyun.svideosdk.editor.e.f.a.d> arrayList = this.j;
        if (arrayList == null) {
            return;
        }
        java.util.Iterator<com.aliyun.svideosdk.editor.e.f.a.d> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(f, f2);
        }
    }

    private static void a(android.widget.TextView textView, android.text.TextPaint textPaint, float f, float f2, int i, float f3) {
        int width;
        if (i <= 0 || i == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
            return;
        }
        java.lang.CharSequence text = textView.getText();
        android.text.method.TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        android.content.Context context = textView.getContext();
        android.content.res.Resources system = android.content.res.Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        android.util.DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f2);
        float a = ((i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && a(text, textPaint, f2, (float) width, displayMetrics) <= i) ? f2 : a(text, textPaint, width, i, 0.0f, f2, f3, displayMetrics);
        if (a < f) {
            a = f;
        }
        textView.setTextSize(0, a);
    }

    private void c(float f) {
        if (f != this.f) {
            this.f = f;
            a();
        }
    }

    private void d(float f) {
        if (f != this.e) {
            this.e = f;
            a();
        }
    }

    private void e(float f) {
        if (this.c != f) {
            this.c = f;
        }
    }

    public com.aliyun.svideosdk.editor.e.f.a a(float f) {
        return a(2, f);
    }

    public com.aliyun.svideosdk.editor.e.f.a a(int i) {
        if (this.d != i) {
            this.d = i;
            a();
        }
        return this;
    }

    public com.aliyun.svideosdk.editor.e.f.a a(int i, float f) {
        android.content.Context context = this.a.getContext();
        android.content.res.Resources system = android.content.res.Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        c(android.util.TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public com.aliyun.svideosdk.editor.e.f.a a(com.aliyun.svideosdk.editor.e.f.a.d dVar) {
        if (this.j == null) {
            this.j = new java.util.ArrayList<>();
        }
        this.j.add(dVar);
        return this;
    }

    public com.aliyun.svideosdk.editor.e.f.a a(boolean z) {
        if (this.h != z) {
            this.h = z;
            if (z) {
                this.a.addTextChangedListener(this.k);
                this.a.addOnLayoutChangeListener(this.l);
                a();
            } else {
                this.a.removeTextChangedListener(this.k);
                this.a.removeOnLayoutChangeListener(this.l);
                this.a.setTextSize(0, this.c);
            }
        }
        return this;
    }

    public float b() {
        return this.f;
    }

    public com.aliyun.svideosdk.editor.e.f.a b(float f) {
        if (this.g != f) {
            this.g = f;
            a();
        }
        return this;
    }

    public com.aliyun.svideosdk.editor.e.f.a b(int i, float f) {
        android.content.Context context = this.a.getContext();
        android.content.res.Resources system = android.content.res.Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        d(android.util.TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    public float c() {
        return this.e;
    }

    public void c(int i, float f) {
        if (this.i) {
            return;
        }
        android.content.Context context = this.a.getContext();
        android.content.res.Resources system = android.content.res.Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        e(android.util.TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    public float d() {
        return this.g;
    }
}
