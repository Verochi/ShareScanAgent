package net.lingala.zip4j.util;

/* loaded from: classes23.dex */
public class ArchiveMaintainer {

    /* renamed from: net.lingala.zip4j.util.ArchiveMaintainer$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ net.lingala.zip4j.model.ZipModel n;
        public final /* synthetic */ net.lingala.zip4j.model.FileHeader t;
        public final /* synthetic */ net.lingala.zip4j.progress.ProgressMonitor u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) {
            super(str);
            this.n = zipModel;
            this.t = fileHeader;
            this.u = progressMonitor;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                net.lingala.zip4j.util.ArchiveMaintainer.this.initRemoveZipFile(this.n, this.t, this.u);
                this.u.endProgressMonitorSuccess();
            } catch (net.lingala.zip4j.exception.ZipException unused) {
            }
        }
    }

    /* renamed from: net.lingala.zip4j.util.ArchiveMaintainer$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        public final /* synthetic */ net.lingala.zip4j.model.ZipModel n;
        public final /* synthetic */ java.io.File t;
        public final /* synthetic */ net.lingala.zip4j.progress.ProgressMonitor u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, net.lingala.zip4j.model.ZipModel zipModel, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) {
            super(str);
            this.n = zipModel;
            this.t = file;
            this.u = progressMonitor;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                net.lingala.zip4j.util.ArchiveMaintainer.this.g(this.n, this.t, this.u);
            } catch (net.lingala.zip4j.exception.ZipException unused) {
            }
        }
    }

    public final long b(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        long j = 0;
        if (zipModel.isSplitArchive()) {
            int noOfThisDisk = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
            java.lang.String zipFile = zipModel.getZipFile();
            for (int i = 0; i <= noOfThisDisk; i++) {
                j += net.lingala.zip4j.util.Zip4jUtil.getFileLengh(new java.io.File(zipModel.getEndCentralDirRecord().getNoOfThisDisk() == 0 ? zipModel.getZipFile() : zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z01"));
            }
        }
        return j;
    }

    public final long c(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        return net.lingala.zip4j.util.Zip4jUtil.getFileLengh(new java.io.File(zipModel.getZipFile())) - fileHeader.getCompressedSize();
    }

    public final void d(java.io.RandomAccessFile randomAccessFile, java.io.OutputStream outputStream, long j, long j2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        if (randomAccessFile == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input or output stream is null, cannot copy file");
        }
        long j3 = 0;
        if (j < 0) {
            throw new net.lingala.zip4j.exception.ZipException("starting offset is negative, cannot copy file");
        }
        if (j2 < 0) {
            throw new net.lingala.zip4j.exception.ZipException("end offset is negative, cannot copy file");
        }
        if (j > j2) {
            throw new net.lingala.zip4j.exception.ZipException("start offset is greater than end offset, cannot copy file");
        }
        if (j == j2) {
            return;
        }
        if (progressMonitor.isCancelAllTasks()) {
            progressMonitor.setResult(3);
            progressMonitor.setState(0);
            return;
        }
        try {
            randomAccessFile.seek(j);
            long j4 = j2 - j;
            byte[] bArr = j4 < 4096 ? new byte[(int) j4] : new byte[4096];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
                long j5 = read;
                progressMonitor.updateWorkCompleted(j5);
                if (progressMonitor.isCancelAllTasks()) {
                    progressMonitor.setResult(3);
                    return;
                }
                j3 += j5;
                if (j3 == j4) {
                    return;
                }
                if (bArr.length + j3 > j4) {
                    bArr = new byte[(int) (j4 - j3)];
                }
            }
        } catch (java.io.IOException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final java.io.RandomAccessFile e(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || !net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipModel.getZipFile())) {
            throw new net.lingala.zip4j.exception.ZipException("input parameter is null in getFilePointer, cannot create file handler to remove file");
        }
        try {
            return new java.io.RandomAccessFile(new java.io.File(zipModel.getZipFile()), str);
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public final java.io.RandomAccessFile f(net.lingala.zip4j.model.ZipModel zipModel, int i) throws net.lingala.zip4j.exception.ZipException {
        java.lang.String str;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot create split file handler");
        }
        if (i < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invlaid part number, cannot create split file handler");
        }
        try {
            java.lang.String zipFile = zipModel.getZipFile();
            if (i == zipModel.getEndCentralDirRecord().getNoOfThisDisk()) {
                str = zipModel.getZipFile();
            } else if (i >= 9) {
                str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z" + (i + 1);
            } else {
                str = zipFile.substring(0, zipFile.lastIndexOf(".")) + ".z0" + (i + 1);
            }
            java.io.File file = new java.io.File(str);
            if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(file)) {
                return new java.io.RandomAccessFile(file, "r");
            }
            throw new net.lingala.zip4j.exception.ZipException("split file does not exist: " + str);
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0086 A[Catch: all -> 0x0075, Exception -> 0x0078, IOException -> 0x007b, TRY_LEAVE, TryCatch #22 {IOException -> 0x007b, Exception -> 0x0078, all -> 0x0075, blocks: (B:73:0x003a, B:75:0x0040, B:77:0x004a, B:79:0x0058, B:20:0x0086), top: B:72:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cc A[Catch: all -> 0x00e0, Exception -> 0x00e8, IOException -> 0x00f0, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x00f0, blocks: (B:25:0x00ab, B:35:0x00bc, B:27:0x00cc), top: B:24:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(net.lingala.zip4j.model.ZipModel zipModel, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        java.io.RandomAccessFile randomAccessFile;
        long j;
        int i;
        boolean z;
        net.lingala.zip4j.util.ArchiveMaintainer archiveMaintainer = this;
        net.lingala.zip4j.model.ZipModel zipModel2 = zipModel;
        if (zipModel2 == null) {
            net.lingala.zip4j.exception.ZipException zipException = new net.lingala.zip4j.exception.ZipException("one of the input parameters is null, cannot merge split zip file");
            progressMonitor.endProgressMonitorError(zipException);
            throw zipException;
        }
        if (!zipModel.isSplitArchive()) {
            net.lingala.zip4j.exception.ZipException zipException2 = new net.lingala.zip4j.exception.ZipException("archive not a split zip file");
            progressMonitor.endProgressMonitorError(zipException2);
            throw zipException2;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.OutputStream outputStream = null;
        java.io.RandomAccessFile randomAccessFile2 = null;
        outputStream = null;
        try {
            try {
                int noOfThisDisk = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
                if (noOfThisDisk > 0) {
                    java.io.OutputStream h = archiveMaintainer.h(file);
                    long j2 = 0;
                    long j3 = 0;
                    boolean z2 = false;
                    int i2 = 0;
                    while (i2 <= noOfThisDisk) {
                        try {
                            randomAccessFile = archiveMaintainer.f(zipModel2, i2);
                            try {
                                java.lang.Long l = new java.lang.Long(randomAccessFile.length());
                                try {
                                    try {
                                        if (i2 == 0) {
                                            try {
                                                if (zipModel.getCentralDirectory() != null && zipModel.getCentralDirectory().getFileHeaders() != null && zipModel.getCentralDirectory().getFileHeaders().size() > 0) {
                                                    randomAccessFile.seek(j2);
                                                    randomAccessFile.read(new byte[4]);
                                                    j = j3;
                                                    if (net.lingala.zip4j.util.Raw.readIntLittleEndian(r8, 0) == 134695760) {
                                                        i = 4;
                                                        z = true;
                                                        if (i2 == noOfThisDisk) {
                                                            l = new java.lang.Long(zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                                                        }
                                                        java.lang.Long l2 = l;
                                                        long j4 = i;
                                                        long j5 = j;
                                                        int i3 = i2;
                                                        d(randomAccessFile, h, j4, l2.longValue(), progressMonitor);
                                                        j3 = j5 + (l2.longValue() - j4);
                                                        if (progressMonitor.isCancelAllTasks()) {
                                                            progressMonitor.setResult(3);
                                                            progressMonitor.setState(0);
                                                            if (h != null) {
                                                                try {
                                                                    h.close();
                                                                } catch (java.io.IOException unused) {
                                                                }
                                                            }
                                                            try {
                                                                randomAccessFile.close();
                                                                return;
                                                            } catch (java.io.IOException unused2) {
                                                                return;
                                                            }
                                                        }
                                                        arrayList.add(l2);
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (java.io.IOException unused3) {
                                                        }
                                                        i2 = i3 + 1;
                                                        j2 = 0;
                                                        archiveMaintainer = this;
                                                        zipModel2 = zipModel;
                                                        z2 = z;
                                                        randomAccessFile2 = randomAccessFile;
                                                    }
                                                    z = z2;
                                                    i = 0;
                                                    if (i2 == noOfThisDisk) {
                                                    }
                                                    java.lang.Long l22 = l;
                                                    long j42 = i;
                                                    long j52 = j;
                                                    int i32 = i2;
                                                    d(randomAccessFile, h, j42, l22.longValue(), progressMonitor);
                                                    j3 = j52 + (l22.longValue() - j42);
                                                    if (progressMonitor.isCancelAllTasks()) {
                                                    }
                                                }
                                            } catch (java.io.IOException e) {
                                                e = e;
                                                progressMonitor.endProgressMonitorError(e);
                                                throw new net.lingala.zip4j.exception.ZipException(e);
                                            } catch (java.lang.Exception e2) {
                                                e = e2;
                                                progressMonitor.endProgressMonitorError(e);
                                                throw new net.lingala.zip4j.exception.ZipException(e);
                                            } catch (java.lang.Throwable th) {
                                                th = th;
                                                outputStream = h;
                                                if (outputStream != null) {
                                                }
                                                if (randomAccessFile == null) {
                                                }
                                            }
                                        }
                                        d(randomAccessFile, h, j42, l22.longValue(), progressMonitor);
                                        j3 = j52 + (l22.longValue() - j42);
                                        if (progressMonitor.isCancelAllTasks()) {
                                        }
                                    } catch (java.io.IOException e3) {
                                        e = e3;
                                        progressMonitor.endProgressMonitorError(e);
                                        throw new net.lingala.zip4j.exception.ZipException(e);
                                    }
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                    progressMonitor.endProgressMonitorError(e);
                                    throw new net.lingala.zip4j.exception.ZipException(e);
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    outputStream = h;
                                    randomAccessFile = randomAccessFile;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (java.io.IOException unused4) {
                                        }
                                    }
                                    if (randomAccessFile == null) {
                                        throw th;
                                    }
                                    try {
                                        randomAccessFile.close();
                                        throw th;
                                    } catch (java.io.IOException unused5) {
                                        throw th;
                                    }
                                }
                                j = j3;
                                z = z2;
                                i = 0;
                                if (i2 == noOfThisDisk) {
                                }
                                java.lang.Long l222 = l;
                                long j422 = i;
                                long j522 = j;
                                int i322 = i2;
                            } catch (java.io.IOException e5) {
                                e = e5;
                            } catch (java.lang.Exception e6) {
                                e = e6;
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                        } catch (java.io.IOException e7) {
                            e = e7;
                            progressMonitor.endProgressMonitorError(e);
                            throw new net.lingala.zip4j.exception.ZipException(e);
                        } catch (java.lang.Exception e8) {
                            e = e8;
                            progressMonitor.endProgressMonitorError(e);
                            throw new net.lingala.zip4j.exception.ZipException(e);
                        } catch (java.lang.Throwable th4) {
                            th = th4;
                            randomAccessFile = randomAccessFile2;
                            outputStream = h;
                            if (outputStream != null) {
                            }
                            if (randomAccessFile == null) {
                            }
                        }
                    }
                    long j6 = j3;
                    net.lingala.zip4j.model.ZipModel zipModel3 = (net.lingala.zip4j.model.ZipModel) zipModel.clone();
                    zipModel3.getEndCentralDirRecord().setOffsetOfStartOfCentralDir(j6);
                    try {
                        n(zipModel3, arrayList, z2);
                        new net.lingala.zip4j.core.HeaderWriter().finalizeZipFileWithoutValidations(zipModel3, h);
                        progressMonitor.endProgressMonitorSuccess();
                        if (h != null) {
                            try {
                                h.close();
                            } catch (java.io.IOException unused6) {
                            }
                        }
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (java.io.IOException unused7) {
                            }
                        }
                    } catch (java.io.IOException e9) {
                        e = e9;
                        progressMonitor.endProgressMonitorError(e);
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Exception e10) {
                        e = e10;
                        progressMonitor.endProgressMonitorError(e);
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        outputStream = h;
                        if (outputStream != null) {
                        }
                        if (randomAccessFile == null) {
                        }
                    }
                } else {
                    try {
                        throw new net.lingala.zip4j.exception.ZipException("corrupt zip model, archive not a split zip file");
                    } catch (java.io.IOException e11) {
                        e = e11;
                        progressMonitor.endProgressMonitorError(e);
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Exception e12) {
                        e = e12;
                        progressMonitor.endProgressMonitorError(e);
                        throw new net.lingala.zip4j.exception.ZipException(e);
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        randomAccessFile = null;
                        if (outputStream != null) {
                        }
                        if (randomAccessFile == null) {
                        }
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
            }
        } catch (java.io.IOException e13) {
            e = e13;
        } catch (java.lang.Exception e14) {
            e = e14;
        } catch (java.lang.Throwable th8) {
            th = th8;
        }
    }

    public final java.io.OutputStream h(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("outFile is null, cannot create outputstream");
        }
        try {
            return new java.io.FileOutputStream(file);
        } catch (java.io.FileNotFoundException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void i(java.io.File file, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!file.delete()) {
            throw new net.lingala.zip4j.exception.ZipException("cannot delete old zip file");
        }
        if (!new java.io.File(str).renameTo(file)) {
            throw new net.lingala.zip4j.exception.ZipException("cannot rename modified zip file");
        }
    }

    public void initProgressMonitorForMergeOp(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot calculate total work for merge op");
        }
        progressMonitor.setCurrentOperation(4);
        progressMonitor.setFileName(zipModel.getZipFile());
        progressMonitor.setTotalWork(b(zipModel));
        progressMonitor.setState(1);
    }

    public void initProgressMonitorForRemoveOp(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || fileHeader == null || progressMonitor == null) {
            throw new net.lingala.zip4j.exception.ZipException("one of the input parameters is null, cannot calculate total work");
        }
        progressMonitor.setCurrentOperation(2);
        progressMonitor.setFileName(fileHeader.getFileName());
        progressMonitor.setTotalWork(c(zipModel, fileHeader));
        progressMonitor.setState(1);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01c6: MOVE (r8 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:164:0x01c4 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01c9: MOVE (r8 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:162:0x01c9 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01cc: MOVE (r8 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:160:0x01cc */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x041b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:262:0x041b */
    public java.util.HashMap initRemoveZipFile(net.lingala.zip4j.model.ZipModel r32, net.lingala.zip4j.model.FileHeader r33, net.lingala.zip4j.progress.ProgressMonitor r34) throws net.lingala.zip4j.exception.ZipException {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.util.ArchiveMaintainer.initRemoveZipFile(net.lingala.zip4j.model.ZipModel, net.lingala.zip4j.model.FileHeader, net.lingala.zip4j.progress.ProgressMonitor):java.util.HashMap");
    }

    public final void j(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        try {
            if (zipModel == null) {
                throw new net.lingala.zip4j.exception.ZipException("zip model is null - cannot update end of central directory for split zip model");
            }
            if (zipModel.getCentralDirectory() == null) {
                throw new net.lingala.zip4j.exception.ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
            zipModel.getEndCentralDirRecord().setNoOfThisDisk(0);
            zipModel.getEndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
            zipModel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDir(zipModel.getCentralDirectory().getFileHeaders().size());
            zipModel.getEndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipModel.getCentralDirectory().getFileHeaders().size());
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void k(net.lingala.zip4j.model.ZipModel zipModel, java.util.ArrayList arrayList, boolean z) throws net.lingala.zip4j.exception.ZipException {
        try {
            if (zipModel.getCentralDirectory() == null) {
                throw new net.lingala.zip4j.exception.ZipException("corrupt zip model - getCentralDirectory, cannot update split zip model");
            }
            int size = zipModel.getCentralDirectory().getFileHeaders().size();
            int i = z ? 4 : 0;
            for (int i2 = 0; i2 < size; i2++) {
                long j = 0;
                for (int i3 = 0; i3 < ((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).getDiskNumberStart(); i3++) {
                    j += ((java.lang.Long) arrayList.get(i3)).longValue();
                }
                ((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).setOffsetLocalHeader((((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).getOffsetLocalHeader() + j) - i);
                ((net.lingala.zip4j.model.FileHeader) zipModel.getCentralDirectory().getFileHeaders().get(i2)).setDiskNumberStart(0);
            }
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    public final void l(net.lingala.zip4j.model.ZipModel zipModel, java.util.ArrayList arrayList) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot update split Zip64 end of central directory locator");
        }
        if (zipModel.getZip64EndCentralDirLocator() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirLocator().setNoOfDiskStartOfZip64EndOfCentralDirRec(0);
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((java.lang.Long) arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirLocator().setOffsetZip64EndOfCentralDirRec(zipModel.getZip64EndCentralDirLocator().getOffsetZip64EndOfCentralDirRec() + j);
        zipModel.getZip64EndCentralDirLocator().setTotNumberOfDiscs(1);
    }

    public final void m(net.lingala.zip4j.model.ZipModel zipModel, java.util.ArrayList arrayList) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot update split Zip64 end of central directory record");
        }
        if (zipModel.getZip64EndCentralDirRecord() == null) {
            return;
        }
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDisk(0);
        zipModel.getZip64EndCentralDirRecord().setNoOfThisDiskStartOfCentralDir(0);
        zipModel.getZip64EndCentralDirRecord().setTotNoOfEntriesInCentralDirOnThisDisk(zipModel.getEndCentralDirRecord().getTotNoOfEntriesInCentralDir());
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += ((java.lang.Long) arrayList.get(i)).longValue();
        }
        zipModel.getZip64EndCentralDirRecord().setOffsetStartCenDirWRTStartDiskNo(zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo() + j);
    }

    public void mergeSplitZipFiles(net.lingala.zip4j.model.ZipModel zipModel, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (z) {
            new net.lingala.zip4j.util.ArchiveMaintainer.AnonymousClass2(net.lingala.zip4j.util.InternalZipConstants.THREAD_NAME, zipModel, file, progressMonitor).start();
        } else {
            g(zipModel, file, progressMonitor);
        }
    }

    public final void n(net.lingala.zip4j.model.ZipModel zipModel, java.util.ArrayList arrayList, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot update split zip model");
        }
        zipModel.setSplitArchive(false);
        k(zipModel, arrayList, z);
        j(zipModel);
        if (zipModel.isZip64Format()) {
            l(zipModel, arrayList);
            m(zipModel, arrayList);
        }
    }

    public java.util.HashMap removeZipFile(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (z) {
            new net.lingala.zip4j.util.ArchiveMaintainer.AnonymousClass1(net.lingala.zip4j.util.InternalZipConstants.THREAD_NAME, zipModel, fileHeader, progressMonitor).start();
            return null;
        }
        java.util.HashMap initRemoveZipFile = initRemoveZipFile(zipModel, fileHeader, progressMonitor);
        progressMonitor.endProgressMonitorSuccess();
        return initRemoveZipFile;
    }

    public void setComment(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.core.HeaderWriter headerWriter;
        net.lingala.zip4j.io.SplitOutputStream splitOutputStream;
        if (str == null) {
            throw new net.lingala.zip4j.exception.ZipException("comment is null, cannot update Zip file with comment");
        }
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zipModel is null, cannot update Zip file with comment");
        }
        byte[] bytes = str.getBytes();
        int length = str.length();
        if (net.lingala.zip4j.util.Zip4jUtil.isSupportedCharset(net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT)) {
            try {
                java.lang.String str2 = new java.lang.String(str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT), net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT);
                byte[] bytes2 = str2.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT);
                length = str2.length();
                str = str2;
                bytes = bytes2;
            } catch (java.io.UnsupportedEncodingException unused) {
                bytes = str.getBytes();
                length = str.length();
            }
        }
        if (length > 65535) {
            throw new net.lingala.zip4j.exception.ZipException("comment length exceeds maximum length");
        }
        zipModel.getEndCentralDirRecord().setComment(str);
        zipModel.getEndCentralDirRecord().setCommentBytes(bytes);
        zipModel.getEndCentralDirRecord().setCommentLength(length);
        net.lingala.zip4j.io.SplitOutputStream splitOutputStream2 = null;
        try {
            try {
                headerWriter = new net.lingala.zip4j.core.HeaderWriter();
                splitOutputStream = new net.lingala.zip4j.io.SplitOutputStream(zipModel.getZipFile());
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.FileNotFoundException e) {
            e = e;
        } catch (java.io.IOException e2) {
            e = e2;
        }
        try {
            if (zipModel.isZip64Format()) {
                splitOutputStream.seek(zipModel.getZip64EndCentralDirRecord().getOffsetStartCenDirWRTStartDiskNo());
            } else {
                splitOutputStream.seek(zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
            }
            headerWriter.finalizeZipFileWithoutValidations(zipModel, splitOutputStream);
            try {
                splitOutputStream.close();
            } catch (java.io.IOException unused2) {
            }
        } catch (java.io.FileNotFoundException e3) {
            e = e3;
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.io.IOException e4) {
            e = e4;
            throw new net.lingala.zip4j.exception.ZipException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            splitOutputStream2 = splitOutputStream;
            if (splitOutputStream2 != null) {
                try {
                    splitOutputStream2.close();
                } catch (java.io.IOException unused3) {
                }
            }
            throw th;
        }
    }
}
