package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectText extends com.aliyun.svideosdk.common.struct.effect.EffectPaster {
    public float bitmapScale;
    public int breakStrategy;
    public int dTextColor;
    public int dTextStrokeColor;

    @java.lang.Deprecated
    public java.lang.String font;
    public com.aliyun.svideosdk.common.struct.project.Source fontSource;
    public boolean hasLabel;
    public boolean hasStroke;
    public android.graphics.Bitmap mBackgroundBmp;
    public java.lang.String mBackgroundBmpPath;
    public boolean mIncludePad;
    public float mSpacingAdd;
    public float mSpacingMult;
    public android.text.Layout.Alignment mTextAlignment;
    public int mTextMaxLines;
    public int mTextPaddingX;
    public int mTextPaddingY;
    public int mTextSize;
    public boolean needSaveBmp;
    public java.lang.String text;
    public android.text.Layout.Alignment textAlignment;
    public java.lang.String textBmpPath;
    public int textColor;
    public int textHeight;
    public int textLabelColor;
    public int textStrokeColor;
    public int textWidth;
    public boolean useLineSpacingFromFallbacks;

    public EffectText(com.aliyun.svideosdk.common.struct.project.Source source) {
        super(source);
        this.textLabelColor = 0;
        this.needSaveBmp = true;
        this.mTextMaxLines = 0;
        this.bitmapScale = 1.0f;
        this.breakStrategy = 1;
        this.useLineSpacingFromFallbacks = true;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mIncludePad = true;
    }

    @java.lang.Deprecated
    public EffectText(java.lang.String str) {
        super(str);
        this.textLabelColor = 0;
        this.needSaveBmp = true;
        this.mTextMaxLines = 0;
        this.bitmapScale = 1.0f;
        this.breakStrategy = 1;
        this.useLineSpacingFromFallbacks = true;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mIncludePad = true;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        super.copy(effectBase);
        if (effectBase instanceof com.aliyun.svideosdk.common.struct.effect.EffectText) {
            com.aliyun.svideosdk.common.struct.effect.EffectText effectText = (com.aliyun.svideosdk.common.struct.effect.EffectText) effectBase;
            effectText.textAlignment = this.textAlignment;
            effectText.text = this.text;
            effectText.textBmpPath = this.textBmpPath;
            effectText.textWidth = this.textWidth;
            effectText.textHeight = this.textHeight;
            effectText.textColor = this.textColor;
            effectText.dTextColor = this.dTextColor;
            effectText.textStrokeColor = this.textStrokeColor;
            effectText.font = this.font;
            if (this.fontSource != null) {
                com.aliyun.svideosdk.common.struct.project.Source source = new com.aliyun.svideosdk.common.struct.project.Source();
                source.setId(this.fontSource.getId());
                source.setPath(this.fontSource.getPath());
                source.setURL(this.fontSource.getURL());
                effectText.fontSource = source;
            }
            effectText.hasStroke = this.hasStroke;
            effectText.hasLabel = this.hasLabel;
            effectText.textLabelColor = this.textLabelColor;
            effectText.mBackgroundBmp = this.mBackgroundBmp;
            effectText.mBackgroundBmpPath = this.mBackgroundBmpPath;
            effectText.mTextSize = this.mTextSize;
            effectText.mTextPaddingX = this.mTextPaddingX;
            effectText.mTextPaddingY = this.mTextPaddingY;
            effectText.mTextAlignment = this.mTextAlignment;
            effectText.needSaveBmp = this.needSaveBmp;
            effectText.mTextMaxLines = this.mTextMaxLines;
            effectText.bitmapScale = this.bitmapScale;
            effectText.breakStrategy = this.breakStrategy;
            effectText.useLineSpacingFromFallbacks = this.useLineSpacingFromFallbacks;
            effectText.mSpacingAdd = this.mSpacingAdd;
            effectText.mSpacingMult = this.mSpacingMult;
            effectText.mIncludePad = this.mIncludePad;
        }
    }

    public java.lang.String generateTextFinger() {
        return com.aliyun.common.utils.MD5Util.getMD5(this.textAlignment + getViewId() + this.text + this.textWidth + this.textHeight + this.width + this.height + this.textColor + this.textStrokeColor + this.font + this.hasLabel + this.hasStroke + this.textLabelColor);
    }

    public java.lang.String getFontPath() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.fontSource;
        return (source == null || com.aliyun.common.utils.StringUtils.isEmpty(source.getPath())) ? this.font : this.fontSource.getPath();
    }

    public com.aliyun.svideosdk.common.struct.project.Source getFontSource() {
        com.aliyun.svideosdk.common.struct.project.Source source = this.fontSource;
        return source != null ? source : new com.aliyun.svideosdk.common.struct.project.Source(this.font);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster
    public int getPasterType() {
        return 1;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public java.lang.String toString() {
        return "EffectText{textAlignment=" + this.textAlignment + ", text='" + this.text + "', textBmpPath='" + this.textBmpPath + "', textWidth=" + this.textWidth + ", textHeight=" + this.textHeight + ", textColor=" + this.textColor + ", dTextColor=" + this.dTextColor + ", textStrokeColor=" + this.textStrokeColor + ", dTextStrokeColor=" + this.dTextStrokeColor + ", font='" + this.font + "', hasStroke=" + this.hasStroke + ", hasLabel=" + this.hasLabel + ", textLabelColor=" + this.textLabelColor + ", mBackgroundBmp=" + this.mBackgroundBmp + ", mBackgroundBmpPath='" + this.mBackgroundBmpPath + "', mTextSize=" + this.mTextSize + ", mTextPaddingX=" + this.mTextPaddingX + ", mTextPaddingY=" + this.mTextPaddingY + ", mTextAlignment=" + this.mTextAlignment + ", needSaveBmp=" + this.needSaveBmp + ", mTextMaxLines=" + this.mTextMaxLines + ", name='" + this.name + "', width=" + this.width + ", height=" + this.height + ", start=" + this.start + ", end=" + this.end + ", y=" + this.y + ", x=" + this.x + ", rotation=" + this.rotation + ", duration=" + this.duration + ", kernelFrame=" + this.kernelFrame + ", frameArry=" + this.frameArry + ", timeArry=" + this.timeArry + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + ", bitmapScale=" + this.bitmapScale + ", breakStrategy=" + this.breakStrategy + ", useLineSpacingFromFallbacks=" + this.useLineSpacingFromFallbacks + ", mIncludePad=" + this.mIncludePad + ", mSpacingAdd=" + this.mSpacingAdd + ", mSpacingMult=" + this.mSpacingMult + '}';
    }
}
