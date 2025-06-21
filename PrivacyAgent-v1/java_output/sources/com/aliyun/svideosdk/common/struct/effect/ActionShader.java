package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class ActionShader extends com.aliyun.svideosdk.common.struct.effect.ActionBase {

    @com.google.gson.annotations.SerializedName("FragmentShader")
    private java.lang.String mFragmentFunction;

    @com.google.gson.annotations.SerializedName("VertexShader")
    private java.lang.String mVertexFunction;

    public ActionShader() {
        this.mType = com.aliyun.svideosdk.common.struct.effect.ActionBase.Type.custom;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(java.lang.String str) {
        throw new java.lang.RuntimeException("Not Support");
    }

    public void setShader(java.lang.String str, java.lang.String str2) {
        this.mVertexFunction = str;
        this.mFragmentFunction = str2;
    }
}
