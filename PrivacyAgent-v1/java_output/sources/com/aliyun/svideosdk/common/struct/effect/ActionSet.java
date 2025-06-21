package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionSet extends com.aliyun.svideosdk.common.struct.effect.ActionBase {

    @com.google.gson.annotations.SerializedName("ActionList")
    private java.util.List<com.aliyun.svideosdk.common.struct.effect.ActionBase> mActionList;

    @com.google.gson.annotations.SerializedName("Mode")
    private int mMode = com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode.Dependent.ordinal();

    public enum AnimationMode {
        Dependent,
        Independent
    }

    public ActionSet() {
        this.mTimelineIn = -1.0f;
        this.mTimelineOut = -1.0f;
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.action_set;
        this.mActionList = new java.util.ArrayList();
    }

    public void addAction(com.aliyun.svideosdk.common.struct.effect.ActionBase actionBase) {
        this.mActionList.add(actionBase);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(java.lang.String str) {
        throw new java.lang.RuntimeException("Not Support");
    }

    public void setMode(com.aliyun.svideosdk.common.struct.effect.ActionSet.AnimationMode animationMode) {
        this.mMode = animationMode.ordinal();
    }
}
