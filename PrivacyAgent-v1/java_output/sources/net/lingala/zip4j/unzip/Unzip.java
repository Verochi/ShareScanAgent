package net.lingala.zip4j.unzip;

/* loaded from: classes23.dex */
public class Unzip {
    public net.lingala.zip4j.model.ZipModel a;

    /* renamed from: net.lingala.zip4j.unzip.Unzip$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.Thread {
        public final /* synthetic */ java.util.ArrayList n;
        public final /* synthetic */ net.lingala.zip4j.model.UnzipParameters t;
        public final /* synthetic */ net.lingala.zip4j.progress.ProgressMonitor u;
        public final /* synthetic */ java.lang.String v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.util.ArrayList arrayList, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, java.lang.String str2) {
            super(str);
            this.n = arrayList;
            this.t = unzipParameters;
            this.u = progressMonitor;
            this.v = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                net.lingala.zip4j.unzip.Unzip.this.e(this.n, this.t, this.u, this.v);
                this.u.endProgressMonitorSuccess();
            } catch (net.lingala.zip4j.exception.ZipException unused) {
            }
        }
    }

    /* renamed from: net.lingala.zip4j.unzip.Unzip$2, reason: invalid class name */
    public class AnonymousClass2 extends java.lang.Thread {
        public final /* synthetic */ net.lingala.zip4j.model.FileHeader n;
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ net.lingala.zip4j.model.UnzipParameters u;
        public final /* synthetic */ java.lang.String v;
        public final /* synthetic */ net.lingala.zip4j.progress.ProgressMonitor w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str3, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) {
            super(str);
            this.n = fileHeader;
            this.t = str2;
            this.u = unzipParameters;
            this.v = str3;
            this.w = progressMonitor;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                net.lingala.zip4j.unzip.Unzip.this.f(this.n, this.t, this.u, this.v, this.w);
                this.w.endProgressMonitorSuccess();
            } catch (net.lingala.zip4j.exception.ZipException unused) {
            }
        }
    }

    public Unzip(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("ZipModel is null");
        }
        this.a = zipModel;
    }

    public final long c(java.util.ArrayList arrayList) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("fileHeaders is null, cannot calculate total work");
        }
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            net.lingala.zip4j.model.FileHeader fileHeader = (net.lingala.zip4j.model.FileHeader) arrayList.get(i);
            j += (fileHeader.getZip64ExtendedInfo() == null || fileHeader.getZip64ExtendedInfo().getUnCompressedSize() <= 0) ? fileHeader.getCompressedSize() : fileHeader.getZip64ExtendedInfo().getCompressedSize();
        }
        return j;
    }

    public final void d(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null || !net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        java.lang.String fileName = fileHeader.getFileName();
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = fileName;
        }
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            try {
                java.io.File file = new java.io.File(new java.io.File(str + str2).getParent());
                if (file.exists()) {
                    return;
                }
                file.mkdirs();
            } catch (java.lang.Exception e) {
                throw new net.lingala.zip4j.exception.ZipException(e);
            }
        }
    }

    public final void e(java.util.ArrayList arrayList, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        for (int i = 0; i < arrayList.size(); i++) {
            f((net.lingala.zip4j.model.FileHeader) arrayList.get(i), str, unzipParameters, null, progressMonitor);
            if (progressMonitor.isCancelAllTasks()) {
                progressMonitor.setResult(3);
                progressMonitor.setState(0);
                return;
            }
        }
    }

    public void extractAll(net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.CentralDirectory centralDirectory = this.a.getCentralDirectory();
        if (centralDirectory == null || centralDirectory.getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid central directory in zipModel");
        }
        java.util.ArrayList fileHeaders = centralDirectory.getFileHeaders();
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(c(fileHeaders));
        progressMonitor.setState(1);
        if (z) {
            new net.lingala.zip4j.unzip.Unzip.AnonymousClass1(net.lingala.zip4j.util.InternalZipConstants.THREAD_NAME, fileHeaders, unzipParameters, progressMonitor, str).start();
        } else {
            e(fileHeaders, unzipParameters, progressMonitor, str);
        }
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("fileHeader is null");
        }
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(fileHeader.getCompressedSize());
        progressMonitor.setState(1);
        progressMonitor.setPercentDone(0);
        progressMonitor.setFileName(fileHeader.getFileName());
        if (z) {
            new net.lingala.zip4j.unzip.Unzip.AnonymousClass2(net.lingala.zip4j.util.InternalZipConstants.THREAD_NAME, fileHeader, str, unzipParameters, str2, progressMonitor).start();
        } else {
            f(fileHeader, str, unzipParameters, str2, progressMonitor);
            progressMonitor.endProgressMonitorSuccess();
        }
    }

    public final void f(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("fileHeader is null");
        }
        try {
            progressMonitor.setFileName(fileHeader.getFileName());
            java.lang.String str3 = net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
            if (!fileHeader.isDirectory()) {
                d(fileHeader, str, str2);
                try {
                    new net.lingala.zip4j.unzip.UnzipEngine(this.a, fileHeader).unzipFile(progressMonitor, str, str2, unzipParameters);
                    return;
                } catch (java.lang.Exception e) {
                    progressMonitor.endProgressMonitorError(e);
                    throw new net.lingala.zip4j.exception.ZipException(e);
                }
            }
            try {
                java.lang.String fileName = fileHeader.getFileName();
                if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(fileName)) {
                    java.io.File file = new java.io.File(str + fileName);
                    if (file.exists()) {
                        return;
                    }
                    file.mkdirs();
                }
            } catch (java.lang.Exception e2) {
                progressMonitor.endProgressMonitorError(e2);
                throw new net.lingala.zip4j.exception.ZipException(e2);
            }
        } catch (net.lingala.zip4j.exception.ZipException e3) {
            progressMonitor.endProgressMonitorError(e3);
            throw e3;
        } catch (java.lang.Exception e4) {
            progressMonitor.endProgressMonitorError(e4);
            throw new net.lingala.zip4j.exception.ZipException(e4);
        }
    }

    public net.lingala.zip4j.io.ZipInputStream getInputStream(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        return new net.lingala.zip4j.unzip.UnzipEngine(this.a, fileHeader).getInputStream();
    }
}
