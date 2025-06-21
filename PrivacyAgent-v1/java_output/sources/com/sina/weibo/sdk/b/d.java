package com.sina.weibo.sdk.b;

/* loaded from: classes19.dex */
public final class d extends com.sina.weibo.sdk.b.c<java.lang.Void, java.lang.Void, java.lang.String> {
    private android.content.Context ae;
    private com.sina.weibo.sdk.api.ChatObject af;
    private com.sina.weibo.sdk.net.c<java.lang.String> ag;
    private java.lang.Throwable ah;

    public d(android.content.Context context, com.sina.weibo.sdk.api.ChatObject chatObject, com.sina.weibo.sdk.net.c<java.lang.String> cVar) {
        this.ae = context;
        this.af = chatObject;
        this.ag = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public java.lang.String o() {
        com.sina.weibo.sdk.auth.AuthInfo a = com.sina.weibo.sdk.a.a();
        try {
            com.sina.weibo.sdk.net.e.a aVar = new com.sina.weibo.sdk.net.e.a();
            aVar.url = "http://i.open.t.sina.com.cn/mobilesdk/sendmessage.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.b("app_key", a.getAppKey()).b("platform", "2").b("android_pack", a.getPackageName()).b("android_sign", a.getHash()).b(com.umeng.analytics.pro.bo.f445s, this.af.content).b("image_url", this.af.image_url).b("url", this.af.url).b("summary", this.af.summary).i()).j();
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
