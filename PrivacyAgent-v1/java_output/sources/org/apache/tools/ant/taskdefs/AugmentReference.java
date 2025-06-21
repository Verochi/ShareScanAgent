package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class AugmentReference extends org.apache.tools.ant.Task implements org.apache.tools.ant.TypeAdapter {
    public java.lang.String u;

    public final synchronized void c() {
        if (this.u == null) {
            org.apache.tools.ant.RuntimeConfigurable wrapper = getWrapper();
            java.lang.String id = wrapper.getId();
            this.u = id;
            if (id == null) {
                throw new org.apache.tools.ant.BuildException(getTaskName() + " attribute 'id' unset");
            }
            wrapper.setAttribute("id", (java.lang.String) null);
            wrapper.removeAttribute("id");
            wrapper.setElementTag("augmented reference \"" + this.u + "\"");
        }
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public void checkProxyClass(java.lang.Class<?> cls) {
    }

    public final synchronized void d() {
        if (this.u != null) {
            log("restoring augment wrapper " + this.u, 4);
            org.apache.tools.ant.RuntimeConfigurable wrapper = getWrapper();
            wrapper.setAttribute("id", this.u);
            wrapper.setElementTag(getTaskName());
            this.u = null;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        d();
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public synchronized java.lang.Object getProxy() {
        java.lang.Object reference;
        if (getProject() == null) {
            throw new java.lang.IllegalStateException(getTaskName() + "Project owner unset");
        }
        c();
        if (!getProject().hasReference(this.u)) {
            throw new org.apache.tools.ant.BuildException("Unknown reference \"" + this.u + "\"");
        }
        reference = getProject().getReference(this.u);
        log("project reference " + this.u + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + java.lang.String.valueOf(reference), 4);
        return reference;
    }

    @Override // org.apache.tools.ant.TypeAdapter
    public void setProxy(java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException();
    }
}
