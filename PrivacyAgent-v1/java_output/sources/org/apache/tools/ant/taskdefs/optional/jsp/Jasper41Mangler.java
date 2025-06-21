package org.apache.tools.ant.taskdefs.optional.jsp;

/* loaded from: classes25.dex */
public class Jasper41Mangler implements org.apache.tools.ant.taskdefs.optional.jsp.JspMangler {
    public static java.lang.String a(char c) {
        java.lang.String hexString = java.lang.Integer.toHexString(c);
        int length = 5 - hexString.length();
        char[] cArr = new char[6];
        int i = 0;
        cArr[0] = '_';
        for (int i2 = 1; i2 <= length; i2++) {
            cArr[i2] = '0';
        }
        int i3 = length + 1;
        while (i3 < 6) {
            cArr[i3] = hexString.charAt(i);
            i3++;
            i++;
        }
        return new java.lang.String(cArr);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.JspMangler
    public java.lang.String mapJspToJavaName(java.io.File file) {
        java.lang.String absolutePath = file.getAbsolutePath();
        int lastIndexOf = absolutePath.lastIndexOf(java.io.File.separatorChar) + 1;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(absolutePath.length() - lastIndexOf);
        if (!java.lang.Character.isJavaIdentifierStart(absolutePath.charAt(lastIndexOf)) || absolutePath.charAt(lastIndexOf) == '_') {
            sb.append('_');
        }
        for (char c : absolutePath.substring(lastIndexOf).toCharArray()) {
            if (java.lang.Character.isJavaIdentifierPart(c)) {
                sb.append(c);
            } else if (c == '.') {
                sb.append('_');
            } else {
                sb.append(a(c));
            }
        }
        return sb.toString();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.jsp.JspMangler
    public java.lang.String mapPath(java.lang.String str) {
        return null;
    }
}
