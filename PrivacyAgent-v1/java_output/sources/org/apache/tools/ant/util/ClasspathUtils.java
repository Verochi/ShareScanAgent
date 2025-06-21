package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class ClasspathUtils {
    public static final java.lang.String REUSE_LOADER_REF = "ant.reuse.loader";

    public static class Delegate {
        public final org.apache.tools.ant.ProjectComponent a;
        public org.apache.tools.ant.types.Path b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public boolean f = false;

        public Delegate(org.apache.tools.ant.ProjectComponent projectComponent) {
            this.a = projectComponent;
        }

        public final org.apache.tools.ant.Project a() {
            return this.a.getProject();
        }

        public org.apache.tools.ant.types.Path createClasspath() {
            if (this.b == null) {
                this.b = new org.apache.tools.ant.types.Path(this.a.getProject());
            }
            return this.b.createPath();
        }

        public java.lang.String getClassLoadId() {
            java.lang.String str = this.e;
            if (str != null || this.c == null) {
                return str;
            }
            return org.apache.tools.ant.MagicNames.REFID_CLASSPATH_LOADER_PREFIX + this.c;
        }

        public java.lang.ClassLoader getClassLoader() {
            return org.apache.tools.ant.util.ClasspathUtils.getClassLoaderForPath(a(), this.b, getClassLoadId(), this.f, this.e != null || org.apache.tools.ant.util.ClasspathUtils.b(a()));
        }

        public org.apache.tools.ant.types.Path getClasspath() {
            return this.b;
        }

        public boolean isReverseLoader() {
            return this.f;
        }

        public java.lang.Object newInstance() {
            return org.apache.tools.ant.util.ClasspathUtils.newInstance(this.d, getClassLoader());
        }

        public void setClassname(java.lang.String str) {
            this.d = str;
        }

        public void setClasspath(org.apache.tools.ant.types.Path path) {
            org.apache.tools.ant.types.Path path2 = this.b;
            if (path2 == null) {
                this.b = path;
            } else {
                path2.append(path);
            }
        }

        public void setClasspathref(org.apache.tools.ant.types.Reference reference) {
            this.c = reference.getRefId();
            createClasspath().setRefid(reference);
        }

        public void setLoaderRef(org.apache.tools.ant.types.Reference reference) {
            this.e = reference.getRefId();
        }

        public void setReverseLoader(boolean z) {
            this.f = z;
        }
    }

    public static boolean b(org.apache.tools.ant.Project project) {
        return project.getProperty("ant.reuse.loader") != null;
    }

    public static java.lang.ClassLoader getClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, java.lang.String str) {
        return getClassLoaderForPath(project, path, str, false);
    }

    public static java.lang.ClassLoader getClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, java.lang.String str, boolean z) {
        return getClassLoaderForPath(project, path, str, z, b(project));
    }

    public static java.lang.ClassLoader getClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, java.lang.String str, boolean z, boolean z2) {
        java.lang.ClassLoader classLoader;
        if (str == null || !z2) {
            classLoader = null;
        } else {
            java.lang.Object reference = project.getReference(str);
            if (reference != null && !(reference instanceof java.lang.ClassLoader)) {
                throw new org.apache.tools.ant.BuildException("The specified loader id " + str + " does not reference a class loader");
            }
            classLoader = (java.lang.ClassLoader) reference;
        }
        if (classLoader == null) {
            classLoader = getUniqueClassLoaderForPath(project, path, z);
            if (str != null && z2) {
                project.addReference(str, classLoader);
            }
        }
        return classLoader;
    }

    public static java.lang.ClassLoader getClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Reference reference) {
        return getClassLoaderForPath(project, reference, false);
    }

    public static java.lang.ClassLoader getClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Reference reference, boolean z) {
        java.lang.String refId = reference.getRefId();
        java.lang.Object reference2 = project.getReference(refId);
        if (reference2 instanceof org.apache.tools.ant.types.Path) {
            return getClassLoaderForPath(project, (org.apache.tools.ant.types.Path) reference2, org.apache.tools.ant.MagicNames.REFID_CLASSPATH_LOADER_PREFIX + refId, z);
        }
        throw new org.apache.tools.ant.BuildException("The specified classpathref " + refId + " does not reference a Path.");
    }

    public static org.apache.tools.ant.util.ClasspathUtils.Delegate getDelegate(org.apache.tools.ant.ProjectComponent projectComponent) {
        return new org.apache.tools.ant.util.ClasspathUtils.Delegate(projectComponent);
    }

    public static java.lang.ClassLoader getUniqueClassLoaderForPath(org.apache.tools.ant.Project project, org.apache.tools.ant.types.Path path, boolean z) {
        org.apache.tools.ant.AntClassLoader createClassLoader = project.createClassLoader(path);
        if (z) {
            createClassLoader.setParentFirst(false);
            createClassLoader.addJavaLibraries();
        }
        return createClassLoader;
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.ClassLoader classLoader) {
        return newInstance(str, classLoader, java.lang.Object.class);
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.ClassLoader classLoader, java.lang.Class cls) {
        try {
            java.lang.Object newInstance = java.lang.Class.forName(str, true, classLoader).newInstance();
            if (cls.isInstance(newInstance)) {
                return newInstance;
            }
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.rmic.RmicAdapterFactory.ERROR_NOT_RMIC_ADAPTER + str + " expected :" + cls);
        } catch (java.lang.ClassNotFoundException e) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.rmic.RmicAdapterFactory.ERROR_UNKNOWN_COMPILER + str, e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new org.apache.tools.ant.BuildException("Could not instantiate " + str + ". Specified class should have a public constructor.", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new org.apache.tools.ant.BuildException("Could not instantiate " + str + ". Specified class should have a no argument constructor.", e3);
        } catch (java.lang.LinkageError e4) {
            throw new org.apache.tools.ant.BuildException("Class " + str + " could not be loaded because of an invalid dependency.", e4);
        }
    }
}
