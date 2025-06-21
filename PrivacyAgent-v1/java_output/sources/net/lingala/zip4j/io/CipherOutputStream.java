package net.lingala.zip4j.io;

/* loaded from: classes23.dex */
public class CipherOutputStream extends net.lingala.zip4j.io.BaseOutputStream {
    protected java.util.zip.CRC32 crc;
    protected net.lingala.zip4j.model.FileHeader fileHeader;
    protected net.lingala.zip4j.model.LocalFileHeader localFileHeader;
    public java.io.File n;
    protected java.io.OutputStream outputStream;
    public net.lingala.zip4j.crypto.IEncrypter t;
    public long u;
    public long v;
    public byte[] w;
    public int x;
    public long y;
    protected net.lingala.zip4j.model.ZipModel zipModel;
    protected net.lingala.zip4j.model.ZipParameters zipParameters;

    public CipherOutputStream(java.io.OutputStream outputStream, net.lingala.zip4j.model.ZipModel zipModel) {
        this.outputStream = outputStream;
        k(zipModel);
        this.crc = new java.util.zip.CRC32();
        this.u = 0L;
        this.v = 0L;
        this.w = new byte[16];
        this.x = 0;
        this.y = 0L;
    }

    public final void a() throws net.lingala.zip4j.exception.ZipException {
        java.lang.String relativeFileName;
        int i;
        net.lingala.zip4j.model.FileHeader fileHeader = new net.lingala.zip4j.model.FileHeader();
        this.fileHeader = fileHeader;
        fileHeader.setSignature(33639248);
        this.fileHeader.setVersionMadeBy(20);
        this.fileHeader.setVersionNeededToExtract(20);
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCompressionMethod(99);
            this.fileHeader.setAesExtraDataRecord(e(this.zipParameters));
        } else {
            this.fileHeader.setCompressionMethod(this.zipParameters.getCompressionMethod());
        }
        if (this.zipParameters.isEncryptFiles()) {
            this.fileHeader.setEncrypted(true);
            this.fileHeader.setEncryptionMethod(this.zipParameters.getEncryptionMethod());
        }
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setLastModFileTime((int) net.lingala.zip4j.util.Zip4jUtil.javaToDosTime(java.lang.System.currentTimeMillis()));
            if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.zipParameters.getFileNameInZip())) {
                throw new net.lingala.zip4j.exception.ZipException("fileNameInZip is null or empty");
            }
            relativeFileName = this.zipParameters.getFileNameInZip();
        } else {
            this.fileHeader.setLastModFileTime((int) net.lingala.zip4j.util.Zip4jUtil.javaToDosTime(net.lingala.zip4j.util.Zip4jUtil.getLastModifiedFileTime(this.n, this.zipParameters.getTimeZone())));
            this.fileHeader.setUncompressedSize(this.n.length());
            relativeFileName = net.lingala.zip4j.util.Zip4jUtil.getRelativeFileName(this.n.getAbsolutePath(), this.zipParameters.getRootFolderInZip(), this.zipParameters.getDefaultFolderPath());
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(relativeFileName)) {
            throw new net.lingala.zip4j.exception.ZipException("fileName is null or empty. unable to create file header");
        }
        this.fileHeader.setFileName(relativeFileName);
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset())) {
            this.fileHeader.setFileNameLength(net.lingala.zip4j.util.Zip4jUtil.getEncodedStringLength(relativeFileName, this.zipModel.getFileNameCharset()));
        } else {
            this.fileHeader.setFileNameLength(net.lingala.zip4j.util.Zip4jUtil.getEncodedStringLength(relativeFileName));
        }
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream instanceof net.lingala.zip4j.io.SplitOutputStream) {
            this.fileHeader.setDiskNumberStart(((net.lingala.zip4j.io.SplitOutputStream) outputStream).getCurrSplitFileCounter());
        } else {
            this.fileHeader.setDiskNumberStart(0);
        }
        this.fileHeader.setExternalFileAttr(new byte[]{(byte) (!this.zipParameters.isSourceExternalStream() ? g(this.n) : 0), 0, 0, 0});
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setDirectory(relativeFileName.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || relativeFileName.endsWith("\\"));
        } else {
            this.fileHeader.setDirectory(this.n.isDirectory());
        }
        if (this.fileHeader.isDirectory()) {
            this.fileHeader.setCompressedSize(0L);
            this.fileHeader.setUncompressedSize(0L);
        } else if (!this.zipParameters.isSourceExternalStream()) {
            long fileLengh = net.lingala.zip4j.util.Zip4jUtil.getFileLengh(this.n);
            if (this.zipParameters.getCompressionMethod() != 0) {
                this.fileHeader.setCompressedSize(0L);
            } else if (this.zipParameters.getEncryptionMethod() == 0) {
                this.fileHeader.setCompressedSize(12 + fileLengh);
            } else if (this.zipParameters.getEncryptionMethod() == 99) {
                int aesKeyStrength = this.zipParameters.getAesKeyStrength();
                if (aesKeyStrength == 1) {
                    i = 8;
                } else {
                    if (aesKeyStrength != 3) {
                        throw new net.lingala.zip4j.exception.ZipException("invalid aes key strength, cannot determine key sizes");
                    }
                    i = 16;
                }
                this.fileHeader.setCompressedSize(i + fileLengh + 10 + 2);
            } else {
                this.fileHeader.setCompressedSize(0L);
            }
            this.fileHeader.setUncompressedSize(fileLengh);
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 0) {
            this.fileHeader.setCrc32(this.zipParameters.getSourceFileCRC());
        }
        byte[] bArr = new byte[2];
        bArr[0] = net.lingala.zip4j.util.Raw.bitArrayToByte(f(this.fileHeader.isEncrypted(), this.zipParameters.getCompressionMethod()));
        boolean isStringNotNullAndNotEmpty = net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.zipModel.getFileNameCharset());
        if (!(isStringNotNullAndNotEmpty && this.zipModel.getFileNameCharset().equalsIgnoreCase(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8)) && (isStringNotNullAndNotEmpty || !net.lingala.zip4j.util.Zip4jUtil.detectCharSet(this.fileHeader.getFileName()).equals(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8))) {
            bArr[1] = 0;
        } else {
            bArr[1] = 8;
        }
        this.fileHeader.setGeneralPurposeFlag(bArr);
    }

    public final void c() throws net.lingala.zip4j.exception.ZipException {
        if (this.fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null, cannot create local file header");
        }
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = new net.lingala.zip4j.model.LocalFileHeader();
        this.localFileHeader = localFileHeader;
        localFileHeader.setSignature(67324752);
        this.localFileHeader.setVersionNeededToExtract(this.fileHeader.getVersionNeededToExtract());
        this.localFileHeader.setCompressionMethod(this.fileHeader.getCompressionMethod());
        this.localFileHeader.setLastModFileTime(this.fileHeader.getLastModFileTime());
        this.localFileHeader.setUncompressedSize(this.fileHeader.getUncompressedSize());
        this.localFileHeader.setFileNameLength(this.fileHeader.getFileNameLength());
        this.localFileHeader.setFileName(this.fileHeader.getFileName());
        this.localFileHeader.setEncrypted(this.fileHeader.isEncrypted());
        this.localFileHeader.setEncryptionMethod(this.fileHeader.getEncryptionMethod());
        this.localFileHeader.setAesExtraDataRecord(this.fileHeader.getAesExtraDataRecord());
        this.localFileHeader.setCrc32(this.fileHeader.getCrc32());
        this.localFileHeader.setCompressedSize(this.fileHeader.getCompressedSize());
        this.localFileHeader.setGeneralPurposeFlag((byte[]) this.fileHeader.getGeneralPurposeFlag().clone());
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.io.OutputStream outputStream = this.outputStream;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void closeEntry() throws java.io.IOException, net.lingala.zip4j.exception.ZipException {
        int i = this.x;
        if (i != 0) {
            d(this.w, 0, i);
            this.x = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            net.lingala.zip4j.crypto.IEncrypter iEncrypter = this.t;
            if (!(iEncrypter instanceof net.lingala.zip4j.crypto.AESEncrpyter)) {
                throw new net.lingala.zip4j.exception.ZipException("invalid encrypter for AES encrypted file");
            }
            this.outputStream.write(((net.lingala.zip4j.crypto.AESEncrpyter) iEncrypter).getFinalMac());
            this.v += 10;
            this.u += 10;
        }
        this.fileHeader.setCompressedSize(this.v);
        this.localFileHeader.setCompressedSize(this.v);
        if (this.zipParameters.isSourceExternalStream()) {
            this.fileHeader.setUncompressedSize(this.y);
            long uncompressedSize = this.localFileHeader.getUncompressedSize();
            long j = this.y;
            if (uncompressedSize != j) {
                this.localFileHeader.setUncompressedSize(j);
            }
        }
        long value = this.crc.getValue();
        if (this.fileHeader.isEncrypted() && this.fileHeader.getEncryptionMethod() == 99) {
            value = 0;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            this.fileHeader.setCrc32(0L);
            this.localFileHeader.setCrc32(0L);
        } else {
            this.fileHeader.setCrc32(value);
            this.localFileHeader.setCrc32(value);
        }
        this.zipModel.getLocalFileHeaderList().add(this.localFileHeader);
        this.zipModel.getCentralDirectory().getFileHeaders().add(this.fileHeader);
        this.u += new net.lingala.zip4j.core.HeaderWriter().writeExtendedLocalHeader(this.localFileHeader, this.outputStream);
        this.crc.reset();
        this.v = 0L;
        this.t = null;
        this.y = 0L;
    }

    public final void d(byte[] bArr, int i, int i2) throws java.io.IOException {
        net.lingala.zip4j.crypto.IEncrypter iEncrypter = this.t;
        if (iEncrypter != null) {
            try {
                iEncrypter.encryptData(bArr, i, i2);
            } catch (net.lingala.zip4j.exception.ZipException e) {
                throw new java.io.IOException(e.getMessage());
            }
        }
        this.outputStream.write(bArr, i, i2);
        long j = i2;
        this.u += j;
        this.v += j;
    }

    public void decrementCompressedFileSize(int i) {
        if (i <= 0) {
            return;
        }
        long j = i;
        long j2 = this.v;
        if (j <= j2) {
            this.v = j2 - j;
        }
    }

    public final net.lingala.zip4j.model.AESExtraDataRecord e(net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip parameters are null, cannot generate AES Extra Data record");
        }
        net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord = new net.lingala.zip4j.model.AESExtraDataRecord();
        aESExtraDataRecord.setSignature(39169L);
        aESExtraDataRecord.setDataSize(7);
        aESExtraDataRecord.setVendorID("AE");
        aESExtraDataRecord.setVersionNumber(2);
        if (zipParameters.getAesKeyStrength() == 1) {
            aESExtraDataRecord.setAesStrength(1);
        } else {
            if (zipParameters.getAesKeyStrength() != 3) {
                throw new net.lingala.zip4j.exception.ZipException("invalid AES key strength, cannot generate AES Extra data record");
            }
            aESExtraDataRecord.setAesStrength(3);
        }
        aESExtraDataRecord.setCompressionMethod(zipParameters.getCompressionMethod());
        return aESExtraDataRecord;
    }

    public final int[] f(boolean z, int i) {
        int[] iArr = new int[8];
        if (z) {
            iArr[0] = 1;
        } else {
            iArr[0] = 0;
        }
        if (i != 8) {
            iArr[1] = 0;
            iArr[2] = 0;
        }
        iArr[3] = 1;
        return iArr;
    }

    public void finish() throws java.io.IOException, net.lingala.zip4j.exception.ZipException {
        this.zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(this.u);
        new net.lingala.zip4j.core.HeaderWriter().finalizeZipFile(this.zipModel, this.outputStream);
    }

    public final int g(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null, cannot get file attributes");
        }
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            return file.isHidden() ? 18 : 16;
        }
        if (!file.canWrite() && file.isHidden()) {
            return 3;
        }
        if (file.canWrite()) {
            return file.isHidden() ? 2 : 0;
        }
        return 1;
    }

    public java.io.File getSourceFile() {
        return this.n;
    }

    public final void j() throws net.lingala.zip4j.exception.ZipException {
        if (!this.zipParameters.isEncryptFiles()) {
            this.t = null;
            return;
        }
        int encryptionMethod = this.zipParameters.getEncryptionMethod();
        if (encryptionMethod == 0) {
            this.t = new net.lingala.zip4j.crypto.StandardEncrypter(this.zipParameters.getPassword(), (this.localFileHeader.getLastModFileTime() & 65535) << 16);
        } else {
            if (encryptionMethod != 99) {
                throw new net.lingala.zip4j.exception.ZipException("invalid encprytion method");
            }
            this.t = new net.lingala.zip4j.crypto.AESEncrpyter(this.zipParameters.getPassword(), this.zipParameters.getAesKeyStrength());
        }
    }

    public final void k(net.lingala.zip4j.model.ZipModel zipModel) {
        if (zipModel == null) {
            this.zipModel = new net.lingala.zip4j.model.ZipModel();
        } else {
            this.zipModel = zipModel;
        }
        if (this.zipModel.getEndCentralDirRecord() == null) {
            this.zipModel.setEndCentralDirRecord(new net.lingala.zip4j.model.EndCentralDirRecord());
        }
        if (this.zipModel.getCentralDirectory() == null) {
            this.zipModel.setCentralDirectory(new net.lingala.zip4j.model.CentralDirectory());
        }
        if (this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            this.zipModel.getCentralDirectory().setFileHeaders(new java.util.ArrayList());
        }
        if (this.zipModel.getLocalFileHeaderList() == null) {
            this.zipModel.setLocalFileHeaderList(new java.util.ArrayList());
        }
        java.io.OutputStream outputStream = this.outputStream;
        if ((outputStream instanceof net.lingala.zip4j.io.SplitOutputStream) && ((net.lingala.zip4j.io.SplitOutputStream) outputStream).isSplitZipFile()) {
            this.zipModel.setSplitArchive(true);
            this.zipModel.setSplitLength(((net.lingala.zip4j.io.SplitOutputStream) this.outputStream).getSplitLength());
        }
        this.zipModel.getEndCentralDirRecord().setSignature(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
    }

    public void putNextEntry(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!zipParameters.isSourceExternalStream() && file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null");
        }
        if (!zipParameters.isSourceExternalStream() && !net.lingala.zip4j.util.Zip4jUtil.checkFileExists(file)) {
            throw new net.lingala.zip4j.exception.ZipException("input file does not exist");
        }
        try {
            this.n = file;
            this.zipParameters = (net.lingala.zip4j.model.ZipParameters) zipParameters.clone();
            if (zipParameters.isSourceExternalStream()) {
                if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.zipParameters.getFileNameInZip())) {
                    throw new net.lingala.zip4j.exception.ZipException("file name is empty for external stream");
                }
                if (this.zipParameters.getFileNameInZip().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) || this.zipParameters.getFileNameInZip().endsWith("\\")) {
                    this.zipParameters.setEncryptFiles(false);
                    this.zipParameters.setEncryptionMethod(-1);
                    this.zipParameters.setCompressionMethod(0);
                }
            } else if (this.n.isDirectory()) {
                this.zipParameters.setEncryptFiles(false);
                this.zipParameters.setEncryptionMethod(-1);
                this.zipParameters.setCompressionMethod(0);
            }
            a();
            c();
            if (this.zipModel.isSplitArchive() && (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() == 0)) {
                byte[] bArr = new byte[4];
                net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, 134695760);
                this.outputStream.write(bArr);
                this.u += 4;
            }
            java.io.OutputStream outputStream = this.outputStream;
            if (!(outputStream instanceof net.lingala.zip4j.io.SplitOutputStream)) {
                long j = this.u;
                if (j == 4) {
                    this.fileHeader.setOffsetLocalHeader(4L);
                } else {
                    this.fileHeader.setOffsetLocalHeader(j);
                }
            } else if (this.u == 4) {
                this.fileHeader.setOffsetLocalHeader(4L);
            } else {
                this.fileHeader.setOffsetLocalHeader(((net.lingala.zip4j.io.SplitOutputStream) outputStream).getFilePointer());
            }
            this.u += new net.lingala.zip4j.core.HeaderWriter().writeLocalFileHeader(this.zipModel, this.localFileHeader, this.outputStream);
            if (this.zipParameters.isEncryptFiles()) {
                j();
                if (this.t != null) {
                    if (zipParameters.getEncryptionMethod() == 0) {
                        this.outputStream.write(((net.lingala.zip4j.crypto.StandardEncrypter) this.t).getHeaderBytes());
                        this.u += r6.length;
                        this.v += r6.length;
                    } else if (zipParameters.getEncryptionMethod() == 99) {
                        byte[] saltBytes = ((net.lingala.zip4j.crypto.AESEncrpyter) this.t).getSaltBytes();
                        byte[] derivedPasswordVerifier = ((net.lingala.zip4j.crypto.AESEncrpyter) this.t).getDerivedPasswordVerifier();
                        this.outputStream.write(saltBytes);
                        this.outputStream.write(derivedPasswordVerifier);
                        this.u += saltBytes.length + derivedPasswordVerifier.length;
                        this.v += saltBytes.length + derivedPasswordVerifier.length;
                    }
                }
            }
            this.crc.reset();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (net.lingala.zip4j.exception.ZipException e2) {
            throw e2;
        } catch (java.lang.Exception e3) {
            throw new net.lingala.zip4j.exception.ZipException(e3);
        }
    }

    public void setSourceFile(java.io.File file) {
        this.n = file;
    }

    public void updateTotalBytesRead(int i) {
        if (i > 0) {
            this.y += i;
        }
    }

    @Override // net.lingala.zip4j.io.BaseOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        bArr.getClass();
        if (bArr.length == 0) {
            return;
        }
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        if (i2 == 0) {
            return;
        }
        if (this.zipParameters.isEncryptFiles() && this.zipParameters.getEncryptionMethod() == 99) {
            int i4 = this.x;
            if (i4 != 0) {
                if (i2 < 16 - i4) {
                    java.lang.System.arraycopy(bArr, i, this.w, i4, i2);
                    this.x += i2;
                    return;
                }
                java.lang.System.arraycopy(bArr, i, this.w, i4, 16 - i4);
                byte[] bArr2 = this.w;
                d(bArr2, 0, bArr2.length);
                i = 16 - this.x;
                i2 -= i;
                this.x = 0;
            }
            if (i2 != 0 && (i3 = i2 % 16) != 0) {
                java.lang.System.arraycopy(bArr, (i2 + i) - i3, this.w, 0, i3);
                this.x = i3;
                i2 -= i3;
            }
        }
        if (i2 != 0) {
            d(bArr, i, i2);
        }
    }
}
