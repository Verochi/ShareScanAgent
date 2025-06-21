package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
public class Message extends org.apache.tools.ant.ProjectComponent {
    public java.io.File n;
    public java.lang.StringBuffer t;
    public java.lang.String u;
    public boolean v;
    public java.lang.String w;
    public java.lang.String x;

    public Message() {
        this.n = null;
        this.t = new java.lang.StringBuffer();
        this.u = com.baidu.mobads.sdk.internal.am.e;
        this.v = false;
        this.w = null;
    }

    public Message(java.io.File file) {
        this.n = null;
        this.t = new java.lang.StringBuffer();
        this.u = com.baidu.mobads.sdk.internal.am.e;
        this.v = false;
        this.w = null;
        this.n = file;
    }

    public Message(java.lang.String str) {
        this.n = null;
        this.t = new java.lang.StringBuffer();
        this.u = com.baidu.mobads.sdk.internal.am.e;
        this.v = false;
        this.w = null;
        addText(str);
    }

    public final java.io.Reader a(java.io.File file) throws java.io.IOException {
        if (this.x == null) {
            return new java.io.FileReader(file);
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            return new java.io.InputStreamReader(fileInputStream, this.x);
        } catch (java.io.IOException e) {
            fileInputStream.close();
            throw e;
        }
    }

    public void addText(java.lang.String str) {
        this.t.append(str);
    }

    public java.lang.String getCharset() {
        return this.w;
    }

    public java.lang.String getMimeType() {
        return this.u;
    }

    public boolean isMimeTypeSpecified() {
        return this.v;
    }

    public void print(java.io.PrintStream printStream) throws java.io.IOException {
        java.io.BufferedWriter bufferedWriter = this.w != null ? new java.io.BufferedWriter(new java.io.OutputStreamWriter(printStream, this.w)) : new java.io.BufferedWriter(new java.io.OutputStreamWriter(printStream));
        java.io.File file = this.n;
        if (file != null) {
            java.io.Reader a = a(file);
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(a);
                while (true) {
                    java.lang.String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    bufferedWriter.write(getProject().replaceProperties(readLine));
                    bufferedWriter.newLine();
                }
            } finally {
                a.close();
            }
        } else {
            bufferedWriter.write(getProject().replaceProperties(this.t.substring(0)));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    public void setCharset(java.lang.String str) {
        this.w = str;
    }

    public void setInputEncoding(java.lang.String str) {
        this.x = str;
    }

    public void setMimeType(java.lang.String str) {
        this.u = str;
        this.v = true;
    }

    public void setSrc(java.io.File file) {
        this.n = file;
    }
}
