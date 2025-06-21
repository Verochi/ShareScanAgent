package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Os implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final java.lang.String FAMILY_9X = "win9x";
    public static final java.lang.String FAMILY_DOS = "dos";
    public static final java.lang.String FAMILY_MAC = "mac";
    public static final java.lang.String FAMILY_NETWARE = "netware";
    public static final java.lang.String FAMILY_NT = "winnt";
    public static final java.lang.String FAMILY_OS2 = "os/2";
    public static final java.lang.String FAMILY_OS400 = "os/400";
    public static final java.lang.String FAMILY_TANDEM = "tandem";
    public static final java.lang.String FAMILY_UNIX = "unix";
    public static final java.lang.String FAMILY_VMS = "openvms";
    public static final java.lang.String FAMILY_WINDOWS = "windows";
    public static final java.lang.String FAMILY_ZOS = "z/os";
    public static final java.lang.String w;
    public static final java.lang.String x;
    public static final java.lang.String y;
    public static final java.lang.String z;
    public java.lang.String n;
    public java.lang.String t;
    public java.lang.String u;
    public java.lang.String v;

    static {
        java.lang.String property = java.lang.System.getProperty("os.name");
        java.util.Locale locale = java.util.Locale.ENGLISH;
        w = property.toLowerCase(locale);
        x = java.lang.System.getProperty("os.arch").toLowerCase(locale);
        y = java.lang.System.getProperty("os.version").toLowerCase(locale);
        z = java.lang.System.getProperty("path.separator");
    }

    public Os() {
    }

    public Os(java.lang.String str) {
        setFamily(str);
    }

    public static boolean isArch(java.lang.String str) {
        return isOs(null, null, str, null);
    }

    public static boolean isFamily(java.lang.String str) {
        return isOs(str, null, null, null);
    }

    public static boolean isName(java.lang.String str) {
        return isOs(null, str, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        if (r5 != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        if (r6 != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0098, code lost:
    
        if (isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b0, code lost:
    
        if (r2.contains("darwin") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
    
        if (r2.contains("darwin") != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0107, code lost:
    
        if (r2.contains("os/390") == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isOs(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (str == null && str2 == null && str3 == null && str4 == null) {
            return false;
        }
        if (str != null) {
            java.lang.String str5 = w;
            z2 = str5.contains(FAMILY_WINDOWS);
            if (z2) {
                z3 = str5.contains("95") || str5.contains("98") || str5.contains("me") || str5.contains("ce");
                z4 = !z3;
            } else {
                z3 = false;
                z4 = false;
            }
            if (!str.equals(FAMILY_WINDOWS)) {
                if (str.equals(FAMILY_9X)) {
                    if (z2) {
                    }
                    z2 = false;
                } else if (str.equals(FAMILY_NT)) {
                    if (z2) {
                    }
                    z2 = false;
                } else if (str.equals(FAMILY_OS2)) {
                    z2 = str5.contains(FAMILY_OS2);
                } else if (str.equals(FAMILY_NETWARE)) {
                    z2 = str5.contains(FAMILY_NETWARE);
                } else if (str.equals(FAMILY_DOS)) {
                    if (z.equals(com.alipay.sdk.m.u.i.b)) {
                    }
                    z2 = false;
                } else if (str.equals("mac")) {
                    if (!str5.contains("mac")) {
                    }
                } else if (str.equals(FAMILY_TANDEM)) {
                    z2 = str5.contains("nonstop_kernel");
                } else if (str.equals(FAMILY_UNIX)) {
                    if (z.equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                        if (!isFamily(FAMILY_VMS)) {
                            if (isFamily("mac")) {
                                if (!str5.endsWith("x")) {
                                }
                            }
                        }
                    }
                    z2 = false;
                } else if (str.equals(FAMILY_ZOS)) {
                    if (!str5.contains(FAMILY_ZOS)) {
                    }
                } else if (str.equals(FAMILY_OS400)) {
                    z2 = str5.contains(FAMILY_OS400);
                } else {
                    if (!str.equals(FAMILY_VMS)) {
                        throw new org.apache.tools.ant.BuildException("Don't know how to detect os family \"" + str + "\"");
                    }
                    z2 = str5.contains(FAMILY_VMS);
                }
            }
            boolean equals = str2 == null ? str2.equals(w) : true;
            boolean equals2 = str3 == null ? str3.equals(x) : true;
            boolean equals3 = str4 == null ? str4.equals(y) : true;
            return !z2 ? false : false;
        }
        z2 = true;
        if (str2 == null) {
        }
        if (str3 == null) {
        }
        if (str4 == null) {
        }
        return !z2 ? false : false;
    }

    public static boolean isVersion(java.lang.String str) {
        return isOs(null, null, null, str);
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        return isOs(this.n, this.t, this.v, this.u);
    }

    public void setArch(java.lang.String str) {
        this.v = str.toLowerCase(java.util.Locale.ENGLISH);
    }

    public void setFamily(java.lang.String str) {
        this.n = str.toLowerCase(java.util.Locale.ENGLISH);
    }

    public void setName(java.lang.String str) {
        this.t = str.toLowerCase(java.util.Locale.ENGLISH);
    }

    public void setVersion(java.lang.String str) {
        this.u = str.toLowerCase(java.util.Locale.ENGLISH);
    }
}
