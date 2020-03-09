package com.encryption.util.service;

import java.util.Iterator;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CustomStringEncryptor {

  public JSONObject cookJsonWithSugarSalt(JSONObject plainJson, String key) {
    StringEncryptor encryptor = createCustomEncryptor(key);
    JSONObject cookedProperties = new JSONObject();
    if (null == plainJson) {
      return cookedProperties;
    }
    Iterator keys = plainJson.keys();
    try {
      while (keys.hasNext()) {
        String field = keys.next().toString();
        String value = plainJson.getString(field);
        String cookItem = encryptor.encrypt(value);
        cookedProperties.put(field, cookItem);
      }
    } catch (JSONException ex) {
      System.out.println("Failed to cook properties - Check your sugar salt" + ex.getMessage());
    }
    return cookedProperties;
  }

  public JSONObject unCookJsonWithSugarSalt(JSONObject encryptedJson, String key) {
    StringEncryptor encryptor = createCustomEncryptor(key);

    JSONObject uncookedJson = new JSONObject();
    if (null == encryptedJson) {
      return uncookedJson;
    }
    Iterator keys = encryptedJson.keys();
    try {
      while (keys.hasNext()) {
        String field = keys.next().toString();
        String value = encryptedJson.getString(field);
        String unCookItem = encryptor.decrypt(value);
        uncookedJson.put(field, unCookItem);
      }
    } catch (JSONException ex) {
      System.out.println("Failed to uncook properties - Check your sugar salt" + ex.getMessage());
    }
    return uncookedJson;
  }

  public String encryptPlainString(String plainString, String key) {
    StringEncryptor encryptor = createCustomEncryptor(key);
    return encryptor.encrypt(plainString);
  }

  public String decryptEncryptedString(String encString, String key) {
    StringEncryptor encryptor = createCustomEncryptor(key);
    return encryptor.decrypt(encString);
  }

  public StringEncryptor createCustomEncryptor(String key) {
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword(key);
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName("SunJCE");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");
    encryptor.setConfig(config);
    return encryptor;
  }
}
