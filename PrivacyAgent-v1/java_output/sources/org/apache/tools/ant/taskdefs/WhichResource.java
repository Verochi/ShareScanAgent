package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class WhichResource extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Path u;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String x;

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u.createPath();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        org.apache.tools.ant.types.Path path = this.u;
        if (path != null) {
            this.u = path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
            getProject().log("using user supplied classpath: " + this.u, 4);
        } else {
            org.apache.tools.ant.types.Path path2 = new org.apache.tools.ant.types.Path(getProject());
            this.u = path2;
            this.u = path2.concatSystemClasspath(com.tencent.open.SocialConstants.PARAM_ONLY);
            getProject().log("using system classpath: " + this.u, 4);
        }
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        try {
            org.apache.tools.ant.AntClassLoader newAntClassLoader = org.apache.tools.ant.AntClassLoader.newAntClassLoader(getProject().getCoreLoader(), getProject(), this.u, false);
            if (this.v != null) {
                this.w = this.v.replace('.', '/') + ".class";
            }
            java.lang.String str = this.w;
            if (str == null) {
                throw new org.apache.tools.ant.BuildException("One of class or resource is required");
            }
            if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                this.w = this.w.substring(1);
            }
            log("Searching for " + this.w, 3);
            java.net.URL resource = newAntClassLoader.getResource(this.w);
            if (resource != null) {
                getProject().setNewProperty(this.x, resource.toExternalForm());
            }
            newAntClassLoader.cleanup();
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                antClassLoader.cleanup();
            }
            throw th;
        }
    }

    public void setClass(java.lang.String str) {
        this.v = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.u;
        if (path2 == null) {
            this.u = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setProperty(java.lang.String str) {
        this.x = str;
    }

    public void setResource(java.lang.String str) {
        this.w = str;
    }

    public final void validate() {
        int i = this.v != null ? 1 : 0;
        if (this.w != null) {
            i++;
        }
        if (i == 0) {
            throw new org.apache.tools.ant.BuildException("One of classname or resource must be specified");
        }
        if (i > 1) {
            throw new org.apache.tools.ant.BuildException("Only one of classname or resource can be specified");
        }
        if (this.x == null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.MakeUrl.ERROR_NO_PROPERTY);
        }
    }
}
