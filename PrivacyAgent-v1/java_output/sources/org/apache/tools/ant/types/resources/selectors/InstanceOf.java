package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class InstanceOf implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public org.apache.tools.ant.Project n;
    public java.lang.Class<?> t;
    public java.lang.String u;
    public java.lang.String v;

    public java.lang.Class<?> getCheckClass() {
        return this.t;
    }

    public java.lang.String getType() {
        return this.u;
    }

    public java.lang.String getURI() {
        return this.v;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        java.lang.Class<?> cls = this.t;
        boolean z = cls == null;
        java.lang.String str = this.u;
        if (z == (str == null)) {
            throw new org.apache.tools.ant.BuildException("Exactly one of class|type must be set.");
        }
        if (str != null) {
            org.apache.tools.ant.Project project = this.n;
            if (project == null) {
                throw new org.apache.tools.ant.BuildException("No project set for InstanceOf ResourceSelector; the type attribute is invalid.");
            }
            org.apache.tools.ant.AntTypeDefinition definition = org.apache.tools.ant.ComponentHelper.getComponentHelper(project).getDefinition(org.apache.tools.ant.ProjectHelper.genComponentName(this.v, this.u));
            if (definition == null) {
                throw new org.apache.tools.ant.BuildException("type " + this.u + " not found.");
            }
            try {
                cls = definition.innerGetTypeClass();
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        }
        return cls.isAssignableFrom(resource.getClass());
    }

    public void setClass(java.lang.Class<?> cls) {
        if (this.t != null) {
            throw new org.apache.tools.ant.BuildException("The class attribute has already been set.");
        }
        this.t = cls;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.n = project;
    }

    public void setType(java.lang.String str) {
        this.u = str;
    }

    public void setURI(java.lang.String str) {
        this.v = str;
    }
}
