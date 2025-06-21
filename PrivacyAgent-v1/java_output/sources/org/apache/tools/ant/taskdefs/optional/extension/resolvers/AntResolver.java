package org.apache.tools.ant.taskdefs.optional.extension.resolvers;

/* loaded from: classes25.dex */
public class AntResolver implements org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver {
    public java.io.File a;
    public java.io.File b;
    public java.lang.String c;

    public final void a() {
        if (this.a == null) {
            throw new org.apache.tools.ant.BuildException("Must specify Buildfile");
        }
        if (this.b == null) {
            throw new org.apache.tools.ant.BuildException("Must specify destination file");
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver
    public java.io.File resolve(org.apache.tools.ant.taskdefs.optional.extension.Extension extension, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        a();
        org.apache.tools.ant.taskdefs.Ant ant = new org.apache.tools.ant.taskdefs.Ant();
        ant.setProject(project);
        ant.setInheritAll(false);
        ant.setAntfile(this.a.getName());
        try {
            ant.setDir(this.a.getParentFile().getCanonicalFile());
            java.lang.String str = this.c;
            if (str != null) {
                ant.setTarget(str);
            }
            ant.execute();
            return this.b;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        }
    }

    public void setAntfile(java.io.File file) {
        this.a = file;
    }

    public void setDestfile(java.io.File file) {
        this.b = file;
    }

    public void setTarget(java.lang.String str) {
        this.c = str;
    }

    public java.lang.String toString() {
        return "Ant[" + this.a + "==>" + this.b + "]";
    }
}
