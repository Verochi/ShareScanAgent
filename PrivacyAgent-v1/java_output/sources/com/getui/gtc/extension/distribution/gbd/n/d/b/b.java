package com.getui.gtc.extension.distribution.gbd.n.d.b;

/* loaded from: classes22.dex */
public final class b implements java.lang.Cloneable, java.lang.Iterable<com.getui.gtc.extension.distribution.gbd.n.d.b.a> {
    protected static final java.lang.String a = "data-";
    java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> b = null;

    public class a extends java.util.AbstractMap<java.lang.String, java.lang.String> {

        /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.b.b$a$a, reason: collision with other inner class name */
        public class C0320a implements java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> {
            private java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.a> b;
            private com.getui.gtc.extension.distribution.gbd.n.d.b.a c;

            private C0320a() {
                this.b = com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.values().iterator();
            }

            public /* synthetic */ C0320a(com.getui.gtc.extension.distribution.gbd.n.d.b.b.a aVar, byte b) {
                this();
            }

            private java.util.Map.Entry<java.lang.String, java.lang.String> a() {
                return new com.getui.gtc.extension.distribution.gbd.n.d.b.a(this.c.a.substring(5), this.c.b);
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                boolean z;
                do {
                    z = false;
                    if (!this.b.hasNext()) {
                        return false;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.d.b.a next = this.b.next();
                    this.c = next;
                    if (next.a.startsWith(com.getui.gtc.extension.distribution.gbd.n.d.b.b.a) && next.a.length() > 5) {
                        z = true;
                    }
                } while (!z);
                return true;
            }

            @Override // java.util.Iterator
            public final /* synthetic */ java.util.Map.Entry<java.lang.String, java.lang.String> next() {
                return new com.getui.gtc.extension.distribution.gbd.n.d.b.a(this.c.a.substring(5), this.c.b);
            }

            @Override // java.util.Iterator
            public final void remove() {
                com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.remove(this.c.a);
            }
        }

        /* renamed from: com.getui.gtc.extension.distribution.gbd.n.d.b.b$a$b, reason: collision with other inner class name */
        public class C0321b extends java.util.AbstractSet<java.util.Map.Entry<java.lang.String, java.lang.String>> {
            private C0321b() {
            }

            public /* synthetic */ C0321b(com.getui.gtc.extension.distribution.gbd.n.d.b.b.a aVar, byte b) {
                this();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> iterator() {
                return new com.getui.gtc.extension.distribution.gbd.n.d.b.b.a.C0320a(com.getui.gtc.extension.distribution.gbd.n.d.b.b.a.this, (byte) 0);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                int i = 0;
                while (new com.getui.gtc.extension.distribution.gbd.n.d.b.b.a.C0320a(com.getui.gtc.extension.distribution.gbd.n.d.b.b.a.this, (byte) 0).hasNext()) {
                    i++;
                }
                return i;
            }
        }

        private a() {
            if (com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b == null) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b = new java.util.LinkedHashMap(2);
            }
        }

        public /* synthetic */ a(com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar, byte b) {
            this();
        }

        private java.lang.String a(java.lang.String str, java.lang.String str2) {
            java.lang.String c = com.getui.gtc.extension.distribution.gbd.n.d.b.b.c(str);
            java.lang.String str3 = com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b(c) ? ((com.getui.gtc.extension.distribution.gbd.n.d.b.a) com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.get(c)).b : null;
            com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.put(c, new com.getui.gtc.extension.distribution.gbd.n.d.b.a(c, str2));
            return str3;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.String>> entrySet() {
            return new com.getui.gtc.extension.distribution.gbd.n.d.b.b.a.C0321b(this, (byte) 0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* synthetic */ java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) {
            java.lang.String str = (java.lang.String) obj2;
            java.lang.String c = com.getui.gtc.extension.distribution.gbd.n.d.b.b.c((java.lang.String) obj);
            java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b(c) ? ((com.getui.gtc.extension.distribution.gbd.n.d.b.a) com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.get(c)).b : null;
            com.getui.gtc.extension.distribution.gbd.n.d.b.b.this.b.put(c, new com.getui.gtc.extension.distribution.gbd.n.d.b.a(c, str));
            return str2;
        }
    }

    public static /* synthetic */ java.lang.String c(java.lang.String str) {
        return a.concat(java.lang.String.valueOf(str));
    }

    private java.util.Map<java.lang.String, java.lang.String> d() {
        return new com.getui.gtc.extension.distribution.gbd.n.d.b.b.a(this, (byte) 0);
    }

    private void d(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        if (linkedHashMap == null) {
            return;
        }
        linkedHashMap.remove(str.toLowerCase());
    }

    private java.lang.String e() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a(sb, new com.getui.gtc.extension.distribution.gbd.n.d.b.e("").a);
        return sb.toString();
    }

