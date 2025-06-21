package com.vivo.push.sdk;

/* loaded from: classes19.dex */
public abstract class OpenClientPushMessageReceiver extends com.vivo.push.sdk.BasePushMessageReceiver {
    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final boolean isAllowNet(android.content.Context context) {
        return super.isAllowNet(context);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onBind(android.content.Context context, int i, java.lang.String str) {
        super.onBind(context, i, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onDelTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onListTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.lang.String str) {
        super.onListTags(context, i, list, str);
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onLog(android.content.Context context, java.lang.String str, int i, boolean z) {
        super.onLog(context, str, i, z);
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public final boolean onNotificationMessageArrived(android.content.Context context, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage) {
        return false;
    }

    @Override // com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(android.content.Context context, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onPublish(android.content.Context context, int i, java.lang.String str) {
        super.onPublish(context, i, str);
    }

    public void onReceiveRegId(android.content.Context context, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onSetTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onTransmissionMessage(android.content.Context context, com.vivo.push.model.UnvarnishedMessage unvarnishedMessage) {
    }

    @Override // com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onUnBind(android.content.Context context, int i, java.lang.String str) {
        super.onUnBind(context, i, str);
    }
}
