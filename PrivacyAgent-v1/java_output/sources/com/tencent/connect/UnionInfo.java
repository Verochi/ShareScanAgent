package com.tencent.connect;

/* loaded from: classes19.dex */
public class UnionInfo extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String URL_GET_UNION_ID = "https://openmobile.qq.com/oauth2.0/me";

    public UnionInfo(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public void getUnionId(com.tencent.tauth.IUiListener iUiListener) {
        android.os.Bundle a = a();
        a.putString(com.tencent.open.SocialOperation.GAME_UNION_ID, "1");
        com.tencent.open.utils.HttpUtils.requestAsync(this.c, com.tencent.open.utils.f.a(), URL_GET_UNION_ID, a, "GET", new com.tencent.connect.common.BaseApi.TempRequestListener(iUiListener));
    }
}
