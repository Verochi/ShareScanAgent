package com.sina.weibo.sdk.auth;

/* loaded from: classes19.dex */
public interface WbAuthListener {
    void onCancel();

    void onComplete(com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken);

    void onError(com.sina.weibo.sdk.common.UiError uiError);
}
