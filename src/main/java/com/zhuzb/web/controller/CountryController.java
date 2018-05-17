package com.zhuzb.web.controller;

import com.zhuzb.entity.Country;
import com.zhuzb.service.CountryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc：
 * User：ZhuZhiBin
 * Date：2018/3/2
 * Time：14:12
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequiresPermissions("country:view")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Model model){
        return new ModelAndView("country/countryList");
    }

    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(HttpServletRequest request,Country country){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Country> a = countryService.getCountryList(country);
        map.put("total", countryService.getAll().size());
        map.put("rows", a);
        return map;
    }

    @ResponseBody
    public List<Country> getAll(HttpServletRequest request){
        List<Country> a = countryService.getAll();
        return a;
    }

    @RequestMapping("/saveObj")
    @ResponseBody
    public String saveObj(HttpServletRequest request){
        Country country = new Country();
        country.setCountryCode("001");
        country.setCountryName("不知道");
        countryService.save(country);
        return "success";
    }

    @RequiresPermissions("country:view")
    @RequestMapping(value = "addView",method = RequestMethod.GET)
    public ModelAndView addView(Model model){
        return new ModelAndView("country/addCountry");
    }
}
