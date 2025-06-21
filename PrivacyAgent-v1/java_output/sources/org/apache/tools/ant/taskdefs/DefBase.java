package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class DefBase extends org.apache.tools.ant.taskdefs.AntlibDefinition {
    public java.lang.ClassLoader w;
    public org.apache.tools.ant.util.ClasspathUtils.Delegate x;

    public final org.apache.tools.ant.util.ClasspathUtils.Delegate c() {
        if (this.x == null) {
            this.x = org.apache.tools.ant.util.ClasspathUtils.getDelegate(this);
        }
        return this.x;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return c().createClasspath();
    }

    public java.lang.ClassLoader createLoader() {
        if (getAntlibClassLoader() != null && this.x == null) {
            return getAntlibClassLoader();
        }
        if (this.w == null) {
            java.lang.ClassLoader classLoader = c().getClassLoader();
            this.w = classLoader;
            ((org.apache.tools.ant.AntClassLoader) classLoader).addSystemPackageRoot("org.apache.tools.ant");
        }
        return this.w;
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return c().getClasspath();
    }

    public java.lang.String getClasspathId() {
        return c().getClassLoadId();
    }

    public java.lang.String getLoaderId() {
        return c().getClassLoadId();
    }

    public boolean hasCpDelegate() {
        return this.x != null;
    }

    @Override // org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        super.init();
    }

    public boolean isReverseLoader() {
        return c().isReverseLoader();
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        c().setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        c().setClasspathref(reference);
    }

    public void setLoaderRef(org.apache.tools.ant.types.Reference reference) {
        c().setLoaderRef(reference);
    }

    @java.lang.Deprecated
    public void setReverseLoader(boolean z) {
        c().setReverseLoader(z);
        log("The reverseloader attribute is DEPRECATED. It will be removed", 1);
    }
}
