package com.google.android.gms.tasks;

/* loaded from: classes22.dex */
final class zzaa implements com.google.android.gms.tasks.Continuation {
    public final /* synthetic */ java.util.Collection a;

    public zzaa(java.util.Collection collection) {
        this.a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ java.lang.Object then(@androidx.annotation.NonNull com.google.android.gms.tasks.Task task) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.google.android.gms.tasks.Task) it.next()).getResult());
        }
        return arrayList;
    }
}
