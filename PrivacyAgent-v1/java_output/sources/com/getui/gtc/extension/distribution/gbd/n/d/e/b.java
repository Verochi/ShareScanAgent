package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
abstract class b extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
    final java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.e.d> a;

    public static final class a extends com.getui.gtc.extension.distribution.gbd.n.d.e.b {
        public a(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.e.d> collection) {
            super(collection);
        }

        public a(com.getui.gtc.extension.distribution.gbd.n.d.e.d... dVarArr) {
            this(java.util.Arrays.asList(dVarArr));
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.e.d> it = this.a.iterator();
            while (it.hasNext()) {
                if (!it.next().a(gVar, gVar2)) {
                    return false;
                }
            }
            return true;
        }

        public final java.lang.String toString() {
            return com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(this.a, " ");
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.e.b$b, reason: collision with other inner class name */
    public static final class C0326b extends com.getui.gtc.extension.distribution.gbd.n.d.e.b {
        public C0326b() {
        }

        private C0326b(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.e.d> collection) {
            if (collection.size() > 1) {
                this.a.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(collection));
            } else {
                this.a.addAll(collection);
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.e.d> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().a(gVar, gVar2)) {
                    return true;
                }
            }
            return false;
        }

        public final void b(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a.add(dVar);
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":or%s", this.a);
        }
    }

    public b() {
        this.a = new java.util.ArrayList();
    }

    public b(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.e.d> collection) {
        this();
        this.a.addAll(collection);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.e.d a() {
        if (this.a.size() <= 0) {
            return null;
        }
        return this.a.get(r0.size() - 1);
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
        this.a.set(r0.size() - 1, dVar);
    }
}
