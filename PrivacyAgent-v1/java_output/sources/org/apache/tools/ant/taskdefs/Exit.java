package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Exit extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.lang.Object v;
    public java.lang.Object w;
    public org.apache.tools.ant.taskdefs.Exit.NestedCondition x;
    public java.lang.Integer y;

    public static class NestedCondition extends org.apache.tools.ant.taskdefs.condition.ConditionBase implements org.apache.tools.ant.taskdefs.condition.Condition {
        public NestedCondition() {
        }

        public /* synthetic */ NestedCondition(org.apache.tools.ant.taskdefs.Exit.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.apache.tools.ant.taskdefs.condition.Condition
        public boolean eval() {
            if (countConditions() == 1) {
                return ((org.apache.tools.ant.taskdefs.condition.Condition) getConditions().nextElement()).eval();
            }
            throw new org.apache.tools.ant.BuildException("A single nested condition is required.");
        }
    }

    public void addText(java.lang.String str) {
        if (this.u == null) {
            this.u = "";
        }
        this.u += getProject().replaceProperties(str);
    }

    public final boolean c() {
        return this.x != null;
    }

    public org.apache.tools.ant.taskdefs.condition.ConditionBase createCondition() {
        if (this.x != null) {
            throw new org.apache.tools.ant.BuildException("Only one nested condition is allowed.");
        }
        org.apache.tools.ant.taskdefs.Exit.NestedCondition nestedCondition = new org.apache.tools.ant.taskdefs.Exit.NestedCondition(null);
        this.x = nestedCondition;
        return nestedCondition;
    }

    public final boolean d() {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject()).testIfCondition(this.v);
    }

    public final boolean e() {
        boolean c = c();
        if ((!c || this.v == null) && this.w == null) {
            return c && this.x.eval();
        }
        throw new org.apache.tools.ant.BuildException("Nested conditions not permitted in conjunction with if/unless attributes");
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        if (c() ? e() : d() && f()) {
            java.lang.String str2 = this.u;
            if (str2 == null || str2.trim().length() <= 0) {
                java.lang.Object obj = this.v;
                java.lang.String str3 = "";
                if (obj == null || "".equals(obj) || !d()) {
                    str = null;
                } else {
                    str = "if=" + this.v;
                }
                java.lang.Object obj2 = this.w;
                if (obj2 != null && !"".equals(obj2) && f()) {
                    if (str != null) {
                        str3 = str + " and ";
                    }
                    str = str3 + "unless=" + this.w;
                }
                if (c()) {
                    str = "condition satisfied";
                } else if (str == null) {
                    str = "No message";
                }
            } else {
                str = this.u.trim();
            }
            log("failing due to " + str, 4);
            if (this.y != null) {
                throw new org.apache.tools.ant.ExitStatusException(str, this.y.intValue());
            }
        }
    }

    public final boolean f() {
        return org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject()).testUnlessCondition(this.w);
    }

    public void setIf(java.lang.Object obj) {
        this.v = obj;
    }

    public void setIf(java.lang.String str) {
        setIf((java.lang.Object) str);
    }

    public void setMessage(java.lang.String str) {
        this.u = str;
    }

    public void setStatus(int i) {
        this.y = java.lang.Integer.valueOf(i);
    }

    public void setUnless(java.lang.Object obj) {
        this.w = obj;
    }

    public void setUnless(java.lang.String str) {
        setUnless((java.lang.Object) str);
    }
}
