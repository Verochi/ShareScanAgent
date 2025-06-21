package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Date implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public static final org.apache.tools.ant.util.FileUtils x = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.Long n = null;
    public java.lang.String t = null;
    public java.lang.String u = null;
    public org.apache.tools.ant.types.TimeComparison v = org.apache.tools.ant.types.TimeComparison.EQUAL;
    public long w = x.getFileTimestampGranularity();

    public synchronized java.lang.String getDatetime() {
        return this.t;
    }

    public synchronized long getGranularity() {
        return this.w;
    }

    public synchronized long getMillis() {
        java.lang.Long l;
        l = this.n;
        return l == null ? -1L : l.longValue();
    }

    public synchronized java.lang.String getPattern() {
        return this.u;
    }

    public synchronized org.apache.tools.ant.types.TimeComparison getWhen() {
        return this.v;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public synchronized boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        if (this.t == null && this.n == null) {
            throw new org.apache.tools.ant.BuildException("Either the millis or the datetime attribute must be set.");
        }
        if (this.n == null) {
            java.lang.String str = this.u;
            java.lang.String str2 = str == null ? "MM/dd/yyyy hh:mm a" : str;
            try {
                long time = (str == null ? new java.text.SimpleDateFormat(str2, java.util.Locale.US) : new java.text.SimpleDateFormat(str2)).parse(this.t).getTime();
                if (time < 0) {
                    throw new org.apache.tools.ant.BuildException("Date of " + this.t + " results in negative milliseconds value relative to epoch (January 1, 1970, 00:00:00 GMT).");
                }
                setMillis(time);
            } catch (java.text.ParseException unused) {
                throw new org.apache.tools.ant.BuildException("Date of " + this.t + " Cannot be parsed correctly. It should be in '" + str2 + "' format.");
            }
        }
        return this.v.evaluate(resource.getLastModified(), this.n.longValue(), this.w);
    }

    public synchronized void setDateTime(java.lang.String str) {
        this.t = str;
        this.n = null;
    }

    public synchronized void setGranularity(long j) {
        this.w = j;
    }

    public synchronized void setMillis(long j) {
        this.n = new java.lang.Long(j);
    }

    public synchronized void setPattern(java.lang.String str) {
        this.u = str;
    }

    public synchronized void setWhen(org.apache.tools.ant.types.TimeComparison timeComparison) {
        this.v = timeComparison;
    }
}
