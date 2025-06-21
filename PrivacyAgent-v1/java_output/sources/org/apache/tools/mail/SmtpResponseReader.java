package org.apache.tools.mail;

/* loaded from: classes26.dex */
public class SmtpResponseReader {
    public java.lang.StringBuffer a = new java.lang.StringBuffer();
    protected java.io.BufferedReader reader;

    public SmtpResponseReader(java.io.InputStream inputStream) {
        this.reader = null;
        this.reader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
    }

    public final void a(java.lang.String str) {
        if (str.length() > 4) {
            this.a.append(str.substring(4));
            this.a.append(" ");
        }
    }

    public void close() throws java.io.IOException {
        this.reader.close();
    }

    public java.lang.String getResponse() throws java.io.IOException {
        this.a.setLength(0);
        java.lang.String readLine = this.reader.readLine();
        if (readLine != null && readLine.length() >= 3) {
            this.a.append(readLine.substring(0, 3));
            this.a.append(" ");
        }
        while (readLine != null) {
            a(readLine);
            if (!hasMoreLines(readLine)) {
                break;
            }
            readLine = this.reader.readLine();
        }
        return this.a.toString().trim();
    }

    public boolean hasMoreLines(java.lang.String str) {
        return str.length() > 3 && str.charAt(3) == '-';
    }
}
