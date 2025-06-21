package androidx.transition;

/* loaded from: classes.dex */
public class Scene {
    private android.content.Context mContext;
    private java.lang.Runnable mEnterAction;
    private java.lang.Runnable mExitAction;
    private android.view.View mLayout;
    private int mLayoutId;
    private android.view.ViewGroup mSceneRoot;

    public Scene(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    private Scene(android.view.ViewGroup viewGroup, int i, android.content.Context context) {
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i;
    }

    public Scene(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.NonNull android.view.View view) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }

    @androidx.annotation.Nullable
    public static androidx.transition.Scene getCurrentScene(@androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        return (androidx.transition.Scene) viewGroup.getTag(androidx.transition.R.id.transition_current_scene);
    }

    @androidx.annotation.NonNull
    public static androidx.transition.Scene getSceneForLayout(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.LayoutRes int i, @androidx.annotation.NonNull android.content.Context context) {
        int i2 = androidx.transition.R.id.transition_scene_layoutid_cache;
        android.util.SparseArray sparseArray = (android.util.SparseArray) viewGroup.getTag(i2);
        if (sparseArray == null) {
            sparseArray = new android.util.SparseArray();
            viewGroup.setTag(i2, sparseArray);
        }
        androidx.transition.Scene scene = (androidx.transition.Scene) sparseArray.get(i);
        if (scene != null) {
            return scene;
        }
        androidx.transition.Scene scene2 = new androidx.transition.Scene(viewGroup, i, context);
        sparseArray.put(i, scene2);
        return scene2;
    }

    public static void setCurrentScene(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, @androidx.annotation.Nullable androidx.transition.Scene scene) {
        viewGroup.setTag(androidx.transition.R.id.transition_current_scene, scene);
    }

    public void enter() {
        if (this.mLayoutId > 0 || this.mLayout != null) {
            getSceneRoot().removeAllViews();
            if (this.mLayoutId > 0) {
                android.view.LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            } else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }
        java.lang.Runnable runnable = this.mEnterAction;
        if (runnable != null) {
            runnable.run();
        }
        setCurrentScene(this.mSceneRoot, this);
    }

    public void exit() {
        java.lang.Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) != this || (runnable = this.mExitAction) == null) {
            return;
        }
        runnable.run();
    }

    @androidx.annotation.NonNull
    public android.view.ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public boolean isCreatedFromLayoutResource() {
        return this.mLayoutId > 0;
    }

    public void setEnterAction(@androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(@androidx.annotation.Nullable java.lang.Runnable runnable) {
        this.mExitAction = runnable;
    }
}
