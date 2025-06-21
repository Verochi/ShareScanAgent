package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public final class SelectorUtils {
    public static final java.lang.String DEEP_TREE_MATCH = "**";
    public static final org.apache.tools.ant.types.selectors.SelectorUtils a = new org.apache.tools.ant.types.selectors.SelectorUtils();
    public static final org.apache.tools.ant.util.FileUtils b = org.apache.tools.ant.util.FileUtils.getFileUtils();

    public static boolean a(char[] cArr, int i, int i2) {
        while (i <= i2) {
            if (cArr[i] != '*') {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean b(boolean z, char c, char c2) {
        if (z) {
            if (c != c2) {
                return true;
            }
        } else if (java.lang.Character.toUpperCase(c) != java.lang.Character.toUpperCase(c2)) {
            return true;
        }
        return false;
    }

    public static boolean c(java.lang.String[] strArr, java.lang.String[] strArr2, boolean z) {
        int i;
        int i2 = 1;
        int length = strArr.length - 1;
        int length2 = strArr2.length - 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 <= length && i4 <= length2) {
            java.lang.String str = strArr[i3];
            if (str.equals(DEEP_TREE_MATCH)) {
                break;
            }
            if (!match(str, strArr2[i4], z)) {
                return false;
            }
            i3++;
            i4++;
        }
        if (i4 > length2) {
            while (i3 <= length) {
                if (!strArr[i3].equals(DEEP_TREE_MATCH)) {
                    return false;
                }
                i3++;
            }
            return true;
        }
        if (i3 > length) {
            return false;
        }
        while (i3 <= length && i4 <= length2) {
            java.lang.String str2 = strArr[length];
            if (str2.equals(DEEP_TREE_MATCH)) {
                break;
            }
            if (!match(str2, strArr2[length2], z)) {
                return false;
            }
            length--;
            length2--;
        }
        if (i4 > length2) {
            while (i3 <= length) {
                if (!strArr[i3].equals(DEEP_TREE_MATCH)) {
                    return false;
                }
                i3++;
            }
            return true;
        }
        while (i3 != length && i4 <= length2) {
            int i5 = i3 + 1;
            int i6 = i5;
            while (true) {
                if (i6 > length) {
                    i6 = -1;
                    break;
                }
                if (strArr[i6].equals(DEEP_TREE_MATCH)) {
                    break;
                }
                i6++;
            }
            if (i6 == i5) {
                i3 = i5;
            } else {
                int i7 = (i6 - i3) - i2;
                int i8 = (length2 - i4) + i2;
                int i9 = 0;
                while (true) {
                    if (i9 > i8 - i7) {
                        i = -1;
                        break;
                    }
                    for (int i10 = 0; i10 < i7; i10++) {
                        if (!match(strArr[i3 + i10 + 1], strArr2[i4 + i9 + i10], z)) {
                            break;
                        }
                    }
                    i = i4 + i9;
                    break;
                    i9++;
                }
                if (i == -1) {
                    return false;
                }
                i4 = i + i7;
                i3 = i6;
                i2 = 1;
            }
        }
        while (i3 <= length) {
            if (!strArr[i3].equals(DEEP_TREE_MATCH)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    public static boolean d(java.lang.String[] strArr, java.lang.String[] strArr2, boolean z) {
        int length = strArr.length - 1;
        int length2 = strArr2.length - 1;
        int i = 0;
        int i2 = 0;
        while (i <= length && i2 <= length2) {
            java.lang.String str = strArr[i];
            if (str.equals(DEEP_TREE_MATCH)) {
                break;
            }
            if (!match(str, strArr2[i2], z)) {
                return false;
            }
            i++;
            i2++;
        }
        return i2 > length2 || i <= length;
    }

    public static java.lang.String[] e(java.lang.String str) {
        java.lang.String str2;
        int i = 1;
        if (org.apache.tools.ant.util.FileUtils.isAbsolutePath(str)) {
            java.lang.String[] dissect = b.dissect(str);
            str2 = dissect[0];
            str = dissect[1];
        } else {
            str2 = null;
        }
        char c = java.io.File.separatorChar;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) == c) {
                if (i4 != i2) {
                    i3++;
                }
                i2 = i4 + 1;
            }
        }
        if (length != i2) {
            i3++;
        }
        java.lang.String[] strArr = new java.lang.String[i3 + (str2 == null ? 0 : 1)];
        if (str2 != null) {
            strArr[0] = str2;
        } else {
            i = 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (str.charAt(i6) == c) {
                if (i6 != i5) {
                    strArr[i] = str.substring(i5, i6);
                    i++;
                }
                i5 = i6 + 1;
            }
        }
        if (length != i5) {
            strArr[i] = str.substring(i5);
        }
        return strArr;
    }

    public static org.apache.tools.ant.types.selectors.SelectorUtils getInstance() {
        return a;
    }

    public static boolean hasWildcards(java.lang.String str) {
        return (str.indexOf(42) == -1 && str.indexOf(63) == -1) ? false : true;
    }

    public static boolean isOutOfDate(java.io.File file, java.io.File file2, int i) {
        if (file.exists()) {
            return !file2.exists() || file.lastModified() - ((long) i) > file2.lastModified();
        }
        return false;
    }

    public static boolean isOutOfDate(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, int i) {
        return isOutOfDate(resource, resource2, i);
    }

    public static boolean isOutOfDate(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2, long j) {
        long lastModified = resource.getLastModified();
        long lastModified2 = resource2.getLastModified();
        return resource.isExists() && (lastModified == 0 || lastModified2 == 0 || lastModified - j > lastModified2);
    }

    public static boolean match(java.lang.String str, java.lang.String str2) {
        return match(str, str2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00d3, code lost:
    
        return a(r1, r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0057, code lost:
    
        if (r10 <= r5) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005d, code lost:
    
        return a(r1, r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005e, code lost:
    
        r11 = r1[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0060, code lost:
    
        if (r11 == '*') goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0062, code lost:
    
        if (r10 <= r5) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0065, code lost:
    
        if (r11 == '?') goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
    
        if (b(r19, r11, r2[r5]) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0070, code lost:
    
        r3 = r3 - 1;
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0075, code lost:
    
        if (r10 <= r5) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007b, code lost:
    
        return a(r1, r6, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007c, code lost:
    
        if (r6 == r3) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x007e, code lost:
    
        if (r10 > r5) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0080, code lost:
    
        r11 = r6 + 1;
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0084, code lost:
    
        if (r12 > r3) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0088, code lost:
    
        if (r1[r12] != r9) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x008b, code lost:
    
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008f, code lost:
    
        if (r12 != r11) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0093, code lost:
    
        r11 = (r12 - r6) - r4;
        r14 = (r5 - r10) + r4;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x009c, code lost:
    
        if (r15 > (r14 - r11)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x009e, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x009f, code lost:
    
        if (r9 >= r11) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a1, code lost:
    
        r4 = r1[(r6 + r9) + 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00a7, code lost:
    
        if (r4 == r8) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00b3, code lost:
    
        if (b(r19, r4, r2[(r10 + r15) + r9]) == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b5, code lost:
    
        r15 = r15 + 1;
        r8 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00bb, code lost:
    
        r9 = r9 + 1;
        r8 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00c1, code lost:
    
        r10 = r10 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00c4, code lost:
    
        if (r10 != (-1)) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c7, code lost:
    
        r10 = r10 + r11;
        r6 = r12;
        r4 = 1;
        r8 = '?';
        r9 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00c6, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c3, code lost:
    
        r10 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0091, code lost:
    
        r6 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x008e, code lost:
    
        r12 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean match(java.lang.String str, java.lang.String str2, boolean z) {
        boolean z2;
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i = 1;
        int length = charArray.length - 1;
        int length2 = charArray2.length - 1;
        int length3 = charArray.length;
        int i2 = 0;
        while (true) {
            char c = '*';
            if (i2 >= length3) {
                z2 = false;
                break;
            }
            if (charArray[i2] == '*') {
                z2 = true;
                break;
            }
            i2++;
        }
        char c2 = '?';
        if (!z2) {
            if (length != length2) {
                return false;
            }
            for (int i3 = 0; i3 <= length; i3++) {
                char c3 = charArray[i3];
                if (c3 != '?' && b(z, c3, charArray2[i3])) {
                    return false;
                }
            }
            return true;
        }
        if (length == 0) {
            return true;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            char c4 = charArray[i4];
            if (c4 == '*' || i5 > length2) {
                break;
            }
            if (c4 != '?' && b(z, c4, charArray2[i5])) {
                return false;
            }
            i4++;
            i5++;
        }
    }

    public static boolean matchPath(java.lang.String str, java.lang.String str2) {
        return c(e(str), e(str2), true);
    }

    public static boolean matchPath(java.lang.String str, java.lang.String str2, boolean z) {
        return c(e(str), e(str2), z);
    }

    public static boolean matchPatternStart(java.lang.String str, java.lang.String str2) {
        return matchPatternStart(str, str2, true);
    }

    public static boolean matchPatternStart(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.String str3 = java.io.File.separator;
        if (str2.startsWith(str3) != str.startsWith(str3)) {
            return false;
        }
        return d(e(str), e(str2), z);
    }

    public static java.lang.String removeWhitespace(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (str != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str);
            while (stringTokenizer.hasMoreTokens()) {
                stringBuffer.append(stringTokenizer.nextToken());
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String rtrimWildcardTokens(java.lang.String str) {
        return new org.apache.tools.ant.types.selectors.TokenizedPattern(str).rtrimWildcardTokens().toString();
    }

    public static java.util.Vector<java.lang.String> tokenizePath(java.lang.String str) {
        return tokenizePath(str, java.io.File.separator);
    }

    public static java.util.Vector<java.lang.String> tokenizePath(java.lang.String str, java.lang.String str2) {
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
        if (org.apache.tools.ant.util.FileUtils.isAbsolutePath(str)) {
            java.lang.String[] dissect = b.dissect(str);
            vector.add(dissect[0]);
            str = dissect[1];
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            vector.addElement(stringTokenizer.nextToken());
        }
        return vector;
    }
}
