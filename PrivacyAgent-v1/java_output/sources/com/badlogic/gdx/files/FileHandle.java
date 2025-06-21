package com.badlogic.gdx.files;

/* loaded from: classes12.dex */
public class FileHandle {
    protected java.io.File file;
    protected com.badlogic.gdx.Files.FileType type;

    /* renamed from: com.badlogic.gdx.files.FileHandle$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.Files.FileType.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.Files.FileType.Internal.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.Files.FileType.Classpath.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public FileHandle() {
    }

    public FileHandle(java.io.File file) {
        this.file = file;
        this.type = com.badlogic.gdx.Files.FileType.Absolute;
    }

    public FileHandle(java.io.File file, com.badlogic.gdx.Files.FileType fileType) {
        this.file = file;
        this.type = fileType;
    }

    public FileHandle(java.lang.String str) {
        this.file = new java.io.File(str);
        this.type = com.badlogic.gdx.Files.FileType.Absolute;
    }

    public FileHandle(java.lang.String str, com.badlogic.gdx.Files.FileType fileType) {
        this.type = fileType;
        this.file = new java.io.File(str);
    }

    public static void a(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2) {
        fileHandle2.mkdirs();
        for (com.badlogic.gdx.files.FileHandle fileHandle3 : fileHandle.list()) {
            com.badlogic.gdx.files.FileHandle child = fileHandle2.child(fileHandle3.name());
            if (fileHandle3.isDirectory()) {
                a(fileHandle3, child);
            } else {
                b(fileHandle3, child);
            }
        }
    }

    public static void b(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2) {
        try {
            fileHandle2.write(fileHandle.read(), false);
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error copying source file: " + fileHandle.file + " (" + fileHandle.type + ")\nTo destination: " + fileHandle2.file + " (" + fileHandle2.type + ")", e);
        }
    }

    public static boolean c(java.io.File file) {
        d(file, false);
        return file.delete();
    }

    public static void d(java.io.File file, boolean z) {
        java.io.File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return;
        }
        int length = listFiles.length;
        for (int i = 0; i < length; i++) {
            if (!listFiles[i].isDirectory()) {
                listFiles[i].delete();
            } else if (z) {
                d(listFiles[i], true);
            } else {
                c(listFiles[i]);
            }
        }
    }

    public static com.badlogic.gdx.files.FileHandle tempDirectory(java.lang.String str) {
        try {
            java.io.File createTempFile = java.io.File.createTempFile(str, null);
            if (!createTempFile.delete()) {
                throw new java.io.IOException("Unable to delete temp file: " + createTempFile);
            }
            if (createTempFile.mkdir()) {
                return new com.badlogic.gdx.files.FileHandle(createTempFile);
            }
            throw new java.io.IOException("Unable to create temp directory: " + createTempFile);
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to create temp file.", e);
        }
    }

    public static com.badlogic.gdx.files.FileHandle tempFile(java.lang.String str) {
        try {
            return new com.badlogic.gdx.files.FileHandle(java.io.File.createTempFile(str, null));
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to create temp file.", e);
        }
    }

    public com.badlogic.gdx.files.FileHandle child(java.lang.String str) {
        return this.file.getPath().length() == 0 ? new com.badlogic.gdx.files.FileHandle(new java.io.File(str), this.type) : new com.badlogic.gdx.files.FileHandle(new java.io.File(this.file, str), this.type);
    }

    public void copyTo(com.badlogic.gdx.files.FileHandle fileHandle) {
        boolean isDirectory = isDirectory();
        if (!isDirectory) {
            if (fileHandle.isDirectory()) {
                fileHandle = fileHandle.child(name());
            }
            b(this, fileHandle);
            return;
        }
        if (!fileHandle.exists()) {
            fileHandle.mkdirs();
            if (!fileHandle.isDirectory()) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Destination directory cannot be created: " + fileHandle);
            }
        } else if (!fileHandle.isDirectory()) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Destination exists but is not a directory: " + fileHandle);
        }
        if (!isDirectory) {
            fileHandle = fileHandle.child(name());
        }
        a(this, fileHandle);
    }

    public boolean delete() {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (fileType != com.badlogic.gdx.Files.FileType.Internal) {
            return file().delete();
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete an internal file: " + this.file);
    }

    public boolean deleteDirectory() {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (fileType != com.badlogic.gdx.Files.FileType.Internal) {
            return c(file());
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete an internal file: " + this.file);
    }

    public final int e() {
        int length = (int) length();
        if (length != 0) {
            return length;
        }
        return 512;
    }

    public void emptyDirectory() {
        emptyDirectory(false);
    }

    public void emptyDirectory(boolean z) {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete a classpath file: " + this.file);
        }
        if (fileType != com.badlogic.gdx.Files.FileType.Internal) {
            d(file(), z);
            return;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot delete an internal file: " + this.file);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.badlogic.gdx.files.FileHandle)) {
            return false;
        }
        com.badlogic.gdx.files.FileHandle fileHandle = (com.badlogic.gdx.files.FileHandle) obj;
        return this.type == fileHandle.type && path().equals(fileHandle.path());
    }

    public boolean exists() {
        int i = com.badlogic.gdx.files.FileHandle.AnonymousClass1.a[this.type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return file().exists();
            }
        } else if (file().exists()) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        sb.append(this.file.getPath().replace('\\', '/'));
        return com.badlogic.gdx.files.FileHandle.class.getResource(sb.toString()) != null;
    }

    public java.lang.String extension() {
        java.lang.String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
    }

    public java.io.File file() {
        return this.type == com.badlogic.gdx.Files.FileType.External ? new java.io.File(com.badlogic.gdx.Gdx.files.getExternalStoragePath(), this.file.getPath()) : this.file;
    }

    public int hashCode() {
        return ((37 + this.type.hashCode()) * 67) + path().hashCode();
    }

    public boolean isDirectory() {
        if (this.type == com.badlogic.gdx.Files.FileType.Classpath) {
            return false;
        }
        return file().isDirectory();
    }

    public long lastModified() {
        return file().lastModified();
    }

    public long length() {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType != com.badlogic.gdx.Files.FileType.Classpath && (fileType != com.badlogic.gdx.Files.FileType.Internal || this.file.exists())) {
            return file().length();
        }
        java.io.InputStream read = read();
        try {
            long available = read.available();
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
            return available;
        } catch (java.lang.Exception unused) {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
            return 0L;
        } catch (java.lang.Throwable th) {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
            throw th;
        }
    }

    public com.badlogic.gdx.files.FileHandle[] list() {
        if (this.type == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        java.lang.String[] list = file().list();
        if (list == null) {
            return new com.badlogic.gdx.files.FileHandle[0];
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
        int length = list.length;
        for (int i = 0; i < length; i++) {
            fileHandleArr[i] = child(list[i]);
        }
        return fileHandleArr;
    }

    public com.badlogic.gdx.files.FileHandle[] list(java.io.FileFilter fileFilter) {
        if (this.type == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        java.lang.String[] list = file().list();
        if (list == null) {
            return new com.badlogic.gdx.files.FileHandle[0];
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
        int i = 0;
        for (java.lang.String str : list) {
            com.badlogic.gdx.files.FileHandle child = child(str);
            if (fileFilter.accept(child.file())) {
                fileHandleArr[i] = child;
                i++;
            }
        }
        if (i >= list.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    public com.badlogic.gdx.files.FileHandle[] list(java.io.FilenameFilter filenameFilter) {
        if (this.type == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        java.io.File file = file();
        java.lang.String[] list = file.list();
        if (list == null) {
            return new com.badlogic.gdx.files.FileHandle[0];
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
        int i = 0;
        for (java.lang.String str : list) {
            if (filenameFilter.accept(file, str)) {
                fileHandleArr[i] = child(str);
                i++;
            }
        }
        if (i >= list.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    public com.badlogic.gdx.files.FileHandle[] list(java.lang.String str) {
        if (this.type == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot list a classpath directory: " + this.file);
        }
        java.lang.String[] list = file().list();
        if (list == null) {
            return new com.badlogic.gdx.files.FileHandle[0];
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
        int i = 0;
        for (java.lang.String str2 : list) {
            if (str2.endsWith(str)) {
                fileHandleArr[i] = child(str2);
                i++;
            }
        }
        if (i >= list.length) {
            return fileHandleArr;
        }
        com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
        java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
        return fileHandleArr2;
    }

    public void mkdirs() {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot mkdirs with a classpath file: " + this.file);
        }
        if (fileType != com.badlogic.gdx.Files.FileType.Internal) {
            file().mkdirs();
            return;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot mkdirs with an internal file: " + this.file);
    }

    public void moveTo(com.badlogic.gdx.files.FileHandle fileHandle) {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot move a classpath file: " + this.file);
        }
        if (fileType == com.badlogic.gdx.Files.FileType.Internal) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot move an internal file: " + this.file);
        }
        copyTo(fileHandle);
        delete();
        if (exists() && isDirectory()) {
            deleteDirectory();
        }
    }

    public java.lang.String name() {
        return this.file.getName();
    }

    public java.lang.String nameWithoutExtension() {
        java.lang.String name = this.file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    public com.badlogic.gdx.files.FileHandle parent() {
        java.io.File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            parentFile = this.type == com.badlogic.gdx.Files.FileType.Absolute ? new java.io.File(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) : new java.io.File("");
        }
        return new com.badlogic.gdx.files.FileHandle(parentFile, this.type);
    }

    public java.lang.String path() {
        return this.file.getPath().replace('\\', '/');
    }

    public java.lang.String pathWithoutExtension() {
        java.lang.String replace = this.file.getPath().replace('\\', '/');
        int lastIndexOf = replace.lastIndexOf(46);
        return lastIndexOf == -1 ? replace : replace.substring(0, lastIndexOf);
    }

    public java.io.BufferedInputStream read(int i) {
        return new java.io.BufferedInputStream(read(), i);
    }

    public java.io.InputStream read() {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath || ((fileType == com.badlogic.gdx.Files.FileType.Internal && !file().exists()) || (this.type == com.badlogic.gdx.Files.FileType.Local && !file().exists()))) {
            java.io.InputStream resourceAsStream = com.badlogic.gdx.files.FileHandle.class.getResourceAsStream(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + this.file.getPath().replace('\\', '/'));
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException(org.apache.tools.ant.taskdefs.optional.SchemaValidate.SchemaLocation.ERROR_NO_FILE + this.file + " (" + this.type + ")");
        }
        try {
            return new java.io.FileInputStream(file());
        } catch (java.lang.Exception e) {
            if (file().isDirectory()) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this.file + " (" + this.type + ")", e);
        }
    }

    public int readBytes(byte[] bArr, int i, int i2) {
        java.io.InputStream read = read();
        int i3 = 0;
        while (true) {
            try {
                try {
                    int read2 = read.read(bArr, i + i3, i2 - i3);
                    if (read2 <= 0) {
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
                        return i3 - i;
                    }
                    i3 += read2;
                } catch (java.io.IOException e) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this, e);
                }
            } catch (java.lang.Throwable th) {
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
                throw th;
            }
        }
    }

    public byte[] readBytes() {
        java.io.InputStream read = read();
        try {
            try {
                return com.badlogic.gdx.utils.StreamUtils.copyStreamToByteArray(read, e());
            } catch (java.io.IOException e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this, e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
        }
    }

    public java.lang.String readString() {
        return readString(null);
    }

    public java.lang.String readString(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(e());
        java.io.InputStreamReader inputStreamReader = null;
        try {
            try {
                inputStreamReader = str == null ? new java.io.InputStreamReader(read()) : new java.io.InputStreamReader(read(), str);
                char[] cArr = new char[256];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(inputStreamReader);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (java.io.IOException e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading layout file: " + this, e);
            }
        } catch (java.lang.Throwable th) {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    public java.io.BufferedReader reader(int i) {
        return new java.io.BufferedReader(new java.io.InputStreamReader(read()), i);
    }

    public java.io.BufferedReader reader(int i, java.lang.String str) {
        try {
            return new java.io.BufferedReader(new java.io.InputStreamReader(read(), str), i);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this, e);
        }
    }

    public java.io.Reader reader() {
        return new java.io.InputStreamReader(read());
    }

    public java.io.Reader reader(java.lang.String str) {
        java.io.InputStream read = read();
        try {
            return new java.io.InputStreamReader(read, str);
        } catch (java.io.UnsupportedEncodingException e) {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(read);
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this, e);
        }
    }

    public com.badlogic.gdx.files.FileHandle sibling(java.lang.String str) {
        if (this.file.getPath().length() != 0) {
            return new com.badlogic.gdx.files.FileHandle(new java.io.File(this.file.getParent(), str), this.type);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot get the sibling of the root.");
    }

    public java.lang.String toString() {
        return this.file.getPath().replace('\\', '/');
    }

    public com.badlogic.gdx.Files.FileType type() {
        return this.type;
    }

    public java.io.OutputStream write(boolean z) {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot write to a classpath file: " + this.file);
        }
        if (fileType == com.badlogic.gdx.Files.FileType.Internal) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot write to an internal file: " + this.file);
        }
        parent().mkdirs();
        try {
            return new java.io.FileOutputStream(file(), z);
        } catch (java.lang.Exception e) {
            if (file().isDirectory()) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", e);
        }
    }

    public java.io.OutputStream write(boolean z, int i) {
        return new java.io.BufferedOutputStream(write(z), i);
    }

    public void write(java.io.InputStream inputStream, boolean z) {
        java.io.OutputStream outputStream = null;
        try {
            try {
                outputStream = write(z);
                com.badlogic.gdx.utils.StreamUtils.copyStream(inputStream, outputStream);
            } catch (java.lang.Exception e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error stream writing to file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(inputStream);
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(outputStream);
        }
    }

    public void writeBytes(byte[] bArr, int i, int i2, boolean z) {
        java.io.OutputStream write = write(z);
        try {
            try {
                write.write(bArr, i, i2);
            } catch (java.io.IOException e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(write);
        }
    }

    public void writeBytes(byte[] bArr, boolean z) {
        java.io.OutputStream write = write(z);
        try {
            try {
                write.write(bArr);
            } catch (java.io.IOException e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(write);
        }
    }

    public void writeString(java.lang.String str, boolean z) {
        writeString(str, z, null);
    }

    public void writeString(java.lang.String str, boolean z, java.lang.String str2) {
        java.io.Writer writer = null;
        try {
            try {
                writer = writer(z, str2);
                writer.write(str);
            } catch (java.lang.Exception e) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", e);
            }
        } finally {
            com.badlogic.gdx.utils.StreamUtils.closeQuietly(writer);
        }
    }

    public java.io.Writer writer(boolean z) {
        return writer(z, null);
    }

    public java.io.Writer writer(boolean z, java.lang.String str) {
        com.badlogic.gdx.Files.FileType fileType = this.type;
        if (fileType == com.badlogic.gdx.Files.FileType.Classpath) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot write to a classpath file: " + this.file);
        }
        if (fileType == com.badlogic.gdx.Files.FileType.Internal) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot write to an internal file: " + this.file);
        }
        parent().mkdirs();
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file(), z);
            return str == null ? new java.io.OutputStreamWriter(fileOutputStream) : new java.io.OutputStreamWriter(fileOutputStream, str);
        } catch (java.io.IOException e) {
            if (file().isDirectory()) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", e);
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", e);
        }
    }
}
