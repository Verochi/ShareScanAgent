package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Environment {
    protected java.util.Vector<org.apache.tools.ant.types.Environment.Variable> variables = new java.util.Vector<>();

    public static class Variable {
        public java.lang.String a;
        public java.lang.String b;

        public java.lang.String getContent() throws org.apache.tools.ant.BuildException {
            validate();
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(this.a.trim());
            stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(this.b.trim());
            return stringBuffer.toString();
        }

        public java.lang.String getKey() {
            return this.a;
        }

        public java.lang.String getValue() {
            return this.b;
        }

        public void setFile(java.io.File file) {
            this.b = file.getAbsolutePath();
        }

        public void setKey(java.lang.String str) {
            this.a = str;
        }

        public void setPath(org.apache.tools.ant.types.Path path) {
            this.b = path.toString();
        }

        public void setValue(java.lang.String str) {
            this.b = str;
        }

        public void validate() {
            if (this.a == null || this.b == null) {
                throw new org.apache.tools.ant.BuildException("key and value must be specified for environment variables.");
            }
        }
    }

    public void addVariable(org.apache.tools.ant.types.Environment.Variable variable) {
        this.variables.addElement(variable);
    }

    public java.lang.String[] getVariables() throws org.apache.tools.ant.BuildException {
        if (this.variables.size() == 0) {
            return null;
        }
        int size = this.variables.size();
        java.lang.String[] strArr = new java.lang.String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = this.variables.elementAt(i).getContent();
        }
        return strArr;
    }

    public java.util.Vector<org.apache.tools.ant.types.Environment.Variable> getVariablesVector() {
        return this.variables;
    }
}
