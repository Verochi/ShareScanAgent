package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class LineContainsRegExp extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.util.Vector<org.apache.tools.ant.types.RegularExpression> v;
    public java.lang.String w;
    public boolean x;
    public int y;

    public LineContainsRegExp() {
        this.v = new java.util.Vector<>();
        this.w = null;
        this.x = false;
        this.y = 0;
    }

    public LineContainsRegExp(java.io.Reader reader) {
        super(reader);
        this.v = new java.util.Vector<>();
        this.w = null;
        this.x = false;
        this.y = 0;
    }

    public final java.util.Vector<org.apache.tools.ant.types.RegularExpression> a() {
        return this.v;
    }

    public void addConfiguredRegexp(org.apache.tools.ant.types.RegularExpression regularExpression) {
        this.v.addElement(regularExpression);
    }

    public final void c() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if (org.apache.tools.ant.types.RegularExpression.DATA_TYPE_NAME.equals(parameter.getType())) {
                    setRegexp(parameter.getValue());
                } else if (org.apache.tools.ant.types.selectors.FilenameSelector.NEGATE_KEY.equals(parameter.getType())) {
                    setNegate(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if ("casesensitive".equals(parameter.getType())) {
                    setCaseSensitive(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.LineContainsRegExp lineContainsRegExp = new org.apache.tools.ant.filters.LineContainsRegExp(reader);
        lineContainsRegExp.d(a());
        lineContainsRegExp.setNegate(isNegated());
        lineContainsRegExp.setCaseSensitive(!org.apache.tools.ant.util.regexp.RegexpUtil.hasFlag(this.y, 256));
        return lineContainsRegExp;
    }

    public final void d(java.util.Vector<org.apache.tools.ant.types.RegularExpression> vector) {
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
                z = this.v.elementAt(i).getRegexp(getProject()).matches(this.w, this.y);
            }
        } while (!(z ^ isNegated()));
        if (this.w != null) {
            return read();
        }
        return -1;
    }

    public void setCaseSensitive(boolean z) {
        this.y = org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(z);
    }

    public void setNegate(boolean z) {
        this.x = z;
    }

    public void setRegexp(java.lang.String str) {
        org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
        regularExpression.setPattern(str);
        this.v.addElement(regularExpression);
    }
}
