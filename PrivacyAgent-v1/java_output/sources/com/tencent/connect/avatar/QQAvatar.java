package com.tencent.connect.avatar;

/* loaded from: classes19.dex */
public class QQAvatar extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";
    private com.tencent.tauth.IUiListener a;

    public QQAvatar(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    private android.content.Intent a(android.app.Activity activity) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(activity, com.tencent.connect.avatar.ImageActivity.class);
        return intent;
    }

    private void a(android.app.Activity activity, android.os.Bundle bundle, android.content.Intent intent) {
        a(bundle);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, "action_avatar");
        intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
        com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_AVATER, this.a);
        a(activity, intent, com.tencent.connect.common.Constants.REQUEST_AVATER);
    }

    private void a(android.os.Bundle bundle) {
        com.tencent.connect.auth.QQToken qQToken = this.c;
        if (qQToken != null) {
            bundle.putString("appid", qQToken.getAppId());
            if (this.c.isSessionValid()) {
                bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_STR, this.c.getAccessToken());
                bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_TYPE, "0x80");
            }
            java.lang.String openId = this.c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString("platform", "androidqz");
            try {
                bundle.putString("pf", com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                bundle.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
        }
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
    }

    public void setAvatar(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener, int i) {
        com.tencent.tauth.IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.c.getAppId());
        bundle.putString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.c.getAccessToken());
        bundle.putLong(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN, this.c.getExpireTimeInSecond());
        bundle.putString("openid", this.c.getOpenId());
        android.content.Intent a = a(activity);
        if (!a(a)) {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", "1");
        } else {
            a(activity, bundle, a);
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SET_AVATAR, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", "0");
        }
    }

    public void setAvatarByQQ(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.tauth.IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!com.tencent.open.utils.i.b(activity)) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (com.tencent.open.utils.i.c(activity, "8.0.0") < 0) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!android.text.TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a), 2));
        }
        java.lang.String appId = this.c.getAppId();
        java.lang.String openId = this.c.getOpenId();
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        }
        java.lang.String a2 = com.tencent.open.utils.l.a(activity, uri);
        if (!android.text.TextUtils.isEmpty(a2)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(uri.toString()), 2));
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!android.text.TextUtils.isEmpty(a2)) {
            stringBuffer.append("&set_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a2), 2));
        }
        stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
        com.tencent.open.log.SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_EDIT_AVATAR, iUiListener);
            a(activity, com.tencent.connect.common.Constants.REQUEST_EDIT_AVATAR, intent, false);
        }
    }

    public void setDynamicAvatar(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.tauth.IUiListener iUiListener2 = this.a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.a = iUiListener;
        if (!com.tencent.open.utils.i.b(activity)) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (com.tencent.open.utils.i.c(activity, "8.0.5") < 0) {
            android.widget.Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        java.lang.String a = com.tencent.open.utils.l.a(activity);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!android.text.TextUtils.isEmpty(a)) {
            if (a.length() > 20) {
                a = a.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a), 2));
        }
        java.lang.String appId = this.c.getAppId();
        java.lang.String openId = this.c.getOpenId();
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
        }
        java.lang.String a2 = com.tencent.open.utils.l.a(activity, uri);
        if (!android.text.TextUtils.isEmpty(a2)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(android.util.Base64.encodeToString(com.tencent.open.utils.l.i(uri.toString()), 2));
            } catch (java.lang.Exception e) {
                com.tencent.open.log.SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!android.text.TextUtils.isEmpty(a2)) {
            stringBuffer.append("&video_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(a2), 2));
        }
        stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
        com.tencent.open.log.SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra("pkg_name", activity.getPackageName());
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
            a(activity, com.tencent.connect.common.Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
        }
    }
}
