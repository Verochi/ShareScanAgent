package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
public abstract class a<MODEL extends com.aliyun.svideosdk.common.struct.effect.ICopyable<MODEL>> extends com.aliyun.svideosdk.common.framework.a.a<MODEL> {
    public MODEL getModel() {
        return this.mModel;
    }

    public abstract com.aliyun.svideosdk.recorder.impl.AliyunRecordStickerType getType();
}
