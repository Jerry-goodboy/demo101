package com.github.binarywang.demo.wx.cp.controller.xml;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.entity.TestXmlDataEntity;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/portal/{agentId}")
public class TestXmlDataController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private TestXmlDataEntity testXmlDataEntity;

  @PostMapping(value = "/test_xml_data",produces = "application/xml; charset=UTF-8")
  public TestXmlDataEntity sendMsg(@PathVariable Integer agentId,
                     @RequestBody String requestBody) {


    return testXmlDataEntity;
  }



}
