package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public class c {
    private static final java.lang.String b = "c";
    private static char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -1, -1, -1, -1, -1, -1, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, -1, -1, -1, -1, -1};
    public static java.lang.String a = "";
    private static java.lang.String g = "";
    private static java.util.Map<java.lang.Character, java.lang.Character> d = new java.util.HashMap();
    private static java.util.Map<java.lang.Character, java.lang.Character> c = new java.util.HashMap();

    private c() {
    }

    private static java.lang.Character a(char c2) {
        if (d == null) {
            d = new java.util.HashMap();
            for (int i = 0; i < a.length(); i++) {
                d.put(java.lang.Character.valueOf(g.charAt(i)), java.lang.Character.valueOf(a.charAt(i)));
            }
        }
        return d.containsKey(java.lang.Character.valueOf(c2)) ? d.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2);
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2 = "";
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            char[] charArray = str.toCharArray();
            if (charArray != null && charArray.length > 0) {
                char[] cArr = new char[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    char c2 = charArray[i];
                    if (d == null) {
                        d = new java.util.HashMap();
                        for (int i2 = 0; i2 < a.length(); i2++) {
                            d.put(java.lang.Character.valueOf(g.charAt(i2)), java.lang.Character.valueOf(a.charAt(i2)));
                        }
                    }
                    cArr[i] = (d.containsKey(java.lang.Character.valueOf(c2)) ? d.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2)).charValue();
                }
                str2 = new java.lang.String(cArr);
            }
            return new java.lang.String(d(str2));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static java.lang.String a(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(e[i3 >>> 2]);
                stringBuffer.append(e[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(e[i3 >>> 2]);
                stringBuffer.append(e[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(e[(i5 & 15) << 2]);
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            stringBuffer.append(e[i3 >>> 2]);
            stringBuffer.append(e[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(e[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(e[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }

    private static java.lang.Character b(char c2) {
        if (c == null) {
            c = new java.util.HashMap();
            for (int i = 0; i < a.length(); i++) {
                c.put(java.lang.Character.valueOf(a.charAt(i)), java.lang.Character.valueOf(g.charAt(i)));
            }
        }
        return c.containsKey(java.lang.Character.valueOf(c2)) ? c.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2);
    }

    public static java.lang.String b(java.lang.String str) {
        char[] charArray;
        try {
            if (android.text.TextUtils.isEmpty(str) || (charArray = a(str.getBytes()).toCharArray()) == null || charArray.length <= 0) {
                return "";
            }
            char[] cArr = new char[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                char c2 = charArray[i];
                if (c == null) {
                    c = new java.util.HashMap();
                    for (int i2 = 0; i2 < a.length(); i2++) {
                        c.put(java.lang.Character.valueOf(a.charAt(i2)), java.lang.Character.valueOf(g.charAt(i2)));
                    }
                }
                cArr[i] = (c.containsKey(java.lang.Character.valueOf(c2)) ? c.get(java.lang.Character.valueOf(c2)) : java.lang.Character.valueOf(c2)).charValue();
            }
            return new java.lang.String(cArr);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void c(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("k");
            java.lang.String optString2 = jSONObject.optString("v");
            if (android.text.TextUtils.isEmpty(optString) || android.text.TextUtils.isEmpty(optString2)) {
                return;
            }
            a = optString;
            g = optString2;
            for (int i = 0; i < a.length(); i++) {
                d.put(java.lang.Character.valueOf(g.charAt(i)), java.lang.Character.valueOf(a.charAt(i)));
            }
            for (int i2 = 0; i2 < a.length(); i2++) {
                c.put(java.lang.Character.valueOf(a.charAt(i2)), java.lang.Character.valueOf(g.charAt(i2)));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static byte[] d(java.lang.String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(length);
        int i5 = 0;
        while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b2 = f[bytes[i5]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i5 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = f[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & org.apache.tools.tar.TarConstants.LF_NORMAL) >>> 4));
            while (true) {
                i3 = i2 + 1;
                byte b6 = bytes[i2];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = f[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b5 = f[b7];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
            i5 = i4;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
