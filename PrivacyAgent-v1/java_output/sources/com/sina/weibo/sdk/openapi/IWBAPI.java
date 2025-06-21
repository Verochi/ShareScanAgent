package com.sina.weibo.sdk.openapi;

/* loaded from: classes19.dex */
public interface IWBAPI {
    void authorize(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener);

    void authorizeCallback(int i, int i2, android.content.Intent intent);

    void authorizeClient(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener);

    void authorizeWeb(com.sina.weibo.sdk.auth.WbAuthListener wbAuthListener);

    void doResultIntent(android.content.Intent intent, com.sina.weibo.sdk.share.WbShareCallback wbShareCallback);

    boolean isWBAppInstalled();

    boolean isWBAppSupportMultipleImage();

    void registerApp(android.content.Context context, com.sina.weibo.sdk.auth.AuthInfo authInfo);

    void setLoggerEnable(boolean z);

    void shareMessage(com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage, boolean z);

    void shareStory(com.sina.weibo.sdk.api.StoryMessage storyMessage);
}
