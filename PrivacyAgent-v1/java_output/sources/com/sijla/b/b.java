package com.sijla.b;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    private /* synthetic */ boolean a;
    private /* synthetic */ java.lang.StringBuilder b;
    private /* synthetic */ long c;
    private /* synthetic */ java.lang.String d;

    public b(boolean z, java.lang.StringBuilder sb, long j, java.lang.String str) {
        this.a = z;
        this.b = sb;
        this.c = j;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2;
        try {
            int i = 1;
            if (!this.a) {
                java.lang.Thread.sleep(1000L);
                z = com.sijla.b.a.e;
                if (!z) {
                    i = 0;
                }
            }
            java.lang.StringBuilder sb = this.b;
            sb.append("\t");
            sb.append(i);
            java.lang.StringBuilder sb2 = this.b;
            sb2.append("\t");
            sb2.append(this.c);
            z2 = com.sijla.b.a.e;
            if (!z2) {
                com.sijla.b.a.b();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("basename", "activity");
            jSONObject.put("data", this.b.toString());
            com.sijla.b.a.a(this.d, jSONObject);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
