package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class JavaEnvUtils {
    public static final java.lang.String JAVA_1_0 = "1.0";
    public static final java.lang.String JAVA_1_1 = "1.1";
    public static final java.lang.String JAVA_1_2 = "1.2";
    public static final java.lang.String JAVA_1_3 = "1.3";
    public static final java.lang.String JAVA_1_4 = "1.4";
    public static final java.lang.String JAVA_1_5 = "1.5";
    public static final java.lang.String JAVA_1_6 = "1.6";
    public static final java.lang.String JAVA_1_7 = "1.7";
    public static final java.lang.String JAVA_1_8 = "1.8";

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_9 = "1.9";
    public static final java.lang.String JAVA_9 = "9";
    public static final int VERSION_1_0 = 10;
    public static final int VERSION_1_1 = 11;
    public static final int VERSION_1_2 = 12;
    public static final int VERSION_1_3 = 13;
    public static final int VERSION_1_4 = 14;
    public static final int VERSION_1_5 = 15;
    public static final int VERSION_1_6 = 16;
    public static final int VERSION_1_7 = 17;
    public static final int VERSION_1_8 = 18;

    @java.lang.Deprecated
    public static final int VERSION_1_9 = 19;
    public static final int VERSION_9 = 90;
    public static final boolean a = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS);
    public static final boolean b = org.apache.tools.ant.taskdefs.condition.Os.isName(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE);
    public static final boolean c = org.apache.tools.ant.taskdefs.condition.Os.isName("aix");
    public static final java.lang.String d = java.lang.System.getProperty("java.home");
    public static final org.apache.tools.ant.util.FileUtils e = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static java.lang.String f;
    public static int g;
    public static final org.apache.tools.ant.util.DeweyDecimal h;
    public static boolean i;
    public static boolean j;
    public static boolean k;
    public static boolean l;
    public static java.util.Vector<java.lang.String> m;

    static {
        try {
            f = "1.1";
            g = 10 + 1;
            java.lang.Class.forName("java.lang.ThreadLocal");
            f = "1.2";
            g++;
            java.lang.Class.forName("java.lang.StrictMath");
            int i2 = g + 1;
            f = "1.4";
            g = i2 + 1;
            java.lang.Class.forName("java.net.Proxy");
            int i3 = g + 1;
            f = JAVA_1_6;
            g = i3 + 1;
            java.lang.Class.forName("java.nio.file.FileSystem");
            f = JAVA_1_7;
            g++;
            java.lang.Class.forName("java.lang.reflect.Executable");
            f = JAVA_1_8;
            g++;
            java.lang.Class.forName("java.lang.module.ModuleDescriptor");
            f = "9";
            g = 90;
            org.apache.tools.ant.util.DeweyDecimal deweyDecimal = new org.apache.tools.ant.util.DeweyDecimal(java.lang.System.getProperty("java.specification.version"));
            g = deweyDecimal.get(0) * 10;
            if (deweyDecimal.getSize() > 1) {
                g += deweyDecimal.get(1);
            }
            f = deweyDecimal.toString();
        } catch (java.lang.Throwable unused) {
        }
        h = new org.apache.tools.ant.util.DeweyDecimal(f);
        i = false;
        try {
            java.lang.Class.forName("kaffe.util.NotImplemented");
            i = true;
        } catch (java.lang.Throwable unused2) {
        }
        j = false;
        try {
            java.lang.Class.forName("gnu.classpath.Configuration");
            j = true;
        } catch (java.lang.Throwable unused3) {
        }
        k = false;
        try {
            java.lang.Class.forName("gnu.gcj.Core");
            k = true;
        } catch (java.lang.Throwable unused4) {
        }
        l = false;
        try {
            java.lang.Class.forName("org.apache.harmony.luni.util.Base64");
            l = true;
        } catch (java.lang.Throwable unused5) {
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(a ? ".exe" : "");
        return sb.toString();
    }

    public static void b() {
        m = new java.util.Vector<>();
        if (isAtLeastJavaVersion("1.1")) {
            m.addElement("sun");
            m.addElement(com.uc.crashsdk.export.LogType.JAVA_TYPE);
            m.addElement("javax");
        }
        if (isAtLeastJavaVersion("1.2")) {
            m.addElement("com.sun.java");
            m.addElement("com.sun.image");
        }
        if (isAtLeastJavaVersion("1.3")) {
            m.addElement("org.omg");
            m.addElement("com.sun.corba");
            m.addElement("com.sun.jndi");
            m.addElement("com.sun.media");
            m.addElement("com.sun.naming");
            m.addElement("com.sun.org.omg");
            m.addElement("com.sun.rmi");
            m.addElement("sunw.io");
            m.addElement("sunw.util");
        }
        if (isAtLeastJavaVersion("1.4")) {
            if (g == 14) {
                m.addElement("org.apache.crimson");
                m.addElement("org.apache.xalan");
                m.addElement("org.apache.xml");
                m.addElement("org.apache.xpath");
            }
            m.addElement("org.ietf.jgss");
            m.addElement("org.w3c.dom");
            m.addElement("org.xml.sax");
        }
        if (isAtLeastJavaVersion(JAVA_1_5)) {
            m.addElement("com.sun.org.apache");
        }
        if (isAtLeastJavaVersion(JAVA_1_7)) {
            m.addElement("jdk");
        }
    }

    public static java.io.File c(java.lang.String str, java.lang.String str2) {
        java.io.File normalize = e.normalize(str);
        if (!normalize.exists()) {
            return null;
        }
        java.io.File file = new java.io.File(normalize, a(str2));
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static java.io.File createVmsJavaOptionFile(java.lang.String[] strArr) throws java.io.IOException {
        java.io.File createTempFile = e.createTempFile(null, "ANT", ".JAVA_OPTS", null, false, true);
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile));
            for (java.lang.String str : strArr) {
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.newLine();
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    throw th;
                }
            }
            org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
            return createTempFile;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.lang.String getJavaHome() {
        return d;
    }

    public static java.lang.String getJavaVersion() {
        return f;
    }

    @java.lang.Deprecated
    public static int getJavaVersionNumber() {
        return g;
    }

    public static java.lang.String getJdkExecutable(java.lang.String str) {
        java.io.File file;
        if (b) {
            return str;
        }
        if (c) {
            file = c(d + "/../sh", str);
        } else {
            file = null;
        }
        if (file == null) {
            file = c(d + "/../bin", str);
        }
        return file != null ? file.getAbsolutePath() : getJreExecutable(str);
    }

    public static java.lang.String getJreExecutable(java.lang.String str) {
        java.io.File file;
        if (b) {
            return str;
        }
        if (c) {
            file = c(d + "/sh", str);
        } else {
            file = null;
        }
        if (file == null) {
            file = c(d + "/bin", str);
        }
        return file != null ? file.getAbsolutePath() : a(str);
    }

    public static java.util.Vector<java.lang.String> getJrePackageTestCases() {
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
        vector.addElement("java.lang.Object");
        if (isAtLeastJavaVersion("1.1")) {
            vector.addElement("sun.reflect.SerializationConstructorAccessorImpl");
            vector.addElement("sun.net.www.http.HttpClient");
            vector.addElement("sun.audio.AudioPlayer");
        }
        if (isAtLeastJavaVersion("1.2")) {
            vector.addElement("javax.accessibility.Accessible");
            vector.addElement("sun.misc.BASE64Encoder");
            vector.addElement("com.sun.image.codec.jpeg.JPEGCodec");
        }
        if (isAtLeastJavaVersion("1.3")) {
            vector.addElement("org.omg.CORBA.Any");
            vector.addElement("com.sun.corba.se.internal.corba.AnyImpl");
            vector.addElement("com.sun.jndi.ldap.LdapURL");
            vector.addElement("com.sun.media.sound.Printer");
            vector.addElement("com.sun.naming.internal.VersionHelper");
            vector.addElement("com.sun.org.omg.CORBA.Initializer");
            vector.addElement("sunw.io.Serializable");
            vector.addElement("sunw.util.EventListener");
        }
        if (isAtLeastJavaVersion("1.4")) {
            vector.addElement("sun.audio.AudioPlayer");
            if (g == 14) {
                vector.addElement("org.apache.crimson.parser.ContentModel");
                vector.addElement("org.apache.xalan.processor.ProcessorImport");
                vector.addElement("org.apache.xml.utils.URI");
                vector.addElement("org.apache.xpath.XPathFactory");
            }
            vector.addElement("org.ietf.jgss.Oid");
            vector.addElement("org.w3c.dom.Attr");
            vector.addElement("org.xml.sax.XMLReader");
        }
        if (isAtLeastJavaVersion(JAVA_1_5)) {
            vector.addElement("com.sun.org.apache.xerces.internal.jaxp.datatype.DatatypeFactoryImpl");
        }
        if (isAtLeastJavaVersion(JAVA_1_7)) {
            vector.addElement("jdk.net.Sockets");
        }
        return vector;
    }

    public static java.util.Vector<java.lang.String> getJrePackages() {
        if (m == null) {
            b();
        }
        return m;
    }

    public static org.apache.tools.ant.util.DeweyDecimal getParsedJavaVersion() {
        return h;
    }

    public static boolean isApacheHarmony() {
        return l;
    }

    public static boolean isAtLeastJavaVersion(java.lang.String str) {
        return h.compareTo(new org.apache.tools.ant.util.DeweyDecimal(str)) >= 0;
    }

    public static boolean isClasspathBased() {
        return j;
    }

    public static boolean isGij() {
        return k;
    }

    public static boolean isJavaVersion(java.lang.String str) {
        return f.equals(str) || (f.equals("9") && JAVA_1_9.equals(str));
    }

    public static boolean isKaffe() {
        return i;
    }
}
