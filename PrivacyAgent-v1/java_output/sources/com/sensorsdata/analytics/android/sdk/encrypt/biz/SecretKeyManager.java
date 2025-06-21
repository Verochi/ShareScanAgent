package com.sensorsdata.analytics.android.sdk.encrypt.biz;

/* loaded from: classes19.dex */
public class SecretKeyManager {
    private static com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager INSTANCE = null;
    private static final int KEY_VERSION_DEFAULT = 0;
    private static final java.lang.String SP_SECRET_KEY = "secret_key";
    private static final java.lang.String SP_SUPPORT_TRANSPORT_ENCRYPT = "supportTransportEncrypt";
    private static final java.lang.String TAG = "SA.SecretKeyManager";
    private final java.util.List<com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener> mListeners;
    private final com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey mPersistentSecretKey;
    private final com.sensorsdata.analytics.android.sdk.SAConfigOptions mSAConfigOptions;

    private SecretKeyManager(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        this.mPersistentSecretKey = sAContextManager.getInternalConfigs().saConfigOptions.getPersistentSecretKey();
        java.util.List<com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener> encryptors = sAContextManager.getInternalConfigs().saConfigOptions.getEncryptors();
        this.mListeners = encryptors;
        encryptors.add(new com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SARSAEncrypt());
        if (com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils.isECEncrypt()) {
            encryptors.add(new com.sensorsdata.analytics.android.sdk.encrypt.encryptor.SAECEncrypt());
        }
    }

