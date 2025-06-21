package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class FilenameUtils {
    public static final char EXTENSION_SEPARATOR = '.';
    private static final char OTHER_SEPARATOR;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    public static final java.lang.String EXTENSION_SEPARATOR_STR = java.lang.Character.toString('.');
    private static final char SYSTEM_SEPARATOR = java.io.File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
    }

    public static java.lang.String concat(java.lang.String str, java.lang.String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + '/' + str2);
    }

    private static java.lang.String doGetFullPath(java.lang.String str, boolean z) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            return z ? getPrefix(str) : str;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        if (indexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i = indexOfLastSeparator + (z ? 1 : 0);
        if (i == 0) {
            i++;
        }
        return str.substring(0, i);
    }

    private static java.lang.String doGetPath(java.lang.String str, int i) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int indexOfLastSeparator = indexOfLastSeparator(str);
        int i2 = i + indexOfLastSeparator;
        return (prefixLength >= str.length() || indexOfLastSeparator < 0 || prefixLength >= i2) ? "" : str.substring(prefixLength, i2);
    }

    private static java.lang.String doNormalize(java.lang.String str, char c, boolean z) {
        boolean z2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i = length + 2;
        char[] cArr = new char[i];
        str.getChars(0, str.length(), cArr, 0);
        char c2 = SYSTEM_SEPARATOR;
        if (c == c2) {
            c2 = OTHER_SEPARATOR;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (cArr[i2] == c2) {
                cArr[i2] = c;
            }
        }
        if (cArr[length - 1] != c) {
            cArr[length] = c;
            length++;
            z2 = false;
        } else {
            z2 = true;
        }
        int i3 = prefixLength + 1;
        int i4 = i3;
        while (i4 < length) {
            if (cArr[i4] == c) {
                int i5 = i4 - 1;
                if (cArr[i5] == c) {
                    java.lang.System.arraycopy(cArr, i4, cArr, i5, length - i4);
                    length--;
                    i4--;
                }
            }
            i4++;
        }
        int i6 = i3;
        while (i6 < length) {
            if (cArr[i6] == c) {
                int i7 = i6 - 1;
                if (cArr[i7] == '.' && (i6 == i3 || cArr[i6 - 2] == c)) {
                    if (i6 == length - 1) {
                        z2 = true;
                    }
                    java.lang.System.arraycopy(cArr, i6 + 1, cArr, i7, length - i6);
                    length -= 2;
                    i6--;
                }
            }
            i6++;
        }
        int i8 = prefixLength + 2;
        int i9 = i8;
        while (i9 < length) {
            if (cArr[i9] == c && cArr[i9 - 1] == '.' && cArr[i9 - 2] == '.' && (i9 == i8 || cArr[i9 - 3] == c)) {
                if (i9 == i8) {
                    return null;
                }
                if (i9 == length - 1) {
                    z2 = true;
                }
                int i10 = i9 - 4;
                while (true) {
                    if (i10 < prefixLength) {
                        int i11 = i9 + 1;
                        java.lang.System.arraycopy(cArr, i11, cArr, prefixLength, length - i9);
                        length -= i11 - prefixLength;
                        i9 = i3;
                        break;
                    }
                    if (cArr[i10] == c) {
                        int i12 = i10 + 1;
                        java.lang.System.arraycopy(cArr, i9 + 1, cArr, i12, length - i9);
                        length -= i9 - i10;
                        i9 = i12;
                        break;
                    }
                    i10--;
                }
            }
            i9++;
        }
        return length <= 0 ? "" : length <= prefixLength ? new java.lang.String(cArr, 0, length) : (z2 && z) ? new java.lang.String(cArr, 0, length) : new java.lang.String(cArr, 0, length - 1);
    }

    public static java.lang.String getExtension(java.lang.String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        return indexOfExtension == -1 ? "" : str.substring(indexOfExtension + 1);
    }

    public static java.lang.String getFullPath(java.lang.String str) {
        return doGetFullPath(str, true);
    }

    public static java.lang.String getFullPathNoEndSeparator(java.lang.String str) {
        return doGetFullPath(str, false);
    }

    public static java.lang.String getName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static java.lang.String getPath(java.lang.String str) {
        return doGetPath(str, 1);
    }

    public static java.lang.String getPathNoEndSeparator(java.lang.String str) {
        return doGetPath(str, 0);
    }

    public static java.lang.String getPrefix(java.lang.String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength <= str.length()) {
            return str.substring(0, prefixLength);
        }
        return str + '/';
    }

    public static int getPrefixLength(java.lang.String str) {
        int min;
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return isSeparator(charAt) ? 1 : 0;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            min = java.lang.Math.min(indexOf, indexOf2);
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char upperCase = java.lang.Character.toUpperCase(charAt);
                if (upperCase < 'A' || upperCase > 'Z') {
                    return -1;
                }
                return (length == 2 || !isSeparator(str.charAt(2))) ? 2 : 3;
            }
            if (!isSeparator(charAt) || !isSeparator(charAt2)) {
                return isSeparator(charAt) ? 1 : 0;
            }
            int indexOf3 = str.indexOf(47, 2);
            int indexOf4 = str.indexOf(92, 2);
            if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
                return -1;
            }
            if (indexOf3 == -1) {
                indexOf3 = indexOf4;
            }
            if (indexOf4 == -1) {
                indexOf4 = indexOf3;
            }
            min = java.lang.Math.min(indexOf3, indexOf4);
        }
        return min + 1;
    }

    public static int indexOfExtension(java.lang.String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int indexOfLastSeparator(java.lang.String str) {
        if (str == null) {
            return -1;
        }
        return java.lang.Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isExtension(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return false;
        }
        return (str2 == null || str2.length() == 0) ? indexOfExtension(str) == -1 : getExtension(str).equals(str2);
    }

    public static boolean isExtension(java.lang.String str, java.util.Collection<java.lang.String> collection) {
        if (str == null) {
            return false;
        }
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        java.lang.String extension = getExtension(str);
        java.util.Iterator<java.lang.String> it = collection.iterator();
        while (it.hasNext()) {
            if (extension.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(java.lang.String str, java.lang.String[] strArr) {
        if (str == null) {
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            return indexOfExtension(str) == -1;
        }
        java.lang.String extension = getExtension(str);
        for (java.lang.String str2 : strArr) {
            if (extension.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSeparator(char c) {
        return c == '/' || c == '\\';
    }

    public static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static java.lang.String normalize(java.lang.String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static java.lang.String normalize(java.lang.String str, boolean z) {
        return doNormalize(str, z ? '/' : '\\', true);
    }

    public static java.lang.String normalizeNoEndSeparator(java.lang.String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static java.lang.String normalizeNoEndSeparator(java.lang.String str, boolean z) {
        return doNormalize(str, z ? '/' : '\\', false);
    }

    public static java.lang.String separatorsToSystem(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return isSystemWindows() ? separatorsToWindows(str) : separatorsToUnix(str);
    }

    public static java.lang.String separatorsToUnix(java.lang.String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public static java.lang.String separatorsToWindows(java.lang.String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace('/', '\\');
    }

    public static java.lang.String[] splitOnTokens(java.lang.String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new java.lang.String[]{str};
        }
        char[] charArray = str.toCharArray();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '?' || c == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (charArray[i] == '?') {
                    arrayList.add("?");
                } else if (arrayList.isEmpty() || (i > 0 && !((java.lang.String) arrayList.get(arrayList.size() - 1)).equals("*"))) {
                    arrayList.add("*");
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }
}
