package com.liulishuo.filedownloader.model;

/* loaded from: classes23.dex */
public class ConnectionModel {
    public static final java.lang.String CURRENT_OFFSET = "currentOffset";
    public static final java.lang.String END_OFFSET = "endOffset";
    public static final java.lang.String ID = "id";
    public static final java.lang.String INDEX = "connectionIndex";
    public static final java.lang.String START_OFFSET = "startOffset";
    public int a;
    public int b;
    public long c;
    public long d;
    public long e;

    public static long getTotalOffset(java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list) {
        long j = 0;
        for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : list) {
            j += connectionModel.getCurrentOffset() - connectionModel.getStartOffset();
        }
        return j;
    }

    public long getCurrentOffset() {
        return this.d;
    }

    public long getEndOffset() {
        return this.e;
    }

    public int getId() {
        return this.a;
    }

    public int getIndex() {
        return this.b;
    }

    public long getStartOffset() {
        return this.c;
    }

    public void setCurrentOffset(long j) {
        this.d = j;
    }

    public void setEndOffset(long j) {
        this.e = j;
    }

    public void setId(int i) {
        this.a = i;
    }

    public void setIndex(int i) {
        this.b = i;
    }

    public void setStartOffset(long j) {
        this.c = j;
    }

    public android.content.ContentValues toContentValues() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("id", java.lang.Integer.valueOf(this.a));
        contentValues.put(INDEX, java.lang.Integer.valueOf(this.b));
        contentValues.put("startOffset", java.lang.Long.valueOf(this.c));
        contentValues.put(CURRENT_OFFSET, java.lang.Long.valueOf(this.d));
        contentValues.put("endOffset", java.lang.Long.valueOf(this.e));
        return contentValues;
    }

    public java.lang.String toString() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("id[%d] index[%d] range[%d, %d) current offset(%d)", java.lang.Integer.valueOf(this.a), java.lang.Integer.valueOf(this.b), java.lang.Long.valueOf(this.c), java.lang.Long.valueOf(this.e), java.lang.Long.valueOf(this.d));
    }
}
