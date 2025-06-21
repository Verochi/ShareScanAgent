package com.aliyun.svideo.editor.bean;

/* loaded from: classes12.dex */
public class PasterRestoreBean {
    private com.aliyun.svideosdk.common.struct.effect.EffectBase mEffectBase;
    private com.aliyun.svideosdk.common.struct.effect.ActionBase mFrameAction;
    private int mFrameSelectedPosition;
    private com.aliyun.svideosdk.common.struct.effect.ActionBase mTempFrameAction;

    public com.aliyun.svideosdk.common.struct.effect.EffectBase getEffectBase() {
        return this.mEffectBase;
    }

    public com.aliyun.svideosdk.common.struct.effect.ActionBase getFrameAction() {
        return this.mFrameAction;
    }

    public int getFrameSelectedPosition() {
        return this.mFrameSelectedPosition;
    }

    public com.aliyun.svideosdk.common.struct.effect.ActionBase getTempFrameAction() {
        return this.mTempFrameAction;
    }

    public void setEffectBase(com.aliyun.svideosdk.common.struct.effect.EffectBase effectBase) {
        this.mEffectBase = effectBase;
    }

    public void setFrameAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        this.mFrameAction = actionBase;
    }

    public void setFrameSelectedPosition(int i) {
        this.mFrameSelectedPosition = i;
    }

    public void setTempFrameAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        this.mTempFrameAction = actionBase;
    }
}
