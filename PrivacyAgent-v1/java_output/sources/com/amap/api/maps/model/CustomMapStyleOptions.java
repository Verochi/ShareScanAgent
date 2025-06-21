package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public class CustomMapStyleOptions {
    private java.lang.String styleDataPath = null;
    private byte[] styleData = null;
    private java.lang.String styleTexturePath = null;
    private byte[] styleTextureData = null;
    private java.lang.String styleId = null;
    private boolean enable = true;
    private byte[] styleExtraData = null;
    private java.lang.String styleExtraPath = null;
    private java.lang.String styleDataOverseaPath = null;
    private byte[] styleDataOversea = null;
    private java.lang.String styleResDataPath = null;
    private byte[] styleResData = null;

    public byte[] getStyleData() {
        return this.styleData;
    }

    public byte[] getStyleDataOversea() {
        return this.styleDataOversea;
    }

    public java.lang.String getStyleDataOverseaPath() {
        return this.styleDataOverseaPath;
    }

    public java.lang.String getStyleDataPath() {
        return this.styleDataPath;
    }

    public byte[] getStyleExtraData() {
        return this.styleExtraData;
    }

    public java.lang.String getStyleExtraPath() {
        return this.styleExtraPath;
    }

    public java.lang.String getStyleId() {
        return this.styleId;
    }

    public byte[] getStyleResData() {
        return this.styleResData;
    }

    public java.lang.String getStyleResDataPath() {
        return this.styleResDataPath;
    }

    public byte[] getStyleTextureData() {
        return this.styleTextureData;
    }

    public java.lang.String getStyleTexturePath() {
        return this.styleTexturePath;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleData(byte[] bArr) {
        this.styleData = bArr;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleDataOversea(byte[] bArr) {
        this.styleDataOversea = bArr;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleDataOverseaPath(java.lang.String str) {
        this.styleDataOverseaPath = str;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleDataPath(java.lang.String str) {
        this.styleDataPath = str;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleExtraData(byte[] bArr) {
        this.styleExtraData = bArr;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleExtraPath(java.lang.String str) {
        this.styleExtraPath = str;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleId(java.lang.String str) {
        this.styleId = str;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleResData(byte[] bArr) {
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleResDataPath(java.lang.String str) {
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleTextureData(byte[] bArr) {
        this.styleTextureData = bArr;
        return this;
    }

    public com.amap.api.maps.model.CustomMapStyleOptions setStyleTexturePath(java.lang.String str) {
        this.styleTexturePath = str;
        return this;
    }
}
