package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class ContainsSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public static final java.lang.String CASE_KEY = "casesensitive";
    public static final java.lang.String CONTAINS_KEY = "text";
    public static final java.lang.String EXPRESSION_KEY = "expression";
    public static final java.lang.String WHITESPACE_KEY = "ignorewhitespace";
    public java.lang.String u = null;
    public boolean v = true;
    public boolean w = false;
    public java.lang.String x = null;

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        return isSelected(new org.apache.tools.ant.types.resources.FileResource(file2));
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        validate();
        if (resource.isDirectory() || this.u.length() == 0) {
            return true;
        }
        java.lang.String str = this.u;
        if (!this.v) {
            str = str.toLowerCase();
        }
        if (this.w) {
            str = org.apache.tools.ant.types.selectors.SelectorUtils.removeWhitespace(str);
        }
        try {
            java.io.BufferedReader bufferedReader = this.x != null ? new java.io.BufferedReader(new java.io.InputStreamReader(resource.getInputStream(), this.x)) : new java.io.BufferedReader(new java.io.InputStreamReader(resource.getInputStream()));
            try {
                try {
                    java.lang.String readLine = bufferedReader.readLine();
                    while (readLine != null) {
                        if (!this.v) {
                            readLine = readLine.toLowerCase();
                        }
                        if (this.w) {
                            readLine = org.apache.tools.ant.types.selectors.SelectorUtils.removeWhitespace(readLine);
                        }
                        if (readLine.contains(str)) {
                            return true;
                        }
                        readLine = bufferedReader.readLine();
                    }
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    return false;
                } catch (java.io.IOException unused) {
                    throw new org.apache.tools.ant.BuildException("Could not read " + resource.toLongString());
                }
            } finally {
                org.apache.tools.ant.util.FileUtils.close(bufferedReader);
            }
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Could not get InputStream from " + resource.toLongString(), e);
        }
    }

    public void setCasesensitive(boolean z) {
        this.v = z;
    }

    public void setEncoding(java.lang.String str) {
        this.x = str;
    }

    public void setIgnorewhitespace(boolean z) {
        this.w = z;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if ("text".equalsIgnoreCase(name)) {
                    setText(parameter.getValue());
                } else if ("casesensitive".equalsIgnoreCase(name)) {
                    setCasesensitive(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if (WHITESPACE_KEY.equalsIgnoreCase(name)) {
                    setIgnorewhitespace(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setText(java.lang.String str) {
        this.u = str;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{containsselector text: ");
        sb.append(kotlin.text.Typography.quote);
        sb.append(this.u);
        sb.append(kotlin.text.Typography.quote);
        sb.append(" casesensitive: ");
        boolean z = this.v;
        java.lang.String str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
        sb.append(z ? com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        sb.append(" ignorewhitespace: ");
        if (!this.w) {
            str = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
        }
        sb.append(str);
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.u == null) {
            setError("The text attribute is required");
        }
    }
}
