package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class et implements com.xiaomi.push.fi {
    public static boolean a;
    private com.xiaomi.push.ev c;
    private com.xiaomi.push.et.a d;
    private com.xiaomi.push.et.a e;
    private com.xiaomi.push.ey f;
    private java.text.SimpleDateFormat b = new java.text.SimpleDateFormat("hh:mm:ss aaa");
    private final java.lang.String g = "[Slim] ";

    public class a implements com.xiaomi.push.fb, com.xiaomi.push.fj {
        java.lang.String a;
        private boolean c;

        public a(boolean z) {
            this.c = z;
            this.a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fb
        public final void a(com.xiaomi.push.ek ekVar) {
            java.lang.StringBuilder sb;
            java.lang.String str;
            if (com.xiaomi.push.et.a) {
                sb = new java.lang.StringBuilder("[Slim] ");
                sb.append(com.xiaomi.push.et.this.b.format(new java.util.Date()));
                sb.append(this.a);
                str = ekVar.toString();
            } else {
                sb = new java.lang.StringBuilder("[Slim] ");
                sb.append(com.xiaomi.push.et.this.b.format(new java.util.Date()));
                sb.append(this.a);
                sb.append(" Blob [");
                sb.append(ekVar.a.f);
                sb.append(",");
                sb.append(ekVar.a.a);
                sb.append(",");
                sb.append(ekVar.a());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            if (ekVar != null) {
                com.xiaomi.push.cx.a aVar = ekVar.a;
                if (aVar.a == 99999) {
                    java.lang.String str2 = aVar.f;
                    com.xiaomi.push.ek ekVar2 = null;
                    if (!this.c) {
                        if ("BIND".equals(str2)) {
                            com.xiaomi.channel.commonutils.logger.b.a("build binded result for loopback.");
                            com.xiaomi.push.cx.d dVar = new com.xiaomi.push.cx.d();
                            dVar.a(true);
                            dVar.c("login success.");
                            dVar.b("success");
                            dVar.a("success");
                            com.xiaomi.push.ek ekVar3 = new com.xiaomi.push.ek();
                            ekVar3.a(dVar.c(), (java.lang.String) null);
                            ekVar3.b = (short) 2;
                            ekVar3.a(99999);
                            ekVar3.a("BIND", (java.lang.String) null);
                            ekVar3.a(ekVar.a());
                            ekVar3.c = null;
                            ekVar3.b(ekVar.b());
                            ekVar2 = ekVar3;
                        } else if (!"UBND".equals(str2) && "SECMSG".equals(str2)) {
                            com.xiaomi.push.ek ekVar4 = new com.xiaomi.push.ek();
                            ekVar4.a(99999);
                            ekVar4.a("SECMSG", (java.lang.String) null);
                            ekVar4.b(ekVar.b());
                            ekVar4.a(ekVar.a());
                            ekVar4.b = ekVar.b;
                            ekVar4.c = ekVar.c;
                            ekVar4.a(ekVar.c(com.xiaomi.push.service.aj.a().b("99999", ekVar.b()).i), (java.lang.String) null);
                            ekVar2 = ekVar4;
                        }
                    }
                    if (ekVar2 != null) {
                        for (java.util.Map.Entry<com.xiaomi.push.fb, com.xiaomi.push.ev.a> entry : com.xiaomi.push.et.this.c.h().entrySet()) {
                            if (com.xiaomi.push.et.this.d != entry.getKey()) {
                                entry.getValue().a(ekVar2);
                            }
                        }
                    }
                }
            }
        }

        @Override // com.xiaomi.push.fb
        public final void a(com.xiaomi.push.fn fnVar) {
            java.lang.StringBuilder sb;
            java.lang.String str;
            if (com.xiaomi.push.et.a) {
                sb = new java.lang.StringBuilder("[Slim] ");
                sb.append(com.xiaomi.push.et.this.b.format(new java.util.Date()));
                sb.append(this.a);
                sb.append(" PKT ");
                str = fnVar.b();
            } else {
                sb = new java.lang.StringBuilder("[Slim] ");
                sb.append(com.xiaomi.push.et.this.b.format(new java.util.Date()));
                sb.append(this.a);
                sb.append(" PKT [");
                sb.append(fnVar.t);
                sb.append(",");
                sb.append(fnVar.d());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        }
    }

    public et(com.xiaomi.push.ev evVar) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.c = evVar;
        this.d = new com.xiaomi.push.et.a(true);
        this.e = new com.xiaomi.push.et.a(false);
        com.xiaomi.push.ev evVar2 = this.c;
        com.xiaomi.push.et.a aVar = this.d;
        evVar2.a(aVar, aVar);
        com.xiaomi.push.ev evVar3 = this.c;
        com.xiaomi.push.et.a aVar2 = this.e;
        evVar3.b(aVar2, aVar2);
        this.f = new com.xiaomi.push.eu(this);
    }
}
