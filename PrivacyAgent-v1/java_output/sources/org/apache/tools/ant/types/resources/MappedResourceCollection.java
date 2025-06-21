package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class MappedResourceCollection extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public org.apache.tools.ant.types.ResourceCollection n = null;
    public org.apache.tools.ant.types.Mapper t = null;
    public boolean u = false;
    public boolean v = false;
    public java.util.Collection<org.apache.tools.ant.types.Resource> w = null;

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.n != null) {
            throw new org.apache.tools.ant.BuildException("Only one resource collection can be nested into mappedresources", getLocation());
        }
        setChecked(false);
        this.w = null;
        this.n = resourceCollection;
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public final synchronized java.util.Collection<org.apache.tools.ant.types.Resource> b() {
        if (this.w == null || !this.v) {
            this.w = getCollection();
        }
        return this.w;
    }

    public final void c() {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("A nested resource collection element is required", getLocation());
        }
        dieOnCircularReference();
    }

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.resources.MappedResourceCollection mappedResourceCollection = (org.apache.tools.ant.types.resources.MappedResourceCollection) super.clone();
            mappedResourceCollection.n = this.n;
            mappedResourceCollection.t = this.t;
            mappedResourceCollection.w = null;
            return mappedResourceCollection;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.t != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        setChecked(false);
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.t = mapper;
        this.w = null;
        return mapper;
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            c();
            org.apache.tools.ant.types.Mapper mapper = this.t;
            if (mapper != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(mapper, stack, project);
            }
            java.lang.Object obj = this.n;
            if (obj instanceof org.apache.tools.ant.types.DataType) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
            }
            setChecked(true);
        }
    }

    public final java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        org.apache.tools.ant.types.Mapper mapper = this.t;
        org.apache.tools.ant.util.FileNameMapper implementation = mapper != null ? mapper.getImplementation() : new org.apache.tools.ant.util.IdentityMapper();
        for (org.apache.tools.ant.types.Resource resource : this.n) {
            if (this.u) {
                java.lang.String[] mapFileName = implementation.mapFileName(resource.getName());
                if (mapFileName != null) {
                    for (java.lang.String str : mapFileName) {
                        arrayList.add(new org.apache.tools.ant.types.resources.MappedResource(resource, new org.apache.tools.ant.util.MergingMapper(str)));
                    }
                }
            } else {
                arrayList.add(new org.apache.tools.ant.types.resources.MappedResource(resource, implementation));
            }
        }
        return arrayList;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.MappedResourceCollection) getCheckedRef()).isFilesystemOnly();
        }
        c();
        return false;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.MappedResourceCollection) getCheckedRef()).iterator();
        }
        c();
        return b().iterator();
    }

    public void setCache(boolean z) {
        this.v = z;
    }

    public void setEnableMultipleMappings(boolean z) {
        this.u = z;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.n != null || this.t != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.MappedResourceCollection) getCheckedRef()).size();
        }
        c();
        return b().size();
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = iterator();
        if (!it.hasNext()) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (it.hasNext()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(java.io.File.pathSeparatorChar);
            }
            stringBuffer.append(it.next());
        }
        return stringBuffer.toString();
    }
}
