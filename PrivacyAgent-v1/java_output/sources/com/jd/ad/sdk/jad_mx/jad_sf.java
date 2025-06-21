package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public final class jad_sf extends java.lang.Exception {
    public static final java.lang.StackTraceElement[] jad_fs = new java.lang.StackTraceElement[0];
    public final java.util.List<java.lang.Throwable> jad_an;
    public com.jd.ad.sdk.jad_ju.jad_hu jad_bo;
    public com.jd.ad.sdk.jad_ju.jad_an jad_cp;
    public java.lang.Class<?> jad_dq;
    public java.lang.String jad_er;

    public static final class jad_an implements java.lang.Appendable {
        public final java.lang.Appendable jad_an;
        public boolean jad_bo = true;

        public jad_an(java.lang.Appendable appendable) {
            this.jad_an = appendable;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char c) {
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            this.jad_bo = c == '\n';
            this.jad_an.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            return append(charSequence, 0, charSequence.length());
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(@androidx.annotation.Nullable java.lang.CharSequence charSequence, int i, int i2) {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.jad_bo) {
                this.jad_bo = false;
                this.jad_an.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.jad_bo = z;
            this.jad_an.append(charSequence, i, i2);
            return this;
        }
    }

    public jad_sf(java.lang.String str, java.util.List<java.lang.Throwable> list) {
        this.jad_er = str;
        setStackTrace(jad_fs);
        this.jad_an = list;
    }

    public static void jad_an(java.lang.Throwable th, java.lang.Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (java.io.IOException unused) {
            throw new java.lang.RuntimeException(th);
        }
    }

    public static void jad_an(java.util.List<java.lang.Throwable> list, java.lang.Appendable appendable) {
        try {
            jad_bo(list, appendable);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public static void jad_bo(java.util.List<java.lang.Throwable> list, java.lang.Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(java.lang.String.valueOf(i2)).append(" of ").append(java.lang.String.valueOf(size)).append("): ");
            java.lang.Throwable th = list.get(i);
            if (th instanceof com.jd.ad.sdk.jad_mx.jad_sf) {
                ((com.jd.ad.sdk.jad_mx.jad_sf) th).jad_an(appendable);
            } else {
                jad_an(th, appendable);
            }
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public java.lang.Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(71);
        sb.append(this.jad_er);
        java.lang.String str4 = "";
        if (this.jad_dq != null) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ");
            jad_an2.append(this.jad_dq);
            str = jad_an2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.jad_cp != null) {
            java.lang.StringBuilder jad_an3 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ");
            jad_an3.append(this.jad_cp);
            str2 = jad_an3.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.jad_bo != null) {
            java.lang.StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an(", ");
            jad_an4.append(this.jad_bo);
            str4 = jad_an4.toString();
        }
        sb.append(str4);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jad_an(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            str3 = " root causes:";
        }
        sb.append(str3);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            java.lang.Throwable th = (java.lang.Throwable) it.next();
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public final void jad_an(java.lang.Appendable appendable) {
        jad_an(this, appendable);
        jad_an(this.jad_an, new com.jd.ad.sdk.jad_mx.jad_sf.jad_an(appendable));
    }

    public void jad_an(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        jad_an(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Root cause (");
            int i2 = i + 1;
            jad_an2.append(i2);
            jad_an2.append(" of ");
            jad_an2.append(size);
            jad_an2.append(")");
            com.jd.ad.sdk.logger.Logger.i(str, jad_an2.toString(), arrayList.get(i));
            i = i2;
        }
    }

    public final void jad_an(java.lang.Throwable th, java.util.List<java.lang.Throwable> list) {
        if (!(th instanceof com.jd.ad.sdk.jad_mx.jad_sf)) {
            list.add(th);
            return;
        }
        java.util.Iterator<java.lang.Throwable> it = ((com.jd.ad.sdk.jad_mx.jad_sf) th).jad_an.iterator();
        while (it.hasNext()) {
            jad_an(it.next(), list);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        jad_an(java.lang.System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintStream printStream) {
        jad_an(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintWriter printWriter) {
        jad_an(printWriter);
    }
}
