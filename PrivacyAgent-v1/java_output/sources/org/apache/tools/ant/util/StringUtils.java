package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class StringUtils {
    public static final java.lang.String LINE_SEP = java.lang.System.getProperty("line.separator");

    public static boolean endsWith(java.lang.StringBuffer stringBuffer, java.lang.String str) {
        if (str.length() > stringBuffer.length()) {
            return false;
        }
        int length = stringBuffer.length() - 1;
        for (int length2 = str.length() - 1; length2 >= 0; length2--) {
            if (stringBuffer.charAt(length) != str.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static java.lang.String getStackTrace(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter((java.io.Writer) stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    public static java.util.Vector<java.lang.String> lineSplit(java.lang.String str) {
        return split(str, 10);
    }

    public static long parseHumanSizes(java.lang.String str) throws java.lang.Exception {
        long j;
        char charAt = str.charAt(0);
        int i = 1;
        long j2 = 1;
        if (charAt == '+') {
            str = str.substring(1);
        } else if (charAt == '-') {
            str = str.substring(1);
            j2 = -1;
        }
        char charAt2 = str.charAt(str.length() - 1);
        if (!java.lang.Character.isDigit(charAt2)) {
            if (charAt2 == 'G') {
                j = 1073741824;
            } else if (charAt2 == 'K') {
                j = 1024;
            } else if (charAt2 == 'M') {
                j = 1048576;
            } else if (charAt2 == 'P') {
                j = 1125899906842624L;
            } else if (charAt2 != 'T') {
                i = 0;
                str = str.substring(0, str.length() - i);
            } else {
                j = 1099511627776L;
            }
            j2 *= j;
            str = str.substring(0, str.length() - i);
        }
        try {
            return j2 * java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException e) {
            throw new org.apache.tools.ant.BuildException("Failed to parse \"" + str + "\"", e);
        }
    }

    public static java.lang.String removePrefix(java.lang.String str, java.lang.String str2) {
        return str.startsWith(str2) ? str.substring(str2.length()) : str;
    }

    public static java.lang.String removeSuffix(java.lang.String str, java.lang.String str2) {
        return str.endsWith(str2) ? str.substring(0, str.length() - str2.length()) : str;
    }

    @java.lang.Deprecated
    public static java.lang.String replace(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return str.replace(str2, str3);
    }

    public static java.lang.String resolveBackSlash(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        boolean z = false;
        for (char c : str.toCharArray()) {
            if (z) {
                if (c == '\\') {
                    stringBuffer.append('\\');
                } else if (c == 'f') {
                    stringBuffer.append('\f');
                } else if (c != 'n') {
                    switch (c) {
                        case 'r':
                            stringBuffer.append('\r');
                            break;
                        case 's':
                            stringBuffer.append(" \t\n\r\f");
                            break;
                        case 't':
                            stringBuffer.append('\t');
                            break;
                        default:
                            stringBuffer.append(c);
                            break;
                    }
                } else {
                    stringBuffer.append('\n');
                }
                z = false;
            } else if (c == '\\') {
                z = true;
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    public static java.util.Vector<java.lang.String> split(java.lang.String str, int i) {
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(i, i2);
            if (indexOf == -1) {
                vector.addElement(str.substring(i2));
                return vector;
            }
            vector.addElement(str.substring(i2, indexOf));
            i2 = indexOf + 1;
        }
    }
}
