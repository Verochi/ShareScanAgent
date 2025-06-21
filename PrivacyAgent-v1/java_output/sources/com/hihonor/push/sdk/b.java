package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class b {
    public static void a(android.content.Context context) {
        try {
            com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = com.hihonor.push.sdk.utils.HonorIdUtils.getHonorPushPreferences(context);
            if (honorPushPreferences.containsKey("key_auto_init") ? honorPushPreferences.getBoolean("key_auto_init") : com.hihonor.push.sdk.utils.ConfigUtils.getPushAutoInitEnabled(context)) {
                com.hihonor.push.sdk.common.logger.Logger.i("AutoInitHelper", "Push init start");
                new java.lang.Thread(new com.hihonor.push.sdk.c(context)).start();
            }
        } catch (java.lang.Exception unused) {
            com.hihonor.push.sdk.common.logger.Logger.e("AutoInitHelper", "Push init failed");
        }
    }
}
