package androidx.loader.content;

/* loaded from: classes.dex */
public class Loader<D> {
    android.content.Context mContext;
    int mId;
    androidx.loader.content.Loader.OnLoadCompleteListener<D> mListener;
    androidx.loader.content.Loader.OnLoadCanceledListener<D> mOnLoadCanceledListener;
    boolean mStarted = false;
    boolean mAbandoned = false;
    boolean mReset = true;
    boolean mContentChanged = false;
    boolean mProcessingChange = false;

    public final class ForceLoadContentObserver extends android.database.ContentObserver {
        public ForceLoadContentObserver() {
            super(new android.os.Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            androidx.loader.content.Loader.this.onContentChanged();
        }
    }

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@androidx.annotation.NonNull androidx.loader.content.Loader<D> loader, @androidx.annotation.Nullable D d);
    }

    public Loader(@androidx.annotation.NonNull android.content.Context context) {
        this.mContext = context.getApplicationContext();
    }

    @androidx.annotation.MainThread
    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    @androidx.annotation.MainThread
    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    @androidx.annotation.NonNull
    public java.lang.String dataToString(@androidx.annotation.Nullable D d) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        androidx.core.util.DebugUtils.buildShortClassTag(d, sb);
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @androidx.annotation.MainThread
    public void deliverCancellation() {
        androidx.loader.content.Loader.OnLoadCanceledListener<D> onLoadCanceledListener = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener != null) {
            onLoadCanceledListener.onLoadCanceled(this);
        }
    }

    @androidx.annotation.MainThread
    public void deliverResult(@androidx.annotation.Nullable D d) {
        androidx.loader.content.Loader.OnLoadCompleteListener<D> onLoadCompleteListener = this.mListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.onLoadComplete(this, d);
        }
    }

    @java.lang.Deprecated
    public void dump(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }

    @androidx.annotation.MainThread
    public void forceLoad() {
        onForceLoad();
    }

    @androidx.annotation.NonNull
    public android.content.Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    @androidx.annotation.MainThread
    public void onAbandon() {
    }

    @androidx.annotation.MainThread
    public boolean onCancelLoad() {
        return false;
    }

    @androidx.annotation.MainThread
    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    @androidx.annotation.MainThread
    public void onForceLoad() {
    }

    @androidx.annotation.MainThread
    public void onReset() {
    }

    @androidx.annotation.MainThread
    public void onStartLoading() {
    }

    @androidx.annotation.MainThread
    public void onStopLoading() {
    }

    @androidx.annotation.MainThread
    public void registerListener(int i, @androidx.annotation.NonNull androidx.loader.content.Loader.OnLoadCompleteListener<D> onLoadCompleteListener) {
        if (this.mListener != null) {
            throw new java.lang.IllegalStateException("There is already a listener registered");
        }
        this.mListener = onLoadCompleteListener;
        this.mId = i;
    }

    @androidx.annotation.MainThread
    public void registerOnLoadCanceledListener(@androidx.annotation.NonNull androidx.loader.content.Loader.OnLoadCanceledListener<D> onLoadCanceledListener) {
        if (this.mOnLoadCanceledListener != null) {
            throw new java.lang.IllegalStateException("There is already a listener registered");
        }
        this.mOnLoadCanceledListener = onLoadCanceledListener;
    }

    @androidx.annotation.MainThread
    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    @androidx.annotation.MainThread
    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    @androidx.annotation.MainThread
    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        androidx.core.util.DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @androidx.annotation.MainThread
    public void unregisterListener(@androidx.annotation.NonNull androidx.loader.content.Loader.OnLoadCompleteListener<D> onLoadCompleteListener) {
        androidx.loader.content.Loader.OnLoadCompleteListener<D> onLoadCompleteListener2 = this.mListener;
        if (onLoadCompleteListener2 == null) {
            throw new java.lang.IllegalStateException("No listener register");
        }
        if (onLoadCompleteListener2 != onLoadCompleteListener) {
            throw new java.lang.IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mListener = null;
    }

    @androidx.annotation.MainThread
    public void unregisterOnLoadCanceledListener(@androidx.annotation.NonNull androidx.loader.content.Loader.OnLoadCanceledListener<D> onLoadCanceledListener) {
        androidx.loader.content.Loader.OnLoadCanceledListener<D> onLoadCanceledListener2 = this.mOnLoadCanceledListener;
        if (onLoadCanceledListener2 == null) {
            throw new java.lang.IllegalStateException("No listener register");
        }
        if (onLoadCanceledListener2 != onLoadCanceledListener) {
            throw new java.lang.IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.mOnLoadCanceledListener = null;
    }
}
