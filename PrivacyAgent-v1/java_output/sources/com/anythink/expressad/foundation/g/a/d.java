package com.anythink.expressad.foundation.g.a;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.foundation.g.a.e<java.lang.String, org.json.JSONObject> {
    private int c;
    private final int b = 1000;
    private final java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> a = new java.util.LinkedHashMap<>(0, 0.75f, true);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        throw new java.lang.IllegalStateException(com.anythink.expressad.foundation.g.a.d.class.getName() + ".sizeOf() is reporting inconsistent results!");
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
                    java.util.Map.Entry<java.lang.String, org.json.JSONObject> next = this.a.entrySet().iterator().next();
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

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private void b2(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.a.remove(str) != null) {
                this.c--;
            }
        }
    }

    private static int c() {
        return 1;
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
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final org.json.JSONObject b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            jSONObject = this.a.get(str);
        }
        return jSONObject;
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final /* synthetic */ void a(java.lang.String str) {
        java.lang.String str2 = str;
        if (str2 == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.a.remove(str2) != null) {
                this.c--;
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final boolean a(java.lang.String str, org.json.JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c++;
            if (this.a.put(str, jSONObject) != null) {
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

    public final synchronized java.lang.String toString() {
        return java.lang.String.format("LruCache[maxSize=%d]", java.lang.Integer.valueOf(this.b));
    }
}
