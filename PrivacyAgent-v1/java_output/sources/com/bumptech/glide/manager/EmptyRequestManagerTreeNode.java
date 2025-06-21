package com.bumptech.glide.manager;

/* loaded from: classes.dex */
final class EmptyRequestManagerTreeNode implements com.bumptech.glide.manager.RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    @androidx.annotation.NonNull
    public java.util.Set<com.bumptech.glide.RequestManager> getDescendants() {
        return java.util.Collections.emptySet();
    }
}
