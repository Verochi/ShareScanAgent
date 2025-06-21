package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class BaseResourceCollectionContainer extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public java.util.List<org.apache.tools.ant.types.ResourceCollection> n = new java.util.ArrayList();
    public java.util.Collection<org.apache.tools.ant.types.Resource> t = null;
    public boolean u = true;

    public BaseResourceCollectionContainer() {
    }

    public BaseResourceCollectionContainer(org.apache.tools.ant.Project project) {
        setProject(project);
    }

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Project project;
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceCollection == null) {
            return;
        }
        if (org.apache.tools.ant.Project.getProject(resourceCollection) == null && (project = getProject()) != null) {
            project.setProjectReference(resourceCollection);
        }
        this.n.add(resourceCollection);
        org.apache.tools.ant.types.resources.FailFast.c(this);
        this.t = null;
        setChecked(false);
    }

    public synchronized void addAll(java.util.Collection<? extends org.apache.tools.ant.types.ResourceCollection> collection) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        try {
            java.util.Iterator<? extends org.apache.tools.ant.types.ResourceCollection> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        } catch (java.lang.ClassCastException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public final synchronized java.util.Collection<org.apache.tools.ant.types.Resource> b() {
        if (this.t == null || !isCache()) {
            this.t = getCollection();
        }
        return this.t;
    }

    public synchronized void clear() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.n.clear();
        org.apache.tools.ant.types.resources.FailFast.c(this);
        this.t = null;
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.resources.BaseResourceCollectionContainer baseResourceCollectionContainer = (org.apache.tools.ant.types.resources.BaseResourceCollectionContainer) super.clone();
            baseResourceCollectionContainer.n = new java.util.ArrayList(this.n);
            baseResourceCollectionContainer.t = null;
            return baseResourceCollectionContainer;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            for (java.lang.Object obj : this.n) {
                if (obj instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
                }
            }
            setChecked(true);
        }
    }

    public abstract java.util.Collection<org.apache.tools.ant.types.Resource> getCollection();

    public final synchronized java.util.List<org.apache.tools.ant.types.ResourceCollection> getResourceCollections() {
        dieOnCircularReference();
        return java.util.Collections.unmodifiableList(this.n);
    }

    public synchronized boolean isCache() {
        return this.u;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.BaseResourceCollectionContainer) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = this.n.iterator();
        boolean z = true;
        while (z && it.hasNext()) {
            z = it.next().isFilesystemOnly();
        }
        if (z) {
            return true;
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = b().iterator();
        while (it2.hasNext()) {
            if (it2.next().as(org.apache.tools.ant.types.resources.FileProvider.class) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public final synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.BaseResourceCollectionContainer) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        return new org.apache.tools.ant.types.resources.FailFast(this, b().iterator());
    }

    public synchronized void setCache(boolean z) {
        this.u = z;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.BaseResourceCollectionContainer) getCheckedRef(org.apache.tools.ant.types.resources.BaseResourceCollectionContainer.class, getDataTypeName())).size();
        }
        dieOnCircularReference();
        return b().size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        if (b().size() == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (org.apache.tools.ant.types.Resource resource : this.t) {
            if (sb.length() > 0) {
                sb.append(java.io.File.pathSeparatorChar);
            }
            sb.append(resource);
        }
        return sb.toString();
    }
}
