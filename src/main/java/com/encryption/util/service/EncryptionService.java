package com.encryption.util.service;

import com.encryption.util.model.RequestPayload;
import com.encryption.util.model.ResponsePayload;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

  final CustomStringEncryptor customStringEncryptor;

  public EncryptionService(CustomStringEncryptor customStringEncryptor) {
    this.customStringEncryptor = customStringEncryptor;
  }

  public ResponsePayload encryptPlainText(RequestPayload requestPayload) {
    String encryptedString = customStringEncryptor
      .encryptPlainString(requestPayload.getPlainText(), requestPayload.getEncryptionKey());
    return new ResponsePayload(requestPayload.getEncryptionKey(), encryptedString);
  }

  public ResponsePayload decryptEncryptedText(RequestPayload requestPayload) {
    String plainText = customStringEncryptor
      .decryptEncryptedString(requestPayload.getPlainText(), requestPayload.getEncryptionKey());
    return new ResponsePayload(requestPayload.getEncryptionKey(), plainText);
  }
}
