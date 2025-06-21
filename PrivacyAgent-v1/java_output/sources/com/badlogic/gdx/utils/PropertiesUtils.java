package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public final class PropertiesUtils {
    public static void a(com.badlogic.gdx.utils.StringBuilder stringBuilder, java.lang.String str, boolean z, boolean z2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > '=' && charAt < 127) {
                stringBuilder.append(charAt == '\\' ? "\\\\" : java.lang.Character.valueOf(charAt));
            } else if (charAt == '\t') {
                stringBuilder.append("\\t");
            } else if (charAt == '\n') {
                stringBuilder.append("\\n");
            } else if (charAt == '\f') {
                stringBuilder.append("\\f");
            } else if (charAt == '\r') {
                stringBuilder.append("\\r");
            } else if (charAt != ' ') {
                if (charAt == '!' || charAt == '#' || charAt == ':' || charAt == '=') {
                    stringBuilder.append('\\').append(charAt);
                } else if ((charAt < ' ' || charAt > '~') && z2) {
                    java.lang.String hexString = java.lang.Integer.toHexString(charAt);
                    stringBuilder.append("\\u");
                    for (int i2 = 0; i2 < 4 - hexString.length(); i2++) {
                        stringBuilder.append('0');
                    }
                    stringBuilder.append(hexString);
                } else {
                    stringBuilder.append(charAt);
                }
            } else if (i == 0 || z) {
                stringBuilder.append("\\ ");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.String> objectMap, java.io.Writer writer, java.lang.String str, boolean z) throws java.io.IOException {
        if (str != null) {
            c(writer, str);
        }
        writer.write("#");
        writer.write(new java.util.Date().toString());
        writer.write("\n");
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(200);
        com.badlogic.gdx.utils.ObjectMap.Entries<java.lang.String, java.lang.String> it = objectMap.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
            a(stringBuilder, (java.lang.String) next.key, true, z);
            stringBuilder.append(com.alipay.sdk.m.n.a.h);
            a(stringBuilder, (java.lang.String) next.value, false, z);
            writer.write("\n");
            writer.write(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        writer.flush();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        if (r11.charAt(r4) != '!') goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(java.io.Writer writer, java.lang.String str) throws java.io.IOException {
        writer.write("#");
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > 255 || charAt == '\n' || charAt == '\r') {
                if (i2 != i) {
                    writer.write(str.substring(i2, i));
                }
                if (charAt > 255) {
                    java.lang.String hexString = java.lang.Integer.toHexString(charAt);
                    writer.write("\\u");
                    for (int i3 = 0; i3 < 4 - hexString.length(); i3++) {
                        writer.write(48);
                    }
                    writer.write(hexString);
                } else {
                    writer.write("\n");
                    if (charAt == '\r' && i != length - 1) {
                        int i4 = i + 1;
                        if (str.charAt(i4) == '\n') {
                            i = i4;
                        }
                    }
                    if (i != length - 1) {
                        int i5 = i + 1;
                        if (str.charAt(i5) != '#') {
                        }
                    }
                    writer.write("#");
                }
                i2 = i + 1;
            }
            i++;
        }
        if (i2 != i) {
            writer.write(str.substring(i2, i));
        }
        writer.write("\n");
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0127, code lost:
    
        if (r7 != 3) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void load(com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.String> objectMap, java.io.Reader reader) throws java.io.IOException {
        char c;
        if (objectMap == null) {
            throw new java.lang.NullPointerException("ObjectMap cannot be null");
        }
        if (reader == null) {
            throw new java.lang.NullPointerException("Reader cannot be null");
        }
        char[] cArr = new char[40];
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(reader);
        boolean z = true;
        int i = 0;
        int i2 = 0;
        char c2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = -1;
            boolean z2 = true;
            while (true) {
                int read = bufferedReader.read();
                if (read == -1) {
                    if (c2 == 2 && i3 <= 4) {
                        throw new java.lang.IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
                    }
                    if (i5 == -1 && i2 > 0) {
                        i5 = i2;
                    }
                    if (i5 >= 0) {
                        java.lang.String str = new java.lang.String(cArr, i, i2);
                        java.lang.String substring = str.substring(i, i5);
                        java.lang.String substring2 = str.substring(i5);
                        if (c2 == z) {
                            substring2 = substring2 + "\u0000";
                        }
                        objectMap.put(substring, substring2);
                        return;
                    }
                    return;
                }
                char c3 = (char) read;
                if (i2 == cArr.length) {
                    char[] cArr2 = new char[cArr.length * 2];
                    java.lang.System.arraycopy(cArr, i, cArr2, i, i2);
                    cArr = cArr2;
                }
                if (c2 == 2) {
                    int digit = java.lang.Character.digit(c3, 16);
                    if (digit >= 0) {
                        i4 = (i4 << 4) + digit;
                        i3++;
                        if (i3 < 4) {
                            continue;
                        }
                    } else if (i3 <= 4) {
                        throw new java.lang.IllegalArgumentException("Invalid Unicode sequence: illegal character");
                    }
                    cArr[i2] = (char) i4;
                    i2++;
                    c2 = 0;
                    if (c3 != '\n') {
                        continue;
                    }
                }
                if (c2 != z) {
                    if (c3 == '\n') {
                        if (c2 != 3) {
                            break;
                        }
                        z = true;
                        i = 0;
                        c2 = 5;
                    } else {
                        if (c3 == '\r') {
                            break;
                        }
                        if (c3 == '!' || c3 == '#') {
                            if (z2) {
                                do {
                                    int read2 = bufferedReader.read();
                                    if (read2 == -1 || (c = (char) read2) == '\r') {
                                        break;
                                    }
                                } while (c != '\n');
                                z = true;
                                i = 0;
                            }
                        } else if (c3 == ':' || c3 == '=') {
                            if (i5 == -1) {
                                i5 = i2;
                                z = true;
                                i = 0;
                                c2 = 0;
                            }
                        } else if (c3 == '\\') {
                            if (c2 == 4) {
                                i5 = i2;
                            }
                            z = true;
                            i = 0;
                            c2 = 1;
                        }
                        if (java.lang.Character.isSpace(c3)) {
                            if (c2 == 3) {
                                c2 = 5;
                            }
                            if (i2 != 0 && i2 != i5 && c2 != 5) {
                                if (i5 == -1) {
                                    z = true;
                                    i = 0;
                                    c2 = 4;
                                }
                            }
                            z = true;
                            i = 0;
                        }
                        if (c2 != 5) {
                        }
                        c2 = 0;
                    }
                } else if (c3 == '\n') {
                    i = 0;
                    c2 = 5;
                } else if (c3 != '\r') {
                    if (c3 == 'b') {
                        c3 = '\b';
                    } else if (c3 == 'f') {
                        c3 = '\f';
                    } else if (c3 == 'n') {
                        c3 = '\n';
                    } else if (c3 == 'r') {
                        c3 = '\r';
                    } else if (c3 == 't') {
                        c3 = '\t';
                    } else if (c3 == 'u') {
                        i = 0;
                        c2 = 2;
                        i3 = 0;
                        i4 = 0;
                    }
                    c2 = 0;
                } else {
                    i = 0;
                    c2 = 3;
                }
                if (c2 == 4) {
                    i5 = i2;
                    c2 = 0;
                }
                cArr[i2] = c3;
                i2++;
                z = true;
                i = 0;
                z2 = false;
            }
            if (i2 > 0 || (i2 == 0 && i5 == 0)) {
                if (i5 == -1) {
                    i5 = i2;
                }
                i = 0;
                java.lang.String str2 = new java.lang.String(cArr, 0, i2);
                objectMap.put(str2.substring(0, i5), str2.substring(i5));
            } else {
                i = 0;
            }
            z = true;
            i2 = 0;
            c2 = 0;
        }
    }

    public static void store(com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.String> objectMap, java.io.Writer writer, java.lang.String str) throws java.io.IOException {
        b(objectMap, writer, str, false);
    }
}
