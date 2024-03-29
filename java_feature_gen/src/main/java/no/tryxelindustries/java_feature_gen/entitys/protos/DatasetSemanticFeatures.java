// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/news_dataset_semantic_features.proto

package no.tryxelindustries.java_feature_gen.entitys.protos;

/**
 * Protobuf type {@code java_feature_gen.DatasetSemanticFeatures}
 */
public final class DatasetSemanticFeatures extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:java_feature_gen.DatasetSemanticFeatures)
    DatasetSemanticFeaturesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DatasetSemanticFeatures.newBuilder() to construct.
  private DatasetSemanticFeatures(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DatasetSemanticFeatures() {
    datasetName_ = "";
    newsEntries_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new DatasetSemanticFeatures();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DatasetSemanticFeatures(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            datasetName_ = s;
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              newsEntries_ = new java.util.ArrayList<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures>();
              mutable_bitField0_ |= 0x00000001;
            }
            newsEntries_.add(
                input.readMessage(no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        newsEntries_ = java.util.Collections.unmodifiableList(newsEntries_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesProtos.internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesProtos.internal_static_java_feature_gen_DatasetSemanticFeatures_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.class, no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.Builder.class);
  }

  public static final int DATASET_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object datasetName_;
  /**
   * <code>string dataset_name = 1;</code>
   * @return The datasetName.
   */
  @java.lang.Override
  public java.lang.String getDatasetName() {
    java.lang.Object ref = datasetName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      datasetName_ = s;
      return s;
    }
  }
  /**
   * <code>string dataset_name = 1;</code>
   * @return The bytes for datasetName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDatasetNameBytes() {
    java.lang.Object ref = datasetName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      datasetName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NEWS_ENTRIES_FIELD_NUMBER = 2;
  private java.util.List<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures> newsEntries_;
  /**
   * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
   */
  @java.lang.Override
  public java.util.List<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures> getNewsEntriesList() {
    return newsEntries_;
  }
  /**
   * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder> 
      getNewsEntriesOrBuilderList() {
    return newsEntries_;
  }
  /**
   * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
   */
  @java.lang.Override
  public int getNewsEntriesCount() {
    return newsEntries_.size();
  }
  /**
   * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
   */
  @java.lang.Override
  public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures getNewsEntries(int index) {
    return newsEntries_.get(index);
  }
  /**
   * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
   */
  @java.lang.Override
  public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder getNewsEntriesOrBuilder(
      int index) {
    return newsEntries_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getDatasetNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, datasetName_);
    }
    for (int i = 0; i < newsEntries_.size(); i++) {
      output.writeMessage(2, newsEntries_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDatasetNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, datasetName_);
    }
    for (int i = 0; i < newsEntries_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, newsEntries_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures)) {
      return super.equals(obj);
    }
    no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures other = (no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures) obj;

    if (!getDatasetName()
        .equals(other.getDatasetName())) return false;
    if (!getNewsEntriesList()
        .equals(other.getNewsEntriesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DATASET_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getDatasetName().hashCode();
    if (getNewsEntriesCount() > 0) {
      hash = (37 * hash) + NEWS_ENTRIES_FIELD_NUMBER;
      hash = (53 * hash) + getNewsEntriesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code java_feature_gen.DatasetSemanticFeatures}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:java_feature_gen.DatasetSemanticFeatures)
      no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesProtos.internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesProtos.internal_static_java_feature_gen_DatasetSemanticFeatures_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.class, no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.Builder.class);
    }

    // Construct using no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getNewsEntriesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      datasetName_ = "";

      if (newsEntriesBuilder_ == null) {
        newsEntries_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        newsEntriesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeaturesProtos.internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor;
    }

    @java.lang.Override
    public no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures getDefaultInstanceForType() {
      return no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.getDefaultInstance();
    }

    @java.lang.Override
    public no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures build() {
      no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures buildPartial() {
      no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures result = new no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures(this);
      int from_bitField0_ = bitField0_;
      result.datasetName_ = datasetName_;
      if (newsEntriesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          newsEntries_ = java.util.Collections.unmodifiableList(newsEntries_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.newsEntries_ = newsEntries_;
      } else {
        result.newsEntries_ = newsEntriesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures) {
        return mergeFrom((no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures other) {
      if (other == no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures.getDefaultInstance()) return this;
      if (!other.getDatasetName().isEmpty()) {
        datasetName_ = other.datasetName_;
        onChanged();
      }
      if (newsEntriesBuilder_ == null) {
        if (!other.newsEntries_.isEmpty()) {
          if (newsEntries_.isEmpty()) {
            newsEntries_ = other.newsEntries_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureNewsEntriesIsMutable();
            newsEntries_.addAll(other.newsEntries_);
          }
          onChanged();
        }
      } else {
        if (!other.newsEntries_.isEmpty()) {
          if (newsEntriesBuilder_.isEmpty()) {
            newsEntriesBuilder_.dispose();
            newsEntriesBuilder_ = null;
            newsEntries_ = other.newsEntries_;
            bitField0_ = (bitField0_ & ~0x00000001);
            newsEntriesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getNewsEntriesFieldBuilder() : null;
          } else {
            newsEntriesBuilder_.addAllMessages(other.newsEntries_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object datasetName_ = "";
    /**
     * <code>string dataset_name = 1;</code>
     * @return The datasetName.
     */
    public java.lang.String getDatasetName() {
      java.lang.Object ref = datasetName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        datasetName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dataset_name = 1;</code>
     * @return The bytes for datasetName.
     */
    public com.google.protobuf.ByteString
        getDatasetNameBytes() {
      java.lang.Object ref = datasetName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        datasetName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dataset_name = 1;</code>
     * @param value The datasetName to set.
     * @return This builder for chaining.
     */
    public Builder setDatasetName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      datasetName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dataset_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearDatasetName() {
      
      datasetName_ = getDefaultInstance().getDatasetName();
      onChanged();
      return this;
    }
    /**
     * <code>string dataset_name = 1;</code>
     * @param value The bytes for datasetName to set.
     * @return This builder for chaining.
     */
    public Builder setDatasetNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      datasetName_ = value;
      onChanged();
      return this;
    }

    private java.util.List<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures> newsEntries_ =
      java.util.Collections.emptyList();
    private void ensureNewsEntriesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        newsEntries_ = new java.util.ArrayList<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures>(newsEntries_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder> newsEntriesBuilder_;

    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public java.util.List<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures> getNewsEntriesList() {
      if (newsEntriesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(newsEntries_);
      } else {
        return newsEntriesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public int getNewsEntriesCount() {
      if (newsEntriesBuilder_ == null) {
        return newsEntries_.size();
      } else {
        return newsEntriesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures getNewsEntries(int index) {
      if (newsEntriesBuilder_ == null) {
        return newsEntries_.get(index);
      } else {
        return newsEntriesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder setNewsEntries(
        int index, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures value) {
      if (newsEntriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNewsEntriesIsMutable();
        newsEntries_.set(index, value);
        onChanged();
      } else {
        newsEntriesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder setNewsEntries(
        int index, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder builderForValue) {
      if (newsEntriesBuilder_ == null) {
        ensureNewsEntriesIsMutable();
        newsEntries_.set(index, builderForValue.build());
        onChanged();
      } else {
        newsEntriesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder addNewsEntries(no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures value) {
      if (newsEntriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNewsEntriesIsMutable();
        newsEntries_.add(value);
        onChanged();
      } else {
        newsEntriesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder addNewsEntries(
        int index, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures value) {
      if (newsEntriesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureNewsEntriesIsMutable();
        newsEntries_.add(index, value);
        onChanged();
      } else {
        newsEntriesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder addNewsEntries(
        no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder builderForValue) {
      if (newsEntriesBuilder_ == null) {
        ensureNewsEntriesIsMutable();
        newsEntries_.add(builderForValue.build());
        onChanged();
      } else {
        newsEntriesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder addNewsEntries(
        int index, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder builderForValue) {
      if (newsEntriesBuilder_ == null) {
        ensureNewsEntriesIsMutable();
        newsEntries_.add(index, builderForValue.build());
        onChanged();
      } else {
        newsEntriesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder addAllNewsEntries(
        java.lang.Iterable<? extends no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures> values) {
      if (newsEntriesBuilder_ == null) {
        ensureNewsEntriesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, newsEntries_);
        onChanged();
      } else {
        newsEntriesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder clearNewsEntries() {
      if (newsEntriesBuilder_ == null) {
        newsEntries_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        newsEntriesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public Builder removeNewsEntries(int index) {
      if (newsEntriesBuilder_ == null) {
        ensureNewsEntriesIsMutable();
        newsEntries_.remove(index);
        onChanged();
      } else {
        newsEntriesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder getNewsEntriesBuilder(
        int index) {
      return getNewsEntriesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder getNewsEntriesOrBuilder(
        int index) {
      if (newsEntriesBuilder_ == null) {
        return newsEntries_.get(index);  } else {
        return newsEntriesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public java.util.List<? extends no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder> 
         getNewsEntriesOrBuilderList() {
      if (newsEntriesBuilder_ != null) {
        return newsEntriesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(newsEntries_);
      }
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder addNewsEntriesBuilder() {
      return getNewsEntriesFieldBuilder().addBuilder(
          no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.getDefaultInstance());
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder addNewsEntriesBuilder(
        int index) {
      return getNewsEntriesFieldBuilder().addBuilder(
          index, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.getDefaultInstance());
    }
    /**
     * <code>repeated .java_feature_gen.NewsEntrySemanticFeatures news_entries = 2;</code>
     */
    public java.util.List<no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder> 
         getNewsEntriesBuilderList() {
      return getNewsEntriesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder> 
        getNewsEntriesFieldBuilder() {
      if (newsEntriesBuilder_ == null) {
        newsEntriesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeatures.Builder, no.tryxelindustries.java_feature_gen.entitys.protos.NewsEntrySemanticFeaturesOrBuilder>(
                newsEntries_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        newsEntries_ = null;
      }
      return newsEntriesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:java_feature_gen.DatasetSemanticFeatures)
  }

  // @@protoc_insertion_point(class_scope:java_feature_gen.DatasetSemanticFeatures)
  private static final no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures();
  }

  public static no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DatasetSemanticFeatures>
      PARSER = new com.google.protobuf.AbstractParser<DatasetSemanticFeatures>() {
    @java.lang.Override
    public DatasetSemanticFeatures parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DatasetSemanticFeatures(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DatasetSemanticFeatures> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DatasetSemanticFeatures> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public no.tryxelindustries.java_feature_gen.entitys.protos.DatasetSemanticFeatures getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

