package androidx.lifecycle;

/* loaded from: classes.dex */
public final class SavedStateHandle {
    private static final java.lang.Class[] ACCEPTABLE_CLASSES = {java.lang.Boolean.TYPE, boolean[].class, java.lang.Double.TYPE, double[].class, java.lang.Integer.TYPE, int[].class, java.lang.Long.TYPE, long[].class, java.lang.String.class, java.lang.String[].class, android.os.Binder.class, android.os.Bundle.class, java.lang.Byte.TYPE, byte[].class, java.lang.Character.TYPE, char[].class, java.lang.CharSequence.class, java.lang.CharSequence[].class, java.util.ArrayList.class, java.lang.Float.TYPE, float[].class, android.os.Parcelable.class, android.os.Parcelable[].class, java.io.Serializable.class, java.lang.Short.TYPE, short[].class, android.util.SparseArray.class, android.util.Size.class, android.util.SizeF.class};
    private static final java.lang.String KEYS = "keys";
    private static final java.lang.String VALUES = "values";
    private final java.util.Map<java.lang.String, androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?>> mLiveDatas;
    final java.util.Map<java.lang.String, java.lang.Object> mRegular;
    private final androidx.savedstate.SavedStateRegistry.SavedStateProvider mSavedStateProvider;
    final java.util.Map<java.lang.String, androidx.savedstate.SavedStateRegistry.SavedStateProvider> mSavedStateProviders;

    /* renamed from: androidx.lifecycle.SavedStateHandle$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {
        public AnonymousClass1() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @androidx.annotation.NonNull
        public android.os.Bundle saveState() {
            for (java.util.Map.Entry entry : new java.util.HashMap(androidx.lifecycle.SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                androidx.lifecycle.SavedStateHandle.this.set((java.lang.String) entry.getKey(), ((androidx.savedstate.SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
            java.util.Set<java.lang.String> keySet = androidx.lifecycle.SavedStateHandle.this.mRegular.keySet();
            java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>(keySet.size());
            java.util.ArrayList<? extends android.os.Parcelable> arrayList2 = new java.util.ArrayList<>(arrayList.size());
            for (java.lang.String str : keySet) {
                arrayList.add(str);
                arrayList2.add(androidx.lifecycle.SavedStateHandle.this.mRegular.get(str));
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelableArrayList(androidx.lifecycle.SavedStateHandle.KEYS, arrayList);
            bundle.putParcelableArrayList(androidx.lifecycle.SavedStateHandle.VALUES, arrayList2);
            return bundle;
        }
    }

    public static class SavingStateLiveData<T> extends androidx.lifecycle.MutableLiveData<T> {
        private androidx.lifecycle.SavedStateHandle mHandle;
        private java.lang.String mKey;

        public SavingStateLiveData(androidx.lifecycle.SavedStateHandle savedStateHandle, java.lang.String str) {
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }

        public SavingStateLiveData(androidx.lifecycle.SavedStateHandle savedStateHandle, java.lang.String str, T t) {
            super(t);
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }

        public void detach() {
            this.mHandle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t) {
            androidx.lifecycle.SavedStateHandle savedStateHandle = this.mHandle;
            if (savedStateHandle != null) {
                savedStateHandle.mRegular.put(this.mKey, t);
            }
            super.setValue(t);
        }
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new java.util.HashMap();
        this.mLiveDatas = new java.util.HashMap();
        this.mSavedStateProvider = new androidx.lifecycle.SavedStateHandle.AnonymousClass1();
        this.mRegular = new java.util.HashMap();
    }

    public SavedStateHandle(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.Object> map) {
        this.mSavedStateProviders = new java.util.HashMap();
        this.mLiveDatas = new java.util.HashMap();
        this.mSavedStateProvider = new androidx.lifecycle.SavedStateHandle.AnonymousClass1();
        this.mRegular = new java.util.HashMap(map);
    }

    public static androidx.lifecycle.SavedStateHandle createHandle(@androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.Nullable android.os.Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new androidx.lifecycle.SavedStateHandle();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        if (bundle2 != null) {
            for (java.lang.String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new androidx.lifecycle.SavedStateHandle(hashMap);
        }
        java.util.ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEYS);
        java.util.ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(VALUES);
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new java.lang.IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            hashMap.put((java.lang.String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
        }
        return new androidx.lifecycle.SavedStateHandle(hashMap);
    }

    @androidx.annotation.NonNull
    private <T> androidx.lifecycle.MutableLiveData<T> getLiveDataInternal(@androidx.annotation.NonNull java.lang.String str, boolean z, @androidx.annotation.Nullable T t) {
        androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
        if (savingStateLiveData != null) {
            return savingStateLiveData;
        }
        androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?> savingStateLiveData2 = this.mRegular.containsKey(str) ? new androidx.lifecycle.SavedStateHandle.SavingStateLiveData<>(this, str, this.mRegular.get(str)) : z ? new androidx.lifecycle.SavedStateHandle.SavingStateLiveData<>(this, str, t) : new androidx.lifecycle.SavedStateHandle.SavingStateLiveData<>(this, str);
        this.mLiveDatas.put(str, savingStateLiveData2);
        return savingStateLiveData2;
    }

    private static void validateValue(java.lang.Object obj) {
        if (obj == null) {
            return;
        }
        for (java.lang.Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new java.lang.IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    @androidx.annotation.MainThread
    public void clearSavedStateProvider(@androidx.annotation.NonNull java.lang.String str) {
        this.mSavedStateProviders.remove(str);
    }

    @androidx.annotation.MainThread
    public boolean contains(@androidx.annotation.NonNull java.lang.String str) {
        return this.mRegular.containsKey(str);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public <T> T get(@androidx.annotation.NonNull java.lang.String str) {
        return (T) this.mRegular.get(str);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public <T> androidx.lifecycle.MutableLiveData<T> getLiveData(@androidx.annotation.NonNull java.lang.String str) {
        return getLiveDataInternal(str, false, null);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public <T> androidx.lifecycle.MutableLiveData<T> getLiveData(@androidx.annotation.NonNull java.lang.String str, @android.annotation.SuppressLint({"UnknownNullness"}) T t) {
        return getLiveDataInternal(str, true, t);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.MainThread
    public java.util.Set<java.lang.String> keys() {
        java.util.HashSet hashSet = new java.util.HashSet(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    @androidx.annotation.Nullable
    @androidx.annotation.MainThread
    public <T> T remove(@androidx.annotation.NonNull java.lang.String str) {
        T t = (T) this.mRegular.remove(str);
        androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?> remove = this.mLiveDatas.remove(str);
        if (remove != null) {
            remove.detach();
        }
        return t;
    }

    @androidx.annotation.NonNull
    public androidx.savedstate.SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    @androidx.annotation.MainThread
    public <T> void set(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable T t) {
        validateValue(t);
        androidx.lifecycle.SavedStateHandle.SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
        if (savingStateLiveData != null) {
            savingStateLiveData.setValue(t);
        } else {
            this.mRegular.put(str, t);
        }
    }

    @androidx.annotation.MainThread
    public void setSavedStateProvider(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.savedstate.SavedStateRegistry.SavedStateProvider savedStateProvider) {
        this.mSavedStateProviders.put(str, savedStateProvider);
    }
}
