package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public abstract class i implements java.lang.Cloneable {
    public com.getui.gtc.extension.distribution.gbd.n.d.b.i d;
    public java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> e;
    com.getui.gtc.extension.distribution.gbd.n.d.b.b f;
    public java.lang.String g;
    int h;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.b.i$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.n.d.e.f {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
            iVar.g = this.a;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
        }
    }

    public static class a implements com.getui.gtc.extension.distribution.gbd.n.d.e.f {
        private java.lang.StringBuilder a;
        private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a b;

        public a(java.lang.StringBuilder sb, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
            this.a = sb;
            this.b = aVar;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
            iVar.a(this.a, i, this.b);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.n.d.e.f
        public final void b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, int i) {
            if (iVar.a().equals("#text")) {
                return;
            }
            iVar.b(this.a, i, this.b);
        }
    }

    public i() {
        this.e = java.util.Collections.emptyList();
        this.f = null;
    }

    public i(java.lang.String str) {
        this(str, new com.getui.gtc.extension.distribution.gbd.n.d.b.b());
    }

    public i(java.lang.String str, com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(bVar);
        this.e = new java.util.ArrayList(4);
        this.g = str.trim();
        this.f = bVar;
    }

    private static com.getui.gtc.extension.distribution.gbd.n.d.b.g a(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        while (true) {
            com.getui.gtc.extension.distribution.gbd.n.d.e.c e = gVar.e();
            if (e.size() <= 0) {
                return gVar;
            }
            gVar = e.get(0);
        }
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.i a(com.getui.gtc.extension.distribution.gbd.n.d.e.f fVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(fVar);
        new com.getui.gtc.extension.distribution.gbd.n.d.e.e(fVar).a(this);
        return this;
    }

    private void a(int i) {
        this.h = i;
    }

    private void a(int i, java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a2 = com.getui.gtc.extension.distribution.gbd.n.d.c.f.a(str, o() instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g ? (com.getui.gtc.extension.distribution.gbd.n.d.b.g) o() : null, this.g);
        this.d.a(i, (com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) a2.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[a2.size()]));
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        this.d.a(this, iVar);
    }

    private void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar, com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar.d == this);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar2);
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar3 = iVar2.d;
        if (iVar3 != null) {
            iVar3.f(iVar2);
        }
        java.lang.Integer valueOf = java.lang.Integer.valueOf(iVar.h);
        this.e.set(valueOf.intValue(), iVar2);
        iVar2.d = this;
        iVar2.h = valueOf.intValue();
        iVar.d = null;
    }

    private void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.i.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.n.d.b.i.AnonymousClass1(str);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(anonymousClass1);
        new com.getui.gtc.extension.distribution.gbd.n.d.e.e(anonymousClass1).a(this);
    }

    private void b(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = this.d;
        if (iVar2 != null) {
            iVar2.f(this);
        }
        this.d = iVar;
    }

    private java.lang.String c() {
        return this.g;
    }

    private void c(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = iVar.d;
        if (iVar2 != null) {
            iVar2.f(iVar);
        }
        iVar.b(this);
    }

    public static void c(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        sb.append("\n");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.d.a.d.a(i * aVar.e));
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> e() {
        return java.util.Collections.unmodifiableList(this.e);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.i[] f() {
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> list = this.e;
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) list.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[java.util.Collections.unmodifiableList(list).size()]);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.i g(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        try {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = (com.getui.gtc.extension.distribution.gbd.n.d.b.i) super.clone();
            iVar2.d = iVar;
            iVar2.h = iVar == null ? 0 : this.h;
            com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
            iVar2.f = bVar != null ? bVar.clone() : null;
            iVar2.g = this.g;
            iVar2.e = new java.util.ArrayList(this.e.size());
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.i> it = this.e.iterator();
            while (it.hasNext()) {
                iVar2.e.add(it.next().g(iVar2));
            }
            return iVar2;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private void g() {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).h = i;
        }
    }

    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> h() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return java.util.Collections.emptyList();
        }
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> list = iVar.e;
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size() - 1);
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 : list) {
            if (iVar2 != this) {
                arrayList.add(iVar2);
            }
        }
        return arrayList;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.i i() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return null;
        }
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> list = iVar.e;
        java.lang.Integer valueOf = java.lang.Integer.valueOf(this.h);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(valueOf);
        if (valueOf.intValue() > 0) {
            return list.get(valueOf.intValue() - 1);
        }
        return null;
    }

    private int j() {
        return this.h;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.e.a k() {
        return (r() != null ? r() : new com.getui.gtc.extension.distribution.gbd.n.d.b.e("")).a;
    }

    public abstract java.lang.String a();

    public final void a(int i, com.getui.gtc.extension.distribution.gbd.n.d.b.i... iVarArr) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object[]) iVarArr);
        for (int length = iVarArr.length - 1; length >= 0; length--) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = iVarArr[length];
            c(iVar);
            this.e.add(i, iVar);
        }
        g();
    }

    public final void a(java.lang.StringBuilder sb) {
        new com.getui.gtc.extension.distribution.gbd.n.d.e.e(new com.getui.gtc.extension.distribution.gbd.n.d.b.i.a(sb, k())).a(this);
    }

    public abstract void a(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar);

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.i... iVarArr) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar : iVarArr) {
            c(iVar);
            this.e.add(iVar);
            iVar.h = this.e.size() - 1;
        }
    }

    public java.lang.String a_() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        a(sb);
        return sb.toString();
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i b(java.lang.String str, java.lang.String str2) {
        this.f.a(str, str2);
        return this;
    }

    public abstract void b(java.lang.StringBuilder sb, int i, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar);

    @Override // 
    public com.getui.gtc.extension.distribution.gbd.n.d.b.i d() {
        return g(null);
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i d(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        this.d.a(this.h + 1, iVar);
        return this;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i e(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        this.d.a(this.h, iVar);
        return this;
    }

    public boolean equals(java.lang.Object obj) {
        return this == obj;
    }

    public final void f(com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(iVar.d == this);
        this.e.remove(iVar.h);
        g();
        iVar.d = null;
    }

    public int hashCode() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        int hashCode = (iVar != null ? iVar.hashCode() : 0) * 31;
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i m(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> a2 = com.getui.gtc.extension.distribution.gbd.n.d.c.f.a(str, o() instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g ? (com.getui.gtc.extension.distribution.gbd.n.d.b.g) o() : null, this.g);
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = a2.get(0);
        if (iVar == null || !(iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.g)) {
            return null;
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.g) iVar;
        com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar2 = gVar;
        while (true) {
            com.getui.gtc.extension.distribution.gbd.n.d.e.c e = gVar2.e();
            if (e.size() <= 0) {
                break;
            }
            gVar2 = e.get(0);
        }
        this.d.a(this, gVar);
        gVar2.a(this);
        if (a2.size() > 0) {
            for (int i = 0; i < a2.size(); i++) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = a2.get(i);
                iVar2.d.f(iVar2);
                gVar.a(iVar2);
            }
        }
        return this;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i n(java.lang.String str) {
        a(this.h + 1, str);
        return this;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i o() {
        return this.d;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i o(java.lang.String str) {
        a(this.h, str);
        return this;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.b p() {
        return this.f;
    }

    public java.lang.String p(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        return this.f.b(str) ? this.f.a(str) : str.toLowerCase().startsWith("abs:") ? s(str.substring(4)) : "";
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.i q() {
        return this.e.get(0);
    }

    public boolean q(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        if (str.toLowerCase().startsWith("abs:")) {
            java.lang.String substring = str.substring(4);
            if (this.f.b(substring) && !s(substring).equals("")) {
                return true;
            }
        }
        return this.f.b(str);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.e r() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this;
        while (!(iVar instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.e)) {
            iVar = iVar.d;
            if (iVar == null) {
                return null;
            }
        }
        return (com.getui.gtc.extension.distribution.gbd.n.d.b.e) iVar;
    }

    public com.getui.gtc.extension.distribution.gbd.n.d.b.i r(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
        com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = this.f;
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = bVar.b;
        if (linkedHashMap != null) {
            linkedHashMap.remove(str.toLowerCase());
        }
        return this;
    }

    public java.lang.String s(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.lang.String p = p(str);
        try {
            if (!q(str)) {
                return "";
            }
            try {
                java.net.URL url = new java.net.URL(this.g);
                if (p.startsWith("?")) {
                    p = url.getPath() + p;
                }
                return new java.net.URL(url, p).toExternalForm();
            } catch (java.net.MalformedURLException unused) {
                return new java.net.URL(p).toExternalForm();
            }
        } catch (java.net.MalformedURLException unused2) {
            return "";
        }
    }

    public final void s() {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        this.d.f(this);
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.i t() {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(this.d);
        int i = this.h;
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.e.size() > 0 ? this.e.get(0) : null;
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar2 = this.d;
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> list = this.e;
        iVar2.a(i, (com.getui.gtc.extension.distribution.gbd.n.d.b.i[]) list.toArray(new com.getui.gtc.extension.distribution.gbd.n.d.b.i[java.util.Collections.unmodifiableList(list).size()]));
        s();
        return iVar;
    }

    public java.lang.String toString() {
        return a_();
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.i u() {
        com.getui.gtc.extension.distribution.gbd.n.d.b.i iVar = this.d;
        if (iVar == null) {
            return null;
        }
        java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.i> list = iVar.e;
        java.lang.Integer valueOf = java.lang.Integer.valueOf(this.h);
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(valueOf);
        if (list.size() > valueOf.intValue() + 1) {
            return list.get(valueOf.intValue() + 1);
        }
        return null;
    }
}
