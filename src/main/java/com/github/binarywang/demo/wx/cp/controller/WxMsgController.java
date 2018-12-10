package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.utils.JsonUtils;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/portal/{agentId}")
public class WxMsgController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @PostMapping(value = "/send_msg",produces = "application/xml; charset=UTF-8")
  public String sendMsg(@PathVariable Integer agentId,
                     @RequestBody String requestBody) {

    final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);


    return out;
  }



}
