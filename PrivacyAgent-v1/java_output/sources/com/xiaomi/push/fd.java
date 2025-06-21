package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class fd extends com.xiaomi.push.ev {
    private long A;
    protected java.lang.Exception r;

    /* renamed from: s, reason: collision with root package name */
    protected java.net.Socket f465s;
    java.lang.String t;
    protected com.xiaomi.push.service.c u;
    protected volatile long v;
    protected volatile long w;
    protected volatile long x;
    private java.lang.String y;
    private int z;

    public fd(com.xiaomi.push.service.c cVar, com.xiaomi.push.ew ewVar) {
        super(cVar, ewVar);
        this.r = null;
        this.t = null;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.A = 0L;
        this.u = cVar;
    }

    public synchronized void a(int i, java.lang.Exception exc) {
        if (this.m == 2) {
            return;
        }
        a(2, i, exc);
        this.k = "";
        try {
            this.f465s.close();
        } catch (java.lang.Throwable unused) {
        }
        this.v = 0L;
        this.w = 0L;
    }

    public abstract void a(boolean z);

    @Override // com.xiaomi.push.ev
    public void a(com.xiaomi.push.ek[] ekVarArr) {
        throw new com.xiaomi.push.fh("Don't support send Blob");
    }

    @Override // com.xiaomi.push.ev
    public final void b(int i, java.lang.Exception exc) {
        a(i, exc);
        if ((exc != null || i == 18) && this.x != 0) {
            if (android.os.SystemClock.elapsedRealtime() - this.x >= 300000) {
                this.z = 0;
                return;
            }
            if (com.xiaomi.push.ai.a(this.u)) {
                int i2 = this.z + 1;
                this.z = i2;
                if (i2 >= 2) {
                    java.lang.String str = this.y;
                    com.xiaomi.channel.commonutils.logger.b.a("max short conn time reached, sink down current host:".concat(java.lang.String.valueOf(str)));
                    com.xiaomi.push.br a = com.xiaomi.push.bv.a().a(com.xiaomi.push.ew.a(), false);
                    if (a != null) {
                        a.b(str, 0L, 0L, exc);
                        com.xiaomi.push.bv.a().f();
                    }
                    this.z = 0;
                }
            }
        }
    }

    @Override // com.xiaomi.push.ev
    public final void b(boolean z) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        a(z);
        com.xiaomi.push.service.ck a = com.xiaomi.push.service.ck.a(this.u);
        if (a.e()) {
            a.e = a.c;
        }
        if (z) {
            return;
        }
        this.u.a(new com.xiaomi.push.fe(this, elapsedRealtime, currentTimeMillis), 10000L);
    }

    public synchronized void c() {
    }

    public final void c(int i, java.lang.Exception exc) {
        this.u.a(new com.xiaomi.push.ff(this, i, exc), 0L);
    }

    @Override // com.xiaomi.push.ev
    public final java.lang.String e() {
        return this.y;
    }

    public final java.lang.String m() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ba A[Catch: all -> 0x0304, IOException -> 0x0306, TryCatch #4 {IOException -> 0x0306, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0011, B:11:0x0045, B:12:0x004d, B:14:0x0062, B:15:0x006a, B:17:0x0070, B:20:0x007d, B:25:0x0081, B:27:0x0087, B:28:0x008a, B:29:0x00a4, B:31:0x00aa, B:41:0x02aa, B:43:0x02ba, B:45:0x02c0, B:47:0x02ea, B:48:0x02f3, B:50:0x02ce, B:53:0x02e3, B:55:0x02f4, B:75:0x0139, B:78:0x018a, B:82:0x0175, B:85:0x0231, B:88:0x0282, B:90:0x02a7, B:91:0x026d, B:60:0x01b3, B:63:0x0204, B:71:0x01ef, B:99:0x02fd), top: B:3:0x0003, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02f4 A[Catch: all -> 0x0304, IOException -> 0x0306, TRY_LEAVE, TryCatch #4 {IOException -> 0x0306, blocks: (B:4:0x0003, B:6:0x0009, B:9:0x0011, B:11:0x0045, B:12:0x004d, B:14:0x0062, B:15:0x006a, B:17:0x0070, B:20:0x007d, B:25:0x0081, B:27:0x0087, B:28:0x008a, B:29:0x00a4, B:31:0x00aa, B:41:0x02aa, B:43:0x02ba, B:45:0x02c0, B:47:0x02ea, B:48:0x02f3, B:50:0x02ce, B:53:0x02e3, B:55:0x02f4, B:75:0x0139, B:78:0x018a, B:82:0x0175, B:85:0x0231, B:88:0x0282, B:90:0x02a7, B:91:0x026d, B:60:0x01b3, B:63:0x0204, B:71:0x01ef, B:99:0x02fd), top: B:3:0x0003, outer: #2 }] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void n() {
        java.lang.StringBuilder sb;
        boolean z;
        java.lang.String str;
        boolean equals;
        java.lang.String str2;
        long currentTimeMillis;
        try {
            if (!j() && !i()) {
                a(0, 0, null);
                com.xiaomi.push.ew ewVar = this.o;
                java.lang.String c = ewVar.c();
                int i = ewVar.e;
                this.r = null;
                new java.util.ArrayList();
                int intValue = com.xiaomi.channel.commonutils.logger.b.e("get bucket for host : ".concat(java.lang.String.valueOf(c))).intValue();
                com.xiaomi.push.br a = com.xiaomi.push.bv.a().a(c, false);
                if (!a.a()) {
                    com.xiaomi.push.fz.a(new com.xiaomi.push.fg(this, c));
                }
                com.xiaomi.channel.commonutils.logger.b.a(java.lang.Integer.valueOf(intValue));
                ?? r13 = 1;
                java.util.ArrayList<java.lang.String> a2 = a.a(true);
                com.xiaomi.push.bv.a();
                com.xiaomi.push.br c2 = com.xiaomi.push.bv.c(c);
                if (c2 != null) {
                    java.util.Iterator<java.lang.String> it = c2.a(true).iterator();
                    while (it.hasNext()) {
                        java.lang.String next = it.next();
                        if (a2.indexOf(next) == -1) {
                            a2.add(next);
                        }
                    }
                }
                if (a2.isEmpty()) {
                    a2.add(c);
                }
                this.x = 0L;
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                java.lang.String str3 = "";
                java.lang.String i2 = com.xiaomi.push.ai.i(this.u);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                java.util.Iterator<java.lang.String> it2 = a2.iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    java.lang.String next2 = it2.next();
                    long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                    this.b += r13;
                    int i4 = i3 + 1;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a("begin to connect to ".concat(java.lang.String.valueOf(next2)));
                        this.f465s = new java.net.Socket();
                        this.f465s.connect(com.xiaomi.push.bt.b(next2, i), 8000);
                        com.xiaomi.channel.commonutils.logger.b.a("tcp connected");
                        this.f465s.setTcpNoDelay(r13);
                        this.y = next2;
                        c();
                        currentTimeMillis = java.lang.System.currentTimeMillis() - currentTimeMillis2;
                        this.c = currentTimeMillis;
                        this.l = i2;
                        sb = sb2;
                        str = next2;
                    } catch (java.lang.Exception e) {
                        e = e;
                        sb = sb2;
                        str = next2;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        sb = sb2;
                        str = next2;
                    }
                    try {
                        a.a(next2, currentTimeMillis, 0L);
                        this.x = android.os.SystemClock.elapsedRealtime();
                        com.xiaomi.channel.commonutils.logger.b.a("connected to " + str + " in " + this.c);
                        i3 = i4;
                        z = true;
                        break;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        this.r = e;
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:".concat(java.lang.String.valueOf(str)));
                        sb.append("SMACK: Could not connect to ");
                        sb.append(str);
                        sb.append(" port:");
                        sb.append(i);
                        sb.append(" err:");
                        sb.append(this.r.getClass().getSimpleName());
                        sb.append("\n");
                        if (android.text.TextUtils.isEmpty(str3)) {
                            str3 = str;
                        } else {
                            str3 = str3 + "|" + str;
                        }
                        com.xiaomi.push.ej.a(str, this.r);
                        java.lang.String str4 = str;
                        str2 = i2;
                        a.b(str4, java.lang.System.currentTimeMillis() - currentTimeMillis2, 0L, this.r);
                        if (android.text.TextUtils.equals(str2, com.xiaomi.push.ai.i(this.u))) {
                            sb2 = sb;
                            i2 = str2;
                            i3 = i4;
                            r13 = 1;
                        } else {
                            i3 = i4;
                            z = false;
                            com.xiaomi.push.bv.a().f();
                            int elapsedRealtime2 = (int) (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            this.r = new java.lang.Exception("abnormal exception", th);
                            com.xiaomi.channel.commonutils.logger.b.a(th);
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:".concat(java.lang.String.valueOf(str)));
                            sb.append("SMACK: Could not connect to ");
                            sb.append(str);
                            sb.append(" port:");
                            sb.append(i);
                            sb.append(" err:");
                            sb.append(this.r.getClass().getSimpleName());
                            sb.append("\n");
                            if (android.text.TextUtils.isEmpty(str3)) {
                                str3 = str;
                            } else {
                                str3 = str3 + "|" + str;
                            }
                            com.xiaomi.push.ej.a(str, this.r);
                            java.lang.String str5 = str;
                            str2 = i2;
                            a.b(str5, java.lang.System.currentTimeMillis() - currentTimeMillis2, 0L, this.r);
                        } finally {
                            if (equals) {
                            }
                            i3 = i4;
                            z = false;
                            com.xiaomi.push.bv.a().f();
                            int elapsedRealtime22 = (int) (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                        if (android.text.TextUtils.equals(str2, com.xiaomi.push.ai.i(this.u))) {
                            sb2 = sb;
                            i2 = str2;
                            i3 = i4;
                            r13 = 1;
                        } else {
                            i3 = i4;
                            z = false;
                            com.xiaomi.push.bv.a().f();
                            int elapsedRealtime222 = (int) (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (!z) {
                            }
                        }
                    }
                }
                sb = sb2;
                z = false;
                com.xiaomi.push.bv.a().f();
                int elapsedRealtime2222 = (int) (android.os.SystemClock.elapsedRealtime() - elapsedRealtime);
                if (!z) {
                    com.xiaomi.push.ej.a(com.xiaomi.push.dy.BATCH_TCP_CONN_SUCCESS.af, elapsedRealtime2222, str3, i3);
                    return;
                }
                if (this.A == 0 || android.os.SystemClock.elapsedRealtime() - this.A > 480000) {
                    this.A = android.os.SystemClock.elapsedRealtime();
                    com.xiaomi.push.ej.a(com.xiaomi.push.dy.BATCH_TCP_CONN_FAIL.af, elapsedRealtime2222, str3, com.xiaomi.push.ai.b(this.u.getApplicationContext()) ? 1 : 0);
                }
                throw new com.xiaomi.push.fh(sb.toString());
            }
            com.xiaomi.channel.commonutils.logger.b.a("WARNING: current xmpp has connected");
        } catch (java.io.IOException e3) {
            throw new com.xiaomi.push.fh(e3);
        }
    }

    public final void o() {
        this.v = android.os.SystemClock.elapsedRealtime();
    }

    public final void p() {
        this.w = android.os.SystemClock.elapsedRealtime();
    }
}
