package com.tencent.connect;

/* loaded from: classes19.dex */
public class UserInfo extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public UserInfo(android.content.Context context, com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        super(cVar, qQToken);
    }

    public void getOpenId(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), GRAPH_OPEN_ID, a(), "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }

    public void getUserInfo(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), "user/get_simple_userinfo", a(), "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }
}
