package com.chad.library.adapter.base;

@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f¢\u0006\u0004\bF\u0010GJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0018\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0016\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\"\u0010\u001d\u001a\u00020\u00052\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0016\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\u001e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002J$\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012J\u0016\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000bJ\u0016\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002J\u001e\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0002J\u001c\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012J2\u0010+\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0007J2\u0010,\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0007J2\u0010-\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0007J2\u0010.\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0007J2\u0010/\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0007JR\u00104\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\r2\b\b\u0002\u00101\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u00102\u001a\u0004\u0018\u00010)2\n\b\u0002\u00103\u001a\u0004\u0018\u00010)H\u0007J\u000e\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0002J\u0010\u00106\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000bJ\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J/\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\n\b\u0002\u00109\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b:\u0010;J<\u0010=\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0002J<\u0010?\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0002R$\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u000b0@j\b\u0012\u0004\u0012\u00020\u000b`A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006H"}, d2 = {"Lcom/chad/library/adapter/base/BaseNodeAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", com.umeng.analytics.pro.f.M, "", "addNodeProvider", "addFullSpanNodeProvider", "addFooterNodeProvider", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "addItemProvider", "", "type", "", "isFixedViewType", "", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, "setNewInstance", "", "setList", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "data", "addData", "newData", "removeAt", "index", "setData", "Ljava/lang/Runnable;", "commitCallback", "setDiffNewData", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "parentNode", "nodeAddData", "childIndex", "nodeRemoveData", "childNode", "nodeSetData", "nodeReplaceChildData", "animate", "notify", "", "parentPayload", "collapse", "expand", "expandOrCollapse", "expandAndChild", "collapseAndChild", "isExpandedChild", "isCollapseChild", "expandPayload", "collapsePayload", "expandAndCollapseOther", "node", "findParentNode", "y", "x", "isExpanded", "v", "(Ljava/util/Collection;Ljava/lang/Boolean;)Ljava/util/List;", "isChangeChildCollapse", "t", "isChangeChildExpand", com.umeng.analytics.pro.bo.aN, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/HashSet;", "fullSpanNodeTypeSet", "nodeList", "<init>", "(Ljava/util/List;)V", "com.github.CymChad.brvah"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public abstract class BaseNodeAdapter extends com.chad.library.adapter.base.BaseProviderMultiAdapter<com.chad.library.adapter.base.entity.node.BaseNode> {

    /* renamed from: T, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.HashSet<java.lang.Integer> fullSpanNodeTypeSet;

    public BaseNodeAdapter() {
        this(null, 1, null);
    }

    public BaseNodeAdapter(@org.jetbrains.annotations.Nullable java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> list) {
        super(null);
        this.fullSpanNodeTypeSet = new java.util.HashSet<>();
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        getData().addAll(w(this, list2, null, 2, null));
    }

    public /* synthetic */ BaseNodeAdapter(java.util.List list, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public static /* synthetic */ int collapse$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.collapse(i, z, z2, obj);
    }

    public static /* synthetic */ int collapseAndChild$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.collapseAndChild(i, z, z2, obj);
    }

    public static /* synthetic */ int expand$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expand(i, z, z2, obj);
    }

    public static /* synthetic */ int expandAndChild$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expandAndChild(i, z, z2, obj);
    }

    public static /* synthetic */ void expandAndCollapseOther$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, boolean z3, boolean z4, java.lang.Object obj, java.lang.Object obj2, int i2, java.lang.Object obj3) {
        if (obj3 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
        }
        baseNodeAdapter.expandAndCollapseOther(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? true : z2, (i2 & 8) != 0 ? true : z3, (i2 & 16) == 0 ? z4 : true, (i2 & 32) != 0 ? null : obj, (i2 & 64) == 0 ? obj2 : null);
    }

    public static /* synthetic */ int expandOrCollapse$default(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, int i, boolean z, boolean z2, java.lang.Object obj, int i2, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expandOrCollapse(i, z, z2, obj);
    }

    public static /* synthetic */ java.util.List w(com.chad.library.adapter.base.BaseNodeAdapter baseNodeAdapter, java.util.Collection collection, java.lang.Boolean bool, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
        }
        if ((i & 2) != 0) {
            bool = null;
        }
        return baseNodeAdapter.v(collection, bool);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int position, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        java.util.ArrayList arrayListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        arrayListOf = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(data);
        addData(position, (java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode>) arrayListOf);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int position, @org.jetbrains.annotations.NotNull java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> newData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newData, "newData");
        super.addData(position, (java.util.Collection) w(this, newData, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        java.util.ArrayList arrayListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        arrayListOf = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(data);
        addData((java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode>) arrayListOf);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@org.jetbrains.annotations.NotNull java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> newData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newData, "newData");
        super.addData((java.util.Collection) w(this, newData, null, 2, null));
    }

    public final void addFooterNodeProvider(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.provider.BaseNodeProvider provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        addFullSpanNodeProvider(provider);
    }

    public final void addFullSpanNodeProvider(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.provider.BaseNodeProvider provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        this.fullSpanNodeTypeSet.add(java.lang.Integer.valueOf(provider.getItemViewType()));
        addItemProvider(provider);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public void addItemProvider(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.provider.BaseItemProvider<com.chad.library.adapter.base.entity.node.BaseNode> provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        if (!(provider instanceof com.chad.library.adapter.base.provider.BaseNodeProvider)) {
            throw new java.lang.IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
        }
        super.addItemProvider(provider);
    }

    public final void addNodeProvider(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.provider.BaseNodeProvider provider) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(provider, "provider");
        addItemProvider(provider);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapse(@androidx.annotation.IntRange(from = 0) int i) {
        return collapse$default(this, i, false, false, null, 14, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapse(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        return collapse$default(this, i, z, false, null, 12, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapse(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        return collapse$default(this, i, z, z2, null, 8, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapse(@androidx.annotation.IntRange(from = 0) int position, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object parentPayload) {
        return t(position, false, animate, notify, parentPayload);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapseAndChild(@androidx.annotation.IntRange(from = 0) int i) {
        return collapseAndChild$default(this, i, false, false, null, 14, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapseAndChild(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        return collapseAndChild$default(this, i, z, false, null, 12, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapseAndChild(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        return collapseAndChild$default(this, i, z, z2, null, 8, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int collapseAndChild(@androidx.annotation.IntRange(from = 0) int position, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object parentPayload) {
        return t(position, true, animate, notify, parentPayload);
    }

    @kotlin.jvm.JvmOverloads
    public final int expand(@androidx.annotation.IntRange(from = 0) int i) {
        return expand$default(this, i, false, false, null, 14, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expand(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        return expand$default(this, i, z, false, null, 12, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expand(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        return expand$default(this, i, z, z2, null, 8, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expand(@androidx.annotation.IntRange(from = 0) int position, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object parentPayload) {
        return u(position, false, animate, notify, parentPayload);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandAndChild(@androidx.annotation.IntRange(from = 0) int i) {
        return expandAndChild$default(this, i, false, false, null, 14, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandAndChild(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        return expandAndChild$default(this, i, z, false, null, 12, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandAndChild(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        return expandAndChild$default(this, i, z, z2, null, 8, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandAndChild(@androidx.annotation.IntRange(from = 0) int position, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object parentPayload) {
        return u(position, true, animate, notify, parentPayload);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i) {
        expandAndCollapseOther$default(this, i, false, false, false, false, null, null, 126, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        expandAndCollapseOther$default(this, i, z, false, false, false, null, null, 124, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        expandAndCollapseOther$default(this, i, z, z2, false, false, null, null, 120, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2, boolean z3) {
        expandAndCollapseOther$default(this, i, z, z2, z3, false, null, null, 112, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2, boolean z3, boolean z4) {
        expandAndCollapseOther$default(this, i, z, z2, z3, z4, null, null, 96, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2, boolean z3, boolean z4, @org.jetbrains.annotations.Nullable java.lang.Object obj) {
        expandAndCollapseOther$default(this, i, z, z2, z3, z4, obj, null, 64, null);
    }

    @kotlin.jvm.JvmOverloads
    public final void expandAndCollapseOther(@androidx.annotation.IntRange(from = 0) int position, boolean isExpandedChild, boolean isCollapseChild, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object expandPayload, @org.jetbrains.annotations.Nullable java.lang.Object collapsePayload) {
        int i;
        int size;
        int u = u(position, isExpandedChild, animate, notify, expandPayload);
        if (u == 0) {
            return;
        }
        int findParentNode = findParentNode(position);
        int i2 = findParentNode == -1 ? 0 : findParentNode + 1;
        if (position - i2 > 0) {
            int i3 = i2;
            i = position;
            do {
                int t = t(i3, isCollapseChild, animate, notify, collapsePayload);
                i3++;
                i -= t;
            } while (i3 < i);
        } else {
            i = position;
        }
        if (findParentNode == -1) {
            size = getData().size() - 1;
        } else {
            java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = getData().get(findParentNode).getChildNode();
            size = findParentNode + (childNode != null ? childNode.size() : 0) + u;
        }
        int i4 = i + u;
        if (i4 < size) {
            int i5 = i4 + 1;
            while (i5 <= size) {
                int t2 = t(i5, isCollapseChild, animate, notify, collapsePayload);
                i5++;
                size -= t2;
            }
        }
    }

    @kotlin.jvm.JvmOverloads
    public final int expandOrCollapse(@androidx.annotation.IntRange(from = 0) int i) {
        return expandOrCollapse$default(this, i, false, false, null, 14, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandOrCollapse(@androidx.annotation.IntRange(from = 0) int i, boolean z) {
        return expandOrCollapse$default(this, i, z, false, null, 12, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandOrCollapse(@androidx.annotation.IntRange(from = 0) int i, boolean z, boolean z2) {
        return expandOrCollapse$default(this, i, z, z2, null, 8, null);
    }

    @kotlin.jvm.JvmOverloads
    public final int expandOrCollapse(@androidx.annotation.IntRange(from = 0) int position, boolean animate, boolean notify, @org.jetbrains.annotations.Nullable java.lang.Object parentPayload) {
        com.chad.library.adapter.base.entity.node.BaseNode baseNode = getData().get(position);
        if (baseNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) {
            return ((com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode).getIsExpanded() ? t(position, false, animate, notify, parentPayload) : u(position, false, animate, notify, parentPayload);
        }
        return 0;
    }

    public final int findParentNode(@androidx.annotation.IntRange(from = 0) int position) {
        if (position == 0) {
            return -1;
        }
        com.chad.library.adapter.base.entity.node.BaseNode baseNode = getData().get(position);
        for (int i = position - 1; -1 < i; i--) {
            java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = getData().get(i).getChildNode();
            boolean z = false;
            if (childNode != null && childNode.contains(baseNode)) {
                z = true;
            }
            if (z) {
                return i;
            }
        }
        return -1;
    }

    public final int findParentNode(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode node) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(node, "node");
        int indexOf = getData().indexOf(node);
        if (indexOf != -1 && indexOf != 0) {
            for (int i = indexOf - 1; -1 < i; i--) {
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = getData().get(i).getChildNode();
                boolean z = false;
                if (childNode != null && childNode.contains(node)) {
                    z = true;
                }
                if (z) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int type) {
        return super.isFixedViewType(type) || this.fullSpanNodeTypeSet.contains(java.lang.Integer.valueOf(type));
    }

    public final void nodeAddData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, int childIndex, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.add(childIndex, data);
            if (!(parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) || ((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
                addData(getData().indexOf(parentNode) + 1 + childIndex, data);
            }
        }
    }

    public final void nodeAddData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, int childIndex, @org.jetbrains.annotations.NotNull java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> newData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newData, "newData");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.addAll(childIndex, newData);
            if (!(parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) || ((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
                addData(getData().indexOf(parentNode) + 1 + childIndex, newData);
            }
        }
    }

    public final void nodeAddData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.add(data);
            if (!(parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) || ((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
                addData(getData().indexOf(parentNode) + childNode.size(), data);
            }
        }
    }

    public final void nodeRemoveData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, int childIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode == null || childIndex >= childNode.size()) {
            return;
        }
        if ((parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) && !((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
            childNode.remove(childIndex);
        } else {
            remove(getData().indexOf(parentNode) + 1 + childIndex);
            childNode.remove(childIndex);
        }
    }

    public final void nodeRemoveData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode childNode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(childNode, "childNode");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode2 = parentNode.getChildNode();
        if (childNode2 != null) {
            if ((parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) && !((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
                childNode2.remove(childNode);
            } else {
                remove((com.chad.library.adapter.base.BaseNodeAdapter) childNode);
                childNode2.remove(childNode);
            }
        }
    }

    public final void nodeReplaceChildData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, @org.jetbrains.annotations.NotNull java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> newData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newData, "newData");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            if ((parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) && !((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
                childNode.clear();
                childNode.addAll(newData);
                return;
            }
            int indexOf = getData().indexOf(parentNode);
            int x = x(indexOf);
            childNode.clear();
            childNode.addAll(newData);
            java.util.List w = w(this, newData, null, 2, null);
            int i = indexOf + 1;
            getData().addAll(i, w);
            int headerLayoutCount = i + getHeaderLayoutCount();
            if (x == w.size()) {
                notifyItemRangeChanged(headerLayoutCount, x);
            } else {
                notifyItemRangeRemoved(headerLayoutCount, x);
                notifyItemRangeInserted(headerLayoutCount, w.size());
            }
        }
    }

    public final void nodeSetData(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode parentNode, int childIndex, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parentNode, "parentNode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = parentNode.getChildNode();
        if (childNode == null || childIndex >= childNode.size()) {
            return;
        }
        if ((parentNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) && !((com.chad.library.adapter.base.entity.node.BaseExpandNode) parentNode).getIsExpanded()) {
            childNode.set(childIndex, data);
        } else {
            setData(getData().indexOf(parentNode) + 1 + childIndex, data);
            childNode.set(childIndex, data);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void removeAt(int position) {
        notifyItemRangeRemoved(position + getHeaderLayoutCount(), y(position));
        compatibilityDataSizeChanged(0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setData(int index, @org.jetbrains.annotations.NotNull com.chad.library.adapter.base.entity.node.BaseNode data) {
        java.util.ArrayList arrayListOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        int y = y(index);
        arrayListOf = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(data);
        java.util.List w = w(this, arrayListOf, null, 2, null);
        getData().addAll(index, w);
        if (y == w.size()) {
            notifyItemRangeChanged(index + getHeaderLayoutCount(), y);
        } else {
            notifyItemRangeRemoved(getHeaderLayoutCount() + index, y);
            notifyItemRangeInserted(index + getHeaderLayoutCount(), w.size());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.DiffUtil.DiffResult diffResult, @org.jetbrains.annotations.NotNull java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            super.setDiffNewData(diffResult, w(this, list, null, 2, null));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(@org.jetbrains.annotations.Nullable java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> list, @org.jetbrains.annotations.Nullable java.lang.Runnable commitCallback) {
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            super.setDiffNewData(w(this, list != null ? list : new java.util.ArrayList(), null, 2, null), commitCallback);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@org.jetbrains.annotations.Nullable java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> list) {
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        super.setList(w(this, list, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewInstance(@org.jetbrains.annotations.Nullable java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> list) {
        super.setNewInstance(w(this, list != null ? list : new java.util.ArrayList(), null, 2, null));
    }

    public final int t(@androidx.annotation.IntRange(from = 0) int position, boolean isChangeChildCollapse, boolean animate, boolean notify, java.lang.Object parentPayload) {
        com.chad.library.adapter.base.entity.node.BaseNode baseNode = getData().get(position);
        if (baseNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) {
            com.chad.library.adapter.base.entity.node.BaseExpandNode baseExpandNode = (com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode;
            if (baseExpandNode.getIsExpanded()) {
                int headerLayoutCount = position + getHeaderLayoutCount();
                baseExpandNode.setExpanded(false);
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = baseNode.getChildNode();
                if (childNode == null || childNode.isEmpty()) {
                    notifyItemChanged(headerLayoutCount, parentPayload);
                    return 0;
                }
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode2 = baseNode.getChildNode();
                kotlin.jvm.internal.Intrinsics.checkNotNull(childNode2);
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> v = v(childNode2, isChangeChildCollapse ? java.lang.Boolean.FALSE : null);
                int size = v.size();
                getData().removeAll(v);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(headerLayoutCount, parentPayload);
                        notifyItemRangeRemoved(headerLayoutCount + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    public final int u(@androidx.annotation.IntRange(from = 0) int position, boolean isChangeChildExpand, boolean animate, boolean notify, java.lang.Object parentPayload) {
        com.chad.library.adapter.base.entity.node.BaseNode baseNode = getData().get(position);
        if (baseNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) {
            com.chad.library.adapter.base.entity.node.BaseExpandNode baseExpandNode = (com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode;
            if (!baseExpandNode.getIsExpanded()) {
                int headerLayoutCount = getHeaderLayoutCount() + position;
                baseExpandNode.setExpanded(true);
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = baseNode.getChildNode();
                if (childNode == null || childNode.isEmpty()) {
                    notifyItemChanged(headerLayoutCount, parentPayload);
                    return 0;
                }
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode2 = baseNode.getChildNode();
                kotlin.jvm.internal.Intrinsics.checkNotNull(childNode2);
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> v = v(childNode2, isChangeChildExpand ? java.lang.Boolean.TRUE : null);
                int size = v.size();
                getData().addAll(position + 1, v);
                if (notify) {
                    if (animate) {
                        notifyItemChanged(headerLayoutCount, parentPayload);
                        notifyItemRangeInserted(headerLayoutCount + 1, size);
                    } else {
                        notifyDataSetChanged();
                    }
                }
                return size;
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> v(java.util.Collection<? extends com.chad.library.adapter.base.entity.node.BaseNode> list, java.lang.Boolean isExpanded) {
        com.chad.library.adapter.base.entity.node.BaseNode footerNode;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.chad.library.adapter.base.entity.node.BaseNode baseNode : list) {
            arrayList.add(baseNode);
            if (baseNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(isExpanded, java.lang.Boolean.TRUE) || ((com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode).getIsExpanded()) {
                    java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = baseNode.getChildNode();
                    if (!(childNode == null || childNode.isEmpty())) {
                        arrayList.addAll(v(childNode, isExpanded));
                    }
                }
                if (isExpanded != null) {
                    ((com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode).setExpanded(isExpanded.booleanValue());
                }
            } else {
                java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode2 = baseNode.getChildNode();
                if (!(childNode2 == null || childNode2.isEmpty())) {
                    arrayList.addAll(v(childNode2, isExpanded));
                }
            }
            if ((baseNode instanceof com.chad.library.adapter.base.entity.node.NodeFooterImp) && (footerNode = ((com.chad.library.adapter.base.entity.node.NodeFooterImp) baseNode).getFooterNode()) != null) {
                arrayList.add(footerNode);
            }
        }
        return arrayList;
    }

    public final int x(int position) {
        if (position >= getData().size()) {
            return 0;
        }
        com.chad.library.adapter.base.entity.node.BaseNode baseNode = getData().get(position);
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode = baseNode.getChildNode();
        if (childNode == null || childNode.isEmpty()) {
            return 0;
        }
        if (!(baseNode instanceof com.chad.library.adapter.base.entity.node.BaseExpandNode)) {
            java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode2 = baseNode.getChildNode();
            kotlin.jvm.internal.Intrinsics.checkNotNull(childNode2);
            java.util.List w = w(this, childNode2, null, 2, null);
            getData().removeAll(w);
            return w.size();
        }
        if (!((com.chad.library.adapter.base.entity.node.BaseExpandNode) baseNode).getIsExpanded()) {
            return 0;
        }
        java.util.List<com.chad.library.adapter.base.entity.node.BaseNode> childNode3 = baseNode.getChildNode();
        kotlin.jvm.internal.Intrinsics.checkNotNull(childNode3);
        java.util.List w2 = w(this, childNode3, null, 2, null);
        getData().removeAll(w2);
        return w2.size();
    }

    public final int y(int position) {
        if (position >= getData().size()) {
            return 0;
        }
        int x = x(position);
        getData().remove(position);
        int i = x + 1;
        java.lang.Object obj = (com.chad.library.adapter.base.entity.node.BaseNode) getData().get(position);
        if (!(obj instanceof com.chad.library.adapter.base.entity.node.NodeFooterImp) || ((com.chad.library.adapter.base.entity.node.NodeFooterImp) obj).getFooterNode() == null) {
            return i;
        }
        getData().remove(position);
        return i + 1;
    }
}
