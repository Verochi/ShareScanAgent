package cn.fly.verify;

/* loaded from: classes.dex */
public class x {
    public static java.lang.String a = "AID";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String h;
    private android.net.Network i;
    private java.lang.String n;
    private java.lang.String d = "";
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String j = "";
    private byte[] k = new byte[0];
    private byte[] l = new byte[0];
    private java.lang.String m = "";
    private java.util.HashMap<java.lang.String, java.lang.String> o = new java.util.HashMap<>();

    public x(java.lang.String str, java.lang.String str2) {
        this.b = "";
        this.c = "";
        this.h = "";
        this.h = cn.fly.verify.ab.b();
        this.b = str;
        this.c = str2;
        this.o.put("CMCC", "1");
        this.o.put("CUCC", "2");
        this.o.put("CTCC", "3");
    }

    private org.json.JSONObject r() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("appid", this.b);
            jSONObject.put("traceId", this.h);
            jSONObject.put("appName", cn.fly.verify.al.i());
            jSONObject.put("appVersion", cn.fly.verify.fh.d.c() + "&" + cn.fly.verify.fh.d.f());
            jSONObject.put(com.heytap.mcssdk.constant.b.C, this.f);
            jSONObject.put("clientType", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            jSONObject.put("timeOut", "8000");
            jSONObject.put("requestTime", "");
            jSONObject.put("responseTime", "");
            jSONObject.put("elapsedTime", java.lang.System.currentTimeMillis() + "");
            jSONObject.put("requestType", "eventTracking5");
            jSONObject.put("interfaceType", "");
            jSONObject.put("interfaceCode", (java.lang.Object) null);
            jSONObject.put("interfaceElasped", (java.lang.Object) null);
            jSONObject.put("loginType", (java.lang.Object) null);
            jSONObject.put("exceptionStackTrace", (java.lang.Object) null);
            jSONObject.put("operatorType", this.o.get(cn.fly.verify.as.b()));
            jSONObject.put("networkType", t());
            jSONObject.put("brand", cn.fly.verify.fh.d.l());
            jSONObject.put("reqDevice", cn.fly.verify.fh.d.j());
            jSONObject.put("reqSystem", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE);
            jSONObject.put("simCardNum", "");
            jSONObject.put("imsiState", "0");
            jSONObject.put("resultCode", (java.lang.Object) null);
            jSONObject.put("AID", (java.lang.Object) null);
            jSONObject.put("sysOperType", (java.lang.Object) null);
            jSONObject.put("scripType", (java.lang.Object) null);
            jSONObject.put("event", s());
            jSONObject.put("exceptionStackTrace", (java.lang.Object) null);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    private org.json.JSONObject s() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("authPageOut", "1");
            jSONObject.put("authPageIn", "1");
            jSONObject.put("authClickSuccess", "1");
            jSONObject.put("timeOnAuthPage", java.lang.String.valueOf(new java.util.Random().nextInt(5000) + 800));
            jSONObject.put("authClickFailed", "0");
            jSONObject.put("authPrivacyState", "1");
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    private int t() {
        java.lang.String j = cn.fly.verify.al.j();
        if (!android.text.TextUtils.isEmpty(j) && !"none".equalsIgnoreCase(j)) {
            boolean b = cn.fly.verify.as.b(cn.fly.verify.ax.g());
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j) && b) {
                return 3;
            }
            if (com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI.equalsIgnoreCase(j) && !b) {
                return 2;
            }
            if (b) {
                return 1;
            }
        }
        return 0;
    }

    private java.lang.String u() {
        java.lang.String a2 = cn.fly.verify.ah.a(a, null);
        if (!android.text.TextUtils.isEmpty(a2)) {
            return a2;
        }
        java.lang.String str = "%" + cn.fly.verify.ab.a();
        cn.fly.verify.ah.b(a, str);
        return str;
    }

    public java.lang.String a() {
        return this.h;
    }

    public void a(android.net.Network network) {
        this.i = network;
    }

    public void a(java.lang.String str) {
        this.h = str;
    }

    public java.lang.String b() {
        return this.j;
    }

    public void b(java.lang.String str) {
        this.j = str;
    }

    public android.net.Network c() {
        return this.i;
    }

    public void c(java.lang.String str) {
        this.g = str;
    }

    public java.lang.String d() {
        return this.g;
    }

    public void d(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String e() {
        org.json.JSONObject jSONObject;
        java.lang.String str;
        java.lang.String str2;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            java.lang.String str3 = this.o.get(cn.fly.verify.as.b());
            int t = t();
            java.lang.String encode = java.net.URLEncoder.encode(cn.fly.verify.fh.d.l());
            java.lang.String encode2 = java.net.URLEncoder.encode(cn.fly.verify.fh.d.j());
            java.lang.String encode3 = java.net.URLEncoder.encode(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE);
            java.lang.String format = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date(java.lang.System.currentTimeMillis()));
            java.lang.String c = cn.fly.verify.fh.d.c();
            java.lang.String upperCase = cn.fly.verify.al.a().toUpperCase();
            java.lang.String[] a2 = cn.fly.verify.aa.a(true);
            if (a2 == null || a2.length <= 0) {
                str = "";
                str2 = str;
            } else {
                str2 = a2[0];
                str = a2[1];
            }
            try {
                java.lang.String a3 = cn.fly.verify.ab.a();
                java.lang.String b = cn.fly.verify.fi.b(this.f + this.b + "" + str3 + t + encode + encode2 + encode3 + "0" + a3 + format + this.c + "" + c + upperCase + str2 + str + "001" + u() + this.d + com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE + "authz" + this.e);
                java.lang.String str4 = str;
                java.lang.String str5 = str2;
                jSONObject = jSONObject2;
                try {
                    jSONObject.put("ver", "1.0");
                    jSONObject.put("sdkver", this.f);
                    jSONObject.put("appid", this.b);
                    jSONObject.put("imsi", "");
                    jSONObject.put("operatortype", str3);
                    jSONObject.put("networktype", t);
                    jSONObject.put("mobilebrand", encode);
                    jSONObject.put("mobilemodel", encode2);
                    jSONObject.put("mobilesystem", encode3);
                    jSONObject.put("clienttype", "0");
                    jSONObject.put("interfacever", "3.0");
                    jSONObject.put("expandparams", "");
                    jSONObject.put("msgid", a3);
                    jSONObject.put("timestamp", format);
                    jSONObject.put("subimsi", "");
                    jSONObject.put("sign", b);
                    jSONObject.put("apppackage", c);
                    jSONObject.put("appsign", upperCase);
                    jSONObject.put("ipv4_list", str5);
                    jSONObject.put("ipv6_list", str4);
                    jSONObject.put("sdkType", "001");
                    jSONObject.put("tempPDR", u());
                    jSONObject.put("scrip", this.d);
                    jSONObject.put("userCapaid", com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE);
                    jSONObject.put("funcType", "authz");
                    jSONObject.put("socketip", this.e);
                } catch (org.json.JSONException unused) {
                }
            } catch (org.json.JSONException unused2) {
                jSONObject = jSONObject2;
            }
        } catch (org.json.JSONException unused3) {
            jSONObject = jSONObject2;
        }
        return jSONObject.toString();
    }

    public void e(java.lang.String str) {
        this.e = str;
    }

    public java.lang.String f() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        try {
            java.lang.String u = u();
            java.lang.String str4 = this.o.get(cn.fly.verify.as.b());
            int t = t();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                this.k = java.util.UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (java.lang.Exception unused) {
            }
            jSONObject.put("encrypted", cn.fly.verify.y.a().a(this.k));
            byte[] a2 = cn.fly.verify.w.a();
            this.l = a2;
            jSONObject.put("encryptedIV", android.util.Base64.encodeToString(a2, 0));
            java.lang.String encode = java.net.URLEncoder.encode(cn.fly.verify.fh.d.l());
            java.lang.String encode2 = java.net.URLEncoder.encode(cn.fly.verify.fh.d.j());
            java.lang.String encode3 = java.net.URLEncoder.encode(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM + android.os.Build.VERSION.RELEASE);
            java.lang.String a3 = cn.fly.verify.ab.a();
            java.lang.String format = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date(java.lang.System.currentTimeMillis()));
            java.lang.String c = cn.fly.verify.fh.d.c();
            java.lang.String upperCase = cn.fly.verify.al.a().toUpperCase();
            java.lang.String[] a4 = cn.fly.verify.aa.a(true);
            if (a4 != null) {
                str = "pre";
                if (a4.length > 0) {
                    str2 = a4[0];
                    str3 = a4[1];
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(this.f);
                    sb.append(this.b);
                    sb.append("");
                    sb.append(str4);
                    sb.append(t);
                    sb.append(encode);
                    sb.append(encode2);
                    sb.append(encode3);
                    sb.append("0");
                    sb.append(a3);
                    sb.append(format);
                    sb.append(this.c);
                    sb.append("");
                    sb.append(c);
                    sb.append(upperCase);
                    sb.append(str2);
                    sb.append(str3);
                    sb.append("001");
                    sb.append(u);
                    sb.append(this.d);
                    sb.append("");
                    java.lang.String str5 = str;
                    sb.append(str5);
                    sb.append(this.e);
                    jSONObject.put("reqdata", cn.fly.verify.w.a(this.k, "1.0&" + this.f + "&" + this.b + "&&" + str4 + "&" + t + "&" + encode + "&" + encode2 + "&" + encode3 + "&0&3.0&&" + a3 + "&" + format + "&&" + cn.fly.verify.fi.b(sb.toString()) + "&" + c + "&" + upperCase + "&&" + str2 + "&" + str3 + "&001&" + u + "&" + this.d + "&&" + str5 + "&" + this.e, this.l));
                    jSONObject.put("securityreinforce", "");
                    return jSONObject.toString();
                }
            } else {
                str = "pre";
            }
            str2 = "";
            str3 = str2;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(this.f);
            sb2.append(this.b);
            sb2.append("");
            sb2.append(str4);
            sb2.append(t);
            sb2.append(encode);
            sb2.append(encode2);
            sb2.append(encode3);
            sb2.append("0");
            sb2.append(a3);
            sb2.append(format);
            sb2.append(this.c);
            sb2.append("");
            sb2.append(c);
            sb2.append(upperCase);
            sb2.append(str2);
            sb2.append(str3);
            sb2.append("001");
            sb2.append(u);
            sb2.append(this.d);
            sb2.append("");
            java.lang.String str52 = str;
            sb2.append(str52);
            sb2.append(this.e);
            jSONObject.put("reqdata", cn.fly.verify.w.a(this.k, "1.0&" + this.f + "&" + this.b + "&&" + str4 + "&" + t + "&" + encode + "&" + encode2 + "&" + encode3 + "&0&3.0&&" + a3 + "&" + format + "&&" + cn.fly.verify.fi.b(sb2.toString()) + "&" + c + "&" + upperCase + "&&" + str2 + "&" + str3 + "&001&" + u + "&" + this.d + "&&" + str52 + "&" + this.e, this.l));
            jSONObject.put("securityreinforce", "");
            return jSONObject.toString();
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    public void f(java.lang.String str) {
        this.f = str;
    }

    public java.lang.String g() {
        org.json.JSONObject i = i();
        try {
            i.put("data", this.m);
            i.put("funcType", "pre");
        } catch (org.json.JSONException unused) {
        }
        return i.toString();
    }

    public void g(java.lang.String str) {
        this.m = str;
    }

    public java.lang.String h() {
        org.json.JSONObject i = i();
        try {
            i.put("data", this.m);
            i.put("funcType", "authz");
        } catch (org.json.JSONException unused) {
        }
        return i.toString();
    }

    public void h(java.lang.String str) {
        this.n = str;
    }

    public org.json.JSONObject i() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("ver", "1.0");
            jSONObject.put("userCapaid", "");
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public java.lang.String j() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("version", "1.0");
            jSONObject.put("apptype", "Android");
            jSONObject.put("phone_ID", u());
            jSONObject.put("certflag", "0");
            jSONObject.put("sdkversion", this.f);
            jSONObject.put("appid", this.b);
            jSONObject.put("expandparams", "");
            jSONObject.put("sign", cn.fly.verify.fi.b("1.0" + this.f + this.b + "iYm0HAnkxQtpvN44"));
        } catch (org.json.JSONException unused) {
        }
        return jSONObject.toString();
    }

    public java.lang.String k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            java.lang.String a2 = cn.fly.verify.ab.a();
            java.lang.String format = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date(java.lang.System.currentTimeMillis()));
            jSONObject2.put("sign", cn.fly.verify.fi.b("2.0" + this.b + format + a2 + "@Fdiwmxy7CBDDQNUI"));
            jSONObject2.put("msgid", a2);
            jSONObject2.put("systemtime", format);
            jSONObject2.put("appid", this.b);
            jSONObject2.put("version", "2.0");
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", r());
            jSONObject.put("body", jSONObject3);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public byte[] l() {
        return this.k;
    }

    public byte[] m() {
        return this.l;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> n() {
        java.util.HashMap<java.lang.String, java.lang.String> p = p();
        p.put("defendEOF", "1");
        return p;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> o() {
        java.util.HashMap<java.lang.String, java.lang.String> p = p();
        p.put("defendEOF", "0");
        return p;
    }

    public java.util.HashMap<java.lang.String, java.lang.String> p() {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(com.heytap.mcssdk.constant.b.C, this.f);
        hashMap.put("Content-Type", com.baidu.mobads.sdk.internal.am.d);
        hashMap.put("CMCC-EncryptType", "STD");
        hashMap.put("traceId", this.h);
        hashMap.put("appid", this.b);
        hashMap.put("connection", com.anythink.expressad.foundation.g.f.g.b.c);
        hashMap.put("interfaceVersion", "3.0");
        return hashMap;
    }

    public java.lang.String q() {
        return this.n;
    }
}
