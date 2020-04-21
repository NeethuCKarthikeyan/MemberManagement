package com.ust.ticl.management;

import java.util.HashMap;
import java.util.Map;

import com.ust.ticl.management.request.MemberInfo;

public class AppContext {
	
	private static String TENANT_ID = "TENANT_ID";
	
	private static String MEMBER_INFO = "MEMBER_INFO";

	private static final ThreadLocal<Map<String, Object>> CONTEXT = new ThreadLocal<>();

	public static void setTenantId(String tenantId) {
		Map<String, Object> contextMap = CONTEXT.get();
		if (contextMap == null) 
			contextMap = new HashMap<>();
		contextMap.put(TENANT_ID, tenantId);
		CONTEXT.set(contextMap);
	}

	public static String getTenantId() {
		Map<String, Object> contextMap = CONTEXT.get();
		return contextMap == null ? null : (String)contextMap.get(TENANT_ID);
	}
	
	public static void setMemberInfo(MemberInfo memberInfo) {
		Map<String, Object> contextMap = CONTEXT.get();
		if (contextMap == null) 
			contextMap = new HashMap<>();
		contextMap.put(MEMBER_INFO, memberInfo);
		CONTEXT.set(contextMap);
	}

	public static MemberInfo getMemberInfo() {
		Map<String, Object> contextMap = CONTEXT.get();
		return contextMap == null ? null : (MemberInfo)contextMap.get(MEMBER_INFO);
	}

	public static void clear() {
		CONTEXT.remove();
	}

}
