package com.xiaomi.push;

/* loaded from: classes19.dex */
final class bs {
    java.lang.String a;
    final java.util.ArrayList<com.xiaomi.push.br> b = new java.util.ArrayList<>();

    public bs() {
    }

    public bs(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("the host is empty");
        }
        this.a = str;
    }

    public final synchronized com.xiaomi.push.br a() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            com.xiaomi.push.br brVar = this.b.get(size);
            if (android.text.TextUtils.equals(brVar.a, com.xiaomi.push.bv.b())) {
                com.xiaomi.push.bv.a().e = brVar.c();
                return brVar;
            }
        }
        return null;
    }

    public final synchronized com.xiaomi.push.bs a(org.json.JSONObject jSONObject) {
        this.a = jSONObject.getString(com.alipay.sdk.m.l.c.f);
        org.json.JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.b.add(new com.xiaomi.push.br(this.a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public final synchronized void a(com.xiaomi.push.br brVar) {
        int i = 0;
        while (true) {
            if (i >= this.b.size()) {
                break;
            }
            if (android.text.TextUtils.equals(this.b.get(i).a, brVar.a)) {
                this.b.set(i, brVar);
                break;
            }
            i++;
        }
        if (i >= this.b.size()) {
            this.b.add(brVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000b, B:8:0x001e, B:10:0x002a, B:12:0x0031, B:17:0x0041), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void b() {
        boolean z;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            com.xiaomi.push.br brVar = this.b.get(size);
            long j = brVar.l;
            if (864000000 >= j) {
                j = 864000000;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            long j2 = brVar.b;
            if (currentTimeMillis - j2 <= j && (currentTimeMillis - j2 <= brVar.l || !brVar.a.startsWith("WIFI-"))) {
                z = false;
                if (!z) {
                    this.b.remove(size);
                }
            }
            z = true;
            if (!z) {
            }
        }
    }

    public final synchronized org.json.JSONObject c() {
        org.json.JSONObject jSONObject;
        jSONObject = new org.json.JSONObject();
        jSONObject.put(com.alipay.sdk.m.l.c.f, this.a);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.xiaomi.push.br> it = this.b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().d());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append("\n");
        java.util.Iterator<com.xiaomi.push.br> it = this.b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
