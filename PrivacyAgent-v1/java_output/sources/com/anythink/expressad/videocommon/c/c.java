package com.anythink.expressad.videocommon.c;

/* loaded from: classes12.dex */
public class c {
    private java.lang.String a;
    private int b;

    public c(java.lang.String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static com.anythink.expressad.videocommon.c.c a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            java.lang.String optString = jSONObject.optString("name");
            int optInt = jSONObject.optInt("amount");
            jSONObject.optString("id");
            return new com.anythink.expressad.videocommon.c.c(optString, optInt);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.util.Map<java.lang.String, com.anythink.expressad.videocommon.c.c> a(org.json.JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), new com.anythink.expressad.videocommon.c.c(optJSONObject.optString("name"), optJSONObject.optInt("amount")));
            }
            return hashMap;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a A[Catch: Exception -> 0x002f, TRY_LEAVE, TryCatch #0 {Exception -> 0x002f, blocks: (B:3:0x0001, B:5:0x000f, B:8:0x002a, B:14:0x0017, B:16:0x001d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.expressad.videocommon.c.c b(java.lang.String str) {
        com.anythink.expressad.videocommon.c.c cVar;
        com.anythink.expressad.videocommon.c.c cVar2 = null;
        try {
            com.anythink.expressad.videocommon.e.a b = com.anythink.expressad.videocommon.e.c.a().b();
            if (!android.text.TextUtils.isEmpty(str)) {
                if (b != null && b.j() != null) {
                    cVar = b.j().get(str);
                }
                return cVar2 != null ? c() : cVar2;
            }
            cVar = c();
            cVar2 = cVar;
            if (cVar2 != null) {
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static com.anythink.expressad.videocommon.c.c c() {
        return new com.anythink.expressad.videocommon.c.c("Virtual Item", 1);
    }

    public final java.lang.String a() {
        return this.a;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(java.lang.String str) {
        this.a = str;
    }

    public final int b() {
        return this.b;
    }

    public java.lang.String toString() {
        return "Reward{name='" + this.a + "', amount=" + this.b + '}';
    }
}
