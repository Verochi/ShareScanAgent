package net.lingala.zip4j.unzip;

/* loaded from: classes23.dex */
public class UnzipEngine {
    public net.lingala.zip4j.model.ZipModel a;
    public net.lingala.zip4j.model.FileHeader b;
    public int c = 0;
    public net.lingala.zip4j.model.LocalFileHeader d;
    public net.lingala.zip4j.crypto.IDecrypter e;
    public java.util.zip.CRC32 f;

    public UnzipEngine(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.a = zipModel;
        this.b = fileHeader;
        this.f = new java.util.zip.CRC32();
    }

    public final int a(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord) throws net.lingala.zip4j.exception.ZipException {
        if (aESExtraDataRecord == null) {
            throw new net.lingala.zip4j.exception.ZipException("unable to determine salt length: AESExtraDataRecord is null");
        }
        int aesStrength = aESExtraDataRecord.getAesStrength();
        if (aesStrength == 1) {
            return 8;
        }
        if (aesStrength == 2) {
            return 12;
        }
        if (aesStrength == 3) {
            return 16;
        }
        throw new net.lingala.zip4j.exception.ZipException("unable to determine salt length: invalid aes key strength");
    }

    public final boolean b() throws net.lingala.zip4j.exception.ZipException {
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            try {
                java.io.RandomAccessFile c = c();
                if (c == null) {
                    c = new java.io.RandomAccessFile(new java.io.File(this.a.getZipFile()), "r");
                }
                net.lingala.zip4j.model.LocalFileHeader readLocalFileHeader = new net.lingala.zip4j.core.HeaderReader(c).readLocalFileHeader(this.b);
                this.d = readLocalFileHeader;
                if (readLocalFileHeader == null) {
                    throw new net.lingala.zip4j.exception.ZipException("error reading local file header. Is this a valid zip file?");
                }
                if (readLocalFileHeader.getCompressionMethod() != this.b.getCompressionMethod()) {
                    try {
                        c.close();
                        return false;
                    } catch (java.io.IOException | java.lang.Exception unused) {
                        return false;
                    }
                }
                try {
                    c.close();
                    return true;
                } catch (java.io.IOException | java.lang.Exception unused2) {
                    return true;
                }
            } catch (java.io.FileNotFoundException e) {
                throw new net.lingala.zip4j.exception.ZipException(e);
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException | java.lang.Exception unused3) {
                }
            }
            throw th;
        }
    }

    public final java.io.RandomAccessFile c() throws net.lingala.zip4j.exception.ZipException {
        java.lang.String str;
        if (!this.a.isSplitArchive()) {
            return null;
        }
        int diskNumberStart = this.b.getDiskNumberStart();
        int i = diskNumberStart + 1;
        this.c = i;
        java.lang.String zipFile = this.a.getZipFile();
        if (diskNumberStart == this.a.getEndCentralDirRecord().getNoOfThisDisk()) {
            str = this.a.getZipFile();
        } else if (diskNumberStart >= 9) {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + i;
        } else {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + i;
        }
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
            if (this.c == 1) {
                randomAccessFile.read(new byte[4]);
                if (net.lingala.zip4j.util.Raw.readIntLittleEndian(r0, 0) != 134695760) {
                    throw new net.lingala.zip4j.exception.ZipException("invalid first part split file signature");
                }
            }
            return randomAccessFile;
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.io.IOException e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public void checkCRC() throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeader = this.b;
        if (fileHeader != null) {
            if (fileHeader.getEncryptionMethod() != 99) {
                if ((this.f.getValue() & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) != this.b.getCrc32()) {
                    java.lang.String str = "invalid CRC for file: " + this.b.getFileName();
                    if (this.d.isEncrypted() && this.d.getEncryptionMethod() == 0) {
                        str = str + " - Wrong Password?";
                    }
                    throw new net.lingala.zip4j.exception.ZipException(str);
                }
                return;
            }
            net.lingala.zip4j.crypto.IDecrypter iDecrypter = this.e;
            if (iDecrypter == null || !(iDecrypter instanceof net.lingala.zip4j.crypto.AESDecrypter)) {
                return;
            }
            byte[] calculatedAuthenticationBytes = ((net.lingala.zip4j.crypto.AESDecrypter) iDecrypter).getCalculatedAuthenticationBytes();
            byte[] storedMac = ((net.lingala.zip4j.crypto.AESDecrypter) this.e).getStoredMac();
            byte[] bArr = new byte[10];
            if (storedMac == null) {
                throw new net.lingala.zip4j.exception.ZipException("CRC (MAC) check failed for " + this.b.getFileName());
            }
            java.lang.System.arraycopy(calculatedAuthenticationBytes, 0, bArr, 0, 10);
            if (java.util.Arrays.equals(bArr, storedMac)) {
                return;
            }
            throw new net.lingala.zip4j.exception.ZipException("invalid CRC (MAC) for file: " + this.b.getFileName());
        }
    }

    public final void d(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException {
        if (inputStream != null) {
            try {
                try {
                    inputStream.close();
                } catch (java.io.IOException e) {
                    if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(e.getMessage()) && e.getMessage().indexOf(" - Wrong Password?") >= 0) {
                        throw new net.lingala.zip4j.exception.ZipException(e.getMessage());
                    }
                    return;
                }
            } catch (java.lang.Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                throw th;
            }
        }
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (java.io.IOException unused2) {
        }
    }

    public final java.io.RandomAccessFile e(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.ZipModel zipModel = this.a;
        if (zipModel == null || !net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new net.lingala.zip4j.exception.ZipException("input parameter is null in getFilePointer");
        }
        try {
            return this.a.isSplitArchive() ? c() : new java.io.RandomAccessFile(new java.io.File(this.a.getZipFile()), str);
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final byte[] f(java.io.RandomAccessFile randomAccessFile) throws net.lingala.zip4j.exception.ZipException {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final byte[] g(java.io.RandomAccessFile randomAccessFile) throws net.lingala.zip4j.exception.ZipException {
        if (this.d.getAesExtraDataRecord() == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[a(this.d.getAesExtraDataRecord())];
            randomAccessFile.seek(this.d.getOffsetStartOfData());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public net.lingala.zip4j.crypto.IDecrypter getDecrypter() {
        return this.e;
    }

    public net.lingala.zip4j.model.FileHeader getFileHeader() {
        return this.b;
    }

    public net.lingala.zip4j.io.ZipInputStream getInputStream() throws net.lingala.zip4j.exception.ZipException {
        long j;
        if (this.b == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null, cannot get inputstream");
        }
        java.io.RandomAccessFile randomAccessFile = null;
        try {
            java.io.RandomAccessFile e = e("r");
            if (!b()) {
                throw new net.lingala.zip4j.exception.ZipException("local header and file header do not match");
            }
            k(e);
            long compressedSize = this.d.getCompressedSize();
            long offsetStartOfData = this.d.getOffsetStartOfData();
            if (this.d.isEncrypted()) {
                if (this.d.getEncryptionMethod() == 99) {
                    if (!(this.e instanceof net.lingala.zip4j.crypto.AESDecrypter)) {
                        throw new net.lingala.zip4j.exception.ZipException("invalid decryptor when trying to calculate compressed size for AES encrypted file: " + this.b.getFileName());
                    }
                    compressedSize -= (((net.lingala.zip4j.crypto.AESDecrypter) r5).getSaltLength() + ((net.lingala.zip4j.crypto.AESDecrypter) this.e).getPasswordVerifierLength()) + 10;
                    j = ((net.lingala.zip4j.crypto.AESDecrypter) this.e).getSaltLength() + ((net.lingala.zip4j.crypto.AESDecrypter) this.e).getPasswordVerifierLength();
                } else if (this.d.getEncryptionMethod() == 0) {
                    j = 12;
                    compressedSize -= 12;
                }
                offsetStartOfData += j;
            }
            long j2 = compressedSize;
            long j3 = offsetStartOfData;
            int compressionMethod = this.b.getCompressionMethod();
            if (this.b.getEncryptionMethod() == 99) {
                if (this.b.getAesExtraDataRecord() == null) {
                    throw new net.lingala.zip4j.exception.ZipException("AESExtraDataRecord does not exist for AES encrypted file: " + this.b.getFileName());
                }
                compressionMethod = this.b.getAesExtraDataRecord().getCompressionMethod();
            }
            e.seek(j3);
            if (compressionMethod == 0) {
                return new net.lingala.zip4j.io.ZipInputStream(new net.lingala.zip4j.io.PartInputStream(e, j3, j2, this));
            }
            if (compressionMethod == 8) {
                return new net.lingala.zip4j.io.ZipInputStream(new net.lingala.zip4j.io.InflaterInputStream(e, j3, j2, this));
            }
            throw new net.lingala.zip4j.exception.ZipException("compression type not supported");
        } catch (net.lingala.zip4j.exception.ZipException e2) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException unused) {
                }
            }
            throw e2;
        } catch (java.lang.Exception e3) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (java.io.IOException unused2) {
                }
            }
            throw new net.lingala.zip4j.exception.ZipException(e3);
        }
    }

    public net.lingala.zip4j.model.LocalFileHeader getLocalFileHeader() {
        return this.d;
    }

    public net.lingala.zip4j.model.ZipModel getZipModel() {
        return this.a;
    }

    public final java.lang.String h(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = this.b.getFileName();
        }
        return str + java.lang.System.getProperty("file.separator") + str2;
    }

    public final java.io.FileOutputStream i(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("invalid output path");
        }
        try {
            java.io.File file = new java.io.File(h(str, str2));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            return new java.io.FileOutputStream(file);
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final byte[] j(java.io.RandomAccessFile randomAccessFile) throws net.lingala.zip4j.exception.ZipException {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.d.getOffsetStartOfData());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void k(java.io.RandomAccessFile randomAccessFile) throws net.lingala.zip4j.exception.ZipException {
        if (this.d == null) {
            throw new net.lingala.zip4j.exception.ZipException("local file header is null, cannot initialize input stream");
        }
        try {
            l(randomAccessFile);
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void l(java.io.RandomAccessFile randomAccessFile) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = this.d;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("local file header is null, cannot init decrypter");
        }
        if (localFileHeader.isEncrypted()) {
            if (this.d.getEncryptionMethod() == 0) {
                this.e = new net.lingala.zip4j.crypto.StandardDecrypter(this.b, j(randomAccessFile));
            } else {
                if (this.d.getEncryptionMethod() != 99) {
                    throw new net.lingala.zip4j.exception.ZipException("unsupported encryption method");
                }
                this.e = new net.lingala.zip4j.crypto.AESDecrypter(this.d, g(randomAccessFile), f(randomAccessFile));
            }
        }
    }

    public java.io.RandomAccessFile startNextSplitFile() throws java.io.IOException, java.io.FileNotFoundException {
        java.lang.String str;
        java.lang.String zipFile = this.a.getZipFile();
        if (this.c == this.a.getEndCentralDirRecord().getNoOfThisDisk()) {
            str = this.a.getZipFile();
        } else if (this.c >= 9) {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + (this.c + 1);
        } else {
            str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + (this.c + 1);
        }
        this.c++;
        try {
            if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(str)) {
                return new java.io.RandomAccessFile(str, "r");
            }
            throw new java.io.IOException("zip split file does not exist: " + str);
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [net.lingala.zip4j.unzip.UnzipEngine] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void unzipFile(net.lingala.zip4j.progress.ProgressMonitor progressMonitor, java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        byte[] bArr;
        net.lingala.zip4j.io.ZipInputStream inputStream;
        if (this.a == null || this.b == null || !net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid parameters passed during unzipping file. One or more of the parameters were null");
        }
        net.lingala.zip4j.io.ZipInputStream zipInputStream = null;
        try {
            try {
                bArr = new byte[4096];
                inputStream = getInputStream();
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                java.io.FileOutputStream i = i(str, str2);
                do {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        d(inputStream, i);
                        net.lingala.zip4j.unzip.UnzipUtil.applyFileAttributes(this.b, new java.io.File(h(str, str2)), unzipParameters);
                        d(inputStream, i);
                        return;
                    }
                    i.write(bArr, 0, read);
                    progressMonitor.updateWorkCompleted(read);
                } while (!progressMonitor.isCancelAllTasks());
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                d(inputStream, i);
            } catch (java.io.IOException e) {
                e = e;
                throw new net.lingala.zip4j.exception.ZipException(e);
            } catch (java.lang.Exception e2) {
                e = e2;
                throw new net.lingala.zip4j.exception.ZipException(e);
            } catch (java.lang.Throwable th2) {
                th = th2;
                str = 0;
                zipInputStream = inputStream;
                d(zipInputStream, str);
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Exception e4) {
            e = e4;
        } catch (java.lang.Throwable th3) {
            th = th3;
            str = 0;
        }
    }

    public void updateCRC(int i) {
        this.f.update(i);
    }

    public void updateCRC(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            this.f.update(bArr, i, i2);
        }
    }
}
