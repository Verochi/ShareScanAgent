package com.aliyun.svideo.base.beauty.api;

/* loaded from: classes.dex */
public class BeautyFactory {
    @androidx.annotation.Nullable
    public static com.aliyun.svideo.base.beauty.api.BeautyInterface createBeauty(com.aliyun.svideo.base.beauty.api.constant.BeautySDKType beautySDKType, @androidx.annotation.NonNull android.content.Context context) {
        com.aliyun.svideo.base.beauty.api.constant.BeautySDKType beautySDKType2 = com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.QUEEN;
        if (beautySDKType == beautySDKType2) {
            return reflectInitBeauty(com.aliyun.svideo.base.beauty.api.constant.BeautyConstant.beautyManagerImplMap.get(beautySDKType2), null, null);
        }
        com.aliyun.svideo.base.beauty.api.constant.BeautySDKType beautySDKType3 = com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.FACEUNITY;
        if (beautySDKType == beautySDKType3) {
            return reflectInitBeauty(com.aliyun.svideo.base.beauty.api.constant.BeautyConstant.beautyManagerImplMap.get(beautySDKType3), null, null);
        }
        com.aliyun.svideo.base.beauty.api.constant.BeautySDKType beautySDKType4 = com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.RACE;
        if (beautySDKType == beautySDKType4) {
            return reflectInitBeauty(com.aliyun.svideo.base.beauty.api.constant.BeautyConstant.beautyManagerImplMap.get(beautySDKType4), null, null);
        }
        if (beautySDKType == com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.DEFAULT) {
            return new com.aliyun.svideo.base.beauty.BeautyManager();
        }
        return null;
    }

    private static com.aliyun.svideo.base.beauty.api.BeautyInterface reflectInitBeauty(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Object[] objArr, @androidx.annotation.NonNull java.lang.Class<?>[] clsArr) {
        java.lang.Object obj;
        try {
            obj = java.lang.Class.forName(str).getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            obj = null;
            return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            obj = null;
            return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
        } catch (java.lang.InstantiationException e3) {
            e3.printStackTrace();
            obj = null;
            return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
        } catch (java.lang.NoSuchMethodException e4) {
            e4.printStackTrace();
            obj = null;
            return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
        } catch (java.lang.reflect.InvocationTargetException e5) {
            e5.printStackTrace();
            obj = null;
            return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
        }
        return (com.aliyun.svideo.base.beauty.api.BeautyInterface) obj;
    }
}
