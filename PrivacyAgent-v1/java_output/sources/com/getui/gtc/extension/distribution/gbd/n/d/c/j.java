package com.getui.gtc.extension.distribution.gbd.n.d.c;

/* loaded from: classes22.dex */
final class j {
    static final char a = 65533;
    java.lang.StringBuilder c;
    com.getui.gtc.extension.distribution.gbd.n.d.c.h.g d;
    com.getui.gtc.extension.distribution.gbd.n.d.c.h.c e;
    com.getui.gtc.extension.distribution.gbd.n.d.c.h.b f;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.a h;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.e i;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.h j;
    private com.getui.gtc.extension.distribution.gbd.n.d.c.h.f m;
    com.getui.gtc.extension.distribution.gbd.n.d.c.k b = com.getui.gtc.extension.distribution.gbd.n.d.c.k.a;
    private boolean k = false;
    private java.lang.StringBuilder l = new java.lang.StringBuilder();
    boolean g = true;

    public j(com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar, com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar) {
        this.h = aVar;
        this.i = eVar;
    }

    private void b(java.lang.String str) {
        if (this.i.a()) {
            this.i.add(new com.getui.gtc.extension.distribution.gbd.n.d.c.d(this.h.c, "Invalid character reference: %s", str));
        }
    }

    private void c(java.lang.String str) {
        if (this.i.a()) {
            this.i.add(new com.getui.gtc.extension.distribution.gbd.n.d.c.d(this.h.c, str));
        }
    }

