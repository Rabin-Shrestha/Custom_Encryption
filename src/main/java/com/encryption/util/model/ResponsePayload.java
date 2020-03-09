package com.encryption.util.model;

public class ResponsePayload {

  String key;
  String outputString;

  public ResponsePayload(String key, String outputString) {
    this.key = key;
    this.outputString = outputString;
  }

  @Override
  public String toString() {
    return "EncResponse{" +
      "key='" + key + '\'' +
      ", ennryptedString='" + outputString + '\'' +
      '}';
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getOutputString() {
    return outputString;
  }

  public void setOutputString(String outputString) {
    this.outputString = outputString;
  }
}
