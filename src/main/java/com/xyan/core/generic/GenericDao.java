package com.xyan.core.generic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.xyan.api.core.BaseModel;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * 可以通过Mybatis Generator Maven 插件自动生成Dao,
 * 也可以手动编码,然后继承GenericDao 即可.
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author StarZou
 * @since 2014年6月9日 下午6:14:06
 */
public interface GenericDao<Model extends BaseModel, PK> {

    /**
     * 插入单个对象
     * @param model 对象
     */
    int insert(Model model);
    
    /**
     * 更新单个对象
     * @param model 对象
     */
    int update(Model model);

    /**
     * 通过主键, 删除对象
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);
    
    /**
     * 根据例子查询对象
     * @param example 例子对象
     * @return
     */
    List<Model> selectByExample(Map<String,Object> example);
    
    /**
     * 
     * @param example
     * @return 条数
     */
    int countByExample(Map<String,Object> example);
    /**
     * 根据例子查询对象
     * @param example 例子对象
     * @return
     */
    List<Model> selectByExample(Map<String,Object> example,RowBounds bounds);
}
