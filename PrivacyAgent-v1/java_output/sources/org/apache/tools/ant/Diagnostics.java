package org.apache.tools.ant;

/* loaded from: classes25.dex */
public final class Diagnostics {
    protected static final java.lang.String ERROR_PROPERTY_ACCESS_BLOCKED = "Access to this property blocked by a security manager";

    /* renamed from: org.apache.tools.ant.Diagnostics$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return str.endsWith(".jar");
        }
    }

    public static void A(java.io.PrintStream printStream, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str2 == null) {
            str2 = "unknown";
        }
        if (str3 == null) {
            str3 = "unknown";
        }
        printStream.println(str + " : " + str2);
        printStream.println(str + " Location: " + str3);
    }

    public static void B(java.io.PrintStream printStream, java.lang.String str) {
        java.lang.String p = p(str);
        if (p != null) {
            printStream.print(str);
            printStream.print(" = ");
            printStream.print(kotlin.text.Typography.quote);
            printStream.print(p);
            printStream.println(kotlin.text.Typography.quote);
        }
    }

    public static void a(java.io.PrintStream printStream) {
        printStream.println("ant.home: " + java.lang.System.getProperty("ant.home"));
        z(listLibraries(), printStream);
    }

    public static void b(java.io.PrintStream printStream) {
        org.apache.tools.ant.Project project = new org.apache.tools.ant.Project();
        project.initProperties();
        printStream.println("ant.version: " + project.getProperty(org.apache.tools.ant.MagicNames.ANT_VERSION));
        printStream.println("ant.java.version: " + project.getProperty(org.apache.tools.ant.MagicNames.ANT_JAVA_VERSION));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Is this the Apache Harmony VM? ");
        sb.append(org.apache.tools.ant.util.JavaEnvUtils.isApacheHarmony() ? "yes" : "no");
        printStream.println(sb.toString());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Is this the Kaffe VM? ");
        sb2.append(org.apache.tools.ant.util.JavaEnvUtils.isKaffe() ? "yes" : "no");
        printStream.println(sb2.toString());
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("Is this gij/gcj? ");
        sb3.append(org.apache.tools.ant.util.JavaEnvUtils.isGij() ? "yes" : "no");
        printStream.println(sb3.toString());
        printStream.println("ant.core.lib: " + project.getProperty(org.apache.tools.ant.MagicNames.ANT_LIB));
        printStream.println("ant.home: " + project.getProperty("ant.home"));
    }

    public static void c(java.io.PrintStream printStream) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        java.util.TimeZone timeZone = calendar.getTimeZone();
        printStream.println("Timezone " + timeZone.getDisplayName() + " offset=" + timeZone.getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), (((((calendar.get(11) * 60) + calendar.get(12)) * 60) + calendar.get(13)) * 1000) + calendar.get(14)));
    }

    public static void d(java.io.PrintStream printStream) {
        A(printStream, "XML Parser", s(), r());
        A(printStream, "Namespace-aware parser", o(), n());
    }

    public static void doReport(java.io.PrintStream printStream) {
        doReport(printStream, 2);
    }

    public static void doReport(java.io.PrintStream printStream, int i) {
        printStream.println("------- Ant diagnostics report -------");
        printStream.println(org.apache.tools.ant.Main.getAntVersion());
        w(printStream, "Implementation Version");
        printStream.println("core tasks     : " + m(org.apache.tools.ant.Main.class) + " in " + l(org.apache.tools.ant.Main.class));
        w(printStream, "ANT PROPERTIES");
        b(printStream);
        w(printStream, "ANT_HOME/lib jar listing");
        a(printStream);
        w(printStream, "USER_HOME/.ant/lib jar listing");
        i(printStream);
        w(printStream, "Tasks availability");
        g(printStream);
        w(printStream, "org.apache.env.Which diagnostics");
        j(printStream);
        w(printStream, "XML Parser information");
        d(printStream);
        w(printStream, "XSLT Processor information");
        k(printStream);
        w(printStream, "System properties");
        f(printStream);
        w(printStream, "Temp dir");
        h(printStream);
        w(printStream, "Locale information");
        c(printStream);
        w(printStream, "Proxy information");
        e(printStream);
        printStream.println();
    }

    public static void e(java.io.PrintStream printStream) {
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_HOST);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PORT);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_USERNAME);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTP_PROXY_PASSWORD);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTP_NON_PROXY_HOSTS);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_HOST);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_PORT);
        B(printStream, org.apache.tools.ant.util.ProxySetup.HTTPS_NON_PROXY_HOSTS);
        B(printStream, org.apache.tools.ant.util.ProxySetup.FTP_PROXY_HOST);
        B(printStream, org.apache.tools.ant.util.ProxySetup.FTP_PROXY_PORT);
        B(printStream, org.apache.tools.ant.util.ProxySetup.FTP_NON_PROXY_HOSTS);
        B(printStream, org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_HOST);
        B(printStream, org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PORT);
        B(printStream, org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_USERNAME);
        B(printStream, org.apache.tools.ant.util.ProxySetup.SOCKS_PROXY_PASSWORD);
        if (org.apache.tools.ant.util.JavaEnvUtils.getJavaVersionNumber() < 15) {
            return;
        }
        B(printStream, org.apache.tools.ant.util.ProxySetup.USE_SYSTEM_PROXIES);
        try {
            java.lang.Object newInstance = org.apache.tools.ant.util.java15.ProxyDiagnostics.class.newInstance();
            printStream.println("Java1.5+ proxy settings:");
            printStream.println(newInstance.toString());
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoClassDefFoundError unused) {
        }
    }

    public static void f(java.io.PrintStream printStream) {
        try {
            java.util.Enumeration<?> propertyNames = java.lang.System.getProperties().propertyNames();
            while (propertyNames.hasMoreElements()) {
                java.lang.String str = (java.lang.String) propertyNames.nextElement();
                printStream.println(str + " : " + p(str));
            }
        } catch (java.lang.SecurityException e) {
            x(e);
            printStream.println("Access to System.getProperties() blocked by a security manager");
        }
    }

    public static void g(java.io.PrintStream printStream) {
        java.io.InputStream resourceAsStream = org.apache.tools.ant.Main.class.getResourceAsStream(org.apache.tools.ant.MagicNames.TASKDEF_PROPERTIES_RESOURCE);
        if (resourceAsStream == null) {
            printStream.println("None available");
            return;
        }
        java.util.Properties properties = new java.util.Properties();
        try {
            properties.load(resourceAsStream);
            java.util.Enumeration keys = properties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str = (java.lang.String) keys.nextElement();
                try {
                    try {
                        java.lang.Class.forName(properties.getProperty(str));
                        properties.remove(str);
                    } catch (java.lang.NoClassDefFoundError e) {
                        printStream.println(str + " : Missing dependency " + e.getMessage().replace('/', '.'));
                    }
                } catch (java.lang.ClassNotFoundException unused) {
                    printStream.println(str + " : Not Available (the implementation class is not present)");
                } catch (java.lang.LinkageError unused2) {
                    printStream.println(str + " : Initialization error");
                }
            }
            if (properties.size() == 0) {
                printStream.println("All defined tasks are available");
            } else {
                printStream.println("A task being missing/unavailable should only matter if you are trying to use it");
            }
        } catch (java.io.IOException e2) {
            printStream.println(e2.getMessage());
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x012b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:91:0x012a */
    /* JADX WARN: Removed duplicated region for block: B:64:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void h(java.io.PrintStream printStream) {
        java.io.File file;
        java.io.FileInputStream fileInputStream;
        java.io.File file2;
        java.io.FileInputStream fileInputStream2;
        java.io.FileOutputStream fileOutputStream;
        java.io.FileInputStream fileInputStream3;
        java.lang.String property = java.lang.System.getProperty("java.io.tmpdir");
        if (property == null) {
            printStream.println("Warning: java.io.tmpdir is undefined");
            return;
        }
        printStream.println("Temp dir is " + property);
        java.io.File file3 = new java.io.File(property);
        if (!file3.exists()) {
            printStream.println("Warning, java.io.tmpdir directory does not exist: " + property);
            return;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.io.FileOutputStream fileOutputStream2 = null;
        r4 = null;
        r4 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        java.io.File file4 = null;
        java.io.FileOutputStream fileOutputStream3 = null;
        try {
            try {
                file2 = java.io.File.createTempFile("diag", "txt", file3);
            } catch (java.lang.Throwable th) {
                th = th;
                file = file3;
                fileInputStream = fileInputStream3;
            }
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
            } catch (java.io.IOException e) {
                e = e;
                fileOutputStream = null;
                file4 = file2;
                fileInputStream = null;
            } catch (java.lang.InterruptedException e2) {
                e = e2;
                fileInputStream2 = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                file = file2;
                fileInputStream = null;
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                if (file != null) {
                    file.delete();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                for (int i = 0; i < 32; i++) {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.close();
                java.lang.Thread.sleep(1000L);
                fileInputStream2 = new java.io.FileInputStream(file2);
                int i2 = 0;
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            i2 += read;
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        file4 = file2;
                        fileInputStream = fileInputStream2;
                        fileOutputStream = null;
                        try {
                            x(e);
                            printStream.println("Failed to create a temporary file in the temp dir " + property);
                            printStream.println("File  " + file4 + " could not be created/written to");
                            org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                            if (file4 == null || !file4.exists()) {
                                return;
                            }
                            file4.delete();
                            return;
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            file = file4;
                            fileOutputStream2 = fileOutputStream;
                            org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
                            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                            if (file != null && file.exists()) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (java.lang.InterruptedException e4) {
                        e = e4;
                        x(e);
                        printStream.println("Failed to check whether tempdir is writable");
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream3);
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                        if (file2 == null || !file2.exists()) {
                            return;
                        }
                        file2.delete();
                    }
                }
                fileInputStream2.close();
                long lastModified = file2.lastModified() - currentTimeMillis;
                file2.delete();
                printStream.print("Temp dir is writeable");
                if (i2 != 32768) {
                    printStream.println(", but seems to be full.  Wrote 32768but could only read " + i2 + " bytes.");
                } else {
                    printStream.println();
                }
                printStream.println("Temp dir alignment with system clock is " + lastModified + " ms");
                if (java.lang.Math.abs(lastModified) > 10000) {
                    printStream.println("Warning: big clock drift -maybe a network filesystem");
                }
                org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
                org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
                if (!file2.exists()) {
                    return;
                }
            } catch (java.io.IOException e5) {
                e = e5;
                file4 = file2;
                fileInputStream = null;
            } catch (java.lang.InterruptedException e6) {
                e = e6;
                fileInputStream2 = null;
                fileOutputStream3 = fileOutputStream;
            } catch (java.lang.Throwable th4) {
                th = th4;
                file = file2;
                fileInputStream = null;
                fileOutputStream2 = fileOutputStream;
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                if (file != null) {
                }
                throw th;
            }
        } catch (java.io.IOException e7) {
            e = e7;
            fileInputStream = null;
            fileOutputStream = null;
        } catch (java.lang.InterruptedException e8) {
            e = e8;
            file2 = null;
            fileInputStream2 = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            file = null;
            fileInputStream = null;
        }
        file2.delete();
    }

    public static void i(java.io.PrintStream printStream) {
        java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR);
        printStream.println("user.home: " + property);
        z(y(new java.io.File(property, org.apache.tools.ant.launch.Launcher.USER_LIBDIR)), printStream);
    }

    @java.lang.Deprecated
    public static boolean isOptionalAvailable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.reflect.InvocationTargetException] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static void j(java.io.PrintStream printStream) {
        ?? e = 0;
        e = 0;
        try {
            java.lang.Class.forName("org.apache.env.Which").getMethod("main", java.lang.String[].class).invoke(null, new java.lang.String[0]);
        } catch (java.lang.ClassNotFoundException unused) {
            printStream.println("Not available.");
            printStream.println("Download it at http://xml.apache.org/commons/");
        } catch (java.lang.reflect.InvocationTargetException e2) {
            e = e2;
            if (e.getTargetException() != null) {
                e = e.getTargetException();
            }
        } catch (java.lang.Throwable th) {
            e = th;
        }
        if (e != 0) {
            printStream.println("Error while running org.apache.env.Which");
            e.printStackTrace(printStream);
        }
    }

    public static void k(java.io.PrintStream printStream) {
        A(printStream, "XSLT Processor", v(), u());
    }

    public static java.net.URL l(java.lang.Class<?> cls) {
        if (cls.getProtectionDomain().getCodeSource() == null) {
            return null;
        }
        return cls.getProtectionDomain().getCodeSource().getLocation();
    }

    public static java.io.File[] listLibraries() {
        java.lang.String property = java.lang.System.getProperty("ant.home");
        if (property == null) {
            return null;
        }
        return y(new java.io.File(property, "lib"));
    }

    public static java.lang.String m(java.lang.Class<?> cls) {
        return cls.getPackage().getImplementationVersion();
    }

    public static void main(java.lang.String[] strArr) {
        doReport(java.lang.System.out);
    }

    public static java.lang.String n() {
        try {
            java.net.URL l = l(org.apache.tools.ant.util.JAXPUtils.getNamespaceXMLReader().getClass());
            if (l != null) {
                return l.toString();
            }
            return null;
        } catch (org.apache.tools.ant.BuildException e) {
            x(e);
            return null;
        }
    }

    public static java.lang.String o() {
        try {
            return org.apache.tools.ant.util.JAXPUtils.getNamespaceXMLReader().getClass().getName();
        } catch (org.apache.tools.ant.BuildException e) {
            x(e);
            return null;
        }
    }

    public static java.lang.String p(java.lang.String str) {
        try {
            return java.lang.System.getProperty(str);
        } catch (java.lang.SecurityException unused) {
            return ERROR_PROPERTY_ACCESS_BLOCKED;
        }
    }

    public static javax.xml.parsers.SAXParser q() {
        try {
            try {
                return javax.xml.parsers.SAXParserFactory.newInstance().newSAXParser();
            } catch (java.lang.Exception e) {
                x(e);
                return null;
            }
        } catch (java.lang.Exception e2) {
            x(e2);
            return null;
        }
    }

    public static java.lang.String r() {
        java.net.URL l;
        javax.xml.parsers.SAXParser q = q();
        if (q == null || (l = l(q.getClass())) == null) {
            return null;
        }
        return l.toString();
    }

    public static java.lang.String s() {
        javax.xml.parsers.SAXParser q = q();
        return q == null ? "Could not create an XML Parser" : q.getClass().getName();
    }

    public static javax.xml.transform.Transformer t() {
        javax.xml.transform.TransformerFactory newInstance = javax.xml.transform.TransformerFactory.newInstance();
        if (newInstance == null) {
            return null;
        }
        try {
            return newInstance.newTransformer();
        } catch (java.lang.Exception e) {
            x(e);
            return null;
        }
    }

    public static java.lang.String u() {
        java.net.URL l;
        javax.xml.transform.Transformer t = t();
        if (t == null || (l = l(t.getClass())) == null) {
            return null;
        }
        return l.toString();
    }

    public static java.lang.String v() {
        javax.xml.transform.Transformer t = t();
        return t == null ? "Could not create an XSLT Processor" : t.getClass().getName();
    }

    @java.lang.Deprecated
    public static void validateVersion() throws org.apache.tools.ant.BuildException {
    }

    public static void w(java.io.PrintStream printStream, java.lang.String str) {
        printStream.println();
        printStream.println("-------------------------------------------");
        printStream.print(" ");
        printStream.println(str);
        printStream.println("-------------------------------------------");
    }

    public static void x(java.lang.Throwable th) {
    }

    public static java.io.File[] y(java.io.File file) {
        return file.listFiles(new org.apache.tools.ant.Diagnostics.AnonymousClass1());
    }

    public static void z(java.io.File[] fileArr, java.io.PrintStream printStream) {
        if (fileArr == null) {
            printStream.println("No such directory.");
            return;
        }
        for (java.io.File file : fileArr) {
            printStream.println(file.getName() + " (" + file.length() + " bytes)");
        }
    }
}
