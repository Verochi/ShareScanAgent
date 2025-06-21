package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class AntlibDefinition extends org.apache.tools.ant.Task {
    public java.lang.String u = "";
    public java.lang.ClassLoader v;

    public java.lang.ClassLoader getAntlibClassLoader() {
        return this.v;
    }

    public java.lang.String getURI() {
        return this.u;
    }

    public void setAntlibClassLoader(java.lang.ClassLoader classLoader) {
        this.v = classLoader;
    }

    public void setURI(java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (str.equals(org.apache.tools.ant.ProjectHelper.ANT_CORE_URI)) {
            str = "";
        }
        if (!str.startsWith("ant:")) {
            this.u = str;
            return;
        }
        throw new org.apache.tools.ant.BuildException("Attempt to use a reserved URI " + str);
    }
}
