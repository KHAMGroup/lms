
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object employee extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Employee,Form[Employee],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(employee: Employee, employeeForm: Form[Employee]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("Employee")/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""
    <h1>"""),_display_(Seq[Any](/*5.10*/employee/*5.18*/.getFirst())),format.raw/*5.29*/(""" """),_display_(Seq[Any](/*5.31*/employee/*5.39*/.getLast())),format.raw/*5.49*/("""</h1>

    """),_display_(Seq[Any](/*7.6*/form(routes.EmployeeApp.update(employee.getEmployeeNumber()))/*7.67*/ {_display_(Seq[Any](format.raw/*7.69*/("""      
        <fieldset>
        	<div>Employee Number: """),_display_(Seq[Any](/*9.33*/employee/*9.41*/.getEmployeeNumber())),format.raw/*9.61*/("""</div>
            """),_display_(Seq[Any](/*10.14*/inputText(employeeForm("first"), '_label -> "First Name"))),format.raw/*10.71*/("""
            """),_display_(Seq[Any](/*11.14*/inputText(employeeForm("last"), '_label -> "Last Name"))),format.raw/*11.69*/("""
            """),_display_(Seq[Any](/*12.14*/inputText(employeeForm("username"), '_label -> "User name"))),format.raw/*12.73*/("""
        </fieldset>

        <div>
            <input type="submit" value="Update" />
        </div>
        
    """)))})),format.raw/*19.6*/("""
	
	"""),_display_(Seq[Any](/*21.3*/form(routes.EmployeeApp.delete(employee.getEmployeeNumber()))/*21.64*/{_display_(Seq[Any](format.raw/*21.65*/("""
		<div>
			<input type="submit" value="Delete" />
		</div>
	""")))})),format.raw/*25.3*/("""
""")))})),format.raw/*26.2*/("""
"""))}
    }
    
    def render(employee:Employee,employeeForm:Form[Employee]): play.api.templates.Html = apply(employee,employeeForm)
    
    def f:((Employee,Form[Employee]) => play.api.templates.Html) = (employee,employeeForm) => apply(employee,employeeForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Sep 14 15:47:58 PDT 2013
                    SOURCE: /Users/matthewreyes/programming/workspace01-indigo/lms/ddllab/app/views/employee.scala.html
                    HASH: 4142f9842382fc78b72e147785118b8753460fff
                    MATRIX: 743->1|886->51|913->69|949->71|973->87|1012->89|1057->99|1073->107|1105->118|1142->120|1158->128|1189->138|1235->150|1304->211|1343->213|1436->271|1452->279|1493->299|1549->319|1628->376|1678->390|1755->445|1805->459|1886->518|2033->634|2073->639|2143->700|2182->701|2275->763|2308->765
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|39->11|39->11|40->12|40->12|47->19|49->21|49->21|49->21|53->25|54->26
                    -- GENERATED --
                */
            