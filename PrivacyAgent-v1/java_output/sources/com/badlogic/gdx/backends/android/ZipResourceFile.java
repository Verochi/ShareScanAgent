package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class ZipResourceFile {
    public java.util.HashMap<java.lang.String, com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO> a = new java.util.HashMap<>();
    public java.util.HashMap<java.io.File, java.util.zip.ZipFile> mZipFiles = new java.util.HashMap<>();
    public java.nio.ByteBuffer b = java.nio.ByteBuffer.allocate(4);

    public static final class ZipEntryRO {
        public long mCRC32;
        public long mCompressedLength;
        public final java.io.File mFile;
        public final java.lang.String mFileName;
        public long mLocalHdrOffset;
        public int mMethod;
        public long mOffset = -1;
        public long mUncompressedLength;
        public long mWhenModified;
        public final java.lang.String mZipFileName;

        public ZipEntryRO(java.lang.String str, java.io.File file, java.lang.String str2) {
            this.mFileName = str2;
            this.mZipFileName = str;
            this.mFile = file;
        }

        public android.content.res.AssetFileDescriptor getAssetFileDescriptor() {
            if (this.mMethod != 0) {
                return null;
            }
            try {
                return new android.content.res.AssetFileDescriptor(android.os.ParcelFileDescriptor.open(this.mFile, 268435456), getOffset(), this.mUncompressedLength);
            } catch (java.io.FileNotFoundException unused) {
                return null;
            }
        }

        public long getOffset() {
            return this.mOffset;
        }

        public java.io.File getZipFile() {
            return this.mFile;
        }

        public java.lang.String getZipFileName() {
            return this.mZipFileName;
        }

        public boolean isUncompressed() {
            return this.mMethod == 0;
        }

        public void setOffsetFromFile(java.io.RandomAccessFile randomAccessFile, java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
            long j = this.mLocalHdrOffset;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) != 67324752) {
                    throw new java.io.IOException();
                }
                this.mOffset = j + 30 + (byteBuffer.getShort(26) & kotlin.UShort.MAX_VALUE) + (byteBuffer.getShort(28) & kotlin.UShort.MAX_VALUE);
            } catch (java.io.FileNotFoundException | java.io.IOException unused) {
            }
        }
    }

    public ZipResourceFile(java.lang.String str) throws java.io.IOException {
        a(str);
    }

    public static int c(java.io.RandomAccessFile randomAccessFile) throws java.io.EOFException, java.io.IOException {
        return d(randomAccessFile.readInt());
    }

    public static int d(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    public void a(java.lang.String str) throws java.io.IOException {
        java.lang.String str2 = str;
        java.io.File file = new java.io.File(str2);
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length < 22) {
            randomAccessFile.close();
            throw new java.io.IOException();
        }
        long j = 65557 > length ? length : 65557L;
        randomAccessFile.seek(0L);
        int c = c(randomAccessFile);
        if (c == 101010256) {
            throw new java.io.IOException();
        }
        if (c != 67324752) {
            throw new java.io.IOException();
        }
        randomAccessFile.seek(length - j);
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate((int) j);
        byte[] array = allocate.array();
        randomAccessFile.readFully(array);
        allocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        int length2 = array.length - 22;
        while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
            length2--;
        }
        if (length2 < 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Zip: EOCD not found, ");
            sb.append(str2);
            sb.append(" is not zip");
        }
        short s2 = allocate.getShort(length2 + 8);
        long j2 = allocate.getInt(length2 + 12) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        long j3 = allocate.getInt(length2 + 16) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
        if (j3 + j2 > length) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("bad offsets (dir ");
            sb2.append(j3);
            sb2.append(", size ");
            sb2.append(j2);
            sb2.append(", eocd ");
            sb2.append(length2);
            sb2.append(")");
            throw new java.io.IOException();
        }
        if (s2 == 0) {
            throw new java.io.IOException();
        }
        java.nio.MappedByteBuffer map = randomAccessFile.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, j3, j2);
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        map.order(byteOrder);
        short s3 = kotlin.UShort.MAX_VALUE;
        byte[] bArr = new byte[65535];
        java.nio.ByteBuffer allocate2 = java.nio.ByteBuffer.allocate(30);
        allocate2.order(byteOrder);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < s2) {
            if (map.getInt(i3) != 33639248) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("Missed a central dir sig (at ");
                sb3.append(i3);
                sb3.append(")");
                throw new java.io.IOException();
            }
            int i4 = map.getShort(i3 + 28) & s3;
            int i5 = map.getShort(i3 + 30) & s3;
            int i6 = map.getShort(i3 + 32) & s3;
            map.position(i3 + 46);
            map.get(bArr, i, i4);
            map.position(i);
            java.lang.String str3 = new java.lang.String(bArr, i, i4);
            com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO = new com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO(str2, file, str3);
            zipEntryRO.mMethod = map.getShort(i3 + 10) & s3;
            zipEntryRO.mWhenModified = map.getInt(i3 + 12) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            zipEntryRO.mCRC32 = map.getLong(i3 + 16) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            zipEntryRO.mCompressedLength = map.getLong(i3 + 20) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            zipEntryRO.mUncompressedLength = map.getLong(i3 + 24) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            zipEntryRO.mLocalHdrOffset = map.getInt(i3 + 42) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT;
            allocate2.clear();
            zipEntryRO.setOffsetFromFile(randomAccessFile, allocate2);
            this.a.put(str3, zipEntryRO);
            i3 += i4 + 46 + i5 + i6;
            i2++;
            str2 = str;
            bArr = bArr;
            i = 0;
            s3 = kotlin.UShort.MAX_VALUE;
        }
    }

    public com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] b(java.lang.String str) {
        java.util.Vector vector = new java.util.Vector();
        java.util.Collection<com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO> values = this.a.values();
        if (str == null) {
            str = "";
        }
        int length = str.length();
        for (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO : values) {
            if (zipEntryRO.mFileName.startsWith(str) && -1 == zipEntryRO.mFileName.indexOf(47, length)) {
                vector.add(zipEntryRO);
            }
        }
        return (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[]) vector.toArray(new com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[vector.size()]);
    }

    public com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[] getAllEntries() {
        java.util.Collection<com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO> values = this.a.values();
        return (com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[]) values.toArray(new com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO[values.size()]);
    }

    public android.content.res.AssetFileDescriptor getAssetFileDescriptor(java.lang.String str) {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO = this.a.get(str);
        if (zipEntryRO != null) {
            return zipEntryRO.getAssetFileDescriptor();
        }
        return null;
    }

    public java.io.InputStream getInputStream(java.lang.String str) throws java.io.IOException {
        com.badlogic.gdx.backends.android.ZipResourceFile.ZipEntryRO zipEntryRO = this.a.get(str);
        if (zipEntryRO == null) {
            return null;
        }
        if (zipEntryRO.isUncompressed()) {
            return zipEntryRO.getAssetFileDescriptor().createInputStream();
        }
        java.util.zip.ZipFile zipFile = this.mZipFiles.get(zipEntryRO.getZipFile());
        if (zipFile == null) {
            zipFile = new java.util.zip.ZipFile(zipEntryRO.getZipFile(), 1);
            this.mZipFiles.put(zipEntryRO.getZipFile(), zipFile);
        }
        java.util.zip.ZipEntry entry = zipFile.getEntry(str);
        if (entry != null) {
            return zipFile.getInputStream(entry);
        }
        return null;
    }
}
