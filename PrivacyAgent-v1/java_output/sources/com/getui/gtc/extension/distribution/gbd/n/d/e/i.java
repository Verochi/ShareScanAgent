package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
abstract class i extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
    com.getui.gtc.extension.distribution.gbd.n.d.e.d a;

    public static class a extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public a(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.a(), gVar2).iterator();
            while (it.hasNext()) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.g next = it.next();
                if (next != gVar2 && this.a.a(gVar, next)) {
                    return true;
                }
            }
            return false;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":has(%s)", this.a);
        }
    }

    public static class b extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public b(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar3;
            return (gVar == gVar2 || (gVar3 = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) gVar2.d) == null || !this.a.a(gVar, gVar3)) ? false : true;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":ImmediateParent%s", this.a);
        }
    }

    public static class c extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public c(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.g g;
            return (gVar == gVar2 || (g = gVar2.g()) == null || !this.a.a(gVar, g)) ? false : true;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":prev%s", this.a);
        }
    }

    public static class d extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public d(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return !this.a.a(gVar, gVar2);
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":not%s", this.a);
        }
    }

    public static class e extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public e(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            if (gVar == gVar2) {
                return false;
            }
            do {
                gVar2 = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) gVar2.d;
                if (gVar2 == gVar) {
                    return false;
                }
            } while (!this.a.a(gVar, gVar2));
            return true;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":parent%s", this.a);
        }
    }

    public static class f extends com.getui.gtc.extension.distribution.gbd.n.d.e.i {
        public f(com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar) {
            this.a = dVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            if (gVar == gVar2) {
                return false;
            }
            do {
                gVar2 = gVar2.g();
                if (gVar2 == null) {
                    return false;
                }
            } while (!this.a.a(gVar, gVar2));
            return true;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":prev*%s", this.a);
        }
    }

    public static class g extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar == gVar2;
        }
    }
}
