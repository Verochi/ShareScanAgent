package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunPasterBaseView {
    android.graphics.Bitmap getBackgroundBitmap();

    int getPasterCenterX();

    int getPasterCenterY();

    int getPasterHeight();

    float getPasterRotation();

    @java.lang.Deprecated
    java.lang.String getPasterTextFont();

    com.aliyun.svideosdk.common.struct.project.Source getPasterTextFontSource();

    int getPasterTextHeight();

    int getPasterTextOffsetX();

    int getPasterTextOffsetY();

    float getPasterTextRotation();

    int getPasterTextWidth();

    android.view.View getPasterView();

    int getPasterWidth();

    java.lang.String getText();

    android.text.Layout.Alignment getTextAlign();

    int getTextBgLabelColor();

    int getTextColor();

    int getTextFixSize();

    int getTextMaxLines();

    int getTextPaddingX();

    int getTextPaddingY();

    int getTextStrokeColor();

    android.view.View getTextView();

    boolean isPasterMirrored();

    boolean isTextHasLabel();

    boolean isTextHasStroke();

    android.graphics.Bitmap transToImage();
}
