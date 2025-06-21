package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class ZipUtils implements com.alimm.tanx.core.utils.NotConfused {
    public static void main(java.lang.String[] strArr) throws java.lang.Exception {
        unZip("D:/test.zip", "D:/a");
    }

    private static void mkdir(java.io.File file) {
        if (file == null || file.exists()) {
            return;
        }
        mkdir(file.getParentFile());
        file.mkdir();
    }

    public static void unZip(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.io.File file = new java.io.File(str2);
        if (!file.exists() && !file.mkdir()) {
            throw new java.lang.Exception("创建解压目标文件夹失败");
        }
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.FileInputStream(str));
        for (java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            if (nextEntry.isDirectory()) {
                mkdir(new java.io.File(str2 + java.io.File.separator + nextEntry.getName()));
            } else {
                java.lang.String str3 = str2 + java.io.File.separator + nextEntry.getName();
                mkdir(new java.io.File(str3).getParentFile());
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(str3));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.close();
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
    }
}
