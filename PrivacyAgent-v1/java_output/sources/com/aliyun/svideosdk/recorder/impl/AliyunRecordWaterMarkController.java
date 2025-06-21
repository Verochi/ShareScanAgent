package com.aliyun.svideosdk.recorder.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunRecordWaterMarkController extends com.aliyun.svideosdk.recorder.impl.a<com.aliyun.svideosdk.common.struct.effect.EffectImage> {
    protected com.aliyun.svideosdk.recorder.impl.d mRecordStickerExecutor;

    public AliyunRecordWaterMarkController(com.aliyun.svideosdk.common.struct.project.Source source, com.aliyun.svideosdk.recorder.impl.d dVar) {
        this.mModel = new com.aliyun.svideosdk.common.struct.effect.EffectImage(source);
        this.mRecordStickerExecutor = dVar;
    }

    public float getHeightRatio() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getHeightRatio();
    }

    public float getRotation() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getRotation();
    }

    public com.aliyun.svideosdk.common.struct.project.Source getSource() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getSource();
    }

    @Override // com.aliyun.svideosdk.recorder.impl.a
    public com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType getType() {
        return com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType.WATERMARK;
    }

    public float getWidthRatio() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getWidthRatio();
    }

    public float getXRadio() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getXRadio();
    }

    public float getYRadio() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getYRadio();
    }

    @Override // com.aliyun.svideosdk.common.framework.a.a
    public void onUpdate(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        if (this.mRecordStickerExecutor != null) {
            if (((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).getViewId() == 0) {
                this.mRecordStickerExecutor.a(this);
            } else {
                this.mRecordStickerExecutor.c(this);
            }
        }
    }

    public void setHeightRatio(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setHeightRatio(f);
    }

    public void setRotation(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setRotation(f);
    }

    public void setSource(com.aliyun.svideosdk.common.struct.project.Source source) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setSource(source);
    }

    public void setWidthRatio(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setWidthRatio(f);
    }

    public void setXRadio(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setXRadio(f);
    }

    public void setYRatio(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) this.mModel).setYRatio(f);
    }
}
