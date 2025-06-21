package com.xiaomi.push;

/* loaded from: classes19.dex */
public enum dx {
    COMMAND_REGISTER(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_REGISTER),
    COMMAND_UNREGISTER(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_UNREGISTER),
    COMMAND_SET_ALIAS(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_SET_ALIAS),
    COMMAND_UNSET_ALIAS(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_UNSET_ALIAS),
    COMMAND_SET_ACCOUNT(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_SET_ACCOUNT),
    COMMAND_UNSET_ACCOUNT(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_UNSET_ACCOUNT),
    COMMAND_SUBSCRIBE_TOPIC(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_SUBSCRIBE_TOPIC),
    COMMAND_UNSUBSCRIBE_TOPIC(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC),
    COMMAND_SET_ACCEPT_TIME(com.xiaomi.mipush.sdk.MiPushClient.COMMAND_SET_ACCEPT_TIME),
    COMMAND_CHK_VDEVID("check-vdeviceid");

    public final java.lang.String k;

    dx(java.lang.String str) {
        this.k = str;
    }

    public static int a(java.lang.String str) {
        int i = -1;
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        for (com.xiaomi.push.dx dxVar : values()) {
            if (dxVar.k.equals(str)) {
                i = com.xiaomi.push.Cdo.a(dxVar);
            }
        }
        return i;
    }
}
