package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ConditionTask extends org.apache.tools.ant.taskdefs.condition.ConditionBase {
    public java.lang.String u;
    public java.lang.Object v;
    public java.lang.Object w;

    public ConditionTask() {
        super("condition");
        this.u = null;
        this.v = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
        this.w = null;
    }

    public void execute() throws org.apache.tools.ant.BuildException {
        if (countConditions() > 1) {
            throw new org.apache.tools.ant.BuildException("You must not nest more than one condition into <" + getTaskName() + ">");
        }
        if (countConditions() < 1) {
            throw new org.apache.tools.ant.BuildException("You must nest a condition into <" + getTaskName() + ">");
        }
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("The property attribute is required.");
        }
        if (((org.apache.tools.ant.taskdefs.condition.Condition) getConditions().nextElement()).eval()) {
            log("Condition true; setting " + this.u + " to " + this.v, 4);
            org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject()).setNewProperty(this.u, this.v);
            return;
        }
        if (this.w == null) {
            log("Condition false; not setting " + this.u, 4);
            return;
        }
        log("Condition false; setting " + this.u + " to " + this.w, 4);
        org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject()).setNewProperty(this.u, this.w);
    }

    public void setElse(java.lang.Object obj) {
        this.w = obj;
    }

    public void setElse(java.lang.String str) {
        setElse((java.lang.Object) str);
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public void setValue(java.lang.Object obj) {
        this.v = obj;
    }

    public void setValue(java.lang.String str) {
        setValue((java.lang.Object) str);
    }
}
