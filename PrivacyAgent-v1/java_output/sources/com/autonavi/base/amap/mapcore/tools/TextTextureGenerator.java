package com.autonavi.base.amap.mapcore.tools;

/* loaded from: classes12.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE = -1;
    private int TEXT_FONTSIZE_TRUE = -1;
    private float base_line = 0.0f;
    private float start_x = 0.0f;
    private android.graphics.Paint text_paint = null;

    public TextTextureGenerator() {
        createTextParam();
    }

    public static int GetNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    private void createTextParam() {
        float f;
        float f2;
        int i = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = i;
        android.graphics.Paint newPaint = newPaint(null, i, 49);
        this.text_paint = newPaint;
        float f3 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = f3;
        try {
            android.graphics.Paint.FontMetrics fontMetrics = newPaint.getFontMetrics();
            f = fontMetrics.descent;
            try {
                f2 = fontMetrics.ascent;
            } catch (java.lang.Exception unused) {
                f2 = -27.832031f;
                this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f + f2)) / 2.0f) + f3 + 0.5f;
            }
        } catch (java.lang.Exception unused2) {
            f = 7.3242188f;
        }
        this.base_line = ((this.TEXT_FONTSIZE_TRUE - (f + f2)) / 2.0f) + f3 + 0.5f;
    }

    public static float getFontHeight(android.graphics.Paint paint) {
        android.graphics.Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float getFontlength(android.graphics.Paint paint, java.lang.String str) {
        return paint.measureText(str);
    }

    private static android.graphics.Paint newPaint(java.lang.String str, int i, int i2) {
        android.text.TextPaint textPaint = new android.text.TextPaint();
        textPaint.setColor(-1);
        textPaint.setTextSize(i);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        switch (i2) {
            case 49:
                textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
                return textPaint;
            case 50:
                textPaint.setTextAlign(android.graphics.Paint.Align.RIGHT);
                return textPaint;
            case 51:
                textPaint.setTextAlign(android.graphics.Paint.Align.CENTER);
                return textPaint;
            default:
                textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
                return textPaint;
        }
    }

    public byte[] getCharsWidths(int[] iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            android.graphics.Paint paint = this.text_paint;
            new java.lang.StringBuilder().append((char) iArr[i]);
            bArr[i] = (byte) (paint.measureText(r4.toString()) + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        }
        return bArr;
    }

    public byte[] getTextPixelBuffer(int i, int i2) {
        if (this.TEXT_FONTSIZE != i2) {
            this.TEXT_FONTSIZE = i2;
            createTextParam();
        }
        try {
            char c = (char) i;
            char[] cArr = {c};
            float f = this.base_line;
            int i3 = this.TEXT_FONTSIZE;
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i3, i3, android.graphics.Bitmap.Config.ALPHA_8);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            int i4 = this.TEXT_FONTSIZE;
            byte[] bArr = new byte[i4 * i4];
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
            float measureText = this.text_paint.measureText(java.lang.String.valueOf(c));
            char c2 = cArr[0];
            if (c2 > 0 && c2 < 256) {
                f -= 1.5f;
            }
            float f2 = f;
            android.graphics.Paint.Align textAlign = this.text_paint.getTextAlign();
            float textSize = this.text_paint.getTextSize();
            float f3 = measureText - this.TEXT_FONTSIZE_TRUE;
            android.graphics.Paint.Align align = android.graphics.Paint.Align.CENTER;
            if (textAlign == align || f3 < 4.0f) {
                canvas.drawText(cArr, 0, 1, this.start_x, f2, this.text_paint);
            } else {
                this.text_paint.setTextAlign(align);
                this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - f3);
                canvas.drawText(cArr, 0, 1, (this.TEXT_FONTSIZE_TRUE - f3) / 2.0f, f2, this.text_paint);
                this.text_paint.setTextAlign(textAlign);
                this.text_paint.setTextSize(textSize);
            }
            createBitmap.copyPixelsToBuffer(wrap);
            com.amap.api.mapcore.util.dl.a(createBitmap);
            return bArr;
        } catch (java.lang.Exception | java.lang.OutOfMemoryError unused) {
            return null;
        }
    }
}
