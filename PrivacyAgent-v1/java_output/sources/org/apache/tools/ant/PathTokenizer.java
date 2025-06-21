package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class PathTokenizer {
    public java.util.StringTokenizer a;
    public java.lang.String b = null;
    public boolean c;
    public boolean d;

    public PathTokenizer(java.lang.String str) {
        boolean isFamily = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_NETWARE);
        this.c = isFamily;
        if (isFamily) {
            this.a = new java.util.StringTokenizer(str, ":;", true);
        } else {
            this.a = new java.util.StringTokenizer(str, ":;", false);
        }
        this.d = java.io.File.pathSeparatorChar == ';';
    }

    public boolean hasMoreTokens() {
        if (this.b != null) {
            return true;
        }
        return this.a.hasMoreTokens();
    }

    public java.lang.String nextToken() throws java.util.NoSuchElementException {
        java.lang.String str = this.b;
        if (str != null) {
            this.b = null;
        } else {
            str = this.a.nextToken().trim();
        }
        if (!this.c) {
            if (str.length() != 1 || !java.lang.Character.isLetter(str.charAt(0)) || !this.d || !this.a.hasMoreTokens()) {
                return str;
            }
            java.lang.String trim = this.a.nextToken().trim();
            if (!trim.startsWith("\\") && !trim.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                this.b = trim;
                return str;
            }
            return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + trim;
        }
        java.lang.String str2 = java.io.File.pathSeparator;
        if (str.equals(str2) || str.equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            str = this.a.nextToken().trim();
        }
        if (!this.a.hasMoreTokens()) {
            return str;
        }
        java.lang.String trim2 = this.a.nextToken().trim();
        if (trim2.equals(str2)) {
            return str;
        }
        if (!trim2.equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            this.b = trim2;
            return str;
        }
        if (str.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || str.startsWith("\\") || str.startsWith(".") || str.startsWith("..")) {
            return str;
        }
        java.lang.String trim3 = this.a.nextToken().trim();
        if (!trim3.equals(str2)) {
            return str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + trim3;
        }
        java.lang.String str3 = str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        this.b = trim3;
        return str3;
    }
}
