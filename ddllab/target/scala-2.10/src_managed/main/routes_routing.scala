// @SOURCE:/Users/matthewreyes/programming/workspace01-indigo/lms/ddllab/conf/routes
// @HASH:7f30a2f8806f63748bd1814b2a8648f4a6993868
// @DATE:Mon Sep 23 19:16:01 PDT 2013


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix  
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" } 


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_EmployeeApp_employees1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees"))))
        

// @LINE:9
private[this] lazy val controllers_EmployeeApp_employee2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:10
private[this] lazy val controllers_EmployeeApp_update3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees/"),DynamicPart("id", """[^/]+""",true),StaticPart("/update"))))
        

// @LINE:11
private[this] lazy val controllers_EmployeeApp_create4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees/new"))))
        

// @LINE:12
private[this] lazy val controllers_EmployeeApp_save5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees/save"))))
        

// @LINE:13
private[this] lazy val controllers_EmployeeApp_delete6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("employees/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
        

// @LINE:25
private[this] lazy val controllers_Assets_at7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees""","""controllers.EmployeeApp.employees()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees/$id<[^/]+>""","""controllers.EmployeeApp.employee(id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees/$id<[^/]+>/update""","""controllers.EmployeeApp.update(id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees/new""","""controllers.EmployeeApp.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees/save""","""controllers.EmployeeApp.save()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """employees/$id<[^/]+>/delete""","""controllers.EmployeeApp.delete(id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
       
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_EmployeeApp_employees1(params) => {
   call { 
        invokeHandler(controllers.EmployeeApp.employees(), HandlerDef(this, "controllers.EmployeeApp", "employees", Nil,"GET", """ Employees""", Routes.prefix + """employees"""))
   }
}
        

// @LINE:9
case controllers_EmployeeApp_employee2(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(controllers.EmployeeApp.employee(id), HandlerDef(this, "controllers.EmployeeApp", "employee", Seq(classOf[Int]),"GET", """""", Routes.prefix + """employees/$id<[^/]+>"""))
   }
}
        

// @LINE:10
case controllers_EmployeeApp_update3(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(controllers.EmployeeApp.update(id), HandlerDef(this, "controllers.EmployeeApp", "update", Seq(classOf[Int]),"POST", """""", Routes.prefix + """employees/$id<[^/]+>/update"""))
   }
}
        

// @LINE:11
case controllers_EmployeeApp_create4(params) => {
   call { 
        invokeHandler(controllers.EmployeeApp.create(), HandlerDef(this, "controllers.EmployeeApp", "create", Nil,"POST", """""", Routes.prefix + """employees/new"""))
   }
}
        

// @LINE:12
case controllers_EmployeeApp_save5(params) => {
   call { 
        invokeHandler(controllers.EmployeeApp.save(), HandlerDef(this, "controllers.EmployeeApp", "save", Nil,"POST", """""", Routes.prefix + """employees/save"""))
   }
}
        

// @LINE:13
case controllers_EmployeeApp_delete6(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        invokeHandler(controllers.EmployeeApp.delete(id), HandlerDef(this, "controllers.EmployeeApp", "delete", Seq(classOf[Int]),"POST", """""", Routes.prefix + """employees/$id<[^/]+>/delete"""))
   }
}
        

// @LINE:25
case controllers_Assets_at7(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}
    
}
        