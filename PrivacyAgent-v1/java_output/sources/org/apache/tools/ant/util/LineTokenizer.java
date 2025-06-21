package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LineTokenizer extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.util.Tokenizer {
    public java.lang.String n = "";
    public int t = -2;
    public boolean u = false;

    @Override // org.apache.tools.ant.util.Tokenizer
    public java.lang.String getPostToken() {
        return this.u ? "" : this.n;
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
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i == -1) {
                break;
            }
            if (!z2) {
                if (i == 13) {
                    z2 = true;
                } else {
                    if (i == 10) {
                        this.n = "\n";
                        break;
                    }
                    stringBuffer.append((char) i);
                }
                i = reader.read();
            } else if (i == 10) {
                this.n = "\r\n";
            } else {
                this.t = i;
                this.n = "\r";
            }
        }
        z = z2;
        if (i == -1 && z) {
            this.n = "\r";
        }
        if (this.u) {
            stringBuffer.append(this.n);
        }
        return stringBuffer.toString();
    }

    public void setIncludeDelims(boolean z) {
        this.u = z;
    }
}
