package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class HasFreeSpace implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public java.lang.String t;

    public final void a() throws org.apache.tools.ant.BuildException {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("Please set the partition attribute.");
        }
        if (this.t == null) {
            throw new org.apache.tools.ant.BuildException("Please set the needed attribute.");
        }
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        a();
        try {
            if (org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)) {
                return ((java.lang.Long) new org.apache.tools.ant.util.ReflectWrapper(new java.io.File(this.n)).invoke("getFreeSpace")).longValue() >= org.apache.tools.ant.util.StringUtils.parseHumanSizes(this.t);
            }
            throw new org.apache.tools.ant.BuildException("HasFreeSpace condition not supported on Java5 or less.");
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public java.lang.String getNeeded() {
        return this.t;
    }

    public java.lang.String getPartition() {
        return this.n;
    }

    public void setNeeded(java.lang.String str) {
        this.t = str;
    }

    public void setPartition(java.lang.String str) {
        this.n = str;
    }
}
