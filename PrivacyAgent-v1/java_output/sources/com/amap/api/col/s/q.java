package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class q {
    public static com.amap.api.col.s.bt a;
    public static com.amap.api.col.s.q d;
    public static android.content.Context e;
    public com.amap.api.col.s.q.a b;
    public android.os.HandlerThread c = new com.amap.api.col.s.q.AnonymousClass1("manifestThread");

    /* renamed from: com.amap.api.col.s.q$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.HandlerThread {

        /* renamed from: com.amap.api.col.s.q$1$1, reason: invalid class name and collision with other inner class name */
        public class C01171 implements com.amap.api.col.s.bj.a {
            public C01171() {
            }

            @Override // com.amap.api.col.s.bj.a
            public final void a(com.amap.api.col.s.bj.b bVar) {
                com.amap.api.col.s.q.a aVar;
                org.json.JSONObject jSONObject;
                org.json.JSONObject optJSONObject;
                org.json.JSONObject jSONObject2;
                org.json.JSONObject optJSONObject2;
                android.os.Message message = new android.os.Message();
                if (bVar != null) {
                    try {
                        com.amap.api.col.s.bj.b.a aVar2 = bVar.g;
                        if (aVar2 != null) {
                            message.obj = new com.amap.api.col.s.r(aVar2.b, aVar2.a);
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            com.amap.api.col.s.i.a(th, "ManifestConfig", "run");
                            if (aVar == null) {
                                return;
                            }
                        } finally {
                            message.what = 3;
                            if (com.amap.api.col.s.q.this.b != null) {
                                com.amap.api.col.s.q.this.b.sendMessage(message);
                            }
                        }
                    }
                }
                if (bVar != null && (jSONObject2 = bVar.f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                    com.amap.api.col.s.q.k(optJSONObject2);
                    com.amap.api.col.s.al.a(com.amap.api.col.s.q.e, "amap_search", "cache_control", optJSONObject2.toString());
                }
                if (bVar != null && (jSONObject = bVar.f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                    com.amap.api.col.s.q.j(optJSONObject);
                    com.amap.api.col.s.al.a(com.amap.api.col.s.q.e, "amap_search", "parm_control", optJSONObject.toString());
                }
                message.what = 3;
                if (com.amap.api.col.s.q.this.b == null) {
                }
            }
        }

        public AnonymousClass1(java.lang.String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            java.lang.Thread.currentThread().setName("ManifestConfigThread");
            com.amap.api.col.s.bt a = com.amap.api.col.s.h.a(false);
            com.amap.api.col.s.q.i(com.amap.api.col.s.q.e);
            com.amap.api.col.s.bj.a(com.amap.api.col.s.q.e, a, "11K" + com.alipay.sdk.m.u.i.b + "001" + com.alipay.sdk.m.u.i.b + "184" + com.alipay.sdk.m.u.i.b + "185", new com.amap.api.col.s.q.AnonymousClass1.C01171());
            try {
                java.lang.Thread.sleep(10000L);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class a extends android.os.Handler {
        public java.lang.String a;

        public a(android.os.Looper looper) {
            super(looper);
            this.a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message != null && message.what == 3) {
                try {
                    com.amap.api.col.s.r rVar = (com.amap.api.col.s.r) message.obj;
                    if (rVar == null) {
                        rVar = new com.amap.api.col.s.r(false, false);
                    }
                    com.amap.api.col.s.cj.a(com.amap.api.col.s.q.e, com.amap.api.col.s.h.a(rVar.a()));
                    com.amap.api.col.s.q.a = com.amap.api.col.s.h.a(rVar.a());
                } catch (java.lang.Throwable th) {
                    com.amap.api.col.s.i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    public q(android.content.Context context) {
        e = context;
        a = com.amap.api.col.s.h.a(false);
        try {
            f();
            this.b = new com.amap.api.col.s.q.a(android.os.Looper.getMainLooper());
            this.c.start();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static com.amap.api.col.s.q a(android.content.Context context) {
        if (d == null) {
            d = new com.amap.api.col.s.q(context);
        }
        return d;
    }

    public static com.amap.api.col.s.ad.a b(org.json.JSONObject jSONObject, boolean z, com.amap.api.col.s.ad.a aVar) {
        boolean optBoolean;
        com.amap.api.col.s.ad.a aVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.amap.api.col.s.ad.a aVar3 = new com.amap.api.col.s.ad.a();
            try {
                if (z) {
                    optBoolean = com.amap.api.col.s.bj.a(jSONObject.optString("able"), aVar == null || aVar.e());
                } else {
                    optBoolean = jSONObject.optBoolean("able", aVar == null || aVar.e());
                }
                int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.f() : 86400);
                int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.g() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.h() : 0.0d);
                aVar3.d(optBoolean);
                aVar3.c(optInt);
                aVar3.b(optInt2);
                aVar3.a(optDouble);
                return aVar3;
            } catch (java.lang.Throwable th) {
                th = th;
                aVar2 = aVar3;
                th.printStackTrace();
                return aVar2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static void d(java.lang.String str, org.json.JSONObject jSONObject, com.amap.api.col.s.ad.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            com.amap.api.col.s.ad.a().a(str, b(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    public static void f() {
        com.amap.api.col.s.ac.a();
    }

    public static void i(android.content.Context context) {
        try {
            java.lang.String str = (java.lang.String) com.amap.api.col.s.al.b(context, "amap_search", "cache_control", "");
            if (!android.text.TextUtils.isEmpty(str)) {
                k(new org.json.JSONObject(str));
            }
            java.lang.String str2 = (java.lang.String) com.amap.api.col.s.al.b(context, "amap_search", "parm_control", "");
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            j(new org.json.JSONObject(str2));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    public static void j(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean a2 = com.amap.api.col.s.bj.a(jSONObject.optString("passAreaAble"), true);
                boolean a3 = com.amap.api.col.s.bj.a(jSONObject.optString("truckAble"), true);
                boolean a4 = com.amap.api.col.s.bj.a(jSONObject.optString("poiPageAble"), true);
                boolean a5 = com.amap.api.col.s.bj.a(jSONObject.optString("rideAble"), true);
                boolean a6 = com.amap.api.col.s.bj.a(jSONObject.optString("walkAble"), true);
                boolean a7 = com.amap.api.col.s.bj.a(jSONObject.optString("passPointAble"), true);
                boolean a8 = com.amap.api.col.s.bj.a(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                com.amap.api.col.s.ag.a().a(a2);
                com.amap.api.col.s.ag.a().c(optInt2);
                com.amap.api.col.s.ag.a().i(optInt8);
                com.amap.api.col.s.ag.a().j(optInt9);
                com.amap.api.col.s.ag.a().b(a3);
                com.amap.api.col.s.ag.a().g(optInt6);
                com.amap.api.col.s.ag.a().c(a4);
                com.amap.api.col.s.ag.a().f(optInt5);
                com.amap.api.col.s.ag.a().a(optInt);
                com.amap.api.col.s.ag.a().b(optInt10);
                com.amap.api.col.s.ag.a().g(a8);
                com.amap.api.col.s.ag.a().d(a5);
                com.amap.api.col.s.ag.a().h(optInt7);
                com.amap.api.col.s.ag.a().e(a6);
                com.amap.api.col.s.ag.a().d(optInt3);
                com.amap.api.col.s.ag.a().f(a7);
                com.amap.api.col.s.ag.a().e(optInt4);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void k(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    com.amap.api.col.s.ad.a b = b(jSONObject, true, null);
                    com.amap.api.col.s.ad.a().a(b);
                    if (b.e()) {
                        d("regeo", jSONObject, b);
                        d("geo", jSONObject, b);
                        d("placeText", jSONObject, b);
                        d("placeAround", jSONObject, b);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
