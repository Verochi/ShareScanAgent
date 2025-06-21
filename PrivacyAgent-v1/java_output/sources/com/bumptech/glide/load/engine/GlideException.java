package com.bumptech.glide.load.engine;

/* loaded from: classes.dex */
public final class GlideException extends java.lang.Exception {
    private static final java.lang.StackTraceElement[] EMPTY_ELEMENTS = new java.lang.StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final java.util.List<java.lang.Throwable> causes;
    private java.lang.Class<?> dataClass;
    private com.bumptech.glide.load.DataSource dataSource;
    private java.lang.String detailMessage;

    @androidx.annotation.Nullable
    private java.lang.Exception exception;
    private com.bumptech.glide.load.Key key;

    public static final class IndentedAppendable implements java.lang.Appendable {
        private static final java.lang.String EMPTY_SEQUENCE = "";
        private static final java.lang.String INDENT = "  ";
        private final java.lang.Appendable appendable;
        private boolean printedNewLine = true;

        public IndentedAppendable(java.lang.Appendable appendable) {
            this.appendable = appendable;
        }

        @androidx.annotation.NonNull
        private java.lang.CharSequence safeSequence(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char c) throws java.io.IOException {
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(INDENT);
            }
            this.printedNewLine = c == '\n';
            this.appendable.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@androidx.annotation.Nullable java.lang.CharSequence charSequence) throws java.io.IOException {
            java.lang.CharSequence safeSequence = safeSequence(charSequence);
            return append(safeSequence, 0, safeSequence.length());
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@androidx.annotation.Nullable java.lang.CharSequence charSequence, int i, int i2) throws java.io.IOException {
            java.lang.CharSequence safeSequence = safeSequence(charSequence);
            boolean z = false;
            if (this.printedNewLine) {
                this.printedNewLine = false;
                this.appendable.append(INDENT);
            }
            if (safeSequence.length() > 0 && safeSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.printedNewLine = z;
            this.appendable.append(safeSequence, i, i2);
            return this;
        }
    }

    public GlideException(java.lang.String str) {
        this(str, (java.util.List<java.lang.Throwable>) java.util.Collections.emptyList());
    }

    public GlideException(java.lang.String str, java.lang.Throwable th) {
        this(str, (java.util.List<java.lang.Throwable>) java.util.Collections.singletonList(th));
    }

    public GlideException(java.lang.String str, java.util.List<java.lang.Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    private void addRootCauses(java.lang.Throwable th, java.util.List<java.lang.Throwable> list) {
        if (!(th instanceof com.bumptech.glide.load.engine.GlideException)) {
            list.add(th);
            return;
        }
        java.util.Iterator<java.lang.Throwable> it = ((com.bumptech.glide.load.engine.GlideException) th).getCauses().iterator();
        while (it.hasNext()) {
            addRootCauses(it.next(), list);
        }
    }

    private static void appendCauses(java.util.List<java.lang.Throwable> list, java.lang.Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(java.util.List<java.lang.Throwable> list, java.lang.Appendable appendable) throws java.io.IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(java.lang.String.valueOf(i2)).append(" of ").append(java.lang.String.valueOf(size)).append("): ");
            java.lang.Throwable th = list.get(i);
            if (th instanceof com.bumptech.glide.load.engine.GlideException) {
                ((com.bumptech.glide.load.engine.GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }

    private static void appendExceptionMessage(java.lang.Throwable th, java.lang.Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (java.io.IOException unused) {
            throw new java.lang.RuntimeException(th);
        }
    }

    private void printStackTrace(java.lang.Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new com.bumptech.glide.load.engine.GlideException.IndentedAppendable(appendable));
    }

    @Override // java.lang.Throwable
    public java.lang.Throwable fillInStackTrace() {
        return this;
    }

    public java.util.List<java.lang.Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(71);
        sb.append(this.detailMessage);
        sb.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb.append(this.key != null ? ", " + this.key : "");
        java.util.List<java.lang.Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (java.lang.Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @androidx.annotation.Nullable
    public java.lang.Exception getOrigin() {
        return this.exception;
    }

    public java.util.List<java.lang.Throwable> getRootCauses() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(java.lang.String str) {
        java.util.List<java.lang.Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            rootCauses.get(i);
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(java.lang.System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintStream printStream) {
        printStackTrace((java.lang.Appendable) printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintWriter printWriter) {
        printStackTrace((java.lang.Appendable) printWriter);
    }

    public void setLoggingDetails(com.bumptech.glide.load.Key key, com.bumptech.glide.load.DataSource dataSource) {
        setLoggingDetails(key, dataSource, null);
    }

    public void setLoggingDetails(com.bumptech.glide.load.Key key, com.bumptech.glide.load.DataSource dataSource, java.lang.Class<?> cls) {
        this.key = key;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public void setOrigin(@androidx.annotation.Nullable java.lang.Exception exc) {
        this.exception = exc;
    }
}
