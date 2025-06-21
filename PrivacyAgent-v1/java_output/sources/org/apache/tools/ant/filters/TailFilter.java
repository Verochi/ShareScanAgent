package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class TailFilter extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public int A;
    public java.util.LinkedList<java.lang.String> B;
    public long v;
    public long w;
    public boolean x;
    public org.apache.tools.ant.util.LineTokenizer y;
    public java.lang.String z;

    public TailFilter() {
        this.v = 10L;
        this.w = 0L;
        this.x = false;
        this.y = null;
        this.z = null;
        this.A = 0;
        this.B = new java.util.LinkedList<>();
    }

    public TailFilter(java.io.Reader reader) {
        super(reader);
        this.v = 10L;
        this.w = 0L;
        this.x = false;
        this.y = null;
        this.z = null;
        this.A = 0;
        this.B = new java.util.LinkedList<>();
        org.apache.tools.ant.util.LineTokenizer lineTokenizer = new org.apache.tools.ant.util.LineTokenizer();
        this.y = lineTokenizer;
        lineTokenizer.setIncludeDelims(true);
    }

    public final long a() {
        return this.v;
    }

    public final long c() {
        return this.w;
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.TailFilter tailFilter = new org.apache.tools.ant.filters.TailFilter(reader);
        tailFilter.setLines(a());
        tailFilter.setSkip(c());
        tailFilter.setInitialized(true);
        return tailFilter;
    }

    public final void e() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("lines".equals(parameter.getName())) {
                    setLines(java.lang.Long.parseLong(parameter.getValue()));
                } else if (org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP.equals(parameter.getName())) {
                    this.w = java.lang.Long.parseLong(parameter.getValue());
                }
            }
        }
    }

    public final java.lang.String f(java.lang.String str) {
        if (!this.x) {
            if (str != null) {
                this.B.add(str);
                long j = this.v;
                if (j == -1) {
                    return ((long) this.B.size()) > this.w ? this.B.removeFirst() : "";
                }
                long j2 = this.w;
                if (j + (j2 > 0 ? j2 : 0L) >= this.B.size()) {
                    return "";
                }
                this.B.removeFirst();
                return "";
            }
            this.x = true;
            if (this.w > 0) {
                for (int i = 0; i < this.w; i++) {
                    this.B.removeLast();
                }
            }
            if (this.v > -1) {
                while (this.B.size() > this.v) {
                    this.B.removeFirst();
                }
            }
        }
        if (this.B.size() > 0) {
            return this.B.removeFirst();
        }
        return null;
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
            java.lang.String f = f(token);
            this.z = f;
            if (f == null) {
                return -1;
            }
            this.A = 0;
        }
    }

    public void setLines(long j) {
        this.v = j;
    }

    public void setSkip(long j) {
        this.w = j;
    }
}
