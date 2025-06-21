package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class StringTokenizer extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.util.Tokenizer {
    public java.lang.String n = "";
    public int t = -2;
    public char[] u = null;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;

    public final boolean a(char c) {
        char[] cArr = this.u;
        if (cArr == null) {
            return java.lang.Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.tools.ant.util.Tokenizer
    public java.lang.String getPostToken() {
        return (this.w || this.x) ? "" : this.n;
    }

    @Override // org.apache.tools.ant.util.Tokenizer
    public java.lang.String getToken(java.io.Reader reader) throws java.io.IOException {
        int i = this.t;
        if (i != -2) {
            this.t = -2;
        } else {
            i = reader.read();
        }
        if (i == -1) {
            return null;
        }
        this.n = "";
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        boolean z = true;
        while (true) {
            if (i == -1) {
                break;
            }
            char c = (char) i;
            boolean a = a(c);
            if (!z) {
                if (!a) {
                    this.t = i;
                    break;
                }
                stringBuffer2.append(c);
                i = reader.read();
            } else {
                if (!a) {
                    stringBuffer.append(c);
                } else if (!this.v) {
                    stringBuffer2.append(c);
                    z = false;
                } else if (stringBuffer.length() == 0) {
                    stringBuffer.append(c);
                } else {
                    this.t = i;
                }
                i = reader.read();
            }
        }
        java.lang.String stringBuffer3 = stringBuffer2.toString();
        this.n = stringBuffer3;
        if (this.x) {
            stringBuffer.append(stringBuffer3);
        }
        return stringBuffer.toString();
    }

    public void setDelims(java.lang.String str) {
        this.u = org.apache.tools.ant.util.StringUtils.resolveBackSlash(str).toCharArray();
    }

    public void setDelimsAreTokens(boolean z) {
        this.v = z;
    }

    public void setIncludeDelims(boolean z) {
        this.x = z;
    }

    public void setSuppressDelims(boolean z) {
        this.w = z;
    }
}
