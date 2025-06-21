package androidx.savedstate;

@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
final class Recreator implements androidx.lifecycle.GenericLifecycleObserver {
    static final java.lang.String CLASSES_KEY = "classes_to_restore";
    static final java.lang.String COMPONENT_KEY = "androidx.savedstate.Restarter";
    private final androidx.savedstate.SavedStateRegistryOwner mOwner;

    public static final class SavedStateProvider implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {
        final java.util.Set<java.lang.String> mClasses = new java.util.HashSet();

        public SavedStateProvider(androidx.savedstate.SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.registerSavedStateProvider(androidx.savedstate.Recreator.COMPONENT_KEY, this);
        }

        public void add(java.lang.String str) {
            this.mClasses.add(str);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        @androidx.annotation.NonNull
        public android.os.Bundle saveState() {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putStringArrayList(androidx.savedstate.Recreator.CLASSES_KEY, new java.util.ArrayList<>(this.mClasses));
            return bundle;
        }
    }

    public Recreator(androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner) {
        this.mOwner = savedStateRegistryOwner;
    }

    private void reflectiveNew(java.lang.String str) {
        try {
            java.lang.Class<? extends U> asSubclass = java.lang.Class.forName(str, false, androidx.savedstate.Recreator.class.getClassLoader()).asSubclass(androidx.savedstate.SavedStateRegistry.AutoRecreated.class);
            try {
                java.lang.reflect.Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new java.lang.Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((androidx.savedstate.SavedStateRegistry.AutoRecreated) declaredConstructor.newInstance(new java.lang.Object[0])).onRecreated(this.mOwner);
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException("Failed to instantiate " + str, e);
                }
            } catch (java.lang.NoSuchMethodException e2) {
                throw new java.lang.IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (java.lang.ClassNotFoundException e3) {
            throw new java.lang.RuntimeException("Class " + str + " wasn't found", e3);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Lifecycle.Event event) {
        if (event != androidx.lifecycle.Lifecycle.Event.ON_CREATE) {
            throw new java.lang.AssertionError("Next event must be ON_CREATE");
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        android.os.Bundle consumeRestoredStateForKey = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (consumeRestoredStateForKey == null) {
            return;
        }
        java.util.ArrayList<java.lang.String> stringArrayList = consumeRestoredStateForKey.getStringArrayList(CLASSES_KEY);
        if (stringArrayList == null) {
            throw new java.lang.IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        java.util.Iterator<java.lang.String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            reflectiveNew(it.next());
        }
    }
}
