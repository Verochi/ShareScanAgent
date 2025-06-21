package com.sijla.mla.a.a;

/* loaded from: classes19.dex */
public final class g extends com.sijla.mla.a.a.a implements com.sijla.mla.a.b.c, com.sijla.mla.a.b.d {
    private static com.sijla.mla.a.a.g b = new com.sijla.mla.a.a.g();

    public static class a {
        int a = 0;
        private java.util.Hashtable b = new java.util.Hashtable();

        public static /* synthetic */ com.sijla.mla.a.w a(com.sijla.mla.a.a.g.a aVar, java.io.InputStream inputStream, java.lang.String str) {
            com.sijla.mla.a.a.f fVar = new com.sijla.mla.a.a.f(aVar, inputStream);
            com.sijla.mla.a.a.c cVar = new com.sijla.mla.a.a.c();
            fVar.c = cVar;
            fVar.a(aVar, inputStream.read(), inputStream, com.sijla.mla.a.r.h(str));
            com.sijla.mla.a.w wVar = new com.sijla.mla.a.w();
            cVar.b = wVar;
            wVar.g = com.sijla.mla.a.r.h(str);
            fVar.a(cVar);
            boolean z = true;
            com.sijla.mla.a.a.a.a(cVar.c == null);
            com.sijla.mla.a.a.f.b bVar = fVar.d;
            if (bVar != null && (bVar.b != 0 || bVar.d != 0 || bVar.f != 0)) {
                z = false;
            }
            com.sijla.mla.a.a.a.a(z);
            return cVar.b;
        }

        private com.sijla.mla.a.n b(com.sijla.mla.a.n nVar) {
            com.sijla.mla.a.n nVar2 = (com.sijla.mla.a.n) this.b.get(nVar);
            if (nVar2 != null) {
                return nVar2;
            }
            this.b.put(nVar, nVar);
            return nVar;
        }

        public final com.sijla.mla.a.n a(com.sijla.mla.a.n nVar) {
            return b(nVar);
        }

        public final com.sijla.mla.a.n a(java.lang.String str) {
            return b(com.sijla.mla.a.n.c(str));
        }
    }

    public static void a(com.sijla.mla.a.b bVar) {
        com.sijla.mla.a.a.g gVar = b;
        bVar.i = gVar;
        bVar.h = gVar;
    }

    @Override // com.sijla.mla.a.b.d
    public final com.sijla.mla.a.j a(com.sijla.mla.a.w wVar, com.sijla.mla.a.r rVar) {
        return new com.sijla.mla.a.g(wVar, rVar);
    }

    @Override // com.sijla.mla.a.b.c
    public final com.sijla.mla.a.w a(java.io.InputStream inputStream, java.lang.String str) {
        return com.sijla.mla.a.a.g.a.a(new com.sijla.mla.a.a.g.a(), inputStream, str);
    }
}
