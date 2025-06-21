package com.uc.crashsdk.export;

/* loaded from: classes19.dex */
public class DumpFileInfo {
    public java.lang.String mCategory;
    public boolean mDeleteAfterDump;
    public java.lang.String mFileTobeDump;
    public boolean mIsEncrypted;
    public int mLogType;
    public boolean mWriteCategory;

    public DumpFileInfo(com.uc.crashsdk.export.DumpFileInfo dumpFileInfo) {
        this.mWriteCategory = true;
        this.mDeleteAfterDump = false;
        this.mIsEncrypted = false;
        this.mCategory = dumpFileInfo.mCategory;
        this.mFileTobeDump = dumpFileInfo.mFileTobeDump;
        this.mLogType = dumpFileInfo.mLogType;
        this.mWriteCategory = dumpFileInfo.mWriteCategory;
        this.mDeleteAfterDump = dumpFileInfo.mDeleteAfterDump;
        this.mIsEncrypted = dumpFileInfo.mIsEncrypted;
    }

    public DumpFileInfo(java.lang.String str, java.lang.String str2, int i) {
        this.mWriteCategory = true;
        this.mDeleteAfterDump = false;
        this.mIsEncrypted = false;
        this.mCategory = str;
        this.mFileTobeDump = str2;
        this.mLogType = i;
    }
}
