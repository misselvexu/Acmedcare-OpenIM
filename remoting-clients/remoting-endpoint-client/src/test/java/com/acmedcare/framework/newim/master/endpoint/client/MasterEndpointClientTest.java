package com.acmedcare.framework.newim.master.endpoint.client;

import com.acmedcare.framework.newim.client.MessageBizType;
import com.acmedcare.framework.newim.client.MessageContentType;
import com.acmedcare.framework.newim.client.bean.Member;
import com.acmedcare.framework.newim.client.bean.request.AddGroupMembersRequest;
import com.acmedcare.framework.newim.client.bean.request.NewGroupRequest;
import com.acmedcare.framework.newim.client.bean.request.RemoveGroupMembersRequest;
import com.acmedcare.framework.newim.client.bean.request.UpdateGroupRequest;
import com.acmedcare.framework.newim.client.bean.response.GroupResponse;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * com.acmedcare.framework.newim.master.endpoint.client
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 29/11/2018.
 */
public class MasterEndpointClientTest {

  private MasterEndpointClient masterEndpointClient;

  @Before
  public void init() {
    this.masterEndpointClient =
        new MasterEndpointClient(Lists.newArrayList("39.100.125.0:13110"), false);
  }

  @Test
  public void testCreateNewGroup() {

    NewGroupRequest request = new NewGroupRequest();
    request.setGroupId("EXPERT351707096506624");
    request.setGroupName("微急救群");
    request.setGroupBizTag("");
    request.setGroupExt("");
    request.setGroupOwner("misselvexu");
    this.masterEndpointClient.createNewGroup(request);
  }

  @Test
  public void queryGroupMemberList() {

    List<Member> members = this.masterEndpointClient.queryGroupMemberList("EXPERT351707096506624","DEFAULT");
    System.out.println(JSON.toJSONString(members));
    Assert.assertNotNull(members);

  }

  @Test
  public void testJoinGroup() {

    AddGroupMembersRequest request = new AddGroupMembersRequest();
    request.setGroupId("EXPERT359817676148994");
    request.setMembers(
        Lists.newArrayList(
            Member.builder().memberId(1405282155989248L).memberName("wyjdd").memberUserName("wyjdd").build()));
    masterEndpointClient.joinGroup(request);
  }

  @Test
  public void testRemoveGroupMember() {
    RemoveGroupMembersRequest request = new RemoveGroupMembersRequest();
    request.setGroupId("gid-20181123-1");
    request.setMemberIds(Lists.newArrayList("3837142362366976"));
    masterEndpointClient.removeGroupMembers(request);
  }

  @Test
  public void testUpdateGroup() {

    UpdateGroupRequest request = new UpdateGroupRequest();
    request.setGroupId("gid-20181123-1");
    request.setGroupName("xxwssxxxxxxxxxxxx");
    request.setGroupBizTag("tagss2222");
    request.setGroupExt("~~");
    request.setGroupOwner("misselvexu");
    GroupResponse groupResponse = this.masterEndpointClient.updateGroup(request);
    Assert.assertNotNull(groupResponse);
    Assert.assertEquals("gid-20181123-1", groupResponse.getGroupId());
    Assert.assertEquals("xxwss", groupResponse.getGroupName());
  }

  @Test
  public void testSendSingleMessage() {

    this.masterEndpointClient.sendSingleMessage(
        MessageBizType.NORMAL,
        "JUNIT-TEST",
        "3837142362366976",
        "{\"name\":\"misselvexu\"}",
        MessageContentType.APPLICATION_JSON,
        null);
  }

  @Test
  public void testBatchSendSingleMessage() {

    this.masterEndpointClient.batchSendSingleMessages(
        MessageBizType.NORMAL,
        "JUNIT-TEST",
        Lists.newArrayList("3837142362366976", "3837142362366977"),
        "{\"name\":\"misselvexu\"}",
        MessageContentType.APPLICATION_JSON,
        null);
  }

  @Test
  public void testSendGroupMessage() {

    this.masterEndpointClient.sendGroupMessage(
        MessageBizType.NORMAL,
        "JUNIT-TEST",
        "EXPERT359817676148994",
        "{\"name\":\"misselvexu\"}",
        MessageContentType.APPLICATION_JSON,
        null);
  }
}
