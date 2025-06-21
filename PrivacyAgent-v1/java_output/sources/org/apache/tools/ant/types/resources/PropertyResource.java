package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class PropertyResource extends org.apache.tools.ant.types.Resource {
    public static final int y = org.apache.tools.ant.types.Resource.getMagicNumber("PropertyResource".getBytes());
    public static final java.io.InputStream z = new org.apache.tools.ant.types.resources.PropertyResource.AnonymousClass1();

    /* renamed from: org.apache.tools.ant.types.resources.PropertyResource$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.io.InputStream {
        @Override // java.io.InputStream
        public int read() {
            return -1;
        }
    }

    public PropertyResource() {
    }

    public PropertyResource(org.apache.tools.ant.Project project, java.lang.String str) {
        super(str);
        setProject(project);
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean equals(java.lang.Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return isReferenceOrProxy() && getReferencedOrProxied().equals(obj);
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReferenceOrProxy()) {
            return getReferencedOrProxied().getInputStream();
        }
        java.lang.Object objectValue = getObjectValue();
        return objectValue == null ? z : new java.io.ByteArrayInputStream(java.lang.String.valueOf(objectValue).getBytes());
    }

    public java.lang.Object getObjectValue() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.PropertyResource) getCheckedRef()).getObjectValue();
        }
        org.apache.tools.ant.Project project = getProject();
        if (project == null) {
            return null;
        }
        return org.apache.tools.ant.PropertyHelper.getProperty(project, getName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReferenceOrProxy()) {
            return getReferencedOrProxied().getOutputStream();
        }
        if (isExists()) {
            throw new org.apache.tools.ant.types.resources.ImmutableResourceException();
        }
        return new org.apache.tools.ant.util.PropertyOutputStream(getProject(), getName());
    }

    public org.apache.tools.ant.types.Resource getReferencedOrProxied() {
        if (isReference()) {
            return (org.apache.tools.ant.types.Resource) getCheckedRef(org.apache.tools.ant.types.Resource.class, "resource");
        }
        java.lang.Object objectValue = getObjectValue();
        if (objectValue instanceof org.apache.tools.ant.types.Resource) {
            return (org.apache.tools.ant.types.Resource) objectValue;
        }
        throw new java.lang.IllegalStateException("This PropertyResource does not reference or proxy another Resource");
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getSize() {
        if (isReferenceOrProxy()) {
            return getReferencedOrProxied().getSize();
        }
        if (getObjectValue() == null) {
            return 0L;
        }
        return java.lang.String.valueOf(r0).length();
    }

    public java.lang.String getValue() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.PropertyResource) getCheckedRef()).getValue();
        }
        org.apache.tools.ant.Project project = getProject();
        if (project == null) {
            return null;
        }
        return project.getProperty(getName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public int hashCode() {
        return isReferenceOrProxy() ? getReferencedOrProxied().hashCode() : super.hashCode() * y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        return isReferenceOrProxy() ? getReferencedOrProxied().isExists() : getObjectValue() != null;
    }

    public boolean isReferenceOrProxy() {
        return isReference() || (getObjectValue() instanceof org.apache.tools.ant.types.Resource);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return isReferenceOrProxy() ? getReferencedOrProxied().toString() : getValue();
    }
}
