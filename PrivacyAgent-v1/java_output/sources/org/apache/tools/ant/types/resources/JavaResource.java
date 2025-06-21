package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class JavaResource extends org.apache.tools.ant.types.resources.AbstractClasspathResource implements org.apache.tools.ant.types.resources.URLProvider {
    public JavaResource() {
    }

    public JavaResource(java.lang.String str, org.apache.tools.ant.types.Path path) {
        setName(str);
        setClasspath(path);
    }

    @Override // org.apache.tools.ant.types.Resource, java.lang.Comparable
    public int compareTo(org.apache.tools.ant.types.Resource resource) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).compareTo(resource);
        }
        if (!resource.getClass().equals(getClass())) {
            return super.compareTo(resource);
        }
        org.apache.tools.ant.types.resources.JavaResource javaResource = (org.apache.tools.ant.types.resources.JavaResource) resource;
        if (!getName().equals(javaResource.getName())) {
            return getName().compareTo(javaResource.getName());
        }
        if (getLoader() != javaResource.getLoader()) {
            if (getLoader() == null) {
                return -1;
            }
            if (javaResource.getLoader() == null) {
                return 1;
            }
            return getLoader().getRefId().compareTo(javaResource.getLoader().getRefId());
        }
        org.apache.tools.ant.types.Path classpath = getClasspath();
        org.apache.tools.ant.types.Path classpath2 = javaResource.getClasspath();
        if (classpath == classpath2) {
            return 0;
        }
        if (classpath == null) {
            return -1;
        }
        if (classpath2 == null) {
            return 1;
        }
        return classpath.toString().compareTo(classpath2.toString());
    }

    @Override // org.apache.tools.ant.types.resources.URLProvider
    public java.net.URL getURL() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.JavaResource) getCheckedRef()).getURL();
        }
        org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag classLoader = getClassLoader();
        if (classLoader.getLoader() == null) {
            return java.lang.ClassLoader.getSystemResource(getName());
        }
        try {
            return classLoader.getLoader().getResource(getName());
        } finally {
            classLoader.cleanup();
        }
    }

    @Override // org.apache.tools.ant.types.resources.AbstractClasspathResource
    public java.io.InputStream openInputStream(java.lang.ClassLoader classLoader) throws java.io.IOException {
        if (classLoader == null) {
            java.io.InputStream systemResourceAsStream = java.lang.ClassLoader.getSystemResourceAsStream(getName());
            if (systemResourceAsStream != null) {
                return systemResourceAsStream;
            }
            throw new java.io.FileNotFoundException("No resource " + getName() + " on Ant's classpath");
        }
        java.io.InputStream resourceAsStream = classLoader.getResourceAsStream(getName());
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new java.io.FileNotFoundException("No resource " + getName() + " on the classpath " + classLoader);
    }
}
