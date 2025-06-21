package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Resources extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public java.util.Vector<org.apache.tools.ant.types.ResourceCollection> n;
    public java.util.Collection<org.apache.tools.ant.types.Resource> t;
    public boolean u = false;
    public static final org.apache.tools.ant.types.ResourceCollection NONE = new org.apache.tools.ant.types.resources.Resources.AnonymousClass1();
    public static final java.util.Iterator<org.apache.tools.ant.types.Resource> EMPTY_ITERATOR = new org.apache.tools.ant.types.resources.Resources.AnonymousClass2();

    /* renamed from: org.apache.tools.ant.types.resources.Resources$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.types.ResourceCollection {
        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return org.apache.tools.ant.types.resources.Resources.EMPTY_ITERATOR;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            return 0;
        }
    }

    /* renamed from: org.apache.tools.ant.types.resources.Resources$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.types.Resource next() {
            throw new java.util.NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public class MyCollection extends java.util.AbstractCollection<org.apache.tools.ant.types.Resource> {
        public java.util.Collection<org.apache.tools.ant.types.Resource> n;

        public class MyIterator implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
            public java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> n;
            public java.util.Iterator<org.apache.tools.ant.types.Resource> t;

            public MyIterator() {
                this.n = org.apache.tools.ant.types.resources.Resources.this.d().iterator();
                this.t = null;
            }

            public /* synthetic */ MyIterator(org.apache.tools.ant.types.resources.Resources.MyCollection myCollection, org.apache.tools.ant.types.resources.Resources.AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public org.apache.tools.ant.types.Resource next() {
                if (hasNext()) {
                    return this.t.next();
                }
                throw new java.util.NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.t;
                boolean z = it != null && it.hasNext();
                while (!z && this.n.hasNext()) {
                    java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = this.n.next().iterator();
                    this.t = it2;
                    z = it2.hasNext();
                }
                return z;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }
        }

        public MyCollection() {
        }

        public final synchronized java.util.Collection<org.apache.tools.ant.types.Resource> a() {
            java.util.Collection<org.apache.tools.ant.types.Resource> collection;
            collection = this.n;
            if (collection == null) {
                collection = org.apache.tools.ant.util.CollectionUtils.asCollection(new org.apache.tools.ant.types.resources.Resources.MyCollection.MyIterator(this, null));
                if (org.apache.tools.ant.types.resources.Resources.this.u) {
                    this.n = collection;
                }
            }
            return collection;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public Resources() {
    }

    public Resources(org.apache.tools.ant.Project project) {
        setProject(project);
    }

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceCollection == null) {
            return;
        }
        if (this.n == null) {
            this.n = new java.util.Vector<>();
        }
        this.n.add(resourceCollection);
        invalidateExistingIterators();
        this.t = null;
        setChecked(false);
    }

    public final synchronized java.util.List<org.apache.tools.ant.types.ResourceCollection> d() {
        java.util.List<org.apache.tools.ant.types.ResourceCollection> list;
        list = this.n;
        if (list == null) {
            list = java.util.Collections.emptyList();
        }
        return list;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        for (java.lang.Object obj : d()) {
            if (obj instanceof org.apache.tools.ant.types.DataType) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
            }
        }
        setChecked(true);
    }

    public final org.apache.tools.ant.types.ResourceCollection e() {
        return (org.apache.tools.ant.types.ResourceCollection) getCheckedRef(org.apache.tools.ant.types.ResourceCollection.class, "ResourceCollection");
    }

    public void invalidateExistingIterators() {
        org.apache.tools.ant.types.resources.FailFast.c(this);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return e().isFilesystemOnly();
        }
        validate();
        java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = d().iterator();
        while (it.hasNext()) {
            if (!it.next().isFilesystemOnly()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return e().iterator();
        }
        validate();
        return new org.apache.tools.ant.types.resources.FailFast(this, this.t.iterator());
    }

    public synchronized void setCache(boolean z) {
        this.u = z;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return e().size();
        }
        validate();
        return this.t.size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        validate();
        java.util.Collection<org.apache.tools.ant.types.Resource> collection = this.t;
        if (collection != null && !collection.isEmpty()) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            for (org.apache.tools.ant.types.Resource resource : this.t) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(java.io.File.pathSeparatorChar);
                }
                stringBuffer.append(resource);
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public final synchronized void validate() {
        dieOnCircularReference();
        java.util.Collection<org.apache.tools.ant.types.Resource> collection = this.t;
        if (collection == null) {
            collection = new org.apache.tools.ant.types.resources.Resources.MyCollection();
        }
        this.t = collection;
    }
}
