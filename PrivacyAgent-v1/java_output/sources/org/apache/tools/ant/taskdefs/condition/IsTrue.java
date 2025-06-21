package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsTrue extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.Boolean n = null;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.lang.Boolean bool = this.n;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new org.apache.tools.ant.BuildException("Nothing to test for truth");
    }

    public void setValue(boolean z) {
        this.n = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }
}
