package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class LoadProperties extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Resource u = null;
    public final java.util.Vector<org.apache.tools.ant.types.FilterChain> v = new java.util.Vector<>();
    public java.lang.String w = null;
    public java.lang.String x = null;
    public boolean y = true;

    public synchronized void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("only a single source is supported");
        }
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single-element resource collections are supported");
        }
        this.u = resourceCollection.iterator().next();
    }

    public final void addFilterChain(org.apache.tools.ant.types.FilterChain filterChain) {
        this.v.addElement(filterChain);
    }

    public final synchronized org.apache.tools.ant.types.resources.JavaResource c() {
        org.apache.tools.ant.types.Resource resource = this.u;
        if (resource == null) {
            org.apache.tools.ant.types.resources.JavaResource javaResource = new org.apache.tools.ant.types.resources.JavaResource();
            this.u = javaResource;
            javaResource.setProject(getProject());
        } else if (!(resource instanceof org.apache.tools.ant.types.resources.JavaResource)) {
            throw new org.apache.tools.ant.BuildException("expected a java resource as source");
        }
        return (org.apache.tools.ant.types.resources.JavaResource) this.u;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return c().createClasspath();
    }

    @Override // org.apache.tools.ant.Task
    public final void execute() throws org.apache.tools.ant.BuildException {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2;
        org.apache.tools.ant.types.Resource resource = this.u;
        if (resource == null) {
            throw new org.apache.tools.ant.BuildException("A source resource is required.");
        }
        if (!resource.isExists()) {
            if (!(this.u instanceof org.apache.tools.ant.types.resources.JavaResource)) {
                throw new org.apache.tools.ant.BuildException("Source resource does not exist: " + this.u);
            }
            log("Unable to find resource " + this.u, 1);
            return;
        }
        java.io.InputStream inputStream = null;
        try {
            java.io.BufferedInputStream bufferedInputStream3 = new java.io.BufferedInputStream(this.u.getInputStream());
            try {
                java.io.InputStreamReader inputStreamReader = this.w == null ? new java.io.InputStreamReader(bufferedInputStream3) : new java.io.InputStreamReader(bufferedInputStream3, this.w);
                org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                chainReaderHelper.setPrimaryReader(inputStreamReader);
                chainReaderHelper.setFilterChains(this.v);
                chainReaderHelper.setProject(getProject());
                java.lang.String readFully = chainReaderHelper.readFully(chainReaderHelper.getAssembledReader());
                if (readFully != null && readFully.length() != 0) {
                    if (!readFully.endsWith("\n")) {
                        readFully = readFully + "\n";
                    }
                    java.io.ByteArrayInputStream byteArrayInputStream2 = new java.io.ByteArrayInputStream(readFully.getBytes("ISO-8859-1"));
                    try {
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(byteArrayInputStream2);
                        org.apache.tools.ant.taskdefs.Property property = new org.apache.tools.ant.taskdefs.Property();
                        property.bindToOwner(this);
                        property.setPrefix(this.x);
                        property.setPrefixValues(this.y);
                        property.addProperties(properties);
                        inputStream = byteArrayInputStream2;
                    } catch (java.io.IOException e) {
                        bufferedInputStream2 = bufferedInputStream3;
                        byteArrayInputStream = byteArrayInputStream2;
                        e = e;
                        inputStream = bufferedInputStream2;
                        try {
                            throw new org.apache.tools.ant.BuildException("Unable to load file: " + e, e, getLocation());
                        } catch (java.lang.Throwable th) {
                            th = th;
                            org.apache.tools.ant.util.FileUtils.close(inputStream);
                            org.apache.tools.ant.util.FileUtils.close(byteArrayInputStream);
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        bufferedInputStream = bufferedInputStream3;
                        byteArrayInputStream = byteArrayInputStream2;
                        th = th2;
                        inputStream = bufferedInputStream;
                        org.apache.tools.ant.util.FileUtils.close(inputStream);
                        org.apache.tools.ant.util.FileUtils.close(byteArrayInputStream);
                        throw th;
                    }
                }
                org.apache.tools.ant.util.FileUtils.close(bufferedInputStream3);
                org.apache.tools.ant.util.FileUtils.close(inputStream);
            } catch (java.io.IOException e2) {
                e = e2;
                bufferedInputStream2 = bufferedInputStream3;
                byteArrayInputStream = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream3;
                byteArrayInputStream = null;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            byteArrayInputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
        }
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return c().getClasspath();
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        c().setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        c().setClasspathRef(reference);
    }

    public final void setEncoding(java.lang.String str) {
        this.w = str;
    }

    public void setPrefix(java.lang.String str) {
        this.x = str;
    }

    public void setPrefixValues(boolean z) {
        this.y = z;
    }

    public void setResource(java.lang.String str) {
        c().setName(str);
    }

    public final void setSrcFile(java.io.File file) {
        addConfigured(new org.apache.tools.ant.types.resources.FileResource(file));
    }
}
