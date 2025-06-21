package com.badlogic.gdx.backends.android;

/* loaded from: classes12.dex */
public class AndroidFileHandle extends com.badlogic.gdx.files.FileHandle {
    public final android.content.res.AssetManager a;

    public AndroidFileHandle(android.content.res.AssetManager assetManager, java.io.File file, com.badlogic.gdx.Files.FileType fileType) {
        super(file, fileType);
        this.a = assetManager;
    }

    public AndroidFileHandle(android.content.res.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.Files.FileType fileType) {
        super(str.replace('\\', '/'), fileType);
        this.a = assetManager;
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle child(java.lang.String str) {
        java.lang.String replace = str.replace('\\', '/');
        return this.file.getPath().length() == 0 ? new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(replace), this.type) : new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(this.file, replace), this.type);
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public boolean exists() {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.exists();
        }
        java.lang.String path = this.file.getPath();
        try {
            this.a.open(path).close();
            return true;
        } catch (java.lang.Exception unused) {
            try {
                return this.a.list(path).length > 0;
            } catch (java.lang.Exception unused2) {
                return false;
            }
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public java.io.File file() {
        return this.type == com.badlogic.gdx.Files.FileType.Local ? new java.io.File(com.badlogic.gdx.Gdx.files.getLocalStoragePath(), this.file.getPath()) : super.file();
    }

    public android.content.res.AssetFileDescriptor getAssetFileDescriptor() throws java.io.IOException {
        android.content.res.AssetManager assetManager = this.a;
        if (assetManager != null) {
            return assetManager.openFd(path());
        }
        return null;
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public boolean isDirectory() {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.isDirectory();
        }
        try {
            return this.a.list(this.file.getPath()).length > 0;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public long lastModified() {
        return super.lastModified();
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public long length() {
        if (this.type == com.badlogic.gdx.Files.FileType.Internal) {
            android.content.res.AssetFileDescriptor assetFileDescriptor = null;
            try {
                assetFileDescriptor = this.a.openFd(this.file.getPath());
                long length = assetFileDescriptor.getLength();
                try {
                    assetFileDescriptor.close();
                } catch (java.io.IOException unused) {
                }
                return length;
            } catch (java.io.IOException unused2) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
            } catch (java.lang.Throwable th) {
                if (assetFileDescriptor != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return super.length();
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list() {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.list();
        }
        try {
            java.lang.String[] list = this.a.list(this.file.getPath());
            int length = list.length;
            com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[length];
            for (int i = 0; i < length; i++) {
                fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(this.file, list[i]), this.type);
            }
            return fileHandleArr;
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", e);
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.io.FileFilter fileFilter) {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.list(fileFilter);
        }
        try {
            java.lang.String[] list = this.a.list(this.file.getPath());
            com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
            int i = 0;
            for (java.lang.String str : list) {
                com.badlogic.gdx.backends.android.AndroidFileHandle androidFileHandle = new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(this.file, str), this.type);
                if (fileFilter.accept(androidFileHandle.file())) {
                    fileHandleArr[i] = androidFileHandle;
                    i++;
                }
            }
            if (i >= list.length) {
                return fileHandleArr;
            }
            com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
            java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
            return fileHandleArr2;
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", e);
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.io.FilenameFilter filenameFilter) {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.list(filenameFilter);
        }
        try {
            java.lang.String[] list = this.a.list(this.file.getPath());
            com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
            int i = 0;
            for (java.lang.String str : list) {
                if (filenameFilter.accept(this.file, str)) {
                    fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(this.file, str), this.type);
                    i++;
                }
            }
            if (i >= list.length) {
                return fileHandleArr;
            }
            com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
            java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
            return fileHandleArr2;
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", e);
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle[] list(java.lang.String str) {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.list(str);
        }
        try {
            java.lang.String[] list = this.a.list(this.file.getPath());
            com.badlogic.gdx.files.FileHandle[] fileHandleArr = new com.badlogic.gdx.files.FileHandle[list.length];
            int i = 0;
            for (java.lang.String str2 : list) {
                if (str2.endsWith(str)) {
                    fileHandleArr[i] = new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, new java.io.File(this.file, str2), this.type);
                    i++;
                }
            }
            if (i >= list.length) {
                return fileHandleArr;
            }
            com.badlogic.gdx.files.FileHandle[] fileHandleArr2 = new com.badlogic.gdx.files.FileHandle[i];
            java.lang.System.arraycopy(fileHandleArr, 0, fileHandleArr2, 0, i);
            return fileHandleArr2;
        } catch (java.lang.Exception e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", e);
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle parent() {
        java.io.File parentFile = this.file.getParentFile();
        if (parentFile == null) {
            parentFile = this.type == com.badlogic.gdx.Files.FileType.Absolute ? new java.io.File(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) : new java.io.File("");
        }
        return new com.badlogic.gdx.backends.android.AndroidFileHandle(this.a, parentFile, this.type);
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public java.io.InputStream read() {
        if (this.type != com.badlogic.gdx.Files.FileType.Internal) {
            return super.read();
        }
        try {
            return this.a.open(this.file.getPath());
        } catch (java.io.IOException e) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("Error reading file: " + this.file + " (" + this.type + ")", e);
        }
    }

    @Override // com.badlogic.gdx.files.FileHandle
    public com.badlogic.gdx.files.FileHandle sibling(java.lang.String str) {
        java.lang.String replace = str.replace('\\', '/');
        if (this.file.getPath().length() != 0) {
            return com.badlogic.gdx.Gdx.files.getFileHandle(new java.io.File(this.file.getParent(), replace).getPath(), this.type);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Cannot get the sibling of the root.");
    }
}
