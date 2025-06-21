package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Tstamp extends org.apache.tools.ant.Task {
    public java.util.Vector u = new java.util.Vector();
    public java.lang.String v = "";

    public class CustomFormat {
        public java.util.TimeZone a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public int g = 0;
        public int h = 5;

        public CustomFormat() {
        }

        public void execute(org.apache.tools.ant.Project project, java.util.Date date, org.apache.tools.ant.Location location) {
            if (this.b == null) {
                throw new org.apache.tools.ant.BuildException("property attribute must be provided", location);
            }
            if (this.c == null) {
                throw new org.apache.tools.ant.BuildException("pattern attribute must be provided", location);
            }
            java.text.SimpleDateFormat simpleDateFormat = this.d == null ? new java.text.SimpleDateFormat(this.c) : this.f == null ? new java.text.SimpleDateFormat(this.c, new java.util.Locale(this.d, this.e)) : new java.text.SimpleDateFormat(this.c, new java.util.Locale(this.d, this.e, this.f));
            if (this.g != 0) {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(this.h, this.g);
                date = calendar.getTime();
            }
            java.util.TimeZone timeZone = this.a;
            if (timeZone != null) {
                simpleDateFormat.setTimeZone(timeZone);
            }
            org.apache.tools.ant.taskdefs.Tstamp.this.setProperty(this.b, simpleDateFormat.format(date));
        }

        public void setLocale(java.lang.String str) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, " \t\n\r\f,");
            try {
                this.d = stringTokenizer.nextToken();
                if (!stringTokenizer.hasMoreElements()) {
                    this.e = "";
                    return;
                }
                this.e = stringTokenizer.nextToken();
                if (stringTokenizer.hasMoreElements()) {
                    this.f = stringTokenizer.nextToken();
                    if (stringTokenizer.hasMoreElements()) {
                        throw new org.apache.tools.ant.BuildException("bad locale format", org.apache.tools.ant.taskdefs.Tstamp.this.getLocation());
                    }
                }
            } catch (java.util.NoSuchElementException e) {
                throw new org.apache.tools.ant.BuildException("bad locale format", e, org.apache.tools.ant.taskdefs.Tstamp.this.getLocation());
            }
        }

        public void setOffset(int i) {
            this.g = i;
        }

        public void setPattern(java.lang.String str) {
            this.c = str;
        }

        public void setProperty(java.lang.String str) {
            this.b = str;
        }

        public void setTimezone(java.lang.String str) {
            this.a = java.util.TimeZone.getTimeZone(str);
        }

        public void setUnit(java.lang.String str) {
            org.apache.tools.ant.taskdefs.Tstamp.this.log("DEPRECATED - The setUnit(String) method has been deprecated. Use setUnit(Tstamp.Unit) instead.");
            org.apache.tools.ant.taskdefs.Tstamp.Unit unit = new org.apache.tools.ant.taskdefs.Tstamp.Unit();
            unit.setValue(str);
            this.h = unit.getCalendarField();
        }

        public void setUnit(org.apache.tools.ant.taskdefs.Tstamp.Unit unit) {
            this.h = unit.getCalendarField();
        }
    }

    public static class Unit extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] c = {org.apache.tools.ant.taskdefs.WaitFor.Unit.MILLISECOND, org.apache.tools.ant.taskdefs.WaitFor.Unit.SECOND, org.apache.tools.ant.taskdefs.WaitFor.Unit.MINUTE, org.apache.tools.ant.taskdefs.WaitFor.Unit.HOUR, org.apache.tools.ant.taskdefs.WaitFor.Unit.DAY, org.apache.tools.ant.taskdefs.WaitFor.Unit.WEEK, "month", "year"};
        public java.util.Map b;

        public Unit() {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.b = hashMap;
            hashMap.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.MILLISECOND, new java.lang.Integer(14));
            this.b.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.SECOND, new java.lang.Integer(13));
            this.b.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.MINUTE, new java.lang.Integer(12));
            this.b.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.HOUR, new java.lang.Integer(11));
            this.b.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.DAY, new java.lang.Integer(5));
            this.b.put(org.apache.tools.ant.taskdefs.WaitFor.Unit.WEEK, new java.lang.Integer(3));
            this.b.put("month", new java.lang.Integer(2));
            this.b.put("year", new java.lang.Integer(1));
        }

        public int getCalendarField() {
            return ((java.lang.Integer) this.b.get(getValue().toLowerCase(java.util.Locale.ENGLISH))).intValue();
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return c;
        }
    }

    public org.apache.tools.ant.taskdefs.Tstamp.CustomFormat createFormat() {
        org.apache.tools.ant.taskdefs.Tstamp.CustomFormat customFormat = new org.apache.tools.ant.taskdefs.Tstamp.CustomFormat();
        this.u.addElement(customFormat);
        return customFormat;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        try {
            java.util.Date now = getNow();
            java.util.Enumeration elements = this.u.elements();
            while (elements.hasMoreElements()) {
                ((org.apache.tools.ant.taskdefs.Tstamp.CustomFormat) elements.nextElement()).execute(getProject(), now, getLocation());
            }
            setProperty("DSTAMP", new java.text.SimpleDateFormat("yyyyMMdd").format(now));
            setProperty("TSTAMP", new java.text.SimpleDateFormat("HHmm").format(now));
            setProperty("TODAY", new java.text.SimpleDateFormat("MMMM d yyyy", java.util.Locale.US).format(now));
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public java.util.Date getNow() {
        java.lang.String property = getProject().getProperty(org.apache.tools.ant.MagicNames.TSTAMP_NOW);
        if (property != null && property.length() > 0) {
            try {
                return new java.util.Date(java.lang.Long.parseLong(property) * 1000);
            } catch (java.lang.NumberFormatException unused) {
                log("magic property ant.tstamp.now ignored as " + property + " is not a valid number");
            }
        }
        return new java.util.Date();
    }

    public void setPrefix(java.lang.String str) {
        this.v = str;
        if (str.endsWith(".")) {
            return;
        }
        this.v += ".";
    }

    public final void setProperty(java.lang.String str, java.lang.String str2) {
        getProject().setNewProperty(this.v + str, str2);
    }
}
