package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
abstract class h {
    com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h a;

    public static class a extends com.getui.gtc.extension.distribution.gbd.n.d.c.h {
        final java.lang.String b;

        public a(java.lang.String str) {
            super((byte) 0);
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Character;
            this.b = str;
        }

        private java.lang.String g() {
            return this.b;
        }

        public final java.lang.String toString() {
            return this.b;
        }
    }

    public static class b extends com.getui.gtc.extension.distribution.gbd.n.d.c.h {
        final java.lang.StringBuilder b;

        public b() {
            super((byte) 0);
            this.b = new java.lang.StringBuilder();
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Comment;
        }

        private java.lang.String g() {
            return this.b.toString();
        }

        public final java.lang.String toString() {
            return "<!--" + this.b.toString() + "-->";
        }
    }

    public static class c extends com.getui.gtc.extension.distribution.gbd.n.d.c.h {
        final java.lang.StringBuilder b;
        final java.lang.StringBuilder c;
        final java.lang.StringBuilder d;
        boolean e;

        public c() {
            super((byte) 0);
            this.b = new java.lang.StringBuilder();
            this.c = new java.lang.StringBuilder();
            this.d = new java.lang.StringBuilder();
            this.e = false;
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Doctype;
        }

        private java.lang.String g() {
            return this.b.toString();
        }

        private java.lang.String h() {
            return this.c.toString();
        }

        private java.lang.String i() {
            return this.d.toString();
        }

        private boolean j() {
            return this.e;
        }
    }

    public static class d extends com.getui.gtc.extension.distribution.gbd.n.d.c.h {
        public d() {
            super((byte) 0);
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EOF;
        }
    }

    public static class e extends com.getui.gtc.extension.distribution.gbd.n.d.c.h.g {
        public e() {
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EndTag;
        }

        public e(java.lang.String str) {
            this();
            this.b = str;
        }

        public final java.lang.String toString() {
            return "</" + h() + " " + this.e.toString() + ">";
        }
    }

    public static class f extends com.getui.gtc.extension.distribution.gbd.n.d.c.h.g {
        public f() {
            this.a = com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.StartTag;
        }

        public f(java.lang.String str) {
            this();
            this.b = str;
        }

        public f(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar) {
            this();
            this.b = str;
            this.e = bVar;
        }

        public final java.lang.String toString() {
            return "<" + h() + " " + this.e.toString() + ">";
        }
    }

    public static abstract class g extends com.getui.gtc.extension.distribution.gbd.n.d.c.h {
        protected java.lang.String b;
        java.lang.String c;
        boolean d;
        com.getui.gtc.extension.distribution.gbd.n.d.b.b e;
        private java.lang.String f;

        public g() {
            super((byte) 0);
            this.d = false;
            this.e = new com.getui.gtc.extension.distribution.gbd.n.d.b.b();
        }

        private void i() {
            if (this.c != null) {
                g();
            }
        }

        private boolean j() {
            return this.d;
        }

        private com.getui.gtc.extension.distribution.gbd.n.d.b.b k() {
            return this.e;
        }

        public final com.getui.gtc.extension.distribution.gbd.n.d.c.h.g a(java.lang.String str) {
            this.b = str;
            return this;
        }

        public final void a(char c) {
            b(java.lang.String.valueOf(c));
        }

        public final void b(char c) {
            c(java.lang.String.valueOf(c));
        }

        public final void b(java.lang.String str) {
            java.lang.String str2 = this.b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.b = str;
        }

        public final void c(char c) {
            d(java.lang.String.valueOf(c));
        }

        public final void c(java.lang.String str) {
            java.lang.String str2 = this.c;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.c = str;
        }

        public final void d(java.lang.String str) {
            java.lang.String str2 = this.f;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f = str;
        }

        public final void g() {
            java.lang.String str = this.c;
            if (str != null) {
                if (this.f == null) {
                    this.f = "";
                }
                this.e.a(new com.getui.gtc.extension.distribution.gbd.n.d.b.a(str, this.f));
            }
            this.c = null;
            this.f = null;
        }

        public final java.lang.String h() {
            if (this.b.length() == 0) {
                throw new java.lang.IllegalArgumentException("Must be false");
            }
            return this.b;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.c.h$h, reason: collision with other inner class name */
    public enum EnumC0322h {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    private h() {
    }

    public /* synthetic */ h(byte b2) {
        this();
    }

    private java.lang.String g() {
        return getClass().getSimpleName();
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.c h() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.c.h.c) this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.f i() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.c.h.f) this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.e j() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.c.h.e) this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.b k() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.c.h.b) this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.a l() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.c.h.a) this;
    }

    public final boolean a() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Doctype;
    }

    public final boolean b() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.StartTag;
    }

    public final boolean c() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EndTag;
    }

    public final boolean d() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Comment;
    }

    public final boolean e() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.Character;
    }

    public final boolean f() {
        return this.a == com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EOF;
    }
}
