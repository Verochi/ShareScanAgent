package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class Project implements org.apache.tools.ant.types.ResourceFactory {

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_0 = "1.0";

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_1 = "1.1";

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_2 = "1.2";

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_3 = "1.3";

    @java.lang.Deprecated
    public static final java.lang.String JAVA_1_4 = "1.4";
    public static final org.apache.tools.ant.util.FileUtils K = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final int MSG_DEBUG = 4;
    public static final int MSG_ERR = 0;
    public static final int MSG_INFO = 2;
    public static final int MSG_VERBOSE = 3;
    public static final int MSG_WARN = 1;
    public static final java.lang.String TOKEN_END = "@";
    public static final java.lang.String TOKEN_START = "@";
    public java.io.File A;
    public final java.lang.Object B;
    public volatile org.apache.tools.ant.BuildListener[] C;
    public final java.lang.ThreadLocal<java.lang.Boolean> D;
    public java.lang.ClassLoader E;
    public final java.util.Map<java.lang.Thread, org.apache.tools.ant.Task> F;
    public final java.util.Map<java.lang.ThreadGroup, org.apache.tools.ant.Task> G;
    public org.apache.tools.ant.input.InputHandler H;
    public java.io.InputStream I;
    public boolean J;
    public java.lang.String n;
    public java.lang.String t;
    public java.lang.String w;
    public final org.apache.tools.ant.types.FilterSet y;
    public final org.apache.tools.ant.types.FilterSetCollection z;
    public final java.util.Hashtable<java.lang.String, java.lang.Object> u = new org.apache.tools.ant.Project.AntRefTable();
    public final java.util.HashMap<java.lang.String, java.lang.Object> v = new java.util.HashMap<>();
    public final java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> x = new java.util.Hashtable<>();

    /* renamed from: org.apache.tools.ant.Project$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.ThreadLocal<java.lang.Boolean> {
        public AnonymousClass1() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean initialValue() {
            return java.lang.Boolean.FALSE;
        }
    }

    public static class AntRefTable extends java.util.Hashtable<java.lang.String, java.lang.Object> {
        private static final long serialVersionUID = 1;

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.Object getReal(java.lang.Object obj) {
            return super.get(obj);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public java.lang.Object get(java.lang.Object obj) {
            java.lang.Object real = getReal(obj);
            if (!(real instanceof org.apache.tools.ant.UnknownElement)) {
                return real;
            }
            org.apache.tools.ant.UnknownElement unknownElement = (org.apache.tools.ant.UnknownElement) real;
            unknownElement.maybeConfigure();
            return unknownElement.getRealThing();
        }
    }

    public Project() {
        org.apache.tools.ant.types.FilterSet filterSet = new org.apache.tools.ant.types.FilterSet();
        this.y = filterSet;
        filterSet.setProject(this);
        this.z = new org.apache.tools.ant.types.FilterSetCollection(filterSet);
        this.B = new java.lang.Object();
        this.C = new org.apache.tools.ant.BuildListener[0];
        this.D = new org.apache.tools.ant.Project.AnonymousClass1();
        this.E = null;
        this.F = java.util.Collections.synchronizedMap(new java.util.WeakHashMap());
        this.G = java.util.Collections.synchronizedMap(new java.util.WeakHashMap());
        this.H = null;
        this.I = null;
        this.J = false;
        this.H = new org.apache.tools.ant.input.DefaultInputHandler();
    }

    public static org.apache.tools.ant.BuildException b(java.lang.String str, java.util.Stack<java.lang.String> stack) {
        java.lang.String pop;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Circular dependency: ");
        sb.append(str);
        do {
            pop = stack.pop();
            sb.append(" <- ");
            sb.append(pop);
        } while (!pop.equals(str));
        return new org.apache.tools.ant.BuildException(sb.toString());
    }

    @java.lang.Deprecated
    public static java.lang.String getJavaVersion() {
        return org.apache.tools.ant.util.JavaEnvUtils.getJavaVersion();
    }

    public static org.apache.tools.ant.Project getProject(java.lang.Object obj) {
        if (obj instanceof org.apache.tools.ant.ProjectComponent) {
            return ((org.apache.tools.ant.ProjectComponent) obj).getProject();
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod("getProject", null);
            if (org.apache.tools.ant.Project.class == method.getReturnType()) {
                return (org.apache.tools.ant.Project) method.invoke(obj, null);
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static boolean toBoolean(java.lang.String str) {
        return kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON.equalsIgnoreCase(str) || com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str);
    }

    @java.lang.Deprecated
    public static java.lang.String translatePath(java.lang.String str) {
        return org.apache.tools.ant.util.FileUtils.translatePath(str);
    }

    public final void a(org.apache.tools.ant.BuildEvent buildEvent, java.lang.String str, int i) {
        if (str == null) {
            str = java.lang.String.valueOf(str);
        }
        java.lang.String str2 = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        if (str.endsWith(str2)) {
            buildEvent.setMessage(str.substring(0, str.length() - str2.length()), i);
        } else {
            buildEvent.setMessage(str, i);
        }
        if (this.D.get() != java.lang.Boolean.FALSE) {
            return;
        }
        try {
            this.D.set(java.lang.Boolean.TRUE);
            for (org.apache.tools.ant.BuildListener buildListener : this.C) {
                buildListener.messageLogged(buildEvent);
            }
        } finally {
            this.D.set(java.lang.Boolean.FALSE);
        }
    }

    public void addBuildListener(org.apache.tools.ant.BuildListener buildListener) {
        synchronized (this.B) {
            for (org.apache.tools.ant.BuildListener buildListener2 : this.C) {
                if (buildListener2 == buildListener) {
                    return;
                }
            }
            org.apache.tools.ant.BuildListener[] buildListenerArr = new org.apache.tools.ant.BuildListener[this.C.length + 1];
            java.lang.System.arraycopy(this.C, 0, buildListenerArr, 0, this.C.length);
            buildListenerArr[this.C.length] = buildListener;
            this.C = buildListenerArr;
        }
    }

    public void addDataTypeDefinition(java.lang.String str, java.lang.Class<?> cls) {
        org.apache.tools.ant.ComponentHelper.getComponentHelper(this).addDataTypeDefinition(str, cls);
    }

    @java.lang.Deprecated
    public void addFilter(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return;
        }
        this.y.addFilter(new org.apache.tools.ant.types.FilterSet.Filter(str, str2));
    }

    public void addIdReference(java.lang.String str, java.lang.Object obj) {
        this.v.put(str, obj);
    }

    public void addOrReplaceTarget(java.lang.String str, org.apache.tools.ant.Target target) {
        log(" +Target: " + str, 4);
        target.setProject(this);
        this.x.put(str, target);
    }

    public void addOrReplaceTarget(org.apache.tools.ant.Target target) {
        addOrReplaceTarget(target.getName(), target);
    }

    public void addReference(java.lang.String str, java.lang.Object obj) {
        java.lang.Object real = ((org.apache.tools.ant.Project.AntRefTable) this.u).getReal(str);
        if (real == obj) {
            return;
        }
        if (real != null && !(real instanceof org.apache.tools.ant.UnknownElement)) {
            log("Overriding previous definition of reference to " + str, 3);
        }
        log("Adding reference: " + str, 4);
        this.u.put(str, obj);
    }

    public void addTarget(java.lang.String str, org.apache.tools.ant.Target target) throws org.apache.tools.ant.BuildException {
        if (this.x.get(str) == null) {
            addOrReplaceTarget(str, target);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Duplicate target: `" + str + "'");
    }

    public void addTarget(org.apache.tools.ant.Target target) throws org.apache.tools.ant.BuildException {
        addTarget(target.getName(), target);
    }

    public void addTaskDefinition(java.lang.String str, java.lang.Class<?> cls) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.ComponentHelper.getComponentHelper(this).addTaskDefinition(str, cls);
    }

    public final void c() {
        java.io.File classSource = org.apache.tools.ant.launch.Locator.getClassSource(org.apache.tools.ant.Project.class);
        if (classSource != null) {
            d(org.apache.tools.ant.MagicNames.ANT_LIB, classSource.getAbsolutePath());
        }
    }

    public void checkTaskClass(java.lang.Class<?> cls) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.ComponentHelper.getComponentHelper(this).checkTaskClass(cls);
        if (!java.lang.reflect.Modifier.isPublic(cls.getModifiers())) {
            java.lang.String str = cls + " is not public";
            log(str, 0);
            throw new org.apache.tools.ant.BuildException(str);
        }
        if (java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
            java.lang.String str2 = cls + " is abstract";
            log(str2, 0);
            throw new org.apache.tools.ant.BuildException(str2);
        }
        try {
            cls.getConstructor(new java.lang.Class[0]);
            if (org.apache.tools.ant.Task.class.isAssignableFrom(cls)) {
                return;
            }
            org.apache.tools.ant.TaskAdapter.checkTaskClass(cls, this);
        } catch (java.lang.LinkageError e) {
            java.lang.String str3 = "Could not load " + cls + ": " + e;
            log(str3, 0);
            throw new org.apache.tools.ant.BuildException(str3, e);
        } catch (java.lang.NoSuchMethodException unused) {
            java.lang.String str4 = "No public no-arg constructor in " + cls;
            log(str4, 0);
            throw new org.apache.tools.ant.BuildException(str4);
        }
    }

    @java.lang.Deprecated
    public void copyFile(java.io.File file, java.io.File file2) throws java.io.IOException {
        K.copyFile(file, file2);
    }

    @java.lang.Deprecated
    public void copyFile(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        K.copyFile(file, file2, z ? this.z : null);
    }

    @java.lang.Deprecated
    public void copyFile(java.io.File file, java.io.File file2, boolean z, boolean z2) throws java.io.IOException {
        K.copyFile(file, file2, z ? this.z : null, z2);
    }

    @java.lang.Deprecated
    public void copyFile(java.io.File file, java.io.File file2, boolean z, boolean z2, boolean z3) throws java.io.IOException {
        K.copyFile(file, file2, z ? this.z : null, z2, z3);
    }

    @java.lang.Deprecated
    public void copyFile(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        K.copyFile(str, str2);
    }

    @java.lang.Deprecated
    public void copyFile(java.lang.String str, java.lang.String str2, boolean z) throws java.io.IOException {
        K.copyFile(str, str2, z ? this.z : null);
    }

    @java.lang.Deprecated
    public void copyFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2) throws java.io.IOException {
        K.copyFile(str, str2, z ? this.z : null, z2);
    }

    @java.lang.Deprecated
    public void copyFile(java.lang.String str, java.lang.String str2, boolean z, boolean z2, boolean z3) throws java.io.IOException {
        K.copyFile(str, str2, z ? this.z : null, z2, z3);
    }

    public void copyInheritedProperties(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).copyInheritedProperties(project);
    }

    public void copyUserProperties(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).copyUserProperties(project);
    }

    public org.apache.tools.ant.AntClassLoader createClassLoader(java.lang.ClassLoader classLoader, org.apache.tools.ant.types.Path path) {
        return org.apache.tools.ant.AntClassLoader.newAntClassLoader(classLoader, this, path, true);
    }

    public org.apache.tools.ant.AntClassLoader createClassLoader(org.apache.tools.ant.types.Path path) {
        return org.apache.tools.ant.AntClassLoader.newAntClassLoader(getClass().getClassLoader(), this, path, true);
    }

    public java.lang.Object createDataType(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return org.apache.tools.ant.ComponentHelper.getComponentHelper(this).createDataType(str);
    }

    public org.apache.tools.ant.Project createSubProject() {
        org.apache.tools.ant.Project project;
        try {
            project = (org.apache.tools.ant.Project) getClass().newInstance();
        } catch (java.lang.Exception unused) {
            project = new org.apache.tools.ant.Project();
        }
        initSubProject(project);
        return project;
    }

    public org.apache.tools.ant.Task createTask(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return org.apache.tools.ant.ComponentHelper.getComponentHelper(this).createTask(str);
    }

    public final void d(java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).setProperty(str, (java.lang.Object) str2, false);
    }

    public int defaultInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.I == null) {
            throw new java.io.EOFException("No input provided for project");
        }
        java.lang.System.out.flush();
        return this.I.read(bArr, i, i2);
    }

    public void demuxFlush(java.lang.String str, boolean z) {
        org.apache.tools.ant.Task threadTask = getThreadTask(java.lang.Thread.currentThread());
        if (threadTask == null) {
            fireMessageLogged(this, str, z ? 0 : 2);
        } else if (z) {
            threadTask.handleErrorFlush(str);
        } else {
            threadTask.handleFlush(str);
        }
    }

    public int demuxInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        org.apache.tools.ant.Task threadTask = getThreadTask(java.lang.Thread.currentThread());
        return threadTask == null ? defaultInput(bArr, i, i2) : threadTask.handleInput(bArr, i, i2);
    }

    public void demuxOutput(java.lang.String str, boolean z) {
        org.apache.tools.ant.Task threadTask = getThreadTask(java.lang.Thread.currentThread());
        if (threadTask == null) {
            log(str, z ? 1 : 2);
        } else if (z) {
            threadTask.handleErrorOutput(str);
        } else {
            threadTask.handleOutput(str);
        }
    }

    public final void e(java.lang.String str, java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> hashtable, java.util.Hashtable<java.lang.String, java.lang.String> hashtable2, java.util.Stack<java.lang.String> stack, java.util.Vector<org.apache.tools.ant.Target> vector) throws org.apache.tools.ant.BuildException {
        hashtable2.put(str, "VISITING");
        stack.push(str);
        org.apache.tools.ant.Target target = hashtable.get(str);
        if (target == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Target \"");
            sb.append(str);
            sb.append("\" does not exist in the project \"");
            sb.append(this.n);
            sb.append("\". ");
            stack.pop();
            if (!stack.empty()) {
                java.lang.String peek = stack.peek();
                sb.append("It is used from target \"");
                sb.append(peek);
                sb.append("\".");
            }
            throw new org.apache.tools.ant.BuildException(new java.lang.String(sb));
        }
        java.util.Enumeration<java.lang.String> dependencies = target.getDependencies();
        while (dependencies.hasMoreElements()) {
            java.lang.String nextElement = dependencies.nextElement();
            java.lang.String str2 = hashtable2.get(nextElement);
            if (str2 == null) {
                e(nextElement, hashtable, hashtable2, stack, vector);
            } else if (str2 == "VISITING") {
                throw b(nextElement, stack);
            }
        }
        java.lang.String pop = stack.pop();
        if (str == pop) {
            hashtable2.put(str, "VISITED");
            vector.addElement(target);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Unexpected internal error: expected to pop " + str + " but got " + pop);
    }

    public void executeSortedTargets(java.util.Vector<org.apache.tools.ant.Target> vector) throws org.apache.tools.ant.BuildException {
        boolean z;
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<org.apache.tools.ant.Target> it = vector.iterator();
        org.apache.tools.ant.BuildException buildException = null;
        while (it.hasNext()) {
            org.apache.tools.ant.Target next = it.next();
            java.util.Enumeration<java.lang.String> dependencies = next.getDependencies();
            while (true) {
                if (!dependencies.hasMoreElements()) {
                    z = true;
                    break;
                }
                java.lang.String nextElement = dependencies.nextElement();
                if (!hashSet.contains(nextElement)) {
                    log(next, "Cannot execute '" + next.getName() + "' - '" + nextElement + "' failed or was not executed.", 0);
                    z = false;
                    break;
                }
            }
            if (z) {
                try {
                    next.performTasks();
                    hashSet.add(next.getName());
                    e = null;
                } catch (java.lang.RuntimeException e) {
                    e = e;
                    if (!this.J) {
                        throw e;
                    }
                } catch (java.lang.Throwable th) {
                    e = th;
                    if (!this.J) {
                        throw new org.apache.tools.ant.BuildException(e);
                    }
                }
                if (e != null) {
                    if (e instanceof org.apache.tools.ant.BuildException) {
                        log(next, "Target '" + next.getName() + "' failed with message '" + e.getMessage() + "'.", 0);
                        if (buildException == null) {
                            buildException = (org.apache.tools.ant.BuildException) e;
                        }
                    } else {
                        log(next, "Target '" + next.getName() + "' failed with message '" + e.getMessage() + "'.", 0);
                        e.printStackTrace(java.lang.System.err);
                        if (buildException == null) {
                            buildException = new org.apache.tools.ant.BuildException(e);
                        }
                    }
                }
            }
        }
        if (buildException != null) {
            throw buildException;
        }
    }

    public void executeTarget(java.lang.String str) throws org.apache.tools.ant.BuildException {
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("No target specified");
        }
        executeSortedTargets(topoSort(str, this.x, false));
    }

    public void executeTargets(java.util.Vector<java.lang.String> vector) throws org.apache.tools.ant.BuildException {
        setUserProperty(org.apache.tools.ant.MagicNames.PROJECT_INVOKED_TARGETS, org.apache.tools.ant.util.CollectionUtils.flattenToString(vector));
        getExecutor().executeTargets(this, (java.lang.String[]) vector.toArray(new java.lang.String[vector.size()]));
    }

    public void fireBuildFinished(java.lang.Throwable th) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(this);
        buildEvent.setException(th);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.buildFinished(buildEvent);
        }
        org.apache.tools.ant.IntrospectionHelper.clearCache();
    }

    public void fireBuildStarted() {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(this);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.buildStarted(buildEvent);
        }
    }

    public void fireMessageLogged(org.apache.tools.ant.Project project, java.lang.String str, int i) {
        fireMessageLogged(project, str, (java.lang.Throwable) null, i);
    }

    public void fireMessageLogged(org.apache.tools.ant.Project project, java.lang.String str, java.lang.Throwable th, int i) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(project);
        buildEvent.setException(th);
        a(buildEvent, str, i);
    }

    public void fireMessageLogged(org.apache.tools.ant.Target target, java.lang.String str, int i) {
        fireMessageLogged(target, str, (java.lang.Throwable) null, i);
    }

    public void fireMessageLogged(org.apache.tools.ant.Target target, java.lang.String str, java.lang.Throwable th, int i) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(target);
        buildEvent.setException(th);
        a(buildEvent, str, i);
    }

    public void fireMessageLogged(org.apache.tools.ant.Task task, java.lang.String str, int i) {
        fireMessageLogged(task, str, (java.lang.Throwable) null, i);
    }

    public void fireMessageLogged(org.apache.tools.ant.Task task, java.lang.String str, java.lang.Throwable th, int i) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(task);
        buildEvent.setException(th);
        a(buildEvent, str, i);
    }

    public void fireSubBuildFinished(java.lang.Throwable th) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(this);
        buildEvent.setException(th);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            if (buildListener instanceof org.apache.tools.ant.SubBuildListener) {
                ((org.apache.tools.ant.SubBuildListener) buildListener).subBuildFinished(buildEvent);
            }
        }
    }

    public void fireSubBuildStarted() {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(this);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            if (buildListener instanceof org.apache.tools.ant.SubBuildListener) {
                ((org.apache.tools.ant.SubBuildListener) buildListener).subBuildStarted(buildEvent);
            }
        }
    }

    public void fireTargetFinished(org.apache.tools.ant.Target target, java.lang.Throwable th) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(target);
        buildEvent.setException(th);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.targetFinished(buildEvent);
        }
    }

    public void fireTargetStarted(org.apache.tools.ant.Target target) {
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(target);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.targetStarted(buildEvent);
        }
    }

    public void fireTaskFinished(org.apache.tools.ant.Task task, java.lang.Throwable th) {
        registerThreadTask(java.lang.Thread.currentThread(), null);
        java.lang.System.out.flush();
        java.lang.System.err.flush();
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(task);
        buildEvent.setException(th);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.taskFinished(buildEvent);
        }
    }

    public void fireTaskStarted(org.apache.tools.ant.Task task) {
        registerThreadTask(java.lang.Thread.currentThread(), task);
        org.apache.tools.ant.BuildEvent buildEvent = new org.apache.tools.ant.BuildEvent(task);
        for (org.apache.tools.ant.BuildListener buildListener : this.C) {
            buildListener.taskStarted(buildEvent);
        }
    }

    public java.io.File getBaseDir() {
        if (this.A == null) {
            try {
                setBasedir(".");
            } catch (org.apache.tools.ant.BuildException e) {
                e.printStackTrace();
            }
        }
        return this.A;
    }

    public java.util.Vector<org.apache.tools.ant.BuildListener> getBuildListeners() {
        java.util.Vector<org.apache.tools.ant.BuildListener> vector;
        synchronized (this.B) {
            vector = new java.util.Vector<>(this.C.length);
            for (org.apache.tools.ant.BuildListener buildListener : this.C) {
                vector.add(buildListener);
            }
        }
        return vector;
    }

    public java.util.Map<java.lang.String, java.lang.Class<?>> getCopyOfDataTypeDefinitions() {
        return new java.util.HashMap(getDataTypeDefinitions());
    }

    public java.util.Map<java.lang.String, java.lang.Object> getCopyOfReferences() {
        return new java.util.HashMap(this.u);
    }

    public java.util.Map<java.lang.String, org.apache.tools.ant.Target> getCopyOfTargets() {
        return new java.util.HashMap(this.x);
    }

    public java.util.Map<java.lang.String, java.lang.Class<?>> getCopyOfTaskDefinitions() {
        return new java.util.HashMap(getTaskDefinitions());
    }

    public java.lang.ClassLoader getCoreLoader() {
        return this.E;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Class<?>> getDataTypeDefinitions() {
        return org.apache.tools.ant.ComponentHelper.getComponentHelper(this).getDataTypeDefinitions();
    }

    public java.io.InputStream getDefaultInputStream() {
        return this.I;
    }

    public java.lang.String getDefaultTarget() {
        return this.w;
    }

    public java.lang.String getDescription() {
        if (this.t == null) {
            this.t = org.apache.tools.ant.types.Description.getDescription(this);
        }
        return this.t;
    }

    public java.lang.String getElementName(java.lang.Object obj) {
        return org.apache.tools.ant.ComponentHelper.getComponentHelper(this).getElementName(obj);
    }

    public org.apache.tools.ant.Executor getExecutor() {
        java.lang.Object obj;
        java.lang.Object reference = getReference(org.apache.tools.ant.MagicNames.ANT_EXECUTOR_REFERENCE);
        java.lang.Object obj2 = reference;
        if (reference == null) {
            java.lang.String property = getProperty(org.apache.tools.ant.MagicNames.ANT_EXECUTOR_CLASSNAME);
            if (property == null) {
                property = org.apache.tools.ant.helper.DefaultExecutor.class.getName();
            }
            log("Attempting to create object of type " + property, 4);
            try {
                try {
                    obj = java.lang.Class.forName(property, true, this.E).newInstance();
                } catch (java.lang.Exception e) {
                    log(e.toString(), 0);
                    obj = reference;
                }
            } catch (java.lang.ClassNotFoundException unused) {
                obj = java.lang.Class.forName(property).newInstance();
            } catch (java.lang.Exception e2) {
                log(e2.toString(), 0);
                obj = reference;
            }
            if (obj == null) {
                throw new org.apache.tools.ant.BuildException("Unable to obtain a Target Executor instance.");
            }
            setExecutor((org.apache.tools.ant.Executor) obj);
            obj2 = obj;
        }
        return (org.apache.tools.ant.Executor) obj2;
    }

    @java.lang.Deprecated
    public java.util.Hashtable<java.lang.String, java.lang.String> getFilters() {
        return this.y.getFilterHash();
    }

    public org.apache.tools.ant.types.FilterSet getGlobalFilterSet() {
        return this.y;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getInheritedProperties() {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).getInheritedProperties();
    }

    public org.apache.tools.ant.input.InputHandler getInputHandler() {
        return this.H;
    }

    public java.lang.String getName() {
        return this.n;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getProperties() {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).getProperties();
    }

    public java.lang.String getProperty(java.lang.String str) {
        java.lang.Object property = org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).getProperty(str);
        if (property == null) {
            return null;
        }
        return java.lang.String.valueOf(property);
    }

    public <T> T getReference(java.lang.String str) {
        T t = (T) this.u.get(str);
        if (t != null) {
            return t;
        }
        if (str.equals(org.apache.tools.ant.MagicNames.REFID_PROPERTY_HELPER)) {
            return null;
        }
        try {
            if (!org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).containsProperties(str)) {
                return null;
            }
            log("Unresolvable reference " + str + " might be a misuse of property expansion syntax.", 1);
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getReferences() {
        return this.u;
    }

    @Override // org.apache.tools.ant.types.ResourceFactory
    public org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
        return new org.apache.tools.ant.types.resources.FileResource(getBaseDir(), str);
    }

    public java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> getTargets() {
        return this.x;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Class<?>> getTaskDefinitions() {
        return org.apache.tools.ant.ComponentHelper.getComponentHelper(this).getTaskDefinitions();
    }

    public org.apache.tools.ant.Task getThreadTask(java.lang.Thread thread) {
        org.apache.tools.ant.Task task;
        synchronized (this.F) {
            task = this.F.get(thread);
            if (task == null) {
                for (java.lang.ThreadGroup threadGroup = thread.getThreadGroup(); task == null && threadGroup != null; threadGroup = threadGroup.getParent()) {
                    task = this.G.get(threadGroup);
                }
            }
        }
        return task;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Object> getUserProperties() {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).getUserProperties();
    }

    public java.lang.String getUserProperty(java.lang.String str) {
        return (java.lang.String) org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).getUserProperty(str);
    }

    public boolean hasReference(java.lang.String str) {
        return this.u.containsKey(str);
    }

    public void inheritIDReferences(org.apache.tools.ant.Project project) {
    }

    public void init() throws org.apache.tools.ant.BuildException {
        initProperties();
        org.apache.tools.ant.ComponentHelper.getComponentHelper(this).initDefaultDefinitions();
    }

    public void initProperties() throws org.apache.tools.ant.BuildException {
        setJavaVersionProperty();
        setSystemProperties();
        d(org.apache.tools.ant.MagicNames.ANT_VERSION, org.apache.tools.ant.Main.getAntVersion());
        c();
    }

    public void initSubProject(org.apache.tools.ant.Project project) {
        org.apache.tools.ant.ComponentHelper.getComponentHelper(project).initSubProject(org.apache.tools.ant.ComponentHelper.getComponentHelper(this));
        project.setDefaultInputStream(getDefaultInputStream());
        project.setKeepGoingMode(isKeepGoingMode());
        project.setExecutor(getExecutor().getSubProjectExecutor());
    }

    public boolean isKeepGoingMode() {
        return this.J;
    }

    public void log(java.lang.String str) {
        log(str, 2);
    }

    public void log(java.lang.String str, int i) {
        log(str, (java.lang.Throwable) null, i);
    }

    public void log(java.lang.String str, java.lang.Throwable th, int i) {
        fireMessageLogged(this, str, th, i);
    }

    public void log(org.apache.tools.ant.Target target, java.lang.String str, int i) {
        log(target, str, (java.lang.Throwable) null, i);
    }

    public void log(org.apache.tools.ant.Target target, java.lang.String str, java.lang.Throwable th, int i) {
        fireMessageLogged(target, str, th, i);
    }

    public void log(org.apache.tools.ant.Task task, java.lang.String str, int i) {
        fireMessageLogged(task, str, (java.lang.Throwable) null, i);
    }

    public void log(org.apache.tools.ant.Task task, java.lang.String str, java.lang.Throwable th, int i) {
        fireMessageLogged(task, str, th, i);
    }

    public void registerThreadTask(java.lang.Thread thread, org.apache.tools.ant.Task task) {
        synchronized (this.F) {
            if (task != null) {
                this.F.put(thread, task);
                this.G.put(thread.getThreadGroup(), task);
            } else {
                this.F.remove(thread);
                this.G.remove(thread.getThreadGroup());
            }
        }
    }

    public void removeBuildListener(org.apache.tools.ant.BuildListener buildListener) {
        synchronized (this.B) {
            int i = 0;
            while (true) {
                if (i >= this.C.length) {
                    break;
                }
                if (this.C[i] == buildListener) {
                    org.apache.tools.ant.BuildListener[] buildListenerArr = new org.apache.tools.ant.BuildListener[this.C.length - 1];
                    java.lang.System.arraycopy(this.C, 0, buildListenerArr, 0, i);
                    java.lang.System.arraycopy(this.C, i + 1, buildListenerArr, i, (this.C.length - i) - 1);
                    this.C = buildListenerArr;
                    break;
                }
                i++;
            }
        }
    }

    public java.lang.String replaceProperties(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).replaceProperties(null, str, null);
    }

    public java.io.File resolveFile(java.lang.String str) {
        return K.resolveFile(this.A, str);
    }

    @java.lang.Deprecated
    public java.io.File resolveFile(java.lang.String str, java.io.File file) {
        return K.resolveFile(file, str);
    }

    public void setBaseDir(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.File normalize = K.normalize(file.getAbsolutePath());
        if (!normalize.exists()) {
            throw new org.apache.tools.ant.BuildException("Basedir " + normalize.getAbsolutePath() + " does not exist");
        }
        if (!normalize.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("Basedir " + normalize.getAbsolutePath() + " is not a directory");
        }
        this.A = normalize;
        d(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR, normalize.getPath());
        log("Project base dir set to: " + this.A, 3);
    }

    public void setBasedir(java.lang.String str) throws org.apache.tools.ant.BuildException {
        setBaseDir(new java.io.File(str));
    }

    public void setCoreLoader(java.lang.ClassLoader classLoader) {
        this.E = classLoader;
    }

    public void setDefault(java.lang.String str) {
        if (str != null) {
            setUserProperty(org.apache.tools.ant.MagicNames.PROJECT_DEFAULT_TARGET, str);
        }
        this.w = str;
    }

    public void setDefaultInputStream(java.io.InputStream inputStream) {
        this.I = inputStream;
    }

    @java.lang.Deprecated
    public void setDefaultTarget(java.lang.String str) {
        setDefault(str);
    }

    public void setDescription(java.lang.String str) {
        this.t = str;
    }

    public void setExecutor(org.apache.tools.ant.Executor executor) {
        addReference(org.apache.tools.ant.MagicNames.ANT_EXECUTOR_REFERENCE, executor);
    }

    @java.lang.Deprecated
    public void setFileLastModified(java.io.File file, long j) throws org.apache.tools.ant.BuildException {
        K.setFileLastModified(file, j);
        log("Setting modification time for " + file, 3);
    }

    public void setInheritedProperty(java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).setInheritedProperty(str, str2);
    }

    public void setInputHandler(org.apache.tools.ant.input.InputHandler inputHandler) {
        this.H = inputHandler;
    }

    public void setJavaVersionProperty() throws org.apache.tools.ant.BuildException {
        java.lang.String javaVersion = org.apache.tools.ant.util.JavaEnvUtils.getJavaVersion();
        d(org.apache.tools.ant.MagicNames.ANT_JAVA_VERSION, javaVersion);
        if (!org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)) {
            throw new org.apache.tools.ant.BuildException("Ant cannot work on Java prior to 1.5");
        }
        log("Detected Java version: " + javaVersion + " in: " + java.lang.System.getProperty("java.home"), 3);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Detected OS: ");
        sb.append(java.lang.System.getProperty("os.name"));
        log(sb.toString(), 3);
    }

    public void setKeepGoingMode(boolean z) {
        this.J = z;
    }

    public void setName(java.lang.String str) {
        setUserProperty(org.apache.tools.ant.MagicNames.PROJECT_NAME, str);
        this.n = str;
    }

    public void setNewProperty(java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).setNewProperty(str, str2);
    }

    public final void setProjectReference(java.lang.Object obj) {
        if (obj instanceof org.apache.tools.ant.ProjectComponent) {
            ((org.apache.tools.ant.ProjectComponent) obj).setProject(this);
            return;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod("setProject", org.apache.tools.ant.Project.class);
            if (method != null) {
                method.invoke(obj, this);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setProperty(java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).setProperty(str, (java.lang.Object) str2, true);
    }

    public void setSystemProperties() {
        java.util.Properties properties = java.lang.System.getProperties();
        java.util.Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            java.lang.String property = properties.getProperty(str);
            if (property != null) {
                d(str, property);
            }
        }
    }

    public void setUserProperty(java.lang.String str, java.lang.String str2) {
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(this).setUserProperty(str, str2);
    }

    public final java.util.Vector<org.apache.tools.ant.Target> topoSort(java.lang.String str, java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> hashtable) throws org.apache.tools.ant.BuildException {
        return topoSort(new java.lang.String[]{str}, hashtable, true);
    }

    public final java.util.Vector<org.apache.tools.ant.Target> topoSort(java.lang.String str, java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> hashtable, boolean z) throws org.apache.tools.ant.BuildException {
        return topoSort(new java.lang.String[]{str}, hashtable, z);
    }

    public final java.util.Vector<org.apache.tools.ant.Target> topoSort(java.lang.String[] strArr, java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> hashtable, boolean z) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.util.VectorSet vectorSet = new org.apache.tools.ant.util.VectorSet();
        java.util.Hashtable<java.lang.String, java.lang.String> hashtable2 = new java.util.Hashtable<>();
        java.util.Stack<java.lang.String> stack = new java.util.Stack<>();
        int i = 0;
        for (java.lang.String str : strArr) {
            java.lang.String str2 = hashtable2.get(str);
            if (str2 == null) {
                e(str, hashtable, hashtable2, stack, vectorSet);
            } else if (str2 == "VISITING") {
                throw new org.apache.tools.ant.BuildException("Unexpected node in visiting state: " + str);
            }
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Build sequence for target(s)");
        while (i < strArr.length) {
            stringBuffer.append(i == 0 ? " `" : ", `");
            stringBuffer.append(strArr[i]);
            stringBuffer.append('\'');
            i++;
        }
        stringBuffer.append(" is ");
        stringBuffer.append(vectorSet);
        log(stringBuffer.toString(), 3);
        java.util.Vector<org.apache.tools.ant.Target> vector = z ? vectorSet : new java.util.Vector<>(vectorSet);
        java.util.Enumeration<java.lang.String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            java.lang.String nextElement = keys.nextElement();
            java.lang.String str3 = hashtable2.get(nextElement);
            if (str3 == null) {
                e(nextElement, hashtable, hashtable2, stack, vector);
            } else if (str3 == "VISITING") {
                throw new org.apache.tools.ant.BuildException("Unexpected node in visiting state: " + nextElement);
            }
        }
        log("Complete build sequence is " + vector, 3);
        return vectorSet;
    }
}
