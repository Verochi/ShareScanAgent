package com.getui.gtc.extension.distribution.gbd.m.d;

/* loaded from: classes22.dex */
public final class c implements java.util.Map<java.lang.String, java.util.List<java.lang.String>> {
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> a = new java.util.HashMap(32);

    private java.util.List<java.lang.String> a(java.lang.Object obj) {
        return this.a.get((java.lang.String) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.util.List<java.lang.String> put(java.lang.String str, java.util.List<java.lang.String> list) {
        return this.a.put(str, list);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        java.util.List<java.lang.String> list = this.a.get(str);
        if (list == null) {
            list = new java.util.LinkedList<>();
            this.a.put(str, list);
        }
        list.add(str2);
    }

    private java.util.List<java.lang.String> b(java.lang.Object obj) {
        return this.a.remove((java.lang.String) obj);
    }

    public final void a(com.getui.gtc.extension.distribution.gbd.m.d.b.a aVar, com.getui.gtc.extension.distribution.gbd.m.d.b<?> bVar) {
        java.lang.String str = aVar.e;
        java.lang.String a = bVar.a();
        java.util.List<java.lang.String> list = this.a.get(str);
        if (list == null) {
            list = new java.util.LinkedList<>();
            this.a.put(str, list);
        }
        list.add(a);
    }

    @Override // java.util.Map
    public final void clear() {
        this.a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(java.lang.Object obj) {
        return (obj instanceof java.lang.String) && this.a.containsKey((java.lang.String) obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(java.lang.Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // java.util.Map
    public final java.util.Set<java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>>> entrySet() {
        return this.a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(java.lang.Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ java.util.List<java.lang.String> get(java.lang.Object obj) {
        return this.a.get((java.lang.String) obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.Map
    public final java.util.Set<java.lang.String> keySet() {
        return this.a.keySet();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map<? extends java.lang.String, ? extends java.util.List<java.lang.String>> map) {
        for (java.util.Map.Entry<? extends java.lang.String, ? extends java.util.List<java.lang.String>> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ java.util.List<java.lang.String> remove(java.lang.Object obj) {
        return this.a.remove((java.lang.String) obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.a.size();
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(512);
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            java.util.Iterator<java.lang.String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    @Override // java.util.Map
    public final java.util.Collection<java.util.List<java.lang.String>> values() {
        return this.a.values();
    }
}
