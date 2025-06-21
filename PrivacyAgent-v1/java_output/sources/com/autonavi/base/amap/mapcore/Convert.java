package com.autonavi.base.amap.mapcore;

/* loaded from: classes12.dex */
public class Convert {
    public static final java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length);
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static void convert1bString(byte[] bArr, int i, com.autonavi.base.amap.mapcore.ConvertString convertString) {
        try {
            byte b = bArr[i];
            convertString.byteLength = b;
            convertString.value = new java.lang.String(bArr, i + 1, b, "UTF-8");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void convert2bString(byte[] bArr, int i, com.autonavi.base.amap.mapcore.ConvertString convertString) {
        try {
            short s2 = getShort(bArr, i);
            convertString.byteLength = s2;
            convertString.value = new java.lang.String(bArr, i + 2, s2, "UTF-8");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static double convertDouble(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j += (bArr[i2 + i] & 255) << (i2 * 8);
        }
        return java.lang.Double.longBitsToDouble(j);
    }

    public static byte[] convertInt(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] convertShort(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static byte[] copyString(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] covertBytes(byte b) {
        return new byte[]{b};
    }

    public static byte[] get1BString(java.lang.String str) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static byte[] get2BString(java.lang.String str) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b, int i) {
        int i2 = 32 - i;
        return (((b << i2) >>> i2) >>> (i - 1)) > 0;
    }

    public static byte[] getDouble(double d) {
        byte[] bArr = new byte[8];
        java.lang.String hexString = java.lang.Long.toHexString(java.lang.Double.doubleToLongBits(d));
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            bArr[7 - i] = (byte) java.lang.Integer.parseInt(hexString.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static int getInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static int getNum(byte b, int i, int i2) {
        int i3 = (32 - i2) - 1;
        return ((b << i3) >>> i3) >>> i;
    }

    public static int getNum(short s2, int i, int i2) {
        int i3 = 32 - i2;
        return ((s2 << i3) >>> i3) >>> (i - 1);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0));
    }

    public static java.lang.String getString(byte[] bArr, int i, int i2) {
        try {
            return new java.lang.String(bArr, i, i2, "UTF-8");
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = new byte[i3];
        java.lang.System.arraycopy(bArr, i, bArr3, 0, i3);
        java.lang.System.arraycopy(bArr3, 0, bArr2, i2, i3);
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        java.lang.System.arraycopy(convertInt(i2), 0, bArr, i, 4);
    }

    public static void writeShort(byte[] bArr, int i, short s2) {
        java.lang.System.arraycopy(convertShort(s2), 0, bArr, i, 2);
    }
}
