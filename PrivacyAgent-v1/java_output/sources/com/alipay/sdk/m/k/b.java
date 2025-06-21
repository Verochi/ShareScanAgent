package com.alipay.sdk.m.k;

/* loaded from: classes.dex */
public class b {
    public static final java.lang.String A = "SSLDenied";
    public static final java.lang.String A0 = "out_trade_no";
    public static final java.lang.String B = "H5PayDataAnalysisError";
    public static final java.lang.String B0 = "trade_no";
    public static final java.lang.String C = "H5AuthDataAnalysisError";
    public static final java.lang.String C0 = "biz_content";
    public static final java.lang.String D = "PublicKeyUnmatch";
    public static final java.lang.String D0 = "app_id";
    public static final java.lang.String E = "ClientBindFailed";
    public static final java.lang.String F = "TriDesEncryptError";
    public static final java.lang.String G = "TriDesDecryptError";
    public static final java.lang.String H = "ClientBindException";
    public static final java.lang.String I = "SaveTradeTokenError";
    public static final java.lang.String J = "ClientBindServiceFailed";
    public static final java.lang.String K = "TryStartServiceEx";
    public static final java.lang.String L = "BindWaitTimeoutEx";
    public static final java.lang.String M = "CheckClientExistEx";
    public static final java.lang.String N = "CheckClientSignEx";
    public static final java.lang.String O = "GetInstalledAppEx";
    public static final java.lang.String P = "ParserTidClientKeyEx";
    public static final java.lang.String Q = "PgApiInvoke";
    public static final java.lang.String R = "PgBindStarting";
    public static final java.lang.String S = "PgBinded";
    public static final java.lang.String T = "PgBindEnd";
    public static final java.lang.String U = "PgBindPay";
    public static final java.lang.String V = "PgReturn";
    public static final java.lang.String W = "PgReturnV";
    public static final java.lang.String X = "PgWltVer";
    public static final java.lang.String Y = "PgOpenStarting";
    public static final java.lang.String Z = "ErrIntentEx";
    public static final java.lang.String a0 = "ErrActNull";
    public static final java.lang.String b0 = "ErrActEx";
    public static final java.lang.String c0 = "ErrActNull2";
    public static final java.lang.String d0 = "ErrActEx2";
    public static final java.lang.String e0 = "ErrActNotCreated";
    public static final java.lang.String f0 = "GetInstalledAppEx";
    public static final java.lang.String g0 = "StartLaunchAppTransEx";
    public static final java.lang.String h0 = "CheckLaunchAppExistEx";
    public static final java.lang.String i0 = "LogBindCalledH5";
    public static final java.lang.String j0 = "LogCalledH5";
    public static final java.lang.String k = "net";
    public static final java.lang.String k0 = "LogHkLoginByIntent";
    public static final java.lang.String l = "biz";
    public static final java.lang.String l0 = "SchemePayWrongHashEx";
    public static final java.lang.String m = "cp";
    public static final java.lang.String m0 = "LogAppFetchConfigTimeout";
    public static final java.lang.String n = "auth";
    public static final java.lang.String n0 = "H5CbUrlEmpty";
    public static final java.lang.String o = "third";
    public static final java.lang.String o0 = "H5CbEx";
    public static final java.lang.String p = "wlt";
    public static final java.lang.String p0 = "StartActivityEx";
    public static final java.lang.String q = "FormatResultEx";
    public static final java.lang.String q0 = "JSONEx";
    public static final java.lang.String r = "GetApdidEx";
    public static final java.lang.String r0 = "ParseBundleSerializableError";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f81s = "GetApdidNull";
    public static final java.lang.String s0 = "ParseSchemeQueryError";
    public static final java.lang.String t = "GetApdidTimeout";
    public static final java.lang.String t0 = "TbChk";
    public static final java.lang.String u = "GetUtdidEx";
    public static final java.lang.String u0 = "TbStart";
    public static final java.lang.String v = "GetPackageInfoEx";
    public static final java.lang.String v0 = "TbCancel";
    public static final java.lang.String w = "NotIncludeSignatures";
    public static final java.lang.String w0 = "TbUnknown";
    public static final java.lang.String x = "GetPublicKeyFromSignEx";
    public static final java.lang.String x0 = "TbOk";
    public static final java.lang.String y = "webError";
    public static final java.lang.String y0 = "TbActFail";
    public static final java.lang.String z = "SSLError";
    public static final java.lang.String z0 = "partner";
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h = "";
    public java.lang.String i = "";
    public java.lang.String j;

    public b(android.content.Context context, boolean z2) {
        context = context != null ? context.getApplicationContext() : context;
        this.a = b();
        this.c = a(context);
        this.d = a(z2 ? 0L : com.alipay.sdk.m.k.a.e.a(context));
        this.e = a();
        this.f = b(context);
        this.g = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        this.j = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
    }

