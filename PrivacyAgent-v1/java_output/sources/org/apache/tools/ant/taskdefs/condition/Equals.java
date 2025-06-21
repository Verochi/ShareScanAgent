package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Equals implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.Object n;
    public java.lang.Object t;
    public int w;
    public boolean u = false;
    public boolean v = true;
    public boolean x = false;

    public final void a(java.lang.Object obj) {
        this.n = obj;
        this.w |= 1;
    }

    public final void b(java.lang.Object obj) {
        this.t = obj;
        this.w |= 2;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if ((this.w & 3) != 3) {
            throw new org.apache.tools.ant.BuildException("both arg1 and arg2 are required in equals");
        }
        java.lang.Object obj = this.n;
        java.lang.Object obj2 = this.t;
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        if (this.x) {
            java.lang.Object obj3 = this.n;
            if (obj3 != null && !(obj3 instanceof java.lang.String)) {
                obj3 = obj3.toString();
            }
            this.n = obj3;
            java.lang.Object obj4 = this.t;
            if (obj4 != null && !(obj4 instanceof java.lang.String)) {
                obj4 = obj4.toString();
            }
            this.t = obj4;
        }
        java.lang.Object obj5 = this.n;
        if ((obj5 instanceof java.lang.String) && this.u) {
            this.n = ((java.lang.String) obj5).trim();
        }
        java.lang.Object obj6 = this.t;
        if ((obj6 instanceof java.lang.String) && this.u) {
            this.t = ((java.lang.String) obj6).trim();
        }
        java.lang.Object obj7 = this.n;
        if (!(obj7 instanceof java.lang.String)) {
            return false;
        }
        java.lang.Object obj8 = this.t;
        if (!(obj8 instanceof java.lang.String)) {
            return false;
        }
        java.lang.String str = (java.lang.String) obj7;
        java.lang.String str2 = (java.lang.String) obj8;
        return this.v ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public void setArg1(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            setArg1((java.lang.String) obj);
        } else {
            a(obj);
        }
    }

    public void setArg1(java.lang.String str) {
        a(str);
    }

    public void setArg2(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            setArg2((java.lang.String) obj);
        } else {
            b(obj);
        }
    }

    public void setArg2(java.lang.String str) {
        b(str);
    }

    public void setCasesensitive(boolean z) {
        this.v = z;
    }

    public void setForcestring(boolean z) {
        this.x = z;
    }

    public void setTrim(boolean z) {
        this.u = z;
    }
}
