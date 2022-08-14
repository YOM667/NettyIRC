package me.youm.dao;

import me.youm.api.ServerBuilder;
import me.youm.api.SetMapper;

/**
 * @author : You_M
 * @date : 2022/8/7 13:44 05
 * @projectName : KES-IRC-Server
 * @className : UserServicesMapper
 */
public interface UserServicesMapper {
    SetMapper setMapper = ServerBuilder.build().getSetMapper();

}
