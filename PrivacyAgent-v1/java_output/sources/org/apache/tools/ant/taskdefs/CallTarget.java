package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class CallTarget extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.taskdefs.Ant u;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;

    public void addConfiguredTarget(org.apache.tools.ant.taskdefs.Ant.TargetElement targetElement) {
        if (this.u == null) {
            init();
        }
        this.u.addConfiguredTarget(targetElement);
        this.x = true;
    }

    public void addPropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        if (this.u == null) {
            init();
        }
        this.u.addPropertyset(propertySet);
    }

    public void addReference(org.apache.tools.ant.taskdefs.Ant.Reference reference) {
        if (this.u == null) {
            init();
        }
        this.u.addReference(reference);
    }

    public org.apache.tools.ant.taskdefs.Property createParam() {
        if (this.u == null) {
            init();
        }
        return this.u.createProperty();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            init();
        }
        if (!this.x) {
            throw new org.apache.tools.ant.BuildException("Attribute target or at least one nested target is required.", getLocation());
        }
        this.u.setAntfile(getProject().getProperty(org.apache.tools.ant.MagicNames.ANT_FILE));
        this.u.setInheritAll(this.v);
        this.u.setInheritRefs(this.w);
        this.u.execute();
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorFlush(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.u;
        if (ant != null) {
            ant.handleErrorFlush(str);
        } else {
            super.handleErrorFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorOutput(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.u;
        if (ant != null) {
            ant.handleErrorOutput(str);
        } else {
            super.handleErrorOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleFlush(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.u;
        if (ant != null) {
            ant.handleFlush(str);
        } else {
            super.handleFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        org.apache.tools.ant.taskdefs.Ant ant = this.u;
        return ant != null ? ant.handleInput(bArr, i, i2) : super.handleInput(bArr, i, i2);
    }

    @Override // org.apache.tools.ant.Task
    public void handleOutput(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.u;
        if (ant != null) {
            ant.handleOutput(str);
        } else {
            super.handleOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void init() {
        org.apache.tools.ant.taskdefs.Ant ant = new org.apache.tools.ant.taskdefs.Ant(this);
        this.u = ant;
        ant.init();
    }

    public void setInheritAll(boolean z) {
        this.v = z;
    }

    public void setInheritRefs(boolean z) {
        this.w = z;
    }

    public void setTarget(java.lang.String str) {
        if (this.u == null) {
            init();
        }
        this.u.setTarget(str);
        this.x = true;
    }
}
