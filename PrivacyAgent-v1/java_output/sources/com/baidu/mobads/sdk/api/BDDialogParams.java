package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final com.baidu.mobads.sdk.api.BDDialogParams.Builder mBuilder;

    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public com.baidu.mobads.sdk.api.BDDialogParams build() {
            return new com.baidu.mobads.sdk.api.BDDialogParams(this, null);
        }

        public com.baidu.mobads.sdk.api.BDDialogParams.Builder setDlDialogAnimStyle(int i) {
            this.mDlDialogAnimStyle = i;
            return this;
        }

        public com.baidu.mobads.sdk.api.BDDialogParams.Builder setDlDialogType(int i) {
            this.mDlDialogType = i;
            return this;
        }
    }

    private BDDialogParams(com.baidu.mobads.sdk.api.BDDialogParams.Builder builder) {
        this.mBuilder = builder;
    }

    public /* synthetic */ BDDialogParams(com.baidu.mobads.sdk.api.BDDialogParams.Builder builder, com.baidu.mobads.sdk.api.BDDialogParams.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("type", this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        return jSONObject;
    }
}
