package com.aliyun.svideosdk.font;

@com.aliyun.Visible
/* loaded from: classes12.dex */
class AliyunTextGenerator {
    private static final int FONT_WEIGHT_BOLD = 600;
    private static final int FONT_WEIGHT_NORMAL = 450;
    private static final java.lang.String TAG = "AliyunTextGenerator";
    private boolean mIsItalic;
    private boolean mOnlyLayout;
    private com.aliyun.svideosdk.font.c mTextLayout;

    @com.aliyun.Visible
    public static class TextGlyph {
        public android.graphics.RectF bound;
        public int codePoint = -1;
        public boolean colorGlyph = false;
        public android.graphics.PointF pos;
    }

    @com.aliyun.Visible
    public static class TextLayout {
        public android.graphics.Bitmap bitmap;
        public android.graphics.RectF bound;
        public java.util.List<com.aliyun.svideosdk.font.AliyunTextGenerator.TextGlyph> glyphList;
    }

    @com.aliyun.Visible
    public AliyunTextGenerator(java.lang.String str, java.lang.String str2) {
        this(str, str2, 48.0f, 0.0f, false, false, false, 1, 0, 0, false);
    }

    @com.aliyun.Visible
    public AliyunTextGenerator(java.lang.String str, java.lang.String str2, float f, float f2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4) {
        this.mOnlyLayout = false;
        this.mIsItalic = z2;
        this.mTextLayout = new com.aliyun.svideosdk.font.b(str, com.aliyun.svideosdk.font.a.a(com.aliyun.svideosdk.font.a.a(getApplicationContext(), str2, z ? 600 : FONT_WEIGHT_NORMAL, z2), f, z ? 600 : FONT_WEIGHT_NORMAL, z2, f2), 0.0f, z3, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, i, i2, -1);
        this.mOnlyLayout = z4;
    }

    private android.graphics.PointF calcGlyphSizeInCanvasPixel(com.aliyun.svideosdk.font.c.b bVar, android.graphics.Canvas canvas) {
        android.graphics.Matrix matrix = canvas.getMatrix();
        if (matrix == null) {
            return new android.graphics.PointF(bVar.b.width(), bVar.b.height());
        }
        float[] fArr = {0.0f, 0.0f, bVar.b.width(), bVar.b.height()};
        matrix.mapPoints(fArr);
        return new android.graphics.PointF(java.lang.Math.abs(fArr[2] - fArr[0]), java.lang.Math.abs(fArr[3] - fArr[1]));
    }

