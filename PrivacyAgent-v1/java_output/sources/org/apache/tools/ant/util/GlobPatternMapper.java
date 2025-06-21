package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class GlobPatternMapper implements org.apache.tools.ant.util.FileNameMapper {
    protected int postfixLength;
    protected int prefixLength;
    protected java.lang.String fromPrefix = null;
    protected java.lang.String fromPostfix = null;
    protected java.lang.String toPrefix = null;
    protected java.lang.String toPostfix = null;
    public boolean n = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;

    public final java.lang.String a(java.lang.String str) {
        if (!this.v) {
            str = str.toLowerCase();
        }
        return (!this.u || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public java.lang.String extractVariablePart(java.lang.String str) {
        return str.substring(this.prefixLength, str.length() - this.postfixLength);
    }

    public boolean getHandleDirSep() {
        return this.u;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        java.lang.String str2;
        java.lang.String[] strArr = null;
        if (str == null) {
            return null;
        }
        java.lang.String a = a(str);
        if (this.fromPrefix != null && str.length() >= this.prefixLength + this.postfixLength && ((this.n || a.equals(a(this.fromPrefix))) && (!this.n || (a.startsWith(a(this.fromPrefix)) && a.endsWith(a(this.fromPostfix)))))) {
            strArr = new java.lang.String[1];
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.toPrefix);
            if (this.t) {
                str2 = extractVariablePart(str) + this.toPostfix;
            } else {
                str2 = "";
            }
            sb.append(str2);
            strArr[0] = sb.toString();
        }
        return strArr;
    }

    public void setCaseSensitive(boolean z) {
        this.v = z;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("this mapper requires a 'from' attribute");
        }
        int lastIndexOf = str.lastIndexOf("*");
        if (lastIndexOf == -1) {
            this.fromPrefix = str;
            this.fromPostfix = "";
        } else {
            this.fromPrefix = str.substring(0, lastIndexOf);
            this.fromPostfix = str.substring(lastIndexOf + 1);
            this.n = true;
        }
        this.prefixLength = this.fromPrefix.length();
        this.postfixLength = this.fromPostfix.length();
    }

    public void setHandleDirSep(boolean z) {
        this.u = z;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
        if (str == null) {
            throw new org.apache.tools.ant.BuildException("this mapper requires a 'to' attribute");
        }
        int lastIndexOf = str.lastIndexOf("*");
        if (lastIndexOf == -1) {
            this.toPrefix = str;
            this.toPostfix = "";
        } else {
            this.toPrefix = str.substring(0, lastIndexOf);
            this.toPostfix = str.substring(lastIndexOf + 1);
            this.t = true;
        }
    }
}
