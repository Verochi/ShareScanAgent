package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class DownloadChunk implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.DownloadChunk> CREATOR = new com.ss.android.socialbase.downloader.model.DownloadChunk.AnonymousClass1();
    private static final java.lang.String TAG = "DownloadChunk";
    private int bindValueCount;
    private int chunkIndex;
    private com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable chunkRunnable;
    private long contentLength;
    private java.util.concurrent.atomic.AtomicLong currentOffset;
    private long endOffset;
    private com.ss.android.socialbase.downloader.model.DownloadChunk hostChunk;
    private java.util.concurrent.atomic.AtomicInteger hostChunkIndex;
    private int id;
    private java.util.concurrent.atomic.AtomicBoolean isDownloading;
    private long oldOffset;
    private boolean reuseingFirstConnection;
    private long startOffset;
    private java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> subChunkList;

    /* renamed from: com.ss.android.socialbase.downloader.model.DownloadChunk$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.DownloadChunk> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.DownloadChunk createFromParcel(android.os.Parcel parcel) {
            return new com.ss.android.socialbase.downloader.model.DownloadChunk(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.DownloadChunk[] newArray(int i) {
            return new com.ss.android.socialbase.downloader.model.DownloadChunk[i];
        }
    }

    public static class Builder {
        private int chunkIndex;
        private long contentLength;
        private long currentOffset;
        private long endOffset;
        private com.ss.android.socialbase.downloader.model.DownloadChunk hostChunk;
        private int id;
        private long oldOffset;
        private long startOffset;

        public Builder(int i) {
            this.id = i;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk build() {
            return new com.ss.android.socialbase.downloader.model.DownloadChunk(this, null);
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder chunkIndex(int i) {
            this.chunkIndex = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder contentLength(long j) {
            this.contentLength = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder currentOffset(long j) {
            this.currentOffset = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder endOffset(long j) {
            this.endOffset = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder hostChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
            this.hostChunk = downloadChunk;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder id(int i) {
            this.id = i;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder oldOffset(long j) {
            this.oldOffset = j;
            return this;
        }

        public com.ss.android.socialbase.downloader.model.DownloadChunk.Builder startOffset(long j) {
            this.startOffset = j;
            return this;
        }
    }

    public DownloadChunk(android.database.Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.id = cursor.getInt(cursor.getColumnIndex("_id"));
        this.chunkIndex = cursor.getInt(cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_INDEX));
        this.startOffset = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_OFFSET);
        if (columnIndex != -1) {
            this.currentOffset = new java.util.concurrent.atomic.AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.currentOffset = new java.util.concurrent.atomic.AtomicLong(0L);
        }
        this.endOffset = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.HOST_CHUNK_INDEX);
        if (columnIndex2 != -1) {
            this.hostChunkIndex = new java.util.concurrent.atomic.AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.hostChunkIndex = new java.util.concurrent.atomic.AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_CONTENT_LEN);
        if (columnIndex3 != -1) {
            this.contentLength = cursor.getLong(columnIndex3);
        }
        this.isDownloading = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    public DownloadChunk(android.os.Parcel parcel) {
        this.id = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.currentOffset = new java.util.concurrent.atomic.AtomicLong(parcel.readLong());
        this.endOffset = parcel.readLong();
        this.contentLength = parcel.readLong();
        this.chunkIndex = parcel.readInt();
        this.hostChunkIndex = new java.util.concurrent.atomic.AtomicInteger(parcel.readInt());
    }

    private DownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk.Builder builder) {
        if (builder == null) {
            return;
        }
        this.id = builder.id;
        this.startOffset = builder.startOffset;
        this.currentOffset = new java.util.concurrent.atomic.AtomicLong(builder.currentOffset);
        this.endOffset = builder.endOffset;
        this.contentLength = builder.contentLength;
        this.chunkIndex = builder.chunkIndex;
        this.oldOffset = builder.oldOffset;
        this.hostChunkIndex = new java.util.concurrent.atomic.AtomicInteger(-1);
        setHostChunk(builder.hostChunk);
        this.isDownloading = new java.util.concurrent.atomic.AtomicBoolean(false);
    }

    public /* synthetic */ DownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk.Builder builder, com.ss.android.socialbase.downloader.model.DownloadChunk.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public void bindValue(android.database.sqlite.SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        sQLiteStatement.bindLong(i2, this.chunkIndex);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        sQLiteStatement.bindLong(i3, this.startOffset);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        sQLiteStatement.bindLong(i4, getCurrentOffset());
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        sQLiteStatement.bindLong(i5, this.endOffset);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.contentLength);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, getHostChunkIndex());
    }

    public boolean canRefreshCurOffsetForReuseChunk() {
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk == null) {
            return true;
        }
        if (!downloadChunk.hasChunkDivided()) {
            return false;
        }
        for (int i = 0; i < this.hostChunk.getSubChunkList().size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i);
            if (downloadChunk2 != null) {
                int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
                if (indexOf > i && !downloadChunk2.hasNoBytesDownload()) {
                    return false;
                }
                if (indexOf == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> divideChunkForReuse(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk;
        long j2;
        long j3;
        long j4;
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = this;
        int i2 = i;
        if (!isHostChunk() || hasChunkDivided()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long curOffset = getCurOffset();
        long retainLength = downloadChunk2.getRetainLength(true);
        long j5 = retainLength / i2;
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "retainLen:" + retainLength + " divideChunkForReuse chunkSize:" + j5 + " current host downloadChunk index:" + downloadChunk2.chunkIndex);
        int i3 = 0;
        while (i3 < i2) {
            if (i3 == 0) {
                j2 = getStartOffset();
            } else {
                int i4 = i2 - 1;
                if (i3 == i4) {
                    long endOffset = getEndOffset();
                    j3 = endOffset;
                    j4 = endOffset > curOffset ? (endOffset - curOffset) + 1 : retainLength - (i4 * j5);
                    j2 = curOffset;
                    long j6 = retainLength;
                    long j7 = j4;
                    com.ss.android.socialbase.downloader.model.DownloadChunk build = new com.ss.android.socialbase.downloader.model.DownloadChunk.Builder(downloadChunk2.id).chunkIndex((-i3) - 1).startOffset(j2).currentOffset(curOffset).oldOffset(curOffset).endOffset(j3).contentLength(j7).hostChunk(downloadChunk2).build();
                    com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + curOffset + " endOffset:" + j3 + " contentLen:" + j7);
                    arrayList.add(build);
                    curOffset += j5;
                    i3++;
                    downloadChunk2 = this;
                    i2 = i;
                    retainLength = j6;
                } else {
                    j2 = curOffset;
                }
            }
            j3 = (curOffset + j5) - 1;
            j4 = j5;
            long j62 = retainLength;
            long j72 = j4;
            com.ss.android.socialbase.downloader.model.DownloadChunk build2 = new com.ss.android.socialbase.downloader.model.DownloadChunk.Builder(downloadChunk2.id).chunkIndex((-i3) - 1).startOffset(j2).currentOffset(curOffset).oldOffset(curOffset).endOffset(j3).contentLength(j72).hostChunk(downloadChunk2).build();
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "divide sub chunk : " + i3 + " startOffset:" + j2 + " curOffset:" + curOffset + " endOffset:" + j3 + " contentLen:" + j72);
            arrayList.add(build2);
            curOffset += j5;
            i3++;
            downloadChunk2 = this;
            i2 = i;
            retainLength = j62;
        }
        long j8 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk3 = arrayList.get(size);
            if (downloadChunk3 != null) {
                j8 += downloadChunk3.getContentLength();
            }
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "reuseChunkContentLen:".concat(java.lang.String.valueOf(j8)));
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk4 = arrayList.get(0);
        if (downloadChunk4 != null) {
            downloadChunk4.setContentLength((getEndOffset() == 0 ? j - getStartOffset() : (getEndOffset() - getStartOffset()) + 1) - j8);
            downloadChunk = this;
            downloadChunk4.setChunkIndex(downloadChunk.chunkIndex);
            com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable = downloadChunk.chunkRunnable;
            if (downloadChunkRunnable != null) {
                downloadChunkRunnable.refreshResponseHandleOffset(downloadChunk4.getEndOffset(), getContentLength() - j8);
            }
        } else {
            downloadChunk = this;
        }
        downloadChunk.setSubChunkList(arrayList);
        return arrayList;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getChunkIndex() {
        return this.chunkIndex;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurOffset() {
        java.util.concurrent.atomic.AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long getCurrentOffset() {
        if (!isHostChunk() || !hasChunkDivided()) {
            return getCurOffset();
        }
        long j = 0;
        for (int i = 0; i < this.subChunkList.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = this.subChunkList.get(i);
            if (downloadChunk != null) {
                if (!downloadChunk.hasNoBytesDownload()) {
                    return downloadChunk.getCurOffset();
                }
                if (j < downloadChunk.getCurOffset()) {
                    j = downloadChunk.getCurOffset();
                }
            }
        }
        return j;
    }

    public long getDownloadChunkBytes() {
        long currentOffset = getCurrentOffset() - this.startOffset;
        if (hasChunkDivided()) {
            currentOffset = 0;
            for (int i = 0; i < this.subChunkList.size(); i++) {
                com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = this.subChunkList.get(i);
                if (downloadChunk != null) {
                    currentOffset += downloadChunk.getCurrentOffset() - downloadChunk.getStartOffset();
                }
            }
        }
        return currentOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public com.ss.android.socialbase.downloader.model.DownloadChunk getFirstReuseChunk() {
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = !isHostChunk() ? this.hostChunk : this;
        if (downloadChunk == null || !downloadChunk.hasChunkDivided()) {
            return null;
        }
        return downloadChunk.getSubChunkList().get(0);
    }

    public com.ss.android.socialbase.downloader.model.DownloadChunk getHostChunk() {
        return this.hostChunk;
    }

    public int getHostChunkIndex() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public int getId() {
        return this.id;
    }

    public long getNextChunkCurOffset() {
        com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk != null && downloadChunk.getSubChunkList() != null) {
            int indexOf = this.hostChunk.getSubChunkList().indexOf(this);
            boolean z = false;
            for (int i = 0; i < this.hostChunk.getSubChunkList().size(); i++) {
                com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i);
                if (downloadChunk2 != null) {
                    if (z) {
                        return downloadChunk2.getCurrentOffset();
                    }
                    if (indexOf == i) {
                        z = true;
                    }
                }
            }
        }
        return -1L;
    }

    public long getOldOffset() {
        return this.oldOffset;
    }

    public long getRetainLength(boolean z) {
        long currentOffset = getCurrentOffset();
        long j = this.contentLength;
        long j2 = this.oldOffset;
        long j3 = j - (currentOffset - j2);
        if (!z && currentOffset == j2) {
            j3 = j - (currentOffset - this.startOffset);
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "contentLength:" + this.contentLength + " curOffset:" + getCurrentOffset() + " oldOffset:" + this.oldOffset + " retainLen:" + j3);
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getSubChunkList() {
        return this.subChunkList;
    }

    public boolean hasChunkDivided() {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list = this.subChunkList;
        return list != null && list.size() > 0;
    }

    public boolean hasNoBytesDownload() {
        long j = this.startOffset;
        if (isHostChunk()) {
            long j2 = this.oldOffset;
            if (j2 > this.startOffset) {
                j = j2;
            }
        }
        return getCurrentOffset() - j >= this.contentLength;
    }

    public boolean isDownloading() {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean isHostChunk() {
        return getHostChunkIndex() == -1;
    }

    public boolean isReuseingFirstConnection() {
        return this.chunkIndex == 0 && this.reuseingFirstConnection;
    }

    public void setChunkIndex(int i) {
        this.chunkIndex = i;
    }

    public void setChunkRunnable(com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable downloadChunkRunnable) {
        this.chunkRunnable = downloadChunkRunnable;
        setOldOffset();
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setCurrentOffset(long j) {
        java.util.concurrent.atomic.AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.currentOffset = new java.util.concurrent.atomic.AtomicLong(j);
        }
    }

    public void setDownloading(boolean z) {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            this.isDownloading = new java.util.concurrent.atomic.AtomicBoolean(z);
        } else {
            atomicBoolean.set(z);
        }
        this.chunkRunnable = null;
    }

    public void setHostChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        this.hostChunk = downloadChunk;
        if (downloadChunk != null) {
            setHostChunkIndex(downloadChunk.getChunkIndex());
        }
    }

    public void setHostChunkIndex(int i) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            this.hostChunkIndex = new java.util.concurrent.atomic.AtomicInteger(i);
        } else {
            atomicInteger.set(i);
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOldOffset() {
        this.oldOffset = getCurrentOffset();
    }

    public void setOldOffset(long j) {
        this.oldOffset = j;
    }

    public void setReuseingFirstConnection(boolean z) {
        this.reuseingFirstConnection = z;
    }

    public void setSubChunkList(java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        this.subChunkList = list;
    }

    public android.content.ContentValues toContentValues() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_id", java.lang.Integer.valueOf(this.id));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_INDEX, java.lang.Integer.valueOf(this.chunkIndex));
        contentValues.put("startOffset", java.lang.Long.valueOf(this.startOffset));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CUR_OFFSET, java.lang.Long.valueOf(getCurrentOffset()));
        contentValues.put("endOffset", java.lang.Long.valueOf(this.endOffset));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.CHUNK_CONTENT_LEN, java.lang.Long.valueOf(this.contentLength));
        contentValues.put(com.ss.android.socialbase.downloader.constants.DBDefinition.HOST_CHUNK_INDEX, java.lang.Integer.valueOf(getHostChunkIndex()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeLong(this.startOffset);
        java.util.concurrent.atomic.AtomicLong atomicLong = this.currentOffset;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.endOffset);
        parcel.writeLong(this.contentLength);
        parcel.writeInt(this.chunkIndex);
        java.util.concurrent.atomic.AtomicInteger atomicInteger = this.hostChunkIndex;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }
}
