package com.tencent.connect.common;

/* loaded from: classes19.dex */
public class AssistActivity extends android.app.Activity {
    public static final java.lang.String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    private java.lang.String d;
    private com.tencent.connect.common.AssistActivity.QQStayReceiver e;
    private boolean f;
    private boolean c = false;
    protected boolean a = false;
    protected android.os.Handler b = new com.tencent.connect.common.AssistActivity.AnonymousClass1();

    /* renamed from: com.tencent.connect.common.AssistActivity$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 0 && !com.tencent.connect.common.AssistActivity.this.isFinishing()) {
                com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                com.tencent.connect.common.AssistActivity.this.finish();
            }
        }
    }

    /* renamed from: com.tencent.connect.common.AssistActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
            com.tencent.connect.common.AssistActivity.this.finish();
        }
    }

    public class QQStayReceiver extends android.content.BroadcastReceiver {
        private QQStayReceiver() {
        }

        public /* synthetic */ QQStayReceiver(com.tencent.connect.common.AssistActivity assistActivity, com.tencent.connect.common.AssistActivity.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String str = "#";
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            android.net.Uri uri = (android.net.Uri) intent.getParcelableExtra("uriData");
            android.content.Intent intent2 = new android.content.Intent();
            try {
                java.lang.String uri2 = uri.toString();
                if (!uri2.contains("#")) {
                    str = "?";
                }
                for (java.lang.String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                    java.lang.String[] split = str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    intent2.putExtra(split[0], split[1]);
                }
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e.getMessage());
            }
            intent2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
            intent2.setData(uri);
            com.tencent.connect.common.AssistActivity.this.setResult(-1, intent2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(android.os.Bundle bundle) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String string = bundle.getString("viaShareType");
        java.lang.String string2 = bundle.getString("callbackAction");
        java.lang.String string3 = bundle.getString("url");
        java.lang.String string4 = bundle.getString("openId");
        java.lang.String string5 = bundle.getString(com.anythink.expressad.videocommon.e.b.u);
        if ("shareToQQ".equals(string2)) {
            str3 = com.tencent.connect.common.Constants.VIA_SHARE_TO_QQ;
            str4 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        } else {
            if (!"shareToQzone".equals(string2)) {
                str = "";
                str2 = str;
                if (com.tencent.open.utils.l.a(this, string3)) {
                    com.tencent.tauth.IUiListener listnerWithAction = com.tencent.connect.common.UIListenerManager.getInstance().getListnerWithAction(string2);
                    if (listnerWithAction != null) {
                        listnerWithAction.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_OPEN_BROWSER_ERROR, null));
                    }
                    com.tencent.open.a.d.a().a(string4, string5, str, str2, "3", "1", string, "0", "2", "0");
                    finish();
                } else {
                    com.tencent.open.a.d.a().a(string4, string5, str, str2, "3", "0", string, "0", "2", "0");
                }
                getIntent().removeExtra("shareH5");
            }
            str3 = com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE;
            str4 = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
        }
        str2 = str4;
        str = str3;
        if (com.tencent.open.utils.l.a(this, string3)) {
        }
        getIntent().removeExtra("shareH5");
    }

    public static android.content.Intent getAssistActivityIntent(android.content.Context context) {
        return new android.content.Intent(context, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("--onActivityResult--requestCode: ");
        sb.append(i);
        sb.append(" | resultCode: ");
        sb.append(i2);
        sb.append("data = null ? ");
        sb.append(intent == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", sb.toString());
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            return;
        }
        if (intent != null) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_login");
        }
        setResultData(i, intent);
        if (this.f) {
            new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.tencent.connect.common.AssistActivity.AnonymousClass2(), 200L);
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        getWindow().addFlags(67108864);
        requestWindowFeature(1);
        super.onCreate(bundle);
        this.f = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE, false);
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f);
        if (getIntent() == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        android.content.Intent intent = (android.content.Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        int intExtra = intent == null ? 0 : intent.getIntExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, 0);
        this.d = intent == null ? "" : intent.getStringExtra("appid");
        android.os.Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c) {
            com.tencent.open.log.SLog.d("openSDK_LOG.AssistActivity", "is restart");
            return;
        }
        if (bundleExtra != null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
            return;
        }
        if (intent == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
            return;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter(com.tencent.connect.common.Constants.SHARE_QQ_AND_STAY + intent.getData().getQueryParameter("share_id"));
            if (this.e == null) {
                this.e = new com.tencent.connect.common.AssistActivity.QQStayReceiver(this, null);
            }
            registerReceiver(this.e, intentFilter);
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e.getMessage());
        }
        startActivityForResult(intent, intExtra);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
        com.tencent.connect.common.AssistActivity.QQStayReceiver qQStayReceiver = this.e;
        if (qQStayReceiver != null) {
            unregisterReceiver(qQStayReceiver);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, -1);
        if (intExtra == 10108) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10109) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_set_emotion");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10110) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_request_dynamic_avatar");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra == 10111) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "joinGroup");
            if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
                moveTaskToBack(true);
            }
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            finish();
            return;
        }
        if (intExtra != 10112) {
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
            return;
        }
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "bindGroup");
        if (intent.getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false)) {
            moveTaskToBack(true);
        }
        setResult(-1, intent);
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onPause() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        android.content.Intent intent = getIntent();
        if (intent.getBooleanExtra("is_login", false)) {
            return;
        }
        if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.c && !isFinishing()) {
            finish();
        }
        if (!this.a) {
            this.a = true;
        } else {
            this.b.sendMessage(this.b.obtainMessage(0));
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.a);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    public void setResultData(int i, android.content.Intent intent) {
        if (intent == null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                com.tencent.open.a.d.a().a("", this.d, "2", "1", "7", "2");
                return;
            }
            return;
        }
        try {
            java.lang.String stringExtra = intent.getStringExtra(com.tencent.connect.common.Constants.KEY_RESPONSE);
            com.tencent.open.log.SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
            if (android.text.TextUtils.isEmpty(stringExtra)) {
                com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
            } else {
                org.json.JSONObject jSONObject = new org.json.JSONObject(stringExtra);
                java.lang.String optString = jSONObject.optString("openid");
                java.lang.String optString2 = jSONObject.optString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
                java.lang.String optString3 = jSONObject.optString("proxy_code");
                long optLong = jSONObject.optLong("proxy_expires_in");
                if (!android.text.TextUtils.isEmpty(optString) && !android.text.TextUtils.isEmpty(optString2)) {
                    com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                    com.tencent.open.a.d.a().a(optString, this.d, "2", "1", "7", "0");
                } else if (android.text.TextUtils.isEmpty(optString3) || optLong == 0) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                    setResult(0, intent);
                    com.tencent.open.a.d.a().a("", this.d, "2", "1", "7", "1");
                } else {
                    com.tencent.open.log.SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                    setResult(-1, intent);
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            e.printStackTrace();
        }
    }
}
