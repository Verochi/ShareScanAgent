package com.chad.library.adapter.base.entity;

/* loaded from: classes22.dex */
public abstract class JSectionEntity implements com.chad.library.adapter.base.entity.SectionEntity {
    @Override // com.chad.library.adapter.base.entity.SectionEntity, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return isHeader() ? -99 : -100;
    }
}
