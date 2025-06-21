package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class y {
    public org.json.JSONArray a = new org.json.JSONArray();
    public org.json.JSONArray b = new org.json.JSONArray();

    public class a implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ java.lang.String b;
        public final /* synthetic */ java.lang.String c;

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.zx.a.I8b7.y.this.a.length() >= 100) {
                    com.zx.a.I8b7.r2.a("events length > MAX_COUNT " + com.zx.a.I8b7.y.this.a.length());
                    return;
                }
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("ts", currentTimeMillis);
                jSONObject.put(com.huawei.hms.api.FailedBinderCallBack.CALLER_ID, this.a);
                jSONObject.put("action", this.b);
                jSONObject.put("params", this.c);
                com.zx.a.I8b7.y.this.a.put(jSONObject);
                com.zx.a.I8b7.r2.a("events add:" + jSONObject.toString());
                if (com.zx.a.I8b7.m3.G) {
                    com.zx.a.I8b7.r2.a("events save:" + com.zx.a.I8b7.y.this.a.toString());
                    com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                    com.zx.a.I8b7.u3 u3Var = l2Var.a;
                    java.lang.String jSONArray = com.zx.a.I8b7.y.this.a.toString();
                    u3Var.getClass();
                    l2Var.a.a(23, jSONArray, true);
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
            }
        }
    }

    public static final class b {
        public static final com.zx.a.I8b7.y a = new com.zx.a.I8b7.y();
    }

    public final org.json.JSONArray a(org.json.JSONArray jSONArray, org.json.JSONArray jSONArray2, int i) throws org.json.JSONException {
        org.json.JSONArray jSONArray3 = new org.json.JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray3.length() >= i) {
                return jSONArray3;
            }
            jSONArray3.put(jSONArray.get(i2));
        }
        for (int i3 = 0; i3 < jSONArray2.length() && jSONArray3.length() < i; i3++) {
            jSONArray3.put(jSONArray2.get(i3));
        }
        return jSONArray3;
    }

    public final void a(java.lang.Runnable runnable) {
        try {
            com.zx.a.I8b7.v3.f.a.b.execute(runnable);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            a(new com.zx.a.I8b7.y.a(str, str2, str3));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
