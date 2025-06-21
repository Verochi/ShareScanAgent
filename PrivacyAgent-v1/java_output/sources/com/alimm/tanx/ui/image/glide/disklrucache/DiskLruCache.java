package com.alimm.tanx.ui.image.glide.disklrucache;

/* loaded from: classes.dex */
public final class DiskLruCache implements java.io.Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final java.lang.String CLEAN = "CLEAN";
    private static final java.lang.String DIRTY = "DIRTY";
    static final java.lang.String JOURNAL_FILE = "journal";
    static final java.lang.String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final java.lang.String JOURNAL_FILE_TEMP = "journal.tmp";
    static final java.lang.String MAGIC = "libcore.io.DiskLruCache";
    private static final java.lang.String READ = "READ";
    private static final java.lang.String REMOVE = "REMOVE";
    static final java.lang.String VERSION_1 = "1";
    private final int appVersion;
    private final java.io.File directory;
    private final java.io.File journalFile;
    private final java.io.File journalFileBackup;
    private final java.io.File journalFileTmp;
    private java.io.Writer journalWriter;
    private long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final java.util.LinkedHashMap<java.lang.String, com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry> lruEntries = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    final java.util.concurrent.ThreadPoolExecutor executorService = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.DiskLruCacheThreadFactory(null));
    private final java.util.concurrent.Callable<java.lang.Void> cleanupCallable = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.AnonymousClass1();

    /* renamed from: com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Void> {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() throws java.lang.Exception {
            synchronized (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this) {
                if (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.trimToSize();
                if (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.journalRebuildRequired()) {
                    com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.rebuildJournal();
                    com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    }

    public static final class DiskLruCacheThreadFactory implements java.util.concurrent.ThreadFactory {
        private DiskLruCacheThreadFactory() {
        }

        public /* synthetic */ DiskLruCacheThreadFactory(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.AnonymousClass1 anonymousClass1) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread;
            thread = new java.lang.Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class Editor {
        private boolean committed;
        private final com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry;
        private final boolean[] written;

        private Editor(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount];
        }

        public /* synthetic */ Editor(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache, com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry, com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        private java.io.InputStream newInputStream(int i) throws java.io.IOException {
            synchronized (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                try {
                    return new java.io.FileInputStream(this.entry.getCleanFile(i));
                } catch (java.io.FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public void abort() throws java.io.IOException {
            com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.completeEdit(this, false);
        }

        public void abortUnlessCommitted() {
            if (this.committed) {
                return;
            }
            try {
                abort();
            } catch (java.io.IOException unused) {
            }
        }

        public void commit() throws java.io.IOException {
            com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.completeEdit(this, true);
            this.committed = true;
        }

        public java.io.File getFile(int i) throws java.io.IOException {
            java.io.File dirtyFile;
            synchronized (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                dirtyFile = this.entry.getDirtyFile(i);
                com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.directory.mkdirs();
            }
            return dirtyFile;
        }

        public java.lang.String getString(int i) throws java.io.IOException {
            java.io.InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public void set(int i, java.lang.String str) throws java.io.IOException {
            java.lang.Throwable th;
            java.io.OutputStreamWriter outputStreamWriter;
            try {
                outputStreamWriter = new java.io.OutputStreamWriter(new java.io.FileOutputStream(getFile(i)), com.alimm.tanx.ui.image.glide.disklrucache.Util.UTF_8);
                try {
                    outputStreamWriter.write(str);
                    com.alimm.tanx.ui.image.glide.disklrucache.Util.closeQuietly(outputStreamWriter);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.alimm.tanx.ui.image.glide.disklrucache.Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                outputStreamWriter = null;
            }
        }
    }

    public final class Entry {
        java.io.File[] cleanFiles;
        private com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor currentEditor;
        java.io.File[] dirtyFiles;
        private final java.lang.String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(java.lang.String str) {
            this.key = str;
            this.lengths = new long[com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount];
            this.cleanFiles = new java.io.File[com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount];
            this.dirtyFiles = new java.io.File[com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount; i++) {
                sb.append(i);
                this.cleanFiles[i] = new java.io.File(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.directory, sb.toString());
                sb.append(com.baidu.mobads.sdk.internal.al.k);
                this.dirtyFiles[i] = new java.io.File(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        public /* synthetic */ Entry(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache, java.lang.String str, com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private java.io.IOException invalidLengths(java.lang.String[] strArr) throws java.io.IOException {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("unexpected journal line: ");
            tanxu_do2.append(java.util.Arrays.toString(strArr));
            throw new java.io.IOException(tanxu_do2.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.valueCount) {
                invalidLengths(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    invalidLengths(strArr);
                    throw null;
                }
            }
        }

        public java.io.File getCleanFile(int i) {
            return this.cleanFiles[i];
        }

        public java.io.File getDirtyFile(int i) {
            return this.dirtyFiles[i];
        }

        public java.lang.String getLengths() throws java.io.IOException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.lengths) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }
    }

    public final class Value {
        private final java.io.File[] files;
        private final java.lang.String key;
        private final long[] lengths;
        private final long sequenceNumber;

        private Value(java.lang.String str, long j, java.io.File[] fileArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.lengths = jArr;
        }

        public /* synthetic */ Value(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache, java.lang.String str, long j, java.io.File[] fileArr, long[] jArr, com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(str, j, fileArr, jArr);
        }

        public com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor edit() throws java.io.IOException {
            return com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public java.io.File getFile(int i) {
            return this.files[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public java.lang.String getString(int i) throws java.io.IOException {
            return com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.inputStreamToString(new java.io.FileInputStream(this.files[i]));
        }
    }

    private DiskLruCache(java.io.File file, int i, int i2, long j) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new java.io.File(file, JOURNAL_FILE);
        this.journalFileTmp = new java.io.File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new java.io.File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    @android.annotation.TargetApi(26)
    private static void closeWriter(java.io.Writer writer) throws java.io.IOException {
        android.os.StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = android.os.StrictMode.getThreadPolicy();
        permitUnbufferedIo = new android.os.StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        android.os.StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            android.os.StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor editor, boolean z) throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!editor.written[i]) {
                    editor.abort();
                    throw new java.lang.IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!entry.getDirtyFile(i).exists()) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            java.io.File dirtyFile = entry.getDirtyFile(i2);
            if (!z) {
                deleteIfExists(dirtyFile);
            } else if (dirtyFile.exists()) {
                java.io.File cleanFile = entry.getCleanFile(i2);
                dirtyFile.renameTo(cleanFile);
                long j = entry.lengths[i2];
                long length = cleanFile.length();
                entry.lengths[i2] = length;
                this.size = (this.size - j) + length;
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable || z) {
            entry.readable = true;
            this.journalWriter.append((java.lang.CharSequence) CLEAN);
            this.journalWriter.append(' ');
            this.journalWriter.append((java.lang.CharSequence) entry.key);
            this.journalWriter.append((java.lang.CharSequence) entry.getLengths());
            this.journalWriter.append('\n');
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.append((java.lang.CharSequence) REMOVE);
            this.journalWriter.append(' ');
            this.journalWriter.append((java.lang.CharSequence) entry.key);
            this.journalWriter.append('\n');
        }
        flushWriter(this.journalWriter);
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
    }

    private static void deleteIfExists(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor edit(java.lang.String str, long j) throws java.io.IOException {
        checkNotClosed();
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if (entry == null) {
            entry = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry(this, str, null);
            this.lruEntries.put(str, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor editor = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor(this, entry, null);
        entry.currentEditor = editor;
        this.journalWriter.append((java.lang.CharSequence) DIRTY);
        this.journalWriter.append(' ');
        this.journalWriter.append((java.lang.CharSequence) str);
        this.journalWriter.append('\n');
        flushWriter(this.journalWriter);
        return editor;
    }

    @android.annotation.TargetApi(26)
    private static void flushWriter(java.io.Writer writer) throws java.io.IOException {
        android.os.StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = android.os.StrictMode.getThreadPolicy();
        permitUnbufferedIo = new android.os.StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        android.os.StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            android.os.StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String inputStreamToString(java.io.InputStream inputStream) throws java.io.IOException {
        return com.alimm.tanx.ui.image.glide.disklrucache.Util.readFully(new java.io.InputStreamReader(inputStream, com.alimm.tanx.ui.image.glide.disklrucache.Util.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public static com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache open(java.io.File file, int i, int i2, long j) throws java.io.IOException {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("valueCount <= 0");
        }
        java.io.File file2 = new java.io.File(file, JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            java.io.File file3 = new java.io.File(file, JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else {
                renameTo(file2, file3, false);
            }
        }
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache(file, i, i2, j);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                return diskLruCache;
            } catch (java.io.IOException e) {
                java.lang.System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache diskLruCache2 = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache(file, i, i2, j);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }

    private void processJournal() throws java.io.IOException {
        deleteIfExists(this.journalFileTmp);
        java.util.Iterator<com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    deleteIfExists(next.getCleanFile(i));
                    deleteIfExists(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() throws java.io.IOException {
        com.alimm.tanx.ui.image.glide.disklrucache.StrictLineReader strictLineReader = new com.alimm.tanx.ui.image.glide.disklrucache.StrictLineReader(new java.io.FileInputStream(this.journalFile), 8192, com.alimm.tanx.ui.image.glide.disklrucache.Util.US_ASCII);
        try {
            java.lang.String readLine = strictLineReader.readLine();
            java.lang.String readLine2 = strictLineReader.readLine();
            java.lang.String readLine3 = strictLineReader.readLine();
            java.lang.String readLine4 = strictLineReader.readLine();
            java.lang.String readLine5 = strictLineReader.readLine();
            if (!MAGIC.equals(readLine) || !"1".equals(readLine2) || !java.lang.Integer.toString(this.appVersion).equals(readLine3) || !java.lang.Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(readLine);
                sb.append(", ");
                sb.append(readLine2);
                sb.append(", ");
                sb.append(readLine4);
                sb.append(", ");
                sb.append(readLine5);
                sb.append("]");
                throw new java.io.IOException(sb.toString());
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (strictLineReader.hasUnterminatedLine()) {
                        rebuildJournal();
                    } else {
                        this.journalWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.journalFile, true), com.alimm.tanx.ui.image.glide.disklrucache.Util.US_ASCII));
                    }
                    com.alimm.tanx.ui.image.glide.disklrucache.Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.alimm.tanx.ui.image.glide.disklrucache.Util.closeQuietly(strictLineReader);
            throw th;
        }
    }

    private void readJournalLine(java.lang.String str) throws java.io.IOException {
        java.lang.String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry(this, substring, null);
            this.lruEntries.put(substring, entry);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
            java.lang.String[] split = str.substring(indexOf2 + 1).split(" ");
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor(this, entry, null);
            return;
        }
        if (indexOf2 == -1 && indexOf == 4 && str.startsWith(READ)) {
            return;
        }
        throw new java.io.IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() throws java.io.IOException {
        java.io.Writer writer = this.journalWriter;
        if (writer != null) {
            closeWriter(writer);
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.journalFileTmp), com.alimm.tanx.ui.image.glide.disklrucache.Util.US_ASCII));
        try {
            bufferedWriter.write(MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.appVersion));
            bufferedWriter.write("\n");
            bufferedWriter.write(java.lang.Integer.toString(this.valueCount));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("DIRTY ");
                    sb.append(entry.key);
                    sb.append('\n');
                    bufferedWriter.write(sb.toString());
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(entry.key);
                    sb2.append(entry.getLengths());
                    sb2.append('\n');
                    bufferedWriter.write(sb2.toString());
                }
            }
            closeWriter(bufferedWriter);
            if (this.journalFile.exists()) {
                renameTo(this.journalFile, this.journalFileBackup, true);
            }
            renameTo(this.journalFileTmp, this.journalFile, false);
            this.journalFileBackup.delete();
            this.journalWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.journalFile, true), com.alimm.tanx.ui.image.glide.disklrucache.Util.US_ASCII));
        } catch (java.lang.Throwable th) {
            closeWriter(bufferedWriter);
            throw th;
        }
    }

    private static void renameTo(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (z) {
            deleteIfExists(file2);
        }
        if (!file.renameTo(file2)) {
            throw new java.io.IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws java.io.IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.journalWriter == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.lruEntries.values()).iterator();
        while (it.hasNext()) {
            com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = (com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry) it.next();
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        closeWriter(this.journalWriter);
        this.journalWriter = null;
    }

    public void delete() throws java.io.IOException {
        close();
        com.alimm.tanx.ui.image.glide.disklrucache.Util.deleteContents(this.directory);
    }

    public com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Editor edit(java.lang.String str) throws java.io.IOException {
        return edit(str, -1L);
    }

    public synchronized void flush() throws java.io.IOException {
        checkNotClosed();
        trimToSize();
        flushWriter(this.journalWriter);
    }

    public synchronized com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Value get(java.lang.String str) throws java.io.IOException {
        checkNotClosed();
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        for (java.io.File file : entry.cleanFiles) {
            if (!file.exists()) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((java.lang.CharSequence) READ);
        this.journalWriter.append(' ');
        this.journalWriter.append((java.lang.CharSequence) str);
        this.journalWriter.append('\n');
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Value(this, str, entry.sequenceNumber, entry.cleanFiles, entry.lengths, null);
    }

    public java.io.File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.journalWriter == null;
    }

    public synchronized boolean remove(java.lang.String str) throws java.io.IOException {
        checkNotClosed();
        com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i = 0; i < this.valueCount; i++) {
                java.io.File cleanFile = entry.getCleanFile(i);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new java.io.IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i];
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((java.lang.CharSequence) REMOVE);
            this.journalWriter.append(' ');
            this.journalWriter.append((java.lang.CharSequence) str);
            this.journalWriter.append('\n');
            this.lruEntries.remove(str);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
        return false;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        this.executorService.submit(this.cleanupCallable);
    }

    public synchronized long size() {
        return this.size;
    }
}
