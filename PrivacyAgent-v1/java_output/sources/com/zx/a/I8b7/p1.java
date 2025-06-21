package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class p1 {
    public static java.lang.String a = "";
    public static javax.crypto.SecretKey c;
    public static byte[] d;
    public static java.util.LinkedList<java.lang.String> b = new java.util.LinkedList<>();
    public static final java.security.SecureRandom e = new java.security.SecureRandom();

    public static java.lang.String a(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        java.lang.String substring;
        if (jSONObject == null || !jSONObject.has(str) || android.text.TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            int i = jSONObject.getInt(str);
            if (i == 1) {
                return new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(str2, c, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8);
            }
            if (i == 2) {
                substring = com.zx.a.I8b7.p.a(str2, "MD5").substring(0, 20);
            } else {
                if (i != 3) {
                    return str2;
                }
                java.lang.String a2 = com.zx.a.I8b7.p.a(str2, "MD5");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(a2.substring(0, 20));
                android.content.pm.PackageManager packageManager = com.zx.a.I8b7.w3.a;
                sb.append(android.os.Build.MODEL);
                substring = sb.toString();
            }
            return com.zx.a.I8b7.p.a(substring, "MD5");
        } catch (java.lang.Exception e2) {
            com.zx.a.I8b7.r2.b("加密脱敏失败:" + str + ",error:" + e2);
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, org.json.JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.isNull(str)) ? "" : jSONObject.optString(str);
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a() throws org.json.JSONException {
        org.json.JSONObject jSONObject = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.x) ? new org.json.JSONObject(com.zx.a.I8b7.m3.x) : new org.json.JSONObject();
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("lv1");
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("lv2");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return new java.util.HashMap<>();
        }
        if (optJSONObject == null) {
            java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                java.lang.String string = optJSONArray.getString(i);
                hashMap.put(string, "99".equals(string) ? com.zx.a.I8b7.u0.a() : com.zx.a.I8b7.w3.a(string));
            }
            return hashMap;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            java.lang.String string2 = optJSONArray.getString(i2);
            java.lang.String a2 = "99".equals(string2) ? com.zx.a.I8b7.u0.a() : com.zx.a.I8b7.w3.a(string2);
            if (!android.text.TextUtils.isEmpty(a2) && optJSONObject.has(string2)) {
                string2.getClass();
                switch (string2) {
                    case "48":
                    case "49":
                    case "98":
                        java.lang.String[] split = a2.split("#");
                        java.util.HashMap hashMap3 = new java.util.HashMap();
                        for (java.lang.String str : split) {
                            java.lang.String str2 = str.split(",")[0];
                            hashMap3.put(str2, str.substring(str2.length() + 1));
                        }
                        org.json.JSONObject jSONObject2 = optJSONObject.getJSONObject(string2);
                        java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            java.lang.String next = keys.next();
                            try {
                                java.lang.String str3 = string2 + "." + next;
                                java.lang.String str4 = (java.lang.String) hashMap3.get(com.zx.a.I8b7.p.a(jSONObject2.getString(next), true));
                                hashMap2.put(str3, str4);
                                if (!android.text.TextUtils.isEmpty(str4)) {
                                    b.add(str3);
                                }
                            } catch (java.lang.Throwable th) {
                                com.zx.a.I8b7.r2.a(th);
                            }
                        }
                        break;
                }
            }
            hashMap2.put(string2, a2);
        }
        return hashMap2;
    }

    public static org.json.JSONObject a(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> hashMap, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String a2 = a(string, hashMap.get(string), jSONObject);
                if (a2 == null) {
                    a2 = "";
                }
                jSONObject2.put(string, a2);
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("ZXID handleType1 error:");
                a3.append(e2.getMessage());
                com.zx.a.I8b7.r2.b(a3.toString());
            }
        }
        return jSONObject2;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native void a(org.json.JSONObject jSONObject) throws java.lang.Throwable;

    public static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            return !android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.D) ? new org.json.JSONObject(com.zx.a.I8b7.m3.D) : jSONObject;
        } catch (org.json.JSONException e2) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("ZXID buildOldLv1 error:");
            a2.append(e2.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
            return jSONObject;
        }
    }

    public static org.json.JSONObject b(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> hashMap, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject b2 = b();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String str = hashMap.get(string);
                java.lang.String str2 = "";
                if (str == null) {
                    str = "";
                }
                if (!android.text.TextUtils.equals(a(string, b2), str)) {
                    java.lang.String a2 = a(string, str, jSONObject);
                    if (a2 != null) {
                        str2 = a2;
                    }
                    jSONObject2.put(string, str2);
                }
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("ZXID handleType2 error:");
                a3.append(e2.getMessage());
                com.zx.a.I8b7.r2.b(a3.toString());
            }
        }
        return jSONObject2;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native void b(org.json.JSONObject jSONObject) throws java.lang.Throwable;

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String c();

    public static org.json.JSONObject c(org.json.JSONArray jSONArray, java.util.HashMap<java.lang.String, java.lang.String> hashMap, org.json.JSONObject jSONObject) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        org.json.JSONObject b2 = b();
        int i = 0;
        while (true) {
            java.lang.String str = "";
            if (i >= jSONArray.length()) {
                break;
            }
            try {
                java.lang.String string = jSONArray.getString(i);
                java.lang.String str2 = hashMap.get(string);
                if (str2 == null) {
                    str2 = "";
                }
                java.lang.String a2 = a(string, str2, jSONObject);
                if (a2 != null) {
                    str = a2;
                }
                jSONObject2.put(string, str);
                stringBuffer.append(str2);
                stringBuffer.append("|");
                stringBuffer2.append(a(string, b2));
                stringBuffer2.append("|");
            } catch (org.json.JSONException e2) {
                java.lang.StringBuilder a3 = com.zx.a.I8b7.f3.a("ZXID handleType3 error:");
                a3.append(e2.getMessage());
                com.zx.a.I8b7.r2.b(a3.toString());
            }
            i++;
        }
        java.util.Iterator<java.lang.String> it = b.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            try {
                java.lang.String str3 = hashMap.get(next);
                if (str3 == null) {
                    str3 = "";
                }
                java.lang.String a4 = a(next, str3, jSONObject);
                if (a4 == null) {
                    a4 = "";
                }
                jSONObject2.put(next, a4);
                stringBuffer.append(str3);
                stringBuffer.append("|");
                stringBuffer2.append(a(next, b2));
                stringBuffer2.append("|");
            } catch (org.json.JSONException e3) {
                java.lang.StringBuilder a5 = com.zx.a.I8b7.f3.a("ZXID handleType3 childIndex error:");
                a5.append(e3.getMessage());
                com.zx.a.I8b7.r2.b(a5.toString());
            }
        }
        return android.text.TextUtils.equals(com.zx.a.I8b7.p.a(stringBuffer.toString(), "SHA256"), com.zx.a.I8b7.p.a(stringBuffer2.toString(), "SHA256")) ? new org.json.JSONObject() : jSONObject2;
    }

    public static org.json.JSONObject d() {
        org.json.JSONObject a2;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            b.clear();
            java.util.HashMap<java.lang.String, java.lang.String> a3 = a();
            com.zx.a.I8b7.m3.E = new org.json.JSONObject(a3).toString();
            org.json.JSONObject jSONObject2 = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.y) ? new org.json.JSONObject(com.zx.a.I8b7.m3.y) : new org.json.JSONObject();
            org.json.JSONObject jSONObject3 = !android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.z) ? new org.json.JSONObject(com.zx.a.I8b7.m3.z) : new org.json.JSONObject();
            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                org.json.JSONObject jSONObject4 = jSONObject2.getJSONObject(next);
                int i = jSONObject4.getInt("type");
                org.json.JSONArray jSONArray = jSONObject4.getJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
                if (i == 1) {
                    a2 = a(jSONArray, a3, jSONObject3);
                } else if (i == 2) {
                    a2 = b(jSONArray, a3, jSONObject3);
                } else if (i == 3) {
                    a2 = c(jSONArray, a3, jSONObject3);
                }
                jSONObject.put(next, a2);
            }
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder a4 = com.zx.a.I8b7.f3.a("ZXID 获取data参数异常:");
            a4.append(th.getMessage());
            com.zx.a.I8b7.r2.b(a4.toString());
        }
        return jSONObject;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String e();

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c9, code lost:
    
        if (r7.length() > 0) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f() throws java.lang.Throwable {
        org.json.JSONObject jSONObject;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        java.lang.Runnable l1Var;
        org.json.JSONArray optJSONArray;
        if (com.zx.a.I8b7.c0.a()) {
            return;
        }
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(c());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/channel/report");
        a2.b = "POST";
        com.zx.a.I8b7.x0 b3 = com.zx.a.I8b7.x0.b("application/json; charset=utf-8");
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        jSONObject3.put("syncId", com.zx.a.I8b7.m3.n);
        jSONObject3.put("lid", com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
        jSONObject3.put(com.umeng.analytics.pro.bo.al, com.zx.a.I8b7.m3.i);
        jSONObject2.put("ctx", jSONObject3);
        jSONObject2.put(com.alipay.sdk.m.x.d.D, com.zx.a.I8b7.i0.d());
        jSONObject2.put("deviceInfo", com.zx.a.I8b7.i0.b());
        com.zx.a.I8b7.y yVar = com.zx.a.I8b7.y.b.a;
        yVar.getClass();
        org.json.JSONObject jSONObject4 = new org.json.JSONObject();
        try {
            jSONObject4.put(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, yVar.a);
        } catch (java.lang.Exception e2) {
            com.zx.a.I8b7.r2.a(e2);
        }
        jSONObject2.put("events", jSONObject4);
        com.zx.a.I8b7.y yVar2 = com.zx.a.I8b7.y.b.a;
        yVar2.getClass();
        org.json.JSONObject jSONObject5 = new org.json.JSONObject();
        try {
            jSONObject5.put(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, yVar2.b);
        } catch (java.lang.Exception e3) {
            com.zx.a.I8b7.r2.a(e3);
        }
        if (jSONObject5.length() > 0 && (optJSONArray = jSONObject5.optJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) != null && optJSONArray.length() > 0) {
            jSONObject2.put(androidx.core.app.NotificationCompat.CATEGORY_ERROR, jSONObject5);
        }
        try {
            java.lang.String a3 = com.zx.a.I8b7.l2.a.a.a.a(322);
            if (!android.text.TextUtils.isEmpty(a3)) {
                jSONObject = new org.json.JSONObject(a3);
            }
        } catch (java.lang.Throwable unused) {
        }
        jSONObject = null;
        jSONObject2.put(com.alipay.sdk.m.k.b.n, jSONObject);
        org.json.JSONObject jSONObject6 = new org.json.JSONObject();
        jSONObject6.put("ood", com.zx.a.I8b7.w3.a("62"));
        b(jSONObject6);
        if (com.zx.a.I8b7.m3.k != null && com.zx.a.I8b7.m3.k.length() > 0) {
            jSONObject6.put("reqBZ", com.zx.a.I8b7.m3.k);
        }
        a(jSONObject6);
        jSONObject2.put("extensionInfo", jSONObject6);
        org.json.JSONObject jSONObject7 = new org.json.JSONObject();
        try {
            jSONObject7.put("data", d());
            jSONObject7.put("unauthorizedFields", new org.json.JSONArray());
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder a4 = com.zx.a.I8b7.f3.a("ZXID getReportData error:");
            a4.append(th.getMessage());
            com.zx.a.I8b7.r2.b(a4.toString());
        }
        jSONObject2.put("reportData", jSONObject7);
        a2.d = com.zx.a.I8b7.s1.a(b3, new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(jSONObject2.toString(), c, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        a2.e = "request zxid api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a5 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a5.b != 200) {
            throw new java.lang.RuntimeException("response errCode: " + a5.a("Udid-Error-Code") + ", errMsg: " + a5.a("Udid-Error-Message"));
        }
        com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
        com.zx.a.I8b7.u3 u3Var = l2Var.a;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        u3Var.getClass();
        if (currentTimeMillis != com.zx.a.I8b7.m3.u) {
            com.zx.a.I8b7.m3.u = currentTimeMillis;
            com.zx.a.I8b7.u3 u3Var2 = l2Var.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.zx.a.I8b7.m3.u);
            u3Var2.a(8, sb.toString(), false);
            com.zx.a.I8b7.r2.a("lastRequestTime had changed refresh:" + com.zx.a.I8b7.m3.u);
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            com.zx.a.I8b7.u3 u3Var3 = l2Var.a;
            java.lang.String str = a;
            u3Var3.getClass();
            if (!android.text.TextUtils.equals(str, com.zx.a.I8b7.m3.m)) {
                com.zx.a.I8b7.m3.m = str;
                l2Var.a.a(28, str, true);
                com.zx.a.I8b7.r2.a("lastReportExtListMD5 had changed refresh:" + com.zx.a.I8b7.m3.m);
            }
            a = "";
        }
        com.zx.a.I8b7.y yVar3 = com.zx.a.I8b7.y.b.a;
        yVar3.getClass();
        yVar3.a(new com.zx.a.I8b7.a0(yVar3));
        yVar3.a(new com.zx.a.I8b7.b0(yVar3));
        l2Var.a.getClass();
        l2Var.a.a(322, "", true);
        l2Var.a.getClass();
        com.zx.a.I8b7.m3.k = new org.json.JSONArray();
        l2Var.a.a(63, com.zx.a.I8b7.m3.k.toString(), true);
        com.zx.a.I8b7.v3.f.a.e.execute(new com.zx.a.I8b7.k1());
        org.json.JSONObject jSONObject8 = new org.json.JSONObject(a5.e.b());
        l2Var.a.d(jSONObject8.getInt("syncId"));
        org.json.JSONObject jSONObject9 = new org.json.JSONObject(com.zx.a.I8b7.p.a(android.util.Base64.decode(jSONObject8.getString("data"), 2), c, "UDID_ENC_AUTHTAG"));
        java.lang.String string = jSONObject9.getString(com.umeng.analytics.pro.bo.al);
        l2Var.a.getClass();
        if (!android.text.TextUtils.equals(string, com.zx.a.I8b7.m3.i)) {
            com.zx.a.I8b7.m3.i = string;
            l2Var.a.a(1, string, true);
            com.zx.a.I8b7.r2.a("zid had changed refresh:".concat(java.lang.String.valueOf(string)));
        }
        org.json.JSONObject optJSONObject = jSONObject9.optJSONObject("aids");
        org.json.JSONObject optJSONObject2 = jSONObject9.optJSONObject("aidsExt");
        if (optJSONObject2 == null) {
            optJSONObject2 = new org.json.JSONObject();
        }
        if (!android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.f) && optJSONObject != null) {
            optJSONObject2.put(com.zx.a.I8b7.m3.f, optJSONObject);
        }
        org.json.JSONObject jSONObject10 = new org.json.JSONObject();
        jSONObject10.put(com.baidu.mobads.sdk.internal.bm.l, jSONObject9.optJSONArray(com.baidu.mobads.sdk.internal.bm.l));
        jSONObject10.put("aids", optJSONObject2);
        jSONObject10.put("openid", jSONObject9.has("openid") ? jSONObject9.optString("openid") : "OPENID_CLOSED");
        jSONObject10.put(com.anythink.expressad.foundation.g.a.J, jSONObject9.optInt(com.anythink.expressad.foundation.g.a.J));
        org.json.JSONObject jSONObject11 = new org.json.JSONObject();
        if (jSONObject9.has("zxc1")) {
            jSONObject11.put("zxc1", jSONObject9.getString("zxc1"));
        }
        if (jSONObject9.has("zxc2")) {
            jSONObject11.put("zxc2", true);
        }
        if (jSONObject9.has("zxc3")) {
            jSONObject11.put("zxc3", true);
        }
        l2Var.a.getClass();
        java.lang.String jSONObject12 = jSONObject11.toString();
        com.zx.a.I8b7.m3.l = jSONObject12;
        l2Var.a.a(30, jSONObject12, true);
        com.zx.a.I8b7.r2.a("zxc had changed refresh:" + com.zx.a.I8b7.m3.l);
        l2Var.a.getClass();
        java.lang.String jSONObject13 = jSONObject10.toString();
        if (!android.text.TextUtils.isEmpty(jSONObject13)) {
            com.zx.a.I8b7.m3.j = jSONObject13;
            l2Var.a.a(16, jSONObject13, true);
            com.zx.a.I8b7.r2.a("ext had changed refresh:".concat(java.lang.String.valueOf(jSONObject10)));
        }
        org.json.JSONArray optJSONArray2 = jSONObject8.optJSONArray("cmds");
        com.zx.a.I8b7.u3 u3Var4 = l2Var.a;
        java.lang.String str2 = com.zx.a.I8b7.m3.E;
        u3Var4.getClass();
        if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.equals(str2, com.zx.a.I8b7.m3.D)) {
            com.zx.a.I8b7.m3.D = str2;
            l2Var.a.a(13, str2, true);
        }
        org.json.JSONArray optJSONArray3 = jSONObject9.optJSONArray("iaps");
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i = 0; i < optJSONArray3.length(); i++) {
                    jSONArray.put(com.zx.a.I8b7.p.a(android.util.Base64.decode(optJSONArray3.getString(i), 2), c, "UDID_ENC_AUTHTAG"));
                }
            }
            com.zx.a.I8b7.l2 l2Var2 = com.zx.a.I8b7.l2.a.a;
            l2Var2.a.getClass();
            l2Var2.a.a(25, jSONArray.toString(), true);
        } catch (java.lang.Throwable unused2) {
        }
        if (optJSONArray2 != null) {
            try {
                if (optJSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        switch (optJSONArray2.getInt(i2)) {
                            case 1:
                                com.zx.a.I8b7.r2.a("cmd 1 REQUEST_CONFIG ");
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.l1();
                                break;
                            case 2:
                                com.zx.a.I8b7.l2.a.a.a.d(0);
                                continue;
                            case 3:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.m1();
                                break;
                            case 4:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.n1();
                                break;
                            case 5:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.o1();
                                break;
                            case 6:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.f();
                                break;
                            case 7:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.g();
                                break;
                            case 8:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.h();
                                break;
                            case 9:
                                threadPoolExecutor = com.zx.a.I8b7.v3.f.a.d;
                                l1Var = new com.zx.a.I8b7.i();
                                break;
                            default:
                                continue;
                        }
                        threadPoolExecutor.execute(l1Var);
                    }
                }
            } catch (java.lang.Throwable th2) {
                com.zx.a.I8b7.r2.a(th2);
            }
        }
    }
}
