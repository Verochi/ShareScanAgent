package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class ZipUtils {
    private static final int CACHE_SIZE = 1024;

    public static void unZip(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str);
        java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
        byte[] bArr = new byte[1024];
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (entries.hasMoreElements()) {
            java.util.zip.ZipEntry nextElement = entries.nextElement();
            java.lang.String substring = nextElement.getName().contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) ? nextElement.getName().substring(nextElement.getName().lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR), nextElement.getName().length()) : nextElement.getName();
            if (nextElement.isDirectory()) {
                new java.io.File(str2 + substring).mkdirs();
            } else {
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(zipFile.getInputStream(nextElement));
                stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(str2);
                stringBuffer.append(java.io.File.separator);
                stringBuffer.append(substring);
                java.io.File file = new java.io.File(stringBuffer.toString());
                java.io.File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream, 1024);
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileOutputStream.close();
                bufferedInputStream.close();
            }
        }
        zipFile.close();
    }

    public static void zip(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str2);
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(bufferedOutputStream);
        java.io.File file = new java.io.File(str);
        zipFile(file, file.isDirectory() ? file.getPath() : file.getParent(), zipOutputStream);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        bufferedOutputStream.close();
        fileOutputStream.close();
    }

    private static void zipFile(java.io.File file, java.lang.String str, java.util.zip.ZipOutputStream zipOutputStream) throws java.lang.Exception {
        byte[] bArr = new byte[1024];
        for (java.io.File file2 : file.isDirectory() ? file.listFiles() : new java.io.File[]{file}) {
            if (file2.isDirectory()) {
                zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(file2.getPath().substring(str.length() + 1) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR));
                zipFile(file2, str, zipOutputStream);
            } else {
                java.lang.String substring = file2.getPath().substring(str.length() + 1);
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(fileInputStream);
                zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(substring));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    } else {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
                fileInputStream.close();
            }
        }
    }
}
