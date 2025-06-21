package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class TypeSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector {
    public static final java.lang.String TYPE_KEY = "type";
    public java.lang.String u = null;

    public static class FileType extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String DIR = "dir";
        public static final java.lang.String FILE = "file";

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"file", "dir"};
        }
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        return file2.isDirectory() ? this.u.equals("dir") : this.u.equals("file");
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if ("type".equalsIgnoreCase(name)) {
                    org.apache.tools.ant.types.selectors.TypeSelector.FileType fileType = new org.apache.tools.ant.types.selectors.TypeSelector.FileType();
                    fileType.setValue(parameter.getValue());
                    setType(fileType);
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setType(org.apache.tools.ant.types.selectors.TypeSelector.FileType fileType) {
        this.u = fileType.getValue();
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "{typeselector type: " + this.u + com.alipay.sdk.m.u.i.d;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.u == null) {
            setError("The type attribute is required");
        }
    }
}
