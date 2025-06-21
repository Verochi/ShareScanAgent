package com.getui.gs.g;

/* loaded from: classes22.dex */
public final class g {
    public android.app.usage.UsageStatsManager a;

    /* renamed from: com.getui.gs.g.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gs.b.e eVar;
            android.app.usage.UsageEvents queryEventsForSelf;
            java.lang.String a;
            com.getui.gs.b.e eVar2;
            try {
                if (com.getui.gs.g.g.this.a != null && android.os.Build.VERSION.SDK_INT >= 28) {
                    eVar = com.getui.gs.b.e.a.a;
                    long a2 = eVar.a.a(32);
                    long currentTimeMillis = java.lang.System.currentTimeMillis();
                    if (a2 > 0 && currentTimeMillis - a2 < 10000) {
                        com.getui.gs.h.a.a("ue-queryAndUpload : last query time is too short, ".concat(java.lang.String.valueOf(a2)));
                        return;
                    }
                    com.getui.gs.h.a.a("ue-queryAndUpload : qefs, [" + a2 + "," + currentTimeMillis + "]");
                    queryEventsForSelf = com.getui.gs.g.g.this.a.queryEventsForSelf(a2, currentTimeMillis);
                    java.util.HashSet hashSet = new java.util.HashSet();
                    while (queryEventsForSelf.hasNextEvent()) {
                        android.app.usage.UsageEvents.Event event = new android.app.usage.UsageEvents.Event();
                        queryEventsForSelf.getNextEvent(event);
                        hashSet.add(java.lang.String.valueOf(event.getEventType()));
                    }
                    if (hashSet.isEmpty()) {
                        com.getui.gs.h.a.a("ue-queryAndUpload : no usage event");
                        a = "noUsageEvent";
                    } else {
                        a = defpackage.br3.a(",", hashSet);
                    }
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("eventTypes", a);
                    jSONObject.put("s11", com.getui.gs.h.e.a());
                    java.lang.String server = com.getui.gtc.server.ServerManager.getServer("ido.as");
                    org.json.JSONObject a3 = com.getui.gs.e.d.a();
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    a3.put("data", jSONArray);
                    jSONArray.put(jSONObject);
                    java.lang.String jSONObject2 = a3.toString();
                    try {
                        com.getui.gs.e.h.a(server, "%s/sdk/v2/used", "upload usage", jSONObject2);
                    } catch (java.lang.Throwable th) {
                        if (!(th instanceof java.io.IOException) || !com.getui.gtc.server.ServerManager.switchServer("ido.as", server)) {
                            throw th;
                        }
                        com.getui.gs.e.h.a(server, "%s/sdk/v2/used", "upload usage", jSONObject2);
                    }
                    eVar2 = com.getui.gs.b.e.a.a;
                    eVar2.a.a(32, currentTimeMillis);
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gs.h.b.a.a.a.e(th2);
            }
        }
    }

    public static class a {
        private static final com.getui.gs.g.g a = new com.getui.gs.g.g((byte) 0);
    }

    private g() {
    }

    public /* synthetic */ g(byte b) {
        this();
    }
}
