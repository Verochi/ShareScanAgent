package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class ConcatFilter extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.io.File v;
    public java.io.File w;
    public java.io.Reader x;
    public java.io.Reader y;

    public ConcatFilter() {
        this.x = null;
        this.y = null;
    }

    public ConcatFilter(java.io.Reader reader) {
        super(reader);
        this.x = null;
        this.y = null;
    }

    public final void a() throws java.io.IOException {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("prepend".equals(parameter.getName())) {
                    setPrepend(new java.io.File(parameter.getValue()));
                } else if (com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_APPEND.equals(parameter.getName())) {
                    setAppend(new java.io.File(parameter.getValue()));
                }
            }
        }
        java.io.File file = this.v;
        if (file != null) {
            if (!file.isAbsolute()) {
                this.v = new java.io.File(getProject().getBaseDir(), this.v.getPath());
            }
            this.x = new java.io.BufferedReader(new java.io.FileReader(this.v));
        }
        java.io.File file2 = this.w;
        if (file2 != null) {
            if (!file2.isAbsolute()) {
                this.w = new java.io.File(getProject().getBaseDir(), this.w.getPath());
            }
            this.y = new java.io.BufferedReader(new java.io.FileReader(this.w));
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.ConcatFilter concatFilter = new org.apache.tools.ant.filters.ConcatFilter(reader);
        concatFilter.setPrepend(getPrepend());
        concatFilter.setAppend(getAppend());
        return concatFilter;
    }

    public java.io.File getAppend() {
        return this.w;
    }

    public java.io.File getPrepend() {
        return this.v;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        int i;
        java.io.Reader reader;
        if (!getInitialized()) {
            a();
            setInitialized(true);
        }
        java.io.Reader reader2 = this.x;
        if (reader2 != null) {
            i = reader2.read();
            if (i == -1) {
                this.x.close();
                this.x = null;
            }
        } else {
            i = -1;
        }
        if (i == -1) {
            i = super.read();
        }
        if (i == -1 && (reader = this.y) != null && (i = reader.read()) == -1) {
            this.y.close();
            this.y = null;
        }
        return i;
    }

    public void setAppend(java.io.File file) {
        this.w = file;
    }

    public void setPrepend(java.io.File file) {
        this.v = file;
    }
}
