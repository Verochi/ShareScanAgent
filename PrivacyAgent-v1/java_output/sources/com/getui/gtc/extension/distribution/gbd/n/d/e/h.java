package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
public final class h {
    private final com.getui.gtc.extension.distribution.gbd.n.d.e.d a;
    private final com.getui.gtc.extension.distribution.gbd.n.d.b.g b;

    public static class a extends java.lang.IllegalStateException {
        public a(java.lang.String str, java.lang.Object... objArr) {
            super(java.lang.String.format(str, objArr));
        }
    }

    private h(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.lang.String trim = str.trim();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(trim);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar);
        this.a = com.getui.gtc.extension.distribution.gbd.n.d.e.g.a(trim);
        this.b = gVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c a() {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(this.a, this.b);
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.h(str, gVar).a();
    }

    public static com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.lang.String str, java.lang.Iterable<com.getui.gtc.extension.distribution.gbd.n.d.b.g> iterable) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iterable);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = iterable.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(a(str, it.next()));
        }
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.c(linkedHashSet);
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.b.g> collection, java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.b.g> collection2) {
        boolean z;
        com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : collection) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (gVar.equals(it.next())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                cVar.add(gVar);
            }
        }
        return cVar;
    }
}
