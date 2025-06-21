package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionWipe extends com.aliyun.svideosdk.common.struct.effect.ActionBase {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;
    public static final int WIPE_MODE_APPEAR = 0;
    public static final int WIPE_MODE_DISAPPEAR = 1;
    protected int mDirection;
    protected int mWipeMode;

    public ActionWipe() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.swipe;
    }

    public int getDirection() {
        return this.mDirection;
    }

    public int getWipeMode() {
        return this.mWipeMode;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(java.lang.String str) {
        throw new java.lang.RuntimeException("Not Support");
    }

    public void setDirection(int i) {
        this.mDirection = i;
    }

    public void setWipeMode(int i) {
        this.mWipeMode = i;
    }
}
