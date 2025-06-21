package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class AntVersion extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String u = null;
    public java.lang.String v = null;
    public java.lang.String w = null;

    public final org.apache.tools.ant.util.DeweyDecimal c() {
        org.apache.tools.ant.Project project = new org.apache.tools.ant.Project();
        project.init();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        for (char c : project.getProperty(org.apache.tools.ant.MagicNames.ANT_VERSION).toCharArray()) {
            if (java.lang.Character.isDigit(c)) {
                sb.append(c);
                z = true;
            }
            if (c == '.' && z) {
                sb.append(c);
            }
            if (java.lang.Character.isLetter(c) && z) {
                break;
            }
        }
        return new org.apache.tools.ant.util.DeweyDecimal(sb.toString());
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        validate();
        org.apache.tools.ant.util.DeweyDecimal c = c();
        java.lang.String str = this.u;
        if (str != null) {
            return c.isGreaterThanOrEqual(new org.apache.tools.ant.util.DeweyDecimal(str));
        }
        java.lang.String str2 = this.v;
        if (str2 != null) {
            return c.isEqual(new org.apache.tools.ant.util.DeweyDecimal(str2));
        }
        return false;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.w == null) {
            throw new org.apache.tools.ant.BuildException("'property' must be set.");
        }
        if (this.u == null && this.v == null) {
            getProject().setNewProperty(this.w, c().toString());
        } else if (eval()) {
            getProject().setNewProperty(this.w, c().toString());
        }
    }

    public java.lang.String getAtLeast() {
        return this.u;
    }

    public java.lang.String getExactly() {
        return this.v;
    }

    public java.lang.String getProperty() {
        return this.w;
    }

    public void setAtLeast(java.lang.String str) {
        this.u = str;
    }

    public void setExactly(java.lang.String str) {
        this.v = str;
    }

    public void setProperty(java.lang.String str) {
        this.w = str;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.u;
        if (str != null && this.v != null) {
            throw new org.apache.tools.ant.BuildException("Only one of atleast or exactly may be set.");
        }
        if (str == null && this.v == null) {
            throw new org.apache.tools.ant.BuildException("One of atleast or exactly must be set.");
        }
        if (str != null) {
            try {
                new org.apache.tools.ant.util.DeweyDecimal(str);
                return;
            } catch (java.lang.NumberFormatException unused) {
                throw new org.apache.tools.ant.BuildException("The 'atleast' attribute is not a Dewey Decimal eg 1.1.0 : " + this.u);
            }
        }
        try {
            new org.apache.tools.ant.util.DeweyDecimal(this.v);
        } catch (java.lang.NumberFormatException unused2) {
            throw new org.apache.tools.ant.BuildException("The 'exactly' attribute is not a Dewey Decimal eg 1.1.0 : " + this.v);
        }
    }
}
