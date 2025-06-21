package com.aliyun.svideosdk.editor.impl;

@java.lang.Deprecated
/* loaded from: classes12.dex */
class m extends com.aliyun.svideosdk.editor.impl.l implements com.aliyun.svideosdk.nativerender.BitmapGenerator {
    private com.aliyun.svideosdk.editor.impl.text.TextBitmap g;
    private com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator h;
    protected com.aliyun.svideosdk.common.struct.effect.EffectText i;

    public m(com.aliyun.svideosdk.common.struct.effect.EffectText effectText, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager) {
        super(effectText, pVar, aliyunPasterManager, false);
        this.i = effectText;
    }

    public m(com.aliyun.svideosdk.common.struct.effect.EffectText effectText, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectText, pVar, aliyunPasterManager, z);
        this.i = effectText;
    }

    private void a(android.widget.TextView textView) {
        boolean isFallbackLineSpacing;
        int breakStrategy;
        try {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i > 22) {
                com.aliyun.svideosdk.common.struct.effect.EffectText effectText = this.i;
                breakStrategy = textView.getBreakStrategy();
                effectText.breakStrategy = breakStrategy;
            }
            this.i.mIncludePad = textView.getIncludeFontPadding();
            this.i.mSpacingAdd = textView.getLineSpacingExtra();
            this.i.mSpacingMult = textView.getLineSpacingMultiplier();
            if (i > 27) {
                com.aliyun.svideosdk.common.struct.effect.EffectText effectText2 = this.i;
                isFallbackLineSpacing = textView.isFallbackLineSpacing();
                effectText2.useLineSpacingFromFallbacks = isFallbackLineSpacing;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void b() {
        if (isRevert()) {
            return;
        }
        this.i.textColor = this.b.getTextColor();
        this.i.textStrokeColor = this.b.getTextStrokeColor();
        this.i.text = this.b.getText();
        this.i.fontSource = this.b.getPasterTextFontSource();
        this.i.hasStroke = this.b.isTextHasStroke();
        this.i.hasLabel = this.b.isTextHasLabel();
        this.i.textLabelColor = this.b.getTextBgLabelColor();
        int pasterTextWidth = this.b.getPasterTextWidth();
        if (pasterTextWidth != 0) {
            this.i.textWidth = pasterTextWidth;
        }
        int pasterTextHeight = this.b.getPasterTextHeight();
        if (pasterTextHeight != 0) {
            this.i.textHeight = pasterTextHeight;
        }
        this.i.width = this.b.getPasterWidth();
        this.i.height = this.b.getPasterHeight();
        this.i.mBackgroundBmp = this.b.getBackgroundBitmap();
        float textFixSize = this.b.getTextFixSize();
        if (textFixSize <= 0.0f && (this.b.getTextView() instanceof android.widget.TextView)) {
            textFixSize = ((android.widget.TextView) this.b.getTextView()).getTextSize();
            a((android.widget.TextView) this.b.getTextView());
        }
        com.aliyun.svideosdk.common.struct.effect.EffectText effectText = this.i;
        effectText.mTextSize = (int) textFixSize;
        effectText.bitmapScale = textFixSize > 199.0f ? textFixSize / 199.0f : 1.0f;
        effectText.mTextPaddingX = this.b.getTextPaddingX();
        this.i.mTextPaddingY = this.b.getTextPaddingY();
        this.i.mTextAlignment = this.b.getTextAlign();
        this.i.mTextMaxLines = this.b.getTextMaxLines();
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public int editCompleted() {
        if (this.b == null) {
            return -4;
        }
        a();
        b();
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showTextPaster(this, this.i);
        }
        int addSubtitle = this.mRender.addSubtitle(this, this.i);
        if (addSubtitle != 0) {
            return addSubtitle;
        }
        this.c = true;
        return addSubtitle;
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public android.graphics.Bitmap generateBitmap(int i, int i2) {
        if (this.h == null) {
            this.g = new com.aliyun.svideosdk.editor.impl.text.TextBitmap();
            this.h = new com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator();
        }
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = this.g;
        com.aliyun.svideosdk.common.struct.effect.EffectText effectText = this.i;
        textBitmap.mText = effectText.text;
        textBitmap.mFontPath = effectText.getFontPath();
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap2 = this.g;
        textBitmap2.mBmpWidth = i;
        textBitmap2.mBmpHeight = i2;
        com.aliyun.svideosdk.common.struct.effect.EffectText effectText2 = this.i;
        textBitmap2.mTextWidth = effectText2.textWidth;
        textBitmap2.mTextHeight = effectText2.textHeight;
        textBitmap2.mTextColor = effectText2.textColor;
        textBitmap2.mTextStrokeColor = effectText2.textStrokeColor;
        android.text.Layout.Alignment alignment = android.text.Layout.Alignment.ALIGN_CENTER;
        textBitmap2.mBackgroundColor = effectText2.textLabelColor;
        textBitmap2.mBackgroundBmp = effectText2.mBackgroundBmp;
        textBitmap2.mTextSize = effectText2.mTextSize;
        textBitmap2.mTextPaddingX = effectText2.mTextPaddingX;
        textBitmap2.mTextPaddingY = effectText2.mTextPaddingY;
        textBitmap2.mTextAlignment = effectText2.mTextAlignment;
        textBitmap2.mMaxLines = effectText2.mTextMaxLines;
        textBitmap2.bitmapScale = effectText2.bitmapScale;
        textBitmap2.breakStrategy = effectText2.breakStrategy;
        textBitmap2.useLineSpacingFromFallbacks = effectText2.useLineSpacingFromFallbacks;
        textBitmap2.mSpacingAdd = effectText2.mSpacingAdd;
        textBitmap2.mSpacingMult = effectText2.mSpacingMult;
        textBitmap2.mIncludePad = effectText2.mIncludePad;
        this.h.updateTextBitmap(textBitmap2);
        return this.h.generateBitmap(i, i2);
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextColor() {
        return this.i.dTextColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextStrokeColor() {
        return this.i.dTextStrokeColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public com.aliyun.svideosdk.common.struct.effect.EffectBase getEffect() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public java.lang.String getPasterTextFont() {
        return this.i.getFontPath();
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource() {
        return this.i.fontSource;
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterType() {
        return 1;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public java.lang.String getText() {
        return this.i.text;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextBgLabelColor() {
        return this.i.textLabelColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextColor() {
        return this.i.textColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextStrokeColor() {
        return this.i.textStrokeColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterExists() {
        return true;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isTextHasStroke() {
        return this.i.hasLabel;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectText] */
    @Override // com.aliyun.svideosdk.editor.impl.l, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setEffect(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) {
            ?? r2 = (com.aliyun.svideosdk.common.struct.effect.EffectText) effectBase;
            this.i = r2;
            this.a = r2;
        }
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterView(com.aliyun.svideosdk.editor.AliyunPasterBaseView aliyunPasterBaseView) {
        super.setPasterView(aliyunPasterBaseView);
    }
}
