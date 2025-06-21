package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ScriptRunnerHelper {
    public java.io.File b;
    public java.lang.String d;
    public java.lang.String e;
    public org.apache.tools.ant.ProjectComponent g;
    public org.apache.tools.ant.util.ClasspathUtils.Delegate a = null;
    public java.lang.String c = "auto";
    public boolean f = true;
    public java.lang.ClassLoader h = null;
    public org.apache.tools.ant.types.resources.Union i = new org.apache.tools.ant.types.resources.Union();

    public final synchronized java.lang.ClassLoader a() {
        java.lang.ClassLoader classLoader = this.h;
        if (classLoader != null) {
            return classLoader;
        }
        org.apache.tools.ant.util.ClasspathUtils.Delegate delegate = this.a;
        if (delegate == null) {
            java.lang.ClassLoader classLoader2 = getClass().getClassLoader();
            this.h = classLoader2;
            return classLoader2;
        }
        java.lang.ClassLoader classLoader3 = delegate.getClassLoader();
        this.h = classLoader3;
        return classLoader3;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.i.add(resourceCollection);
    }

    public void addText(java.lang.String str) {
        this.e = str;
    }

    public final org.apache.tools.ant.util.ClasspathUtils.Delegate b() {
        if (this.a == null) {
            org.apache.tools.ant.ProjectComponent projectComponent = this.g;
            if (projectComponent == null) {
                throw new java.lang.IllegalStateException("Can't access classpath without a project component");
            }
            this.a = org.apache.tools.ant.util.ClasspathUtils.getDelegate(projectComponent);
        }
        return this.a;
    }

    public final org.apache.tools.ant.util.ScriptRunnerBase c() {
        return new org.apache.tools.ant.util.ScriptRunnerCreator(this.g.getProject()).createRunner(this.c, this.d, a());
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        return b().createClasspath();
    }

    public java.lang.String getLanguage() {
        return this.d;
    }

    public org.apache.tools.ant.util.ScriptRunnerBase getScriptRunner() {
        org.apache.tools.ant.util.ScriptRunnerBase c = c();
        java.io.File file = this.b;
        if (file != null) {
            c.setSrc(file);
        }
        java.lang.String str = this.e;
        if (str != null) {
            c.addText(str);
        }
        org.apache.tools.ant.types.resources.Union union = this.i;
        if (union != null) {
            c.loadResources(union);
        }
        if (this.f) {
            c.bindToComponent(this.g);
        } else {
            c.bindToComponentMinimum(this.g);
        }
        return c;
    }

    public void setClassLoader(java.lang.ClassLoader classLoader) {
        this.h = classLoader;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        b().setClasspath(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        b().setClasspathref(reference);
    }

    public void setLanguage(java.lang.String str) {
        this.d = str;
    }

    public void setManager(java.lang.String str) {
        this.c = str;
    }

    public void setProjectComponent(org.apache.tools.ant.ProjectComponent projectComponent) {
        this.g = projectComponent;
    }

    public void setSetBeans(boolean z) {
        this.f = z;
    }

    public void setSrc(java.io.File file) {
        this.b = file;
    }
}
