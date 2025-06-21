package androidx.loader.content;

/* loaded from: classes.dex */
public class CursorLoader extends androidx.loader.content.AsyncTaskLoader<android.database.Cursor> {
    androidx.core.os.CancellationSignal mCancellationSignal;
    android.database.Cursor mCursor;
    final androidx.loader.content.Loader<android.database.Cursor>.ForceLoadContentObserver mObserver;
    java.lang.String[] mProjection;
    java.lang.String mSelection;
    java.lang.String[] mSelectionArgs;
    java.lang.String mSortOrder;
    android.net.Uri mUri;

    public CursorLoader(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.mObserver = new androidx.loader.content.Loader.ForceLoadContentObserver();
    }

    public CursorLoader(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        super(context);
        this.mObserver = new androidx.loader.content.Loader.ForceLoadContentObserver();
        this.mUri = uri;
        this.mProjection = strArr;
        this.mSelection = str;
        this.mSelectionArgs = strArr2;
        this.mSortOrder = str2;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            androidx.core.os.CancellationSignal cancellationSignal = this.mCancellationSignal;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
        }
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(android.database.Cursor cursor) {
        if (isReset()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        android.database.Cursor cursor2 = this.mCursor;
        this.mCursor = cursor;
        if (isStarted()) {
            super.deliverResult((androidx.loader.content.CursorLoader) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    @java.lang.Deprecated
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.mUri);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(java.util.Arrays.toString(this.mProjection));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.mSelection);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(java.util.Arrays.toString(this.mSelectionArgs));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.mSortOrder);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.mCursor);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }

    @androidx.annotation.Nullable
    public java.lang.String[] getProjection() {
        return this.mProjection;
    }

    @androidx.annotation.Nullable
    public java.lang.String getSelection() {
        return this.mSelection;
    }

    @androidx.annotation.Nullable
    public java.lang.String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    @androidx.annotation.Nullable
    public java.lang.String getSortOrder() {
        return this.mSortOrder;
    }

    @androidx.annotation.NonNull
    public android.net.Uri getUri() {
        return this.mUri;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public android.database.Cursor loadInBackground() {
        synchronized (this) {
            if (isLoadInBackgroundCanceled()) {
                throw new androidx.core.os.OperationCanceledException();
            }
            this.mCancellationSignal = new androidx.core.os.CancellationSignal();
        }
        try {
            android.database.Cursor query = androidx.core.content.ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);
            if (query != null) {
                try {
                    query.getCount();
                    query.registerContentObserver(this.mObserver);
                } catch (java.lang.RuntimeException e) {
                    query.close();
                    throw e;
                }
            }
            synchronized (this) {
                this.mCancellationSignal = null;
            }
            return query;
        } catch (java.lang.Throwable th) {
            synchronized (this) {
                this.mCancellationSignal = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(android.database.Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        android.database.Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            this.mCursor.close();
        }
        this.mCursor = null;
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        android.database.Cursor cursor = this.mCursor;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.mCursor == null) {
            forceLoad();
        }
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    public void setProjection(@androidx.annotation.Nullable java.lang.String[] strArr) {
        this.mProjection = strArr;
    }

    public void setSelection(@androidx.annotation.Nullable java.lang.String str) {
        this.mSelection = str;
    }

    public void setSelectionArgs(@androidx.annotation.Nullable java.lang.String[] strArr) {
        this.mSelectionArgs = strArr;
    }

    public void setSortOrder(@androidx.annotation.Nullable java.lang.String str) {
        this.mSortOrder = str;
    }

    public void setUri(@androidx.annotation.NonNull android.net.Uri uri) {
        this.mUri = uri;
    }
}
