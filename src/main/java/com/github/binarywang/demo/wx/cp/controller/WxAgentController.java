package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.utils.JsonUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpAgentService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpAgent;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/portal/{agentId}")
public class WxAgentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/agent_info" ,produces = "text/plain;charset=utf-8")
    public String agentInfo(@PathVariable Integer agentId) {
        this.logger.info("\n接收到来自应用服务器的请求：agentId = [{}]",agentId);

        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        if (wxCpService == null) {
            throw new IllegalArgumentException(String.format("未找到对应agentId=[%d]的配置，请核实！", agentId));
        }

        try {
            WxCpAgentService wxCpAgentService = wxCpService.getAgentService();
            WxCpAgent wxCpAgent = wxCpAgentService.get(agentId);
            return wxCpAgent.toJson();
        }catch (WxErrorException e) {
            e.printStackTrace();
        }

        return "请求出错";
    }

    @GetMapping(value = "/all_agent_info" ,produces = "text/plain;charset=utf-8")
    public String allAgentInfo(@PathVariable Integer agentId) {
        this.logger.info("\n接收到来自应用服务器的请求：agentId = [{}]",agentId);

        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);
        if (wxCpService == null) {
            throw new IllegalArgumentException(String.format("未找到对应agentId=[%d]的配置，请核实！", agentId));
        }

        try {
            WxCpAgentService wxCpAgentService = wxCpService.getAgentService();
            List<WxCpAgent> wxCpAgentList = wxCpAgentService.list();
            return JsonUtils.toJson(wxCpAgentList);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }

        return "请求出错";
    }

}
