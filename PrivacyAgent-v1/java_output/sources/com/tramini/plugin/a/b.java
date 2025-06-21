package com.tramini.plugin.a;

/* loaded from: classes19.dex */
public class b extends android.content.BroadcastReceiver {
    public static final java.lang.String a = "b";
    public static final java.lang.String b = "tramini";

    /* renamed from: com.tramini.plugin.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.tramini.plugin.a.h.a.InterfaceC0510a {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.tramini.plugin.b.b c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        /* renamed from: com.tramini.plugin.a.b$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC05041 implements java.lang.Runnable {
            final /* synthetic */ com.tramini.plugin.a.d.a a;

            public RunnableC05041(com.tramini.plugin.a.d.a aVar) {
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                org.json.JSONObject jSONObject;
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(com.tramini.plugin.a.b.AnonymousClass1.this.b);
                    com.tramini.plugin.a.d.a aVar = this.a;
                    if (aVar != null && (jSONObject = aVar.a) != null) {
                        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            java.lang.String next = keys.next();
                            jSONObject2.put(next, jSONObject.optString(next));
                        }
                        jSONObject2.put("setting_id", com.tramini.plugin.a.b.AnonymousClass1.this.c.c());
                    } else if (aVar == null || aVar.b == null) {
                        int i = com.tramini.plugin.a.b.AnonymousClass1.this.a;
                        if (i != 18 && i != 19 && i != 20) {
                            return;
                        }
                    } else {
                        jSONObject2.put("type", 10001);
                        jSONObject2.put("i_t", this.a.b.a);
                        if (!android.text.TextUtils.isEmpty(this.a.b.b)) {
                            jSONObject2.put("i_al", com.tramini.plugin.a.h.c.a(this.a.b.b.getBytes()));
                        }
                    }
                    com.tramini.plugin.a.g.a.a().a(com.tramini.plugin.a.b.AnonymousClass1.this.d, new org.json.JSONObject(com.tramini.plugin.a.b.AnonymousClass1.this.e), jSONObject2);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public AnonymousClass1(int i, java.lang.String str, com.tramini.plugin.b.b bVar, java.lang.String str2, java.lang.String str3) {
            this.a = i;
            this.b = str;
            this.c = bVar;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.tramini.plugin.a.h.a.InterfaceC0510a
        public final void a(com.tramini.plugin.a.d.a aVar) {
            int i;
            if (aVar != null || (i = this.a) == 18 || i == 19 || i == 20) {
                com.tramini.plugin.a.b.c.a();
                com.tramini.plugin.a.b.c.a(new com.tramini.plugin.a.b.AnonymousClass1.RunnableC05041(aVar));
            }
        }
    }

    private void a(android.content.Intent intent, com.tramini.plugin.b.b bVar) {
        java.lang.String stringExtra = intent.getStringExtra(bVar.g());
        java.lang.String stringExtra2 = intent.getStringExtra(bVar.h());
        intent.getStringExtra(bVar.i());
        java.lang.String stringExtra3 = intent.getStringExtra(bVar.j());
        com.tramini.plugin.a.h.a.a(bVar, stringExtra3, intent.getStringExtra(bVar.l()), intent.getStringExtra(bVar.k()), new com.tramini.plugin.a.b.AnonymousClass1(intent.getIntExtra(bVar.m(), 0), stringExtra2, bVar, stringExtra3, stringExtra));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.util.List<java.lang.String> e;
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        intent.getAction();
        com.tramini.plugin.b.b b2 = com.tramini.plugin.b.c.a(context).b();
        if (b2 == null) {
            return;
        }
        com.tramini.plugin.a.h.b.a().a(b2);
        if (!(com.tramini.plugin.a.h.h.a(context) && b2.n() == 0) && (e = b2.e()) != null && e.size() > 0 && e.contains(intent.getAction())) {
            try {
                java.lang.String stringExtra = intent.getStringExtra(b2.g());
                java.lang.String stringExtra2 = intent.getStringExtra(b2.h());
                intent.getStringExtra(b2.i());
                java.lang.String stringExtra3 = intent.getStringExtra(b2.j());
                com.tramini.plugin.a.h.a.a(b2, stringExtra3, intent.getStringExtra(b2.l()), intent.getStringExtra(b2.k()), new com.tramini.plugin.a.b.AnonymousClass1(intent.getIntExtra(b2.m(), 0), stringExtra2, b2, stringExtra3, stringExtra));
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
