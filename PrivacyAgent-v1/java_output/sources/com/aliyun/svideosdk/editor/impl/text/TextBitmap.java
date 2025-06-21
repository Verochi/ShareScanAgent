package com.aliyun.svideosdk.editor.impl.text;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TextBitmap {
    public android.graphics.Bitmap mBackgroundBmp;
    public java.lang.String mBackgroundImg;
    public int mBmpHeight;
    public int mBmpWidth;
    public java.lang.String mFontPath;
    public java.lang.CharSequence mText;
    public android.text.Layout.Alignment mTextAlignment;
    public int mTextColor;
    public int mTextHeight;
    public int mTextSize;
    public int mTextStrokeColor;
    public int mTextWidth;
    public int mBackgroundColor = 0;
    public int mTextPaddingX = 0;
    public int mTextPaddingY = 0;
    public int mMaxLines = 0;
    public float bitmapScale = 1.0f;
    public java.lang.CharSequence mEmojiText = "";
    public int breakStrategy = 1;
    public boolean useLineSpacingFromFallbacks = true;
    public float mSpacingMult = 1.0f;
    public float mSpacingAdd = 0.0f;
    public boolean mIncludePad = true;

    public static com.aliyun.svideosdk.editor.impl.text.TextBitmap fromEffectText(com.aliyun.svideosdk.common.struct.effect.EffectText effectText) {
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = new com.aliyun.svideosdk.editor.impl.text.TextBitmap();
        textBitmap.mText = effectText.text;
        textBitmap.mFontPath = effectText.getFontPath();
        textBitmap.mBmpWidth = effectText.width;
        textBitmap.mBmpHeight = effectText.height;
        textBitmap.mTextWidth = effectText.textWidth;
        textBitmap.mTextHeight = effectText.textHeight;
        textBitmap.mTextColor = effectText.textColor;
        textBitmap.mTextStrokeColor = effectText.textStrokeColor;
        textBitmap.mBackgroundColor = effectText.textLabelColor;
        textBitmap.mTextSize = effectText.mTextSize;
        textBitmap.mTextPaddingX = effectText.mTextPaddingX;
        textBitmap.mTextPaddingY = effectText.mTextPaddingY;
        textBitmap.mTextAlignment = effectText.mTextAlignment;
        textBitmap.mMaxLines = effectText.mTextMaxLines;
        if (!android.text.TextUtils.isEmpty(effectText.mBackgroundBmpPath) && new java.io.File(effectText.mBackgroundBmpPath).exists()) {
            android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(effectText.mBackgroundBmpPath);
            effectText.mBackgroundBmp = decodeFile;
            textBitmap.mBackgroundBmp = decodeFile;
        }
        return textBitmap;
    }
}
