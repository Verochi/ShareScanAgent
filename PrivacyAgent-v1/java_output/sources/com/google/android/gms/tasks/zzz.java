package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzz implements com.google.android.gms.tasks.Continuation<java.lang.Void, com.google.android.gms.tasks.Task<java.util.List<com.google.android.gms.tasks.Task<?>>>> {
    public final /* synthetic */ java.util.Collection a;

    public zzz(java.util.Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ com.google.android.gms.tasks.Task<java.util.List<com.google.android.gms.tasks.Task<?>>> then(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<java.lang.Void> task) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(this.a);
        return com.google.android.gms.tasks.Tasks.forResult(arrayList);
    }
}
