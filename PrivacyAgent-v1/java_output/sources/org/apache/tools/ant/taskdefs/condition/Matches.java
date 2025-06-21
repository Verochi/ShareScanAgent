package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Matches extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public boolean t = true;
    public boolean u = false;
    public boolean v = false;
    public org.apache.tools.ant.types.RegularExpression w;

    public void addRegexp(org.apache.tools.ant.types.RegularExpression regularExpression) {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("Only one regular expression is allowed.");
        }
        this.w = regularExpression;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("Parameter string is required in matches.");
        }
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException("Missing pattern in matches.");
        }
        return this.w.getRegexp(getProject()).matches(this.n, org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(this.t, this.u, this.v));
    }

    public void setCasesensitive(boolean z) {
        this.t = z;
    }

    public void setMultiline(boolean z) {
        this.u = z;
    }

    public void setPattern(java.lang.String str) {
        if (this.w != null) {
            throw new org.apache.tools.ant.BuildException("Only one regular expression is allowed.");
        }
        org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
        this.w = regularExpression;
        regularExpression.setPattern(str);
    }

    public void setSingleLine(boolean z) {
        this.v = z;
    }

    public void setString(java.lang.String str) {
        this.n = str;
    }
}
