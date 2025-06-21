package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Ant extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils H = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.Project B;
    public java.io.File u = null;
    public java.lang.String v = null;
    public java.lang.String w = null;
    public boolean x = true;
    public boolean y = false;
    public java.util.Vector<org.apache.tools.ant.taskdefs.Property> z = new java.util.Vector<>();
    public java.util.Vector<org.apache.tools.ant.taskdefs.Ant.Reference> A = new java.util.Vector<>();
    public java.io.PrintStream C = null;
    public java.util.Vector<org.apache.tools.ant.types.PropertySet> D = new java.util.Vector<>();
    public java.util.Vector<java.lang.String> E = new java.util.Vector<>();
    public boolean F = false;
    public boolean G = false;

    public static final class PropertyType {
        public static final org.apache.tools.ant.taskdefs.Ant.PropertyType a = new org.apache.tools.ant.taskdefs.Ant.PropertyType();
        public static final org.apache.tools.ant.taskdefs.Ant.PropertyType b = new org.apache.tools.ant.taskdefs.Ant.PropertyType();
        public static final org.apache.tools.ant.taskdefs.Ant.PropertyType c = new org.apache.tools.ant.taskdefs.Ant.PropertyType();
    }

    public static class Reference extends org.apache.tools.ant.types.Reference {
        public java.lang.String c = null;

        public java.lang.String getToRefid() {
            return this.c;
        }

        public void setToRefid(java.lang.String str) {
            this.c = str;
        }
    }

    public static class TargetElement {
        public java.lang.String a;

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }
    }

    public Ant() {
    }

    public Ant(org.apache.tools.ant.Task task) {
        bindToOwner(task);
    }

    public void addConfiguredTarget(org.apache.tools.ant.taskdefs.Ant.TargetElement targetElement) {
        if (this.F) {
            throw new org.apache.tools.ant.BuildException("nested target is incompatible with the target attribute");
        }
        java.lang.String name = targetElement.getName();
        if (name.equals("")) {
            throw new org.apache.tools.ant.BuildException("target name must not be empty");
        }
        this.E.add(name);
    }

    public void addPropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        this.D.addElement(propertySet);
    }

    public void addReference(org.apache.tools.ant.taskdefs.Ant.Reference reference) {
        this.A.addElement(reference);
    }

    public final void c(java.util.Hashtable<?, ?> hashtable, org.apache.tools.ant.taskdefs.Ant.PropertyType propertyType) {
        java.util.Enumeration<?> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            java.lang.String obj = keys.nextElement().toString();
            if (!org.apache.tools.ant.MagicNames.PROJECT_BASEDIR.equals(obj) && !org.apache.tools.ant.MagicNames.ANT_FILE.equals(obj)) {
                java.lang.String obj2 = hashtable.get(obj).toString();
                if (propertyType == org.apache.tools.ant.taskdefs.Ant.PropertyType.a) {
                    if (this.B.getProperty(obj) == null) {
                        this.B.setNewProperty(obj, obj2);
                    }
                } else if (propertyType == org.apache.tools.ant.taskdefs.Ant.PropertyType.c) {
                    this.B.setUserProperty(obj, obj2);
                } else if (propertyType == org.apache.tools.ant.taskdefs.Ant.PropertyType.b) {
                    this.B.setInheritedProperty(obj, obj2);
                }
            }
        }
    }

    public org.apache.tools.ant.taskdefs.Property createProperty() {
        org.apache.tools.ant.taskdefs.Property property = new org.apache.tools.ant.taskdefs.Property(true, getProject());
        property.setProject(getNewProject());
        property.setTaskName(org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY);
        this.z.addElement(property);
        return property;
    }

    public final void d() throws org.apache.tools.ant.BuildException {
        java.util.Hashtable hashtable = (java.util.Hashtable) getProject().getReferences().clone();
        java.util.Iterator<org.apache.tools.ant.taskdefs.Ant.Reference> it = this.A.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.Ant.Reference next = it.next();
            java.lang.String refId = next.getRefId();
            if (refId == null) {
                throw new org.apache.tools.ant.BuildException("the refid attribute is required for reference elements");
            }
            if (hashtable.containsKey(refId)) {
                hashtable.remove(refId);
                java.lang.String toRefid = next.getToRefid();
                if (toRefid == null) {
                    toRefid = refId;
                }
                e(refId, toRefid);
            } else {
                log("Parent project doesn't contain any reference '" + refId + "'", 1);
            }
        }
        if (this.y) {
            java.util.Hashtable<java.lang.String, java.lang.Object> references = this.B.getReferences();
            for (java.lang.String str : hashtable.keySet()) {
                if (!references.containsKey(str)) {
                    e(str, str);
                    this.B.inheritIDReferences(getProject());
                }
            }
        }
    }

    public final void e(java.lang.String str, java.lang.String str2) {
        java.lang.Object reference = getProject().getReference(str);
        if (reference == null) {
            log("No object referenced by " + str + ". Can't copy to " + str2, 1);
            return;
        }
        java.lang.Class<?> cls = reference.getClass();
        try {
            java.lang.reflect.Method method = cls.getMethod("clone", new java.lang.Class[0]);
            if (method != null) {
                reference = method.invoke(reference, new java.lang.Object[0]);
                log("Adding clone of reference " + str, 4);
            }
        } catch (java.lang.Exception unused) {
        }
        if (reference instanceof org.apache.tools.ant.ProjectComponent) {
            ((org.apache.tools.ant.ProjectComponent) reference).setProject(this.B);
        } else {
            try {
                java.lang.reflect.Method method2 = cls.getMethod("setProject", org.apache.tools.ant.Project.class);
                if (method2 != null) {
                    method2.invoke(reference, this.B);
                }
            } catch (java.lang.NoSuchMethodException unused2) {
            } catch (java.lang.Exception e) {
                throw new org.apache.tools.ant.BuildException("Error setting new project instance for reference with id " + str, e, getLocation());
            }
        }
        this.B.addReference(str2, reference);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.PrintStream printStream;
        org.apache.tools.ant.BuildException addLocationToBuildException;
        java.lang.String defaultTarget;
        java.io.File file = this.u;
        java.lang.String str = this.v;
        org.apache.tools.ant.util.VectorSet vectorSet = new org.apache.tools.ant.util.VectorSet(this.E);
        try {
            getNewProject();
            if (this.u == null && this.x) {
                this.u = getProject().getBaseDir();
            }
            g();
            java.io.File file2 = this.u;
            if (file2 == null) {
                this.u = getProject().getBaseDir();
            } else if (!this.G) {
                this.B.setBaseDir(file2);
                if (file != null) {
                    this.B.setInheritedProperty(org.apache.tools.ant.MagicNames.PROJECT_BASEDIR, this.u.getAbsolutePath());
                }
            }
            h();
            if (this.v == null) {
                this.v = getDefaultBuildFile();
            }
            java.io.File resolveFile = H.resolveFile(this.u, this.v);
            this.v = resolveFile.getAbsolutePath();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("calling target(s) ");
            sb.append(vectorSet.size() > 0 ? vectorSet.toString() : "[default]");
            sb.append(" in build file ");
            sb.append(this.v);
            log(sb.toString(), 3);
            this.B.setUserProperty(org.apache.tools.ant.MagicNames.ANT_FILE, this.v);
            java.lang.String property = getProject().getProperty(org.apache.tools.ant.MagicNames.ANT_FILE);
            if (property != null && resolveFile.equals(getProject().resolveFile(property)) && getOwningTarget() != null && getOwningTarget().getName().equals("")) {
                if (getTaskName().equals("antcall")) {
                    throw new org.apache.tools.ant.BuildException("antcall must not be used at the top level.");
                }
                throw new org.apache.tools.ant.BuildException(getTaskName() + " task at the top level must not invoke its own build file.");
            }
            try {
                org.apache.tools.ant.ProjectHelper.configureProject(this.B, resolveFile);
                if (vectorSet.size() == 0 && (defaultTarget = this.B.getDefaultTarget()) != null) {
                    vectorSet.add(defaultTarget);
                }
                if (this.B.getProperty(org.apache.tools.ant.MagicNames.ANT_FILE).equals(getProject().getProperty(org.apache.tools.ant.MagicNames.ANT_FILE)) && getOwningTarget() != null) {
                    java.lang.String name = getOwningTarget().getName();
                    if (vectorSet.contains(name)) {
                        throw new org.apache.tools.ant.BuildException(getTaskName() + " task calling its own parent target.");
                    }
                    java.util.Iterator<E> it = vectorSet.iterator();
                    boolean z = false;
                    while (!z && it.hasNext()) {
                        org.apache.tools.ant.Target target = getProject().getTargets().get(it.next());
                        z |= target != null && target.dependsOn(name);
                    }
                    if (z) {
                        throw new org.apache.tools.ant.BuildException(getTaskName() + " task calling a target that depends on its parent target '" + name + "'.");
                    }
                }
                d();
                if (vectorSet.size() > 0 && (vectorSet.size() != 1 || !"".equals(vectorSet.get(0)))) {
                    try {
                        try {
                            log("Entering " + this.v + "...", 3);
                            this.B.fireSubBuildStarted();
                            this.B.executeTargets(vectorSet);
                            log("Exiting " + this.v + ".", 3);
                            this.B.fireSubBuildFinished(null);
                        } catch (org.apache.tools.ant.BuildException e) {
                            addLocationToBuildException = org.apache.tools.ant.ProjectHelper.addLocationToBuildException(e, getLocation());
                            try {
                                throw addLocationToBuildException;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                log("Exiting " + this.v + ".", 3);
                                this.B.fireSubBuildFinished(addLocationToBuildException);
                                throw th;
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        addLocationToBuildException = null;
                        log("Exiting " + this.v + ".", 3);
                        this.B.fireSubBuildFinished(addLocationToBuildException);
                        throw th;
                    }
                }
            } catch (org.apache.tools.ant.BuildException e2) {
                throw org.apache.tools.ant.ProjectHelper.addLocationToBuildException(e2, getLocation());
            }
        } finally {
            this.B = null;
            java.util.Iterator<org.apache.tools.ant.taskdefs.Property> it2 = this.z.iterator();
            while (it2.hasNext()) {
                it2.next().setProject(null);
            }
            if (this.w != null && (printStream = this.C) != null) {
                org.apache.tools.ant.util.FileUtils.close(printStream);
            }
            this.u = file;
            this.v = str;
        }
    }

    public final java.util.Iterator<org.apache.tools.ant.BuildListener> f() {
        return getProject().getBuildListeners().iterator();
    }

    public final void g() {
        this.B.setInputHandler(getProject().getInputHandler());
        java.util.Iterator<org.apache.tools.ant.BuildListener> f = f();
        while (f.hasNext()) {
            this.B.addBuildListener(f.next());
        }
        java.lang.String str = this.w;
        if (str != null) {
            java.io.File file = this.u;
            try {
                this.C = new java.io.PrintStream(new java.io.FileOutputStream(file != null ? H.resolveFile(file, str) : getProject().resolveFile(this.w)));
                org.apache.tools.ant.DefaultLogger defaultLogger = new org.apache.tools.ant.DefaultLogger();
                defaultLogger.setMessageOutputLevel(2);
                defaultLogger.setOutputPrintStream(this.C);
                defaultLogger.setErrorPrintStream(this.C);
                this.B.addBuildListener(defaultLogger);
            } catch (java.io.IOException unused) {
                log("Ant: Can't set output to " + this.w);
            }
        }
        if (this.G) {
            c(getProject().getUserProperties(), org.apache.tools.ant.taskdefs.Ant.PropertyType.c);
        } else {
            getProject().copyUserProperties(this.B);
        }
        if (this.x) {
            c(getProject().getProperties(), org.apache.tools.ant.taskdefs.Ant.PropertyType.a);
        } else {
            this.B.initProperties();
        }
        java.util.Iterator<org.apache.tools.ant.types.PropertySet> it = this.D.iterator();
        while (it.hasNext()) {
            c(it.next().getProperties(), org.apache.tools.ant.taskdefs.Ant.PropertyType.a);
        }
    }

    public java.lang.String getDefaultBuildFile() {
        return org.apache.tools.ant.Main.DEFAULT_BUILD_FILENAME;
    }

    public org.apache.tools.ant.Project getNewProject() {
        if (this.B == null) {
            i();
        }
        return this.B;
    }

    public final void h() throws org.apache.tools.ant.BuildException {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (int size = this.z.size() - 1; size >= 0; size--) {
            org.apache.tools.ant.taskdefs.Property property = this.z.get(size);
            if (property.getName() != null && !property.getName().equals("")) {
                if (hashSet.contains(property.getName())) {
                    this.z.remove(size);
                } else {
                    hashSet.add(property.getName());
                }
            }
        }
        java.util.Enumeration<org.apache.tools.ant.taskdefs.Property> elements = this.z.elements();
        while (elements.hasMoreElements()) {
            org.apache.tools.ant.taskdefs.Property nextElement = elements.nextElement();
            nextElement.setProject(this.B);
            nextElement.execute();
        }
        if (this.G) {
            c(getProject().getInheritedProperties(), org.apache.tools.ant.taskdefs.Ant.PropertyType.b);
        } else {
            getProject().copyInheritedProperties(this.B);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorFlush(java.lang.String str) {
        org.apache.tools.ant.Project project = this.B;
        if (project != null) {
            project.demuxFlush(str, true);
        } else {
            super.handleErrorFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorOutput(java.lang.String str) {
        org.apache.tools.ant.Project project = this.B;
        if (project != null) {
            project.demuxOutput(str, true);
        } else {
            super.handleErrorOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleFlush(java.lang.String str) {
        org.apache.tools.ant.Project project = this.B;
        if (project != null) {
            project.demuxFlush(str, false);
        } else {
            super.handleFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        org.apache.tools.ant.Project project = this.B;
        return project != null ? project.demuxInput(bArr, i, i2) : super.handleInput(bArr, i, i2);
    }

    @Override // org.apache.tools.ant.Task
    public void handleOutput(java.lang.String str) {
        org.apache.tools.ant.Project project = this.B;
        if (project != null) {
            project.demuxOutput(str, false);
        } else {
            super.handleOutput(str);
        }
    }

    public final void i() {
        init();
    }

    @Override // org.apache.tools.ant.Task
    public void init() {
        org.apache.tools.ant.Project createSubProject = getProject().createSubProject();
        this.B = createSubProject;
        createSubProject.setJavaVersionProperty();
    }

    public void setAntfile(java.lang.String str) {
        this.v = str;
    }

    public void setDir(java.io.File file) {
        this.u = file;
    }

    public void setInheritAll(boolean z) {
        this.x = z;
    }

    public void setInheritRefs(boolean z) {
        this.y = z;
    }

    public void setOutput(java.lang.String str) {
        this.w = str;
    }

    public void setTarget(java.lang.String str) {
        if (str.equals("")) {
            throw new org.apache.tools.ant.BuildException("target attribute must not be empty");
        }
        this.E.add(str);
        this.F = true;
    }

    public void setUseNativeBasedir(boolean z) {
        this.G = z;
    }
}
