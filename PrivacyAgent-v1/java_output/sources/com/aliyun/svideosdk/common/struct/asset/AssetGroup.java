package com.aliyun.svideosdk.common.struct.asset;

/* loaded from: classes12.dex */
public abstract class AssetGroup {
    public static final int GROUP_SPECIAL_RECENT = 1;

    public abstract int getGroupId();

    public abstract java.lang.String getIconUrl();

    public abstract java.lang.String getName();

    public abstract int getResourceFrom();

    public abstract int getType();

    public abstract boolean isAvailable();
}
