package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.utils.JsonUtils;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
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

      WxCpMessage message = WxCpMessage
          .TEXT()
          .agentId(agentId) // 企业号应用ID
          .toUser("@all") //非必填，UserID列表（消息接收者，多个接收者用‘|’分隔）。特殊情况：指定为@all，则向关注该企业应用的全部成员发送
          .toParty("") //非必填，PartyID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数
          .toTag("") //非必填，TagID列表，多个接受者用‘|’分隔。当touser为@all时忽略本参数
          .content(requestBody)
          .build();

      try {
          // 设置消息的内容等信息
          wxCpService.messageSend(message);
      }catch (Exception e) {
          e.printStackTrace();
      }

    return "success";
  }



}
