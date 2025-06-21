package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class Main implements org.apache.tools.ant.launch.AntMain {
    public static final java.lang.String DEFAULT_BUILD_FILENAME = "build.xml";
    public static final java.util.Set<java.lang.String> u = java.util.Collections.unmodifiableSet(new java.util.HashSet(java.util.Arrays.asList("-lib", "-cp", "-noclasspath", "--noclasspath", "-nouserlib", "-main")));
    public static final org.apache.tools.ant.property.GetProperty v = new org.apache.tools.ant.Main.AnonymousClass1();
    public static java.lang.String w = null;
    public static java.lang.String x = null;
    public java.io.File b;
    public int a = 2;
    public java.io.PrintStream c = java.lang.System.out;
    public java.io.PrintStream d = java.lang.System.err;
    public final java.util.Vector<java.lang.String> e = new java.util.Vector<>();
    public final java.util.Properties f = new java.util.Properties();
    public final java.util.Vector<java.lang.String> g = new java.util.Vector<>(1);
    public final java.util.Vector<java.lang.String> h = new java.util.Vector<>(1);
    public boolean i = true;
    public boolean j = false;
    public java.lang.String k = null;
    public java.lang.String l = null;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public java.lang.Integer r = null;

    /* renamed from: s, reason: collision with root package name */
    public boolean f503s = false;
    public final java.util.Map<java.lang.Class<?>, java.util.List<java.lang.String>> t = new java.util.HashMap();

    /* renamed from: org.apache.tools.ant.Main$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.tools.ant.property.GetProperty {
        @Override // org.apache.tools.ant.property.GetProperty
        public java.lang.Object getProperty(java.lang.String str) {
            return null;
        }
    }

    public Main() {
    }

    @java.lang.Deprecated
    public Main(java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        u(strArr);
    }

    public static int d(java.util.Vector<java.lang.String> vector, java.lang.String str) {
        int size = vector.size();
        int i = size;
        for (int i2 = 0; i2 < size && i == size; i2++) {
            if (str.compareTo(vector.elementAt(i2)) < 0) {
                i = i2;
            }
        }
        return i;
    }

    public static synchronized java.lang.String getAntVersion() throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        synchronized (org.apache.tools.ant.Main.class) {
            if (w == null) {
                try {
                    java.util.Properties properties = new java.util.Properties();
                    java.io.InputStream resourceAsStream = org.apache.tools.ant.Main.class.getResourceAsStream("/org/apache/tools/ant/version.txt");
                    properties.load(resourceAsStream);
                    resourceAsStream.close();
                    x = properties.getProperty("VERSION");
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    stringBuffer.append("Apache Ant(TM) version ");
                    stringBuffer.append(x);
                    stringBuffer.append(" compiled on ");
                    stringBuffer.append(properties.getProperty("DATE"));
                    w = stringBuffer.toString();
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("Could not load the version information:" + e.getMessage());
                } catch (java.lang.NullPointerException unused) {
                    throw new org.apache.tools.ant.BuildException("Could not load the version information.");
                }
            }
            str = w;
        }
        return str;
    }

    public static java.lang.String getShortAntVersion() throws org.apache.tools.ant.BuildException {
        if (x == null) {
            getAntVersion();
        }
        return x;
    }

    public static void main(java.lang.String[] strArr) {
        start(strArr, null, null);
    }

    public static void o(org.apache.tools.ant.Project project) {
        if (project.getDescription() != null) {
            project.log(project.getDescription());
        }
    }

    public static void p(java.lang.Throwable th) {
        java.lang.String message = th.getMessage();
        if (message != null) {
            java.lang.System.err.println(message);
        }
    }

    public static void q(org.apache.tools.ant.Project project, java.util.Vector<java.lang.String> vector, java.util.Vector<java.lang.String> vector2, java.util.Vector<java.util.Enumeration<java.lang.String>> vector3, java.lang.String str, int i) {
        java.lang.String property = java.lang.System.getProperty("line.separator");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("    ");
        while (sb.length() <= i) {
            sb.append((java.lang.CharSequence) sb);
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append(property);
        sb2.append(property);
        int size = vector.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb2.append(" ");
            sb2.append(vector.elementAt(i2));
            if (vector2 != null) {
                sb2.append(sb.substring(0, (i - vector.elementAt(i2).length()) + 2));
                sb2.append(vector2.elementAt(i2));
            }
            sb2.append(property);
            if (!vector3.isEmpty()) {
                java.util.Enumeration<java.lang.String> elementAt = vector3.elementAt(i2);
                if (elementAt.hasMoreElements()) {
                    sb2.append("   depends on: ");
                    while (elementAt.hasMoreElements()) {
                        sb2.append(elementAt.nextElement());
                        if (elementAt.hasMoreElements()) {
                            sb2.append(", ");
                        }
                    }
                    sb2.append(property);
                }
            }
        }
        project.log(sb2.toString(), 1);
    }

    public static void r(org.apache.tools.ant.Project project, boolean z, boolean z2) {
        java.util.Map<java.lang.String, org.apache.tools.ant.Target> v2 = v(project.getTargets());
        java.util.Vector vector = new java.util.Vector();
        java.util.Vector vector2 = new java.util.Vector();
        java.util.Vector vector3 = new java.util.Vector();
        java.util.Vector vector4 = new java.util.Vector();
        java.util.Vector vector5 = new java.util.Vector();
        int i = 0;
        for (org.apache.tools.ant.Target target : v2.values()) {
            java.lang.String name = target.getName();
            if (!name.equals("")) {
                java.lang.String description = target.getDescription();
                if (description == null) {
                    int d = d(vector4, name);
                    vector4.insertElementAt(name, d);
                    if (z2) {
                        vector5.insertElementAt(target.getDependencies(), d);
                    }
                } else {
                    int d2 = d(vector, name);
                    vector.insertElementAt(name, d2);
                    vector2.insertElementAt(description, d2);
                    if (name.length() > i) {
                        i = name.length();
                    }
                    if (z2) {
                        vector3.insertElementAt(target.getDependencies(), d2);
                    }
                }
            }
        }
        q(project, vector, vector2, vector3, "Main targets:", i);
        if (vector.size() == 0 ? true : z) {
            q(project, vector4, null, vector5, "Other targets:", 0);
        }
        java.lang.String defaultTarget = project.getDefaultTarget();
        if (defaultTarget == null || "".equals(defaultTarget)) {
            return;
        }
        project.log("Default target: " + defaultTarget);
    }

    public static void s() {
        java.lang.System.out.println("ant [options] [target [target2 [target3] ...]]");
        java.lang.System.out.println("Options: ");
        java.lang.System.out.println("  -help, -h              print this message and exit");
        java.lang.System.out.println("  -projecthelp, -p       print project help information and exit");
        java.lang.System.out.println("  -version               print the version information and exit");
        java.lang.System.out.println("  -diagnostics           print information that might be helpful to");
        java.lang.System.out.println("                         diagnose or report problems and exit");
        java.lang.System.out.println("  -quiet, -q             be extra quiet");
        java.lang.System.out.println("  -silent, -S            print nothing but task outputs and build failures");
        java.lang.System.out.println("  -verbose, -v           be extra verbose");
        java.lang.System.out.println("  -debug, -d             print debugging information");
        java.lang.System.out.println("  -emacs, -e             produce logging information without adornments");
        java.lang.System.out.println("  -lib <path>            specifies a path to search for jars and classes");
        java.lang.System.out.println("  -logfile <file>        use given file for log");
        java.lang.System.out.println("    -l     <file>                ''");
        java.lang.System.out.println("  -logger <classname>    the class which is to perform logging");
        java.lang.System.out.println("  -listener <classname>  add an instance of class as a project listener");
        java.lang.System.out.println("  -noinput               do not allow interactive input");
        java.lang.System.out.println("  -buildfile <file>      use given buildfile");
        java.lang.System.out.println("    -file    <file>              ''");
        java.lang.System.out.println("    -f       <file>              ''");
        java.lang.System.out.println("  -D<property>=<value>   use value for given property");
        java.lang.System.out.println("  -keep-going, -k        execute all targets that do not depend");
        java.lang.System.out.println("                         on failed target(s)");
        java.lang.System.out.println("  -propertyfile <name>   load all properties from file with -D");
        java.lang.System.out.println("                         properties taking precedence");
        java.lang.System.out.println("  -inputhandler <class>  the class which will handle input requests");
        java.lang.System.out.println("  -find <file>           (s)earch for buildfile towards the root of");
        java.lang.System.out.println("    -s  <file>           the filesystem and use it");
        java.lang.System.out.println("  -nice  number          A niceness value for the main thread:");
        java.lang.System.out.println("                         1 (lowest) to 10 (highest); 5 is the default");
        java.lang.System.out.println("  -nouserlib             Run ant without using the jar files from");
        java.lang.System.out.println("                         ${user.home}/.ant/lib");
        java.lang.System.out.println("  -noclasspath           Run ant without using CLASSPATH");
        java.lang.System.out.println("  -autoproxy             Java1.5+: use the OS proxy settings");
        java.lang.System.out.println("  -main <class>          override Ant's normal entry point");
        java.util.Iterator<org.apache.tools.ant.ArgumentProcessor> it = org.apache.tools.ant.ArgumentProcessorRegistry.getInstance().getProcessors().iterator();
        while (it.hasNext()) {
            it.next().printUsage(java.lang.System.out);
        }
    }

    public static void start(java.lang.String[] strArr, java.util.Properties properties, java.lang.ClassLoader classLoader) {
        new org.apache.tools.ant.Main().startAnt(strArr, properties, classLoader);
    }

    public static void t(int i) throws org.apache.tools.ant.BuildException {
        java.lang.System.out.println(getAntVersion());
    }

    public static java.util.Map<java.lang.String, org.apache.tools.ant.Target> v(java.util.Map<java.lang.String, org.apache.tools.ant.Target> map) {
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, org.apache.tools.ant.Target> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            org.apache.tools.ant.Target value = entry.getValue();
            org.apache.tools.ant.Target target = (org.apache.tools.ant.Target) hashMap.get(value.getLocation());
            if (target == null || target.getName().length() > key.length()) {
                hashMap.put(value.getLocation(), value);
            }
        }
        java.util.HashMap hashMap2 = new java.util.HashMap();
        for (org.apache.tools.ant.Target target2 : hashMap.values()) {
            hashMap2.put(target2.getName(), target2);
        }
        return hashMap2;
    }

    public final void a(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.input.InputHandler inputHandler;
        java.lang.String str = this.l;
        if (str == null) {
            inputHandler = new org.apache.tools.ant.input.DefaultInputHandler();
        } else {
            inputHandler = (org.apache.tools.ant.input.InputHandler) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, org.apache.tools.ant.Main.class.getClassLoader(), org.apache.tools.ant.input.InputHandler.class);
            project.setProjectReference(inputHandler);
        }
        project.setInputHandler(inputHandler);
    }

    public void addBuildListeners(org.apache.tools.ant.Project project) {
        project.addBuildListener(b());
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.BuildListener buildListener = (org.apache.tools.ant.BuildListener) org.apache.tools.ant.util.ClasspathUtils.newInstance(this.g.elementAt(i), org.apache.tools.ant.Main.class.getClassLoader(), org.apache.tools.ant.BuildListener.class);
            project.setProjectReference(buildListener);
            project.addBuildListener(buildListener);
        }
    }

    public final org.apache.tools.ant.BuildLogger b() {
        org.apache.tools.ant.BuildLogger buildLogger;
        if (this.n) {
            buildLogger = new org.apache.tools.ant.listener.SilentLogger();
            this.a = 1;
            this.m = true;
        } else {
            java.lang.String str = this.k;
            if (str != null) {
                try {
                    buildLogger = (org.apache.tools.ant.BuildLogger) org.apache.tools.ant.util.ClasspathUtils.newInstance(str, org.apache.tools.ant.Main.class.getClassLoader(), org.apache.tools.ant.BuildLogger.class);
                } catch (org.apache.tools.ant.BuildException e) {
                    java.lang.System.err.println("The specified logger class " + this.k + " could not be used because " + e.getMessage());
                    throw e;
                }
            } else {
                buildLogger = new org.apache.tools.ant.DefaultLogger();
            }
        }
        buildLogger.setMessageOutputLevel(this.a);
        buildLogger.setOutputPrintStream(this.c);
        buildLogger.setErrorPrintStream(this.d);
        buildLogger.setEmacsMode(this.m);
        return buildLogger;
    }

    public final java.io.File c(java.lang.String str, java.lang.String str2) {
        if (this.a >= 2) {
            java.lang.System.out.println("Searching for " + str2 + " ...");
        }
        java.io.File file = new java.io.File(new java.io.File(str).getAbsolutePath());
        java.io.File file2 = new java.io.File(file, str2);
        while (!file2.exists()) {
            file = e(file);
            if (file == null) {
                return null;
            }
            file2 = new java.io.File(file, str2);
        }
        return file2;
    }

    @java.lang.Deprecated
    public final java.io.File e(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && this.a >= 3) {
            java.lang.System.out.println("Searching in " + parentFile.getAbsolutePath());
        }
        return parentFile;
    }

    public void exit(int i) {
        java.lang.System.exit(i);
    }

    public final int f(java.lang.String[] strArr, int i) {
        try {
            int i2 = i + 1;
            this.b = new java.io.File(strArr[i2].replace('/', java.io.File.separatorChar));
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must specify a buildfile when using the -buildfile argument");
        }
    }

    public final int g(java.lang.String[] strArr, int i) {
        java.lang.String str;
        java.lang.String str2 = strArr[i];
        java.lang.String substring = str2.substring(2, str2.length());
        int indexOf = substring.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf > 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            if (i >= strArr.length - 1) {
                throw new org.apache.tools.ant.BuildException("Missing value for property " + substring);
            }
            i++;
            str = strArr[i];
        }
        this.f.put(substring, str);
        return i;
    }

    public final int h(java.lang.String[] strArr, int i) {
        if (this.l != null) {
            throw new org.apache.tools.ant.BuildException("Only one input handler class may be specified.");
        }
        int i2 = i + 1;
        try {
            this.l = strArr[i2];
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must specify a classname when using the -inputhandler argument");
        }
    }

    public final int i(java.lang.String[] strArr, int i) {
        try {
            int i2 = i + 1;
            this.g.addElement(strArr[i2]);
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must specify a classname when using the -listener argument");
        }
    }

    public final int j(java.lang.String[] strArr, int i) {
        if (this.k != null) {
            throw new org.apache.tools.ant.BuildException("Only one logger class may be specified.");
        }
        int i2 = i + 1;
        try {
            this.k = strArr[i2];
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must specify a classname when using the -logger argument");
        }
    }

    public final int k(java.lang.String[] strArr, int i) {
        int i2 = i + 1;
        try {
            java.lang.Integer decode = java.lang.Integer.decode(strArr[i2]);
            this.r = decode;
            if (decode.intValue() < 1 || this.r.intValue() > 10) {
                throw new org.apache.tools.ant.BuildException("Niceness value is out of the range 1-10");
            }
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must supply a niceness value (1-10) after the -nice option");
        } catch (java.lang.NumberFormatException unused2) {
            throw new org.apache.tools.ant.BuildException("Unrecognized niceness value: " + strArr[i2]);
        }
    }

    public final int l(java.lang.String[] strArr, int i) {
        try {
            int i2 = i + 1;
            this.h.addElement(strArr[i2]);
            return i2;
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            throw new org.apache.tools.ant.BuildException("You must specify a property filename when using the -propertyfile argument");
        }
    }

    public final void m() {
        if (this.q) {
            org.apache.tools.ant.util.FileUtils.close(this.c);
            org.apache.tools.ant.util.FileUtils.close(this.d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        java.io.FileInputStream fileInputStream;
        java.io.IOException e;
        java.util.Enumeration<?> propertyNames;
        java.util.Iterator<java.lang.String> it = this.h.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            java.util.Properties properties = new java.util.Properties();
            java.io.FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new java.io.FileInputStream(next);
                try {
                    try {
                        properties.load(fileInputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                        throw th;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    java.lang.System.out.println("Could not load property file " + next + ": " + e.getMessage());
                    org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                    propertyNames = properties.propertyNames();
                    while (propertyNames.hasMoreElements()) {
                    }
                }
            } catch (java.io.IOException e3) {
                fileInputStream = null;
                e = e3;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
            propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                java.lang.String str = (java.lang.String) propertyNames.nextElement();
                if (this.f.getProperty(str) == null) {
                    this.f.put(str, properties.getProperty(str));
                }
            }
        }
    }

    @Override // org.apache.tools.ant.launch.AntMain
    public void startAnt(java.lang.String[] strArr, java.util.Properties properties, java.lang.ClassLoader classLoader) {
        int i;
        try {
            u(strArr);
            if (properties != null) {
                java.util.Enumeration keys = properties.keys();
                while (keys.hasMoreElements()) {
                    java.lang.String str = (java.lang.String) keys.nextElement();
                    this.f.put(str, properties.getProperty(str));
                }
            }
            try {
                try {
                    try {
                        w(classLoader);
                        i = 0;
                    } catch (org.apache.tools.ant.ExitStatusException e) {
                        int status = e.getStatus();
                        if (status != 0) {
                            throw e;
                        }
                        i = status;
                    }
                } finally {
                    m();
                }
            } catch (org.apache.tools.ant.BuildException e2) {
                if (this.d != java.lang.System.err) {
                    p(e2);
                }
                m();
                i = 1;
                exit(i);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                p(th);
                m();
                i = 1;
                exit(i);
            }
            exit(i);
        } catch (java.lang.Throwable th2) {
            m();
            p(th2);
            exit(1);
        }
    }

    public final void u(java.lang.String[] strArr) {
        boolean z;
        org.apache.tools.ant.ArgumentProcessorRegistry argumentProcessorRegistry = org.apache.tools.ant.ArgumentProcessorRegistry.getInstance();
        java.lang.String str = null;
        boolean z2 = false;
        java.io.PrintStream printStream = null;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (i < strArr.length) {
            java.lang.String str2 = strArr[i];
            if (str2.equals("-help") || str2.equals("-h")) {
                z4 = true;
            } else if (str2.equals("-version")) {
                z3 = true;
            } else if (str2.equals("-diagnostics")) {
                z5 = true;
            } else if (str2.equals("-quiet") || str2.equals("-q")) {
                this.a = 1;
            } else if (str2.equals(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE) || str2.equals("-v")) {
                this.a = 3;
            } else if (str2.equals("-debug") || str2.equals("-d")) {
                this.a = 4;
            } else if (str2.equals("-silent") || str2.equals("-S")) {
                this.n = true;
            } else if (str2.equals("-noinput")) {
                this.i = z2;
            } else if (str2.equals("-logfile") || str2.equals("-l")) {
                try {
                    i++;
                    printStream = new java.io.PrintStream(new java.io.FileOutputStream(new java.io.File(strArr[i])));
                    this.q = true;
                } catch (java.io.IOException unused) {
                    throw new org.apache.tools.ant.BuildException("Cannot write on the specified log file. Make sure the path exists and you have write permissions.");
                } catch (java.lang.ArrayIndexOutOfBoundsException unused2) {
                    throw new org.apache.tools.ant.BuildException("You must specify a log file when using the -log argument");
                }
            } else if (str2.equals("-buildfile") || str2.equals(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_FILE) || str2.equals("-f")) {
                i = f(strArr, i);
            } else if (str2.equals("-listener")) {
                i = i(strArr, i);
            } else if (str2.startsWith(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF)) {
                i = g(strArr, i);
            } else if (str2.equals("-logger")) {
                i = j(strArr, i);
            } else if (str2.equals("-inputhandler")) {
                i = h(strArr, i);
            } else if (str2.equals("-emacs") || str2.equals("-e")) {
                this.m = true;
            } else if (str2.equals("-projecthelp") || str2.equals("-p")) {
                this.p = true;
            } else if (str2.equals("-find") || str2.equals("-s")) {
                if (i < strArr.length - 1) {
                    i++;
                    str = strArr[i];
                }
                z6 = true;
            } else if (str2.startsWith("-propertyfile")) {
                i = l(strArr, i);
            } else if (str2.equals("-k") || str2.equals("-keep-going")) {
                this.j = true;
            } else if (str2.equals("-nice")) {
                i = k(strArr, i);
            } else {
                if (u.contains(str2)) {
                    throw new org.apache.tools.ant.BuildException("Ant's Main method is being handed an option " + str2 + " that is only for the launcher class.\nThis can be caused by a version mismatch between the ant script/.bat file and Ant itself.");
                }
                if (str2.equals("-autoproxy")) {
                    this.f503s = true;
                } else if (str2.startsWith(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    java.util.Iterator<org.apache.tools.ant.ArgumentProcessor> it = argumentProcessorRegistry.getProcessors().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        org.apache.tools.ant.ArgumentProcessor next = it.next();
                        int readArguments = next.readArguments(strArr, i);
                        if (readArguments != -1) {
                            java.util.List<java.lang.String> list = this.t.get(next.getClass());
                            if (list == null) {
                                list = new java.util.ArrayList<>();
                                this.t.put(next.getClass(), list);
                            }
                            while (i < readArguments && i < strArr.length) {
                                list.add(strArr[i]);
                                i++;
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        java.lang.System.err.println("Unknown argument: " + str2);
                        s();
                        throw new org.apache.tools.ant.BuildException("");
                    }
                } else {
                    this.e.addElement(str2);
                }
            }
            i++;
            z2 = false;
        }
        int i2 = this.a;
        if (i2 >= 3 || z3) {
            t(i2);
        }
        if (z4 || z3 || z5) {
            if (z4) {
                s();
            }
            if (z5) {
                org.apache.tools.ant.Diagnostics.doReport(java.lang.System.out, this.a);
                return;
            }
            return;
        }
        if (this.b == null) {
            if (!z6) {
                java.util.Iterator<org.apache.tools.ant.ProjectHelper> helpers = org.apache.tools.ant.ProjectHelperRepository.getInstance().getHelpers();
                do {
                    this.b = new java.io.File(helpers.next().getDefaultBuildFile());
                    if (this.a >= 3) {
                        java.lang.System.out.println("Trying the default build file: " + this.b);
                    }
                    if (this.b.exists()) {
                        break;
                    }
                } while (helpers.hasNext());
            } else if (str != null) {
                java.io.File c = c(java.lang.System.getProperty("user.dir"), str);
                this.b = c;
                if (c == null) {
                    throw new org.apache.tools.ant.BuildException("Could not locate a build file!");
                }
            } else {
                java.util.Iterator<org.apache.tools.ant.ProjectHelper> helpers2 = org.apache.tools.ant.ProjectHelperRepository.getInstance().getHelpers();
                do {
                    java.lang.String defaultBuildFile = helpers2.next().getDefaultBuildFile();
                    if (this.a >= 3) {
                        java.lang.System.out.println("Searching the default build file: " + defaultBuildFile);
                    }
                    java.io.File c2 = c(java.lang.System.getProperty("user.dir"), defaultBuildFile);
                    this.b = c2;
                    if (c2 != null) {
                        break;
                    }
                } while (helpers2.hasNext());
                if (this.b == null) {
                    throw new org.apache.tools.ant.BuildException("Could not locate a build file!");
                }
            }
        }
        if (!this.b.exists()) {
            java.lang.System.out.println("Buildfile: " + this.b + " does not exist!");
            throw new org.apache.tools.ant.BuildException("Build failed");
        }
        if (this.b.isDirectory()) {
            java.io.File file = new java.io.File(this.b, DEFAULT_BUILD_FILENAME);
            if (!file.isFile()) {
                java.lang.System.out.println("What? Buildfile: " + this.b + " is a dir!");
                throw new org.apache.tools.ant.BuildException("Build failed");
            }
            this.b = file;
        }
        this.b = org.apache.tools.ant.util.FileUtils.getFileUtils().normalize(this.b.getAbsolutePath());
        n();
        if (this.a >= 2) {
            java.lang.System.out.println("Buildfile: " + this.b);
        }
        if (printStream != null) {
            this.c = printStream;
            this.d = printStream;
            java.lang.System.setOut(printStream);
            java.lang.System.setErr(this.d);
        }
        this.o = true;
    }

    public final void w(java.lang.ClassLoader classLoader) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.BuildException buildException;
        if (this.o) {
            org.apache.tools.ant.ArgumentProcessorRegistry argumentProcessorRegistry = org.apache.tools.ant.ArgumentProcessorRegistry.getInstance();
            for (org.apache.tools.ant.ArgumentProcessor argumentProcessor : argumentProcessorRegistry.getProcessors()) {
                java.util.List<java.lang.String> list = this.t.get(argumentProcessor.getClass());
                if (list != null && argumentProcessor.handleArg(list)) {
                    return;
                }
            }
            org.apache.tools.ant.Project project = new org.apache.tools.ant.Project();
            project.setCoreLoader(classLoader);
            java.lang.Throwable th = null;
            try {
                try {
                    addBuildListeners(project);
                    a(project);
                    java.io.PrintStream printStream = java.lang.System.err;
                    java.io.PrintStream printStream2 = java.lang.System.out;
                    java.io.InputStream inputStream = java.lang.System.in;
                    java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
                    try {
                        if (this.i) {
                            project.setDefaultInputStream(java.lang.System.in);
                        }
                        java.lang.System.setIn(new org.apache.tools.ant.DemuxInputStream(project));
                        java.lang.System.setOut(new java.io.PrintStream(new org.apache.tools.ant.DemuxOutputStream(project, false)));
                        boolean z = true;
                        java.lang.System.setErr(new java.io.PrintStream(new org.apache.tools.ant.DemuxOutputStream(project, true)));
                        if (!this.p) {
                            project.fireBuildStarted();
                        }
                        if (this.r != null) {
                            try {
                                project.log("Setting Ant's thread priority to " + this.r, 3);
                                java.lang.Thread.currentThread().setPriority(this.r.intValue());
                            } catch (java.lang.SecurityException unused) {
                                project.log("A security manager refused to set the -nice value");
                            }
                        }
                        x(project);
                        project.setKeepGoingMode(this.j);
                        if (this.f503s) {
                            new org.apache.tools.ant.util.ProxySetup(project).enableProxies();
                        }
                        for (org.apache.tools.ant.ArgumentProcessor argumentProcessor2 : argumentProcessorRegistry.getProcessors()) {
                            java.util.List<java.lang.String> list2 = this.t.get(argumentProcessor2.getClass());
                            if (list2 != null) {
                                argumentProcessor2.prepareConfigure(project, list2);
                            }
                        }
                        org.apache.tools.ant.ProjectHelper.configureProject(project, this.b);
                        for (org.apache.tools.ant.ArgumentProcessor argumentProcessor3 : argumentProcessorRegistry.getProcessors()) {
                            java.util.List<java.lang.String> list3 = this.t.get(argumentProcessor3.getClass());
                            if (list3 != null && argumentProcessor3.handleArg(project, list3)) {
                                if (this.p) {
                                    return;
                                }
                                try {
                                    project.fireBuildFinished(null);
                                    return;
                                } finally {
                                }
                            }
                        }
                        if (!this.p) {
                            if (this.e.size() == 0 && project.getDefaultTarget() != null) {
                                this.e.addElement(project.getDefaultTarget());
                            }
                            project.executeTargets(this.e);
                            if (securityManager != null) {
                                java.lang.System.setSecurityManager(securityManager);
                            }
                            java.lang.System.setOut(printStream2);
                            java.lang.System.setErr(printStream);
                            java.lang.System.setIn(inputStream);
                            if (this.p) {
                                return;
                            }
                            try {
                                project.fireBuildFinished(null);
                                return;
                            } finally {
                            }
                        }
                        o(project);
                        int i = this.a;
                        boolean z2 = i > 2;
                        if (i <= 3) {
                            z = false;
                        }
                        r(project, z2, z);
                        if (securityManager != null) {
                            java.lang.System.setSecurityManager(securityManager);
                        }
                        java.lang.System.setOut(printStream2);
                        java.lang.System.setErr(printStream);
                        java.lang.System.setIn(inputStream);
                        if (this.p) {
                            return;
                        }
                        try {
                            project.fireBuildFinished(null);
                        } finally {
                        }
                    } finally {
                        if (securityManager != null) {
                            java.lang.System.setSecurityManager(securityManager);
                        }
                        java.lang.System.setOut(printStream2);
                        java.lang.System.setErr(printStream);
                        java.lang.System.setIn(inputStream);
                    }
                } catch (java.lang.Throwable th2) {
                    if (!this.p) {
                        try {
                            project.fireBuildFinished(null);
                        } catch (java.lang.Throwable th3) {
                            java.lang.System.err.println("Caught an exception while logging the end of the build.  Exception was:");
                            th3.printStackTrace();
                            if (0 != 0) {
                                java.lang.System.err.println("There has been an error prior to that:");
                                th.printStackTrace();
                            }
                            throw new org.apache.tools.ant.BuildException(th3);
                        }
                    } else if (0 != 0) {
                        project.log(th.toString(), 0);
                    }
                    throw th2;
                }
            } catch (java.lang.Error e) {
                throw e;
            } catch (java.lang.RuntimeException e2) {
                throw e2;
            }
        }
    }

    public final void x(org.apache.tools.ant.Project project) {
        project.init();
        org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(project);
        java.util.HashMap hashMap = new java.util.HashMap(this.f);
        new org.apache.tools.ant.property.ResolvePropertyMap(project, v, propertyHelper.getExpanders()).resolveAllProperties(hashMap, null, false);
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            project.setUserProperty((java.lang.String) entry.getKey(), java.lang.String.valueOf(entry.getValue()));
        }
        project.setUserProperty(org.apache.tools.ant.MagicNames.ANT_FILE, this.b.getAbsolutePath());
        project.setUserProperty(org.apache.tools.ant.MagicNames.ANT_FILE_TYPE, "file");
        project.setUserProperty(org.apache.tools.ant.MagicNames.PROJECT_INVOKED_TARGETS, org.apache.tools.ant.util.CollectionUtils.flattenToString(this.e));
    }
}
