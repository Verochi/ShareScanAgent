package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class ZipResource extends org.apache.tools.ant.types.resources.ArchiveResource {
    public java.lang.String D;
    public org.apache.tools.zip.ZipExtraField[] E;
    public int F;

    /* renamed from: org.apache.tools.ant.types.resources.ZipResource$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.FilterInputStream {
        public final /* synthetic */ org.apache.tools.zip.ZipFile n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.io.InputStream inputStream, org.apache.tools.zip.ZipFile zipFile) {
            super(inputStream);
            this.n = zipFile;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            org.apache.tools.ant.util.FileUtils.close(((java.io.FilterInputStream) this).in);
            this.n.close();
        }

        public void finalize() throws java.lang.Throwable {
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public ZipResource() {
    }

    public ZipResource(java.io.File file, java.lang.String str, org.apache.tools.zip.ZipEntry zipEntry) {
        super(file, true);
        setEncoding(str);
        b(zipEntry);
    }

    @Override // org.apache.tools.ant.types.resources.ArchiveResource
    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        super.addConfigured(resourceCollection);
        if (!resourceCollection.isFilesystemOnly()) {
            throw new org.apache.tools.ant.BuildException("only filesystem resources are supported");
        }
    }

    public final void b(org.apache.tools.zip.ZipEntry zipEntry) {
        if (zipEntry == null) {
            setExists(false);
            return;
        }
        setName(zipEntry.getName());
        setExists(true);
        setLastModified(zipEntry.getTime());
        setDirectory(zipEntry.isDirectory());
        setSize(zipEntry.getSize());
        setMode(zipEntry.getUnixMode());
        this.E = zipEntry.getExtraFields(true);
        this.F = zipEntry.getMethod();
    }

    @Override // org.apache.tools.ant.types.resources.ArchiveResource
    public void fetchEntry() {
        java.lang.Throwable th;
        java.io.IOException e;
        try {
            try {
                org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(getZipfile(), getEncoding());
                try {
                    b(zipFile.getEntry(getName()));
                    org.apache.tools.zip.ZipFile.closeQuietly(zipFile);
                } catch (java.io.IOException e2) {
                    e = e2;
                    log(e.getMessage(), 4);
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                org.apache.tools.zip.ZipFile.closeQuietly(null);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            org.apache.tools.zip.ZipFile.closeQuietly(null);
            throw th;
        }
    }

    public java.lang.String getEncoding() {
        return isReference() ? ((org.apache.tools.ant.types.resources.ZipResource) getCheckedRef()).getEncoding() : this.D;
    }

    public org.apache.tools.zip.ZipExtraField[] getExtraFields() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.ZipResource) getCheckedRef()).getExtraFields();
        }
        checkEntry();
        org.apache.tools.zip.ZipExtraField[] zipExtraFieldArr = this.E;
        return zipExtraFieldArr == null ? new org.apache.tools.zip.ZipExtraField[0] : zipExtraFieldArr;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        org.apache.tools.zip.ZipFile zipFile = new org.apache.tools.zip.ZipFile(getZipfile(), getEncoding());
        org.apache.tools.zip.ZipEntry entry = zipFile.getEntry(getName());
        if (entry != null) {
            return new org.apache.tools.ant.types.resources.ZipResource.AnonymousClass1(zipFile.getInputStream(entry), zipFile);
        }
        zipFile.close();
        throw new org.apache.tools.ant.BuildException("no entry " + getName() + " in " + getArchive());
    }

    public int getMethod() {
        return this.F;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getOutputStream();
        }
        throw new java.lang.UnsupportedOperationException("Use the zip task for zip output.");
    }

    public java.io.File getZipfile() {
        return ((org.apache.tools.ant.types.resources.FileProvider) getArchive().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
    }

    public void setEncoding(java.lang.String str) {
        checkAttributesAllowed();
        this.D = str;
    }

    @Override // org.apache.tools.ant.types.resources.ArchiveResource, org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.D != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setZipfile(java.io.File file) {
        setArchive(file);
    }
}
