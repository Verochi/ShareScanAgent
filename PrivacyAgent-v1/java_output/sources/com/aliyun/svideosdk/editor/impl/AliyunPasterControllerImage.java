package com.aliyun.svideosdk.editor.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunPasterControllerImage extends com.aliyun.svideosdk.editor.impl.AliyunPasterAbstractController<com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage>> {
    private com.aliyun.svideosdk.editor.impl.g mEditor;

    public AliyunPasterControllerImage(com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> trackEffect, com.aliyun.svideosdk.editor.impl.p pVar, com.aliyun.svideosdk.editor.impl.g gVar) {
        super(trackEffect, pVar);
        this.mEditor = gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply() {
        if (((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getViewId() != 0) {
            this.mEditor.b((com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage>) this.mModel);
        }
        ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).setViewId(this.mEditor.a((com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage>) this.mModel));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getDuration());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.PointF getPosition() {
        android.graphics.PointF pointF = new android.graphics.PointF(((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getXRadio(), ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getYRadio());
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        pointF.x *= displaySize.getWidth();
        pointF.y *= displaySize.getHeight();
        return pointF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getRotation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public android.graphics.RectF getSize() {
        float xRadio = ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getXRadio();
        float yRadio = ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getYRadio();
        float widthRatio = ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getWidthRatio();
        float heightRatio = ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).getHeightRatio();
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        float f = widthRatio * 0.5f;
        float f2 = heightRatio * 0.5f;
        android.graphics.RectF rectF = new android.graphics.RectF(xRadio - f, yRadio - f2, xRadio + f, yRadio + f2);
        rectF.left *= displaySize.getWidth();
        rectF.right *= displaySize.getWidth();
        rectF.top *= displaySize.getHeight();
        rectF.bottom *= displaySize.getHeight();
        return rectF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return java.util.concurrent.TimeUnit.MILLISECONDS.toMicros(((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.h
    public int remove() {
        this.mEditor.b((com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage>) this.mModel);
        ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).setViewId(0);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).setDuration(j, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setPosition(android.graphics.PointF pointF) {
        android.graphics.PointF pointF2 = new android.graphics.PointF();
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        pointF2.x = pointF.x / displaySize.getWidth();
        pointF2.y = pointF.y / displaySize.getHeight();
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).setXRadio(pointF2.x);
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).setYRatio(pointF2.y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setRotate(float f) {
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).setRotation(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSize(float f, float f2) {
        com.aliyun.common.utils.Size displaySize = this.mRender.getDisplaySize();
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).setWidthRatio(f / displaySize.getWidth());
        ((com.aliyun.svideosdk.common.struct.effect.EffectImage) ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).getBean()).setHeightRatio(f2 / displaySize.getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, java.util.concurrent.TimeUnit timeUnit) {
        ((com.aliyun.svideosdk.common.struct.effect.TrackEffect) this.mModel).setStartTime(j, timeUnit);
    }
}
