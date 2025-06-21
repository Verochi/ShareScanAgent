package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class SplashFocusParams {
    private final com.baidu.mobads.sdk.api.SplashFocusParams.Builder mBuilder;

    public static class Builder {
        private int iconRightMarginDp = 15;
        private int iconBottomMarginDp = 95;
        private int iconSizeDp = 44;
        private boolean autoAnimOffset = true;
        private int animOffsetPx = 0;
        private double darkAlpha = 0.0d;

        public com.baidu.mobads.sdk.api.SplashFocusParams build() {
            return new com.baidu.mobads.sdk.api.SplashFocusParams(this);
        }

        @java.lang.Deprecated
        public com.baidu.mobads.sdk.api.SplashFocusParams.Builder setAnimOffsetPx(int i) {
            this.autoAnimOffset = false;
            this.animOffsetPx = i;
            return this;
        }

        public com.baidu.mobads.sdk.api.SplashFocusParams.Builder setDarkAlpha(double d) {
            this.darkAlpha = d;
            return this;
        }

        public com.baidu.mobads.sdk.api.SplashFocusParams.Builder setIconBottomMarginDp(int i) {
            this.iconBottomMarginDp = i;
            return this;
        }

        public com.baidu.mobads.sdk.api.SplashFocusParams.Builder setIconRightMarginDp(int i) {
            this.iconRightMarginDp = i;
            return this;
        }

        public com.baidu.mobads.sdk.api.SplashFocusParams.Builder setIconSizeDp(int i) {
            this.iconSizeDp = i;
            return this;
        }
    }

    public SplashFocusParams(com.baidu.mobads.sdk.api.SplashFocusParams.Builder builder) {
        this.mBuilder = builder;
    }

    public org.json.JSONObject getFocusParams() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("right_margin", this.mBuilder.iconRightMarginDp);
            jSONObject.put("bottom_margin", this.mBuilder.iconBottomMarginDp);
            jSONObject.put("icon_size", this.mBuilder.iconSizeDp);
            if (!this.mBuilder.autoAnimOffset) {
                jSONObject.put("anim_offset_y", this.mBuilder.animOffsetPx);
            }
            jSONObject.put("icon_dark_alpha", this.mBuilder.darkAlpha);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
        }
        return jSONObject;
    }
}
