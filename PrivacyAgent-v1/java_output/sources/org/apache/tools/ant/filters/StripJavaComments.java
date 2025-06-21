package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class StripJavaComments extends org.apache.tools.ant.filters.BaseFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public int u;
    public boolean v;
    public boolean w;

    public StripJavaComments() {
        this.u = -1;
        this.v = false;
        this.w = false;
    }

    public StripJavaComments(java.io.Reader reader) {
        super(reader);
        this.u = -1;
        this.v = false;
        this.w = false;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        return new org.apache.tools.ant.filters.StripJavaComments(reader);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        int i = this.u;
        if (i != -1) {
            this.u = -1;
            return i;
        }
        int read = ((java.io.FilterReader) this).in.read();
        if (read == 34 && !this.w) {
            this.v = !this.v;
            this.w = false;
            return read;
        }
        if (read == 92) {
            this.w = !this.w;
            return read;
        }
        this.w = false;
        if (this.v || read != 47) {
            return read;
        }
        int read2 = ((java.io.FilterReader) this).in.read();
        if (read2 == 47) {
            while (read2 != 10 && read2 != -1 && read2 != 13) {
                read2 = ((java.io.FilterReader) this).in.read();
            }
            return read2;
        }
        if (read2 != 42) {
            this.u = read2;
            return 47;
        }
        while (read2 != -1) {
            read2 = ((java.io.FilterReader) this).in.read();
            if (read2 == 42) {
                read2 = ((java.io.FilterReader) this).in.read();
                while (read2 == 42) {
                    read2 = ((java.io.FilterReader) this).in.read();
                }
                if (read2 == 47) {
                    return read();
                }
            }
        }
        return read2;
    }
}
