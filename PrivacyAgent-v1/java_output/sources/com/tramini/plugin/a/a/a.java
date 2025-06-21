package com.tramini.plugin.a.a;

/* loaded from: classes19.dex */
public final class a {

    /* renamed from: com.tramini.plugin.a.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject a;

        public AnonymousClass1(org.json.JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setAction(com.anythink.core.common.b.h.G);
                intent.putExtra(com.anythink.core.common.b.h.H, this.a.toString());
                com.tramini.plugin.a.b.b.a(com.tramini.plugin.a.b.c.a().b()).a(intent);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("key", "1004688");
            jSONObject.put("msg", "3");
            jSONObject.put("msg1", str);
            jSONObject.put("msg2", str2);
            jSONObject.put("msg3", str3);
            com.tramini.plugin.a.b.c.a();
            com.tramini.plugin.a.b.c.a(new com.tramini.plugin.a.a.a.AnonymousClass1(jSONObject));
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(org.json.JSONObject jSONObject) {
        com.tramini.plugin.a.b.c.a();
        com.tramini.plugin.a.b.c.a(new com.tramini.plugin.a.a.a.AnonymousClass1(jSONObject));
    }
}
