package org.apache.tools.ant.taskdefs.optional.extension.resolvers;

/* loaded from: classes25.dex */
public class LocationResolver implements org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver {
    public java.lang.String a;

    @Override // org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver
    public java.io.File resolve(org.apache.tools.ant.taskdefs.optional.extension.Extension extension, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.a;
        if (str != null) {
            return project.resolveFile(str);
        }
        throw new org.apache.tools.ant.BuildException("No location specified for resolver");
    }

    public void setLocation(java.lang.String str) {
        this.a = str;
    }

    public java.lang.String toString() {
        return "Location[" + this.a + "]";
    }
}
