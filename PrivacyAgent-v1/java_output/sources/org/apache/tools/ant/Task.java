package org.apache.tools.ant;

/* loaded from: classes25.dex */
public abstract class Task extends org.apache.tools.ant.ProjectComponent {
    public boolean n;
    public org.apache.tools.ant.UnknownElement t;

    @java.lang.Deprecated
    protected org.apache.tools.ant.Target target;

    @java.lang.Deprecated
    protected java.lang.String taskName;

    @java.lang.Deprecated
    protected java.lang.String taskType;

    @java.lang.Deprecated
    protected org.apache.tools.ant.RuntimeConfigurable wrapper;

    public final org.apache.tools.ant.UnknownElement a() {
        if (this.t == null) {
            org.apache.tools.ant.UnknownElement unknownElement = new org.apache.tools.ant.UnknownElement(this.taskType);
            this.t = unknownElement;
            unknownElement.setProject(getProject());
            this.t.setTaskType(this.taskType);
            this.t.setTaskName(this.taskName);
            this.t.setLocation(getLocation());
            this.t.setOwningTarget(this.target);
            this.t.setRuntimeConfigurableWrapper(this.wrapper);
            this.wrapper.setProxy(this.t);
            b(this.wrapper, this.t);
            this.target.a(this, this.t);
            this.t.maybeConfigure();
        }
        return this.t;
    }

    public final void b(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable, org.apache.tools.ant.UnknownElement unknownElement) {
        java.util.Enumeration<org.apache.tools.ant.RuntimeConfigurable> children = runtimeConfigurable.getChildren();
        while (children.hasMoreElements()) {
            org.apache.tools.ant.RuntimeConfigurable nextElement = children.nextElement();
            org.apache.tools.ant.UnknownElement unknownElement2 = new org.apache.tools.ant.UnknownElement(nextElement.getElementTag());
            unknownElement.addChild(unknownElement2);
            unknownElement2.setProject(getProject());
            unknownElement2.setRuntimeConfigurableWrapper(nextElement);
            nextElement.setProxy(unknownElement2);
            b(nextElement, unknownElement2);
        }
    }

    public final void bindToOwner(org.apache.tools.ant.Task task) {
        setProject(task.getProject());
        setOwningTarget(task.getOwningTarget());
        setTaskName(task.getTaskName());
        setDescription(task.getDescription());
        setLocation(task.getLocation());
        setTaskType(task.getTaskType());
    }

    public void execute() throws org.apache.tools.ant.BuildException {
    }

    public org.apache.tools.ant.Target getOwningTarget() {
        return this.target;
    }

    public org.apache.tools.ant.RuntimeConfigurable getRuntimeConfigurableWrapper() {
        if (this.wrapper == null) {
            this.wrapper = new org.apache.tools.ant.RuntimeConfigurable(this, getTaskName());
        }
        return this.wrapper;
    }

    public java.lang.String getTaskName() {
        return this.taskName;
    }

    public java.lang.String getTaskType() {
        return this.taskType;
    }

    public org.apache.tools.ant.RuntimeConfigurable getWrapper() {
        return this.wrapper;
    }

    public void handleErrorFlush(java.lang.String str) {
        handleErrorOutput(str);
    }

    public void handleErrorOutput(java.lang.String str) {
        log(str, 1);
    }

    public void handleFlush(java.lang.String str) {
        handleOutput(str);
    }

    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        return getProject().defaultInput(bArr, i, i2);
    }

    public void handleOutput(java.lang.String str) {
        log(str, 2);
    }

    public void init() throws org.apache.tools.ant.BuildException {
    }

    public final boolean isInvalid() {
        return this.n;
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void log(java.lang.String str) {
        log(str, 2);
    }

    @Override // org.apache.tools.ant.ProjectComponent
    public void log(java.lang.String str, int i) {
        if (getProject() != null) {
            getProject().log(this, str, i);
        } else {
            super.log(str, i);
        }
    }

    public void log(java.lang.String str, java.lang.Throwable th, int i) {
        if (getProject() != null) {
            getProject().log(this, str, th, i);
        } else {
            super.log(str, i);
        }
    }

    public void log(java.lang.Throwable th, int i) {
        if (th != null) {
            log(th.getMessage(), th, i);
        }
    }

    public void maybeConfigure() throws org.apache.tools.ant.BuildException {
        if (this.n) {
            a();
            return;
        }
        org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = this.wrapper;
        if (runtimeConfigurable != null) {
            runtimeConfigurable.maybeConfigure(getProject());
        }
    }

    public final void perform() {
        java.lang.Throwable th;
        if (this.n) {
            a().getTask().perform();
            return;
        }
        getProject().fireTaskStarted(this);
        org.apache.tools.ant.BuildException buildException = null;
        try {
            try {
                try {
                    maybeConfigure();
                    org.apache.tools.ant.dispatch.DispatchUtils.execute(this);
                    getProject().fireTaskFinished(this, null);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    getProject().fireTaskFinished(this, buildException);
                    throw th;
                }
            } catch (org.apache.tools.ant.BuildException e) {
                if (e.getLocation() == org.apache.tools.ant.Location.UNKNOWN_LOCATION) {
                    e.setLocation(getLocation());
                }
                try {
                    throw e;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    buildException = e;
                    getProject().fireTaskFinished(this, buildException);
                    throw th;
                }
            }
        } catch (java.lang.Error e2) {
            throw e2;
        } catch (java.lang.Exception e3) {
            org.apache.tools.ant.BuildException buildException2 = new org.apache.tools.ant.BuildException(e3);
            buildException2.setLocation(getLocation());
            throw buildException2;
        }
    }

    public void reconfigure() {
        org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable = this.wrapper;
        if (runtimeConfigurable != null) {
            runtimeConfigurable.reconfigure(getProject());
        }
    }

    public void setOwningTarget(org.apache.tools.ant.Target target) {
        this.target = target;
    }

    public void setRuntimeConfigurableWrapper(org.apache.tools.ant.RuntimeConfigurable runtimeConfigurable) {
        this.wrapper = runtimeConfigurable;
    }

    public void setTaskName(java.lang.String str) {
        this.taskName = str;
    }

    public void setTaskType(java.lang.String str) {
        this.taskType = str;
    }
}
