package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class c0 {
    public java.lang.String a = com.huawei.hms.hatool.b.i().getFilesDir().getPath();

    public static boolean b(java.io.File file) {
        java.io.File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (java.io.File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    com.huawei.hms.hatool.y.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    public static boolean d() {
        return b(new java.io.File(com.huawei.hms.hatool.b.i().getFilesDir().getPath() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "hms"));
    }

    public java.lang.String a() {
        java.lang.String b;
        java.lang.String b2;
        java.lang.String b3;
        java.lang.String b4;
        java.lang.String c = c();
        if (b()) {
            com.huawei.hms.hatool.y.c("hmsSdk", "refresh components");
            b = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(128);
            a("aprpap", b);
            b2 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(128);
            a("febdoc", b2);
            b3 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(128);
            a("marfil", b3);
            b4 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(128);
            a("maywnj", b4);
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "assemblyFlash", java.lang.System.currentTimeMillis());
        } else {
            b = b("aprpap");
            b2 = b("febdoc");
            b3 = b("marfil");
            b4 = b("maywnj");
        }
        return com.huawei.secure.android.common.encrypt.utils.HexUtil.byteArray2HexStr(com.huawei.secure.android.common.encrypt.hash.PBKDF2.pbkdf2(a(b, b2, b3, c), com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(b4), 10000, 16));
    }

    public final java.lang.String a(java.lang.String str) {
        return this.a + "/hms/component/".replace("component", str);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        java.io.File file = new java.io.File(a(str));
        java.io.File file2 = new java.io.File(a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            com.huawei.hms.hatool.y.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            com.huawei.hms.hatool.t0.a(file2, str2);
        } else {
            com.huawei.hms.hatool.y.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    public final boolean a(java.io.File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (java.io.IOException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    public final char[] a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        byte[] hexStr2ByteArray = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((hexStr2ByteArray[i] ^ hexStr2ByteArray2[i]) ^ hexStr2ByteArray3[i]) ^ hexStr2ByteArray4[i]);
        }
        return cArr;
    }

    public final java.lang.String b(java.lang.String str) {
        java.io.File file = new java.io.File(a(str), "hianalytics_" + str);
        if (a(file)) {
            return com.huawei.hms.hatool.t0.a(file);
        }
        java.lang.String generateSecureRandomStr = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(128);
        com.huawei.hms.hatool.t0.a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    public final boolean b() {
        long a = com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != a) {
            return java.lang.System.currentTimeMillis() - a > 31536000000L;
        }
        com.huawei.hms.hatool.y.c("hmsSdk", "First init components");
        return true;
    }

    public final java.lang.String c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }
}
