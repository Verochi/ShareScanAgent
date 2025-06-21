package com.tencent.connect.common;

/* loaded from: classes19.dex */
public abstract class BaseApi {
    public static java.lang.String businessId;
    public static java.lang.String installChannel;
    public static boolean isOEM;
    public static java.lang.String registerChannel;
    protected com.tencent.connect.auth.c b;
    protected com.tencent.connect.auth.QQToken c;

    public class TempRequestListener implements com.tencent.tauth.IRequestListener {
        private final com.tencent.tauth.IUiListener b;
        private final android.os.Handler c;

        /* renamed from: com.tencent.connect.common.BaseApi$TempRequestListener$1, reason: invalid class name */
        public class AnonymousClass1 extends android.os.Handler {
            final /* synthetic */ com.tencent.connect.common.BaseApi a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.os.Looper looper, com.tencent.connect.common.BaseApi baseApi) {
                super(looper);
                this.a = baseApi;
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 0) {
                    com.tencent.connect.common.BaseApi.TempRequestListener.this.b.onComplete(message.obj);
                } else {
                    com.tencent.connect.common.BaseApi.TempRequestListener.this.b.onError(new com.tencent.tauth.UiError(message.what, (java.lang.String) message.obj, null));
                }
            }
        }

        public TempRequestListener(com.tencent.tauth.IUiListener iUiListener) {
            this.b = iUiListener;
            this.c = new com.tencent.connect.common.BaseApi.TempRequestListener.AnonymousClass1(com.tencent.open.utils.f.a().getMainLooper(), com.tencent.connect.common.BaseApi.this);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(org.json.JSONObject jSONObject) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(org.apache.http.conn.ConnectTimeoutException connectTimeoutException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(com.tencent.open.utils.HttpUtils.HttpStatusException httpStatusException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(java.io.IOException iOException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(org.json.JSONException jSONException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(java.net.MalformedURLException malformedURLException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(com.tencent.open.utils.HttpUtils.NetworkUnavailableException networkUnavailableException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(java.net.SocketTimeoutException socketTimeoutException) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(java.lang.Exception exc) {
            android.os.Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(com.tencent.connect.auth.QQToken qQToken) {
        this(null, qQToken);
    }

    public BaseApi(com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        this.b = cVar;
        this.c = qQToken;
    }

    private android.content.Intent a(android.app.Activity activity, android.content.Intent intent, java.util.Map<java.lang.String, java.lang.Object> map) {
        android.content.Intent intent2 = new android.content.Intent(activity.getApplicationContext(), (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(com.tencent.connect.common.AssistActivity.EXTRA_INTENT, intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE, ((java.lang.Boolean) map.get(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.BaseApi", "Exception", e);
        }
        return intent2;
    }

    public android.os.Bundle a() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("format", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", android.os.Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        com.tencent.connect.auth.QQToken qQToken = this.c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.c.getAppId());
            bundle.putString("openid", this.c.getOpenId());
            bundle.putString("appid_for_getting_config", this.c.getAppId());
        }
        android.content.SharedPreferences sharedPreferences = com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
        }
        return bundle;
    }

    public java.lang.String a(java.lang.String str) {
        android.os.Bundle a = a();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            a.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(com.tencent.open.utils.HttpUtils.encodeUrl(a));
        return sb.toString();
    }

    public void a(android.app.Activity activity, int i, android.content.Intent intent, boolean z) {
        android.content.Intent intent2 = new android.content.Intent(activity.getApplicationContext(), (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(com.tencent.connect.common.AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i);
    }

    public void a(android.app.Activity activity, android.content.Intent intent, int i) {
        a(activity, intent, i, (java.util.Map<java.lang.String, java.lang.Object>) null);
    }

    public void a(android.app.Activity activity, android.content.Intent intent, int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        intent.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, i);
        activity.startActivityForResult(a(activity, intent, map), i);
    }

    public void a(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new com.tencent.open.TDialog(activity, "", "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + com.tencent.open.utils.HttpUtils.encodeUrl(bundle), null, this.c).show();
    }

    public void a(androidx.fragment.app.Fragment fragment, android.content.Intent intent, int i, java.util.Map<java.lang.String, java.lang.Object> map) {
        intent.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, i);
        fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i);
    }

    public boolean a(android.content.Intent intent) {
        if (intent != null) {
            return com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent);
        }
        return false;
    }

    public android.content.Intent b(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        if (com.tencent.open.utils.l.c(com.tencent.open.utils.f.a())) {
            intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, str);
            if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_TIM, str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED, str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        return null;
    }

    public android.os.Bundle b() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid", this.c.getAppId());
        if (this.c.isSessionValid()) {
            bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_STR, this.c.getAccessToken());
            bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_TYPE, "0x80");
        }
        java.lang.String openId = this.c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        android.content.SharedPreferences sharedPreferences = com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
            bundle.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    public android.content.Intent c(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        android.content.Intent b = b(str);
        if (b == null || b.getComponent() == null) {
            return null;
        }
        intent.setClassName(b.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    public void releaseResource() {
    }
}
