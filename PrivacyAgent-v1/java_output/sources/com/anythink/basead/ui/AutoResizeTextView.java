package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class AutoResizeTextView extends android.widget.TextView {
    private static final int a = 1000;
    private static final int b = 5;
    private android.text.TextPaint c;
    private float d;
    private float e;
    private boolean f;
    private boolean g;

    public AutoResizeTextView(android.content.Context context) {
        super(context);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    public AutoResizeTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    public AutoResizeTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 1.0f;
        this.e = 0.0f;
        this.f = false;
        this.g = false;
        a();
    }

    private int a(java.lang.CharSequence charSequence, int i) {
        return new android.text.StaticLayout(charSequence, this.c, i, android.text.Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
    }

    private void a() {
        this.c = new android.text.TextPaint();
    }

    private void b() {
        java.lang.CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || android.text.TextUtils.isEmpty(text)) {
            return;
        }
        this.g = true;
        int textSize = (int) getTextSize();
        while (textSize >= 5) {
            this.c.setTextSize(textSize);
            int measureText = (int) this.c.measureText(text, 0, text.length());
            int height2 = new android.text.StaticLayout(text, this.c, width, android.text.Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
            if (measureText < width && height2 < height) {
                break;
            } else {
                textSize--;
            }
        }
        setTextSize(0, textSize);
        this.g = false;
        this.f = false;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (this.g) {
            return;
        }
        if (!this.f) {
            super.onDraw(canvas);
            return;
        }
        java.lang.CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || android.text.TextUtils.isEmpty(text)) {
            return;
        }
        this.g = true;
        int textSize = (int) getTextSize();
        while (textSize >= 5) {
            this.c.setTextSize(textSize);
            int measureText = (int) this.c.measureText(text, 0, text.length());
            int height2 = new android.text.StaticLayout(text, this.c, width, android.text.Layout.Alignment.ALIGN_NORMAL, this.d, this.e, true).getHeight();
            if (measureText < width && height2 < height) {
                break;
            } else {
                textSize--;
            }
        }
        setTextSize(0, textSize);
        this.g = false;
        this.f = false;
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = true;
    }

    @Override // android.widget.TextView
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.f = true;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.d = f2;
        this.e = f;
    }
}
