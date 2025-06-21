package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
class FailFast implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
    public static final java.util.WeakHashMap<java.lang.Object, java.util.Set<org.apache.tools.ant.types.resources.FailFast>> u = new java.util.WeakHashMap<>();
    public final java.lang.Object n;
    public java.util.Iterator<org.apache.tools.ant.types.Resource> t;

    public FailFast(java.lang.Object obj, java.util.Iterator<org.apache.tools.ant.types.Resource> it) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("parent object is null");
        }
        if (it == null) {
            throw new java.lang.IllegalArgumentException("cannot wrap null iterator");
        }
        this.n = obj;
        if (it.hasNext()) {
            this.t = it;
            a(this);
        }
    }

    public static synchronized void a(org.apache.tools.ant.types.resources.FailFast failFast) {
        synchronized (org.apache.tools.ant.types.resources.FailFast.class) {
            java.util.WeakHashMap<java.lang.Object, java.util.Set<org.apache.tools.ant.types.resources.FailFast>> weakHashMap = u;
            java.util.Set<org.apache.tools.ant.types.resources.FailFast> set = weakHashMap.get(failFast.n);
            if (set == null) {
                set = new java.util.HashSet<>();
                weakHashMap.put(failFast.n, set);
            }
            set.add(failFast);
        }
    }

    public static synchronized void b(org.apache.tools.ant.types.resources.FailFast failFast) {
        synchronized (org.apache.tools.ant.types.resources.FailFast.class) {
            if (!u.get(failFast.n).contains(failFast)) {
                throw new java.util.ConcurrentModificationException();
            }
        }
    }

    public static synchronized void c(java.lang.Object obj) {
        synchronized (org.apache.tools.ant.types.resources.FailFast.class) {
            java.util.Set<org.apache.tools.ant.types.resources.FailFast> set = u.get(obj);
            if (set != null) {
                set.clear();
            }
        }
    }

    public static synchronized void e(org.apache.tools.ant.types.resources.FailFast failFast) {
        synchronized (org.apache.tools.ant.types.resources.FailFast.class) {
            java.util.Set<org.apache.tools.ant.types.resources.FailFast> set = u.get(failFast.n);
            if (set != null) {
                set.remove(failFast);
            }
        }
    }

    @Override // java.util.Iterator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public org.apache.tools.ant.types.Resource next() {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.t;
        if (it == null || !it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        b(this);
        try {
            return this.t.next();
        } finally {
            if (!this.t.hasNext()) {
                this.t = null;
                e(this);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.t == null) {
            return false;
        }
        b(this);
        return this.t.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
