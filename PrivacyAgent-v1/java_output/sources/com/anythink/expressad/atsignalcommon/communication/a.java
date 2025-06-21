package com.anythink.expressad.atsignalcommon.communication;

/* loaded from: classes12.dex */
public class a {
    public static final java.lang.String a = "a";
    public static int b = 0;
    public static int c = 1;

    /* renamed from: com.anythink.expressad.atsignalcommon.communication.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.expressad.atsignalcommon.communication.a.a(this.a.K(), this.a);
            } catch (java.lang.Throwable th) {
                java.lang.String str = com.anythink.expressad.atsignalcommon.communication.a.a;
                th.getMessage();
            }
        }
    }

    private static java.lang.String a(float f, float f2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.foundation.h.t.a(com.anythink.expressad.foundation.b.a.b().d(), f));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.foundation.h.t.a(com.anythink.expressad.foundation.b.a.b().d(), f2));
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, 0);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, com.anythink.expressad.foundation.b.a.b().d().getResources().getConfiguration().orientation);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(com.anythink.expressad.foundation.b.a.b().d()));
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static java.lang.String a(int i) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar) {
        new java.lang.Thread(new com.anythink.expressad.atsignalcommon.communication.a.AnonymousClass1(cVar)).start();
    }

    private static void a(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", c);
            jSONObject.put("message", str);
            jSONObject.put("data", new org.json.JSONObject());
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    private static void a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject);
            if (b2 == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new java.lang.Thread(new com.anythink.expressad.atsignalcommon.communication.a.AnonymousClass1(b2)).start();
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("code", b);
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("id", "");
                jSONObject2.put("data", jSONObject3);
                com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (java.lang.Exception e) {
                a(obj, e.getMessage());
                e.getMessage();
            }
        } catch (java.lang.Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static /* synthetic */ void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (com.anythink.expressad.foundation.g.a.f.n == null || android.text.TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(str, cVar, "banner");
    }

    private static void b(java.lang.Object obj, java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", b);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            com.anythink.expressad.atsignalcommon.windvane.j.a().a(obj, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception e) {
            a(obj, e.getMessage());
            e.getMessage();
        }
    }

    private static void b(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        if (com.anythink.expressad.foundation.g.a.f.n == null || android.text.TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(str, cVar, "banner");
    }
}
