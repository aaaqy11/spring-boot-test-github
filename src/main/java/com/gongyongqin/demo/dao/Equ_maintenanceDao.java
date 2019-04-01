package com.gongyongqin.demo.dao;

import java.util.List;
import java.util.Map;

public interface Equ_maintenanceDao {
    /**
     * 员工列表查询
     */
    //@Select("select * from Equ_maintenance")
    List<Map> getEquList();

    /**
     * 车辆添加
     */
    //@Insert(value = "insert into equ_maintenance values (null,#{equ_id},#{equ_name},#{main_infor},#{main_user},date_format(#{main_time},'%Y-%m-%d'),#{fstatue},#{reason})")
    int addEqu(Map map);

    /**
     * 通过条件获取员工列表
     */
    //@Select(value = "select * from equ_maintenance where equ_id=#{equ_id}")
    List<Map> getEquListBy(Map map);

    /**
     * 更改
     * @param map
     * @return
     */
    //@Insert("update equ_maintenance set equ_id=#{equ_id},equ_name=#{equ_name},main_infor=#{main_infor},main_user=#{main_user},main_time=#{main_time},fstatue=#{fstatue},reason=#{reason} where id = #{id}")
    int updateEqu(Map map);

    /**
     * 删除
     * @param
     * @return
     */
    //@Delete("delete from equ_maintenance where id=#{id}")
    int deleteEqu(Integer ID);

    /**
     * 批量删除
     * @param IDs
     * @return
     */
    int equDel(List IDs);
}
