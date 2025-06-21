package com.getui.gtc.f;

/* loaded from: classes22.dex */
public final class c {

    /* renamed from: com.getui.gtc.f.c$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.getui.gtc.f.e {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.getui.gtc.f.e b;

        public AnonymousClass1(java.lang.String str, com.getui.gtc.f.e eVar) {
            this.a = str;
            this.b = eVar;
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.Exception exc) {
            if ((exc.getCause() instanceof java.io.IOException) && com.getui.gtc.server.ServerManager.switchServer("gtc.cs", this.a)) {
                com.getui.gtc.h.c.a.b("gtc config failed with server: " + this.a + ", try again with: " + com.getui.gtc.server.ServerManager.getServer("gtc.cs"));
                com.getui.gtc.f.c.a(this.b);
            }
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.String str) {
            com.getui.gtc.h.c.a.b("gtc config failed: ".concat(java.lang.String.valueOf(str)));
            com.getui.gtc.f.e eVar = this.b;
            if (eVar != null) {
                eVar.a(str);
            }
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
            com.getui.gtc.server.ServerManager.confirmServer("gtc.cs", this.a);
            com.getui.gtc.f.e eVar = this.b;
            if (eVar != null) {
                eVar.a(map, map2);
            }
        }
    }

    /* renamed from: com.getui.gtc.f.c$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.getui.gtc.f.e {
        final /* synthetic */ com.getui.gtc.f.c.a a;

        public AnonymousClass2(com.getui.gtc.f.c.a aVar) {
            this.a = aVar;
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.Exception exc) {
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.String str) {
            com.getui.gtc.h.c.a.b("sdk config failed: ".concat(java.lang.String.valueOf(str)));
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
            com.getui.gtc.f.c.a aVar;
            if (map != null || map2 == null || (aVar = this.a) == null) {
                return;
            }
            aVar.a(map2);
        }
    }

    public interface a {
        void a(java.util.Map<java.lang.String, java.lang.String> map);
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(com.getui.gtc.api.SdkInfo sdkInfo, com.getui.gtc.f.c.a aVar) {
        return com.getui.gtc.f.a.a(com.getui.gtc.base.GtcProvider.context(), new com.getui.gtc.f.d.a().a(android.text.TextUtils.isEmpty(sdkInfo.getPsUrl()) ? java.lang.String.format("%s/api.php?format=json&t=1", com.getui.gtc.server.ServerManager.getServer("gtc.cs")) : sdkInfo.getPsUrl()).b(sdkInfo.getModuleName()).d(sdkInfo.getCid()).e(sdkInfo.getVersion()).c(sdkInfo.getAppid()).a().a(new com.getui.gtc.f.c.AnonymousClass2(aVar)).b());
    }

    public static java.util.Map<java.lang.String, java.lang.String> a(com.getui.gtc.f.e eVar) {
        java.lang.String server = com.getui.gtc.server.ServerManager.getServer("gtc.cs");
        return com.getui.gtc.f.a.a(com.getui.gtc.base.GtcProvider.context(), new com.getui.gtc.f.d.a().b("GTC").a(java.lang.String.format("%s/api.php?format=json&t=1", server)).c(com.getui.gtc.c.b.a).d(com.getui.gtc.c.b.d).e(com.getui.gtc.BuildConfig.VERSION_NAME).a().a(new com.getui.gtc.f.c.AnonymousClass1(server, eVar)).b());
    }
}
