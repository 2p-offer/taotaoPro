package com.taotao.service;

import com.taotao.common.pojo.EUGridResult;
import com.taotao.pojo.TbItem;

/**
 * Created by 2P on 2018/3/23.
 */
public interface ItemService {

    TbItem getItemById(long itemId);

    EUGridResult getItemList(int page,int rows);
}
