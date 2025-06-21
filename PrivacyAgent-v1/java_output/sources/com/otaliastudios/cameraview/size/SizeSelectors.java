package com.otaliastudios.cameraview.size;

/* loaded from: classes19.dex */
public class SizeSelectors {

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getWidth() <= this.a;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getWidth() >= this.a;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getHeight() <= this.a;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getHeight() >= this.a;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$5, reason: invalid class name */
    public static class AnonymousClass5 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        public AnonymousClass5(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            float f = com.otaliastudios.cameraview.size.AspectRatio.of(size.getWidth(), size.getHeight()).toFloat();
            float f2 = this.a;
            float f3 = this.b;
            return f >= f2 - f3 && f <= f2 + f3;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$6, reason: invalid class name */
    public static class AnonymousClass6 implements com.otaliastudios.cameraview.size.SizeSelector {
        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @androidx.annotation.NonNull
        public java.util.List<com.otaliastudios.cameraview.size.Size> select(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.size.Size> list) {
            java.util.Collections.sort(list);
            java.util.Collections.reverse(list);
            return list;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$7, reason: invalid class name */
    public static class AnonymousClass7 implements com.otaliastudios.cameraview.size.SizeSelector {
        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @androidx.annotation.NonNull
        public java.util.List<com.otaliastudios.cameraview.size.Size> select(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.size.Size> list) {
            java.util.Collections.sort(list);
            return list;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$8, reason: invalid class name */
    public static class AnonymousClass8 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass8(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getHeight() * size.getWidth() <= this.a;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.size.SizeSelectors$9, reason: invalid class name */
    public static class AnonymousClass9 implements com.otaliastudios.cameraview.size.SizeSelectors.Filter {
        public final /* synthetic */ int a;

        public AnonymousClass9(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelectors.Filter
        public boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size) {
            return size.getHeight() * size.getWidth() >= this.a;
        }
    }

    public static class AndSelector implements com.otaliastudios.cameraview.size.SizeSelector {
        public com.otaliastudios.cameraview.size.SizeSelector[] a;

        public AndSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector... sizeSelectorArr) {
            this.a = sizeSelectorArr;
        }

        public /* synthetic */ AndSelector(com.otaliastudios.cameraview.size.SizeSelector[] sizeSelectorArr, com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass1 anonymousClass1) {
            this(sizeSelectorArr);
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @androidx.annotation.NonNull
        public java.util.List<com.otaliastudios.cameraview.size.Size> select(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.size.Size> list) {
            for (com.otaliastudios.cameraview.size.SizeSelector sizeSelector : this.a) {
                list = sizeSelector.select(list);
            }
            return list;
        }
    }

    public interface Filter {
        boolean accepts(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.Size size);
    }

    public static class FilterSelector implements com.otaliastudios.cameraview.size.SizeSelector {
        public com.otaliastudios.cameraview.size.SizeSelectors.Filter a;

        public FilterSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelectors.Filter filter) {
            this.a = filter;
        }

        public /* synthetic */ FilterSelector(com.otaliastudios.cameraview.size.SizeSelectors.Filter filter, com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass1 anonymousClass1) {
            this(filter);
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @androidx.annotation.NonNull
        public java.util.List<com.otaliastudios.cameraview.size.Size> select(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.size.Size> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.otaliastudios.cameraview.size.Size size : list) {
                if (this.a.accepts(size)) {
                    arrayList.add(size);
                }
            }
            return arrayList;
        }
    }

    public static class OrSelector implements com.otaliastudios.cameraview.size.SizeSelector {
        public com.otaliastudios.cameraview.size.SizeSelector[] a;

        public OrSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector... sizeSelectorArr) {
            this.a = sizeSelectorArr;
        }

        public /* synthetic */ OrSelector(com.otaliastudios.cameraview.size.SizeSelector[] sizeSelectorArr, com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass1 anonymousClass1) {
            this(sizeSelectorArr);
        }

        @Override // com.otaliastudios.cameraview.size.SizeSelector
        @androidx.annotation.NonNull
        public java.util.List<com.otaliastudios.cameraview.size.Size> select(@androidx.annotation.NonNull java.util.List<com.otaliastudios.cameraview.size.Size> list) {
            java.util.List<com.otaliastudios.cameraview.size.Size> list2 = null;
            for (com.otaliastudios.cameraview.size.SizeSelector sizeSelector : this.a) {
                list2 = sizeSelector.select(list);
                if (!list2.isEmpty()) {
                    break;
                }
            }
            return list2 == null ? new java.util.ArrayList() : list2;
        }
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector and(com.otaliastudios.cameraview.size.SizeSelector... sizeSelectorArr) {
        return new com.otaliastudios.cameraview.size.SizeSelectors.AndSelector(sizeSelectorArr, null);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector aspectRatio(com.otaliastudios.cameraview.size.AspectRatio aspectRatio, float f) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass5(aspectRatio.toFloat(), f));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector biggest() {
        return new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass6();
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector maxArea(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass8(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector maxHeight(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass3(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector maxWidth(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass1(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector minArea(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass9(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector minHeight(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass4(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector minWidth(int i) {
        return withFilter(new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass2(i));
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector or(com.otaliastudios.cameraview.size.SizeSelector... sizeSelectorArr) {
        return new com.otaliastudios.cameraview.size.SizeSelectors.OrSelector(sizeSelectorArr, null);
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector smallest() {
        return new com.otaliastudios.cameraview.size.SizeSelectors.AnonymousClass7();
    }

    @androidx.annotation.NonNull
    public static com.otaliastudios.cameraview.size.SizeSelector withFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelectors.Filter filter) {
        return new com.otaliastudios.cameraview.size.SizeSelectors.FilterSelector(filter, null);
    }
}
