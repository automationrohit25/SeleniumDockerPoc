package com.qa.seachmodule.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.search.pages.SearchPage;
import com.qa.tests.BaseTest;

public class SearchTest extends BaseTest{
	
	
	@Test
	@Parameters({"keyword"})
	public void search(String keyword) throws InterruptedException{
		SearchPage searchpage = new SearchPage(driver);
		searchpage.goTo();
		searchpage.doSearch(keyword);
		searchpage.goToVideos();
		int size = searchpage.getResult();
		Thread.sleep(5000);
		Assert.assertTrue(size > 0);
		System.out.println("test case execution completed");
	}
	
	

}
