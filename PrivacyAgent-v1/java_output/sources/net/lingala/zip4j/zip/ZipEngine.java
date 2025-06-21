package net.lingala.zip4j.zip;

/* loaded from: classes23.dex */
public class ZipEngine {
    public net.lingala.zip4j.model.ZipModel a;

    /* renamed from: net.lingala.zip4j.zip.ZipEngine$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ java.util.ArrayList n;
        public final /* synthetic */ net.lingala.zip4j.model.ZipParameters t;
        public final /* synthetic */ net.lingala.zip4j.progress.ProgressMonitor u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) {
            super(str);
            this.n = arrayList;
            this.t = zipParameters;
            this.u = progressMonitor;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                net.lingala.zip4j.zip.ZipEngine.this.e(this.n, this.t, this.u);
            } catch (net.lingala.zip4j.exception.ZipException unused) {
            }
        }
    }

    public ZipEngine(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null in ZipEngine constructor");
        }
        this.a = zipModel;
    }

    public void addFiles(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null || zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null when adding files");
        }
        if (arrayList.size() <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("no files to add");
        }
        progressMonitor.setCurrentOperation(0);
        progressMonitor.setState(1);
        progressMonitor.setResult(1);
        if (!z) {
            e(arrayList, zipParameters, progressMonitor);
            return;
        }
        progressMonitor.setTotalWork(b(arrayList, zipParameters));
        progressMonitor.setFileName(((java.io.File) arrayList.get(0)).getAbsolutePath());
        new net.lingala.zip4j.zip.ZipEngine.AnonymousClass1(net.lingala.zip4j.util.InternalZipConstants.THREAD_NAME, arrayList, zipParameters, progressMonitor).start();
    }

    public void addFolderToZip(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        java.lang.String absolutePath;
        if (file == null || zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null, cannot add folder to zip");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileExists(file.getAbsolutePath())) {
            throw new net.lingala.zip4j.exception.ZipException("input folder does not exist");
        }
        if (!file.isDirectory()) {
            throw new net.lingala.zip4j.exception.ZipException("input file is not a folder, user addFileToZip method to add files");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileReadAccess(file.getAbsolutePath())) {
            throw new net.lingala.zip4j.exception.ZipException("cannot read folder: " + file.getAbsolutePath());
        }
        if (zipParameters.isIncludeRootFolder()) {
            absolutePath = "";
            if (file.getAbsolutePath() != null) {
                if (file.getAbsoluteFile().getParentFile() != null) {
                    absolutePath = file.getAbsoluteFile().getParentFile().getAbsolutePath();
                }
            } else if (file.getParentFile() != null) {
                absolutePath = file.getParentFile().getAbsolutePath();
            }
        } else {
            absolutePath = file.getAbsolutePath();
        }
        zipParameters.setDefaultFolderPath(absolutePath);
        java.util.ArrayList filesInDirectoryRec = net.lingala.zip4j.util.Zip4jUtil.getFilesInDirectoryRec(file, zipParameters.isReadHiddenFiles());
        if (zipParameters.isIncludeRootFolder()) {
            if (filesInDirectoryRec == null) {
                filesInDirectoryRec = new java.util.ArrayList();
            }
            filesInDirectoryRec.add(file);
        }
        addFiles(filesInDirectoryRec, zipParameters, progressMonitor, z);
    }

    public void addStreamToZip(java.io.InputStream inputStream, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (inputStream == null || zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null, cannot add stream to zip");
        }
        net.lingala.zip4j.io.ZipOutputStream zipOutputStream = null;
        try {
            try {
                c(zipParameters);
                boolean checkFileExists = net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a.getZipFile());
                net.lingala.zip4j.io.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.SplitOutputStream(new java.io.File(this.a.getZipFile()), this.a.getSplitLength());
                net.lingala.zip4j.io.ZipOutputStream zipOutputStream2 = new net.lingala.zip4j.io.ZipOutputStream(splitOutputStream, this.a);
                if (checkFileExists) {
                    try {
                        if (this.a.getEndCentralDirRecord() == null) {
                            throw new net.lingala.zip4j.exception.ZipException("invalid end of central directory record");
                        }
                        splitOutputStream.seek(this.a.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    } catch (net.lingala.zip4j.exception.ZipException e) {
                        throw e;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        zipOutputStream = zipOutputStream2;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[4096];
                zipOutputStream2.putNextEntry(null, zipParameters);
                if (!zipParameters.getFileNameInZip().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !zipParameters.getFileNameInZip().endsWith("\\")) {
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            zipOutputStream2.write(bArr, 0, read);
                        }
                    }
                }
                zipOutputStream2.closeEntry();
                zipOutputStream2.finish();
                try {
                    zipOutputStream2.close();
                } catch (java.io.IOException unused2) {
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (net.lingala.zip4j.exception.ZipException e3) {
            throw e3;
        } catch (java.lang.Exception e4) {
            e = e4;
        }
    }

    public final long b(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("file list is null, cannot calculate total work");
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) instanceof java.io.File) && ((java.io.File) arrayList.get(i)).exists()) {
                j += (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 0) ? net.lingala.zip4j.util.Zip4jUtil.getFileLengh((java.io.File) arrayList.get(i)) * 2 : net.lingala.zip4j.util.Zip4jUtil.getFileLengh((java.io.File) arrayList.get(i));
                if (this.a.getCentralDirectory() != null && this.a.getCentralDirectory().getFileHeaders() != null && this.a.getCentralDirectory().getFileHeaders().size() > 0) {
                    net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.util.Zip4jUtil.getFileHeader(this.a, net.lingala.zip4j.util.Zip4jUtil.getRelativeFileName(((java.io.File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        j += net.lingala.zip4j.util.Zip4jUtil.getFileLengh(new java.io.File(this.a.getZipFile())) - fileHeader.getCompressedSize();
                    }
                }
            }
        }
        return j;
    }

    public final void c(net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot validate zip parameters");
        }
        if (zipParameters.getCompressionMethod() != 0 && zipParameters.getCompressionMethod() != 8) {
            throw new net.lingala.zip4j.exception.ZipException("unsupported compression type");
        }
        if (zipParameters.getCompressionMethod() == 8 && zipParameters.getCompressionLevel() < 0 && zipParameters.getCompressionLevel() > 9) {
            throw new net.lingala.zip4j.exception.ZipException("invalid compression level. compression level dor deflate should be in the range of 0-9");
        }
        if (!zipParameters.isEncryptFiles()) {
            zipParameters.setAesKeyStrength(-1);
            zipParameters.setEncryptionMethod(-1);
        } else {
            if (zipParameters.getEncryptionMethod() != 0 && zipParameters.getEncryptionMethod() != 99) {
                throw new net.lingala.zip4j.exception.ZipException("unsupported encryption method");
            }
            if (zipParameters.getPassword() == null || zipParameters.getPassword().length <= 0) {
                throw new net.lingala.zip4j.exception.ZipException("input password is empty or null");
            }
        }
    }

    public final net.lingala.zip4j.model.EndCentralDirRecord d() {
        net.lingala.zip4j.model.EndCentralDirRecord endCentralDirRecord = new net.lingala.zip4j.model.EndCentralDirRecord();
        endCentralDirRecord.setSignature(net.lingala.zip4j.util.InternalZipConstants.ENDSIG);
        endCentralDirRecord.setNoOfThisDisk(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDir(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(0);
        endCentralDirRecord.setOffsetOfStartOfCentralDir(0L);
        return endCentralDirRecord;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0127, code lost:
    
        r15.setResult(3);
        r15.setState(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012d, code lost:
    
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.io.ZipOutputStream zipOutputStream;
        if (arrayList == null || zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null when adding files");
        }
        if (arrayList.size() <= 0) {
            throw new net.lingala.zip4j.exception.ZipException("no files to add");
        }
        if (this.a.getEndCentralDirRecord() == null) {
            this.a.setEndCentralDirRecord(d());
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                c(zipParameters);
                g(arrayList, zipParameters, progressMonitor);
                boolean checkFileExists = net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a.getZipFile());
                net.lingala.zip4j.io.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.SplitOutputStream(new java.io.File(this.a.getZipFile()), this.a.getSplitLength());
                zipOutputStream = new net.lingala.zip4j.io.ZipOutputStream(splitOutputStream, this.a);
                if (checkFileExists) {
                    try {
                        if (this.a.getEndCentralDirRecord() == null) {
                            throw new net.lingala.zip4j.exception.ZipException("invalid end of central directory record");
                        }
                        splitOutputStream.seek(this.a.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    } catch (net.lingala.zip4j.exception.ZipException e) {
                        e = e;
                        progressMonitor.endProgressMonitorError(e);
                        throw e;
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        progressMonitor.endProgressMonitorError(e);
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                        }
                        if (zipOutputStream != null) {
                        }
                    }
                }
                byte[] bArr = new byte[4096];
                loop0: for (int i = 0; i < arrayList.size(); i++) {
                    if (progressMonitor.isCancelAllTasks()) {
                        progressMonitor.setResult(3);
                        progressMonitor.setState(0);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException unused) {
                            }
                        }
                        try {
                            zipOutputStream.close();
                            return;
                        } catch (java.io.IOException unused2) {
                            return;
                        }
                    }
                    net.lingala.zip4j.model.ZipParameters zipParameters2 = (net.lingala.zip4j.model.ZipParameters) zipParameters.clone();
                    progressMonitor.setFileName(((java.io.File) arrayList.get(i)).getAbsolutePath());
                    if (!((java.io.File) arrayList.get(i)).isDirectory()) {
                        if (zipParameters2.isEncryptFiles() && zipParameters2.getEncryptionMethod() == 0) {
                            progressMonitor.setCurrentOperation(3);
                            zipParameters2.setSourceFileCRC((int) net.lingala.zip4j.util.CRCUtil.computeFileCRC(((java.io.File) arrayList.get(i)).getAbsolutePath(), progressMonitor));
                            progressMonitor.setCurrentOperation(0);
                            if (progressMonitor.isCancelAllTasks()) {
                                progressMonitor.setResult(3);
                                progressMonitor.setState(0);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException unused3) {
                                    }
                                }
                                try {
                                    zipOutputStream.close();
                                    return;
                                } catch (java.io.IOException unused4) {
                                    return;
                                }
                            }
                        }
                        if (net.lingala.zip4j.util.Zip4jUtil.getFileLengh((java.io.File) arrayList.get(i)) == 0) {
                            zipParameters2.setCompressionMethod(0);
                        }
                    }
                    zipOutputStream.putNextEntry((java.io.File) arrayList.get(i), zipParameters2);
                    if (((java.io.File) arrayList.get(i)).isDirectory()) {
                        zipOutputStream.closeEntry();
                    } else {
                        java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream((java.io.File) arrayList.get(i));
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    zipOutputStream.closeEntry();
                                    fileInputStream2.close();
                                    fileInputStream = fileInputStream2;
                                    break;
                                } else {
                                    if (progressMonitor.isCancelAllTasks()) {
                                        break loop0;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                    progressMonitor.updateWorkCompleted(read);
                                }
                            } catch (net.lingala.zip4j.exception.ZipException e3) {
                                e = e3;
                                progressMonitor.endProgressMonitorError(e);
                                throw e;
                            } catch (java.lang.Exception e4) {
                                e = e4;
                                progressMonitor.endProgressMonitorError(e);
                                throw new net.lingala.zip4j.exception.ZipException(e);
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (java.io.IOException unused5) {
                                    }
                                }
                                if (zipOutputStream != null) {
                                    throw th;
                                }
                                try {
                                    zipOutputStream.close();
                                    throw th;
                                } catch (java.io.IOException unused6) {
                                    throw th;
                                }
                            }
                        }
                    }
                }
                zipOutputStream.finish();
                progressMonitor.endProgressMonitorSuccess();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused7) {
                    }
                }
                try {
                    zipOutputStream.close();
                    return;
                } catch (java.io.IOException unused8) {
                    return;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                zipOutputStream = null;
            }
        } catch (net.lingala.zip4j.exception.ZipException e5) {
            e = e5;
        } catch (java.lang.Exception e6) {
            e = e6;
        } catch (java.lang.Throwable th4) {
            th = th4;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.close();
        } catch (java.io.IOException unused9) {
        }
    }

    public final java.io.RandomAccessFile f() throws net.lingala.zip4j.exception.ZipException {
        java.lang.String zipFile = this.a.getZipFile();
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipFile)) {
            throw new net.lingala.zip4j.exception.ZipException("invalid output path");
        }
        try {
            java.io.File file = new java.io.File(zipFile);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            return new java.io.RandomAccessFile(file, "rw");
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final void g(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.ZipModel zipModel = this.a;
        if (zipModel == null || zipModel.getCentralDirectory() == null || this.a.getCentralDirectory().getFileHeaders() == null || this.a.getCentralDirectory().getFileHeaders().size() <= 0) {
            return;
        }
        java.io.RandomAccessFile randomAccessFile = null;
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                try {
                    net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.util.Zip4jUtil.getFileHeader(this.a, net.lingala.zip4j.util.Zip4jUtil.getRelativeFileName(((java.io.File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            randomAccessFile = null;
                        }
                        net.lingala.zip4j.util.ArchiveMaintainer archiveMaintainer = new net.lingala.zip4j.util.ArchiveMaintainer();
                        progressMonitor.setCurrentOperation(2);
                        java.util.HashMap initRemoveZipFile = archiveMaintainer.initRemoveZipFile(this.a, fileHeader, progressMonitor);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(3);
                            progressMonitor.setState(0);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (java.io.IOException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        progressMonitor.setCurrentOperation(0);
                        if (randomAccessFile == null) {
                            randomAccessFile = f();
                            if (initRemoveZipFile != null && initRemoveZipFile.get(net.lingala.zip4j.util.InternalZipConstants.OFFSET_CENTRAL_DIR) != null) {
                                try {
                                    long parseLong = java.lang.Long.parseLong((java.lang.String) initRemoveZipFile.get(net.lingala.zip4j.util.InternalZipConstants.OFFSET_CENTRAL_DIR));
                                    if (parseLong >= 0) {
                                        randomAccessFile.seek(parseLong);
                                    }
                                } catch (java.lang.NumberFormatException unused2) {
                                    throw new net.lingala.zip4j.exception.ZipException("NumberFormatException while parsing offset central directory. Cannot update already existing file header");
                                } catch (java.lang.Exception unused3) {
                                    throw new net.lingala.zip4j.exception.ZipException("Error while parsing offset central directory. Cannot update already existing file header");
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (java.io.IOException e) {
                    throw new net.lingala.zip4j.exception.ZipException(e);
                }
            } catch (java.lang.Throwable th) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        }
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (java.io.IOException unused5) {
            }
        }
    }
}