    private java.lang.String disposeECPublicKey(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.startsWith("EC:")) ? str : str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1);
    }

    public static com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager getInstance(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (INSTANCE == null) {
            INSTANCE = new com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager(sAContextManager);
        }
        return INSTANCE;
    }

    private boolean isEncryptorTypeNull(com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener sAEncryptListener) {
        return android.text.TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) || android.text.TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType());
    }

    private boolean isMatchEncryptType(com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener sAEncryptListener, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        return (sAEncryptListener == null || isSecretKeyNull(secreteKey) || isEncryptorTypeNull(sAEncryptListener) || !sAEncryptListener.asymmetricEncryptType().equals(secreteKey.asymmetricEncryptType) || !sAEncryptListener.symmetricEncryptType().equals(secreteKey.symmetricEncryptType)) ? false : true;
    }

    private void parseSecreteKey(org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("key_ec") && com.sensorsdata.analytics.android.sdk.encrypt.utils.EncryptUtils.isECEncrypt()) {
                    java.lang.String optString = jSONObject.optString("key_ec");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        jSONObject = new org.json.JSONObject(optString);
                    }
                }
                secreteKey.key = jSONObject.optString(com.alipay.sdk.m.p.e.o);
                secreteKey.symmetricEncryptType = "AES";
                if (jSONObject.has("type")) {
                    java.lang.String optString2 = jSONObject.optString("type");
                    secreteKey.key = optString2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + secreteKey.key;
                    secreteKey.asymmetricEncryptType = optString2;
                } else {
                    secreteKey.asymmetricEncryptType = com.alipay.sdk.m.n.d.a;
                }
                secreteKey.version = jSONObject.optInt("pkv");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    private com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey readAppKey() {
        java.lang.String str;
        int i;
        java.lang.String str2;
        java.lang.String str3;
        com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey = this.mPersistentSecretKey.loadSecretKey();
        if (loadSecretKey != null) {
            str = loadSecretKey.key;
            i = loadSecretKey.version;
            str3 = loadSecretKey.symmetricEncryptType;
            str2 = loadSecretKey.asymmetricEncryptType;
        } else {
            str = "";
            i = 0;
            str2 = "";
            str3 = str2;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "readAppKey [key = " + str + " ,v = " + i + " ,symmetricEncryptType = " + str3 + " ,asymmetricEncryptType = " + str2 + "]");
        return new com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey(str, i, str3, str2);
    }

    private com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey readLocalKey() throws org.json.JSONException {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3 = "";
        java.lang.String string = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString(SP_SECRET_KEY, "");
        int i = 0;
        if (android.text.TextUtils.isEmpty(string)) {
            str = "";
            str2 = str;
        } else {
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            java.lang.String optString = jSONObject.optString("key", "");
            i = jSONObject.optInt("version", 0);
            str2 = jSONObject.optString("symmetricEncryptType", "");
            str3 = optString;
            str = jSONObject.optString("asymmetricEncryptType", "");
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "readLocalKey [key = " + str3 + " ,v = " + i + " ,symmetricEncryptType = " + str2 + " ,asymmetricEncryptType = " + str + "]");
        return new com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey(str3, i, str2, str);
    }

    private void storeSecretKey(com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "[saveSecretKey] publicKey = " + secreteKey.toString());
            if (getEncryptListener(secreteKey) != null) {
                com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey iPersistentSecretKey = this.mPersistentSecretKey;
                if (iPersistentSecretKey != null) {
                    iPersistentSecretKey.saveSecretKey(secreteKey);
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(SP_SECRET_KEY, "");
                } else {
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(SP_SECRET_KEY, secreteKey.toString());
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public java.lang.String checkPublicSecretKey(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        try {
            com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey = loadSecretKey();
            if (loadSecretKey != null && !android.text.TextUtils.isEmpty(loadSecretKey.key)) {
                if (!str.equals(loadSecretKey.version + "") || !disposeECPublicKey(str2).equals(disposeECPublicKey(loadSecretKey.key))) {
                    return java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_verify_fail_version), str, java.lang.Integer.valueOf(loadSecretKey.version));
                }
                if (str3 != null && str4 != null && (!str3.equals(loadSecretKey.symmetricEncryptType) || !str4.equals(loadSecretKey.asymmetricEncryptType))) {
                    return java.lang.String.format(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_verify_fail_type), str3, str4, loadSecretKey.symmetricEncryptType, loadSecretKey.asymmetricEncryptType);
                }
                return com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_pass);
            }
            return com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(context, com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_key_null);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener getEncryptListener(com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        if (isSecretKeyNull(secreteKey)) {
            return null;
        }
        for (com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener sAEncryptListener : this.mListeners) {
            if (isMatchEncryptType(sAEncryptListener, secreteKey)) {
                return sAEncryptListener;
            }
        }
        return null;
    }

    public boolean isSecretKeyNull(com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        return secreteKey == null || android.text.TextUtils.isEmpty(secreteKey.key) || secreteKey.version == 0;
    }

    public java.lang.Boolean isSupportTransportEncrypt() {
        if (com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists("supportTransportEncrypt")) {
            return java.lang.Boolean.valueOf(com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getBool("supportTransportEncrypt", false));
        }
        return null;
    }

    public com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey() throws org.json.JSONException {
        return this.mPersistentSecretKey != null ? readAppKey() : readLocalKey();
    }

    public void storeSecretKey(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (this.mSAConfigOptions.isEnableEncrypt() || this.mSAConfigOptions.isTransportEncrypt()) {
                jSONObject = new org.json.JSONObject(jSONObject.optString("configs"));
                com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey = new com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey("", -1, "", "");
                java.util.List<com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener> encryptors = this.mSAConfigOptions.getEncryptors();
                if (encryptors != null && !encryptors.isEmpty()) {
                    org.json.JSONObject optJSONObject = jSONObject.optJSONObject("key_v2");
                    if (optJSONObject != null) {
                        java.lang.String[] split = optJSONObject.optString("type").split("\\+");
                        if (split.length == 2) {
                            java.lang.String str2 = split[0];
                            java.lang.String str3 = split[1];
                            for (com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener sAEncryptListener : encryptors) {
                                if (str2.equals(sAEncryptListener.asymmetricEncryptType()) && str3.equals(sAEncryptListener.symmetricEncryptType())) {
                                    secreteKey.key = optJSONObject.optString(com.alipay.sdk.m.p.e.o);
                                    secreteKey.version = optJSONObject.optInt("pkv");
                                    secreteKey.asymmetricEncryptType = str2;
                                    secreteKey.symmetricEncryptType = str3;
                                }
                            }
                        }
                    }
                    if (android.text.TextUtils.isEmpty(secreteKey.key)) {
                        parseSecreteKey(jSONObject.optJSONObject("key"), secreteKey);
                    }
                }
                storeSecretKey(secreteKey);
            }
            if (jSONObject.has("supportTransportEncrypt")) {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setBool("supportTransportEncrypt", jSONObject.optBoolean("supportTransportEncrypt"));
            } else {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setBool("supportTransportEncrypt", false);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
