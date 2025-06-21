package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class HonorIdUtils {
    public static boolean deleteAAID(android.content.Context context) {
        boolean removeKey;
        synchronized (com.hihonor.push.sdk.utils.HonorIdUtils.class) {
            com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = getHonorPushPreferences(context);
            removeKey = honorPushPreferences.containsKey("key_aaid") ? honorPushPreferences.removeKey("key_aaid") : false;
            if (removeKey) {
                setPushToken(context, null);
            }
        }
        return removeKey;
    }

    public static java.lang.String getAAID(android.content.Context context) {
        java.lang.String str;
        synchronized (com.hihonor.push.sdk.utils.HonorIdUtils.class) {
            com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = getHonorPushPreferences(context);
            if (honorPushPreferences.containsKey("key_aaid")) {
                str = honorPushPreferences.getString("key_aaid");
            } else {
                java.lang.String randomUUID = com.hihonor.push.sdk.utils.ConfigUtils.getRandomUUID();
                honorPushPreferences.saveString("key_aaid", randomUUID);
                str = randomUUID;
            }
        }
        return str;
    }

    public static com.hihonor.push.sdk.utils.PushPreferences getHonorPushPreferences(android.content.Context context) {
        return new com.hihonor.push.sdk.utils.PushPreferences(context, "push");
    }

    public static java.lang.String getPushToken(android.content.Context context) {
        java.lang.String str = "";
        synchronized (com.hihonor.push.sdk.utils.HonorIdUtils.class) {
            com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = getHonorPushPreferences(context);
            if (honorPushPreferences.containsKey("key_push_token")) {
                if (honorPushPreferences.containsKey("key_aes_gcm")) {
                    java.lang.String decrypt = com.hihonor.push.sdk.common.encrypt.AesGcmUtil.decrypt(honorPushPreferences.getString("key_push_token"), honorPushPreferences.getString("key_aes_gcm"));
                    if (android.text.TextUtils.isEmpty(decrypt)) {
                        honorPushPreferences.removeKey("key_aes_gcm");
                        honorPushPreferences.removeKey("key_push_token");
                    } else {
                        str = decrypt;
                    }
                } else {
                    honorPushPreferences.removeKey("key_push_token");
                }
            }
        }
        return str;
    }

    public static void setPushToken(android.content.Context context, java.lang.String str) {
        synchronized (com.hihonor.push.sdk.utils.HonorIdUtils.class) {
            com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = getHonorPushPreferences(context);
            if (android.text.TextUtils.isEmpty(str)) {
                honorPushPreferences.removeKey("key_push_token");
            } else {
                java.lang.String aesGcmRandomKey = com.hihonor.push.sdk.common.encrypt.AesGcmUtil.getAesGcmRandomKey("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22", com.hihonor.push.sdk.utils.ConfigUtils.getCertFingerprint(context));
                boolean saveString = honorPushPreferences.saveString("key_aes_gcm", aesGcmRandomKey);
                java.lang.String encrypt = com.hihonor.push.sdk.common.encrypt.AesGcmUtil.encrypt(str, aesGcmRandomKey);
                if (saveString && !android.text.TextUtils.isEmpty(encrypt)) {
                    honorPushPreferences.saveString("key_push_token", encrypt);
                }
            }
        }
    }
}
