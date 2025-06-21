package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Dynamic32Structure extends com.getkeepsafe.relinker.elf.Elf.DynamicStructure {
    public Dynamic32Structure(com.getkeepsafe.relinker.elf.ElfParser elfParser, com.getkeepsafe.relinker.elf.Elf.Header header, long j, int i) throws java.io.IOException {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(4);
        allocate.order(header.bigEndian ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 8);
        this.tag = elfParser.readWord(allocate, j2);
        this.val = elfParser.readWord(allocate, j2 + 4);
    }
}
