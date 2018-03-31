package com.taotao.service;

import com.taotao.common.pojo.EUGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by 2P on 2018/3/23.
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EUGridResult getItemList(int page,int rows);

    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
