package com.tramini.plugin.a.f;

/* loaded from: classes19.dex */
public final class a extends com.tramini.plugin.a.f.f {
    static final java.lang.String a = "naitve";
    static final java.lang.String b = "html";
    static final java.lang.String c = "html_background";
    static final java.lang.String d = "html_play";
    static final java.lang.String e = "html_css";
    static final java.lang.String f = "html_x3d";
    static final java.lang.String g = "html_doctype";
    static final java.lang.String h = "html_doctype_write";
    static final java.lang.String i = "html_unknow";
    static final java.lang.String j = "0";
    static final java.lang.String k = "1";
    static final java.lang.String l = "2";
    static final java.lang.String m = "3";
    static final java.lang.String n = "4";
    static final java.lang.String o = "5";
    static final java.lang.String p = "6";
    static final java.lang.String q = "7";
    static final java.lang.String r = "8";

    /* renamed from: s, reason: collision with root package name */
    static final java.lang.String f437s = "9";
    private static final java.lang.String t = org.json.JSONObject.class.getName();

    /* JADX WARN: Removed duplicated region for block: B:103:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[Catch: all -> 0x01e9, TRY_ENTER, TryCatch #1 {all -> 0x01e9, blocks: (B:6:0x0013, B:12:0x003e, B:14:0x0046, B:16:0x0052, B:18:0x005c, B:20:0x0064, B:24:0x00c1, B:25:0x00c8, B:56:0x0179, B:58:0x0184, B:60:0x018a, B:62:0x0194, B:64:0x019a, B:66:0x01a4, B:67:0x01a8, B:69:0x01b2, B:71:0x01b7, B:73:0x01bd, B:74:0x01cc, B:77:0x01d1, B:79:0x01db, B:81:0x0073, B:83:0x007b, B:86:0x0086, B:88:0x008e, B:91:0x0099, B:93:0x00a1, B:96:0x00ac, B:98:0x00b4, B:104:0x0118, B:106:0x0128, B:107:0x012f, B:138:0x0029), top: B:5:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0184 A[Catch: all -> 0x01e9, TryCatch #1 {all -> 0x01e9, blocks: (B:6:0x0013, B:12:0x003e, B:14:0x0046, B:16:0x0052, B:18:0x005c, B:20:0x0064, B:24:0x00c1, B:25:0x00c8, B:56:0x0179, B:58:0x0184, B:60:0x018a, B:62:0x0194, B:64:0x019a, B:66:0x01a4, B:67:0x01a8, B:69:0x01b2, B:71:0x01b7, B:73:0x01bd, B:74:0x01cc, B:77:0x01d1, B:79:0x01db, B:81:0x0073, B:83:0x007b, B:86:0x0086, B:88:0x008e, B:91:0x0099, B:93:0x00a1, B:96:0x00ac, B:98:0x00b4, B:104:0x0118, B:106:0x0128, B:107:0x012f, B:138:0x0029), top: B:5:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.tramini.plugin.a.d.a a(java.lang.Object obj, java.lang.String str, java.lang.String[] strArr, org.json.JSONObject jSONObject, org.json.JSONArray jSONArray, java.lang.String str2) {
        char c2;
        org.json.JSONObject a2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (obj == null) {
            return null;
        }
        try {
            jSONArray.put(jSONArray.length(), "pkg");
            java.util.HashSet hashSet = new java.util.HashSet();
            int i2 = 0;
            if (str2.hashCode() == 48 && str2.equals("0")) {
                c2 = 0;
                if (c2 == 0) {
                    a2 = a(obj, hashSet, strArr[0], str);
                    if (a2 != null) {
                        java.lang.String optString = a2.optString(strArr[0]);
                        if (!android.text.TextUtils.isEmpty(optString)) {
                            java.lang.String str6 = i;
                            if (optString.contains("div id=\"mys-wrapper\" class=\"mys-wrapper\">")) {
                                if (!optString.contains("https://rr") && !optString.contains(".mp4")) {
                                    str6 = c;
                                }
                                str6 = "html";
                            } else if (optString.contains("html5AdData") && optString.contains("google_template_data")) {
                                str6 = d;
                            } else if (optString.contains("<link") && optString.contains("type=\"text/css")) {
                                str6 = e;
                            } else if (optString.contains("new videoInterstitial") && optString.contains("x3c")) {
                                str6 = f;
                            } else if (optString.contains("<!doctype html>")) {
                                str6 = optString.contains("doc.write") ? h : g;
                            }
                            java.lang.String d2 = d(optString, str6);
                            str3 = "";
                            str4 = str3;
                            str5 = str4;
                            while (i2 < jSONArray.length()) {
                                try {
                                    java.lang.String optString2 = jSONArray.optString(i2);
                                    java.lang.String optString3 = jSONObject.optString(optString2);
                                    if (android.text.TextUtils.equals(optString3, "pkg")) {
                                        str3 = optString2;
                                    } else if (android.text.TextUtils.equals(optString3, "all")) {
                                        str5 = optString2;
                                    } else if (!android.text.TextUtils.isEmpty(optString3)) {
                                        java.lang.String a3 = a(d2, str6, optString2, jSONObject);
                                        if (android.text.TextUtils.equals(optString2, "i_lr")) {
                                            str4 = a3;
                                        }
                                        if (!android.text.TextUtils.isEmpty(a3)) {
                                            if (optString2.equals("pkg") && !android.text.TextUtils.isEmpty(str3)) {
                                                jSONObject2.put(str3, a3);
                                            }
                                            jSONObject2.put(optString2, a3);
                                        }
                                    }
                                } catch (java.lang.Throwable unused) {
                                }
                                i2++;
                            }
                        }
                    }
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                } else {
                    a2 = a(obj, hashSet, strArr[1], str);
                    java.lang.String jSONObject3 = a2.toString();
                    if (!android.text.TextUtils.isEmpty(jSONObject3)) {
                        java.lang.String d3 = d(jSONObject3, a);
                        str3 = "";
                        str4 = str3;
                        str5 = str4;
                        while (i2 < jSONArray.length()) {
                            try {
                                java.lang.String optString4 = jSONArray.optString(i2);
                                java.lang.String optString5 = jSONObject.optString(optString4);
                                if (android.text.TextUtils.equals(optString5, "pkg")) {
                                    str3 = optString4;
                                } else if (android.text.TextUtils.equals(optString5, "all")) {
                                    str5 = optString4;
                                } else if (!android.text.TextUtils.isEmpty(optString5)) {
                                    java.lang.String a4 = a(d3, a, optString4, jSONObject);
                                    if (android.text.TextUtils.equals(optString4, "i_lr")) {
                                        str4 = a4;
                                    }
                                    if (!android.text.TextUtils.isEmpty(a4)) {
                                        if (optString4.equals("pkg") && !android.text.TextUtils.isEmpty(str3)) {
                                            jSONObject2.put(str3, a4);
                                        }
                                        jSONObject2.put(optString4, a4);
                                    }
                                }
                            } catch (java.lang.Throwable unused2) {
                            }
                            i2++;
                        }
                    }
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                }
                com.tramini.plugin.a.d.a aVar = new com.tramini.plugin.a.d.a();
                if (jSONObject2.length() > 0) {
                    if (a2 == null) {
                        aVar.b = new com.tramini.plugin.a.d.a.C0506a("1", "");
                    } else {
                        aVar.b = new com.tramini.plugin.a.d.a.C0506a("2", a2.toString());
                    }
                    return aVar;
                }
                if (!android.text.TextUtils.isEmpty(str3) && android.text.TextUtils.isEmpty(jSONObject2.optString(str3, "")) && !android.text.TextUtils.isEmpty(str4)) {
                    java.lang.String b2 = com.tramini.plugin.a.f.f.b(str4);
                    if (android.text.TextUtils.isEmpty(b2)) {
                        java.lang.String a5 = com.tramini.plugin.a.f.f.a(str4);
                        if (!android.text.TextUtils.isEmpty(a5)) {
                            jSONObject2.put(str3, a5);
                        }
                    } else {
                        jSONObject2.put(str3, b2);
                    }
                }
                if (a2 != null && !android.text.TextUtils.isEmpty(str5)) {
                    jSONObject2.put(str5, com.tramini.plugin.a.h.c.a(a2.toString().getBytes()));
                }
                aVar.a = jSONObject2;
                return aVar;
            }
            c2 = 65535;
            if (c2 == 0) {
            }
            com.tramini.plugin.a.d.a aVar2 = new com.tramini.plugin.a.d.a();
            if (jSONObject2.length() > 0) {
            }
        } catch (java.lang.Throwable unused3) {
            return null;
        }
    }

    public static com.tramini.plugin.a.d.a a(org.json.JSONObject jSONObject, com.tramini.plugin.a.d.c cVar, java.lang.String str, java.lang.String str2) {
        return a(com.tramini.plugin.a.f.f.a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), a(jSONObject.optJSONArray("p_key")), jSONObject, cVar.e, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject) {
        char c2;
        switch (str2.hashCode()) {
            case -1852354744:
                if (str2.equals(d)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1851164744:
                if (str2.equals(i)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1747666366:
                if (str2.equals(c)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1052935859:
                if (str2.equals(a)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -336860305:
                if (str2.equals(e)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -336842123:
                if (str2.equals(f)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3213227:
                if (str2.equals("html")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 45377598:
                if (str2.equals(h)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 562203614:
                if (str2.equals(g)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return e(jSONObject.optJSONObject(str3).optString("0"), str);
            case 1:
                return e(jSONObject.optJSONObject(str3).optString("1"), str);
            case 2:
                return e(jSONObject.optJSONObject(str3).optString("2"), str);
            case 3:
                return e(jSONObject.optJSONObject(str3).optString("5"), str);
            case 4:
                return e(jSONObject.optJSONObject(str3).optString("7"), str);
            case 5:
                java.lang.String optString = jSONObject.optString("3");
                java.lang.String optString2 = jSONObject.optString("4");
                java.lang.String a2 = com.tramini.plugin.a.f.f.b.a(str, optString);
                if (android.text.TextUtils.isEmpty(a2)) {
                    return e(jSONObject.optJSONObject(str3).optString("4"), com.tramini.plugin.a.f.f.b.a(str, optString2));
                }
                return e(jSONObject.optJSONObject(str3).optString("3"), com.tramini.plugin.a.f.f.d(a2));
            case 6:
                java.lang.String a3 = com.tramini.plugin.a.f.f.b.a(str, jSONObject.optString("6"));
                if (android.text.TextUtils.isEmpty(a3)) {
                    return "";
                }
                return e(jSONObject.optJSONObject(str3).optString("3"), com.tramini.plugin.a.f.f.d(a3));
            case 7:
                return e(jSONObject.optJSONObject(str3).optString("2"), com.tramini.plugin.a.f.f.b.a(str, jSONObject.optString("8")));
            default:
                return e(jSONObject.optJSONObject(str3).optString("9"), str);
        }
    }

    private static org.json.JSONObject a(java.lang.Object obj, java.util.Set<java.lang.Object> set, java.lang.String str, java.lang.String str2) {
        if (obj != null && !set.contains(obj)) {
            set.add(obj);
            java.lang.Class<?> cls = obj.getClass();
            java.util.ArrayList<java.lang.reflect.Field> arrayList = new java.util.ArrayList();
            do {
                arrayList.addAll(java.util.Arrays.asList(cls.getDeclaredFields()));
                cls = cls.getSuperclass();
            } while (cls.getName().startsWith(str2));
            for (java.lang.reflect.Field field : arrayList) {
                field.setAccessible(true);
                try {
                    java.lang.Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        if (!field.getType().getName().equals("interface") && !obj2.getClass().getName().startsWith(str2)) {
                            if (field.getType().getName().equals(t)) {
                                org.json.JSONObject jSONObject = (org.json.JSONObject) obj2;
                                if (jSONObject.has(str)) {
                                    return jSONObject;
                                }
                            } else {
                                continue;
                            }
                        }
                        org.json.JSONObject a2 = a(obj2, set, str, str2);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        return null;
    }

    private static java.lang.String[] a(org.json.JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            java.lang.String[] strArr = new java.lang.String[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    strArr[i2] = jSONArray.getString(i2);
                } catch (org.json.JSONException unused) {
                    return strArr;
                }
            }
            return strArr;
        } catch (org.json.JSONException unused2) {
            return null;
        }
    }

    private static java.lang.String d(java.lang.String str, java.lang.String str2) {
        str2.hashCode();
        switch (str2) {
            case "html_play":
            case "html_x3d":
                return f(com.tramini.plugin.a.f.f.c(str.replace("\\\\\\\\x", "%").replaceAll("\\\\x", "%").replaceAll("\\\\n", "")));
            case "naitve":
                return str.replace("\\/", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            case "html_doctype_write":
                return f(com.tramini.plugin.a.f.f.c(str.replace("x22", "\"").replace("x26", "&").replace("x27", "'").replace("x3c", "<").replace("x3d", com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).replace("x3e", ">")));
            default:
                return f(com.tramini.plugin.a.f.f.c(str));
        }
    }

    private static java.lang.String e(java.lang.String str) {
        return str.contains("div id=\"mys-wrapper\" class=\"mys-wrapper\">") ? (str.contains("https://rr") || str.contains(".mp4")) ? "html" : c : (str.contains("html5AdData") && str.contains("google_template_data")) ? d : (str.contains("<link") && str.contains("type=\"text/css")) ? e : (str.contains("new videoInterstitial") && str.contains("x3c")) ? f : str.contains("<!doctype html>") ? str.contains("doc.write") ? h : g : i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String e(java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(str);
            java.lang.String str3 = "";
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt("action", -1);
                    java.lang.String optString = optJSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, "");
                    if (optInt != 11) {
                        if (optInt != 13) {
                            if (optInt != 101) {
                                if (optInt == 102) {
                                    if (android.text.TextUtils.isEmpty(str2)) {
                                        continue;
                                    } else {
                                        str3 = com.tramini.plugin.a.f.f.c(str2, "'" + optString + "'\\s*:\\s*'(.*?)'");
                                    }
                                }
                                if (android.text.TextUtils.isEmpty(str3)) {
                                    return str3;
                                }
                            } else if (android.text.TextUtils.isEmpty(str2)) {
                                continue;
                            } else {
                                str3 = com.tramini.plugin.a.f.f.b.a(str2, optString);
                                if (android.text.TextUtils.isEmpty(str3)) {
                                }
                            }
                        } else if (android.text.TextUtils.isEmpty(str2)) {
                            continue;
                        } else {
                            str3 = com.tramini.plugin.a.f.f.d.b(str2, optString);
                            if (android.text.TextUtils.isEmpty(str3)) {
                            }
                        }
                    } else if (android.text.TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        str3 = com.tramini.plugin.a.f.f.d.a(str2, optString);
                        if (android.text.TextUtils.isEmpty(str3)) {
                        }
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    private static java.lang.String f(java.lang.String str) {
        return str.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }
}
