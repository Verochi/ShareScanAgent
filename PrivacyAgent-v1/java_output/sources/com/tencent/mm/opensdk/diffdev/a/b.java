package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes19.dex */
public class b extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.tencent.mm.opensdk.diffdev.a.b.a> {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private com.tencent.mm.opensdk.diffdev.OAuthListener f;
    private com.tencent.mm.opensdk.diffdev.a.c g;

    public static class a {
        public com.tencent.mm.opensdk.diffdev.OAuthErrCode a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public byte[] e;

        private a() {
        }

        public static com.tencent.mm.opensdk.diffdev.a.b.a a(byte[] bArr) {
            com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode;
            java.lang.String format;
            com.tencent.mm.opensdk.diffdev.a.b.a aVar = new com.tencent.mm.opensdk.diffdev.a.b.a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (java.lang.Exception e) {
                    format = java.lang.String.format("parse fail, build String fail, ex = %s", e.getMessage());
                }
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr, "utf-8"));
                    int i = jSONObject.getInt("errcode");
                    if (i != 0) {
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", java.lang.String.format("resp errcode = %d", java.lang.Integer.valueOf(i)));
                        aVar.a = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                        jSONObject.optString("errmsg");
                        return aVar;
                    }
                    java.lang.String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = android.util.Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.a = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                            aVar.e = decode;
                            aVar.b = jSONObject.getString("uuid");
                            java.lang.String string2 = jSONObject.getString("appname");
                            aVar.c = string2;
                            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeResult", java.lang.String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.b, string2, java.lang.Integer.valueOf(aVar.e.length)));
                            return aVar;
                        }
                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.a = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.a = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (java.lang.Exception e2) {
                    format = java.lang.String.format("parse json fail, ex = %s", e2.getMessage());
                    com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.a = oAuthErrCode;
                    return aVar;
                }
            }
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.a = oAuthErrCode;
            return aVar;
        }
    }

    public b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = oAuthListener;
    }

    public boolean a() {
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        com.tencent.mm.opensdk.diffdev.a.c cVar = this.g;
        return cVar == null ? cancel(true) : cVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    public com.tencent.mm.opensdk.diffdev.a.b.a doInBackground(java.lang.Void[] voidArr) {
        java.lang.Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        java.lang.String format = java.lang.String.format("https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s", this.a, this.c, this.d, this.b, this.e);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(format, 60000);
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeTask", java.lang.String.format("doInBackground, url = %s, time consumed = %d(ms)", format, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - currentTimeMillis)));
        return com.tencent.mm.opensdk.diffdev.a.b.a.a(a2);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(com.tencent.mm.opensdk.diffdev.a.b.a aVar) {
        com.tencent.mm.opensdk.diffdev.a.b.a aVar2 = aVar;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode = aVar2.a;
        if (oAuthErrCode != com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.GetQRCodeTask", java.lang.String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f.onAuthFinish(aVar2.a, null);
            return;
        }
        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.e.length);
        this.f.onAuthGotQrcode(aVar2.d, aVar2.e);
        com.tencent.mm.opensdk.diffdev.a.c cVar = new com.tencent.mm.opensdk.diffdev.a.c(aVar2.b, this.f);
        this.g = cVar;
        cVar.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
    }
}
