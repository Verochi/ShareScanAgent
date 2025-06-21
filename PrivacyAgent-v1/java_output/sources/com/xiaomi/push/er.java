package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class er extends com.xiaomi.push.fd {
    private com.xiaomi.push.en A;
    private byte[] B;
    private java.lang.Thread y;
    private com.xiaomi.push.em z;

    public er(com.xiaomi.push.service.c cVar, com.xiaomi.push.ew ewVar) {
        super(cVar, ewVar);
    }

    @Override // com.xiaomi.push.fd
    public final synchronized void a(int i, java.lang.Exception exc) {
        com.xiaomi.push.em emVar = this.z;
        if (emVar != null) {
            emVar.c = true;
            this.z = null;
        }
        com.xiaomi.push.en enVar = this.A;
        if (enVar != null) {
            try {
                com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
                ekVar.a("CLOSE", (java.lang.String) null);
                enVar.a(ekVar);
                enVar.c.close();
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
            this.A = null;
        }
        this.B = null;
        super.a(i, exc);
    }

    public final void a(com.xiaomi.push.ek ekVar) {
        if (ekVar == null) {
            return;
        }
        if (ekVar.a.l) {
            com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV blob chid=" + ekVar.a.a + "; id=" + ekVar.a() + "; errCode=" + ekVar.a.m + "; err=" + ekVar.a.n);
        }
        com.xiaomi.push.cx.a aVar = ekVar.a;
        if (aVar.a == 0) {
            if ("PING".equals(aVar.f)) {
                com.xiaomi.channel.commonutils.logger.b.a("[Slim] RCV ping id=" + ekVar.a());
                p();
            } else if ("CLOSE".equals(ekVar.a.f)) {
                c(13, null);
            }
        }
        java.util.Iterator<com.xiaomi.push.ev.a> it = this.h.values().iterator();
        while (it.hasNext()) {
            it.next().a(ekVar);
        }
    }

    @Override // com.xiaomi.push.ev
    @java.lang.Deprecated
    public final void a(com.xiaomi.push.fn fnVar) {
        b(com.xiaomi.push.ek.a(fnVar, (java.lang.String) null));
    }

    @Override // com.xiaomi.push.ev
    public final synchronized void a(com.xiaomi.push.service.aj.b bVar) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String a;
        java.lang.String m = m();
        com.xiaomi.push.cx.c cVar = new com.xiaomi.push.cx.c();
        if (!android.text.TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!android.text.TextUtils.isEmpty(bVar.f)) {
            cVar.d(bVar.f);
        }
        if (!android.text.TextUtils.isEmpty(bVar.g)) {
            cVar.e(bVar.g);
        }
        cVar.b(bVar.e ? "1" : "0");
        cVar.c(!android.text.TextUtils.isEmpty(bVar.d) ? bVar.d : "XIAOMI-SASL");
        com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
        ekVar.b(bVar.b);
        ekVar.a(java.lang.Integer.parseInt(bVar.h));
        ekVar.c = bVar.a;
        ekVar.a("BIND", (java.lang.String) null);
        ekVar.a(ekVar.a());
        com.xiaomi.channel.commonutils.logger.b.a("[Slim]: bind id=" + ekVar.a());
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("challenge", m);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.h);
        hashMap.put("from", bVar.b);
        hashMap.put("id", ekVar.a());
        hashMap.put(com.huawei.hms.push.constant.RemoteMessageConst.TO, "xiaomi.com");
        if (bVar.e) {
            str = "kick";
            str2 = "1";
        } else {
            str = "kick";
            str2 = "0";
        }
        hashMap.put(str, str2);
        if (android.text.TextUtils.isEmpty(bVar.f)) {
            str3 = "client_attrs";
            str4 = "";
        } else {
            str3 = "client_attrs";
            str4 = bVar.f;
        }
        hashMap.put(str3, str4);
        if (android.text.TextUtils.isEmpty(bVar.g)) {
            str5 = "cloud_attrs";
            str6 = "";
        } else {
            str5 = "cloud_attrs";
            str6 = bVar.g;
        }
        hashMap.put(str5, str6);
        if (!bVar.d.equals("XIAOMI-PASS") && !bVar.d.equals("XMPUSH-PASS")) {
            bVar.d.equals("XIAOMI-SASL");
            a = null;
            cVar.f(a);
            ekVar.a(cVar.c(), (java.lang.String) null);
            b(ekVar);
        }
        a = com.xiaomi.push.am.a(bVar.d, hashMap, bVar.i);
        cVar.f(a);
        ekVar.a(cVar.c(), (java.lang.String) null);
        b(ekVar);
    }

    @Override // com.xiaomi.push.ev
    public final synchronized void a(java.lang.String str, java.lang.String str2) {
        com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
        ekVar.b(str2);
        ekVar.a(java.lang.Integer.parseInt(str));
        ekVar.a("UBND", (java.lang.String) null);
        b(ekVar);
    }

    @Override // com.xiaomi.push.fd
    public final void a(boolean z) {
        if (this.A == null) {
            throw new com.xiaomi.push.fh("The BlobWriter is null.");
        }
        com.xiaomi.push.eq eqVar = new com.xiaomi.push.eq();
        if (z) {
            eqVar.a("1");
        }
        byte[] c = com.xiaomi.push.ej.c();
        if (c != null) {
            com.xiaomi.push.cx.j jVar = new com.xiaomi.push.cx.j();
            jVar.a(com.xiaomi.push.a.a(c));
            eqVar.a(jVar.c(), (java.lang.String) null);
        }
        com.xiaomi.channel.commonutils.logger.b.a("[Slim] SND ping id=" + eqVar.a());
        b(eqVar);
        o();
    }

    @Override // com.xiaomi.push.fd, com.xiaomi.push.ev
    public final void a(com.xiaomi.push.ek[] ekVarArr) {
        for (com.xiaomi.push.ek ekVar : ekVarArr) {
            b(ekVar);
        }
    }

    public final synchronized byte[] a() {
        if (this.B == null && !android.text.TextUtils.isEmpty(this.k)) {
            java.lang.String e = com.xiaomi.push.service.ay.e();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = this.k;
            sb.append(str.substring(str.length() / 2));
            sb.append(e.substring(e.length() / 2));
            this.B = com.xiaomi.push.service.as.a(this.k.getBytes(), sb.toString().getBytes());
        }
        return this.B;
    }

    @Override // com.xiaomi.push.ev
    public final void b(com.xiaomi.push.ek ekVar) {
        com.xiaomi.push.en enVar = this.A;
        if (enVar == null) {
            throw new com.xiaomi.push.fh("the writer is null.");
        }
        try {
            int a = enVar.a(ekVar);
            this.q = android.os.SystemClock.elapsedRealtime();
            java.lang.String str = ekVar.c;
            if (!android.text.TextUtils.isEmpty(str)) {
                com.xiaomi.push.gc.a(this.p, str, a, false, true, java.lang.System.currentTimeMillis());
            }
            java.util.Iterator<com.xiaomi.push.ev.a> it = this.i.values().iterator();
            while (it.hasNext()) {
                it.next().a(ekVar);
            }
        } catch (java.lang.Exception e) {
            throw new com.xiaomi.push.fh(e);
        }
    }

    public final void b(com.xiaomi.push.fn fnVar) {
        if (fnVar == null) {
            return;
        }
        java.util.Iterator<com.xiaomi.push.ev.a> it = this.h.values().iterator();
        while (it.hasNext()) {
            it.next().a.a(fnVar);
        }
    }

    @Override // com.xiaomi.push.ev
    public final boolean b() {
        return true;
    }

    @Override // com.xiaomi.push.fd
    public final synchronized void c() {
        try {
            this.z = new com.xiaomi.push.em(((com.xiaomi.push.fd) this).f465s.getInputStream(), this, this.p);
            this.A = new com.xiaomi.push.en(((com.xiaomi.push.fd) this).f465s.getOutputStream(), this);
            com.xiaomi.push.es esVar = new com.xiaomi.push.es(this, "Blob Reader (" + this.n + ")");
            this.y = esVar;
            esVar.start();
            com.xiaomi.push.en enVar = this.A;
            com.xiaomi.push.cx.e eVar = new com.xiaomi.push.cx.e();
            eVar.a(106);
            java.lang.String str = android.os.Build.MODEL;
            eVar.a(str);
            eVar.b(com.xiaomi.push.jc.e());
            eVar.c(com.xiaomi.push.service.ay.e());
            eVar.b(48);
            eVar.d(enVar.b.f());
            eVar.e(enVar.b.e());
            eVar.f(java.util.Locale.getDefault().toString());
            int i = android.os.Build.VERSION.SDK_INT;
            eVar.c(i);
            byte[] b = enVar.b.d().b();
            if (b != null) {
                eVar.a(com.xiaomi.push.cx.b.a(b));
            }
            com.xiaomi.push.ek ekVar = new com.xiaomi.push.ek();
            ekVar.a(0);
            ekVar.a("CONN", (java.lang.String) null);
            ekVar.a(0L, "xiaomi.com", null);
            ekVar.a(eVar.c(), (java.lang.String) null);
            enVar.a(ekVar);
            com.xiaomi.channel.commonutils.logger.b.a("[slim] open conn: andver=" + i + " sdk=48 tz=" + enVar.d + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + enVar.e + " Model=" + str + " os=" + android.os.Build.VERSION.INCREMENTAL);
        } catch (java.lang.Exception e) {
            throw new com.xiaomi.push.fh("Error to init reader and writer", e);
        }
    }
}
