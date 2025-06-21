package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class StripLineBreaks extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.lang.String v;

    public StripLineBreaks() {
        this.v = "\r\n";
    }

    public StripLineBreaks(java.io.Reader reader) {
        super(reader);
        this.v = "\r\n";
    }

    public final java.lang.String a() {
        return this.v;
    }

    public final void c() {
        java.lang.String str;
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("linebreaks".equals(parameter.getName())) {
                    str = parameter.getValue();
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            this.v = str;
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.StripLineBreaks stripLineBreaks = new org.apache.tools.ant.filters.StripLineBreaks(reader);
        stripLineBreaks.setLineBreaks(a());
        stripLineBreaks.setInitialized(true);
        return stripLineBreaks;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            c();
            setInitialized(true);
        }
        int read = ((java.io.FilterReader) this).in.read();
        while (read != -1 && this.v.indexOf(read) != -1) {
            read = ((java.io.FilterReader) this).in.read();
        }
        return read;
    }

    public void setLineBreaks(java.lang.String str) {
        this.v = str;
    }
}
