package com.xiaomi.push;

/* loaded from: classes19.dex */
public class cg {
    private static volatile com.xiaomi.push.cg c;
    public final java.util.concurrent.ConcurrentLinkedQueue<com.xiaomi.push.cg.b> a;
    private android.content.Context b;

    public class a extends com.xiaomi.push.cg.b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.cg.b, com.xiaomi.push.p.b
        public final void a() {
            com.xiaomi.push.cg.c(com.xiaomi.push.cg.this);
        }
    }

    public class b extends com.xiaomi.push.p.b {
        long b = java.lang.System.currentTimeMillis();

        public b() {
        }

        @Override // com.xiaomi.push.p.b
        public void a() {
        }

        public boolean c() {
            return true;
        }
    }

    public class c extends com.xiaomi.push.cg.b {
        java.lang.String a;
        java.lang.String d;
        java.io.File e;
        int f;
        boolean g;
        boolean h;

        public c(java.lang.String str, java.lang.String str2, java.io.File file, boolean z) {
            super();
            this.a = str;
            this.d = str2;
            this.e = file;
            this.h = z;
        }

        private boolean d() {
            int i;
            int i2 = 0;
            android.content.SharedPreferences sharedPreferences = com.xiaomi.push.cg.this.b.getSharedPreferences("log.timestamp", 0);
            java.lang.String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (org.json.JSONException unused) {
                i = 0;
            }
            if (java.lang.System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = java.lang.System.currentTimeMillis();
            } else {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (org.json.JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.cg.b, com.xiaomi.push.p.b
        public final void a() {
            try {
                if (d()) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("uid", com.xiaomi.push.service.ay.e());
                    hashMap.put("token", this.d);
                    hashMap.put(com.alipay.sdk.m.k.b.k, com.xiaomi.push.ai.i(com.xiaomi.push.cg.this.b));
                    com.xiaomi.push.ai.a(this.a, hashMap, this.e, "file");
                }
                this.g = true;
            } catch (java.io.IOException unused) {
            }
        }

        @Override // com.xiaomi.push.p.b
        public final void b() {
            if (!this.g) {
                int i = this.f + 1;
                this.f = i;
                if (i < 3) {
                    com.xiaomi.push.cg.this.a.add(this);
                }
            }
            if (this.g || this.f >= 3) {
                this.e.delete();
            }
            com.xiaomi.push.cg.this.b((1 << this.f) * 1000);
        }

        @Override // com.xiaomi.push.cg.b
        public final boolean c() {
            if (com.xiaomi.push.ai.d(com.xiaomi.push.cg.this.b)) {
                return true;
            }
            return this.h && com.xiaomi.push.ai.a(com.xiaomi.push.cg.this.b);
        }
    }

    private cg(android.content.Context context) {
        java.util.concurrent.ConcurrentLinkedQueue<com.xiaomi.push.cg.b> concurrentLinkedQueue = new java.util.concurrent.ConcurrentLinkedQueue<>();
        this.a = concurrentLinkedQueue;
        this.b = context;
        concurrentLinkedQueue.add(new com.xiaomi.push.cg.a());
        a(0L);
    }

    public static com.xiaomi.push.cg a(android.content.Context context) {
        if (c == null) {
            synchronized (com.xiaomi.push.cg.class) {
                if (c == null) {
                    c = new com.xiaomi.push.cg(context);
                }
            }
        }
        c.b = context;
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        com.xiaomi.push.cg.b peek = this.a.peek();
        if (peek == null || !peek.c()) {
            return;
        }
        a(j);
    }

    public static /* synthetic */ void c(com.xiaomi.push.cg cgVar) {
        if (com.xiaomi.push.e.b() || com.xiaomi.push.e.a()) {
            return;
        }
        try {
            java.io.File file = new java.io.File(cgVar.b.getExternalFilesDir(null) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (java.io.File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (java.lang.NullPointerException unused) {
        }
    }

    public final void a() {
        while (!this.a.isEmpty()) {
            com.xiaomi.push.cg.b peek = this.a.peek();
            if (peek != null) {
                if (!(java.lang.System.currentTimeMillis() - peek.b > com.baidu.mobads.sdk.internal.bm.e) && this.a.size() <= 6) {
                    break;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.a.remove(peek);
            }
        }
        b(0L);
    }

    public final void a(long j) {
        if (this.a.isEmpty()) {
            return;
        }
        com.xiaomi.push.fz.a(new com.xiaomi.push.ci(this), j);
    }
}
