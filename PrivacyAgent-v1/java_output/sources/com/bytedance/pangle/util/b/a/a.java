package com.bytedance.pangle.util.b.a;

/* loaded from: classes.dex */
public final class a {
    public static com.bytedance.pangle.util.b.b.d a(java.lang.String str) {
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(str, "r");
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new java.io.IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                com.bytedance.pangle.util.b.b.d dVar = new com.bytedance.pangle.util.b.b.d(str);
                long length = randomAccessFile2.length();
                if (length < 22) {
                    throw new java.io.IOException("Zip file size less than size of zip headers. Probably not a zip file.");
                }
                long j = length - 22;
                randomAccessFile2.seek(j);
                if (dVar.c.a(randomAccessFile2) != net.lingala.zip4j.util.InternalZipConstants.ENDSIG) {
                    j = b(randomAccessFile2, dVar);
                }
                randomAccessFile2.seek(j + 4);
                com.bytedance.pangle.util.b.b.b bVar = new com.bytedance.pangle.util.b.b.b();
                randomAccessFile2.skipBytes(6);
                bVar.a = dVar.c.b(randomAccessFile2);
                randomAccessFile2.skipBytes(4);
                bVar.b = dVar.c.a(randomAccessFile2);
                dVar.b = bVar;
                if (bVar.a == 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (java.io.IOException unused) {
                    }
                    return dVar;
                }
                a(randomAccessFile2, dVar);
                try {
                    randomAccessFile2.close();
                } catch (java.io.IOException unused2) {
                }
                return dVar;
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static void a(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.util.b.b.d dVar) {
        com.bytedance.pangle.util.b.b.a aVar = new com.bytedance.pangle.util.b.b.a();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.bytedance.pangle.util.b.b.b bVar = dVar.b;
        long j = bVar.b;
        long j2 = bVar.a;
        randomAccessFile.seek(j);
        for (int i = 0; i < j2; i++) {
            com.bytedance.pangle.util.b.b.c cVar = new com.bytedance.pangle.util.b.b.c();
            if (dVar.c.a(randomAccessFile) != net.lingala.zip4j.util.InternalZipConstants.CENSIG) {
                throw new java.io.IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            cVar.a = dVar.c.b(randomAccessFile);
            randomAccessFile.skipBytes(4);
            cVar.b = dVar.c.a(randomAccessFile);
            cVar.c = dVar.c.a(randomAccessFile);
            cVar.d = dVar.c.a(randomAccessFile);
            int b = dVar.c.b(randomAccessFile);
            cVar.e = b;
            cVar.f = dVar.c.b(randomAccessFile);
            int b2 = dVar.c.b(randomAccessFile);
            randomAccessFile.skipBytes(8);
            cVar.i = dVar.c.a(randomAccessFile);
            if (b <= 0) {
                throw new java.io.IOException("Invalid entry name in file header");
            }
            byte[] bArr = new byte[b];
            randomAccessFile.readFully(bArr);
            cVar.h = new java.lang.String(bArr, java.nio.charset.Charset.forName("UTF-8"));
            randomAccessFile.skipBytes(cVar.f);
            if (b2 > 0) {
                randomAccessFile.skipBytes(b2);
            }
            long filePointer = randomAccessFile.getFilePointer();
            randomAccessFile.seek(cVar.i + 28);
            cVar.g = dVar.c.b(randomAccessFile);
            randomAccessFile.seek(filePointer);
            arrayList.add(cVar);
        }
        aVar.a = arrayList;
        dVar.a = aVar;
    }

    private static long b(java.io.RandomAccessFile randomAccessFile, com.bytedance.pangle.util.b.b.d dVar) {
        long length = randomAccessFile.length() - 22;
        for (long length2 = randomAccessFile.length() < 65536 ? randomAccessFile.length() : 65536L; length2 > 0 && length > 0; length2--) {
            length--;
            randomAccessFile.seek(length);
            if (dVar.c.a(randomAccessFile) == net.lingala.zip4j.util.InternalZipConstants.ENDSIG) {
                return length;
            }
        }
        throw new java.io.IOException("Zip headers not found. Probably not a zip file");
    }
}
