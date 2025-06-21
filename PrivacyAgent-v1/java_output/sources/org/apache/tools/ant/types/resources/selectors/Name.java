package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Name implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public java.lang.String t;
    public org.apache.tools.ant.types.RegularExpression w;
    public org.apache.tools.ant.util.regexp.Regexp x;
    public org.apache.tools.ant.Project y;
    public java.lang.String n = null;
    public boolean u = true;
    public boolean v = false;

    public final boolean a(java.lang.String str) {
        java.lang.String str2 = this.t;
        if (str2 != null) {
            return org.apache.tools.ant.types.selectors.SelectorUtils.match(b(str2), b(str), this.u);
        }
        if (this.w == null) {
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            this.w = regularExpression;
            regularExpression.setPattern(this.n);
            this.x = this.w.getRegexp(this.y);
        }
        return this.x.matches(b(str), org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(this.u));
    }

    public final java.lang.String b(java.lang.String str) {
        return (str != null && this.v && str.contains("\\")) ? str.replace('\\', '/') : str;
    }

    public boolean doesHandledirSep() {
        return this.v;
    }

    public java.lang.String getName() {
        return this.t;
    }

    public java.lang.String getRegex() {
        return this.n;
    }

    public boolean isCaseSensitive() {
        return this.u;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        java.lang.String name = resource.getName();
        if (a(name)) {
            return true;
        }
        java.lang.String resource2 = resource.toString();
        if (resource2.equals(name)) {
            return false;
        }
        return a(resource2);
    }

    public void setCaseSensitive(boolean z) {
        this.u = z;
    }

    public void setHandleDirSep(boolean z) {
        this.v = z;
    }

    public void setName(java.lang.String str) {
        this.t = str;
    }

    public void setProject(org.apache.tools.ant.Project project) {
        this.y = project;
    }

    public void setRegex(java.lang.String str) {
        this.n = str;
        this.w = null;
    }
}
