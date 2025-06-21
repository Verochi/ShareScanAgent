package org.apache.tools.ant.launch;

/* loaded from: classes25.dex */
public class Launcher {
    public static final java.lang.String ANTHOME_PROPERTY = "ant.home";
    public static final java.lang.String ANTLIBDIR_PROPERTY = "ant.library.dir";
    public static final java.lang.String ANT_PRIVATELIB = "lib";
    protected static final int EXIT_CODE_ERROR = 2;
    public static final java.lang.String MAIN_CLASS = "org.apache.tools.ant.Main";
    public static final java.lang.String USER_HOMEDIR = "user.home";
    public boolean launchDiag = false;
    public static final java.lang.String ANT_PRIVATEDIR = ".ant";
    public static final java.lang.String USER_LIBDIR = ANT_PRIVATEDIR + java.io.File.separatorChar + "lib";

    public static void main(java.lang.String[] strArr) {
        int i = 2;
        boolean z = false;
        try {
            org.apache.tools.ant.launch.Launcher launcher = new org.apache.tools.ant.launch.Launcher();
            int g = launcher.g(strArr);
            z = launcher.launchDiag;
            i = g;
        } catch (org.apache.tools.ant.launch.LaunchException e) {
            java.lang.System.err.println(e.getMessage());
        } catch (java.lang.Throwable th) {
            th.printStackTrace(java.lang.System.err);
        }
        if (i != 0) {
            if (z) {
                java.lang.System.out.println("Exit code: " + i);
            }
            java.lang.System.exit(i);
        }
    }

