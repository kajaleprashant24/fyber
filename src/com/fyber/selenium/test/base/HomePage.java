package com.fyber.selenium.test.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.fyber.selenium.webdriver.base.AbstractTestBase;
import com.fyber.selenium.webdriver.base.WaitService;
import com.fyber.selenium.webdriver.base.WebDriverWrapper;

public class HomePage extends AbstractTestBase {

	public static String appUrl = "http://www.imdb.com/chart/top";
	private static By logo = By.id("home_img");
	private static By movielist = By.xpath("//tbody[@class='lister-list']/tr");
	private String genere_quicklinks = "//ul[@class='quicklinks ']//li//a[contains(text(),'%s')]";
	private static By sortOrder = By.className("lister-sort-by");
	private static By genereList = By.xpath("//div[@class='lister-list']//div[@class='lister-item-content']");

	public enum sortOptions {

		IMDb_Rating, Release_Date, Number_of_Ratings, Your_Rating,Ranking
	};

	public enum genere {
		Action, Adventure, Animation, Biography, Comedy, Crime, Drama, Family, Fantasy, Film_Noir, History, Horror, Music, Musical, Mystery, Romance, Sci_Fi, Sport, Thriller, War, Western
	};

	/**
	 * Get app (Launch app url)
	 */
	public static void getApp() {

		WebDriverWrapper.open(appUrl);
		Reporter.log("Index page launched");

		// Wait till home page logo is visible
		WaitService waitService = new WaitService();
		waitService.waitForElementVisible(driver.findElement(logo));

	};

	/**
	 * Get the count for listed movies
	 * 
	 * @return
	 */
	public int getListedMoviesCount() {

		List<WebElement> list = driver.findElements(movielist);
		return list.size();
	}

	/**
	 * Sort the list of movies by sortOptions
	 * 
	 * @param sortoptions
	 */
	public void sort(sortOptions sortoptions) {

		String sortBy = sortoptions.name().replaceAll("_", " ");
		WebElement el = driver.findElement(sortOrder);
		Select select = new Select(el);
		select.selectByVisibleText(sortBy);
	}

	/**
	 * Click on given genere quick link
	 * 
	 * @param genere
	 */
	public void getMoviesByGenere(genere genere) {
		String gen = genere.name();
		WebElement el = driver.findElement(By.xpath(String.format(genere_quicklinks, gen)));
		el.click();

	}

	/**
	 * Get the count for listed movies
	 * 
	 * @return
	 */
	public int getListedMoviesCountByGenere() {

		List<WebElement> list = driver.findElements(genereList);
		return list.size();
	}

}
