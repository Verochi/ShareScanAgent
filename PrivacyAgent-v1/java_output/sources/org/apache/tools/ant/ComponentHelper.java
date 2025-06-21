package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class ComponentHelper {
    public static final java.lang.String COMPONENT_HELPER_REFERENCE = "ant.ComponentHelper";
    public static java.util.Properties[] l = new java.util.Properties[2];
    public java.util.Map<java.lang.String, java.util.List<org.apache.tools.ant.AntTypeDefinition>> a = new java.util.HashMap();
    public final java.util.Hashtable<java.lang.String, org.apache.tools.ant.AntTypeDefinition> b = new java.util.Hashtable<>();
    public final java.util.Hashtable<java.lang.String, java.lang.Class<?>> c = new java.util.Hashtable<>();
    public boolean d = true;
    public final java.util.Hashtable<java.lang.String, java.lang.Class<?>> e = new java.util.Hashtable<>();
    public boolean f = true;
    public final java.util.HashSet<java.lang.String> g = new java.util.HashSet<>();
    public java.util.Stack<java.lang.String> h = new java.util.Stack<>();
    public java.lang.String i = null;
    public org.apache.tools.ant.ComponentHelper j;
    public org.apache.tools.ant.Project k;

    public static synchronized java.util.Properties f(boolean z) throws org.apache.tools.ant.BuildException {
        java.util.Properties properties;
        synchronized (org.apache.tools.ant.ComponentHelper.class) {
            char c = z ? (char) 1 : (char) 0;
            if (l[c] == null) {
                java.lang.String str = z ? org.apache.tools.ant.MagicNames.TYPEDEFS_PROPERTIES_RESOURCE : org.apache.tools.ant.MagicNames.TASKDEF_PROPERTIES_RESOURCE;
                java.lang.String str2 = z ? "Can't load default type list" : "Can't load default task list";
                try {
                    try {
                        java.io.InputStream resourceAsStream = org.apache.tools.ant.ComponentHelper.class.getResourceAsStream(str);
                        if (resourceAsStream == null) {
                            throw new org.apache.tools.ant.BuildException(str2);
                        }
                        java.util.Properties properties2 = new java.util.Properties();
                        properties2.load(resourceAsStream);
                        l[c] = properties2;
                        org.apache.tools.ant.util.FileUtils.close(resourceAsStream);
                    } catch (java.io.IOException e) {
                        throw new org.apache.tools.ant.BuildException(str2, e);
                    }
                } catch (java.lang.Throwable th) {
                    org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
                    throw th;
                }
            }
            properties = l[c];
        }
        return properties;
    }

    public static org.apache.tools.ant.ComponentHelper getComponentHelper(org.apache.tools.ant.Project project) {
        if (project == null) {
            return null;
        }
        org.apache.tools.ant.ComponentHelper componentHelper = (org.apache.tools.ant.ComponentHelper) project.getReference(COMPONENT_HELPER_REFERENCE);
        if (componentHelper != null) {
            return componentHelper;
        }
        org.apache.tools.ant.ComponentHelper componentHelper2 = new org.apache.tools.ant.ComponentHelper();
        componentHelper2.setProject(project);
        project.addReference(COMPONENT_HELPER_REFERENCE, componentHelper2);
        return componentHelper2;
    }

    public static java.lang.String getElementName(org.apache.tools.ant.Project project, java.lang.Object obj, boolean z) {
        if (project == null) {
            project = org.apache.tools.ant.Project.getProject(obj);
        }
        return project == null ? h(obj.getClass(), z) : getComponentHelper(project).getElementName(obj, z);
    }

    public static java.lang.String h(java.lang.Class<?> cls, boolean z) {
        if (!z) {
            return cls.toString();
        }
        java.lang.String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    public final synchronized void a(java.lang.String str) {
        java.lang.String extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(str);
        if ("".equals(extractUriFromComponentName)) {
            extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.ANT_CORE_URI;
        }
        if (extractUriFromComponentName.startsWith("antlib:")) {
            if (this.g.contains(extractUriFromComponentName)) {
                return;
            }
            this.g.add(extractUriFromComponentName);
            if (this.b.size() == 0) {
                initDefaultDefinitions();
            }
            org.apache.tools.ant.taskdefs.Typedef typedef = new org.apache.tools.ant.taskdefs.Typedef();
            typedef.setProject(this.k);
            typedef.init();
            typedef.setURI(extractUriFromComponentName);
            typedef.setTaskName(extractUriFromComponentName);
            typedef.setResource(org.apache.tools.ant.taskdefs.Definer.makeResourceFromURI(extractUriFromComponentName));
            typedef.setOnError(new org.apache.tools.ant.taskdefs.Definer.OnError(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE));
            typedef.execute();
        }
    }

    public void addDataTypeDefinition(java.lang.String str, java.lang.Class<?> cls) {
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        antTypeDefinition.setName(str);
        antTypeDefinition.setClass(cls);
        o(antTypeDefinition);
        this.k.log(" +User datatype: " + str + "     " + cls.getName(), 4);
    }

    public void addDataTypeDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition) {
        if (antTypeDefinition.isRestrict()) {
            p(antTypeDefinition);
        } else {
            o(antTypeDefinition);
        }
    }

    public void addTaskDefinition(java.lang.String str, java.lang.Class<?> cls) {
        checkTaskClass(cls);
        org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
        antTypeDefinition.setName(str);
        antTypeDefinition.setClassLoader(cls.getClassLoader());
        antTypeDefinition.setClass(cls);
        antTypeDefinition.setAdapterClass(org.apache.tools.ant.TaskAdapter.class);
        antTypeDefinition.setClassName(cls.getName());
        antTypeDefinition.setAdaptToClass(org.apache.tools.ant.Task.class);
        o(antTypeDefinition);
    }

    public final org.apache.tools.ant.Task b(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.lang.Object createComponent;
        java.lang.Class<?> componentClass = getComponentClass(str);
        if (componentClass == null || !org.apache.tools.ant.Task.class.isAssignableFrom(componentClass) || (createComponent = createComponent(str)) == null) {
            return null;
        }
        if (!(createComponent instanceof org.apache.tools.ant.Task)) {
            throw new org.apache.tools.ant.BuildException("Expected a Task from '" + str + "' but got an instance of " + createComponent.getClass().getName() + " instead");
        }
        org.apache.tools.ant.Task task = (org.apache.tools.ant.Task) createComponent;
        task.setTaskType(str);
        task.setTaskName(str);
        this.k.log("   +Task: " + str, 4);
        return task;
    }

    public final java.util.List<org.apache.tools.ant.AntTypeDefinition> c(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.b) {
            for (org.apache.tools.ant.AntTypeDefinition antTypeDefinition : this.b.values()) {
                if (antTypeDefinition.getName().startsWith(str)) {
                    arrayList.add(antTypeDefinition);
                }
            }
        }
        return arrayList;
    }

    public void checkTaskClass(java.lang.Class<?> cls) throws org.apache.tools.ant.BuildException {
        if (!java.lang.reflect.Modifier.isPublic(cls.getModifiers())) {
            java.lang.String str = cls + " is not public";
            this.k.log(str, 0);
            throw new org.apache.tools.ant.BuildException(str);
        }
        if (java.lang.reflect.Modifier.isAbstract(cls.getModifiers())) {
            java.lang.String str2 = cls + " is abstract";
            this.k.log(str2, 0);
            throw new org.apache.tools.ant.BuildException(str2);
        }
        try {
            cls.getConstructor(null);
            if (org.apache.tools.ant.Task.class.isAssignableFrom(cls)) {
                return;
            }
            org.apache.tools.ant.TaskAdapter.checkTaskClass(cls, this.k);
        } catch (java.lang.NoSuchMethodException unused) {
            java.lang.String str3 = "No public no-arg constructor in " + cls;
            this.k.log(str3, 0);
            throw new org.apache.tools.ant.BuildException(str3);
        }
    }

    public java.lang.Object createComponent(java.lang.String str) {
        org.apache.tools.ant.AntTypeDefinition definition = getDefinition(str);
        if (definition == null) {
            return null;
        }
        return definition.create(this.k);
    }

    public java.lang.Object createComponent(org.apache.tools.ant.UnknownElement unknownElement, java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.lang.Object createComponent = createComponent(str2);
        if (createComponent instanceof org.apache.tools.ant.Task) {
            org.apache.tools.ant.Task task = (org.apache.tools.ant.Task) createComponent;
            task.setLocation(unknownElement.getLocation());
            task.setTaskType(str2);
            task.setTaskName(unknownElement.getTaskName());
            task.setOwningTarget(unknownElement.getOwningTarget());
            task.init();
        }
        return createComponent;
    }

    public java.lang.Object createDataType(java.lang.String str) throws org.apache.tools.ant.BuildException {
        return createComponent(str);
    }

    public org.apache.tools.ant.Task createTask(java.lang.String str) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Task b = b(str);
        if (b != null || !str.equals(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY)) {
            return b;
        }
        addTaskDefinition(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY, org.apache.tools.ant.taskdefs.Property.class);
        return b(str);
    }

    public final synchronized java.util.Set<java.lang.String> d() {
        return (java.util.Set) this.g.clone();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String diagnoseCreationFailure(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        boolean z;
        boolean z2;
        boolean z3;
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        printWriter.println("Problem: failed to create " + str2 + " " + str);
        java.io.File file = new java.io.File(java.lang.System.getProperty(org.apache.tools.ant.launch.Launcher.USER_HOMEDIR), org.apache.tools.ant.launch.Launcher.USER_LIBDIR);
        java.lang.String property = java.lang.System.getProperty("ant.home");
        boolean z4 = true;
        boolean z5 = false;
        if (property != null) {
            str3 = new java.io.File(property, "lib").getAbsolutePath();
            z = false;
        } else {
            str3 = "ANT_HOME" + java.io.File.separatorChar + "lib";
            z = true;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("        -");
        stringBuffer.append(str3);
        stringBuffer.append('\n');
        if (z) {
            stringBuffer.append("        -");
            stringBuffer.append("the IDE Ant configuration dialogs");
        } else {
            stringBuffer.append("        -");
            stringBuffer.append(file);
            stringBuffer.append('\n');
            stringBuffer.append("        -");
            stringBuffer.append("a directory added on the command line with the -lib argument");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        org.apache.tools.ant.AntTypeDefinition definition = getDefinition(str);
        if (definition == null) {
            m(printWriter, str, stringBuffer2);
        } else {
            java.lang.String className = definition.getClassName();
            boolean startsWith = className.startsWith("org.apache.tools.ant.");
            boolean startsWith2 = className.startsWith("org.apache.tools.ant.taskdefs.optional") | className.startsWith("org.apache.tools.ant.types.optional");
            java.lang.Class<?> cls = null;
            try {
                cls = definition.innerGetTypeClass();
                z2 = false;
            } catch (java.lang.ClassNotFoundException unused) {
                z3 = !startsWith2;
                k(printWriter, className, startsWith2, stringBuffer2);
                z2 = true;
            } catch (java.lang.NoClassDefFoundError e) {
                l(printWriter, startsWith2, e, stringBuffer2);
                z2 = true;
            }
            z3 = false;
            if (cls != null) {
                try {
                    definition.innerCreateAndSet(cls, this.k);
                    printWriter.println("The component could be instantiated.");
                } catch (java.lang.IllegalAccessException unused2) {
                    printWriter.println("Cause: The constructor for " + className + " is private and cannot be invoked.");
                    z4 = z2;
                    z5 = true;
                    printWriter.println();
                    printWriter.println("Do not panic, this is a common problem.");
                    if (z3) {
                    }
                    if (z4) {
                    }
                    if (z5) {
                    }
                    printWriter.flush();
                    printWriter.close();
                    return stringWriter.toString();
                } catch (java.lang.InstantiationException unused3) {
                    printWriter.println("Cause: The class " + className + " is abstract and cannot be instantiated.");
                    z4 = z2;
                    z5 = true;
                    printWriter.println();
                    printWriter.println("Do not panic, this is a common problem.");
                    if (z3) {
                    }
                    if (z4) {
                    }
                    if (z5) {
                    }
                    printWriter.flush();
                    printWriter.close();
                    return stringWriter.toString();
                } catch (java.lang.NoClassDefFoundError e2) {
                    printWriter.println("Cause:  A class needed by class " + className + " cannot be found: ");
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("       ");
                    sb.append(e2.getMessage());
                    printWriter.println(sb.toString());
                    printWriter.println("Action: Determine what extra JAR files are needed, and place them in:");
                    printWriter.println(stringBuffer2);
                } catch (java.lang.NoSuchMethodException unused4) {
                    printWriter.println("Cause: The class " + className + " has no compatible constructor.");
                    z4 = z2;
                    z5 = true;
                    printWriter.println();
                    printWriter.println("Do not panic, this is a common problem.");
                    if (z3) {
                    }
                    if (z4) {
                    }
                    if (z5) {
                    }
                    printWriter.flush();
                    printWriter.close();
                    return stringWriter.toString();
                } catch (java.lang.reflect.InvocationTargetException e3) {
                    java.lang.Throwable targetException = e3.getTargetException();
                    printWriter.println("Cause: The constructor threw the exception");
                    printWriter.println(targetException.toString());
                    targetException.printStackTrace(printWriter);
                    z4 = z2;
                    z5 = true;
                    printWriter.println();
                    printWriter.println("Do not panic, this is a common problem.");
                    if (z3) {
                    }
                    if (z4) {
                    }
                    if (z5) {
                    }
                    printWriter.flush();
                    printWriter.close();
                    return stringWriter.toString();
                }
            }
            z4 = z2;
            printWriter.println();
            printWriter.println("Do not panic, this is a common problem.");
            if (z3) {
                printWriter.println("It may just be a typographical error in the build file or the task/type declaration.");
            }
            if (z4) {
                printWriter.println("The commonest cause is a missing JAR.");
            }
            if (z5) {
                printWriter.println("This is quite a low level problem, which may need consultation with the author of the task.");
                if (startsWith) {
                    printWriter.println("This may be the Ant team. Please file a defect or contact the developer team.");
                } else {
                    printWriter.println("This does not appear to be a task bundled with Ant.");
                    printWriter.println("Please take it up with the supplier of the third-party " + str2 + ".");
                    printWriter.println("If you have written it yourself, you probably have a bug to fix.");
                }
            } else {
                printWriter.println();
                printWriter.println("This is not a bug; it is a configuration problem");
            }
        }
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    public final java.lang.ClassLoader e(java.lang.ClassLoader classLoader) {
        return (this.k.getCoreLoader() == null || com.tencent.open.SocialConstants.PARAM_ONLY.equals(this.k.getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH))) ? classLoader : this.k.getCoreLoader();
    }

    public void enterAntLib(java.lang.String str) {
        this.i = str;
        this.h.push(str);
    }

    public void exitAntLib() {
        this.h.pop();
        this.i = this.h.size() == 0 ? null : this.h.peek();
    }

    public final java.util.Map<java.lang.String, java.util.List<org.apache.tools.ant.AntTypeDefinition>> g() {
        java.util.ArrayList arrayList;
        java.util.HashMap hashMap = new java.util.HashMap();
        synchronized (this.a) {
            for (java.util.Map.Entry<java.lang.String, java.util.List<org.apache.tools.ant.AntTypeDefinition>> entry : this.a.entrySet()) {
                java.util.List<org.apache.tools.ant.AntTypeDefinition> value = entry.getValue();
                synchronized (value) {
                    arrayList = new java.util.ArrayList(value);
                }
                hashMap.put(entry.getKey(), arrayList);
            }
        }
        return hashMap;
    }

    public java.util.Hashtable<java.lang.String, org.apache.tools.ant.AntTypeDefinition> getAntTypeTable() {
        return this.b;
    }

    public java.lang.Class<?> getComponentClass(java.lang.String str) {
        org.apache.tools.ant.AntTypeDefinition definition = getDefinition(str);
        if (definition == null) {
            return null;
        }
        return definition.getExposedClass(this.k);
    }

    public java.lang.String getCurrentAntlibUri() {
        return this.i;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Class<?>> getDataTypeDefinitions() {
        synchronized (this.e) {
            synchronized (this.b) {
                if (this.f) {
                    this.e.clear();
                    for (java.util.Map.Entry<java.lang.String, org.apache.tools.ant.AntTypeDefinition> entry : this.b.entrySet()) {
                        java.lang.Class<?> exposedClass = entry.getValue().getExposedClass(this.k);
                        if (exposedClass != null && !org.apache.tools.ant.Task.class.isAssignableFrom(exposedClass)) {
                            this.e.put(entry.getKey(), entry.getValue().getTypeClass(this.k));
                        }
                    }
                    this.f = false;
                }
            }
        }
        return this.e;
    }

    public org.apache.tools.ant.AntTypeDefinition getDefinition(java.lang.String str) {
        a(str);
        return this.b.get(str);
    }

    public java.lang.String getElementName(java.lang.Object obj) {
        return getElementName(obj, false);
    }

    public java.lang.String getElementName(java.lang.Object obj, boolean z) {
        java.lang.Class<?> cls = obj.getClass();
        java.lang.String name = cls.getName();
        synchronized (this.b) {
            for (org.apache.tools.ant.AntTypeDefinition antTypeDefinition : this.b.values()) {
                if (name.equals(antTypeDefinition.getClassName()) && cls == antTypeDefinition.getExposedClass(this.k)) {
                    java.lang.String name2 = antTypeDefinition.getName();
                    if (!z) {
                        name2 = "The <" + name2 + "> type";
                    }
                    return name2;
                }
            }
            return h(obj.getClass(), z);
        }
    }

    public org.apache.tools.ant.ComponentHelper getNext() {
        return this.j;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.k;
    }

    public java.util.List<org.apache.tools.ant.AntTypeDefinition> getRestrictedDefinitions(java.lang.String str) {
        java.util.List<org.apache.tools.ant.AntTypeDefinition> list;
        synchronized (this.a) {
            list = this.a.get(str);
        }
        return list;
    }

    public java.util.Hashtable<java.lang.String, java.lang.Class<?>> getTaskDefinitions() {
        synchronized (this.c) {
            synchronized (this.b) {
                if (this.d) {
                    this.c.clear();
                    for (java.util.Map.Entry<java.lang.String, org.apache.tools.ant.AntTypeDefinition> entry : this.b.entrySet()) {
                        java.lang.Class<?> exposedClass = entry.getValue().getExposedClass(this.k);
                        if (exposedClass != null && org.apache.tools.ant.Task.class.isAssignableFrom(exposedClass)) {
                            this.c.put(entry.getKey(), entry.getValue().getTypeClass(this.k));
                        }
                    }
                    this.d = false;
                }
            }
        }
        return this.c;
    }

    public final void i() {
        java.lang.ClassLoader e = e(null);
        java.util.Properties f = f(false);
        java.util.Enumeration<?> propertyNames = f.propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            java.lang.String property = f.getProperty(str);
            org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
            antTypeDefinition.setName(str);
            antTypeDefinition.setClassName(property);
            antTypeDefinition.setClassLoader(e);
            antTypeDefinition.setAdaptToClass(org.apache.tools.ant.Task.class);
            antTypeDefinition.setAdapterClass(org.apache.tools.ant.TaskAdapter.class);
            this.b.put(str, antTypeDefinition);
        }
    }

    public void initDefaultDefinitions() {
        i();
        j();
        new org.apache.tools.ant.DefaultDefinitions(this).execute();
    }

    public void initSubProject(org.apache.tools.ant.ComponentHelper componentHelper) {
        java.util.Hashtable hashtable = (java.util.Hashtable) componentHelper.b.clone();
        synchronized (this.b) {
            for (org.apache.tools.ant.AntTypeDefinition antTypeDefinition : hashtable.values()) {
                this.b.put(antTypeDefinition.getName(), antTypeDefinition);
            }
        }
        java.util.Set<java.lang.String> d = componentHelper.d();
        synchronized (this) {
            this.g.addAll(d);
        }
        java.util.Map<java.lang.String, java.util.List<org.apache.tools.ant.AntTypeDefinition>> g = componentHelper.g();
        synchronized (this.a) {
            this.a.putAll(g);
        }
    }

    public final void j() {
        java.lang.ClassLoader e = e(null);
        java.util.Properties f = f(true);
        java.util.Enumeration<?> propertyNames = f.propertyNames();
        while (propertyNames.hasMoreElements()) {
            java.lang.String str = (java.lang.String) propertyNames.nextElement();
            java.lang.String property = f.getProperty(str);
            org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
            antTypeDefinition.setName(str);
            antTypeDefinition.setClassName(property);
            antTypeDefinition.setClassLoader(e);
            this.b.put(str, antTypeDefinition);
        }
    }

    public final void k(java.io.PrintWriter printWriter, java.lang.String str, boolean z, java.lang.String str2) {
        printWriter.println("Cause: the class " + str + " was not found.");
        if (z) {
            printWriter.println("        This looks like one of Ant's optional components.");
            printWriter.println("Action: Check that the appropriate optional JAR exists in");
            printWriter.println(str2);
        } else {
            printWriter.println("Action: Check that the component has been correctly declared");
            printWriter.println("        and that the implementing JAR is in one of:");
            printWriter.println(str2);
        }
    }

    public final void l(java.io.PrintWriter printWriter, boolean z, java.lang.NoClassDefFoundError noClassDefFoundError, java.lang.String str) {
        printWriter.println("Cause: Could not load a dependent class " + noClassDefFoundError.getMessage());
        if (z) {
            printWriter.println("       It is not enough to have Ant's optional JARs");
            printWriter.println("       you need the JAR files that the optional tasks depend upon.");
            printWriter.println("       Ant's optional task dependencies are listed in the manual.");
        } else {
            printWriter.println("       This class may be in a separate JAR that is not installed.");
        }
        printWriter.println("Action: Determine what extra JAR files are needed, and place them in one of:");
        printWriter.println(str);
    }

    public final void m(java.io.PrintWriter printWriter, java.lang.String str, java.lang.String str2) {
        boolean startsWith = str.startsWith("antlib:");
        java.lang.String extractUriFromComponentName = org.apache.tools.ant.ProjectHelper.extractUriFromComponentName(str);
        printWriter.println("Cause: The name is undefined.");
        printWriter.println("Action: Check the spelling.");
        printWriter.println("Action: Check that any custom tasks/types have been declared.");
        printWriter.println("Action: Check that any <presetdef>/<macrodef> declarations have taken place.");
        if (extractUriFromComponentName.length() > 0) {
            java.util.List<org.apache.tools.ant.AntTypeDefinition> c = c(extractUriFromComponentName);
            if (c.size() <= 0) {
                printWriter.println("No types or tasks have been defined in this namespace yet");
                if (startsWith) {
                    printWriter.println();
                    printWriter.println("This appears to be an antlib declaration. ");
                    printWriter.println("Action: Check that the implementing library exists in one of:");
                    printWriter.println(str2);
                    return;
                }
                return;
            }
            printWriter.println();
            printWriter.println("The definitions in the namespace " + extractUriFromComponentName + " are:");
            java.util.Iterator<org.apache.tools.ant.AntTypeDefinition> it = c.iterator();
            while (it.hasNext()) {
                printWriter.println("    " + org.apache.tools.ant.ProjectHelper.extractNameFromComponentName(it.next().getName()));
            }
        }
    }

    public final boolean n(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.AntTypeDefinition antTypeDefinition2) {
        boolean q = q(antTypeDefinition);
        return (q == q(antTypeDefinition2)) && (!q || antTypeDefinition.sameDefinition(antTypeDefinition2, this.k));
    }

    public final void o(org.apache.tools.ant.AntTypeDefinition antTypeDefinition) {
        java.lang.String name = antTypeDefinition.getName();
        synchronized (this.b) {
            this.d = true;
            this.f = true;
            org.apache.tools.ant.AntTypeDefinition antTypeDefinition2 = this.b.get(name);
            if (antTypeDefinition2 != null) {
                if (n(antTypeDefinition, antTypeDefinition2)) {
                    return;
                }
                java.lang.Class<?> exposedClass = antTypeDefinition2.getExposedClass(this.k);
                boolean z = exposedClass != null && org.apache.tools.ant.Task.class.isAssignableFrom(exposedClass);
                org.apache.tools.ant.Project project = this.k;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Trying to override old definition of ");
                sb.append(z ? "task " : "datatype ");
                sb.append(name);
                project.log(sb.toString(), antTypeDefinition.similarDefinition(antTypeDefinition2, this.k) ? 3 : 1);
            }
            this.k.log(" +Datatype " + name + " " + antTypeDefinition.getClassName(), 4);
            this.b.put(name, antTypeDefinition);
        }
    }

    public final void p(org.apache.tools.ant.AntTypeDefinition antTypeDefinition) {
        java.util.List<org.apache.tools.ant.AntTypeDefinition> list;
        java.lang.String name = antTypeDefinition.getName();
        synchronized (this.a) {
            list = this.a.get(name);
            if (list == null) {
                list = new java.util.ArrayList<>();
                this.a.put(name, list);
            }
        }
        synchronized (list) {
            java.util.Iterator<org.apache.tools.ant.AntTypeDefinition> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getClassName().equals(antTypeDefinition.getClassName())) {
                    it.remove();
                    break;
                }
            }
            list.add(antTypeDefinition);
        }
    }

    public final boolean q(org.apache.tools.ant.AntTypeDefinition antTypeDefinition) {
        return (antTypeDefinition.getTypeClass(this.k) == null || antTypeDefinition.getExposedClass(this.k) == null) ? false : true;
    }

    public void setNext(org.apache.tools.ant.ComponentHelper componentHelper) {
        this.j = componentHelper;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.k = project;
    }
}