    public static java.lang.String a() {
        return java.lang.String.format("%s,%s,-,-,-", c(com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).d()), c(com.alipay.sdk.m.s.b.d().c()));
    }

    public static java.lang.String a(long j) {
        return java.lang.String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", c("15.8.11"), c("h.a.3.8.11"), com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + j);
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String packageName;
        java.lang.String str = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        if (context != null) {
            try {
                android.content.Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    android.content.pm.PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str = packageInfo.versionName + "|" + a(packageInfo);
                } catch (java.lang.Throwable unused) {
                }
            } catch (java.lang.Throwable unused2) {
            }
            return java.lang.String.format("%s,%s,-,-,-", c(packageName), c(str));
        }
        packageName = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        return java.lang.String.format("%s,%s,-,-,-", c(packageName), c(str));
    }

    public static java.lang.String a(android.content.pm.PackageInfo packageInfo) {
        android.content.pm.Signature[] signatureArr;
        java.lang.String str;
        java.lang.String a;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(packageInfo.signatures.length);
            for (android.content.pm.Signature signature : packageInfo.signatures) {
                try {
                    a = com.alipay.sdk.m.u.n.a((com.alipay.sdk.m.s.a) null, signature.toByteArray());
                } catch (java.lang.Throwable unused) {
                }
                if (android.text.TextUtils.isEmpty(a)) {
                    str = "?";
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(str);
                } else {
                    str = com.alipay.sdk.m.u.n.g(a).substring(0, 8);
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(str);
                }
            }
            return sb.toString();
        } catch (java.lang.Throwable unused2) {
            return "?";
        }
    }

    public static java.lang.String a(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            stringBuffer.append(th.getMessage());
            stringBuffer.append(" 》 ");
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int i = 0;
                for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i++;
                    if (i > 5) {
                        break;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @android.annotation.SuppressLint({"SimpleDateFormat"})
    public static java.lang.String b() {
        return java.lang.String.format("%s,%s", e(), new java.text.SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new java.util.Date()));
    }

    public static java.lang.String b(android.content.Context context) {
        return java.lang.String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", c(com.alipay.sdk.m.u.c.c(context)), com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM, c(android.os.Build.VERSION.RELEASE), c(android.os.Build.MODEL), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "0", c(com.alipay.sdk.m.u.c.d(context).b()), "gw", c(com.alipay.sdk.m.w.b.b(null, context)));
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        if (str == null) {
            str = "";
        }
        java.lang.String[] split = str.split("&");
        java.lang.String str4 = null;
        if (split != null) {
            str2 = null;
            str3 = null;
            for (java.lang.String str5 : split) {
                java.lang.String[] split2 = str5.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase("partner")) {
                        str4 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(A0)) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(B0)) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(C0)) {
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(com.alipay.sdk.m.u.n.e(com.alipay.sdk.m.s.a.h(), split2[1]));
                            if (android.text.TextUtils.isEmpty(str2)) {
                                str2 = jSONObject.getString(A0);
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                    } else if (split2[0].equalsIgnoreCase("app_id") && android.text.TextUtils.isEmpty(str4)) {
                        str4 = split2[1];
                    }
                }
            }
        } else {
            str2 = null;
            str3 = null;
        }
        return java.lang.String.format("%s,%s,-,%s,-,-,-", c(str3), c(str2), c(str4));
    }

    public static java.lang.String c() {
        return new java.text.SimpleDateFormat("HH:mm:ss:SSS", java.util.Locale.getDefault()).format(new java.util.Date());
    }

    public static java.lang.String c(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR).replace("#", "＃");
    }

    private synchronized void c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, java.lang.String.format("event %s %s %s", str, str2, str3));
        java.lang.String str4 = "";
        if (!android.text.TextUtils.isEmpty(this.h)) {
            str4 = "^";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str4);
        java.lang.Object[] objArr = new java.lang.Object[4];
        objArr[0] = android.text.TextUtils.isEmpty(str) ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : c(str);
        objArr[1] = c(str2);
        objArr[2] = c(str3);
        objArr[3] = c(c());
        sb.append(java.lang.String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.h += sb.toString();
    }

    public static java.lang.String d(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : str;
    }

    private synchronized void d(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alipay.sdk.m.u.e.c(com.alipay.sdk.m.l.a.z, java.lang.String.format("err %s %s %s", str, str2, str3));
        java.lang.String str4 = "";
        if (!android.text.TextUtils.isEmpty(this.i)) {
            str4 = "^";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str4);
        java.lang.Object[] objArr = new java.lang.Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = android.text.TextUtils.isEmpty(str3) ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : c(str3);
        objArr[3] = c(c());
        sb.append(java.lang.String.format("%s,%s,%s,%s", objArr));
        this.i += sb.toString();
    }

    private boolean d() {
        return android.text.TextUtils.isEmpty(this.i);
    }

    public static java.lang.String e() {
        try {
            return java.util.UUID.randomUUID().toString();
        } catch (java.lang.Throwable unused) {
            return "12345678uuid";
        }
    }

    public java.lang.String a(java.lang.String str) {
        java.lang.String b = b(str);
        this.b = b;
        return java.lang.String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.a, b, this.c, this.d, this.e, this.f, this.g, d(this.h), d(this.i), this.j);
    }

    public void a(java.lang.String str, java.lang.String str2) {
        c("", str, str2);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        c("", str, str2 + "|" + str3);
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        d(str, str2, a(th));
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th, java.lang.String str3) {
        d(str, str2, str3 + ": " + a(th));
    }

    public void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        d(str, str2, str3);
    }
}
