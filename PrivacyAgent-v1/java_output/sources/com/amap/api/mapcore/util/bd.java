package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class bd {

    public interface a {
        void a();

        void a(float f);

        void b();
    }

    private static float a(long j, long j2) {
        return (j / j2) * 100.0f;
    }

    public final long a(java.io.File file, java.io.File file2, long j, long j2, com.amap.api.mapcore.util.bd.a aVar) {
        long j3;
        if (j == 0) {
            if (aVar != null) {
                aVar.b();
            }
            return 0L;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
        try {
            if (file.isDirectory()) {
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new java.io.IOException("Cannot create dir " + file2.getAbsolutePath());
                }
                java.lang.String[] list = file.list();
                j3 = j;
                if (list == null) {
                    return j3;
                }
                int i = 0;
                while (i < list.length) {
                    try {
                        int i2 = i;
                        j3 = a(new java.io.File(file, list[i]), new java.io.File(new java.io.File(file2, file.getName()), list[i]), j3, j2, aVar);
                        i = i2 + 1;
                    } catch (java.lang.Exception e) {
                        e = e;
                    }
                }
                return j3;
            }
            java.io.File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new java.io.IOException("Cannot create dir " + parentFile.getAbsolutePath());
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j4 = j;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    j4 += read;
                    if (aVar != null) {
                        aVar.a(a(j4, j2));
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    j3 = j4;
                }
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            if (aVar != null && j4 >= j2 - 1) {
                aVar.a();
            }
            return j4;
        } catch (java.lang.Exception e3) {
            e = e3;
            j3 = j;
        }
        e.printStackTrace();
        if (aVar == null) {
            return j3;
        }
        aVar.b();
        return j3;
    }
}
