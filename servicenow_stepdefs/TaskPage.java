package servicenow_stepdefs;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;


public class TaskPage extends BaseSteps{
	@And("click Request link")
	public RequestPage clickOnRequest() {
		driver.findElement(By.xpath("//a[@href='wizard_view.do?sys_action=sysverb_wizard_ans&WIZARD:action=follow&wiz_referring_url=task_list.do?sys_id=-1@99@sys_target=task@99@sysparm_fixed_query=@99@sysparm_group_sort=@99@sysparm_parent=e56db0c76d2220100acb70b3534330b7@99@sysparm_query=active%3dtrue%5eassigned_to%3djavascript%3agetMyAssignments()%5estate!%3d-5@99@sysparm_target=@99@sysparm_view=&wiz_collection_key=&wiz_collectionID=&wiz_collection=&wiz_collection_related_field=&wiz_view=&wiz_action=sysverb_new&sys_id=ec31854f6d2620100acb70b353433090&sysparm_query=active=true^assigned_to=javascript:getMyAssignments()^state!=-5&sysparm_target=&sys_target=task']")).click();
		return new RequestPage();
	}
	
	@And("click chat queue entry link")
	public void clickOnChatQueueEntry() {
		driver.findElement(By.xpath("//a[@href='wizard_view.do?sys_action=sysverb_wizard_ans&WIZARD:action=follow&wiz_referring_url=task_list.do?sys_id=-1@99@sys_target=task@99@sysparm_fixed_query=@99@sysparm_group_sort=@99@sysparm_parent=e56db0c76d2220100acb70b3534330b7@99@sysparm_query=active%3dtrue%5eassigned_to%3djavascript%3agetMyAssignments()%5estate!%3d-5@99@sysparm_target=@99@sysparm_view=&wiz_collection_key=&wiz_collectionID=&wiz_collection=&wiz_collection_related_field=&wiz_view=&wiz_action=sysverb_new&sys_id=4f7db4c76d2220100acb70b353433083&sysparm_query=active=true^assigned_to=javascript:getMyAssignments()^state!=-5&sysparm_target=&sys_target=task']")).click();
	}
	
}
