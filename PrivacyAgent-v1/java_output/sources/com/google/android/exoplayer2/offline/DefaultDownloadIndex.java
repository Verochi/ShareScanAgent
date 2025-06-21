package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class DefaultDownloadIndex implements com.google.android.exoplayer2.offline.WritableDownloadIndex {
    public static final java.lang.String e = h(3, 4);
    public static final java.lang.String[] f = {"id", "mime_type", "uri", "stream_keys", "custom_cache_key", "data", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "start_time_ms", "update_time_ms", "content_length", com.google.android.exoplayer2.offline.DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded", "key_set_id"};
    public final java.lang.String a;
    public final java.lang.String b;
    public final com.google.android.exoplayer2.database.DatabaseProvider c;
    public boolean d;

    public static final class DownloadCursorImpl implements com.google.android.exoplayer2.offline.DownloadCursor {
        public final android.database.Cursor n;

        public DownloadCursorImpl(android.database.Cursor cursor) {
            this.n = cursor;
        }

        public /* synthetic */ DownloadCursorImpl(android.database.Cursor cursor, com.google.android.exoplayer2.offline.DefaultDownloadIndex.AnonymousClass1 anonymousClass1) {
            this(cursor);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.n.close();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getCount() {
            return this.n.getCount();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public com.google.android.exoplayer2.offline.Download getDownload() {
            return com.google.android.exoplayer2.offline.DefaultDownloadIndex.f(this.n);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public int getPosition() {
            return this.n.getPosition();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isAfterLast() {
            return defpackage.y40.a(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isBeforeFirst() {
            return defpackage.y40.b(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean isClosed() {
            return this.n.isClosed();
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isFirst() {
            return defpackage.y40.c(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean isLast() {
            return defpackage.y40.d(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToFirst() {
            return defpackage.y40.e(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToLast() {
            return defpackage.y40.f(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToNext() {
            return defpackage.y40.g(this);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public boolean moveToPosition(int i) {
            return this.n.moveToPosition(i);
        }

        @Override // com.google.android.exoplayer2.offline.DownloadCursor
        public /* synthetic */ boolean moveToPrevious() {
            return defpackage.y40.h(this);
        }
    }

    public DefaultDownloadIndex(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    public DefaultDownloadIndex(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, java.lang.String str) {
        this.a = str;
        this.c = databaseProvider;
        java.lang.String valueOf = java.lang.String.valueOf(str);
        this.b = valueOf.length() != 0 ? "ExoPlayerDownloads".concat(valueOf) : new java.lang.String("ExoPlayerDownloads");
    }

    public static java.util.List<com.google.android.exoplayer2.offline.StreamKey> b(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str.isEmpty()) {
            return arrayList;
        }
        for (java.lang.String str2 : com.google.android.exoplayer2.util.Util.split(str, ",")) {
            java.lang.String[] split = com.google.android.exoplayer2.util.Util.split(str2, "\\.");
            com.google.android.exoplayer2.util.Assertions.checkState(split.length == 3);
            arrayList.add(new com.google.android.exoplayer2.offline.StreamKey(java.lang.Integer.parseInt(split[0]), java.lang.Integer.parseInt(split[1]), java.lang.Integer.parseInt(split[2])));
        }
        return arrayList;
    }

    @androidx.annotation.VisibleForTesting
    public static java.lang.String c(java.util.List<com.google.android.exoplayer2.offline.StreamKey> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            com.google.android.exoplayer2.offline.StreamKey streamKey = list.get(i);
            sb.append(streamKey.periodIndex);
            sb.append('.');
            sb.append(streamKey.groupIndex);
            sb.append('.');
            sb.append(streamKey.trackIndex);
            sb.append(',');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static com.google.android.exoplayer2.offline.Download f(android.database.Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        com.google.android.exoplayer2.offline.DownloadRequest.Builder streamKeys = new com.google.android.exoplayer2.offline.DownloadRequest.Builder(cursor.getString(0), android.net.Uri.parse(cursor.getString(2))).setMimeType(cursor.getString(1)).setStreamKeys(b(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        com.google.android.exoplayer2.offline.DownloadRequest build = streamKeys.setKeySetId(blob).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        com.google.android.exoplayer2.offline.DownloadProgress downloadProgress = new com.google.android.exoplayer2.offline.DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new com.google.android.exoplayer2.offline.Download(build, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static com.google.android.exoplayer2.offline.Download g(android.database.Cursor cursor) {
        com.google.android.exoplayer2.offline.DownloadRequest build = new com.google.android.exoplayer2.offline.DownloadRequest.Builder(cursor.getString(0), android.net.Uri.parse(cursor.getString(2))).setMimeType(i(cursor.getString(1))).setStreamKeys(b(cursor.getString(3))).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        com.google.android.exoplayer2.offline.DownloadProgress downloadProgress = new com.google.android.exoplayer2.offline.DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i = cursor.getInt(6);
        return new com.google.android.exoplayer2.offline.Download(build, i, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    public static java.lang.String h(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b);
        sb.append(" IN (");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(iArr[i]);
        }
        sb.append(')');
        return sb.toString();
    }

    public static java.lang.String i(java.lang.String str) {
        return "dash".equals(str) ? "application/dash+xml" : "hls".equals(str) ? "application/x-mpegURL" : "ss".equals(str) ? "application/vnd.ms-sstr+xml" : "video/x-unknown";
    }

    public final void d() throws com.google.android.exoplayer2.database.DatabaseIOException {
        if (this.d) {
            return;
        }
        try {
            int version = com.google.android.exoplayer2.database.VersionTable.getVersion(this.c.getReadableDatabase(), 0, this.a);
            if (version != 3) {
                android.database.sqlite.SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    com.google.android.exoplayer2.database.VersionTable.setVersion(writableDatabase, 0, this.a, 3);
                    java.util.List<com.google.android.exoplayer2.offline.Download> j = version == 2 ? j(writableDatabase) : new java.util.ArrayList<>();
                    java.lang.String valueOf = java.lang.String.valueOf(this.b);
                    writableDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new java.lang.String("DROP TABLE IF EXISTS "));
                    java.lang.String str = this.b;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + com.bytedance.sdk.openadsdk.TTAdConstant.VIDEO_COVER_URL_CODE);
                    sb.append("CREATE TABLE ");
                    sb.append(str);
                    sb.append(" ");
                    sb.append("(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)");
                    writableDatabase.execSQL(sb.toString());
                    java.util.Iterator<com.google.android.exoplayer2.offline.Download> it = j.iterator();
                    while (it.hasNext()) {
                        k(it.next(), writableDatabase);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (java.lang.Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
            this.d = true;
        } catch (android.database.SQLException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    public final android.database.Cursor e(java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            return this.c.getReadableDatabase().query(this.b, f, str, strArr, null, null, "start_time_ms ASC");
        } catch (android.database.sqlite.SQLiteException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.offline.Download getDownload(java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            android.database.Cursor e2 = e("id = ?", new java.lang.String[]{str});
            try {
                if (e2.getCount() == 0) {
                    e2.close();
                    return null;
                }
                e2.moveToNext();
                com.google.android.exoplayer2.offline.Download f2 = f(e2);
                e2.close();
                return f2;
            } finally {
            }
        } catch (android.database.sqlite.SQLiteException e3) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e3);
        }
    }

    @Override // com.google.android.exoplayer2.offline.DownloadIndex
    public com.google.android.exoplayer2.offline.DownloadCursor getDownloads(int... iArr) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        return new com.google.android.exoplayer2.offline.DefaultDownloadIndex.DownloadCursorImpl(e(h(iArr), null), null);
    }

    public final java.util.List<com.google.android.exoplayer2.offline.Download> j(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!com.google.android.exoplayer2.util.Util.tableExists(sQLiteDatabase, this.b)) {
            return arrayList;
        }
        android.database.Cursor query = sQLiteDatabase.query(this.b, new java.lang.String[]{"id", "title", "uri", "stream_keys", "custom_cache_key", "data", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "start_time_ms", "update_time_ms", "content_length", com.google.android.exoplayer2.offline.DownloadService.KEY_STOP_REASON, "failure_reason", "percent_downloaded", "bytes_downloaded"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(g(query));
            } finally {
            }
        }
        query.close();
        return arrayList;
    }

    public final void k(com.google.android.exoplayer2.offline.Download download, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.request.keySetId;
        if (bArr == null) {
            bArr = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("id", download.request.id);
        contentValues.put("mime_type", download.request.mimeType);
        contentValues.put("uri", download.request.uri.toString());
        contentValues.put("stream_keys", c(download.request.streamKeys));
        contentValues.put("custom_cache_key", download.request.customCacheKey);
        contentValues.put("data", download.request.data);
        contentValues.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, java.lang.Integer.valueOf(download.state));
        contentValues.put("start_time_ms", java.lang.Long.valueOf(download.startTimeMs));
        contentValues.put("update_time_ms", java.lang.Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", java.lang.Long.valueOf(download.contentLength));
        contentValues.put(com.google.android.exoplayer2.offline.DownloadService.KEY_STOP_REASON, java.lang.Integer.valueOf(download.stopReason));
        contentValues.put("failure_reason", java.lang.Integer.valueOf(download.failureReason));
        contentValues.put("percent_downloaded", java.lang.Float.valueOf(download.getPercentDownloaded()));
        contentValues.put("bytes_downloaded", java.lang.Long.valueOf(download.getBytesDownloaded()));
        contentValues.put("key_set_id", bArr);
        sQLiteDatabase.replaceOrThrow(this.b, null, contentValues);
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void putDownload(com.google.android.exoplayer2.offline.Download download) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            k(download, this.c.getWritableDatabase());
        } catch (android.database.sqlite.SQLiteException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void removeDownload(java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            this.c.getWritableDatabase().delete(this.b, "id = ?", new java.lang.String[]{str});
        } catch (android.database.sqlite.SQLiteException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setDownloadingStatesToQueued() throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, (java.lang.Integer) 0);
            this.c.getWritableDatabase().update(this.b, contentValues, "state = 2", null);
        } catch (android.database.SQLException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStatesToRemoving() throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, (java.lang.Integer) 5);
            contentValues.put("failure_reason", (java.lang.Integer) 0);
            this.c.getWritableDatabase().update(this.b, contentValues, null, null);
        } catch (android.database.SQLException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(int i) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.google.android.exoplayer2.offline.DownloadService.KEY_STOP_REASON, java.lang.Integer.valueOf(i));
            this.c.getWritableDatabase().update(this.b, contentValues, e, null);
        } catch (android.database.SQLException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.offline.WritableDownloadIndex
    public void setStopReason(java.lang.String str, int i) throws com.google.android.exoplayer2.database.DatabaseIOException {
        d();
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.google.android.exoplayer2.offline.DownloadService.KEY_STOP_REASON, java.lang.Integer.valueOf(i));
            android.database.sqlite.SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            java.lang.String str2 = this.b;
            java.lang.String str3 = e;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str3).length() + 11);
            sb.append(str3);
            sb.append(" AND ");
            sb.append("id = ?");
            writableDatabase.update(str2, contentValues, sb.toString(), new java.lang.String[]{str});
        } catch (android.database.SQLException e2) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e2);
        }
    }
}
