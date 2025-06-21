package com.aliyun.svideosdk.editor.e;

/* loaded from: classes12.dex */
class d implements com.aliyun.svideosdk.nativerender.BitmapGenerator {
    private com.aliyun.svideosdk.editor.NativeEditor a;
    private int b;
    private int c;
    private com.aliyun.svideosdk.editor.e.b d;
    private com.aliyun.svideosdk.common.struct.effect.EffectCaption e;
    private com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator f;
    private com.aliyun.svideosdk.editor.impl.text.TextBitmap g;
    private com.aliyun.svideosdk.editor.e.d.c h;
    private com.aliyun.svideosdk.editor.e.c i;

    public static class b {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;

        private b() {
        }

        public /* synthetic */ b(com.aliyun.svideosdk.editor.e.d.a aVar) {
            this();
        }

        public java.lang.String toString() {
            return "PasterParam{x=" + this.a + ", y=" + this.b + ", w=" + this.c + ", h=" + this.d + ", r=" + this.e + '}';
        }
    }

    public static class c {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public java.lang.String toString() {
            return "TextSizeSpec{textSize=" + this.a + ", centerX=" + this.b + ", centerY=" + this.c + ", width=" + this.d + ", height=" + this.e + ", textWidth=" + this.f + ", textHeight=" + this.g + '}';
        }
    }

    public d(com.aliyun.svideosdk.editor.NativeEditor nativeEditor, com.aliyun.svideosdk.editor.e.b bVar, int i, int i2, com.aliyun.svideosdk.editor.e.d.c cVar, com.aliyun.svideosdk.editor.e.c cVar2) {
        this.a = nativeEditor;
        this.d = bVar;
        this.b = i;
        this.c = i2;
        this.h = cVar;
        this.i = cVar2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Create RollCaptionView. captionInfo:");
        sb.append(bVar);
        sb.append(", textSizeSpec:");
        sb.append(cVar);
        sb.append(", captionStyle:");
        sb.append(cVar2);
    }

    private com.aliyun.svideosdk.editor.e.d.b a(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster) {
        float xRatio;
        float yRatio;
        float widthRatio;
        float heightRatio;
        int i;
        com.aliyun.svideosdk.editor.e.d.b bVar = new com.aliyun.svideosdk.editor.e.d.b(null);
        int i2 = effectPaster.width;
        int i3 = effectPaster.height;
        float f = effectPaster.x;
        int i4 = this.b;
        if (i4 <= 0 || (i = this.c) <= 0) {
            xRatio = effectPaster.getXRatio();
            yRatio = effectPaster.getYRatio();
            widthRatio = effectPaster.getWidthRatio();
            heightRatio = effectPaster.getHeightRatio();
        } else {
            float f2 = i4;
            xRatio = f / f2;
            float f3 = i;
            yRatio = f / f3;
            widthRatio = i2 / f2;
            heightRatio = i3 / f3;
            effectPaster.setXRatio(xRatio);
            effectPaster.setYRatio(yRatio);
            effectPaster.setWidthRatio(widthRatio);
            effectPaster.setHeightRatio(heightRatio);
        }
        bVar.a = xRatio;
        bVar.b = yRatio;
        bVar.c = widthRatio;
        bVar.d = heightRatio;
        bVar.e = -effectPaster.rotation;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("generatePasterParams params:");
        sb.append(bVar);
        return bVar;
    }

    private boolean a(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = effectCaption.end - effectCaption.start;
        com.aliyun.svideosdk.editor.e.d.b a2 = a(effectCaption);
        int addRollCaptionItemView = this.a.addRollCaptionItemView(bitmapGenerator, a2.a, a2.b, a2.c, a2.d, a2.e, this.b, this.c, effectCaption.start, j);
        if (addRollCaptionItemView <= 0 || addRollCaptionItemView > 268435456) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("addCaptionPaster FAILED. native invoke ret ");
            sb.append(addRollCaptionItemView);
            return false;
        }
        effectCaption.setViewId(addRollCaptionItemView);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("applyDisplay attach success., cost:");
        sb2.append(android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
        sb2.append(", vid:");
        sb2.append(addRollCaptionItemView);
        sb2.append(", start:");
        sb2.append(effectCaption.start);
        sb2.append(", end:");
        sb2.append(effectCaption.end);
        sb2.append(", duration:");
        sb2.append(j);
        sb2.append(", PasterParam:");
        sb2.append(a2);
        return true;
    }

    private com.aliyun.svideosdk.common.struct.effect.EffectCaption b() {
        com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = new com.aliyun.svideosdk.common.struct.effect.EffectCaption(new com.aliyun.svideosdk.common.struct.project.Source());
        effectCaption.start = this.d.a() * 1000;
        effectCaption.end = this.a.getDuration();
        a(effectCaption, this.h);
        return effectCaption;
    }

    public void a(com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption, com.aliyun.svideosdk.editor.e.d.c cVar) {
        effectCaption.textColor = this.i.c();
        effectCaption.textStrokeColor = this.i.f();
        effectCaption.text = this.d.b();
        effectCaption.font = this.i.a();
        effectCaption.fontSource = this.i.b();
        effectCaption.hasStroke = this.i.f() != 0;
        effectCaption.textWidth = cVar.f;
        effectCaption.textHeight = cVar.g;
        effectCaption.width = cVar.d;
        effectCaption.height = cVar.e;
        effectCaption.mTextSize = cVar.a;
        effectCaption.mTextMaxLines = 1;
        effectCaption.x = cVar.b;
        effectCaption.y = cVar.c;
        effectCaption.rotation = 0.0f;
    }

    public boolean a() {
        com.aliyun.svideosdk.common.struct.effect.EffectCaption b2 = b();
        this.e = b2;
        boolean a2 = a(this, b2);
        if (!a2) {
            this.e = null;
        }
        return a2;
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public android.graphics.Bitmap generateBitmap(int i, int i2) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        if (this.f == null) {
            this.g = new com.aliyun.svideosdk.editor.impl.text.TextBitmap();
            this.f = new com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator();
        }
        com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = this.e;
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = this.g;
        textBitmap.mText = effectCaption.text;
        textBitmap.mFontPath = effectCaption.getFontPath();
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap2 = this.g;
        textBitmap2.mBmpWidth = i;
        textBitmap2.mBmpHeight = i2;
        textBitmap2.mTextWidth = effectCaption.textWidth;
        textBitmap2.mTextHeight = effectCaption.textHeight;
        textBitmap2.mTextColor = effectCaption.textColor;
        textBitmap2.mTextStrokeColor = effectCaption.textStrokeColor;
        android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_CENTER;
        textBitmap2.mBackgroundColor = effectCaption.textLabelColor;
        textBitmap2.mBackgroundBmp = effectCaption.mBackgroundBmp;
        textBitmap2.mTextSize = effectCaption.mTextSize;
        textBitmap2.mTextPaddingX = effectCaption.mTextPaddingX;
        textBitmap2.mTextPaddingY = effectCaption.mTextPaddingY;
        textBitmap2.mTextAlignment = effectCaption.mTextAlignment;
        textBitmap2.mMaxLines = effectCaption.mTextMaxLines;
        this.f.updateTextBitmap(textBitmap2);
        android.graphics.Bitmap generateBitmap = this.f.generateBitmap(i, i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("generateBitmap cost:");
        sb.append(android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
        sb.append(", CaptionInfo:");
        sb.append(this.d);
        return generateBitmap;
    }
}
