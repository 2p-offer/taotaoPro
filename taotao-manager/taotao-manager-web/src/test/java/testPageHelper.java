import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 2P on 2018/3/24.
 */
public class testPageHelper {
    @Test
    public void testPageHelper(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        PageHelper.startPage(1,15);
        TbItemExample example=new TbItemExample();
        List<TbItem> tbItemList = itemMapper.selectByExample(example);

        for(TbItem item : tbItemList){
            System.out.println(item.getTitle());
        }
        PageInfo pageInfo=new PageInfo(tbItemList);
        long total = pageInfo.getTotal();
        System.out.println("总共有商品+"+total);


    }
}
