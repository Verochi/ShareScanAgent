package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class RegularExpression extends org.apache.tools.ant.types.DataType {
    public static final java.lang.String DATA_TYPE_NAME = "regexp";
    public static final org.apache.tools.ant.util.regexp.RegexpFactory w = new org.apache.tools.ant.util.regexp.RegexpFactory();
    public java.lang.String u;
    public boolean n = false;
    public org.apache.tools.ant.util.regexp.Regexp t = null;
    public boolean v = false;

    public final void b(org.apache.tools.ant.Project project) {
        if (this.n) {
            return;
        }
        this.t = w.newRegexp(project);
        this.n = true;
    }

    public final void c() {
        if (this.v) {
            this.t.setPattern(this.u);
            this.v = false;
        }
    }

    public java.lang.String getPattern(org.apache.tools.ant.Project project) {
        b(project);
        if (isReference()) {
            return getRef(project).getPattern(project);
        }
        c();
        return this.t.getPattern();
    }

    public org.apache.tools.ant.types.RegularExpression getRef(org.apache.tools.ant.Project project) {
        return (org.apache.tools.ant.types.RegularExpression) getCheckedRef(project);
    }

    public org.apache.tools.ant.util.regexp.Regexp getRegexp(org.apache.tools.ant.Project project) {
        b(project);
        if (isReference()) {
            return getRef(project).getRegexp(project);
        }
        c();
        return this.t;
    }

    public void setPattern(java.lang.String str) {
        org.apache.tools.ant.util.regexp.Regexp regexp = this.t;
        if (regexp != null) {
            regexp.setPattern(str);
        } else {
            this.u = str;
            this.v = true;
        }
    }
}
