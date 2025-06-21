package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class ad {
    private static final char[] a = {'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'm', 'n', 'o', 'p', 'q', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 's', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static java.lang.String a() {
        java.util.Random random = new java.util.Random();
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            char[] cArr2 = a;
            cArr[i] = cArr2[random.nextInt(cArr2.length)];
        }
        return new java.lang.String(cArr);
    }

    private static java.lang.String a(java.lang.Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static java.lang.String a(java.lang.String str) {
        java.security.MessageDigest messageDigest;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        char[] cArr2 = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = digest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[b & 15];
        }
        return new java.lang.String(cArr2);
    }

    private static java.lang.String a(java.lang.String str, boolean z) {
        if (str == null) {
            return null;
        }
        return z ? str : str.concat("$GX");
    }

    private static java.lang.String a(byte[] bArr, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < i + 0; i2++) {
            sb.append(java.lang.String.format("%02X", java.lang.Byte.valueOf(bArr[i2])));
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr) {
        byte[] a2;
        if (bArr == null || (a2 = com.getui.gtc.extension.distribution.gbd.n.n.a(bArr)) == null) {
            return null;
        }
        java.lang.String a3 = a(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        int length = a2.length;
        byte[] bArr2 = new byte[length + 16];
        byte[] bytes = a3.substring(0, 8).getBytes();
        byte[] bytes2 = a3.substring(24, 32).getBytes();
        java.lang.System.arraycopy(bytes, 0, bArr2, 0, 8);
        java.lang.System.arraycopy(a2, 0, bArr2, 8, length);
        java.lang.System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    private static java.lang.String b(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                if (messageDigest == null) {
                    return "0";
                }
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        byte[] digest = messageDigest.digest();
                        java.lang.String a2 = a(digest, digest.length);
                        fileInputStream.close();
                        return a2;
                    }
                    if (read < 10240) {
                        byte[] bArr2 = new byte[read];
                        java.lang.System.arraycopy(bArr, 0, bArr2, 0, read);
                        messageDigest.update(bArr2);
                    } else {
                        messageDigest.update(bArr);
                    }
                }
            } catch (java.security.NoSuchAlgorithmException e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                return "0";
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            return "0";
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return com.getui.gtc.extension.distribution.gbd.n.n.b(bArr2);
    }

    private static java.lang.String c(java.lang.String str) {
        return str == null ? "" : str;
    }

    private static byte[] c(byte[] bArr) {
        java.security.MessageDigest messageDigest;
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.security.NoSuchAlgorithmException e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    private static boolean d(java.lang.String str) {
        if (str == null) {
            return true;
        }
        return "".equals(str);
    }
}
