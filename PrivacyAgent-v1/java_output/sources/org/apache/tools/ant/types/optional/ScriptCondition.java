package org.apache.tools.ant.types.optional;

/* loaded from: classes26.dex */
public class ScriptCondition extends org.apache.tools.ant.types.optional.AbstractScriptComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public boolean u = false;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        initScriptRunner();
        executeScript("ant_condition");
        return getValue();
    }

    public boolean getValue() {
        return this.u;
    }

    public void setValue(boolean z) {
        this.u = z;
    }
}
