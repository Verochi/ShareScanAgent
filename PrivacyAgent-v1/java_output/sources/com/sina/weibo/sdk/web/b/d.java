package com.sina.weibo.sdk.web.b;

/* loaded from: classes19.dex */
public final class d extends com.sina.weibo.sdk.web.b.b {
    public com.sina.weibo.sdk.api.WeiboMultiMessage aJ;
    private byte[] aK;
    java.lang.String aL;
    public java.lang.String aj;
    public java.lang.String packageName;
    private java.lang.String text;

    /* renamed from: com.sina.weibo.sdk.web.b.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sina.weibo.sdk.net.c<java.lang.String> {
        final /* synthetic */ com.sina.weibo.sdk.web.b.b.a aM;

        public AnonymousClass1(com.sina.weibo.sdk.web.b.b.a aVar) {
            this.aM = aVar;
        }

        @Override // com.sina.weibo.sdk.net.c
        public final /* synthetic */ void a(java.lang.String str) {
            java.lang.String str2 = str;
            com.sina.weibo.sdk.c.c.a("WbShareTag", "handle image result :" + str2);
            if (android.text.TextUtils.isEmpty(str2)) {
                com.sina.weibo.sdk.web.b.b.a aVar = this.aM;
                if (aVar != null) {
                    aVar.onError("处理图片，服务端返回null!");
                    return;
                }
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                int optInt = jSONObject.optInt("code");
                java.lang.String optString = jSONObject.optString("data");
                if (optInt != 1 || android.text.TextUtils.isEmpty(optString)) {
                    com.sina.weibo.sdk.web.b.b.a aVar2 = this.aM;
                    if (aVar2 != null) {
                        aVar2.onError("图片内容不合适，禁止上传！");
                        return;
                    }
                    return;
                }
                com.sina.weibo.sdk.web.b.d.this.aL = optString;
                com.sina.weibo.sdk.web.b.b.a aVar3 = this.aM;
                if (aVar3 != null) {
                    aVar3.onComplete();
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.sina.weibo.sdk.web.b.b.a aVar4 = this.aM;
                if (aVar4 != null) {
                    aVar4.onError("解析服务端返回的字符串时发生异常！");
                }
            }
        }

        @Override // com.sina.weibo.sdk.net.c
        public final void onError(java.lang.Throwable th) {
            com.sina.weibo.sdk.web.b.b.a aVar = this.aM;
            if (aVar != null) {
                aVar.onError(th.getMessage());
            }
        }
    }

    public d(android.content.Context context) {
        this.ae = context;
    }

    public d(com.sina.weibo.sdk.auth.AuthInfo authInfo) {
        super(authInfo, 1, null, null);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(android.os.Bundle bundle) {
        com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage = this.aJ;
        if (weiboMultiMessage != null) {
            weiboMultiMessage.writeToBundle(bundle);
        }
        bundle.putString("token", this.aj);
        bundle.putString("packageName", this.packageName);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void a(com.sina.weibo.sdk.web.b.b.a aVar) {
        com.sina.weibo.sdk.b.b bVar;
        com.sina.weibo.sdk.b.e eVar = new com.sina.weibo.sdk.b.e(this.ae, new java.lang.String(this.aK), this.aH.a().getAppKey(), this.aj, new com.sina.weibo.sdk.web.b.d.AnonymousClass1(aVar));
        bVar = com.sina.weibo.sdk.b.b.a.P;
        bVar.a(eVar);
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final void b(android.os.Bundle bundle) {
        byte[] bArr;
        java.io.FileInputStream fileInputStream;
        com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage = new com.sina.weibo.sdk.api.WeiboMultiMessage();
        this.aJ = weiboMultiMessage;
        weiboMultiMessage.readFromBundle(bundle);
        this.aj = bundle.getString("token");
        this.packageName = bundle.getString("packageName");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.sina.weibo.sdk.api.TextObject textObject = this.aJ.textObject;
        if (textObject != null) {
            sb.append(textObject.text);
        }
        com.sina.weibo.sdk.api.ImageObject imageObject = this.aJ.imageObject;
        if (imageObject != null) {
            java.lang.String str = imageObject.imagePath;
            if (!android.text.TextUtils.isEmpty(str)) {
                java.io.File file = new java.io.File(str);
                if (file.exists() && file.canRead() && file.length() > 0) {
                    byte[] bArr2 = new byte[(int) file.length()];
                    java.io.FileInputStream fileInputStream2 = null;
                    try {
                        try {
                            fileInputStream = new java.io.FileInputStream(file);
                        } catch (java.lang.Exception e) {
                            e = e;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                    try {
                        fileInputStream.read(bArr2);
                        this.aK = com.sina.weibo.sdk.c.e.b(bArr2);
                        try {
                            fileInputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        bArr = imageObject.imageData;
                        if (bArr != null) {
                            this.aK = com.sina.weibo.sdk.c.e.b(bArr);
                        }
                        this.text = sb.toString();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            }
            bArr = imageObject.imageData;
            if (bArr != null && bArr.length > 0) {
                this.aK = com.sina.weibo.sdk.c.e.b(bArr);
            }
        }
        this.text = sb.toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final java.lang.String getUrl() {
        android.net.Uri.Builder buildUpon = android.net.Uri.parse("https://service.weibo.com/share/mobilesdk.php").buildUpon();
        buildUpon.appendQueryParameter("title", this.text);
        buildUpon.appendQueryParameter("version", "0041005000");
        java.lang.String appKey = this.aH.a().getAppKey();
        if (!android.text.TextUtils.isEmpty(appKey)) {
            buildUpon.appendQueryParameter(com.tencent.open.SocialConstants.PARAM_SOURCE, appKey);
        }
        if (!android.text.TextUtils.isEmpty(this.aj)) {
            buildUpon.appendQueryParameter(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.aj);
        }
        java.lang.String f = com.sina.weibo.sdk.c.e.f(this.ae, appKey);
        if (!android.text.TextUtils.isEmpty(f)) {
            buildUpon.appendQueryParameter("aid", f);
        }
        if (!android.text.TextUtils.isEmpty(this.packageName)) {
            buildUpon.appendQueryParameter(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, this.packageName);
        }
        if (!android.text.TextUtils.isEmpty(this.aL)) {
            buildUpon.appendQueryParameter("picinfo", this.aL);
        }
        buildUpon.appendQueryParameter("luicode", "10000360");
        buildUpon.appendQueryParameter("lfid", com.igexin.assist.sdk.AssistPushConsts.OPPO_PREFIX + appKey);
        return buildUpon.build().toString();
    }

    @Override // com.sina.weibo.sdk.web.b.b
    public final boolean w() {
        byte[] bArr = this.aK;
        if (bArr == null || bArr.length <= 0) {
            return super.w();
        }
        return true;
    }
}
