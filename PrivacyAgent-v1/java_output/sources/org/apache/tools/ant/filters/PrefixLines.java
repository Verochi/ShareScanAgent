package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class PrefixLines extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.lang.String v;
    public java.lang.String w;

    public PrefixLines() {
        this.v = null;
        this.w = null;
    }

    public PrefixLines(java.io.Reader reader) {
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
                if (com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX.equals(parameter.getName())) {
                    this.v = parameter.getValue();
                    return;
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.PrefixLines prefixLines = new org.apache.tools.ant.filters.PrefixLines(reader);
        prefixLines.setPrefix(a());
        prefixLines.setInitialized(true);
        return prefixLines;
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
            this.w = this.v + this.w;
        }
        return read();
    }

    public void setPrefix(java.lang.String str) {
        this.v = str;
    }
}
