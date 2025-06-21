package androidx.lifecycle;

/* loaded from: classes.dex */
public class ViewModelStore {
    private final java.util.HashMap<java.lang.String, androidx.lifecycle.ViewModel> mMap = new java.util.HashMap<>();

    public final void clear() {
        java.util.Iterator<androidx.lifecycle.ViewModel> it = this.mMap.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.mMap.clear();
    }

    public final androidx.lifecycle.ViewModel get(java.lang.String str) {
        return this.mMap.get(str);
    }

    public java.util.Set<java.lang.String> keys() {
        return new java.util.HashSet(this.mMap.keySet());
    }

    public final void put(java.lang.String str, androidx.lifecycle.ViewModel viewModel) {
        androidx.lifecycle.ViewModel put = this.mMap.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
