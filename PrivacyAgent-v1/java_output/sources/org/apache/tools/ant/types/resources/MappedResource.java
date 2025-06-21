package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class MappedResource extends org.apache.tools.ant.types.resources.ResourceDecorator {
    public final org.apache.tools.ant.util.FileNameMapper z;

    public MappedResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        super(resource);
        this.z = fileNameMapper;
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public <T> T as(java.lang.Class<T> cls) {
        if (org.apache.tools.ant.types.resources.FileProvider.class.isAssignableFrom(cls)) {
            return null;
        }
        return (T) getResource().as(cls);
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean equals(java.lang.Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        org.apache.tools.ant.types.resources.MappedResource mappedResource = (org.apache.tools.ant.types.resources.MappedResource) obj;
        java.lang.String name = getName();
        java.lang.String name2 = mappedResource.getName();
        if (name == null) {
            if (name2 != null) {
                return false;
            }
        } else if (!name.equals(name2)) {
            return false;
        }
        return getResource().equals(mappedResource.getResource());
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public java.lang.String getName() {
        java.lang.String name = getResource().getName();
        if (isReference()) {
            return name;
        }
        java.lang.String[] mapFileName = this.z.mapFileName(name);
        if (mapFileName == null || mapFileName.length <= 0) {
            return null;
        }
        return mapFileName[0];
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource
    public int hashCode() {
        java.lang.String name = getName();
        return name == null ? super.hashCode() : name.hashCode();
    }

    @Override // org.apache.tools.ant.types.resources.ResourceDecorator, org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.z != null) {
            throw noChildrenAllowed();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return isReference() ? getCheckedRef().toString() : getName();
    }
}
