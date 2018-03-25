package com.taotao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2P on 2018/3/23.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        TbItemExample example=new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> tbItemlist = itemMapper.selectByExample(example);
        if(tbItemlist!=null&&tbItemlist.size()>0){
            return tbItemlist.get(0);
        }
        return null;
    }

    @Override
    public EUGridResult getItemList(int page, int rows) {
        TbItemExample example=new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> itemList = itemMapper.selectByExample(example);
        EUGridResult euGridResult=new EUGridResult();
        euGridResult.setRows(itemList);
        PageInfo<TbItem> pageInfo=new PageInfo<>(itemList);

        euGridResult.setTotal(pageInfo.getTotal());
        return euGridResult;
    }
}
