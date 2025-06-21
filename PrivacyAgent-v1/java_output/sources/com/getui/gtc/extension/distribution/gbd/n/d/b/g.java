package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public class g extends com.getui.gtc.extension.distribution.gbd.n.d.b.i {
    private java.util.Set<java.lang.String> a;
    public com.getui.gtc.extension.distribution.gbd.n.d.c.g c;

    public g(com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar, java.lang.String str) {
        this(gVar, str, new com.getui.gtc.extension.distribution.gbd.n.d.b.b());
    }

    public g(com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar, java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar) {
        super(str, bVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar);
        this.c = gVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g A() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) this.d;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c A(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.C0327d(str.trim().toLowerCase()), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c B() {
        com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
        a(this, cVar);
        return cVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c B(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.m(str), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c C(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.l(str), this);
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.j> C() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                arrayList.add((com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar);
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c D(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.s(java.util.regex.Pattern.compile(str)), this);
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new java.lang.IllegalArgumentException("Pattern syntax error: ".concat(java.lang.String.valueOf(str)), e);
        }
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.d> D() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.d) {
                arrayList.add((com.getui.gtc.extension.distribution.gbd.n.d.b.d) iVar);
            }
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c E() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.e.c(0);
        }
        com.getui.gtc.extension.distribution.gbd.n.d.e.c e = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).e();
        com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c(e.size() - 1);
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : e) {
            if (gVar != this) {
                cVar.add(gVar);
            }
        }
        return cVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c E(java.lang.String str) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.t(java.util.regex.Pattern.compile(str)), this);
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new java.lang.IllegalArgumentException("Pattern syntax error: ".concat(java.lang.String.valueOf(str)), e);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g F() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.e.c e = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).e();
        java.lang.Integer a = a(this, (java.util.List) e);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(a);
        if (e.size() > a.intValue() + 1) {
            return e.get(a.intValue() + 1);
        }
        return null;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g F(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.util.Set<java.lang.String> m = m();
        m.add(str);
        a(m);
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g G() {
        com.getui.gtc.extension.distribution.gbd.n.d.e.c e = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) this.d).e();
        if (e.size() > 1) {
            return e.get(0);
        }
        return null;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g G(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.util.Set<java.lang.String> m = m();
        m.remove(str);
        a(m);
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g H() {
        com.getui.gtc.extension.distribution.gbd.n.d.e.c e = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) this.d).e();
        if (e.size() > 1) {
            return e.get(e.size() - 1);
        }
        return null;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g H(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.util.Set<java.lang.String> m = m();
        if (m.contains(str)) {
            m.remove(str);
        } else {
            m.add(str);
        }
        a(m);
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c I() {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.a(), this);
    }

    private java.lang.String J() {
        java.lang.String b;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.d) {
                b = ((com.getui.gtc.extension.distribution.gbd.n.d.b.d) iVar).b();
            } else if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                b = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).J();
            }
            sb.append(b);
        }
        return sb.toString();
    }

    private java.lang.String K() {
        return p("class");
    }

    private java.lang.String L() {
        return this.c.a.equals("textarea") ? i() : p("value");
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g a(int i) {
        return e().get(i);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Tag name must not be empty.");
        this.c = com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str);
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.lang.String str, java.util.regex.Pattern pattern) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.h(str, pattern), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.util.regex.Pattern pattern) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.s(pattern), this);
    }

    private static <E extends com.getui.gtc.extension.distribution.gbd.n.d.b.g> java.lang.Integer a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, java.util.List<E> list) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(gVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(gVar)) {
                return java.lang.Integer.valueOf(i);
            }
        }
        return null;
    }

    public static void a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar) {
        while (true) {
            gVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) gVar.d;
            if (gVar == null || gVar.c.a.equals("#root")) {
                return;
            } else {
                cVar.add(gVar);
            }
        }
    }

    private static void a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar, java.lang.StringBuilder sb) {
        if (!gVar.c.a.equals("br") || com.getui.gtc.extension.distribution.gbd.n.d.b.j.b(sb)) {
            return;
        }
        sb.append(" ");
    }

    private void a(java.lang.StringBuilder sb, com.getui.gtc.extension.distribution.gbd.n.d.b.j jVar) {
        java.lang.String c = jVar.c();
        if (!k()) {
            c = com.getui.gtc.extension.distribution.gbd.n.d.a.d.c(c);
            if (com.getui.gtc.extension.distribution.gbd.n.d.b.j.b(sb)) {
                c = com.getui.gtc.extension.distribution.gbd.n.d.b.j.a(c);
            }
        }
        sb.append(c);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c b(int i) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.r(i), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c b(java.util.regex.Pattern pattern) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.t(pattern), this);
    }

    private void b(java.lang.StringBuilder sb) {
        a(this, sb);
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                a(sb, (com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar);
            } else if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar;
                if (sb.length() > 0 && gVar.c.b && !com.getui.gtc.extension.distribution.gbd.n.d.b.j.b(sb)) {
                    sb.append(" ");
                }
                gVar.b(sb);
            }
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c c(int i) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.q(i), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c c(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.e(str, str2), this);
    }

    private void c(java.lang.StringBuilder sb) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                a(sb, (com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar);
            } else if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                a((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar, sb);
            }
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c d(int i) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.o(i), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c d(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.i(str, str2), this);
    }

    private void d(java.lang.StringBuilder sb) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.i> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(sb);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c e(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.j(str, str2), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c f(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.g(str, str2), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g g(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.d(iVar);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c g(java.lang.String str, java.lang.String str2) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.f(str, str2), this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c h(java.lang.String str, java.lang.String str2) {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.h(str, java.util.regex.Pattern.compile(str2)), this);
        } catch (java.util.regex.PatternSyntaxException e) {
            throw new java.lang.IllegalArgumentException("Pattern syntax error: ".concat(java.lang.String.valueOf(str2)), e);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c t(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.h.a(str, this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g u(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str), this.g);
        b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar);
        return gVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g v(java.lang.String str) {
        a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.j(str, this.g));
        return this;
    }

    private java.lang.String v() {
        return this.c.a;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g w(java.lang.String str) {
        b((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.j(str, this.g));
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.g w() {
        return this.c;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g x(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        com.getui.gtc.extension.distribution.gbd.n.d.e.c a = com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.n(str), this);
        if (a.size() > 0) {
            return a.get(0);
        }
        return null;
    }

    private boolean x() {
        return this.c.b;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c y(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.k(str), this);
    }

    private java.lang.String y() {
        java.lang.String p = p("id");
        return p == null ? "" : p;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c z(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.b(str.trim().toLowerCase()), this);
    }

    private java.util.Map<java.lang.String, java.lang.String> z() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.b.a(this.f, (byte) 0);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar);
        a(iVar);
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g b(java.lang.String str, java.lang.String str2) {
        super.b(str, str2);
        return this;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a(java.util.Set<java.lang.String> set) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(set);
        this.f.a("class", com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(set, " "));
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public java.lang.String a() {
        return this.c.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (((com.getui.gtc.extension.distribution.gbd.n.d.b.g) r0).c.c != false) goto L12;
     */
    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        if (sb.length() > 0 && aVar.d) {
            if (!this.c.c) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
                if (((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar) != null) {
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.d.b.i.c(sb, i, aVar);
        }
        sb.append("<");
        sb.append(this.c.a);
        this.f.a(sb, aVar);
        sb.append((this.e.isEmpty() && this.c.a()) ? " />" : ">");
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar);
        a(0, iVar);
        return this;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.g b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        f();
        a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) new com.getui.gtc.extension.distribution.gbd.n.d.b.j(str, this.g));
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        if (this.e.isEmpty() && this.c.a()) {
            return;
        }
        if (aVar.d && !this.e.isEmpty() && this.c.c) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i.c(sb, i, aVar);
        }
        sb.append("</");
        sb.append(this.c.a);
        sb.append(">");
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public com.getui.gtc.extension.distribution.gbd.n.d.b.g d() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.d();
        gVar.m();
        return gVar;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g e(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.e(iVar);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g c(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.b.g(com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str), this.g);
        a((com.getui.gtc.extension.distribution.gbd.n.d.b.i) gVar);
        return gVar;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a = com.getui.gtc.extension.distribution.gbd.n.d.c.f.a(str, this, this.g);
        a((com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) a.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[a.size()]));
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.b.i d(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.d(iVar);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g e(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a = com.getui.gtc.extension.distribution.gbd.n.d.c.f.a(str, this, this.g);
        a(0, (com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) a.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[a.size()]));
        return this;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.e.c e() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) {
                arrayList.add((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar);
            }
        }
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.c((java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g>) arrayList);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public boolean equals(java.lang.Object obj) {
        return this == obj;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g f() {
        this.e.clear();
        return this;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g o(java.lang.String str) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.o(str);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g g() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.e.c e = ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).e();
        java.lang.Integer a = a(this, (java.util.List) e);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(a);
        if (a.intValue() > 0) {
            return e.get(a.intValue() - 1);
        }
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g n(java.lang.String str) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.n(str);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g m(java.lang.String str) {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) super.m(str);
    }

    public final java.lang.Integer h() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar) == null) {
            return 0;
        }
        return a(this, (java.util.List) ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).e());
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        com.getui.gtc.extension.distribution.gbd.n.d.c.g gVar = this.c;
        return hashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.e.c i(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        return com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.u(str.toLowerCase().trim()), this);
    }

    public final java.lang.String i() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        b(sb);
        return sb.toString().trim();
    }

    public final java.lang.String j() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        c(sb);
        return sb.toString().trim();
    }

    public final boolean j(java.lang.String str) {
        java.util.Iterator<java.lang.String> it = m().iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g k(java.lang.String str) {
        if (this.c.a.equals("textarea")) {
            b(str);
        } else {
            b("value", str);
        }
        return this;
    }

    public final boolean k() {
        if (this.c.e) {
            return true;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        return ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar) != null && ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).k();
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g l(java.lang.String str) {
        f();
        d(str);
        return this;
    }

    public final boolean l() {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : this.e) {
            if (iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.j) {
                if (!com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(((com.getui.gtc.extension.distribution.gbd.n.d.b.j) iVar).c())) {
                    return true;
                }
            } else if ((iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g) && ((com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar).l()) {
                return true;
            }
        }
        return false;
    }

    public final java.util.Set<java.lang.String> m() {
        if (this.a == null) {
            this.a = new java.util.LinkedHashSet(java.util.Arrays.asList(p("class").split("\\s+")));
        }
        return this.a;
    }

    public final java.lang.String n() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        d(sb);
        return sb.toString().trim();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.b.i o() {
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.g) this.d;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.n.d.b.i
    public java.lang.String toString() {
        return a_();
    }
}
