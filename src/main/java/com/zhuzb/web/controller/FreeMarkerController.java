package com.zhuzb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/3/6
 * Time：14:48
 */
@Controller
@RequestMapping("/freemarker")
public class FreeMarkerController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView view(){
        return  new ModelAndView("freemarker/freemarker");
    }
}
