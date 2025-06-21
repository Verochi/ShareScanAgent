package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public final class StripLineComments extends org.apache.tools.ant.filters.BaseParamFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.util.Vector<java.lang.String> v;
    public java.lang.String w;

    public static class Comment {
        public java.lang.String a;

        public void addText(java.lang.String str) {
            setValue(str);
        }

        public final java.lang.String getValue() {
            return this.a;
        }

        public final void setValue(java.lang.String str) {
            if (this.a != null) {
                throw new java.lang.IllegalStateException("Comment value already set.");
            }
            this.a = str;
        }
    }

    public StripLineComments() {
        this.v = new java.util.Vector<>();
        this.w = null;
    }

    public StripLineComments(java.io.Reader reader) {
        super(reader);
        this.v = new java.util.Vector<>();
        this.w = null;
    }

    public final java.util.Vector<java.lang.String> a() {
        return this.v;
    }

    public void addConfiguredComment(org.apache.tools.ant.filters.StripLineComments.Comment comment) {
        this.v.addElement(comment.getValue());
    }

    public final void c() {
        org.apache.tools.ant.types.Parameter[] parameters = getParameters();
        if (parameters != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameters) {
                if ("comment".equals(parameter.getType())) {
                    this.v.addElement(parameter.getValue());
                }
            }
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.StripLineComments stripLineComments = new org.apache.tools.ant.filters.StripLineComments(reader);
        stripLineComments.d(a());
        stripLineComments.setInitialized(true);
        return stripLineComments;
    }

    public final void d(java.util.Vector<java.lang.String> vector) {
        this.v = vector;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
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
        this.w = readLine();
        int size = this.v.size();
        while (this.w != null) {
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (this.w.startsWith(this.v.elementAt(i))) {
                    this.w = null;
                    break;
                }
                i++;
            }
            if (this.w != null) {
                break;
            }
            this.w = readLine();
        }
        if (this.w != null) {
            return read();
        }
        return -1;
    }
}
