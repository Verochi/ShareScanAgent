package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunPasterRender {
    int addCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    @java.lang.Deprecated
    int addCaptionPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption);

    @java.lang.Deprecated
    int addCaptionPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption);

    int addEffectPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    @java.lang.Deprecated
    int addSubtitle(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectText effectText);

    @java.lang.Deprecated
    int addSubtitle(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectText effectText);

    int applyPaintCanvas(com.aliyun.svideosdk.common.struct.effect.EffectPaint effectPaint);

    java.util.List<com.aliyun.svideosdk.common.AliyunCaption> findCaptions(long j);

    com.aliyun.common.utils.Size getDisplaySize();

    int hidePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    void removeCanvas();

    int removeCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    int removePaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    void setDisplaySize(int i, int i2);

    int setEffectWaterMark(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage);

    void setOnPasterResumeAndSave(com.aliyun.svideosdk.editor.OnPasterResumeAndSave onPasterResumeAndSave);

    int showCaptionPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption);

    int showCaptionPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectCaption effectCaption);

    int showPaster(com.aliyun.svideosdk.common.struct.effect.EffectPaster effectPaster);

    int showTextPaster(android.graphics.Bitmap bitmap, com.aliyun.svideosdk.common.struct.effect.EffectText effectText);

    int showTextPaster(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, com.aliyun.svideosdk.common.struct.effect.EffectText effectText);

    int updateCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);
}
