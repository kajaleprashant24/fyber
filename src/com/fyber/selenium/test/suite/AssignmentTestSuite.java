package com.fyber.selenium.test.suite;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fyber.selenium.test.base.HomePage;

public class AssignmentTestSuite extends HomePage {

	public Map<sortOptions, String> mapUrl=new HashMap<>();

	/**
	 * 1.Launch test app page(). 
	 * 2. Assert Page Title. 
	 * 3. Assert List of movies is greater then 1.
	 * 
	 */
	@Test()
	public void testTopListCount() {

		HomePage.getApp();

		Assert.assertEquals(driver.getTitle(), "IMDb Top 250 - IMDb");
		Assert.assertTrue(getListedMoviesCount() > 1, "Returned movies count is greater then 1");

	}

	/**
	 * 1.Test sorting by for all available options option
	 * 2. Select the sort option from drop down
	 * 3. Assert the url changes when sort option is changed.
	 * 4.Assert list contains moe then 1 item in returned list
	 */
	@Test()
	public void testSortingOptions() {

		HomePage.getApp();
	
		// map sort urls with sort options
		mapUrl.put(sortOptions.IMDb_Rating, "sort=ir");
		mapUrl.put(sortOptions.Number_of_Ratings, "sort=nv");
		mapUrl.put(sortOptions.Ranking, "sort=rk");
		mapUrl.put(sortOptions.Release_Date, "sort=us");
		mapUrl.put(sortOptions.Your_Rating, "sort=ur");

		for (sortOptions s : sortOptions.values()) {
			System.out.println(s.name());

			// Sort List
			sort(s);
	
			// Assert change in url after sortBy is changed
			String url = driver.getCurrentUrl();
			System.out.println(driver.getCurrentUrl());
			System.out.println(mapUrl.get(s));
			System.out.println("");
			Assert.assertTrue(driver.getCurrentUrl().contains(mapUrl.get(s)), "Url contains mapped url");
			Assert.assertTrue(getListedMoviesCount() > 1, "Returned movies count is greater then 1");
		}

	}

	
	/**
	 * 1. Get app.
	 * 2. List movies by genere
	 * 3.Assert returned list has more the 1 items.
	 */
	@Test
	public void testGenere() {
		HomePage.getApp();
		getMoviesByGenere(genere.Western);
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("genres=western"), "Url contains selected genere");
		Assert.assertTrue(getListedMoviesCountByGenere() > 1, "Returned movies count is greater then 1");

	}
}
