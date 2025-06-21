package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public final class e extends com.sina.weibo.sdk.b.c<java.lang.Void, java.lang.Void, java.lang.String> {
    private android.content.Context ae;
    private com.sina.weibo.sdk.net.c<java.lang.String> ag;
    private java.lang.Throwable ah;
    private java.lang.String ai;
    private java.lang.String aj;
    private java.lang.String appKey;

    public e(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sina.weibo.sdk.net.c<java.lang.String> cVar) {
        this.ae = context;
        this.ai = str;
        this.appKey = str2;
        this.aj = str3;
        this.ag = cVar;
    }

    private java.lang.String d(java.lang.String str) {
        return com.sina.weibo.sdk.net.HttpManager.a(this.ae, getAid(), this.aj, this.appKey, str);
    }

    private java.lang.String getAid() {
        return com.sina.weibo.sdk.c.e.f(this.ae, this.appKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public java.lang.String o() {
        try {
            java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
            com.sina.weibo.sdk.net.e.a aVar = new com.sina.weibo.sdk.net.e.a();
            aVar.url = "https://service.weibo.com/share/mobilesdk_uppic.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.a("aid", getAid()).a("oauth_timestamp", valueOf).a("oauth_sign", d(valueOf)).b(com.heytap.mcssdk.constant.b.z, this.appKey).b("aid", getAid()).b("oauth_timestamp", valueOf).b("oauth_sign", d(valueOf)).b(com.tencent.open.SocialConstants.PARAM_IMG_URL, this.ai).i()).j();
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
