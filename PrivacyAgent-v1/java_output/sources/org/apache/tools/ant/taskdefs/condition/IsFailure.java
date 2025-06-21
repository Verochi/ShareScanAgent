package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsFailure implements org.apache.tools.ant.taskdefs.condition.Condition {
    public int n;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        return org.apache.tools.ant.taskdefs.Execute.isFailure(this.n);
    }

    public int getCode() {
        return this.n;
    }

    public void setCode(int i) {
        this.n = i;
    }
}
