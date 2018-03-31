package com.taotao.service.Impl;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2P on 2018/3/25.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(long parentId) {
        TbItemCatExample example=new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCatList = itemCatMapper.selectByExample(example);
        List<TreeNode> list = new ArrayList<>();
        for(TbItemCat tbItemCat : tbItemCatList)
        {
            TreeNode node= new TreeNode(tbItemCat.getId(),tbItemCat.getName(),tbItemCat.getIsParent()?"closed":"open");
            list.add(node);
        }


        return list;
    }
}
