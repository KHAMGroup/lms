
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
object createEmployee extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Employee,Form[Employee],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(employee: Employee, employeeForm: Form[Employee]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("Employee")/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""
    <h1>New Employee</h1>

    """),_display_(Seq[Any](/*7.6*/form(routes.EmployeeApp.save())/*7.37*/ {_display_(Seq[Any](format.raw/*7.39*/("""      
        <fieldset>
            """),_display_(Seq[Any](/*9.14*/inputText(employeeForm("first"), '_label -> "First Name"))),format.raw/*9.71*/("""
            """),_display_(Seq[Any](/*10.14*/inputText(employeeForm("last"), '_label -> "Last Name"))),format.raw/*10.69*/("""
            """),_display_(Seq[Any](/*11.14*/inputText(employeeForm("username"), '_label -> "User Name"))),format.raw/*11.73*/("""
            """),_display_(Seq[Any](/*12.14*/inputText(employeeForm("password"), '_label -> "Password"))),format.raw/*12.72*/("""
        </fieldset>

        <div>
            <input type="submit" value="Save" />
        </div>
        
    """)))})),format.raw/*19.6*/("""
	
""")))})),format.raw/*21.2*/("""
"""))}
    }
    
    def render(employee:Employee,employeeForm:Form[Employee]): play.api.templates.Html = apply(employee,employeeForm)
    
    def f:((Employee,Form[Employee]) => play.api.templates.Html) = (employee,employeeForm) => apply(employee,employeeForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Sep 14 15:47:58 PDT 2013
                    SOURCE: /Users/matthewreyes/programming/workspace01-indigo/lms/ddllab/app/views/createEmployee.scala.html
                    HASH: 51497b494234e35ae7a0b315460f54fd78cc4d47
                    MATRIX: 749->1|892->51|919->69|955->71|979->87|1018->89|1085->122|1124->153|1163->155|1237->194|1315->251|1365->265|1442->320|1492->334|1573->393|1623->407|1703->465|1848->579|1883->583
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|35->7|35->7|35->7|37->9|37->9|38->10|38->10|39->11|39->11|40->12|40->12|47->19|49->21
                    -- GENERATED --
                */
            