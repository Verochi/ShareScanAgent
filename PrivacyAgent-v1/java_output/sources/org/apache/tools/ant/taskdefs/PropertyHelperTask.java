package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class PropertyHelperTask extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.PropertyHelper u;
    public java.util.List v;

    public final class DelegateElement {
        public java.lang.String a;

        public DelegateElement() {
        }

        public /* synthetic */ DelegateElement(org.apache.tools.ant.taskdefs.PropertyHelperTask propertyHelperTask, org.apache.tools.ant.taskdefs.PropertyHelperTask.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final org.apache.tools.ant.PropertyHelper.Delegate b() {
            if (this.a != null) {
                return (org.apache.tools.ant.PropertyHelper.Delegate) org.apache.tools.ant.taskdefs.PropertyHelperTask.this.getProject().getReference(this.a);
            }
            throw new org.apache.tools.ant.BuildException("refid required for generic delegate");
        }

        public java.lang.String getRefid() {
            return this.a;
        }

        public void setRefid(java.lang.String str) {
            this.a = str;
        }
    }

    public synchronized void addConfigured(org.apache.tools.ant.PropertyHelper.Delegate delegate) {
        c().add(delegate);
    }

    public synchronized void addConfigured(org.apache.tools.ant.PropertyHelper propertyHelper) {
        if (this.u != null) {
            throw new org.apache.tools.ant.BuildException("Only one PropertyHelper can be installed");
        }
        this.u = propertyHelper;
    }

    public final synchronized java.util.List c() {
        if (this.v == null) {
            this.v = new java.util.ArrayList();
        }
        return this.v;
    }

    public org.apache.tools.ant.taskdefs.PropertyHelperTask.DelegateElement createDelegate() {
        org.apache.tools.ant.taskdefs.PropertyHelperTask.DelegateElement delegateElement = new org.apache.tools.ant.taskdefs.PropertyHelperTask.DelegateElement(this, null);
        c().add(delegateElement);
        return delegateElement;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (getProject() == null) {
            throw new org.apache.tools.ant.BuildException("Project instance not set");
        }
        org.apache.tools.ant.PropertyHelper propertyHelper = this.u;
        if (propertyHelper == null && this.v == null) {
            throw new org.apache.tools.ant.BuildException("Either a new PropertyHelper or one or more PropertyHelper delegates are required");
        }
        if (propertyHelper == null) {
            propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject());
        }
        synchronized (propertyHelper) {
            java.util.List list = this.v;
            if (list != null) {
                for (java.lang.Object obj : list) {
                    org.apache.tools.ant.PropertyHelper.Delegate b = obj instanceof org.apache.tools.ant.taskdefs.PropertyHelperTask.DelegateElement ? ((org.apache.tools.ant.taskdefs.PropertyHelperTask.DelegateElement) obj).b() : (org.apache.tools.ant.PropertyHelper.Delegate) obj;
                    log("Adding PropertyHelper delegate " + b, 4);
                    propertyHelper.add(b);
                }
            }
        }
        if (this.u != null) {
            log("Installing PropertyHelper " + this.u, 4);
            getProject().addReference(org.apache.tools.ant.MagicNames.REFID_PROPERTY_HELPER, this.u);
        }
    }
}
