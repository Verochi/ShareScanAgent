package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public class DataBufferRef {
    protected final com.huawei.hms.common.data.DataHolder mDataHolder;
    protected int mDataRow;
    private int windowIndex;

    public DataBufferRef(com.huawei.hms.common.data.DataHolder dataHolder, int i) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i);
    }

    public void copyToBuffer(java.lang.String str, android.database.CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.windowIndex, charArrayBuffer);
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.huawei.hms.common.data.DataBufferRef)) {
            return false;
        }
        com.huawei.hms.common.data.DataBufferRef dataBufferRef = (com.huawei.hms.common.data.DataBufferRef) obj;
        return dataBufferRef.mDataRow == this.mDataRow && dataBufferRef.windowIndex == this.windowIndex && dataBufferRef.mDataHolder == this.mDataHolder;
    }

    public boolean getBoolean(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((java.lang.Boolean) value).booleanValue();
        }
        return false;
    }

    public byte[] getByteArray(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((java.lang.Double) value).doubleValue();
        }
        return -1.0d;
    }

    public float getFloat(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((java.lang.Float) value).floatValue();
        }
        return -1.0f;
    }

    public int getInteger(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_INT);
        if (value != null) {
            return ((java.lang.Integer) value).intValue();
        }
        return -1;
    }

    public long getLong(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_LONG);
        if (value != null) {
            return ((java.lang.Long) value).longValue();
        }
        return -1L;
    }

    public java.lang.String getString(java.lang.String str) {
        java.lang.Object value = this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_STRING);
        return value != null ? (java.lang.String) value : "";
    }

    public final void getWindowIndex(int i) {
        com.huawei.hms.common.internal.Preconditions.checkArgument(i >= 0 && i < this.mDataHolder.getCount(), "rowNum is out of index");
        this.mDataRow = i;
        this.windowIndex = this.mDataHolder.getWindowIndex(i);
    }

    public boolean hasColumn(java.lang.String str) {
        return this.mDataHolder.hasColumn(str);
    }

    public boolean hasNull(java.lang.String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.windowIndex);
    }

    public int hashCode() {
        return com.huawei.hms.common.internal.Objects.hashCode(java.lang.Integer.valueOf(this.mDataRow), java.lang.Integer.valueOf(this.windowIndex), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public android.net.Uri parseUri(java.lang.String str) {
        java.lang.String str2 = (java.lang.String) this.mDataHolder.getValue(str, this.mDataRow, this.windowIndex, com.huawei.hms.common.data.DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return android.net.Uri.parse(str2);
    }
}
