package com.getui.gtc.extension.distribution.gbd.n.d.e;

/* loaded from: classes22.dex */
public final class c implements java.lang.Cloneable, java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g> {
    private java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g> a;

    public c() {
        this.a = new java.util.ArrayList();
    }

    public c(int i) {
        this.a = new java.util.ArrayList(i);
    }

    public c(java.util.Collection<com.getui.gtc.extension.distribution.gbd.n.d.b.g> collection) {
        this.a = new java.util.ArrayList(collection);
    }

    public c(java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g> list) {
        this.a = list;
    }

    private c(com.getui.gtc.extension.distribution.gbd.n.d.b.g... gVarArr) {
        this((java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g>) java.util.Arrays.asList(gVarArr));
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g a(int i, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return this.a.set(i, gVar);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c a(com.getui.gtc.extension.distribution.gbd.n.d.e.f fVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(fVar);
        com.getui.gtc.extension.distribution.gbd.n.d.e.e eVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.e(fVar);
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            eVar.a(it.next());
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c a(java.lang.String str, java.lang.String str2) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(str, str2);
        }
        return this;
    }

    private java.lang.String a(java.lang.String str) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            if (gVar.q(str)) {
                return gVar.p(str);
            }
        }
        return "";
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c b() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().d());
        }
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.c((java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g>) arrayList);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c b(int i) {
        return this.a.size() > i ? new com.getui.gtc.extension.distribution.gbd.n.d.e.c(get(i)) : new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
    }

    private void b(int i, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        this.a.add(i, gVar);
    }

    private boolean b(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().q(str)) {
                return true;
            }
        }
        return false;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g c(int i) {
        return this.a.remove(i);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c c(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().r(str);
        }
        return this;
    }

    private java.lang.String c() {
        if (size() <= 0) {
            return "";
        }
        com.getui.gtc.extension.distribution.gbd.n.d.b.g a = a();
        return a.c.a.equals("textarea") ? a.i() : a.p("value");
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c d(java.lang.String str) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
            java.util.Set<java.lang.String> m = gVar.m();
            m.add(str);
            gVar.a(m);
        }
        return this;
    }

    private java.lang.String d() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(gVar.i());
        }
        return sb.toString();
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c e(java.lang.String str) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
            java.util.Set<java.lang.String> m = gVar.m();
            m.remove(str);
            gVar.a(m);
        }
        return this;
    }

    private boolean e() {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().l()) {
                return true;
            }
        }
        return false;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c f(java.lang.String str) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a((java.lang.Object) str);
            java.util.Set<java.lang.String> m = gVar.m();
            if (m.contains(str)) {
                m.remove(str);
            } else {
                m.add(str);
            }
            gVar.a(m);
        }
        return this;
    }

    private java.lang.String f() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(gVar.n());
        }
        return sb.toString();
    }

    private java.lang.String g() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(gVar.a_());
        }
        return sb.toString();
    }

    private boolean g(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().j(str)) {
                return true;
            }
        }
        return false;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c h() {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().t();
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c h(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().k(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c i() {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c i(java.lang.String str) {
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str, "Tag name must not be empty.");
            gVar.c = com.getui.gtc.extension.distribution.gbd.n.d.c.g.a(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c j() {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().s();
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c j(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().l(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c k() {
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
            com.getui.gtc.extension.distribution.gbd.n.d.b.g.a(gVar, cVar);
            linkedHashSet.addAll(cVar);
        }
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.c(linkedHashSet);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c k(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.b.g l() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(r0.size() - 1);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c l(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c m(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().o(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c n(java.lang.String str) {
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().n(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c o(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().m(str);
        }
        return this;
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c p(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.d.e.h.a(str, this);
    }

    private com.getui.gtc.extension.distribution.gbd.n.d.e.c q(java.lang.String str) {
        boolean z;
        com.getui.gtc.extension.distribution.gbd.n.d.e.c a = com.getui.gtc.extension.distribution.gbd.n.d.e.h.a(str, this);
        com.getui.gtc.extension.distribution.gbd.n.d.e.c cVar = new com.getui.gtc.extension.distribution.gbd.n.d.e.c();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this) {
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = a.iterator();
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

    private boolean r(java.lang.String str) {
        return !com.getui.gtc.extension.distribution.gbd.n.d.e.h.a(str, this).isEmpty();
    }

    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g a() {
        if (this.a.isEmpty()) {
            return null;
        }
        return this.a.get(0);
    }

    @Override // java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.g get(int i) {
        return this.a.get(i);
    }

    @Override // java.util.List, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean add(com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return this.a.add(gVar);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        this.a.add(i, gVar);
    }

    @Override // java.util.List
    public final boolean addAll(int i, java.util.Collection<? extends com.getui.gtc.extension.distribution.gbd.n.d.b.g> collection) {
        return this.a.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(java.util.Collection<? extends com.getui.gtc.extension.distribution.gbd.n.d.b.g> collection) {
        return this.a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.a.clear();
    }

    public final /* synthetic */ java.lang.Object clone() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().d());
        }
        return new com.getui.gtc.extension.distribution.gbd.n.d.e.c((java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g>) arrayList);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(java.lang.Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(java.util.Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean equals(java.lang.Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.List
    public final int indexOf(java.lang.Object obj) {
        return this.a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(java.lang.Object obj) {
        return this.a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final java.util.ListIterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List
    public final java.util.ListIterator<com.getui.gtc.extension.distribution.gbd.n.d.b.g> listIterator(int i) {
        return this.a.listIterator(i);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.b.g remove(int i) {
        return this.a.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(java.lang.Object obj) {
        return this.a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(java.util.Collection<?> collection) {
        return this.a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(java.util.Collection<?> collection) {
        return this.a.retainAll(collection);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ com.getui.gtc.extension.distribution.gbd.n.d.b.g set(int i, com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar) {
        return this.a.set(i, gVar);
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.a.size();
    }

    @Override // java.util.List
    public final java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.g> subList(int i, int i2) {
        return this.a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final java.lang.Object[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        return (T[]) this.a.toArray(tArr);
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.getui.gtc.extension.distribution.gbd.n.d.b.g gVar : this.a) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            sb.append(gVar.a_());
        }
        return sb.toString();
    }
}
