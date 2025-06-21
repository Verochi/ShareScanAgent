package com.tencent.connect.auth;

/* loaded from: classes19.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static android.content.SharedPreferences g;
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private int d = 1;
    private long e = -1;
    private com.tencent.open.utils.a f;

    public QQToken(java.lang.String str) {
        this.a = str;
    }

    @android.annotation.TargetApi(11)
    private static synchronized android.content.SharedPreferences a() {
        android.content.SharedPreferences sharedPreferences;
        synchronized (com.tencent.connect.auth.QQToken.class) {
            if (g == null) {
                g = com.tencent.open.utils.f.a().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = g;
        }
        return sharedPreferences;
    }

    private static java.lang.String a(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2) + "_aes_google";
    }

    private static synchronized org.json.JSONObject a(java.lang.String str, com.tencent.open.utils.a aVar) {
        java.lang.String b;
        synchronized (com.tencent.connect.auth.QQToken.class) {
            if (com.tencent.open.utils.f.a() == null) {
                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            java.lang.String string = a().getString(a(str), "");
            if (android.text.TextUtils.isEmpty(string)) {
                if (!com.tencent.open.web.security.JniInterface.isJniOk) {
                    com.tencent.open.utils.i.a(com.tencent.connect.auth.AuthAgent.SECURE_LIB_FILE_NAME, com.tencent.connect.auth.AuthAgent.SECURE_LIB_NAME, 5);
                    com.tencent.open.web.security.JniInterface.loadSo();
                }
                if (!com.tencent.open.web.security.JniInterface.isJniOk) {
                    com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                java.lang.String c = c(str);
                java.lang.String string2 = a().getString(c, "");
                try {
                    if (android.text.TextUtils.isEmpty(string2)) {
                        java.lang.String b2 = b(str);
                        java.lang.String string3 = a().getString(b2, "");
                        try {
                            if (android.text.TextUtils.isEmpty(string3)) {
                                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            b = com.tencent.open.web.security.JniInterface.d1(string3);
                            if (android.text.TextUtils.isEmpty(b)) {
                                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                return null;
                            }
                            a(str, new org.json.JSONObject(b), aVar);
                        } catch (java.lang.Exception e) {
                            com.tencent.open.log.SLog.e("QQToken", "Catch Exception", e);
                            return null;
                        } finally {
                            a().edit().remove(b2).apply();
                        }
                    } else {
                        b = com.tencent.open.web.security.JniInterface.d2(string2);
                        a(str, new org.json.JSONObject(b), aVar);
                    }
                } catch (java.lang.Exception e2) {
                    com.tencent.open.log.SLog.e("QQToken", "Catch Exception", e2);
                    return null;
                } finally {
                    a().edit().remove(c).apply();
                }
            } else {
                b = aVar.b(string);
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(b);
                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (java.lang.Exception e3) {
                com.tencent.open.log.SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
                return null;
            }
        }
    }

    private static synchronized boolean a(java.lang.String str, org.json.JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (com.tencent.connect.auth.QQToken.class) {
            if (com.tencent.open.utils.f.a() == null) {
                com.tencent.open.log.SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str == null || jSONObject == null) {
                com.tencent.open.log.SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            }
            try {
                java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
                if (android.text.TextUtils.isEmpty(string)) {
                    com.tencent.open.log.SLog.i("QQToken", "expires is null");
                    return false;
                }
                jSONObject.put(com.tencent.connect.common.Constants.PARAM_EXPIRES_TIME, java.lang.System.currentTimeMillis() + (java.lang.Long.parseLong(string) * 1000));
                java.lang.String a = a(str);
                java.lang.String a2 = aVar.a(jSONObject.toString());
                if (a.length() > 6 && a2 != null) {
                    a().edit().putString(a, a2).commit();
                    com.tencent.open.log.SLog.i("QQToken", "saveJsonPreference sucess");
                    return true;
                }
                com.tencent.open.log.SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                return false;
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                return false;
            }
        }
    }

    @java.lang.Deprecated
    private static java.lang.String b(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2);
    }

    @java.lang.Deprecated
    private static java.lang.String c(java.lang.String str) {
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2) + "_spkey";
    }

    public java.lang.String getAccessToken() {
        return this.b;
    }

    public java.lang.String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public java.lang.String getOpenId() {
        return this.c;
    }

    public java.lang.String getOpenIdWithCache() {
        java.lang.String openId = getOpenId();
        try {
            if (android.text.TextUtils.isEmpty(openId)) {
                org.json.JSONObject loadSession = loadSession(this.a);
                if (loadSession != null) {
                    openId = loadSession.getString("openid");
                    if (!android.text.TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                com.tencent.open.log.SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                com.tencent.open.log.SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && java.lang.System.currentTimeMillis() < this.e;
    }

    public org.json.JSONObject loadSession(java.lang.String str) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(com.tencent.open.utils.f.a());
            }
            return a(str, this.f);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(java.lang.String str) {
        android.content.SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        com.tencent.open.log.SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(org.json.JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(com.tencent.open.utils.f.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(java.lang.String str, java.lang.String str2) throws java.lang.NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = java.lang.System.currentTimeMillis() + (java.lang.Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(java.lang.String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(java.lang.String str) {
        this.c = str;
    }
}
