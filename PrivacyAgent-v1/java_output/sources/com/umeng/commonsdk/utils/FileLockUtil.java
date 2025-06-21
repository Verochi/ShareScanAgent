package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public class FileLockUtil {
    private final java.lang.Object lockObject = new java.lang.Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.nio.channels.FileLock getFileLock(java.lang.String str) {
        java.nio.channels.FileChannel fileChannel;
        try {
            fileChannel = new java.io.RandomAccessFile(str, "rw").getChannel();
        } catch (java.io.FileNotFoundException e) {
            e = e;
            fileChannel = null;
        } catch (java.io.IOException e2) {
            e = e2;
            fileChannel = null;
        }
        try {
            return fileChannel.lock();
        } catch (java.io.FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (java.io.IOException e5) {
            e = e5;
            e.printStackTrace();
            if (fileChannel != null) {
            }
            return null;
        }
    }

    public void doFileOperateion(java.io.File file, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                java.nio.channels.FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.io.IOException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (java.io.IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(java.io.File file, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback, int i) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                java.nio.channels.FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file, i);
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.lang.Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(java.io.File file, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback, java.lang.Object obj) {
        if (file.exists()) {
            synchronized (this.lockObject) {
                java.nio.channels.FileLock fileLock = getFileLock(file.getAbsolutePath());
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName(), obj);
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.io.IOException e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileLock.release();
                            fileLock.channel().close();
                        } catch (java.io.IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public void doFileOperateion(java.lang.String str, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback) {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                java.nio.channels.FileLock fileLock = getFileLock(str);
                if (fileLock != null) {
                    try {
                        try {
                            fileLockCallback.onFileLock(file.getName());
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.io.IOException e) {
                                e = e;
                                e.printStackTrace();
                            }
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (java.io.IOException e3) {
                                e = e3;
                                e.printStackTrace();
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
