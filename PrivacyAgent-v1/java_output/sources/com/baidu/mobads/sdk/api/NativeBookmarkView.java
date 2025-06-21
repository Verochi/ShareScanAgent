package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class NativeBookmarkView {
    private android.view.View bookmarkView;
    private final com.baidu.mobads.sdk.api.NativeResponse nativeResponse;
    private final org.json.JSONObject params = new org.json.JSONObject();

    public NativeBookmarkView(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, int i, int i2) {
        this.nativeResponse = nativeResponse;
        putValue("type", "template");
        putValue(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, java.lang.Integer.valueOf(i));
        putValue("h", java.lang.Integer.valueOf(i2));
    }

    private void putValue(java.lang.String str, java.lang.Object obj) {
        try {
            this.params.put(str, obj);
        } catch (org.json.JSONException e) {
            com.baidu.mobads.sdk.internal.ay.b(e);
        }
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView bottomCardColor(java.lang.String str) {
        putValue("bottom_card_color", str);
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView closeListener(com.baidu.mobads.sdk.api.NativeResponse.AdCloseListener adCloseListener) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).setAdCloseListener(adCloseListener);
        }
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView dislikeListener(com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener adDislikeListener) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).setAdDislikeListener(adDislikeListener);
        }
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeResponse getNativeResponse() {
        return this.nativeResponse;
    }

    public android.view.View getView() {
        return this.bookmarkView;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView hideAdLogo(boolean z) {
        putValue("hide_ad_logo", java.lang.Boolean.valueOf(z));
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView hideDislike(boolean z) {
        putValue("hide_dislike", java.lang.Boolean.valueOf(z));
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView hideMuteButton(boolean z) {
        putValue("hide_mute", java.lang.Boolean.valueOf(z));
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView mute(boolean z) {
        putValue("mute", java.lang.Boolean.valueOf(z));
        return this;
    }

    public com.baidu.mobads.sdk.api.NativeBookmarkView regionClick(boolean z) {
        putValue("region_click", java.lang.Boolean.valueOf(z));
        return this;
    }

    public android.view.View render() {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.nativeResponse;
        if (!(nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse)) {
            return null;
        }
        android.view.View renderNativeView = ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).renderNativeView("bookmark", this.params);
        this.bookmarkView = renderNativeView;
        return renderNativeView;
    }
}
