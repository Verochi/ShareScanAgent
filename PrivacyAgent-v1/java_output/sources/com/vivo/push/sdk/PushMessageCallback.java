package com.vivo.push.sdk;

/* loaded from: classes19.dex */
public interface PushMessageCallback {
    boolean isAllowNet(android.content.Context context);

    void onBind(android.content.Context context, int i, java.lang.String str);

    void onDelAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str);

    void onDelTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str);

    void onListTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.lang.String str);

    void onLog(android.content.Context context, java.lang.String str, int i, boolean z);

    boolean onNotificationMessageArrived(android.content.Context context, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage);

    void onNotificationMessageClicked(android.content.Context context, com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage);

    void onPublish(android.content.Context context, int i, java.lang.String str);

    void onReceiveRegId(android.content.Context context, java.lang.String str);

    void onSetAlias(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str);

    void onSetTags(android.content.Context context, int i, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.lang.String str);

    void onTransmissionMessage(android.content.Context context, com.vivo.push.model.UnvarnishedMessage unvarnishedMessage);

    void onUnBind(android.content.Context context, int i, java.lang.String str);
}
