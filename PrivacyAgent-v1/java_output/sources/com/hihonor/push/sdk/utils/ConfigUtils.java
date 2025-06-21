package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class ConfigUtils {
    private static final java.lang.String PUSH_AUTO_INIT = "com.hihonor.push.init_enabled";
    private static final java.lang.String PUSH_ID = "com.hihonor.push.app_id";
    private static final java.lang.String PUSH_KEY = "com.hihonor.push.api_key";
    private static final java.lang.String PUSH_VERSION = "com.hihonor.push.sdk_version";
    private static final java.lang.String TAG = "ConfigUtils";

    public static java.lang.String getCertFingerprint(android.content.Context context) {
        return getCertFingerprint(context, context.getPackageName());
    }

    public static java.lang.String getCertFingerprint(android.content.Context context, java.lang.String str) {
        java.util.List<java.lang.String> certFingerprint = getCertFingerprint(context, str, true);
        if (certFingerprint.isEmpty()) {
            return null;
        }
        return certFingerprint.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        r3 = r3.signingInfo;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0038 -> B:12:0x0039). Please report as a decompilation issue!!! */
    @android.annotation.SuppressLint({"PackageManagerGetSignatures"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<java.lang.String> getCertFingerprint(android.content.Context context, java.lang.String str, boolean z) {
        android.content.pm.Signature[] signatureArr;
        android.content.pm.SigningInfo signingInfo;
        boolean hasMultipleSigners;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo != null && signingInfo != null) {
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                signatureArr = hasMultipleSigners ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            }
            signatureArr = null;
        } else {
            android.content.pm.PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 != null) {
                signatureArr = packageInfo2.signatures;
            }
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            for (android.content.pm.Signature signature : signatureArr) {
                java.lang.String signatureToString = signatureToString(signature.toByteArray());
                if (signatureToString != null) {
                    arrayList.add(signatureToString);
                    if (z) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static java.lang.String getPushApiKey(android.content.Context context) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(PUSH_KEY);
            if (obj != null) {
                return java.lang.String.valueOf(obj);
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "getPushApiKey", e);
            return null;
        }
    }

    public static java.lang.String getPushAppId(android.content.Context context) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(PUSH_ID);
            if (obj != null) {
                return java.lang.String.valueOf(obj);
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "getPushAppId", e);
            return null;
        }
    }

    public static boolean getPushAutoInitEnabled(android.content.Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean(PUSH_AUTO_INIT);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "getPushAutoInitEnabled", e);
            return false;
        }
    }

    public static java.lang.String getPushSDKVersion(android.content.Context context) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(PUSH_VERSION);
            if (obj != null) {
                return java.lang.String.valueOf(obj);
            }
            return null;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.hihonor.push.sdk.common.logger.Logger.e(TAG, "getPushSDKVersion", e);
            return null;
        }
    }

    public static java.lang.String getRandomUUID() {
        java.lang.String replace = java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        com.hihonor.push.sdk.common.logger.Logger.d("getRandomUUID UUID =" + replace);
        return replace;
    }

    private static java.lang.String signatureToString(byte[] bArr) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance("SHA256").digest(bArr);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : digest) {
                java.lang.String upperCase = java.lang.Integer.toHexString(b & 255).toUpperCase(java.util.Locale.US);
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
