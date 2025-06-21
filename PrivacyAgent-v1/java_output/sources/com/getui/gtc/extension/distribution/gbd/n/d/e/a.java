package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
public final class a {

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.e.a$a, reason: collision with other inner class name */
    public static class C0325a implements com.getui.gtc.extension.distribution.gbd.n.d.e.f {
        private final com.getui.gtc.extension.distribution.gbd.n.d.b.g a;
        private final com.getui.gtc.extension.distribution.gbd.n.d.e.c b;
        private final com.getui.gtc.extension.distribution.gbd.n.d.e.d c;

        public C0325a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar, com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = gVar;
            this.b = cVar;
            this.c = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar;
                if (this.c.a(this.a, gVar)) {
                    this.b.add(gVar);
                }
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
        }
    }

    private a() {
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.e.c a(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
        new com.getui.gtc.extension.distribution.gbd.n.d.e.e(new com.getui.gtc.extension.distribution.gbd.n.d.e.a.C0325a(gVar, cVar, dVar)).a(gVar);
        return cVar;
    }
}