    public final void a(java.lang.String str, boolean z, java.util.List<java.net.URL> list) throws java.net.MalformedURLException {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, java.io.File.pathSeparator);
        while (stringTokenizer.hasMoreElements()) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            java.io.File file = new java.io.File(nextToken);
            if (nextToken.indexOf(37) == -1 || file.exists()) {
                if (z && file.isDirectory()) {
                    for (java.net.URL url : org.apache.tools.ant.launch.Locator.getLocationURLs(file)) {
                        if (this.launchDiag) {
                            java.lang.System.out.println("adding library JAR: " + url);
                        }
                        list.add(url);
                    }
                }
                java.net.URL fileToURL = org.apache.tools.ant.launch.Locator.fileToURL(file);
                if (this.launchDiag) {
                    java.lang.System.out.println("adding library URL: " + fileToURL);
                }
                list.add(fileToURL);
            }
        }
    }

    public final java.net.URL[] b(java.net.URL[] urlArr, java.net.URL[] urlArr2, java.net.URL[] urlArr3, java.io.File file) throws java.net.MalformedURLException {
        int length = urlArr.length + urlArr2.length + urlArr3.length;
        if (file != null) {
            length++;
        }
        java.net.URL[] urlArr4 = new java.net.URL[length];
        java.lang.System.arraycopy(urlArr, 0, urlArr4, 0, urlArr.length);
        java.lang.System.arraycopy(urlArr2, 0, urlArr4, urlArr.length, urlArr2.length);
        java.lang.System.arraycopy(urlArr3, 0, urlArr4, urlArr2.length + urlArr.length, urlArr3.length);
        if (file != null) {
            urlArr4[length - 1] = org.apache.tools.ant.launch.Locator.fileToURL(file);
        }
        return urlArr4;
    }

    public final java.net.URL[] c(java.lang.String str, java.util.List<java.lang.String> list) throws java.net.MalformedURLException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null) {
            a(str, false, arrayList);
        }
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            a(it.next(), true, arrayList);
        }
        return (java.net.URL[]) arrayList.toArray(new java.net.URL[arrayList.size()]);
    }

    public final java.net.URL[] d(java.io.File file) throws java.net.MalformedURLException {
        java.lang.String property = java.lang.System.getProperty(ANTLIBDIR_PROPERTY);
        java.io.File file2 = property != null ? new java.io.File(property) : null;
        if (file2 == null || !file2.exists()) {
            h(ANTLIBDIR_PROPERTY, file.getAbsolutePath());
        } else {
            file = file2;
        }
        return org.apache.tools.ant.launch.Locator.getLocationURLs(file);
    }

    public final java.net.URL[] e() throws java.net.MalformedURLException {
        return org.apache.tools.ant.launch.Locator.getLocationURLs(new java.io.File(java.lang.System.getProperty(USER_HOMEDIR), USER_LIBDIR));
    }

    public final void f(java.lang.String str, java.io.File file) {
        if (this.launchDiag) {
            java.lang.System.out.println(str + "= \"" + file + "\"");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(java.lang.String[] strArr) throws org.apache.tools.ant.launch.LaunchException, java.net.MalformedURLException {
        java.lang.Throwable th;
        java.lang.Class<?> cls;
        java.lang.String[] strArr2 = strArr;
        java.lang.String property = java.lang.System.getProperty("ant.home");
        java.io.File classSource = org.apache.tools.ant.launch.Locator.getClassSource(getClass());
        java.io.File parentFile = classSource.getParentFile();
        java.io.File file = property != null ? new java.io.File(property) : null;
        if (file == null || !file.exists()) {
            file = parentFile.getParentFile();
            h("ant.home", file.getAbsolutePath());
        }
        if (!file.exists()) {
            throw new org.apache.tools.ant.launch.LaunchException("Ant home is set incorrectly or ant could not be located (estimated value=" + file.getAbsolutePath() + ")");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.lang.String str = MAIN_CLASS;
        int i = 0;
        boolean z = false;
        java.lang.String str2 = null;
        boolean z2 = false;
        while (i < strArr2.length) {
            if (strArr2[i].equals("-lib")) {
                if (i == strArr2.length - 1) {
                    throw new org.apache.tools.ant.launch.LaunchException("The -lib argument must be followed by a library location");
                }
                i++;
                arrayList.add(strArr2[i]);
            } else if (strArr2[i].equals("-cp")) {
                if (i == strArr2.length - 1) {
                    throw new org.apache.tools.ant.launch.LaunchException("The -cp argument must be followed by a classpath expression");
                }
                if (str2 != null) {
                    throw new org.apache.tools.ant.launch.LaunchException("The -cp argument must not be repeated");
                }
                i++;
                str2 = strArr2[i];
            } else if (strArr2[i].equals("--nouserlib") || strArr2[i].equals("-nouserlib")) {
                z2 = true;
            } else if (strArr2[i].equals("--launchdiag")) {
                this.launchDiag = true;
            } else if (strArr2[i].equals("--noclasspath") || strArr2[i].equals("-noclasspath")) {
                z = true;
            } else if (!strArr2[i].equals("-main")) {
                arrayList2.add(strArr2[i]);
            } else {
                if (i == strArr2.length - 1) {
                    throw new org.apache.tools.ant.launch.LaunchException("The -main argument must be followed by a library location");
                }
                i++;
                str = strArr2[i];
            }
            i++;
        }
        f("Launcher JAR", classSource);
        f("Launcher JAR directory", classSource.getParentFile());
        f("java.home", new java.io.File(java.lang.System.getProperty("java.home")));
        if (arrayList2.size() != strArr2.length) {
            strArr2 = (java.lang.String[]) arrayList2.toArray(new java.lang.String[arrayList2.size()]);
        }
        if (z) {
            str2 = null;
        }
        java.net.URL[] c = c(str2, arrayList);
        java.net.URL[] d = d(parentFile);
        java.net.URL[] e = z2 ? new java.net.URL[0] : e();
        java.io.File toolsJar = org.apache.tools.ant.launch.Locator.getToolsJar();
        f("tools.jar", toolsJar);
        java.net.URL[] b = b(c, e, d, toolsJar);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(java.lang.System.getProperty("java.class.path"));
        if (stringBuffer.charAt(stringBuffer.length() - 1) == java.io.File.pathSeparatorChar) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        for (java.net.URL url : b) {
            stringBuffer.append(java.io.File.pathSeparatorChar);
            stringBuffer.append(org.apache.tools.ant.launch.Locator.fromURI(url.toString()));
        }
        h("java.class.path", stringBuffer.toString());
        java.net.URLClassLoader uRLClassLoader = new java.net.URLClassLoader(b, org.apache.tools.ant.launch.Launcher.class.getClassLoader());
        java.lang.Thread.currentThread().setContextClassLoader(uRLClassLoader);
        try {
            try {
                cls = uRLClassLoader.loadClass(str);
                try {
                    ((org.apache.tools.ant.launch.AntMain) cls.newInstance()).startAnt(strArr2, null, null);
                    th = null;
                } catch (java.lang.InstantiationException e2) {
                    th = e2;
                    java.lang.System.err.println("Incompatible version of " + str + " detected");
                    java.lang.System.err.println("Location of this class " + org.apache.tools.ant.launch.Locator.getClassSource(cls));
                    if (th != null) {
                    }
                }
            } catch (java.lang.InstantiationException e3) {
                th = e3;
                cls = null;
            }
        } catch (java.lang.ClassNotFoundException e4) {
            th = e4;
            java.lang.System.err.println("Failed to locate" + str);
        } catch (java.lang.Throwable th2) {
            th = th2;
            th.printStackTrace(java.lang.System.err);
        }
        if (th != null) {
            return 0;
        }
        java.lang.System.err.println("ant.home: " + file.getAbsolutePath());
        java.lang.System.err.println("Classpath: " + stringBuffer.toString());
        java.lang.System.err.println("Launcher JAR: " + classSource.getAbsolutePath());
        java.lang.System.err.println("Launcher Directory: " + parentFile.getAbsolutePath());
        return 2;
    }

    public final void h(java.lang.String str, java.lang.String str2) {
        if (this.launchDiag) {
            java.lang.System.out.println("Setting \"" + str + "\" to \"" + str2 + "\"");
        }
        java.lang.System.setProperty(str, str2);
    }
}
