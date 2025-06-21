package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Restrict extends org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer implements org.apache.tools.ant.types.ResourceCollection {
    public org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper t = new org.apache.tools.ant.types.resources.Restrict.AnonymousClass1();

    /* renamed from: org.apache.tools.ant.types.resources.Restrict$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper {
        public AnonymousClass1() {
        }

        @Override // org.apache.tools.ant.types.resources.LazyResourceCollectionWrapper
        public boolean filterResource(org.apache.tools.ant.types.Resource resource) {
            java.util.Iterator<org.apache.tools.ant.types.resources.selectors.ResourceSelector> selectors = org.apache.tools.ant.types.resources.Restrict.this.getSelectors();
            while (selectors.hasNext()) {
                if (!selectors.next().isSelected(resource)) {
                    return true;
                }
            }
            return false;
        }
    }

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceCollection == null) {
            return;
        }
        this.t.add(resourceCollection);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer
    public synchronized void add(org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        if (resourceSelector == null) {
            return;
        }
        super.add(resourceSelector);
        org.apache.tools.ant.types.resources.FailFast.c(this);
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer, org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        if (isChecked()) {
            return;
        }
        super.dieOnCircularReference(stack, project);
        if (!isReference()) {
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.t, stack, project);
            setChecked(true);
        }
    }

    public synchronized boolean isCache() {
        return this.t.isCache();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Restrict) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        return this.t.isFilesystemOnly();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public final synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Restrict) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        return this.t.iterator();
    }

    public synchronized void setCache(boolean z) {
        this.t.setCache(z);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Restrict) getCheckedRef()).size();
        }
        dieOnCircularReference();
        return this.t.size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        dieOnCircularReference();
        return this.t.toString();
    }
}
