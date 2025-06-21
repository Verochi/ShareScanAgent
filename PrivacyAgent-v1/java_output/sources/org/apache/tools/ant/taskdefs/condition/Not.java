package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Not extends org.apache.tools.ant.taskdefs.condition.ConditionBase implements org.apache.tools.ant.taskdefs.condition.Condition {
    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (countConditions() > 1) {
            throw new org.apache.tools.ant.BuildException("You must not nest more than one condition into <not>");
        }
        if (countConditions() >= 1) {
            return !((org.apache.tools.ant.taskdefs.condition.Condition) getConditions().nextElement()).eval();
        }
        throw new org.apache.tools.ant.BuildException("You must nest a condition into <not>");
    }
}
