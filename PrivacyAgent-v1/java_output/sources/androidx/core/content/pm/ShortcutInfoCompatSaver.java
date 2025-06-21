package androidx.core.content.pm;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ShortcutInfoCompatSaver<T> {

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static class NoopImpl extends androidx.core.content.pm.ShortcutInfoCompatSaver<java.lang.Void> {
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ java.lang.Void addShortcuts(java.util.List list) {
            return addShortcuts2((java.util.List<androidx.core.content.pm.ShortcutInfoCompat>) list);
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: addShortcuts, reason: avoid collision after fix types in other method */
        public java.lang.Void addShortcuts2(java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list) {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public java.lang.Void removeAllShortcuts() {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public /* bridge */ /* synthetic */ java.lang.Void removeShortcuts(java.util.List list) {
            return removeShortcuts2((java.util.List<java.lang.String>) list);
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: removeShortcuts, reason: avoid collision after fix types in other method */
        public java.lang.Void removeShortcuts2(java.util.List<java.lang.String> list) {
            return null;
        }
    }

    @androidx.annotation.AnyThread
    public abstract T addShortcuts(java.util.List<androidx.core.content.pm.ShortcutInfoCompat> list);

    @androidx.annotation.WorkerThread
    public java.util.List<androidx.core.content.pm.ShortcutInfoCompat> getShortcuts() throws java.lang.Exception {
        return new java.util.ArrayList();
    }

    @androidx.annotation.AnyThread
    public abstract T removeAllShortcuts();

    @androidx.annotation.AnyThread
    public abstract T removeShortcuts(java.util.List<java.lang.String> list);
}
