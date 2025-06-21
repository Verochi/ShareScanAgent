package com.sina.weibo.sdk.openapi;

/* loaded from: classes19.dex */
public final class a implements com.sina.weibo.sdk.openapi.IWBAPI {
    private android.content.Context mContext;

    /* renamed from: s, reason: collision with root package name */
    private com.sina.weibo.sdk.auth.a f429s;
    private com.sina.weibo.sdk.share.f t;

    public a(android.content.Context context) {
        this.mContext = context;
        this.f429s = new com.sina.weibo.sdk.auth.a((android.app.Activity) context);
        this.t = new com.sina.weibo.sdk.share.f((android.app.Activity) this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorize(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f429s;
        com.sina.weibo.sdk.c.c.a("WBSsoTag", "authorize()");
        if (wbAuthListener == null) {
            throw new java.lang.RuntimeException("listener can not be null.");
        }
        aVar.h = wbAuthListener;
        android.app.Activity activity = aVar.g.get();
        if (com.sina.weibo.sdk.a.a(activity)) {
            if (com.sina.weibo.sdk.c.a.c(activity) != null) {
                aVar.d();
                return;
            }
        }
        aVar.e();
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeCallback(int i, int i2, android.content.Intent intent) {
        com.sina.weibo.sdk.auth.a aVar = this.f429s;
        com.sina.weibo.sdk.c.c.a("WBSsoTag", "authorizeCallback()");
        com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener = aVar.h;
        if (wbAuthListener != null) {
            if (32973 != i) {
                wbAuthListener.onError(new com.sina.weibo.sdk.common.UiError(-7, "request code is error", "requestCode is error"));
                return;
            }
            if (i2 != -1) {
                if (i2 == 0) {
                    wbAuthListener.onCancel();
                    return;
                } else {
                    wbAuthListener.onError(new com.sina.weibo.sdk.common.UiError(-6, "result code is error", "result code is error"));
                    return;
                }
            }
            if (intent != null) {
                java.lang.String stringExtra = intent.getStringExtra("error");
                java.lang.String stringExtra2 = intent.getStringExtra(com.xiaomi.mipush.sdk.PushMessageHelper.ERROR_TYPE);
                java.lang.String stringExtra3 = intent.getStringExtra("error_description");
                if (!android.text.TextUtils.isEmpty(stringExtra) || !android.text.TextUtils.isEmpty(stringExtra2) || !android.text.TextUtils.isEmpty(stringExtra3)) {
                    if ("access_denied".equals(stringExtra) || "OAuthAccessDeniedException".equals(stringExtra)) {
                        aVar.h.onCancel();
                        return;
                    } else {
                        aVar.h.onError(new com.sina.weibo.sdk.common.UiError(-5, stringExtra2, stringExtra3));
                        return;
                    }
                }
                com.sina.weibo.sdk.auth.Oauth2AccessToken parseAccessToken = com.sina.weibo.sdk.auth.Oauth2AccessToken.parseAccessToken(intent.getExtras());
                if (parseAccessToken == null) {
                    aVar.h.onError(new com.sina.weibo.sdk.common.UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
                } else {
                    com.sina.weibo.sdk.auth.AccessTokenHelper.writeAccessToken(aVar.g.get(), parseAccessToken);
                    aVar.h.onComplete(parseAccessToken);
                }
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeClient(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f429s;
        com.sina.weibo.sdk.c.c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener == null) {
            throw new java.lang.RuntimeException("listener can not be null.");
        }
        aVar.h = wbAuthListener;
        aVar.d();
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void authorizeWeb(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener) {
        com.sina.weibo.sdk.auth.a aVar = this.f429s;
        com.sina.weibo.sdk.c.c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener == null) {
            throw new java.lang.RuntimeException("listener can not be null.");
        }
        aVar.h = wbAuthListener;
        aVar.e();
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void doResultIntent(android.content.Intent intent, com.sina.weibo.sdk.share.WbShareCallback wbShareCallback) {
        android.os.Bundle extras;
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i = extras.getInt("_weibo_resp_errcode", -1);
            if (i == 0) {
                wbShareCallback.onComplete();
            } else if (i == 1) {
                wbShareCallback.onCancel();
            } else {
                if (i != 2) {
                    return;
                }
                wbShareCallback.onError(new com.sina.weibo.sdk.common.UiError(i, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (java.lang.Exception e) {
            wbShareCallback.onError(new com.sina.weibo.sdk.common.UiError(-1, e.getMessage(), e.getMessage()));
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppInstalled() {
        return com.sina.weibo.sdk.a.a(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final boolean isWBAppSupportMultipleImage() {
        return com.sina.weibo.sdk.a.b(this.mContext);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void registerApp(android.content.Context context, com.sina.weibo.sdk.auth.AuthInfo authInfo) {
        com.sina.weibo.sdk.a.a(context, authInfo);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void setLoggerEnable(boolean z) {
        com.sina.weibo.sdk.c.c.setLoggerEnable(z);
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareMessage(com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage, boolean z) {
        com.sina.weibo.sdk.auth.AuthInfo a;
        com.sina.weibo.sdk.share.f fVar = this.t;
        android.app.Activity activity = fVar.g.get();
        if (activity != null) {
            if (com.sina.weibo.sdk.a.a(activity) || !z) {
                if (z) {
                    fVar.b(weiboMultiMessage);
                    return;
                }
                com.sina.weibo.sdk.c.a.C0466a c = com.sina.weibo.sdk.c.a.c(activity);
                if (com.sina.weibo.sdk.a.a(activity) && c != null) {
                    com.sina.weibo.sdk.c.a.C0466a c2 = com.sina.weibo.sdk.c.a.c(activity);
                    if (c2 != null && c2.am > 10000) {
                        fVar.b(weiboMultiMessage);
                        return;
                    }
                }
                android.app.Activity activity2 = fVar.g.get();
                if (activity2 == null || (a = com.sina.weibo.sdk.a.a()) == null) {
                    return;
                }
                com.sina.weibo.sdk.web.b.d dVar = new com.sina.weibo.sdk.web.b.d(a);
                dVar.setContext(activity2);
                dVar.aJ = weiboMultiMessage;
                dVar.packageName = activity2.getPackageName();
                com.sina.weibo.sdk.auth.Oauth2AccessToken readAccessToken = com.sina.weibo.sdk.auth.AccessTokenHelper.readAccessToken(activity2);
                if (readAccessToken != null) {
                    java.lang.String accessToken = readAccessToken.getAccessToken();
                    if (!android.text.TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                        dVar.aj = accessToken;
                    }
                }
                android.os.Bundle bundle = new android.os.Bundle();
                dVar.writeToBundle(bundle);
                android.content.Intent intent = new android.content.Intent(activity2, (java.lang.Class<?>) com.sina.weibo.sdk.share.ShareTransActivity.class);
                intent.putExtra("start_flag", 0);
                intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                intent.putExtras(bundle);
                activity2.startActivityForResult(intent, 10001);
            }
        }
    }

    @Override // com.sina.weibo.sdk.openapi.IWBAPI
    public final void shareStory(com.sina.weibo.sdk.api.StoryMessage storyMessage) {
        android.app.Activity activity = this.t.g.get();
        if (activity != null) {
            android.net.Uri imageUri = storyMessage.getImageUri();
            android.net.Uri videoUri = storyMessage.getVideoUri();
            if (imageUri != null) {
                try {
                    if (!com.sina.weibo.sdk.c.b.a(activity, imageUri)) {
                    }
                    android.content.Intent intent = new android.content.Intent();
                    intent.putExtra("_weibo_message_stroy", storyMessage);
                    intent.putExtra("start_flag", 0);
                    intent.setClass(activity, com.sina.weibo.sdk.share.ShareStoryActivity.class);
                    activity.startActivityForResult(intent, 10001);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (videoUri == null || !com.sina.weibo.sdk.c.b.b(activity, videoUri)) {
                throw new java.lang.IllegalStateException("File only can be Image or Video. ");
            }
            android.content.Intent intent2 = new android.content.Intent();
            intent2.putExtra("_weibo_message_stroy", storyMessage);
            intent2.putExtra("start_flag", 0);
            intent2.setClass(activity, com.sina.weibo.sdk.share.ShareStoryActivity.class);
            activity.startActivityForResult(intent2, 10001);
        }
    }
}
