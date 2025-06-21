package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes19.dex */
class c extends android.os.AsyncTask<java.lang.Void, java.lang.Void, com.tencent.mm.opensdk.diffdev.a.c.a> {
    private java.lang.String a;
    private java.lang.String b;
    private com.tencent.mm.opensdk.diffdev.OAuthListener c;
    private int d;

    public static class a {
        public com.tencent.mm.opensdk.diffdev.OAuthErrCode a;
        public java.lang.String b;
        public int c;
    }

    public c(java.lang.String str, com.tencent.mm.opensdk.diffdev.OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = java.lang.String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] voidArr) {
        com.tencent.mm.opensdk.diffdev.a.c.a aVar;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode;
        java.lang.String str;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode2;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode3;
        java.lang.String format;
        org.json.JSONObject jSONObject;
        int i;
        com.tencent.mm.opensdk.diffdev.OAuthErrCode oAuthErrCode4;
        java.lang.Thread.currentThread().setName("OpenSdkNoopingTask");
        java.lang.String str2 = this.a;
        if (str2 != null && str2.length() != 0) {
            com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.b);
                if (this.d == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.d;
                }
                sb.append(str);
                java.lang.String sb2 = sb.toString();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                byte[] a2 = com.tencent.mm.opensdk.channel.a.a.a(sb2, 60000);
                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                aVar = new com.tencent.mm.opensdk.diffdev.a.c.a();
                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
                if (a2 != null && a2.length != 0) {
                    try {
                        try {
                            jSONObject = new org.json.JSONObject(new java.lang.String(a2, "utf-8"));
                            int i2 = jSONObject.getInt("wx_errcode");
                            aVar.c = i2;
                            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingResult", java.lang.String.format("nooping uuidStatusCode = %d", java.lang.Integer.valueOf(i2)));
                            i = aVar.c;
                        } catch (java.lang.Exception e) {
                            format = java.lang.String.format("parse json fail, ex = %s", e.getMessage());
                            com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingResult", format);
                            oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.a = oAuthErrCode2;
                            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), java.lang.Integer.valueOf(aVar.c), java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.a;
                            if (oAuthErrCode3 == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                            }
                            return aVar;
                        }
                    } catch (java.lang.Exception e2) {
                        format = java.lang.String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                    }
                    if (i != 408) {
                        if (i != 500) {
                            switch (i) {
                                case 402:
                                    oAuthErrCode4 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout;
                                    aVar.a = oAuthErrCode4;
                                    break;
                                case 403:
                                    oAuthErrCode4 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel;
                                    aVar.a = oAuthErrCode4;
                                    break;
                                case 405:
                                    aVar.a = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                                    aVar.b = jSONObject.getString("wx_code");
                                    break;
                            }
                            com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), java.lang.Integer.valueOf(aVar.c), java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                            oAuthErrCode3 = aVar.a;
                            if (oAuthErrCode3 == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                                int i3 = aVar.c;
                                this.d = i3;
                                if (i3 == com.tencent.mm.opensdk.diffdev.a.d.UUID_SCANED.a()) {
                                    this.c.onQrcodeScanned();
                                } else if (aVar.c != com.tencent.mm.opensdk.diffdev.a.d.UUID_KEEP_CONNECT.a() && aVar.c == com.tencent.mm.opensdk.diffdev.a.d.UUID_CONFIRM.a()) {
                                    java.lang.String str3 = aVar.b;
                                    if (str3 == null || str3.length() == 0) {
                                        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                                    }
                                }
                            } else {
                                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode3.toString(), java.lang.Integer.valueOf(aVar.c)));
                            }
                            return aVar;
                        }
                        oAuthErrCode4 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.a = oAuthErrCode4;
                        com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), java.lang.Integer.valueOf(aVar.c), java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                        oAuthErrCode3 = aVar.a;
                        if (oAuthErrCode3 == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                        }
                        return aVar;
                    }
                    oAuthErrCode4 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK;
                    aVar.a = oAuthErrCode4;
                    com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), java.lang.Integer.valueOf(aVar.c), java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                    oAuthErrCode3 = aVar.a;
                    if (oAuthErrCode3 == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                    }
                    return aVar;
                }
                com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode2 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr;
                aVar.a = oAuthErrCode2;
                com.tencent.mm.opensdk.utils.Log.d("MicroMsg.SDK.NoopingTask", java.lang.String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb2, aVar.a.toString(), java.lang.Integer.valueOf(aVar.c), java.lang.Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                oAuthErrCode3 = aVar.a;
                if (oAuthErrCode3 == com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK) {
                }
                return aVar;
            }
            com.tencent.mm.opensdk.utils.Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new com.tencent.mm.opensdk.diffdev.a.c.a();
            oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Auth_Stopped;
            aVar.a = oAuthErrCode;
            return aVar;
        }
        com.tencent.mm.opensdk.utils.Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
        aVar = new com.tencent.mm.opensdk.diffdev.a.c.a();
        oAuthErrCode = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr;
        aVar.a = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(com.tencent.mm.opensdk.diffdev.a.c.a aVar) {
        com.tencent.mm.opensdk.diffdev.a.c.a aVar2 = aVar;
        this.c.onAuthFinish(aVar2.a, aVar2.b);
    }
}
