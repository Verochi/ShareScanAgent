package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class DoubleMetaphone implements org.apache.commons.codec.StringEncoder {
    public static final java.lang.String[] b = {"GN", "KN", "PN", "WR", "PS"};
    public static final java.lang.String[] c = {"L", "R", "N", "M", "B", "H", "F", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST, " "};
    public static final java.lang.String[] d = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", com.anythink.core.api.ATCountryCode.INDIA, "IE", "EI", "ER"};
    public static final java.lang.String[] e = {"L", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "K", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};
    public int a = 4;

    public class DoubleMetaphoneResult {
        public final java.lang.StringBuffer a;
        public final java.lang.StringBuffer b;
        public final int c;

        public DoubleMetaphoneResult(int i) {
            this.a = new java.lang.StringBuffer(org.apache.commons.codec.language.DoubleMetaphone.this.getMaxCodeLen());
            this.b = new java.lang.StringBuffer(org.apache.commons.codec.language.DoubleMetaphone.this.getMaxCodeLen());
            this.c = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void append(java.lang.String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(java.lang.String str, java.lang.String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendAlternate(char c) {
            if (this.b.length() < this.c) {
                this.b.append(c);
            }
        }

        public void appendAlternate(java.lang.String str) {
            int length = this.c - this.b.length();
            if (str.length() <= length) {
                this.b.append(str);
            } else {
                this.b.append(str.substring(0, length));
            }
        }

        public void appendPrimary(char c) {
            if (this.a.length() < this.c) {
                this.a.append(c);
            }
        }

        public void appendPrimary(java.lang.String str) {
            int length = this.c - this.a.length();
            if (str.length() <= length) {
                this.a.append(str);
            } else {
                this.a.append(str.substring(0, length));
            }
        }

        public java.lang.String getAlternate() {
            return this.b.toString();
        }

        public java.lang.String getPrimary() {
            return this.a.toString();
        }

        public boolean isComplete() {
            return this.a.length() >= this.c && this.b.length() >= this.c;
        }
    }

    public static boolean contains(java.lang.String str, int i, int i2, java.lang.String[] strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        java.lang.String substring = str.substring(i, i3);
        for (java.lang.String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(java.lang.String str, int i, int i2, java.lang.String str2) {
        return contains(str, i, i2, new java.lang.String[]{str2});
    }

    public static boolean h(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3) {
        return contains(str, i, i2, new java.lang.String[]{str2, str3});
    }

    public static boolean i(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return contains(str, i, i2, new java.lang.String[]{str2, str3, str4});
    }

    public static boolean j(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        return contains(str, i, i2, new java.lang.String[]{str2, str3, str4, str5});
    }

    public static boolean k(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        return contains(str, i, i2, new java.lang.String[]{str2, str3, str4, str5, str6});
    }

    public static boolean l(java.lang.String str, int i, int i2, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        return contains(str, i, i2, new java.lang.String[]{str2, str3, str4, str5, str6, str7});
    }

    public final int A(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (g(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
        } else {
            if (!h(str, i, 3, "TIA", "TCH")) {
                if (!g(str, i, 2, "TH") && !g(str, i, 3, "TTH")) {
                    doubleMetaphoneResult.append('T');
                    int i2 = i + 1;
                    return h(str, i2, 1, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "D") ? i + 2 : i2;
                }
                int i3 = i + 2;
                if (h(str, i3, 2, "OM", "AM") || h(str, 0, 4, "VAN ", "VON ") || g(str, 0, 3, "SCH")) {
                    doubleMetaphoneResult.append('T');
                    return i3;
                }
                doubleMetaphoneResult.append('0', 'T');
                return i3;
            }
            doubleMetaphoneResult.append('X');
        }
        return i + 3;
    }

    public final int B(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (g(str, i, 2, "WR")) {
            doubleMetaphoneResult.append('R');
            return i + 2;
        }
        if (i == 0) {
            int i2 = i + 1;
            if (G(charAt(str, i2)) || g(str, i, 2, "WH")) {
                if (G(charAt(str, i2))) {
                    doubleMetaphoneResult.append('A', 'F');
                } else {
                    doubleMetaphoneResult.append('A');
                }
                return i2;
            }
        }
        if ((i == str.length() - 1 && G(charAt(str, i - 1))) || j(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || g(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.appendAlternate('F');
        } else if (h(str, i, 4, "WICZ", "WITZ")) {
            doubleMetaphoneResult.append("TS", "FX");
            return i + 4;
        }
        return i + 1;
    }

    public final int C(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!h(str, i - 3, 3, "IAU", "EAU") && !h(str, i - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append(com.qq.e.comm.managers.setting.GlobalSetting.KS_SDK_WRAPPER);
        }
        int i2 = i + 1;
        return h(str, i2, 1, "C", "X") ? i + 2 : i2;
    }

    public final int D(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (i(str, i2, 2, "ZO", "ZI", "ZA") || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    public final boolean E(java.lang.String str) {
        for (java.lang.String str2 : b) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean F(java.lang.String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    public final boolean G(char c2) {
        return "AEIOUY".indexOf(c2) != -1;
    }

    public final java.lang.String a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.lang.String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(java.util.Locale.ENGLISH);
    }

    public final boolean b(java.lang.String str, int i) {
        if (g(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (G(charAt(str, i2)) || !g(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        return !(charAt == 'I' || charAt == 'E') || h(str, i2, 6, "BACHER", "MACHER");
    }

    public final boolean c(java.lang.String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        return (h(str, i2, 5, "HARAC", "HARIS") || j(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !g(str, 0, 5, "CHORE");
    }

    public char charAt(java.lang.String str, int i) {
        if (i < 0 || i >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i);
    }

    public final boolean d(java.lang.String str, int i) {
        if (!h(str, 0, 4, "VAN ", "VON ") && !g(str, 0, 3, "SCH") && !i(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = i + 2;
            if (!h(str, i2, 1, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH)) {
                if (!j(str, i - 1, 1, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST) && i != 0) {
                    return false;
                }
                if (!contains(str, i2, 1, c) && i + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public java.lang.String doubleMetaphone(java.lang.String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public java.lang.String doubleMetaphone(java.lang.String str, boolean z) {
        int i;
        ?? a = a(str);
        if (a == 0) {
            return null;
        }
        boolean F = F(a);
        ?? E = E(a);
        org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult = new org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult(getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && E <= a.length() - 1) {
            char charAt = a.charAt(E);
            if (charAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        E = m(doubleMetaphoneResult, E);
                        break;
                    case 'B':
                        doubleMetaphoneResult.append('P');
                        i = E + 1;
                        if (charAt(a, i) != 'B') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'C':
                        E = n(a, doubleMetaphoneResult, E);
                        break;
                    case 'D':
                        E = q(a, doubleMetaphoneResult, E);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        i = E + 1;
                        if (charAt(a, i) != 'F') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'G':
                        E = r(a, doubleMetaphoneResult, E, F);
                        break;
                    case 'H':
                        E = t(a, doubleMetaphoneResult, E);
                        break;
                    case 'J':
                        E = u(a, doubleMetaphoneResult, E, F);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        i = E + 1;
                        if (charAt(a, i) != 'K') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'L':
                        E = v(a, doubleMetaphoneResult, E);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        if (!f(a, E)) {
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        i = E + 1;
                        if (charAt(a, i) != 'N') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'P':
                        E = w(a, doubleMetaphoneResult, E);
                        break;
                    case 'Q':
                        doubleMetaphoneResult.append('K');
                        i = E + 1;
                        if (charAt(a, i) != 'Q') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'R':
                        E = x(a, doubleMetaphoneResult, E, F);
                        break;
                    case 'S':
                        E = y(a, doubleMetaphoneResult, E, F);
                        break;
                    case 'T':
                        E = A(a, doubleMetaphoneResult, E);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        i = E + 1;
                        if (charAt(a, i) != 'V') {
                            E = i;
                            break;
                        } else {
                            E += 2;
                            break;
                        }
                    case 'W':
                        E = B(a, doubleMetaphoneResult, E);
                        break;
                    case 'X':
                        E = C(a, doubleMetaphoneResult, E);
                        break;
                    case 'Z':
                        E = D(a, doubleMetaphoneResult, E, F);
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            E++;
        }
        return z ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    public final boolean e(java.lang.String str, int i) {
        if (i == str.length() - 3 && i(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (h(str, str.length() - 2, 2, "AS", "OS") || h(str, str.length() - 1, 1, androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && g(str, i - 1, 4, "ALLE");
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return doubleMetaphone((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return doubleMetaphone(str);
    }

    public final boolean f(java.lang.String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        return g(str, i + (-1), 3, "UMB") && (i2 == str.length() - 1 || g(str, i + 2, 2, "ER"));
    }

    public int getMaxCodeLen() {
        return this.a;
    }

    public boolean isDoubleMetaphoneEqual(java.lang.String str, java.lang.String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(java.lang.String str, java.lang.String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    public final int m(org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    public final int n(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (b(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (i == 0 && g(str, i, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
        } else {
            if (g(str, i, 2, "CH")) {
                return p(str, doubleMetaphoneResult, i);
            }
            if (!g(str, i, 2, "CZ") || g(str, i - 2, 4, "WICZ")) {
                int i2 = i + 1;
                if (g(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X');
                } else {
                    if (g(str, i, 2, "CC") && (i != 1 || charAt(str, 0) != 'M')) {
                        return o(str, doubleMetaphoneResult, i);
                    }
                    if (i(str, i, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K');
                    } else if (!i(str, i, 2, "CI", "CE", "CY")) {
                        doubleMetaphoneResult.append('K');
                        if (!i(str, i2, 2, " C", " Q", " G")) {
                            if (!i(str, i2, 1, "C", "K", "Q") || h(str, i2, 2, "CE", "CI")) {
                                return i2;
                            }
                        }
                    } else if (i(str, i, 3, "CIO", "CIE", "CIA")) {
                        doubleMetaphoneResult.append('S', 'X');
                    } else {
                        doubleMetaphoneResult.append('S');
                    }
                }
                return i + 3;
            }
            doubleMetaphoneResult.append('S', 'X');
        }
        return i + 2;
    }

    public final int o(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (!i(str, i2, 1, "I", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "H") || g(str, i2, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i2;
        }
        if ((i == 1 && charAt(str, i - 1) == 'A') || h(str, i - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append(com.qq.e.comm.managers.setting.GlobalSetting.KS_SDK_WRAPPER);
        } else {
            doubleMetaphoneResult.append('X');
        }
        return i + 3;
    }

    public final int p(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && g(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else if (c(str, i)) {
            doubleMetaphoneResult.append('K');
        } else {
            if (!d(str, i)) {
                if (i <= 0) {
                    doubleMetaphoneResult.append('X');
                } else if (g(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
                return i + 2;
            }
            doubleMetaphoneResult.append('K');
        }
        return i + 2;
    }

    public final int q(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (!g(str, i, 2, "DG")) {
            if (h(str, i, 2, "DT", "DD")) {
                doubleMetaphoneResult.append('T');
                return i + 2;
            }
            doubleMetaphoneResult.append('T');
            return i + 1;
        }
        int i2 = i + 2;
        if (i(str, i2, 1, "I", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Y")) {
            doubleMetaphoneResult.append('J');
            return i + 3;
        }
        doubleMetaphoneResult.append("TK");
        return i2;
    }

    public final int r(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2;
        int i3 = i + 1;
        if (charAt(str, i3) == 'H') {
            return s(str, doubleMetaphoneResult, i);
        }
        if (charAt(str, i3) == 'N') {
            if (i == 1 && G(charAt(str, 0)) && !z) {
                doubleMetaphoneResult.append("KN", "N");
            } else if (g(str, i + 2, 2, "EY") || charAt(str, i3) == 'Y' || z) {
                doubleMetaphoneResult.append("KN");
            } else {
                doubleMetaphoneResult.append("N", "KN");
            }
        } else if (g(str, i3, 2, "LI") && !z) {
            doubleMetaphoneResult.append("KL", "L");
        } else if (i == 0 && (charAt(str, i3) == 'Y' || contains(str, i3, 2, d))) {
            doubleMetaphoneResult.append('K', 'J');
        } else {
            if (g(str, i3, 2, "ER") || charAt(str, i3) == 'Y') {
                i2 = 3;
                if (!i(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                    int i4 = i - 1;
                    if (!h(str, i4, 1, androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "I") && !h(str, i4, 3, "RGY", "OGY")) {
                        doubleMetaphoneResult.append('K', 'J');
                    }
                }
            } else {
                i2 = 3;
            }
            if (!i(str, i3, 1, androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "I", "Y") && !h(str, i - 1, 4, "AGGI", "OGGI")) {
                if (charAt(str, i3) != 'G') {
                    doubleMetaphoneResult.append('K');
                    return i3;
                }
                int i5 = i + 2;
                doubleMetaphoneResult.append('K');
                return i5;
            }
            if (h(str, 0, 4, "VAN ", "VON ") || g(str, 0, i2, "SCH") || g(str, i3, 2, "ET")) {
                doubleMetaphoneResult.append('K');
            } else if (g(str, i3, i2, "IER")) {
                doubleMetaphoneResult.append('J');
            } else {
                doubleMetaphoneResult.append('J', 'K');
            }
        }
        return i + 2;
    }

    public final int s(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && !G(charAt(str, i - 1))) {
            doubleMetaphoneResult.append('K');
        } else {
            if (i == 0) {
                int i2 = i + 2;
                if (charAt(str, i2) == 'I') {
                    doubleMetaphoneResult.append('J');
                    return i2;
                }
                doubleMetaphoneResult.append('K');
                return i2;
            }
            if ((i <= 1 || !i(str, i - 2, 1, "B", "H", "D")) && ((i <= 2 || !i(str, i - 3, 1, "B", "H", "D")) && (i <= 3 || !h(str, i - 4, 1, "B", "H")))) {
                if (i > 2 && charAt(str, i - 1) == 'U' && k(str, i - 3, 1, "C", "G", "L", "R", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE)) {
                    doubleMetaphoneResult.append('F');
                } else if (i > 0 && charAt(str, i - 1) != 'I') {
                    doubleMetaphoneResult.append('K');
                }
            }
        }
        return i + 2;
    }

    public void setMaxCodeLen(int i) {
        this.a = i;
    }

    public final int t(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !G(charAt(str, i - 1))) || !G(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    public final int u(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (g(str, i, 4, "JOSE") || g(str, 0, 4, "SAN ")) {
            if ((i == 0 && charAt(str, i + 4) == ' ') || str.length() == 4 || g(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.append('H');
            } else {
                doubleMetaphoneResult.append('J', 'H');
            }
            return i + 1;
        }
        if (i != 0 || g(str, i, 4, "JOSE")) {
            int i2 = i - 1;
            if (G(charAt(str, i2)) && !z) {
                int i3 = i + 1;
                if (charAt(str, i3) == 'A' || charAt(str, i3) == 'O') {
                    doubleMetaphoneResult.append('J', 'H');
                }
            }
            if (i == str.length() - 1) {
                doubleMetaphoneResult.append('J', ' ');
            } else if (!contains(str, i + 1, 1, e) && !i(str, i2, 1, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                doubleMetaphoneResult.append('J');
            }
        } else {
            doubleMetaphoneResult.append('J', 'A');
        }
        int i4 = i + 1;
        return charAt(str, i4) == 'J' ? i + 2 : i4;
    }

    public final int v(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) != 'L') {
            doubleMetaphoneResult.append('L');
            return i2;
        }
        if (e(str, i)) {
            doubleMetaphoneResult.appendPrimary('L');
        } else {
            doubleMetaphoneResult.append('L');
        }
        return i + 2;
    }

    public final int w(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (h(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    public final int x(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i != str.length() - 1 || z || !g(str, i - 2, 2, "IE") || h(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append('R');
        } else {
            doubleMetaphoneResult.appendAlternate('R');
        }
        int i2 = i + 1;
        return charAt(str, i2) == 'R' ? i + 2 : i2;
    }

    public final int y(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (!h(str, i - 1, 3, "ISL", "YSL")) {
            if (i != 0 || !g(str, i, 5, "SUGAR")) {
                if (g(str, i, 2, "SH")) {
                    if (j(str, i + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('X');
                    }
                } else {
                    if (h(str, i, 3, "SIO", "SIA") || g(str, i, 4, "SIAN")) {
                        if (z) {
                            doubleMetaphoneResult.append('S');
                        } else {
                            doubleMetaphoneResult.append('S', 'X');
                        }
                        return i + 3;
                    }
                    if (i != 0 || !j(str, i + 1, 1, "M", "N", "L", androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST)) {
                        int i2 = i + 1;
                        if (!g(str, i2, 1, "Z")) {
                            if (g(str, i, 2, "SC")) {
                                return z(str, doubleMetaphoneResult, i);
                            }
                            if (i == str.length() - 1 && h(str, i - 2, 2, "AI", "OI")) {
                                doubleMetaphoneResult.appendAlternate('S');
                            } else {
                                doubleMetaphoneResult.append('S');
                            }
                            if (!h(str, i2, 1, androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i2;
                            }
                        }
                    }
                    doubleMetaphoneResult.append('S', 'X');
                    int i3 = i + 1;
                    if (!g(str, i3, 1, "Z")) {
                        return i3;
                    }
                }
                return i + 2;
            }
            doubleMetaphoneResult.append('X', 'S');
        }
        return i + 1;
    }

    public final int z(java.lang.String str, org.apache.commons.codec.language.DoubleMetaphone.DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (charAt(str, i2) == 'H') {
            int i3 = i + 3;
            if (l(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (h(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i != 0 || G(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else if (i(str, i2, 1, "I", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "Y")) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return i + 3;
    }
}
