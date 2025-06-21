package com.sensorsdata.analytics.android.sdk.encrypt.impl;

/* loaded from: classes19.dex */
public class SAEncryptAPIImpl implements com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI {
    private static final java.lang.String TAG = "SA.EncryptAPIImpl";
    private com.sensorsdata.analytics.android.sdk.core.SAContextManager mSAContextManager;
    private com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager mSecretKeyManager;
    private com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools mSensorsDataEncrypt;

    public SAEncryptAPIImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        try {
            this.mSAContextManager = sAContextManager;
            com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
            if (!sAConfigOptions.isEnableEncrypt() && !sAConfigOptions.isTransportEncrypt()) {
                if (sAConfigOptions.getAdvertConfig() != null && sAConfigOptions.getAdvertConfig().secreteKey != null) {
                    this.mSensorsDataEncrypt = new com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools(sAContextManager);
                }
                if (sAConfigOptions.getStorePlugins() != null || sAConfigOptions.getStorePlugins().isEmpty()) {
                }
                com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().initSecretKey(sAContextManager.getContext());
                return;
            }
            this.mSensorsDataEncrypt = new com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools(sAContextManager);
            this.mSecretKeyManager = com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager.getInstance(sAContextManager);
            com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().initSecretKey(sAContextManager.getContext());
            if (sAConfigOptions.getStorePlugins() != null) {
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public java.lang.String decryptAES(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().decryptAES(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public java.lang.String encryptAES(java.lang.String str) {
        return com.sensorsdata.analytics.android.sdk.encrypt.AESSecretManager.getInstance().encryptAES(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public <T> T encryptEventData(T t) {
        return (T) this.mSensorsDataEncrypt.encryptTrackData(t);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public <T> T encryptEventData(T t, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        com.sensorsdata.analytics.android.sdk.encrypt.biz.SAEventEncryptTools sAEventEncryptTools = this.mSensorsDataEncrypt;
        return sAEventEncryptTools == null ? t : (T) sAEventEncryptTools.encryptTrackData(t, secreteKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T invokeModuleFunction(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_AES.equals(str)) {
                return (T) encryptAES((java.lang.String) objArr[0]);
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_DECRYPT_AES.equals(str)) {
                return (T) decryptAES((java.lang.String) objArr[0]);
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_VERIFY_SECRET_KEY.equals(str)) {
                return (T) verifySecretKey((android.net.Uri) objArr[0]);
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA.equals(str)) {
                return (T) encryptEventData(objArr[0]);
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA_WITH_KEY.equals(str)) {
                return (T) encryptEventData(objArr[0], (com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey) objArr[1]);
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_STORE_SECRET_KEY.equals(str)) {
                storeSecretKey((java.lang.String) objArr[0]);
                return null;
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_LOAD_SECRET_KEY.equals(str)) {
                return (T) loadSecretKey();
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_VERIFY_SUPPORT_TRANSPORT.equals(str)) {
                return (T) this.mSecretKeyManager.isSupportTransportEncrypt();
            }
            if (com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_STORE_EVENT.equals(str)) {
                com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener encryptListener = this.mSensorsDataEncrypt.getEncryptListener();
                if (encryptListener instanceof com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt) {
                    return (T) ((com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt) encryptListener).encryptEventRecord((java.lang.String) objArr[0]);
                }
                return null;
            }
            if (!com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_LOAD_EVENT.equals(str)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener encryptListener2 = this.mSensorsDataEncrypt.getEncryptListener();
            if (encryptListener2 instanceof com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt) {
                return (T) ((com.sensorsdata.analytics.android.sdk.encrypt.impl.AbsSAEncrypt) encryptListener2).decryptEventRecord((java.lang.String) objArr[0]);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public java.lang.String loadSecretKey() {
        try {
            com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
            return this.mSecretKeyManager.getEncryptListener(loadSecretKey) == null ? "" : loadSecretKey.toString();
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public void storeSecretKey(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager.getInstance(this.mSAContextManager).storeSecretKey(str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptAPI
    public java.lang.String verifySecretKey(android.net.Uri uri) {
        java.lang.String queryParameter = uri.getQueryParameter("v");
        java.lang.String decode = android.net.Uri.decode(uri.getQueryParameter("key"));
        java.lang.String decode2 = android.net.Uri.decode(uri.getQueryParameter("symmetricEncryptType"));
        java.lang.String decode3 = android.net.Uri.decode(uri.getQueryParameter("asymmetricEncryptType"));
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Encrypt, version = " + queryParameter + ", key = " + decode + ", symmetricEncryptType = " + decode2 + ", asymmetricEncryptType = " + decode3);
        if (android.text.TextUtils.isEmpty(queryParameter) || android.text.TextUtils.isEmpty(decode)) {
            return com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mSAContextManager.getContext(), com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_fail);
        }
        com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager secretKeyManager = this.mSecretKeyManager;
        return secretKeyManager != null ? secretKeyManager.checkPublicSecretKey(this.mSAContextManager.getContext(), queryParameter, decode, decode2, decode3) : com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(this.mSAContextManager.getContext(), com.sensorsdata.analytics.android.sdk.encrypt.R.string.sensors_analytics_encrypt_disable);
    }
}
