package net.lingala.zip4j.core;

/* loaded from: classes23.dex */
public class HeaderReader {
    public java.io.RandomAccessFile a;
    public net.lingala.zip4j.model.ZipModel b;

    public HeaderReader(java.io.RandomAccessFile randomAccessFile) {
        this.a = randomAccessFile;
    }

    public final byte[] a(byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        if (bArr == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameter is null, cannot expand to 8 bytes");
        }
        if (bArr.length == 4) {
            return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3], 0, 0, 0, 0};
        }
        throw new net.lingala.zip4j.exception.ZipException("invalid byte length, cannot expand to 8 bytes");
    }

    public final net.lingala.zip4j.model.AESExtraDataRecord b(java.util.ArrayList arrayList) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null) {
            return null;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            net.lingala.zip4j.model.ExtraDataRecord extraDataRecord = (net.lingala.zip4j.model.ExtraDataRecord) arrayList.get(i);
            if (extraDataRecord != null && extraDataRecord.getHeader() == 39169) {
                if (extraDataRecord.getData() == null) {
                    throw new net.lingala.zip4j.exception.ZipException("corrput AES extra data records");
                }
                net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord = new net.lingala.zip4j.model.AESExtraDataRecord();
                aESExtraDataRecord.setSignature(39169L);
                aESExtraDataRecord.setDataSize(extraDataRecord.getSizeOfData());
                byte[] data = extraDataRecord.getData();
                aESExtraDataRecord.setVersionNumber(net.lingala.zip4j.util.Raw.readShortLittleEndian(data, 0));
                byte[] bArr = new byte[2];
                java.lang.System.arraycopy(data, 2, bArr, 0, 2);
                aESExtraDataRecord.setVendorID(new java.lang.String(bArr));
                aESExtraDataRecord.setAesStrength(data[4] & 255);
                aESExtraDataRecord.setCompressionMethod(net.lingala.zip4j.util.Raw.readShortLittleEndian(data, 5));
                return aESExtraDataRecord;
            }
        }
        return null;
    }

    public final void c(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.AESExtraDataRecord b;
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (fileHeader.getExtraDataRecords() == null || fileHeader.getExtraDataRecords().size() <= 0 || (b = b(fileHeader.getExtraDataRecords())) == null) {
            return;
        }
        fileHeader.setAesExtraDataRecord(b);
        fileHeader.setEncryptionMethod(99);
    }

    public final void d(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.AESExtraDataRecord b;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (localFileHeader.getExtraDataRecords() == null || localFileHeader.getExtraDataRecords().size() <= 0 || (b = b(localFileHeader.getExtraDataRecords())) == null) {
            return;
        }
        localFileHeader.setAesExtraDataRecord(b);
        localFileHeader.setEncryptionMethod(99);
    }

    public final void e(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (this.a == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid file handler when trying to read extra data record");
        }
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null");
        }
        int extraFieldLength = fileHeader.getExtraFieldLength();
        if (extraFieldLength <= 0) {
            return;
        }
        fileHeader.setExtraDataRecords(k(extraFieldLength));
    }

    public final void f(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (this.a == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid file handler when trying to read extra data record");
        }
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null");
        }
        int extraFieldLength = localFileHeader.getExtraFieldLength();
        if (extraFieldLength <= 0) {
            return;
        }
        localFileHeader.setExtraDataRecords(k(extraFieldLength));
    }

    public final void g(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.Zip64ExtendedInfo o;
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (fileHeader.getExtraDataRecords() == null || fileHeader.getExtraDataRecords().size() <= 0 || (o = o(fileHeader.getExtraDataRecords(), fileHeader.getUncompressedSize(), fileHeader.getCompressedSize(), fileHeader.getOffsetLocalHeader(), fileHeader.getDiskNumberStart())) == null) {
            return;
        }
        fileHeader.setZip64ExtendedInfo(o);
        if (o.getUnCompressedSize() != -1) {
            fileHeader.setUncompressedSize(o.getUnCompressedSize());
        }
        if (o.getCompressedSize() != -1) {
            fileHeader.setCompressedSize(o.getCompressedSize());
        }
        if (o.getOffsetLocalHeader() != -1) {
            fileHeader.setOffsetLocalHeader(o.getOffsetLocalHeader());
        }
        if (o.getDiskNumberStart() != -1) {
            fileHeader.setDiskNumberStart(o.getDiskNumberStart());
        }
    }

    public final void h(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.Zip64ExtendedInfo o;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (localFileHeader.getExtraDataRecords() == null || localFileHeader.getExtraDataRecords().size() <= 0 || (o = o(localFileHeader.getExtraDataRecords(), localFileHeader.getUncompressedSize(), localFileHeader.getCompressedSize(), -1L, -1)) == null) {
            return;
        }
        localFileHeader.setZip64ExtendedInfo(o);
        if (o.getUnCompressedSize() != -1) {
            localFileHeader.setUncompressedSize(o.getUnCompressedSize());
        }
        if (o.getCompressedSize() != -1) {
            localFileHeader.setCompressedSize(o.getCompressedSize());
        }
    }

    public final net.lingala.zip4j.model.CentralDirectory i() throws net.lingala.zip4j.exception.ZipException {
        if (this.a == null) {
            throw new net.lingala.zip4j.exception.ZipException("random access file was null", 3);
        }
        if (this.b.getEndCentralDirRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("EndCentralRecord was null, maybe a corrupt zip file");
        }
        try {
            net.lingala.zip4j.model.CentralDirectory centralDirectory = new net.lingala.zip4j.model.CentralDirectory();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            net.lingala.zip4j.model.EndCentralDirRecord endCentralDirRecord = this.b.getEndCentralDirRecord();
            long offsetOfStartOfCentralDir = endCentralDirRecord.getOffsetOfStartOfCentralDir();
            int totNoOfEntriesInCentralDir = endCentralDirRecord.getTotNoOfEntriesInCentralDir();
            if (this.b.isZip64Format()) {
                offsetOfStartOfCentralDir = this.b.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo();
                totNoOfEntriesInCentralDir = (int) this.b.getZip64EndCentralDirRecord().getTotNoOfEntriesInCentralDir();
            }
            this.a.seek(offsetOfStartOfCentralDir);
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[2];
            for (int i = 0; i < totNoOfEntriesInCentralDir; i++) {
                net.lingala.zip4j.model.FileHeader fileHeader = new net.lingala.zip4j.model.FileHeader();
                l(this.a, bArr);
                int readIntLittleEndian = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0);
                boolean z = true;
                if (readIntLittleEndian != net.lingala.zip4j.util.InternalZipConstants.CENSIG) {
                    throw new net.lingala.zip4j.exception.ZipException("Expected central directory entry not found (#" + (i + 1) + ")");
                }
                fileHeader.setSignature(readIntLittleEndian);
                l(this.a, bArr2);
                fileHeader.setVersionMadeBy(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0));
                l(this.a, bArr2);
                fileHeader.setVersionNeededToExtract(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0));
                l(this.a, bArr2);
                fileHeader.setFileNameUTF8Encoded((net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0) & 2048) != 0);
                byte b = bArr2[0];
                if ((b & 1) != 0) {
                    fileHeader.setEncrypted(true);
                }
                fileHeader.setGeneralPurposeFlag((byte[]) bArr2.clone());
                fileHeader.setDataDescriptorExists((b >> 3) == 1);
                l(this.a, bArr2);
                fileHeader.setCompressionMethod(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0));
                l(this.a, bArr);
                fileHeader.setLastModFileTime(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0));
                l(this.a, bArr);
                fileHeader.setCrc32(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0));
                fileHeader.setCrcBuff((byte[]) bArr.clone());
                l(this.a, bArr);
                fileHeader.setCompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr), 0));
                l(this.a, bArr);
                fileHeader.setUncompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr), 0));
                l(this.a, bArr2);
                int readShortLittleEndian = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0);
                fileHeader.setFileNameLength(readShortLittleEndian);
                l(this.a, bArr2);
                fileHeader.setExtraFieldLength(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0));
                l(this.a, bArr2);
                int readShortLittleEndian2 = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0);
                fileHeader.setFileComment(new java.lang.String(bArr2));
                l(this.a, bArr2);
                fileHeader.setDiskNumberStart(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0));
                l(this.a, bArr2);
                fileHeader.setInternalFileAttr((byte[]) bArr2.clone());
                l(this.a, bArr);
                fileHeader.setExternalFileAttr((byte[]) bArr.clone());
                l(this.a, bArr);
                fileHeader.setOffsetLocalHeader(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr), 0) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
                if (readShortLittleEndian > 0) {
                    byte[] bArr3 = new byte[readShortLittleEndian];
                    l(this.a, bArr3);
                    java.lang.String str = net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.b.getFileNameCharset()) ? new java.lang.String(bArr3, this.b.getFileNameCharset()) : net.lingala.zip4j.util.Zip4jUtil.decodeFileName(bArr3, fileHeader.isFileNameUTF8Encoded());
                    if (str == null) {
                        throw new net.lingala.zip4j.exception.ZipException("fileName is null when reading central directory");
                    }
                    if (str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + java.lang.System.getProperty("file.separator")) >= 0) {
                        str = str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + java.lang.System.getProperty("file.separator")) + 2);
                    }
                    fileHeader.setFileName(str);
                    if (!str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !str.endsWith("\\")) {
                        z = false;
                    }
                    fileHeader.setDirectory(z);
                } else {
                    fileHeader.setFileName(null);
                }
                e(fileHeader);
                g(fileHeader);
                c(fileHeader);
                if (readShortLittleEndian2 > 0) {
                    byte[] bArr4 = new byte[readShortLittleEndian2];
                    l(this.a, bArr4);
                    fileHeader.setFileComment(new java.lang.String(bArr4));
                }
                arrayList.add(fileHeader);
            }
            centralDirectory.setFileHeaders(arrayList);
            net.lingala.zip4j.model.DigitalSignature digitalSignature = new net.lingala.zip4j.model.DigitalSignature();
            l(this.a, bArr);
            int readIntLittleEndian2 = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0);
            if (readIntLittleEndian2 != net.lingala.zip4j.util.InternalZipConstants.DIGSIG) {
                return centralDirectory;
            }
            digitalSignature.setHeaderSignature(readIntLittleEndian2);
            l(this.a, bArr2);
            int readShortLittleEndian3 = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr2, 0);
            digitalSignature.setSizeOfData(readShortLittleEndian3);
            if (readShortLittleEndian3 > 0) {
                byte[] bArr5 = new byte[readShortLittleEndian3];
                l(this.a, bArr5);
                digitalSignature.setSignatureData(new java.lang.String(bArr5));
            }
            return centralDirectory;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final net.lingala.zip4j.model.EndCentralDirRecord j() throws net.lingala.zip4j.exception.ZipException {
        java.io.RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile == null) {
            throw new net.lingala.zip4j.exception.ZipException("random access file was null", 3);
        }
        try {
            byte[] bArr = new byte[4];
            long length = randomAccessFile.length() - 22;
            net.lingala.zip4j.model.EndCentralDirRecord endCentralDirRecord = new net.lingala.zip4j.model.EndCentralDirRecord();
            int i = 0;
            while (true) {
                long j = length - 1;
                this.a.seek(length);
                i++;
                if (net.lingala.zip4j.util.Raw.readLeInt(this.a, bArr) == net.lingala.zip4j.util.InternalZipConstants.ENDSIG || i > 3000) {
                    break;
                }
                length = j;
            }
            if (net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0) != net.lingala.zip4j.util.InternalZipConstants.ENDSIG) {
                throw new net.lingala.zip4j.exception.ZipException("zip headers not found. probably not a zip file");
            }
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[2];
            endCentralDirRecord.setSignature(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
            l(this.a, bArr3);
            endCentralDirRecord.setNoOfThisDisk(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            endCentralDirRecord.setNoOfThisDiskStartOfCentralDir(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            endCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            endCentralDirRecord.setTotNoOfEntriesInCentralDir(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr3, 0));
            l(this.a, bArr2);
            endCentralDirRecord.setSizeOfCentralDir(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
            l(this.a, bArr2);
            endCentralDirRecord.setOffsetOfStartOfCentralDir(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr2), 0));
            l(this.a, bArr3);
            int readShortLittleEndian = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr3, 0);
            endCentralDirRecord.setCommentLength(readShortLittleEndian);
            if (readShortLittleEndian > 0) {
                byte[] bArr4 = new byte[readShortLittleEndian];
                l(this.a, bArr4);
                endCentralDirRecord.setComment(new java.lang.String(bArr4));
                endCentralDirRecord.setCommentBytes(bArr4);
            } else {
                endCentralDirRecord.setComment(null);
            }
            if (endCentralDirRecord.getNoOfThisDisk() > 0) {
                this.b.setSplitArchive(true);
            } else {
                this.b.setSplitArchive(false);
            }
            return endCentralDirRecord;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException("Probably not a zip file or a corrupted zip file", e, 4);
        }
    }

    public final java.util.ArrayList k(int i) throws net.lingala.zip4j.exception.ZipException {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            this.a.read(bArr);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int i2 = 0;
            while (i2 < i) {
                net.lingala.zip4j.model.ExtraDataRecord extraDataRecord = new net.lingala.zip4j.model.ExtraDataRecord();
                extraDataRecord.setHeader(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, i2));
                int i3 = i2 + 2;
                int readShortLittleEndian = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, i3);
                if (readShortLittleEndian + 2 > i) {
                    readShortLittleEndian = net.lingala.zip4j.util.Raw.readShortBigEndian(bArr, i3);
                    if (readShortLittleEndian + 2 > i) {
                        break;
                    }
                }
                extraDataRecord.setSizeOfData(readShortLittleEndian);
                int i4 = i3 + 2;
                if (readShortLittleEndian > 0) {
                    byte[] bArr2 = new byte[readShortLittleEndian];
                    java.lang.System.arraycopy(bArr, i4, bArr2, 0, readShortLittleEndian);
                    extraDataRecord.setData(bArr2);
                }
                i2 = i4 + readShortLittleEndian;
                arrayList.add(extraDataRecord);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final byte[] l(java.io.RandomAccessFile randomAccessFile, byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new net.lingala.zip4j.exception.ZipException("unexpected end of file when reading short buff");
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException("IOException when reading short buff", e);
        }
    }

    public final net.lingala.zip4j.model.Zip64EndCentralDirLocator m() throws net.lingala.zip4j.exception.ZipException {
        if (this.a == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
        try {
            net.lingala.zip4j.model.Zip64EndCentralDirLocator zip64EndCentralDirLocator = new net.lingala.zip4j.model.Zip64EndCentralDirLocator();
            p();
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[8];
            l(this.a, bArr);
            long readIntLittleEndian = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0);
            if (readIntLittleEndian != net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRLOC) {
                this.b.setZip64Format(false);
                return null;
            }
            this.b.setZip64Format(true);
            zip64EndCentralDirLocator.setSignature(readIntLittleEndian);
            l(this.a, bArr);
            zip64EndCentralDirLocator.setNoOfDiskStartOfZip64EndOfCentralDirRec(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0));
            l(this.a, bArr2);
            zip64EndCentralDirLocator.setOffsetZip64EndOfCentralDirRec(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr2, 0));
            l(this.a, bArr);
            zip64EndCentralDirLocator.setTotNumberOfDiscs(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr, 0));
            return zip64EndCentralDirLocator;
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final net.lingala.zip4j.model.Zip64EndCentralDirRecord n() throws net.lingala.zip4j.exception.ZipException {
        if (this.b.getZip64EndCentralDirLocator() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid zip64 end of central directory locator");
        }
        long offsetZip64EndOfCentralDirRec = this.b.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec();
        if (offsetZip64EndOfCentralDirRec < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invalid offset for start of end of central directory record");
        }
        try {
            this.a.seek(offsetZip64EndOfCentralDirRec);
            net.lingala.zip4j.model.Zip64EndCentralDirRecord zip64EndCentralDirRecord = new net.lingala.zip4j.model.Zip64EndCentralDirRecord();
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[8];
            l(this.a, bArr2);
            long readIntLittleEndian = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0);
            if (readIntLittleEndian != net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRREC) {
                throw new net.lingala.zip4j.exception.ZipException("invalid signature for zip64 end of central directory record");
            }
            zip64EndCentralDirRecord.setSignature(readIntLittleEndian);
            l(this.a, bArr3);
            zip64EndCentralDirRecord.setSizeOfZip64EndCentralDirRec(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr3, 0));
            l(this.a, bArr);
            zip64EndCentralDirRecord.setVersionMadeBy(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0));
            l(this.a, bArr);
            zip64EndCentralDirRecord.setVersionNeededToExtract(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0));
            l(this.a, bArr2);
            zip64EndCentralDirRecord.setNoOfThisDisk(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
            l(this.a, bArr2);
            zip64EndCentralDirRecord.setNoOfThisDiskStartOfCentralDir(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
            l(this.a, bArr3);
            zip64EndCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            zip64EndCentralDirRecord.setTotNoOfEntriesInCentralDir(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            zip64EndCentralDirRecord.setSizeOfCentralDir(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr3, 0));
            l(this.a, bArr3);
            zip64EndCentralDirRecord.setOffsetStartCenDirWRTStartDiskNo(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr3, 0));
            long sizeOfZip64EndCentralDirRec = zip64EndCentralDirRecord.getSizeOfZip64EndCentralDirRec() - 44;
            if (sizeOfZip64EndCentralDirRec > 0) {
                byte[] bArr4 = new byte[(int) sizeOfZip64EndCentralDirRec];
                l(this.a, bArr4);
                zip64EndCentralDirRecord.setExtensibleDataSector(bArr4);
            }
            return zip64EndCentralDirRecord;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final net.lingala.zip4j.model.Zip64ExtendedInfo o(java.util.ArrayList arrayList, long j, long j2, long j3, int i) throws net.lingala.zip4j.exception.ZipException {
        int i2;
        boolean z;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            net.lingala.zip4j.model.ExtraDataRecord extraDataRecord = (net.lingala.zip4j.model.ExtraDataRecord) arrayList.get(i3);
            if (extraDataRecord != null && extraDataRecord.getHeader() == 1) {
                net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo = new net.lingala.zip4j.model.Zip64ExtendedInfo();
                byte[] data = extraDataRecord.getData();
                if (extraDataRecord.getSizeOfData() <= 0) {
                    return null;
                }
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[4];
                boolean z2 = true;
                if ((j & 65535) != 65535 || extraDataRecord.getSizeOfData() <= 0) {
                    i2 = 0;
                    z = false;
                } else {
                    java.lang.System.arraycopy(data, 0, bArr, 0, 8);
                    zip64ExtendedInfo.setUnCompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr, 0));
                    i2 = 8;
                    z = true;
                }
                if ((j2 & 65535) == 65535 && i2 < extraDataRecord.getSizeOfData()) {
                    java.lang.System.arraycopy(data, i2, bArr, 0, 8);
                    zip64ExtendedInfo.setCompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((j3 & 65535) == 65535 && i2 < extraDataRecord.getSizeOfData()) {
                    java.lang.System.arraycopy(data, i2, bArr, 0, 8);
                    zip64ExtendedInfo.setOffsetLocalHeader(net.lingala.zip4j.util.Raw.readLongLittleEndian(bArr, 0));
                    i2 += 8;
                    z = true;
                }
                if ((i & 65535) != 65535 || i2 >= extraDataRecord.getSizeOfData()) {
                    z2 = z;
                } else {
                    java.lang.System.arraycopy(data, i2, bArr2, 0, 4);
                    zip64ExtendedInfo.setDiskNumberStart(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
                }
                if (z2) {
                    return zip64ExtendedInfo;
                }
                return null;
            }
        }
        return null;
    }

    public final void p() throws net.lingala.zip4j.exception.ZipException {
        try {
            byte[] bArr = new byte[4];
            long length = this.a.length() - 22;
            while (true) {
                long j = length - 1;
                this.a.seek(length);
                if (net.lingala.zip4j.util.Raw.readLeInt(this.a, bArr) == net.lingala.zip4j.util.InternalZipConstants.ENDSIG) {
                    java.io.RandomAccessFile randomAccessFile = this.a;
                    randomAccessFile.seek(((((randomAccessFile.getFilePointer() - 4) - 4) - 8) - 4) - 4);
                    return;
                }
                length = j;
            }
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public net.lingala.zip4j.model.ZipModel readAllHeaders() throws net.lingala.zip4j.exception.ZipException {
        return readAllHeaders(null);
    }

    public net.lingala.zip4j.model.ZipModel readAllHeaders(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.ZipModel zipModel = new net.lingala.zip4j.model.ZipModel();
        this.b = zipModel;
        zipModel.setFileNameCharset(str);
        this.b.setEndCentralDirRecord(j());
        this.b.setZip64EndCentralDirLocator(m());
        if (this.b.isZip64Format()) {
            this.b.setZip64EndCentralDirRecord(n());
            if (this.b.getZip64EndCentralDirRecord() == null || this.b.getZip64EndCentralDirRecord().getNoOfThisDisk() <= 0) {
                this.b.setSplitArchive(false);
            } else {
                this.b.setSplitArchive(true);
            }
        }
        this.b.setCentralDirectory(i());
        return this.b;
    }

    public net.lingala.zip4j.model.LocalFileHeader readLocalFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null || this.a == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid read parameters for local header");
        }
        long offsetLocalHeader = fileHeader.getOffsetLocalHeader();
        if (fileHeader.getZip64ExtendedInfo() != null && fileHeader.getZip64ExtendedInfo().getOffsetLocalHeader() > 0) {
            offsetLocalHeader = fileHeader.getOffsetLocalHeader();
        }
        if (offsetLocalHeader < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invalid local header offset");
        }
        try {
            this.a.seek(offsetLocalHeader);
            net.lingala.zip4j.model.LocalFileHeader localFileHeader = new net.lingala.zip4j.model.LocalFileHeader();
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            l(this.a, bArr2);
            int readIntLittleEndian = net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0);
            if (readIntLittleEndian != net.lingala.zip4j.util.InternalZipConstants.LOCSIG) {
                throw new net.lingala.zip4j.exception.ZipException("invalid local header signature for file: " + fileHeader.getFileName());
            }
            localFileHeader.setSignature(readIntLittleEndian);
            l(this.a, bArr);
            localFileHeader.setVersionNeededToExtract(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0));
            l(this.a, bArr);
            localFileHeader.setFileNameUTF8Encoded((net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0) & 2048) != 0);
            byte b = bArr[0];
            if ((b & 1) != 0) {
                localFileHeader.setEncrypted(true);
            }
            localFileHeader.setGeneralPurposeFlag(bArr);
            java.lang.String binaryString = java.lang.Integer.toBinaryString(b);
            if (binaryString.length() >= 4) {
                localFileHeader.setDataDescriptorExists(binaryString.charAt(3) == '1');
            }
            l(this.a, bArr);
            localFileHeader.setCompressionMethod(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0));
            l(this.a, bArr2);
            localFileHeader.setLastModFileTime(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
            l(this.a, bArr2);
            localFileHeader.setCrc32(net.lingala.zip4j.util.Raw.readIntLittleEndian(bArr2, 0));
            localFileHeader.setCrcBuff((byte[]) bArr2.clone());
            l(this.a, bArr2);
            localFileHeader.setCompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr2), 0));
            l(this.a, bArr2);
            localFileHeader.setUncompressedSize(net.lingala.zip4j.util.Raw.readLongLittleEndian(a(bArr2), 0));
            l(this.a, bArr);
            int readShortLittleEndian = net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0);
            localFileHeader.setFileNameLength(readShortLittleEndian);
            l(this.a, bArr);
            localFileHeader.setExtraFieldLength(net.lingala.zip4j.util.Raw.readShortLittleEndian(bArr, 0));
            int i = 30;
            if (readShortLittleEndian > 0) {
                byte[] bArr3 = new byte[readShortLittleEndian];
                l(this.a, bArr3);
                java.lang.String decodeFileName = net.lingala.zip4j.util.Zip4jUtil.decodeFileName(bArr3, localFileHeader.isFileNameUTF8Encoded());
                if (decodeFileName == null) {
                    throw new net.lingala.zip4j.exception.ZipException("file name is null, cannot assign file name to local file header");
                }
                if (decodeFileName.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + java.lang.System.getProperty("file.separator")) >= 0) {
                    decodeFileName = decodeFileName.substring(decodeFileName.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + java.lang.System.getProperty("file.separator")) + 2);
                }
                localFileHeader.setFileName(decodeFileName);
                i = 30 + readShortLittleEndian;
            } else {
                localFileHeader.setFileName(null);
            }
            f(localFileHeader);
            localFileHeader.setOffsetStartOfData(offsetLocalHeader + i + r7);
            localFileHeader.setPassword(fileHeader.getPassword());
            h(localFileHeader);
            d(localFileHeader);
            if (localFileHeader.isEncrypted() && localFileHeader.getEncryptionMethod() != 99) {
                if ((b & com.google.common.primitives.SignedBytes.MAX_POWER_OF_TWO) == 64) {
                    localFileHeader.setEncryptionMethod(1);
                } else {
                    localFileHeader.setEncryptionMethod(0);
                }
            }
            if (localFileHeader.getCrc32() <= 0) {
                localFileHeader.setCrc32(fileHeader.getCrc32());
                localFileHeader.setCrcBuff(fileHeader.getCrcBuff());
            }
            if (localFileHeader.getCompressedSize() <= 0) {
                localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            }
            if (localFileHeader.getUncompressedSize() <= 0) {
                localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
            }
            return localFileHeader;
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }
}
