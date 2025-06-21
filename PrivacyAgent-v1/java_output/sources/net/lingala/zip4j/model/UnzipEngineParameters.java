package net.lingala.zip4j.model;

/* loaded from: classes23.dex */
public class UnzipEngineParameters {
    public net.lingala.zip4j.model.ZipModel a;
    public net.lingala.zip4j.model.FileHeader b;
    public net.lingala.zip4j.model.LocalFileHeader c;
    public net.lingala.zip4j.crypto.IDecrypter d;
    public java.io.FileOutputStream e;
    public net.lingala.zip4j.unzip.UnzipEngine f;

    public net.lingala.zip4j.model.FileHeader getFileHeader() {
        return this.b;
    }

    public net.lingala.zip4j.crypto.IDecrypter getIDecryptor() {
        return this.d;
    }

    public net.lingala.zip4j.model.LocalFileHeader getLocalFileHeader() {
        return this.c;
    }

    public java.io.FileOutputStream getOutputStream() {
        return this.e;
    }

    public net.lingala.zip4j.unzip.UnzipEngine getUnzipEngine() {
        return this.f;
    }

    public net.lingala.zip4j.model.ZipModel getZipModel() {
        return this.a;
    }

    public void setFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) {
        this.b = fileHeader;
    }

    public void setIDecryptor(net.lingala.zip4j.crypto.IDecrypter iDecrypter) {
        this.d = iDecrypter;
    }

    public void setLocalFileHeader(net.lingala.zip4j.model.LocalFileHeader localFileHeader) {
        this.c = localFileHeader;
    }

    public void setOutputStream(java.io.FileOutputStream fileOutputStream) {
        this.e = fileOutputStream;
    }

    public void setUnzipEngine(net.lingala.zip4j.unzip.UnzipEngine unzipEngine) {
        this.f = unzipEngine;
    }

    public void setZipModel(net.lingala.zip4j.model.ZipModel zipModel) {
        this.a = zipModel;
    }
}
