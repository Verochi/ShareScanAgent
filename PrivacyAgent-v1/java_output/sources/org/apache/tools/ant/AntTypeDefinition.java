package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class AntTypeDefinition {
    public java.lang.String a;
    public java.lang.Class<?> b;
    public java.lang.Class<?> c;
    public java.lang.Class<?> d;
    public java.lang.String e;
    public java.lang.ClassLoader f;
    public boolean g = false;

    public final java.lang.Object a(org.apache.tools.ant.Project project, java.lang.Class<?> cls) {
        try {
            return innerCreateAndSet(cls, project);
        } catch (java.lang.IllegalAccessException unused) {
            throw new org.apache.tools.ant.BuildException("Could not create type " + this.a + " as the constructor " + cls + " is not accessible");
        } catch (java.lang.InstantiationException unused2) {
            throw new org.apache.tools.ant.BuildException("Could not create type " + this.a + " as the class " + cls + " is abstract");
        } catch (java.lang.NoClassDefFoundError e) {
            throw new org.apache.tools.ant.BuildException("Type " + this.a + ": A class needed by class " + cls + " cannot be found: " + e.getMessage(), e);
        } catch (java.lang.NoSuchMethodException unused3) {
            throw new org.apache.tools.ant.BuildException("Could not create type " + this.a + " as the class " + cls + " has no compatible constructor");
        } catch (java.lang.reflect.InvocationTargetException e2) {
            java.lang.Throwable targetException = e2.getTargetException();
            throw new org.apache.tools.ant.BuildException("Could not create type " + this.a + " due to " + targetException, targetException);
        } catch (java.lang.Throwable th) {
            throw new org.apache.tools.ant.BuildException("Could not create type " + this.a + " due to " + th, th);
        }
    }

    public final java.lang.String b(java.lang.Class<?> cls) {
        return cls == null ? "<null>" : cls.getClass().getName();
    }

    public final java.lang.Object c(org.apache.tools.ant.Project project) {
        java.lang.Class<?> cls;
        java.lang.Class<?> typeClass = getTypeClass(project);
        if (typeClass == null) {
            return null;
        }
        java.lang.Object a = a(project, typeClass);
        if (this.c == null || ((cls = this.d) != null && cls.isAssignableFrom(a.getClass()))) {
            return a;
        }
        org.apache.tools.ant.TypeAdapter typeAdapter = (org.apache.tools.ant.TypeAdapter) a(project, this.c);
        typeAdapter.setProxy(a);
        return typeAdapter;
    }

    public void checkClass(org.apache.tools.ant.Project project) {
        if (this.b == null) {
            java.lang.Class<?> typeClass = getTypeClass(project);
            this.b = typeClass;
            if (typeClass == null) {
                throw new org.apache.tools.ant.BuildException("Unable to create class for " + getName());
            }
        }
        if (this.c != null) {
            java.lang.Class<?> cls = this.d;
            if (cls == null || !cls.isAssignableFrom(this.b)) {
                ((org.apache.tools.ant.TypeAdapter) a(project, this.c)).checkProxyClass(this.b);
            }
        }
    }

    public java.lang.Object create(org.apache.tools.ant.Project project) {
        return c(project);
    }

    public java.lang.ClassLoader getClassLoader() {
        return this.f;
    }

    public java.lang.String getClassName() {
        return this.e;
    }

    public java.lang.Class<?> getExposedClass(org.apache.tools.ant.Project project) {
        java.lang.Class<?> typeClass;
        if (this.d != null && ((typeClass = getTypeClass(project)) == null || this.d.isAssignableFrom(typeClass))) {
            return typeClass;
        }
        java.lang.Class<?> cls = this.c;
        return cls == null ? getTypeClass(project) : cls;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public java.lang.Class<?> getTypeClass(org.apache.tools.ant.Project project) {
        try {
            return innerGetTypeClass();
        } catch (java.lang.ClassNotFoundException unused) {
            project.log("Could not load class (" + this.e + ") for type " + this.a, 4);
            return null;
        } catch (java.lang.NoClassDefFoundError e) {
            project.log("Could not load a dependent class (" + e.getMessage() + ") for type " + this.a, 4);
            return null;
        }
    }

    public <T> T innerCreateAndSet(java.lang.Class<T> cls, org.apache.tools.ant.Project project) throws java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Constructor<T> constructor;
        boolean z;
        try {
            constructor = cls.getConstructor(new java.lang.Class[0]);
            z = true;
        } catch (java.lang.NoSuchMethodException unused) {
            constructor = cls.getConstructor(org.apache.tools.ant.Project.class);
            z = false;
        }
        T newInstance = constructor.newInstance(z ? new java.lang.Object[0] : new java.lang.Object[]{project});
        project.setProjectReference(newInstance);
        return newInstance;
    }

    public java.lang.Class<?> innerGetTypeClass() throws java.lang.ClassNotFoundException {
        java.lang.Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        java.lang.ClassLoader classLoader = this.f;
        if (classLoader == null) {
            this.b = java.lang.Class.forName(this.e);
        } else {
            this.b = classLoader.loadClass(this.e);
        }
        return this.b;
    }

    public boolean isRestrict() {
        return this.g;
    }

    public boolean sameDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
        return antTypeDefinition != null && antTypeDefinition.getClass() == getClass() && antTypeDefinition.getTypeClass(project).equals(getTypeClass(project)) && antTypeDefinition.getExposedClass(project).equals(getExposedClass(project)) && antTypeDefinition.g == this.g && antTypeDefinition.c == this.c && antTypeDefinition.d == this.d;
    }

    public void setAdaptToClass(java.lang.Class<?> cls) {
        this.d = cls;
    }

    public void setAdapterClass(java.lang.Class<?> cls) {
        this.c = cls;
    }

    public void setClass(java.lang.Class<?> cls) {
        this.b = cls;
        if (cls == null) {
            return;
        }
        java.lang.ClassLoader classLoader = this.f;
        if (classLoader == null) {
            classLoader = cls.getClassLoader();
        }
        this.f = classLoader;
        java.lang.String str = this.e;
        if (str == null) {
            str = cls.getName();
        }
        this.e = str;
    }

    public void setClassLoader(java.lang.ClassLoader classLoader) {
        this.f = classLoader;
    }

    public void setClassName(java.lang.String str) {
        this.e = str;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    public void setRestrict(boolean z) {
        this.g = z;
    }

    public boolean similarDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
        if (antTypeDefinition == null || getClass() != antTypeDefinition.getClass() || !getClassName().equals(antTypeDefinition.getClassName()) || !b(this.c).equals(b(antTypeDefinition.c)) || !b(this.d).equals(b(antTypeDefinition.d)) || this.g != antTypeDefinition.g) {
            return false;
        }
        java.lang.ClassLoader classLoader = antTypeDefinition.getClassLoader();
        java.lang.ClassLoader classLoader2 = getClassLoader();
        return classLoader == classLoader2 || ((classLoader instanceof org.apache.tools.ant.AntClassLoader) && (classLoader2 instanceof org.apache.tools.ant.AntClassLoader) && ((org.apache.tools.ant.AntClassLoader) classLoader).getClasspath().equals(((org.apache.tools.ant.AntClassLoader) classLoader2).getClasspath()));
    }
}
