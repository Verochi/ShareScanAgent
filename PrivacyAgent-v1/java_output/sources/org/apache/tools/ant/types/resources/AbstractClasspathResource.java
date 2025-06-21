package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class AbstractClasspathResource extends org.apache.tools.ant.types.Resource {
    public boolean A = true;
    public org.apache.tools.ant.types.Path y;
    public org.apache.tools.ant.types.Reference z;

    /* renamed from: org.apache.tools.ant.types.resources.AbstractClasspathResource$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.FilterInputStream {
        public final /* synthetic */ org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.io.InputStream inputStream, org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag classLoaderWithFlag) {
            super(inputStream);
            this.n = classLoaderWithFlag;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            org.apache.tools.ant.util.FileUtils.close(((java.io.FilterInputStream) this).in);
            this.n.cleanup();
        }

        public void finalize() throws java.lang.Throwable {
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public static class ClassLoaderWithFlag {
        public final java.lang.ClassLoader a;
        public final boolean b;

        public ClassLoaderWithFlag(java.lang.ClassLoader classLoader, boolean z) {
            this.a = classLoader;
            this.b = z && (classLoader instanceof org.apache.tools.ant.AntClassLoader);
        }

        public void cleanup() {
            if (this.b) {
                ((org.apache.tools.ant.AntClassLoader) this.a).cleanup();
            }
        }

        public java.lang.ClassLoader getLoader() {
            return this.a;
        }

        public boolean needsCleanup() {
            return this.b;
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        checkChildrenAllowed();
        if (this.y == null) {
            this.y = new org.apache.tools.ant.types.Path(getProject());
        }
        setChecked(false);
        return this.y.createPath();
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.Path path = this.y;
            if (path != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(path, stack, project);
            }
            setChecked(true);
        }
    }

    public org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag getClassLoader() {
        org.apache.tools.ant.types.Reference reference = this.z;
        java.lang.ClassLoader classLoader = reference != null ? (java.lang.ClassLoader) reference.getReferencedObject() : null;
        boolean z = false;
        if (classLoader == null) {
            if (getClasspath() != null) {
                org.apache.tools.ant.types.Path concatSystemClasspath = getClasspath().concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
                classLoader = this.A ? getProject().createClassLoader(concatSystemClasspath) : org.apache.tools.ant.AntClassLoader.newAntClassLoader(getProject().getCoreLoader(), getProject(), concatSystemClasspath, false);
                if (this.z == null) {
                    z = true;
                }
            } else {
                classLoader = org.apache.tools.ant.types.resources.JavaResource.class.getClassLoader();
            }
            if (this.z != null && classLoader != null) {
                getProject().addReference(this.z.getRefId(), classLoader);
            }
        }
        return new org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag(classLoader, z);
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.AbstractClasspathResource) getCheckedRef()).getClasspath();
        }
        dieOnCircularReference();
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.resources.AbstractClasspathResource.ClassLoaderWithFlag classLoader = getClassLoader();
        return !classLoader.needsCleanup() ? openInputStream(classLoader.getLoader()) : new org.apache.tools.ant.types.resources.AbstractClasspathResource.AnonymousClass1(openInputStream(classLoader.getLoader()), classLoader);
    }

    public org.apache.tools.ant.types.Reference getLoader() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.AbstractClasspathResource) getCheckedRef()).getLoader();
        }
        dieOnCircularReference();
        return this.z;
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isExists();
        }
        dieOnCircularReference();
        try {
            java.io.InputStream inputStream = getInputStream();
            boolean z = inputStream != null;
            org.apache.tools.ant.util.FileUtils.close(inputStream);
            return z;
        } catch (java.io.IOException unused) {
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            return false;
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            throw th;
        }
    }

    public abstract java.io.InputStream openInputStream(java.lang.ClassLoader classLoader) throws java.io.IOException;

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        checkAttributesAllowed();
        org.apache.tools.ant.types.Path path2 = this.y;
        if (path2 == null) {
            this.y = path;
        } else {
            path2.append(path);
        }
        setChecked(false);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        checkAttributesAllowed();
        createClasspath().setRefid(reference);
    }

    public void setLoaderRef(org.apache.tools.ant.types.Reference reference) {
        checkAttributesAllowed();
        this.z = reference;
    }

    public void setParentFirst(boolean z) {
        this.A = z;
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.z != null || this.y != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }
}
