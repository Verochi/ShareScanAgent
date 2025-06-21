package net.lingala.zip4j.util;

/* loaded from: classes23.dex */
public class Zip4jUtil {
    public static boolean checkArrayListTypes(java.util.ArrayList arrayList, int i) throws net.lingala.zip4j.exception.ZipException {
        if (arrayList == null) {
            throw new net.lingala.zip4j.exception.ZipException("input arraylist is null, cannot check types");
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        boolean z = false;
        if (i == 1) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (!(arrayList.get(i2) instanceof java.io.File)) {
                    z = true;
                    break;
                }
            }
            return !z;
        }
        if (i == 2) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!(arrayList.get(i3) instanceof java.lang.String)) {
                    z = true;
                    break;
                }
            }
        }
        return !z;
    }

    public static boolean checkFileExists(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file != null) {
            return file.exists();
        }
        throw new net.lingala.zip4j.exception.ZipException("cannot check if file exists: input file is null");
    }

    public static boolean checkFileExists(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (isStringNotNullAndNotEmpty(str)) {
            return checkFileExists(new java.io.File(str));
        }
        throw new net.lingala.zip4j.exception.ZipException("path is null");
    }

    public static boolean checkFileReadAccess(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("path is null");
        }
        if (checkFileExists(str)) {
            try {
                return new java.io.File(str).canRead();
            } catch (java.lang.Exception unused) {
                throw new net.lingala.zip4j.exception.ZipException("cannot read zip file");
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("file does not exist: " + str);
    }

    public static boolean checkFileWriteAccess(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("path is null");
        }
        if (checkFileExists(str)) {
            try {
                return new java.io.File(str).canWrite();
            } catch (java.lang.Exception unused) {
                throw new net.lingala.zip4j.exception.ZipException("cannot read zip file");
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("file does not exist: " + str);
    }

    public static boolean checkOutputFolder(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException(new java.lang.NullPointerException("output path is null"));
        }
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new net.lingala.zip4j.exception.ZipException("output folder is not valid");
            }
            if (file.canWrite()) {
                return true;
            }
            throw new net.lingala.zip4j.exception.ZipException("no write access to output folder");
        }
        try {
            file.mkdirs();
            if (!file.isDirectory()) {
                throw new net.lingala.zip4j.exception.ZipException("output folder is not valid");
            }
            if (file.canWrite()) {
                return true;
            }
            throw new net.lingala.zip4j.exception.ZipException("no write access to destination folder");
        } catch (java.lang.Exception unused) {
            throw new net.lingala.zip4j.exception.ZipException("Cannot create destination folder");
        }
    }

    public static byte[] convertCharset(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        try {
            java.lang.String detectCharSet = detectCharSet(str);
            return detectCharSet.equals(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850) ? str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850) : detectCharSet.equals(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8) ? str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8) : str.getBytes();
        } catch (java.io.UnsupportedEncodingException unused) {
            return str.getBytes();
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public static java.lang.String decodeFileName(byte[] bArr, boolean z) {
        if (!z) {
            return getCp850EncodedString(bArr);
        }
        try {
            return new java.lang.String(bArr, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr);
        }
    }

    public static java.lang.String detectCharSet(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (str == null) {
            throw new net.lingala.zip4j.exception.ZipException("input string is null, cannot detect charset");
        }
        try {
            return str.equals(new java.lang.String(str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850), net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850)) ? net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850 : str.equals(new java.lang.String(str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8), net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8)) ? net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8 : net.lingala.zip4j.util.InternalZipConstants.CHARSET_DEFAULT;
        } catch (java.io.UnsupportedEncodingException unused) {
            return net.lingala.zip4j.util.InternalZipConstants.CHARSET_DEFAULT;
        } catch (java.lang.Exception unused2) {
            return net.lingala.zip4j.util.InternalZipConstants.CHARSET_DEFAULT;
        }
    }

    public static long dosToJavaTme(int i) {
        int i2 = (i & 31) * 2;
        int i3 = (i >> 5) & 63;
        int i4 = (i >> 11) & 31;
        int i5 = (i >> 16) & 31;
        int i6 = ((i >> 21) & 15) - 1;
        int i7 = ((i >> 25) & 127) + 1980;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(i7, i6, i5, i4, i3, i2);
        calendar.set(14, 0);
        return calendar.getTime().getTime();
    }

    public static java.lang.String getAbsoluteFilePath(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (isStringNotNullAndNotEmpty(str)) {
            return new java.io.File(str).getAbsolutePath();
        }
        throw new net.lingala.zip4j.exception.ZipException("filePath is null or empty, cannot get absolute file path");
    }

    public static long[] getAllHeaderSignatures() {
        return new long[]{net.lingala.zip4j.util.InternalZipConstants.LOCSIG, 134695760, net.lingala.zip4j.util.InternalZipConstants.CENSIG, net.lingala.zip4j.util.InternalZipConstants.ENDSIG, net.lingala.zip4j.util.InternalZipConstants.DIGSIG, net.lingala.zip4j.util.InternalZipConstants.ARCEXTDATREC, 134695760, net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRLOC, net.lingala.zip4j.util.InternalZipConstants.ZIP64ENDCENDIRREC, 1, 39169};
    }

    public static java.lang.String getCp850EncodedString(byte[] bArr) {
        try {
            return new java.lang.String(bArr, net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850);
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr);
        }
    }

    public static int getEncodedStringLength(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (isStringNotNullAndNotEmpty(str)) {
            return getEncodedStringLength(str, detectCharSet(str));
        }
        throw new net.lingala.zip4j.exception.ZipException("input string is null, cannot calculate encoded String length");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.nio.Buffer] */
    public static int getEncodedStringLength(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input string is null, cannot calculate encoded String length");
        }
        if (!isStringNotNullAndNotEmpty(str2)) {
            throw new net.lingala.zip4j.exception.ZipException("encoding is not defined, cannot calculate string length");
        }
        try {
            str = str2.equals(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850) ? java.nio.ByteBuffer.wrap(str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_CP850)) : str2.equals(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8) ? java.nio.ByteBuffer.wrap(str.getBytes(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8)) : java.nio.ByteBuffer.wrap(str.getBytes(str2));
        } catch (java.io.UnsupportedEncodingException unused) {
            str = java.nio.ByteBuffer.wrap(str.getBytes());
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
        return str.limit();
    }

    public static net.lingala.zip4j.model.FileHeader getFileHeader(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot determine file header for fileName: " + str);
        }
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name is null, cannot determine file header for fileName: " + str);
        }
        net.lingala.zip4j.model.FileHeader fileHeaderWithExactMatch = getFileHeaderWithExactMatch(zipModel, str);
        if (fileHeaderWithExactMatch != null) {
            return fileHeaderWithExactMatch;
        }
        java.lang.String replaceAll = str.replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        net.lingala.zip4j.model.FileHeader fileHeaderWithExactMatch2 = getFileHeaderWithExactMatch(zipModel, replaceAll);
        return fileHeaderWithExactMatch2 == null ? getFileHeaderWithExactMatch(zipModel, replaceAll.replaceAll(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR, "\\\\")) : fileHeaderWithExactMatch2;
    }

    public static net.lingala.zip4j.model.FileHeader getFileHeaderWithExactMatch(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new net.lingala.zip4j.exception.ZipException("central directory is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return null;
        }
        java.util.ArrayList fileHeaders = zipModel.getCentralDirectory().getFileHeaders();
        for (int i = 0; i < fileHeaders.size(); i++) {
            net.lingala.zip4j.model.FileHeader fileHeader = (net.lingala.zip4j.model.FileHeader) fileHeaders.get(i);
            java.lang.String fileName = fileHeader.getFileName();
            if (isStringNotNullAndNotEmpty(fileName) && str.equalsIgnoreCase(fileName)) {
                return fileHeader;
            }
        }
        return null;
    }

    public static long getFileLengh(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null, cannot calculate file length");
        }
        if (file.isDirectory()) {
            return -1L;
        }
        return file.length();
    }

    public static long getFileLengh(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (isStringNotNullAndNotEmpty(str)) {
            return getFileLengh(new java.io.File(str));
        }
        throw new net.lingala.zip4j.exception.ZipException("invalid file name");
    }

    public static java.lang.String getFileNameFromFilePath(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null, cannot get file name");
        }
        if (file.isDirectory()) {
            return null;
        }
        return file.getName();
    }

    public static java.util.ArrayList getFilesInDirectoryRec(java.io.File file, boolean z) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input path is null, cannot read files in the directory");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List asList = java.util.Arrays.asList(file.listFiles());
        if (!file.canRead()) {
            return arrayList;
        }
        for (int i = 0; i < asList.size(); i++) {
            java.io.File file2 = (java.io.File) asList.get(i);
            if (file2.isHidden() && !z) {
                return arrayList;
            }
            arrayList.add(file2);
            if (file2.isDirectory()) {
                arrayList.addAll(getFilesInDirectoryRec(file2, z));
            }
        }
        return arrayList;
    }

    public static int getIndexOfFileHeader(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new net.lingala.zip4j.exception.ZipException("central directory is null, ccannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("file Headers are null, cannot determine index of file header");
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return -1;
        }
        java.lang.String fileName = fileHeader.getFileName();
        if (!isStringNotNullAndNotEmpty(fileName)) {
            throw new net.lingala.zip4j.exception.ZipException("file name in file header is empty or null, cannot determine index of file header");
        }
        java.util.ArrayList fileHeaders = zipModel.getCentralDirectory().getFileHeaders();
        for (int i = 0; i < fileHeaders.size(); i++) {
            java.lang.String fileName2 = ((net.lingala.zip4j.model.FileHeader) fileHeaders.get(i)).getFileName();
            if (isStringNotNullAndNotEmpty(fileName2) && fileName.equalsIgnoreCase(fileName2)) {
                return i;
            }
        }
        return -1;
    }

    public static long getLastModifiedFileTime(java.io.File file, java.util.TimeZone timeZone) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null, cannot read last modified file time");
        }
        if (file.exists()) {
            return file.lastModified();
        }
        throw new net.lingala.zip4j.exception.ZipException("input file does not exist, cannot read last modified file time");
    }

    public static java.lang.String getRelativeFileName(java.lang.String str, java.lang.String str2, java.lang.String str3) throws net.lingala.zip4j.exception.ZipException {
        java.lang.String fileNameFromFilePath;
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input file path/name is empty, cannot calculate relative file name");
        }
        if (isStringNotNullAndNotEmpty(str3)) {
            java.lang.String path = new java.io.File(str3).getPath();
            java.lang.String str4 = net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
            if (!path.endsWith(str4)) {
                path = path + str4;
            }
            java.lang.String substring = str.substring(path.length());
            if (substring.startsWith(java.lang.System.getProperty("file.separator"))) {
                substring = substring.substring(1);
            }
            java.io.File file = new java.io.File(str);
            if (file.isDirectory()) {
                fileNameFromFilePath = substring.replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                fileNameFromFilePath = substring.substring(0, substring.lastIndexOf(file.getName())).replaceAll("\\\\", net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + file.getName();
            }
        } else {
            java.io.File file2 = new java.io.File(str);
            if (file2.isDirectory()) {
                fileNameFromFilePath = file2.getName() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
            } else {
                fileNameFromFilePath = getFileNameFromFilePath(new java.io.File(str));
            }
        }
        if (isStringNotNullAndNotEmpty(str2)) {
            fileNameFromFilePath = str2 + fileNameFromFilePath;
        }
        if (isStringNotNullAndNotEmpty(fileNameFromFilePath)) {
            return fileNameFromFilePath;
        }
        throw new net.lingala.zip4j.exception.ZipException("Error determining file name");
    }

    public static java.util.ArrayList getSplitZipFiles(net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot get split zip files: zipmodel is null");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String zipFile = zipModel.getZipFile();
        java.lang.String name = new java.io.File(zipFile).getName();
        if (!isStringNotNullAndNotEmpty(zipFile)) {
            throw new net.lingala.zip4j.exception.ZipException("cannot get split zip files: zipfile is null");
        }
        if (!zipModel.isSplitArchive()) {
            arrayList.add(zipFile);
            return arrayList;
        }
        int noOfThisDisk = zipModel.getEndCentralDirRecord().getNoOfThisDisk();
        if (noOfThisDisk == 0) {
            arrayList.add(zipFile);
            return arrayList;
        }
        int i = 0;
        while (i <= noOfThisDisk) {
            if (i == noOfThisDisk) {
                arrayList.add(zipModel.getZipFile());
            } else {
                java.lang.String str = i > 9 ? ".z" : ".z0";
                arrayList.add((name.indexOf(".") >= 0 ? zipFile.substring(0, zipFile.lastIndexOf(".")) : zipFile) + str + (i + 1));
            }
            i++;
        }
        return arrayList;
    }

    public static java.lang.String getZipFileNameWithoutExt(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("zip file name is empty or null, cannot determine zip file name");
        }
        if (str.indexOf(java.lang.System.getProperty("file.separator")) >= 0) {
            str = str.substring(str.lastIndexOf(java.lang.System.getProperty("file.separator")));
        }
        return str.indexOf(".") > 0 ? str.substring(0, str.lastIndexOf(".")) : str;
    }

    public static boolean isStringNotNullAndNotEmpty(java.lang.String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean isSupportedCharset(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("charset is null or empty, cannot check if it is supported");
        }
        try {
            new java.lang.String("a".getBytes(), str);
            return true;
        } catch (java.io.UnsupportedEncodingException unused) {
            return false;
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    public static boolean isWindows() {
        return java.lang.System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
    }

    public static long javaToDosTime(long j) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (calendar.get(1) < 1980) {
            return 2162688L;
        }
        return (calendar.get(13) >> 1) | ((r5 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    public static void setFileArchive(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
    }

    public static void setFileHidden(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
    }

    public static void setFileReadOnly(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file is null. cannot set read only file attribute");
        }
        if (file.exists()) {
            file.setReadOnly();
        }
    }

    public static void setFileSystemMode(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
    }
}
