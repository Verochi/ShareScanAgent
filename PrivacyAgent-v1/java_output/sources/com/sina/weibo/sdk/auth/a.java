package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public final class a {
    public java.lang.ref.WeakReference<android.app.Activity> g;
    public com.sina.weibo.sdk.auth.WbAuthListener h;

    public a(android.app.Activity activity) {
        this.g = new java.lang.ref.WeakReference<>(activity);
    }

    public final void d() {
        com.sina.weibo.sdk.c.c.a("WBSsoTag", "startClientAuth()");
        try {
            android.app.Activity activity = this.g.get();
            com.sina.weibo.sdk.c.a.C0466a c = com.sina.weibo.sdk.c.a.c(activity);
            android.content.Intent intent = new android.content.Intent();
            if (c == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(c.packageName, c.al);
            }
            com.sina.weibo.sdk.auth.AuthInfo a = com.sina.weibo.sdk.a.a();
            intent.putExtra(com.heytap.mcssdk.constant.b.z, a.getAppKey());
            intent.putExtra("redirectUri", a.getRedirectUrl());
            intent.putExtra(com.tencent.connect.common.Constants.PARAM_SCOPE, a.getScope());
            intent.putExtra(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, a.getPackageName());
            intent.putExtra("key_hash", a.getHash());
            intent.putExtra("_weibo_command_type", 3);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb.toString());
            android.app.Activity activity2 = this.g.get();
            if (activity2 == null) {
                this.h.onError(new com.sina.weibo.sdk.common.UiError(-1, "activity is null", ""));
            } else {
                if (!com.sina.weibo.sdk.c.a.a(activity, intent)) {
                    this.h.onError(new com.sina.weibo.sdk.common.UiError(-2, "your app is illegal", ""));
                    return;
                }
                intent.putExtra("aid", com.sina.weibo.sdk.c.e.f(activity2, a.getAppKey()));
                activity2.startActivityForResult(intent, 32973);
                com.sina.weibo.sdk.c.c.a("WBSsoTag", "start SsoActivity ");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.sina.weibo.sdk.c.c.b("WBSsoTag", e.getMessage());
            this.h.onError(new com.sina.weibo.sdk.common.UiError(-3, "occur exception", e.getMessage()));
        }
    }

    public final void e() {
        android.app.Activity activity = this.g.get();
        com.sina.weibo.sdk.net.h hVar = new com.sina.weibo.sdk.net.h();
        com.sina.weibo.sdk.auth.AuthInfo a = com.sina.weibo.sdk.a.a();
        if (a == null) {
            return;
        }
        hVar.put(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, a.getAppKey());
        hVar.put("redirect_uri", a.getRedirectUrl());
        hVar.put(com.tencent.connect.common.Constants.PARAM_SCOPE, a.getScope());
        hVar.put(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, a.getPackageName());
        hVar.put("key_hash", a.getHash());
        hVar.put("response_type", "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX + a.getAppKey());
        com.sina.weibo.sdk.auth.Oauth2AccessToken readAccessToken = com.sina.weibo.sdk.auth.AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            java.lang.String accessToken = readAccessToken.getAccessToken();
            if (!android.text.TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        java.lang.String f = com.sina.weibo.sdk.c.e.f(activity, a.getAppKey());
        if (!android.text.TextUtils.isEmpty(f)) {
            hVar.put("aid", f);
        }
        java.lang.String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.k();
        if (this.h != null) {
            com.sina.weibo.sdk.auth.b f2 = com.sina.weibo.sdk.auth.b.f();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(java.lang.System.currentTimeMillis());
            java.lang.String sb2 = sb.toString();
            f2.a(sb2, this.h);
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.sina.weibo.sdk.web.WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(a, str, sb2);
            android.os.Bundle bundle = new android.os.Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
