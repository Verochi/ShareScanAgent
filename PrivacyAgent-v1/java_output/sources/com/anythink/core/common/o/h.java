package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class h {
    static java.util.Random a = new java.util.Random();

    public static class a {
        public static final java.lang.String a = "com.android.vending";
    }

    public static double a(com.anythink.core.common.f.au auVar) {
        if (auVar != null) {
            return auVar.af();
        }
        return 0.0d;
    }

    private static int a(int i, int[] iArr, int i2) {
        if (iArr == null) {
            return i2;
        }
        for (int i3 : iArr) {
            if (i == i3) {
                return i;
            }
        }
        return i2;
    }

    public static java.lang.String a() {
        return android.text.TextUtils.isEmpty("UA_6.2.66") ? "UA_0.0.0" : "UA_6.2.66";
    }

    public static java.lang.String a(int i) {
        switch (i) {
            case 2:
                return "c2s";
            case 3:
                return "s2s";
            case 4:
                return "adx";
            case 5:
                return "adx open";
            case 6:
            case 10:
            default:
                return "";
            case 7:
                return "fb in-house";
            case 8:
                return "directly";
            case 9:
                return "dynamic";
            case 11:
                return "custom in-house";
        }
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String x = com.anythink.core.common.b.o.a().x();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(com.anythink.core.common.o.e.d(context));
        stringBuffer.append("&");
        stringBuffer.append(com.anythink.core.common.o.e.f());
        stringBuffer.append("&");
        stringBuffer.append(x);
        stringBuffer.append("&");
        stringBuffer.append(java.lang.System.currentTimeMillis());
        stringBuffer.append("&");
        stringBuffer.append(new java.util.Random().nextInt(10000));
        return com.anythink.core.common.o.g.a(stringBuffer.toString());
    }

    public static java.lang.String a(com.anythink.core.common.f.l lVar) {
        return com.anythink.core.common.o.g.a(lVar.s() + lVar.D());
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, long j) {
        return str + "_" + str2 + "_" + j;
    }

    public static java.util.List<com.anythink.core.common.f.au> a(java.util.List<com.anythink.core.common.f.au> list, com.anythink.core.common.g.d dVar) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.HashMap hashMap = new java.util.HashMap(3);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.anythink.core.common.f.au auVar : list) {
            double a2 = a(auVar);
            java.util.List list2 = (java.util.List) linkedHashMap.get(java.lang.String.valueOf(a2));
            if (list2 == null) {
                list2 = new java.util.ArrayList();
                linkedHashMap.put(java.lang.String.valueOf(a2), list2);
            }
            java.lang.Integer num = (java.lang.Integer) hashMap.get(java.lang.String.valueOf(a2));
            if (num == null) {
                num = 0;
            }
            hashMap.put(java.lang.String.valueOf(a2), java.lang.Integer.valueOf(num.intValue() + auVar.R()));
            list2.add(auVar);
        }
        int i = 0;
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            java.util.List list3 = (java.util.List) entry.getValue();
            int intValue = ((java.lang.Integer) hashMap.get(entry.getKey())).intValue();
            int i2 = -1;
            while (true) {
                if (list3.size() <= 0) {
                    break;
                }
                if (list3.size() == 1) {
                    com.anythink.core.common.f.au auVar2 = (com.anythink.core.common.f.au) list3.get(0);
                    arrayList.add(auVar2);
                    list3.remove(0);
                    if (dVar != null) {
                        dVar.a(auVar2, i, i2);
                    }
                    i++;
                } else {
                    int nextInt = a.nextInt(intValue) + 1;
                    java.util.Iterator it = list3.iterator();
                    int i3 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            com.anythink.core.common.f.au auVar3 = (com.anythink.core.common.f.au) it.next();
                            if (auVar3.R() + i3 >= nextInt) {
                                arrayList.add(auVar3);
                                list3.remove(auVar3);
                                intValue -= auVar3.R();
                                if (i2 == -1) {
                                    i2 = 0;
                                }
                                if (dVar != null) {
                                    dVar.a(auVar3, i, i2);
                                }
                                i2++;
                                i++;
                            } else {
                                i3 += auVar3.R();
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static org.json.JSONObject a(android.content.Context context, java.lang.String str, java.lang.String str2, int i, int i2) {
        int[] a2 = com.anythink.core.a.a.a(context).a(i);
        int i3 = a2[0];
        int i4 = a2[1];
        com.anythink.core.common.f.an a3 = com.anythink.core.a.a.a(context).a(str2, i);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("sr", "tp");
            jSONObject.put("rid", str);
            jSONObject.put(com.anythink.expressad.foundation.d.d.h, i3);
            jSONObject.put("ahs", i4);
            jSONObject.put("pds", a3 != null ? a3.c : 0);
            jSONObject.put("phs", a3 != null ? a3.d : 0);
            jSONObject.put("ap", i2);
            jSONObject.put("tpl", str2);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public static void a(android.webkit.WebView webView) {
        if (webView == null) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxjavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setSavePassword(false);
    }

    private static void a(java.lang.String str, java.util.List<com.anythink.core.common.f.au> list) {
        if (list != null) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.anythink.core.common.f.au auVar = list.get(i);
                    sb.append("\n");
                    sb.append(i);
                    sb.append(" --> adSourceId: ");
                    sb.append(auVar.u());
                    sb.append(", ");
                    sb.append(auVar.e());
                    sb.append(", real: ");
                    sb.append(auVar.y());
                    sb.append(", sort: ");
                    sb.append(a(auVar));
                    java.lang.String A = auVar.A();
                    if (!android.text.TextUtils.isEmpty(A)) {
                        sb.append(", errorMsg: ");
                        sb.append(A);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(java.util.List<com.anythink.core.common.f.au> list, com.anythink.core.common.f.au auVar) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(auVar);
            return;
        }
        int i = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.core.common.f.au auVar2 = list.get(i2);
            double a2 = a(auVar);
            double a3 = a(auVar2);
            boolean z = true;
            if (a2 >= a3) {
                list.add(i2, auVar);
            } else if (i2 == i) {
                list.add(auVar);
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
    }

    public static void a(java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.h hVar) {
        if (hVar == null || hVar.M() >= 100000) {
            return;
        }
        map.put(com.anythink.core.common.b.h.o.h, hVar);
    }

    public static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.length() > 128) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Invalid Channel(");
            sb.append(str);
            sb.append("):Channel'length over 128");
            return false;
        }
        if (java.util.regex.Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Invalid Channel(");
        sb2.append(str);
        sb2.append("): contains some characters that are not in the ");
        sb2.append("^([.A-Za-z0-9_-]){1,128}$");
        return false;
    }

    private static boolean a(java.util.List<com.anythink.core.common.f.au> list, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.au auVar2, int i, int i2, boolean z) {
        if (z && auVar.b() == -1) {
            list.add(i, auVar2);
            return true;
        }
        if (a(auVar2) >= a(auVar)) {
            list.add(i, auVar2);
            return true;
        }
        if (i != i2) {
            return false;
        }
        list.add(auVar2);
        return true;
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2, long j) {
        return a(str, str2, j) + "_refresh";
    }

    public static boolean b() {
        try {
            java.util.Map<java.lang.String, java.lang.Object> l = com.anythink.core.common.b.o.a().l();
            if (l == null || !l.containsKey(com.anythink.core.api.ATCustomRuleKeys.AGE)) {
                return false;
            }
            return java.lang.Integer.parseInt(l.get(com.anythink.core.api.ATCustomRuleKeys.AGE).toString()) <= 13;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean b(android.content.Context context) {
        return com.anythink.core.common.o.s.a().a(context);
    }

    public static boolean b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.length() > 128) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Invalid SubChannel(");
            sb.append(str);
            sb.append("):SubChannel'length over 128");
            return false;
        }
        if (java.util.regex.Pattern.matches("^([.A-Za-z0-9_-]){1,128}$", str)) {
            return true;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Invalid SubChannel(");
        sb2.append(str);
        sb2.append("):SubChannel contains some characters that are not in the ");
        sb2.append("^([.A-Za-z0-9_-]){1,128}$");
        return false;
    }

    public static boolean c() {
        return com.anythink.core.common.o.s.a().b();
    }

    public static boolean c(android.content.Context context) {
        return com.anythink.core.common.o.s.a().b(context);
    }

    public static boolean c(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.length() > 50) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Invalid ScenarioId(");
                sb.append(str);
                sb.append("):The length of ScenarioId must be between 1-50.");
            } else {
                if (!java.util.regex.Pattern.matches(".*[\\u4E00-\\u9FFF\\s]+.*", str)) {
                    return true;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Invalid ScenarioId(");
                sb2.append(str);
                sb2.append("):ScenarioId cannot contain spaces or chinese characters.");
            }
        }
        return false;
    }

    private static java.lang.String d(android.content.Context context) {
        java.lang.String x = com.anythink.core.common.b.o.a().x();
        if (android.text.TextUtils.isEmpty(x)) {
            x = com.anythink.core.common.o.e.d(context) + com.anythink.core.common.o.e.f();
        }
        return com.anythink.core.common.o.g.a(x + java.util.UUID.randomUUID().toString());
    }

    public static java.lang.String d(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "0":
                return com.anythink.core.common.b.h.i.a;
            case "1":
                return com.anythink.core.common.b.h.i.b;
            case "2":
                return com.anythink.core.common.b.h.i.c;
            case "3":
                return "Interstitial";
            case "4":
                return com.anythink.core.common.b.h.i.e;
            default:
                return "";
        }
    }
}
