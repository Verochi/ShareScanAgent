package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class StringResource extends org.apache.tools.ant.types.Resource {
    public static final int z = org.apache.tools.ant.types.Resource.getMagicNumber("StringResource".getBytes());
    public java.lang.String y;

    public class StringResourceFilterOutputStream extends java.io.FilterOutputStream {
        public final java.io.ByteArrayOutputStream n;

        public StringResourceFilterOutputStream() {
            super(new java.io.ByteArrayOutputStream());
            this.n = (java.io.ByteArrayOutputStream) ((java.io.FilterOutputStream) this).out;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            super.close();
            org.apache.tools.ant.types.resources.StringResource.this.d(org.apache.tools.ant.types.resources.StringResource.this.y == null ? this.n.toString() : this.n.toString(org.apache.tools.ant.types.resources.StringResource.this.y));
        }
    }

    public StringResource() {
        this.y = "UTF-8";
    }

    public StringResource(java.lang.String str) {
        this(null, str);
    }

    public StringResource(org.apache.tools.ant.Project project, java.lang.String str) {
        this.y = "UTF-8";
        setProject(project);
        setValue(project != null ? project.replaceProperties(str) : str);
    }

    public void addText(java.lang.String str) {
        checkChildrenAllowed();
        setValue(getProject().replaceProperties(str));
    }

    public final void d(java.lang.String str) {
        if (getProject() != null) {
            str = getProject().replaceProperties(str);
        }
        setValue(str);
    }

    public synchronized java.lang.String getContent() {
        return getValue();
    }

    public synchronized java.lang.String getEncoding() {
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        java.lang.String content = getContent();
        if (content == null) {
            throw new java.lang.IllegalStateException("unset string value");
        }
        java.lang.String str = this.y;
        return new java.io.ByteArrayInputStream(str == null ? content.getBytes() : content.getBytes(str));
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.lang.String getName() {
        return super.getName();
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getOutputStream();
        }
        if (getValue() != null) {
            throw new org.apache.tools.ant.types.resources.ImmutableResourceException();
        }
        return new org.apache.tools.ant.types.resources.StringResource.StringResourceFilterOutputStream();
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized long getSize() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).getSize() : getContent().length();
    }

    public synchronized java.lang.String getValue() {
        return getName();
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return super.hashCode() * z;
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        return getValue() != null;
    }

    public synchronized void setEncoding(java.lang.String str) {
        checkAttributesAllowed();
        this.y = str;
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized void setName(java.lang.String str) {
        if (getName() != null) {
            throw new org.apache.tools.ant.BuildException(new org.apache.tools.ant.types.resources.ImmutableResourceException());
        }
        super.setName(str);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.y != "UTF-8") {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public synchronized void setValue(java.lang.String str) {
        setName(str);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return java.lang.String.valueOf(getContent());
    }
}
