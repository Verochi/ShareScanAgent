package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class JavaVersion implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n = null;
    public java.lang.String t = null;

    public final void a() throws org.apache.tools.ant.BuildException {
        java.lang.String str = this.n;
        if (str != null && this.t != null) {
            throw new org.apache.tools.ant.BuildException("Only one of atleast or exactly may be set.");
        }
        if (str == null && this.t == null) {
            throw new org.apache.tools.ant.BuildException("One of atleast or exactly must be set.");
        }
        if (str != null) {
            try {
                new org.apache.tools.ant.util.DeweyDecimal(str);
                return;
            } catch (java.lang.NumberFormatException unused) {
                throw new org.apache.tools.ant.BuildException("The 'atleast' attribute is not a Dewey Decimal eg 1.1.0 : " + this.n);
            }
        }
        try {
            new org.apache.tools.ant.util.DeweyDecimal(this.t);
        } catch (java.lang.NumberFormatException unused2) {
            throw new org.apache.tools.ant.BuildException("The 'exactly' attribute is not a Dewey Decimal eg 1.1.0 : " + this.t);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        a();
        org.apache.tools.ant.util.DeweyDecimal parsedJavaVersion = org.apache.tools.ant.util.JavaEnvUtils.getParsedJavaVersion();
        java.lang.String str = this.n;
        if (str != null) {
            return parsedJavaVersion.isGreaterThanOrEqual(new org.apache.tools.ant.util.DeweyDecimal(str));
        }
        java.lang.String str2 = this.t;
        if (str2 != null) {
            return parsedJavaVersion.isEqual(new org.apache.tools.ant.util.DeweyDecimal(str2));
        }
        return false;
    }

    public java.lang.String getAtLeast() {
        return this.n;
    }

    public java.lang.String getExactly() {
        return this.t;
    }

    public void setAtLeast(java.lang.String str) {
        this.n = str;
    }

    public void setExactly(java.lang.String str) {
        this.t = str;
    }
}
