package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Execute {
    public static final int INVALID = Integer.MAX_VALUE;
    public static java.lang.String j = java.lang.System.getProperty("user.dir");
    public static java.util.Map<java.lang.String, java.lang.String> k = null;
    public static org.apache.tools.ant.taskdefs.ProcessDestroyer l = new org.apache.tools.ant.taskdefs.ProcessDestroyer();
    public static boolean m;
    public java.lang.String[] a;
    public java.lang.String[] b;
    public int c;
    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler d;
    public final org.apache.tools.ant.taskdefs.ExecuteWatchdog e;
    public java.io.File f;
    public org.apache.tools.ant.Project g;
    public boolean h;
    public boolean i;

    /* renamed from: org.apache.tools.ant.taskdefs.Execute$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.OutputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws java.io.IOException {
        }
    }

    static {
        m = false;
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            m = true;
        }
    }

    public Execute() {
        this(new org.apache.tools.ant.taskdefs.PumpStreamHandler(), null);
    }

    public Execute(org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        this(executeStreamHandler, null);
    }

    public Execute(org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler, org.apache.tools.ant.taskdefs.ExecuteWatchdog executeWatchdog) {
        this.a = null;
        this.b = null;
        this.c = Integer.MAX_VALUE;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = true;
        setStreamHandler(executeStreamHandler);
        this.e = executeWatchdog;
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            this.i = false;
        }
    }

    public static java.lang.String[] a() {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS2)) {
            return new java.lang.String[]{"cmd", "/c", "set"};
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            return org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_9X) ? new java.lang.String[]{"command.com", "/c", "set"} : new java.lang.String[]{"cmd", "/c", "set"};
        }
        if (!org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_ZOS) && !org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX)) {
            if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE) || org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS400)) {
                return new java.lang.String[]{com.umeng.analytics.pro.ay.a};
            }
            if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
                return new java.lang.String[]{"show", "logical"};
            }
            return null;
        }
        java.lang.String[] strArr = new java.lang.String[1];
        if (new java.io.File("/bin/env").canRead()) {
            strArr[0] = "/bin/env";
        } else if (new java.io.File("/usr/bin/env").canRead()) {
            strArr[0] = "/usr/bin/env";
        } else {
            strArr[0] = com.umeng.analytics.pro.ay.a;
        }
        return strArr;
    }

    public static java.util.Map<java.lang.String, java.lang.String> b(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str = null;
        java.lang.String str2 = null;
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (readLine.startsWith("\t=")) {
                if (str != null) {
                    str2 = str2 + "," + readLine.substring(4, readLine.length() - 1);
                }
            } else if (readLine.startsWith("  \"")) {
                if (str != null) {
                    hashMap.put(str, str2);
                }
                int indexOf = readLine.indexOf(61);
                java.lang.String substring = readLine.substring(3, indexOf - 2);
                if (hashMap.containsKey(substring)) {
                    str = null;
                } else {
                    str2 = readLine.substring(indexOf + 3, readLine.length() - 1);
                    str = substring;
                }
            }
        }
        if (str != null) {
            hashMap.put(str, str2);
        }
        return hashMap;
    }

    public static void closeStreams(java.lang.Process process) {
        org.apache.tools.ant.util.FileUtils.close(process.getInputStream());
        org.apache.tools.ant.util.FileUtils.close(process.getOutputStream());
        org.apache.tools.ant.util.FileUtils.close(process.getErrorStream());
    }

    public static synchronized java.util.Map<java.lang.String, java.lang.String> getEnvironmentVariables() {
        java.io.BufferedReader bufferedReader;
        synchronized (org.apache.tools.ant.taskdefs.Execute.class) {
            java.util.Map<java.lang.String, java.lang.String> map = k;
            if (map != null) {
                return map;
            }
            if (!org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
                try {
                    java.util.Map<java.lang.String, java.lang.String> map2 = java.lang.System.getenv();
                    k = map2;
                    return map2;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            k = new java.util.LinkedHashMap();
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.PumpStreamHandler(byteArrayOutputStream));
                execute.setCommandline(a());
                execute.setNewenvironment(true);
                execute.execute();
                bufferedReader = new java.io.BufferedReader(new java.io.StringReader(toString(byteArrayOutputStream)));
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
            if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
                java.util.Map<java.lang.String, java.lang.String> b = b(bufferedReader);
                k = b;
                return b;
            }
            java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
            java.lang.String str2 = null;
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.indexOf(61) != -1) {
                    if (str2 != null) {
                        int indexOf = str2.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                        k.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                    }
                    str2 = readLine;
                } else if (str2 == null) {
                    str2 = str + readLine;
                } else {
                    str2 = str2 + str + readLine;
                }
            }
            if (str2 != null) {
                int indexOf2 = str2.indexOf(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                k.put(str2.substring(0, indexOf2), str2.substring(indexOf2 + 1));
            }
            return k;
        }
    }

    @java.lang.Deprecated
    public static synchronized java.util.Vector<java.lang.String> getProcEnvironment() {
        java.util.Vector<java.lang.String> vector;
        synchronized (org.apache.tools.ant.taskdefs.Execute.class) {
            vector = new java.util.Vector<>();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : getEnvironmentVariables().entrySet()) {
                vector.add(entry.getKey() + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue());
            }
        }
        return vector;
    }

    public static boolean isFailure(int i) {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            if (i % 2 == 0) {
                return true;
            }
        } else if (i != 0) {
            return true;
        }
        return false;
    }

    public static java.lang.Process launch(org.apache.tools.ant.Project project, java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file, boolean z) throws java.io.IOException {
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException(file + " doesn't exist.");
        }
        org.apache.tools.ant.taskdefs.launcher.CommandLauncher vMLauncher = org.apache.tools.ant.taskdefs.launcher.CommandLauncher.getVMLauncher(project);
        if (!z || vMLauncher == null) {
            vMLauncher = org.apache.tools.ant.taskdefs.launcher.CommandLauncher.getShellLauncher(project);
        }
        return vMLauncher.exec(project, strArr, strArr2, file);
    }

    public static void runCommand(org.apache.tools.ant.Task task, java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        try {
            task.log(org.apache.tools.ant.types.Commandline.describeCommand(strArr), 3);
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(new org.apache.tools.ant.taskdefs.LogStreamHandler(task, 2, 0));
            execute.setAntRun(task.getProject());
            execute.setCommandline(strArr);
            int execute2 = execute.execute();
            if (isFailure(execute2)) {
                throw new org.apache.tools.ant.BuildException(strArr[0] + " failed with return code " + execute2, task.getLocation());
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Could not launch " + strArr[0] + ": " + e, task.getLocation());
        }
    }

    public static java.lang.String toString(java.io.ByteArrayOutputStream byteArrayOutputStream) {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_ZOS)) {
            return byteArrayOutputStream.toString("Cp1047");
        }
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_OS400)) {
            return byteArrayOutputStream.toString("Cp500");
        }
        return byteArrayOutputStream.toString();
    }

    public final java.lang.String[] c() {
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_VMS)) {
            return this.b;
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(getEnvironmentVariables());
        for (java.lang.String str : this.b) {
            java.lang.String substring = str.substring(0, str.indexOf(61));
            if (linkedHashMap.remove(substring) == null && m) {
                java.util.Iterator it = linkedHashMap.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        java.lang.String str2 = (java.lang.String) it.next();
                        if (str2.toLowerCase().equals(substring.toLowerCase())) {
                            substring = str2;
                            break;
                        }
                    }
                }
            }
            linkedHashMap.put(substring, str.substring(substring.length() + 1));
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(((java.lang.String) entry.getKey()) + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + ((java.lang.String) entry.getValue()));
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[linkedHashMap.size()]);
    }

    public int execute() throws java.io.IOException {
        java.io.File file = this.f;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException(this.f + " doesn't exist.");
        }
        java.lang.Process launch = launch(this.g, getCommandline(), getEnvironment(), this.f, this.i);
        try {
            this.d.setProcessInputStream(launch.getOutputStream());
            this.d.setProcessOutputStream(launch.getInputStream());
            this.d.setProcessErrorStream(launch.getErrorStream());
            this.d.start();
            try {
                try {
                    l.a(launch);
                    org.apache.tools.ant.taskdefs.ExecuteWatchdog executeWatchdog = this.e;
                    if (executeWatchdog != null) {
                        executeWatchdog.start(launch);
                    }
                    waitFor(launch);
                    org.apache.tools.ant.taskdefs.ExecuteWatchdog executeWatchdog2 = this.e;
                    if (executeWatchdog2 != null) {
                        executeWatchdog2.stop();
                    }
                    this.d.stop();
                    closeStreams(launch);
                    org.apache.tools.ant.taskdefs.ExecuteWatchdog executeWatchdog3 = this.e;
                    if (executeWatchdog3 != null) {
                        executeWatchdog3.checkException();
                    }
                    return getExitValue();
                } finally {
                    l.c(launch);
                }
            } catch (java.lang.ThreadDeath e) {
                launch.destroy();
                throw e;
            }
        } catch (java.io.IOException e2) {
            launch.destroy();
            throw e2;
        }
    }

    public java.lang.String[] getCommandline() {
        return this.a;
    }

    public java.lang.String[] getEnvironment() {
        java.lang.String[] strArr = this.b;
        return (strArr == null || this.h) ? strArr : c();
    }

    public int getExitValue() {
        return this.c;
    }

    public java.io.File getWorkingDirectory() {
        java.io.File file = this.f;
        return file == null ? new java.io.File(j) : file;
    }

    public boolean isFailure() {
        return isFailure(getExitValue());
    }

    public boolean killedProcess() {
        org.apache.tools.ant.taskdefs.ExecuteWatchdog executeWatchdog = this.e;
        return executeWatchdog != null && executeWatchdog.killedProcess();
    }

    public void setAntRun(org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        this.g = project;
    }

    public void setCommandline(java.lang.String[] strArr) {
        this.a = strArr;
    }

    public void setEnvironment(java.lang.String[] strArr) {
        this.b = strArr;
    }

    public void setExitValue(int i) {
        this.c = i;
    }

    public void setNewenvironment(boolean z) {
        this.h = z;
    }

    @java.lang.Deprecated
    public void setSpawn(boolean z) {
    }

    public void setStreamHandler(org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        this.d = executeStreamHandler;
    }

    public void setVMLauncher(boolean z) {
        this.i = z;
    }

    public void setWorkingDirectory(java.io.File file) {
        this.f = file;
    }

    public void spawn() throws java.io.IOException {
        java.io.File file = this.f;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException(this.f + " doesn't exist.");
        }
        java.lang.Process launch = launch(this.g, getCommandline(), getEnvironment(), this.f, this.i);
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            try {
                java.lang.Thread.sleep(1000L);
            } catch (java.lang.InterruptedException unused) {
                this.g.log("interruption in the sleep after having spawned a process", 3);
            }
        }
        org.apache.tools.ant.taskdefs.PumpStreamHandler pumpStreamHandler = new org.apache.tools.ant.taskdefs.PumpStreamHandler(new org.apache.tools.ant.taskdefs.Execute.AnonymousClass1());
        pumpStreamHandler.setProcessErrorStream(launch.getErrorStream());
        pumpStreamHandler.setProcessOutputStream(launch.getInputStream());
        pumpStreamHandler.start();
        launch.getOutputStream().close();
        this.g.log("spawned process " + launch.toString(), 3);
    }

    public void waitFor(java.lang.Process process) {
        try {
            process.waitFor();
            setExitValue(process.exitValue());
        } catch (java.lang.InterruptedException unused) {
            process.destroy();
        }
    }
}
