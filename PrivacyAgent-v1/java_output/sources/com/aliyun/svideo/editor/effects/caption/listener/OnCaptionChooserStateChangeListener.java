package com.aliyun.svideo.editor.effects.caption.listener;

/* loaded from: classes12.dex */
public interface OnCaptionChooserStateChangeListener {
    com.aliyun.svideosdk.editor.impl.AliyunPasterControllerCompoundCaption getAliyunPasterController();

    boolean isInvert();

    void onBubbleEffectTemplateChanged(@androidx.annotation.Nullable com.aliyun.svideosdk.common.struct.project.Source source, @androidx.annotation.Nullable com.aliyun.svideosdk.common.struct.project.Source source2);

    void onCaptionCancel();

    void onCaptionConfirm();

    void onCaptionFrameAnimation(int i);

    void onCaptionTextAlignmentChanged(int i);

    void onCaptionTextBackgroundColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    void onCaptionTextBackgroundCornerRadiusChanged(int i);

    void onCaptionTextChanged(java.lang.String str);

    void onCaptionTextColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    void onCaptionTextFontTtfChanged(com.aliyun.svideosdk.common.struct.project.Source source);

    void onCaptionTextFontTypeFaceChanged(com.aliyun.svideosdk.common.AliyunTypeface aliyunTypeface);

    void onCaptionTextShandowColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    void onCaptionTextShandowOffsetChanged(android.graphics.PointF pointF);

    void onCaptionTextStrokeColorChanged(com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    void onCaptionTextStrokeWidthChanged(int i);

    void onFontEffectTemplateChanged(@androidx.annotation.Nullable com.aliyun.svideosdk.common.struct.project.Source source);
}
