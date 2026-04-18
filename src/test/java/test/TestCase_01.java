package test;

import org.testng.annotations.Test;

import base.BaseClass;
import page.Search_product;

public class TestCase_01 extends BaseClass {
	@Test
	public void searchTest() {
        Search_product sp = new Search_product(driver);		
        sp.inputfield("laptop");
        sp.clicksearch();
        sp.selectLaptop("ASUS ROG");
        sp.validateProductPage();


	}

}
