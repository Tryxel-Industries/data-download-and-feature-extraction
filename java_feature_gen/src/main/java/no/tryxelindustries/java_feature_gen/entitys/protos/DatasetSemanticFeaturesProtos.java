// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/news_dataset_semantic_features.proto

package no.tryxelindustries.java_feature_gen.entitys.protos;

public final class DatasetSemanticFeaturesProtos {
  private DatasetSemanticFeaturesProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_java_feature_gen_NewsEntrySemanticFeatures_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_FeatureResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_java_feature_gen_NewsEntrySemanticFeatures_FeatureResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_java_feature_gen_DatasetSemanticFeatures_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*proto/news_dataset_semantic_features.p" +
      "roto\022\020java_feature_gen\"\256\002\n\031NewsEntrySema" +
      "nticFeatures\022\n\n\002id\030\001 \001(\005\022\024\n\014publish_date" +
      "\030\002 \001(\003\022I\n\006result\030\003 \003(\01329.java_feature_ge" +
      "n.NewsEntrySemanticFeatures.FeatureResul" +
      "t\022\r\n\005label\030\004 \001(\t\032e\n\rFeatureResult\022E\n\004typ" +
      "e\030\001 \001(\01627.java_feature_gen.NewsEntrySema" +
      "nticFeatures.FeatureType\022\r\n\005value\030\002 \001(\001\"" +
      ".\n\013FeatureType\022\016\n\nWORD_COUNT\020\000\022\017\n\013SWEAR_" +
      "WORDS\020\001\"r\n\027DatasetSemanticFeatures\022\024\n\014da" +
      "taset_name\030\001 \001(\t\022A\n\014news_entries\030\002 \003(\0132+" +
      ".java_feature_gen.NewsEntrySemanticFeatu" +
      "resBV\n3no.tryxelindustries.java_feature_" +
      "gen.entitys.protosB\035DatasetSemanticFeatu" +
      "resProtosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_java_feature_gen_NewsEntrySemanticFeatures_descriptor,
        new java.lang.String[] { "Id", "PublishDate", "Result", "Label", });
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_FeatureResult_descriptor =
      internal_static_java_feature_gen_NewsEntrySemanticFeatures_descriptor.getNestedTypes().get(0);
    internal_static_java_feature_gen_NewsEntrySemanticFeatures_FeatureResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_java_feature_gen_NewsEntrySemanticFeatures_FeatureResult_descriptor,
        new java.lang.String[] { "Type", "Value", });
    internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_java_feature_gen_DatasetSemanticFeatures_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_java_feature_gen_DatasetSemanticFeatures_descriptor,
        new java.lang.String[] { "DatasetName", "NewsEntries", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}