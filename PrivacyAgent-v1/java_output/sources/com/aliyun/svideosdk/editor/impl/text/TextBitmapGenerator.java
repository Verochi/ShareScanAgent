package com.aliyun.svideosdk.editor.impl.text;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TextBitmapGenerator implements com.aliyun.svideosdk.nativerender.BitmapGenerator {
    public static final float MAX_TEXT_SIZE = 199.0f;
    private com.aliyun.svideosdk.editor.impl.text.TextBitmap mTextBitmap;
    private final android.graphics.Canvas mCanvas = new android.graphics.Canvas();
    private final com.aliyun.svideosdk.editor.impl.text.b mTextBox = new com.aliyun.svideosdk.editor.impl.text.b();

    public class a implements java.io.FilenameFilter {
        public a(com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator textBitmapGenerator) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.toLowerCase().endsWith(".ttf");
        }
    }

    private void configureLayout(com.aliyun.svideosdk.editor.impl.text.a aVar, com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap) {
        com.aliyun.svideosdk.common.struct.asset.TypefaceConfig typefaceConfig;
        if (android.text.TextUtils.isEmpty(textBitmap.mFontPath)) {
            typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
        } else {
            try {
                java.io.File file = new java.io.File(textBitmap.mFontPath);
                if (file.exists()) {
                    typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig(android.graphics.Typeface.createFromFile(textBitmap.mFontPath));
                } else {
                    java.io.File parentFile = file.getParentFile();
                    java.lang.String[] list = parentFile.list(new com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator.a(this));
                    if (list == null || list.length <= 0) {
                        typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
                    } else {
                        java.io.File file2 = new java.io.File(parentFile, list[0]);
                        if (file2.exists()) {
                            typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig(android.graphics.Typeface.createFromFile(file2));
                        } else {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append("Font file[");
                            sb.append(file2.getAbsolutePath());
                            sb.append("] not exist!");
                            typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
                typefaceConfig = new com.aliyun.svideosdk.common.struct.asset.TypefaceConfig();
            }
        }
        aVar.b(textBitmap.mTextPaddingX, textBitmap.mTextPaddingY);
        aVar.c(textBitmap.mTextSize);
        aVar.c(textBitmap.mTextWidth, textBitmap.mTextHeight);
        aVar.a(textBitmap.mBmpWidth, textBitmap.mBmpHeight);
        aVar.c(textBitmap.useLineSpacingFromFallbacks);
        aVar.f(textBitmap.breakStrategy);
        aVar.b(textBitmap.mIncludePad);
        aVar.a(textBitmap.mSpacingAdd, textBitmap.mSpacingMult);
        aVar.a(textBitmap.mText);
        aVar.b(textBitmap.mTextColor);
        aVar.a(textBitmap.mTextAlignment);
        aVar.e(textBitmap.mTextStrokeColor);
        aVar.a(android.graphics.Paint.Join.ROUND);
        aVar.a(textBitmap.mBackgroundColor);
        aVar.a(textBitmap.mBackgroundBmp);
        aVar.a(typefaceConfig.typeface);
        aVar.a(typefaceConfig.fakeBold);
        aVar.d(textBitmap.mMaxLines);
    }

    private android.graphics.Bitmap generateScaleEmojiBitmap() {
        try {
            com.aliyun.svideosdk.editor.impl.text.b bVar = new com.aliyun.svideosdk.editor.impl.text.b();
            float f = this.mTextBitmap.bitmapScale;
            float f2 = r1.mTextSize / f;
            int i = (int) (r1.mBmpWidth / f);
            int i2 = (int) (r1.mBmpHeight / f);
            com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = new com.aliyun.svideosdk.editor.impl.text.TextBitmap();
            textBitmap.mTextSize = (int) f2;
            com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap2 = this.mTextBitmap;
            textBitmap.mText = textBitmap2.mEmojiText;
            textBitmap.mBmpHeight = i2;
            textBitmap.mBmpWidth = i;
            textBitmap.mFontPath = textBitmap2.mFontPath;
            textBitmap.mMaxLines = textBitmap2.mMaxLines;
            textBitmap.mTextAlignment = textBitmap2.mTextAlignment;
            textBitmap.mTextHeight = (int) (textBitmap2.mTextHeight / f);
            textBitmap.mTextWidth = (int) (textBitmap2.mTextWidth / f);
            textBitmap.mTextPaddingX = (int) (textBitmap2.mTextPaddingX / f);
            textBitmap.mTextPaddingY = (int) (textBitmap2.mTextPaddingY / f);
            textBitmap.mTextStrokeColor = textBitmap2.mTextStrokeColor;
            textBitmap.mTextColor = textBitmap2.mTextColor;
            textBitmap.mBackgroundColor = 0;
            configureLayout(bVar, textBitmap);
            bVar.c();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            bVar.setBounds(0, 0, i, i2);
            int save = canvas.save();
            bVar.draw(canvas);
            canvas.restoreToCount(save);
            com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap3 = this.mTextBitmap;
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postScale(textBitmap3.mBmpWidth / i, textBitmap3.mBmpHeight / i2);
            return android.graphics.Bitmap.createBitmap(createBitmap, 0, 0, i, i2, matrix, true);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private android.graphics.Bitmap getImageAligned(android.graphics.drawable.Drawable drawable, int i, int i2) {
        return rasterize(drawable, i, i2);
    }

    public static boolean isEmojiCharacter(int i) {
        return (128 <= i && i <= 687) || (768 <= i && i <= 1023) || ((1536 <= i && i <= 1791) || ((3072 <= i && i <= 3199) || ((7616 <= i && i <= 7679) || ((7680 <= i && i <= 7935) || ((8192 <= i && i <= 8351) || ((8400 <= i && i <= 8527) || ((8592 <= i && i <= 9215) || ((9312 <= i && i <= 9727) || ((9728 <= i && i <= 10223) || ((10496 <= i && i <= 10751) || ((11008 <= i && i <= 11263) || ((11360 <= i && i <= 11391) || ((11776 <= i && i <= 11903) || ((42128 <= i && i <= 42191) || ((57344 <= i && i <= 63743) || ((65024 <= i && i <= 65039) || ((65072 <= i && i <= 65103) || ((126976 <= i && i <= 127023) || ((127136 <= i && i <= 127231) || ((127232 <= i && i <= 128591) || ((128640 <= i && i <= 128767) || ((129296 <= i && i <= 129387) || (129408 <= i && i <= 129504)))))))))))))))))))))));
    }

    private boolean isLineBreak(java.lang.CharSequence charSequence) {
        return android.text.TextUtils.equals(charSequence, "\n") || android.text.TextUtils.equals(charSequence, "\t") || android.text.TextUtils.equals(charSequence, "\r");
    }

    private android.graphics.Bitmap rasterize(android.graphics.drawable.Drawable drawable, int i, int i2) {
        android.graphics.Bitmap generateScaleEmojiBitmap;
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(createBitmap);
        drawable.setBounds(0, 0, i, i2);
        int save = this.mCanvas.save();
        drawable.draw(this.mCanvas);
        this.mCanvas.restoreToCount(save);
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = this.mTextBitmap;
        if (textBitmap.mTextSize > 199.0f && !android.text.TextUtils.isEmpty(textBitmap.mEmojiText) && (generateScaleEmojiBitmap = generateScaleEmojiBitmap()) != null) {
            this.mCanvas.drawBitmap(generateScaleEmojiBitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
        }
        return createBitmap;
    }

    private void replaceEmojiText() {
        try {
            com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = this.mTextBitmap;
            if (textBitmap.mTextSize > 199.0f && !android.text.TextUtils.isEmpty(textBitmap.mText)) {
                android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
                android.text.SpannableStringBuilder spannableStringBuilder2 = new android.text.SpannableStringBuilder();
                android.graphics.Paint paint = new android.graphics.Paint(1);
                paint.setTextSize(this.mTextBitmap.mTextSize);
                java.lang.String charSequence = this.mTextBitmap.mText.toString();
                int i = 0;
                boolean z = false;
                float f = 0.0f;
                while (i < charSequence.length()) {
                    if (isEmojiCharacter(java.lang.Character.codePointAt(this.mTextBitmap.mText, i))) {
                        if (f <= 0.0f) {
                            f = 0.98f * (paint.measureText(charSequence.subSequence(i, i + 2).toString()) / paint.measureText(" "));
                        }
                        if (i <= this.mTextBitmap.mText.length() - 2) {
                            spannableStringBuilder2.append(charSequence.subSequence(i, i + 2));
                        }
                        spannableStringBuilder.append((java.lang.CharSequence) " ");
                        spannableStringBuilder.setSpan(new android.text.style.ScaleXSpan(f), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                        i++;
                        z = true;
                    } else {
                        spannableStringBuilder.append(charSequence.charAt(i));
                        if (isLineBreak(java.lang.String.valueOf(charSequence.charAt(i)))) {
                            spannableStringBuilder2.append(charSequence.charAt(i));
                        } else {
                            float measureText = paint.measureText(java.lang.String.valueOf(charSequence.charAt(i))) / paint.measureText(" ");
                            spannableStringBuilder2.append((java.lang.CharSequence) " ");
                            spannableStringBuilder2.setSpan(new android.text.style.ScaleXSpan(measureText), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
                        }
                    }
                    i++;
                }
                if (z) {
                    this.mTextBitmap.mEmojiText = spannableStringBuilder2;
                }
                this.mTextBitmap.mText = spannableStringBuilder;
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public int align2(int i, int i2) {
        return ((i + i2) - 1) & (~(i2 - 1));
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public android.graphics.Bitmap generateBitmap(int i, int i2) {
        com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap = this.mTextBitmap;
        if (textBitmap != null) {
            textBitmap.mBmpWidth = i;
            textBitmap.mBmpHeight = i2;
        }
        configureLayout(this.mTextBox, textBitmap);
        this.mTextBox.c();
        return getImageAligned(this.mTextBox, i, i2);
    }

    public android.graphics.Bitmap generateTextBitmap(com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap) {
        this.mTextBitmap = textBitmap;
        replaceEmojiText();
        configureLayout(this.mTextBox, textBitmap);
        this.mTextBox.c();
        return getImageAligned(this.mTextBox, textBitmap.mBmpWidth, textBitmap.mBmpHeight);
    }

    public void updateTextBitmap(com.aliyun.svideosdk.editor.impl.text.TextBitmap textBitmap) {
        this.mTextBitmap = textBitmap;
        replaceEmojiText();
    }
}
