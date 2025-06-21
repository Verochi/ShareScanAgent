package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Archives extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public org.apache.tools.ant.types.resources.Union n = new org.apache.tools.ant.types.resources.Union();
    public org.apache.tools.ant.types.resources.Union t = new org.apache.tools.ant.types.resources.Union();

    @Override // org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.resources.Archives archives = (org.apache.tools.ant.types.resources.Archives) super.clone();
            archives.n = (org.apache.tools.ant.types.resources.Union) this.n.clone();
            archives.t = (org.apache.tools.ant.types.resources.Union) this.t.clone();
            return archives;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.ArchiveFileSet configureArchive(org.apache.tools.ant.types.ArchiveFileSet archiveFileSet, org.apache.tools.ant.types.Resource resource) {
        archiveFileSet.setProject(getProject());
        archiveFileSet.setSrcResource(resource);
        return archiveFileSet;
    }

    public org.apache.tools.ant.types.resources.Union createTars() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        return this.t;
    }

    public org.apache.tools.ant.types.resources.Union createZips() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        return this.n;
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.n, stack, project);
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.t, stack, project);
            setChecked(true);
        }
    }

    public java.util.Iterator<org.apache.tools.ant.types.ArchiveFileSet> grabArchives() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.n.iterator();
        while (it.hasNext()) {
            linkedList.add(configureArchive(new org.apache.tools.ant.types.ZipFileSet(), it.next()));
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = this.t.iterator();
        while (it2.hasNext()) {
            linkedList.add(configureArchive(new org.apache.tools.ant.types.TarFileSet(), it2.next()));
        }
        return linkedList.iterator();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Archives) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        return false;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Archives) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator<org.apache.tools.ant.types.ArchiveFileSet> grabArchives = grabArchives();
        while (grabArchives.hasNext()) {
            linkedList.addAll(org.apache.tools.ant.util.CollectionUtils.asCollection(grabArchives.next().iterator()));
        }
        return linkedList.iterator();
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.n.getResourceCollections().size() > 0 || this.t.getResourceCollections().size() > 0) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.Archives) getCheckedRef()).size();
        }
        dieOnCircularReference();
        java.util.Iterator<org.apache.tools.ant.types.ArchiveFileSet> grabArchives = grabArchives();
        int i = 0;
        while (grabArchives.hasNext()) {
            i += grabArchives.next().size();
        }
        return i;
    }
}
