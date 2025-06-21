package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public final class f extends com.sina.weibo.sdk.b.c<java.lang.Void, java.lang.Void, java.lang.String> {
    private com.sina.weibo.sdk.net.c<java.lang.String> ag;
    private java.lang.Throwable ah;
    private com.sina.weibo.sdk.auth.Oauth2AccessToken ak;
    private java.lang.String appKey;

    public f(java.lang.String str, com.sina.weibo.sdk.auth.Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c<java.lang.String> cVar) {
        this.appKey = str;
        this.ak = oauth2AccessToken;
        this.ag = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public java.lang.String o() {
        try {
            com.sina.weibo.sdk.net.e.a aVar = new com.sina.weibo.sdk.net.e.a();
            aVar.url = "https://api.weibo.com/oauth2/access_token";
            return new com.sina.weibo.sdk.net.b().a(aVar.b(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.appKey).b(com.heytap.mcssdk.constant.b.z, this.appKey).b("grant_type", "refresh_token").b("refresh_token", this.ak.getRefreshToken()).i()).j();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            this.ah = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    public final /* synthetic */ void onPostExecute(java.lang.String str) {
        java.lang.String str2 = str;
        java.lang.Throwable th = this.ah;
        if (th != null) {
            com.sina.weibo.sdk.net.c<java.lang.String> cVar = this.ag;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<java.lang.String> cVar2 = this.ag;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}
