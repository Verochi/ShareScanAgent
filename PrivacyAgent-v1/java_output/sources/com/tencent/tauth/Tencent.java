package com.tencent.tauth;

/* loaded from: classes19.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static com.tencent.tauth.Tencent c;
    private final com.tencent.connect.auth.c a;
    private java.lang.String b;

    private Tencent(java.lang.String str, android.content.Context context) {
        this.a = com.tencent.connect.auth.c.a(str, context);
    }

    private static boolean a(android.content.Context context, java.lang.String str) {
        try {
            context.getPackageManager().getActivityInfo(new android.content.ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
            try {
                context.getPackageManager().getActivityInfo(new android.content.ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                return true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized com.tencent.tauth.Tencent createInstance(java.lang.String str, android.content.Context context) {
        synchronized (com.tencent.tauth.Tencent.class) {
            com.tencent.open.utils.f.a(context.getApplicationContext());
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            com.tencent.tauth.Tencent tencent = c;
            if (tencent == null) {
                c = new com.tencent.tauth.Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                c.logout(context);
                c = new com.tencent.tauth.Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            com.tencent.open.utils.g.a(context, str);
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return c;
        }
    }

    public static synchronized com.tencent.tauth.Tencent createInstance(java.lang.String str, android.content.Context context, java.lang.String str2) {
        com.tencent.tauth.Tencent createInstance;
        synchronized (com.tencent.tauth.Tencent.class) {
            createInstance = createInstance(str, context);
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
            if (createInstance != null) {
                createInstance.b = str2;
            } else {
                com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
            }
        }
        return createInstance;
    }

    public static synchronized java.lang.String getAuthorities(java.lang.String str) {
        synchronized (com.tencent.tauth.Tencent.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            com.tencent.tauth.Tencent tencent = c;
            if (tencent != null) {
                return str.equals(tencent.getAppId()) ? c.b : "";
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "sInstance == null");
            return null;
        }
    }

    public static void handleResultData(android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isSupportPushToQZone(android.content.Context context) {
        boolean z = com.tencent.open.utils.i.c(context, "5.9.5") >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        return z;
    }

    public static boolean isSupportShareToQQ(android.content.Context context) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (com.tencent.open.utils.l.c(context) && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (com.tencent.open.utils.i.c(context, "4.1") < 0 && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) == null && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) == null) {
            z = false;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        return z;
    }

    public static boolean onActivityResultData(int i, int i2, android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        return com.tencent.connect.common.UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public static java.util.Map<java.lang.String, java.lang.String> parseMiniParameters(android.content.Intent intent) {
        java.lang.String stringExtra;
        java.util.HashMap hashMap = new java.util.HashMap();
        if (intent == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        }
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            org.json.JSONObject jSONObject = new org.json.JSONObject(stringExtra);
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        android.net.Uri data = intent.getData();
        if (data == null) {
            com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        java.lang.String uri = data.toString();
        if (android.text.TextUtils.isEmpty(uri)) {
            com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        java.lang.String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (android.text.TextUtils.isEmpty(substring)) {
            com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (java.lang.String str : substring.split("&")) {
            java.lang.String[] split = str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public static void setCustomLogger(com.tencent.open.log.Tracer tracer) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        com.tencent.open.log.SLog.getInstance().setCustomLogger(tracer);
    }

    public void checkLogin(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        this.a.a(iUiListener);
    }

    public java.lang.String getAccessToken() {
        java.lang.String accessToken = this.a.b().getAccessToken();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        return accessToken;
    }

    public java.lang.String getAppId() {
        java.lang.String appId = this.a.b().getAppId();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.a.b().getExpireTimeInSecond();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        return expireTimeInSecond;
    }

    public java.lang.String getOpenId() {
        java.lang.String openId = this.a.b().getOpenId();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        return openId;
    }

    public com.tencent.connect.auth.QQToken getQQToken() {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        return this.a.b();
    }

    @java.lang.Deprecated
    public void handleLoginData(android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(org.json.JSONObject jSONObject) {
        try {
            java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
            java.lang.String string2 = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
            java.lang.String string3 = jSONObject.getString("openid");
            if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2) && !android.text.TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("QQToken", "initSessionCache " + e.toString());
        }
    }

    public boolean isQQInstalled(android.content.Context context) {
        boolean b = com.tencent.open.utils.i.b(context);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b);
        return b;
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        return z;
    }

    public boolean isSessionValid() {
        boolean c2 = this.a.c();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c2);
        return c2;
    }

    public boolean isSupportSSOLogin(android.app.Activity activity) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (com.tencent.open.utils.l.c(activity) && com.tencent.open.utils.i.a((android.content.Context) activity, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (com.tencent.open.utils.i.c(activity, "4.1") < 0 && com.tencent.open.utils.i.d(activity, "1.1") < 0 && com.tencent.open.utils.i.e(activity, "4.0.0") < 0) {
            z = false;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        return z;
    }

    public org.json.JSONObject loadSession(java.lang.String str) {
        org.json.JSONObject loadSession = this.a.b().loadSession(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(loadSession != null ? loadSession.length() : 0);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        return loadSession;
    }

    public int login(android.app.Activity activity, com.tencent.tauth.IUiListener iUiListener, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login activity with params");
        return this.a.a(activity, iUiListener, map);
    }

    public int login(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.a.a(activity, str, iUiListener);
    }

    public int login(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.a.a(activity, str, iUiListener, z);
    }

    public int login(androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.a.a(fragment, str, iUiListener, "");
    }

    public int login(androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.a.a(fragment, str, iUiListener, "", z);
    }

    public int loginServerSide(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        return this.a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginServerSide(androidx.fragment.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        return this.a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public int loginWithOEM(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.a.a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(android.content.Context context) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "logout()");
        this.a.b().setAccessToken(null, "0");
        this.a.b().setOpenId(null);
        this.a.b().removeSession(this.a.b().getAppId());
    }

    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        new com.tencent.connect.share.QzonePublish(activity, this.a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        this.a.a();
    }

    public org.json.JSONObject request(java.lang.String str, android.os.Bundle bundle, java.lang.String str2) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "request()");
        return com.tencent.open.utils.HttpUtils.request(this.a.b(), com.tencent.open.utils.f.a(), str, bundle, str2);
    }

    public void requestAsync(java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IRequestListener iRequestListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        com.tencent.open.utils.HttpUtils.requestAsync(this.a.b(), com.tencent.open.utils.f.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(org.json.JSONObject jSONObject) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        this.a.b().saveSession(jSONObject);
    }

    public void setAccessToken(java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        this.a.a(str, str2);
    }

    public void setAvatar(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        java.lang.String string = bundle.getString("picture");
        new com.tencent.connect.avatar.QQAvatar(this.a.b()).setAvatar(activity, android.net.Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatar(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener, int i, int i2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public void setAvatarByQQ(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        new com.tencent.connect.avatar.QQAvatar(this.a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        new com.tencent.connect.avatar.QQAvatar(this.a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(android.app.Activity activity, java.util.ArrayList<android.net.Uri> arrayList, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        new com.tencent.connect.emotion.QQEmotion(this.a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(java.lang.String str) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        this.a.b(com.tencent.open.utils.f.a(), str);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        if (android.text.TextUtils.isEmpty(this.b)) {
            iUiListener.onWarning(-19);
        }
        new com.tencent.connect.share.QQShare(activity, this.a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        new com.tencent.connect.share.QzoneShare(activity, this.a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int startIMAio(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return new com.tencent.open.im.IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        return new com.tencent.open.miniapp.MiniApp(getQQToken()).startMiniApp(activity, com.tencent.open.miniapp.MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }
}