    private void d(com.getui.gtc.extension.distribution.gbd.n.d.c.k kVar) {
        this.b = kVar;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.c.k i() {
        return this.b;
    }

    private void j() {
        this.g = true;
    }

    private void k() {
        this.f = new com.getui.gtc.extension.distribution.gbd.n.d.c.h.b();
    }

    private static boolean l() {
        return true;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.c.h.g a(boolean z) {
        com.getui.gtc.extension.distribution.gbd.n.d.c.h.g fVar = z ? new com.getui.gtc.extension.distribution.gbd.n.d.c.h.f() : new com.getui.gtc.extension.distribution.gbd.n.d.c.h.e();
        this.d = fVar;
        return fVar;
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.c.h a() {
        if (!this.g) {
            c("Self closing flag not acknowledged");
            this.g = true;
        }
        while (!this.k) {
            this.b.a(this, this.h);
        }
        if (this.l.length() <= 0) {
            this.k = false;
            return this.j;
        }
        java.lang.String sb = this.l.toString();
        java.lang.StringBuilder sb2 = this.l;
        sb2.delete(0, sb2.length());
        return new com.getui.gtc.extension.distribution.gbd.n.d.c.h.a(sb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01a0, code lost:
    
        if (r11.h.b(com.alipay.sdk.m.n.a.h, '-', '_') == false) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Character a(java.lang.Character ch, boolean z) {
        char charAt;
        char charAt2;
        char charAt3;
        java.lang.String format;
        java.lang.String substring;
        char charAt4;
        int i;
        char c;
        char charAt5;
        if (this.h.a()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.h.b()) || this.h.b('\t', '\n', '\f', ' ', kotlin.text.Typography.less, kotlin.text.Typography.amp)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar = this.h;
        aVar.d = aVar.c;
        if (!aVar.a("#")) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar2 = this.h;
            int i2 = aVar2.c;
            while (!aVar2.a() && (((charAt3 = aVar2.b.charAt(aVar2.c)) >= 'A' && charAt3 <= 'Z') || (charAt3 >= 'a' && charAt3 <= 'z'))) {
                aVar2.c++;
            }
            while (!aVar2.a() && (charAt2 = aVar2.b.charAt(aVar2.c)) >= '0' && charAt2 <= '9') {
                aVar2.c++;
            }
            java.lang.String substring2 = aVar2.b.substring(i2, aVar2.c);
            java.lang.String str = new java.lang.String(substring2);
            boolean b = this.h.b(';');
            boolean z2 = false;
            while (substring2.length() > 0 && !z2) {
                if (com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(substring2)) {
                    z2 = true;
                } else {
                    substring2 = substring2.substring(0, substring2.length() - 1);
                    this.h.d();
                }
            }
            if (z2) {
                if (z) {
                    if (!this.h.i()) {
                        com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar3 = this.h;
                        if (!(!aVar3.a() && (charAt = aVar3.b.charAt(aVar3.c)) >= '0' && charAt <= '9')) {
                        }
                    }
                }
                if (!this.h.a(com.alipay.sdk.m.u.i.b)) {
                    b("missing semicolon");
                }
                return com.getui.gtc.extension.distribution.gbd.n.d.b.h.b(substring2);
            }
            format = b ? java.lang.String.format("invalid named referenece '%s'", str) : "numeric reference with no numerals";
            this.h.f();
            return null;
        }
        boolean b2 = this.h.b("X");
        com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar4 = this.h;
        if (b2) {
            int i3 = aVar4.c;
            while (!aVar4.a() && (((charAt5 = aVar4.b.charAt(aVar4.c)) >= '0' && charAt5 <= '9') || ((charAt5 >= 'A' && charAt5 <= 'F') || (charAt5 >= 'a' && charAt5 <= 'f')))) {
                aVar4.c++;
            }
            substring = aVar4.b.substring(i3, aVar4.c);
        } else {
            int i4 = aVar4.c;
            while (!aVar4.a() && (charAt4 = aVar4.b.charAt(aVar4.c)) >= '0' && charAt4 <= '9') {
                aVar4.c++;
            }
            substring = aVar4.b.substring(i4, aVar4.c);
        }
        if (substring.length() != 0) {
            if (!this.h.a(com.alipay.sdk.m.u.i.b)) {
                b("missing semicolon");
            }
            try {
                i = java.lang.Integer.valueOf(substring, b2 ? 16 : 10).intValue();
            } catch (java.lang.NumberFormatException unused) {
                i = -1;
            }
            if (i == -1 || ((i >= 55296 && i <= 57343) || i > 1114111)) {
                b("character outside of valid range");
                c = a;
            } else {
                c = (char) i;
            }
            return java.lang.Character.valueOf(c);
        }
        b(format);
        this.h.f();
        return null;
    }

    public final void a(char c) {
        this.l.append(c);
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.c.h hVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.b(this.k, "There is an unread token pending!");
        this.j = hVar;
        this.k = true;
        com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h enumC0322h = hVar.a;
        if (enumC0322h != com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.StartTag) {
            if (enumC0322h != com.getui.gtc.extension.distribution.gbd.n.d.c.h.EnumC0322h.EndTag || ((com.getui.gtc.extension.distribution.gbd.n.d.c.h.e) hVar).e.a() <= 0) {
                return;
            }
            c("Attributes incorrectly present on end tag");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar = (com.getui.gtc.extension.distribution.gbd.n.d.c.h.f) hVar;
        this.m = fVar;
        if (fVar.d) {
            this.g = false;
        }
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.c.k kVar) {
        this.h.e();
        this.b = kVar;
    }

    public final void a(java.lang.String str) {
        this.l.append(str);
    }

    public final void b() {
        com.getui.gtc.extension.distribution.gbd.n.d.c.h.g gVar = this.d;
        if (gVar.c != null) {
            gVar.g();
        }
        a(this.d);
    }

    public final void b(com.getui.gtc.extension.distribution.gbd.n.d.c.k kVar) {
        if (this.i.a()) {
            com.getui.gtc.extension.distribution.gbd.n.d.c.e eVar = this.i;
            com.getui.gtc.extension.distribution.gbd.n.d.c.a aVar = this.h;
            eVar.add(new com.getui.gtc.extension.distribution.gbd.n.d.c.d(aVar.c, "Unexpected character '%s' in input state [%s]", java.lang.Character.valueOf(aVar.b()), kVar));
        }
    }

    public final void c() {
        a(this.f);
    }

    public final void c(com.getui.gtc.extension.distribution.gbd.n.d.c.k kVar) {
        if (this.i.a()) {
            this.i.add(new com.getui.gtc.extension.distribution.gbd.n.d.c.d(this.h.c, "Unexpectedly reached end of file (EOF) in input state [%s]", kVar));
        }
    }

    public final void d() {
        this.e = new com.getui.gtc.extension.distribution.gbd.n.d.c.h.c();
    }

    public final void e() {
        a(this.e);
    }

    public final void f() {
        this.c = new java.lang.StringBuilder();
    }

    public final boolean g() {
        com.getui.gtc.extension.distribution.gbd.n.d.c.h.f fVar = this.m;
        if (fVar == null) {
            return false;
        }
        return this.d.b.equals(fVar.b);
    }

    public final java.lang.String h() {
        return this.m.b;
    }
}
