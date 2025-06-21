package com.huawei.hms.common.sqlite;

/* loaded from: classes22.dex */
public class HMSCursorWrapper extends android.database.CursorWrapper implements android.database.CrossProcessCursor {
    private android.database.AbstractWindowedCursor mCursor;

    public HMSCursorWrapper(android.database.Cursor cursor) {
        super(cursor);
        if (cursor == null) {
            throw new java.lang.IllegalArgumentException("cursor cannot be null");
        }
        if (!(cursor instanceof android.database.CursorWrapper)) {
            throw new java.lang.IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
        android.database.Cursor wrappedCursor = ((android.database.CursorWrapper) cursor).getWrappedCursor();
        if (wrappedCursor == null) {
            throw new java.lang.IllegalArgumentException("getWrappedCursor cannot be null");
        }
        if (wrappedCursor instanceof android.database.AbstractWindowedCursor) {
            this.mCursor = (android.database.AbstractWindowedCursor) wrappedCursor;
            return;
        }
        throw new java.lang.IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        this.mCursor.fillWindow(i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public android.database.CursorWindow getWindow() {
        return this.mCursor.getWindow();
    }

    @Override // android.database.CursorWrapper
    public android.database.Cursor getWrappedCursor() {
        return this.mCursor;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return this.mCursor.onMove(i, i2);
    }

    public void setWindow(android.database.CursorWindow cursorWindow) {
        this.mCursor.setWindow(cursorWindow);
    }
}
