package com.xyan.core.generic;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;

import com.xyan.api.core.BaseModel;
import com.xyan.core.feature.orm.mybatis.Page;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作,
 * 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author StarZou
 * @since 2014年6月9日 下午6:14:06
 */
public abstract class GenericServiceImpl<Model extends BaseModel, PK> implements GenericService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return GenericDao实现类
     */
    public abstract GenericDao<Model, PK> getDao();

    /**
     * 插入单个对象
     * @param model 对象
     */
    public int insert(Model model) {
    	if(StringUtils.isBlank(model.getId())){
    		model.setId(UUID.randomUUID().toString());
    	}
        return getDao().insert(model);
    }

    /**
     * 更新单个对象
     * @param model 对象
     */
    public int update(Model model) {
        return getDao().update(model);
    }

    /**
     * 通过主键, 删除对象
     * @param id 主键
     */
    public int delete(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return
     */
    public Model selectByPrimaryKey(PK id) {
        return getDao().selectByPrimaryKey(id);
    }
    
    public List<Model> selectByExample(Map<String,Object> Example){
    	return getDao().selectByExample(Example);
    }
    
    public int countByExample(Map<String,Object> example){
    	return getDao().countByExample(example);
    }
    
    public List<Model> selectByExample(Map<String,Object> example,Page<Model> page){
    	if(page==null){
    		page=new Page<Model>(1, 10);
    	}
    	RowBounds rowBounds = new RowBounds(page.getOffset(),page.getPageSize());
    	List<Model> list=getDao().selectByExample(example,rowBounds);
    	page.setTotalCount(countByExample(example));
    	return list;
    }
}
