package com.tencent.mmkv;

/* loaded from: classes19.dex */
public class MMKV implements android.content.SharedPreferences, android.content.SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int BACKUP_MODE = 16;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final java.util.Set<java.lang.Long> checkedHandleSet;
    private static com.tencent.mmkv.MMKVHandler gCallbackHandler;
    private static com.tencent.mmkv.MMKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting;
    private static final com.tencent.mmkv.MMKVLogLevel[] index2LogLevel;
    private static boolean isProcessModeCheckerEnabled;
    private static final java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer> logLevel2Index;
    private static final java.util.HashMap<java.lang.String, android.os.Parcelable.Creator<?>> mCreators;
    private static final java.util.EnumMap<com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer> recoverIndex;
    private static java.lang.String rootDir;
    private final long nativeHandle;

    /* renamed from: com.tencent.mmkv.MMKV$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mmkv$MMKVLogLevel;

        static {
            int[] iArr = new int[com.tencent.mmkv.MMKVLogLevel.values().length];
            $SwitchMap$com$tencent$mmkv$MMKVLogLevel = iArr;
            try {
                iArr[com.tencent.mmkv.MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[com.tencent.mmkv.MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[com.tencent.mmkv.MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[com.tencent.mmkv.MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[com.tencent.mmkv.MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public interface LibLoader {
        void loadLibrary(java.lang.String str);
    }

    static {
        java.util.EnumMap<com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer> enumMap = new java.util.EnumMap<>((java.lang.Class<com.tencent.mmkv.MMKVRecoverStrategic>) com.tencent.mmkv.MMKVRecoverStrategic.class);
        recoverIndex = enumMap;
        enumMap.put((java.util.EnumMap<com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer>) com.tencent.mmkv.MMKVRecoverStrategic.OnErrorDiscard, (com.tencent.mmkv.MMKVRecoverStrategic) 0);
        enumMap.put((java.util.EnumMap<com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer>) com.tencent.mmkv.MMKVRecoverStrategic.OnErrorRecover, (com.tencent.mmkv.MMKVRecoverStrategic) 1);
        java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer> enumMap2 = new java.util.EnumMap<>((java.lang.Class<com.tencent.mmkv.MMKVLogLevel>) com.tencent.mmkv.MMKVLogLevel.class);
        logLevel2Index = enumMap2;
        com.tencent.mmkv.MMKVLogLevel mMKVLogLevel = com.tencent.mmkv.MMKVLogLevel.LevelDebug;
        enumMap2.put((java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer>) mMKVLogLevel, (com.tencent.mmkv.MMKVLogLevel) 0);
        com.tencent.mmkv.MMKVLogLevel mMKVLogLevel2 = com.tencent.mmkv.MMKVLogLevel.LevelInfo;
        enumMap2.put((java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer>) mMKVLogLevel2, (com.tencent.mmkv.MMKVLogLevel) 1);
        com.tencent.mmkv.MMKVLogLevel mMKVLogLevel3 = com.tencent.mmkv.MMKVLogLevel.LevelWarning;
        enumMap2.put((java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer>) mMKVLogLevel3, (com.tencent.mmkv.MMKVLogLevel) 2);
        com.tencent.mmkv.MMKVLogLevel mMKVLogLevel4 = com.tencent.mmkv.MMKVLogLevel.LevelError;
        enumMap2.put((java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer>) mMKVLogLevel4, (com.tencent.mmkv.MMKVLogLevel) 3);
        com.tencent.mmkv.MMKVLogLevel mMKVLogLevel5 = com.tencent.mmkv.MMKVLogLevel.LevelNone;
        enumMap2.put((java.util.EnumMap<com.tencent.mmkv.MMKVLogLevel, java.lang.Integer>) mMKVLogLevel5, (com.tencent.mmkv.MMKVLogLevel) 4);
        index2LogLevel = new com.tencent.mmkv.MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        checkedHandleSet = new java.util.HashSet();
        rootDir = null;
        isProcessModeCheckerEnabled = true;
        mCreators = new java.util.HashMap<>();
        gWantLogReDirecting = false;
    }

    private MMKV(long j) {
        this.nativeHandle = j;
    }

    private native long actualSize(long j);

    public static com.tencent.mmkv.MMKV backedUpMMKVWithID(java.lang.String str, int i, @androidx.annotation.Nullable java.lang.String str2, java.lang.String str3) throws java.lang.RuntimeException {
        if (rootDir == null) {
            throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
        }
        int i2 = i | 16;
        return checkProcessMode(getMMKVWithID(str, i2, str2, str3), str, i2);
    }

    public static native long backupAllToDirectory(java.lang.String str);

    public static native boolean backupOneToDirectory(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3);

    private static com.tencent.mmkv.MMKV checkProcessMode(long j, java.lang.String str, int i) throws java.lang.RuntimeException {
        java.lang.String str2;
        if (j == 0) {
            throw new java.lang.RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!isProcessModeCheckerEnabled) {
            return new com.tencent.mmkv.MMKV(j);
        }
        java.util.Set<java.lang.Long> set = checkedHandleSet;
        synchronized (set) {
            if (!set.contains(java.lang.Long.valueOf(j))) {
                if (!checkProcessMode(j)) {
                    if (i == 1) {
                        str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                    } else {
                        str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                    }
                    throw new java.lang.IllegalArgumentException(str2);
                }
                set.add(java.lang.Long.valueOf(j));
            }
        }
        return new com.tencent.mmkv.MMKV(j);
    }

    private static native boolean checkProcessMode(long j);

    private native boolean containsKey(long j, java.lang.String str);

    private native long count(long j);

    private static native long createNB(int i);

    @androidx.annotation.Nullable
    public static com.tencent.mmkv.NativeBuffer createNativeBuffer(int i) {
        long createNB = createNB(i);
        if (createNB <= 0) {
            return null;
        }
        return new com.tencent.mmkv.NativeBuffer(createNB, i);
    }

    private native boolean decodeBool(long j, java.lang.String str, boolean z);

    @androidx.annotation.Nullable
    private native byte[] decodeBytes(long j, java.lang.String str);

    private native double decodeDouble(long j, java.lang.String str, double d);

    private native float decodeFloat(long j, java.lang.String str, float f);

    private native int decodeInt(long j, java.lang.String str, int i);

    private native long decodeLong(long j, java.lang.String str, long j2);

    @androidx.annotation.Nullable
    private native java.lang.String decodeString(long j, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2);

    @androidx.annotation.Nullable
    private native java.lang.String[] decodeStringSet(long j, java.lang.String str);

    public static com.tencent.mmkv.MMKV defaultMMKV() throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static com.tencent.mmkv.MMKV defaultMMKV(int i, @androidx.annotation.Nullable java.lang.String str) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(i, str), "DefaultMMKV", i);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void destroyNB(long j, int i);

    public static void destroyNativeBuffer(com.tencent.mmkv.NativeBuffer nativeBuffer) {
        destroyNB(nativeBuffer.pointer, nativeBuffer.size);
    }

    public static void disableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = false;
        }
    }

    private static java.lang.String doInitialize(java.lang.String str, java.lang.String str2, com.tencent.mmkv.MMKV.LibLoader libLoader, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        if (libLoader != null) {
            libLoader.loadLibrary("mmkv");
        } else {
            java.lang.System.loadLibrary("mmkv");
        }
        jniInitialize(str, str2, logLevel2Int(mMKVLogLevel));
        rootDir = str;
        return str;
    }

    public static void enableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = true;
        }
    }

    private native boolean encodeBool(long j, java.lang.String str, boolean z);

    private native boolean encodeBytes(long j, java.lang.String str, @androidx.annotation.Nullable byte[] bArr);

    private native boolean encodeDouble(long j, java.lang.String str, double d);

    private native boolean encodeFloat(long j, java.lang.String str, float f);

    private native boolean encodeInt(long j, java.lang.String str, int i);

    private native boolean encodeLong(long j, java.lang.String str, long j2);

    private native boolean encodeSet(long j, java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr);

    private native boolean encodeString(long j, java.lang.String str, @androidx.annotation.Nullable java.lang.String str2);

    private static native long getDefaultMMKV(int i, @androidx.annotation.Nullable java.lang.String str);

    private static native long getMMKVWithAshmemFD(java.lang.String str, int i, int i2, @androidx.annotation.Nullable java.lang.String str2);

    private static native long getMMKVWithID(java.lang.String str, int i, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3);

    private static native long getMMKVWithIDAndSize(java.lang.String str, int i, int i2, @androidx.annotation.Nullable java.lang.String str2);

    public static java.lang.String getRootDir() {
        return rootDir;
    }

    public static java.lang.String initialize(android.content.Context context) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    public static java.lang.String initialize(android.content.Context context, com.tencent.mmkv.MMKV.LibLoader libLoader) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    public static java.lang.String initialize(android.content.Context context, com.tencent.mmkv.MMKV.LibLoader libLoader, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, mMKVLogLevel);
    }

    public static java.lang.String initialize(android.content.Context context, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, mMKVLogLevel);
    }

    public static java.lang.String initialize(android.content.Context context, java.lang.String str) {
        return initialize(context, str, null, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    public static java.lang.String initialize(android.content.Context context, java.lang.String str, com.tencent.mmkv.MMKV.LibLoader libLoader) {
        return initialize(context, str, libLoader, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    public static java.lang.String initialize(android.content.Context context, java.lang.String str, com.tencent.mmkv.MMKV.LibLoader libLoader, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            disableProcessModeChecker();
        } else {
            enableProcessModeChecker();
        }
        return doInitialize(str, context.getCacheDir().getAbsolutePath(), libLoader, mMKVLogLevel);
    }

    public static java.lang.String initialize(android.content.Context context, java.lang.String str, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        return initialize(context, str, null, mMKVLogLevel);
    }

    @java.lang.Deprecated
    public static java.lang.String initialize(java.lang.String str) {
        return doInitialize(str, str + "/.tmp", null, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    @java.lang.Deprecated
    public static java.lang.String initialize(java.lang.String str, com.tencent.mmkv.MMKV.LibLoader libLoader) {
        return doInitialize(str, str + "/.tmp", libLoader, com.tencent.mmkv.MMKVLogLevel.LevelInfo);
    }

    @java.lang.Deprecated
    public static java.lang.String initialize(java.lang.String str, com.tencent.mmkv.MMKV.LibLoader libLoader, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, str + "/.tmp", libLoader, mMKVLogLevel);
    }

    @java.lang.Deprecated
    public static java.lang.String initialize(java.lang.String str, com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, str + "/.tmp", null, mMKVLogLevel);
    }

    public static boolean isFileValid(java.lang.String str) {
        return isFileValid(str, null);
    }

    public static native boolean isFileValid(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2);

    private static native void jniInitialize(java.lang.String str, java.lang.String str2, int i);

    private static int logLevel2Int(com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        int i = com.tencent.mmkv.MMKV.AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[mMKVLogLevel.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        if (i != 3) {
            return i != 4 ? 1 : 4;
        }
        return 3;
    }

    private static void mmkvLogImp(int i, java.lang.String str, int i2, java.lang.String str2, java.lang.String str3) {
        com.tencent.mmkv.MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler == null || !gWantLogReDirecting) {
            int i3 = com.tencent.mmkv.MMKV.AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[i].ordinal()];
        } else {
            mMKVHandler.mmkvLog(index2LogLevel[i], str, i2, str2, str3);
        }
    }

    public static com.tencent.mmkv.MMKV mmkvWithAshmemFD(java.lang.String str, int i, int i2, java.lang.String str2) throws java.lang.RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i, i2, str2);
        if (mMKVWithAshmemFD != 0) {
            return new com.tencent.mmkv.MMKV(mMKVWithAshmemFD);
        }
        throw new java.lang.RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public static com.tencent.mmkv.MMKV mmkvWithAshmemID(android.content.Context context, java.lang.String str, int i, int i2, @androidx.annotation.Nullable java.lang.String str2) throws java.lang.RuntimeException {
        com.tencent.mmkv.MMKV mmkv;
        if (rootDir == null) {
            throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
        }
        java.lang.String processNameByPID = com.tencent.mmkv.MMKVContentProvider.getProcessNameByPID(context, android.os.Process.myPid());
        if (processNameByPID == null || processNameByPID.length() == 0) {
            simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new java.lang.IllegalStateException("process name detect fail, try again later");
        }
        if (processNameByPID.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
            android.net.Uri contentUri = com.tencent.mmkv.MMKVContentProvider.contentUri(context);
            if (contentUri == null) {
                simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new java.lang.IllegalStateException("MMKVContentProvider has invalid authority");
            }
            com.tencent.mmkv.MMKVLogLevel mMKVLogLevel = com.tencent.mmkv.MMKVLogLevel.LevelInfo;
            simpleLog(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + contentUri);
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("KEY_SIZE", i);
            bundle.putInt("KEY_MODE", i2);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            android.os.Bundle call = context.getContentResolver().call(contentUri, "mmkvFromAshmemID", str, bundle);
            if (call != null) {
                call.setClassLoader(com.tencent.mmkv.ParcelableMMKV.class.getClassLoader());
                com.tencent.mmkv.ParcelableMMKV parcelableMMKV = (com.tencent.mmkv.ParcelableMMKV) call.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.toMMKV()) != null) {
                    simpleLog(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i, i2 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new com.tencent.mmkv.MMKV(mMKVWithIDAndSize);
        }
        throw new java.lang.IllegalStateException("Fail to create an Ashmem MMKV instance [" + str + "]");
    }

    public static com.tencent.mmkv.MMKV mmkvWithID(java.lang.String str) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, null), str, 1);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static com.tencent.mmkv.MMKV mmkvWithID(java.lang.String str, int i) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, null, null), str, i);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static com.tencent.mmkv.MMKV mmkvWithID(java.lang.String str, int i, @androidx.annotation.Nullable java.lang.String str2) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, str2, null), str, i);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static com.tencent.mmkv.MMKV mmkvWithID(java.lang.String str, int i, @androidx.annotation.Nullable java.lang.String str2, java.lang.String str3) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, str2, str3), str, i);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static com.tencent.mmkv.MMKV mmkvWithID(java.lang.String str, java.lang.String str2) throws java.lang.RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, str2), str, 1);
        }
        throw new java.lang.IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void onContentChangedByOuterProcess(java.lang.String str) {
        com.tencent.mmkv.MMKVContentChangeNotification mMKVContentChangeNotification = gContentChangeNotify;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.onContentChangedByOuterProcess(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(java.lang.String str) {
        com.tencent.mmkv.MMKVRecoverStrategic mMKVRecoverStrategic = com.tencent.mmkv.MMKVRecoverStrategic.OnErrorDiscard;
        com.tencent.mmkv.MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVCRCCheckFail(str);
        }
        simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        java.lang.Integer num = recoverIndex.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(java.lang.String str) {
        com.tencent.mmkv.MMKVRecoverStrategic mMKVRecoverStrategic = com.tencent.mmkv.MMKVRecoverStrategic.OnErrorDiscard;
        com.tencent.mmkv.MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategic = mMKVHandler.onMMKVFileLengthError(str);
        }
        simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        java.lang.Integer num = recoverIndex.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static void registerContentChangeNotify(com.tencent.mmkv.MMKVContentChangeNotification mMKVContentChangeNotification) {
        gContentChangeNotify = mMKVContentChangeNotification;
        setWantsContentChangeNotify(mMKVContentChangeNotification != null);
    }

    public static void registerHandler(com.tencent.mmkv.MMKVHandler mMKVHandler) {
        gCallbackHandler = mMKVHandler;
        if (mMKVHandler.wantLogRedirecting()) {
            setCallbackHandler(true, true);
            gWantLogReDirecting = true;
        } else {
            setCallbackHandler(false, true);
            gWantLogReDirecting = false;
        }
    }

    private native void removeValueForKey(long j, java.lang.String str);

    public static native long restoreAllFromDirectory(java.lang.String str);

    public static native boolean restoreOneMMKVFromDirectory(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3);

    private static native void setCallbackHandler(boolean z, boolean z2);

    private static native void setLogLevel(int i);

    public static void setLogLevel(com.tencent.mmkv.MMKVLogLevel mMKVLogLevel) {
        setLogLevel(logLevel2Int(mMKVLogLevel));
    }

    private static native void setWantsContentChangeNotify(boolean z);

    private static void simpleLog(com.tencent.mmkv.MMKVLogLevel mMKVLogLevel, java.lang.String str) {
        java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[r0.length - 1];
        java.lang.Integer num = logLevel2Index.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native void sync(boolean z);

    private native long totalSize(long j);

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false);
        gWantLogReDirecting = false;
    }

    private native int valueSize(long j, java.lang.String str, boolean z);

    public static native java.lang.String version();

    private native int writeValueToNB(long j, java.lang.String str, long j2, int i);

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    @androidx.annotation.Nullable
    public native java.lang.String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    @java.lang.Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public void async() {
        sync(false);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@androidx.annotation.Nullable java.lang.String str);

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @java.lang.Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        return containsKey(str);
    }

    public boolean containsKey(java.lang.String str) {
        return containsKey(this.nativeHandle, str);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    @androidx.annotation.Nullable
    public native java.lang.String cryptKey();

    public boolean decodeBool(java.lang.String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    public boolean decodeBool(java.lang.String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    @androidx.annotation.Nullable
    public byte[] decodeBytes(java.lang.String str) {
        return decodeBytes(str, (byte[]) null);
    }

    @androidx.annotation.Nullable
    public byte[] decodeBytes(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        byte[] decodeBytes = decodeBytes(this.nativeHandle, str);
        return decodeBytes != null ? decodeBytes : bArr;
    }

    public double decodeDouble(java.lang.String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public double decodeDouble(java.lang.String str, double d) {
        return decodeDouble(this.nativeHandle, str, d);
    }

    public float decodeFloat(java.lang.String str) {
        return decodeFloat(this.nativeHandle, str, 0.0f);
    }

    public float decodeFloat(java.lang.String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public int decodeInt(java.lang.String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public int decodeInt(java.lang.String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public long decodeLong(java.lang.String str) {
        return decodeLong(this.nativeHandle, str, 0L);
    }

    public long decodeLong(java.lang.String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    @androidx.annotation.Nullable
    public <T extends android.os.Parcelable> T decodeParcelable(java.lang.String str, java.lang.Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    @androidx.annotation.Nullable
    public <T extends android.os.Parcelable> T decodeParcelable(java.lang.String str, java.lang.Class<T> cls, @androidx.annotation.Nullable T t) {
        byte[] decodeBytes;
        android.os.Parcelable.Creator<?> creator;
        if (cls == null || (decodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t;
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        obtain.unmarshall(decodeBytes, 0, decodeBytes.length);
        obtain.setDataPosition(0);
        try {
            java.lang.String cls2 = cls.toString();
            java.util.HashMap<java.lang.String, android.os.Parcelable.Creator<?>> hashMap = mCreators;
            synchronized (hashMap) {
                creator = hashMap.get(cls2);
                if (creator == null && (creator = (android.os.Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                    hashMap.put(cls2, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(obtain);
            }
            throw new java.lang.Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + cls2);
        } catch (java.lang.Exception e) {
            simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelError, e.toString());
            return t;
        } finally {
            obtain.recycle();
        }
    }

    @androidx.annotation.Nullable
    public java.lang.String decodeString(java.lang.String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @androidx.annotation.Nullable
    public java.lang.String decodeString(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @androidx.annotation.Nullable
    public java.util.Set<java.lang.String> decodeStringSet(java.lang.String str) {
        return decodeStringSet(str, (java.util.Set<java.lang.String>) null);
    }

    @androidx.annotation.Nullable
    public java.util.Set<java.lang.String> decodeStringSet(java.lang.String str, @androidx.annotation.Nullable java.util.Set<java.lang.String> set) {
        return decodeStringSet(str, set, java.util.HashSet.class);
    }

    @androidx.annotation.Nullable
    public java.util.Set<java.lang.String> decodeStringSet(java.lang.String str, @androidx.annotation.Nullable java.util.Set<java.lang.String> set, java.lang.Class<? extends java.util.Set> cls) {
        java.lang.String[] decodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (decodeStringSet == null) {
            return set;
        }
        try {
            java.util.Set<java.lang.String> newInstance = cls.newInstance();
            newInstance.addAll(java.util.Arrays.asList(decodeStringSet));
            return newInstance;
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public android.content.SharedPreferences.Editor edit() {
        return this;
    }

    public boolean encode(java.lang.String str, double d) {
        return encodeDouble(this.nativeHandle, str, d);
    }

    public boolean encode(java.lang.String str, float f) {
        return encodeFloat(this.nativeHandle, str, f);
    }

    public boolean encode(java.lang.String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public boolean encode(java.lang.String str, long j) {
        return encodeLong(this.nativeHandle, str, j);
    }

    public boolean encode(java.lang.String str, @androidx.annotation.Nullable android.os.Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return encodeBytes(this.nativeHandle, str, marshall);
    }

    public boolean encode(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(java.lang.String str, @androidx.annotation.Nullable java.util.Set<java.lang.String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (java.lang.String[]) set.toArray(new java.lang.String[0]));
    }

    public boolean encode(java.lang.String str, boolean z) {
        return encodeBool(this.nativeHandle, str, z);
    }

    public boolean encode(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    @Override // android.content.SharedPreferences
    public java.util.Map<java.lang.String, ?> getAll() {
        throw new java.lang.UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public byte[] getBytes(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        return decodeBytes(str, bArr);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(java.lang.String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(java.lang.String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(java.lang.String str, long j) {
        return decodeLong(this.nativeHandle, str, j);
    }

    @Override // android.content.SharedPreferences
    @androidx.annotation.Nullable
    public java.lang.String getString(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @androidx.annotation.Nullable
    public java.util.Set<java.lang.String> getStringSet(java.lang.String str, @androidx.annotation.Nullable java.util.Set<java.lang.String> set) {
        return decodeStringSet(str, set);
    }

    public int getValueActualSize(java.lang.String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public int getValueSize(java.lang.String str) {
        return valueSize(this.nativeHandle, str, false);
    }

    public int importFromSharedPreferences(android.content.SharedPreferences sharedPreferences) {
        java.util.Map<java.lang.String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (key != null && value != null) {
                if (value instanceof java.lang.Boolean) {
                    encodeBool(this.nativeHandle, key, ((java.lang.Boolean) value).booleanValue());
                } else if (value instanceof java.lang.Integer) {
                    encodeInt(this.nativeHandle, key, ((java.lang.Integer) value).intValue());
                } else if (value instanceof java.lang.Long) {
                    encodeLong(this.nativeHandle, key, ((java.lang.Long) value).longValue());
                } else if (value instanceof java.lang.Float) {
                    encodeFloat(this.nativeHandle, key, ((java.lang.Float) value).floatValue());
                } else if (value instanceof java.lang.Double) {
                    encodeDouble(this.nativeHandle, key, ((java.lang.Double) value).doubleValue());
                } else if (value instanceof java.lang.String) {
                    encodeString(this.nativeHandle, key, (java.lang.String) value);
                } else if (value instanceof java.util.Set) {
                    encode(key, (java.util.Set<java.lang.String>) value);
                } else {
                    simpleLog(com.tencent.mmkv.MMKVLogLevel.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        return all.size();
    }

    public native void lock();

    public native java.lang.String mmapID();

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putBoolean(java.lang.String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    public android.content.SharedPreferences.Editor putBytes(java.lang.String str, @androidx.annotation.Nullable byte[] bArr) {
        encode(str, bArr);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putFloat(java.lang.String str, float f) {
        encodeFloat(this.nativeHandle, str, f);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putInt(java.lang.String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putLong(java.lang.String str, long j) {
        encodeLong(this.nativeHandle, str, j);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putString(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor putStringSet(java.lang.String str, @androidx.annotation.Nullable java.util.Set<java.lang.String> set) {
        encode(str, set);
        return this;
    }

    public native boolean reKey(@androidx.annotation.Nullable java.lang.String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new java.lang.UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public android.content.SharedPreferences.Editor remove(java.lang.String str) {
        removeValueForKey(str);
        return this;
    }

    public void removeValueForKey(java.lang.String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void removeValuesForKeys(java.lang.String[] strArr);

    public void sync() {
        sync(true);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new java.lang.UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public int writeValueToNativeBuffer(java.lang.String str, com.tencent.mmkv.NativeBuffer nativeBuffer) {
        return writeValueToNB(this.nativeHandle, str, nativeBuffer.pointer, nativeBuffer.size);
    }
}
