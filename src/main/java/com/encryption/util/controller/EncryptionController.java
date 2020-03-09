package com.encryption.util.controller;

import com.encryption.util.model.RequestPayload;
import com.encryption.util.model.ResponsePayload;
import com.encryption.util.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EncryptionController {

  private EncryptionService encryptionService;

  @Autowired
  public EncryptionController(EncryptionService encryptionService) {
    this.encryptionService = encryptionService;
  }

  @RequestMapping(value = {"/"})
  public ModelAndView index() {
    return new ModelAndView("index");
  }

  @PostMapping("/encrypt/")
  ModelAndView encryptPlainTextWithKey(RequestPayload requestPayload) {
    ModelAndView model = new ModelAndView("index");
    ResponsePayload responsePayload = encryptionService.encryptPlainText(requestPayload);
    model.addObject("result", responsePayload);
    return model;
  }

  @PostMapping("/decrypt/")
  ModelAndView decryptWithKey(RequestPayload requestPayload) {
    ModelAndView model = new ModelAndView("index");
    ResponsePayload responsePayload = encryptionService.decryptEncryptedText(requestPayload);
    model.addObject("result", responsePayload);
    return model;
  }
}
