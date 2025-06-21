package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class ResourceList extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public final java.util.Vector<org.apache.tools.ant.types.FilterChain> n = new java.util.Vector<>();
    public final java.util.ArrayList<org.apache.tools.ant.types.ResourceCollection> t = new java.util.ArrayList<>();
    public final org.apache.tools.ant.types.resources.Union u;
    public volatile boolean v;
    public java.lang.String w;
    public java.io.File x;

    public ResourceList() {
        org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
        this.u = union;
        this.v = false;
        this.w = null;
        union.setCache(true);
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.t.add(resourceCollection);
        setChecked(false);
    }

    public final void addFilterChain(org.apache.tools.ant.types.FilterChain filterChain) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.n.add(filterChain);
        setChecked(false);
    }

    public final synchronized org.apache.tools.ant.types.ResourceCollection b() {
        if (!this.v) {
            dieOnCircularReference();
            java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = this.t.iterator();
            while (it.hasNext()) {
                java.util.Iterator<org.apache.tools.ant.types.Resource> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    this.u.add(d(it2.next()));
                }
            }
            this.v = true;
        }
        return this.u;
    }

    public final org.apache.tools.ant.types.Resource c(java.lang.String str) {
        java.lang.Object parseProperties = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject()).parseProperties(str);
        if (parseProperties instanceof org.apache.tools.ant.types.Resource) {
            return (org.apache.tools.ant.types.Resource) parseProperties;
        }
        java.lang.String obj = parseProperties.toString();
        if (obj.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) != -1) {
            try {
                return new org.apache.tools.ant.types.resources.URLResource(obj);
            } catch (org.apache.tools.ant.BuildException unused) {
            }
        }
        if (this.x == null) {
            return new org.apache.tools.ant.types.resources.FileResource(getProject(), obj);
        }
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource(this.x, obj);
        fileResource.setProject(getProject());
        return fileResource;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x008b */
    public final org.apache.tools.ant.types.ResourceCollection d(org.apache.tools.ant.types.Resource resource) {
        java.io.IOException e;
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        try {
            try {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(resource.getInputStream());
                try {
                    java.io.InputStreamReader inputStreamReader = this.w == null ? new java.io.InputStreamReader(bufferedInputStream) : new java.io.InputStreamReader(bufferedInputStream, this.w);
                    org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                    chainReaderHelper.setPrimaryReader(inputStreamReader);
                    chainReaderHelper.setFilterChains(this.n);
                    chainReaderHelper.setProject(getProject());
                    org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(chainReaderHelper.getAssembledReader());
                    try {
                        union.setCache(true);
                        while (true) {
                            java.lang.String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                                return union;
                            }
                            union.add(c(readLine));
                        }
                    } finally {
                        bufferedReader.close();
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("Unable to read resource " + resource.getName() + ": " + e, e, getLocation());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = inputStream;
                org.apache.tools.ant.util.FileUtils.close(inputStream2);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Throwable th2) {
            th = th2;
            org.apache.tools.ant.util.FileUtils.close(inputStream2);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            java.util.Iterator<org.apache.tools.ant.types.ResourceCollection> it = this.t.iterator();
            while (it.hasNext()) {
                java.lang.Object obj = (org.apache.tools.ant.types.ResourceCollection) it.next();
                if (obj instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) obj, stack, project);
                }
            }
            java.util.Iterator<org.apache.tools.ant.types.FilterChain> it2 = this.n.iterator();
            while (it2.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(it2.next(), stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.ResourceList) getCheckedRef()).isFilesystemOnly();
        }
        return b().isFilesystemOnly();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public final synchronized java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.ResourceList) getCheckedRef()).iterator();
        }
        return b().iterator();
    }

    public final void setBasedir(java.io.File file) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.x = file;
    }

    public final void setEncoding(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.w = str;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.w != null) {
            throw tooManyAttributes();
        }
        if (this.n.size() > 0 || this.t.size() > 0) {
            throw noChildrenAllowed();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.ResourceList) getCheckedRef()).size();
        }
        return b().size();
    }
}
