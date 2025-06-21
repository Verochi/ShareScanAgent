package com.anythink.expressad.video.bt.a;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String c = "HandlerH5MessageManager";
    int a;
    int b;
    private java.lang.String d;

    public static final class a {
        private static com.anythink.expressad.video.bt.a.b a = new com.anythink.expressad.video.bt.a.b((byte) 0);

        private a() {
        }
    }

    private b() {
        this.d = "handlerNativeResult";
        this.a = 0;
        this.b = 1;
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static com.anythink.expressad.video.bt.a.b a() {
        return com.anythink.expressad.video.bt.a.b.a.a;
    }

    private static void a(int i, java.lang.String str, java.lang.Object obj) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (org.json.JSONException e) {
            e.getMessage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            if (android.text.TextUtils.isEmpty(jSONObject.toString())) {
                a(this.b, "params is null", obj);
                return;
            }
            java.lang.String optString = jSONObject.optString("uniqueIdentifier");
            java.lang.String optString2 = jSONObject.optString("name");
            if (!android.text.TextUtils.isEmpty(optString) && !android.text.TextUtils.isEmpty(optString2)) {
                org.json.JSONArray optJSONArray = jSONObject.optJSONArray(com.meizu.cloud.pushsdk.constants.PushConstants.PARAMS);
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject != null && !android.text.TextUtils.isEmpty(optJSONObject.toString())) {
                    optJSONObject.optInt("type", 0);
                }
                a(this.a, "receivedMessage", obj);
                if (optString.equalsIgnoreCase("reporter") || !optString.equalsIgnoreCase("MediaPlayer")) {
                    return;
                }
                com.anythink.expressad.video.bt.a.a.a().a(obj, optString2, optJSONArray);
                return;
            }
            a(this.b, "module or method is null", obj);
        } catch (java.lang.Exception e) {
            e.getMessage();
            a(this.b, e.getMessage(), obj);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            a(this.b, th.getMessage(), obj);
        }
    }
}
