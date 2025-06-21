package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
public abstract class d {

    public static final class a extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return true;
        }

        public final java.lang.String toString() {
            return "*";
        }
    }

    public static final class b extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public b(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s]", this.a);
        }
    }

    public static abstract class c extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        java.lang.String a;
        java.lang.String b;

        public c(java.lang.String str, java.lang.String str2) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str2);
            this.a = str.trim().toLowerCase();
            this.b = str2.trim().toLowerCase();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.e.d$d, reason: collision with other inner class name */
    public static final class C0327d extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public C0327d(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.a> it = gVar2.p().b().iterator();
            while (it.hasNext()) {
                if (it.next().a.startsWith(this.a)) {
                    return true;
                }
            }
            return false;
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[^%s]", this.a);
        }
    }

    public static final class e extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.c {
        public e(java.lang.String str, java.lang.String str2) {
            super(str, str2);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a) && this.b.equalsIgnoreCase(gVar2.p(this.a));
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s=%s]", this.a, this.b);
        }
    }

    public static final class f extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.c {
        public f(java.lang.String str, java.lang.String str2) {
            super(str, str2);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a) && gVar2.p(this.a).toLowerCase().contains(this.b);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s*=%s]", this.a, this.b);
        }
    }

    public static final class g extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.c {
        public g(java.lang.String str, java.lang.String str2) {
            super(str, str2);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a) && gVar2.p(this.a).toLowerCase().endsWith(this.b);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s$=%s]", this.a, this.b);
        }
    }

    public static final class h extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        java.lang.String a;
        java.util.regex.Pattern b;

        public h(java.lang.String str, java.util.regex.Pattern pattern) {
            this.a = str.trim().toLowerCase();
            this.b = pattern;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a) && this.b.matcher(gVar2.p(this.a)).find();
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s~=%s]", this.a, this.b.toString());
        }
    }

    public static final class i extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.c {
        public i(java.lang.String str, java.lang.String str2) {
            super(str, str2);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return !this.b.equalsIgnoreCase(gVar2.p(this.a));
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s!=%s]", this.a, this.b);
        }
    }

    public static final class j extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.c {
        public j(java.lang.String str, java.lang.String str2) {
            super(str, str2);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.q(this.a) && gVar2.p(this.a).toLowerCase().startsWith(this.b);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("[%s^=%s]", this.a, this.b);
        }
    }

    public static final class k extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public k(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.j(this.a);
        }

        public final java.lang.String toString() {
            return java.lang.String.format(".%s", this.a);
        }
    }

    public static final class l extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public l(java.lang.String str) {
            this.a = str.toLowerCase();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.j().toLowerCase().contains(this.a);
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":containsOwn(%s", this.a);
        }
    }

    public static final class m extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public m(java.lang.String str) {
            this.a = str.toLowerCase();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.i().toLowerCase().contains(this.a);
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":contains(%s", this.a);
        }
    }

    public static final class n extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public n(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            java.lang.String str = this.a;
            java.lang.String p = gVar2.p("id");
            if (p == null) {
                p = "";
            }
            return str.equals(p);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("#%s", this.a);
        }
    }

    public static final class o extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.p {
        public o(int i) {
            super(i);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.h().intValue() == this.a;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":eq(%d)", java.lang.Integer.valueOf(this.a));
        }
    }

    public static abstract class p extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        int a;

        public p(int i) {
            this.a = i;
        }
    }

    public static final class q extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.p {
        public q(int i) {
            super(i);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.h().intValue() > this.a;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":gt(%d)", java.lang.Integer.valueOf(this.a));
        }
    }

    public static final class r extends com.getui.gtc.extension.distribution.gbd.n.d.e.d.p {
        public r(int i) {
            super(i);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.h().intValue() < this.a;
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":lt(%d)", java.lang.Integer.valueOf(this.a));
        }
    }

    public static final class s extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.util.regex.Pattern a;

        public s(java.util.regex.Pattern pattern) {
            this.a = pattern;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return this.a.matcher(gVar2.i()).find();
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":matches(%s", this.a);
        }
    }

    public static final class t extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.util.regex.Pattern a;

        public t(java.util.regex.Pattern pattern) {
            this.a = pattern;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return this.a.matcher(gVar2.j()).find();
        }

        public final java.lang.String toString() {
            return java.lang.String.format(":matchesOwn(%s", this.a);
        }
    }

    public static final class u extends com.getui.gtc.extension.distribution.gbd.n.d.e.d {
        private java.lang.String a;

        public u(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.d
        public final boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2) {
            return gVar2.c.a.equals(this.a);
        }

        public final java.lang.String toString() {
            return java.lang.String.format("%s", this.a);
        }
    }

    public abstract boolean a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2);
}
