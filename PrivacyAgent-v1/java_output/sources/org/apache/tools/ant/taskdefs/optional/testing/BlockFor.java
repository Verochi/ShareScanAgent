package org.apache.tools.ant.taskdefs.optional.testing;

/* loaded from: classes25.dex */
public class BlockFor extends org.apache.tools.ant.taskdefs.WaitFor {
    public java.lang.String z;

    public BlockFor() {
        super("blockfor");
        this.z = getTaskName() + " timed out";
    }

    public BlockFor(java.lang.String str) {
        super(str);
    }

    public void addText(java.lang.String str) {
        this.z = getProject().replaceProperties(str);
    }

    @Override // org.apache.tools.ant.taskdefs.WaitFor
    public void processTimeout() throws org.apache.tools.ant.taskdefs.optional.testing.BuildTimeoutException {
        super.processTimeout();
        throw new org.apache.tools.ant.taskdefs.optional.testing.BuildTimeoutException(this.z, getLocation());
    }
}
