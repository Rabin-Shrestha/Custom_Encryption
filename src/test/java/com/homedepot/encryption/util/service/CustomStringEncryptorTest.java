package com.homedepot.encryption.util.service;

import com.encryption.util.service.CustomStringEncryptor;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class CustomStringEncryptorTest {

  @Test
  public void shouldEncryptWithKey() {
    CustomStringEncryptor customStringEncryptor = new CustomStringEncryptor();

    String configJson = "{\n"
      + "  \"storeNumber\": \"9184\",\n"
      + "  \"redemptionCode\":\"627706\",\n"
      + "  \"clientName\": \"AmeriGas\"\n"
      + "}";

    JSONObject properties = new JSONObject(configJson);
    String plainStringProperties = properties.toString().replaceAll("\\\\", "").trim();

    String key1 = "EnC4$%";
    String key2 = "R*N#7";
    String key3 = "B@D#3";
    String salt = key1 + key2 + key3;

    System.out.println("===================================================================");
    System.out.println("=================== Original Properties: ==========================\n");
    JSONObject originalConfigJson = new JSONObject(plainStringProperties);
    System.out.println(originalConfigJson);

    System.out.println("===================================================================");
    System.out.println("=================== Cooked Properties:: ==========================\n");
    JSONObject cookedProperties = customStringEncryptor
      .cookJsonWithSugarSalt(originalConfigJson, salt);
    System.out.println(cookedProperties);

    System.out.println("===================================================================");
    System.out.println("=================== UnCooked Properties:: ==========================\n");
    JSONObject uncooked = customStringEncryptor.unCookJsonWithSugarSalt(cookedProperties, salt);
    System.out.println(uncooked);
    Assert.assertEquals(originalConfigJson.toString(), uncooked.toString());
  }
}
