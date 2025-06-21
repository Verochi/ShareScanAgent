package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class n {
    public static float d = 640.0f;
    private int a = 0;
    private int b = 0;
    public int c;

    public void a(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = java.lang.Math.min(i, i2);
    }

    public void a(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack) {
        if (this.c == 0 || this.a == 0 || this.b == 0) {
            return;
        }
        photoPasterTrack.setId(effectPaster.getViewId());
        photoPasterTrack.setX(effectPaster.x / effectPaster.displayWidth);
        photoPasterTrack.setY(effectPaster.y / effectPaster.displayHeight);
        photoPasterTrack.setWidth(effectPaster.width / effectPaster.displayWidth);
        photoPasterTrack.setHeight(effectPaster.height / effectPaster.displayHeight);
        photoPasterTrack.setRotation(effectPaster.rotation);
        photoPasterTrack.setMirror(effectPaster.mirror);
        photoPasterTrack.setTimelineIn(effectPaster.start / 1000000.0f);
        photoPasterTrack.setTimelineOut(effectPaster.end / 1000000.0f);
        if (effectPaster.getPasterType() == 0) {
            photoPasterTrack.setSource(effectPaster.getSource());
            return;
        }
        if (effectPaster.getPasterType() == 1 || effectPaster.getPasterType() == 2) {
            com.aliyun.svideosdk.common.struct.effect.EffectText effectText = (com.aliyun.svideosdk.common.struct.effect.EffectText) effectPaster;
            com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack = (com.aliyun.svideosdk.common.struct.project.SubTitleTrack) photoPasterTrack;
            subTitleTrack.setText(effectText.text);
            subTitleTrack.setTextColor(effectText.textColor);
            subTitleTrack.setTextStrokeColor(effectText.textStrokeColor);
            subTitleTrack.setFont(effectText.getFontSource());
            subTitleTrack.setTextBmpPath(effectText.textBmpPath);
            subTitleTrack.setTextWidth(effectText.textWidth / effectPaster.displayWidth);
            subTitleTrack.setTextHeight(effectText.textHeight / effectPaster.displayHeight);
            subTitleTrack.setTextBackgroundColor(effectText.textLabelColor);
            subTitleTrack.setBackgroundImgPath(new com.aliyun.svideosdk.common.struct.project.Source(effectText.mBackgroundBmpPath));
            subTitleTrack.setTextSize(effectText.mTextSize / java.lang.Math.min(effectPaster.displayWidth, effectPaster.displayHeight));
            subTitleTrack.setTextPaddingX(effectText.mTextPaddingX / effectPaster.displayWidth);
            subTitleTrack.setTextPaddingY(effectText.mTextPaddingY / effectPaster.displayHeight);
            android.text.Layout.Alignment alignment = effectText.mTextAlignment;
            if (alignment != null) {
                subTitleTrack.setTextAlignment(alignment.ordinal());
            }
            subTitleTrack.setTextMaxLines(effectText.mTextMaxLines);
            if (effectPaster.getPasterType() == 2) {
                com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectPaster;
                photoPasterTrack.setSource(effectPaster.getSource());
                com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) photoPasterTrack;
                bubbleCaptionTrack.setTextCenterX(effectCaption.textCenterX / effectPaster.width);
                bubbleCaptionTrack.setTextCenterY(effectCaption.textCenterY / effectPaster.height);
            }
        }
    }

    public void a(com.aliyun.svideosdk.common.struct.effect.EffectText effectText, com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack) {
        effectText.text = subTitleTrack.getText();
        effectText.dTextColor = subTitleTrack.getTextColor();
        effectText.textColor = subTitleTrack.getTextColor();
        effectText.dTextStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.textStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.hasLabel = subTitleTrack.getTextBackgroundColor() == 0;
        effectText.textLabelColor = subTitleTrack.getTextBackgroundColor();
        if (subTitleTrack.getFont() != null && !com.aliyun.common.utils.StringUtils.isEmpty(subTitleTrack.getFont().getPath())) {
            effectText.font = subTitleTrack.getFont().getPath();
            effectText.fontSource = subTitleTrack.getFont();
        }
        effectText.textBmpPath = subTitleTrack.getTextBmpPath();
        if (subTitleTrack.getBackgroundImgPath() != null && !com.aliyun.common.utils.StringUtils.isEmpty(subTitleTrack.getBackgroundImgPath().getPath())) {
            effectText.mBackgroundBmpPath = subTitleTrack.getBackgroundImgPath().getPath();
        }
        float f = this.c / d;
        float textWidth = subTitleTrack.getTextWidth();
        float textHeight = subTitleTrack.getTextHeight();
        effectText.textWidth = (int) (textWidth * f);
        effectText.textHeight = (int) (textHeight * f);
        effectText.mTextSize = (int) (subTitleTrack.getTextSize() * f);
        effectText.mTextPaddingX = (int) (subTitleTrack.getTextPaddingX() * f);
        effectText.mTextPaddingY = (int) (subTitleTrack.getTextPaddingY() * f);
        effectText.mTextAlignment = (subTitleTrack.getTextAlignment() < 0 || subTitleTrack.getTextAlignment() > 2) ? android.text.Layout.Alignment.ALIGN_CENTER : android.text.Layout.Alignment.values()[subTitleTrack.getTextAlignment()];
        effectText.mTextMaxLines = subTitleTrack.getTextMaxLines();
        if (effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
            com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText;
            effectCaption.textRotation = subTitleTrack.getTextRotation();
            effectCaption.preBegin = (long) (subTitleTrack.getPreBegin() * 1000000.0f);
            effectCaption.preEnd = (long) (subTitleTrack.getPreEnd() * 1000000.0f);
            com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack;
            effectCaption.textCenterX = (int) (bubbleCaptionTrack.getTextCenterX() * f);
            effectCaption.textCenterY = (int) (bubbleCaptionTrack.getTextCenterY() * f);
        }
    }

    public boolean a() {
        return this.a > 0 && this.b > 0;
    }

    public void b(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack) {
        float f = this.c / d;
        effectPaster.width = (int) (photoPasterTrack.getWidth() * f);
        effectPaster.height = (int) (photoPasterTrack.getHeight() * f);
        if (a()) {
            float x = photoPasterTrack.getX();
            float y = photoPasterTrack.getY() * f;
            float f2 = x * f;
            int i = this.a;
            int i2 = this.b;
            if (i > i2) {
                if (d - photoPasterTrack.getWidth() != 0.0f) {
                    float f3 = (((this.a * r0) / this.b) - effectPaster.width) / 2.0f;
                    float height = photoPasterTrack.getHeight();
                    float f4 = d;
                    f2 += (f3 * (height - (f4 / 2.0f))) / ((f4 - photoPasterTrack.getWidth()) / 2.0f);
                }
            } else if (i2 > i && d - photoPasterTrack.getHeight() != 0.0f) {
                float f5 = (((this.b * r0) / this.a) - effectPaster.height) / 2.0f;
                float y2 = photoPasterTrack.getY();
                float f6 = d;
                y += (f5 * (y2 - (f6 / 2.0f))) / ((f6 - photoPasterTrack.getHeight()) / 2.0f);
            }
            float f7 = (this.a / 2) - f2;
            float f8 = (this.b / 2) - y;
            effectPaster.x = ((photoPasterTrack.getX() / d) * this.a) - f7;
            float y3 = photoPasterTrack.getY() / d;
            int i3 = this.b;
            effectPaster.y = (y3 * i3) - f8;
            effectPaster.displayWidth = this.a;
            effectPaster.displayHeight = i3;
        }
        effectPaster.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
        long timelineOut = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
        effectPaster.end = timelineOut;
        effectPaster.duration = timelineOut - effectPaster.start;
        effectPaster.rotation = photoPasterTrack.getRotation();
        effectPaster.mirror = photoPasterTrack.isMirror();
        effectPaster.name = photoPasterTrack.getName();
        effectPaster.frameArry = photoPasterTrack.getFrameArray();
        effectPaster.timeArry = photoPasterTrack.getTimeArray();
    }

    public void b(com.aliyun.svideosdk.common.struct.effect.EffectText effectText, com.aliyun.svideosdk.common.struct.project.SubTitleTrack subTitleTrack) {
        effectText.text = subTitleTrack.getText();
        effectText.dTextColor = subTitleTrack.getTextColor();
        effectText.textColor = subTitleTrack.getTextColor();
        effectText.dTextStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.textStrokeColor = subTitleTrack.getTextStrokeColor();
        effectText.hasLabel = subTitleTrack.getTextBackgroundColor() == 0;
        effectText.textLabelColor = subTitleTrack.getTextBackgroundColor();
        if (subTitleTrack.getFont() != null && !com.aliyun.common.utils.StringUtils.isEmpty(subTitleTrack.getFont().getPath())) {
            effectText.font = subTitleTrack.getFont().getPath();
            effectText.fontSource = subTitleTrack.getFont();
        }
        effectText.textBmpPath = subTitleTrack.getTextBmpPath();
        if (subTitleTrack.getBackgroundImgPath() != null && !com.aliyun.common.utils.StringUtils.isEmpty(subTitleTrack.getBackgroundImgPath().getPath())) {
            effectText.mBackgroundBmpPath = subTitleTrack.getBackgroundImgPath().getPath();
        }
        float textWidth = subTitleTrack.getTextWidth();
        float textHeight = subTitleTrack.getTextHeight();
        effectText.textWidth = (int) (textWidth * this.a);
        effectText.textHeight = (int) (textHeight * this.b);
        effectText.mTextSize = (int) (subTitleTrack.getTextSize() * java.lang.Math.min(this.a, this.b));
        effectText.mTextPaddingX = (int) (subTitleTrack.getTextPaddingX() * this.a);
        effectText.mTextPaddingY = (int) (subTitleTrack.getTextPaddingY() * this.b);
        effectText.mTextAlignment = (subTitleTrack.getTextAlignment() < 0 || subTitleTrack.getTextAlignment() > 2) ? android.text.Layout.Alignment.ALIGN_CENTER : android.text.Layout.Alignment.values()[subTitleTrack.getTextAlignment()];
        effectText.mTextMaxLines = subTitleTrack.getTextMaxLines();
        if (effectText instanceof com.aliyun.svideosdk.common.struct.effect.EffectCaption) {
            com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption = (com.aliyun.svideosdk.common.struct.effect.EffectCaption) effectText;
            effectCaption.textRotation = subTitleTrack.getTextRotation();
            effectCaption.preBegin = (long) (subTitleTrack.getPreBegin() * 1000000.0f);
            effectCaption.preEnd = (long) (subTitleTrack.getPreEnd() * 1000000.0f);
            com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack bubbleCaptionTrack = (com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack) subTitleTrack;
            effectCaption.textCenterX = (int) (bubbleCaptionTrack.getTextCenterX() * effectText.width);
            effectCaption.textCenterY = (int) (bubbleCaptionTrack.getTextCenterY() * effectText.height);
        }
    }

    public void c(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster, com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack photoPasterTrack) {
        effectPaster.width = (int) (photoPasterTrack.getWidth() * this.a);
        effectPaster.height = (int) (photoPasterTrack.getHeight() * this.b);
        if (a()) {
            effectPaster.x = photoPasterTrack.getX() * this.a;
            float y = photoPasterTrack.getY();
            int i = this.b;
            effectPaster.y = y * i;
            effectPaster.displayWidth = this.a;
            effectPaster.displayHeight = i;
        }
        effectPaster.start = (long) (photoPasterTrack.getTimelineIn() * 1000000.0f);
        long timelineOut = (long) (photoPasterTrack.getTimelineOut() * 1000000.0f);
        effectPaster.end = timelineOut;
        effectPaster.duration = timelineOut - effectPaster.start;
        effectPaster.rotation = photoPasterTrack.getRotation();
        effectPaster.mirror = photoPasterTrack.isMirror();
        effectPaster.name = photoPasterTrack.getName();
        effectPaster.frameArry = photoPasterTrack.getFrameArray();
        effectPaster.timeArry = photoPasterTrack.getTimeArray();
    }
}
