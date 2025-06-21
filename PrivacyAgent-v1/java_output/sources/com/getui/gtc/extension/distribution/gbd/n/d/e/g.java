package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
final class g {
    private static final java.lang.String[] a = {",", ">", "+", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR, " "};
    private com.getui.gtc.extension.distribution.gbd.n.d.c.i b;
    private java.lang.String c;
    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.e.d> d = new java.util.ArrayList();

    private g(java.lang.String str) {
        this.c = str;
        this.b = new com.getui.gtc.extension.distribution.gbd.n.d.c.i(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0026, code lost:
    
        c();
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0041 -> B:5:0x001f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x003c -> B:4:0x0019). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.getui.gtc.extension.distribution.gbd.n.d.e.d a() {
        this.b.d();
        if (this.b.a(a)) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.i.g());
            char c = this.b.c();
            a(c);
            while (!this.b.a()) {
                boolean d = this.b.d();
                if (this.b.a(a)) {
                    char c2 = this.b.c();
                    a(c2);
                    while (!this.b.a()) {
                    }
                } else if (d) {
                    c2 = ' ';
                    a(c2);
                    while (!this.b.a()) {
                    }
                }
            }
            return this.d.size() == 1 ? this.d.get(0) : new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(this.d);
        }
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        r0.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0046 -> B:5:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0041 -> B:4:0x001e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.getui.gtc.extension.distribution.gbd.n.d.e.d a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.e.g gVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.g(str);
        gVar.b.d();
        if (gVar.b.a(a)) {
            gVar.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.i.g());
            char c = gVar.b.c();
            gVar.a(c);
            while (!gVar.b.a()) {
                boolean d = gVar.b.d();
                if (gVar.b.a(a)) {
                    char c2 = gVar.b.c();
                    gVar.a(c2);
                    while (!gVar.b.a()) {
                    }
                } else if (d) {
                    c2 = ' ';
                    gVar.a(c2);
                    while (!gVar.b.a()) {
                    }
                }
            }
            return gVar.d.size() == 1 ? gVar.d.get(0) : new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(gVar.d);
        }
        gVar.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(char c) {
        com.getui.gtc.extension.distribution.gbd.n.d.e.d aVar;
        com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar;
        boolean z;
        com.getui.gtc.extension.distribution.gbd.n.d.e.d dVar2;
        this.b.d();
        com.getui.gtc.extension.distribution.gbd.n.d.e.d a2 = a(b());
        if (this.d.size() == 1) {
            aVar = this.d.get(0);
            if ((aVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b) && c != ',') {
                z = true;
                dVar = aVar;
                aVar = ((com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b) aVar).a();
                this.d.clear();
                if (c != '>') {
                    dVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(a2, new com.getui.gtc.extension.distribution.gbd.n.d.e.i.b(aVar));
                } else if (c == ' ') {
                    dVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(a2, new com.getui.gtc.extension.distribution.gbd.n.d.e.i.e(aVar));
                } else if (c == '+') {
                    dVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(a2, new com.getui.gtc.extension.distribution.gbd.n.d.e.i.c(aVar));
                } else if (c == '~') {
                    dVar2 = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(a2, new com.getui.gtc.extension.distribution.gbd.n.d.e.i.f(aVar));
                } else {
                    if (c != ',') {
                        throw new com.getui.gtc.extension.distribution.gbd.n.d.e.h.a("Unknown combinator: ".concat(java.lang.String.valueOf(c)), new java.lang.Object[0]);
                    }
                    if (aVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b) {
                        com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b c0326b = (com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b) aVar;
                        c0326b.b(a2);
                        dVar2 = c0326b;
                    } else {
                        com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b c0326b2 = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b();
                        c0326b2.b(aVar);
                        c0326b2.b(a2);
                        dVar2 = c0326b2;
                    }
                }
                if (z) {
                    dVar = dVar2;
                } else {
                    ((com.getui.gtc.extension.distribution.gbd.n.d.e.b.C0326b) dVar).a(dVar2);
                }
                this.d.add(dVar);
            }
        } else {
            aVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.b.a(this.d);
        }
        dVar = aVar;
        z = false;
        this.d.clear();
        if (c != '>') {
        }
        if (z) {
        }
        this.d.add(dVar);
    }

    private void a(boolean z) {
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.e.d> list;
        com.getui.gtc.extension.distribution.gbd.n.d.e.d mVar;
        this.b.c(z ? ":containsOwn" : ":contains");
        java.lang.String f = com.getui.gtc.extension.distribution.gbd.n.d.c.i.f(this.b.a('(', ')'));
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(f, ":contains(text) query must not be empty");
        if (z) {
            list = this.d;
            mVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.d.l(f);
        } else {
            list = this.d;
            mVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.d.m(f);
        }
        list.add(mVar);
    }

    private java.lang.String b() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (!this.b.a()) {
            if (!this.b.a("(")) {
                if (!this.b.a("[")) {
                    if (this.b.a(a)) {
                        break;
                    }
                    sb.append(this.b.c());
                } else {
                    sb.append("[");
                    sb.append(this.b.a('[', ']'));
                    str = "]";
                }
            } else {
                sb.append("(");
                sb.append(this.b.a('(', ')'));
                str = ")";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private void b(boolean z) {
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.e.d> list;
        com.getui.gtc.extension.distribution.gbd.n.d.e.d sVar;
        this.b.c(z ? ":matchesOwn" : ":matches");
        java.lang.String a2 = this.b.a('(', ')');
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(a2, ":matches(regex) query must not be empty");
        if (z) {
            list = this.d;
            sVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.d.t(java.util.regex.Pattern.compile(a2));
        } else {
            list = this.d;
            sVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.d.s(java.util.regex.Pattern.compile(a2));
        }
        list.add(sVar);
    }

    private void c() {
        if (this.b.b("#")) {
            d();
            return;
        }
        if (this.b.b(".")) {
            e();
            return;
        }
        if (this.b.b()) {
            f();
            return;
        }
        if (this.b.a("[")) {
            g();
            return;
        }
        if (this.b.b("*")) {
            h();
            return;
        }
        if (this.b.b(":lt(")) {
            i();
            return;
        }
        if (this.b.b(":gt(")) {
            j();
            return;
        }
        if (this.b.b(":eq(")) {
            k();
            return;
        }
        if (this.b.a(":has(")) {
            m();
            return;
        }
        if (this.b.a(":contains(")) {
            a(false);
            return;
        }
        if (this.b.a(":containsOwn(")) {
            a(true);
            return;
        }
        if (this.b.a(":matches(")) {
            b(false);
        } else if (this.b.a(":matchesOwn(")) {
            b(true);
        } else {
            if (!this.b.a(":not(")) {
                throw new com.getui.gtc.extension.distribution.gbd.n.d.e.h.a("Could not parse query '%s': unexpected token at '%s'", this.c, this.b.g());
            }
            n();
        }
    }

    private void d() {
        java.lang.String f = this.b.f();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(f);
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.n(f));
    }

    private void e() {
        java.lang.String f = this.b.f();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(f);
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.k(f.trim().toLowerCase()));
    }

    private void f() {
        java.lang.String e = this.b.e();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(e);
        if (e.contains("|")) {
            e = e.replace("|", com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        }
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.u(e.trim().toLowerCase()));
    }

    private void g() {
        com.getui.gtc.extension.distribution.gbd.n.d.c.i iVar = new com.getui.gtc.extension.distribution.gbd.n.d.c.i(this.b.a('[', ']'));
        java.lang.String b = iVar.b(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, "!=", "^=", "$=", "*=", "~=");
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(b);
        iVar.d();
        if (iVar.a()) {
            if (b.startsWith("^")) {
                this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.C0327d(b.substring(1)));
                return;
            } else {
                this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.b(b));
                return;
            }
        }
        if (iVar.b(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.e(b, iVar.g()));
            return;
        }
        if (iVar.b("!=")) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.i(b, iVar.g()));
            return;
        }
        if (iVar.b("^=")) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.j(b, iVar.g()));
            return;
        }
        if (iVar.b("$=")) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.g(b, iVar.g()));
        } else if (iVar.b("*=")) {
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.f(b, iVar.g()));
        } else {
            if (!iVar.b("~=")) {
                throw new com.getui.gtc.extension.distribution.gbd.n.d.e.h.a("Could not parse attribute query '%s': unexpected token at '%s'", this.c, iVar.g());
            }
            this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.h(b, java.util.regex.Pattern.compile(iVar.g())));
        }
    }

    private void h() {
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.a());
    }

    private void i() {
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.r(l()));
    }

    private void j() {
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.q(l()));
    }

    private void k() {
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.o(l()));
    }

    private int l() {
        java.lang.String trim = this.b.e(")").trim();
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(com.getui.gtc.extension.distribution.gbd.n.d.a.d.b(trim), "Index must be numeric");
        return java.lang.Integer.parseInt(trim);
    }

    private void m() {
        this.b.c(":has");
        java.lang.String a2 = this.b.a('(', ')');
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(a2, ":has(el) subselect must not be empty");
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.i.a(a(a2)));
    }

    private void n() {
        this.b.c(":not");
        java.lang.String a2 = this.b.a('(', ')');
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(a2, ":not(selector) subselect must not be empty");
        this.d.add(new com.getui.gtc.extension.distribution.gbd.n.d.e.i.d(a(a2)));
    }
}
