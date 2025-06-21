package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public final class DataHolder extends com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable implements java.io.Closeable {
    private static final java.lang.String TAG = "DataHolder";
    public static final java.lang.String TYPE_BOOLEAN = "type_boolean";
    public static final java.lang.String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final java.lang.String TYPE_DOUBLE = "type_double";
    public static final java.lang.String TYPE_FLOAT = "type_float";
    public static final java.lang.String TYPE_INT = "type_int";
    public static final java.lang.String TYPE_LONG = "type_long";
    public static final java.lang.String TYPE_STRING = "type_string";
    private java.lang.String[] columns;
    private android.os.Bundle columnsBundle;
    private android.database.CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private android.os.Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final android.os.Parcelable.Creator<com.huawei.hms.common.data.DataHolder> CREATOR = new com.huawei.hms.common.data.DataHolderCreator();
    private static final com.huawei.hms.common.data.DataHolder.Builder BUILDER = new com.huawei.hms.common.data.DataHolderBuilderCreator(new java.lang.String[0], null);

    public static class Builder {
        private java.lang.String[] builderColumns;
        private final java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> dataCollectionList;
        private final java.lang.String type;
        private final java.util.HashMap<java.lang.Object, java.lang.Integer> typeAndDataCollectionCountMapping;

        private Builder(java.lang.String[] strArr, java.lang.String str) {
            com.huawei.hms.common.internal.Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.builderColumns = strArr;
            this.dataCollectionList = new java.util.ArrayList<>();
            this.type = str;
            this.typeAndDataCollectionCountMapping = new java.util.HashMap<>();
        }

        public /* synthetic */ Builder(java.lang.String[] strArr, java.lang.String str, com.huawei.hms.common.data.DataHolder.AnonymousClass1 anonymousClass1) {
            this(strArr, str);
        }

        public Builder(java.lang.String[] strArr, java.lang.String str, com.huawei.hms.common.data.DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }

        public com.huawei.hms.common.data.DataHolder build(int i) {
            return new com.huawei.hms.common.data.DataHolder(this, i, (android.os.Bundle) null, (com.huawei.hms.common.data.DataHolder.AnonymousClass1) null);
        }

        public com.huawei.hms.common.data.DataHolder build(int i, android.os.Bundle bundle) {
            return new com.huawei.hms.common.data.DataHolder(this, i, bundle, -1, (com.huawei.hms.common.data.DataHolder.AnonymousClass1) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.huawei.hms.common.data.DataHolder.Builder setDataForContentValuesHashMap(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
            int i;
            boolean z;
            java.lang.Object obj;
            com.huawei.hms.common.internal.Preconditions.checkNotNull(hashMap, "contentValuesHashMap cannot be null");
            java.lang.String str = this.type;
            if (str != null && (obj = hashMap.get(str)) != null) {
                java.lang.Integer num = this.typeAndDataCollectionCountMapping.get(obj);
                if (num != null) {
                    i = num.intValue();
                    z = true;
                    if (z) {
                        this.dataCollectionList.add(hashMap);
                    } else {
                        this.dataCollectionList.remove(i);
                        this.dataCollectionList.add(i, hashMap);
                    }
                    return this;
                }
                this.typeAndDataCollectionCountMapping.put(obj, java.lang.Integer.valueOf(this.dataCollectionList.size()));
            }
            i = 0;
            z = false;
            if (z) {
            }
            return this;
        }

        public com.huawei.hms.common.data.DataHolder.Builder withRow(android.content.ContentValues contentValues) {
            com.huawei.hms.common.internal.Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>(contentValues.size());
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }
    }

    public static class DataHolderException extends java.lang.RuntimeException {
        public DataHolderException(java.lang.String str) {
            super(str);
        }
    }

    public DataHolder(int i, java.lang.String[] strArr, android.database.CursorWindow[] cursorWindowArr, int i2, android.os.Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i2;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(android.database.Cursor cursor, int i, android.os.Bundle bundle) {
        this(new com.huawei.hms.common.sqlite.HMSCursorWrapper(cursor), i, bundle);
    }

    private DataHolder(com.huawei.hms.common.data.DataHolder.Builder builder, int i, android.os.Bundle bundle) {
        this(builder.builderColumns, getCursorWindows(builder, -1), i, (android.os.Bundle) null);
    }

    private DataHolder(com.huawei.hms.common.data.DataHolder.Builder builder, int i, android.os.Bundle bundle, int i2) {
        this(builder.builderColumns, getCursorWindows(builder, -1), i, bundle);
    }

    public /* synthetic */ DataHolder(com.huawei.hms.common.data.DataHolder.Builder builder, int i, android.os.Bundle bundle, int i2, com.huawei.hms.common.data.DataHolder.AnonymousClass1 anonymousClass1) {
        this(builder, i, bundle, i2);
    }

    public /* synthetic */ DataHolder(com.huawei.hms.common.data.DataHolder.Builder builder, int i, android.os.Bundle bundle, com.huawei.hms.common.data.DataHolder.AnonymousClass1 anonymousClass1) {
        this(builder, i, bundle);
    }

    private DataHolder(com.huawei.hms.common.sqlite.HMSCursorWrapper hMSCursorWrapper, int i, android.os.Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i, bundle);
    }

    public DataHolder(java.lang.String[] strArr, android.database.CursorWindow[] cursorWindowArr, int i, android.os.Bundle bundle) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        com.huawei.hms.common.internal.Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public static com.huawei.hms.common.data.DataHolder.Builder builder(java.lang.String[] strArr) {
        return new com.huawei.hms.common.data.DataHolder.Builder(strArr, (java.lang.String) null, (com.huawei.hms.common.data.DataHolder.AnonymousClass1) null);
    }

    private void checkAvailable(java.lang.String str, int i) {
        java.lang.String str2;
        android.os.Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i < 0 || i >= this.dataCount) {
            str2 = "row is out of index:" + i;
        } else {
            str2 = "";
        }
        com.huawei.hms.common.internal.Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static com.huawei.hms.common.data.DataHolder empty(int i) {
        return new com.huawei.hms.common.data.DataHolder(BUILDER, i, (android.os.Bundle) null);
    }

    private static android.database.CursorWindow[] getCursorWindows(com.huawei.hms.common.data.DataHolder.Builder builder, int i) {
        if (builder.builderColumns.length == 0) {
            return new android.database.CursorWindow[0];
        }
        if (i < 0 || i >= builder.dataCollectionList.size()) {
            i = builder.dataCollectionList.size();
        }
        java.util.ArrayList<android.database.CursorWindow> iterCursorWindow = iterCursorWindow(builder, i, builder.dataCollectionList.subList(0, i));
        return (android.database.CursorWindow[]) iterCursorWindow.toArray(new android.database.CursorWindow[iterCursorWindow.size()]);
    }

    private static android.database.CursorWindow[] getCursorWindows(com.huawei.hms.common.sqlite.HMSCursorWrapper hMSCursorWrapper) {
        int i;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            android.database.CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                i = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i, count));
            return (android.database.CursorWindow[]) arrayList.toArray(new android.database.CursorWindow[arrayList.size()]);
        } catch (java.lang.Throwable th) {
            try {
                com.huawei.hms.support.log.HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                return new android.database.CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.ArrayList<android.database.CursorWindow> iterCursorWindow(com.huawei.hms.common.data.DataHolder.Builder builder, int i, java.util.List list) {
        java.util.ArrayList<android.database.CursorWindow> arrayList = new java.util.ArrayList<>();
        android.database.CursorWindow cursorWindow = new android.database.CursorWindow((java.lang.String) null);
        cursorWindow.setNumColumns(builder.builderColumns.length);
        arrayList.add(cursorWindow);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            try {
                if (!cursorWindow.allocRow()) {
                    com.huawei.hms.support.log.HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new android.database.CursorWindow((java.lang.String) null);
                    cursorWindow.setStartPosition(i2);
                    cursorWindow.setNumColumns(builder.builderColumns.length);
                    if (!cursorWindow.allocRow()) {
                        com.huawei.hms.support.log.HMSLog.e(TAG, "Failed to retry to allocate a row");
                        return arrayList;
                    }
                    arrayList.add(cursorWindow);
                }
                java.util.HashMap hashMap = (java.util.HashMap) list.get(i2);
                boolean z = true;
                for (int i3 = 0; i3 < builder.builderColumns.length && (z = putValue(cursorWindow, hashMap.get(builder.builderColumns[i3]), i2, i3)); i3++) {
                }
                if (!z) {
                    com.huawei.hms.support.log.HMSLog.d(TAG, "fail to put data for row " + i2);
                    cursorWindow.freeLastRow();
                    android.database.CursorWindow cursorWindow2 = new android.database.CursorWindow((java.lang.String) null);
                    cursorWindow2.setStartPosition(i2);
                    cursorWindow2.setNumColumns(builder.builderColumns.length);
                    arrayList.add(cursorWindow2);
                    break;
                }
                i2++;
            } catch (java.lang.RuntimeException e) {
                java.util.Iterator<android.database.CursorWindow> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                throw e;
            }
        }
    }

    private static java.util.ArrayList<android.database.CursorWindow> iterCursorWrapper(com.huawei.hms.common.sqlite.HMSCursorWrapper hMSCursorWrapper, int i, int i2) {
        java.util.ArrayList<android.database.CursorWindow> arrayList = new java.util.ArrayList<>();
        while (i < i2 && hMSCursorWrapper.moveToPosition(i)) {
            android.database.CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new android.database.CursorWindow((java.lang.String) null);
                window.setStartPosition(i);
                hMSCursorWrapper.fillWindow(i, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(android.database.CursorWindow cursorWindow, java.lang.Object obj, int i, int i2) throws java.lang.IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i, i2);
        }
        if (obj instanceof java.lang.Boolean) {
            return cursorWindow.putLong(((java.lang.Boolean) obj).booleanValue() ? 1L : 0L, i, i2);
        }
        if (obj instanceof java.lang.Integer) {
            return cursorWindow.putLong(((java.lang.Integer) obj).intValue(), i, i2);
        }
        if (obj instanceof java.lang.Long) {
            return cursorWindow.putLong(((java.lang.Long) obj).longValue(), i, i2);
        }
        if (obj instanceof java.lang.Float) {
            return cursorWindow.putDouble(((java.lang.Float) obj).floatValue(), i, i2);
        }
        if (obj instanceof java.lang.Double) {
            return cursorWindow.putDouble(((java.lang.Double) obj).doubleValue(), i, i2);
        }
        if (obj instanceof java.lang.String) {
            return cursorWindow.putString((java.lang.String) obj, i, i2);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i, i2);
        }
        throw new java.lang.IllegalArgumentException("unsupported type for column: " + obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.mClosed) {
            for (android.database.CursorWindow cursorWindow : this.cursorWindows) {
                cursorWindow.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new android.os.Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = this.columns;
            if (i2 >= strArr.length) {
                break;
            }
            this.columnsBundle.putInt(strArr[i2], i2);
            i2++;
        }
        this.perCursorCounts = new int[this.cursorWindows.length];
        int i3 = 0;
        while (true) {
            android.database.CursorWindow[] cursorWindowArr = this.cursorWindows;
            if (i >= cursorWindowArr.length) {
                this.dataCount = i3;
                return;
            } else {
                this.perCursorCounts[i] = i3;
                i3 = cursorWindowArr[i].getStartPosition() + this.cursorWindows[i].getNumRows();
                i++;
            }
        }
    }

    public final void copyToBuffer(java.lang.String str, int i, int i2, android.database.CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i);
        this.cursorWindows[i2].copyStringToBuffer(i, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    public final void finalize() throws java.lang.Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final android.os.Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final java.lang.Object getValue(java.lang.String str, int i, int i2, java.lang.String str2) {
        str2.hashCode();
        switch (str2) {
            case "type_float":
                checkAvailable(str, i);
                return java.lang.Float.valueOf(this.cursorWindows[i2].getFloat(i, this.columnsBundle.getInt(str)));
            case "type_boolean":
                checkAvailable(str, i);
                return java.lang.Boolean.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)) == 1);
            case "type_int":
                checkAvailable(str, i);
                return java.lang.Integer.valueOf(this.cursorWindows[i2].getInt(i, this.columnsBundle.getInt(str)));
            case "type_double":
                checkAvailable(str, i);
                return java.lang.Double.valueOf(this.cursorWindows[i2].getDouble(i, this.columnsBundle.getInt(str)));
            case "type_long":
                checkAvailable(str, i);
                return java.lang.Long.valueOf(this.cursorWindows[i2].getLong(i, this.columnsBundle.getInt(str)));
            case "type_string":
                checkAvailable(str, i);
                return this.cursorWindows[i2].getString(i, this.columnsBundle.getInt(str));
            case "type_byte_array":
                checkAvailable(str, i);
                return this.cursorWindows[i2].getBlob(i, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i) {
        int[] iArr;
        int i2 = 0;
        com.huawei.hms.common.internal.Preconditions.checkArgument(i >= 0 || i < this.dataCount, "rowIndex is out of index:" + i);
        while (true) {
            iArr = this.perCursorCounts;
            if (i2 >= iArr.length) {
                break;
            }
            if (i < iArr[i2]) {
                i2--;
                break;
            }
            i2++;
        }
        return i2 == iArr.length ? i2 - 1 : i2;
    }

    public final boolean hasColumn(java.lang.String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(java.lang.String str, int i, int i2) {
        checkAvailable(str, i);
        return this.cursorWindows[i2].getType(i, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        int beginObjectHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.beginObjectHeader(parcel);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i, false);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.writeInt(parcel, 1000, this.version);
        com.huawei.hms.common.internal.safeparcel.SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            close();
        }
    }
}
