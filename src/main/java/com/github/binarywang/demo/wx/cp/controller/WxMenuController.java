package com.github.binarywang.demo.wx.cp.controller;

import com.github.binarywang.demo.wx.cp.config.WxCpConfiguration;
import com.github.binarywang.demo.wx.cp.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpMenuService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.util.crypto.WxCpCryptUtil;
import me.chanjar.weixin.cp.util.json.WxCpMenuGsonAdapter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.google.gson.JsonElement;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wx/cp/portal/{agentId}")
public class WxMenuController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/menu_create", produces = "application/json; charset=UTF-8")
    public String menuCreate(@PathVariable Integer agentId,
                            @RequestBody String requestBody) {
        this.logger.info("\n接收应用服务器请求： requestBody=[\n{}\n] ", requestBody);

        final WxCpService wxCpService = WxCpConfiguration.getCpService(agentId);

        WxCpMenuService wxCpMenuService = wxCpService.getMenuService();

        try {
//            File file = new File(this.getClass().getResource("menu.json").getFile());
//            InputStream inputStream = new FileInputStream(file);
            this.logger.info("\n接收应用服务器请求： requestBody=[\n{}\n] ", requestBody);
//            wxCpMenuService.create(WxMenu.fromJson(inputStream));
            WxCpMenuGsonAdapter wxCpMenuGsonAdapter = new WxCpMenuGsonAdapter();

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(requestBody);

            wxCpMenuService.create(wxCpMenuGsonAdapter.deserialize(jsonElement,null, null));
            return "正在创建";
        } catch (Exception e) {
            e.printStackTrace();
            return "创建失败";
        }

    }

}
