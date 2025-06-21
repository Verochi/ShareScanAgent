package androidx.activity.result;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    private static final int INITIAL_REQUEST_CODE_VALUE = 65536;
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final java.lang.String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final java.lang.String LOG_TAG = "ActivityResultRegistry";
    private java.util.Random mRandom = new java.util.Random();
    private final java.util.Map<java.lang.Integer, java.lang.String> mRcToKey = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Integer> mKeyToRc = new java.util.HashMap();
    private final java.util.Map<java.lang.String, androidx.activity.result.ActivityResultRegistry.LifecycleContainer> mKeyToLifecycleContainers = new java.util.HashMap();
    java.util.ArrayList<java.lang.String> mLaunchedKeys = new java.util.ArrayList<>();
    final transient java.util.Map<java.lang.String, androidx.activity.result.ActivityResultRegistry.CallbackAndContract<?>> mKeyToCallback = new java.util.HashMap();
    final java.util.Map<java.lang.String, java.lang.Object> mParsedPendingResults = new java.util.HashMap();
    final android.os.Bundle mPendingResults = new android.os.Bundle();

    /* renamed from: androidx.activity.result.ActivityResultRegistry$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.lifecycle.LifecycleEventObserver {
        final /* synthetic */ androidx.activity.result.ActivityResultCallback val$callback;
        final /* synthetic */ androidx.activity.result.contract.ActivityResultContract val$contract;
        final /* synthetic */ java.lang.String val$key;

        public AnonymousClass1(java.lang.String str, androidx.activity.result.ActivityResultCallback activityResultCallback, androidx.activity.result.contract.ActivityResultContract activityResultContract) {
            this.val$key = str;
            this.val$callback = activityResultCallback;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            if (!androidx.lifecycle.Lifecycle.Event.ON_START.equals(event)) {
                if (androidx.lifecycle.Lifecycle.Event.ON_STOP.equals(event)) {
                    androidx.activity.result.ActivityResultRegistry.this.mKeyToCallback.remove(this.val$key);
                    return;
                } else {
                    if (androidx.lifecycle.Lifecycle.Event.ON_DESTROY.equals(event)) {
                        androidx.activity.result.ActivityResultRegistry.this.unregister(this.val$key);
                        return;
                    }
                    return;
                }
            }
            androidx.activity.result.ActivityResultRegistry.this.mKeyToCallback.put(this.val$key, new androidx.activity.result.ActivityResultRegistry.CallbackAndContract<>(this.val$callback, this.val$contract));
            if (androidx.activity.result.ActivityResultRegistry.this.mParsedPendingResults.containsKey(this.val$key)) {
                java.lang.Object obj = androidx.activity.result.ActivityResultRegistry.this.mParsedPendingResults.get(this.val$key);
                androidx.activity.result.ActivityResultRegistry.this.mParsedPendingResults.remove(this.val$key);
                this.val$callback.onActivityResult(obj);
            }
            androidx.activity.result.ActivityResult activityResult = (androidx.activity.result.ActivityResult) androidx.activity.result.ActivityResultRegistry.this.mPendingResults.getParcelable(this.val$key);
            if (activityResult != null) {
                androidx.activity.result.ActivityResultRegistry.this.mPendingResults.remove(this.val$key);
                this.val$callback.onActivityResult(this.val$contract.parseResult(activityResult.getResultCode(), activityResult.getData()));
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: androidx.activity.result.ActivityResultRegistry$2, reason: invalid class name */
    public class AnonymousClass2<I> extends androidx.activity.result.ActivityResultLauncher<I> {
        final /* synthetic */ androidx.activity.result.contract.ActivityResultContract val$contract;
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ int val$requestCode;

        public AnonymousClass2(java.lang.String str, int i, androidx.activity.result.contract.ActivityResultContract activityResultContract) {
            this.val$key = str;
            this.val$requestCode = i;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        @androidx.annotation.NonNull
        public androidx.activity.result.contract.ActivityResultContract<I, ?> getContract() {
            return this.val$contract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void launch(I i, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
            androidx.activity.result.ActivityResultRegistry.this.mLaunchedKeys.add(this.val$key);
            androidx.activity.result.ActivityResultRegistry.this.onLaunch(this.val$requestCode, this.val$contract, i, activityOptionsCompat);
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void unregister() {
            androidx.activity.result.ActivityResultRegistry.this.unregister(this.val$key);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* renamed from: androidx.activity.result.ActivityResultRegistry$3, reason: invalid class name */
    public class AnonymousClass3<I> extends androidx.activity.result.ActivityResultLauncher<I> {
        final /* synthetic */ androidx.activity.result.contract.ActivityResultContract val$contract;
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ int val$requestCode;

        public AnonymousClass3(java.lang.String str, int i, androidx.activity.result.contract.ActivityResultContract activityResultContract) {
            this.val$key = str;
            this.val$requestCode = i;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        @androidx.annotation.NonNull
        public androidx.activity.result.contract.ActivityResultContract<I, ?> getContract() {
            return this.val$contract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void launch(I i, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat) {
            androidx.activity.result.ActivityResultRegistry.this.mLaunchedKeys.add(this.val$key);
            androidx.activity.result.ActivityResultRegistry.this.onLaunch(this.val$requestCode, this.val$contract, i, activityOptionsCompat);
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public void unregister() {
            androidx.activity.result.ActivityResultRegistry.this.unregister(this.val$key);
        }
    }

    public static class CallbackAndContract<O> {
        final androidx.activity.result.ActivityResultCallback<O> mCallback;
        final androidx.activity.result.contract.ActivityResultContract<?, O> mContract;

        public CallbackAndContract(androidx.activity.result.ActivityResultCallback<O> activityResultCallback, androidx.activity.result.contract.ActivityResultContract<?, O> activityResultContract) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    public static class LifecycleContainer {
        final androidx.lifecycle.Lifecycle mLifecycle;
        private final java.util.ArrayList<androidx.lifecycle.LifecycleEventObserver> mObservers = new java.util.ArrayList<>();

        public LifecycleContainer(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }

        public void addObserver(@androidx.annotation.NonNull androidx.lifecycle.LifecycleEventObserver lifecycleEventObserver) {
            this.mLifecycle.addObserver(lifecycleEventObserver);
            this.mObservers.add(lifecycleEventObserver);
        }

        public void clearObservers() {
            java.util.Iterator<androidx.lifecycle.LifecycleEventObserver> it = this.mObservers.iterator();
            while (it.hasNext()) {
                this.mLifecycle.removeObserver(it.next());
            }
            this.mObservers.clear();
        }
    }

    private void bindRcKey(int i, java.lang.String str) {
        this.mRcToKey.put(java.lang.Integer.valueOf(i), str);
        this.mKeyToRc.put(str, java.lang.Integer.valueOf(i));
    }

    private <O> void doDispatch(java.lang.String str, int i, @androidx.annotation.Nullable android.content.Intent intent, @androidx.annotation.Nullable androidx.activity.result.ActivityResultRegistry.CallbackAndContract<O> callbackAndContract) {
        androidx.activity.result.ActivityResultCallback<O> activityResultCallback;
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(callbackAndContract.mContract.parseResult(i, intent));
        } else {
            this.mParsedPendingResults.remove(str);
            this.mPendingResults.putParcelable(str, new androidx.activity.result.ActivityResult(i, intent));
        }
    }

    private int generateRandomNumber() {
        int nextInt = this.mRandom.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (!this.mRcToKey.containsKey(java.lang.Integer.valueOf(i))) {
                return i;
            }
            nextInt = this.mRandom.nextInt(2147418112);
        }
    }

    private int registerKey(java.lang.String str) {
        java.lang.Integer num = this.mKeyToRc.get(str);
        if (num != null) {
            return num.intValue();
        }
        int generateRandomNumber = generateRandomNumber();
        bindRcKey(generateRandomNumber, str);
        return generateRandomNumber;
    }

    @androidx.annotation.MainThread
    public final boolean dispatchResult(int i, int i2, @androidx.annotation.Nullable android.content.Intent intent) {
        java.lang.String str = this.mRcToKey.get(java.lang.Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.mLaunchedKeys.remove(str);
        doDispatch(str, i2, intent, this.mKeyToCallback.get(str));
        return true;
    }

    @androidx.annotation.MainThread
    public final <O> boolean dispatchResult(int i, @android.annotation.SuppressLint({"UnknownNullness"}) O o) {
        androidx.activity.result.ActivityResultCallback<?> activityResultCallback;
        java.lang.String str = this.mRcToKey.get(java.lang.Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.mLaunchedKeys.remove(str);
        androidx.activity.result.ActivityResultRegistry.CallbackAndContract<?> callbackAndContract = this.mKeyToCallback.get(str);
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.mCallback) != null) {
            activityResultCallback.onActivityResult(o);
            return true;
        }
        this.mPendingResults.remove(str);
        this.mParsedPendingResults.put(str, o);
        return true;
    }

    @androidx.annotation.MainThread
    public abstract <I, O> void onLaunch(int i, @androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @android.annotation.SuppressLint({"UnknownNullness"}) I i2, @androidx.annotation.Nullable androidx.core.app.ActivityOptionsCompat activityOptionsCompat);

    public final void onRestoreInstanceState(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (bundle == null) {
            return;
        }
        java.util.ArrayList<java.lang.Integer> integerArrayList = bundle.getIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS);
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS);
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        int size = stringArrayList.size();
        for (int i = 0; i < size; i++) {
            bindRcKey(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
        this.mLaunchedKeys = bundle.getStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS);
        this.mRandom = (java.util.Random) bundle.getSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT);
        this.mPendingResults.putAll(bundle.getBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS));
    }

    public final void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        bundle.putIntegerArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_RCS, new java.util.ArrayList<>(this.mRcToKey.keySet()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS, new java.util.ArrayList<>(this.mRcToKey.values()));
        bundle.putStringArrayList(KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS, new java.util.ArrayList<>(this.mLaunchedKeys));
        bundle.putBundle(KEY_COMPONENT_ACTIVITY_PENDING_RESULTS, (android.os.Bundle) this.mPendingResults.clone());
        bundle.putSerializable(KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT, this.mRandom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        int registerKey = registerKey(str);
        this.mKeyToCallback.put(str, new androidx.activity.result.ActivityResultRegistry.CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(str)) {
            java.lang.Object obj = this.mParsedPendingResults.get(str);
            this.mParsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        androidx.activity.result.ActivityResult activityResult = (androidx.activity.result.ActivityResult) this.mPendingResults.getParcelable(str);
        if (activityResult != null) {
            this.mPendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.getResultCode(), activityResult.getData()));
        }
        return new androidx.activity.result.ActivityResultRegistry.AnonymousClass3(str, registerKey, activityResultContract);
    }

    @androidx.annotation.NonNull
    public final <I, O> androidx.activity.result.ActivityResultLauncher<I> register(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.activity.result.contract.ActivityResultContract<I, O> activityResultContract, @androidx.annotation.NonNull androidx.activity.result.ActivityResultCallback<O> activityResultCallback) {
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            throw new java.lang.IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
        }
        int registerKey = registerKey(str);
        androidx.activity.result.ActivityResultRegistry.LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer == null) {
            lifecycleContainer = new androidx.activity.result.ActivityResultRegistry.LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(new androidx.activity.result.ActivityResultRegistry.AnonymousClass1(str, activityResultCallback, activityResultContract));
        this.mKeyToLifecycleContainers.put(str, lifecycleContainer);
        return new androidx.activity.result.ActivityResultRegistry.AnonymousClass2(str, registerKey, activityResultContract);
    }

    @androidx.annotation.MainThread
    public final void unregister(@androidx.annotation.NonNull java.lang.String str) {
        java.lang.Integer remove;
        if (!this.mLaunchedKeys.contains(str) && (remove = this.mKeyToRc.remove(str)) != null) {
            this.mRcToKey.remove(remove);
        }
        this.mKeyToCallback.remove(str);
        if (this.mParsedPendingResults.containsKey(str)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.mParsedPendingResults.get(str));
            this.mParsedPendingResults.remove(str);
        }
        if (this.mPendingResults.containsKey(str)) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.mPendingResults.getParcelable(str));
            this.mPendingResults.remove(str);
        }
        androidx.activity.result.ActivityResultRegistry.LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
            this.mKeyToLifecycleContainers.remove(str);
        }
    }
}
