package com.tencent.tauth;

/* loaded from: classes19.dex */
public class AuthActivity extends android.app.Activity {
    public static final java.lang.String ACTION_KEY = "action";
    public static final java.lang.String ACTION_SHARE_PRIZE = "sharePrize";
    private static int a;

    private void a(android.net.Uri uri) {
        com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (uri != null && uri.toString() != null) {
            java.lang.String str = "";
            if (!uri.toString().equals("")) {
                java.lang.String uri2 = uri.toString();
                android.os.Bundle a2 = com.tencent.open.utils.l.a(uri2.substring(uri2.indexOf("#") + 1));
                if (a2 == null) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                java.lang.String string = a2.getString("action");
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, action: " + string);
                if (string == null) {
                    finish();
                    return;
                }
                if (string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer") || string.equals("shareToTroopBar")) {
                    if (string.equals("shareToQzone") && com.tencent.open.utils.i.a((android.content.Context) this, "com.tencent.mobileqq") != null && com.tencent.open.utils.i.c(this, "5.2.0") < 0) {
                        int i = a + 1;
                        a = i;
                        if (i == 2) {
                            a = 0;
                            finish();
                            return;
                        }
                    }
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                    android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                    intent.putExtras(a2);
                    intent.setFlags(603979776);
                    startActivity(intent);
                    finish();
                    return;
                }
                if (string.equals("addToQQFavorites")) {
                    android.content.Intent intent2 = getIntent();
                    intent2.putExtras(a2);
                    intent2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_share");
                    com.tencent.tauth.IUiListener listnerWithAction = com.tencent.connect.common.UIListenerManager.getInstance().getListnerWithAction(string);
                    if (listnerWithAction != null) {
                        com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent2, listnerWithAction);
                    }
                    finish();
                    return;
                }
                if (string.equals(ACTION_SHARE_PRIZE)) {
                    android.content.Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                    try {
                        str = com.tencent.open.utils.l.d(a2.getString("response")).getString("activityid");
                    } catch (java.lang.Exception e) {
                        com.tencent.open.log.SLog.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", e);
                    }
                    if (!android.text.TextUtils.isEmpty(str)) {
                        launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putString("activityid", str);
                        launchIntentForPackage.putExtras(bundle);
                    }
                    startActivity(launchIntentForPackage);
                    finish();
                    return;
                }
                if (string.equals("sdkSetAvatar")) {
                    boolean booleanExtra = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                    android.content.Intent intent3 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                    intent3.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, com.tencent.connect.common.Constants.REQUEST_EDIT_AVATAR);
                    intent3.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra);
                    intent3.putExtras(a2);
                    intent3.setFlags(603979776);
                    startActivity(intent3);
                    finish();
                    return;
                }
                if ("sdkSetDynamicAvatar".equals(string)) {
                    boolean booleanExtra2 = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                    android.content.Intent intent4 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                    intent4.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, com.tencent.connect.common.Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                    intent4.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra2);
                    intent4.putExtras(a2);
                    intent4.setFlags(603979776);
                    startActivity(intent4);
                    finish();
                    return;
                }
                if (string.equals("sdkSetEmotion")) {
                    boolean booleanExtra3 = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                    android.content.Intent intent5 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                    intent5.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION);
                    intent5.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra3);
                    intent5.putExtras(a2);
                    intent5.setFlags(603979776);
                    startActivity(intent5);
                    finish();
                    return;
                }
                if (string.equals("bindGroup")) {
                    com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--bind group callback.");
                    boolean booleanExtra4 = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                    android.content.Intent intent6 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                    intent6.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, com.tencent.connect.common.Constants.REQUEST_BIND_GROUP);
                    intent6.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra4);
                    intent6.putExtras(a2);
                    intent6.setFlags(603979776);
                    startActivity(intent6);
                    finish();
                    return;
                }
                if (!string.equals("joinGroup")) {
                    finish();
                    return;
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.AuthActivity", "-->handleActionUri--join group callback. ");
                boolean booleanExtra5 = getIntent().getBooleanExtra(com.tencent.connect.common.Constants.KEY_STAY, false);
                android.content.Intent intent7 = new android.content.Intent(this, (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
                intent7.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, com.tencent.connect.common.Constants.REQUEST_JOIN_GROUP);
                intent7.putExtra(com.tencent.connect.common.Constants.KEY_STAY, booleanExtra5);
                intent7.putExtras(a2);
                intent7.setFlags(603979776);
                startActivity(intent7);
                finish();
                return;
            }
        }
        com.tencent.open.log.SLog.w("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        android.net.Uri uri;
        super.onCreate(bundle);
        if (getIntent() == null) {
            com.tencent.open.log.SLog.w("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        try {
            uri = getIntent().getData();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            uri = null;
        }
        com.tencent.open.log.SLog.v("openSDK_LOG.AuthActivity", "-->onCreate, uri: " + uri);
        try {
            a(uri);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
