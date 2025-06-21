package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class Target implements org.apache.tools.ant.TaskContainer {
    public org.apache.tools.ant.Project A;
    public java.lang.String B;
    public java.lang.String n;
    public java.lang.String t;
    public java.lang.String u;
    public org.apache.tools.ant.taskdefs.condition.Condition v;
    public org.apache.tools.ant.taskdefs.condition.Condition w;
    public java.util.List<java.lang.String> x;
    public java.util.List<java.lang.Object> y;
    public org.apache.tools.ant.Location z;

    public class IfStringCondition implements org.apache.tools.ant.taskdefs.condition.Condition {
        public java.lang.String n;

        public IfStringCondition(java.lang.String str) {
            this.n = str;
        }

        @Override // org.apache.tools.ant.taskdefs.condition.Condition
        public boolean eval() throws org.apache.tools.ant.BuildException {
            org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(org.apache.tools.ant.Target.this.getProject());
            return propertyHelper.testIfCondition(propertyHelper.parseProperties(this.n));
        }
    }

    public class UnlessStringCondition implements org.apache.tools.ant.taskdefs.condition.Condition {
        public java.lang.String n;

        public UnlessStringCondition(java.lang.String str) {
            this.n = str;
        }

        @Override // org.apache.tools.ant.taskdefs.condition.Condition
        public boolean eval() throws org.apache.tools.ant.BuildException {
            org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(org.apache.tools.ant.Target.this.getProject());
            return !propertyHelper.testUnlessCondition(propertyHelper.parseProperties(this.n));
        }
    }

    public Target() {
        this.t = "";
        this.u = "";
        this.x = null;
        this.y = new java.util.ArrayList();
        this.z = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
        this.B = null;
    }

    public Target(org.apache.tools.ant.Target target) {
        this.t = "";
        this.u = "";
        this.x = null;
        this.y = new java.util.ArrayList();
        this.z = org.apache.tools.ant.Location.UNKNOWN_LOCATION;
        this.B = null;
        this.n = target.n;
        this.t = target.t;
        this.u = target.u;
        this.v = target.v;
        this.w = target.w;
        this.x = target.x;
        this.z = target.z;
        this.A = target.A;
        this.B = target.B;
        this.y = target.y;
    }

    public static java.util.List<java.lang.String> parseDepends(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str.length() > 0) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ",", true);
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String trim = stringTokenizer.nextToken().trim();
                if ("".equals(trim) || ",".equals(trim)) {
                    throw new org.apache.tools.ant.BuildException("Syntax Error: " + str3 + " attribute of target \"" + str2 + "\" contains an empty string.");
                }
                arrayList.add(trim);
                if (stringTokenizer.hasMoreTokens()) {
                    java.lang.String nextToken = stringTokenizer.nextToken();
                    if (!stringTokenizer.hasMoreTokens() || !",".equals(nextToken)) {
                        throw new org.apache.tools.ant.BuildException("Syntax Error: " + str3 + " attribute for target \"" + str2 + "\" ends with a \",\" character");
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(org.apache.tools.ant.Task task, org.apache.tools.ant.Task task2) {
        while (true) {
            int indexOf = this.y.indexOf(task);
            if (indexOf < 0) {
                return;
            } else {
                this.y.set(indexOf, task2);
            }
        }
    }

    public void addDataType(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        this.y.add(runtimeConfigurable);
    }

    public void addDependency(java.lang.String str) {
        if (this.x == null) {
            this.x = new java.util.ArrayList(2);
        }
        this.x.add(str);
    }

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        this.y.add(task);
    }

    public boolean dependsOn(java.lang.String str) {
        org.apache.tools.ant.Project project = getProject();
        java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> targets = project == null ? null : project.getTargets();
        return project != null && project.topoSort(getName(), targets, false).contains(targets.get(str));
    }

    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.condition.Condition condition = this.v;
        if (condition != null && !condition.eval()) {
            this.A.log(this, "Skipped because property '" + this.A.replaceProperties(this.t) + "' not set.", 3);
            return;
        }
        org.apache.tools.ant.taskdefs.condition.Condition condition2 = this.w;
        if (condition2 != null && condition2.eval()) {
            this.A.log(this, "Skipped because property '" + this.A.replaceProperties(this.u) + "' set.", 3);
            return;
        }
        org.apache.tools.ant.property.LocalProperties localProperties = org.apache.tools.ant.property.LocalProperties.get(getProject());
        localProperties.enterScope();
        for (int i = 0; i < this.y.size(); i++) {
            try {
                java.lang.Object obj = this.y.get(i);
                if (obj instanceof org.apache.tools.ant.Task) {
                    ((org.apache.tools.ant.Task) obj).perform();
                } else {
                    ((org.apache.tools.ant.RuntimeConfigurable) obj).maybeConfigure(this.A);
                }
            } finally {
                localProperties.exitScope();
            }
        }
    }

    public java.util.Enumeration<java.lang.String> getDependencies() {
        java.util.List<java.lang.String> list = this.x;
        if (list == null) {
            list = java.util.Collections.emptyList();
        }
        return java.util.Collections.enumeration(list);
    }

    public java.lang.String getDescription() {
        return this.B;
    }

    public java.lang.String getIf() {
        if ("".equals(this.t)) {
            return null;
        }
        return this.t;
    }

    public org.apache.tools.ant.Location getLocation() {
        return this.z;
    }

    public java.lang.String getName() {
        return this.n;
    }

    public org.apache.tools.ant.Project getProject() {
        return this.A;
    }

    public org.apache.tools.ant.Task[] getTasks() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.y.size());
        for (java.lang.Object obj : this.y) {
            if (obj instanceof org.apache.tools.ant.Task) {
                arrayList.add((org.apache.tools.ant.Task) obj);
            }
        }
        return (org.apache.tools.ant.Task[]) arrayList.toArray(new org.apache.tools.ant.Task[arrayList.size()]);
    }

    public java.lang.String getUnless() {
        if ("".equals(this.u)) {
            return null;
        }
        return this.u;
    }

    public final void performTasks() {
        this.A.fireTargetStarted(this);
        java.lang.RuntimeException e = null;
        try {
            try {
                execute();
            } catch (java.lang.RuntimeException e2) {
                e = e2;
                throw e;
            }
        } finally {
            this.A.fireTargetFinished(this, e);
        }
    }

    public void setDepends(java.lang.String str) {
        java.util.Iterator<java.lang.String> it = parseDepends(str, getName(), "depends").iterator();
        while (it.hasNext()) {
            addDependency(it.next());
        }
    }

    public void setDescription(java.lang.String str) {
        this.B = str;
    }

    public void setIf(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.t = str;
        setIf(new org.apache.tools.ant.Target.IfStringCondition(str));
    }

    public void setIf(org.apache.tools.ant.taskdefs.condition.Condition condition) {
        if (this.v == null) {
            this.v = condition;
            return;
        }
        org.apache.tools.ant.taskdefs.condition.And and = new org.apache.tools.ant.taskdefs.condition.And();
        and.setProject(getProject());
        and.setLocation(getLocation());
        and.add(this.v);
        and.add(condition);
        this.v = and;
    }

    public void setLocation(org.apache.tools.ant.Location location) {
        this.z = location;
    }

    public void setName(java.lang.String str) {
        this.n = str;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.A = project;
    }

    public void setUnless(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.u = str;
        setUnless(new org.apache.tools.ant.Target.UnlessStringCondition(str));
    }

    public void setUnless(org.apache.tools.ant.taskdefs.condition.Condition condition) {
        if (this.w == null) {
            this.w = condition;
            return;
        }
        org.apache.tools.ant.taskdefs.condition.Or or = new org.apache.tools.ant.taskdefs.condition.Or();
        or.setProject(getProject());
        or.setLocation(getLocation());
        or.add(this.w);
        or.add(condition);
        this.w = or;
    }

    public java.lang.String toString() {
        return this.n;
    }
}
