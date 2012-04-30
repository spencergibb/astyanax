package com.netflix.astyanax.recipes.storage;

public class ObjectMetadata {
    private Integer ttl;
    private Long objectSize;
    private Integer chunkCount;
    private Integer chunkSize;

    public ObjectMetadata setTtl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public Integer getTtl() {
        return this.ttl;
    }

    public boolean hasTtl() {
        return this.ttl != null && this.ttl > 0;
    }

    public Long getObjectSize() {
        return objectSize;
    }

    public ObjectMetadata setObjectSize(Long objectSize) {
        this.objectSize = objectSize;
        return this;
    }

    public Integer getChunkCount() {
        return chunkCount;
    }

    public ObjectMetadata setChunkCount(Integer chunkCount) {
        this.chunkCount = chunkCount;
        return this;
    }

    public Integer getChunkSize() {
        return chunkSize;
    }

    public ObjectMetadata setChunkSize(Integer chunkSize) {
        this.chunkSize = chunkSize;
        return this;
    }

    public boolean isValidForRead() {
        return (this.objectSize != null && this.chunkCount != null && this.chunkSize != null);
    }
}
