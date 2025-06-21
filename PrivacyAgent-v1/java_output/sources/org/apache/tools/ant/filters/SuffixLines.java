package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class SuffixLines extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.lang.String v;
    public java.lang.String w;

    public SuffixLines() {
        this.v = null;
        this.w = null;
    }

    public SuffixLines(java.io.Reader reader) {
        super(reader);
        this.v = null;
        this.w = null;
    }

    public final java.lang.String a() {
        return this.v;
    }

    public final void c() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("suffix".equals(parameter.getName())) {
                    this.v = parameter.getValue();
                    return;
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.SuffixLines suffixLines = new org.apache.tools.ant.filters.SuffixLines(reader);
        suffixLines.setSuffix(a());
        suffixLines.setInitialized(true);
        return suffixLines;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            c();
            setInitialized(true);
        }
        java.lang.String str = this.w;
        if (str != null && str.length() == 0) {
            this.w = null;
        }
        java.lang.String str2 = this.w;
        if (str2 != null) {
            char charAt = str2.charAt(0);
            java.lang.String substring = this.w.substring(1);
            this.w = substring;
            if (substring.length() != 0) {
                return charAt;
            }
            this.w = null;
            return charAt;
        }
        java.lang.String readLine = readLine();
        this.w = readLine;
        if (readLine == null) {
            return -1;
        }
        if (this.v != null) {
            java.lang.String str3 = "\r\n";
            if (!readLine.endsWith("\r\n")) {
                str3 = "\n";
                if (!this.w.endsWith("\n")) {
                    str3 = "";
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str4 = this.w;
            sb.append(str4.substring(0, str4.length() - str3.length()));
            sb.append(this.v);
            sb.append(str3);
            this.w = sb.toString();
        }
        return read();
    }

    public void setSuffix(java.lang.String str) {
        this.v = str;
    }
}
