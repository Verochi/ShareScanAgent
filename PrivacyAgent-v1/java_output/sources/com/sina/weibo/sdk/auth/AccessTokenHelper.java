package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public class AccessTokenHelper {
    private static final java.lang.String PREFERENCES_NAME = "com_weibo_sdk_android";

    /* renamed from: com.sina.weibo.sdk.auth.AccessTokenHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.sina.weibo.sdk.net.c<java.lang.String> {
        final /* synthetic */ android.content.Context f;

        public AnonymousClass1(android.content.Context context) {
            this.f = context;
        }

        @Override // com.sina.weibo.sdk.net.c
        public final /* synthetic */ void a(java.lang.String str) {
            com.sina.weibo.sdk.auth.AccessTokenHelper.writeAccessToken(this.f, com.sina.weibo.sdk.auth.Oauth2AccessToken.parseAccessToken(str));
        }

        @Override // com.sina.weibo.sdk.net.c
        public final void onError(java.lang.Throwable th) {
        }
    }

    public static void clearAccessToken(android.content.Context context) {
        if (context == null) {
            return;
        }
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        edit.clear();
        edit.apply();
    }

    public static com.sina.weibo.sdk.auth.Oauth2AccessToken readAccessToken(android.content.Context context) {
        if (context == null) {
            return null;
        }
        com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken = new com.sina.weibo.sdk.auth.Oauth2AccessToken();
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
        oauth2AccessToken.setScreenName(sharedPreferences.getString("userName", ""));
        oauth2AccessToken.setAccessToken(sharedPreferences.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, ""));
        oauth2AccessToken.setRefreshToken(sharedPreferences.getString("refresh_token", ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN, 0L));
        return oauth2AccessToken;
    }

    public static void refreshAccessToken(android.content.Context context, java.lang.String str) {
        com.sina.weibo.sdk.b.b bVar;
        com.sina.weibo.sdk.auth.Oauth2AccessToken readAccessToken = readAccessToken(context);
        if (readAccessToken != null) {
            com.sina.weibo.sdk.b.f fVar = new com.sina.weibo.sdk.b.f(str, readAccessToken, new com.sina.weibo.sdk.auth.AccessTokenHelper.AnonymousClass1(context));
            bVar = com.sina.weibo.sdk.b.b.a.P;
            bVar.a(fVar);
        }
    }

    public static void writeAccessToken(android.content.Context context, com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken) {
        if (context == null || oauth2AccessToken == null || android.text.TextUtils.isEmpty(oauth2AccessToken.getAccessToken())) {
            return;
        }
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 0).edit();
        edit.putString("uid", oauth2AccessToken.getUid());
        edit.putString("userName", oauth2AccessToken.getScreenName());
        edit.putString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, oauth2AccessToken.getAccessToken());
        edit.putString("refresh_token", oauth2AccessToken.getRefreshToken());
        edit.putLong(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN, oauth2AccessToken.getExpiresTime());
        edit.apply();
    }
}
