package models.helpers;
import models.*;

public class TestHelper {

	public static TestPOJO entityToPojo(TestEntityObject from){
		TestPOJO to = new TestPOJO();
		to.setTestNumber(from.getTestNumber());
		to.setTestName(from.getTestName());
		to.setTestType(from.getTestType());
		to.setTypeOfSample(from.getTypeOfSample());
		to.setUnits(from.getUnits());
		to.setRespicture(from.getRespicture());
		to.setControlResultLine(from.getControlResultLine());
		to.setControlText(from.getControlText());
		Comment defaultComment = from.getDefaultComment();
		if(defaultComment != null){
			to.setDefaultComment(defaultComment.getCommentText());
		}else{
			to.setDefaultComment("");
		}
		return to;
	}
	
	public static TestEntityObject pojoToEntity(TestPOJO from){
		TestEntityObject to = new TestEntityObject();
		to.setTestNumber(from.getTestNumber());
		to.setTestName(from.getTestName());
		to.setTestType(from.getTestType());
		to.setTypeOfSample(from.getTypeOfSample());
		to.setUnits(from.getUnits());
		to.setRespicture(from.getRespicture());
		to.setControlResultLine(from.getControlResultLine());
		to.setControlText(from.getControlText());
		String defaultComment = from.getDefaultComment();
		if(!(defaultComment.equals(""))){
			Comment defComment = new Comment();
			defComment.setCommentText(defaultComment);
			to.setDefaultComment(defComment);
		}
		return to;
	}

	public static void savePojo(TestPOJO toSave) {
		TestEntityObject save = pojoToEntity(toSave);
		save.save();
	}

	public static TestPOJO findByTestNumber(int id) {
		return entityToPojo(TestEntityObject.findByTestNumber(id));
	}

	public static void update(int id, TestPOJO testPOJO) {
		TestEntityObject toUpdate = pojoToEntity(testPOJO);
		toUpdate.update(id);
	}
}
