package com.bytedance.android.live.base.api.push;

/* loaded from: classes.dex */
public interface ILivePush {
    public static final java.lang.String TAG = "livePush";

    public static class ClickType {
        public static final java.lang.String CLOSE = "close";
        public static final java.lang.String LIVE = "live";
        private java.lang.String value;

        public ClickType() {
        }

        public ClickType(java.lang.String str) {
            this.value = str;
        }

        public final java.lang.String getValue() {
            return this.value;
        }
    }

    public static class PushType {
        public static final int CLOD_LAUNCH = 2;
        public static final int SELF_DRIVING = 1;
        public static final int VIDEO = 3;
        private int value;

        public PushType() {
        }

        public PushType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    void addPushInterceptor(com.bytedance.android.live.base.api.push.PushInterceptor pushInterceptor);

    void clickPush(com.bytedance.android.live.base.api.push.model.PushData pushData, android.content.Context context);

    void dismiss();

    void enterRoom(android.content.Context context, com.bytedance.android.live.base.api.push.model.PushData pushData);

    boolean isShowing();

    void removePushInterceptor(com.bytedance.android.live.base.api.push.PushInterceptor pushInterceptor);

    void reportPushClick(com.bytedance.android.live.base.api.push.model.PushData pushData, com.bytedance.android.live.base.api.push.ILivePush.ClickType clickType);

    void reportShow(com.bytedance.android.live.base.api.push.model.PushData pushData);

    void requestPush(com.bytedance.android.live.base.api.push.PushCallback pushCallback);

    void requestPushAndShow(boolean z, android.app.Activity activity, com.bytedance.android.live.base.api.push.ILivePush.PushType pushType, com.bytedance.android.live.base.api.push.PushCallback pushCallback, com.bytedance.android.live.base.api.push.model.PushUIConfig pushUIConfig);

    void requestPushAndShow(boolean z, android.app.Activity activity, com.bytedance.android.live.base.api.push.ILivePush.PushType pushType, com.bytedance.android.live.base.api.push.PushCallback pushCallback, com.bytedance.android.live.base.api.push.model.PushUIConfig pushUIConfig, android.os.Bundle bundle);
}
