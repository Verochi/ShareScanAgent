package net.lingala.zip4j.core;

/* loaded from: classes23.dex */
public class HeaderWriter {
    public final int a = 50;

    public final byte[] a(java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        if (list == null) {
            throw new net.lingala.zip4j.exception.ZipException("input byte array list is null, cannot conver to byte array");
        }
        if (list.size() <= 0) {
            return null;
        }
        byte[] bArr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = java.lang.Byte.parseByte((java.lang.String) list.get(i));
        }
        return bArr;
    }

    public final void b(byte[] bArr, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        if (list == null || bArr == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null, cannot copy byte array to array list");
        }
        for (byte b : bArr) {
            list.add(java.lang.Byte.toString(b));
        }
    }

    public final int c(java.util.ArrayList arrayList, int i) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("file headers are null, cannot calculate number of entries on this disk");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (((net.lingala.zip4j.model.FileHeader) arrayList.get(i3)).getDiskNumberStart() == i) {
                i2++;
            }
        }
        return i2;
    }

    public final void d(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException {
        int i;
        try {
            if (outputStream instanceof net.lingala.zip4j.io.SplitOutputStream) {
                zipModel.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(((net.lingala.zip4j.io.SplitOutputStream) outputStream).getFilePointer());
                i = ((net.lingala.zip4j.io.SplitOutputStream) outputStream).getCurrSplitFileCounter();
            } else {
                i = 0;
            }
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new net.lingala.zip4j.model.Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new net.lingala.zip4j.model.Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(i);
                zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(i + 1);
            }
            zipModel.getEndCentralDirRecord().setNoOfThisDisk(i);
            zipModel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(i);
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final void e(net.lingala.zip4j.io.SplitOutputStream splitOutputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader, long j, long j2, byte[] bArr, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (splitOutputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid output stream, cannot update compressed size for local file header");
        }
        try {
            if (!localFileHeader.isWriteComprSizeInZip64ExtraRecord()) {
                splitOutputStream.seek(j + j2);
                splitOutputStream.write(bArr);
            } else {
                if (bArr.length != 8) {
                    throw new net.lingala.zip4j.exception.ZipException("attempting to write a non 8-byte compressed size block for a zip64 file");
                }
                long fileNameLength = j + j2 + 4 + 4 + 2 + 2 + localFileHeader.getFileNameLength() + 2 + 2 + 8;
                if (j2 == 22) {
                    fileNameLength += 8;
                }
                splitOutputStream.seek(fileNameLength);
                splitOutputStream.write(bArr);
            }
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final int f(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot write central directory");
        }
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < zipModel.getCentralDirectory().getFileHeaders().size(); i2++) {
            i += h(zipModel, (net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2), outputStream, list);
        }
        return i;
    }

    public void finalizeZipFile(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot finalize zip file");
        }
        try {
            d(zipModel, outputStream);
            long offsetOfStartOfCentralDir = zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int f = f(zipModel, outputStream, arrayList);
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new net.lingala.zip4j.model.Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new net.lingala.zip4j.model.Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(f + offsetOfStartOfCentralDir);
                if (outputStream instanceof net.lingala.zip4j.io.SplitOutputStream) {
                    zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(((net.lingala.zip4j.io.SplitOutputStream) outputStream).getCurrSplitFileCounter());
                    zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(((net.lingala.zip4j.io.SplitOutputStream) outputStream).getCurrSplitFileCounter() + 1);
                } else {
                    zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
                    zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
                }
                j(zipModel, outputStream, f, offsetOfStartOfCentralDir, arrayList);
                i(zipModel, outputStream, arrayList);
            }
            g(zipModel, outputStream, f, offsetOfStartOfCentralDir, arrayList);
            k(zipModel, outputStream, a(arrayList));
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public void finalizeZipFileWithoutValidations(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            long offsetOfStartOfCentralDir = zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir();
            int f = f(zipModel, outputStream, arrayList);
            if (zipModel.isZip64Format()) {
                if (zipModel.getZip64EndCentralDirRecord() == null) {
                    zipModel.setZip64EndCentralDirRecord(new net.lingala.zip4j.model.Zip64EndCentralDirRecord());
                }
                if (zipModel.getZip64EndCentralDirLocator() == null) {
                    zipModel.setZip64EndCentralDirLocator(new net.lingala.zip4j.model.Zip64EndCentralDirLocator());
                }
                zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(f + offsetOfStartOfCentralDir);
                j(zipModel, outputStream, f, offsetOfStartOfCentralDir, arrayList);
                i(zipModel, outputStream, arrayList);
            }
            g(zipModel, outputStream, f, offsetOfStartOfCentralDir, arrayList);
            k(zipModel, outputStream, a(arrayList));
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void g(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, int i, long j, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model or output stream is null, cannot write end of central directory record");
        }
        try {
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[8];
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, (int) zipModel.getEndCentralDirRecord().getSignature());
            b(bArr2, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) zipModel.getEndCentralDirRecord().getNoOfThisDisk());
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) zipModel.getEndCentralDirRecord().getNoOfThisDiskStartOfCentralDir());
            b(bArr, list);
            if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null) {
                throw new net.lingala.zip4j.exception.ZipException("invalid central directory/file headers, cannot write end of central directory record");
            }
            int size = zipModel.getCentralDirectory().getFileHeaders().size();
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) (zipModel.isSplitArchive() ? c(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndCentralDirRecord().getNoOfThisDisk()) : size));
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) size);
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, i);
            b(bArr2, list);
            if (j > net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, list);
            } else {
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, j);
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, list);
            }
            int commentLength = zipModel.getEndCentralDirRecord().getComment() != null ? zipModel.getEndCentralDirRecord().getCommentLength() : 0;
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) commentLength);
            b(bArr, list);
            if (commentLength > 0) {
                b(zipModel.getEndCentralDirRecord().getCommentBytes(), list);
            }
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e0, code lost:
    
        r4 = 20;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c4 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ec A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010c A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0126 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x014d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019b A[Catch: Exception -> 0x01e6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0164 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0170 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0189 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e4 A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc A[Catch: Exception -> 0x01e6, TryCatch #0 {Exception -> 0x01e6, blocks: (B:6:0x0009, B:8:0x0079, B:11:0x0086, B:12:0x00af, B:14:0x00c4, B:19:0x00e6, B:21:0x00ec, B:22:0x00ee, B:24:0x010c, B:25:0x0117, B:27:0x0126, B:28:0x014a, B:31:0x0195, B:33:0x019b, B:39:0x014f, B:43:0x0164, B:44:0x0166, B:46:0x0170, B:48:0x0189, B:50:0x0137, B:51:0x0114, B:55:0x00e4, B:56:0x00cc, B:57:0x00a2), top: B:5:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int h(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, java.io.OutputStream outputStream, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        boolean z;
        boolean z2;
        int encodedStringLength;
        int i;
        if (fileHeader == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot write local file header");
        }
        try {
            byte[] bArr = new byte[2];
            int i2 = 4;
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[8];
            byte[] bArr4 = {0, 0};
            byte[] bArr5 = {0, 0, 0, 0};
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, fileHeader.getSignature());
            b(bArr2, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getVersionMadeBy());
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getVersionNeededToExtract());
            b(bArr, list);
            b(fileHeader.getGeneralPurposeFlag(), list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getCompressionMethod());
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, fileHeader.getLastModFileTime());
            b(bArr2, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, (int) fileHeader.getCrc32());
            b(bArr2, list);
            if (fileHeader.getCompressedSize() < net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT && fileHeader.getUncompressedSize() + 50 < net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getCompressedSize());
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, list);
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getUncompressedSize());
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, list);
                z = false;
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getFileNameLength());
                b(bArr, list);
                byte[] bArr6 = new byte[4];
                if (fileHeader.getOffsetLocalHeader() <= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                    net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
                    java.lang.System.arraycopy(bArr3, 0, bArr6, 0, 4);
                    z2 = true;
                } else {
                    net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getOffsetLocalHeader());
                    java.lang.System.arraycopy(bArr3, 0, bArr6, 0, 4);
                    z2 = false;
                }
                if (!z && !z2) {
                    i2 = 0;
                    if (fileHeader.getAesExtraDataRecord() != null) {
                        i2 += 11;
                    }
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i2);
                    b(bArr, list);
                    b(bArr4, list);
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getDiskNumberStart());
                    b(bArr, list);
                    b(bArr4, list);
                    if (fileHeader.getExternalFileAttr() == null) {
                        b(fileHeader.getExternalFileAttr(), list);
                    } else {
                        b(bArr5, list);
                    }
                    b(bArr6, list);
                    if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) {
                        b(net.lingala.zip4j.util.Zip4jUtil.convertCharset(fileHeader.getFileName()), list);
                        encodedStringLength = net.lingala.zip4j.util.Zip4jUtil.getEncodedStringLength(fileHeader.getFileName());
                    } else {
                        byte[] bytes = fileHeader.getFileName().getBytes(zipModel.getFileNameCharset());
                        b(bytes, list);
                        encodedStringLength = bytes.length;
                    }
                    i = 46 + encodedStringLength;
                    if (!z || z2) {
                        zipModel.setZip64Format(true);
                        net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 1);
                        b(bArr, list);
                        int i3 = i + 2;
                        int i4 = !z ? 16 : 0;
                        if (z2) {
                            i4 += 8;
                        }
                        net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i4);
                        b(bArr, list);
                        i = i3 + 2;
                        if (z) {
                            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getUncompressedSize());
                            b(bArr3, list);
                            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getCompressedSize());
                            b(bArr3, list);
                            i = i + 8 + 8;
                        }
                        if (z2) {
                            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, fileHeader.getOffsetLocalHeader());
                            b(bArr3, list);
                            i += 8;
                        }
                    }
                    if (fileHeader.getAesExtraDataRecord() != null) {
                        return i;
                    }
                    net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord = fileHeader.getAesExtraDataRecord();
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getSignature());
                    b(bArr, list);
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getDataSize());
                    b(bArr, list);
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getVersionNumber());
                    b(bArr, list);
                    b(aesExtraDataRecord.getVendorID().getBytes(), list);
                    b(new byte[]{(byte) aesExtraDataRecord.getAesStrength()}, list);
                    net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getCompressionMethod());
                    b(bArr, list);
                    return i + 11;
                }
                if (z2) {
                    i2 += 8;
                }
                if (fileHeader.getAesExtraDataRecord() != null) {
                }
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i2);
                b(bArr, list);
                b(bArr4, list);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getDiskNumberStart());
                b(bArr, list);
                b(bArr4, list);
                if (fileHeader.getExternalFileAttr() == null) {
                }
                b(bArr6, list);
                if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) {
                }
                i = 46 + encodedStringLength;
                if (!z) {
                }
                zipModel.setZip64Format(true);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 1);
                b(bArr, list);
                int i32 = i + 2;
                if (!z) {
                }
                if (z2) {
                }
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i4);
                b(bArr, list);
                i = i32 + 2;
                if (z) {
                }
                if (z2) {
                }
                if (fileHeader.getAesExtraDataRecord() != null) {
                }
            }
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
            java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
            b(bArr2, list);
            b(bArr2, list);
            z = true;
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getFileNameLength());
            b(bArr, list);
            byte[] bArr62 = new byte[4];
            if (fileHeader.getOffsetLocalHeader() <= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
            }
            if (!z) {
                i2 = 0;
                if (fileHeader.getAesExtraDataRecord() != null) {
                }
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i2);
                b(bArr, list);
                b(bArr4, list);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getDiskNumberStart());
                b(bArr, list);
                b(bArr4, list);
                if (fileHeader.getExternalFileAttr() == null) {
                }
                b(bArr62, list);
                if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) {
                }
                i = 46 + encodedStringLength;
                if (!z) {
                }
                zipModel.setZip64Format(true);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 1);
                b(bArr, list);
                int i322 = i + 2;
                if (!z) {
                }
                if (z2) {
                }
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i4);
                b(bArr, list);
                i = i322 + 2;
                if (z) {
                }
                if (z2) {
                }
                if (fileHeader.getAesExtraDataRecord() != null) {
                }
            }
            if (z2) {
            }
            if (fileHeader.getAesExtraDataRecord() != null) {
            }
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i2);
            b(bArr, list);
            b(bArr4, list);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) fileHeader.getDiskNumberStart());
            b(bArr, list);
            b(bArr4, list);
            if (fileHeader.getExternalFileAttr() == null) {
            }
            b(bArr62, list);
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) {
            }
            i = 46 + encodedStringLength;
            if (!z) {
            }
            zipModel.setZip64Format(true);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 1);
            b(bArr, list);
            int i3222 = i + 2;
            if (!z) {
            }
            if (z2) {
            }
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i4);
            b(bArr, list);
            i = i3222 + 2;
            if (z) {
            }
            if (z2) {
            }
            if (fileHeader.getAesExtraDataRecord() != null) {
            }
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final void i(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model or output stream is null, cannot write zip64 end of central directory locator");
        }
        try {
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[8];
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, 117853008);
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, zipModel.getZip64EndCentralDirLocator().getNoOfDiskStartOfZip64EndOfCentralDirRec());
            b(bArr, list);
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr2, 0, zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec());
            b(bArr2, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, zipModel.getZip64EndCentralDirLocator().getTotNumberOfDiscs());
            b(bArr, list);
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void j(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, int i, long j, java.util.List list) throws net.lingala.zip4j.exception.ZipException {
        int i2;
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model or output stream is null, cannot write zip64 end of central directory record");
        }
        try {
            byte[] bArr = new byte[2];
            byte[] bArr2 = {0, 0};
            byte[] bArr3 = new byte[4];
            byte[] bArr4 = new byte[8];
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr3, 0, 101075792);
            b(bArr3, list);
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr4, 0, 44L);
            b(bArr4, list);
            if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
                b(bArr2, list);
                b(bArr2, list);
            } else {
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) ((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(0)).getVersionMadeBy());
                b(bArr, list);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) ((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(0)).getVersionNeededToExtract());
                b(bArr, list);
            }
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr3, 0, zipModel.getEndCentralDirRecord().getNoOfThisDisk());
            b(bArr3, list);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr3, 0, zipModel.getEndCentralDirRecord().getNoOfThisDiskStartOfCentralDir());
            b(bArr3, list);
            if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null) {
                throw new net.lingala.zip4j.exception.ZipException("invalid central directory/file headers, cannot write end of central directory record");
            }
            int size = zipModel.getCentralDirectory().getFileHeaders().size();
            if (zipModel.isSplitArchive()) {
                c(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndCentralDirRecord().getNoOfThisDisk());
                i2 = 0;
            } else {
                i2 = size;
            }
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr4, 0, i2);
            b(bArr4, list);
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr4, 0, size);
            b(bArr4, list);
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr4, 0, i);
            b(bArr4, list);
            net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr4, 0, j);
            b(bArr4, list);
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void k(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, byte[] bArr) throws net.lingala.zip4j.exception.ZipException {
        if (bArr == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid buff to write as zip headers");
        }
        try {
            if ((outputStream instanceof net.lingala.zip4j.io.SplitOutputStream) && ((net.lingala.zip4j.io.SplitOutputStream) outputStream).checkBuffSizeAndStartNextSplitFile(bArr.length)) {
                finalizeZipFile(zipModel, outputStream);
            } else {
                outputStream.write(bArr);
            }
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public void updateLocalFileHeader(net.lingala.zip4j.model.LocalFileHeader localFileHeader, long j, int i, net.lingala.zip4j.model.ZipModel zipModel, byte[] bArr, int i2, net.lingala.zip4j.io.SplitOutputStream splitOutputStream) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.io.SplitOutputStream splitOutputStream2;
        boolean z;
        java.lang.String str;
        if (localFileHeader == null || j < 0 || zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid input parameters, cannot update local file header");
        }
        try {
            if (i2 != splitOutputStream.getCurrSplitFileCounter()) {
                java.io.File file = new java.io.File(zipModel.getZipFile());
                java.lang.String parent = file.getParent();
                java.lang.String zipFileNameWithoutExt = net.lingala.zip4j.util.Zip4jUtil.getZipFileNameWithoutExt(file.getName());
                java.lang.String str2 = parent + java.lang.System.getProperty("file.separator");
                if (i2 < 9) {
                    str = str2 + zipFileNameWithoutExt + ".z0" + (i2 + 1);
                } else {
                    str = str2 + zipFileNameWithoutExt + ".z" + (i2 + 1);
                }
                splitOutputStream2 = new net.lingala.zip4j.io.SplitOutputStream(new java.io.File(str));
                z = true;
            } else {
                splitOutputStream2 = splitOutputStream;
                z = false;
            }
            long filePointer = splitOutputStream2.getFilePointer();
            if (i == 14) {
                splitOutputStream2.seek(j + i);
                splitOutputStream2.write(bArr);
            } else if (i == 18 || i == 22) {
                e(splitOutputStream2, localFileHeader, j, i, bArr, zipModel.isZip64Format());
            }
            if (z) {
                splitOutputStream2.close();
            } else {
                splitOutputStream.seek(filePointer);
            }
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public int writeExtendedLocalHeader(net.lingala.zip4j.model.LocalFileHeader localFileHeader, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException, java.io.IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot write extended local header");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        byte[] bArr = new byte[4];
        net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, 134695760);
        b(bArr, arrayList);
        net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, (int) localFileHeader.getCrc32());
        b(bArr, arrayList);
        long compressedSize = localFileHeader.getCompressedSize();
        if (compressedSize >= 2147483647L) {
            compressedSize = 2147483647L;
        }
        net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, (int) compressedSize);
        b(bArr, arrayList);
        long uncompressedSize = localFileHeader.getUncompressedSize();
        net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr, 0, (int) (uncompressedSize < 2147483647L ? uncompressedSize : 2147483647L));
        b(bArr, arrayList);
        byte[] a = a(arrayList);
        outputStream.write(a);
        return a.length;
    }

    public int writeLocalFileHeader(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.LocalFileHeader localFileHeader, java.io.OutputStream outputStream) throws net.lingala.zip4j.exception.ZipException {
        boolean z;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot write local file header");
        }
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            byte[] bArr = new byte[2];
            byte[] bArr2 = new byte[4];
            byte[] bArr3 = new byte[8];
            byte[] bArr4 = {0, 0, 0, 0, 0, 0, 0, 0};
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, localFileHeader.getSignature());
            b(bArr2, arrayList);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) localFileHeader.getVersionNeededToExtract());
            b(bArr, arrayList);
            b(localFileHeader.getGeneralPurposeFlag(), arrayList);
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) localFileHeader.getCompressionMethod());
            b(bArr, arrayList);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, localFileHeader.getLastModFileTime());
            b(bArr2, arrayList);
            net.lingala.zip4j.util.Raw.writeIntLittleEndian(bArr2, 0, (int) localFileHeader.getCrc32());
            b(bArr2, arrayList);
            if (localFileHeader.getUncompressedSize() + 50 >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) {
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, arrayList);
                b(bArr2, arrayList);
                zipModel.setZip64Format(true);
                localFileHeader.setWriteComprSizeInZip64ExtraRecord(true);
                z = true;
            } else {
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, localFileHeader.getCompressedSize());
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, arrayList);
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, localFileHeader.getUncompressedSize());
                java.lang.System.arraycopy(bArr3, 0, bArr2, 0, 4);
                b(bArr2, arrayList);
                localFileHeader.setWriteComprSizeInZip64ExtraRecord(false);
                z = false;
            }
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) localFileHeader.getFileNameLength());
            b(bArr, arrayList);
            int i = z ? 20 : 0;
            if (localFileHeader.getAesExtraDataRecord() != null) {
                i += 11;
            }
            net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) i);
            b(bArr, arrayList);
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getFileNameCharset())) {
                b(localFileHeader.getFileName().getBytes(zipModel.getFileNameCharset()), arrayList);
            } else {
                b(net.lingala.zip4j.util.Zip4jUtil.convertCharset(localFileHeader.getFileName()), arrayList);
            }
            if (z) {
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 1);
                b(bArr, arrayList);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) 16);
                b(bArr, arrayList);
                net.lingala.zip4j.util.Raw.writeLongLittleEndian(bArr3, 0, localFileHeader.getUncompressedSize());
                b(bArr3, arrayList);
                b(bArr4, arrayList);
            }
            if (localFileHeader.getAesExtraDataRecord() != null) {
                net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord = localFileHeader.getAesExtraDataRecord();
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getSignature());
                b(bArr, arrayList);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getDataSize());
                b(bArr, arrayList);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getVersionNumber());
                b(bArr, arrayList);
                b(aesExtraDataRecord.getVendorID().getBytes(), arrayList);
                b(new byte[]{(byte) aesExtraDataRecord.getAesStrength()}, arrayList);
                net.lingala.zip4j.util.Raw.writeShortLittleEndian(bArr, 0, (short) aesExtraDataRecord.getCompressionMethod());
                b(bArr, arrayList);
            }
            byte[] a = a(arrayList);
            outputStream.write(a);
            return a.length;
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }
}
