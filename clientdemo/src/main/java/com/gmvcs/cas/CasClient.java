package com.gmvcs.cas;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goldmsg.leusysm.base.casrpc.data.results.OrgRsp;
import com.goldmsg.leusysm.base.casrpc.data.results.StatisticOrgInfo;
import com.goldmsg.leusysm.base.casrpc.data.results.UserInfo;
import com.goldmsg.leusysm.base.casrpc.rpc.IOrgService;
import com.goldmsg.leusysm.base.casrpc.rpc.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Created by zhouhaiming on 2017-8-23 14:13
 * Email: dg_chow@163.com
 *
 * @Description:
 */
public class CasClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"cas.xml"});
        context.start();

        IOrgService iOrgService = (IOrgService) context.getBean("iOrgService");
//        OrgRsp orgRsp = iOrgService.getOrgInfoByOrgCode("1");
        String id ="1";
        List<StatisticOrgInfo> statisticOrgInfo1=iOrgService.getStatisticOrgInfo(id, "permanent",null, null, false, false);
        List<StatisticOrgInfo> statisticOrgInfo2=iOrgService.getStatisticOrgInfo(id, "temporary", null, null, false, false);
        List<StatisticOrgInfo> statisticOrgInfo3=iOrgService.getStatisticOrgInfo(id,"temporary",null,  new Date(), false, false);
        List<StatisticOrgInfo> statisticOrgInfo4=iOrgService.getStatisticOrgInfo(id, null, null, new Date(), false, false);
        List<StatisticOrgInfo> statisticOrgInfo5=iOrgService.getStatisticOrgInfo(id, "temporary",null,  null, false, false);
        List<StatisticOrgInfo> statisticOrgInfo6=iOrgService.getStatisticOrgInfo(id,null, null, null, false, false);
//        StatisticOrgInfo statisticOrgInfo=iOrgService.getStatisticOrgInfo(id, null, new Date(), false, false);
        System.out.println(JSON.toJSONString(statisticOrgInfo1));
        System.out.println(JSON.toJSONString(statisticOrgInfo2));
        System.out.println(JSON.toJSONString(statisticOrgInfo3));
        System.out.println(JSON.toJSONString(statisticOrgInfo4));
        System.out.println(JSON.toJSONString(statisticOrgInfo5));
        System.out.println(JSON.toJSONString(statisticOrgInfo6));
//        IUserService iUserService = (IUserService) context.getBean("iUserService");
//        UserInfo userInfoRsp =iUserService.findUserInfoByUid("GMU1100000020171103151800fe8fffffe");
//        userInfoRsp.setOrgId("1");
//        userInfoRsp.setEmail("6633@126.com");
//        UserInfo userInfo =iUserService.saveUserInfoRsp(userInfoRsp);


//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.findUserInfoByUid("123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getUserInfoByAccount("zhangsan");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getUserInfoByUserName("123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.checkUserPassword("123","123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.modUserPassword("123","123","123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getAllUserInfo();
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getUserInfosByOrgCode("123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getUserInfoByOrgCodeAndKeyword("123","123");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getUserInfosByRoleId("6");
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getAllUserRole();
//        invoke com.goldmsg.leusysm.base.casrpc.rpc.IUserService.getOrgUserTree();
//        List<String> stringList = new LinkedList<>();stringList.add("123");
//        SearchAssembler searchAssembler = new SearchAssembler("userName",SearchAssembler.Operator.NE,stringList );
//        Date date = new Date() ;
//        date.setTime(new Long("1503244800000"));

//        BasePagingResults<UserInfo> userInfoBasePagingResults2 = iUserService.getUsersBigerThanByAccount("123", 0, 20);

//        SearchAssembler searchAssembler = new SearchAssembler("uid",SearchAssembler.Operator.GT,"123" );
//        List<SearchAssembler> searchAssemblers = new LinkedList<>();
//        searchAssemblers.add(searchAssembler);
//        BasePagingResults<UserInfo> userInfoBasePagingResults = iUserService.getPageUserInfoByOrgId("123", 0, 20, searchAssemblers);


/*        SearchAssembler searchAssembler = new SearchAssembler("orgId",SearchAssembler.Operator.EQ,"123" );
        List<SearchAssembler> searchAssemblers = new LinkedList<>();
        searchAssemblers.add(searchAssembler);
        BasePagingResults<OrgRsp> orgRspBasePagingResults =iOrgService.getPageOrgRsp("123", 0, 20, searchAssemblers);
        System.out.println();*/





    }
}
