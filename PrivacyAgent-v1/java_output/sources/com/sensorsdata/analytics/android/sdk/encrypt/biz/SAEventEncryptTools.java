package com.sensorsdata.analytics.android.sdk.encrypt.biz;

/* loaded from: classes19.dex */
public class SAEventEncryptTools {
    private final com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager mSecretKeyManager;
    private com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey mSecreteKey;

    public SAEventEncryptTools(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mSecretKeyManager = com.sensorsdata.analytics.android.sdk.encrypt.biz.SecretKeyManager.getInstance(sAContextManager);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0037: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0037 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] gzipEventData(java.lang.String str) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        java.io.OutputStream outputStream;
        java.io.OutputStream outputStream2 = null;
        try {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes());
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPOutputStream.close();
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                    return byteArray;
                } catch (java.lang.Exception e2) {
                    e = e2;
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (java.lang.Exception e3) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (java.lang.Exception e4) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e4);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            gZIPOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (outputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [T, org.json.JSONObject] */
    public <T> T encryptTrackData(T t) {
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(this.mSecreteKey)) {
                com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
                this.mSecreteKey = loadSecretKey;
                if (this.mSecretKeyManager.isSecretKeyNull(loadSecretKey)) {
                    return t;
                }
            }
            com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener encryptListener = this.mSecretKeyManager.getEncryptListener(this.mSecreteKey);
            if (encryptListener == null) {
                return t;
            }
            java.lang.String str = this.mSecreteKey.key;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1);
            }
            java.lang.String encryptSymmetricKeyWithPublicKey = encryptListener.encryptSymmetricKeyWithPublicKey(str);
            if (android.text.TextUtils.isEmpty(encryptSymmetricKeyWithPublicKey)) {
                return t;
            }
            java.lang.String encryptEvent = encryptListener.encryptEvent(gzipEventData(t.toString()));
            if (android.text.TextUtils.isEmpty(encryptEvent)) {
                return t;
            }
            ?? r2 = (T) new org.json.JSONObject();
            r2.put("ekey", encryptSymmetricKeyWithPublicKey);
            r2.put("pkv", this.mSecreteKey.version);
            r2.put("payloads", encryptEvent);
            return t instanceof java.lang.String ? (T) r2.toString() : r2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return t;
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [T, org.json.JSONObject] */
    public <T> T encryptTrackData(T t, com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey secreteKey) {
        com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener encryptListener;
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(secreteKey) || (encryptListener = this.mSecretKeyManager.getEncryptListener(secreteKey)) == null) {
                return t;
            }
            java.lang.String str = secreteKey.key;
            if (str.startsWith("EC:")) {
                str = str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1);
            }
            java.lang.String encryptSymmetricKeyWithPublicKey = encryptListener.encryptSymmetricKeyWithPublicKey(str);
            if (android.text.TextUtils.isEmpty(encryptSymmetricKeyWithPublicKey)) {
                return t;
            }
            java.lang.String encryptEvent = encryptListener.encryptEvent(gzipEventData(t.toString()));
            if (android.text.TextUtils.isEmpty(encryptEvent)) {
                return t;
            }
            ?? r2 = (T) new org.json.JSONObject();
            r2.put("ekey", encryptSymmetricKeyWithPublicKey);
            r2.put("pkv", secreteKey.version);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(encryptEvent);
            r2.put("payloads", jSONArray);
            return t instanceof java.lang.String ? (T) r2.toString() : r2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return t;
        }
    }

    public com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener getEncryptListener() {
        try {
            if (this.mSecretKeyManager.isSecretKeyNull(this.mSecreteKey)) {
                com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey loadSecretKey = this.mSecretKeyManager.loadSecretKey();
                this.mSecreteKey = loadSecretKey;
                if (this.mSecretKeyManager.isSecretKeyNull(loadSecretKey)) {
                    return null;
                }
            }
            return this.mSecretKeyManager.getEncryptListener(this.mSecreteKey);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
