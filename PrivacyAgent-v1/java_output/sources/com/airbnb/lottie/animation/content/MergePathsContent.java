package com.airbnb.lottie.animation.content;

@android.annotation.TargetApi(19)
/* loaded from: classes.dex */
public class MergePathsContent implements com.airbnb.lottie.animation.content.PathContent, com.airbnb.lottie.animation.content.GreedyContent {
    public final java.lang.String d;
    public final com.airbnb.lottie.model.content.MergePaths f;
    public final android.graphics.Path a = new android.graphics.Path();
    public final android.graphics.Path b = new android.graphics.Path();
    public final android.graphics.Path c = new android.graphics.Path();
    public final java.util.List<com.airbnb.lottie.animation.content.PathContent> e = new java.util.ArrayList();

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.airbnb.lottie.model.content.MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(com.airbnb.lottie.model.content.MergePaths mergePaths) {
        this.d = mergePaths.getName();
        this.f = mergePaths;
    }

    public final void a() {
        for (int i = 0; i < this.e.size(); i++) {
            this.c.addPath(this.e.get(i).getPath());
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            com.airbnb.lottie.animation.content.Content previous = listIterator.previous();
            if (previous instanceof com.airbnb.lottie.animation.content.PathContent) {
                this.e.add((com.airbnb.lottie.animation.content.PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @android.annotation.TargetApi(19)
    public final void b(android.graphics.Path.Op op) {
        this.b.reset();
        this.a.reset();
        for (int size = this.e.size() - 1; size >= 1; size--) {
            com.airbnb.lottie.animation.content.PathContent pathContent = this.e.get(size);
            if (pathContent instanceof com.airbnb.lottie.animation.content.ContentGroup) {
                com.airbnb.lottie.animation.content.ContentGroup contentGroup = (com.airbnb.lottie.animation.content.ContentGroup) pathContent;
                java.util.List<com.airbnb.lottie.animation.content.PathContent> c = contentGroup.c();
                for (int size2 = c.size() - 1; size2 >= 0; size2--) {
                    android.graphics.Path path = c.get(size2).getPath();
                    path.transform(contentGroup.d());
                    this.b.addPath(path);
                }
            } else {
                this.b.addPath(pathContent.getPath());
            }
        }
        com.airbnb.lottie.animation.content.PathContent pathContent2 = this.e.get(0);
        if (pathContent2 instanceof com.airbnb.lottie.animation.content.ContentGroup) {
            com.airbnb.lottie.animation.content.ContentGroup contentGroup2 = (com.airbnb.lottie.animation.content.ContentGroup) pathContent2;
            java.util.List<com.airbnb.lottie.animation.content.PathContent> c2 = contentGroup2.c();
            for (int i = 0; i < c2.size(); i++) {
                android.graphics.Path path2 = c2.get(i).getPath();
                path2.transform(contentGroup2.d());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(pathContent2.getPath());
        }
        this.c.op(this.a, this.b, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public java.lang.String getName() {
        return this.d;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public android.graphics.Path getPath() {
        this.c.reset();
        if (this.f.isHidden()) {
            return this.c;
        }
        int i = com.airbnb.lottie.animation.content.MergePathsContent.AnonymousClass1.a[this.f.getMode().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            b(android.graphics.Path.Op.UNION);
        } else if (i == 3) {
            b(android.graphics.Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            b(android.graphics.Path.Op.INTERSECT);
        } else if (i == 5) {
            b(android.graphics.Path.Op.XOR);
        }
        return this.c;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(java.util.List<com.airbnb.lottie.animation.content.Content> list, java.util.List<com.airbnb.lottie.animation.content.Content> list2) {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).setContents(list, list2);
        }
    }
}
