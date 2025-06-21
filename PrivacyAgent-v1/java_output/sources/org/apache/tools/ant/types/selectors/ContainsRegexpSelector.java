package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class ContainsRegexpSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public static final java.lang.String EXPRESSION_KEY = "expression";
    public java.lang.String u = null;
    public org.apache.tools.ant.types.RegularExpression v = null;
    public org.apache.tools.ant.util.regexp.Regexp w = null;
    public boolean x = true;
    public boolean y = false;
    public boolean z = false;

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        return isSelected(new org.apache.tools.ant.types.resources.FileResource(file2));
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        validate();
        if (resource.isDirectory()) {
            return true;
        }
        if (this.v == null) {
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            this.v = regularExpression;
            regularExpression.setPattern(this.u);
            this.w = this.v.getRegexp(getProject());
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(resource.getInputStream()));
            try {
                try {
                    for (java.lang.String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (this.w.matches(readLine, org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(this.x, this.y, this.z))) {
                            return true;
                        }
                    }
                    try {
                        bufferedReader.close();
                        return false;
                    } catch (java.lang.Exception unused) {
                        throw new org.apache.tools.ant.BuildException("Could not close " + resource.toLongString());
                    }
                } catch (java.io.IOException unused2) {
                    throw new org.apache.tools.ant.BuildException("Could not read " + resource.toLongString());
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (java.lang.Exception unused3) {
                }
            }
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Could not get InputStream from " + resource.toLongString(), e);
        }
    }

    public void setCaseSensitive(boolean z) {
        this.x = z;
    }

    public void setExpression(java.lang.String str) {
        this.u = str;
    }

    public void setMultiLine(boolean z) {
        this.y = z;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if ("expression".equalsIgnoreCase(name)) {
                    setExpression(parameter.getValue());
                } else if ("casesensitive".equalsIgnoreCase(name)) {
                    setCaseSensitive(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if ("multiline".equalsIgnoreCase(name)) {
                    setMultiLine(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if ("singleline".equalsIgnoreCase(name)) {
                    setSingleLine(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setSingleLine(boolean z) {
        this.z = z;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return "{containsregexpselector expression: " + this.u + com.alipay.sdk.m.u.i.d;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.u == null) {
            setError("The expression attribute is required");
        }
    }
}
