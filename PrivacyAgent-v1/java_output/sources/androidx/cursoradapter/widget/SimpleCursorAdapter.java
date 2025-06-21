package androidx.cursoradapter.widget;

/* loaded from: classes.dex */
public class SimpleCursorAdapter extends androidx.cursoradapter.widget.ResourceCursorAdapter {
    private androidx.cursoradapter.widget.SimpleCursorAdapter.CursorToStringConverter mCursorToStringConverter;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mFrom;
    java.lang.String[] mOriginalFrom;
    private int mStringConversionColumn;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected int[] mTo;
    private androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder mViewBinder;

    public interface CursorToStringConverter {
        java.lang.CharSequence convertToString(android.database.Cursor cursor);
    }

    public interface ViewBinder {
        boolean setViewValue(android.view.View view, android.database.Cursor cursor, int i);
    }

    @java.lang.Deprecated
    public SimpleCursorAdapter(android.content.Context context, int i, android.database.Cursor cursor, java.lang.String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    public SimpleCursorAdapter(android.content.Context context, int i, android.database.Cursor cursor, java.lang.String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.mStringConversionColumn = -1;
        this.mTo = iArr;
        this.mOriginalFrom = strArr;
        findColumns(cursor, strArr);
    }

    private void findColumns(android.database.Cursor cursor, java.lang.String[] strArr) {
        if (cursor == null) {
            this.mFrom = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.mFrom;
        if (iArr == null || iArr.length != length) {
            this.mFrom = new int[length];
        }
        for (int i = 0; i < length; i++) {
            this.mFrom[i] = cursor.getColumnIndexOrThrow(strArr[i]);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor) {
        androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder viewBinder = this.mViewBinder;
        int[] iArr = this.mTo;
        int length = iArr.length;
        int[] iArr2 = this.mFrom;
        for (int i = 0; i < length; i++) {
            android.view.View findViewById = view.findViewById(iArr[i]);
            if (findViewById != null) {
                if (viewBinder != null ? viewBinder.setViewValue(findViewById, cursor, iArr2[i]) : false) {
                    continue;
                } else {
                    java.lang.String string = cursor.getString(iArr2[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof android.widget.TextView) {
                        setViewText((android.widget.TextView) findViewById, string);
                    } else {
                        if (!(findViewById instanceof android.widget.ImageView)) {
                            throw new java.lang.IllegalStateException(findViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        setViewImage((android.widget.ImageView) findViewById, string);
                    }
                }
            }
        }
    }

    public void changeCursorAndColumns(android.database.Cursor cursor, java.lang.String[] strArr, int[] iArr) {
        this.mOriginalFrom = strArr;
        this.mTo = iArr;
        findColumns(cursor, strArr);
        super.changeCursor(cursor);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public java.lang.CharSequence convertToString(android.database.Cursor cursor) {
        androidx.cursoradapter.widget.SimpleCursorAdapter.CursorToStringConverter cursorToStringConverter = this.mCursorToStringConverter;
        if (cursorToStringConverter != null) {
            return cursorToStringConverter.convertToString(cursor);
        }
        int i = this.mStringConversionColumn;
        return i > -1 ? cursor.getString(i) : super.convertToString(cursor);
    }

    public androidx.cursoradapter.widget.SimpleCursorAdapter.CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(androidx.cursoradapter.widget.SimpleCursorAdapter.CursorToStringConverter cursorToStringConverter) {
        this.mCursorToStringConverter = cursorToStringConverter;
    }

    public void setStringConversionColumn(int i) {
        this.mStringConversionColumn = i;
    }

    public void setViewBinder(androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder viewBinder) {
        this.mViewBinder = viewBinder;
    }

    public void setViewImage(android.widget.ImageView imageView, java.lang.String str) {
        try {
            imageView.setImageResource(java.lang.Integer.parseInt(str));
        } catch (java.lang.NumberFormatException unused) {
            imageView.setImageURI(android.net.Uri.parse(str));
        }
    }

    public void setViewText(android.widget.TextView textView, java.lang.String str) {
        textView.setText(str);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public android.database.Cursor swapCursor(android.database.Cursor cursor) {
        findColumns(cursor, this.mOriginalFrom);
        return super.swapCursor(cursor);
    }
}