    private android.content.Context getApplicationContext() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            return (android.app.Application) cls.getMethod("getApplication", new java.lang.Class[0]).invoke(cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, null), null);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private android.graphics.Paint selectPaint(com.aliyun.svideosdk.font.c cVar, boolean z) {
        android.text.Layout a = cVar.a();
        if (a == null) {
            return null;
        }
        android.text.TextPaint paint = a.getPaint();
        if (!z) {
            return paint;
        }
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setTypeface(paint.getTypeface());
        paint2.setTextSize(paint.getTextSize());
        paint2.setFakeBoldText(paint.isFakeBoldText());
        paint2.setTextSkewX(paint.getTextSkewX());
        paint2.setLetterSpacing(paint.getLetterSpacing());
        return paint2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x000c, B:9:0x0013, B:12:0x001e, B:19:0x0040, B:20:0x0043, B:22:0x0049, B:24:0x0055, B:28:0x0060, B:30:0x0103, B:33:0x007a, B:35:0x008f, B:36:0x009a, B:37:0x0093), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x000c, B:9:0x0013, B:12:0x001e, B:19:0x0040, B:20:0x0043, B:22:0x0049, B:24:0x0055, B:28:0x0060, B:30:0x0103, B:33:0x007a, B:35:0x008f, B:36:0x009a, B:37:0x0093), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x000c, B:9:0x0013, B:12:0x001e, B:19:0x0040, B:20:0x0043, B:22:0x0049, B:24:0x0055, B:28:0x0060, B:30:0x0103, B:33:0x007a, B:35:0x008f, B:36:0x009a, B:37:0x0093), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103 A[Catch: Exception -> 0x0109, TRY_LEAVE, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x000c, B:9:0x0013, B:12:0x001e, B:19:0x0040, B:20:0x0043, B:22:0x0049, B:24:0x0055, B:28:0x0060, B:30:0x0103, B:33:0x007a, B:35:0x008f, B:36:0x009a, B:37:0x0093), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x000c, B:9:0x0013, B:12:0x001e, B:19:0x0040, B:20:0x0043, B:22:0x0049, B:24:0x0055, B:28:0x0060, B:30:0x0103, B:33:0x007a, B:35:0x008f, B:36:0x009a, B:37:0x0093), top: B:5:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean drawTextGlyph(com.aliyun.svideosdk.font.c cVar, int i, int i2, float f, float f2, android.graphics.Canvas canvas, boolean z, boolean z2) {
        android.graphics.Paint selectPaint;
        boolean z3;
        boolean z4;
        int i3;
        if (canvas == null) {
            return false;
        }
        try {
            com.aliyun.svideosdk.font.c.b a = cVar.a(i, i2);
            if (a == null || (selectPaint = selectPaint(cVar, z2)) == null) {
                return false;
            }
            selectPaint.setAntiAlias(z);
            selectPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OVER));
            if (f == 0.0f && f2 == 0.0f) {
                z3 = false;
                if (z3) {
                    canvas.translate(f, f2);
                }
                if (android.os.Build.VERSION.SDK_INT < 30) {
                    android.graphics.PointF calcGlyphSizeInCanvasPixel = calcGlyphSizeInCanvasPixel(a, canvas);
                    if (calcGlyphSizeInCanvasPixel.x >= 256.0f || calcGlyphSizeInCanvasPixel.y >= 256.0f) {
                        z4 = true;
                        if (z4) {
                            float width = a.b.width() / a.b.height();
                            int i4 = 256;
                            if (width >= 1.0f) {
                                i3 = (int) (256 / width);
                            } else {
                                i4 = (int) (256 * width);
                                i3 = 256;
                            }
                            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i4, i3, android.graphics.Bitmap.Config.ARGB_8888);
                            createBitmap.eraseColor(0);
                            android.graphics.Canvas canvas2 = new android.graphics.Canvas(createBitmap);
                            android.graphics.Matrix matrix = new android.graphics.Matrix();
                            android.graphics.RectF rectF = a.b;
                            matrix.postTranslate(-rectF.left, -rectF.top);
                            matrix.postScale(i4 / a.b.width(), i3 / a.b.height());
                            canvas2.setMatrix(matrix);
                            android.graphics.Xfermode xfermode = selectPaint.getXfermode();
                            selectPaint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
                            selectPaint.setStyle(android.graphics.Paint.Style.FILL);
                            java.lang.String d = cVar.d();
                            int i5 = a.g;
                            int i6 = a.h;
                            android.graphics.PointF pointF = a.a;
                            canvas2.drawText(d, i5, i6, pointF.x, pointF.y, selectPaint);
                            selectPaint.setXfermode(xfermode);
                            canvas.drawBitmap(createBitmap, (android.graphics.Rect) null, a.b, selectPaint);
                        } else {
                            selectPaint.setStyle(android.graphics.Paint.Style.FILL);
                            java.lang.String d2 = cVar.d();
                            int i7 = a.g;
                            int i8 = a.h;
                            android.graphics.PointF pointF2 = a.a;
                            canvas.drawText(d2, i7, i8, pointF2.x, pointF2.y, selectPaint);
                        }
                        if (z3) {
                            canvas.translate(-f, -f2);
                        }
                        return true;
                    }
                }
                z4 = false;
                if (z4) {
                }
                if (z3) {
                }
                return true;
            }
            z3 = true;
            if (z3) {
            }
            if (android.os.Build.VERSION.SDK_INT < 30) {
            }
            z4 = false;
            if (z4) {
            }
            if (z3) {
            }
            return true;
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("");
            sb.append(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @com.aliyun.Visible
    public com.aliyun.svideosdk.font.AliyunTextGenerator.TextLayout generateTextGlyph() {
        com.aliyun.svideosdk.font.AliyunTextGenerator.TextLayout textLayout = new com.aliyun.svideosdk.font.AliyunTextGenerator.TextLayout();
        android.graphics.RectF b = this.mTextLayout.b();
        if (this.mIsItalic && b != null) {
            b.set(b.left, b.top, b.right + (this.mTextLayout.a(0, this.mTextLayout.a(0) - 1).b.width() / 2.0f), b.bottom);
        }
        if (b.width() > 0.0f && b.height() > 0.0f) {
            textLayout.bound = b;
            textLayout.glyphList = new java.util.ArrayList();
            if (this.mOnlyLayout) {
                for (int i = 0; i < this.mTextLayout.c(); i++) {
                    for (int i2 = 0; i2 < this.mTextLayout.a(i); i2++) {
                        com.aliyun.svideosdk.font.c.b a = this.mTextLayout.a(i, i2);
                        com.aliyun.svideosdk.font.AliyunTextGenerator.TextGlyph textGlyph = new com.aliyun.svideosdk.font.AliyunTextGenerator.TextGlyph();
                        textGlyph.codePoint = a.i;
                        textGlyph.pos = a.a;
                        textGlyph.bound = a.b;
                        textGlyph.colorGlyph = a.d;
                        textLayout.glyphList.add(textGlyph);
                    }
                }
            } else {
                textLayout.bitmap = android.graphics.Bitmap.createBitmap((int) b.width(), (int) b.height(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(textLayout.bitmap);
                java.util.HashSet hashSet = new java.util.HashSet();
                for (int i3 = 0; i3 < this.mTextLayout.c(); i3++) {
                    for (int i4 = 0; i4 < this.mTextLayout.a(i3); i4++) {
                        com.aliyun.svideosdk.font.c.b a2 = this.mTextLayout.a(i3, i4);
                        com.aliyun.svideosdk.font.AliyunTextGenerator.TextGlyph textGlyph2 = new com.aliyun.svideosdk.font.AliyunTextGenerator.TextGlyph();
                        textGlyph2.codePoint = a2.i;
                        textGlyph2.pos = a2.a;
                        textGlyph2.bound = a2.b;
                        textGlyph2.colorGlyph = a2.d;
                        textLayout.glyphList.add(textGlyph2);
                        int i5 = textGlyph2.codePoint;
                        if (i5 >= 0) {
                            if (!hashSet.contains(java.lang.Integer.valueOf(i5))) {
                                hashSet.add(java.lang.Integer.valueOf(textGlyph2.codePoint));
                            }
                        }
                        drawTextGlyph(this.mTextLayout, i3, i4, 0.0f, 0.0f, canvas, true, false);
                    }
                }
            }
        }
        return textLayout;
    }
}
