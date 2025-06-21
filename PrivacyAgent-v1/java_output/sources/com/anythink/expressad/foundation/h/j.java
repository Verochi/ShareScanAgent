package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public class j {
    private static final java.lang.String a = "j";
    private static java.util.Map<java.lang.Character, java.lang.Character> b;
    private static java.util.Map<java.lang.Character, java.lang.Character> c;
    private static char[] d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, org.apache.tools.tar.TarConstants.LF_BLK, org.apache.tools.tar.TarConstants.LF_DIR, org.apache.tools.tar.TarConstants.LF_FIFO, org.apache.tools.tar.TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, com.google.common.base.Ascii.DC2, 19, com.google.common.base.Ascii.DC4, com.google.common.base.Ascii.NAK, com.google.common.base.Ascii.SYN, com.google.common.base.Ascii.ETB, com.google.common.base.Ascii.CAN, com.google.common.base.Ascii.EM, -1, -1, -1, -1, -1, -1, com.google.common.base.Ascii.SUB, com.google.common.base.Ascii.ESC, com.google.common.base.Ascii.FS, com.google.common.base.Ascii.GS, com.google.common.base.Ascii.RS, com.google.common.base.Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, org.apache.tools.tar.TarConstants.LF_NORMAL, org.apache.tools.tar.TarConstants.LF_LINK, org.apache.tools.tar.TarConstants.LF_SYMLINK, org.apache.tools.tar.TarConstants.LF_CHR, -1, -1, -1, -1, -1};

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        c = hashMap;
        hashMap.put('v', 'A');
        c.put('S', 'B');
        c.put('o', 'C');
        c.put('a', 'D');
        c.put('j', 'E');
        c.put('c', 'F');
        c.put('7', 'G');
        c.put('d', 'H');
        c.put('R', 'I');
        c.put('z', 'J');
        c.put('p', 'K');
        c.put('W', 'L');
        c.put('i', 'M');
        c.put('f', 'N');
        c.put('G', 'O');
        c.put('y', 'P');
        c.put('N', 'Q');
        c.put('x', 'R');
        c.put('Z', 'S');
        c.put('n', 'T');
        c.put('V', 'U');
        c.put('5', 'V');
        c.put('k', 'W');
        c.put('+', 'X');
        c.put('D', 'Y');
        c.put('H', 'Z');
        c.put('L', 'a');
        c.put('Y', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM));
        c.put('h', 'c');
        c.put('J', 'd');
        c.put('4', 'e');
        c.put('6', 'f');
        c.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT), 'g');
        c.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP), 'h');
        c.put('0', 'i');
        c.put('U', 'j');
        c.put('3', 'k');
        c.put('Q', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT));
        c.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT), 'm');
        c.put('g', 'n');
        c.put('E', 'o');
        c.put('u', 'p');
        c.put('q', 'q');
        c.put('8', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT));
        c.put('s', 's');
        c.put('w', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP));
        c.put('/', 'u');
        c.put('X', 'v');
        c.put('M', 'w');
        c.put('e', 'x');
        c.put('B', 'y');
        c.put('A', 'z');
        c.put('T', '0');
        c.put('2', '1');
        c.put('F', '2');
        c.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM), '3');
        c.put('9', '4');
        c.put('P', '5');
        c.put('1', '6');
        c.put('O', '7');
        c.put('I', '8');
        c.put('K', '9');
        c.put('m', '+');
        c.put('C', '/');
        java.util.HashMap hashMap2 = new java.util.HashMap();
        b = hashMap2;
        hashMap2.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM), 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT));
        b.put('h', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP));
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT), 'Q');
        b.put('m', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT));
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', 'u');
        b.put('q', 'q');
        b.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT), '8');
        b.put('s', 's');
        b.put(java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP), 'w');
        b.put('u', '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', java.lang.Character.valueOf(com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM));
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
    }

    private j() {
    }

    public static java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : com.anythink.expressad.foundation.h.q.b(str);
    }

    private static java.lang.String a(byte[] bArr) {
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
                stringBuffer.append(d[i3 >>> 2]);
                stringBuffer.append(d[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(d[i3 >>> 2]);
                stringBuffer.append(d[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(d[(i5 & 15) << 2]);
                stringBuffer.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            stringBuffer.append(d[i3 >>> 2]);
            stringBuffer.append(d[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(d[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(d[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }

    public static java.lang.String b(java.lang.String str) {
        return com.anythink.expressad.foundation.h.q.a(str);
    }

    private static byte[] c(java.lang.String str) {
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
                b2 = e[bytes[i5]];
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
                b3 = e[bytes[i]];
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
                b4 = e[b6];
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
                b5 = e[b7];
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
