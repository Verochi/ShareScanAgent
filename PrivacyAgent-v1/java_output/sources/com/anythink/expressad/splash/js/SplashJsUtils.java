package com.anythink.expressad.splash.js;

/* loaded from: classes12.dex */
public class SplashJsUtils {
    public static final java.lang.String a = "onSystemPause";
    public static final java.lang.String b = "onSystemResume";
    public static final java.lang.String c = "onSystemDestory";
    private static java.lang.String d = "SplashJsUtils";
    private static int e = 0;
    private static int f = 1;

    /* renamed from: com.anythink.expressad.splash.js.SplashJsUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.anythink.expressad.splash.js.SplashJsUtils.a(this.a.K(), this.a);
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.splash.js.SplashJsUtils.d;
                th.getMessage();
            }
        }
    }

    public static /* synthetic */ void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (com.anythink.expressad.foundation.g.a.f.o == null || android.text.TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(str, cVar, "splash");
    }

    private static void b(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (com.anythink.expressad.foundation.g.a.f.o == null || android.text.TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(str, cVar, "splash");
    }

    public static void callbackExcep(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", f);
            jSONObject.put("message", str);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public static void callbackSuccess(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", e);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            callbackExcep(obj, e2.getMessage());
            e2.getMessage();
        }
    }

    public static java.lang.String codeToJsonString(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static void fireOnJSBridgeConnected(android.webkit.WebView webView) {
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static void getFileInfo(java.lang.Object obj, org.json.JSONObject jSONObject) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.io.File file;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        java.lang.String str6 = "message";
        java.lang.String str7 = "code";
        int i = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (org.json.JSONException e2) {
                e2.getMessage();
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                org.json.JSONArray jSONArray2 = new org.json.JSONArray();
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    org.json.JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    java.lang.String optString = jSONObject3.optString("ref", "");
                    int i3 = jSONObject3.getInt("type");
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    if (i3 != i || android.text.TextUtils.isEmpty(optString)) {
                        str3 = str6;
                        str4 = str7;
                        if (i3 == 2 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", com.anythink.expressad.videocommon.b.i.a().c(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i3 == 3 && !android.text.TextUtils.isEmpty(optString)) {
                            try {
                                file = new java.io.File(optString);
                            } catch (java.lang.Throwable th) {
                                if (com.anythink.expressad.a.a) {
                                    th.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                str5 = "file:////".concat(java.lang.String.valueOf(optString));
                                org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put("path", str5);
                                jSONObject4.put(optString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            }
                            str5 = "";
                            org.json.JSONObject jSONObject62 = new org.json.JSONObject();
                            jSONObject62.put("type", 3);
                            jSONObject62.put("path", str5);
                            jSONObject4.put(optString, jSONObject62);
                            jSONArray2.put(jSONObject4);
                        } else if (i3 == 4 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", com.anythink.expressad.foundation.h.s.a(optString) == null ? "" : com.anythink.expressad.foundation.h.s.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                        i2++;
                        str7 = str4;
                        str6 = str3;
                        i = 1;
                    } else {
                        org.json.JSONObject jSONObject8 = new org.json.JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        com.anythink.core.common.a.j b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            jSONObject8.put("type", i);
                            str3 = str6;
                            str4 = str7;
                            try {
                                jSONObject8.put("videoDataLength", b2.d());
                                java.lang.String b3 = b2.b();
                                if (android.text.TextUtils.isEmpty(b3)) {
                                    jSONObject8.put("path", "");
                                    jSONObject8.put("path4Web", "");
                                } else {
                                    jSONObject8.put("path", b3);
                                    jSONObject8.put("path4Web", b3);
                                }
                                if (b2.c() == 100) {
                                    jSONObject8.put("downloaded", 1);
                                } else {
                                    jSONObject8.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject4);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                str2 = str4;
                            }
                        } else {
                            str3 = str6;
                            str4 = str7;
                        }
                        i2++;
                        str7 = str4;
                        str6 = str3;
                        i = 1;
                    }
                }
                str3 = str6;
                str4 = str7;
                jSONObject2.put("resource", jSONArray2);
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str3 = "message";
            str2 = "code";
            str = 1;
            try {
                try {
                    jSONObject2.put(str2, 1);
                    try {
                        jSONObject2.put(str3, "resource is null");
                        com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (org.json.JSONException e3) {
                        e = e3;
                        e.getMessage();
                        return;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (org.json.JSONException e4) {
                e = e4;
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
            str = str3;
        } catch (java.lang.Throwable th5) {
            th = th5;
            str = str6;
            str2 = str7;
        }
        try {
            jSONObject2.put(str2, 1);
            jSONObject2.put(str, th.getLocalizedMessage());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (org.json.JSONException e5) {
            e5.getMessage();
        }
    }

    public static void increaseOfferFrequence(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                callbackExcep(obj, "data is empty");
                return;
            }
            com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject);
            if (b2 == null) {
                callbackExcep(obj, "data camapign is empty");
            } else {
                updateFrequence(b2);
                callbackSuccess(obj, "");
            }
        } catch (java.lang.Throwable th) {
            callbackExcep(obj, th.getMessage());
        }
    }

    public static void sendEventToH5(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(webView, str, str2);
    }

    public static void updateFrequence(com.anythink.expressad.foundation.d.c cVar) {
        new java.lang.Thread(new com.anythink.expressad.splash.js.SplashJsUtils.AnonymousClass1(cVar)).start();
    }
}
