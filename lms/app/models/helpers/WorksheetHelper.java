package models.helpers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import play.db.jpa.JPA;
import models.CaseTest;
import models.TestEntityObject;
import models.SelectTestPOJO;

public class WorksheetHelper {

	public static List<SelectTestPOJO> getTestsNeedingResults(){
		List<SelectTestPOJO> toReturn = new LinkedList<SelectTestPOJO>();
		String query = "select t.testNumber, t.testName, " +
				"t.typeOfSample, count(t.testNumber) " +
				"from TestEntityObject t " +
				"inner join t.caseTests as ct " +
				"with ct.resultsEntered = 0 " +
				"where t.testType = 'T' " +
				"group by t.testNumber " +
				"having count(t.testNumber) > 0 " +
				"order by t.testNumber ASC ";
	
		List<Object[]> resultList = JPA.em().createQuery(query).getResultList();
		for(Object[] obj : resultList){
			SelectTestPOJO test = new SelectTestPOJO();
			test.setTestNumber((int)obj[0]);
			test.setTestName((String)obj[1]);
			test.setTypeOfSample((String)obj[2]);
			test.setNumberOfCases((long)obj[3]);
			toReturn.add(test);
		}
		return toReturn;
	}
	
	
	public static SelectTestPOJO buildWorksheet(int testNumber) {
		SelectTestPOJO toReturn = new SelectTestPOJO();
		
		return toReturn;
	}


}
