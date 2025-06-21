package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class HasMethod extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public java.lang.String t;
    public java.lang.String u;
    public org.apache.tools.ant.types.Path v;
    public org.apache.tools.ant.AntClassLoader w;
    public boolean x = false;

    public final boolean a(java.lang.Class<?> cls) {
        for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
            if (field.getName().equals(this.u)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(java.lang.Class<?> cls) {
        for (java.lang.reflect.Method method : cls.getDeclaredMethods()) {
            if (method.getName().equals(this.t)) {
                return true;
            }
        }
        return false;
    }

    public final java.lang.Class c(java.lang.String str) {
        try {
            if (!this.x) {
                org.apache.tools.ant.AntClassLoader antClassLoader = this.w;
                if (antClassLoader != null) {
                    return antClassLoader.loadClass(str);
                }
                java.lang.ClassLoader classLoader = getClass().getClassLoader();
                return classLoader != null ? java.lang.Class.forName(str, true, classLoader) : java.lang.Class.forName(str);
            }
            org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.v);
            this.w = createClassLoader;
            createClassLoader.setParentFirst(false);
            this.w.addJavaLibraries();
            try {
                return this.w.findClass(str);
            } catch (java.lang.SecurityException e) {
                throw new org.apache.tools.ant.BuildException("class \"" + str + "\" was found but a SecurityException has been raised while loading it", e);
            }
        } catch (java.lang.ClassNotFoundException unused) {
            throw new org.apache.tools.ant.BuildException("class \"" + str + "\" was not found");
        } catch (java.lang.NoClassDefFoundError e2) {
            throw new org.apache.tools.ant.BuildException("Could not load dependent class \"" + e2.getMessage() + "\" for class \"" + str + "\"");
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.v.createPath();
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.n;
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("No classname defined");
        }
        org.apache.tools.ant.AntClassLoader antClassLoader = this.w;
        try {
            java.lang.Class c = c(str);
            if (this.t != null) {
                return b(c);
            }
            if (this.u == null) {
                throw new org.apache.tools.ant.BuildException("Neither method nor field defined");
            }
            boolean a = a(c);
            org.apache.tools.ant.AntClassLoader antClassLoader2 = this.w;
            if (antClassLoader != antClassLoader2 && antClassLoader2 != null) {
                antClassLoader2.cleanup();
                this.w = null;
            }
            return a;
        } finally {
            org.apache.tools.ant.AntClassLoader antClassLoader3 = this.w;
            if (antClassLoader != antClassLoader3 && antClassLoader3 != null) {
                antClassLoader3.cleanup();
                this.w = null;
            }
        }
    }

    public void setClassname(java.lang.String str) {
        this.n = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        createClasspath().append(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setField(java.lang.String str) {
        this.u = str;
    }

    public void setIgnoreSystemClasses(boolean z) {
        this.x = z;
    }

    public void setMethod(java.lang.String str) {
        this.t = str;
    }
}
