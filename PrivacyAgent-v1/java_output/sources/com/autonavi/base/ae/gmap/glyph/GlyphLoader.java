package com.autonavi.base.ae.gmap.glyph;

/* loaded from: classes12.dex */
public class GlyphLoader {
    private static java.util.Map<java.lang.String, android.graphics.Typeface> FontFaceMap = new java.util.HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static java.lang.String decodeUnicode(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static java.lang.String decodeUnicode(short s2) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append((char) s2);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j) {
        nativeDestroyGlyphLoader(j);
    }

    private static com.autonavi.base.ae.gmap.glyph.FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        com.autonavi.base.ae.gmap.glyph.FontMetricsRequestParam fontMetricsRequestParam = new com.autonavi.base.ae.gmap.glyph.FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 4);
        int i = 12;
        if (1 == com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 8)) {
            int i2 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new java.lang.String(bArr, 16, i2);
            i = 16 + i2;
        }
        fontMetricsRequestParam.languageArr = new java.lang.String(bArr, i + 4, com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i));
        return fontMetricsRequestParam;
    }

    private static com.autonavi.base.ae.gmap.glyph.GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        com.autonavi.base.ae.gmap.glyph.GlyphRequestParam glyphRequestParam = new com.autonavi.base.ae.gmap.glyph.GlyphRequestParam();
        int i = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new java.lang.String(bArr, 4, i);
        int i2 = i + 4;
        com.autonavi.base.ae.gmap.glyph.Font font = new com.autonavi.base.ae.gmap.glyph.Font();
        font.nFontStyleCode = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i2);
        int i3 = i2 + 4;
        font.nFontSize = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i3);
        int i4 = i3 + 4;
        int i5 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i4);
        int i6 = i4 + 4;
        font.strName = new java.lang.String(bArr, i6, i5);
        int i7 = i6 + i5;
        com.autonavi.base.ae.gmap.glyph.FontMetrics fontMetrics = new com.autonavi.base.ae.gmap.glyph.FontMetrics();
        int i8 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i7);
        int i9 = i7 + 4;
        fontMetrics.fAscent = i8 * 0.001f;
        int i10 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i9);
        int i11 = i9 + 4;
        fontMetrics.fDescent = i10 * 0.001f;
        int i12 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i11);
        int i13 = i11 + 4;
        fontMetrics.fLeading = i12 * 0.001f;
        int i14 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i13);
        int i15 = i13 + 4;
        fontMetrics.fHeight = i14 * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i15);
        int i16 = i15 + 4;
        int i17 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i16);
        int i18 = i16 + 4;
        glyphRequestParam.strokeWidth = i17 * 0.001f;
        int i19 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i18);
        int i20 = i18 + 4;
        glyphRequestParam.languageArr = new java.lang.String(bArr, i20, i19);
        glyphRequestParam.isEmoji = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i20);
        int i21 = i20 + 4;
        glyphRequestParam.isSDF = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i21);
        int i22 = i21 + 4;
        int i23 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i22);
        int i24 = i22 + 4;
        if (1 == i23) {
            com.autonavi.base.ae.gmap.glyph.GlyphMetrics glyphMetrics = new com.autonavi.base.ae.gmap.glyph.GlyphMetrics();
            glyphMetrics.nWidth = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i24);
            int i25 = i24 + 4;
            glyphMetrics.nHeight = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i25);
            int i26 = i25 + 4;
            int i27 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i26);
            int i28 = i26 + 4;
            glyphMetrics.fLeft = i27 * 0.001f;
            glyphMetrics.fTop = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i28) * 0.001f;
            glyphMetrics.fAdvance = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(bArr, i28 + 4) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static com.autonavi.base.ae.gmap.glyph.FontMetrics getFontMetrics(byte[] bArr) {
        com.autonavi.base.ae.gmap.glyph.FontMetricsRequestParam genFontMetricsParam = genFontMetricsParam(bArr);
        android.text.TextPaint newTextPaint = newTextPaint(new com.autonavi.base.ae.gmap.glyph.FontStyle(genFontMetricsParam.nFontStyleCode), genFontMetricsParam.fFontSize, genFontMetricsParam.strName, false, 0.0f);
        android.graphics.Paint.FontMetrics fontMetrics = newTextPaint.getFontMetrics();
        com.autonavi.base.ae.gmap.glyph.FontMetrics fontMetrics2 = new com.autonavi.base.ae.gmap.glyph.FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = java.lang.Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = java.lang.Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = java.lang.Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = java.lang.Math.abs(fontMetrics.ascent) + java.lang.Math.abs(fontMetrics.descent);
        newTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static com.autonavi.base.ae.gmap.glyph.GlyphMetrics getGlyphMetrics(byte[] bArr) {
        com.autonavi.base.ae.gmap.glyph.GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle = new com.autonavi.base.ae.gmap.glyph.FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        boolean z = genGlyphRequestParam.drawingMode != 0;
        return loadGlyphMetrics(genGlyphRequestParam.strBuffer, fontStyle, r5.nFontSize, genGlyphRequestParam.font.strName, z, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster getGlyphRaster(byte[] bArr) {
        com.autonavi.base.ae.gmap.glyph.GlyphRequestParam genGlyphRequestParam = genGlyphRequestParam(bArr);
        com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle = new com.autonavi.base.ae.gmap.glyph.FontStyle(genGlyphRequestParam.font.nFontStyleCode);
        int i = genGlyphRequestParam.drawingMode;
        boolean z = i != 0;
        if (i == 3) {
            return loadPathRaster(genGlyphRequestParam.strBuffer, fontStyle, r2.nFontSize, genGlyphRequestParam.font.strName, z, genGlyphRequestParam.strokeWidth * 2.0f);
        }
        return loadGlyphRaster(genGlyphRequestParam.strBuffer, fontStyle, r5.nFontSize, genGlyphRequestParam.font.strName, z, genGlyphRequestParam.strokeWidth, genGlyphRequestParam.isEmoji > 0, genGlyphRequestParam.isSDF > 0);
    }

    private static com.autonavi.base.ae.gmap.glyph.GlyphMetrics loadGlyphMetrics(java.lang.String str, com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle, float f, java.lang.String str2, boolean z, float f2, boolean z2, boolean z3) {
        com.autonavi.base.ae.gmap.glyph.GlyphMetrics glyphMetrics = new com.autonavi.base.ae.gmap.glyph.GlyphMetrics();
        if (fontStyle == null || android.text.TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (z2) {
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i = (int) f;
                glyphMetrics.nWidth = i;
                glyphMetrics.nHeight = i;
                glyphMetrics.fAdvance = f;
            } else {
                android.text.TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
                android.graphics.Rect rect = new android.graphics.Rect();
                newTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float measureText = newTextPaint.measureText(" ", 0, 1);
                    float abs = java.lang.Math.abs(newTextPaint.getFontMetrics().ascent) + java.lang.Math.abs(newTextPaint.getFontMetrics().descent);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) measureText;
                    rect.bottom = (int) abs;
                }
                if (z && f2 > 0.0f) {
                    float f3 = f2 / 2.0f;
                    rect.top = (int) (rect.top - f3);
                    rect.left = (int) (rect.left - f3);
                    rect.right = (int) (rect.right + f3);
                    rect.bottom = (int) (rect.bottom + f3);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = java.lang.Math.abs(newTextPaint.getFontMetrics().ascent) - java.lang.Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = newTextPaint.measureText(str);
                newTextPaint.setTypeface(null);
            }
        } catch (java.lang.Exception unused) {
            glyphMetrics.bSuccess = false;
        }
        return glyphMetrics;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:8|9|10|(9:12|14|15|(1:19)|(1:23)|24|(9:26|(7:30|(1:32)(1:50)|33|(4:35|(4:37|(2:40|38)|41|42)|43|44)|45|(1:47)(1:49)|48)|51|(0)(0)|33|(0)|45|(0)(0)|48)|52|53)|56|14|15|(2:17|19)|(2:21|23)|24|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0131, code lost:
    
        r0.bSuccess = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0121 A[Catch: Exception -> 0x0131, TryCatch #1 {Exception -> 0x0131, blocks: (B:15:0x0040, B:17:0x0057, B:19:0x005d, B:23:0x0089, B:24:0x00a8, B:26:0x00ae, B:33:0x00bf, B:35:0x00fc, B:38:0x0102, B:40:0x0106, B:42:0x0114, B:45:0x0118, B:47:0x011e, B:48:0x0123, B:49:0x0121, B:51:0x00b7, B:52:0x012d), top: B:14:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadGlyphRaster(java.lang.String str, com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle, float f, java.lang.String str2, boolean z, float f2, boolean z2, boolean z3) {
        boolean z4;
        android.text.TextPaint newTextPaint;
        android.graphics.Rect rect;
        int i;
        android.content.Context context;
        com.autonavi.base.ae.gmap.glyph.GlyphRaster glyphRaster = new com.autonavi.base.ae.gmap.glyph.GlyphRaster();
        if (fontStyle == null || android.text.TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            context = com.amap.api.mapcore.util.p.a;
        } catch (java.lang.Throwable th) {
            new java.lang.StringBuilder("highText exception:").append(th.toString());
        }
        if (context != null) {
            z4 = ((java.lang.Boolean) com.autonavi.base.ae.gmap.glyph.ReflectUtil.invoke("android.view.accessibility.AccessibilityManager", (android.view.accessibility.AccessibilityManager) context.getApplicationContext().getSystemService("accessibility"), "isHighTextContrastEnabled", null)).booleanValue();
            newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
            rect = new android.graphics.Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() == 0 && rect.height() == 0) {
                float measureText = newTextPaint.measureText(" ", 0, 1);
                float abs = java.lang.Math.abs(newTextPaint.getFontMetrics().ascent) + java.lang.Math.abs(newTextPaint.getFontMetrics().descent);
                rect.right = (int) measureText;
                rect.bottom = (int) abs;
                rect.left = 0;
                rect.top = 0;
            }
            if (z && f2 > 0.0f) {
                float f3 = f2 / 2.0f;
                rect.top = (int) (rect.top - f3);
                rect.left = (int) (rect.left - f3);
                rect.right = (int) (rect.right + f3);
                rect.bottom = (int) (rect.bottom + f3);
            }
            if (!rect.isEmpty()) {
                android.graphics.Bitmap.Config config = android.graphics.Bitmap.Config.ALPHA_8;
                if (!z2 && !z4) {
                    i = 1;
                    int i2 = (!z3 ? 3 : 0) * 2;
                    android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(rect.width() + i2, rect.height() + i2, config);
                    new android.graphics.Canvas(createBitmap).drawText(str, (0 - rect.left) + r13, (0 - rect.top) + r13, newTextPaint);
                    int width = rect.width() + i2;
                    int height = rect.height() + i2;
                    int i3 = width * height;
                    byte[] bArr = new byte[i3 * i];
                    createBitmap.copyPixelsToBuffer(java.nio.ByteBuffer.wrap(bArr));
                    if (z4) {
                        byte[] bArr2 = new byte[i3];
                        for (int i4 = 0; i4 < height; i4++) {
                            for (int i5 = 0; i5 < width * i; i5 += i) {
                                int i6 = i4 * width;
                                bArr2[(i5 / i) + i6] = bArr[(i6 * i) + i5];
                            }
                        }
                        bArr = bArr2;
                    }
                    glyphRaster.bitmapWidth = width;
                    glyphRaster.bitmapHeight = height;
                    if (z2) {
                        glyphRaster.bitmapPixelMode = 0;
                    } else {
                        glyphRaster.bitmapPixelMode = 1;
                    }
                    glyphRaster.bitmapSize = bArr.length;
                    glyphRaster.bitmapBuffer = bArr;
                    createBitmap.recycle();
                    glyphRaster.bSuccess = true;
                }
                config = android.graphics.Bitmap.Config.ARGB_8888;
                i = 4;
                if (!z3) {
                }
                int i22 = (!z3 ? 3 : 0) * 2;
                android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(rect.width() + i22, rect.height() + i22, config);
                new android.graphics.Canvas(createBitmap2).drawText(str, (0 - rect.left) + r13, (0 - rect.top) + r13, newTextPaint);
                int width2 = rect.width() + i22;
                int height2 = rect.height() + i22;
                int i32 = width2 * height2;
                byte[] bArr3 = new byte[i32 * i];
                createBitmap2.copyPixelsToBuffer(java.nio.ByteBuffer.wrap(bArr3));
                if (z4) {
                }
                glyphRaster.bitmapWidth = width2;
                glyphRaster.bitmapHeight = height2;
                if (z2) {
                }
                glyphRaster.bitmapSize = bArr3.length;
                glyphRaster.bitmapBuffer = bArr3;
                createBitmap2.recycle();
                glyphRaster.bSuccess = true;
            }
            newTextPaint.setTypeface(null);
            return glyphRaster;
        }
        z4 = false;
        newTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
        rect = new android.graphics.Rect();
        newTextPaint.getTextBounds(str, 0, str.length(), rect);
        if (rect.width() == 0) {
            float measureText2 = newTextPaint.measureText(" ", 0, 1);
            float abs2 = java.lang.Math.abs(newTextPaint.getFontMetrics().ascent) + java.lang.Math.abs(newTextPaint.getFontMetrics().descent);
            rect.right = (int) measureText2;
            rect.bottom = (int) abs2;
            rect.left = 0;
            rect.top = 0;
        }
        if (z) {
            float f32 = f2 / 2.0f;
            rect.top = (int) (rect.top - f32);
            rect.left = (int) (rect.left - f32);
            rect.right = (int) (rect.right + f32);
            rect.bottom = (int) (rect.bottom + f32);
        }
        if (!rect.isEmpty()) {
        }
        newTextPaint.setTypeface(null);
        return glyphRaster;
    }

    public static com.autonavi.base.ae.gmap.glyph.GlyphRaster loadPathRaster(java.lang.String str, com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle, float f, java.lang.String str2, boolean z, float f2) {
        com.autonavi.base.ae.gmap.glyph.GlyphRaster glyphRaster = new com.autonavi.base.ae.gmap.glyph.GlyphRaster();
        if (fontStyle == null || android.text.TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            android.text.TextPaint newTextPaint = newTextPaint(fontStyle, f, str2, false, 0.0f);
            android.graphics.Rect rect = new android.graphics.Rect();
            newTextPaint.getTextBounds(str, 0, str.length(), rect);
            new android.graphics.Canvas(android.graphics.Bitmap.createBitmap(rect.width(), rect.height(), android.graphics.Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, newTextPaint);
            android.text.TextPaint newTextPaint2 = newTextPaint(fontStyle, f, str2, z, f2);
            android.graphics.Rect rect2 = new android.graphics.Rect();
            newTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z && f2 > 0.0f) {
                float f3 = 0.5f * f2;
                rect2.top = (int) (rect2.top - f3);
                rect2.left = (int) (rect2.left - f3);
                rect2.right = (int) (rect2.right + f3);
                rect2.bottom = (int) (rect2.bottom + f3);
            }
            if (!rect2.isEmpty()) {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(rect2.width(), rect2.height(), android.graphics.Bitmap.Config.ALPHA_8);
                android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
                float f4 = 0 - rect2.left;
                float f5 = 0 - rect2.top;
                android.graphics.Path path = new android.graphics.Path();
                newTextPaint.getTextPath(str, 0, str.length(), f4, f5, path);
                canvas.drawPath(path, newTextPaint2);
                int width = rect2.width() * rect2.height();
                byte[] bArr = new byte[width];
                java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = width;
                createBitmap.copyPixelsToBuffer(wrap);
                createBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
            newTextPaint.setTypeface(null);
            newTextPaint2.setTypeface(null);
        } catch (java.lang.Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j);

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
    
        if (r3 != false) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.text.TextPaint newTextPaint(com.autonavi.base.ae.gmap.glyph.FontStyle fontStyle, float f, java.lang.String str, boolean z, float f2) {
        boolean z2;
        android.graphics.Typeface create;
        android.text.TextPaint textPaint = new android.text.TextPaint();
        if (fontStyle == null) {
            return textPaint;
        }
        textPaint.setColor(-1);
        boolean z3 = true;
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTextSize(f);
        textPaint.setTextAlign(android.graphics.Paint.Align.LEFT);
        if (z) {
            textPaint.setStyle(android.graphics.Paint.Style.STROKE);
            textPaint.setStrokeWidth(f2);
        } else {
            textPaint.setStyle(android.graphics.Paint.Style.FILL);
        }
        int slant = fontStyle.getSlant();
        int i = 2;
        boolean z4 = slant != 0 && (slant == 1 || slant == 2);
        switch (fontStyle.getWeight()) {
            case 0:
            case 100:
            case 200:
            case 300:
            case 400:
            default:
                z2 = false;
                break;
            case 500:
            case 600:
            case 700:
            case 800:
            case 900:
            case 1000:
                z2 = true;
                break;
        }
        if (z2 && z4) {
            textPaint.setFakeBoldText(true);
        } else if (z2) {
            textPaint.setFakeBoldText(true);
        }
        i = 0;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                z3 = false;
            }
        } catch (java.lang.NumberFormatException unused) {
        }
        if (str.isEmpty() || z3) {
            create = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, i);
        } else {
            try {
                synchronized (FontFaceMap) {
                    create = FontFaceMap.get(str);
                    if (create == null) {
                        create = android.graphics.Typeface.createFromFile(str);
                        FontFaceMap.put(str, create);
                    }
                }
            } catch (java.lang.Exception unused2) {
                create = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, i);
            }
        }
        textPaint.setTypeface(create);
        return textPaint;
    }
}
