package com.tencent.open;

/* loaded from: classes19.dex */
public class SocialOperation extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String GAME_FRIEND_ADD_MESSAGE = "add_msg";
    public static final java.lang.String GAME_FRIEND_LABEL = "friend_label";
    public static final java.lang.String GAME_FRIEND_OPENID = "fopen_id";
    public static final java.lang.String GAME_SIGNATURE = "signature";
    public static final java.lang.String GAME_UNION_ID = "unionid";
    public static final java.lang.String GAME_UNION_NAME = "union_name";
    public static final java.lang.String GAME_ZONE_ID = "zoneid";

    /* renamed from: com.tencent.open.SocialOperation$1, reason: invalid class name */
    public class AnonymousClass1 extends com.tencent.tauth.DefaultUiListener {
        final /* synthetic */ com.tencent.tauth.IUiListener a;

        public AnonymousClass1(com.tencent.tauth.IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->unbind group resp is: " + obj);
            if (obj == null) {
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            com.tencent.tauth.IUiListener iUiListener2 = this.a;
            if (iUiListener2 != null) {
                iUiListener2.onComplete(jSONObject);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->unbindQQGroup, error: " + uiError);
            com.tencent.tauth.IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* renamed from: com.tencent.open.SocialOperation$2, reason: invalid class name */
    public class AnonymousClass2 extends com.tencent.tauth.DefaultUiListener {
        final /* synthetic */ com.tencent.tauth.IUiListener a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ android.content.Intent c;

        public AnonymousClass2(com.tencent.tauth.IUiListener iUiListener, android.app.Activity activity, android.content.Intent intent) {
            this.a = iUiListener;
            this.b = activity;
            this.c = intent;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->join group resp is: " + obj);
            if (obj == null) {
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            if (((org.json.JSONObject) obj).optInt("bind") != 1) {
                com.tencent.tauth.IUiListener iUiListener2 = this.a;
                if (iUiListener2 != null) {
                    iUiListener2.onError(new com.tencent.tauth.UiError(3003, "该组织未绑群，无法加入", "该组织未绑群，无法加入。"));
                    return;
                }
                return;
            }
            try {
                com.tencent.open.SocialOperation.this.a(this.b, com.tencent.connect.common.Constants.REQUEST_JOIN_GROUP, this.c, false);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->join group, start activity exception.", e);
                com.tencent.open.SocialOperation.this.a(this.b);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->joinQQGroup, error: " + uiError);
            com.tencent.tauth.IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* renamed from: com.tencent.open.SocialOperation$3, reason: invalid class name */
    public class AnonymousClass3 extends com.tencent.tauth.DefaultUiListener {
        final /* synthetic */ com.tencent.tauth.IUiListener a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ android.content.Intent c;

        public AnonymousClass3(com.tencent.tauth.IUiListener iUiListener, android.app.Activity activity, android.content.Intent intent) {
            this.a = iUiListener;
            this.b = activity;
            this.c = intent;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->bind group resp is: " + obj);
            if (obj == null) {
                com.tencent.tauth.IUiListener iUiListener = this.a;
                if (iUiListener != null) {
                    iUiListener.onError(new com.tencent.tauth.UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                    return;
                }
                return;
            }
            if (((org.json.JSONObject) obj).optInt("bind") == 1) {
                com.tencent.tauth.IUiListener iUiListener2 = this.a;
                if (iUiListener2 != null) {
                    iUiListener2.onError(new com.tencent.tauth.UiError(3002, "该群已绑定！", "绑定过的群不能再次绑定。"));
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() binded return.");
                return;
            }
            try {
                com.tencent.open.SocialOperation.this.a(this.b, com.tencent.connect.common.Constants.REQUEST_BIND_GROUP, this.c, false);
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e);
                com.tencent.open.SocialOperation.this.a(this.b);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, error: " + uiError);
            com.tencent.tauth.IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    public SocialOperation(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.app.Activity activity) {
        a(activity, "");
    }

    private void a(android.app.Activity activity, java.lang.String str) {
        new com.tencent.open.TDialog(activity, "", a(str), null, this.c).show();
    }

    public void bindQQGroup(android.app.Activity activity, java.lang.String str, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
        if (activity == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://opensdk/bind_group?src_type=app&version=1");
        java.lang.String appId = this.c.getAppId();
        if (android.text.TextUtils.isEmpty(appId)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appId is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1003, "appid is null", "please login."));
                return;
            }
            return;
        }
        java.lang.String openId = this.c.getOpenId();
        if (android.text.TextUtils.isEmpty(openId)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1004, "openid params is null", "please login."));
                return;
            }
            return;
        }
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        if (android.text.TextUtils.isEmpty(a)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appname is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1005, "appName params is null", ""));
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization id is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1006, "organizationId params is null", ""));
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization name is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1007, "organizationName params is null", ""));
                return;
            }
            return;
        }
        stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a), 2));
        stringBuffer.append("&organization_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2));
        stringBuffer.append("&organization_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
        stringBuffer.append("&openid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        stringBuffer.append("&appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(appId), 2));
        stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
        com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, url: " + stringBuffer.toString());
        android.net.Uri parse = android.net.Uri.parse(stringBuffer.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (!a(intent) || com.tencent.open.utils.i.c(activity, "8.1.0") < 0) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
            a(activity);
            return;
        }
        com.tencent.open.SocialOperation.AnonymousClass3 anonymousClass3 = new com.tencent.open.SocialOperation.AnonymousClass3(iUiListener, activity, intent);
        android.os.Bundle a2 = a();
        a2.putString("appid", appId);
        a2.putString("orgid", str);
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", a2, "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(anonymousClass3));
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() do.");
    }

    public void joinGroup(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "joinQQGroup()");
        if (activity == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, params is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
                return;
            }
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        java.lang.String appId = this.c.getAppId();
        if (android.text.TextUtils.isEmpty(appId)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, appid is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1003, "appid is null", "appid is null, please login."));
                return;
            }
            return;
        }
        java.lang.String openId = this.c.getOpenId();
        if (android.text.TextUtils.isEmpty(openId)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, openid is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1004, "openid is null", "openid is null, please login."));
                return;
            }
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://opensdk/join_group?src_type=app&version=1");
        stringBuffer.append("&openid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        stringBuffer.append("&appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(appId), 2));
        stringBuffer.append("&organization_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str), 2));
        stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        if (!a(intent) || com.tencent.open.utils.i.c(activity, "8.1.0") < 0) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
            a(activity);
            return;
        }
        com.tencent.open.SocialOperation.AnonymousClass2 anonymousClass2 = new com.tencent.open.SocialOperation.AnonymousClass2(iUiListener, activity, intent);
        android.os.Bundle a = a();
        a.putString("appid", appId);
        a.putString("orgid", str);
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", a, "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(anonymousClass2));
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->joinQQGroup() do.");
    }

    public void makeFriend(android.app.Activity activity, android.os.Bundle bundle) {
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
        if (bundle == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        java.lang.String string = bundle.getString(GAME_FRIEND_OPENID);
        if (android.text.TextUtils.isEmpty(string)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        java.lang.String string2 = bundle.getString(GAME_FRIEND_LABEL);
        java.lang.String string3 = bundle.getString(GAME_FRIEND_ADD_MESSAGE);
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        java.lang.String openId = this.c.getOpenId();
        java.lang.String appId = this.c.getAppId();
        com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid: " + string + " | label: " + string2 + " | message: " + string3 + " | openid: " + openId + " | appid:" + appId);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("&fopen_id=");
        sb.append(android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
        stringBuffer.append(sb.toString());
        if (!android.text.TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&app_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(string2)) {
            stringBuffer.append("&friend_label=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
        }
        if (!android.text.TextUtils.isEmpty(string3)) {
            stringBuffer.append("&add_msg=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a), 2));
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.GameAppOperation", "-->make friend, url: " + stringBuffer.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        if (!a(intent) || com.tencent.open.utils.l.f(activity, "5.1.0")) {
            com.tencent.open.log.SLog.w("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
            a(activity);
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
            try {
                activity.startActivity(intent);
                com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "0");
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e);
                a(activity);
                com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_MAKE_FRIEND, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            }
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
    }

    public void unBindGroup(android.content.Context context, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "unBindQQGroup()");
        if (context == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->uinBindGroup, activity is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->unBindGroup, params is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
                return;
            }
            return;
        }
        java.lang.String appId = this.c.getAppId();
        if (android.text.TextUtils.isEmpty(appId)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.GameAppOperation", "-->unBindGroup, appid is empty.");
            if (iUiListener != null) {
                iUiListener.onError(new com.tencent.tauth.UiError(1003, "param appId is null", "appid is null please login."));
                return;
            }
            return;
        }
        com.tencent.open.SocialOperation.AnonymousClass1 anonymousClass1 = new com.tencent.open.SocialOperation.AnonymousClass1(iUiListener);
        android.os.Bundle a = a();
        a.putString("appid", appId);
        a.putString("orgid", str);
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, context, "https://openmobile.qq.com/cgi-bin/qunopensdk/unbind", a, "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(anonymousClass1));
        com.tencent.open.log.SLog.i("openSDK_LOG.GameAppOperation", "-->unBindQQGroup() do.");
    }
}
