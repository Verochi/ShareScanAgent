package com.efs.sdk.base.newsharedpreferences;

/* loaded from: classes22.dex */
public final class SharedPreferencesNewImpl implements android.content.SharedPreferences {
    private static final java.lang.String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final java.lang.String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final java.lang.Object mFileMonitorSyncObj = new java.lang.Object();
    private static android.os.HandlerThread[] mHandlerThreadPool = new android.os.HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static java.util.concurrent.ExecutorService sCachedThreadPool;
    private java.lang.String mBackupFilePath;
    private int mCurTryTime;
    private java.util.Vector<android.content.SharedPreferences.Editor> mEditorList;
    private com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener mErrorListener;
    private java.io.File mFile;
    private java.nio.channels.FileChannel mFileChannel;
    private com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.FileMonitor mFileMonitor;
    private android.os.Handler mHandler;
    private boolean mIsSaving;
    private final java.util.ArrayList<android.content.SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final java.util.LinkedHashMap<java.lang.String, java.lang.Object> mMap;
    private java.nio.MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    private int mModifyID;
    private com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.RunnableEx mSaveRunnable;
    private final java.lang.Object mSyncObj;
    private final java.lang.Object mSyncSaveObj;
    private final java.lang.Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    /* renamed from: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.io.File file = new java.io.File(com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.mBackupFilePath);
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int modifyID = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.getModifyID();
            if (modifyID <= 0 || modifyID == com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.mModifyID) {
                return;
            }
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.saveInner(false);
        }
    }

    /* renamed from: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean val$force;

        public AnonymousClass3(boolean z) {
            this.val$force = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.saveInner(this.val$force);
        }
    }

    /* renamed from: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$4, reason: invalid class name */
    public class AnonymousClass4 extends com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.RunnableEx {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.saveInner(((java.lang.Boolean) getArg()).booleanValue());
        }
    }

    /* renamed from: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this) {
                com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.loadFromDiskLocked();
            }
        }
    }

    public static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static float bytesToFloat(byte[] bArr) {
            return java.nio.ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] floatToBytes(float f) {
            return java.nio.ByteBuffer.allocate(4).putFloat(f).array();
        }
    }

    public static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static int bytesToInt(byte[] bArr) {
            return java.nio.ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] intToBytes(int i) {
            return java.nio.ByteBuffer.allocate(4).putInt(i).array();
        }
    }

    public static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static long bytesToLong(byte[] bArr) {
            return java.nio.ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] longToBytes(long j) {
            return java.nio.ByteBuffer.allocate(8).putLong(j).array();
        }
    }

    public final class EditorImpl implements android.content.SharedPreferences.Editor {
        private boolean mClear;
        private java.util.HashMap<java.lang.String, java.lang.Object> mModified = new java.util.HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        public final boolean doClear() {
            boolean z;
            synchronized (this) {
                z = this.mClear;
                this.mClear = false;
            }
            return z;
        }

        public final java.util.HashMap<java.lang.String, java.lang.Object> getAll() {
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap;
            synchronized (this) {
                hashMap = this.mModified;
            }
            return hashMap;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putBoolean(java.lang.String str, boolean z) {
            synchronized (this) {
                this.mModified.put(str, java.lang.Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putFloat(java.lang.String str, float f) {
            synchronized (this) {
                this.mModified.put(str, java.lang.Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putInt(java.lang.String str, int i) {
            synchronized (this) {
                this.mModified.put(str, java.lang.Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putLong(java.lang.String str, long j) {
            synchronized (this) {
                this.mModified.put(str, java.lang.Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putString(java.lang.String str, java.lang.String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor putStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
            throw new java.lang.RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final android.content.SharedPreferences.Editor remove(java.lang.String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }
    }

    public final class FileMonitor extends android.os.FileObserver {
        public FileMonitor(java.lang.String str, int i) {
            super(str, i);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, java.lang.String str) {
            if (com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    public interface OnSharedPreferenceErrorListener {
        void onError(java.lang.String str, int i, long j);
    }

    public static abstract class RunnableEx implements java.lang.Runnable {
        private java.lang.Object mArg;

        public java.lang.Object getArg() {
            return this.mArg;
        }

        public void setArg(java.lang.Object obj) {
            this.mArg = obj;
        }
    }

    public class SUPPORTED_TYPE {
        static final byte TYPE_BOOLEAN = 4;
        static final byte TYPE_FLOAT = 2;
        static final byte TYPE_INT = 1;
        static final byte TYPE_LONG = 3;
        static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    static {
        for (int i = 0; i < 3; i++) {
            mHandlerThreadPool[i] = new android.os.HandlerThread("newsp".concat(java.lang.String.valueOf(i)));
            mHandlerThreadPool[i].start();
        }
        sCachedThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
    }

    public SharedPreferencesNewImpl(java.io.File file) {
        this(file, 0, null, false);
    }

    public SharedPreferencesNewImpl(java.io.File file, int i, com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(java.io.File file, int i, com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z) {
        this.mMap = new java.util.LinkedHashMap<>();
        this.mListeners = new java.util.ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new java.lang.Object();
        this.mSyncSaveObj = new java.lang.Object();
        this.mEditorList = new java.util.Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass2();
        this.mSaveRunnable = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass4();
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new android.os.Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z);
        }
        this.mHandler.post(new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass1());
    }

    public SharedPreferencesNewImpl(java.io.File file, com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(java.io.File file, boolean z) {
        this(file, 0, null, z);
    }

    private java.nio.MappedByteBuffer allocBuffer(int i) {
        java.nio.MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        int position = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(java.nio.channels.FileChannel.MapMode.READ_WRITE, 0L, i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        java.nio.MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(position);
        }
        return this.mMappedByteBuffer;
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    try {
                        wait();
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        tryReload();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void backup() {
        java.lang.Throwable th;
        java.io.Closeable closeable;
        java.nio.channels.FileChannel fileChannel = null;
        try {
            java.io.File file = new java.io.File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                fileChannel = fileOutputStream.getChannel();
                this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), fileChannel);
                safeClose(fileOutputStream);
                safeClose(fileChannel);
            } catch (java.lang.Throwable th2) {
                closeable = fileChannel;
                fileChannel = fileOutputStream;
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    safeClose(fileChannel);
                    safeClose(closeable);
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private byte getBCCCode(byte[] bArr) {
        byte b = 0;
        for (byte b2 : bArr) {
            b = (byte) (b ^ b2);
        }
        return b;
    }

    private byte[] getBytes(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof java.lang.String) {
                return ((java.lang.String) obj).getBytes();
            }
            if (obj instanceof java.lang.Boolean) {
                int i = 1;
                byte[] bArr = new byte[1];
                if (!((java.lang.Boolean) obj).booleanValue()) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                return bArr;
            }
            if (obj instanceof java.lang.Float) {
                return com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteFloatUtils.floatToBytes(((java.lang.Float) obj).floatValue());
            }
            if (obj instanceof java.lang.Integer) {
                return com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(((java.lang.Integer) obj).intValue());
            }
            if (obj instanceof java.lang.Long) {
                return com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteLongUtils.longToBytes(((java.lang.Long) obj).longValue());
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int getContentLength() {
        if (this.mMappedByteBuffer == null || this.mFileChannel == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int bytesToInt = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(4);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && bytesToInt >= 0) {
                if (bytesToInt > Integer.MAX_VALUE) {
                    bytesToInt = Integer.MAX_VALUE;
                }
                return bytesToInt;
            }
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
            if (onSharedPreferenceErrorListener != null) {
                java.io.File file = this.mFile;
                java.lang.String absolutePath = file != null ? file.getAbsolutePath() : null;
                java.io.File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 1, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    private android.util.Pair<java.lang.Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        java.util.ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5][];
            arrayList = new java.util.ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i = 0;
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            java.util.Map.Entry entry = (java.util.Map.Entry) arrayList.get(size);
            java.lang.String str = (java.lang.String) entry.getKey();
            java.lang.Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] intToBytes = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(bytes.length);
                bArr[i2] = intToBytes;
                bArr[i2 + 1] = bytes;
                int length = i + intToBytes.length + bytes.length;
                byte[] bytes2 = getBytes(value);
                byte[] intToBytes2 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(bytes2.length);
                bArr[i2 + 2] = intToBytes2;
                bArr[i2 + 3] = bytes2;
                int length2 = length + intToBytes2.length + bytes2.length;
                bArr[i2 + 4] = new byte[]{(byte) getObjectType(value)};
                i = length2 + 1;
                i2 += 5;
            }
        }
        return new android.util.Pair<>(java.lang.Integer.valueOf(i), bArr);
    }

    private android.os.HandlerThread getHandlerThread() {
        int nextInt = new java.util.Random().nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        return mHandlerThreadPool[nextInt % 3];
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    private java.lang.Object getObjectByType(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i == 5) {
                return new java.lang.String(bArr);
            }
            boolean z = true;
            if (i == 4) {
                if (bArr[0] != 1) {
                    z = false;
                }
                return java.lang.Boolean.valueOf(z);
            }
            if (i == 2) {
                return java.lang.Float.valueOf(com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteFloatUtils.bytesToFloat(bArr));
            }
            if (i == 1) {
                return java.lang.Integer.valueOf(com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(bArr));
            }
            if (i == 3) {
                return java.lang.Long.valueOf(com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteLongUtils.bytesToLong(bArr));
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int getObjectType(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return 5;
        }
        if (obj instanceof java.lang.Boolean) {
            return 4;
        }
        if (obj instanceof java.lang.Float) {
            return 2;
        }
        if (obj instanceof java.lang.Integer) {
            return 1;
        }
        return obj instanceof java.lang.Long ? 3 : 0;
    }

    private android.util.Pair<byte[], java.lang.Integer> getOneString(byte[] bArr, int i) {
        int i2;
        byte[] bArr2;
        byte[] bArr3 = new byte[4];
        java.lang.System.arraycopy(bArr, i, bArr3, 0, 4);
        int i3 = i + 4;
        byte b = bArr[i3];
        if (b != 18 && b != getMaskByte(bArr3)) {
            throw new java.lang.Exception("length string's finish mark missing");
        }
        int i4 = i3 + 1;
        int bytesToInt = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(bArr3);
        if (bytesToInt < 0 || (i2 = i4 + bytesToInt) >= bArr.length || bytesToInt > Integer.MAX_VALUE) {
            throw new java.lang.Exception("length string is invalid");
        }
        if (bytesToInt != 0) {
            bArr2 = new byte[bytesToInt];
            java.lang.System.arraycopy(bArr, i4, bArr2, 0, bytesToInt);
            byte b2 = bArr[i2];
            if (b2 != 18 && b2 != getMaskByte(bArr2)) {
                throw new java.lang.Exception("Stored bytes' finish mark missing");
            }
            i4 = i2;
        } else {
            bArr2 = null;
        }
        return new android.util.Pair<>(bArr2, java.lang.Integer.valueOf(i4 + 1));
    }

    private int increaseModifyID() {
        int i = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i;
        return i;
    }

    private boolean initBuffer() {
        boolean z = true;
        if (this.mMappedByteBuffer != null) {
            return true;
        }
        try {
            if (!this.mFile.exists()) {
                this.mFile.getParentFile().mkdirs();
                this.mFile.createNewFile();
                z = new java.io.File(this.mBackupFilePath).exists();
            } else if (this.mFile.length() == 0) {
                com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                }
                z = false;
            }
            this.mFileChannel = new java.io.RandomAccessFile(this.mFile, "rw").getChannel();
            allocBuffer(10);
            if (z) {
                return z;
            }
            initFileHeader();
            return z;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
            if (onSharedPreferenceErrorListener2 != null) {
                onSharedPreferenceErrorListener2.onError(this.mFile.getAbsolutePath() + " " + e.getCause(), 10, -1L);
            }
            return false;
        }
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] intToBytes = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(0);
            java.lang.System.arraycopy(intToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(intToBytes);
            byte[] intToBytes2 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(0);
            java.lang.System.arraycopy(intToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(intToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void load(boolean z) {
        byte[] bArr = null;
        java.nio.channels.FileLock lockFile = z ? null : lockFile(true);
        if (lockFile == null && !z) {
            if (z) {
                return;
            }
            loadFromBakFile();
            return;
        }
        boolean z2 = false;
        try {
            try {
                try {
                    reallocBuffer();
                    java.nio.MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
                    if (mappedByteBuffer != null && mappedByteBuffer.capacity() != 0) {
                        long contentLength = getContentLength();
                        if (contentLength <= 10) {
                            try {
                                z2 = parseBytesIntoMap(null, true);
                            } catch (java.lang.Exception e) {
                                e.printStackTrace();
                            }
                            if (!z2 || this.mModifyID < 0) {
                                loadFromBakFile();
                            }
                            if (lockFile != null) {
                                try {
                                    lockFile.release();
                                    return;
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        }
                        int modifyID = getModifyID();
                        this.mModifyID = modifyID;
                        if (modifyID > 0) {
                            synchronized (this.mSyncObj) {
                                this.mMappedByteBuffer.position(10);
                                bArr = new byte[((int) contentLength) - 10];
                                safeBufferGet(this.mMappedByteBuffer, bArr);
                            }
                        }
                        try {
                            z2 = parseBytesIntoMap(bArr, true);
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                        if (!z2 || (bArr == null && this.mModifyID < 0)) {
                            loadFromBakFile();
                        }
                        if (lockFile != null) {
                            try {
                                lockFile.release();
                                return;
                            } catch (java.lang.Exception e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        z2 = parseBytesIntoMap(null, true);
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                    if (!z2 || this.mModifyID < 0) {
                        loadFromBakFile();
                    }
                    if (lockFile != null) {
                        try {
                            lockFile.release();
                        } catch (java.lang.Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (java.lang.Exception e7) {
                    e7.printStackTrace();
                    if (z2 || (bArr == null && this.mModifyID < 0)) {
                        loadFromBakFile();
                    }
                    if (lockFile == null) {
                        try {
                            lockFile.release();
                        } catch (java.lang.Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
                try {
                    z2 = parseBytesIntoMap(bArr, true);
                } catch (java.lang.Exception e9) {
                    e9.printStackTrace();
                }
                if (z2 || (bArr == null && this.mModifyID < 0)) {
                    loadFromBakFile();
                }
                if (lockFile == null) {
                    try {
                        lockFile.release();
                    } catch (java.lang.Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
        } catch (java.lang.OutOfMemoryError unused2) {
            this.mFile.delete();
            new java.io.File(this.mBackupFilePath).delete();
            z2 = parseBytesIntoMap(bArr, true);
            if (z2) {
            }
            loadFromBakFile();
            if (lockFile == null) {
            }
        } catch (java.lang.Throwable unused3) {
            z2 = parseBytesIntoMap(bArr, true);
            if (z2) {
            }
            loadFromBakFile();
            if (lockFile == null) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v9 */
    private boolean loadFromBakFile() {
        byte[] bArr;
        java.io.RandomAccessFile randomAccessFile;
        int bytesToInt;
        int i = 0;
        boolean z = true;
        java.io.RandomAccessFile randomAccessFile2 = null;
        byte[] bArr2 = null;
        try {
            randomAccessFile = new java.io.RandomAccessFile(this.mBackupFilePath, "r");
        } catch (java.lang.Throwable th) {
            th = th;
            bArr = null;
        }
        try {
            byte[] bArr3 = new byte[4];
            randomAccessFile.read(bArr3, 0, 4);
            bytesToInt = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(bArr3);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bArr = bArr2;
            randomAccessFile2 = randomAccessFile;
            try {
                th.printStackTrace();
                safeClose(randomAccessFile2);
                try {
                    z = parseBytesIntoMap(bArr, false);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mBackupFilePath + "#" + th.getCause() + "#" + z, 12, bArr != null ? bArr.length : 0);
                }
                return z;
            } finally {
            }
        }
        if (bytesToInt <= 10) {
            safeClose(randomAccessFile);
            try {
                parseBytesIntoMap(null, false);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (bytesToInt > Integer.MAX_VALUE) {
            bytesToInt = Integer.MAX_VALUE;
        }
        if (bytesToInt > randomAccessFile.length()) {
            bytesToInt = (int) randomAccessFile.length();
        }
        int i2 = bytesToInt - 10;
        bArr2 = new byte[i2];
        randomAccessFile.seek(10L);
        randomAccessFile.read(bArr2);
        safeClose(randomAccessFile);
        try {
            z = parseBytesIntoMap(bArr2, false);
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
        if (onSharedPreferenceErrorListener2 != null) {
            onSharedPreferenceErrorListener2.onError(this.mBackupFilePath + "#" + ((java.lang.Object) "") + "#" + z, 12, i2);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private java.nio.channels.FileLock lockFile(boolean z) {
        java.nio.channels.FileChannel fileChannel = this.mFileChannel;
        java.nio.channels.FileLock fileLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (!z) {
            try {
                return fileChannel.tryLock();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        while (fileLock == null) {
            try {
                fileLock = this.mFileChannel.tryLock();
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
            if (fileLock == null) {
                try {
                    java.lang.Thread.sleep(100L);
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (android.os.SystemClock.uptimeMillis() - uptimeMillis > 10000) {
                return fileLock;
            }
        }
        return fileLock;
    }

    private boolean merge(android.content.SharedPreferences.Editor editor, java.util.Map map, boolean z) {
        if (editor == null) {
            return false;
        }
        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.EditorImpl editorImpl = (com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.EditorImpl) editor;
        boolean doClear = editorImpl.doClear();
        if (doClear) {
            map.clear();
            this.mEditorList.clear();
        }
        java.util.HashMap<java.lang.String, java.lang.Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return doClear;
        }
        synchronized (editor) {
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : all.entrySet()) {
                java.lang.String key = entry.getKey();
                java.lang.Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                java.util.Iterator<android.content.SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    private void notifyDataChanged(java.lang.String str) {
        if (this.mListeners.size() > 0) {
            for (int i = 0; i < this.mListeners.size(); i++) {
                android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] obtainTotalBytes() {
        android.util.Pair<java.lang.Integer, byte[][]> dataBytes = getDataBytes();
        int intValue = ((java.lang.Integer) dataBytes.first).intValue() + 10 + (((byte[][]) dataBytes.second).length * 1);
        if (intValue > Integer.MAX_VALUE) {
            intValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[intValue];
        byte[] intToBytes = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(intValue);
        java.lang.System.arraycopy(intToBytes, 0, bArr, 0, intToBytes.length);
        int length = intToBytes.length + 0;
        bArr[length] = getMaskByte(intToBytes);
        int i = length + 1;
        byte[] intToBytes2 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.intToBytes(increaseModifyID());
        java.lang.System.arraycopy(intToBytes2, 0, bArr, i, intToBytes2.length);
        int length2 = i + intToBytes2.length;
        bArr[length2] = getMaskByte(intToBytes2);
        int i2 = length2 + 1;
        byte[][] bArr2 = (byte[][]) dataBytes.second;
        int length3 = bArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i3];
            if (bArr3 != null) {
                if (bArr3.length + i2 + 1 <= Integer.MAX_VALUE) {
                    java.lang.System.arraycopy(bArr3, 0, bArr, i2, bArr3.length);
                    int length4 = i2 + bArr3.length;
                    bArr[length4] = getMaskByte(bArr3);
                    i2 = length4 + 1;
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("Write too much data in ");
                    java.io.File file = this.mFile;
                    sb.append(file != null ? file.getAbsolutePath() : null);
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(file2 != null ? file2.getAbsolutePath() : null, 7, -1L);
                    }
                }
            }
            i3++;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        r3 = r12.mErrorListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r3 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r5 = r12.mFile;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r5 = r5.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
    
        r3.onError(r5, 8, r13.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parseBytesIntoMap(byte[] bArr, boolean z) {
        java.util.LinkedHashMap linkedHashMap;
        synchronized (this.mMap) {
            if (z) {
                try {
                    linkedHashMap = new java.util.LinkedHashMap(this.mMap);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(e.getCause());
                        onSharedPreferenceErrorListener.onError(sb.toString(), 3, bArr.length);
                    }
                } finally {
                }
            } else {
                linkedHashMap = null;
            }
            if (z && this.mModifyID > 0) {
                this.mMap.clear();
            }
            if (bArr != null && bArr.length != 0) {
                boolean z2 = false;
                int i = 0;
                boolean z3 = true;
                while (true) {
                    if (i >= bArr.length) {
                        z2 = z3;
                        break;
                    }
                    android.util.Pair<byte[], java.lang.Integer> oneString = getOneString(bArr, i);
                    android.util.Pair<byte[], java.lang.Integer> oneString2 = getOneString(bArr, ((java.lang.Integer) oneString.second).intValue());
                    int intValue = ((java.lang.Integer) oneString2.second).intValue();
                    byte b = bArr[intValue];
                    int i2 = intValue + 1;
                    byte b2 = bArr[i2];
                    int i3 = i2 + 1;
                    if (b2 != 18 && b2 != getMaskByte(new byte[]{b})) {
                        break;
                    }
                    if (checkTypeValid(b)) {
                        java.lang.Object objectByType = getObjectByType((byte[]) oneString2.first, b);
                        java.lang.Object obj = oneString.first;
                        if (obj != null && ((byte[]) obj).length > 0 && objectByType != null) {
                            java.lang.String str = new java.lang.String((byte[]) obj);
                            if (z || !this.mMap.containsKey(str)) {
                                this.mMap.put(str, objectByType);
                            }
                        }
                        i = i3;
                    } else {
                        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
                        if (onSharedPreferenceErrorListener2 != null) {
                            java.io.File file2 = this.mFile;
                            onSharedPreferenceErrorListener2.onError(file2 != null ? file2.getAbsolutePath() : null, 9, bArr.length);
                        }
                        i = i3;
                        z3 = false;
                    }
                }
                if (!z2 && z) {
                    this.mMap.putAll(linkedHashMap);
                }
                return z2;
            }
            return true;
        }
    }

    private void reallocBuffer() {
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                int contentLength = getContentLength();
                if (contentLength > this.mMappedByteBuffer.capacity()) {
                    allocBuffer(contentLength + 1024);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean safeBufferGet(java.nio.MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        java.util.Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void safeBufferPut(java.nio.MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void safeClose(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(android.content.SharedPreferences.Editor editor, boolean z, boolean z2, boolean z3) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z4 = false;
            this.mCurTryTime = 0;
            if (merge(editor, this.mMap, false)) {
                z4 = true;
            } else if (this.mEditorList.size() == 0) {
                return;
            }
            if (z4) {
                this.mEditorList.add(editor);
            }
            if (z2) {
                saveInner(z);
                return;
            }
            long j = z3 ? 1000L : 0L;
            this.mSaveRunnable.setArg(java.lang.Boolean.valueOf(z));
            android.os.Message obtain = android.os.Message.obtain(this.mHandler, this.mSaveRunnable);
            obtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(obtain, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(boolean z) {
        synchronized (this.mSyncSaveObj) {
            java.nio.channels.FileLock lockFile = lockFile(false);
            if (lockFile != null) {
                try {
                    this.mIsSaving = true;
                    if (tryReloadWhenSave()) {
                        mergeWhenReload();
                        notifyDataChanged(null);
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        th.printStackTrace();
                        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        if (onSharedPreferenceErrorListener != null) {
                            onSharedPreferenceErrorListener.onError(th.getMessage(), 11, -1L);
                        }
                        try {
                            lockFile.release();
                        } catch (java.io.IOException e) {
                            e.printStackTrace();
                        }
                    } finally {
                        try {
                            lockFile.release();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                        this.mIsSaving = false;
                    }
                }
                synchronized (this.mMap) {
                    if (this.mEditorList.size() <= 0) {
                        return;
                    }
                    saveToMappedBuffer(obtainTotalBytes(), z);
                    backup();
                    try {
                        lockFile.release();
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                    this.mIsSaving = false;
                }
            }
            int i = this.mCurTryTime;
            this.mCurTryTime = i + 1;
            if (i < 6) {
                this.mHandler.postDelayed(new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass3(z), 2000L);
            }
        }
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private void startLoadFromDisk(boolean z) {
        synchronized (this) {
            this.mLoaded = false;
        }
        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass5 anonymousClass5 = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.AnonymousClass5();
        if (z) {
            anonymousClass5.run();
        } else {
            sCachedThreadPool.execute(anonymousClass5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (android.os.SystemClock.uptimeMillis() - this.mTryReloadStartTime > 60) {
            this.mTryReloadStartTime = android.os.SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    public final boolean checkTypeValid(byte b) {
        return b == 4 || b == 2 || b == 1 || b == 3 || b == 5;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(java.lang.String str) {
        boolean containsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public final android.content.SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final java.util.Map<java.lang.String, ?> getAll() {
        java.util.HashMap hashMap;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            hashMap = new java.util.HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(java.lang.String str, boolean z) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    java.lang.Boolean bool = (java.lang.Boolean) this.mMap.get(str);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                } catch (java.lang.ClassCastException e) {
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        java.lang.String sb2 = sb.toString();
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return z;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(java.lang.String str, float f) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    java.lang.Float f2 = (java.lang.Float) this.mMap.get(str);
                    if (f2 != null) {
                        f = f2.floatValue();
                    }
                } catch (java.lang.ClassCastException e) {
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        java.lang.String sb2 = sb.toString();
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return f;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(java.lang.String str, int i) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    java.lang.Integer num = (java.lang.Integer) this.mMap.get(str);
                    if (num != null) {
                        i = num.intValue();
                    }
                } catch (java.lang.ClassCastException e) {
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        java.lang.String sb2 = sb.toString();
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return i;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(java.lang.String str, long j) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    java.lang.Long l = (java.lang.Long) this.mMap.get(str);
                    if (l != null) {
                        j = l.longValue();
                    }
                } catch (java.lang.ClassCastException e) {
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        java.lang.String sb2 = sb.toString();
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return j;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public final int getModifyID() {
        com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        if (this.mMappedByteBuffer == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(5);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int bytesToInt = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(9);
            byte b = this.mMappedByteBuffer.get();
            if ((b == 18 || b == getMaskByte(bArr)) && bytesToInt >= 0) {
                return bytesToInt;
            }
            int i = this.mModifyErrorCnt + 1;
            this.mModifyErrorCnt = i;
            if (i < 3 && (onSharedPreferenceErrorListener = this.mErrorListener) != null) {
                java.io.File file = this.mFile;
                java.lang.String absolutePath = file != null ? file.getAbsolutePath() : null;
                java.io.File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 2, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    @Override // android.content.SharedPreferences
    public final java.lang.String getString(java.lang.String str, java.lang.String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    java.lang.String str3 = (java.lang.String) this.mMap.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (java.lang.ClassCastException e) {
                    com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        java.io.File file = this.mFile;
                        sb.append(file != null ? file.getAbsolutePath() : null);
                        sb.append("#");
                        sb.append(str);
                        sb.append(e);
                        java.lang.String sb2 = sb.toString();
                        java.io.File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(sb2, 13, file2 != null ? file2.length() : 0L);
                    }
                    return str2;
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final java.util.Set<java.lang.String> getStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
        throw new java.lang.RuntimeException("putStringSet is not supported!");
    }

    public final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        java.io.File file = new java.io.File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    this.mFileMonitor = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    public final void setSharedPreferenceErrorListener(com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }
}
