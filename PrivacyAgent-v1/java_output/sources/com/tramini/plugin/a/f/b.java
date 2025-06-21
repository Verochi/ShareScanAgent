package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class b extends com.tramini.plugin.a.f.f {

    /* renamed from: com.tramini.plugin.a.f.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.webkit.WebView a;
        final /* synthetic */ java.util.concurrent.ExecutorService b;
        final /* synthetic */ java.lang.String[] c;

        /* renamed from: com.tramini.plugin.a.f.b$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC05071 implements java.lang.Runnable {

            /* renamed from: com.tramini.plugin.a.f.b$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C05081 implements android.webkit.ValueCallback<java.lang.String> {
                public C05081() {
                }

                private void a(java.lang.String str) {
                    java.util.Properties properties = new java.util.Properties();
                    try {
                        properties.load(new java.io.StringReader("unicodedString=".concat(java.lang.String.valueOf(str))));
                    } catch (java.io.IOException unused) {
                    }
                    java.lang.String property = properties.getProperty("unicodedString");
                    if (property.length() > 2) {
                        com.tramini.plugin.a.f.b.AnonymousClass1.this.c[0] = property.substring(1, property.length() - 1);
                    }
                    synchronized (com.tramini.plugin.a.f.b.AnonymousClass1.this.b) {
                        com.tramini.plugin.a.f.b.AnonymousClass1.this.b.notifyAll();
                    }
                }

                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(java.lang.String str) {
                    java.util.Properties properties = new java.util.Properties();
                    try {
                        properties.load(new java.io.StringReader("unicodedString=".concat(java.lang.String.valueOf(str))));
                    } catch (java.io.IOException unused) {
                    }
                    java.lang.String property = properties.getProperty("unicodedString");
                    if (property.length() > 2) {
                        com.tramini.plugin.a.f.b.AnonymousClass1.this.c[0] = property.substring(1, property.length() - 1);
                    }
                    synchronized (com.tramini.plugin.a.f.b.AnonymousClass1.this.b) {
                        com.tramini.plugin.a.f.b.AnonymousClass1.this.b.notifyAll();
                    }
                }
            }

            public RunnableC05071() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tramini.plugin.a.f.b.AnonymousClass1.this.a.evaluateJavascript("(function() { return (document.getElementsByTagName('html')[0].innerHTML); })();", new com.tramini.plugin.a.f.b.AnonymousClass1.RunnableC05071.C05081());
            }
        }

        public AnonymousClass1(android.webkit.WebView webView, java.util.concurrent.ExecutorService executorService, java.lang.String[] strArr) {
            this.a = webView;
            this.b = executorService;
            this.c = strArr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a == null) {
                    synchronized (this.b) {
                        this.b.notifyAll();
                    }
                }
                this.a.post(new com.tramini.plugin.a.f.b.AnonymousClass1.RunnableC05071());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0210 A[Catch: all -> 0x02ad, TryCatch #4 {all -> 0x02ad, blocks: (B:3:0x002f, B:6:0x003e, B:8:0x0042, B:10:0x004b, B:12:0x0055, B:15:0x006a, B:17:0x0070, B:22:0x0080, B:43:0x0205, B:45:0x0210, B:47:0x0216, B:49:0x021c, B:51:0x0226, B:52:0x022e, B:54:0x0238, B:56:0x023e, B:58:0x0244, B:59:0x0267, B:63:0x0252, B:65:0x0258, B:67:0x026a, B:70:0x0276, B:72:0x027c, B:74:0x0284, B:76:0x028e, B:77:0x0296, B:79:0x029c, B:80:0x02a1, B:87:0x00c1, B:91:0x00e5, B:97:0x01d7, B:98:0x019c, B:100:0x01aa, B:102:0x01d2), top: B:2:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0238 A[Catch: all -> 0x02ad, TryCatch #4 {all -> 0x02ad, blocks: (B:3:0x002f, B:6:0x003e, B:8:0x0042, B:10:0x004b, B:12:0x0055, B:15:0x006a, B:17:0x0070, B:22:0x0080, B:43:0x0205, B:45:0x0210, B:47:0x0216, B:49:0x021c, B:51:0x0226, B:52:0x022e, B:54:0x0238, B:56:0x023e, B:58:0x0244, B:59:0x0267, B:63:0x0252, B:65:0x0258, B:67:0x026a, B:70:0x0276, B:72:0x027c, B:74:0x0284, B:76:0x028e, B:77:0x0296, B:79:0x029c, B:80:0x02a1, B:87:0x00c1, B:91:0x00e5, B:97:0x01d7, B:98:0x019c, B:100:0x01aa, B:102:0x01d2), top: B:2:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026a A[Catch: all -> 0x02ad, TRY_LEAVE, TryCatch #4 {all -> 0x02ad, blocks: (B:3:0x002f, B:6:0x003e, B:8:0x0042, B:10:0x004b, B:12:0x0055, B:15:0x006a, B:17:0x0070, B:22:0x0080, B:43:0x0205, B:45:0x0210, B:47:0x0216, B:49:0x021c, B:51:0x0226, B:52:0x022e, B:54:0x0238, B:56:0x023e, B:58:0x0244, B:59:0x0267, B:63:0x0252, B:65:0x0258, B:67:0x026a, B:70:0x0276, B:72:0x027c, B:74:0x0284, B:76:0x028e, B:77:0x0296, B:79:0x029c, B:80:0x02a1, B:87:0x00c1, B:91:0x00e5, B:97:0x01d7, B:98:0x019c, B:100:0x01aa, B:102:0x01d2), top: B:2:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String str2, long j, long j2, org.json.JSONObject jSONObject, java.lang.String str3, org.json.JSONArray jSONArray, java.lang.String str4) {
        java.lang.String str5;
        org.json.JSONObject jSONObject2;
        java.lang.String str6;
        org.json.JSONObject jSONObject3;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.lang.String str10;
        java.lang.String str11;
        java.lang.String str12;
        int i;
        java.lang.reflect.Field[] fieldArr;
        java.lang.String str13;
        org.json.JSONObject jSONObject4;
        java.lang.String str14;
        org.json.JSONObject jSONObject5;
        java.lang.String str15;
        java.lang.String str16;
        java.lang.String str17;
        int i2;
        java.lang.String str18;
        org.json.JSONObject jSONObject6;
        java.lang.String str19;
        java.lang.String str20;
        java.lang.String str21;
        java.lang.Object obj2 = obj;
        java.lang.String str22 = str + obj.getClass().getName() + ",";
        org.json.JSONObject jSONObject7 = new org.json.JSONObject();
        try {
            java.lang.String str23 = "i_lr";
            java.lang.String str24 = "all";
            java.lang.String str25 = "pkg";
            java.lang.String str26 = "";
            if (!str4.equals("2")) {
                str5 = "2";
                java.util.ArrayList arrayList = new java.util.ArrayList();
                com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
                int size = arrayList.size();
                java.lang.reflect.Field[] fieldArr2 = new java.lang.reflect.Field[size];
                arrayList.toArray(fieldArr2);
                if (size != 0) {
                    java.lang.String str27 = "";
                    java.lang.String str28 = str27;
                    java.lang.String str29 = str28;
                    java.lang.String str30 = str29;
                    jSONObject2 = null;
                    int i3 = 0;
                    while (i3 < size) {
                        java.lang.reflect.Field field = fieldArr2[i3];
                        field.setAccessible(true);
                        java.lang.Object obj3 = field.get(obj2);
                        org.json.JSONObject c = c(obj3, str2);
                        if (c != null) {
                            try {
                                java.lang.String optString = c.optString(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
                                str27 = b(obj3);
                                java.lang.String optString2 = c.optString(com.baidu.mobads.sdk.internal.a.f);
                                if (android.text.TextUtils.isEmpty(str3)) {
                                    fieldArr = fieldArr2;
                                    str13 = str26;
                                } else {
                                    fieldArr = fieldArr2;
                                    try {
                                        str13 = c.optString(str3);
                                    } catch (java.lang.Throwable unused) {
                                        str12 = str26;
                                        i = size;
                                    }
                                }
                                str12 = str26;
                                i = size;
                                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                    try {
                                        java.lang.String optString3 = jSONArray.optString(i4);
                                        java.lang.String optString4 = jSONObject.optString(optString3);
                                        if (android.text.TextUtils.equals(optString4, str25)) {
                                            str29 = optString3;
                                        } else if (android.text.TextUtils.equals(optString4, str24)) {
                                            str30 = optString3;
                                        } else {
                                            try {
                                                if (!android.text.TextUtils.isEmpty(optString4)) {
                                                    java.lang.String a = a(optString4, obj3, c, optString, str27, optString2, str13);
                                                    if (!android.text.TextUtils.isEmpty(a)) {
                                                        jSONObject7.put(optString3, a);
                                                    }
                                                    if (android.text.TextUtils.equals(optString3, str23)) {
                                                        str28 = a;
                                                    }
                                                }
                                            } catch (java.lang.Throwable unused2) {
                                            }
                                        }
                                    } catch (java.lang.Throwable unused3) {
                                    }
                                }
                            } catch (java.lang.Throwable unused4) {
                                str12 = str26;
                                i = size;
                                fieldArr = fieldArr2;
                            }
                        } else {
                            str12 = str26;
                            i = size;
                            fieldArr = fieldArr2;
                            if (obj3 != null && !str22.contains(obj3.getClass().getName())) {
                                i2 = i;
                                jSONObject4 = c;
                                str17 = str25;
                                str18 = str12;
                                str16 = str24;
                                str15 = str23;
                                jSONObject5 = jSONObject7;
                                str14 = str22;
                                com.tramini.plugin.a.d.a a2 = a(obj3, str22, str2, j, j2, jSONObject, str3, jSONArray, str4);
                                if (a2 != null && a2.a != null) {
                                    return a2;
                                }
                                i3++;
                                jSONObject2 = jSONObject4;
                                str26 = str18;
                                size = i2;
                                str25 = str17;
                                str24 = str16;
                                str23 = str15;
                                jSONObject7 = jSONObject5;
                                str22 = str14;
                                fieldArr2 = fieldArr;
                                obj2 = obj;
                            }
                        }
                        jSONObject4 = c;
                        str17 = str25;
                        str16 = str24;
                        str15 = str23;
                        jSONObject5 = jSONObject7;
                        str14 = str22;
                        str18 = str12;
                        i2 = i;
                        i3++;
                        jSONObject2 = jSONObject4;
                        str26 = str18;
                        size = i2;
                        str25 = str17;
                        str24 = str16;
                        str23 = str15;
                        jSONObject7 = jSONObject5;
                        str22 = str14;
                        fieldArr2 = fieldArr;
                        obj2 = obj;
                    }
                    str6 = str26;
                    jSONObject3 = jSONObject7;
                    str7 = str6;
                    str8 = str27;
                    str9 = str28;
                    str10 = str29;
                    str11 = str30;
                    com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                    if (jSONObject3.length() > 0) {
                    }
                }
            } else if (!(obj2 instanceof android.view.ViewGroup) || ((android.view.ViewGroup) obj2).getChildCount() <= 0) {
                str5 = "2";
            } else {
                android.view.View childAt = ((android.view.ViewGroup) obj2).getChildAt(0);
                if (childAt instanceof android.webkit.WebView) {
                    str5 = "2";
                    str19 = a((android.webkit.WebView) childAt, j, j2);
                    if (!android.text.TextUtils.isEmpty(str19)) {
                        str20 = "";
                        str10 = str20;
                        str21 = str10;
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            java.lang.String optString5 = jSONArray.optString(i5);
                            java.lang.String optString6 = jSONObject.optString(optString5);
                            if (android.text.TextUtils.equals(optString6, "pkg")) {
                                str10 = optString5;
                            } else if (android.text.TextUtils.equals(optString6, "all")) {
                                str21 = optString5;
                            } else {
                                try {
                                    if (!android.text.TextUtils.isEmpty(optString6)) {
                                        java.lang.String d = d(optString6, str19);
                                        if (!android.text.TextUtils.isEmpty(d)) {
                                            jSONObject7.put(optString5, d);
                                        }
                                        if (android.text.TextUtils.equals(optString5, "i_lr")) {
                                            str20 = d;
                                        }
                                    }
                                } catch (java.lang.Throwable unused5) {
                                }
                            }
                        }
                        str11 = str21;
                        str8 = "";
                        jSONObject3 = jSONObject7;
                        str7 = str19;
                        str6 = str8;
                        str9 = str20;
                        jSONObject2 = null;
                        com.tramini.plugin.a.d.a aVar2 = new com.tramini.plugin.a.d.a();
                        if (jSONObject3.length() > 0) {
                            java.lang.String str31 = str5;
                            if (str4.equals(str31)) {
                                if (android.text.TextUtils.isEmpty(str7)) {
                                    aVar2.b = new com.tramini.plugin.a.d.a.C0506a("1", str6);
                                } else {
                                    aVar2.b = new com.tramini.plugin.a.d.a.C0506a(str31, str7);
                                }
                            } else if (jSONObject2 == null) {
                                aVar2.b = new com.tramini.plugin.a.d.a.C0506a("1", str6);
                            } else {
                                if (!android.text.TextUtils.isEmpty(str8)) {
                                    jSONObject2.put("obj_source_html", str8);
                                }
                                aVar2.b = new com.tramini.plugin.a.d.a.C0506a(str31, jSONObject2.toString());
                            }
                            return aVar2;
                        }
                        if (!android.text.TextUtils.isEmpty(str9) && !android.text.TextUtils.isEmpty(str10)) {
                            java.lang.String a3 = com.tramini.plugin.a.f.f.a(str9);
                            if (!android.text.TextUtils.isEmpty(a3)) {
                                jSONObject6 = jSONObject3;
                                jSONObject6.put(str10, a3);
                                if (str4.equals(str5)) {
                                    if (jSONObject2 != null && !android.text.TextUtils.isEmpty(str11)) {
                                        jSONObject6.put(str11, com.tramini.plugin.a.h.c.a(jSONObject2.toString().getBytes()));
                                    }
                                } else if (!android.text.TextUtils.isEmpty(str7) && !android.text.TextUtils.isEmpty(str11)) {
                                    jSONObject6.put(str11, com.tramini.plugin.a.h.c.a(str7.getBytes()));
                                }
                                aVar2.a = jSONObject6;
                                return aVar2;
                            }
                        }
                        jSONObject6 = jSONObject3;
                        if (str4.equals(str5)) {
                        }
                        aVar2.a = jSONObject6;
                        return aVar2;
                    }
                } else {
                    str5 = "2";
                }
                str19 = "";
                str20 = str19;
                str10 = str20;
                str21 = str10;
                str11 = str21;
                str8 = "";
                jSONObject3 = jSONObject7;
                str7 = str19;
                str6 = str8;
                str9 = str20;
                jSONObject2 = null;
                com.tramini.plugin.a.d.a aVar22 = new com.tramini.plugin.a.d.a();
                if (jSONObject3.length() > 0) {
                }
            }
            str6 = "";
            jSONObject3 = jSONObject7;
            str10 = str6;
            str7 = str10;
            str9 = str7;
            str8 = str9;
            str11 = str8;
            jSONObject2 = null;
            com.tramini.plugin.a.d.a aVar222 = new com.tramini.plugin.a.d.a();
            if (jSONObject3.length() > 0) {
            }
        } catch (java.lang.Throwable unused6) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str, java.lang.String str2) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), "", jSONObject.optString("tobj_k"), jSONObject.optLong("bwt", 10000L), jSONObject.optLong("bswt", 2000L), jSONObject, jSONObject.optString("bu_k"), cVar.e, str2);
    }

    private static java.lang.String a(android.webkit.WebView webView, long j, long j2) {
        try {
            java.lang.Thread.sleep(j);
        } catch (java.lang.InterruptedException unused) {
        }
        java.util.concurrent.ExecutorService newFixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(2);
        java.lang.String[] strArr = new java.lang.String[1];
        try {
            newFixedThreadPool.submit(new com.tramini.plugin.a.f.b.AnonymousClass1(webView, newFixedThreadPool, strArr));
        } catch (java.lang.Throwable unused2) {
        }
        try {
            synchronized (newFixedThreadPool) {
                newFixedThreadPool.wait(j + j2);
            }
            newFixedThreadPool.shutdown();
            java.lang.String str = strArr[0];
            return str != null ? str : "";
        } catch (java.lang.Exception unused3) {
            return "";
        }
    }

    private static java.lang.String a(java.lang.Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            java.util.ArrayList<java.lang.reflect.Field> arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            for (java.lang.reflect.Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    java.lang.Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof java.lang.String) && ((java.lang.String) obj2).endsWith(".mp4")) {
                        return (java.lang.String) obj2;
                    }
                }
            }
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String a(java.lang.String str, java.lang.Object obj, org.json.JSONObject jSONObject, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.lang.String str6 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("action", -1);
                    java.lang.String optString = optJSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, "");
                    if (optInt != 1) {
                        if (optInt != 2) {
                            if (optInt != 19) {
                                if (optInt != 21) {
                                    if (optInt != 29) {
                                        if (optInt != 39) {
                                            if (optInt != 41) {
                                                switch (optInt) {
                                                    case 11:
                                                        if (!android.text.TextUtils.isEmpty(str2)) {
                                                            str6 = com.tramini.plugin.a.f.f.d.a(str2, optString);
                                                            break;
                                                        } else {
                                                            continue;
                                                        }
                                                    case 12:
                                                        if (!android.text.TextUtils.isEmpty(str2)) {
                                                            java.lang.String c = com.tramini.plugin.a.f.f.c(str2, optString + "=\"(.*?)\"");
                                                            if (!android.text.TextUtils.isEmpty(c)) {
                                                                str6 = c.replace("\"", "");
                                                                break;
                                                            }
                                                            str6 = "";
                                                            break;
                                                        } else {
                                                            continue;
                                                        }
                                                    case 13:
                                                        if (!android.text.TextUtils.isEmpty(str2)) {
                                                            str6 = com.tramini.plugin.a.f.f.d.b(str2, optString);
                                                            break;
                                                        } else {
                                                            continue;
                                                        }
                                                    default:
                                                        switch (optInt) {
                                                            case 31:
                                                                if (!android.text.TextUtils.isEmpty(str4)) {
                                                                    str6 = com.tramini.plugin.a.f.f.c(str4, optString + ".*?\\>(.*?)(</span>|</div>)");
                                                                    break;
                                                                } else {
                                                                    continue;
                                                                }
                                                            case 32:
                                                                if (!android.text.TextUtils.isEmpty(str4)) {
                                                                    str6 = com.tramini.plugin.a.f.f.b(str4, optString + "=(\"|')(.*?)(\"|')", 2);
                                                                    break;
                                                                } else {
                                                                    continue;
                                                                }
                                                            case 33:
                                                                if (android.text.TextUtils.isEmpty(str4)) {
                                                                    continue;
                                                                } else {
                                                                    str6 = com.tramini.plugin.a.f.f.b(str4, "<(img|IMG).*?" + optString + "(.*?)(/>|></img>|>)", 2);
                                                                }
                                                            case 34:
                                                                if (!android.text.TextUtils.isEmpty(str4)) {
                                                                    str6 = com.tramini.plugin.a.f.f.b(str4, "(" + optString + ")(http.*?)(" + optString + ")", 2);
                                                                    break;
                                                                } else {
                                                                    continue;
                                                                }
                                                        }
                                                        break;
                                                }
                                            } else if (android.text.TextUtils.isEmpty(str5)) {
                                                continue;
                                            } else {
                                                str6 = com.tramini.plugin.a.f.f.b.a(str5, optString);
                                            }
                                        } else if (android.text.TextUtils.isEmpty(str4)) {
                                            continue;
                                        } else {
                                            str6 = com.tramini.plugin.a.f.f.b.a(str4, optString);
                                        }
                                    } else if (android.text.TextUtils.isEmpty(str3)) {
                                        continue;
                                    } else {
                                        str6 = com.tramini.plugin.a.f.f.b.a(str3, optString);
                                    }
                                } else if (android.text.TextUtils.isEmpty(str3)) {
                                    continue;
                                } else {
                                    java.util.regex.Matcher matcher = java.util.regex.Pattern.compile(optString, 34).matcher(str3);
                                    if (matcher.find()) {
                                        str6 = matcher.group(1);
                                    }
                                    str6 = "";
                                }
                                if (android.text.TextUtils.isEmpty(str6)) {
                                    return str6;
                                }
                            } else if (android.text.TextUtils.isEmpty(str2)) {
                                continue;
                            } else {
                                str6 = com.tramini.plugin.a.f.f.b.a(str2, optString);
                                if (android.text.TextUtils.isEmpty(str6)) {
                                }
                            }
                        } else if (obj != null) {
                            str6 = a(obj);
                            if (android.text.TextUtils.isEmpty(str6)) {
                            }
                        } else {
                            continue;
                        }
                    } else if (jSONObject != null) {
                        str6 = jSONObject.optString(optString, "");
                        if (android.text.TextUtils.isEmpty(str6)) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    private static java.lang.String b(java.lang.Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            java.util.ArrayList<java.lang.reflect.Field> arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            for (java.lang.reflect.Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    java.lang.Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof java.lang.String) && ((java.lang.String) obj2).contains("<!DOCTYPE html>")) {
                        return (java.lang.String) obj2;
                    }
                }
            }
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static org.json.JSONObject c(java.lang.Object obj, java.lang.String str) {
        try {
            java.util.ArrayList<java.lang.reflect.Field> arrayList = new java.util.ArrayList();
            com.tramini.plugin.a.f.f.a(obj.getClass(), arrayList);
            for (java.lang.reflect.Field field : arrayList) {
                if (field != null) {
                    field.setAccessible(true);
                    java.lang.Object obj2 = field.get(obj);
                    if (obj2 != null && (obj2 instanceof org.json.JSONObject) && !android.text.TextUtils.isEmpty(((org.json.JSONObject) obj2).optString(str, ""))) {
                        return (org.json.JSONObject) obj2;
                    }
                }
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String d(java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.lang.String str3 = "";
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("action", -1);
                    java.lang.String optString = optJSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, "");
                    if (optInt == 101) {
                        if (android.text.TextUtils.isEmpty(str2)) {
                            continue;
                        } else {
                            str3 = com.tramini.plugin.a.f.f.b.a(str2, optString);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        return str3;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }
}
