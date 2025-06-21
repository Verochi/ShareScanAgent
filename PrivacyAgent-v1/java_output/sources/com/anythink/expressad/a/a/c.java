package com.anythink.expressad.a.a;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.foundation.g.a.e<java.lang.String, com.anythink.expressad.a.a.b> {
    private final java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> a;
    private final int b;
    private int c;

    public c(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.a = new java.util.LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        throw new java.lang.IllegalStateException(com.anythink.expressad.a.a.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c >= 0 && (!this.a.isEmpty() || this.c == 0)) {
                    if (this.c <= i || this.a.isEmpty()) {
                        break;
                    }
                    java.util.Map.Entry<java.lang.String, com.anythink.expressad.a.a.b> next = this.a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    java.lang.String key = next.getKey();
                    next.getValue();
                    try {
                        this.a.remove(key);
                        this.c--;
                    } catch (java.lang.Throwable unused) {
                    }
                } else {
                    break;
                }
            }
        }
    }

    private static int c() {
        return 1;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final com.anythink.expressad.a.a.b b(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            com.anythink.expressad.a.a.b bVar = this.a.get(str);
            if (bVar != null) {
                return bVar;
            }
            return null;
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final java.util.Collection<java.lang.String> a() {
        java.util.HashSet hashSet;
        synchronized (this) {
            hashSet = new java.util.HashSet(this.a.keySet());
        }
        return hashSet;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final boolean a(java.lang.String str, com.anythink.expressad.a.a.b bVar) {
        if (str == null || bVar == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c++;
            if (this.a.put(str, bVar) != null) {
                this.c--;
            }
        }
        a(this.b);
        return true;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.a.remove(str) != null) {
                this.c--;
            }
        }
    }

    public final synchronized java.lang.String toString() {
        return java.lang.String.format("LruCache[maxSize=%d]", java.lang.Integer.valueOf(this.b));
    }
}
