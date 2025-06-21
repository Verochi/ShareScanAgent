package com.umeng.ccg;

/* loaded from: classes19.dex */
public class d implements com.umeng.ccg.c.a {
    private static final java.lang.String a = "iucc";
    private static final java.lang.String b = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.C);
    private static org.json.JSONObject c = null;
    private static final java.lang.String[] d = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h};
    private static final java.lang.String[] e = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h, com.umeng.ccg.a.i};
    private static java.util.ArrayList<com.umeng.analytics.pro.ac> f = null;
    private static java.util.ArrayList<com.umeng.analytics.pro.ac> g = null;
    private static java.util.ArrayList<com.umeng.analytics.pro.ac> h = null;
    private static java.util.ArrayList<com.umeng.analytics.pro.ac> i = null;
    private static com.umeng.analytics.pro.ab j = null;
    private static com.umeng.ccg.d.e m = new com.umeng.ccg.d.e();
    private volatile java.lang.String k = "";
    private java.util.Map<java.lang.String, com.umeng.ccg.d.b> l = new java.util.HashMap();

    /* renamed from: com.umeng.ccg.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
        public void onImprintValueChanged(java.lang.String str, java.lang.String str2) {
            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 107, com.umeng.ccg.d.a(), str2);
        }
    }

    /* renamed from: com.umeng.ccg.d$2, reason: invalid class name */
    public class AnonymousClass2 implements android.accounts.AccountManagerCallback<android.os.Bundle> {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ int b;

        public AnonymousClass2(java.lang.String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(android.accounts.AccountManagerFuture<android.os.Bundle> accountManagerFuture) {
            int i = 1;
            try {
                accountManagerFuture.getResult();
                i = 0;
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
            } catch (java.lang.Throwable unused) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
            }
            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), com.umeng.ccg.c.f452s, com.umeng.ccg.d.a(), com.umeng.ccg.d.this.new c(this.a, this.b, i));
        }
    }

    public static class a extends android.content.BroadcastReceiver {
        public long a(java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    com.umeng.analytics.pro.ac acVar = arrayList.get(i);
                    if (acVar instanceof com.umeng.analytics.pro.af) {
                        return ((com.umeng.analytics.pro.af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                java.lang.String action = intent.getAction();
                if (android.text.TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON") && com.umeng.ccg.d.j != null && (com.umeng.ccg.d.j instanceof com.umeng.analytics.pro.ae)) {
                    if (b(com.umeng.ccg.d.i)) {
                        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 304, com.umeng.ccg.d.a(), null, 1000 * a(com.umeng.ccg.d.i));
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public class b {
        private org.json.JSONArray b;
        private java.lang.String c;

        public b(org.json.JSONArray jSONArray, java.lang.String str) {
            this.b = jSONArray;
            this.c = str;
        }

        public org.json.JSONArray a() {
            return this.b;
        }

        public java.lang.String b() {
            return this.c;
        }
    }

    public class c {
        public java.lang.String a;
        public int b;
        public int c;

        public c(java.lang.String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }
    }

    /* renamed from: com.umeng.ccg.d$d, reason: collision with other inner class name */
    public static class C0517d {
        private static final com.umeng.ccg.d a = new com.umeng.ccg.d();

        private C0517d() {
        }
    }

    public static class e extends android.content.BroadcastReceiver {
        public long a(java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    com.umeng.analytics.pro.ac acVar = arrayList.get(i);
                    if (acVar instanceof com.umeng.analytics.pro.af) {
                        return ((com.umeng.analytics.pro.af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                java.lang.String action = intent.getAction();
                if (android.text.TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(com.umeng.ccg.d.f)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 301, com.umeng.ccg.d.a(), null, a(com.umeng.ccg.d.f) * 1000);
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(com.umeng.ccg.d.g)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 302, com.umeng.ccg.d.a(), null, a(com.umeng.ccg.d.g) * 1000);
                    } else {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals(com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(com.umeng.ccg.d.h)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 303, com.umeng.ccg.d.a(), null, a(com.umeng.ccg.d.h) * 1000);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private com.umeng.analytics.pro.ab a(java.lang.String str, org.json.JSONObject jSONObject) {
        org.json.JSONArray optJSONArray;
        java.lang.String str2;
        org.json.JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.l) && (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.l)) != null && optJSONArray.length() > 0) {
                    org.json.JSONObject jSONObject2 = (org.json.JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(com.umeng.ccg.a.m);
                    boolean has2 = jSONObject2.has(com.umeng.ccg.a.p);
                    boolean has3 = jSONObject2.has(com.umeng.ccg.a.q);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject2.optInt(com.umeng.ccg.a.m);
                        long optLong = jSONObject2.optLong(com.umeng.ccg.a.p);
                        long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.q);
                        java.lang.String optString = jSONObject2.optString(com.umeng.ccg.a.r);
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.n)) {
                            org.json.JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.n);
                            java.util.HashSet hashSet = new java.util.HashSet();
                            if (optJSONArray3 != null) {
                                str2 = "sdk";
                                int i2 = 0;
                                for (int length = optJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(java.lang.Integer.valueOf(optJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str2 = "sdk";
                            }
                            if (hashSet.size() > 0) {
                                com.umeng.analytics.pro.am amVar = new com.umeng.analytics.pro.am(hashSet);
                                if (java.util.Arrays.asList(d).contains(str)) {
                                    a(str, amVar);
                                } else {
                                    arrayList.add(amVar);
                                    if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                                        a(str, amVar);
                                    }
                                }
                            }
                        } else {
                            str2 = "sdk";
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.o)) {
                            java.lang.String optString2 = jSONObject2.optString(com.umeng.ccg.a.o);
                            if (!android.text.TextUtils.isEmpty(optString2)) {
                                com.umeng.analytics.pro.ak akVar = new com.umeng.analytics.pro.ak(optString2);
                                java.util.HashSet hashSet2 = new java.util.HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (akVar.a(i3)) {
                                        hashSet2.add(java.lang.Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    com.umeng.analytics.pro.ag agVar = new com.umeng.analytics.pro.ag(hashSet2);
                                    if (java.util.Arrays.asList(d).contains(str)) {
                                        a(str, agVar);
                                    } else {
                                        arrayList.add(agVar);
                                    }
                                    if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                                        a(str, agVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new com.umeng.analytics.pro.ai(optInt));
                        com.umeng.analytics.pro.ah ahVar = new com.umeng.analytics.pro.ah(str, optLong);
                        java.lang.String[] strArr = d;
                        if (java.util.Arrays.asList(strArr).contains(str)) {
                            a(str, ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                            a(str, ahVar);
                        }
                        com.umeng.analytics.pro.af afVar = new com.umeng.analytics.pro.af(optLong2);
                        if (java.util.Arrays.asList(strArr).contains(str)) {
                            a(str, afVar);
                            arrayList.add(afVar);
                        } else {
                            arrayList.add(afVar);
                        }
                        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                            a(str, afVar);
                        }
                        com.umeng.analytics.pro.ab adVar = com.umeng.ccg.a.e.equals(str) ? new com.umeng.analytics.pro.ad(str, arrayList) : com.umeng.ccg.a.i.equals(str) ? new com.umeng.analytics.pro.ae(str, arrayList) : new com.umeng.analytics.pro.ab(str, arrayList);
                        try {
                            adVar.b(str, jSONObject2);
                            adVar.a(optString);
                            java.lang.String str3 = "";
                            java.lang.String str4 = str2;
                            if (jSONObject.has(str4) && (optJSONArray2 = jSONObject.optJSONArray(str4)) != null) {
                                java.util.Map<java.lang.String, com.umeng.ccg.d.b> map = this.l;
                                if (map != null && !map.containsKey(str)) {
                                    this.l.put(str, new com.umeng.ccg.d.b(new org.json.JSONArray(optJSONArray2.toString()), optString));
                                }
                                int length2 = optJSONArray2.length();
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    str3 = str3 + optJSONArray2.getString(i4);
                                    if (i4 < length2 - 1) {
                                        str3 = str3 + ",";
                                    }
                                }
                            }
                            adVar.b(str3);
                        } catch (java.lang.Throwable unused) {
                        }
                        return adVar;
                    } catch (java.lang.Throwable unused2) {
                        return null;
                    }
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
        return null;
    }

    public static com.umeng.ccg.d a() {
        return com.umeng.ccg.d.C0517d.a;
    }

    private org.json.JSONObject a(java.lang.String str, int i2, int i3) {
        com.umeng.ccg.d.b bVar;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.B, i2);
            jSONObject.put("result", i3);
            if (!this.l.containsKey(com.umeng.ccg.a.i) || (bVar = this.l.get(com.umeng.ccg.a.i)) == null) {
                return null;
            }
            org.json.JSONObject a2 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), bVar.a(), bVar.b());
            org.json.JSONObject a3 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), jSONObject);
            if (a2 == null || a3 == null) {
                return null;
            }
            return com.umeng.analytics.pro.ao.a(a2, a3);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private void a(android.content.Context context, java.lang.String str, long j2) {
        android.content.SharedPreferences a2;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.lang.String[] split = str.split("@");
            if (split.length != 4 || (a2 = com.umeng.analytics.pro.au.a(context)) == null) {
                return;
            }
            long parseLong = java.lang.Long.parseLong(split[0]);
            java.lang.String str2 = split[1];
            android.content.SharedPreferences.Editor edit = a2.edit();
            edit.putLong(com.umeng.analytics.pro.au.c, j2);
            edit.putLong(com.umeng.analytics.pro.au.d, parseLong);
            edit.putString(com.umeng.analytics.pro.au.e, str2).commit();
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, java.lang.String str, android.content.BroadcastReceiver broadcastReceiver) {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private void a(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject) {
        org.json.JSONObject a2;
        java.lang.Object a3;
        try {
            b(com.umeng.ccg.a.i);
            java.lang.String optString = jSONObject.has(com.umeng.ccg.a.A) ? jSONObject.optString(com.umeng.ccg.a.A) : "";
            if (android.text.TextUtils.isEmpty(optString)) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> target is empty, ignore umc_cfg process");
                return;
            }
            int optInt = jSONObject.has(com.umeng.ccg.a.B) ? jSONObject.optInt(com.umeng.ccg.a.B) : 0;
            if (optInt != 0) {
                if (android.os.Build.VERSION.SDK_INT < 23 || (a2 = a(optString, optInt, 0)) == null) {
                    return;
                }
                com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.b, a2), 0L, java.util.concurrent.TimeUnit.SECONDS);
                return;
            }
            org.json.JSONObject j2 = j();
            if (j2 == null || (a3 = com.umeng.analytics.pro.aw.a(j2.optString("c"), j2.optString("s"), new java.lang.Class[]{java.lang.String.class}, context, new java.lang.Object[]{j2.optString("a")})) == null || android.os.Build.VERSION.SDK_INT < 23) {
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("ss", android.util.Base64.encodeToString(com.umeng.analytics.pro.ax.a(com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(context).getBytes(), com.umeng.commonsdk.utils.UMUtils.genSin()), 0).trim());
            com.umeng.analytics.pro.aw.a(j2.optString(com.anythink.expressad.d.a.b.dH), j2.optString("x"), new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String[].class, android.os.Bundle.class, android.app.Activity.class, com.umeng.analytics.pro.aw.a(j2.optString(com.umeng.analytics.pro.bo.aJ)), android.os.Handler.class}, a3, new java.lang.Object[]{optString, com.umeng.ccg.a.k, null, bundle, null, new com.umeng.ccg.d.AnonymousClass2(optString, optInt), null});
        } catch (java.lang.Throwable unused) {
        }
    }

    private synchronized void a(android.content.Context context, org.json.JSONObject jSONObject, java.lang.String str) {
        long b2;
        byte[] a2;
        try {
            b2 = b(jSONObject);
            a2 = com.umeng.analytics.pro.ax.a(jSONObject.toString().getBytes(), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes());
        } catch (java.lang.Throwable unused) {
        }
        if (a2 != null && a2.length > 1) {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(new java.io.File(context.getFilesDir(), b));
            try {
                fileOutputStream.write(a2);
                fileOutputStream.flush();
                com.umeng.analytics.pro.as.a(fileOutputStream);
                a(context, str, b2);
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "saveConfigFile success.");
            } catch (java.lang.Throwable th) {
                com.umeng.analytics.pro.as.a(fileOutputStream);
                throw th;
            }
        }
    }

    private void a(java.lang.String str) {
        try {
            java.lang.String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = java.lang.Long.parseLong(split[0]);
            java.lang.String str2 = split[1];
            if (!android.text.TextUtils.isEmpty(this.k)) {
                java.lang.String[] split2 = this.k.split("@");
                if (split2.length == 2) {
                    long parseLong2 = java.lang.Long.parseLong(split2[0]);
                    java.lang.String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a2 != null) {
                if (a2.getLong(com.umeng.analytics.pro.au.c, 0L) != parseLong) {
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.k = java.lang.String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                if (e(com.umeng.commonsdk.service.UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.k = java.lang.String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void a(java.lang.String str, com.umeng.analytics.pro.ac acVar) {
        if (com.umeng.ccg.a.f.equalsIgnoreCase(str)) {
            if (f == null) {
                f = new java.util.ArrayList<>();
            }
            f.add(acVar);
        }
        if (com.umeng.ccg.a.g.equalsIgnoreCase(str)) {
            if (g == null) {
                g = new java.util.ArrayList<>();
            }
            g.add(acVar);
        }
        if (com.umeng.ccg.a.h.equalsIgnoreCase(str)) {
            if (h == null) {
                h = new java.util.ArrayList<>();
            }
            h.add(acVar);
        }
        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
            if (i == null) {
                i = new java.util.ArrayList<>();
            }
            i.add(acVar);
        }
    }

    private void a(boolean z) {
        try {
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a2 != null) {
                android.content.SharedPreferences.Editor edit = a2.edit();
                if (z) {
                    edit.putString(com.umeng.analytics.pro.au.g, "1").commit();
                } else {
                    edit.putString(com.umeng.analytics.pro.au.g, "").commit();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean a(org.json.JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == java.lang.Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has("cc")) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private long b(org.json.JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (java.lang.Throwable unused) {
            }
        }
        return 0L;
    }

    private void b(java.lang.String str) {
        java.lang.String str2 = com.umeng.analytics.pro.au.b + str;
        android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
        if (a2 != null) {
            a2.edit().putLong(str2, java.lang.System.currentTimeMillis()).commit();
        }
    }

    private void c(android.content.Context context) {
        com.umeng.commonsdk.statistics.idtracking.ImprintHandler.getImprintService(context).registImprintCallback(a, new com.umeng.ccg.d.AnonymousClass1());
    }

    private void c(org.json.JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("cc")) {
            return;
        }
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("cc");
            com.umeng.analytics.pro.ab abVar = null;
            com.umeng.analytics.pro.ab a2 = optJSONObject.has(com.umeng.ccg.a.b) ? a(com.umeng.ccg.a.b, optJSONObject.optJSONObject(com.umeng.ccg.a.b)) : null;
            com.umeng.analytics.pro.ab a3 = optJSONObject.has(com.umeng.ccg.a.c) ? a(com.umeng.ccg.a.c, optJSONObject.optJSONObject(com.umeng.ccg.a.c)) : null;
            com.umeng.analytics.pro.ab a4 = optJSONObject.has(com.umeng.ccg.a.d) ? a(com.umeng.ccg.a.d, optJSONObject.optJSONObject(com.umeng.ccg.a.d)) : null;
            com.umeng.analytics.pro.ab a5 = optJSONObject.has(com.umeng.ccg.a.e) ? a(com.umeng.ccg.a.e, optJSONObject.optJSONObject(com.umeng.ccg.a.e)) : null;
            com.umeng.analytics.pro.ab a6 = optJSONObject.has(com.umeng.ccg.a.f) ? a(com.umeng.ccg.a.f, optJSONObject.optJSONObject(com.umeng.ccg.a.f)) : null;
            com.umeng.analytics.pro.ab a7 = optJSONObject.has(com.umeng.ccg.a.g) ? a(com.umeng.ccg.a.g, optJSONObject.optJSONObject(com.umeng.ccg.a.g)) : null;
            com.umeng.analytics.pro.ab a8 = optJSONObject.has(com.umeng.ccg.a.h) ? a(com.umeng.ccg.a.h, optJSONObject.optJSONObject(com.umeng.ccg.a.h)) : null;
            if (optJSONObject.has(com.umeng.ccg.a.i)) {
                abVar = a(com.umeng.ccg.a.i, optJSONObject.optJSONObject(com.umeng.ccg.a.i));
                j = abVar;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (a2 != null) {
                arrayList.add(a2);
            }
            if (a3 != null) {
                arrayList.add(a3);
            }
            if (a4 != null) {
                arrayList.add(a4);
            }
            if (a5 != null) {
                arrayList.add(a5);
            }
            if (a6 != null) {
                arrayList.add(a6);
            }
            if (a7 != null) {
                arrayList.add(a7);
            }
            if (a8 != null) {
                arrayList.add(a8);
            }
            if (abVar != null) {
                arrayList.add(abVar);
            }
            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (java.lang.Throwable unused) {
        }
    }

    private java.lang.Long d(android.content.Context context) {
        try {
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(context);
            if (a2 != null) {
                return java.lang.Long.valueOf(a2.getLong(com.umeng.analytics.pro.au.d, 0L));
            }
            return 0L;
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }

    private java.lang.String e(android.content.Context context) {
        try {
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(context);
            return a2 != null ? a2.getString(com.umeng.analytics.pro.au.e, "") : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private boolean g() {
        android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
        if (a2 != null) {
            java.lang.String string = a2.getString(com.umeng.analytics.pro.au.f, "");
            if (android.text.TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!com.umeng.analytics.pro.as.a().keySet().equals(com.umeng.analytics.pro.as.a(new org.json.JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a2 != null) {
                a2.edit().putString(com.umeng.analytics.pro.au.f, new org.json.JSONObject(com.umeng.analytics.pro.as.a()).toString()).commit();
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean i() {
        try {
            android.content.SharedPreferences a2 = com.umeng.analytics.pro.au.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
            if (a2 != null) {
                return !android.text.TextUtils.isEmpty(a2.getString(com.umeng.analytics.pro.au.g, ""));
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private org.json.JSONObject j() {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            com.umeng.analytics.pro.ax.b(com.umeng.commonsdk.utils.UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.umeng.analytics.pro.ax.a(byteArray, com.umeng.commonsdk.utils.UMUtils.genSin());
            java.lang.String str = new java.lang.String(byteArray);
            byteArrayOutputStream.reset();
            return new org.json.JSONObject(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public org.json.JSONObject a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put("flag", str2);
            jSONObject.put("ss", str3);
            org.json.JSONObject a2 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), new org.json.JSONArray(), "");
            org.json.JSONObject a3 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), jSONObject);
            if (a2 == null || a3 == null) {
                return null;
            }
            return com.umeng.analytics.pro.ao.a(a2, a3);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public void a(android.content.Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:190:0x0475, code lost:
    
        if (r6 != null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0482, code lost:
    
        r3.put("config", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0480, code lost:
    
        if (0 == 0) goto L159;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(java.lang.Object obj, int i2) {
        ?? r3;
        java.util.ArrayList arrayList;
        int size;
        com.umeng.ccg.d.b bVar;
        com.umeng.ccg.d.b bVar2;
        com.umeng.ccg.d.b bVar3;
        org.json.JSONObject jSONObject = null;
        try {
            switch (i2) {
                case 101:
                    if (obj != null && (obj instanceof java.lang.String)) {
                        java.lang.String str = (java.lang.String) obj;
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                        org.json.JSONObject a2 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), str);
                        if (a2 != null) {
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + a2.toString());
                            com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.ar(com.umeng.analytics.pro.ar.a, a2, str), 0L, java.util.concurrent.TimeUnit.SECONDS);
                        }
                        if (i()) {
                            c(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), a, "");
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty);
                            a(imprintProperty);
                            break;
                        }
                    }
                    break;
                case 102:
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.k = "";
                    if (obj != null && (obj instanceof org.json.JSONObject)) {
                        org.json.JSONObject jSONObject2 = (org.json.JSONObject) obj;
                        if (!a(jSONObject2.optJSONObject("config"))) {
                            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 104, a(), null);
                            break;
                        } else {
                            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 103, a(), jSONObject2);
                            break;
                        }
                    } else {
                        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 104, a(), null);
                        break;
                    }
                    break;
                case 103:
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
                    if (obj != null && (obj instanceof org.json.JSONObject)) {
                        org.json.JSONObject jSONObject3 = (org.json.JSONObject) obj;
                        org.json.JSONObject optJSONObject = jSONObject3.optJSONObject("config");
                        java.lang.String optString = jSONObject3.optString("sourceIucc");
                        if (optJSONObject != null) {
                            if (i()) {
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                                h();
                                a(false);
                            }
                            a(appContext, optJSONObject, optString);
                            com.umeng.ccg.CcgAgent.notifyConfigChanged(optJSONObject);
                            break;
                        }
                    }
                    break;
                case 104:
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    break;
                case 105:
                    java.lang.String[] collectItemList = com.umeng.ccg.CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    r3 = 0;
                    while (r3 < length) {
                        java.lang.String str2 = collectItemList[r3];
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + com.umeng.ccg.CcgAgent.getForbidSdkArray(str2).toString());
                        r3++;
                    }
                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                    java.lang.Integer num = 0;
                    try {
                        try {
                            jSONObject = b(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                            java.lang.Integer valueOf = jSONObject != null ? a(jSONObject) ? java.lang.Integer.valueOf(num.intValue() | 1) : java.lang.Integer.valueOf(num.intValue() | 0) : java.lang.Integer.valueOf(num.intValue() | 0);
                            r3 = new org.json.JSONObject();
                            r3.put("result", valueOf);
                            r3 = r3;
                            break;
                        } catch (java.lang.Throwable unused) {
                            r3 = new org.json.JSONObject();
                            r3.put("result", num);
                            r3 = r3;
                            break;
                        }
                    } catch (java.lang.Throwable unused2) {
                        break;
                    }
                case 106:
                    if (obj != null && (obj instanceof org.json.JSONObject)) {
                        org.json.JSONObject jSONObject4 = (org.json.JSONObject) obj;
                        if (jSONObject4.has("result")) {
                            if ((jSONObject4.optInt("result") & 1) != 0 && jSONObject4.has("config")) {
                                org.json.JSONObject optJSONObject2 = jSONObject4.optJSONObject("config");
                                c = optJSONObject2;
                                if (optJSONObject2 != null) {
                                    com.umeng.ccg.CcgAgent.notifyConfigReady(optJSONObject2);
                                    r10 = 1;
                                }
                            }
                            if (r10 == 0) {
                                com.umeng.ccg.CcgAgent.notifyConfigReady(null);
                            }
                        }
                        if (!g()) {
                            c(com.umeng.commonsdk.service.UMGlobalContext.getAppContext());
                            java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), a, "");
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty2);
                            a(imprintProperty2);
                            break;
                        } else {
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                            java.lang.String imprintProperty3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), a, "");
                            a(true);
                            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 101, a(), imprintProperty3);
                            break;
                        }
                    }
                    break;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof java.lang.String) {
                                java.lang.String str3 = (java.lang.String) obj;
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                                break;
                            }
                        } catch (java.lang.Throwable th) {
                            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    break;
                default:
                    switch (i2) {
                        case 201:
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj != null && (obj instanceof org.json.JSONObject)) {
                                c((org.json.JSONObject) obj);
                                break;
                            }
                            break;
                        case 202:
                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj != null && (obj instanceof java.util.ArrayList) && (size = (arrayList = (java.util.ArrayList) obj).size()) > 0) {
                                while (r10 < size) {
                                    com.umeng.analytics.pro.ab abVar = (com.umeng.analytics.pro.ab) arrayList.get(r10);
                                    java.lang.String a3 = abVar.a();
                                    if (com.umeng.ccg.a.i.equalsIgnoreCase(a3)) {
                                        jSONObject = new org.json.JSONObject();
                                        jSONObject.put(com.umeng.ccg.a.j, 202);
                                    }
                                    org.json.JSONObject a4 = abVar.a(a3, jSONObject);
                                    if (a4 != null) {
                                        long optLong = !java.util.Arrays.asList(d).contains(abVar.a()) ? a4.optLong("delay") * 1000 : 0L;
                                        if (com.umeng.ccg.a.i.equalsIgnoreCase(abVar.a()) && a4.optInt(com.umeng.ccg.a.z) == 0) {
                                            optLong = a4.optLong("delay") * 1000;
                                        }
                                        long j2 = optLong;
                                        a4.remove("delay");
                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + j2);
                                        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 203, a(), a4, j2);
                                    }
                                    r10++;
                                }
                                break;
                            }
                            break;
                        case 203:
                            if (obj != null && (obj instanceof org.json.JSONObject)) {
                                org.json.JSONObject jSONObject5 = (org.json.JSONObject) obj;
                                java.lang.String optString2 = jSONObject5.optString("actionName");
                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + optString2);
                                if (!com.umeng.ccg.b.a(optString2)) {
                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Local switch of [" + optString2 + "] is off, ignore this command.");
                                    break;
                                } else {
                                    java.lang.String jSONObject6 = jSONObject5.toString();
                                    if (!java.util.Arrays.asList(e).contains(optString2)) {
                                        b(optString2);
                                        if (!com.umeng.ccg.CcgAgent.hasRegistedActionInfo()) {
                                            com.umeng.analytics.pro.as.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), jSONObject6);
                                            break;
                                        } else {
                                            r10 = com.umeng.ccg.CcgAgent.getActionInfo("anti") != null ? 1 : 0;
                                            java.lang.String optString3 = jSONObject5.optString(com.umeng.ccg.a.f451s);
                                            if (android.text.TextUtils.isEmpty(optString3)) {
                                                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + optString2 + "]采集请求.");
                                            } else {
                                                com.umeng.ccg.ActionInfo actionInfo = com.umeng.ccg.CcgAgent.getActionInfo(optString3);
                                                if (actionInfo != null) {
                                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "调用[" + optString3 + "] onCommand接口方法, 参数: " + jSONObject5.toString());
                                                    actionInfo.onCommand(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), optString2, jSONObject5);
                                                }
                                            }
                                            if (r10 == 0) {
                                                com.umeng.analytics.pro.as.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), jSONObject6);
                                                break;
                                            }
                                        }
                                    } else {
                                        if (com.umeng.ccg.a.f.equalsIgnoreCase(optString2)) {
                                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                            a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", m);
                                        }
                                        if (com.umeng.ccg.a.g.equalsIgnoreCase(optString2)) {
                                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                            a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF", m);
                                        }
                                        if (com.umeng.ccg.a.h.equalsIgnoreCase(optString2)) {
                                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                            a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), com.igexin.sdk.PushConsts.ACTION_BROADCAST_USER_PRESENT, m);
                                        }
                                        if (com.umeng.ccg.a.i.equalsIgnoreCase(optString2) && jSONObject5.has(com.umeng.ccg.a.z)) {
                                            int optInt = jSONObject5.optInt(com.umeng.ccg.a.z);
                                            if (optInt != 0) {
                                                if (optInt == 1) {
                                                    a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", new com.umeng.ccg.d.a());
                                                    break;
                                                }
                                            } else {
                                                a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), optString2, jSONObject5);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            switch (i2) {
                                case 301:
                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    b(com.umeng.ccg.a.f);
                                    if (this.l.containsKey(com.umeng.ccg.a.f) && (bVar = this.l.get(com.umeng.ccg.a.f)) != null) {
                                        org.json.JSONObject a5 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 1, bVar.a(), bVar.b());
                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "screen_on event param: " + a5.toString());
                                        com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.a, a5), 0L, java.util.concurrent.TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 302:
                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    b(com.umeng.ccg.a.g);
                                    if (this.l.containsKey(com.umeng.ccg.a.g) && (bVar2 = this.l.get(com.umeng.ccg.a.g)) != null) {
                                        org.json.JSONObject a6 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 3, bVar2.a(), bVar2.b());
                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "screen_off event param: " + a6.toString());
                                        com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.a, a6), 0L, java.util.concurrent.TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 303:
                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    b(com.umeng.ccg.a.h);
                                    if (this.l.containsKey(com.umeng.ccg.a.h) && (bVar3 = this.l.get(com.umeng.ccg.a.h)) != null) {
                                        org.json.JSONObject a7 = com.umeng.analytics.pro.ao.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 2, bVar3.a(), bVar3.b());
                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "screen_unlock event param: " + a7.toString());
                                        com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.a, a7), 0L, java.util.concurrent.TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 304:
                                    com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "recv INVOKE_APPACT_WHEN_SC_ON msg.");
                                    if (!com.umeng.ccg.b.a(com.umeng.ccg.a.i)) {
                                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "Local switch of [umc_cfg] is off, ignore this command.");
                                        break;
                                    } else {
                                        org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                                        jSONObject7.put(com.umeng.ccg.a.j, 304);
                                        com.umeng.analytics.pro.ab abVar2 = j;
                                        org.json.JSONObject a8 = abVar2.a(abVar2.a(), jSONObject7);
                                        if (a8 == null) {
                                            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "appActAction.process return null !");
                                            break;
                                        } else {
                                            a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), com.umeng.ccg.a.i, a8);
                                            break;
                                        }
                                    }
                                case com.umeng.ccg.c.f452s /* 305 */:
                                    com.umeng.ccg.d.c cVar = (com.umeng.ccg.d.c) obj;
                                    org.json.JSONObject a9 = a(cVar.a, cVar.b, cVar.c);
                                    if (a9 != null) {
                                        com.umeng.analytics.pro.av.a(new com.umeng.analytics.pro.aq(com.umeng.analytics.pro.aq.b, a9), 0L, java.util.concurrent.TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                            }
                    }
            }
            return;
            com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 106, a(), r3);
        } catch (java.lang.Throwable unused3) {
        }
    }

    public synchronized org.json.JSONObject b(android.content.Context context) {
        java.io.File filesDir;
        java.lang.String str;
        java.io.FileInputStream fileInputStream;
        org.json.JSONObject jSONObject = null;
        try {
            filesDir = context.getFilesDir();
            str = b;
        } catch (java.lang.Throwable unused) {
        }
        if (!new java.io.File(filesDir, str).exists()) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput(str);
        } catch (java.lang.Throwable unused2) {
            fileInputStream = null;
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(new java.lang.String(com.umeng.analytics.pro.ax.a(com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(fileInputStream), com.umeng.commonsdk.UMConfigure.sAppkey.getBytes())));
            try {
                com.umeng.analytics.pro.as.a(fileInputStream);
            } catch (java.lang.Throwable unused3) {
            }
            jSONObject = jSONObject2;
        } catch (java.lang.Throwable unused4) {
            com.umeng.analytics.pro.as.a(fileInputStream);
            return jSONObject;
        }
        return jSONObject;
    }
}
