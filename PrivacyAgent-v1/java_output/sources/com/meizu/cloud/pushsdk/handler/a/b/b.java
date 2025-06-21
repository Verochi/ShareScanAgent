package com.meizu.cloud.pushsdk.handler.a.b;

/* loaded from: classes23.dex */
public class b {
    private final java.io.File a;

    public b(java.lang.String str) {
        this.a = new java.io.File(str);
    }

    private void a(java.io.File file, java.util.zip.ZipOutputStream zipOutputStream, java.lang.String str) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : java.io.File.separator);
        sb.append(file.getName());
        java.lang.String sb2 = sb.toString();
        if (file.isDirectory()) {
            java.io.File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (java.io.File file2 : listFiles) {
                a(file2, zipOutputStream, sb2);
            }
            return;
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("ZipTask", "current file " + sb2 + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + file.getName() + " size is " + (file.length() / 1024) + "KB");
        if (file.length() >= 10485760) {
            return;
        }
        byte[] bArr = new byte[1048576];
        java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(sb2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    private void a(java.util.Collection<java.io.File> collection, java.io.File file) throws java.lang.Exception {
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(file), 1048576));
        java.util.Iterator<java.io.File> it = collection.iterator();
        while (it.hasNext()) {
            a(it.next(), zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public void a(java.util.List<java.lang.String> list) throws java.lang.Exception {
        if (!this.a.exists()) {
            this.a.getParentFile().mkdirs();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String absolutePath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            java.io.File file = new java.io.File(absolutePath + it.next());
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        a(arrayList, this.a);
    }
}
