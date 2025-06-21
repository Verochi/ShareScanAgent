package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ProjectHelperRepository {
    public static final boolean b = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(java.lang.System.getProperty("ant.project-helper-repo.debug"));
    public static org.apache.tools.ant.ProjectHelperRepository c = new org.apache.tools.ant.ProjectHelperRepository();
    public static java.lang.reflect.Constructor<org.apache.tools.ant.helper.ProjectHelper2> d;
    public java.util.List<java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper>> a = new java.util.ArrayList();

    public static class ConstructingIterator implements java.util.Iterator<org.apache.tools.ant.ProjectHelper> {
        public final java.util.Iterator<java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper>> n;
        public boolean t = false;

        public ConstructingIterator(java.util.Iterator<java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper>> it) {
            this.n = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public org.apache.tools.ant.ProjectHelper next() {
            java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper> constructor;
            if (this.n.hasNext()) {
                constructor = this.n.next();
            } else {
                this.t = true;
                constructor = org.apache.tools.ant.ProjectHelperRepository.d;
            }
            try {
                return (org.apache.tools.ant.ProjectHelper) constructor.newInstance(new java.lang.Object[0]);
            } catch (java.lang.Exception unused) {
                throw new org.apache.tools.ant.BuildException("Failed to invoke no-arg constructor on " + constructor.getName());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasNext() || !this.t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("remove is not supported");
        }
    }

    static {
        try {
            d = org.apache.tools.ant.helper.ProjectHelper2.class.getConstructor(new java.lang.Class[0]);
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public ProjectHelperRepository() {
        b();
    }

    public static org.apache.tools.ant.ProjectHelperRepository getInstance() {
        return c;
    }

    public final void b() {
        f(e());
        try {
            java.lang.ClassLoader contextClassLoader = org.apache.tools.ant.util.LoaderUtils.getContextClassLoader();
            if (contextClassLoader != null) {
                java.util.Enumeration<java.net.URL> resources = contextClassLoader.getResources("META-INF/services/org.apache.tools.ant.ProjectHelper");
                while (resources.hasMoreElements()) {
                    java.net.URLConnection openConnection = resources.nextElement().openConnection();
                    openConnection.setUseCaches(false);
                    f(d(openConnection.getInputStream()));
                }
            }
            java.io.InputStream systemResourceAsStream = java.lang.ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.tools.ant.ProjectHelper");
            if (systemResourceAsStream != null) {
                f(d(systemResourceAsStream));
            }
        } catch (java.lang.Exception e) {
            java.lang.System.err.println("Unable to load ProjectHelper from service META-INF/services/org.apache.tools.ant.ProjectHelper (" + e.getClass().getName() + ": " + e.getMessage() + ")");
            if (b) {
                e.printStackTrace(java.lang.System.err);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0010 A[Catch: Exception -> 0x000b, TRY_ENTER, TryCatch #0 {Exception -> 0x000b, blocks: (B:14:0x0006, B:5:0x0010, B:6:0x0014), top: B:13:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper> c(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.Class<?> loadClass;
        java.lang.ClassLoader contextClassLoader = org.apache.tools.ant.util.LoaderUtils.getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                try {
                    loadClass = contextClassLoader.loadClass(str);
                } catch (java.lang.Exception e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (java.lang.ClassNotFoundException unused) {
            }
            if (loadClass == null) {
                loadClass = java.lang.Class.forName(str);
            }
            return loadClass.asSubclass(org.apache.tools.ant.ProjectHelper.class).getConstructor(new java.lang.Class[0]);
        }
        loadClass = null;
        if (loadClass == null) {
        }
        return loadClass.asSubclass(org.apache.tools.ant.ProjectHelper.class).getConstructor(new java.lang.Class[0]);
    }

    public final java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper> d(java.io.InputStream inputStream) {
        java.io.InputStreamReader inputStreamReader;
        try {
            try {
                inputStreamReader = new java.io.InputStreamReader(inputStream, "UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
                inputStreamReader = new java.io.InputStreamReader(inputStream);
            }
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(inputStreamReader);
            java.lang.String readLine = bufferedReader.readLine();
            bufferedReader.close();
            if (readLine == null || "".equals(readLine)) {
                return null;
            }
            return c(readLine);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("Unable to load ProjectHelper from service META-INF/services/org.apache.tools.ant.ProjectHelper (" + e.getMessage() + ")");
            if (!b) {
                return null;
            }
            e.printStackTrace(java.lang.System.err);
            return null;
        }
    }

    public final java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper> e() {
        java.lang.String property = java.lang.System.getProperty("org.apache.tools.ant.ProjectHelper");
        if (property == null) {
            return null;
        }
        try {
            return c(property);
        } catch (java.lang.SecurityException e) {
            java.lang.System.err.println("Unable to load ProjectHelper class \"" + property + " specified in system property org.apache.tools.ant.ProjectHelper (" + e.getMessage() + ")");
            if (!b) {
                return null;
            }
            e.printStackTrace(java.lang.System.err);
            return null;
        }
    }

    public final void f(java.lang.reflect.Constructor<? extends org.apache.tools.ant.ProjectHelper> constructor) {
        if (constructor == null) {
            return;
        }
        if (b) {
            java.lang.System.out.println("ProjectHelper " + constructor.getClass().getName() + " registered.");
        }
        this.a.add(constructor);
    }

    public java.util.Iterator<org.apache.tools.ant.ProjectHelper> getHelpers() {
        return new org.apache.tools.ant.ProjectHelperRepository.ConstructingIterator(this.a.iterator());
    }

    public org.apache.tools.ant.ProjectHelper getProjectHelperForAntlib(org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        java.util.Iterator<org.apache.tools.ant.ProjectHelper> helpers = getHelpers();
        while (helpers.hasNext()) {
            org.apache.tools.ant.ProjectHelper next = helpers.next();
            if (next.canParseAntlibDescriptor(resource)) {
                if (b) {
                    java.lang.System.out.println("ProjectHelper " + next.getClass().getName() + " selected for the antlib " + resource);
                }
                return next;
            }
        }
        throw new org.apache.tools.ant.BuildException("BUG: at least the ProjectHelper2 should have supported the file " + resource);
    }

    public org.apache.tools.ant.ProjectHelper getProjectHelperForBuildFile(org.apache.tools.ant.types.Resource resource) throws org.apache.tools.ant.BuildException {
        java.util.Iterator<org.apache.tools.ant.ProjectHelper> helpers = getHelpers();
        while (helpers.hasNext()) {
            org.apache.tools.ant.ProjectHelper next = helpers.next();
            if (next.canParseBuildFile(resource)) {
                if (b) {
                    java.lang.System.out.println("ProjectHelper " + next.getClass().getName() + " selected for the build file " + resource);
                }
                return next;
            }
        }
        throw new org.apache.tools.ant.BuildException("BUG: at least the ProjectHelper2 should have supported the file " + resource);
    }

    public void registerProjectHelper(java.lang.Class<? extends org.apache.tools.ant.ProjectHelper> cls) throws org.apache.tools.ant.BuildException {
        try {
            f(cls.getConstructor(new java.lang.Class[0]));
        } catch (java.lang.NoSuchMethodException unused) {
            throw new org.apache.tools.ant.BuildException("Couldn't find no-arg constructor in " + cls.getName());
        }
    }

    public void registerProjectHelper(java.lang.String str) throws org.apache.tools.ant.BuildException {
        f(c(str));
    }
}
