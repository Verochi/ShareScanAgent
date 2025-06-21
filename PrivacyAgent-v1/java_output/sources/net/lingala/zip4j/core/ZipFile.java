package net.lingala.zip4j.core;

/* loaded from: classes23.dex */
public class ZipFile {
    public java.lang.String a;
    public int b;
    public net.lingala.zip4j.model.ZipModel c;
    public boolean d;
    public net.lingala.zip4j.progress.ProgressMonitor e;
    public boolean f;
    public java.lang.String g;

    public ZipFile(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("Input zip file parameter is not null", 1);
        }
        this.a = file.getPath();
        this.b = 2;
        this.e = new net.lingala.zip4j.progress.ProgressMonitor();
        this.f = false;
    }

    public ZipFile(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        this(new java.io.File(str));
    }

    public final void a(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z) throws net.lingala.zip4j.exception.ZipException {
        b();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (z && zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.zip.ZipEngine(this.c).addFolderToZip(file, zipParameters, this.e, this.f);
    }

    public void addFile(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(file);
        addFiles(arrayList, zipParameters);
    }

    public void addFiles(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        b();
        if (this.c == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file ArrayList is null, cannot add files");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new net.lingala.zip4j.exception.ZipException("One or more elements in the input ArrayList is not of type File");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot add files to zip");
        }
        if (this.e.getState() == 1) {
            throw new net.lingala.zip4j.exception.ZipException("invalid operation - Zip4j is in busy state");
        }
        if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a) && this.c.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.zip.ZipEngine(this.c).addFiles(arrayList, zipParameters, this.e, this.f);
    }

    public void addFolder(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input path is null, cannot add folder to zip file");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot add folder to zip file");
        }
        a(file, zipParameters, true);
    }

    public void addFolder(java.lang.String str, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input path is null or empty, cannot add folder to zip file");
        }
        addFolder(new java.io.File(str), zipParameters);
    }

    public void addStream(java.io.InputStream inputStream, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (inputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip parameters are null");
        }
        setRunInThread(false);
        b();
        if (this.c == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a) && this.c.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.zip.ZipEngine(this.c).addStreamToZip(inputStream, zipParameters);
    }

    public final void b() throws net.lingala.zip4j.exception.ZipException {
        if (this.c == null) {
            if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
                d();
            } else {
                c();
            }
        }
    }

    public final void c() {
        net.lingala.zip4j.model.ZipModel zipModel = new net.lingala.zip4j.model.ZipModel();
        this.c = zipModel;
        zipModel.setZipFile(this.a);
        this.c.setFileNameCharset(this.g);
    }

    public void createZipFile(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFile(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, z, j);
    }

    public void createZipFile(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFile(java.util.ArrayList arrayList, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file path is empty");
        }
        if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file: " + this.a + " already exists. To add files to existing zip file use addFile method");
        }
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file ArrayList is null, cannot create zip file");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new net.lingala.zip4j.exception.ZipException("One or more elements in the input ArrayList is not of type File");
        }
        c();
        this.c.setSplitArchive(z);
        this.c.setSplitLength(j);
        addFiles(arrayList, zipParameters);
    }

    public void createZipFileFromFolder(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot create zip file from folder");
        }
        if (net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file: " + this.a + " already exists. To add files to existing zip file use addFolder method");
        }
        c();
        this.c.setSplitArchive(z);
        if (z) {
            this.c.setSplitLength(j);
        }
        a(file, zipParameters, false);
    }

    public void createZipFileFromFolder(java.lang.String str, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("folderToAdd is empty or null, cannot create Zip File from folder");
        }
        createZipFileFromFolder(new java.io.File(str), zipParameters, z, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() throws net.lingala.zip4j.exception.ZipException {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        java.io.FileNotFoundException e;
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileReadAccess(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("no read access for the input zip file");
        }
        if (this.b != 2) {
            throw new net.lingala.zip4j.exception.ZipException("Invalid mode");
        }
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(this.a), "r");
            try {
                try {
                    if (this.c == null) {
                        net.lingala.zip4j.model.ZipModel readAllHeaders = new net.lingala.zip4j.core.HeaderReader(randomAccessFile).readAllHeaders(this.g);
                        this.c = readAllHeaders;
                        if (readAllHeaders != null) {
                            readAllHeaders.setZipFile(this.a);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused) {
                    }
                } catch (java.io.FileNotFoundException e2) {
                    e = e2;
                    throw new net.lingala.zip4j.exception.ZipException(e);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.io.FileNotFoundException e3) {
            randomAccessFile = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            randomAccessFile = null;
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public void extractAll(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        extractAll(str, null);
    }

    public void extractAll(java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("output path is null or invalid");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkOutputFolder(str)) {
            throw new net.lingala.zip4j.exception.ZipException("invalid output path");
        }
        if (this.c == null) {
            d();
        }
        if (this.c == null) {
            throw new net.lingala.zip4j.exception.ZipException("Internal error occurred when extracting zip file");
        }
        if (this.e.getState() == 1) {
            throw new net.lingala.zip4j.exception.ZipException("invalid operation - Zip4j is in busy state");
        }
        new net.lingala.zip4j.unzip.Unzip(this.c).extractAll(unzipParameters, str, this.e, this.f);
    }

    public void extractFile(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        extractFile(str, str2, (net.lingala.zip4j.model.UnzipParameters) null);
    }

    public void extractFile(java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        extractFile(str, str2, unzipParameters, (java.lang.String) null);
    }

    public void extractFile(java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str3) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file to extract is null or empty, cannot extract file");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            throw new net.lingala.zip4j.exception.ZipException("destination string path is empty or null, cannot extract file");
        }
        d();
        net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.util.Zip4jUtil.getFileHeader(this.c, str);
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header not found for given file name, cannot extract file");
        }
        if (this.e.getState() == 1) {
            throw new net.lingala.zip4j.exception.ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.c, str2, unzipParameters, str3, this.e, this.f);
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        extractFile(fileHeader, str, (net.lingala.zip4j.model.UnzipParameters) null);
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        extractFile(fileHeader, str, unzipParameters, (java.lang.String) null);
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file header is null, cannot extract file");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("destination path is empty or null, cannot extract file");
        }
        d();
        if (this.e.getState() == 1) {
            throw new net.lingala.zip4j.exception.ZipException("invalid operation - Zip4j is in busy state");
        }
        fileHeader.extractFile(this.c, str, unzipParameters, str2, this.e, this.f);
    }

    public java.lang.String getComment() throws net.lingala.zip4j.exception.ZipException {
        return getComment(null);
    }

    public java.lang.String getComment(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (str == null) {
            str = net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT;
            if (!net.lingala.zip4j.util.Zip4jUtil.isSupportedCharset(net.lingala.zip4j.util.InternalZipConstants.CHARSET_COMMENTS_DEFAULT)) {
                str = net.lingala.zip4j.util.InternalZipConstants.CHARSET_DEFAULT;
            }
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist, cannot read comment");
        }
        b();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot read comment");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("end of central directory record is null, cannot read comment");
        }
        if (this.c.getEndCentralDirRecord().getCommentBytes() == null || this.c.getEndCentralDirRecord().getCommentBytes().length <= 0) {
            return null;
        }
        try {
            return new java.lang.String(this.c.getEndCentralDirRecord().getCommentBytes(), str);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public java.io.File getFile() {
        return new java.io.File(this.a);
    }

    public net.lingala.zip4j.model.FileHeader getFileHeader(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        d();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return net.lingala.zip4j.util.Zip4jUtil.getFileHeader(this.c, str);
    }

    public java.util.List getFileHeaders() throws net.lingala.zip4j.exception.ZipException {
        d();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return this.c.getCentralDirectory().getFileHeaders();
    }

    public net.lingala.zip4j.io.ZipInputStream getInputStream(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("FileHeader is null, cannot get InputStream");
        }
        b();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel != null) {
            return new net.lingala.zip4j.unzip.Unzip(zipModel).getInputStream(fileHeader);
        }
        throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot get inputstream");
    }

    public net.lingala.zip4j.progress.ProgressMonitor getProgressMonitor() {
        return this.e;
    }

    public java.util.ArrayList getSplitZipFiles() throws net.lingala.zip4j.exception.ZipException {
        b();
        return net.lingala.zip4j.util.Zip4jUtil.getSplitZipFiles(this.c);
    }

    public boolean isEncrypted() throws net.lingala.zip4j.exception.ZipException {
        if (this.c == null) {
            d();
            if (this.c == null) {
                throw new net.lingala.zip4j.exception.ZipException("Zip Model is null");
            }
        }
        if (this.c.getCentralDirectory() == null || this.c.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid zip file");
        }
        java.util.ArrayList fileHeaders = this.c.getCentralDirectory().getFileHeaders();
        int i = 0;
        while (true) {
            if (i < fileHeaders.size()) {
                net.lingala.zip4j.model.FileHeader fileHeader = (net.lingala.zip4j.model.FileHeader) fileHeaders.get(i);
                if (fileHeader != null && fileHeader.isEncrypted()) {
                    this.d = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return this.d;
    }

    public boolean isRunInThread() {
        return this.f;
    }

    public boolean isSplitArchive() throws net.lingala.zip4j.exception.ZipException {
        if (this.c == null) {
            d();
            if (this.c == null) {
                throw new net.lingala.zip4j.exception.ZipException("Zip Model is null");
            }
        }
        return this.c.isSplitArchive();
    }

    public boolean isValidZipFile() {
        try {
            d();
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public void mergeSplitFiles(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("output Zip File already exists");
        }
        b();
        if (this.c == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, corrupt zip file?");
        }
        net.lingala.zip4j.util.ArchiveMaintainer archiveMaintainer = new net.lingala.zip4j.util.ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForMergeOp(this.c, this.e);
        archiveMaintainer.mergeSplitZipFiles(this.c, file, this.e, this.f);
    }

    public void removeFile(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name is empty or null, cannot remove file");
        }
        if (this.c == null && net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            d();
        }
        if (this.c.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file format does not allow updating split/spanned files");
        }
        net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.util.Zip4jUtil.getFileHeader(this.c, str);
        if (fileHeader != null) {
            removeFile(fileHeader);
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("could not find file header for file: " + str);
    }

    public void removeFile(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null, cannot remove file");
        }
        if (this.c == null && net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            d();
        }
        if (this.c.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file format does not allow updating split/spanned files");
        }
        net.lingala.zip4j.util.ArchiveMaintainer archiveMaintainer = new net.lingala.zip4j.util.ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForRemoveOp(this.c, fileHeader, this.e);
        archiveMaintainer.removeZipFile(this.c, fileHeader, this.e, this.f);
    }

    public void setComment(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (str == null) {
            throw new net.lingala.zip4j.exception.ZipException("input comment is null, cannot update zip file");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileExists(this.a)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist, cannot set comment for zip file");
        }
        d();
        net.lingala.zip4j.model.ZipModel zipModel = this.c;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zipModel is null, cannot update zip file");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("end of central directory is null, cannot set comment");
        }
        new net.lingala.zip4j.util.ArchiveMaintainer().setComment(this.c, str);
    }

    public void setFileNameCharset(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("null or empty charset name");
        }
        if (net.lingala.zip4j.util.Zip4jUtil.isSupportedCharset(str)) {
            this.g = str;
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("unsupported charset: " + str);
    }

    public void setPassword(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw null;
        }
        setPassword(str.toCharArray());
    }

    public void setPassword(char[] cArr) throws net.lingala.zip4j.exception.ZipException {
        if (this.c == null) {
            d();
            if (this.c == null) {
                throw new net.lingala.zip4j.exception.ZipException("Zip Model is null");
            }
        }
        if (this.c.getCentralDirectory() == null || this.c.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid zip file");
        }
        for (int i = 0; i < this.c.getCentralDirectory().getFileHeaders().size(); i++) {
            if (this.c.getCentralDirectory().getFileHeaders().get(i) != null && ((net.lingala.zip4j.model.FileHeader) this.c.getCentralDirectory().getFileHeaders().get(i)).isEncrypted()) {
                ((net.lingala.zip4j.model.FileHeader) this.c.getCentralDirectory().getFileHeaders().get(i)).setPassword(cArr);
            }
        }
    }

    public void setRunInThread(boolean z) {
        this.f = z;
    }
}
