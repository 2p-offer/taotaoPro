package com.taotao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
        //item补全
        //生成商品ID
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //不弄图片服务器了，瞎给一个
        item.setImage("http://image.taotao.com/jd/902958f543874a4caed08045c96dcf30.jpg");
        //插入到数据库
        itemMapper.insert(item);

        return TaotaoResult.ok();
    }
}
