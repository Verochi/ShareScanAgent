package com.sensorsdata.analytics.android.sdk.encrypt;

/* loaded from: classes19.dex */
public class AESSecretManager {
    private static final java.lang.String ALGORITHM = "AES";
    private static final java.lang.String CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final java.lang.String CHARSET_NAME = "UTF-8";
    private static final java.lang.String SECRET_KEY_FILE = "com.sensorsdata.analytics.android.sdk.other";
    private static final java.lang.String TAG = "SA.AESSecretManager";
    private static final byte[] ZERO_IV = new byte[16];
    private java.lang.String mAESSecret;

    public static class SingletonHolder {
        private static final com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager INSTANCE = new com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager(null);

        private SingletonHolder() {
        }
    }

    private AESSecretManager() {
    }

    public /* synthetic */ AESSecretManager(com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private java.lang.String generateAESKey() {
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(128);
            return new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(keyGenerator.generateKey().getEncoded()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "generateAESKey fail, msg: " + e);
            return "";
        }
    }

    public static com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager getInstance() {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.SingletonHolder.INSTANCE;
    }

    private javax.crypto.SecretKey strKey2SecretKey(java.lang.String str) {
        return new javax.crypto.spec.SecretKeySpec(com.sensorsdata.analytics.android.sdk.util.Base64Coder.decode(str), ALGORITHM);
    }

    public java.lang.String decryptAES(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            if (android.text.TextUtils.isEmpty(this.mAESSecret)) {
                return str;
            }
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CBC_PKCS5_PADDING);
            cipher.init(2, strKey2SecretKey(this.mAESSecret), new javax.crypto.spec.IvParameterSpec(ZERO_IV));
            return new java.lang.String(cipher.doFinal(com.sensorsdata.analytics.android.sdk.util.Base64Coder.decode(str)), "UTF-8");
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "decryptAES fail, msg: " + e);
            return "";
        }
    }

    public java.lang.String encryptAES(java.lang.String str) {
        if (str == null) {
            return str;
        }
        try {
            if (android.text.TextUtils.isEmpty(this.mAESSecret)) {
                return str;
            }
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(CBC_PKCS5_PADDING);
            cipher.init(1, strKey2SecretKey(this.mAESSecret), new javax.crypto.spec.IvParameterSpec(ZERO_IV));
            return new java.lang.String(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(cipher.doFinal(str.getBytes("UTF-8"))));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "encryptAES fail, msg: " + e);
            return "";
        }
    }

    public void initSecretKey(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(SECRET_KEY_FILE, 0);
        java.lang.String string = sharedPreferences.getString(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encodeString(com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.SECRET_KEY), "");
        this.mAESSecret = string;
        if (android.text.TextUtils.isEmpty(string)) {
            this.mAESSecret = generateAESKey();
            sharedPreferences.edit().putString(com.sensorsdata.analytics.android.sdk.util.Base64Coder.encodeString(com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.SECRET_KEY), this.mAESSecret).apply();
        }
    }
}
