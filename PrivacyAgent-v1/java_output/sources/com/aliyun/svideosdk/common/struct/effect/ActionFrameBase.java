package com.aliyun.svideosdk.common.struct.effect;

/* loaded from: classes12.dex */
public abstract class ActionFrameBase<FRAME_VAL_PROPERTY> extends com.aliyun.svideosdk.common.struct.effect.ActionBase {
    @com.aliyun.Visible
    public void setFrameConfig(java.util.List<com.aliyun.svideosdk.common.struct.effect.Frame<FRAME_VAL_PROPERTY>> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            com.aliyun.svideosdk.common.struct.effect.Frame<FRAME_VAL_PROPERTY> frame = list.get(i);
            sb.append(frame.time);
            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            sb.append(frame.value.toString());
            sb.append(com.alipay.sdk.m.u.i.b);
        }
        this.mAnimationConfig = sb.toString();
    }
}
