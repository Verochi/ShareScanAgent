package kotlin.io;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b#\u0010$J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J#\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lkotlin/io/FilePathComponents;", "", "", "beginIndex", "endIndex", "Ljava/io/File;", "subPath", "component1", "", "component2", "root", com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME, com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals", "a", "Ljava/io/File;", "getRoot", "()Ljava/io/File;", "b", "Ljava/util/List;", "getSegments", "()Ljava/util/List;", "getRootName", "()Ljava/lang/String;", "rootName", "isRooted", "()Z", "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final /* data */ class FilePathComponents {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.io.File root;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.io.File> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public FilePathComponents(@org.jetbrains.annotations.NotNull java.io.File root, @org.jetbrains.annotations.NotNull java.util.List<? extends java.io.File> segments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(root, "root");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(segments, "segments");
        this.root = root;
        this.segments = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ kotlin.io.FilePathComponents copy$default(kotlin.io.FilePathComponents filePathComponents, java.io.File file, java.util.List list, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy(file, list);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component1, reason: from getter */
    public final java.io.File getRoot() {
        return this.root;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.io.File> component2() {
        return this.segments;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.io.FilePathComponents copy(@org.jetbrains.annotations.NotNull java.io.File root, @org.jetbrains.annotations.NotNull java.util.List<? extends java.io.File> segments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(root, "root");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(segments, "segments");
        return new kotlin.io.FilePathComponents(root, segments);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof kotlin.io.FilePathComponents)) {
            return false;
        }
        kotlin.io.FilePathComponents filePathComponents = (kotlin.io.FilePathComponents) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.root, filePathComponents.root) && kotlin.jvm.internal.Intrinsics.areEqual(this.segments, filePathComponents.segments);
    }

    @org.jetbrains.annotations.NotNull
    public final java.io.File getRoot() {
        return this.root;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRootName() {
        java.lang.String path = this.root.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.io.File> getSegments() {
        return this.segments;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public int hashCode() {
        return (this.root.hashCode() * 31) + this.segments.hashCode();
    }

    public final boolean isRooted() {
        java.lang.String path = this.root.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "root.path");
        return path.length() > 0;
    }

    @org.jetbrains.annotations.NotNull
    public final java.io.File subPath(int beginIndex, int endIndex) {
        java.lang.String joinToString$default;
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > getSize()) {
            throw new java.lang.IllegalArgumentException();
        }
        java.util.List<java.io.File> subList = this.segments.subList(beginIndex, endIndex);
        java.lang.String separator = java.io.File.separator;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(separator, "separator");
        joinToString$default = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(subList, separator, null, null, 0, null, null, 62, null);
        return new java.io.File(joinToString$default);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }
}
