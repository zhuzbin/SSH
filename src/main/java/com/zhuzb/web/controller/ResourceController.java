package com.zhuzb.web.controller;

import com.zhuzb.entity.Country;
import com.zhuzb.entity.Resource;
import com.zhuzb.service.ResourceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ModelAttribute("types")
    public Resource.ResourceType[] resourceTypes() {
        return Resource.ResourceType.values();
    }

    @RequiresPermissions("resource:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        //model.addAttribute("resourceList", resourceService.findAll());
        return "resource/resourceList";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        Resource parent = resourceService.findOne(parentId);
        model.addAttribute("parent", parent);
        Resource child = new Resource();
        child.setParentId(parentId.toString());
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("resource", child);
        model.addAttribute("op", "新增子节点");
        return "resource/edit";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    public String create(Resource resource, RedirectAttributes redirectAttributes) {
        resource.setAvailable("1");
        resourceService.createResource(resource);
        redirectAttributes.addFlashAttribute("msg", "新增子节点成功");
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("resource", resourceService.findOne(id));
        model.addAttribute("op", "修改");
        return "resource/edit";
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(Resource resource, RedirectAttributes redirectAttributes) {
        resourceService.updateResource(resource);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/resource";
    }

    @RequiresPermissions("resource:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        resourceService.deleteResource(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/resource";
    }

    @RequestMapping("/resourceList")
    @ResponseBody
    public List<Resource> resourceList(HttpServletRequest request, Country country){
        List<Resource> a = resourceService.findAll();
        return a;
    }
}
