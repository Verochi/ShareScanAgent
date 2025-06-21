package com.cicada.player.utils.ass;

/* loaded from: classes22.dex */
public class BorderedSpan extends android.text.style.ReplacementSpan {
    final android.graphics.Paint mBorderPaint;
    private com.cicada.player.utils.ass.BorderedSpan.BorderStyle mBorderStyle;

    public static class BorderStyle {
        public java.lang.String fontName;
        public double fontSize;
        public boolean mBold;
        public boolean mItalic;
        public int mOutlineColour;
        public double mOutlineWidth;
        public int mPrimaryColour;
        public int mSecondaryColour;
        public int mShadowColor;
        public double mShadowWidth;
        public boolean mStrikeOut;
        public boolean mUnderline;
    }

    public BorderedSpan(com.cicada.player.utils.ass.BorderedSpan.BorderStyle borderStyle) {
        this.mBorderStyle = borderStyle;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mBorderPaint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    private void fillPainStyle(android.graphics.Paint paint) {
        paint.setTypeface(android.graphics.Typeface.create(this.mBorderStyle.fontName, 0));
        paint.setTextSize((float) this.mBorderStyle.fontSize);
        paint.setColor(this.mBorderStyle.mPrimaryColour);
        paint.setUnderlineText(this.mBorderStyle.mUnderline);
        paint.setStrikeThruText(this.mBorderStyle.mStrikeOut);
        paint.setFakeBoldText(this.mBorderStyle.mBold);
        paint.setTextSkewX(this.mBorderStyle.mItalic ? -0.25f : 0.0f);
        com.cicada.player.utils.ass.BorderedSpan.BorderStyle borderStyle = this.mBorderStyle;
        float f = (float) borderStyle.mShadowWidth;
        paint.setShadowLayer(0.0f, f, f, borderStyle.mShadowColor);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        if (this.mBorderStyle.mOutlineWidth > 0.0d) {
            fillPainStyle(this.mBorderPaint);
            this.mBorderPaint.setStrokeWidth((float) this.mBorderStyle.mOutlineWidth);
            this.mBorderPaint.setColor(this.mBorderStyle.mOutlineColour);
            canvas.drawText(charSequence, i, i2, f, i4, this.mBorderPaint);
            fillPainStyle(paint);
        }
        canvas.drawText(charSequence, i, i2, f, i4, paint);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        fillPainStyle(paint);
        return (int) paint.measureText(charSequence, i, i2);
    }
}
