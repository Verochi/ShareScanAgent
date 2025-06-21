package com.uc.crashsdk.export;

/* loaded from: classes19.dex */
public class CustomLogInfo {
    public boolean mAddBuildId;
    public boolean mAddFooter;
    public boolean mAddHeader;
    public boolean mAddLogcat;
    public boolean mAddThreadsDump;
    public java.util.ArrayList<java.lang.String> mCachedInfos;
    public java.util.ArrayList<java.lang.String> mCallbacks;
    public java.lang.StringBuffer mData;
    public java.util.ArrayList<java.lang.String> mDumpFiles;
    public java.util.ArrayList<java.lang.Integer> mDumpTids;
    public java.lang.String mLogType;
    public boolean mUploadNow;

    public CustomLogInfo(com.uc.crashsdk.export.CustomLogInfo customLogInfo) {
        this.mAddHeader = true;
        this.mAddFooter = true;
        this.mAddLogcat = false;
        this.mUploadNow = false;
        this.mAddThreadsDump = false;
        this.mAddBuildId = false;
        this.mDumpFiles = null;
        this.mCallbacks = null;
        this.mCachedInfos = null;
        this.mDumpTids = null;
        this.mData = customLogInfo.mData;
        this.mLogType = customLogInfo.mLogType;
        this.mAddHeader = customLogInfo.mAddHeader;
        this.mAddFooter = customLogInfo.mAddFooter;
        this.mAddLogcat = customLogInfo.mAddLogcat;
        this.mUploadNow = customLogInfo.mUploadNow;
        this.mAddThreadsDump = customLogInfo.mAddThreadsDump;
        this.mAddBuildId = customLogInfo.mAddBuildId;
        if (customLogInfo.mDumpFiles != null) {
            this.mDumpFiles = new java.util.ArrayList<>(customLogInfo.mDumpFiles);
        }
        if (customLogInfo.mCallbacks != null) {
            this.mCallbacks = new java.util.ArrayList<>(customLogInfo.mCallbacks);
        }
        if (customLogInfo.mCachedInfos != null) {
            this.mCachedInfos = new java.util.ArrayList<>(customLogInfo.mCachedInfos);
        }
        if (customLogInfo.mDumpTids != null) {
            this.mDumpTids = new java.util.ArrayList<>(customLogInfo.mDumpTids);
        }
    }

    public CustomLogInfo(java.lang.StringBuffer stringBuffer, java.lang.String str) {
        this.mAddHeader = true;
        this.mAddFooter = true;
        this.mAddLogcat = false;
        this.mUploadNow = false;
        this.mAddThreadsDump = false;
        this.mAddBuildId = false;
        this.mDumpFiles = null;
        this.mCallbacks = null;
        this.mCachedInfos = null;
        this.mDumpTids = null;
        this.mData = stringBuffer;
        this.mLogType = str;
    }
}
