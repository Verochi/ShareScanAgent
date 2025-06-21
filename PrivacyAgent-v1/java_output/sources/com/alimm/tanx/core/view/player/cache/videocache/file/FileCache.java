package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
public class FileCache implements com.alimm.tanx.core.view.player.cache.videocache.Cache {
    private static final java.lang.String TEMP_POSTFIX = ".download";
    private java.io.RandomAccessFile dataFile;
    private final com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage;
    public java.io.File file;

    public FileCache(java.io.File file) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        this(file, new com.alimm.tanx.core.view.player.cache.videocache.file.UnlimitedDiskUsage());
    }

    public FileCache(java.io.File file, com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage diskUsage) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        java.io.File file2;
        try {
            if (diskUsage == null) {
                throw new java.lang.NullPointerException();
            }
            this.diskUsage = diskUsage;
            com.alimm.tanx.core.view.player.cache.videocache.file.Files.makeDir(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new java.io.File(file.getParentFile(), file.getName() + TEMP_POSTFIX);
            }
            this.file = file2;
            this.dataFile = new java.io.RandomAccessFile(this.file, exists ? "r" : "rw");
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean isTempFile(java.io.File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void append(byte[] bArr, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        try {
            if (isCompleted()) {
                throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i);
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException(java.lang.String.format("Error writing %d bytes to %s from buffer with size %d", java.lang.Integer.valueOf(i), this.dataFile, java.lang.Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized long available() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        try {
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void close() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized void complete() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        if (isCompleted()) {
            return;
        }
        close();
        java.io.File file = new java.io.File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.dataFile = new java.io.RandomAccessFile(this.file, "r");
            this.diskUsage.touch(this.file);
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException("Error opening " + this.file + " as disc cache", e);
        }
    }

    public java.io.File getFile() {
        return this.file;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Cache
    public synchronized int read(byte[] bArr, long j, int i) throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        try {
            this.dataFile.seek(j);
        } catch (java.io.IOException e) {
            throw new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException(java.lang.String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j), java.lang.Long.valueOf(available()), java.lang.Integer.valueOf(bArr.length)), e);
        }
        return this.dataFile.read(bArr, 0, i);
    }
}
