package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class PreSetDef extends org.apache.tools.ant.taskdefs.AntlibDefinition implements org.apache.tools.ant.TaskContainer {
    public org.apache.tools.ant.UnknownElement w;
    public java.lang.String x;

    public static class PreSetDefinition extends org.apache.tools.ant.AntTypeDefinition {
        public org.apache.tools.ant.AntTypeDefinition h;
        public org.apache.tools.ant.UnknownElement i;

        public PreSetDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.UnknownElement unknownElement) {
            if (antTypeDefinition instanceof org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) {
                org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition preSetDefinition = (org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) antTypeDefinition;
                unknownElement.applyPreSet(preSetDefinition.i);
                antTypeDefinition = preSetDefinition.h;
            }
            this.h = antTypeDefinition;
            this.i = unknownElement;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void checkClass(org.apache.tools.ant.Project project) {
            this.h.checkClass(project);
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.Object create(org.apache.tools.ant.Project project) {
            return this;
        }

        public java.lang.Object createObject(org.apache.tools.ant.Project project) {
            return this.h.create(project);
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.ClassLoader getClassLoader() {
            return this.h.getClassLoader();
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.String getClassName() {
            return this.h.getClassName();
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.Class getExposedClass(org.apache.tools.ant.Project project) {
            return this.h.getExposedClass(project);
        }

        public org.apache.tools.ant.UnknownElement getPreSets() {
            return this.i;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public java.lang.Class getTypeClass(org.apache.tools.ant.Project project) {
            return this.h.getTypeClass(project);
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public boolean sameDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
            org.apache.tools.ant.AntTypeDefinition antTypeDefinition2;
            if (antTypeDefinition != null && antTypeDefinition.getClass() == getClass() && (antTypeDefinition2 = this.h) != null) {
                org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition preSetDefinition = (org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) antTypeDefinition;
                if (antTypeDefinition2.sameDefinition(preSetDefinition.h, project) && this.i.similar(preSetDefinition.i)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void setAdaptToClass(java.lang.Class cls) {
            throw new org.apache.tools.ant.BuildException("Not supported");
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void setAdapterClass(java.lang.Class cls) {
            throw new org.apache.tools.ant.BuildException("Not supported");
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void setClass(java.lang.Class cls) {
            throw new org.apache.tools.ant.BuildException("Not supported");
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void setClassLoader(java.lang.ClassLoader classLoader) {
            throw new org.apache.tools.ant.BuildException("Not supported");
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public void setClassName(java.lang.String str) {
            throw new org.apache.tools.ant.BuildException("Not supported");
        }

        @Override // org.apache.tools.ant.AntTypeDefinition
        public boolean similarDefinition(org.apache.tools.ant.AntTypeDefinition antTypeDefinition, org.apache.tools.ant.Project project) {
            org.apache.tools.ant.AntTypeDefinition antTypeDefinition2;
            if (antTypeDefinition != null && antTypeDefinition.getClass().getName().equals(getClass().getName()) && (antTypeDefinition2 = this.h) != null) {
                org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition preSetDefinition = (org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition) antTypeDefinition;
                if (antTypeDefinition2.similarDefinition(preSetDefinition.h, project) && this.i.similar(preSetDefinition.i)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // org.apache.tools.ant.TaskContainer
    public void addTask(org.apache.tools.ant.Task task) {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("Only one nested element allowed");
        }
        if (!(task instanceof org.apache.tools.ant.UnknownElement)) {
            throw new org.apache.tools.ant.BuildException("addTask called with a task that is not an unknown element");
        }
        this.w = (org.apache.tools.ant.UnknownElement) task;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException("Missing nested element");
        }
        if (this.x == null) {
            throw new org.apache.tools.ant.BuildException("Name not specified");
        }
        this.x = org.apache.tools.ant.ProjectHelper.genComponentName(getURI(), this.x);
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject());
        java.lang.String genComponentName = org.apache.tools.ant.ProjectHelper.genComponentName(this.w.getNamespace(), this.w.getTag());
        org.apache.tools.ant.AntTypeDefinition definition = componentHelper.getDefinition(genComponentName);
        if (definition == null) {
            throw new org.apache.tools.ant.BuildException("Unable to find typedef " + genComponentName);
        }
        org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition preSetDefinition = new org.apache.tools.ant.taskdefs.PreSetDef.PreSetDefinition(definition, this.w);
        preSetDefinition.setName(this.x);
        componentHelper.addDataTypeDefinition(preSetDefinition);
        log("defining preset " + this.x, 3);
    }

    public void setName(java.lang.String str) {
        this.x = str;
    }
}
