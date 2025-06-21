package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ao extends com.xiaomi.push.service.ay.a implements com.xiaomi.push.bv.a {
    private com.xiaomi.push.service.c a;
    private long b;

    public static class a implements com.xiaomi.push.bv.b {
        @Override // com.xiaomi.push.bv.b
        public final java.lang.String a(java.lang.String str) {
            android.net.Uri.Builder buildUpon = android.net.Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", "48");
            buildUpon.appendQueryParameter("osver", java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter("os", com.xiaomi.push.fy.a(android.os.Build.MODEL + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + android.os.Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter(com.getui.gtc.extension.distribution.gbd.f.b.i, java.lang.String.valueOf(com.xiaomi.push.jc.b()));
            java.lang.String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : ".concat(java.lang.String.valueOf(builder)));
            java.net.URL url = new java.net.URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                java.lang.String a = com.xiaomi.push.ai.a(com.xiaomi.push.jc.a(), url);
                com.xiaomi.push.ej.a(url.getHost() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port, (int) (java.lang.System.currentTimeMillis() - currentTimeMillis), (java.lang.Exception) null);
                return a;
            } catch (java.io.IOException e) {
                com.xiaomi.push.ej.a(url.getHost() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port, -1, e);
                throw e;
            }
        }
    }

    public static class b extends com.xiaomi.push.bv {
        public b(android.content.Context context, com.xiaomi.push.bv.b bVar, java.lang.String str) {
            super(context, bVar, str);
        }

        @Override // com.xiaomi.push.bv
        public final java.lang.String a(java.util.ArrayList<java.lang.String> arrayList, java.lang.String str, java.lang.String str2, boolean z) {
            try {
                if (com.xiaomi.push.eh.a.a.a) {
                    str2 = com.xiaomi.push.service.ay.e();
                }
                return super.a(arrayList, str, str2, z);
            } catch (java.io.IOException e) {
                com.xiaomi.push.ej.a(com.xiaomi.push.dy.GSLB_ERR.af, 1, null, com.xiaomi.push.ai.b(com.xiaomi.push.bv.c) ? 1 : 0);
                throw e;
            }
        }
    }

    public ao(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // com.xiaomi.push.bv.a
    public final com.xiaomi.push.bv a(android.content.Context context, com.xiaomi.push.bv.b bVar, java.lang.String str) {
        return new com.xiaomi.push.service.ao.b(context, bVar, str);
    }

    @Override // com.xiaomi.push.service.ay.a
    public final void a(com.xiaomi.push.cx.b bVar) {
        com.xiaomi.push.br b2;
        boolean z;
        if (bVar.a && bVar.b && java.lang.System.currentTimeMillis() - this.b > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.a("fetch bucket :" + bVar.b);
            this.b = java.lang.System.currentTimeMillis();
            com.xiaomi.push.bv a2 = com.xiaomi.push.bv.a();
            a2.c();
            a2.e();
            com.xiaomi.push.ev evVar = this.a.c;
            if (evVar == null || (b2 = a2.b(evVar.d().c())) == null) {
                return;
            }
            java.util.ArrayList<java.lang.String> b3 = b2.b();
            java.util.Iterator<java.lang.String> it = b3.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (it.next().equals(evVar.e())) {
                    z = false;
                    break;
                }
            }
            if (!z || b3.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("bucket changed, force reconnect");
            this.a.a(0, (java.lang.Exception) null);
            this.a.b(false);
        }
    }
}
