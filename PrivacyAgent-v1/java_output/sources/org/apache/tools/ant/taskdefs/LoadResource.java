package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class LoadResource extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Resource u;
    public boolean v = true;
    public boolean w = false;
    public java.lang.String x = null;
    public java.lang.String y = null;
    public final java.util.Vector<org.apache.tools.ant.types.FilterChain> z = new java.util.Vector<>();

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported");
        }
        this.u = resourceCollection.iterator().next();
    }

    public final void addFilterChain(org.apache.tools.ant.types.FilterChain filterChain) {
        this.z.addElement(filterChain);
    }

    @Override // org.apache.tools.ant.Task
    public final void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Resource resource = this.u;
        if (resource == null) {
            throw new org.apache.tools.ant.BuildException("source resource not defined");
        }
        if (this.y == null) {
            throw new org.apache.tools.ant.BuildException("output property not defined");
        }
        if (this.w && this.v) {
            throw new org.apache.tools.ant.BuildException("quiet and failonerror cannot both be set to true");
        }
        if (!resource.isExists()) {
            java.lang.String str = this.u + " doesn't exist";
            if (this.v) {
                throw new org.apache.tools.ant.BuildException(str);
            }
            log(str, this.w ? 1 : 0);
            return;
        }
        int i = 3;
        log("loading " + this.u + " into property " + this.y, 3);
        java.io.InputStream inputStream = null;
        try {
            try {
                long size = this.u.getSize();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("resource size = ");
                sb.append(size != -1 ? java.lang.String.valueOf(size) : "unknown");
                log(sb.toString(), 4);
                int i2 = (int) size;
                inputStream = this.u.getInputStream();
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream);
                java.io.InputStreamReader inputStreamReader = this.x == null ? new java.io.InputStreamReader(bufferedInputStream) : new java.io.InputStreamReader(bufferedInputStream, this.x);
                java.lang.String str2 = "";
                if (i2 != 0) {
                    org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
                    if (size != -1) {
                        chainReaderHelper.setBufferSize(i2);
                    }
                    chainReaderHelper.setPrimaryReader(inputStreamReader);
                    chainReaderHelper.setFilterChains(this.z);
                    chainReaderHelper.setProject(getProject());
                    str2 = chainReaderHelper.readFully(chainReaderHelper.getAssembledReader());
                } else {
                    log("Do not set property " + this.y + " as its length is 0.", this.w ? 3 : 2);
                }
                if (str2 != null && str2.length() > 0) {
                    getProject().setNewProperty(this.y, str2);
                    log("loaded " + str2.length() + " characters", 3);
                    log(this.y + " := " + str2, 4);
                }
            } catch (java.io.IOException e) {
                java.lang.String str3 = "Unable to load resource: " + e.toString();
                if (this.v) {
                    throw new org.apache.tools.ant.BuildException(str3, e, getLocation());
                }
                if (!this.w) {
                    i = 0;
                }
                log(str3, i);
            } catch (org.apache.tools.ant.BuildException e2) {
                if (this.v) {
                    throw e2;
                }
                java.lang.String message = e2.getMessage();
                if (!this.w) {
                    i = 0;
                }
                log(message, i);
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStream);
        }
    }

    public final void setEncoding(java.lang.String str) {
        this.x = str;
    }

    public final void setFailonerror(boolean z) {
        this.v = z;
    }

    public final void setProperty(java.lang.String str) {
        this.y = str;
    }

    public void setQuiet(boolean z) {
        this.w = z;
        if (z) {
            this.v = false;
        }
    }
}
