package androidx.core.view;

/* loaded from: classes.dex */
public final class DragAndDropPermissionsCompat {
    private java.lang.Object mDragAndDropPermissions;

    private DragAndDropPermissionsCompat(java.lang.Object obj) {
        this.mDragAndDropPermissions = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r2 = r2.requestDragAndDropPermissions(r3);
     */
    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static androidx.core.view.DragAndDropPermissionsCompat request(android.app.Activity activity, android.view.DragEvent dragEvent) {
        android.view.DragAndDropPermissions requestDragAndDropPermissions;
        if (android.os.Build.VERSION.SDK_INT < 24 || requestDragAndDropPermissions == null) {
            return null;
        }
        return new androidx.core.view.DragAndDropPermissionsCompat(requestDragAndDropPermissions);
    }

    public void release() {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            ((android.view.DragAndDropPermissions) this.mDragAndDropPermissions).release();
        }
    }
}
