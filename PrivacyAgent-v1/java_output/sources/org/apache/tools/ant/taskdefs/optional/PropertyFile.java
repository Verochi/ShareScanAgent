package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class PropertyFile extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.util.Properties v;
    public java.io.File w;
    public boolean x;
    public java.util.Vector y = new java.util.Vector();

    public static class Entry {
        public java.lang.String a = null;
        public int b = 2;
        public int c = 2;
        public java.lang.String d = null;
        public java.lang.String e = null;
        public java.lang.String f = null;
        public java.lang.String g = null;
        public int h = 5;

        public static class Operation extends org.apache.tools.ant.types.EnumeratedAttribute {
            public static final int DECREMENT_OPER = 1;
            public static final int DELETE_OPER = 3;
            public static final int EQUALS_OPER = 2;
            public static final int INCREMENT_OPER = 0;

            public static int toOperation(java.lang.String str) {
                if ("+".equals(str)) {
                    return 0;
                }
                if (com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(str)) {
                    return 1;
                }
                return "del".equals(str) ? 3 : 2;
            }

            @Override // org.apache.tools.ant.types.EnumeratedAttribute
            public java.lang.String[] getValues() {
                return new java.lang.String[]{"+", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, "del"};
            }
        }

        public static class Type extends org.apache.tools.ant.types.EnumeratedAttribute {
            public static final int DATE_TYPE = 1;
            public static final int INTEGER_TYPE = 0;
            public static final int STRING_TYPE = 2;

            public static int toType(java.lang.String str) {
                if (com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL.equals(str)) {
                    return 0;
                }
                return "date".equals(str) ? 1 : 2;
            }

            @Override // org.apache.tools.ant.types.EnumeratedAttribute
            public java.lang.String[] getValues() {
                return new java.lang.String[]{com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, "date", com.anythink.expressad.foundation.h.i.g};
            }
        }

        public final void a() throws org.apache.tools.ant.BuildException {
            int i = this.b;
            if (i == 2 && this.c == 1) {
                throw new org.apache.tools.ant.BuildException("- is not supported for string properties (key:" + this.a + ")");
            }
            if (this.d == null && this.e == null && this.c != 3) {
                throw new org.apache.tools.ant.BuildException("\"value\" and/or \"default\" attribute must be specified (key:" + this.a + ")");
            }
            if (this.a == null) {
                throw new org.apache.tools.ant.BuildException("key is mandatory");
            }
            if (i != 2 || this.g == null) {
                return;
            }
            throw new org.apache.tools.ant.BuildException("pattern is not supported for string properties (key:" + this.a + ")");
        }

        public final void b(java.lang.String str) throws org.apache.tools.ant.BuildException {
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            if (this.g == null) {
                this.g = "yyyy/MM/dd HH:mm";
            }
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(this.g);
            java.lang.String e = e(str);
            if (e == null) {
                e = "now";
            }
            if ("now".equals(e)) {
                calendar.setTime(new java.util.Date());
            } else {
                try {
                    calendar.setTime(simpleDateFormat.parse(e));
                } catch (java.text.ParseException unused) {
                }
            }
            if (this.c != 2) {
                try {
                    int parseInt = java.lang.Integer.parseInt(this.d);
                    if (this.c == 1) {
                        parseInt *= -1;
                    }
                    calendar.add(this.h, parseInt);
                } catch (java.lang.NumberFormatException unused2) {
                    throw new org.apache.tools.ant.BuildException("Value not an integer on " + this.a);
                }
            }
            this.f = simpleDateFormat.format(calendar.getTime());
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c(java.lang.String str) throws org.apache.tools.ant.BuildException {
            int i;
            int intValue;
            int i2;
            java.lang.String e;
            java.text.DecimalFormat decimalFormat = this.g != null ? new java.text.DecimalFormat(this.g) : new java.text.DecimalFormat();
            int i3 = 0;
            try {
                e = e(str);
            } catch (java.lang.NumberFormatException | java.text.ParseException unused) {
            }
            if (e != null) {
                i = decimalFormat.parse(e).intValue();
                if (this.c != 2) {
                    i3 = i;
                } else {
                    java.lang.String str2 = this.d;
                    if (str2 != null) {
                        try {
                            intValue = decimalFormat.parse(str2).intValue();
                        } catch (java.lang.NumberFormatException | java.text.ParseException unused2) {
                        }
                        i2 = this.c;
                        if (i2 != 0) {
                            i3 = i + intValue;
                        } else if (i2 == 1) {
                            i3 = i - intValue;
                        }
                    }
                    intValue = 1;
                    i2 = this.c;
                    if (i2 != 0) {
                    }
                }
                this.f = decimalFormat.format(i3);
            }
            i = 0;
            if (this.c != 2) {
            }
            this.f = decimalFormat.format(i3);
        }

        public final void d(java.lang.String str) throws org.apache.tools.ant.BuildException {
            java.lang.String e = e(str);
            java.lang.String str2 = "";
            if (e == null) {
                e = "";
            }
            int i = this.c;
            if (i == 2) {
                str2 = e;
            } else if (i == 0) {
                str2 = e + this.d;
            }
            this.f = str2;
        }

        public final java.lang.String e(java.lang.String str) {
            java.lang.String str2;
            java.lang.String str3;
            if (this.c != 2) {
                if (str == null) {
                    str = this.e;
                }
                return str;
            }
            java.lang.String str4 = this.d;
            java.lang.String str5 = (str4 == null || this.e != null) ? null : str4;
            if (str4 == null && this.e != null && str != null) {
                str5 = str;
            }
            if (str4 == null && (str3 = this.e) != null && str == null) {
                str5 = str3;
            }
            if (str4 != null && this.e != null && str != null) {
                str5 = str4;
            }
            return (str4 == null || (str2 = this.e) == null || str != null) ? str5 : str2;
        }

        public void executeOn(java.util.Properties properties) throws org.apache.tools.ant.BuildException {
            a();
            if (this.c == 3) {
                properties.remove(this.a);
                return;
            }
            java.lang.String str = (java.lang.String) properties.get(this.a);
            try {
                int i = this.b;
                if (i == 0) {
                    c(str);
                } else if (i == 1) {
                    b(str);
                } else {
                    if (i != 2) {
                        throw new org.apache.tools.ant.BuildException("Unknown operation type: " + this.b);
                    }
                    d(str);
                }
            } catch (java.lang.NullPointerException e) {
                e.printStackTrace();
            }
            if (this.f == null) {
                this.f = "";
            }
            properties.put(this.a, this.f);
        }

        public void setDefault(java.lang.String str) {
            this.e = str;
        }

        public void setKey(java.lang.String str) {
            this.a = str;
        }

        public void setOperation(org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry.Operation operation) {
            this.c = org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry.Operation.toOperation(operation.getValue());
        }

        public void setPattern(java.lang.String str) {
            this.g = str;
        }

        public void setType(org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry.Type type) {
            this.b = org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry.Type.toType(type.getValue());
        }

        public void setUnit(org.apache.tools.ant.taskdefs.optional.PropertyFile.Unit unit) {
            this.h = unit.getCalendarField();
        }

        public void setValue(java.lang.String str) {
            this.d = str;
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
            return ((java.lang.Integer) this.b.get(getValue().toLowerCase())).intValue();
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return c;
        }
    }

    public final boolean c(java.io.File file) {
        return file != null;
    }

    public final void checkParameters() throws org.apache.tools.ant.BuildException {
        if (!c(this.w)) {
            throw new org.apache.tools.ant.BuildException("file token must not be null.", getLocation());
        }
    }

    public org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry createEntry() {
        org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry entry = new org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry();
        this.y.addElement(entry);
        return entry;
    }

    public final void d() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration elements = this.y.elements();
        while (elements.hasMoreElements()) {
            ((org.apache.tools.ant.taskdefs.optional.PropertyFile.Entry) elements.nextElement()).executeOn(this.v);
        }
    }

    public final void e() throws org.apache.tools.ant.BuildException {
        java.lang.Throwable th;
        java.io.FileOutputStream fileOutputStream;
        java.lang.Throwable th2;
        java.io.FileInputStream fileInputStream;
        if (this.x) {
            this.v = new java.util.Properties();
        } else {
            this.v = new org.apache.tools.ant.util.LayoutPreservingProperties();
        }
        try {
            if (this.w.exists()) {
                log("Updating property file: " + this.w.getAbsolutePath());
                try {
                    fileInputStream = new java.io.FileInputStream(this.w);
                    try {
                        this.v.load(new java.io.BufferedInputStream(fileInputStream));
                        fileInputStream.close();
                    } catch (java.lang.Throwable th3) {
                        th2 = th3;
                        if (fileInputStream == null) {
                            throw th2;
                        }
                        fileInputStream.close();
                        throw th2;
                    }
                } catch (java.lang.Throwable th4) {
                    th2 = th4;
                    fileInputStream = null;
                }
            } else {
                log("Creating new property file: " + this.w.getAbsolutePath());
                try {
                    fileOutputStream = new java.io.FileOutputStream(this.w.getAbsolutePath());
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e.toString());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        checkParameters();
        e();
        d();
        f();
    }

    public final void f() throws org.apache.tools.ant.BuildException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            this.v.store(byteArrayOutputStream, this.u);
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.w);
                try {
                    try {
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    } catch (java.io.IOException e) {
                        org.apache.tools.ant.util.FileUtils.getFileUtils().tryHardToDelete(this.w);
                        throw e;
                    }
                } finally {
                    fileOutputStream.close();
                }
            } catch (java.io.IOException e2) {
                throw new org.apache.tools.ant.BuildException(e2, getLocation());
            }
        } catch (java.io.IOException e3) {
            throw new org.apache.tools.ant.BuildException(e3, getLocation());
        }
    }

    public void setComment(java.lang.String str) {
        this.u = str;
    }

    public void setFile(java.io.File file) {
        this.w = file;
    }

    public void setJDKProperties(boolean z) {
        this.x = z;
    }
}
