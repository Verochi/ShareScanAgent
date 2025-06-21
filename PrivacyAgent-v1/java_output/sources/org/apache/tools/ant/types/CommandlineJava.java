package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class CommandlineJava implements java.lang.Cloneable {
    public org.apache.tools.ant.types.CommandlineJava.ExecutableType C;
    public java.lang.String z;
    public org.apache.tools.ant.types.Commandline n = new org.apache.tools.ant.types.Commandline();
    public org.apache.tools.ant.types.Commandline t = new org.apache.tools.ant.types.Commandline();
    public org.apache.tools.ant.types.CommandlineJava.SysProperties u = new org.apache.tools.ant.types.CommandlineJava.SysProperties();
    public org.apache.tools.ant.types.Path v = null;
    public org.apache.tools.ant.types.Path w = null;
    public org.apache.tools.ant.types.Path x = null;
    public org.apache.tools.ant.types.Path y = null;
    public java.lang.String A = null;
    public org.apache.tools.ant.types.Assertions B = null;
    public boolean D = false;

    /* renamed from: org.apache.tools.ant.types.CommandlineJava$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[org.apache.tools.ant.types.CommandlineJava.ExecutableType.values().length];
            a = iArr;
            try {
                iArr[org.apache.tools.ant.types.CommandlineJava.ExecutableType.CLASS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[org.apache.tools.ant.types.CommandlineJava.ExecutableType.JAR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public enum ExecutableType {
        CLASS,
        JAR,
        MODULE
    }

    public static class SysProperties extends org.apache.tools.ant.types.Environment implements java.lang.Cloneable {
        public java.util.Properties n = null;
        public java.util.Vector<org.apache.tools.ant.types.PropertySet> t = new java.util.Vector<>();

        public final java.util.Properties a() {
            java.util.Properties properties = new java.util.Properties();
            java.util.Iterator<org.apache.tools.ant.types.PropertySet> it = this.t.iterator();
            while (it.hasNext()) {
                properties.putAll(it.next().getProperties());
            }
            return properties;
        }

        public void addDefinitionsToList(java.util.ListIterator<java.lang.String> listIterator) {
            java.lang.String[] variables = super.getVariables();
            if (variables != null) {
                for (java.lang.String str : variables) {
                    listIterator.add(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF + str);
                }
            }
            java.util.Properties a = a();
            java.util.Enumeration keys = a.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str2 = (java.lang.String) keys.nextElement();
                listIterator.add(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_CODEDIFF + str2 + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + a.getProperty(str2));
            }
        }

        public void addSysproperties(org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties) {
            this.variables.addAll(sysProperties.variables);
            this.t.addAll(sysProperties.t);
        }

        public void addSyspropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
            this.t.addElement(propertySet);
        }

        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            try {
                org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties = (org.apache.tools.ant.types.CommandlineJava.SysProperties) super.clone();
                sysProperties.variables = (java.util.Vector) this.variables.clone();
                sysProperties.t = (java.util.Vector) this.t.clone();
                return sysProperties;
            } catch (java.lang.CloneNotSupportedException unused) {
                return null;
            }
        }

        @Override // org.apache.tools.ant.types.Environment
        public java.lang.String[] getVariables() throws org.apache.tools.ant.BuildException {
            java.util.LinkedList linkedList = new java.util.LinkedList();
            addDefinitionsToList(linkedList.listIterator());
            if (linkedList.size() == 0) {
                return null;
            }
            return (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
        }

        public void restoreSystem() throws org.apache.tools.ant.BuildException {
            java.util.Properties properties = this.n;
            if (properties == null) {
                throw new org.apache.tools.ant.BuildException("Unbalanced nesting of SysProperties");
            }
            try {
                java.lang.System.setProperties(properties);
                this.n = null;
            } catch (java.lang.SecurityException e) {
                throw new org.apache.tools.ant.BuildException("Cannot modify system properties", e);
            }
        }

        public void setSystem() throws org.apache.tools.ant.BuildException {
            try {
                this.n = java.lang.System.getProperties();
                java.util.Properties properties = new java.util.Properties();
                java.util.Enumeration<?> propertyNames = this.n.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    java.lang.String str = (java.lang.String) propertyNames.nextElement();
                    java.lang.String property = this.n.getProperty(str);
                    if (str != null && property != null) {
                        properties.put(str, property);
                    }
                }
                properties.putAll(a());
                java.util.Iterator<org.apache.tools.ant.types.Environment.Variable> it = this.variables.iterator();
                while (it.hasNext()) {
                    org.apache.tools.ant.types.Environment.Variable next = it.next();
                    next.validate();
                    properties.put(next.getKey(), next.getValue());
                }
                java.lang.System.setProperties(properties);
            } catch (java.lang.SecurityException e) {
                throw new org.apache.tools.ant.BuildException("Cannot modify system properties", e);
            }
        }

        public int size() {
            return this.variables.size() + a().size();
        }
    }

    public CommandlineJava() {
        setVm(org.apache.tools.ant.util.JavaEnvUtils.getJreExecutable(com.uc.crashsdk.export.LogType.JAVA_TYPE));
        setVmversion(org.apache.tools.ant.util.JavaEnvUtils.getJavaVersion());
    }

    public static java.lang.String c(java.lang.String str, java.lang.String str2) {
        return str2 == null ? str : java.lang.String.format("%s/%s", str, str2);
    }

    public static java.lang.String e(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split.length == 2) {
            return split[1];
        }
        return null;
    }

    public static java.lang.String f(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)[0];
    }

    public final void a(java.util.ListIterator<java.lang.String> listIterator) {
        getActualVMCommand().addCommandToList(listIterator);
        this.u.addDefinitionsToList(listIterator);
        if (d()) {
            org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties = new org.apache.tools.ant.types.CommandlineJava.SysProperties();
            org.apache.tools.ant.types.PropertySet propertySet = new org.apache.tools.ant.types.PropertySet();
            org.apache.tools.ant.types.PropertySet.BuiltinPropertySetName builtinPropertySetName = new org.apache.tools.ant.types.PropertySet.BuiltinPropertySetName();
            builtinPropertySetName.setValue("system");
            propertySet.appendBuiltin(builtinPropertySetName);
            sysProperties.addSyspropertyset(propertySet);
            sysProperties.addDefinitionsToList(listIterator);
        }
        org.apache.tools.ant.types.Path b = b(true);
        if (b.size() > 0) {
            listIterator.add("-Xbootclasspath:" + b.toString());
        }
        if (haveClasspath()) {
            listIterator.add("-classpath");
            listIterator.add(this.v.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE).toString());
        }
        if (haveModulepath()) {
            listIterator.add("--module-path");
            listIterator.add(this.x.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE).toString());
        }
        if (haveUpgrademodulepath()) {
            listIterator.add("--upgrade-module-path");
            listIterator.add(this.y.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE).toString());
        }
        if (getAssertions() != null) {
            getAssertions().applyAssertions(listIterator);
        }
        org.apache.tools.ant.types.CommandlineJava.ExecutableType executableType = this.C;
        if (executableType == org.apache.tools.ant.types.CommandlineJava.ExecutableType.JAR) {
            listIterator.add("-jar");
        } else if (executableType == org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE) {
            listIterator.add("-m");
        }
        this.t.addCommandToList(listIterator);
    }

    public void addSysproperties(org.apache.tools.ant.types.CommandlineJava.SysProperties sysProperties) {
        this.u.addSysproperties(sysProperties);
    }

    public void addSysproperty(org.apache.tools.ant.types.Environment.Variable variable) {
        this.u.addVariable(variable);
    }

    public void addSyspropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        this.u.addSyspropertyset(propertySet);
    }

    public final org.apache.tools.ant.types.Path b(boolean z) {
        if (!this.z.startsWith("1.1")) {
            org.apache.tools.ant.types.Path path = this.w;
            if (path == null) {
                path = new org.apache.tools.ant.types.Path(null);
            }
            return path.concatSystemBootClasspath(d() ? "last" : org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        }
        org.apache.tools.ant.types.Path path2 = this.w;
        if (path2 != null && z) {
            path2.log("Ignoring bootclasspath as the target VM doesn't support it.");
        }
        return new org.apache.tools.ant.types.Path(null);
    }

    public void clearJavaArgs() {
        this.t.clearArgs();
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        try {
            org.apache.tools.ant.types.CommandlineJava commandlineJava = (org.apache.tools.ant.types.CommandlineJava) super.clone();
            commandlineJava.n = (org.apache.tools.ant.types.Commandline) this.n.clone();
            commandlineJava.t = (org.apache.tools.ant.types.Commandline) this.t.clone();
            commandlineJava.u = (org.apache.tools.ant.types.CommandlineJava.SysProperties) this.u.clone();
            org.apache.tools.ant.types.Path path = this.v;
            if (path != null) {
                commandlineJava.v = (org.apache.tools.ant.types.Path) path.clone();
            }
            org.apache.tools.ant.types.Path path2 = this.w;
            if (path2 != null) {
                commandlineJava.w = (org.apache.tools.ant.types.Path) path2.clone();
            }
            org.apache.tools.ant.types.Path path3 = this.x;
            if (path3 != null) {
                commandlineJava.x = (org.apache.tools.ant.types.Path) path3.clone();
            }
            org.apache.tools.ant.types.Path path4 = this.y;
            if (path4 != null) {
                commandlineJava.y = (org.apache.tools.ant.types.Path) path4.clone();
            }
            org.apache.tools.ant.types.Assertions assertions = this.B;
            if (assertions != null) {
                commandlineJava.B = (org.apache.tools.ant.types.Assertions) assertions.clone();
            }
            return commandlineJava;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.Commandline.Argument createArgument() {
        return this.t.createArgument();
    }

    public org.apache.tools.ant.types.Path createBootclasspath(org.apache.tools.ant.Project project) {
        if (this.w == null) {
            this.w = new org.apache.tools.ant.types.Path(project);
        }
        return this.w;
    }

    public org.apache.tools.ant.types.Path createClasspath(org.apache.tools.ant.Project project) {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(project);
        }
        return this.v;
    }

    public org.apache.tools.ant.types.Path createModulepath(org.apache.tools.ant.Project project) {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(project);
        }
        return this.x;
    }

    public org.apache.tools.ant.types.Path createUpgrademodulepath(org.apache.tools.ant.Project project) {
        if (this.y == null) {
            this.y = new org.apache.tools.ant.types.Path(project);
        }
        return this.y;
    }

    public org.apache.tools.ant.types.Commandline.Argument createVmArgument() {
        return this.n.createArgument();
    }

    public final boolean d() {
        return this.D || com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(java.lang.System.getProperty("ant.build.clonevm"));
    }

    public java.lang.String describeCommand() {
        return org.apache.tools.ant.types.Commandline.describeCommand(getCommandline());
    }

    public java.lang.String describeJavaCommand() {
        return org.apache.tools.ant.types.Commandline.describeCommand(getJavaCommand());
    }

    public org.apache.tools.ant.types.Commandline getActualVMCommand() {
        org.apache.tools.ant.types.Commandline commandline = (org.apache.tools.ant.types.Commandline) this.n.clone();
        if (this.A != null) {
            if (this.z.startsWith("1.1")) {
                commandline.createArgument().setValue("-mx" + this.A);
            } else {
                commandline.createArgument().setValue("-Xmx" + this.A);
            }
        }
        return commandline;
    }

    public org.apache.tools.ant.types.Assertions getAssertions() {
        return this.B;
    }

    public org.apache.tools.ant.types.Path getBootclasspath() {
        return this.w;
    }

    public java.lang.String getClassname() {
        org.apache.tools.ant.types.CommandlineJava.ExecutableType executableType = this.C;
        if (executableType == null) {
            return null;
        }
        int i = org.apache.tools.ant.types.CommandlineJava.AnonymousClass1.a[executableType.ordinal()];
        if (i == 1) {
            return this.t.getExecutable();
        }
        if (i != 2) {
            return null;
        }
        return e(this.t.getExecutable());
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.v;
    }

    public java.lang.String[] getCommandline() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        a(linkedList.listIterator());
        return (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
    }

    public java.lang.String getJar() {
        if (this.C == org.apache.tools.ant.types.CommandlineJava.ExecutableType.JAR) {
            return this.t.getExecutable();
        }
        return null;
    }

    public org.apache.tools.ant.types.Commandline getJavaCommand() {
        return this.t;
    }

    public java.lang.String getModule() {
        if (this.C == org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE) {
            return f(this.t.getExecutable());
        }
        return null;
    }

    public org.apache.tools.ant.types.Path getModulepath() {
        return this.x;
    }

    public org.apache.tools.ant.types.CommandlineJava.SysProperties getSystemProperties() {
        return this.u;
    }

    public org.apache.tools.ant.types.Path getUpgrademodulepath() {
        return this.y;
    }

    public org.apache.tools.ant.types.Commandline getVmCommand() {
        return getActualVMCommand();
    }

    public java.lang.String getVmversion() {
        return this.z;
    }

    public boolean haveBootclasspath(boolean z) {
        return b(z).size() > 0;
    }

    public boolean haveClasspath() {
        org.apache.tools.ant.types.Path path = this.v;
        org.apache.tools.ant.types.Path concatSystemClasspath = path != null ? path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE) : null;
        return concatSystemClasspath != null && concatSystemClasspath.toString().trim().length() > 0;
    }

    public boolean haveModulepath() {
        org.apache.tools.ant.types.Path path = this.x;
        org.apache.tools.ant.types.Path concatSystemClasspath = path != null ? path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE) : null;
        return concatSystemClasspath != null && concatSystemClasspath.toString().trim().length() > 0;
    }

    public boolean haveUpgrademodulepath() {
        org.apache.tools.ant.types.Path path = this.y;
        org.apache.tools.ant.types.Path concatSystemClasspath = path != null ? path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE) : null;
        return concatSystemClasspath != null && concatSystemClasspath.toString().trim().length() > 0;
    }

    public void restoreSystemProperties() throws org.apache.tools.ant.BuildException {
        this.u.restoreSystem();
    }

    public void setAssertions(org.apache.tools.ant.types.Assertions assertions) {
        this.B = assertions;
    }

    public void setClassname(java.lang.String str) {
        if (this.C == org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE) {
            org.apache.tools.ant.types.Commandline commandline = this.t;
            commandline.setExecutable(c(f(commandline.getExecutable()), str), false);
        } else {
            this.t.setExecutable(str);
            this.C = org.apache.tools.ant.types.CommandlineJava.ExecutableType.CLASS;
        }
    }

    public void setCloneVm(boolean z) {
        this.D = z;
    }

    public void setJar(java.lang.String str) {
        this.t.setExecutable(str);
        this.C = org.apache.tools.ant.types.CommandlineJava.ExecutableType.JAR;
    }

    public void setMaxmemory(java.lang.String str) {
        this.A = str;
    }

    public void setModule(java.lang.String str) {
        org.apache.tools.ant.types.CommandlineJava.ExecutableType executableType = this.C;
        if (executableType == null) {
            this.t.setExecutable(str);
        } else {
            int i = org.apache.tools.ant.types.CommandlineJava.AnonymousClass1.a[executableType.ordinal()];
            if (i == 1) {
                org.apache.tools.ant.types.Commandline commandline = this.t;
                commandline.setExecutable(c(str, commandline.getExecutable()), false);
            } else if (i == 2) {
                org.apache.tools.ant.types.Commandline commandline2 = this.t;
                commandline2.setExecutable(c(str, e(commandline2.getExecutable())), false);
            } else if (i == 3) {
                this.t.setExecutable(str, false);
            }
        }
        this.C = org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE;
    }

    public void setSystemProperties() throws org.apache.tools.ant.BuildException {
        this.u.setSystem();
    }

    public void setVm(java.lang.String str) {
        this.n.setExecutable(str);
    }

    public void setVmversion(java.lang.String str) {
        this.z = str;
    }

    public int size() {
        int size = getActualVMCommand().size() + this.t.size() + this.u.size();
        if (d()) {
            size += java.lang.System.getProperties().size();
        }
        if (haveClasspath()) {
            size += 2;
        }
        if (b(true).size() > 0) {
            size++;
        }
        org.apache.tools.ant.types.CommandlineJava.ExecutableType executableType = this.C;
        if (executableType == org.apache.tools.ant.types.CommandlineJava.ExecutableType.JAR || executableType == org.apache.tools.ant.types.CommandlineJava.ExecutableType.MODULE) {
            size++;
        }
        return getAssertions() != null ? size + getAssertions().size() : size;
    }

    public java.lang.String toString() {
        return org.apache.tools.ant.types.Commandline.toString(getCommandline());
    }
}
