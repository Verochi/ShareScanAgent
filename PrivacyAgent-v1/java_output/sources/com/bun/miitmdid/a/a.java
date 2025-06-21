package com.bun.miitmdid.a;

/* loaded from: classes.dex */
public class a implements com.bun.miitmdid.a.b {
    public com.bun.miitmdid.a.a.C0255a a = new com.bun.miitmdid.a.a.C0255a(this);

    /* renamed from: com.bun.miitmdid.a.a$a, reason: collision with other inner class name */
    public class C0255a {
        public com.bun.miitmdid.a.c.a a;
        public com.bun.miitmdid.a.c.b b;
        public com.bun.miitmdid.a.c.c c;

        public C0255a(com.bun.miitmdid.a.a aVar) {
        }
    }

    private a() {
    }

    public static com.bun.miitmdid.a.a a(android.content.Context context) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject optJSONObject;
        java.lang.String a = com.bun.miitmdid.d.a.a(context, "supplierconfig.json");
        if (android.text.TextUtils.isEmpty(a)) {
            return null;
        }
        com.bun.miitmdid.a.a aVar = new com.bun.miitmdid.a.a();
        org.json.JSONTokener jSONTokener = new org.json.JSONTokener(a);
        boolean z = false;
        try {
            jSONObject = (org.json.JSONObject) jSONTokener.nextValue();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("supplier")) == null) {
            return null;
        }
        boolean a2 = a(aVar, optJSONObject);
        boolean c = c(aVar, optJSONObject);
        boolean b = b(aVar, optJSONObject);
        if (a2 && c && b) {
            z = true;
        }
        if (z) {
            return aVar;
        }
        return null;
    }

    private static boolean a(com.bun.miitmdid.a.a aVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(com.igexin.assist.util.AssistUtils.BRAND_HW) != null) {
            aVar.a.a = new com.bun.miitmdid.a.c.a();
        }
        return aVar.a.a != null;
    }

    private static boolean b(com.bun.miitmdid.a.a aVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.igexin.assist.util.AssistUtils.BRAND_VIVO);
        com.bun.miitmdid.a.c.b bVar = new com.bun.miitmdid.a.c.b();
        if (optJSONObject != null) {
            bVar.a = optJSONObject.optString("appid");
            aVar.a.b = bVar;
        }
        return aVar.a.b != null;
    }

    private static boolean c(com.bun.miitmdid.a.a aVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null || aVar == null) {
            return false;
        }
        if (jSONObject.optJSONObject(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) != null) {
            aVar.a.c = new com.bun.miitmdid.a.c.c();
        }
        return aVar.a.c != null;
    }

    @Override // com.bun.miitmdid.a.b
    public java.lang.String a() {
        com.bun.miitmdid.a.c.b bVar;
        java.lang.String str;
        com.bun.miitmdid.a.a.C0255a c0255a = this.a;
        return (c0255a == null || (bVar = c0255a.b) == null || (str = bVar.a) == null) ? "" : str;
    }
}
