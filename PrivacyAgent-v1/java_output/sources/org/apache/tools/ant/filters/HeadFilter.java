package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class HeadFilter extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public int A;
    public boolean B;
    public long v;
    public long w;
    public long x;
    public org.apache.tools.ant.util.LineTokenizer y;
    public java.lang.String z;

    public HeadFilter() {
        this.v = 0L;
        this.w = 10L;
        this.x = 0L;
        this.y = null;
        this.z = null;
        this.A = 0;
    }

    public HeadFilter(java.io.Reader reader) {
        super(reader);
        this.v = 0L;
        this.w = 10L;
        this.x = 0L;
        this.y = null;
        this.z = null;
        this.A = 0;
        org.apache.tools.ant.util.LineTokenizer lineTokenizer = new org.apache.tools.ant.util.LineTokenizer();
        this.y = lineTokenizer;
        lineTokenizer.setIncludeDelims(true);
    }

    public final long a() {
        return this.w;
    }

    public final long c() {
        return this.x;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.HeadFilter headFilter = new org.apache.tools.ant.filters.HeadFilter(reader);
        headFilter.setLines(a());
        headFilter.setSkip(c());
        headFilter.setInitialized(true);
        return headFilter;
    }

    public final java.lang.String d(java.lang.String str) {
        long j = this.v + 1;
        this.v = j;
        long j2 = this.x;
        if (j2 > 0 && j - 1 < j2) {
            return null;
        }
        long j3 = this.w;
        if (j3 <= 0 || j <= j3 + j2) {
            return str;
        }
        this.B = true;
        return null;
    }

    public final void e() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("lines".equals(parameter.getName())) {
                    this.w = java.lang.Long.parseLong(parameter.getValue());
                } else if (org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP.equals(parameter.getName())) {
                    this.x = java.lang.Long.parseLong(parameter.getValue());
                }
            }
        }
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            e();
            setInitialized(true);
        }
        while (true) {
            java.lang.String str = this.z;
            if (str != null && str.length() != 0) {
                char charAt = this.z.charAt(this.A);
                int i = this.A + 1;
                this.A = i;
                if (i == this.z.length()) {
                    this.z = null;
                }
                return charAt;
            }
            java.lang.String token = this.y.getToken(((java.io.FilterReader) this).in);
            this.z = token;
            if (token == null) {
                return -1;
            }
            this.z = d(token);
            if (this.B) {
                return -1;
            }
            this.A = 0;
        }
    }

    public void setLines(long j) {
        this.w = j;
    }

    public void setSkip(long j) {
        this.x = j;
    }
}
