package com.getui.gtc.c;

/* loaded from: classes22.dex */
public final class b {
    public static java.lang.String b;
    public static java.lang.String c;
    public static volatile java.lang.String d;
    public static java.lang.String e;
    public static java.lang.String f;
    public static java.lang.String g;
    public static java.lang.String a = com.getui.gtc.base.GtcProvider.context().getPackageName();
    private static final java.util.List<com.getui.gtc.api.GtcIdCallback> j = new java.util.ArrayList();
    public static java.lang.String h = "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB";
    public static java.lang.String i = "69d747c4b9f641baf4004be4297e9f3b";

    /* renamed from: com.getui.gtc.c.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.g.c.a {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.g.c.a
        public final void a(java.lang.String str) {
            com.getui.gtc.e.c cVar;
            com.getui.gtc.c.b.d = str;
            if (!android.text.TextUtils.equals(this.a, str)) {
                try {
                    new java.lang.StringBuilder("gtcid changed to ").append(com.getui.gtc.c.b.d);
                    java.util.Iterator it = com.getui.gtc.c.b.j.iterator();
                    while (it.hasNext()) {
                        ((com.getui.gtc.api.GtcIdCallback) it.next()).onSuccess(com.getui.gtc.c.b.d);
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.b(th);
                }
            }
            com.getui.gtc.c.b.j.clear();
            cVar = com.getui.gtc.e.c.a.a;
            com.getui.gtc.e.d dVar = cVar.a;
            java.lang.String str2 = com.getui.gtc.c.b.d;
            if (dVar.a(4, str2)) {
                dVar.d = str2;
            }
        }
    }

    public static void a() {
        java.util.List asList;
        java.util.List asList2;
        java.util.List asList3;
        java.lang.String str;
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        com.getui.gtc.e.c cVar3;
        try {
            android.os.Bundle bundle = com.getui.gtc.base.util.CommonUtil.getAppInfoForSelf(com.getui.gtc.base.GtcProvider.context()).metaData;
            if (bundle != null) {
                java.lang.String string = bundle.getString("GTC_C");
                if (!android.text.TextUtils.isEmpty(string)) {
                    e = string;
                }
                java.lang.String string2 = bundle.getString("GTC_B");
                if (!android.text.TextUtils.isEmpty(string2)) {
                    f = string2;
                }
                java.lang.String string3 = bundle.getString("GTC_A");
                if (!android.text.TextUtils.isEmpty(string3)) {
                    g = string3;
                }
                java.lang.String string4 = bundle.getString("GTC_P");
                if (!android.text.TextUtils.isEmpty(string4)) {
                    h = string4;
                }
                java.lang.String string5 = bundle.getString("GTC_K");
                if (!android.text.TextUtils.isEmpty(string5)) {
                    i = string5;
                }
                java.lang.String string6 = bundle.getString("GETUI_APPID");
                if (android.text.TextUtils.isEmpty(string6)) {
                    string6 = bundle.getString("GETUI_APP_ID");
                    if (android.text.TextUtils.isEmpty(string6)) {
                        string6 = bundle.getString(com.igexin.push.core.b.b);
                        if (android.text.TextUtils.isEmpty(string6)) {
                            string6 = bundle.getString("GI_APPID");
                            if (android.text.TextUtils.isEmpty(string6)) {
                                string6 = bundle.getString("GI_APP_ID");
                                if (android.text.TextUtils.isEmpty(string6)) {
                                    string6 = bundle.getString("GS_APPID");
                                    if (android.text.TextUtils.isEmpty(string6)) {
                                        string6 = bundle.getString("GS_APP_ID");
                                        if (android.text.TextUtils.isEmpty(string6)) {
                                            string6 = bundle.getString("GY_APPID");
                                            if (android.text.TextUtils.isEmpty(string6)) {
                                                string6 = bundle.getString("GY_APP_ID");
                                                if (android.text.TextUtils.isEmpty(string6)) {
                                                    java.lang.String string7 = bundle.getString("com.sdk.plus.appid");
                                                    if (!android.text.TextUtils.isEmpty(string7)) {
                                                        a = string7;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                a = string6;
            } else {
                com.getui.gtc.h.c.a.b("metaData==null");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.c(th);
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String[] strArr = new java.lang.String[0];
        try {
            try {
                asList = java.util.Arrays.asList(e.split(","));
            } catch (java.lang.Throwable unused) {
                asList = java.util.Arrays.asList("https://c-gtc.getui.net,https://c-gtc.gepush.com".split(","));
            }
            hashMap.put("gtc.cs", asList);
            java.lang.String[] strArr2 = new java.lang.String[0];
            try {
                try {
                    asList2 = java.util.Arrays.asList(g.split(","));
                } catch (java.lang.Throwable th2) {
                    hashMap.put("gtc.as", java.util.Arrays.asList(strArr2));
                    throw th2;
                }
            } catch (java.lang.Throwable unused2) {
                asList2 = java.util.Arrays.asList("https://gtc.getui.net,https://gtc.gepush.com".split(","));
            }
            hashMap.put("gtc.as", asList2);
            java.lang.String[] strArr3 = new java.lang.String[0];
            try {
                try {
                    asList3 = java.util.Arrays.asList(f.split(","));
                } catch (java.lang.Throwable th3) {
                    hashMap.put("gtc.bs", java.util.Arrays.asList(strArr3));
                    throw th3;
                }
            } catch (java.lang.Throwable unused3) {
                asList3 = java.util.Arrays.asList("https://b-gtc.getui.net,https://b-gtc.gepush.com".split(","));
            }
            hashMap.put("gtc.bs", asList3);
            com.getui.gtc.server.ServerManager.addBuildInServerMap(hashMap);
            if (android.text.TextUtils.isEmpty(d)) {
                cVar3 = com.getui.gtc.e.c.a.a;
                d = cVar3.a.d;
            }
            if (android.text.TextUtils.isEmpty(d)) {
                if (android.text.TextUtils.isEmpty(c)) {
                    cVar2 = com.getui.gtc.e.c.a.a;
                    c = cVar2.a.e;
                }
                if (android.text.TextUtils.isEmpty(c)) {
                    if (android.text.TextUtils.isEmpty(b)) {
                        android.content.Context context = com.getui.gtc.base.GtcProvider.context();
                        java.lang.String a2 = com.getui.gtc.b.a.a(context);
                        if (android.text.TextUtils.isEmpty(a2)) {
                            a2 = context.getSharedPreferences("GINSIGHT-SDK-PREFERENCE", 0).getString("gicid", null);
                        }
                        b = a2;
                    }
                    if (android.text.TextUtils.isEmpty(b)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("gtc_");
                        java.lang.String a3 = com.getui.gtc.h.a.a.a(java.util.UUID.randomUUID().toString() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + java.lang.System.currentTimeMillis() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.getui.gtc.base.GtcProvider.context().getPackageName());
                        sb.append(a3);
                        char charAt = a3.charAt(a3.length() + (-1));
                        if (charAt < 16) {
                            sb.append("0");
                        }
                        sb.append(java.lang.Integer.toHexString(charAt));
                        c = sb.toString();
                        cVar = com.getui.gtc.e.c.a.a;
                        com.getui.gtc.e.d dVar = cVar.a;
                        java.lang.String str2 = c;
                        if (dVar.a(9, str2)) {
                            dVar.e = str2;
                        }
                    } else {
                        str = b;
                        d = str;
                        a(str);
                    }
                }
                str = c;
                d = str;
                a(str);
            }
            com.getui.gtc.server.ServerManager.updateConfigServerMap();
            new java.lang.StringBuilder("gtcid is ").append(d);
        } catch (java.lang.Throwable th4) {
            hashMap.put("gtc.cs", java.util.Arrays.asList(strArr));
            throw th4;
        }
    }

    public static void a(com.getui.gtc.api.GtcIdCallback gtcIdCallback) throws android.os.RemoteException {
        if (gtcIdCallback != null) {
            gtcIdCallback.onSuccess(d);
            j.add(gtcIdCallback);
        }
    }

    private static void a(java.lang.String str) {
        com.getui.gtc.g.c.a(str, new com.getui.gtc.c.b.AnonymousClass1(str));
    }
}
