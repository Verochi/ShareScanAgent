package net.lingala.zip4j.unzip;

/* loaded from: classes23.dex */
public class UnzipUtil {
    public static void a(net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file, boolean z, boolean z2, boolean z3, boolean z4) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid file header. cannot set file attributes");
        }
        byte[] externalFileAttr = fileHeader.getExternalFileAttr();
        if (externalFileAttr == null) {
            return;
        }
        byte b = externalFileAttr[0];
        if (b == 1) {
            if (z) {
                net.lingala.zip4j.util.Zip4jUtil.setFileReadOnly(file);
                return;
            }
            return;
        }
        if (b != 2) {
            if (b == 3) {
                if (z) {
                    net.lingala.zip4j.util.Zip4jUtil.setFileReadOnly(file);
                }
                if (z2) {
                    net.lingala.zip4j.util.Zip4jUtil.setFileHidden(file);
                    return;
                }
                return;
            }
            if (b != 18) {
                if (b == 38) {
                    if (z) {
                        net.lingala.zip4j.util.Zip4jUtil.setFileReadOnly(file);
                    }
                    if (z2) {
                        net.lingala.zip4j.util.Zip4jUtil.setFileHidden(file);
                    }
                    if (z4) {
                        net.lingala.zip4j.util.Zip4jUtil.setFileSystemMode(file);
                        return;
                    }
                    return;
                }
                if (b != 48) {
                    if (b != 50) {
                        switch (b) {
                            case 32:
                                break;
                            case 33:
                                if (z3) {
                                    net.lingala.zip4j.util.Zip4jUtil.setFileArchive(file);
                                }
                                if (z) {
                                    net.lingala.zip4j.util.Zip4jUtil.setFileReadOnly(file);
                                    return;
                                }
                                return;
                            case 34:
                                break;
                            case 35:
                                if (z3) {
                                    net.lingala.zip4j.util.Zip4jUtil.setFileArchive(file);
                                }
                                if (z) {
                                    net.lingala.zip4j.util.Zip4jUtil.setFileReadOnly(file);
                                }
                                if (z2) {
                                    net.lingala.zip4j.util.Zip4jUtil.setFileHidden(file);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    if (z3) {
                        net.lingala.zip4j.util.Zip4jUtil.setFileArchive(file);
                    }
                    if (z2) {
                        net.lingala.zip4j.util.Zip4jUtil.setFileHidden(file);
                        return;
                    }
                    return;
                }
                if (z3) {
                    net.lingala.zip4j.util.Zip4jUtil.setFileArchive(file);
                    return;
                }
                return;
            }
        }
        if (z2) {
            net.lingala.zip4j.util.Zip4jUtil.setFileHidden(file);
        }
    }

    public static void applyFileAttributes(net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        applyFileAttributes(fileHeader, file, null);
    }

    public static void applyFileAttributes(net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot set file properties: file header is null");
        }
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot set file properties: output file is null");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.checkFileExists(file)) {
            throw new net.lingala.zip4j.exception.ZipException("cannot set file properties: file doesnot exist");
        }
        if (unzipParameters == null || !unzipParameters.isIgnoreDateTimeAttributes()) {
            b(fileHeader, file);
        }
        if (unzipParameters == null) {
            a(fileHeader, file, true, true, true, true);
        } else if (unzipParameters.isIgnoreAllFileAttributes()) {
            a(fileHeader, file, false, false, false, false);
        } else {
            a(fileHeader, file, !unzipParameters.isIgnoreReadOnlyFileAttribute(), !unzipParameters.isIgnoreHiddenFileAttribute(), !unzipParameters.isIgnoreArchiveFileAttribute(), !unzipParameters.isIgnoreSystemFileAttribute());
        }
    }

    public static void b(net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader.getLastModFileTime() > 0 && file.exists()) {
            file.setLastModified(net.lingala.zip4j.util.Zip4jUtil.dosToJavaTme(fileHeader.getLastModFileTime()));
        }
    }
}
