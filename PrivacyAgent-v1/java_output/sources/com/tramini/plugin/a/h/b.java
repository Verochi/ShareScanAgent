package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class b {
    private static com.tramini.plugin.a.h.b a;

    /* renamed from: com.tramini.plugin.a.h.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.tramini.plugin.b.b a;

        public AnonymousClass1(com.tramini.plugin.b.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.tramini.plugin.a.h.b.this) {
                if (this.a.b() != 1) {
                    return;
                }
                java.lang.String a = com.tramini.plugin.a.h.g.a(this.a);
                com.tramini.plugin.b.b bVar = this.a;
                try {
                    com.tramini.plugin.a.d.b bVar2 = new com.tramini.plugin.a.d.b();
                    bVar2.c = com.appsflyer.AppsFlyerLib.getInstance().getSdkVersion();
                    bVar2.d = 1;
                    java.lang.String b = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "appsflyer-data", "attributionId", "");
                    if (!android.text.TextUtils.isEmpty(b)) {
                        bVar2.e = b;
                        org.json.JSONObject a2 = bVar2.a();
                        java.lang.String b2 = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, "");
                        if (a2 != null && !android.text.TextUtils.equals(b2, b)) {
                            com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, b);
                            com.tramini.plugin.a.g.a.a().a(a, bVar.c(), com.tramini.plugin.a.h.d.a, a2);
                        }
                    }
                } catch (java.lang.Throwable unused) {
                }
                com.tramini.plugin.b.b bVar3 = this.a;
                com.tramini.plugin.a.d.b bVar4 = new com.tramini.plugin.a.d.b();
                bVar4.c = com.adjust.sdk.Adjust.getSdkVersion();
                bVar4.d = 2;
                com.adjust.sdk.AdjustAttribution attribution = com.adjust.sdk.Adjust.getAttribution();
                if (attribution != null) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("adgroup", attribution.adgroup);
                    jSONObject.put("adid", attribution.adid);
                    jSONObject.put("campaign", attribution.campaign);
                    jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_LABEL, attribution.clickLabel);
                    jSONObject.put(com.anythink.expressad.foundation.d.r.aD, attribution.creative);
                    jSONObject.put("network", attribution.network);
                    jSONObject.put("trackerName", attribution.trackerName);
                    jSONObject.put("trackerToken", attribution.trackerToken);
                    jSONObject.put("attr", attribution.toString());
                    bVar4.e = jSONObject.toString();
                    org.json.JSONObject a3 = bVar4.a();
                    if (!android.text.TextUtils.equals(com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, ""), jSONObject.toString())) {
                        com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, jSONObject.toString());
                        com.tramini.plugin.a.g.a.a().a(a, bVar3.c(), com.tramini.plugin.a.h.d.a, a3);
                    }
                }
            }
        }
    }

    private b() {
    }

    public static com.tramini.plugin.a.h.b a() {
        if (a == null) {
            a = new com.tramini.plugin.a.h.b();
        }
        return a;
    }

    private static void a(java.lang.String str, com.tramini.plugin.b.b bVar) {
        try {
            com.tramini.plugin.a.d.b bVar2 = new com.tramini.plugin.a.d.b();
            bVar2.c = com.adjust.sdk.Adjust.getSdkVersion();
            bVar2.d = 2;
            com.adjust.sdk.AdjustAttribution attribution = com.adjust.sdk.Adjust.getAttribution();
            if (attribution != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("adgroup", attribution.adgroup);
                jSONObject.put("adid", attribution.adid);
                jSONObject.put("campaign", attribution.campaign);
                jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_LABEL, attribution.clickLabel);
                jSONObject.put(com.anythink.expressad.foundation.d.r.aD, attribution.creative);
                jSONObject.put("network", attribution.network);
                jSONObject.put("trackerName", attribution.trackerName);
                jSONObject.put("trackerToken", attribution.trackerToken);
                jSONObject.put("attr", attribution.toString());
                bVar2.e = jSONObject.toString();
                org.json.JSONObject a2 = bVar2.a();
                if (android.text.TextUtils.equals(com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, ""), jSONObject.toString())) {
                    return;
                }
                com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, jSONObject.toString());
                com.tramini.plugin.a.g.a.a().a(str, bVar.c(), com.tramini.plugin.a.h.d.a, a2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void b(java.lang.String str, com.tramini.plugin.b.b bVar) {
        try {
            com.tramini.plugin.a.d.b bVar2 = new com.tramini.plugin.a.d.b();
            bVar2.c = com.appsflyer.AppsFlyerLib.getInstance().getSdkVersion();
            bVar2.d = 1;
            java.lang.String b = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "appsflyer-data", "attributionId", "");
            if (android.text.TextUtils.isEmpty(b)) {
                return;
            }
            bVar2.e = b;
            org.json.JSONObject a2 = bVar2.a();
            java.lang.String b2 = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, "");
            if (a2 == null || android.text.TextUtils.equals(b2, b)) {
                return;
            }
            com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, b);
            com.tramini.plugin.a.g.a.a().a(str, bVar.c(), com.tramini.plugin.a.h.d.a, a2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static /* synthetic */ void c(java.lang.String str, com.tramini.plugin.b.b bVar) {
        try {
            com.tramini.plugin.a.d.b bVar2 = new com.tramini.plugin.a.d.b();
            bVar2.c = com.appsflyer.AppsFlyerLib.getInstance().getSdkVersion();
            bVar2.d = 1;
            java.lang.String b = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "appsflyer-data", "attributionId", "");
            if (android.text.TextUtils.isEmpty(b)) {
                return;
            }
            bVar2.e = b;
            org.json.JSONObject a2 = bVar2.a();
            java.lang.String b2 = com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, "");
            if (a2 == null || android.text.TextUtils.equals(b2, b)) {
                return;
            }
            com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.d, b);
            com.tramini.plugin.a.g.a.a().a(str, bVar.c(), com.tramini.plugin.a.h.d.a, a2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static /* synthetic */ void d(java.lang.String str, com.tramini.plugin.b.b bVar) {
        try {
            com.tramini.plugin.a.d.b bVar2 = new com.tramini.plugin.a.d.b();
            bVar2.c = com.adjust.sdk.Adjust.getSdkVersion();
            bVar2.d = 2;
            com.adjust.sdk.AdjustAttribution attribution = com.adjust.sdk.Adjust.getAttribution();
            if (attribution != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("adgroup", attribution.adgroup);
                jSONObject.put("adid", attribution.adid);
                jSONObject.put("campaign", attribution.campaign);
                jSONObject.put(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_CLICK_LABEL, attribution.clickLabel);
                jSONObject.put(com.anythink.expressad.foundation.d.r.aD, attribution.creative);
                jSONObject.put("network", attribution.network);
                jSONObject.put("trackerName", attribution.trackerName);
                jSONObject.put("trackerToken", attribution.trackerToken);
                jSONObject.put("attr", attribution.toString());
                bVar2.e = jSONObject.toString();
                org.json.JSONObject a2 = bVar2.a();
                if (android.text.TextUtils.equals(com.tramini.plugin.a.h.i.b(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, ""), jSONObject.toString())) {
                    return;
                }
                com.tramini.plugin.a.h.i.a(com.tramini.plugin.a.b.c.a().b(), "tramini", com.tramini.plugin.a.b.a.d.e, jSONObject.toString());
                com.tramini.plugin.a.g.a.a().a(str, bVar.c(), com.tramini.plugin.a.h.d.a, a2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.tramini.plugin.b.b bVar) {
        com.tramini.plugin.a.h.b.a.a().a(new com.tramini.plugin.a.h.b.AnonymousClass1(bVar));
    }
}