    private static java.lang.String e(java.lang.String str) {
        return a.concat(java.lang.String.valueOf(str));
    }

    public final int a() {
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public final java.lang.String a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.d.b.a aVar;
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(str);
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        return (linkedHashMap == null || (aVar = linkedHashMap.get(str.toLowerCase())) == null) ? "" : aVar.b;
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.a aVar) {
        com.getui.gtc.extension.distribution.gbd.n.d.a.e.a(aVar);
        if (this.b == null) {
            this.b = new java.util.LinkedHashMap<>(2);
        }
        this.b.put(aVar.a, aVar);
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar) {
        if (bVar.a() == 0) {
            return;
        }
        if (this.b == null) {
            this.b = new java.util.LinkedHashMap<>(bVar.a());
        }
        this.b.putAll(bVar.b);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        a(new com.getui.gtc.extension.distribution.gbd.n.d.b.a(str, str2));
    }

    public final void a(java.lang.StringBuilder sb, com.getui.gtc.extension.distribution.gbd.n.d.b.e.a aVar) {
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        if (linkedHashMap == null) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.getui.gtc.extension.distribution.gbd.n.d.b.a value = it.next().getValue();
            sb.append(" ");
            sb.append(value.a);
            sb.append("=\"");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.d.b.h.a(value.b, aVar));
            sb.append("\"");
        }
    }

    public final java.util.List<com.getui.gtc.extension.distribution.gbd.n.d.b.a> b() {
        if (this.b == null) {
            return java.util.Collections.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.b.size());
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public final boolean b(java.lang.String str) {
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        return linkedHashMap != null && linkedHashMap.containsKey(str.toLowerCase());
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final com.getui.gtc.extension.distribution.gbd.n.d.b.b clone() {
        if (this.b == null) {
            return new com.getui.gtc.extension.distribution.gbd.n.d.b.b();
        }
        try {
            com.getui.gtc.extension.distribution.gbd.n.d.b.b bVar = (com.getui.gtc.extension.distribution.gbd.n.d.b.b) super.clone();
            bVar.b = new java.util.LinkedHashMap<>(this.b.size());
            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.a> it = iterator();
            while (it.hasNext()) {
                com.getui.gtc.extension.distribution.gbd.n.d.b.a next = it.next();
                bVar.b.put(next.a, next.clone());
            }
            return bVar;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.getui.gtc.extension.distribution.gbd.n.d.b.b)) {
            return false;
        }
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap2 = ((com.getui.gtc.extension.distribution.gbd.n.d.b.b) obj).b;
        return linkedHashMap == null ? linkedHashMap2 == null : linkedHashMap.equals(linkedHashMap2);
    }

    public final int hashCode() {
        java.util.LinkedHashMap<java.lang.String, com.getui.gtc.extension.distribution.gbd.n.d.b.a> linkedHashMap = this.b;
        if (linkedHashMap != null) {
            return linkedHashMap.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Iterable
    public final java.util.Iterator<com.getui.gtc.extension.distribution.gbd.n.d.b.a> iterator() {
        return b().iterator();
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        a(sb, new com.getui.gtc.extension.distribution.gbd.n.d.b.e("").a);
        return sb.toString();
    }
}
