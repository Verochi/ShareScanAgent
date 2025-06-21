package com.airbnb.lottie.model.content;

/* loaded from: classes.dex */
public class MergePaths implements com.airbnb.lottie.model.content.ContentModel {
    public final java.lang.String a;
    public final com.airbnb.lottie.model.content.MergePaths.MergePathsMode b;
    public final boolean c;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static com.airbnb.lottie.model.content.MergePaths.MergePathsMode forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public MergePaths(java.lang.String str, com.airbnb.lottie.model.content.MergePaths.MergePathsMode mergePathsMode, boolean z) {
        this.a = str;
        this.b = mergePathsMode;
        this.c = z;
    }

    public com.airbnb.lottie.model.content.MergePaths.MergePathsMode getMode() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public boolean isHidden() {
        return this.c;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    @androidx.annotation.Nullable
    public com.airbnb.lottie.animation.content.Content toContent(com.airbnb.lottie.LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.BaseLayer baseLayer) {
        if (lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            return new com.airbnb.lottie.animation.content.MergePathsContent(this);
        }
        com.airbnb.lottie.utils.Logger.warning("Animation contains merge paths but they are disabled.");
        return null;
    }

    public java.lang.String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
