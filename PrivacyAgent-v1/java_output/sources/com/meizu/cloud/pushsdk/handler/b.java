package com.meizu.cloud.pushsdk.handler;

/* loaded from: classes23.dex */
public interface b {
    void a(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage);

    void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus);

    void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus);

    void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus);

    void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus);

    void a(android.content.Context context, com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus);

    void a(android.content.Context context, java.lang.String str);

    void a(android.content.Context context, java.lang.String str, java.lang.String str2);

    void a(android.content.Context context, boolean z);

    void a(com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder);

    void b(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage);

    void b(android.content.Context context, java.lang.String str);

    void c(android.content.Context context, com.meizu.cloud.pushsdk.handler.MzPushMessage mzPushMessage);

    void c(android.content.Context context, java.lang.String str);
}
