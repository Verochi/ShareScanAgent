package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class HonorChecker {
    public static void checkNotRunInMainThread() throws com.hihonor.push.sdk.common.data.ApiException {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            throw com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static java.lang.String checkPushAppId(android.content.Context context) throws com.hihonor.push.sdk.common.data.ApiException {
        java.lang.String pushAppId = com.hihonor.push.sdk.utils.ConfigUtils.getPushAppId(context);
        if (android.text.TextUtils.isEmpty(pushAppId)) {
            com.hihonor.push.sdk.common.logger.Logger.e("checkPushConfig Parameter is missing");
            throw com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_NO_APPID.toApiException();
        }
        com.hihonor.push.sdk.common.logger.Logger.d("checkPushAppId Parameter is ".concat(java.lang.String.valueOf(pushAppId)));
        return pushAppId;
    }

    public static java.lang.String checkPushCertFingerprint(android.content.Context context) throws com.hihonor.push.sdk.common.data.ApiException {
        java.lang.String certFingerprint = com.hihonor.push.sdk.utils.ConfigUtils.getCertFingerprint(context);
        if (android.text.TextUtils.isEmpty(certFingerprint)) {
            com.hihonor.push.sdk.common.logger.Logger.e("checkPushConfig Parameter is missing.");
            throw com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        com.hihonor.push.sdk.common.logger.Logger.d("checkPushCertFingerprint Parameter is ".concat(java.lang.String.valueOf(certFingerprint)));
        return certFingerprint;
    }

    public static java.lang.String checkPushToken(android.content.Context context) throws com.hihonor.push.sdk.common.data.ApiException {
        java.lang.String pushToken = com.hihonor.push.sdk.utils.HonorIdUtils.getPushToken(context);
        if (android.text.TextUtils.isEmpty(pushToken)) {
            com.hihonor.push.sdk.common.logger.Logger.e("checkPushToken Parameter is missing.");
            throw com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_NO_TOKEN.toApiException();
        }
        com.hihonor.push.sdk.common.logger.Logger.d("checkPushToken Parameter is ".concat(java.lang.String.valueOf(pushToken)));
        return pushToken;
    }
}
