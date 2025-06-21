package com.aliyun.player.source;

/* loaded from: classes.dex */
public class VidSourceBase extends com.aliyun.player.source.SourceBase {
    private java.util.List<com.aliyun.player.source.Definition> mDefinitions;
    private java.util.List<com.aliyun.player.source.MediaFormat> mFormats;
    private com.aliyun.player.VidPlayerConfigGen mPlayConfig = null;
    private com.aliyun.player.source.VidSourceBase.OutputType mOutputType = null;
    private java.util.Set<com.aliyun.player.source.VidSourceBase.StreamType> mStreamTypes = null;
    private java.lang.String mReAuthInfo = null;
    private com.aliyun.player.source.VidSourceBase.ResultType mResultType = null;
    private long mAuthTimeout = com.anythink.expressad.d.a.b.P;

    public enum OutputType {
        oss("oss"),
        cdn("cdn");

        private java.lang.String mOutputType;

        OutputType(java.lang.String str) {
            this.mOutputType = str;
        }

        public java.lang.String getOutputType() {
            return this.mOutputType;
        }
    }

    public enum ResultType {
        Single("Single"),
        Multiple("Multiple");

        private java.lang.String mResultType;

        ResultType(java.lang.String str) {
            this.mResultType = str;
        }

        public java.lang.String getResultType() {
            return this.mResultType;
        }
    }

    public enum StreamType {
        video("video"),
        audio("audio");

        private java.lang.String mStreamType;

        StreamType(java.lang.String str) {
            this.mStreamType = str;
        }

        public java.lang.String getStreamType() {
            return this.mStreamType;
        }
    }

    @com.cicada.player.utils.NativeUsed
    public long getAuthTimeout() {
        return this.mAuthTimeout;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getDefinitionStr() {
        java.util.List<com.aliyun.player.source.Definition> list = this.mDefinitions;
        if (list == null || list.isEmpty()) {
            return null;
        }
        java.util.List<com.aliyun.player.source.Definition> list2 = this.mDefinitions;
        com.aliyun.player.source.Definition definition = com.aliyun.player.source.Definition.DEFINITION_AUTO;
        if (list2.contains(definition)) {
            return definition.getName();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        for (com.aliyun.player.source.Definition definition2 : this.mDefinitions) {
            if (definition2 != null) {
                sb.append(definition2.getName());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getFormatStr() {
        java.util.List<com.aliyun.player.source.MediaFormat> list = this.mFormats;
        if (list == null || list.isEmpty()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        for (com.aliyun.player.source.MediaFormat mediaFormat : this.mFormats) {
            if (mediaFormat != null) {
                sb.append(mediaFormat.getFormat());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public java.util.List<com.aliyun.player.source.MediaFormat> getFormats() {
        return this.mFormats;
    }

    public com.aliyun.player.source.VidSourceBase.OutputType getOutputType() {
        return this.mOutputType;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getOutputTypeStr() {
        com.aliyun.player.source.VidSourceBase.OutputType outputType = this.mOutputType;
        if (outputType == null) {
            return null;
        }
        return outputType.getOutputType();
    }

    public java.lang.String getPlayConfig() {
        com.aliyun.player.VidPlayerConfigGen vidPlayerConfigGen = this.mPlayConfig;
        return vidPlayerConfigGen == null ? "" : vidPlayerConfigGen.genConfig();
    }

    public java.lang.String getReAuthInfo() {
        return this.mReAuthInfo;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getReAuthInfoStr() {
        return this.mReAuthInfo;
    }

    public com.aliyun.player.source.VidSourceBase.ResultType getResultType() {
        return this.mResultType;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getResultTypeStr() {
        com.aliyun.player.source.VidSourceBase.ResultType resultType = this.mResultType;
        if (resultType == null) {
            return null;
        }
        return resultType.getResultType();
    }

    public java.util.Set<com.aliyun.player.source.VidSourceBase.StreamType> getStreamType() {
        return this.mStreamTypes;
    }

    @com.cicada.player.utils.NativeUsed
    public java.lang.String getStreamTypeStr() {
        if (this.mStreamTypes == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("");
        for (com.aliyun.player.source.VidSourceBase.StreamType streamType : this.mStreamTypes) {
            if (streamType != null) {
                sb.append(streamType.getStreamType());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void setAuthTimeout(long j) {
        this.mAuthTimeout = j;
    }

    public void setDefinition(java.util.List<com.aliyun.player.source.Definition> list) {
        this.mDefinitions = list;
    }

    public void setFormats(java.util.List<com.aliyun.player.source.MediaFormat> list) {
        this.mFormats = list;
    }

    public void setOutputType(com.aliyun.player.source.VidSourceBase.OutputType outputType) {
        this.mOutputType = outputType;
    }

    public void setPlayConfig(com.aliyun.player.VidPlayerConfigGen vidPlayerConfigGen) {
        this.mPlayConfig = vidPlayerConfigGen;
    }

    public void setReAuthInfo(java.lang.String str) {
        this.mReAuthInfo = str;
    }

    public void setResultType(com.aliyun.player.source.VidSourceBase.ResultType resultType) {
        this.mResultType = resultType;
    }

    public void setStreamType(java.util.Set<com.aliyun.player.source.VidSourceBase.StreamType> set) {
        this.mStreamTypes = set;
    }
}
