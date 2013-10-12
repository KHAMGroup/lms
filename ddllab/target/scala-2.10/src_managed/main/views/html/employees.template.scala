
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
object employees extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Employee],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(employees: List[Employee]):play.api.templates.Html = {
        _display_ {import helper._


Seq[Any](format.raw/*1.29*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/main("Employees List")/*4.24*/ {_display_(Seq[Any](format.raw/*4.26*/("""
    <h1>"""),_display_(Seq[Any](/*5.10*/employees/*5.19*/.size())),format.raw/*5.26*/(""" employees</h1>
    
    <table>
	    """),_display_(Seq[Any](/*8.7*/for(employee <- employees) yield /*8.33*/{_display_(Seq[Any](format.raw/*8.34*/("""
	    	<tr>
	    		<td><a href=""""),_display_(Seq[Any](/*10.22*/routes/*10.28*/.EmployeeApp.employee(employee.getEmployeeNumber))),format.raw/*10.77*/("""">"""),_display_(Seq[Any](/*10.80*/employee/*10.88*/.getEmployeeNumber())),format.raw/*10.108*/("""</a></td>
	    		<td>"""),_display_(Seq[Any](/*11.13*/employee/*11.21*/.getFirst())),format.raw/*11.32*/("""</td>
	    		<td>"""),_display_(Seq[Any](/*12.13*/employee/*12.21*/.getLast())),format.raw/*12.31*/("""</td>
	    		<td>"""),_display_(Seq[Any](/*13.13*/employee/*13.21*/.getUsername())),format.raw/*13.35*/("""</td>
	    	</tr>
	    """)))})),format.raw/*15.7*/("""
    </table>
    
    """),_display_(Seq[Any](/*18.6*/form(routes.EmployeeApp.create())/*18.39*/ {_display_(Seq[Any](format.raw/*18.41*/("""
        <input type="submit" value="Create">
    """)))})),format.raw/*20.6*/("""
""")))})),format.raw/*21.2*/("""
"""))}
    }
    
    def render(employees:List[Employee]): play.api.templates.Html = apply(employees)
    
    def f:((List[Employee]) => play.api.templates.Html) = (employees) => apply(employees)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Sep 14 15:47:58 PDT 2013
                    SOURCE: /Users/matthewreyes/programming/workspace01-indigo/lms/ddllab/app/views/employees.scala.html
                    HASH: ff3a8ff9c476ea50ca2d34247b6cda83bf24281f
                    MATRIX: 735->1|855->28|882->46|918->48|948->70|987->72|1032->82|1049->91|1077->98|1150->137|1191->163|1229->164|1298->197|1313->203|1384->252|1423->255|1440->263|1483->283|1541->305|1558->313|1591->324|1645->342|1662->350|1694->360|1748->378|1765->386|1801->400|1856->424|1915->448|1957->481|1997->483|2079->534|2112->536
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|33->5|33->5|33->5|36->8|36->8|36->8|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|43->15|46->18|46->18|46->18|48->20|49->21
                    -- GENERATED --
                */
            