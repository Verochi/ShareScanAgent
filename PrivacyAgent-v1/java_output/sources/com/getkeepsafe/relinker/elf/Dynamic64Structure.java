package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Dynamic64Structure extends com.getkeepsafe.relinker.elf.Elf.DynamicStructure {
    public Dynamic64Structure(com.getkeepsafe.relinker.elf.ElfParser elfParser, com.getkeepsafe.relinker.elf.Elf.Header header, long j, int i) throws java.io.IOException {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(header.bigEndian ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 16);
        this.tag = elfParser.readLong(allocate, j2);
        this.val = elfParser.readLong(allocate, j2 + 8);
    }
}
