package com.mashibing.springboot.controller.rest;

import com.mashibing.springboot.entity.Permission;
import com.mashibing.springboot.entity.RespStat;
import com.mashibing.springboot.service.IPermissionService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful风格URI的controller
 * 只和用户交换JSON数据
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/api/v1/manager/permission",method = RequestMethod.GET)
public class PermissionManagerRestController {
	
	@Reference(version = "1.0.0")
	IPermissionService permissionSrv;
	
	/**
	 * 更新
	 * @param permission
	 * @return
	 */
	@RequestMapping("add")
	public RespStat add(@RequestBody Permission permission) {
		
		System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
	
		
		if(permission.getId() == null ) {
			
			permissionSrv.add(permission);
			
			
		}else {
			permissionSrv.update(permission);
		}
		
		
		return RespStat.build(200);
	}
	@RequestMapping("update")
	public RespStat update(@RequestBody Permission permission) {
		
		System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
		permissionSrv.update(permission);
		return RespStat.build(200);
	}
	
	
}
