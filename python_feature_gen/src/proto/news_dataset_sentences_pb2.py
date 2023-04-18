# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: proto/news_dataset_sentences.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='proto/news_dataset_sentences.proto',
  package='java_feature_gen',
  syntax='proto3',
  serialized_options=b'\n3no.tryxelindustries.java_feature_gen.entitys.protosB\025DatasetSentenceProtosP\001',
  create_key=_descriptor._internal_create_key,
  serialized_pb=b'\n\"proto/news_dataset_sentences.proto\x12\x10java_feature_gen\"X\n\x12NewsEntrySentences\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x14\n\x0cpublish_date\x18\x02 \x01(\x03\x12\r\n\x05label\x18\x04 \x01(\t\x12\x11\n\tsentences\x18\x05 \x03(\t\"d\n\x10\x44\x61tasetSentences\x12\x14\n\x0c\x64\x61taset_name\x18\x01 \x01(\t\x12:\n\x0cnews_entries\x18\x02 \x03(\x0b\x32$.java_feature_gen.NewsEntrySentencesBN\n3no.tryxelindustries.java_feature_gen.entitys.protosB\x15\x44\x61tasetSentenceProtosP\x01\x62\x06proto3'
)




_NEWSENTRYSENTENCES = _descriptor.Descriptor(
  name='NewsEntrySentences',
  full_name='java_feature_gen.NewsEntrySentences',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='id', full_name='java_feature_gen.NewsEntrySentences.id', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='publish_date', full_name='java_feature_gen.NewsEntrySentences.publish_date', index=1,
      number=2, type=3, cpp_type=2, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='label', full_name='java_feature_gen.NewsEntrySentences.label', index=2,
      number=4, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='sentences', full_name='java_feature_gen.NewsEntrySentences.sentences', index=3,
      number=5, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=56,
  serialized_end=144,
)


_DATASETSENTENCES = _descriptor.Descriptor(
  name='DatasetSentences',
  full_name='java_feature_gen.DatasetSentences',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  create_key=_descriptor._internal_create_key,
  fields=[
    _descriptor.FieldDescriptor(
      name='dataset_name', full_name='java_feature_gen.DatasetSentences.dataset_name', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=b"".decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
    _descriptor.FieldDescriptor(
      name='news_entries', full_name='java_feature_gen.DatasetSentences.news_entries', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR,  create_key=_descriptor._internal_create_key),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=146,
  serialized_end=246,
)

_DATASETSENTENCES.fields_by_name['news_entries'].message_type = _NEWSENTRYSENTENCES
DESCRIPTOR.message_types_by_name['NewsEntrySentences'] = _NEWSENTRYSENTENCES
DESCRIPTOR.message_types_by_name['DatasetSentences'] = _DATASETSENTENCES
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

NewsEntrySentences = _reflection.GeneratedProtocolMessageType('NewsEntrySentences', (_message.Message,), {
  'DESCRIPTOR' : _NEWSENTRYSENTENCES,
  '__module__' : 'proto.news_dataset_sentences_pb2'
  # @@protoc_insertion_point(class_scope:java_feature_gen.NewsEntrySentences)
  })
_sym_db.RegisterMessage(NewsEntrySentences)

DatasetSentences = _reflection.GeneratedProtocolMessageType('DatasetSentences', (_message.Message,), {
  'DESCRIPTOR' : _DATASETSENTENCES,
  '__module__' : 'proto.news_dataset_sentences_pb2'
  # @@protoc_insertion_point(class_scope:java_feature_gen.DatasetSentences)
  })
_sym_db.RegisterMessage(DatasetSentences)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)
