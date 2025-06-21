package com.vivo.push.d;

/* loaded from: classes19.dex */
final class ah extends com.vivo.push.l {
    public ah(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        android.content.Context context = this.a;
        if (context == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; mContext is Null");
            return;
        }
        if (oVar == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b a = com.vivo.push.util.t.a(context);
        int b = oVar.b();
        if (b == 2009) {
            com.vivo.push.util.p.a(com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).isDebug());
            if (com.vivo.push.util.p.a()) {
                com.vivo.push.e.a().i();
                com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                bVar.a(this.a, "com.vivo.push_preferences.hybridapptoken_v1");
                bVar.a();
                com.vivo.push.util.b bVar2 = new com.vivo.push.util.b();
                bVar2.a(this.a, "com.vivo.push_preferences.appconfig_v1");
                bVar2.a();
                if (!com.vivo.push.e.a().e()) {
                    com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).clearPush();
                }
            }
        } else if (b != 2011) {
            switch (b) {
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                    if (a == null || a.c()) {
                        com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1005);
                        break;
                    } else {
                        com.vivo.push.b.c cVar = (com.vivo.push.b.c) oVar;
                        int a2 = com.vivo.push.util.s.a(cVar);
                        if (a2 != 0) {
                            com.vivo.push.e.a().a(cVar.h(), a2);
                            return;
                        }
                    }
                    break;
            }
        } else {
            com.vivo.push.util.p.a(com.vivo.push.cache.ClientConfigManagerImpl.getInstance(this.a).isDebug(((com.vivo.push.b.w) oVar).d()));
        }
        if (a == null) {
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pushPkgInfo is Null");
            return;
        }
        java.lang.String a3 = a.a();
        if (a.c()) {
            try {
                com.vivo.push.e.a().a(((com.vivo.push.b.c) oVar).h(), 1004);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            oVar = new com.vivo.push.b.e();
            com.vivo.push.util.p.d("SendCommandTask", "SendCommandTask " + oVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.a, a3, oVar);
    }
}
