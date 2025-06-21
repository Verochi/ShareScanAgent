package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class ResourceDecorator extends org.apache.tools.ant.types.Resource {
    public org.apache.tools.ant.types.Resource y;

    public ResourceDecorator() {
    }

    public ResourceDecorator(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        addConfigured(resourceCollection);
    }

    public final void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        checkChildrenAllowed();
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("you must not specify more than one resource");
        }
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported");
        }
        setChecked(false);
        this.y = resourceCollection.iterator().next();
    }

    @Override // org.apache.tools.ant.types.Resource
    public <T> T as(java.lang.Class<T> cls) {
        return (T) getResource().as(cls);
    }

    @Override // org.apache.tools.ant.types.Resource, java.lang.Comparable
    public int compareTo(org.apache.tools.ant.types.Resource resource) {
        if (resource == this) {
            return 0;
        }
        return resource instanceof org.apache.tools.ant.types.resources.ResourceDecorator ? getResource().compareTo(((org.apache.tools.ant.types.resources.ResourceDecorator) resource).getResource()) : getResource().compareTo(resource);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.y, stack, project);
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        return getResource().getInputStream();
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getLastModified() {
        return getResource().getLastModified();
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.lang.String getName() {
        return getResource().getName();
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        return getResource().getOutputStream();
    }

    public final org.apache.tools.ant.types.Resource getResource() {
        if (isReference()) {
            return (org.apache.tools.ant.types.Resource) getCheckedRef();
        }
        if (this.y == null) {
            throw new org.apache.tools.ant.BuildException("no resource specified");
        }
        dieOnCircularReference();
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getSize() {
        return getResource().getSize();
    }

    @Override // org.apache.tools.ant.types.Resource
    public int hashCode() {
        return (getClass().hashCode() << 4) | getResource().hashCode();
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isDirectory() {
        return getResource().isDirectory();
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        return getResource().isExists();
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return as(org.apache.tools.ant.types.resources.FileProvider.class) != null;
    }

    @Override // org.apache.tools.ant.types.Resource
    public void setDirectory(boolean z) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("you can't change the directory state of a " + getDataTypeName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public void setExists(boolean z) {
        throw new org.apache.tools.ant.BuildException("you can't change the exists state of a " + getDataTypeName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public void setLastModified(long j) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("you can't change the timestamp of a " + getDataTypeName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public void setName(java.lang.String str) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("you can't change the name of a " + getDataTypeName());
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.y != null) {
            throw noChildrenAllowed();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.Resource
    public void setSize(long j) throws org.apache.tools.ant.BuildException {
        throw new org.apache.tools.ant.BuildException("you can't change the size of a " + getDataTypeName());
    }
}
