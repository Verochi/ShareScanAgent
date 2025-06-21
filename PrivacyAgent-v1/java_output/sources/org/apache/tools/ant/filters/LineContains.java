package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class LineContains extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.util.Vector<java.lang.String> v;
    public java.lang.String w;
    public boolean x;

    public static class Contains {
        public java.lang.String a;

        public final java.lang.String getValue() {
            return this.a;
        }

        public final void setValue(java.lang.String str) {
            this.a = str;
        }
    }

    public LineContains() {
        this.v = new java.util.Vector<>();
        this.w = null;
        this.x = false;
    }

    public LineContains(java.io.Reader reader) {
        super(reader);
        this.v = new java.util.Vector<>();
        this.w = null;
        this.x = false;
    }

    public final java.util.Vector<java.lang.String> a() {
        return this.v;
    }

    public void addConfiguredContains(org.apache.tools.ant.filters.LineContains.Contains contains) {
        this.v.addElement(contains.getValue());
    }

    public final void c() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("contains".equals(parameter.getType())) {
                    this.v.addElement(parameter.getValue());
                } else if (org.apache.tools.ant.types.selectors.FilenameSelector.NEGATE_KEY.equals(parameter.getType())) {
                    setNegate(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.LineContains lineContains = new org.apache.tools.ant.filters.LineContains(reader);
        lineContains.d(a());
        lineContains.setNegate(isNegated());
        return lineContains;
    }

    public final void d(java.util.Vector<java.lang.String> vector) {
        this.v = vector;
    }

    public boolean isNegated() {
        return this.x;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        boolean z;
        if (!getInitialized()) {
            c();
            setInitialized(true);
        }
        java.lang.String str = this.w;
        if (str != null) {
            char charAt = str.charAt(0);
            if (this.w.length() == 1) {
                this.w = null;
                return charAt;
            }
            this.w = this.w.substring(1);
            return charAt;
        }
        int size = this.v.size();
        do {
            this.w = readLine();
            if (this.w == null) {
                break;
            }
            z = true;
            for (int i = 0; z && i < size; i++) {
                z = this.w.contains(this.v.elementAt(i));
            }
        } while (!(z ^ isNegated()));
        if (this.w != null) {
            return read();
        }
        return -1;
    }

    public void setNegate(boolean z) {
        this.x = z;
    }
}
