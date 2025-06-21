package com.tencent.open.web.security;

/* loaded from: classes19.dex */
public class SecureJsInterface extends com.tencent.open.a.b {
    public static boolean isPWDEdit;
    private java.lang.String a;

    public void clearAllEdit() {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            com.tencent.open.web.security.JniInterface.clearAllPWD();
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new java.lang.RuntimeException(e);
        }
    }

    public void curPosFromJS(java.lang.String str) {
        int i;
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i = java.lang.Integer.parseInt(str);
        } catch (java.lang.NumberFormatException e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            i = -1;
        }
        if (i < 0) {
            throw new java.lang.RuntimeException("position is illegal.");
        }
        boolean z = com.tencent.open.web.security.a.b;
        if (z) {
            if (java.lang.Boolean.valueOf(com.tencent.open.web.security.JniInterface.BackSpaceChar(z, i)).booleanValue()) {
                com.tencent.open.web.security.a.b = false;
                return;
            }
            return;
        }
        java.lang.String str2 = com.tencent.open.web.security.a.a;
        this.a = str2;
        com.tencent.open.web.security.JniInterface.insetTextToArray(i, str2, str2.length());
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.a);
    }

    @Override // com.tencent.open.a.b
    public boolean customCallback() {
        return true;
    }

    public java.lang.String getMD5FromNative() {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            java.lang.String pWDKeyToMD5 = com.tencent.open.web.security.JniInterface.getPWDKeyToMD5(null);
            com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new java.lang.RuntimeException(e);
        }
    }

    public void isPasswordEdit(java.lang.String str) {
        int i;
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i = java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
            i = -1;
        }
        if (i != 0 && i != 1) {
            throw new java.lang.RuntimeException("is pswd edit flag is illegal.");
        }
        if (i == 0) {
            isPWDEdit = false;
        } else if (i == 1) {
            isPWDEdit = true;
        }
    }
}
