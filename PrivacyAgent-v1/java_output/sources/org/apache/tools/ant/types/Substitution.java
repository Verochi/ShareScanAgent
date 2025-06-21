package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Substitution extends org.apache.tools.ant.types.DataType {
    public static final java.lang.String DATA_TYPE_NAME = "substitution";
    public java.lang.String n = null;

    public java.lang.String getExpression(org.apache.tools.ant.Project project) {
        return isReference() ? getRef(project).getExpression(project) : this.n;
    }

    public org.apache.tools.ant.types.Substitution getRef(org.apache.tools.ant.Project project) {
        return (org.apache.tools.ant.types.Substitution) getCheckedRef(project);
    }

    public void setExpression(java.lang.String str) {
        this.n = str;
    }
}
