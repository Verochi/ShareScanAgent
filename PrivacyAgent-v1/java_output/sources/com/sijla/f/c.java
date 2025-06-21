package com.sijla.f;

/* loaded from: classes19.dex */
public final class c {
    private java.lang.Object a;
    private boolean b;

    public static com.sijla.bean.b a(android.content.Context context) {
        return a(context, com.sijla.c.d.a, "0");
    }

    private static com.sijla.bean.b a(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str) {
        com.sijla.bean.b bVar = new com.sijla.bean.b();
        try {
            java.lang.String packageName = context.getPackageName();
            java.lang.String d = 1 == jSONObject.optInt("phnum", 0) ? com.sijla.h.a.a.d() : "";
            bVar.a(org.apache.tools.tar.TarConstants.VERSION_POSIX, com.sijla.h.c.d(context));
            bVar.a(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.KeyAndValue.NUMBER_01, com.sijla.h.c.b(com.sijla.h.a.a.m(context)));
            bVar.a("02", packageName);
            bVar.a("03", com.sijla.h.a.a.j(context));
            bVar.a("04", com.sijla.h.c.g());
            bVar.a("05", android.os.Build.MANUFACTURER);
            bVar.a("06", com.sijla.h.c.h());
            bVar.a("07", java.lang.String.valueOf(com.sijla.h.a.a.q()));
            bVar.a("08", com.sijla.h.a.a.m());
            bVar.a("09", com.sijla.h.c.b(com.sijla.h.a.a.p(context)));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, com.sijla.h.c.b(com.sijla.h.a.a.q(context)));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, com.sijla.h.a.a.e());
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR, android.os.Build.VERSION.RELEASE);
            bVar.a("13", com.sijla.h.c.b(d));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND, com.sijla.h.i.c(context));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_WPA_STATE, com.sijla.h.a.a.n());
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_WAP, com.sijla.h.a.a.i());
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP, com.sijla.h.a.a.s(context));
            bVar.a("18", com.sijla.h.a.a.b() ? "1" : "0");
            bVar.a(com.tencent.connect.common.Constants.VIA_ACT_TYPE_NINETEEN, com.sijla.h.a.a.p());
            bVar.a("20", com.sijla.h.a.a.k());
            bVar.a("21", com.sijla.h.a.a.l());
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE, str);
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AIO, com.sijla.h.i.b(context));
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "");
            bVar.a(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_VIDEO, com.sijla.h.a.a.n(context));
            bVar.a("27", com.sijla.h.c.b(com.sijla.h.c.c(context)));
            bVar.a(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, com.sijla.h.i.d(context));
            bVar.a("29", com.sijla.b.g.d);
            bVar.a("30", java.lang.String.valueOf(com.sijla.h.a.a.s()));
            bVar.a("31", "1");
        } catch (org.json.JSONException unused) {
        }
        return bVar;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = "";
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                str3 = com.sijla.h.a.d.g(context) + str2;
                byte[] e = com.sijla.h.c.e(str);
                if (e != null && e.length > 0) {
                    com.sijla.h.a.e.a(str3, e);
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return str3;
    }

    public static void a(android.content.Context context, long j, com.sijla.callback.QtCallBack qtCallBack) {
        com.sijla.a.a.a(new com.sijla.f.e(context, j, qtCallBack));
    }

    private static void a(android.content.Context context, com.sijla.callback.QtCallBack qtCallBack, java.lang.String str, long j, long j2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String j3 = com.sijla.h.a.a.j(context);
            jSONObject.put("qmuid", com.sijla.h.i.a(context));
            jSONObject.put("selfuid", com.sijla.b.g.d);
            jSONObject.put("appver", j3);
            jSONObject.put("currentChannel", com.sijla.b.g.c);
            jSONObject.put("installChannel", com.sijla.b.g.c);
            jSONObject.put("uploadStatus", str);
            jSONObject.put("sessionid", j);
            jSONObject.put("dur", j2);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (qtCallBack != null) {
            try {
                qtCallBack.uploadCallBack(jSONObject);
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("qtcallback", jSONObject.toString());
        intent.setPackage(context.getPackageName());
        intent.putExtra("proc", com.sijla.h.a.a.c());
        intent.setAction(com.sijla.h.a.a.a(context));
        com.sijla.f.a.a(context, intent);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        java.io.File[] listFiles;
        org.json.JSONArray jSONArray;
        if (com.sijla.h.a.a.e(context)) {
            java.lang.String str2 = "qt.csv." + java.lang.System.currentTimeMillis() + ".txt";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getPackageName());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.j(context));
            sb.append("\t");
            sb.append(com.sijla.h.c.h());
            sb.append("\t");
            sb.append(com.sijla.h.i.b(context));
            sb.append("\t");
            sb.append(com.sijla.h.i.a(context));
            sb.append("\t");
            sb.append(com.sijla.h.c.b(com.sijla.h.a.a.p(context)));
            sb.append("\t");
            sb.append(com.sijla.h.c.b(com.sijla.h.a.a.q(context)));
            sb.append("\t");
            sb.append(com.sijla.h.c.b(1 == com.sijla.c.d.a.optInt("phnum", 0) ? com.sijla.h.a.a.d() : ""));
            sb.append("\t");
            sb.append(com.sijla.h.a.a.l());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.m());
            sb.append("\t");
            sb.append(java.lang.String.valueOf(com.sijla.h.a.a.q()));
            sb.append("\t");
            sb.append(com.sijla.h.a.a.p());
            sb.append("\t");
            sb.append(com.sijla.h.c.b(""));
            sb.append("\t");
            sb.append("-\t");
            sb.append(android.os.Build.MANUFACTURER);
            sb.append("\t");
            sb.append(com.sijla.h.a.a.e());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.n());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.s(context));
            sb.append("\t");
            sb.append(android.os.Build.VERSION.RELEASE);
            sb.append("\t");
            sb.append(com.sijla.h.a.a.k());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.i());
            sb.append("\t");
            sb.append(com.sijla.h.a.a.b() ? "1" : "0");
            sb.append("\t");
            sb.append(com.sijla.h.c.b(com.sijla.h.a.a.m(context)));
            sb.append("\t");
            sb.append(java.lang.System.currentTimeMillis() / 1000);
            sb.append("\t");
            sb.append(com.sijla.h.a.a.n(context));
            sb.append("\t");
            sb.append("1");
            java.lang.String str3 = str + "\t" + sb.toString();
            if (str3 != null) {
                a(context, str3, str2);
                java.io.File file = new java.io.File(com.sijla.h.a.d.g(context));
                if (!file.isDirectory() || (listFiles = file.listFiles(new com.sijla.f.d())) == null) {
                    return;
                }
                java.util.HashMap hashMap = new java.util.HashMap();
                for (java.io.File file2 : listFiles) {
                    hashMap.put(file2.getName(), file2);
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("appkey", com.sijla.h.c.d(context));
                    jSONObject.put("uid", com.sijla.h.i.b(context));
                    jSONObject.put("sdk", 20230823);
                    jSONObject.put("type", 3);
                    jSONObject.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_TYPE, "2");
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                com.sijla.h.c.a.a();
                java.lang.String concat = "?".concat(java.lang.String.valueOf(com.sijla.h.c.a.a(jSONObject).toString()));
                try {
                    jSONArray = com.sijla.c.d.a.optJSONArray("trinfo2urls");
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                    jSONArray = null;
                }
                if (jSONArray == null || jSONArray.length() == 0) {
                    jSONArray = new org.json.JSONArray();
                    jSONArray.put("https://truth.qchannel03.cn/truth");
                }
                boolean z = com.sijla.c.d.a.optInt("repeatReportGrowth", 0) == 0;
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (com.sijla.c.a.a(jSONArray.optString(i, "https://truth.qchannel03.cn/truth") + (concat + "&r=" + i), new org.json.JSONObject(), hashMap).b && z) {
                        break;
                    }
                }
                com.sijla.h.a.e.a(file);
            }
        }
    }

    private static void a(android.content.Context context, org.json.JSONObject jSONObject) {
        new com.sijla.e.d(context).a(jSONObject);
    }

    public static void a(android.content.Context context, org.json.JSONObject jSONObject, com.sijla.callback.QtCallBack qtCallBack, long j) {
        org.json.JSONArray jSONArray;
        int i;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a(context, qtCallBack, "startUpload", currentTimeMillis, j);
        if (jSONObject == null || !com.sijla.h.a.a.e(context)) {
            a(context, qtCallBack, "fail", currentTimeMillis, j);
            a(context, jSONObject);
            return;
        }
        try {
            jSONArray = com.sijla.c.d.a.optJSONArray("growthurls");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            jSONArray = new org.json.JSONArray();
            jSONArray.put("https://b.qchannel03.cn/n/qts");
        }
        boolean z = com.sijla.c.d.a.optInt("repeatReportGrowth", 0) == 0;
        java.lang.String b = b(context);
        boolean z2 = false;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            java.lang.String str = jSONArray.optString(i2, "https://b.qchannel03.cn/n/qts") + (b + "&r=" + i2 + "&sv=20230823");
            com.sijla.f.c cVar = new com.sijla.f.c();
            com.sijla.h.c.a.a();
            com.sijla.h.j a = com.sijla.h.c.a.a(str, jSONObject);
            int a2 = a.a();
            if (200 == a2 || 204 == a2) {
                cVar.b = true;
            } else {
                cVar.b = false;
                cVar.a = a.b();
            }
            if (cVar.b) {
                if (z2) {
                    i = i2;
                } else {
                    com.sijla.b.g.b("Upload Data Success");
                    i = i2;
                    a(context, qtCallBack, "success", currentTimeMillis, j);
                    z2 = true;
                }
                if (z) {
                    break;
                }
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (z2) {
            return;
        }
        com.sijla.b.g.a("Upload Data Fail", 0);
        a(context, qtCallBack, "fail", currentTimeMillis, j);
        a(context, jSONObject);
    }

    private static java.lang.String b(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("ak", com.sijla.h.c.d(context));
            jSONObject.put("uid", com.sijla.h.i.a(context));
            jSONObject.put("offline", "0");
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.sijla.h.c.a.a();
        return "?".concat(java.lang.String.valueOf(com.sijla.h.c.a.a(jSONObject).toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static org.json.JSONObject b(android.content.Context context, long j) {
        java.lang.String valueOf;
        java.lang.String substring;
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = null;
        try {
            valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
            substring = com.sijla.h.a.g.a(valueOf).substring(0, 8);
            jSONObject = new org.json.JSONObject();
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            jSONObject.put("dur", com.sijla.h.c.a(substring, java.lang.String.valueOf(j)));
            jSONObject.put(com.umeng.analytics.pro.f.T, com.sijla.h.c.a(substring, "20230823"));
            jSONObject.put("dtype", com.sijla.h.c.a(substring, "qt"));
            jSONObject.put("ts", com.sijla.h.c.a(substring, java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000)));
            jSONObject.put("appkey", com.sijla.h.c.a(substring, com.sijla.h.c.d(context)));
            java.lang.String str = com.sijla.b.g.c;
            java.lang.String str2 = com.igexin.push.core.b.m;
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            jSONObject.put("channel", com.sijla.h.c.a(substring, str));
            jSONObject.put("uuid", com.sijla.h.c.a(substring, com.sijla.h.i.a(context)));
            jSONObject.put("nt", com.sijla.h.c.a(substring, com.sijla.h.a.a.h(context)));
            jSONObject.put("nuid", com.sijla.h.c.a(substring, com.sijla.h.i.d(context)));
            jSONObject.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_DURATION, com.sijla.h.c.a(substring, com.sijla.h.c.c(context)));
            jSONObject.put("did", com.sijla.h.c.a(substring, com.sijla.h.a.a.p(context)));
            jSONObject.put("mid", com.sijla.h.c.a(substring, com.sijla.h.i.b(context)));
            java.lang.String str3 = com.sijla.b.g.d;
            if (str3 == null) {
                str3 = com.igexin.push.core.b.m;
            }
            jSONObject.put("uid3", com.sijla.h.c.a(substring, str3));
            java.lang.String str4 = com.sijla.b.g.c;
            if (str4 != null) {
                str2 = str4;
            }
            jSONObject.put("inschannel", com.sijla.h.c.a(substring, str2));
            jSONObject.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.ADN_KS, com.sijla.h.c.a(substring, com.sijla.h.a.a.u(context)));
            jSONObject.put("mf", com.sijla.h.c.a(substring, com.sijla.h.a.a.f()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.L, com.sijla.h.c.a(substring, com.sijla.h.a.a.g()));
            jSONObject.put("md", com.sijla.h.c.a(substring, com.sijla.h.a.a.h()));
            jSONObject.put("ov", com.sijla.h.c.a(substring, android.os.Build.VERSION.RELEASE));
            org.json.JSONObject r = com.sijla.h.a.a.r(context);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(r.optLong("instime"));
            jSONObject.put("inst", com.sijla.h.c.a(substring, sb.toString()));
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(r.optLong("uptime"));
            jSONObject.put("upst", com.sijla.h.c.a(substring, sb2.toString()));
            jSONObject.put("insid", com.sijla.h.c.a(substring, com.sijla.b.g.d(context)));
            jSONObject.put("clientkey", com.sijla.h.c.a(substring, com.sijla.b.g.a()));
            jSONObject.put("aid", com.sijla.h.c.a(substring, com.sijla.h.a.a.m(context)));
            jSONObject.put("diao", com.sijla.h.c.a(substring, (java.lang.String) com.sijla.h.j.b(context, "oaidspkey", "")));
            boolean z = com.sijla.b.c.a;
            if (com.sijla.c.d.a.optInt("rsaqt", 0) == 1) {
                jSONObject.put("e", "rsa");
                byte[] a = com.sijla.d.c.a(substring.getBytes());
                if (a != null) {
                    jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, com.sijla.d.a.a(a));
                }
            } else {
                jSONObject.put("e", "1");
                jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, valueOf);
            }
            return jSONObject;
        } catch (java.lang.Exception e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    public final java.lang.Object a() {
        return this.a;
    }

    public final void a(java.lang.Object obj) {
        this.a = obj;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final boolean b() {
        return this.b;
    }
}
