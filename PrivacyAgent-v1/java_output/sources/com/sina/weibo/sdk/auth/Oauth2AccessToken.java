package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public class Oauth2AccessToken {
    protected static final java.lang.String KEY_ACCESS_TOKEN = "access_token";
    protected static final java.lang.String KEY_EXPIRES_IN = "expires_in";
    protected static final java.lang.String KEY_REFRESH_TOKEN = "refresh_token";
    protected static final java.lang.String KEY_SCREEN_NAME = "userName";
    protected static final java.lang.String KEY_UID = "uid";
    private java.lang.String mAccessToken;
    private long mExpiresTime;
    private java.lang.String mRefreshToken;
    private java.lang.String mScreenName;
    private java.lang.String mUid;

    public static com.sina.weibo.sdk.auth.Oauth2AccessToken parseAccessToken(android.os.Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken = new com.sina.weibo.sdk.auth.Oauth2AccessToken();
        oauth2AccessToken.setUid(bundle.getString(KEY_UID));
        oauth2AccessToken.setScreenName(bundle.getString(KEY_SCREEN_NAME));
        oauth2AccessToken.setAccessToken(bundle.getString("access_token"));
        oauth2AccessToken.setRefreshToken(bundle.getString(KEY_REFRESH_TOKEN));
        oauth2AccessToken.setExpiresTime(java.lang.Long.parseLong(bundle.getString("expires_in")) * 1000);
        return oauth2AccessToken;
    }

    public static com.sina.weibo.sdk.auth.Oauth2AccessToken parseAccessToken(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken = new com.sina.weibo.sdk.auth.Oauth2AccessToken();
            oauth2AccessToken.setUid(jSONObject.optString(KEY_UID));
            oauth2AccessToken.setScreenName(jSONObject.optString(KEY_SCREEN_NAME));
            oauth2AccessToken.setAccessToken(jSONObject.optString("access_token"));
            oauth2AccessToken.setExpiresTime(java.lang.Long.parseLong(jSONObject.getString("expires_in")) * 1000);
            oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
            return oauth2AccessToken;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public java.lang.String getAccessToken() {
        return this.mAccessToken;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public java.lang.String getRefreshToken() {
        return this.mRefreshToken;
    }

    public java.lang.String getScreenName() {
        return this.mScreenName;
    }

    public java.lang.String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !android.text.TextUtils.isEmpty(this.mAccessToken) && this.mExpiresTime > 0;
    }

    public void setAccessToken(java.lang.String str) {
        this.mAccessToken = str;
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(java.lang.String str) {
        this.mRefreshToken = str;
    }

    public void setScreenName(java.lang.String str) {
        this.mScreenName = str;
    }

    public void setUid(java.lang.String str) {
        this.mUid = str;
    }
}
