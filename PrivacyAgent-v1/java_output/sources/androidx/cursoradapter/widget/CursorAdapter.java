package androidx.cursoradapter.widget;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends android.widget.BaseAdapter implements android.widget.Filterable, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient {

    @java.lang.Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mAutoRequery;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected androidx.cursoradapter.widget.CursorAdapter.ChangeObserver mChangeObserver;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected android.content.Context mContext;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected android.database.Cursor mCursor;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected androidx.cursoradapter.widget.CursorFilter mCursorFilter;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected android.database.DataSetObserver mDataSetObserver;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mDataValid;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected android.widget.FilterQueryProvider mFilterQueryProvider;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected int mRowIDColumn;

    public class ChangeObserver extends android.database.ContentObserver {
        public ChangeObserver() {
            super(new android.os.Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            androidx.cursoradapter.widget.CursorAdapter.this.onContentChanged();
        }
    }

    public class MyDataSetObserver extends android.database.DataSetObserver {
        public MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            androidx.cursoradapter.widget.CursorAdapter cursorAdapter = androidx.cursoradapter.widget.CursorAdapter.this;
            cursorAdapter.mDataValid = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            androidx.cursoradapter.widget.CursorAdapter cursorAdapter = androidx.cursoradapter.widget.CursorAdapter.this;
            cursorAdapter.mDataValid = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    @java.lang.Deprecated
    public CursorAdapter(android.content.Context context, android.database.Cursor cursor) {
        init(context, cursor, 1);
    }

    public CursorAdapter(android.content.Context context, android.database.Cursor cursor, int i) {
        init(context, cursor, i);
    }

    public CursorAdapter(android.content.Context context, android.database.Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public abstract void bindView(android.view.View view, android.content.Context context, android.database.Cursor cursor);

    public void changeCursor(android.database.Cursor cursor) {
        android.database.Cursor swapCursor = swapCursor(cursor);
        if (swapCursor != null) {
            swapCursor.close();
        }
    }

    public java.lang.CharSequence convertToString(android.database.Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        android.database.Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public android.database.Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public android.view.View getDropDownView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.mCursor, viewGroup);
        }
        bindView(view, this.mContext, this.mCursor);
        return view;
    }

    @Override // android.widget.Filterable
    public android.widget.Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new androidx.cursoradapter.widget.CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public android.widget.FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        android.database.Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.mCursor;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        android.database.Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null && cursor.moveToPosition(i)) {
            return this.mCursor.getLong(this.mRowIDColumn);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new java.lang.IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.mCursor.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.mCursor, viewGroup);
            }
            bindView(view, this.mContext, this.mCursor);
            return view;
        }
        throw new java.lang.IllegalStateException("couldn't move cursor to position " + i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public void init(android.content.Context context, android.database.Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.mAutoRequery = true;
        } else {
            this.mAutoRequery = false;
        }
        boolean z = cursor != null;
        this.mCursor = cursor;
        this.mDataValid = z;
        this.mContext = context;
        this.mRowIDColumn = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.mChangeObserver = new androidx.cursoradapter.widget.CursorAdapter.ChangeObserver();
            this.mDataSetObserver = new androidx.cursoradapter.widget.CursorAdapter.MyDataSetObserver();
        } else {
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (z) {
            androidx.cursoradapter.widget.CursorAdapter.ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor.registerContentObserver(changeObserver);
            }
            android.database.DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @java.lang.Deprecated
    public void init(android.content.Context context, android.database.Cursor cursor, boolean z) {
        init(context, cursor, z ? 1 : 2);
    }

    public android.view.View newDropDownView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public abstract android.view.View newView(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup);

    public void onContentChanged() {
        android.database.Cursor cursor;
        if (!this.mAutoRequery || (cursor = this.mCursor) == null || cursor.isClosed()) {
            return;
        }
        this.mDataValid = this.mCursor.requery();
    }

    public android.database.Cursor runQueryOnBackgroundThread(java.lang.CharSequence charSequence) {
        android.widget.FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.mCursor;
    }

    public void setFilterQueryProvider(android.widget.FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public android.database.Cursor swapCursor(android.database.Cursor cursor) {
        android.database.Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            androidx.cursoradapter.widget.CursorAdapter.ChangeObserver changeObserver = this.mChangeObserver;
            if (changeObserver != null) {
                cursor2.unregisterContentObserver(changeObserver);
            }
            android.database.DataSetObserver dataSetObserver = this.mDataSetObserver;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            androidx.cursoradapter.widget.CursorAdapter.ChangeObserver changeObserver2 = this.mChangeObserver;
            if (changeObserver2 != null) {
                cursor.registerContentObserver(changeObserver2);
            }
            android.database.DataSetObserver dataSetObserver2 = this.mDataSetObserver;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            this.mDataValid = true;
            notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            this.mDataValid = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
