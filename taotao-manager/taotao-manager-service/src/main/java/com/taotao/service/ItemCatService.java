package com.taotao.service;

import com.taotao.common.pojo.TreeNode;

import java.util.List;

/**
 * Created by 2P on 2018/3/25.
 */
public interface ItemCatService {
    List<TreeNode> getItemCatList(long parentId);
}
