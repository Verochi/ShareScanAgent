package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class AbstractResourceCollectionWrapper extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public org.apache.tools.ant.types.ResourceCollection n;
    public boolean t = true;

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Project project;
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceCollection == null) {
            return;
        }
        if (this.n != null) {
            throw b();
        }
        this.n = resourceCollection;
        if (org.apache.tools.ant.Project.getProject(resourceCollection) == null && (project = getProject()) != null) {
            project.setProjectReference(this.n);
        }
        setChecked(false);
    }

    public final org.apache.tools.ant.BuildException b() {
        return new org.apache.tools.ant.BuildException(super.toString() + " expects exactly one nested resource collection.");
    }

    public abstract java.util.Iterator<org.apache.tools.ant.types.Resource> createIterator();

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            java.lang.Object obj = this.n;
            if (obj instanceof org.apache.tools.ant.types.DataType) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
            }
            setChecked(true);
        }
    }

    public final synchronized org.apache.tools.ant.types.ResourceCollection getResourceCollection() {
        org.apache.tools.ant.types.ResourceCollection resourceCollection;
        dieOnCircularReference();
        resourceCollection = this.n;
        if (resourceCollection == null) {
            throw b();
        }
        return resourceCollection;
    }

    public abstract int getSize();

    public synchronized boolean isCache() {
        return this.t;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.BaseResourceCollectionContainer) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.ResourceCollection resourceCollection = this.n;
        if (resourceCollection != null && !resourceCollection.isFilesystemOnly()) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = iterator();
            while (it.hasNext()) {
                if (it.next().as(org.apache.tools.ant.types.resources.FileProvider.class) == null) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public final synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        return new org.apache.tools.ant.types.resources.FailFast(this, createIterator());
    }

    public synchronized void setCache(boolean z) {
        this.t = z;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper) getCheckedRef()).size();
        }
        dieOnCircularReference();
        return getSize();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        if (getSize() == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            if (sb.length() > 0) {
                sb.append(java.io.File.pathSeparatorChar);
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
