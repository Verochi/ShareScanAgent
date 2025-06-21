package com.meizu.cloud.pushsdk.handler.a.c;

/* loaded from: classes23.dex */
public class e {
    private int a;
    private java.lang.String b = java.lang.String.valueOf(-1);
    private java.lang.String c = "";
    private java.lang.String d = "";
    private int e = -1;
    private java.lang.String f = "";

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        java.lang.String c;

        public a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (!jSONObject.isNull("code")) {
                    a(jSONObject.getString("code"));
                }
                if (!jSONObject.isNull("message")) {
                    b(jSONObject.getString("message"));
                }
                if (jSONObject.isNull("value")) {
                    return;
                }
                c(jSONObject.getString("value"));
            } catch (org.json.JSONException e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("SecurityMessage", "covert json error " + e.getMessage());
            }
        }

        public java.lang.String a() {
            return this.c;
        }

        public void a(java.lang.String str) {
            this.a = str;
        }

        public void b(java.lang.String str) {
            this.b = str;
        }

        public void c(java.lang.String str) {
            this.c = str;
        }

        public java.lang.String toString() {
            return "PublicKeyStatus{code='" + this.a + "', message='" + this.b + "', publicKey='" + this.c + "'}";
        }
    }

    public static java.lang.String a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        org.json.JSONObject jSONObject;
        java.lang.String notificationMessage = messageV3.getNotificationMessage();
        java.lang.String str = null;
        try {
            try {
                if (!android.text.TextUtils.isEmpty(notificationMessage)) {
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject(notificationMessage).getJSONObject("data");
                        if (!jSONObject2.isNull("extra")) {
                            org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("extra");
                            if (!jSONObject3.isNull("se")) {
                                str = jSONObject3.getString("se");
                            }
                        }
                    } catch (org.json.JSONException e) {
                        com.meizu.cloud.pushinternal.DebugLogger.e("SecurityMessage", "parse notification message error " + e.getMessage());
                        if (android.text.TextUtils.isEmpty(null)) {
                            jSONObject = new org.json.JSONObject(notificationMessage);
                        }
                    }
                    if (android.text.TextUtils.isEmpty(str)) {
                        jSONObject = new org.json.JSONObject(notificationMessage);
                        str = jSONObject.getString("se");
                    }
                }
            } catch (java.lang.Throwable th) {
                if (android.text.TextUtils.isEmpty(null)) {
                    try {
                        new org.json.JSONObject(notificationMessage).getString("se");
                    } catch (java.lang.Exception unused) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("SecurityMessage", "encrypt message " + str);
        return str;
    }

    public static boolean a(java.lang.String str, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        java.lang.String str2;
        com.meizu.cloud.pushsdk.handler.a.c.e e = e(str);
        com.meizu.cloud.pushinternal.DebugLogger.e("SecurityMessage", "securityMessage " + e);
        if (java.lang.System.currentTimeMillis() / 1000 > e.a()) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e.d())) {
            str2 = "invalid content";
        } else if (!java.lang.String.valueOf(-1).equals(e.b()) && !e.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else {
            if (e.e() != -1) {
                int e2 = e.e();
                if (e2 == 1) {
                    if (!messageV3.getActivity().contains(e.f())) {
                        str2 = "invalid click activity";
                    }
                    return true;
                }
                if (e2 == 2) {
                    if (!messageV3.getWebUrl().contains(e.f())) {
                        str2 = "invalid web url";
                    }
                    return true;
                }
                if (e2 == 3 && !com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e.f())) {
                    str2 = "invalid self define";
                }
                return true;
            }
            str2 = "invalid click type";
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("SecurityMessage", str2);
        return false;
    }

    private static com.meizu.cloud.pushsdk.handler.a.c.e e(java.lang.String str) {
        com.meizu.cloud.pushsdk.handler.a.c.e eVar = new com.meizu.cloud.pushsdk.handler.a.c.e();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.isNull("tt")) {
                eVar.a(jSONObject.getInt("tt"));
            }
            if (!jSONObject.isNull("ti")) {
                eVar.a(jSONObject.getString("ti"));
            }
            if (!jSONObject.isNull("tl")) {
                eVar.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                eVar.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull(com.anythink.expressad.d.a.b.dx)) {
                eVar.b(jSONObject.getInt(com.anythink.expressad.d.a.b.dx));
            }
            if (!jSONObject.isNull("pm")) {
                eVar.d(jSONObject.getString("pm"));
            }
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("SecurityMessage", "parse decryptSign error " + e.getMessage());
        }
        return eVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String c() {
        return this.c;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public java.lang.String d() {
        return this.d;
    }

    public void d(java.lang.String str) {
        this.f = str;
    }

    public int e() {
        return this.e;
    }

    public java.lang.String f() {
        return this.f;
    }

    public java.lang.String toString() {
        return "SecurityMessage{timestamp=" + this.a + ", taskId='" + this.b + "', title='" + this.c + "', content='" + this.d + "', clickType=" + this.e + ", params='" + this.f + "'}";
    }
}
