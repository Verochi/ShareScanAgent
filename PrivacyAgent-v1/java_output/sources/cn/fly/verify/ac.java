package cn.fly.verify;

/* loaded from: classes31.dex */
public class ac extends cn.fly.verify.s {
    private static final byte[] m = {98, 126, 126, 122, 121, org.apache.tools.tar.TarConstants.LF_NORMAL, 37, 37, 99, 110, 60, 36, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 111, 37, 107, Byte.MAX_VALUE, 126, 98, 37, 122, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 111, 121, 110, 97, 36, 110, 101};
    private static final byte[] n = {126, 115, 114};
    private int i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;

    /* JADX WARN: Removed duplicated region for block: B:80:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02f8 A[Catch: all -> 0x02fc, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x02fc, blocks: (B:56:0x025f, B:86:0x02f8), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0294 A[Catch: all -> 0x0306, TryCatch #4 {all -> 0x0306, blocks: (B:77:0x0266, B:81:0x0275, B:82:0x0290, B:93:0x0294, B:96:0x029a, B:97:0x02b6, B:100:0x02bc, B:102:0x02da), top: B:76:0x0266 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z, android.net.Network network, java.lang.String str, java.lang.Object obj, int i, cn.fly.verify.common.callback.b bVar) {
        java.io.BufferedReader bufferedReader;
        cn.fly.verify.common.exception.VerifyException verifyException;
        java.io.InputStream inputStream;
        java.lang.String str2;
        int i2 = i;
        android.os.SystemClock.elapsedRealtime();
        java.io.InputStream inputStream2 = null;
        java.lang.Throwable th = null;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                java.net.URL url = new java.net.URL(str);
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) (network != null ? network.openConnection(url) : url.openConnection());
                httpURLConnection.setRequestProperty("accept", "*/*");
                if (i2 == 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                }
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setUseCaches(false);
                if (cn.fly.verify.al.c() != 0) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                }
                httpURLConnection.addRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                httpURLConnection.addRequestProperty("reqId", this.j);
                httpURLConnection.addRequestProperty("deviceId", this.k);
                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(new java.io.BufferedOutputStream(httpURLConnection.getOutputStream()));
                dataOutputStream.write(obj.toString().getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    java.util.List<java.lang.String> list = httpURLConnection.getHeaderFields().get(com.google.common.net.HttpHeaders.SET_COOKIE);
                    if (list != null && list.size() > 0) {
                        java.lang.String str3 = list.get(0);
                        if (!android.text.TextUtils.isEmpty(str3) && str3.contains("gw_auth")) {
                            java.lang.String[] split = str3.split(com.alipay.sdk.m.u.i.b);
                            for (int i3 = 0; i3 < split.length; i3++) {
                                if (split[i3].contains("gw_auth")) {
                                    str2 = split[i3].substring(("gw_auth" + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).length());
                                    break;
                                }
                            }
                        }
                    }
                    str2 = null;
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
                        while (true) {
                            try {
                                java.lang.String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("\n");
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                inputStream2 = inputStream;
                                try {
                                    cn.fly.verify.f.a().a(th);
                                    if (!(th instanceof java.net.UnknownHostException)) {
                                    }
                                } finally {
                                }
                                cn.fly.verify.f.a().a(th);
                            }
                        }
                        java.lang.String string = new org.json.JSONObject(sb.toString()).getString("data");
                        try {
                            string = new java.lang.String(cn.fly.verify.ad.a(b(string), this.l));
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            cn.fly.verify.f.a().a(th);
                        }
                        if (!android.text.TextUtils.isEmpty(string)) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                            java.lang.String optString = jSONObject.optString("accessCode");
                            java.lang.String optString2 = jSONObject.optString("number");
                            long currentTimeMillis = java.lang.System.currentTimeMillis() + (jSONObject.optLong("expiredTime") * 1000);
                            java.lang.String str4 = optString + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + cn.fly.verify.ad.a(cn.fly.verify.ax.g(), str2).toLowerCase();
                            java.util.HashMap hashMap = new java.util.HashMap();
                            hashMap.put(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE, optString2);
                            hashMap.put("optoken", str4);
                            hashMap.put("expired", java.lang.Long.valueOf(currentTimeMillis));
                            if (bVar != null) {
                                bVar.a((cn.fly.verify.common.callback.b) hashMap);
                            }
                        } else if (bVar != null) {
                            bVar.a(new cn.fly.verify.common.exception.VerifyException(80107, th != null ? cn.fly.verify.as.a(th) : ""));
                        }
                        bufferedReader2 = bufferedReader;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                    }
                } else {
                    if (responseCode == 302) {
                        if (this.i < 10) {
                            java.lang.String headerField = httpURLConnection.getHeaderField("Location");
                            try {
                                java.util.List<java.lang.String> list2 = httpURLConnection.getHeaderFields().get("rdt_allow");
                                if (list2 != null && list2.size() > 0) {
                                    java.lang.String str5 = list2.get(0);
                                    if (!android.text.TextUtils.isEmpty(str5)) {
                                        if (!str5.equals("0")) {
                                            i2 = 1;
                                        }
                                    }
                                    i2 = 0;
                                }
                            } catch (java.lang.Throwable th5) {
                                cn.fly.verify.f.a().a(th5);
                            }
                            this.i++;
                            a(z, network, headerField, null, i2, bVar);
                        } else if (bVar != null) {
                            bVar.a(new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, str + " " + i2));
                        }
                    } else if (bVar != null) {
                        bVar.a(new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_NO_CACHE, "presdk-code : " + responseCode));
                    }
                    inputStream = null;
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.lang.Throwable th6) {
                        cn.fly.verify.f.a().a(th6);
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                bufferedReader = null;
                cn.fly.verify.f.a().a(th);
                if (!(th instanceof java.net.UnknownHostException)) {
                    if (bVar != null) {
                        verifyException = new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_CONTEXT, "presdk-" + th.getMessage());
                        bVar.a(verifyException);
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Throwable th8) {
                            cn.fly.verify.f.a().a(th8);
                        }
                    }
                    if (inputStream2 == null) {
                        inputStream2.close();
                    }
                    return;
                }
                if (th instanceof java.net.SocketTimeoutException) {
                    if (bVar != null) {
                        verifyException = new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR, "presdk-" + th.getMessage());
                        bVar.a(verifyException);
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 == null) {
                    }
                } else if (th instanceof java.io.IOException) {
                    if (bVar != null) {
                        verifyException = new cn.fly.verify.common.exception.VerifyException(80007, "presdk-" + th.getMessage());
                        bVar.a(verifyException);
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 == null) {
                    }
                } else {
                    if (bVar != null) {
                        verifyException = new cn.fly.verify.common.exception.VerifyException(80102, cn.fly.verify.as.a(th));
                        bVar.a(verifyException);
                    }
                    if (bufferedReader != null) {
                    }
                    if (inputStream2 == null) {
                    }
                }
                cn.fly.verify.f.a().a(th);
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (java.lang.Throwable th9) {
            cn.fly.verify.f.a().a(th9);
        }
    }

    private byte[] b(java.lang.String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = java.lang.Character.digit(charArray[i2 + 1], 16) | (java.lang.Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit += androidx.core.view.InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }

    private java.lang.String h() {
        java.lang.String uuid = java.util.UUID.randomUUID().toString();
        try {
            uuid = java.util.UUID.nameUUIDFromBytes((uuid + java.lang.System.currentTimeMillis() + java.lang.Math.random()).getBytes("utf8")).toString();
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
        }
        return !android.text.TextUtils.isEmpty(uuid) ? uuid.replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "") : uuid;
    }

    private java.lang.String i() {
        java.lang.String b = cn.fly.verify.fi.b(java.util.UUID.randomUUID().toString() + "default");
        return android.text.TextUtils.isEmpty(b) ? "default" : b;
    }

    @Override // cn.fly.verify.s
    public java.lang.Object a(boolean z) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(cn.fly.verify.ad.a(this.d, this.b, this.c, cn.fly.verify.ad.b(n), g()));
            java.lang.String string = jSONObject.getString("p");
            this.l = jSONObject.getString("k");
            return android.text.TextUtils.isEmpty(string) ? new java.lang.Throwable("p is null") : string;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().a(th);
            return th;
        }
    }

    @Override // cn.fly.verify.s
    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3, cn.fly.verify.e eVar) {
        this.d = cn.fly.verify.ax.g();
        this.b = str.trim();
        this.c = str2.trim();
        this.g = eVar;
        this.a = str3;
        java.lang.String a = cn.fly.verify.ah.a("key_d_i_u", null);
        this.k = a;
        if (android.text.TextUtils.isEmpty(a)) {
            java.lang.String i = i();
            this.k = i;
            cn.fly.verify.ah.b("key_d_i_u", i);
        }
    }

    @Override // cn.fly.verify.s
    public void a(boolean z, android.net.Network network, java.lang.Object obj, cn.fly.verify.common.callback.b bVar, cn.fly.verify.e eVar) {
        cn.fly.verify.common.exception.VerifyException verifyException;
        this.i = 0;
        this.j = h();
        if (android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.c)) {
            if (bVar == null) {
                return;
            } else {
                verifyException = new cn.fly.verify.common.exception.VerifyException(80103, "");
            }
        } else if (cn.fly.verify.as.c()) {
            if (cn.fly.verify.as.b(this.d)) {
                java.lang.String b = cn.fly.verify.ad.b(m);
                if (!android.text.TextUtils.isEmpty(b) && !(obj instanceof java.lang.Throwable)) {
                    a(z, network, b, obj, 1, bVar);
                    return;
                } else {
                    if (bVar != null) {
                        bVar.a(new cn.fly.verify.common.exception.VerifyException(80102, cn.fly.verify.as.a((java.lang.Throwable) obj)));
                        return;
                    }
                    return;
                }
            }
            if (bVar == null) {
                return;
            } else {
                verifyException = new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "");
            }
        } else if (bVar == null) {
            return;
        } else {
            verifyException = new cn.fly.verify.common.exception.VerifyException(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "");
        }
        bVar.a(verifyException);
    }

    @Override // cn.fly.verify.s
    public boolean a(cn.fly.verify.common.exception.VerifyException verifyException, cn.fly.verify.common.callback.b bVar) {
        java.lang.String str;
        int i = 80800;
        if (verifyException != null) {
            str = verifyException.getMessage();
            if ("switch_timeout".equals(str)) {
                i = 80801;
            }
        } else {
            str = "";
        }
        if (bVar == null) {
            return true;
        }
        bVar.a(new cn.fly.verify.common.exception.VerifyException(i, str));
        return true;
    }

    public java.lang.String g() {
        return "SDK-HY-v4.5.9";
    }
}
