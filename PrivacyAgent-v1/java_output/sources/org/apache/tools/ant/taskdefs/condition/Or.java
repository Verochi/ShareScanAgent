package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Or extends org.apache.tools.ant.taskdefs.condition.ConditionBase implements org.apache.tools.ant.taskdefs.condition.Condition {
    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration conditions = getConditions();
        while (conditions.hasMoreElements()) {
            if (((org.apache.tools.ant.taskdefs.condition.Condition) conditions.nextElement()).eval()) {
                return true;
            }
        }
        return false;
    }
}
