package com.encryption.util.model;

public class RequestPayload {

  String encryptionKey;
  String plainText;

  public RequestPayload(String encryptionKey, String plainText) {
    this.encryptionKey = encryptionKey;
    this.plainText = plainText;
  }

  public String getEncryptionKey() {
    return encryptionKey;
  }

  public void setEncryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
  }

  public String getPlainText() {
    return plainText;
  }

  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }

  @Override
  public String toString() {
    return "EncRequest{" +
      "encryptionKey='" + encryptionKey + '\'' +
      ", plainText='" + plainText + '\'' +
      '}';
  }
}
