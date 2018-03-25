package com.taotao.controller;


import com.taotao.common.pojo.EUGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 2P on 2018/3/23.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long itemId){
        TbItem itemById = itemService.getItemById(itemId);
        return itemById;

    }
    @RequestMapping("item/list")
    @ResponseBody
    public EUGridResult getItemList(int page,int rows){
        EUGridResult itemList = itemService.getItemList(page, rows);
        return  itemList;

    }

}
