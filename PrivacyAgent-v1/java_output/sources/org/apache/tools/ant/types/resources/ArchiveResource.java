package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class ArchiveResource extends org.apache.tools.ant.types.Resource {
    public static final int C = org.apache.tools.ant.types.Resource.getMagicNumber("null archive".getBytes());
    public boolean A;
    public int B;
    public org.apache.tools.ant.types.Resource y;
    public boolean z;

    public ArchiveResource() {
        this.z = false;
        this.A = false;
        this.B = 0;
    }

    public ArchiveResource(java.io.File file) {
        this(file, false);
    }

    public ArchiveResource(java.io.File file, boolean z) {
        this.z = false;
        this.A = false;
        this.B = 0;
        setArchive(file);
        this.z = z;
    }

    public ArchiveResource(org.apache.tools.ant.types.Resource resource, boolean z) {
        this.z = false;
        this.A = false;
        this.B = 0;
        addConfigured(resource);
        this.z = z;
    }

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        checkChildrenAllowed();
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("you must not specify more than one archive");
        }
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported as archives");
        }
        this.y = resourceCollection.iterator().next();
    }

    public final synchronized void checkEntry() throws org.apache.tools.ant.BuildException {
        dieOnCircularReference();
        if (this.z) {
            return;
        }
        if (getName() == null) {
            throw new org.apache.tools.ant.BuildException("entry name not set");
        }
        org.apache.tools.ant.types.Resource archive = getArchive();
        if (archive == null) {
            throw new org.apache.tools.ant.BuildException("archive attribute not set");
        }
        if (!archive.isExists()) {
            throw new org.apache.tools.ant.BuildException(archive.toString() + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX);
        }
        if (!archive.isDirectory()) {
            fetchEntry();
            this.z = true;
        } else {
            throw new org.apache.tools.ant.BuildException(archive + " denotes a directory.");
        }
    }

    @Override // org.apache.tools.ant.types.Resource, java.lang.Comparable
    public int compareTo(org.apache.tools.ant.types.Resource resource) {
        if (equals(resource)) {
            return 0;
        }
        return super.compareTo(resource);
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.Resource resource = this.y;
            if (resource != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(resource, stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        org.apache.tools.ant.types.resources.ArchiveResource archiveResource = (org.apache.tools.ant.types.resources.ArchiveResource) obj;
        return getArchive().equals(archiveResource.getArchive()) && getName().equals(archiveResource.getName());
    }

    public abstract void fetchEntry();

    public org.apache.tools.ant.types.Resource getArchive() {
        return isReference() ? ((org.apache.tools.ant.types.resources.ArchiveResource) getCheckedRef()).getArchive() : this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getLastModified() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getLastModified();
        }
        checkEntry();
        return super.getLastModified();
    }

    public int getMode() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.ArchiveResource) getCheckedRef()).getMode();
        }
        checkEntry();
        return this.B;
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getSize() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getSize();
        }
        checkEntry();
        return super.getSize();
    }

    @Override // org.apache.tools.ant.types.Resource
    public int hashCode() {
        return super.hashCode() * (getArchive() == null ? C : getArchive().hashCode());
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isDirectory() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isDirectory();
        }
        checkEntry();
        return super.isDirectory();
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isExists();
        }
        checkEntry();
        return super.isExists();
    }

    public void setArchive(java.io.File file) {
        checkAttributesAllowed();
        this.y = new org.apache.tools.ant.types.resources.FileResource(file);
    }

    public void setMode(int i) {
        checkAttributesAllowed();
        this.B = i;
        this.A = true;
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.y != null || this.A) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        return getArchive().toString() + ':' + getName();
    }
}
