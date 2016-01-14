package com.xyan.core.generic;

import java.util.List;
import java.util.Map;

import com.xyan.api.core.BaseModel;
import com.xyan.core.feature.orm.mybatis.Page;

/**
 * 所有自定义Service的顶级接口,封装常用的增删查改操作
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 * @author 王明
 * @since 2015年11月12日
 */
public interface GenericService<Model extends BaseModel, PK> {

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
    int delete(PK id);

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return model 对象
     */
    Model selectByPrimaryKey(PK id);

    /**
     * 查询多个对象
     * @return 对象集合
     */
    List<Model> selectByExample(Map<String,Object> Example);
    
    int countByExample(Map<String,Object> Example);
    /**
     * 带分页的查询多个对象
     * @return 对象集合
     */
    List<Model> selectByExample(Map<String,Object> Example,Page<Model> page);
    
    

}
