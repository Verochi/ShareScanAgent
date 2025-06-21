package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class LazyResourceCollectionWrapper extends org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper {
    public final java.util.List<org.apache.tools.ant.types.Resource> u = new java.util.ArrayList();
    public org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.FilteringIterator v;

    public class CachedIterator implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
        public int n = 0;
        public final java.util.Iterator<org.apache.tools.ant.types.Resource> t;

        public CachedIterator(java.util.Iterator<org.apache.tools.ant.types.Resource> it) {
            this.t = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.types.Resource next() {
            org.apache.tools.ant.types.Resource resource;
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            synchronized (org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.u) {
                java.util.List list = org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.u;
                int i = this.n;
                this.n = i + 1;
                resource = (org.apache.tools.ant.types.Resource) list.get(i);
            }
            return resource;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            synchronized (org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.u) {
                if (org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.u.size() > this.n) {
                    return true;
                }
                if (!this.t.hasNext()) {
                    return false;
                }
                org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.u.add(this.t.next());
                return true;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public class FilteringIterator implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
        public org.apache.tools.ant.types.Resource n = null;
        public boolean t = false;
        public final java.util.Iterator<org.apache.tools.ant.types.Resource> u;

        public FilteringIterator(java.util.Iterator<org.apache.tools.ant.types.Resource> it) {
            this.u = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.types.Resource next() {
            if (!hasNext()) {
                throw new java.lang.UnsupportedOperationException();
            }
            org.apache.tools.ant.types.Resource resource = this.n;
            this.n = null;
            return resource;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.t) {
                return false;
            }
            while (this.n == null) {
                if (!this.u.hasNext()) {
                    this.t = true;
                    return false;
                }
                org.apache.tools.ant.types.Resource next = this.u.next();
                this.n = next;
                if (org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.this.filterResource(next)) {
                    this.n = null;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper
    public java.util.Iterator<org.apache.tools.ant.types.Resource> createIterator() {
        if (!isCache()) {
            return new org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.FilteringIterator(getResourceCollection().iterator());
        }
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.FilteringIterator(getResourceCollection().iterator());
        }
        return new org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper.CachedIterator(this.v);
    }

    public boolean filterResource(org.apache.tools.ant.types.Resource resource) {
        return false;
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper
    public int getSize() {
        java.util.Iterator<org.apache.tools.ant.types.Resource> createIterator = createIterator();
        int i = 0;
        while (createIterator.hasNext()) {
            createIterator.next();
            i++;
        }
        return i;
    }
}
