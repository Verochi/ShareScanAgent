package com.tencent.open.miniapp;

/* loaded from: classes19.dex */
public class MiniApp extends com.tencent.connect.common.BaseApi {
    public static final int MINIAPP_CONTEXT_NULL = -6;
    public static final int MINIAPP_ID_EMPTY = -1;
    public static final int MINIAPP_ID_NOT_DIGIT = -4;
    public static final int MINIAPP_SHOULD_DOWNLOAD = -2;
    public static final java.lang.String MINIAPP_SRC_ID = "21";
    public static final int MINIAPP_SRC_ID_NOT_DIGIT = -3;
    public static final int MINIAPP_SUCCESS = 0;
    public static final java.lang.String MINIAPP_TYPE_NORMAL = "mini_program_or_game";
    public static final int MINIAPP_UNKNOWN_TYPE = -5;
    public static final java.lang.String MINIAPP_VERSION_RELEASE = "release";
    public static final int MINIAPP_VERSION_WRONG = -7;
    public static final java.lang.String MINIAPP_VERSION_DEVELOP = "develop";
    public static final java.lang.String MINIAPP_VERSION_TRIAL = "trial";
    public static final java.util.List<java.lang.String> OPEN_CONNECT_DEMO_MINI_APP_VERSIONS = java.util.Arrays.asList(MINIAPP_VERSION_DEVELOP, MINIAPP_VERSION_TRIAL, "release");

    public MiniApp(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public MiniApp(android.content.Context context, com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        super(cVar, qQToken);
    }

    public MiniApp(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public int startMiniApp(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (activity == null) {
            com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_CONTEXT_NULL : -6");
            return -6;
        }
        if (!MINIAPP_TYPE_NORMAL.equals(str)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_UNKNOWN_TYPE : -5");
            return -5;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_EMPTY : -1");
            return -1;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!java.lang.Character.isDigit(str2.charAt(i))) {
                com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_ID_NOT_DIGIT : -4");
                return -4;
            }
        }
        if (str4 == null) {
            str4 = "";
        }
        if (!OPEN_CONNECT_DEMO_MINI_APP_VERSIONS.contains(str5)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_VERSION_WRONG : -7");
            return -7;
        }
        if (com.tencent.open.utils.l.e(activity)) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse(java.lang.String.format("mqqapi://connect_miniapp/launch?app_type=%1$s&mini_app_id=%2$s&version=1&src_type=app&app_name=%3$s&app_id=%4$s&src_id=%5$s&mini_app_path=%6$s&mini_app_type=%7$s&open_id=%8$s", str, str2, com.tencent.open.utils.l.l(com.tencent.open.utils.i.a((android.content.Context) activity)), com.tencent.open.utils.l.l(this.c.getAppId()), str3, com.tencent.open.utils.l.l(str4), com.tencent.open.utils.l.l(str5), com.tencent.open.utils.l.l(this.c.getOpenId()))));
            intent.putExtra("pkg_name", activity.getPackageName());
            activity.startActivity(intent);
            com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SUCCESS : 0");
            return 0;
        }
        try {
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
        } catch (java.lang.RuntimeException e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.MiniApp", "Show download dialog exception:" + e.getMessage());
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.MiniApp", "Result is MINIAPP_SHOULD_DOWNLOAD : -2");
        return -2;
    }
}
