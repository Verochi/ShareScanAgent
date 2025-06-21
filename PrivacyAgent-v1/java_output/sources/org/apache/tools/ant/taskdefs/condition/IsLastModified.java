package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsLastModified extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.Resource v;
    public long n = -1;
    public java.lang.String t = null;
    public org.apache.tools.ant.taskdefs.Touch.DateFormatFactory u = org.apache.tools.ant.taskdefs.Touch.DEFAULT_DF_FACTORY;
    public org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode w = org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode.b;

    /* renamed from: org.apache.tools.ant.taskdefs.condition.IsLastModified$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.taskdefs.Touch.DateFormatFactory {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getFallbackFormat() {
            return null;
        }

        @Override // org.apache.tools.ant.taskdefs.Touch.DateFormatFactory
        public java.text.DateFormat getPrimaryFormat() {
            return new java.text.SimpleDateFormat(this.a);
        }
    }

    public static class CompareMode extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode b = new org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode("equals");

        public CompareMode() {
            this("equals");
        }

        public CompareMode(java.lang.String str) {
            setValue(str);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"equals", "before", "after", "not-before", "not-after"};
        }
    }

    public void add(org.apache.tools.ant.types.Resource resource) {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("only one resource can be tested");
        }
        this.v = resource;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        validate();
        long millis = getMillis();
        long lastModified = this.v.getLastModified();
        log("expected timestamp: " + millis + " (" + new java.util.Date(millis) + "), actual timestamp: " + lastModified + " (" + new java.util.Date(lastModified) + ")", 3);
        if ("equals".equals(this.w.getValue())) {
            return millis == lastModified;
        }
        if ("before".equals(this.w.getValue())) {
            return millis > lastModified;
        }
        if ("not-before".equals(this.w.getValue())) {
            return millis <= lastModified;
        }
        if ("after".equals(this.w.getValue())) {
            return millis < lastModified;
        }
        if ("not-after".equals(this.w.getValue())) {
            return millis >= lastModified;
        }
        throw new org.apache.tools.ant.BuildException("Unknown mode " + this.w.getValue());
    }

    public long getMillis() throws org.apache.tools.ant.BuildException {
        long j = this.n;
        if (j >= 0) {
            return j;
        }
        if ("now".equalsIgnoreCase(this.t)) {
            return java.lang.System.currentTimeMillis();
        }
        try {
            return this.u.getPrimaryFormat().parse(this.t).getTime();
        } catch (java.text.ParseException e) {
            e = e;
            java.text.DateFormat fallbackFormat = this.u.getFallbackFormat();
            if (fallbackFormat != null) {
                try {
                    return fallbackFormat.parse(this.t).getTime();
                } catch (java.text.ParseException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException(e.getMessage(), e, getLocation());
                }
            }
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e, getLocation());
        }
    }

    public void setDatetime(java.lang.String str) {
        this.t = str;
    }

    public void setMillis(long j) {
        this.n = j;
    }

    public void setMode(org.apache.tools.ant.taskdefs.condition.IsLastModified.CompareMode compareMode) {
        this.w = compareMode;
    }

    public void setPattern(java.lang.String str) {
        this.u = new org.apache.tools.ant.taskdefs.condition.IsLastModified.AnonymousClass1(str);
    }

    public void validate() throws org.apache.tools.ant.BuildException {
        long j = this.n;
        if (j >= 0 && this.t != null) {
            throw new org.apache.tools.ant.BuildException("Only one of dateTime and millis can be set");
        }
        if (j < 0 && this.t == null) {
            throw new org.apache.tools.ant.BuildException("millis or dateTime is required");
        }
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("resource is required");
        }
    }
}
