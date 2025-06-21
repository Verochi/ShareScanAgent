package org.apache.tools.ant.taskdefs.optional.extension.resolvers;

/* loaded from: classes25.dex */
public class URLResolver implements org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver {
    public java.io.File a;
    public java.io.File b;
    public java.net.URL c;

    public final java.io.File a() {
        java.lang.String str;
        java.io.File file = this.a;
        if (file != null) {
            return file;
        }
        java.lang.String file2 = this.c.getFile();
        if (file2 == null || file2.length() <= 1) {
            str = "default.file";
        } else {
            int lastIndexOf = file2.lastIndexOf(47);
            if (-1 == lastIndexOf) {
                lastIndexOf = 0;
            }
            str = file2.substring(lastIndexOf);
        }
        return new java.io.File(this.b, str);
    }

    public final void b() {
        if (this.c == null) {
            throw new org.apache.tools.ant.BuildException("Must specify URL");
        }
        java.io.File file = this.b;
        if (file == null && this.a == null) {
            throw new org.apache.tools.ant.BuildException("Must specify destination file or directory");
        }
        if (file != null && this.a != null) {
            throw new org.apache.tools.ant.BuildException("Must not specify both destination file or directory");
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver
    public java.io.File resolve(org.apache.tools.ant.taskdefs.optional.extension.Extension extension, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        b();
        java.io.File a = a();
        org.apache.tools.ant.taskdefs.Get get = new org.apache.tools.ant.taskdefs.Get();
        get.setProject(project);
        get.setDest(a);
        get.setSrc(this.c);
        get.execute();
        return a;
    }

    public void setDestdir(java.io.File file) {
        this.b = file;
    }

    public void setDestfile(java.io.File file) {
        this.a = file;
    }

    public void setUrl(java.net.URL url) {
        this.c = url;
    }

    public java.lang.String toString() {
        return "URL[" + this.c + "]";
    }
}
