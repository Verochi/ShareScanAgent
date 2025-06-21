package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Xor extends org.apache.tools.ant.taskdefs.condition.ConditionBase implements org.apache.tools.ant.taskdefs.condition.Condition {
    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration conditions = getConditions();
        boolean z = false;
        while (conditions.hasMoreElements()) {
            z ^= ((org.apache.tools.ant.taskdefs.condition.Condition) conditions.nextElement()).eval();
        }
        return z;
    }
}
