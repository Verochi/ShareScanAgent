package com.xiaomi.push;

import com.xiaomi.push.cg.c;

/* loaded from: classes19.dex */
public final class ch extends com.xiaomi.push.cg.b {
    java.io.File a;
    final /* synthetic */ int d;
    final /* synthetic */ java.util.Date e;
    final /* synthetic */ java.util.Date f;
    final /* synthetic */ java.lang.String g;
    final /* synthetic */ java.lang.String h;
    final /* synthetic */ boolean i;
    final /* synthetic */ com.xiaomi.push.cg j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch(com.xiaomi.push.cg cgVar, int i, java.util.Date date, java.util.Date date2, java.lang.String str, java.lang.String str2, boolean z) {
        super();
        this.j = cgVar;
        this.d = i;
        this.e = date;
        this.f = date2;
        this.g = str;
        this.h = str2;
        this.i = z;
    }

    @Override // com.xiaomi.push.cg.b, com.xiaomi.push.p.b
    public final void a() {
        java.io.File file;
        java.io.File file2;
        java.lang.String format;
        if (com.xiaomi.push.e.c()) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                java.io.File file3 = null;
                sb.append(this.j.b.getExternalFilesDir(null));
                sb.append("/.logcache");
                java.io.File file4 = new java.io.File(sb.toString());
                file4.mkdirs();
                if (file4.isDirectory()) {
                    com.xiaomi.push.cf cfVar = new com.xiaomi.push.cf();
                    int i = this.d;
                    if (i != 0) {
                        cfVar.e = i;
                    }
                    android.content.Context context = this.j.b;
                    java.util.Date date = this.e;
                    java.util.Date date2 = this.f;
                    if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
                        file = new java.io.File(context.getExternalFilesDir(null), com.xiaomi.push.service.an.N);
                        if (!file.exists()) {
                            file = new java.io.File(context.getFilesDir(), com.xiaomi.push.service.an.N);
                        }
                        if (!file.exists()) {
                            file = context.getFilesDir();
                        }
                        cfVar.a(new java.io.File(file, "xmsf.log.1"));
                        file2 = new java.io.File(file, "xmsf.log");
                    } else {
                        file = new java.io.File(context.getExternalFilesDir(null) + com.xiaomi.push.cf.b);
                        cfVar.a(new java.io.File(file, "log0.txt"));
                        file2 = new java.io.File(file, "log1.txt");
                    }
                    cfVar.a(file2);
                    if (file.isDirectory()) {
                        java.io.File file5 = new java.io.File(file4, date.getTime() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
                        if (!file5.exists()) {
                            if (date.after(date2)) {
                                cfVar.c = cfVar.a.format(date2);
                                format = cfVar.a.format(date);
                            } else {
                                cfVar.c = cfVar.a.format(date);
                                format = cfVar.a.format(date2);
                            }
                            cfVar.d = format;
                            long currentTimeMillis = java.lang.System.currentTimeMillis();
                            java.io.File file6 = new java.io.File(file4, "log.txt");
                            cfVar.b(file6);
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (java.lang.System.currentTimeMillis() - currentTimeMillis));
                            if (file6.exists()) {
                                long currentTimeMillis2 = java.lang.System.currentTimeMillis();
                                com.xiaomi.push.c.a(file5, file6);
                                com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (java.lang.System.currentTimeMillis() - currentTimeMillis2));
                                file6.delete();
                                if (file5.exists()) {
                                    file3 = file5;
                                }
                            }
                        }
                    }
                    this.a = file3;
                }
            } catch (java.lang.NullPointerException unused) {
            }
        }
    }

    @Override // com.xiaomi.push.p.b
    public final void b() {
        java.io.File file = this.a;
        if (file != null && file.exists()) {
            this.j.a.add(this.j.new c(this.g, this.h, this.a, this.i));
        }
        this.j.b(0L);
    }
}
