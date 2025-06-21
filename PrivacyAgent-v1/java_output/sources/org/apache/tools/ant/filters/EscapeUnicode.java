package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public class EscapeUnicode extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.lang.StringBuffer v;

    public EscapeUnicode() {
        this.v = new java.lang.StringBuffer();
    }

    public EscapeUnicode(java.io.Reader reader) {
        super(reader);
        this.v = new java.lang.StringBuffer();
    }

    public final void a() {
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public final java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.EscapeUnicode escapeUnicode = new org.apache.tools.ant.filters.EscapeUnicode(reader);
        escapeUnicode.setInitialized(true);
        return escapeUnicode;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public final int read() throws java.io.IOException {
        char c;
        if (!getInitialized()) {
            a();
            setInitialized(true);
        }
        if (this.v.length() != 0) {
            char charAt = this.v.charAt(0);
            this.v.deleteCharAt(0);
            return charAt;
        }
        int read = ((java.io.FilterReader) this).in.read();
        if (read == -1 || (c = (char) read) < 128) {
            return read;
        }
        this.v = org.apache.tools.ant.util.UnicodeUtil.EscapeUnicode(c);
        return 92;
    }
}
