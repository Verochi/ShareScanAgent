package com.tencent.connect.auth;

/* loaded from: classes19.dex */
public class c {
    private com.tencent.connect.auth.AuthAgent a;
    private com.tencent.connect.auth.QQToken b;

    private c(java.lang.String str, android.content.Context context) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.b = new com.tencent.connect.auth.QQToken(str);
        this.a = new com.tencent.connect.auth.AuthAgent(this.b);
        com.tencent.connect.a.a.c(context, this.b);
        a(context, com.tencent.connect.common.Constants.SDK_VERSION);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    private int a(android.app.Activity activity, androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2) {
        return a(activity, fragment, str, iUiListener, str2, false);
    }

    private int a(android.app.Activity activity, androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2, boolean z) {
        return a(activity, fragment, str, iUiListener, str2, z, (java.util.Map<java.lang.String, java.lang.Object>) null);
    }

    private int a(android.app.Activity activity, androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2, boolean z, java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String a = com.tencent.open.utils.i.a(activity);
            if (a != null) {
                java.lang.String a2 = com.tencent.open.utils.b.a(new java.io.File(a));
                if (!android.text.TextUtils.isEmpty(a2)) {
                    com.tencent.open.log.SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + a2);
                    return a(activity, str, iUiListener, z, a2, a2, "");
                }
            }
        } catch (java.lang.Throwable th) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        com.tencent.connect.common.BaseApi.isOEM = false;
        return this.a.doLogin(activity, str, iUiListener, false, fragment, z, map);
    }

    public static com.tencent.connect.auth.c a(java.lang.String str, android.content.Context context) {
        com.tencent.open.utils.f.a(context.getApplicationContext());
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        com.tencent.connect.auth.c cVar = new com.tencent.connect.auth.c(str, context);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return cVar;
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("bcb3903995", str);
        edit.apply();
    }

    public int a(android.app.Activity activity, com.tencent.tauth.IUiListener iUiListener, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "login--params");
        return a(activity, (androidx.fragment.app.Fragment) null, com.tencent.open.utils.l.a(map, com.tencent.connect.common.Constants.KEY_SCOPE, "all"), iUiListener, "", com.tencent.open.utils.l.a(map, com.tencent.connect.common.Constants.KEY_QRCODE, false), map);
    }

    public int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, (androidx.fragment.app.Fragment) null, str, iUiListener, str2);
    }

    public int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, null, str, iUiListener, "", z);
    }

    @java.lang.Deprecated
    public int a(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        com.tencent.connect.common.BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = com.igexin.push.core.b.m;
        }
        if (str3.equals("")) {
            str3 = com.igexin.push.core.b.m;
        }
        if (str4.equals("")) {
            str4 = com.igexin.push.core.b.m;
        }
        com.tencent.connect.common.BaseApi.installChannel = str3;
        com.tencent.connect.common.BaseApi.registerChannel = str2;
        com.tencent.connect.common.BaseApi.businessId = str4;
        return this.a.a(activity, str, iUiListener, false, null, z);
    }

    public int a(androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2) {
        androidx.fragment.app.FragmentActivity activity = fragment.getActivity();
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    public int a(androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, java.lang.String str2, boolean z) {
        androidx.fragment.app.FragmentActivity activity = fragment.getActivity();
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2, z);
    }

    public void a() {
        this.a.a((com.tencent.tauth.IUiListener) null);
    }

    public void a(com.tencent.tauth.IUiListener iUiListener) {
        this.a.b(iUiListener);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + "");
        this.b.setAccessToken(str, str2);
    }

    public int b(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.a.a(activity, str, iUiListener, true, null, false);
    }

    public com.tencent.connect.auth.QQToken b() {
        return this.b;
    }

    public void b(android.content.Context context, java.lang.String str) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.b);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public boolean c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.b.isSessionValid() ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        com.tencent.open.log.SLog.i("openSDK_LOG.QQAuth", sb.toString());
        return this.b.isSessionValid();
    }
}
