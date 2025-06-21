package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class TarResource extends org.apache.tools.ant.types.resources.ArchiveResource {
    public java.lang.String D;
    public java.lang.String E;
    public int F;
    public int G;

    public TarResource() {
        this.D = "";
        this.E = "";
    }

    public TarResource(java.io.File file, org.apache.tools.tar.TarEntry tarEntry) {
        super(file, true);
        this.D = "";
        this.E = "";
        b(tarEntry);
    }

    public TarResource(org.apache.tools.ant.types.Resource resource, org.apache.tools.tar.TarEntry tarEntry) {
        super(resource, true);
        this.D = "";
        this.E = "";
        b(tarEntry);
    }

    public final void b(org.apache.tools.tar.TarEntry tarEntry) {
        if (tarEntry == null) {
            setExists(false);
            return;
        }
        setName(tarEntry.getName());
        setExists(true);
        setLastModified(tarEntry.getModTime().getTime());
        setDirectory(tarEntry.isDirectory());
        setSize(tarEntry.getSize());
        setMode(tarEntry.getMode());
        this.D = tarEntry.getUserName();
        this.E = tarEntry.getGroupName();
        this.F = tarEntry.getUserId();
        this.G = tarEntry.getGroupId();
    }

    @Override // org.apache.tools.ant.types.resources.ArchiveResource
    public void fetchEntry() {
        org.apache.tools.tar.TarEntry nextEntry;
        org.apache.tools.tar.TarInputStream tarInputStream = null;
        try {
            try {
                org.apache.tools.tar.TarInputStream tarInputStream2 = new org.apache.tools.tar.TarInputStream(getArchive().getInputStream());
                do {
                    try {
                        nextEntry = tarInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            org.apache.tools.ant.util.FileUtils.close(tarInputStream2);
                            b(null);
                            return;
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                        tarInputStream = tarInputStream2;
                        log(e.getMessage(), 4);
                        throw new org.apache.tools.ant.BuildException(e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        tarInputStream = tarInputStream2;
                        org.apache.tools.ant.util.FileUtils.close(tarInputStream);
                        throw th;
                    }
                } while (!nextEntry.getName().equals(getName()));
                b(nextEntry);
                org.apache.tools.ant.util.FileUtils.close(tarInputStream2);
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public int getGid() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.TarResource) getCheckedRef()).getGid();
        }
        checkEntry();
        return this.G;
    }

    public java.lang.String getGroup() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.TarResource) getCheckedRef()).getGroup();
        }
        checkEntry();
        return this.E;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        org.apache.tools.tar.TarEntry nextEntry;
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        org.apache.tools.tar.TarInputStream tarInputStream = new org.apache.tools.tar.TarInputStream(getArchive().getInputStream());
        do {
            nextEntry = tarInputStream.getNextEntry();
            if (nextEntry == null) {
                org.apache.tools.ant.util.FileUtils.close(tarInputStream);
                throw new org.apache.tools.ant.BuildException("no entry " + getName() + " in " + getArchive());
            }
        } while (!nextEntry.getName().equals(getName()));
        return tarInputStream;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getOutputStream();
        }
        throw new java.lang.UnsupportedOperationException("Use the tar task for tar output.");
    }

    public int getUid() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.TarResource) getCheckedRef()).getUid();
        }
        checkEntry();
        return this.F;
    }

    public java.lang.String getUserName() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.TarResource) getCheckedRef()).getUserName();
        }
        checkEntry();
        return this.D;
    }
}
