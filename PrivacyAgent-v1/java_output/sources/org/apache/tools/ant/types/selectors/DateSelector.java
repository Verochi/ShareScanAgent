package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class DateSelector extends org.apache.tools.ant.types.selectors.BaseExtendSelector {
    public static final org.apache.tools.ant.util.FileUtils A = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final java.lang.String CHECKDIRS_KEY = "checkdirs";
    public static final java.lang.String DATETIME_KEY = "datetime";
    public static final java.lang.String GRANULARITY_KEY = "granularity";
    public static final java.lang.String MILLIS_KEY = "millis";
    public static final java.lang.String PATTERN_KEY = "pattern";
    public static final java.lang.String WHEN_KEY = "when";
    public long u = -1;
    public java.lang.String v = null;
    public boolean w = false;
    public long x;
    public java.lang.String y;
    public org.apache.tools.ant.types.TimeComparison z;

    public static class TimeComparisons extends org.apache.tools.ant.types.TimeComparison {
    }

    public DateSelector() {
        org.apache.tools.ant.util.FileUtils fileUtils = A;
        this.x = fileUtils.getFileTimestampGranularity();
        this.z = org.apache.tools.ant.types.TimeComparison.EQUAL;
        this.x = fileUtils.getFileTimestampGranularity();
    }

    public long getMillis() {
        if (this.v != null) {
            validate();
        }
        return this.u;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        validate();
        return (file2.isDirectory() && !this.w) || this.z.evaluate(file2.lastModified(), this.u, this.x);
    }

    public void setCheckdirs(boolean z) {
        this.w = z;
    }

    public void setDatetime(java.lang.String str) {
        this.v = str;
        this.u = -1L;
    }

    public void setGranularity(int i) {
        this.x = i;
    }

    public void setMillis(long j) {
        this.u = j;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseExtendSelector, org.apache.tools.ant.types.Parameterizable
    public void setParameters(org.apache.tools.ant.types.Parameter[] parameterArr) {
        super.setParameters(parameterArr);
        if (parameterArr != null) {
            for (org.apache.tools.ant.types.Parameter parameter : parameterArr) {
                java.lang.String name = parameter.getName();
                if (MILLIS_KEY.equalsIgnoreCase(name)) {
                    try {
                        setMillis(java.lang.Long.parseLong(parameter.getValue()));
                    } catch (java.lang.NumberFormatException unused) {
                        setError("Invalid millisecond setting " + parameter.getValue());
                    }
                } else if (DATETIME_KEY.equalsIgnoreCase(name)) {
                    setDatetime(parameter.getValue());
                } else if (CHECKDIRS_KEY.equalsIgnoreCase(name)) {
                    setCheckdirs(org.apache.tools.ant.Project.toBoolean(parameter.getValue()));
                } else if (GRANULARITY_KEY.equalsIgnoreCase(name)) {
                    try {
                        setGranularity(java.lang.Integer.parseInt(parameter.getValue()));
                    } catch (java.lang.NumberFormatException unused2) {
                        setError("Invalid granularity setting " + parameter.getValue());
                    }
                } else if ("when".equalsIgnoreCase(name)) {
                    setWhen(new org.apache.tools.ant.types.TimeComparison(parameter.getValue()));
                } else if (PATTERN_KEY.equalsIgnoreCase(name)) {
                    setPattern(parameter.getValue());
                } else {
                    setError("Invalid parameter " + name);
                }
            }
        }
    }

    public void setPattern(java.lang.String str) {
        this.y = str;
    }

    public void setWhen(org.apache.tools.ant.types.TimeComparison timeComparison) {
        this.z = timeComparison;
    }

    public void setWhen(org.apache.tools.ant.types.selectors.DateSelector.TimeComparisons timeComparisons) {
        setWhen((org.apache.tools.ant.types.TimeComparison) timeComparisons);
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{dateselector date: ");
        sb.append(this.v);
        sb.append(" compare: ");
        sb.append(this.z.getValue());
        sb.append(" granularity: ");
        sb.append(this.x);
        if (this.y != null) {
            sb.append(" pattern: ");
            sb.append(this.y);
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        java.lang.String str = this.v;
        if (str == null && this.u < 0) {
            setError("You must provide a datetime or the number of milliseconds.");
            return;
        }
        if (this.u >= 0 || str == null) {
            return;
        }
        java.lang.String str2 = this.y;
        java.lang.String str3 = str2 == null ? "MM/dd/yyyy hh:mm a" : str2;
        try {
            setMillis((str2 == null ? new java.text.SimpleDateFormat(str3, java.util.Locale.US) : new java.text.SimpleDateFormat(str3)).parse(this.v).getTime());
            if (this.u < 0) {
                setError("Date of " + this.v + " results in negative milliseconds value relative to epoch (January 1, 1970, 00:00:00 GMT).");
            }
        } catch (java.text.ParseException e) {
            setError("Date of " + this.v + " Cannot be parsed correctly. It should be in '" + str3 + "' format.", e);
        }
    }
}
