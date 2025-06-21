package com.anythink.expressad.foundation.g.a;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.foundation.g.a.e<java.lang.String, android.graphics.Bitmap> {
    private final java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> a;
    private final int b;
    private int c;

    public c(int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        this.b = i;
        this.a = new java.util.LinkedHashMap<>(0, 0.75f, true);
    }

    private static int a(android.graphics.Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.foundation.g.a.e
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public android.graphics.Bitmap b(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            android.graphics.Bitmap bitmap = this.a.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            return bitmap;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0072, code lost:
    
        throw new java.lang.IllegalStateException(com.anythink.expressad.foundation.g.a.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
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
                    java.util.Map.Entry<java.lang.String, android.graphics.Bitmap> next = this.a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    java.lang.String key = next.getKey();
                    try {
                        int a = a(next.getValue());
                        this.a.remove(key).recycle();
                        this.c -= a;
                    } catch (java.lang.Throwable unused) {
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.anythink.expressad.foundation.g.a.e
    public boolean a(java.lang.String str, android.graphics.Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new java.lang.NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c += a(bitmap);
            android.graphics.Bitmap put = this.a.put(str, bitmap);
            if (put != null) {
                this.c -= a(put);
            }
        }
        a(this.b);
        return true;
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private void b2(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            android.graphics.Bitmap remove = this.a.remove(str);
            if (remove != null) {
                this.c -= a(remove);
            }
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
    public final /* synthetic */ void a(java.lang.String str) {
        java.lang.String str2 = str;
        if (str2 == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        synchronized (this) {
            android.graphics.Bitmap remove = this.a.remove(str2);
            if (remove != null) {
                this.c -= a(remove);
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    public final synchronized java.lang.String toString() {
        return java.lang.String.format("LruCache[maxSize=%d]", java.lang.Integer.valueOf(this.b));
    }
}
