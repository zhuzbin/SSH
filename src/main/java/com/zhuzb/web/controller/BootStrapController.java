package com.zhuzb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by admin on 2018/6/5.
 */
@Controller
@RequestMapping("/bootStrap")
public class BootStrapController {

    @RequestMapping(method = RequestMethod.GET,value = "/treeView")
    public ModelAndView view(){
        return new ModelAndView("bootStrap/treeView");
    }
}
