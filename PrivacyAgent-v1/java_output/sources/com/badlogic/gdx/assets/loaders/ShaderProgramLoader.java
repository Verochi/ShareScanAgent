package com.badlogic.gdx.assets.loaders;

/* loaded from: classes12.dex */
public class ShaderProgramLoader extends com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader<com.badlogic.gdx.graphics.glutils.ShaderProgram, com.badlogic.gdx.assets.loaders.ShaderProgramLoader.ShaderProgramParameter> {
    public java.lang.String b;
    public java.lang.String c;

    public static class ShaderProgramParameter extends com.badlogic.gdx.assets.AssetLoaderParameters<com.badlogic.gdx.graphics.glutils.ShaderProgram> {
        public java.lang.String fragmentFile;
        public boolean logOnCompileFailure = true;
        public java.lang.String prependFragmentCode;
        public java.lang.String prependVertexCode;
        public java.lang.String vertexFile;
    }

    public ShaderProgramLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.b = ".vert";
        this.c = ".frag";
    }

    public ShaderProgramLoader(com.badlogic.gdx.assets.loaders.FileHandleResolver fileHandleResolver, java.lang.String str, java.lang.String str2) {
        super(fileHandleResolver);
        this.b = str;
        this.c = str2;
    }

    @Override // com.badlogic.gdx.assets.loaders.AssetLoader
    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.assets.AssetDescriptor> getDependencies(java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.ShaderProgramLoader.ShaderProgramParameter shaderProgramParameter) {
        return null;
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public void loadAsync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.ShaderProgramLoader.ShaderProgramParameter shaderProgramParameter) {
    }

    @Override // com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
    public com.badlogic.gdx.graphics.glutils.ShaderProgram loadSync(com.badlogic.gdx.assets.AssetManager assetManager, java.lang.String str, com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.assets.loaders.ShaderProgramLoader.ShaderProgramParameter shaderProgramParameter) {
        java.lang.String str2;
        java.lang.String str3 = null;
        if (shaderProgramParameter != null) {
            java.lang.String str4 = shaderProgramParameter.vertexFile;
            if (str4 == null) {
                str4 = null;
            }
            str2 = shaderProgramParameter.fragmentFile;
            if (str2 == null) {
                str2 = null;
            }
            str3 = str4;
        } else {
            str2 = null;
        }
        if (str3 == null && str.endsWith(this.c)) {
            str3 = str.substring(0, str.length() - this.c.length()) + this.b;
        }
        if (str2 == null && str.endsWith(this.b)) {
            str2 = str.substring(0, str.length() - this.b.length()) + this.c;
        }
        com.badlogic.gdx.files.FileHandle resolve = str3 == null ? fileHandle : resolve(str3);
        if (str2 != null) {
            fileHandle = resolve(str2);
        }
        java.lang.String readString = resolve.readString();
        java.lang.String readString2 = resolve.equals(fileHandle) ? readString : fileHandle.readString();
        if (shaderProgramParameter != null) {
            if (shaderProgramParameter.prependVertexCode != null) {
                readString = shaderProgramParameter.prependVertexCode + readString;
            }
            if (shaderProgramParameter.prependFragmentCode != null) {
                readString2 = shaderProgramParameter.prependFragmentCode + readString2;
            }
        }
        com.badlogic.gdx.graphics.glutils.ShaderProgram shaderProgram = new com.badlogic.gdx.graphics.glutils.ShaderProgram(readString, readString2);
        if ((shaderProgramParameter == null || shaderProgramParameter.logOnCompileFailure) && !shaderProgram.isCompiled()) {
            assetManager.getLogger().error("ShaderProgram " + str + " failed to compile:\n" + shaderProgram.getLog());
        }
        return shaderProgram;
    }
}
