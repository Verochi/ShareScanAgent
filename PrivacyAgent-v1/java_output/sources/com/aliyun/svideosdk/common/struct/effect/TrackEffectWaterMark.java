package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class TrackEffectWaterMark extends com.aliyun.svideosdk.common.struct.effect.EffectBase {
    protected com.aliyun.svideosdk.common.struct.effect.EffectRect mEffectRect = new com.aliyun.svideosdk.common.struct.effect.EffectRect();

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark effectMv = new com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark();

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark build() {
            return this.effectMv;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder setHeightRatio(float f) {
            this.effectMv.setHeightRatio(f);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder setWidthRatio(float f) {
            this.effectMv.setWidthRatio(f);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder setXRadio(float f) {
            this.effectMv.setXRadio(f);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder setYRatio(float f) {
            this.effectMv.setYRatio(f);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark.Builder source(com.aliyun.svideosdk.common.struct.project.Source source) {
            this.effectMv.setSource(source);
            return this;
        }
    }

    public float getHeightRatio() {
        return this.mEffectRect.getHeightRatio();
    }

    public float getWidthRatio() {
        return this.mEffectRect.getWidthRatio();
    }

    public float getXRadio() {
        return this.mEffectRect.getXRadio();
    }

    public float getYRadio() {
        return this.mEffectRect.getYRadio();
    }

    public void setHeightRatio(float f) {
        this.mEffectRect.setHeightRatio(f);
    }

    public void setWidthRatio(float f) {
        this.mEffectRect.setWidthRatio(f);
    }

    public void setXRadio(float f) {
        this.mEffectRect.setXRadio(f);
    }

    public void setYRatio(float f) {
        this.mEffectRect.setYRatio(f);
    }
}
