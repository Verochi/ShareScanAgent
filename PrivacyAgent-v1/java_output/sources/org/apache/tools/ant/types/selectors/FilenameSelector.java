package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class FilenameSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector {
    public static final java.lang.String CASE_KEY = "casesensitive";
    public static final java.lang.String NAME_KEY = "name";
    public static final java.lang.String NEGATE_KEY = "negate";
    public static final java.lang.String REGEX_KEY = "regex";
    public java.lang.String u = null;
    public java.lang.String v = null;
    public boolean w = true;
    public boolean x = false;
    public org.apache.tools.ant.types.RegularExpression y;
    public org.apache.tools.ant.util.regexp.Regexp z;

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        java.lang.String str2 = this.u;
        if (str2 != null) {
            return org.apache.tools.ant.types.selectors.SelectorUtils.matchPath(str2, str, this.w) == (this.x ^ true);
        }
        if (this.y == null) {
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            this.y = regularExpression;
            regularExpression.setPattern(this.v);
            this.z = this.y.getRegexp(getProject());
        }
        return this.z.matches(str, org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(this.w)) == (this.x ^ true);
    }

    public void setCasesensitive(boolean z) {
        this.w = z;
    }

    public void setName(java.lang.String str) {
        java.lang.String replace = str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
        if (replace.endsWith(java.io.File.separator)) {
            replace = replace + org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH;
        }
        this.u = replace;
    }

    public void setNegate(boolean z) {
        this.x = z;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if ("name".equalsIgnoreCase(name)) {
                    setName(parameter.getValue());
                } else if ("casesensitive".equalsIgnoreCase(name)) {
                    setCasesensitive(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if (NEGATE_KEY.equalsIgnoreCase(name)) {
                    setNegate(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if (REGEX_KEY.equalsIgnoreCase(name)) {
                    setRegex(parameter.getValue());
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setRegex(java.lang.String str) {
        this.v = str;
        this.y = null;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{filenameselector name: ");
        java.lang.String str = this.u;
        if (str != null) {
            sb.append(str);
        }
        java.lang.String str2 = this.v;
        if (str2 != null) {
            sb.append(str2);
            sb.append(" [as regular expression]");
        }
        sb.append(" negate: ");
        sb.append(this.x);
        sb.append(" casesensitive: ");
        sb.append(this.w);
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        java.lang.String str = this.u;
        if (str == null && this.v == null) {
            setError("The name or regex attribute is required");
        } else {
            if (str == null || this.v == null) {
                return;
            }
            setError("Only one of name and regex attribute is allowed");
        }
    }
}
