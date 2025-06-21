package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
final class DiskLruCache implements java.io.Closeable {
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final java.lang.String CLEAN = "CLEAN";
    private static final java.lang.String DIRTY = "DIRTY";
    static final java.lang.String JOURNAL_FILE = "journal";
    static final java.lang.String JOURNAL_FILE_TMP = "journal.tmp";
    static final java.lang.String MAGIC = "libcore.io.DiskLruCache";
    private static final java.lang.String READ = "READ";
    private static final java.lang.String REMOVE = "REMOVE";
    static final java.lang.String VERSION_1 = "1";
    private final int appVersion;
    private final java.io.File directory;
    private final java.io.File journalFile;
    private final java.io.File journalFileTmp;
    private java.io.Writer journalWriter;
    private final long maxSize;
    private int redundantOpCount;
    private final int valueCount;
    private long size = 0;
    private final java.util.LinkedHashMap<java.lang.String, com.sensorsdata.sf.ui.utils.DiskLruCache.Entry> lruEntries = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final java.util.concurrent.ExecutorService executorService = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.concurrent.Callable<java.lang.Void> cleanupCallable = new com.sensorsdata.sf.ui.utils.DiskLruCache.AnonymousClass1();

    /* renamed from: com.sensorsdata.sf.ui.utils.DiskLruCache$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Void> {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() throws java.lang.Exception {
            synchronized (com.sensorsdata.sf.ui.utils.DiskLruCache.this) {
                if (com.sensorsdata.sf.ui.utils.DiskLruCache.this.journalWriter == null) {
                    return null;
                }
                com.sensorsdata.sf.ui.utils.DiskLruCache.this.trimToSize();
                if (com.sensorsdata.sf.ui.utils.DiskLruCache.this.journalRebuildRequired()) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.this.rebuildJournal();
                    com.sensorsdata.sf.ui.utils.DiskLruCache.this.redundantOpCount = 0;
                }
                return null;
            }
        }
    }

    public final class Editor {
        private final com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry;
        private boolean hasErrors;
        private final boolean[] written;

        public class FaultHidingOutputStream extends java.io.FilterOutputStream {
            private FaultHidingOutputStream(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            public /* synthetic */ FaultHidingOutputStream(com.sensorsdata.sf.ui.utils.DiskLruCache.Editor editor, java.io.OutputStream outputStream, com.sensorsdata.sf.ui.utils.DiskLruCache.AnonymousClass1 anonymousClass1) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((java.io.FilterOutputStream) this).out.close();
                } catch (java.io.IOException unused) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((java.io.FilterOutputStream) this).out.flush();
                } catch (java.io.IOException unused) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(i);
                } catch (java.io.IOException unused) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.this.hasErrors = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (java.io.IOException unused) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.this.hasErrors = true;
                }
            }
        }

        private Editor(com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[com.sensorsdata.sf.ui.utils.DiskLruCache.this.valueCount];
        }

        public /* synthetic */ Editor(com.sensorsdata.sf.ui.utils.DiskLruCache diskLruCache, com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry, com.sensorsdata.sf.ui.utils.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(entry);
        }

        public void abort() throws java.io.IOException {
            com.sensorsdata.sf.ui.utils.DiskLruCache.this.completeEdit(this, false);
        }

        public void commit() throws java.io.IOException {
            if (!this.hasErrors) {
                com.sensorsdata.sf.ui.utils.DiskLruCache.this.completeEdit(this, true);
            } else {
                com.sensorsdata.sf.ui.utils.DiskLruCache.this.completeEdit(this, false);
                com.sensorsdata.sf.ui.utils.DiskLruCache.this.remove(this.entry.key);
            }
        }

        public java.lang.String getString(int i) throws java.io.IOException {
            java.io.InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return com.sensorsdata.sf.ui.utils.DiskLruCache.inputStreamToString(newInputStream);
            }
            return null;
        }

        public java.io.InputStream newInputStream(int i) throws java.io.IOException {
            synchronized (com.sensorsdata.sf.ui.utils.DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.entry.readable) {
                    return null;
                }
                return new java.io.FileInputStream(this.entry.getCleanFile(i));
            }
        }

        public java.io.OutputStream newOutputStream(int i) throws java.io.IOException {
            com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.FaultHidingOutputStream faultHidingOutputStream;
            synchronized (com.sensorsdata.sf.ui.utils.DiskLruCache.this) {
                if (this.entry.currentEditor != this) {
                    throw new java.lang.IllegalStateException();
                }
                if (!this.entry.readable) {
                    this.written[i] = true;
                }
                faultHidingOutputStream = new com.sensorsdata.sf.ui.utils.DiskLruCache.Editor.FaultHidingOutputStream(this, new java.io.FileOutputStream(this.entry.getDirtyFile(i)), null);
            }
            return faultHidingOutputStream;
        }

        public void set(int i, java.lang.String str) throws java.io.IOException {
            java.io.OutputStreamWriter outputStreamWriter = null;
            try {
                java.io.OutputStreamWriter outputStreamWriter2 = new java.io.OutputStreamWriter(newOutputStream(i), com.sensorsdata.sf.ui.utils.IoUtils.UTF_8);
                try {
                    outputStreamWriter2.write(str);
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStreamWriter2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
    }

    public final class Entry {
        private com.sensorsdata.sf.ui.utils.DiskLruCache.Editor currentEditor;
        private final java.lang.String key;
        private final long[] lengths;
        private boolean readable;
        private long sequenceNumber;

        private Entry(java.lang.String str) {
            this.key = str;
            this.lengths = new long[com.sensorsdata.sf.ui.utils.DiskLruCache.this.valueCount];
        }

        public /* synthetic */ Entry(com.sensorsdata.sf.ui.utils.DiskLruCache diskLruCache, java.lang.String str, com.sensorsdata.sf.ui.utils.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private java.io.IOException invalidLengths(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != com.sensorsdata.sf.ui.utils.DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        public java.io.File getCleanFile(int i) {
            return new java.io.File(com.sensorsdata.sf.ui.utils.DiskLruCache.this.directory, this.key + "." + i);
        }

        public java.io.File getDirtyFile(int i) {
            return new java.io.File(com.sensorsdata.sf.ui.utils.DiskLruCache.this.directory, this.key + "." + i + com.baidu.mobads.sdk.internal.al.k);
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

    public final class Snapshot implements java.io.Closeable {
        private final java.io.InputStream[] ins;
        private final java.lang.String key;
        private final long sequenceNumber;

        private Snapshot(java.lang.String str, long j, java.io.InputStream[] inputStreamArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.ins = inputStreamArr;
        }

        public /* synthetic */ Snapshot(com.sensorsdata.sf.ui.utils.DiskLruCache diskLruCache, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, com.sensorsdata.sf.ui.utils.DiskLruCache.AnonymousClass1 anonymousClass1) {
            this(str, j, inputStreamArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (java.io.InputStream inputStream : this.ins) {
                com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(inputStream);
            }
        }

        public com.sensorsdata.sf.ui.utils.DiskLruCache.Editor edit() throws java.io.IOException {
            return com.sensorsdata.sf.ui.utils.DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public java.io.InputStream getInputStream(int i) {
            return this.ins[i];
        }

        public java.lang.String getString(int i) throws java.io.IOException {
            return com.sensorsdata.sf.ui.utils.DiskLruCache.inputStreamToString(getInputStream(i));
        }
    }

    private DiskLruCache(java.io.File file, int i, int i2, long j) {
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new java.io.File(file, JOURNAL_FILE);
        this.journalFileTmp = new java.io.File(file, JOURNAL_FILE_TMP);
        this.valueCount = i2;
        this.maxSize = j;
    }

    private void checkNotClosed() {
        if (this.journalWriter == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(com.sensorsdata.sf.ui.utils.DiskLruCache.Editor editor, boolean z) throws java.io.IOException {
        com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = editor.entry;
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
            this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.write("REMOVE " + entry.key + '\n');
        }
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
    public synchronized com.sensorsdata.sf.ui.utils.DiskLruCache.Editor edit(java.lang.String str, long j) throws java.io.IOException {
        checkNotClosed();
        validateKey(str);
        com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if (entry == null) {
            entry = new com.sensorsdata.sf.ui.utils.DiskLruCache.Entry(this, str, null);
            this.lruEntries.put(str, entry);
        } else if (entry.currentEditor != null) {
            return null;
        }
        com.sensorsdata.sf.ui.utils.DiskLruCache.Editor editor = new com.sensorsdata.sf.ui.utils.DiskLruCache.Editor(this, entry, null);
        entry.currentEditor = editor;
        this.journalWriter.write("DIRTY " + str + '\n');
        this.journalWriter.flush();
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String inputStreamToString(java.io.InputStream inputStream) throws java.io.IOException {
        return com.sensorsdata.sf.ui.utils.Streams.readFully(new java.io.InputStreamReader(inputStream, com.sensorsdata.sf.ui.utils.IoUtils.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public static com.sensorsdata.sf.ui.utils.DiskLruCache open(java.io.File file, int i, int i2, long j) throws java.io.IOException {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("valueCount <= 0");
        }
        com.sensorsdata.sf.ui.utils.DiskLruCache diskLruCache = new com.sensorsdata.sf.ui.utils.DiskLruCache(file, i, i2, j);
        if (diskLruCache.journalFile.exists()) {
            try {
                diskLruCache.readJournal();
                diskLruCache.processJournal();
                diskLruCache.journalWriter = new java.io.BufferedWriter(new java.io.FileWriter(diskLruCache.journalFile, true));
                return diskLruCache;
            } catch (java.io.IOException unused) {
                diskLruCache.delete();
            }
        }
        file.mkdirs();
        com.sensorsdata.sf.ui.utils.DiskLruCache diskLruCache2 = new com.sensorsdata.sf.ui.utils.DiskLruCache(file, i, i2, j);
        diskLruCache2.rebuildJournal();
        return diskLruCache2;
    }

    private void processJournal() throws java.io.IOException {
        deleteIfExists(this.journalFileTmp);
        java.util.Iterator<com.sensorsdata.sf.ui.utils.DiskLruCache.Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            com.sensorsdata.sf.ui.utils.DiskLruCache.Entry next = it.next();
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
        com.sensorsdata.sf.ui.utils.StrictLineReader strictLineReader = new com.sensorsdata.sf.ui.utils.StrictLineReader(new java.io.FileInputStream(this.journalFile), com.sensorsdata.sf.ui.utils.IoUtils.US_ASCII);
        try {
            java.lang.String readLine = strictLineReader.readLine();
            java.lang.String readLine2 = strictLineReader.readLine();
            java.lang.String readLine3 = strictLineReader.readLine();
            java.lang.String readLine4 = strictLineReader.readLine();
            java.lang.String readLine5 = strictLineReader.readLine();
            if (!MAGIC.equals(readLine) || !"1".equals(readLine2) || !java.lang.Integer.toString(this.appVersion).equals(readLine3) || !java.lang.Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new java.io.IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(strictLineReader);
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
        com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = this.lruEntries.get(substring);
        if (entry == null) {
            entry = new com.sensorsdata.sf.ui.utils.DiskLruCache.Entry(this, substring, null);
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
            entry.currentEditor = new com.sensorsdata.sf.ui.utils.DiskLruCache.Editor(this, entry, null);
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
            writer.close();
        }
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.journalFileTmp));
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
            for (com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry : this.lruEntries.values()) {
                if (entry.currentEditor != null) {
                    bufferedWriter.write("DIRTY " + entry.key + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                }
            }
            com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedWriter);
            this.journalFileTmp.renameTo(this.journalFile);
            this.journalWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.journalFile, true));
        } catch (java.lang.Throwable th) {
            com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() throws java.io.IOException {
        while (this.size > this.maxSize) {
            remove(this.lruEntries.entrySet().iterator().next().getKey());
        }
    }

    private void validateKey(java.lang.String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new java.lang.IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.journalWriter == null) {
            return;
        }
        java.util.Iterator it = new java.util.ArrayList(this.lruEntries.values()).iterator();
        while (it.hasNext()) {
            com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = (com.sensorsdata.sf.ui.utils.DiskLruCache.Entry) it.next();
            if (entry.currentEditor != null) {
                entry.currentEditor.abort();
            }
        }
        trimToSize();
        this.journalWriter.close();
        this.journalWriter = null;
    }

    public void delete() throws java.io.IOException {
        close();
        com.sensorsdata.sf.ui.utils.IoUtils.deleteContents(this.directory);
    }

    public com.sensorsdata.sf.ui.utils.DiskLruCache.Editor edit(java.lang.String str) throws java.io.IOException {
        return edit(str, -1L);
    }

    public synchronized void flush() throws java.io.IOException {
        checkNotClosed();
        trimToSize();
        this.journalWriter.flush();
    }

    public synchronized com.sensorsdata.sf.ui.utils.DiskLruCache.Snapshot get(java.lang.String str) throws java.io.IOException {
        checkNotClosed();
        validateKey(str);
        com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        if (!entry.readable) {
            return null;
        }
        java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.valueCount];
        for (int i = 0; i < this.valueCount; i++) {
            try {
                inputStreamArr[i] = new java.io.FileInputStream(entry.getCleanFile(i));
            } catch (java.io.FileNotFoundException unused) {
                return null;
            }
        }
        this.redundantOpCount++;
        this.journalWriter.append((java.lang.CharSequence) ("READ " + str + '\n'));
        if (journalRebuildRequired()) {
            this.executorService.submit(this.cleanupCallable);
        }
        return new com.sensorsdata.sf.ui.utils.DiskLruCache.Snapshot(this, str, entry.sequenceNumber, inputStreamArr, null);
    }

    public java.io.File getDirectory() {
        return this.directory;
    }

    public boolean isClosed() {
        return this.journalWriter == null;
    }

    public long maxSize() {
        return this.maxSize;
    }

    public synchronized boolean remove(java.lang.String str) throws java.io.IOException {
        checkNotClosed();
        validateKey(str);
        com.sensorsdata.sf.ui.utils.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.currentEditor == null) {
            for (int i = 0; i < this.valueCount; i++) {
                java.io.File cleanFile = entry.getCleanFile(i);
                if (!cleanFile.delete()) {
                    throw new java.io.IOException("failed to delete " + cleanFile);
                }
                this.size -= entry.lengths[i];
                entry.lengths[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.lruEntries.remove(str);
            if (journalRebuildRequired()) {
                this.executorService.submit(this.cleanupCallable);
            }
            return true;
        }
        return false;
    }

    public synchronized long size() {
        return this.size;
    }
}
