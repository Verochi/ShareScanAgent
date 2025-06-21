package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class TypeFound extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public java.lang.String t;

    public boolean doesTypeExist(java.lang.String str) {
        org.apache.tools.ant.ComponentHelper componentHelper = org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject());
        java.lang.String genComponentName = org.apache.tools.ant.ProjectHelper.genComponentName(this.t, str);
        org.apache.tools.ant.AntTypeDefinition definition = componentHelper.getDefinition(genComponentName);
        if (definition == null) {
            return false;
        }
        boolean z = definition.getExposedClass(getProject()) != null;
        if (!z) {
            log(componentHelper.diagnoseCreationFailure(genComponentName, "type"), 3);
        }
        return z;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.n;
        if (str != null) {
            return doesTypeExist(str);
        }
        throw new org.apache.tools.ant.BuildException("No type specified");
    }

    public void setName(java.lang.String str) {
        this.n = str;
    }

    public void setURI(java.lang.String str) {
        this.t = str;
    }
}
