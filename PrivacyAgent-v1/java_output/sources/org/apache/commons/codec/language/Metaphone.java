package org.apache.commons.codec.language;

/* loaded from: classes24.dex */
public class Metaphone implements org.apache.commons.codec.StringEncoder {
    public int a = 4;

    public final boolean a(int i, int i2) {
        return i2 + 1 == i;
    }

    public final boolean b(java.lang.StringBuffer stringBuffer, int i, char c) {
        return i >= 0 && i < stringBuffer.length() - 1 && stringBuffer.charAt(i + 1) == c;
    }

    public final boolean c(java.lang.StringBuffer stringBuffer, int i, char c) {
        return i > 0 && i < stringBuffer.length() && stringBuffer.charAt(i - 1) == c;
    }

    public final boolean d(java.lang.StringBuffer stringBuffer, int i) {
        return "AEIOU".indexOf(stringBuffer.charAt(i)) >= 0;
    }

    public final boolean e(java.lang.StringBuffer stringBuffer, int i, java.lang.String str) {
        if (i < 0 || (str.length() + i) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i, str.length() + i).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return metaphone((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) {
        return metaphone(str);
    }

    public int getMaxCodeLen() {
        return this.a;
    }

    public boolean isMetaphoneEqual(java.lang.String str, java.lang.String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public java.lang.String metaphone(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(java.util.Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(java.util.Locale.ENGLISH).toCharArray();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(40);
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c == 'W') {
                char c2 = charArray[1];
                if (c2 == 'R') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else if (c2 == 'H') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                    stringBuffer.setCharAt(0, 'W');
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c != 'X') {
                stringBuffer.append(charArray);
            } else {
                charArray[0] = 'S';
                stringBuffer.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            stringBuffer.append(charArray, 1, charArray.length - 1);
        } else {
            stringBuffer.append(charArray);
        }
        int length = stringBuffer.length();
        while (stringBuffer2.length() < getMaxCodeLen() && i < length) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == 'C' || !c(stringBuffer, i, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i == 0) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'B':
                        if (!c(stringBuffer, i, 'M') || !a(length, i)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'C':
                        if (!c(stringBuffer, i, 'S') || a(length, i) || "EIY".indexOf(stringBuffer.charAt(i + 1)) < 0) {
                            if (!e(stringBuffer, i, "CIA")) {
                                if (!a(length, i) && "EIY".indexOf(stringBuffer.charAt(i + 1)) >= 0) {
                                    stringBuffer2.append('S');
                                    break;
                                } else if (!c(stringBuffer, i, 'S') || !b(stringBuffer, i, 'H')) {
                                    if (!b(stringBuffer, i, 'H')) {
                                        stringBuffer2.append('K');
                                        break;
                                    } else if (i != 0 || length < 3 || !d(stringBuffer, 2)) {
                                        stringBuffer2.append('X');
                                        break;
                                    } else {
                                        stringBuffer2.append('K');
                                        break;
                                    }
                                } else {
                                    stringBuffer2.append('K');
                                    break;
                                }
                            } else {
                                stringBuffer2.append('X');
                                break;
                            }
                        }
                        break;
                    case 'D':
                        if (!a(length, i + 1) && b(stringBuffer, i, 'G')) {
                            int i2 = i + 2;
                            if ("EIY".indexOf(stringBuffer.charAt(i2)) >= 0) {
                                stringBuffer2.append('J');
                                i = i2;
                                break;
                            }
                        }
                        stringBuffer2.append('T');
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        stringBuffer2.append(charAt);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if ((!a(length, i3) || !b(stringBuffer, i, 'H')) && ((a(length, i3) || !b(stringBuffer, i, 'H') || d(stringBuffer, i + 2)) && (i <= 0 || (!e(stringBuffer, i, "GN") && !e(stringBuffer, i, "GNED"))))) {
                            boolean c3 = c(stringBuffer, i, 'G');
                            if (!a(length, i) && "EIY".indexOf(stringBuffer.charAt(i3)) >= 0 && !c3) {
                                stringBuffer2.append('J');
                                break;
                            } else {
                                stringBuffer2.append('K');
                                break;
                            }
                        }
                        break;
                    case 'H':
                        if (!a(length, i) && ((i <= 0 || "CSPTG".indexOf(stringBuffer.charAt(i - 1)) < 0) && d(stringBuffer, i + 1))) {
                            stringBuffer2.append('H');
                            break;
                        }
                        break;
                    case 'K':
                        if (i <= 0) {
                            stringBuffer2.append(charAt);
                            break;
                        } else if (!c(stringBuffer, i, 'C')) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'P':
                        if (!b(stringBuffer, i, 'H')) {
                            stringBuffer2.append(charAt);
                            break;
                        } else {
                            stringBuffer2.append('F');
                            break;
                        }
                    case 'Q':
                        stringBuffer2.append('K');
                        break;
                    case 'S':
                        if (!e(stringBuffer, i, "SH") && !e(stringBuffer, i, "SIO") && !e(stringBuffer, i, "SIA")) {
                            stringBuffer2.append('S');
                            break;
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'T':
                        if (!e(stringBuffer, i, "TIA") && !e(stringBuffer, i, "TIO")) {
                            if (!e(stringBuffer, i, "TCH")) {
                                if (!e(stringBuffer, i, "TH")) {
                                    stringBuffer2.append('T');
                                    break;
                                } else {
                                    stringBuffer2.append('0');
                                    break;
                                }
                            }
                        } else {
                            stringBuffer2.append('X');
                            break;
                        }
                        break;
                    case 'V':
                        stringBuffer2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!a(length, i) && d(stringBuffer, i + 1)) {
                            stringBuffer2.append(charAt);
                            break;
                        }
                        break;
                    case 'X':
                        stringBuffer2.append('K');
                        stringBuffer2.append('S');
                        break;
                    case 'Z':
                        stringBuffer2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (stringBuffer2.length() > getMaxCodeLen()) {
                stringBuffer2.setLength(getMaxCodeLen());
            }
        }
        return stringBuffer2.toString();
    }

    public void setMaxCodeLen(int i) {
        this.a = i;
    }
}
