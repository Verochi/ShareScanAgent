package androidx.appcompat.view;

/* loaded from: classes.dex */
public abstract class ActionMode {
    private java.lang.Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(androidx.appcompat.view.ActionMode actionMode, android.view.MenuItem menuItem);

        boolean onCreateActionMode(androidx.appcompat.view.ActionMode actionMode, android.view.Menu menu);

        void onDestroyActionMode(androidx.appcompat.view.ActionMode actionMode);

        boolean onPrepareActionMode(androidx.appcompat.view.ActionMode actionMode, android.view.Menu menu);
    }

    public abstract void finish();

    public abstract android.view.View getCustomView();

    public abstract android.view.Menu getMenu();

    public abstract android.view.MenuInflater getMenuInflater();

    public abstract java.lang.CharSequence getSubtitle();

    public java.lang.Object getTag() {
        return this.mTag;
    }

    public abstract java.lang.CharSequence getTitle();

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(android.view.View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(java.lang.CharSequence charSequence);

    public void setTag(java.lang.Object obj) {
        this.mTag = obj;
    }

    public abstract void setTitle(int i);

    public abstract void setTitle(java.lang.CharSequence charSequence);

    public void setTitleOptionalHint(boolean z) {
        this.mTitleOptionalHint = z;
    }
}
