package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ArgumentProcessorRegistry {
    public static final boolean b = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(java.lang.System.getProperty("ant.argument-processor-repo.debug"));
    public static org.apache.tools.ant.ArgumentProcessorRegistry c = new org.apache.tools.ant.ArgumentProcessorRegistry();
    public java.util.List<org.apache.tools.ant.ArgumentProcessor> a = new java.util.ArrayList();

    public ArgumentProcessorRegistry() {
        a();
    }

    public static org.apache.tools.ant.ArgumentProcessorRegistry getInstance() {
        return c;
    }

    public final void a() {
        try {
            java.lang.ClassLoader contextClassLoader = org.apache.tools.ant.util.LoaderUtils.getContextClassLoader();
            if (contextClassLoader != null) {
                java.util.Enumeration<java.net.URL> resources = contextClassLoader.getResources("META-INF/services/org.apache.tools.ant.ArgumentProcessor");
                while (resources.hasMoreElements()) {
                    java.net.URLConnection openConnection = resources.nextElement().openConnection();
                    openConnection.setUseCaches(false);
                    registerArgumentProcessor(d(openConnection.getInputStream()));
                }
            }
            java.io.InputStream systemResourceAsStream = java.lang.ClassLoader.getSystemResourceAsStream("META-INF/services/org.apache.tools.ant.ArgumentProcessor");
            if (systemResourceAsStream != null) {
                registerArgumentProcessor(d(systemResourceAsStream));
            }
        } catch (java.lang.Exception e) {
            java.lang.System.err.println("Unable to load ArgumentProcessor from service META-INF/services/org.apache.tools.ant.ArgumentProcessor (" + e.getClass().getName() + ": " + e.getMessage() + ")");
            if (b) {
                e.printStackTrace(java.lang.System.err);
            }
        }
    }

    public final org.apache.tools.ant.ArgumentProcessor b(java.lang.Class<? extends org.apache.tools.ant.ArgumentProcessor> cls) {
        try {
            return cls.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("The argument processor class" + cls.getClass().getName() + " could not be instantiated with a default constructor", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final org.apache.tools.ant.ArgumentProcessor c(java.lang.String str) {
        try {
            return b(java.lang.Class.forName(str));
        } catch (java.lang.ClassNotFoundException e) {
            throw new org.apache.tools.ant.BuildException("Argument processor class " + str + " was not found", e);
        }
    }

    public final org.apache.tools.ant.ArgumentProcessor d(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.InputStreamReader inputStreamReader;
        java.io.InputStreamReader inputStreamReader2 = null;
        try {
            try {
                inputStreamReader = new java.io.InputStreamReader(inputStream, "UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
                inputStreamReader = new java.io.InputStreamReader(inputStream);
            }
        } catch (java.lang.Throwable th) {
            th = th;
            org.apache.tools.ant.util.FileUtils.close(inputStreamReader2);
            throw th;
        }
        try {
            java.lang.String readLine = new java.io.BufferedReader(inputStreamReader).readLine();
            if (readLine == null || "".equals(readLine)) {
                org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                return null;
            }
            org.apache.tools.ant.ArgumentProcessor c2 = c(readLine);
            org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
            return c2;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStreamReader2 = inputStreamReader;
            org.apache.tools.ant.util.FileUtils.close(inputStreamReader2);
            throw th;
        }
    }

    public java.util.List<org.apache.tools.ant.ArgumentProcessor> getProcessors() {
        return this.a;
    }

    public void registerArgumentProcessor(java.lang.Class<? extends org.apache.tools.ant.ArgumentProcessor> cls) throws org.apache.tools.ant.BuildException {
        registerArgumentProcessor(b(cls));
    }

    public void registerArgumentProcessor(java.lang.String str) throws org.apache.tools.ant.BuildException {
        registerArgumentProcessor(c(str));
    }

    public void registerArgumentProcessor(org.apache.tools.ant.ArgumentProcessor argumentProcessor) {
        if (argumentProcessor == null) {
            return;
        }
        this.a.add(argumentProcessor);
        if (b) {
            java.lang.System.out.println("Argument processor " + argumentProcessor.getClass().getName() + " registered.");
        }
    }
}
