package com.anythink.expressad.advanced.js;

/* loaded from: classes12.dex */
public class NativeAdvancedJsUtils {
    public static final java.lang.String a = "onViewDisappeared";
    public static final java.lang.String b = "onViewAppeared";
    public static final java.lang.String c = "onSystemDestory";
    public static final java.lang.String d = "setStyleList";
    public static final java.lang.String e = "params";
    public static final java.lang.String f = "showCloseButton";
    public static final java.lang.String g = "hideCloseButton";
    public static final java.lang.String h = "setVolume";
    public static final java.lang.String i = "mute";
    public static final java.lang.String j = "setVideoPlayMode";
    public static final java.lang.String k = "autoPlay";
    public static final java.lang.String l = "onNetstatChanged";
    public static final java.lang.String m = "netstat";
    public static final java.lang.String n = "sq";
    public static final java.lang.String o = "thirdPartyCalled";
    public static final java.lang.String p = "action";
    public static final java.lang.String q = "params";
    private static java.lang.String r = "NativeAdvancedJsUtils";

    /* renamed from: com.anythink.expressad.advanced.js.NativeAdvancedJsUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.webkit.WebView a;
        final /* synthetic */ org.json.JSONObject b;

        public AnonymousClass1(android.webkit.WebView webView, org.json.JSONObject jSONObject) {
            this.a = webView;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.a, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.o, android.util.Base64.encodeToString(this.b.toString().getBytes(), 2));
        }
    }

    public static void callbackSuccess(java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.b);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
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
        int i2 = 1;
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
                int i3 = 0;
                while (i3 < length) {
                    org.json.JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    java.lang.String optString = jSONObject3.optString("ref", "");
                    int i4 = jSONObject3.getInt("type");
                    org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                    if (i4 != i2 || android.text.TextUtils.isEmpty(optString)) {
                        str3 = str6;
                        str4 = str7;
                        if (i4 == 2 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
                            jSONObject5.put("type", 2);
                            jSONObject5.put("path", com.anythink.expressad.videocommon.b.i.a().c(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                            jSONObject4.put(optString, jSONObject5);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 3 && !android.text.TextUtils.isEmpty(optString)) {
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
                        } else if (i4 == 4 && !android.text.TextUtils.isEmpty(optString)) {
                            org.json.JSONObject jSONObject7 = new org.json.JSONObject();
                            jSONObject7.put("type", 4);
                            jSONObject7.put("path", com.anythink.expressad.foundation.h.s.a(optString) == null ? "" : com.anythink.expressad.foundation.h.s.a(optString));
                            jSONObject4.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        }
                        i3++;
                        str7 = str4;
                        str6 = str3;
                        i2 = 1;
                    } else {
                        org.json.JSONObject jSONObject8 = new org.json.JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        com.anythink.core.common.a.j b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            jSONObject8.put("type", i2);
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
                        i3++;
                        str7 = str4;
                        str6 = str3;
                        i2 = 1;
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

    public static void sendEventToH5(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a(webView, str, str2);
    }

    public static void sendThirdToH5(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(n, 1);
            jSONObject.put("action", str);
            if (!android.text.TextUtils.isEmpty(str2)) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (android.text.TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            com.anythink.core.common.b.o.a().b(new com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.AnonymousClass1(webView, jSONObject));
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
    }
}
