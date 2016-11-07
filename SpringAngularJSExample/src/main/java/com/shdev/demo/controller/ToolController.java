package com.shdev.demo.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tool")
public class ToolController {
    private static Logger logger = Logger.getLogger(ToolController.class);

    @RequestMapping
    public String getLayoutPage() {
        return "tool/layout";
    }

    @RequestMapping("/fcr")
    public String loadFcrPage(@RequestParam(value = "ywlsh", defaultValue = StringUtils.EMPTY) String ywlsh,
                              @RequestParam( defaultValue = StringUtils.EMPTY) String jylsh) {
        logger.info(ywlsh);
        logger.info(jylsh);
        return "tool/fcr";
    }

    @RequestMapping("/ics")
    public String loadIcsPage() {
        return "tool/ics";
    }
}
