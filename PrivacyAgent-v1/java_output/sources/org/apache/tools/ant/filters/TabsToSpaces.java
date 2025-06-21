package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class TabsToSpaces extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public int v;
    public int w;

    public TabsToSpaces() {
        this.v = 8;
        this.w = 0;
    }

    public TabsToSpaces(java.io.Reader reader) {
        super(reader);
        this.v = 8;
        this.w = 0;
    }

    public final void a() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if (parameter != null && "tablength".equals(parameter.getName())) {
                    this.v = java.lang.Integer.parseInt(parameter.getValue());
                    return;
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.TabsToSpaces tabsToSpaces = new org.apache.tools.ant.filters.TabsToSpaces(reader);
        tabsToSpaces.setTablength(getTablength());
        tabsToSpaces.setInitialized(true);
        return tabsToSpaces;
    }

    public final int getTablength() {
        return this.v;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (!getInitialized()) {
            a();
            setInitialized(true);
        }
        int i = this.w;
        if (i > 0) {
            this.w = i - 1;
            return 32;
        }
        int read = ((java.io.FilterReader) this).in.read();
        if (read != 9) {
            return read;
        }
        this.w = this.v - 1;
        return 32;
    }

    public void setTablength(int i) {
        this.v = i;
    }
}
